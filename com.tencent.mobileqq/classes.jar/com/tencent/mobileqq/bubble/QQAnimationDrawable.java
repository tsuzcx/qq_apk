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
  public static final ExecutorService a;
  public static byte[] a;
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  final QQAnimationDrawable.InternalHandler jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$InternalHandler = new QQAnimationDrawable.InternalHandler(this, this);
  private QQAnimationDrawable.QQAnimationListener jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
  private volatile QQAnimationDrawable.SerialExecutor jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$SerialExecutor = new QQAnimationDrawable.SerialExecutor(null);
  private QQAnimationDrawable.WorkerRunnable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, SoftReference<Bitmap>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  private FutureTask<Bitmap> jdField_a_of_type_JavaUtilConcurrentFutureTask;
  boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int = 160;
  private long jdField_b_of_type_Long;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = 2;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int h;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_Int = -1;
    int k = this.jdField_b_of_type_Int;
    int j = k;
    if (k == 0) {
      j = 160;
    }
    this.jdField_b_of_type_Int = j;
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener = paramQQAnimationListener;
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
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
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    if ((k <= paramInt2) && (m <= paramInt1)) {
      return 1;
    }
    int j = 2;
    for (;;)
    {
      if ((k / j <= paramInt2) && (m / j <= paramInt1)) {
        return j;
      }
      j *= 2;
    }
  }
  
  @Nullable
  private Bitmap a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localBitmap != null) {
        return localBitmap;
      }
    }
    return null;
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    localObject = paramBitmap;
    long l;
    String str;
    label285:
    try
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          l = System.currentTimeMillis();
          str = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
          localObject = paramBitmap;
          if (str != null) {
            if (this.jdField_f_of_type_Boolean)
            {
              localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(str);
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
      ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
      localBitmap = paramBitmap;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      localBitmap = paramBitmap;
      paramInt = a((BitmapFactory.Options)localObject, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels);
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localBitmap = paramBitmap;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      localBitmap = paramBitmap;
      a((BitmapFactory.Options)localObject);
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
      this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(paramBitmap));
      localObject = paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      localObject = localBitmap;
      break label285;
    }
    a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, str);
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    return localObject;
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
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
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
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
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (QLog.isDevelopLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getBitmapFromFile ");
        paramBitmap.append(paramString);
        paramBitmap.append(" ");
        paramBitmap.append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth);
        paramBitmap.append("——");
        paramBitmap.append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
        QLog.d("QQAnimationDrawable", 4, paramBitmap.toString());
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
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
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
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
  
  private void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
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
    int j = this.jdField_a_of_type_Int;
    boolean bool = true;
    int k = j + 1;
    j = k;
    if (k >= this.jdField_c_of_type_Int) {
      j = 0;
    }
    if (paramBoolean2) {
      unscheduleSelf(this);
    }
    if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (j >= this.jdField_c_of_type_Int - 1)) {
      paramBoolean2 = bool;
    } else {
      paramBoolean2 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("animation QQAnimationDrawable loadNextBitmap  playEnd:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(",mDecodeNextFrameEnd:");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append(",animate:");
    localStringBuilder.append(paramBoolean3);
    QLog.d("QQAnimationDrawable", 4, localStringBuilder.toString());
    if ((!paramBoolean2) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
    {
      this.jdField_e_of_type_Boolean = false;
      long l;
      if (paramBoolean1) {
        l = 0L;
      } else {
        l = SystemClock.uptimeMillis() + this.jdField_b_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable = new QQAnimationDrawable.WorkerRunnable(this, j, l);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$SerialExecutor.execute(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable);
    }
    b(paramBoolean2);
  }
  
  @TargetApi(19)
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int j = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (j < 19)
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
    //   4: invokespecial 400	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 9
    //   18: areturn
    //   19: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   22: lstore 7
    //   24: aload_0
    //   25: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   28: iconst_1
    //   29: putfield 225	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   32: aload_0
    //   33: getfield 402	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   40: invokestatic 234	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: pop
    //   44: aload_0
    //   45: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   48: getfield 189	android/graphics/BitmapFactory$Options:outWidth	I
    //   51: i2f
    //   52: aload_0
    //   53: getfield 404	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   56: i2f
    //   57: fconst_1
    //   58: fmul
    //   59: fdiv
    //   60: f2i
    //   61: istore 5
    //   63: aload_0
    //   64: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   67: getfield 186	android/graphics/BitmapFactory$Options:outHeight	I
    //   70: i2f
    //   71: aload_0
    //   72: getfield 406	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   75: i2f
    //   76: fconst_1
    //   77: fmul
    //   78: fdiv
    //   79: f2i
    //   80: istore 6
    //   82: aload_0
    //   83: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   86: iconst_0
    //   87: putfield 225	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   90: aload_0
    //   91: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   94: sipush 320
    //   97: putfield 293	android/graphics/BitmapFactory$Options:inDensity	I
    //   100: aload_0
    //   101: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   104: aload_0
    //   105: getfield 88	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   108: putfield 296	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   111: aload_0
    //   112: getfield 402	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 93	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   119: invokestatic 234	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: astore 9
    //   124: iconst_0
    //   125: istore_3
    //   126: iload_3
    //   127: aload_0
    //   128: getfield 406	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   131: if_icmpge +104 -> 235
    //   134: iconst_0
    //   135: istore 4
    //   137: iload 4
    //   139: aload_0
    //   140: getfield 404	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_g_of_type_Int	I
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
    //   163: invokestatic 409	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   166: astore 10
    //   168: aload 10
    //   170: ifnull +193 -> 363
    //   173: invokestatic 301	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   176: ifeq +46 -> 222
    //   179: new 303	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   186: astore 11
    //   188: aload 11
    //   190: ldc_w 411
    //   193: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: iload_3
    //   200: bipush 8
    //   202: imul
    //   203: iload 4
    //   205: iadd
    //   206: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc_w 315
    //   213: iconst_4
    //   214: aload 11
    //   216: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 102	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   226: aload 10
    //   228: invokevirtual 412	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: goto +131 -> 363
    //   235: aload 9
    //   237: ifnull +16 -> 253
    //   240: aload 9
    //   242: invokevirtual 256	android/graphics/Bitmap:isRecycled	()Z
    //   245: ifne +8 -> 253
    //   248: aload 9
    //   250: invokevirtual 415	android/graphics/Bitmap:recycle	()V
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 102	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   258: invokevirtual 196	java/util/ArrayList:size	()I
    //   261: putfield 74	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   264: new 303	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   271: astore 9
    //   273: aload 9
    //   275: ldc_w 417
    //   278: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   287: lload 7
    //   289: lsub
    //   290: invokevirtual 313	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_0
    //   295: aload 9
    //   297: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 419	com/tencent/mobileqq/bubble/QQAnimationDrawable:b	(Ljava/lang/String;)V
    //   303: goto +24 -> 327
    //   306: aload_0
    //   307: ldc_w 324
    //   310: invokespecial 327	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Ljava/lang/String;)V
    //   313: goto +14 -> 327
    //   316: astore 9
    //   318: aload_0
    //   319: aload 9
    //   321: invokevirtual 330	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokespecial 327	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 102	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   331: iload_2
    //   332: invokevirtual 200	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   335: checkcast 202	android/graphics/Bitmap
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
    //   125	251	3	j	int
    //   135	233	4	k	int
    //   61	97	5	m	int
    //   80	80	6	n	int
    //   22	266	7	l	long
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
    long l;
    label148:
    try
    {
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        localObject = paramBitmap;
        if (paramInt < this.jdField_a_of_type_ArrayOfInt.length)
        {
          l = System.currentTimeMillis();
          paramInt = this.jdField_a_of_type_ArrayOfInt[paramInt];
          localObject = paramBitmap;
          if (paramInt > 0) {
            if (this.jdField_f_of_type_Boolean)
            {
              localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
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
      this.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(paramInt), new SoftReference(localObject));
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap = paramBitmap;
      break label148;
    }
    a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, paramInt);
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    return localObject;
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
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      stop();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("playEnd listener");
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("QQAnimationDrawable", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).a();
      }
    }
  }
  
  private void e()
  {
    long l2 = this.jdField_b_of_type_Long;
    long l1 = 0L;
    if (l2 == 0L)
    {
      int j = this.i;
      if (j != 0) {
        l1 = this.jdField_a_of_type_Long / j;
      }
      this.jdField_b_of_type_Long = l1;
      return;
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = (l2 * this.i);
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
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
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
        if (localObject2 != null)
        {
          localObject2 = (Bitmap)((SoftReference)localObject2).get();
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
            ((Bitmap)localObject2).recycle();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet;
    Object localObject2 = null;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
    int j = this.jdField_f_of_type_Int;
    Bitmap localBitmap = null;
    if (j == 0) {
      localBitmap = a(paramBoolean, paramInt, null);
    } else if (j == 2) {
      localBitmap = b(paramBoolean, paramInt, null);
    } else if (j == 1) {
      localBitmap = b(paramBoolean, paramInt);
    }
    if (localBitmap == null) {
      return this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    return localBitmap;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQAnimationDrawable", 4, " reset");
    }
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    paramInt = this.jdField_d_of_type_Int;
    if (paramInt > 1) {
      a(false);
    } else if (paramInt == 1) {
      a(true);
    }
    start();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(0);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfJavaLangString, paramArrayOfString))
    {
      d();
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (arrayOfString != null) {
      this.jdField_c_of_type_Int = arrayOfString.length;
    } else {
      this.jdField_c_of_type_Int = 0;
    }
    this.i = paramArrayOfString.length;
    e();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$SerialExecutor != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$SerialExecutor.b();
    }
    FutureTask localFutureTask = this.jdField_a_of_type_JavaUtilConcurrentFutureTask;
    if (localFutureTask != null) {
      localFutureTask.cancel(true);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void c() {}
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
        }
      }
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      f();
      g();
      return;
    }
    finally {}
  }
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)???).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)???).toString());
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      a(false, false, true);
      return;
    }
  }
  
  public int getIntrinsicHeight()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getScaledWidth(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append("animation QQAnimationDrawable run time:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
    ((StringBuilder)localObject).append(",mCurFrame:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("nextFrame:");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isParenMethod:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mRepeatCount:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    QLog.d("QQAnimationDrawable", 4, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == -1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
      if (localObject != null) {
        ((QQAnimationDrawable.QQAnimationListener)localObject).b();
      }
    }
    this.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2))
      {
        c();
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
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int > 0)
    {
      if (this.jdField_b_of_type_Long <= 0L) {
        return;
      }
      if (!isRunning())
      {
        this.jdField_e_of_type_Boolean = true;
        a(true, false, true);
      }
    }
  }
  
  public void stop()
  {
    this.jdField_g_of_type_Boolean = false;
    QLog.d("QQAnimationDrawable", 4, " stop");
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Int = 1;
    }
    a();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Int = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */