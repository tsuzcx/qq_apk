package com.tencent.mobileqq.bubble;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  public static final ExecutorService h = ;
  public static byte[] i = new byte[24576];
  private String A;
  private int B;
  private int C;
  private QQAnimationDrawable.QQAnimationListener D;
  private boolean E = false;
  private Object F = new Object();
  private long G;
  private int H;
  private volatile QQAnimationDrawable.SerialExecutor I = new QQAnimationDrawable.SerialExecutor(null);
  private FutureTask<Bitmap> J;
  private Set<SoftReference<Bitmap>> K;
  protected int a = -1;
  Bitmap b;
  Bitmap c;
  int d = 160;
  final QQAnimationDrawable.InternalHandler e = new QQAnimationDrawable.InternalHandler(this, this);
  boolean f = true;
  boolean g = true;
  private Paint j = new Paint(6);
  private int k = 0;
  private boolean l = false;
  private boolean m = true;
  private int n = 1;
  private long o = 0L;
  private Bitmap p;
  private int q = 0;
  private boolean r = true;
  private QQAnimationDrawable.WorkerRunnable s;
  private int[] t;
  private String[] u;
  private BitmapFactory.Options v = new BitmapFactory.Options();
  private int w = 2;
  private boolean x = true;
  private ArrayList<Bitmap> y = new ArrayList();
  private HashMap<String, SoftReference<Bitmap>> z = new HashMap();
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    int i2 = this.d;
    int i1 = i2;
    if (i2 == 0) {
      i1 = 160;
    }
    this.d = i1;
    this.D = paramQQAnimationListener;
    this.K = Collections.synchronizedSet(new HashSet());
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i2 = paramOptions.outHeight;
    int i3 = paramOptions.outWidth;
    if ((i2 <= paramInt2) && (i3 <= paramInt1)) {
      return 1;
    }
    int i1 = 2;
    for (;;)
    {
      if ((i2 / i1 <= paramInt2) && (i3 / i1 <= paramInt1)) {
        return i1;
      }
      i1 *= 2;
    }
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    localObject = paramBitmap;
    long l1;
    String str;
    label285:
    try
    {
      if (this.u != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.u.length)
        {
          l1 = System.currentTimeMillis();
          str = this.u[paramInt];
          localObject = paramBitmap;
          if (str != null) {
            if (this.x)
            {
              localObject = (SoftReference)this.z.get(str);
              if ((localObject != null) && (((SoftReference)localObject).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject).get();
                return paramBitmap;
              }
              localBitmap = paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = new BitmapFactory.Options();
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inTempStorage = i;
      localBitmap = paramBitmap;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      localBitmap = paramBitmap;
      paramInt = a((BitmapFactory.Options)localObject, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels);
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      localBitmap = paramBitmap;
      b((BitmapFactory.Options)localObject);
      localBitmap = paramBitmap;
      paramBitmap = ImageUtil.a(str, (BitmapFactory.Options)localObject);
      localObject = paramBitmap;
      if (paramBitmap == null) {
        break label285;
      }
      localObject = paramBitmap;
      localBitmap = paramBitmap;
      if (paramBitmap.isRecycled()) {
        break label285;
      }
      localObject = paramBitmap;
      localBitmap = paramBitmap;
      if (Build.VERSION.SDK_INT < 11) {
        break label285;
      }
      localBitmap = paramBitmap;
      this.K.add(new SoftReference(paramBitmap));
      localObject = paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      localObject = localBitmap;
      break label285;
    }
    a(this.c, l1, str);
    localObject = this.c;
    return localObject;
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.v.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.v);
      Bitmap.createBitmap(this.v.outWidth, this.v.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      a(paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label155;
    }
    this.v.inJustDecodeBounds = false;
    this.v.inBitmap = paramBitmap;
    this.v.inSampleSize = 1;
    this.v.inDensity = 320;
    this.v.inTargetDensity = this.d;
    BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.v);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label155:
      a("getBitmapFromFile OOM");
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.v.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.v);
      if (QLog.isDevelopLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getBitmapFromFile ");
        paramBitmap.append(paramString);
        paramBitmap.append(" ");
        paramBitmap.append(this.v.outWidth);
        paramBitmap.append("——");
        paramBitmap.append(this.v.outHeight);
        QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      }
      Bitmap.createBitmap(this.v.outWidth, this.v.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      a(paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      break label223;
    }
    this.v.inJustDecodeBounds = false;
    this.v.inBitmap = paramBitmap;
    this.v.inSampleSize = 1;
    this.v.inDensity = 320;
    this.v.inTargetDensity = this.d;
    BitmapFactory.decodeFile(paramString, this.v);
    if (QLog.isDevelopLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("getBitmapFromFile ");
      paramBitmap.append(System.currentTimeMillis() - paramLong);
      QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      return;
      label223:
      a("getBitmapFromFile OOM");
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("QQAnimationDrawable", 4, paramString);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = this.a;
    boolean bool = true;
    int i2 = i1 + 1;
    i1 = i2;
    if (i2 >= this.k) {
      i1 = 0;
    }
    if (paramBoolean2) {
      unscheduleSelf(this);
    }
    if (((this.l) || (this.n <= 0)) && (i1 >= this.k - 1)) {
      paramBoolean2 = bool;
    } else {
      paramBoolean2 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("animation QQAnimationDrawable loadNextBitmap  playEnd:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(",mDecodeNextFrameEnd:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(",animate:");
    localStringBuilder.append(paramBoolean3);
    QLog.d("QQAnimationDrawable", 4, localStringBuilder.toString());
    if ((!paramBoolean2) && (this.r) && (paramBoolean3))
    {
      this.r = false;
      long l1;
      if (paramBoolean1) {
        l1 = 0L;
      } else {
        l1 = SystemClock.uptimeMillis() + this.G;
      }
      this.s = new QQAnimationDrawable.WorkerRunnable(this, i1, l1);
      this.I.execute(this.s);
    }
    b(paramBoolean2);
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i1 < 19)
    {
      bool1 = bool2;
      if (paramBitmap.getWidth() == paramOptions.outWidth)
      {
        bool1 = bool2;
        if (paramBitmap.getHeight() == paramOptions.outHeight)
        {
          bool1 = bool2;
          if (paramOptions.inSampleSize == 1) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
      bool1 = true;
    }
    return bool1;
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokespecial 413	com/tencent/mobileqq/bubble/QQAnimationDrawable:c	(I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 9
    //   18: areturn
    //   19: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   22: lstore 7
    //   24: aload_0
    //   25: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   28: iconst_1
    //   29: putfield 241	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   32: aload_0
    //   33: getfield 415	com/tencent/mobileqq/bubble/QQAnimationDrawable:A	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   40: invokestatic 250	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: pop
    //   44: aload_0
    //   45: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   48: getfield 215	android/graphics/BitmapFactory$Options:outWidth	I
    //   51: i2f
    //   52: aload_0
    //   53: getfield 417	com/tencent/mobileqq/bubble/QQAnimationDrawable:B	I
    //   56: i2f
    //   57: fconst_1
    //   58: fmul
    //   59: fdiv
    //   60: f2i
    //   61: istore 5
    //   63: aload_0
    //   64: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   67: getfield 212	android/graphics/BitmapFactory$Options:outHeight	I
    //   70: i2f
    //   71: aload_0
    //   72: getfield 419	com/tencent/mobileqq/bubble/QQAnimationDrawable:C	I
    //   75: i2f
    //   76: fconst_1
    //   77: fmul
    //   78: fdiv
    //   79: f2i
    //   80: istore 6
    //   82: aload_0
    //   83: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   86: iconst_0
    //   87: putfield 241	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   90: aload_0
    //   91: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   94: sipush 320
    //   97: putfield 309	android/graphics/BitmapFactory$Options:inDensity	I
    //   100: aload_0
    //   101: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   104: aload_0
    //   105: getfield 114	com/tencent/mobileqq/bubble/QQAnimationDrawable:d	I
    //   108: putfield 312	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   111: aload_0
    //   112: getfield 415	com/tencent/mobileqq/bubble/QQAnimationDrawable:A	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:v	Landroid/graphics/BitmapFactory$Options;
    //   119: invokestatic 250	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: astore 9
    //   124: iconst_0
    //   125: istore_3
    //   126: iload_3
    //   127: aload_0
    //   128: getfield 419	com/tencent/mobileqq/bubble/QQAnimationDrawable:C	I
    //   131: if_icmpge +104 -> 235
    //   134: iconst_0
    //   135: istore 4
    //   137: iload 4
    //   139: aload_0
    //   140: getfield 417	com/tencent/mobileqq/bubble/QQAnimationDrawable:B	I
    //   143: if_icmpge +229 -> 372
    //   146: aload 9
    //   148: iload 4
    //   150: iload 5
    //   152: imul
    //   153: iload_3
    //   154: iload 6
    //   156: imul
    //   157: iload 5
    //   159: iload 6
    //   161: aconst_null
    //   162: iconst_1
    //   163: invokestatic 422	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   166: astore 10
    //   168: aload 10
    //   170: ifnull +193 -> 363
    //   173: invokestatic 317	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   176: ifeq +46 -> 222
    //   179: new 319	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   186: astore 11
    //   188: aload 11
    //   190: ldc_w 424
    //   193: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: iload_3
    //   200: bipush 8
    //   202: imul
    //   203: iload 4
    //   205: iadd
    //   206: invokevirtual 351	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc_w 331
    //   213: iconst_4
    //   214: aload 11
    //   216: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 338	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 128	com/tencent/mobileqq/bubble/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   226: aload 10
    //   228: invokevirtual 425	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: goto +131 -> 363
    //   235: aload 9
    //   237: ifnull +16 -> 253
    //   240: aload 9
    //   242: invokevirtual 272	android/graphics/Bitmap:isRecycled	()Z
    //   245: ifne +8 -> 253
    //   248: aload 9
    //   250: invokevirtual 428	android/graphics/Bitmap:recycle	()V
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 128	com/tencent/mobileqq/bubble/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   258: invokevirtual 431	java/util/ArrayList:size	()I
    //   261: putfield 100	com/tencent/mobileqq/bubble/QQAnimationDrawable:k	I
    //   264: new 319	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   271: astore 9
    //   273: aload 9
    //   275: ldc_w 433
    //   278: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   287: lload 7
    //   289: lsub
    //   290: invokevirtual 329	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: aload 9
    //   297: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 435	com/tencent/mobileqq/bubble/QQAnimationDrawable:b	(Ljava/lang/String;)V
    //   303: goto +24 -> 327
    //   306: aload_0
    //   307: ldc_w 340
    //   310: invokespecial 343	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Ljava/lang/String;)V
    //   313: goto +14 -> 327
    //   316: astore 9
    //   318: aload_0
    //   319: aload 9
    //   321: invokevirtual 346	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokespecial 343	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 128	com/tencent/mobileqq/bubble/QQAnimationDrawable:y	Ljava/util/ArrayList;
    //   331: iload_2
    //   332: invokevirtual 438	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   335: checkcast 238	android/graphics/Bitmap
    //   338: astore 9
    //   340: aload_0
    //   341: monitorexit
    //   342: aload 9
    //   344: areturn
    //   345: astore 9
    //   347: aload_0
    //   348: monitorexit
    //   349: goto +6 -> 355
    //   352: aload 9
    //   354: athrow
    //   355: goto -3 -> 352
    //   358: astore 9
    //   360: goto -54 -> 306
    //   363: iload 4
    //   365: iconst_1
    //   366: iadd
    //   367: istore 4
    //   369: goto -232 -> 137
    //   372: iload_3
    //   373: iconst_1
    //   374: iadd
    //   375: istore_3
    //   376: goto -250 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	QQAnimationDrawable
    //   0	379	1	paramBoolean	boolean
    //   0	379	2	paramInt	int
    //   125	251	3	i1	int
    //   135	233	4	i2	int
    //   61	97	5	i3	int
    //   80	80	6	i4	int
    //   22	266	7	l1	long
    //   7	289	9	localObject1	Object
    //   316	4	9	localException	Exception
    //   338	5	9	localBitmap1	Bitmap
    //   345	8	9	localObject2	Object
    //   358	1	9	localOutOfMemoryError	OutOfMemoryError
    //   166	61	10	localBitmap2	Bitmap
    //   186	29	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	124	316	java/lang/Exception
    //   126	134	316	java/lang/Exception
    //   137	168	316	java/lang/Exception
    //   173	222	316	java/lang/Exception
    //   222	232	316	java/lang/Exception
    //   240	253	316	java/lang/Exception
    //   253	303	316	java/lang/Exception
    //   2	9	345	finally
    //   19	124	345	finally
    //   126	134	345	finally
    //   137	168	345	finally
    //   173	222	345	finally
    //   222	232	345	finally
    //   240	253	345	finally
    //   253	303	345	finally
    //   306	313	345	finally
    //   318	327	345	finally
    //   327	340	345	finally
    //   19	124	358	java/lang/OutOfMemoryError
    //   126	134	358	java/lang/OutOfMemoryError
    //   137	168	358	java/lang/OutOfMemoryError
    //   173	222	358	java/lang/OutOfMemoryError
    //   222	232	358	java/lang/OutOfMemoryError
    //   240	253	358	java/lang/OutOfMemoryError
    //   253	303	358	java/lang/OutOfMemoryError
  }
  
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l1;
    label148:
    try
    {
      if (this.t != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.t.length)
        {
          l1 = System.currentTimeMillis();
          paramInt = this.t[paramInt];
          localObject = paramBitmap;
          if (paramInt > 0) {
            if (this.x)
            {
              localObject = (SoftReference)this.z.get(Integer.valueOf(paramInt));
              if ((localObject != null) && (((SoftReference)localObject).get() != null))
              {
                paramBitmap = (Bitmap)((SoftReference)localObject).get();
                return paramBitmap;
              }
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt);
      paramBitmap = (Bitmap)localObject;
      this.z.put(String.valueOf(paramInt), new SoftReference(localObject));
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap = paramBitmap;
      break label148;
    }
    a(this.c, l1, paramInt);
    localObject = this.c;
    return localObject;
  }
  
  private void b(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQAnimationDrawable", 4, paramString);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playEnd mCountOfFrame");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      stop();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("playEnd listener");
      if (this.D != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      localObject = this.D;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).a();
      }
    }
  }
  
  @Nullable
  private Bitmap c(int paramInt)
  {
    if (paramInt < this.y.size())
    {
      Bitmap localBitmap = (Bitmap)this.y.get(paramInt);
      if (localBitmap != null) {
        return localBitmap;
      }
    }
    return null;
  }
  
  private void f()
  {
    long l2 = this.G;
    long l1 = 0L;
    if (l2 == 0L)
    {
      int i1 = this.H;
      if (i1 != 0) {
        l1 = this.o / i1;
      }
      this.G = l1;
      return;
    }
    if (this.o == 0L) {
      this.o = (l2 * this.H);
    }
  }
  
  private void g()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((Iterator)localObject).next();
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
      }
      this.y.clear();
    }
  }
  
  private void h()
  {
    Object localObject1 = this.z;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (SoftReference)this.z.get(localObject2);
        if (localObject2 != null)
        {
          localObject2 = (Bitmap)((SoftReference)localObject2).get();
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
            ((Bitmap)localObject2).recycle();
          }
        }
      }
      this.z.clear();
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    Object localObject1 = this.K;
    Object localObject2 = null;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
      synchronized (this.K)
      {
        Iterator localIterator = this.K.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Bitmap)((SoftReference)localIterator.next()).get();
          if ((localObject1 != null) && (((Bitmap)localObject1).isMutable()))
          {
            if (a((Bitmap)localObject1, paramOptions))
            {
              localIterator.remove();
              break;
            }
          }
          else {
            localIterator.remove();
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  Bitmap a(boolean paramBoolean, int paramInt)
  {
    int i1 = this.w;
    Bitmap localBitmap = null;
    if (i1 == 0) {
      localBitmap = a(paramBoolean, paramInt, null);
    } else if (i1 == 2) {
      localBitmap = b(paramBoolean, paramInt, null);
    } else if (i1 == 1) {
      localBitmap = b(paramBoolean, paramInt);
    }
    if (localBitmap == null) {
      return this.c;
    }
    return localBitmap;
  }
  
  public void a(int paramInt)
  {
    this.m = false;
    this.n = paramInt;
    paramInt = this.n;
    if (paramInt > 1) {
      a(false);
    } else if (paramInt == 1) {
      a(true);
    }
    start();
  }
  
  public void a(long paramLong)
  {
    this.o = paramLong;
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(0);
    if (!Arrays.equals(this.u, paramArrayOfString))
    {
      e();
      this.u = paramArrayOfString;
    }
    String[] arrayOfString = this.u;
    if (arrayOfString != null) {
      this.k = arrayOfString.length;
    } else {
      this.k = 0;
    }
    this.H = paramArrayOfString.length;
    f();
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQAnimationDrawable", 4, " reset");
    }
    this.n = 1;
    this.a = -1;
    this.q = 0;
    this.c = null;
    this.p = null;
    c();
  }
  
  public void b(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void c()
  {
    if (this.I != null) {
      this.I.b();
    }
    FutureTask localFutureTask = this.J;
    if (localFutureTask != null) {
      localFutureTask.cancel(true);
    }
  }
  
  public void d() {}
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.p == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)???).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)???).toString());
    synchronized (this.F)
    {
      if ((this.p != null) && (!this.p.isRecycled())) {
        paramCanvas.drawBitmap(this.p, null, getBounds(), this.j);
      }
      a(false, false, true);
      return;
    }
  }
  
  public void e()
  {
    try
    {
      if ((this.b != null) && (!this.b.isRecycled())) {
        this.b.recycle();
      }
      if ((this.p != null) && (!this.p.isRecycled())) {
        synchronized (this.F)
        {
          this.p.recycle();
        }
      }
      if ((this.c != null) && (!this.c.isRecycled())) {
        this.c.recycle();
      }
      g();
      h();
      return;
    }
    finally {}
  }
  
  public int getIntrinsicHeight()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      return localBitmap.getScaledHeight(this.d);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      return localBitmap.getScaledWidth(this.d);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.a > -1;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("animation QQAnimationDrawable run time:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
    ((StringBuilder)localObject).append(",mCurFrame:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("nextFrame:");
    ((StringBuilder)localObject).append(this.q);
    ((StringBuilder)localObject).append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (!this.E) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isParenMethod:");
    ((StringBuilder)localObject).append(this.m);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if ((!this.m) && (this.a == a() - 1)) {
      this.n -= 1;
    }
    this.r = true;
    localObject = this.c;
    if (localObject != null) {
      this.p = ((Bitmap)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mRepeatCount:");
    ((StringBuilder)localObject).append(this.n);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (this.a == -1)
    {
      localObject = this.D;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).b();
      }
    }
    this.a = this.q;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.j.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.j.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.j.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.j.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2))
      {
        d();
        return bool;
      }
    }
    else {
      unscheduleSelf(this);
    }
    return bool;
  }
  
  public void start()
  {
    this.E = true;
    if (this.k > 0)
    {
      if (this.G <= 0L) {
        return;
      }
      if (!isRunning())
      {
        this.r = true;
        a(true, false, true);
      }
    }
  }
  
  public void stop()
  {
    this.E = false;
    QLog.d("QQAnimationDrawable", 4, " stop");
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.m) {
      this.n = 1;
    }
    b();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.a = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */