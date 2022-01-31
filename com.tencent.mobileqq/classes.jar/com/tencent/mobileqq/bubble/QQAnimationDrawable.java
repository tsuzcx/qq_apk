package com.tencent.mobileqq.bubble;

import alog;
import aloh;
import aloi;
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
import bacm;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.common.app.BaseApplicationImpl;
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

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  private static volatile aloi jdField_a_of_type_Aloi;
  public static final ExecutorService a;
  public static byte[] a;
  protected int a;
  private long jdField_a_of_type_Long;
  final alog jdField_a_of_type_Alog = new alog(this, this);
  private aloh jdField_a_of_type_Aloh;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
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
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = 2;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  private int i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    jdField_a_of_type_Aloi = new aloi(null);
    jdField_a_of_type_ArrayOfByte = new byte[24576];
  }
  
  public QQAnimationDrawable()
  {
    this(null);
  }
  
  public QQAnimationDrawable(aloh paramaloh)
  {
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_Aloh = paramaloh;
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
      }
      return;
      j = this.jdField_b_of_type_Int;
    }
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    int k = 2;
    int j;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      j = 4;
    }
    do
    {
      do
      {
        return j;
        j = k;
      } while (paramConfig == Bitmap.Config.RGB_565);
      j = k;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l;
    String str;
    label240:
    label249:
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
          if (str != null)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break label249;
            }
            localObject = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(str);
            if ((localObject != null) && (((SoftReference)localObject).get() != null))
            {
              paramBitmap = (Bitmap)((SoftReference)localObject).get();
              return paramBitmap;
            }
          }
        }
      }
    }
    finally {}
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inTempStorage = jdField_a_of_type_ArrayOfByte;
      BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      paramInt = EditGifImage.a((BitmapFactory.Options)localObject, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().heightPixels);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        a((BitmapFactory.Options)localObject);
      }
      localObject = bacm.a(str, (BitmapFactory.Options)localObject);
      paramBitmap = (Bitmap)localObject;
      if (localObject != null) {
        paramBitmap = (Bitmap)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label240;
    }
    try
    {
      if (!((Bitmap)localObject).isRecycled())
      {
        paramBitmap = (Bitmap)localObject;
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(localObject));
          paramBitmap = (Bitmap)localObject;
        }
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap = localOutOfMemoryError;
      break label240;
    }
    for (localObject = paramBitmap;; localObject = this.jdField_b_of_type_AndroidGraphicsBitmap)
    {
      paramBitmap = (Bitmap)localObject;
      break;
      a(this.jdField_b_of_type_AndroidGraphicsBitmap, l, str);
    }
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
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
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
      if (QLog.isDevelopLevel()) {
        QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + paramString + " " + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth + "——" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e("QQAnimationDrawable", 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQAnimationDrawable", 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_a_of_type_Int + 1;
    if (j >= this.jdField_c_of_type_Int) {
      j = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (j >= this.jdField_c_of_type_Int - 1))
      {
        paramBoolean2 = true;
        QLog.d("QQAnimationDrawable", 4, "animation QQAnimationDrawable loadNextBitmap  playEnd:" + paramBoolean2 + ",mDecodeNextFrameEnd:" + this.jdField_e_of_type_Boolean + ",animate:" + paramBoolean3);
        if ((!paramBoolean2) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
        {
          this.jdField_e_of_type_Boolean = false;
          if (!paramBoolean1) {
            break label189;
          }
        }
      }
      label189:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.jdField_b_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable = new QQAnimationDrawable.WorkerRunnable(this, j, l);
        jdField_a_of_type_Aloi.execute(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$WorkerRunnable);
        if (paramBoolean2)
        {
          stop();
          if (this.jdField_a_of_type_Aloh != null) {
            this.jdField_a_of_type_Aloh.a();
          }
        }
        return;
        paramBoolean2 = false;
        break;
      }
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
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 392	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 395	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 202	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 205	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 214	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 263	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 399	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 266	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 401	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 205	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 276	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 87	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   125: putfield 279	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 214	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 401	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   148: if_icmpge +94 -> 242
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 399	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_g_of_type_Int	I
    //   160: if_icmpge +225 -> 385
    //   163: aload 9
    //   165: iload 4
    //   167: iload 5
    //   169: imul
    //   170: iload_3
    //   171: iload 6
    //   173: imul
    //   174: iload 5
    //   176: iload 6
    //   178: aconst_null
    //   179: iconst_1
    //   180: invokestatic 404	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +189 -> 376
    //   190: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: ldc_w 286
    //   199: iconst_4
    //   200: new 288	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 406
    //   210: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_3
    //   214: bipush 8
    //   216: imul
    //   217: iload 4
    //   219: iadd
    //   220: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   233: aload 10
    //   235: invokevirtual 407	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   238: pop
    //   239: goto +137 -> 376
    //   242: aload 9
    //   244: ifnull +16 -> 260
    //   247: aload 9
    //   249: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   252: ifne +8 -> 260
    //   255: aload 9
    //   257: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   265: invokevirtual 392	java/util/ArrayList:size	()I
    //   268: putfield 331	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   271: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   274: ifeq +35 -> 309
    //   277: ldc_w 286
    //   280: iconst_4
    //   281: new 288	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 412
    //   291: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   297: lload 7
    //   299: lsub
    //   300: invokevirtual 298	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   303: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   313: iload_2
    //   314: invokevirtual 395	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   317: checkcast 202	android/graphics/Bitmap
    //   320: astore 9
    //   322: goto -291 -> 31
    //   325: astore 9
    //   327: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   330: ifeq -21 -> 309
    //   333: ldc_w 286
    //   336: iconst_4
    //   337: aload 9
    //   339: invokevirtual 308	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -36 -> 309
    //   348: astore 9
    //   350: aload_0
    //   351: monitorexit
    //   352: aload 9
    //   354: athrow
    //   355: astore 9
    //   357: invokestatic 284	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   360: ifeq -51 -> 309
    //   363: ldc_w 286
    //   366: iconst_4
    //   367: ldc_w 312
    //   370: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: goto -64 -> 309
    //   376: iload 4
    //   378: iconst_1
    //   379: iadd
    //   380: istore 4
    //   382: goto -228 -> 154
    //   385: iload_3
    //   386: iconst_1
    //   387: iadd
    //   388: istore_3
    //   389: goto -246 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	QQAnimationDrawable
    //   0	392	1	paramBoolean	boolean
    //   0	392	2	paramInt	int
    //   142	247	3	j	int
    //   152	229	4	k	int
    //   78	97	5	m	int
    //   97	80	6	n	int
    //   39	259	7	l	long
    //   24	297	9	localBitmap1	Bitmap
    //   325	13	9	localException	Exception
    //   348	5	9	localObject	Object
    //   355	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	51	10	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   36	141	325	java/lang/Exception
    //   143	151	325	java/lang/Exception
    //   154	185	325	java/lang/Exception
    //   190	229	325	java/lang/Exception
    //   229	239	325	java/lang/Exception
    //   247	260	325	java/lang/Exception
    //   260	309	325	java/lang/Exception
    //   2	26	348	finally
    //   36	141	348	finally
    //   143	151	348	finally
    //   154	185	348	finally
    //   190	229	348	finally
    //   229	239	348	finally
    //   247	260	348	finally
    //   260	309	348	finally
    //   309	322	348	finally
    //   327	345	348	finally
    //   357	373	348	finally
    //   36	141	355	java/lang/OutOfMemoryError
    //   143	151	355	java/lang/OutOfMemoryError
    //   154	185	355	java/lang/OutOfMemoryError
    //   190	229	355	java/lang/OutOfMemoryError
    //   229	239	355	java/lang/OutOfMemoryError
    //   247	260	355	java/lang/OutOfMemoryError
    //   260	309	355	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 414	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   9: ifnull +121 -> 130
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 414	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   20: arraylength
    //   21: if_icmpge +109 -> 130
    //   24: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 414	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 6
    //   39: iload_2
    //   40: ifle +90 -> 130
    //   43: aload_0
    //   44: getfield 96	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_f_of_type_Boolean	Z
    //   47: ifeq +89 -> 136
    //   50: aload_0
    //   51: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 420	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 197	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 200	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 200	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 202	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: invokestatic 128	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   95: invokevirtual 132	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   98: iload_2
    //   99: invokestatic 423	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   102: astore 6
    //   104: aload 6
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   111: iload_2
    //   112: invokestatic 428	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: new 197	java/lang/ref/SoftReference
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 242	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   123: invokevirtual 432	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_3
    //   128: astore 6
    //   130: aload 6
    //   132: astore_3
    //   133: goto -45 -> 88
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 250	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   141: lload 4
    //   143: iload_2
    //   144: invokespecial 434	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   147: aload_0
    //   148: getfield 250	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   151: astore 6
    //   153: goto -23 -> 130
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    //   161: astore 6
    //   163: goto -36 -> 127
    //   166: astore 6
    //   168: goto -41 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	QQAnimationDrawable
    //   0	171	1	paramBoolean	boolean
    //   0	171	2	paramInt	int
    //   0	171	3	paramBitmap	Bitmap
    //   27	115	4	l	long
    //   3	149	6	localObject	Object
    //   161	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   166	1	6	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	12	156	finally
    //   15	36	156	finally
    //   43	66	156	finally
    //   71	88	156	finally
    //   92	104	156	finally
    //   107	127	156	finally
    //   136	153	156	finally
    //   92	104	161	java/lang/OutOfMemoryError
    //   107	127	166	java/lang/OutOfMemoryError
  }
  
  private void e()
  {
    long l = 0L;
    if (this.jdField_b_of_type_Long == 0L) {
      if (this.i == 0) {
        this.jdField_b_of_type_Long = l;
      }
    }
    while (this.jdField_a_of_type_Long != 0L) {
      for (;;)
      {
        return;
        l = this.jdField_a_of_type_Long / this.i;
      }
    }
    this.jdField_a_of_type_Long = (this.jdField_b_of_type_Long * this.i);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
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
  
  Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.jdField_f_of_type_Int == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      return localBitmap2;
      if (this.jdField_f_of_type_Int == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.jdField_f_of_type_Int == 1) {
        localBitmap1 = b(paramBoolean, paramInt);
      }
    }
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
    if (this.jdField_d_of_type_Int > 1) {
      a(false);
    }
    for (;;)
    {
      start();
      return;
      if (this.jdField_d_of_type_Int == 1) {
        a(true);
      }
    }
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
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {}
    for (this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;; this.jdField_c_of_type_Int = 0)
    {
      this.i = paramArrayOfString.length;
      e();
      return;
    }
  }
  
  public void b()
  {
    if (jdField_a_of_type_Aloi != null) {
      jdField_a_of_type_Aloi.b();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFutureTask != null) {
      this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(true);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void c() {}
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 504	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 504	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   13: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 504	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   23: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   26: aload_0
    //   27: getfield 471	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   30: ifnull +29 -> 59
    //   33: aload_0
    //   34: getfield 471	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   37: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 115	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 471	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   54: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 250	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   63: ifnull +20 -> 83
    //   66: aload_0
    //   67: getfield 250	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   70: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +10 -> 83
    //   76: aload_0
    //   77: getfield 250	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   83: aload_0
    //   84: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: invokevirtual 505	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 450 1 0
    //   104: ifeq +41 -> 145
    //   107: aload_1
    //   108: invokeinterface 453 1 0
    //   113: checkcast 202	android/graphics/Bitmap
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -20 -> 98
    //   121: aload_2
    //   122: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne -27 -> 98
    //   128: aload_2
    //   129: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 101	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: invokevirtual 508	java/util/ArrayList:clear	()V
    //   152: aload_0
    //   153: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   156: ifnull +84 -> 240
    //   159: aload_0
    //   160: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: invokevirtual 512	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 445 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 450 1 0
    //   178: ifeq +55 -> 233
    //   181: aload_1
    //   182: invokeinterface 453 1 0
    //   187: checkcast 425	java/lang/String
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: aload_2
    //   196: invokevirtual 195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 197	java/lang/ref/SoftReference
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -32 -> 172
    //   207: aload_2
    //   208: invokevirtual 200	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   211: checkcast 202	android/graphics/Bitmap
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: aload_2
    //   220: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
    //   223: ifne -51 -> 172
    //   226: aload_2
    //   227: invokevirtual 410	android/graphics/Bitmap:recycle	()V
    //   230: goto -58 -> 172
    //   233: aload_0
    //   234: getfield 106	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   237: invokevirtual 513	java/util/HashMap:clear	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQAnimationDrawable
    //   135	7	1	localObject2	Object
    //   171	11	1	localIterator	Iterator
    //   116	13	2	localBitmap	Bitmap
    //   140	4	2	localObject3	Object
    //   190	37	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	135	finally
    //   26	50	135	finally
    //   59	83	135	finally
    //   83	98	135	finally
    //   98	117	135	finally
    //   121	132	135	finally
    //   143	145	135	finally
    //   145	152	135	finally
    //   152	172	135	finally
    //   172	203	135	finally
    //   207	215	135	finally
    //   219	230	135	finally
    //   233	240	135	finally
    //   50	59	140	finally
    //   141	143	140	finally
  }
  
  public void draw(Canvas paramCanvas)
  {
    ??? = new StringBuilder().append("animation QQAnimationDrawable draw  currentBitmap == null ");
    boolean bool;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
      bool = true;
    }
    for (;;)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
          paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        a(false, false, true);
        return;
        bool = false;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledWidth(this.jdField_b_of_type_Int);
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
    StringBuilder localStringBuilder = new StringBuilder().append("animation QQAnimationDrawable run time:").append(SystemClock.uptimeMillis()).append(",mCurFrame:").append(this.jdField_a_of_type_Int).append("nextFrame:").append(this.jdField_e_of_type_Int).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 4, bool);
      if (this.jdField_g_of_type_Boolean) {
        break;
      }
      return;
    }
    QLog.d("QQAnimationDrawable", 4, "isParenMethod:" + this.jdField_d_of_type_Boolean);
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    QLog.d("QQAnimationDrawable", 4, "mRepeatCount:" + this.jdField_d_of_type_Int);
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_Aloh != null)) {
      this.jdField_a_of_type_Aloh.b();
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
      if ((bool) || (paramBoolean2)) {
        c();
      }
      return bool;
    }
    unscheduleSelf(this);
    return bool;
  }
  
  public void start()
  {
    this.jdField_g_of_type_Boolean = true;
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_b_of_type_Long <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(true, false, true);
  }
  
  public void stop()
  {
    this.jdField_g_of_type_Boolean = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */