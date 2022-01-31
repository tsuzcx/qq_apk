package com.tencent.mobileqq.bubble;

import abta;
import abtd;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
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
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
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
  private static volatile abta jdField_a_of_type_Abta;
  public static final ExecutorService a;
  public static byte[] a;
  protected int a;
  private long jdField_a_of_type_Long;
  private abtd jdField_a_of_type_Abtd;
  private Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private QQAnimationDrawable.QQAnimationListener jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Set jdField_a_of_type_JavaUtilSet;
  private FutureTask jdField_a_of_type_JavaUtilConcurrentFutureTask;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  public Bitmap b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    jdField_a_of_type_Abta = new abta(null);
    jdField_a_of_type_ArrayOfByte = new byte[24576];
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
  
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    long l;
    String str;
    label242:
    label251:
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
            if (!this.jdField_d_of_type_Boolean) {
              break label251;
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
      paramInt = EditGifImage.a((BitmapFactory.Options)localObject, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        a((BitmapFactory.Options)localObject);
      }
      localObject = ImageUtil.a(str, (BitmapFactory.Options)localObject);
      paramBitmap = (Bitmap)localObject;
      if (localObject != null) {
        paramBitmap = (Bitmap)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label242;
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
      break label242;
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
      BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
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
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
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
    int i = this.jdField_a_of_type_Int + 1;
    if (i >= this.jdField_c_of_type_Int) {
      i = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      if (((this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (i >= this.jdField_c_of_type_Int - 1))
      {
        paramBoolean2 = true;
        QLog.d("QQAnimationDrawable", 4, "animation QQAnimationDrawable loadNextBitmap  playEnd:" + paramBoolean2 + ",mDecodeNextFrameEnd:" + this.jdField_c_of_type_Boolean + ",animate:" + paramBoolean3);
        if ((!paramBoolean2) && (this.jdField_c_of_type_Boolean) && (paramBoolean3))
        {
          this.jdField_c_of_type_Boolean = false;
          if (!paramBoolean1) {
            break label188;
          }
        }
      }
      label188:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Abtd = new abtd(this, i, l);
        jdField_a_of_type_Abta.execute(this.jdField_a_of_type_Abtd);
        if (paramBoolean2)
        {
          stop();
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.a();
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
    //   4: getfield 335	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 340	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 335	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 343	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 107	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 114	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 345	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 123	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 197	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 347	com/tencent/mobileqq/bubble/QQAnimationDrawable:g	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 200	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 349	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 114	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 210	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 212	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   125: putfield 215	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 345	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 190	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 123	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 349	com/tencent/mobileqq/bubble/QQAnimationDrawable:h	I
    //   148: if_icmpge +93 -> 241
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 347	com/tencent/mobileqq/bubble/QQAnimationDrawable:g	I
    //   160: if_icmpge +220 -> 380
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
    //   180: invokestatic 352	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +184 -> 371
    //   190: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +35 -> 228
    //   196: ldc 222
    //   198: iconst_4
    //   199: new 224	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 354
    //   209: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_3
    //   213: bipush 8
    //   215: imul
    //   216: iload 4
    //   218: iadd
    //   219: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 335	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   232: aload 10
    //   234: invokevirtual 355	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: goto +133 -> 371
    //   241: aload 9
    //   243: ifnull +16 -> 259
    //   246: aload 9
    //   248: invokevirtual 169	android/graphics/Bitmap:isRecycled	()Z
    //   251: ifne +8 -> 259
    //   254: aload 9
    //   256: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 335	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   264: invokevirtual 340	java/util/ArrayList:size	()I
    //   267: putfield 269	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   270: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   273: ifeq +34 -> 307
    //   276: ldc 222
    //   278: iconst_4
    //   279: new 224	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 360
    //   289: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   295: lload 7
    //   297: lsub
    //   298: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_0
    //   308: getfield 335	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   311: iload_2
    //   312: invokevirtual 343	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   315: checkcast 107	android/graphics/Bitmap
    //   318: astore 9
    //   320: goto -289 -> 31
    //   323: astore 9
    //   325: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   328: ifeq -21 -> 307
    //   331: ldc 222
    //   333: iconst_4
    //   334: aload 9
    //   336: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   339: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: goto -35 -> 307
    //   345: astore 9
    //   347: aload_0
    //   348: monitorexit
    //   349: aload 9
    //   351: athrow
    //   352: astore 9
    //   354: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   357: ifeq -50 -> 307
    //   360: ldc 222
    //   362: iconst_4
    //   363: ldc 248
    //   365: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -61 -> 307
    //   371: iload 4
    //   373: iconst_1
    //   374: iadd
    //   375: istore 4
    //   377: goto -223 -> 154
    //   380: iload_3
    //   381: iconst_1
    //   382: iadd
    //   383: istore_3
    //   384: goto -241 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	QQAnimationDrawable
    //   0	387	1	paramBoolean	boolean
    //   0	387	2	paramInt	int
    //   142	242	3	i	int
    //   152	224	4	j	int
    //   78	97	5	k	int
    //   97	80	6	m	int
    //   39	257	7	l	long
    //   24	295	9	localBitmap1	Bitmap
    //   323	12	9	localException	Exception
    //   345	5	9	localObject	Object
    //   352	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	50	10	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   36	141	323	java/lang/Exception
    //   143	151	323	java/lang/Exception
    //   154	185	323	java/lang/Exception
    //   190	228	323	java/lang/Exception
    //   228	238	323	java/lang/Exception
    //   246	259	323	java/lang/Exception
    //   259	307	323	java/lang/Exception
    //   2	26	345	finally
    //   36	141	345	finally
    //   143	151	345	finally
    //   154	185	345	finally
    //   190	228	345	finally
    //   228	238	345	finally
    //   246	259	345	finally
    //   259	307	345	finally
    //   307	320	345	finally
    //   325	342	345	finally
    //   354	368	345	finally
    //   36	141	352	java/lang/OutOfMemoryError
    //   143	151	352	java/lang/OutOfMemoryError
    //   154	185	352	java/lang/OutOfMemoryError
    //   190	228	352	java/lang/OutOfMemoryError
    //   228	238	352	java/lang/OutOfMemoryError
    //   246	259	352	java/lang/OutOfMemoryError
    //   259	307	352	java/lang/OutOfMemoryError
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
    //   6: getfield 362	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   9: ifnull +122 -> 131
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 362	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   20: arraylength
    //   21: if_icmpge +110 -> 131
    //   24: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 362	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 6
    //   39: iload_2
    //   40: ifle +91 -> 131
    //   43: aload_0
    //   44: getfield 92	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_d_of_type_Boolean	Z
    //   47: ifeq +90 -> 137
    //   50: aload_0
    //   51: getfield 94	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 368	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 102	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 105	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 105	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 107	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: aload_0
    //   93: getfield 125	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   96: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   99: iload_2
    //   100: invokestatic 371	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   103: astore 6
    //   105: aload 6
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 94	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: iload_2
    //   113: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   116: new 102	java/lang/ref/SoftReference
    //   119: dup
    //   120: aload_3
    //   121: invokespecial 174	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   124: invokevirtual 380	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_3
    //   129: astore 6
    //   131: aload 6
    //   133: astore_3
    //   134: goto -46 -> 88
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 182	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   142: lload 4
    //   144: iload_2
    //   145: invokespecial 382	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   148: aload_0
    //   149: getfield 182	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   152: astore 6
    //   154: goto -23 -> 131
    //   157: astore_3
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_3
    //   161: athrow
    //   162: astore 6
    //   164: goto -36 -> 128
    //   167: astore 6
    //   169: goto -41 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	QQAnimationDrawable
    //   0	172	1	paramBoolean	boolean
    //   0	172	2	paramInt	int
    //   0	172	3	paramBitmap	Bitmap
    //   27	116	4	l	long
    //   3	150	6	localObject	Object
    //   162	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   167	1	6	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	12	157	finally
    //   15	36	157	finally
    //   43	66	157	finally
    //   71	88	157	finally
    //   92	105	157	finally
    //   108	128	157	finally
    //   137	154	157	finally
    //   92	105	162	java/lang/OutOfMemoryError
    //   108	128	167	java/lang/OutOfMemoryError
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
  
  public Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.f == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      return localBitmap2;
      if (this.f == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.f == 1) {
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
  
  public void b()
  {
    if (jdField_a_of_type_Abta != null) {
      jdField_a_of_type_Abta.b();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFutureTask != null) {
      this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(true);
    }
  }
  
  public void c() {}
  
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
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      return;
    }
    QLog.d("QQAnimationDrawable", 4, "isParenMethod:" + this.jdField_b_of_type_Boolean);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    QLog.d("QQAnimationDrawable", 4, "mRepeatCount:" + this.jdField_d_of_type_Int);
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.b();
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
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_Long <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    a(true, false, true);
  }
  
  public void stop()
  {
    this.jdField_e_of_type_Boolean = false;
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.jdField_b_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */