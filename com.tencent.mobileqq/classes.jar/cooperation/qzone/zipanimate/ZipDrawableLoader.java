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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader
  implements ZipDrawableLoaderInterface
{
  public static final String DEFAULT_BUSINESS = "zip_drawable";
  private static final int PRELOAD_FRAME_NUM = 1;
  public static final byte[] inTempStorage = new byte[24576];
  private CopyOnWriteArrayList<AnimationFrame> mAnimationFrames = new CopyOnWriteArrayList();
  private Rect mBounds = null;
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
  private volatile boolean mIsRunning = false;
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
    int k = this.mPreloadNum + paramInt;
    int m = this.mAnimationFrames.size();
    if ((paramInt >= 0) && (paramInt < k))
    {
      if (paramInt >= m) {
        return;
      }
      AnimationFrame localAnimationFrame;
      if (k >= m)
      {
        i = k % m;
        while (i < paramInt)
        {
          localAnimationFrame = (AnimationFrame)this.mAnimationFrames.get(i);
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
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramInt) {
          break;
        }
        localAnimationFrame = (AnimationFrame)this.mAnimationFrames.get(i);
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
        localAnimationFrame = (AnimationFrame)this.mAnimationFrames.get(j);
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
  
  private void clearList()
  {
    Iterator localIterator = this.mAnimationFrames.iterator();
    while (localIterator.hasNext())
    {
      AnimationFrame localAnimationFrame = (AnimationFrame)localIterator.next();
      if (localAnimationFrame.mBitmapDrawable != null) {
        localAnimationFrame.mBitmapDrawable = null;
      }
    }
  }
  
  @TargetApi(12)
  private BitmapDrawable decodeBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((QZLog.isColorLevel()) && (System.currentTimeMillis() - this.mCurrentTime > 1000L))
    {
      this.mCurrentTime = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeBitmap mZipUrl = ");
      ((StringBuilder)localObject).append(this.mZipUrl);
      ((StringBuilder)localObject).append(" path = ");
      ((StringBuilder)localObject).append(paramString);
      QZLog.i("zip_drawable", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QzoneMainRuntime))
      {
        localObject = ImageManager.getInstance().getDecoder();
        if (localObject == null) {
          break label324;
        }
        paramString = new File(paramString);
        if ((!paramString.exists()) || (paramString.isDirectory())) {
          break label324;
        }
        Bitmap localBitmap = getBitmapFromReusableSet();
        paramString = ((IDecoder)localObject).decodeBitmap(paramString, this.mDecodeFileWidth, this.mDecodeFileHeight, localBitmap);
      }
      else
      {
        localObject = new BitmapFactory.Options();
        int i = 1;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
        BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if ((this.mDecodeFileHeight >= 0) || (this.mDecodeFileWidth >= 0)) {
          i = calculateInSampleSize((BitmapFactory.Options)localObject, this.mDecodeFileWidth, this.mDecodeFileHeight);
        }
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inTempStorage = inTempStorage;
        if (Build.VERSION.SDK_INT >= 11) {
          addInBitmapOptions((BitmapFactory.Options)localObject);
        }
        paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      }
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decode bitmap exception ");
      ((StringBuilder)localObject).append(paramString);
      QZLog.e("ziploader", ((StringBuilder)localObject).toString());
      return null;
      QZLog.e("ziploader", "OutOfMemoryError  ");
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        continue;
        paramString = null;
      }
    }
    if (paramString != null)
    {
      paramString.setDensity(160);
      paramString = new BitmapDrawable(paramString);
      return paramString;
    }
  }
  
  private void decodeFrameAsyn(int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    if (paramInt > this.mAnimationFrames.size()) {
      return;
    }
    if (((AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable == null)
    {
      QzoneHandlerThreadFactory.getHandlerThread("YellowVip_HandlerThread").post(new ZipDrawableLoader.3(this, paramInt, paramZipFrameLoadedListener));
      return;
    }
    if (paramZipFrameLoadedListener != null) {
      paramZipFrameLoadedListener.onLoaded(paramInt, ((AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable);
    }
    if (!this.mFirstFrameLoaded)
    {
      this.mFirstFrameLoaded = true;
      paramZipFrameLoadedListener = this.mZipFirstFrameLoadedListener;
      if (paramZipFrameLoadedListener != null) {
        paramZipFrameLoadedListener.onZipFirstFrameLoaded(((AnimationFrame)this.mAnimationFrames.get(paramInt)).mBitmapDrawable);
      }
    }
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
          AnimationFrame localAnimationFrame = new AnimationFrame();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(paramArrayOfString[i]);
          localAnimationFrame.path = localStringBuilder.toString();
          if ((!localAnimationFrame.path.endsWith(".jpg")) && (!localAnimationFrame.path.endsWith(".png"))) {
            break label170;
          }
          this.mAnimationFrames.add(localAnimationFrame);
          break label170;
        }
        bool = true;
      }
      finally {}
      boolean bool = false;
      if (this.mPreLoadFrame) {
        loadFrame(0, this.mDrawableLoadedListener);
      }
      paramArrayOfString = this.mListener;
      if (paramArrayOfString != null) {
        paramArrayOfString.onZipLoaded(bool);
      }
      return;
      label170:
      i += 1;
    }
  }
  
  private boolean selectDrawable(int paramInt)
  {
    try
    {
      AnimationFrame localAnimationFrame = (AnimationFrame)this.mAnimationFrames.get(paramInt);
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
      if ((Build.VERSION.SDK_INT >= 11) && (this.mReusableBitmaps.size() < this.mPreloadNum))
      {
        this.mReusableBitmaps.add(new WeakReference(paramBitmapDrawable.getBitmap()));
        return;
      }
      paramBitmapDrawable = paramBitmapDrawable.getBitmap();
      if ((paramBitmapDrawable != null) && (!paramBitmapDrawable.isRecycled())) {
        paramBitmapDrawable.recycle();
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("ziploader", 1, " out of max preload num:");
      }
    }
  }
  
  private void updateData(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      loadZipData(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getFolderFileNameList(this.mBusiness, this.mDir), ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(this.mBusiness, this.mDir));
      return;
    }
    ZipLoadedListener localZipLoadedListener = this.mListener;
    if (localZipLoadedListener != null) {
      localZipLoadedListener.onZipLoaded(paramBoolean);
    }
  }
  
  protected Bitmap getBitmapFromReusableSet()
  {
    Object localObject3 = this.mReusableBitmaps;
    Object localObject1 = null;
    if ((localObject3 != null) && (!((Set)localObject3).isEmpty())) {
      synchronized (this.mReusableBitmaps)
      {
        Iterator localIterator = this.mReusableBitmaps.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (Bitmap)((WeakReference)localIterator.next()).get();
          if ((localObject3 != null) && (((Bitmap)localObject3).isMutable()))
          {
            localIterator.remove();
            localObject1 = localObject3;
          }
          else
          {
            localIterator.remove();
          }
        }
        return localObject1;
      }
    }
    return null;
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
  
  public CopyOnWriteArrayList<AnimationFrame> getFrames()
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
  
  public void loadFrame(int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    try
    {
      int i = this.mAnimationFrames.size();
      if (i <= paramInt) {
        return;
      }
      decodeFrameAsyn(paramInt, paramZipFrameLoadedListener);
      setFrame(paramInt);
      return;
    }
    finally {}
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
      String[] arrayOfString = ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getFolderFileNameList(paramString1, paramString2, paramString3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(paramString1, paramString2));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString3);
      loadZipData(arrayOfString, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void loadLocalZipData(String paramString, boolean paramBoolean)
  {
    try
    {
      this.mAnimationFrames.clear();
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (this.mPreloadNum <= 0) {
        this.mPreloadNum = 1;
      }
      this.mPreLoadFrame = paramBoolean;
      loadZipData(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getFileList(paramString), paramString);
      return;
    }
    finally {}
  }
  
  public boolean nextFrame()
  {
    try
    {
      int i = this.mCurFrame;
      boolean bool = true;
      int j = i + 1;
      int k = this.mAnimationFrames.size();
      i = j;
      if (j >= k) {
        i = 0;
      }
      setFrame(i);
      if (i != k - 1) {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.mBounds = paramRect;
    paramRect = this.mCurrentDrawable;
    if (paramRect != null) {
      paramRect.setBounds(this.mBounds);
    }
  }
  
  void preloadFrame(List<AnimationFrame> paramList, int paramInt)
  {
    try
    {
      boolean bool = this.mAnimationFrames.isEmpty();
      if (bool) {
        return;
      }
      int i = 0;
      while (i < this.mPreloadNum)
      {
        decodeFrameAsyn((paramInt + i) % paramList.size(), this.mDrawableLoadedListener);
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void release()
  {
    clearDrawable(false);
    clearList();
    this.mReusableBitmaps.clear();
  }
  
  public void selectFrame(int paramInt)
  {
    Object localObject = this.mAnimationFrames;
    if (localObject != null)
    {
      if (paramInt >= ((CopyOnWriteArrayList)localObject).size()) {
        return;
      }
      this.mCurFrame = paramInt;
      localObject = (AnimationFrame)this.mAnimationFrames.get(paramInt);
      if (((AnimationFrame)localObject).mBitmapDrawable != null) {
        this.mCurrentDrawable = ((AnimationFrame)localObject).mBitmapDrawable;
      }
    }
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
  
  public void setDrawableData(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.mAnimationFrames.clear();
      if (paramString1 == null) {
        return;
      }
      if (this.mPreloadNum <= 0) {
        this.mPreloadNum = 1;
      }
      this.mZipUrl = paramString1;
      this.mDir = paramString3;
      this.mBusiness = paramString2;
      this.mPreLoadFrame = paramBoolean;
      QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new ZipDrawableLoader.1(this, paramInt));
      return;
    }
    finally {}
  }
  
  public void setDrawableLoadedListener(ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    this.mDrawableLoadedListener = paramZipFrameLoadedListener;
  }
  
  public void setFrame(int paramInt)
  {
    try
    {
      int i = this.mAnimationFrames.size();
      if (paramInt >= i) {
        return;
      }
      this.mCurFrame = paramInt;
      selectDrawable(paramInt);
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader
 * JD-Core Version:    0.7.0.1
 */