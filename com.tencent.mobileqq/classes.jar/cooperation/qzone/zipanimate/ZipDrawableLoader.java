package cooperation.qzone.zipanimate;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.SafeBitmapFactory;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader
{
  public static final String DEFAULT_BUSINESS = "zip_drawable";
  private static final int PRELOAD_FRAME_NUM = 1;
  public static final byte[] inTempStorage = new byte[24576];
  private CopyOnWriteArrayList<ZipDrawableLoader.AnimationFrame> mAnimationFrames = new CopyOnWriteArrayList();
  private Rect mBounds;
  private String mBusiness;
  private QzoneZipCacheHelperCallBack mCallback = new ZipDrawableLoader.2(this);
  private WeakReference<Context> mContext;
  private int mCurFrame = -1;
  private Drawable mCurrentDrawable;
  private long mCurrentTime;
  private int mDecodeFileHeight = -1;
  private int mDecodeFileWidth = -1;
  private String mDir;
  private ZipFrameLoadedListener mDrawableLoadedListener;
  boolean mFirstFrameLoaded = false;
  private volatile boolean mIsRunning;
  private ZipLoadedListener mListener;
  private boolean mPreLoadFrame;
  private int mPreloadNum = -1;
  private boolean mRecycleFlag = true;
  private Set<WeakReference<Bitmap>> mReusableBitmaps;
  private float mScale = 1.0F;
  private ZipFirstFrameLoadedListener mZipFirstFrameLoadedListener;
  private String mZipUrl;
  
  public ZipDrawableLoader(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
    }
  }
  
  @TargetApi(11)
  private void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = getBitmapFromReusableSet();
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  private void clearDrawable(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mCurrentDrawable = null;
    }
  }
  
  private void clearFrames(int paramInt)
  {
    int k = paramInt + this.mPreloadNum;
    int m = this.mAnimationFrames.size();
    if ((paramInt < 0) || (paramInt >= k) || (paramInt >= m)) {}
    for (;;)
    {
      return;
      int i;
      ZipDrawableLoader.AnimationFrame localAnimationFrame;
      if (k >= m)
      {
        i = k % m;
        while (i < paramInt)
        {
          localAnimationFrame = (ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(i);
          if (localAnimationFrame.mBitmapDrawable != this.mCurrentDrawable)
          {
            if (this.mRecycleFlag) {
              tryReuseBitmapDrawalbe(localAnimationFrame.mBitmapDrawable);
            }
            localAnimationFrame.mBitmapDrawable = null;
          }
          i += 1;
        }
      }
      else
      {
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramInt) {
            break;
          }
          localAnimationFrame = (ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(i);
          if (localAnimationFrame.mBitmapDrawable != this.mCurrentDrawable)
          {
            if (this.mRecycleFlag) {
              tryReuseBitmapDrawalbe(localAnimationFrame.mBitmapDrawable);
            }
            localAnimationFrame.mBitmapDrawable = null;
          }
          i += 1;
        }
        while (j < m)
        {
          localAnimationFrame = (ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(j);
          if (localAnimationFrame.mBitmapDrawable != this.mCurrentDrawable)
          {
            if (this.mRecycleFlag) {
              tryReuseBitmapDrawalbe(localAnimationFrame.mBitmapDrawable);
            }
            localAnimationFrame.mBitmapDrawable = null;
          }
          j += 1;
        }
      }
    }
  }
  
  private void clearList()
  {
    Iterator localIterator = this.mAnimationFrames.iterator();
    while (localIterator.hasNext())
    {
      ZipDrawableLoader.AnimationFrame localAnimationFrame = (ZipDrawableLoader.AnimationFrame)localIterator.next();
      if (localAnimationFrame.mBitmapDrawable != null) {
        localAnimationFrame.mBitmapDrawable = null;
      }
    }
  }
  
  @TargetApi(12)
  private BitmapDrawable decodeBitmap(String paramString)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((QZLog.isColorLevel()) && (System.currentTimeMillis() - this.mCurrentTime > 1000L))
    {
      this.mCurrentTime = System.currentTimeMillis();
      QZLog.i("zip_drawable", 2, "decodeBitmap mZipUrl = " + this.mZipUrl + " path = " + paramString);
    }
    label306:
    label308:
    for (;;)
    {
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QzoneMainRuntime))
        {
          localObject = ImageManager.getInstance().getDecoder();
          if (localObject == null) {
            break label306;
          }
          paramString = new File(paramString);
          if ((!paramString.exists()) || (paramString.isDirectory())) {
            break label306;
          }
          Bitmap localBitmap = getBitmapFromReusableSet();
          paramString = ((IDecoder)localObject).decodeBitmap(paramString, this.mDecodeFileWidth, this.mDecodeFileHeight, localBitmap);
          break label308;
          if (paramString == null) {
            break;
          }
          paramString.setDensity(160);
          return new BitmapDrawable(paramString);
        }
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if ((this.mDecodeFileHeight < 0) && (this.mDecodeFileWidth < 0))
        {
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
          if (Build.VERSION.SDK_INT >= 11) {
            addInBitmapOptions((BitmapFactory.Options)localObject);
          }
          paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        }
        else
        {
          i = calculateInSampleSize((BitmapFactory.Options)localObject, this.mDecodeFileWidth, this.mDecodeFileHeight);
          continue;
          paramString = null;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QZLog.e("ziploader", "OutOfMemoryError  ");
        return null;
      }
      catch (Exception paramString)
      {
        QZLog.e("ziploader", "decode bitmap exception " + paramString);
        return null;
      }
    }
  }
  
  private void decodeFrameAsyn(int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    if (paramInt > this.mAnimationFrames.size()) {}
    do
    {
      do
      {
        return;
        if (((ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable == null)
        {
          QzoneHandlerThreadFactory.getHandlerThread("YellowVip_HandlerThread").post(new ZipDrawableLoader.3(this, paramInt, paramZipFrameLoadedListener));
          return;
        }
        if (paramZipFrameLoadedListener != null) {
          paramZipFrameLoadedListener.onLoaded(paramInt, ((ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable);
        }
      } while (this.mFirstFrameLoaded);
      this.mFirstFrameLoaded = true;
    } while (this.mZipFirstFrameLoadedListener == null);
    this.mZipFirstFrameLoadedListener.onZipFirstFrameLoaded(((ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable);
  }
  
  private void loadZipData(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        this.mAnimationFrames.clear();
        i = 0;
        if (i < paramArrayOfString.length)
        {
          ZipDrawableLoader.AnimationFrame localAnimationFrame = new ZipDrawableLoader.AnimationFrame();
          localAnimationFrame.path = (paramString + File.separator + paramArrayOfString[i]);
          if ((!localAnimationFrame.path.endsWith(".jpg")) && (!localAnimationFrame.path.endsWith(".png"))) {
            break label158;
          }
          this.mAnimationFrames.add(localAnimationFrame);
          break label158;
        }
        bool = true;
        if (this.mPreLoadFrame) {
          loadFrame(0, this.mDrawableLoadedListener);
        }
        if (this.mListener != null) {
          this.mListener.onZipLoaded(bool);
        }
        return;
      }
      finally {}
      boolean bool = false;
      continue;
      label158:
      i += 1;
    }
  }
  
  private boolean selectDrawable(int paramInt)
  {
    try
    {
      ZipDrawableLoader.AnimationFrame localAnimationFrame = (ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(paramInt);
      if (localAnimationFrame.mBitmapDrawable != null) {
        this.mCurrentDrawable = localAnimationFrame.mBitmapDrawable;
      }
      clearFrames(this.mCurFrame);
      preloadFrame(this.mAnimationFrames, this.mCurFrame + 1);
      return false;
    }
    finally {}
  }
  
  private void tryReuseBitmapDrawalbe(BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable != null)
    {
      if ((Build.VERSION.SDK_INT < 11) || (this.mReusableBitmaps.size() >= this.mPreloadNum)) {
        break label50;
      }
      this.mReusableBitmaps.add(new WeakReference(paramBitmapDrawable.getBitmap()));
    }
    label50:
    do
    {
      return;
      paramBitmapDrawable = paramBitmapDrawable.getBitmap();
      if ((paramBitmapDrawable != null) && (!paramBitmapDrawable.isRecycled())) {
        paramBitmapDrawable.recycle();
      }
    } while (!QZLog.isColorLevel());
    QZLog.d("ziploader", 1, " out of max preload num:");
  }
  
  private void updateData(boolean paramBoolean)
  {
    if (paramBoolean) {
      loadZipData(QzoneZipCacheHelper.getFolderFileNameList(this.mBusiness, this.mDir), QzoneZipCacheHelper.getBasePath(this.mBusiness, this.mDir));
    }
    while (this.mListener == null) {
      return;
    }
    this.mListener.onZipLoaded(paramBoolean);
  }
  
  protected Bitmap getBitmapFromReusableSet()
  {
    Bitmap localBitmap3 = null;
    Bitmap localBitmap1 = localBitmap3;
    if (this.mReusableBitmaps != null)
    {
      localBitmap1 = localBitmap3;
      if (!this.mReusableBitmaps.isEmpty()) {
        synchronized (this.mReusableBitmaps)
        {
          Iterator localIterator = this.mReusableBitmaps.iterator();
          localBitmap1 = null;
          while (localIterator.hasNext())
          {
            localBitmap3 = (Bitmap)((WeakReference)localIterator.next()).get();
            if ((localBitmap3 != null) && (localBitmap3.isMutable()))
            {
              localIterator.remove();
              localBitmap1 = localBitmap3;
            }
            else
            {
              localIterator.remove();
            }
          }
        }
      }
    }
    return localBitmap2;
  }
  
  public int getCurFrameNum()
  {
    return this.mCurFrame;
  }
  
  public Drawable getCurrentDrawable()
  {
    return this.mCurrentDrawable;
  }
  
  public int getFrameCount()
  {
    return this.mAnimationFrames.size();
  }
  
  public CopyOnWriteArrayList<ZipDrawableLoader.AnimationFrame> getFrames()
  {
    return this.mAnimationFrames;
  }
  
  public String getZipDrawableDirSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return String.valueOf(paramString.hashCode());
  }
  
  /* Error */
  public void loadFrame(int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	cooperation/qzone/zipanimate/ZipDrawableLoader:mAnimationFrames	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 183	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: iload_1
    //   12: if_icmpgt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: aload_2
    //   21: invokespecial 482	cooperation/qzone/zipanimate/ZipDrawableLoader:decodeFrameAsyn	(ILcooperation/qzone/zipanimate/ZipFrameLoadedListener;)V
    //   24: aload_0
    //   25: iload_1
    //   26: invokevirtual 485	cooperation/qzone/zipanimate/ZipDrawableLoader:setFrame	(I)V
    //   29: goto -14 -> 15
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	ZipDrawableLoader
    //   0	37	1	paramInt	int
    //   0	37	2	paramZipFrameLoadedListener	ZipFrameLoadedListener
    //   9	4	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void loadLocalZipData(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    try
    {
      this.mAnimationFrames.clear();
      if (this.mPreloadNum <= 0) {
        this.mPreloadNum = 1;
      }
      this.mPreLoadFrame = paramBoolean;
      loadZipData(QzoneZipCacheHelper.getFolderFileNameList(paramString1, paramString2, paramString3), QzoneZipCacheHelper.getBasePath(paramString1, paramString2) + File.separator + paramString3);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void loadLocalZipData(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	cooperation/qzone/zipanimate/ZipDrawableLoader:mAnimationFrames	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 377	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 61	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreloadNum	I
    //   25: ifgt +8 -> 33
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 61	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreloadNum	I
    //   33: aload_0
    //   34: iload_2
    //   35: putfield 400	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreLoadFrame	Z
    //   38: aload_0
    //   39: aload_1
    //   40: invokestatic 495	cooperation/qzone/webviewplugin/QzoneZipCacheHelper:getFileList	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: aload_1
    //   44: invokespecial 450	cooperation/qzone/zipanimate/ZipDrawableLoader:loadZipData	([Ljava/lang/String;Ljava/lang/String;)V
    //   47: goto -29 -> 18
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ZipDrawableLoader
    //   0	55	1	paramString	String
    //   0	55	2	paramBoolean	boolean
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	50	finally
    //   21	33	50	finally
    //   33	47	50	finally
  }
  
  public boolean nextFrame()
  {
    boolean bool = false;
    try
    {
      int j = this.mCurFrame + 1;
      int k = this.mAnimationFrames.size();
      int i = j;
      if (j >= k) {
        i = 0;
      }
      setFrame(i);
      if (i == k - 1) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds = paramRect;
    if (this.mCurrentDrawable != null) {
      this.mCurrentDrawable.setBounds(this.mBounds);
    }
  }
  
  /* Error */
  void preloadFrame(java.util.List<ZipDrawableLoader.AnimationFrame> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	cooperation/qzone/zipanimate/ZipDrawableLoader:mAnimationFrames	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 504	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_3
    //   22: aload_0
    //   23: getfield 61	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreloadNum	I
    //   26: if_icmpge -10 -> 16
    //   29: aload_0
    //   30: iload_2
    //   31: iload_3
    //   32: iadd
    //   33: aload_1
    //   34: invokeinterface 507 1 0
    //   39: irem
    //   40: aload_0
    //   41: getfield 402	cooperation/qzone/zipanimate/ZipDrawableLoader:mDrawableLoadedListener	Lcooperation/qzone/zipanimate/ZipFrameLoadedListener;
    //   44: invokespecial 482	cooperation/qzone/zipanimate/ZipDrawableLoader:decodeFrameAsyn	(ILcooperation/qzone/zipanimate/ZipFrameLoadedListener;)V
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ZipDrawableLoader
    //   0	59	1	paramList	java.util.List<ZipDrawableLoader.AnimationFrame>
    //   0	59	2	paramInt	int
    //   20	31	3	i	int
    //   9	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	54	finally
    //   21	47	54	finally
  }
  
  public void release()
  {
    clearDrawable(false);
    clearList();
    this.mReusableBitmaps.clear();
  }
  
  public void selectFrame(int paramInt)
  {
    if ((this.mAnimationFrames == null) || (paramInt >= this.mAnimationFrames.size())) {}
    ZipDrawableLoader.AnimationFrame localAnimationFrame;
    do
    {
      return;
      this.mCurFrame = paramInt;
      localAnimationFrame = (ZipDrawableLoader.AnimationFrame)this.mAnimationFrames.get(paramInt);
    } while (localAnimationFrame.mBitmapDrawable == null);
    this.mCurrentDrawable = localAnimationFrame.mBitmapDrawable;
  }
  
  public void setDrawableData(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      setDrawableData(paramString, "zip_drawable", getZipDrawableDirSuffix(paramString), paramInt, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void setDrawableData(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	cooperation/qzone/zipanimate/ZipDrawableLoader:mAnimationFrames	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 377	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 61	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreloadNum	I
    //   20: ifgt +8 -> 28
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 61	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreloadNum	I
    //   28: aload_0
    //   29: aload_1
    //   30: putfield 112	cooperation/qzone/zipanimate/ZipDrawableLoader:mZipUrl	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_3
    //   35: putfield 126	cooperation/qzone/zipanimate/ZipDrawableLoader:mDir	Ljava/lang/String;
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 115	cooperation/qzone/zipanimate/ZipDrawableLoader:mBusiness	Ljava/lang/String;
    //   43: aload_0
    //   44: iload 5
    //   46: putfield 400	cooperation/qzone/zipanimate/ZipDrawableLoader:mPreLoadFrame	Z
    //   49: ldc_w 524
    //   52: invokestatic 349	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;)Lcooperation/qzone/thread/QzoneBaseThread;
    //   55: new 526	cooperation/qzone/zipanimate/ZipDrawableLoader$1
    //   58: dup
    //   59: aload_0
    //   60: iload 4
    //   62: invokespecial 529	cooperation/qzone/zipanimate/ZipDrawableLoader$1:<init>	(Lcooperation/qzone/zipanimate/ZipDrawableLoader;I)V
    //   65: invokevirtual 360	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   68: goto -55 -> 13
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ZipDrawableLoader
    //   0	76	1	paramString1	String
    //   0	76	2	paramString2	String
    //   0	76	3	paramString3	String
    //   0	76	4	paramInt	int
    //   0	76	5	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   16	28	71	finally
    //   28	68	71	finally
  }
  
  public void setDrawableLoadedListener(ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    this.mDrawableLoadedListener = paramZipFrameLoadedListener;
  }
  
  /* Error */
  public void setFrame(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	cooperation/qzone/zipanimate/ZipDrawableLoader:mAnimationFrames	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 183	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   9: istore_2
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmplt +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 72	cooperation/qzone/zipanimate/ZipDrawableLoader:mCurFrame	I
    //   23: aload_0
    //   24: iload_1
    //   25: invokespecial 533	cooperation/qzone/zipanimate/ZipDrawableLoader:selectDrawable	(I)Z
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	ZipDrawableLoader
    //   0	37	1	paramInt	int
    //   9	4	2	i	int
    //   32	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   18	29	32	finally
  }
  
  public void setPreloadNum(int paramInt)
  {
    if (paramInt > 0) {
      this.mPreloadNum = paramInt;
    }
  }
  
  public void setRecycleFlag(boolean paramBoolean)
  {
    this.mRecycleFlag = paramBoolean;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mDecodeFileWidth = paramInt1;
    this.mDecodeFileHeight = paramInt2;
  }
  
  public void setZipFirstFrameLoadedListener(ZipFirstFrameLoadedListener paramZipFirstFrameLoadedListener)
  {
    this.mZipFirstFrameLoadedListener = paramZipFirstFrameLoadedListener;
  }
  
  public void setZipLoadedListener(ZipLoadedListener paramZipLoadedListener)
  {
    this.mListener = paramZipLoadedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader
 * JD-Core Version:    0.7.0.1
 */