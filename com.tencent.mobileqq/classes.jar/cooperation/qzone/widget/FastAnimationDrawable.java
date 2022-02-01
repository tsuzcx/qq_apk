package cooperation.qzone.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.gifCoderWnsConfig;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FastAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static final String TAG = "FastAnimationDrawable";
  public static byte[] inTempStorage = new byte[24576];
  private FastAnimationDrawable.CallAntiShakeListener callAntiShakeListener;
  private long delay = gifCoderWnsConfig.DEFAULT_DELAY;
  private int mClipHeight;
  private int mClipWidth;
  private Context mContext;
  private volatile BitmapDrawable mCurrentFrame;
  private ExecutorService mExecutor;
  private FastAnimationDrawable.InvalidationHandler mInvalidationHandler;
  private volatile boolean mIsRunning;
  public LruCache<Integer, BitmapDrawable> mMemoryCache;
  private volatile BitmapDrawable mNextFrame;
  private AtomicInteger mNextFrameIndex = new AtomicInteger(-1);
  private ArrayList<String> mPhotoList;
  private Set<SoftReference<Bitmap>> mReusableBitmaps;
  
  public FastAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong, FastAnimationDrawable.CallAntiShakeListener paramCallAntiShakeListener)
  {
    this.mContext = paramContext;
    this.mIsRunning = false;
    this.mExecutor = Executors.newCachedThreadPool();
    this.mInvalidationHandler = new FastAnimationDrawable.InvalidationHandler(this, this);
    this.mClipWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.mClipHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.delay = paramLong;
    this.callAntiShakeListener = paramCallAntiShakeListener;
    if (Build.VERSION.SDK_INT >= 11) {
      this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
    }
    this.mPhotoList = paramArrayList;
    this.mMemoryCache = new FastAnimationDrawable.1(this, paramArrayList.size());
  }
  
  @TargetApi(11)
  private void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = getBitmapFromReusableSet(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      int i = 2;
      for (;;)
      {
        if (k / i <= paramInt2)
        {
          j = i;
          if (m / i <= paramInt1) {
            break;
          }
        }
        i *= 2;
      }
    }
    return j;
  }
  
  @TargetApi(19)
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT < 19) {
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1)) {}
    }
    while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount())
    {
      return true;
      return false;
    }
    return false;
  }
  
  /* Error */
  @TargetApi(12)
  private BitmapDrawable decodeBitmap(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aload 7
    //   7: astore 6
    //   9: new 171	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 220	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 8
    //   18: aload 7
    //   20: astore 6
    //   22: aload 8
    //   24: iconst_1
    //   25: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   28: aload 7
    //   30: astore 6
    //   32: aload 8
    //   34: getstatic 45	cooperation/qzone/widget/FastAnimationDrawable:inTempStorage	[B
    //   37: putfield 224	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   40: aload 7
    //   42: astore 6
    //   44: aload_1
    //   45: aload 8
    //   47: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 7
    //   53: astore 6
    //   55: aload 8
    //   57: aload_0
    //   58: getfield 102	cooperation/qzone/widget/FastAnimationDrawable:mClipWidth	I
    //   61: aload_0
    //   62: getfield 107	cooperation/qzone/widget/FastAnimationDrawable:mClipHeight	I
    //   65: invokestatic 232	cooperation/qzone/widget/FastAnimationDrawable:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   68: istore_2
    //   69: aload 7
    //   71: astore 6
    //   73: aload 8
    //   75: iconst_0
    //   76: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   79: aload 7
    //   81: astore 6
    //   83: aload 8
    //   85: iload_2
    //   86: putfield 205	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload 7
    //   91: astore 6
    //   93: aload 8
    //   95: getstatic 45	cooperation/qzone/widget/FastAnimationDrawable:inTempStorage	[B
    //   98: putfield 224	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   101: aload 7
    //   103: astore 6
    //   105: aload 8
    //   107: getstatic 238	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   110: putfield 241	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   113: aload 7
    //   115: astore 6
    //   117: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   120: bipush 11
    //   122: if_icmplt +13 -> 135
    //   125: aload 7
    //   127: astore 6
    //   129: aload_0
    //   130: aload 8
    //   132: invokespecial 243	cooperation/qzone/widget/FastAnimationDrawable:addInBitmapOptions	(Landroid/graphics/BitmapFactory$Options;)V
    //   135: aload 7
    //   137: astore 6
    //   139: aload_1
    //   140: aload 8
    //   142: invokestatic 246	cooperation/qzone/widget/FastAnimationDrawable:decodeFileWithBufferedStream	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore 8
    //   147: aload 8
    //   149: astore 6
    //   151: aload_1
    //   152: invokestatic 252	bheg:b	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: aload 8
    //   158: astore 7
    //   160: iload_3
    //   161: ifeq +131 -> 292
    //   164: aload 8
    //   166: astore 7
    //   168: iload_3
    //   169: bipush 90
    //   171: irem
    //   172: ifne +120 -> 292
    //   175: aload 8
    //   177: astore 6
    //   179: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +33 -> 215
    //   185: aload 8
    //   187: astore 6
    //   189: ldc 10
    //   191: iconst_2
    //   192: new 260	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 263
    //   202: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload_3
    //   206: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload 8
    //   217: astore 6
    //   219: aload 8
    //   221: invokevirtual 199	android/graphics/Bitmap:getWidth	()I
    //   224: istore 4
    //   226: aload 8
    //   228: astore 6
    //   230: aload 8
    //   232: invokevirtual 202	android/graphics/Bitmap:getHeight	()I
    //   235: istore 5
    //   237: aload 8
    //   239: astore 6
    //   241: new 280	android/graphics/Matrix
    //   244: dup
    //   245: invokespecial 281	android/graphics/Matrix:<init>	()V
    //   248: astore 7
    //   250: aload 8
    //   252: astore 6
    //   254: aload 7
    //   256: iload_3
    //   257: i2f
    //   258: iload 4
    //   260: i2f
    //   261: fconst_2
    //   262: fdiv
    //   263: iload 5
    //   265: i2f
    //   266: fconst_2
    //   267: fdiv
    //   268: invokevirtual 285	android/graphics/Matrix:postRotate	(FFF)Z
    //   271: pop
    //   272: aload 8
    //   274: astore 6
    //   276: aload 8
    //   278: iconst_0
    //   279: iconst_0
    //   280: iload 4
    //   282: iload 5
    //   284: aload 7
    //   286: iconst_1
    //   287: invokestatic 289	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   290: astore 7
    //   292: aload 7
    //   294: astore 8
    //   296: aload 7
    //   298: astore 6
    //   300: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +61 -> 364
    //   306: aload 7
    //   308: astore 6
    //   310: ldc 10
    //   312: iconst_2
    //   313: new 260	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 291
    //   323: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 293
    //   333: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload_2
    //   337: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 295
    //   343: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 7
    //   348: invokevirtual 298	android/graphics/Bitmap:getByteCount	()I
    //   351: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 7
    //   362: astore 8
    //   364: new 300	android/graphics/drawable/BitmapDrawable
    //   367: dup
    //   368: aload 8
    //   370: invokespecial 303	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   373: astore_1
    //   374: aload_0
    //   375: monitorexit
    //   376: aload_1
    //   377: areturn
    //   378: astore_1
    //   379: aload_0
    //   380: monitorexit
    //   381: aload_1
    //   382: athrow
    //   383: astore_1
    //   384: aload 6
    //   386: astore 8
    //   388: goto -24 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	FastAnimationDrawable
    //   0	391	1	paramString	String
    //   68	269	2	i	int
    //   155	102	3	j	int
    //   224	57	4	k	int
    //   235	48	5	m	int
    //   7	378	6	localObject1	java.lang.Object
    //   3	358	7	localObject2	java.lang.Object
    //   16	371	8	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   9	18	378	finally
    //   22	28	378	finally
    //   32	40	378	finally
    //   44	51	378	finally
    //   55	69	378	finally
    //   73	79	378	finally
    //   83	89	378	finally
    //   93	101	378	finally
    //   105	113	378	finally
    //   117	125	378	finally
    //   129	135	378	finally
    //   139	147	378	finally
    //   151	156	378	finally
    //   179	185	378	finally
    //   189	215	378	finally
    //   219	226	378	finally
    //   230	237	378	finally
    //   241	250	378	finally
    //   254	272	378	finally
    //   276	292	378	finally
    //   300	306	378	finally
    //   310	360	378	finally
    //   364	374	378	finally
    //   9	18	383	java/lang/OutOfMemoryError
    //   22	28	383	java/lang/OutOfMemoryError
    //   32	40	383	java/lang/OutOfMemoryError
    //   44	51	383	java/lang/OutOfMemoryError
    //   55	69	383	java/lang/OutOfMemoryError
    //   73	79	383	java/lang/OutOfMemoryError
    //   83	89	383	java/lang/OutOfMemoryError
    //   93	101	383	java/lang/OutOfMemoryError
    //   105	113	383	java/lang/OutOfMemoryError
    //   117	125	383	java/lang/OutOfMemoryError
    //   129	135	383	java/lang/OutOfMemoryError
    //   139	147	383	java/lang/OutOfMemoryError
    //   151	156	383	java/lang/OutOfMemoryError
    //   179	185	383	java/lang/OutOfMemoryError
    //   189	215	383	java/lang/OutOfMemoryError
    //   219	226	383	java/lang/OutOfMemoryError
    //   230	237	383	java/lang/OutOfMemoryError
    //   241	250	383	java/lang/OutOfMemoryError
    //   254	272	383	java/lang/OutOfMemoryError
    //   276	292	383	java/lang/OutOfMemoryError
    //   300	306	383	java/lang/OutOfMemoryError
    //   310	360	383	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static Bitmap decodeFileWithBufferedStream(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +54 -> 57
    //   6: aload_1
    //   7: getfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +47 -> 57
    //   13: new 309	java/io/BufferedInputStream
    //   16: dup
    //   17: new 311	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 2048
    //   28: invokespecial 317	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 321	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokevirtual 326	java/io/InputStream:close	()V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_1
    //   56: areturn
    //   57: new 309	java/io/BufferedInputStream
    //   60: dup
    //   61: new 311	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   69: invokespecial 329	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_0
    //   73: goto -41 -> 32
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 10
    //   83: iconst_1
    //   84: ldc_w 331
    //   87: aload_1
    //   88: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_3
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull -39 -> 55
    //   97: aload_0
    //   98: invokevirtual 326	java/io/InputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: astore_2
    //   111: ldc 10
    //   113: iconst_1
    //   114: ldc_w 337
    //   117: aload_1
    //   118: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_3
    //   122: astore_1
    //   123: aload_0
    //   124: ifnull -69 -> 55
    //   127: aload_0
    //   128: invokevirtual 326	java/io/InputStream:close	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 326	java/io/InputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: aload_2
    //   151: areturn
    //   152: astore_1
    //   153: goto -6 -> 147
    //   156: astore_0
    //   157: goto -18 -> 139
    //   160: astore_1
    //   161: goto -52 -> 109
    //   164: astore_1
    //   165: goto -86 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   0	168	1	paramOptions	BitmapFactory.Options
    //   33	118	2	localObject1	java.lang.Object
    //   1	121	3	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   6	32	76	java/lang/Exception
    //   57	73	76	java/lang/Exception
    //   97	101	103	java/io/IOException
    //   6	32	106	java/lang/OutOfMemoryError
    //   57	73	106	java/lang/OutOfMemoryError
    //   127	131	133	java/io/IOException
    //   6	32	136	finally
    //   57	73	136	finally
    //   49	53	149	java/io/IOException
    //   143	147	152	java/io/IOException
    //   34	41	156	finally
    //   81	91	156	finally
    //   111	121	156	finally
    //   34	41	160	java/lang/OutOfMemoryError
    //   34	41	164	java/lang/Exception
  }
  
  private static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "reset");
    }
    this.mIsRunning = true;
    this.mCurrentFrame = null;
    this.mNextFrame = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mNextFrame != null)
    {
      this.mCurrentFrame = this.mNextFrame;
      this.mNextFrame = null;
    }
    if (this.mCurrentFrame != null)
    {
      this.mCurrentFrame.setBounds(getBounds());
      this.mCurrentFrame.draw(paramCanvas);
    }
  }
  
  protected Bitmap getBitmapFromReusableSet(BitmapFactory.Options paramOptions)
  {
    if ((this.mReusableBitmaps != null) && (!this.mReusableBitmaps.isEmpty())) {
      for (;;)
      {
        synchronized (this.mReusableBitmaps)
        {
          Iterator localIterator = this.mReusableBitmaps.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!canUseForInBitmap(localBitmap, paramOptions)) {
                continue;
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  public long getDuration()
  {
    return this.delay;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  public void recyclBitmaps()
  {
    this.mMemoryCache.evictAll();
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setClipWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mClipWidth = paramInt1;
    this.mClipHeight = paramInt2;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDuration(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 20L) {
      l = 20L;
    }
    this.delay = l;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "setVisible changed:" + bool + " visible:" + paramBoolean1 + " restart:" + paramBoolean2);
    }
    if (paramBoolean1) {
      if (bool)
      {
        start();
        if (!paramBoolean2) {
          break label81;
        }
        reset();
      }
    }
    label81:
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (!this.mIsRunning)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "start");
      }
      this.mIsRunning = true;
      this.mExecutor.submit(new FastAnimationDrawable.LoopReadWriteRunnable(this));
    }
  }
  
  public void stop()
  {
    if (isRunning())
    {
      this.mIsRunning = false;
      this.callAntiShakeListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */