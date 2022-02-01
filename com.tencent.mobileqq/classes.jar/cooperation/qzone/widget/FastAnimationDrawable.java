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
import bmkg;
import bmpc;
import bmpd;
import bmpe;
import com.tencent.qphone.base.util.QLog;
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
  public static byte[] a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = bmkg.d;
  private Context jdField_a_of_type_AndroidContentContext;
  private volatile BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  public LruCache<Integer, BitmapDrawable> a;
  private bmpd jdField_a_of_type_Bmpd;
  private bmpe jdField_a_of_type_Bmpe;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private volatile BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  public FastAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong, bmpd parambmpd)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newCachedThreadPool();
    this.jdField_a_of_type_Bmpe = new bmpe(this, this);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bmpd = parambmpd;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidUtilLruCache = new bmpc(this, paramArrayList.size());
  }
  
  private static int a(Bitmap.Config paramConfig)
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
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +54 -> 57
    //   6: aload_1
    //   7: getfield 161	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +47 -> 57
    //   13: new 163	java/io/BufferedInputStream
    //   16: dup
    //   17: new 165	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 2048
    //   28: invokespecial 171	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 177	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokevirtual 182	java/io/InputStream:close	()V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_1
    //   56: areturn
    //   57: new 163	java/io/BufferedInputStream
    //   60: dup
    //   61: new 165	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   69: invokespecial 185	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_0
    //   73: goto -41 -> 32
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 187
    //   83: iconst_1
    //   84: ldc 189
    //   86: aload_1
    //   87: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_3
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull -38 -> 55
    //   96: aload_0
    //   97: invokevirtual 182	java/io/InputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: astore_2
    //   110: ldc 187
    //   112: iconst_1
    //   113: ldc 197
    //   115: aload_1
    //   116: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_3
    //   120: astore_1
    //   121: aload_0
    //   122: ifnull -67 -> 55
    //   125: aload_0
    //   126: invokevirtual 182	java/io/InputStream:close	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 182	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: astore_0
    //   148: aload_2
    //   149: areturn
    //   150: astore_1
    //   151: goto -6 -> 145
    //   154: astore_0
    //   155: goto -18 -> 137
    //   158: astore_1
    //   159: goto -51 -> 108
    //   162: astore_1
    //   163: goto -84 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   0	166	1	paramOptions	BitmapFactory.Options
    //   33	116	2	localObject1	java.lang.Object
    //   1	119	3	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   6	32	76	java/lang/Exception
    //   57	73	76	java/lang/Exception
    //   96	100	102	java/io/IOException
    //   6	32	105	java/lang/OutOfMemoryError
    //   57	73	105	java/lang/OutOfMemoryError
    //   125	129	131	java/io/IOException
    //   6	32	134	finally
    //   57	73	134	finally
    //   49	53	147	java/io/IOException
    //   141	145	150	java/io/IOException
    //   34	41	154	finally
    //   81	90	154	finally
    //   110	119	154	finally
    //   34	41	158	java/lang/OutOfMemoryError
    //   34	41	162	java/lang/Exception
  }
  
  /* Error */
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 7
    //   5: aload 7
    //   7: astore 6
    //   9: new 144	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 208	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 8
    //   18: aload 7
    //   20: astore 6
    //   22: aload 8
    //   24: iconst_1
    //   25: putfield 161	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   28: aload 7
    //   30: astore 6
    //   32: aload 8
    //   34: getstatic 28	cooperation/qzone/widget/FastAnimationDrawable:jdField_a_of_type_ArrayOfByte	[B
    //   37: putfield 211	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   40: aload 7
    //   42: astore 6
    //   44: aload_1
    //   45: aload 8
    //   47: invokestatic 214	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: pop
    //   51: aload 7
    //   53: astore 6
    //   55: aload 8
    //   57: aload_0
    //   58: getfield 85	cooperation/qzone/widget/FastAnimationDrawable:jdField_a_of_type_Int	I
    //   61: aload_0
    //   62: getfield 90	cooperation/qzone/widget/FastAnimationDrawable:jdField_b_of_type_Int	I
    //   65: invokestatic 216	cooperation/qzone/widget/FastAnimationDrawable:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   68: istore_2
    //   69: aload 7
    //   71: astore 6
    //   73: aload 8
    //   75: iconst_0
    //   76: putfield 161	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   79: aload 7
    //   81: astore 6
    //   83: aload 8
    //   85: iload_2
    //   86: putfield 219	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload 7
    //   91: astore 6
    //   93: aload 8
    //   95: getstatic 28	cooperation/qzone/widget/FastAnimationDrawable:jdField_a_of_type_ArrayOfByte	[B
    //   98: putfield 211	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   101: aload 7
    //   103: astore 6
    //   105: aload 8
    //   107: getstatic 135	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   110: putfield 222	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   113: aload 7
    //   115: astore 6
    //   117: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   120: bipush 11
    //   122: if_icmplt +13 -> 135
    //   125: aload 7
    //   127: astore 6
    //   129: aload_0
    //   130: aload 8
    //   132: invokespecial 225	cooperation/qzone/widget/FastAnimationDrawable:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   135: aload 7
    //   137: astore 6
    //   139: aload_1
    //   140: aload 8
    //   142: invokestatic 227	cooperation/qzone/widget/FastAnimationDrawable:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore 8
    //   147: aload 8
    //   149: astore 6
    //   151: aload_1
    //   152: invokestatic 232	bgmo:b	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: aload 8
    //   158: astore 7
    //   160: iload_3
    //   161: ifeq +130 -> 291
    //   164: aload 8
    //   166: astore 7
    //   168: iload_3
    //   169: bipush 90
    //   171: irem
    //   172: ifne +119 -> 291
    //   175: aload 8
    //   177: astore 6
    //   179: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +32 -> 214
    //   185: aload 8
    //   187: astore 6
    //   189: ldc 187
    //   191: iconst_2
    //   192: new 238	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   199: ldc 241
    //   201: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_3
    //   205: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 8
    //   216: astore 6
    //   218: aload 8
    //   220: invokevirtual 260	android/graphics/Bitmap:getWidth	()I
    //   223: istore 4
    //   225: aload 8
    //   227: astore 6
    //   229: aload 8
    //   231: invokevirtual 263	android/graphics/Bitmap:getHeight	()I
    //   234: istore 5
    //   236: aload 8
    //   238: astore 6
    //   240: new 265	android/graphics/Matrix
    //   243: dup
    //   244: invokespecial 266	android/graphics/Matrix:<init>	()V
    //   247: astore 7
    //   249: aload 8
    //   251: astore 6
    //   253: aload 7
    //   255: iload_3
    //   256: i2f
    //   257: iload 4
    //   259: i2f
    //   260: fconst_2
    //   261: fdiv
    //   262: iload 5
    //   264: i2f
    //   265: fconst_2
    //   266: fdiv
    //   267: invokevirtual 270	android/graphics/Matrix:postRotate	(FFF)Z
    //   270: pop
    //   271: aload 8
    //   273: astore 6
    //   275: aload 8
    //   277: iconst_0
    //   278: iconst_0
    //   279: iload 4
    //   281: iload 5
    //   283: aload 7
    //   285: iconst_1
    //   286: invokestatic 274	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   289: astore 7
    //   291: aload 7
    //   293: astore 8
    //   295: aload 7
    //   297: astore 6
    //   299: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +61 -> 363
    //   305: aload 7
    //   307: astore 6
    //   309: ldc 187
    //   311: iconst_2
    //   312: new 238	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 276
    //   322: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 278
    //   332: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload_2
    //   336: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: ldc_w 280
    //   342: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 7
    //   347: invokevirtual 283	android/graphics/Bitmap:getByteCount	()I
    //   350: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 7
    //   361: astore 8
    //   363: new 285	android/graphics/drawable/BitmapDrawable
    //   366: dup
    //   367: aload 8
    //   369: invokespecial 288	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   372: astore_1
    //   373: aload_0
    //   374: monitorexit
    //   375: aload_1
    //   376: areturn
    //   377: astore_1
    //   378: aload_0
    //   379: monitorexit
    //   380: aload_1
    //   381: athrow
    //   382: astore_1
    //   383: aload 6
    //   385: astore 8
    //   387: goto -24 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	FastAnimationDrawable
    //   0	390	1	paramString	String
    //   68	268	2	i	int
    //   155	101	3	j	int
    //   223	57	4	k	int
    //   234	48	5	m	int
    //   7	377	6	localObject1	java.lang.Object
    //   3	357	7	localObject2	java.lang.Object
    //   16	370	8	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   9	18	377	finally
    //   22	28	377	finally
    //   32	40	377	finally
    //   44	51	377	finally
    //   55	69	377	finally
    //   73	79	377	finally
    //   83	89	377	finally
    //   93	101	377	finally
    //   105	113	377	finally
    //   117	125	377	finally
    //   129	135	377	finally
    //   139	147	377	finally
    //   151	156	377	finally
    //   179	185	377	finally
    //   189	214	377	finally
    //   218	225	377	finally
    //   229	236	377	finally
    //   240	249	377	finally
    //   253	271	377	finally
    //   275	291	377	finally
    //   299	305	377	finally
    //   309	359	377	finally
    //   363	373	377	finally
    //   9	18	382	java/lang/OutOfMemoryError
    //   22	28	382	java/lang/OutOfMemoryError
    //   32	40	382	java/lang/OutOfMemoryError
    //   44	51	382	java/lang/OutOfMemoryError
    //   55	69	382	java/lang/OutOfMemoryError
    //   73	79	382	java/lang/OutOfMemoryError
    //   83	89	382	java/lang/OutOfMemoryError
    //   93	101	382	java/lang/OutOfMemoryError
    //   105	113	382	java/lang/OutOfMemoryError
    //   117	125	382	java/lang/OutOfMemoryError
    //   129	135	382	java/lang/OutOfMemoryError
    //   139	147	382	java/lang/OutOfMemoryError
    //   151	156	382	java/lang/OutOfMemoryError
    //   179	185	382	java/lang/OutOfMemoryError
    //   189	214	382	java/lang/OutOfMemoryError
    //   218	225	382	java/lang/OutOfMemoryError
    //   229	236	382	java/lang/OutOfMemoryError
    //   240	249	382	java/lang/OutOfMemoryError
    //   253	271	382	java/lang/OutOfMemoryError
    //   275	291	382	java/lang/OutOfMemoryError
    //   299	305	382	java/lang/OutOfMemoryError
    //   309	359	382	java/lang/OutOfMemoryError
  }
  
  @TargetApi(11)
  private void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT < 19) {
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1)) {}
    }
    while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount())
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastAnimationDrawable", 2, "reset");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty())) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilSet)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!a(localBitmap, paramOptions)) {
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 20L) {
      l = 20L;
    }
    this.jdField_a_of_type_Long = l;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
      this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(getBounds());
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
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
        b();
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
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FastAnimationDrawable", 2, "start");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new FastAnimationDrawable.LoopReadWriteRunnable(this));
    }
  }
  
  public void stop()
  {
    if (isRunning())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bmpd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.FastAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */