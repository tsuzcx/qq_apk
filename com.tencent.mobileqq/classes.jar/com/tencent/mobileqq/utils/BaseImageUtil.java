package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.IUtilApi;
import com.tencent.util.UtilApi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class BaseImageUtil
{
  static int a = 1280;
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i <= paramInt1) && (j <= paramInt2)) {
      return 1.0D;
    }
    double d1;
    double d2;
    if (i > j)
    {
      d1 = i / paramInt1;
      d2 = j / paramInt2;
    }
    else
    {
      d1 = j / paramInt1;
      d2 = i / paramInt2;
    }
    if (d1 > d2) {
      return d1;
    }
    return d2;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt < 100) {
      return 3;
    }
    if (paramInt < 140) {
      return 7;
    }
    return 10;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 1;
    int i = k;
    if (paramInt1 != 0)
    {
      i = k;
      if (paramInt2 != 0)
      {
        i = k;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          float f1 = paramOptions.outWidth * paramOptions.outHeight;
          float f2 = paramInt1 * paramInt2;
          paramInt1 = j;
          for (;;)
          {
            f1 /= f2;
            i = paramInt1;
            if (f1 <= 1.0F) {
              break;
            }
            paramInt1 *= 2;
            f2 = 4.0F;
          }
        }
      }
    }
    return i;
  }
  
  public static int a(ExifInterface paramExifInterface)
  {
    if (paramExifInterface != null)
    {
      i = paramExifInterface.getAttributeInt("Orientation", -1);
      paramExifInterface = new StringBuilder();
      paramExifInterface.append("getExifOrientation  orientation  =====");
      paramExifInterface.append(i);
      paramExifInterface.append("=====");
      f(paramExifInterface.toString());
      if (i != -1) {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i == 8)
            {
              i = 270;
              break label94;
            }
          }
          else
          {
            i = 90;
            break label94;
          }
        }
        else
        {
          i = 180;
          break label94;
        }
      }
    }
    int i = 0;
    label94:
    paramExifInterface = new StringBuilder();
    paramExifInterface.append("getExifOrientation degree =======");
    paramExifInterface.append(i);
    paramExifInterface.append("==========");
    f(paramExifInterface.toString());
    return i;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultTroopFaceNew");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = c(BitmapManager.b(BaseApplication.getContext().getResources(), 2130841349), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("static://DefaultTroopFaceNew", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  @TargetApi(17)
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return null;
    }
    Object localObject1 = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * paramFloat1), Math.round(paramBitmap.getHeight() * paramFloat1), false);
    paramBitmap = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject2 = RenderScript.create(paramContext);
    paramContext = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
    localObject1 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
    localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, paramBitmap);
    paramContext.setRadius(paramFloat2);
    paramContext.setInput((Allocation)localObject1);
    paramContext.forEach((Allocation)localObject2);
    ((Allocation)localObject2).copyTo(paramBitmap);
    return paramBitmap;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt1;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(paramInt2 * f1);
    return a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  /* Error */
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 215	android/util/TypedValue
    //   8: dup
    //   9: invokespecial 216	android/util/TypedValue:<init>	()V
    //   12: astore 5
    //   14: new 218	java/io/BufferedInputStream
    //   17: dup
    //   18: aload_0
    //   19: iload_1
    //   20: aload 5
    //   22: invokevirtual 222	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   25: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_2
    //   29: aload_0
    //   30: aload 5
    //   32: aload_2
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokestatic 231	android/graphics/BitmapFactory:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 236	java/io/InputStream:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_0
    //   46: goto +7 -> 53
    //   49: astore_0
    //   50: aload 4
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +7 -> 61
    //   57: aload_2
    //   58: invokevirtual 236	java/io/InputStream:close	()V
    //   61: aload_0
    //   62: athrow
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +19 -> 85
    //   69: aload_3
    //   70: astore_0
    //   71: goto -32 -> 39
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +8 -> 85
    //   80: aload_3
    //   81: astore_0
    //   82: goto -43 -> 39
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: goto -14 -> 74
    //   91: astore_0
    //   92: goto -29 -> 63
    //   95: astore_0
    //   96: goto -20 -> 76
    //   99: astore_0
    //   100: goto -35 -> 65
    //   103: astore_2
    //   104: aload_0
    //   105: areturn
    //   106: astore_2
    //   107: goto -46 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramResources	Resources
    //   0	110	1	paramInt	int
    //   28	49	2	localObject1	Object
    //   103	1	2	localIOException1	IOException
    //   106	1	2	localIOException2	IOException
    //   4	77	3	localObject2	Object
    //   1	50	4	localObject3	Object
    //   12	19	5	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   29	39	45	finally
    //   5	29	49	finally
    //   5	29	87	java/lang/OutOfMemoryError
    //   5	29	91	java/lang/Throwable
    //   29	39	95	java/lang/OutOfMemoryError
    //   29	39	99	java/lang/Throwable
    //   39	43	103	java/io/IOException
    //   57	61	106	java/io/IOException
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        ColorMatrix localColorMatrix = new ColorMatrix();
        localColorMatrix.setSaturation(0.0F);
        localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
        ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("grey bitmap, oom, stack:");
        ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
        QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    if (paramBitmap == null) {
      return null;
    }
    Object localObject2;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject1 = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OOM occurred in ImageUtil.round");
      ((StringBuilder)localObject2).append(localOutOfMemoryError.getMessage());
      f(((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      Canvas localCanvas = new Canvas(localObject1);
      localObject2 = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(localRect);
      ((Paint)localObject2).setAntiAlias(true);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, (Paint)localObject2);
      ((Paint)localObject2).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRect, (Paint)localObject2);
    }
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Object localObject = null;
    if (paramBitmap != null) {}
    for (;;)
    {
      float f2;
      float f4;
      try
      {
        f2 = paramBitmap.getWidth();
        float f1 = paramBitmap.getHeight();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cutOurImg() img:[");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append("], default: [");
        ((StringBuilder)localObject).append(paramFloat1);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramFloat2);
        ((StringBuilder)localObject).append("]");
        f(((StringBuilder)localObject).toString());
        float f3 = paramFloat1 / f2;
        f4 = paramFloat2 / f1;
        if (f3 > f4)
        {
          j = (int)paramFloat1;
          i = (int)(f3 * f1);
          Matrix localMatrix = new Matrix();
          f3 = j;
          f2 = f3 / f2;
          f4 = i;
          localMatrix.postScale(f2, f4 / f1);
          localMatrix.postTranslate((paramFloat1 - f3) / 2.0F, (paramFloat2 - f4) / 2.0F);
          localObject = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.RGB_565);
          new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, localMatrix, null);
          return localObject;
        }
      }
      catch (Exception|OutOfMemoryError paramBitmap)
      {
        return null;
      }
      int j = (int)(f4 * f2);
      int i = (int)paramFloat2;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    return a(paramBitmap, paramFloat, false, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        i = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        if (i > k)
        {
          paramInt1 = (i - k) / 2;
          j = paramInt2;
          i = k;
          break label258;
        }
        if (k <= i) {
          break label249;
        }
        k = (k - i) / 2;
        paramInt2 = i;
        m = paramInt2;
        j = 0;
        i = paramInt1;
        n = paramInt1;
        i1 = i;
      }
      catch (Throwable paramBitmap)
      {
        Bitmap localBitmap;
        Canvas localCanvas;
        Paint localPaint;
        Rect localRect1;
        Rect localRect2;
        RectF localRectF;
        paramBitmap.printStackTrace();
        return null;
      }
      localBitmap = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localRect1 = new Rect(j, k, paramInt2 + j, m + k);
      localRect2 = new Rect(0, 0, n, i1);
      localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      label249:
      int m = 0;
      int j = paramInt1;
      paramInt1 = m;
      label258:
      int i2 = 0;
      int i1 = paramInt2;
      int n = j;
      m = k;
      paramInt2 = i;
      int k = i2;
      j = paramInt1;
      if (!paramBoolean) {
        paramFloat = n;
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 344	android/graphics/Matrix
    //   12: dup
    //   13: invokespecial 345	android/graphics/Matrix:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 126	android/graphics/Bitmap:getWidth	()I
    //   22: istore_3
    //   23: aload_0
    //   24: invokevirtual 135	android/graphics/Bitmap:getHeight	()I
    //   27: istore 4
    //   29: iload_1
    //   30: i2f
    //   31: iload_3
    //   32: iload 4
    //   34: invokestatic 383	java/lang/Math:max	(II)I
    //   37: i2f
    //   38: fconst_1
    //   39: fmul
    //   40: fdiv
    //   41: fstore_2
    //   42: aload 6
    //   44: astore 5
    //   46: fload_2
    //   47: fconst_1
    //   48: fcmpl
    //   49: ifeq +94 -> 143
    //   52: aload 6
    //   54: astore 5
    //   56: fload_2
    //   57: fconst_0
    //   58: fcmpl
    //   59: ifle +84 -> 143
    //   62: aload 7
    //   64: fload_2
    //   65: fload_2
    //   66: invokevirtual 349	android/graphics/Matrix:postScale	(FF)Z
    //   69: pop
    //   70: aload_0
    //   71: iconst_0
    //   72: iconst_0
    //   73: iload_3
    //   74: iload 4
    //   76: aload 7
    //   78: iconst_1
    //   79: invokestatic 386	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   82: astore 5
    //   84: goto +59 -> 143
    //   87: ldc_w 388
    //   90: invokestatic 68	com/tencent/mobileqq/utils/BaseImageUtil:f	(Ljava/lang/String;)V
    //   93: aload 6
    //   95: astore 5
    //   97: goto +46 -> 143
    //   100: astore 5
    //   102: new 48	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   109: astore 7
    //   111: aload 7
    //   113: ldc_w 390
    //   116: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 7
    //   122: aload 5
    //   124: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   127: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 7
    //   133: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 68	com/tencent/mobileqq/utils/BaseImageUtil:f	(Ljava/lang/String;)V
    //   139: aload 6
    //   141: astore 5
    //   143: aload 5
    //   145: ifnull +30 -> 175
    //   148: aload_0
    //   149: ifnull +23 -> 172
    //   152: aload_0
    //   153: invokevirtual 394	android/graphics/Bitmap:isRecycled	()Z
    //   156: ifne +16 -> 172
    //   159: aload_0
    //   160: aload 5
    //   162: invokevirtual 398	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   165: ifne +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 401	android/graphics/Bitmap:recycle	()V
    //   172: aload 5
    //   174: areturn
    //   175: aload_0
    //   176: areturn
    //   177: astore 5
    //   179: goto -92 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBitmap	Bitmap
    //   0	182	1	paramInt	int
    //   41	25	2	f	float
    //   22	52	3	i	int
    //   27	48	4	j	int
    //   44	52	5	localObject1	Object
    //   100	23	5	localException	Exception
    //   141	32	5	localObject2	Object
    //   177	1	5	localOutOfMemoryError	OutOfMemoryError
    //   1	139	6	localObject3	Object
    //   16	116	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   62	84	100	java/lang/Exception
    //   62	84	177	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt1;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(paramInt2 * f1);
    return a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    paramBitmap = b(paramBitmap, paramInt1, paramInt2);
    if (paramBitmap != null) {
      return c(paramBitmap, paramFloat, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap = paramBitmap;
    if (localBitmap == null) {
      return null;
    }
    try
    {
      float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
      int m = (int)Math.ceil(paramBitmap.getWidth() / f);
      int n = (int)Math.ceil(paramBitmap.getHeight() / f);
      Object localObject;
      if (m == paramInt1)
      {
        localObject = localBitmap;
        if (n == paramInt2) {}
      }
      else
      {
        paramBitmap = Bitmap.createScaledBitmap(localBitmap, m, n, true);
        int j = (m - paramInt1) / 2;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        int k = (n - paramInt2) / 2;
        j = k;
        if (k < 0) {
          j = 0;
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ROUND_CORNER_DECODER scale = ");
          ((StringBuilder)localObject).append(f);
          ((StringBuilder)localObject).append(", scaledWidth = ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(", scaledHeight = ");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(", xTopLeft = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", yTopLeft = ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(", width = ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", height = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
        }
        localObject = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
        paramBitmap.recycle();
      }
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      if (paramInt4 != 1)
      {
        if (paramInt4 != 2)
        {
          if (paramInt4 != 3)
          {
            if (paramInt4 != 4) {
              paramBitmap = null;
            } else {
              paramBitmap = new Rect(-paramInt3, 0, paramInt1 - paramInt3, paramInt2);
            }
          }
          else {
            paramBitmap = new Rect(paramInt3, 0, paramInt1 + paramInt3, paramInt2);
          }
        }
        else {
          paramBitmap = new Rect(0, -paramInt3, paramInt1, paramInt2 - paramInt3);
        }
      }
      else {
        paramBitmap = new Rect(0, paramInt3, paramInt1, paramInt2 + paramInt3);
      }
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      f = paramInt3;
      localCanvas.drawRoundRect(localRectF, f, f, localPaint);
      if (paramBitmap != null) {
        localCanvas.drawRect(paramBitmap, localPaint);
      }
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap((Bitmap)localObject, localRect1, localRect2, localPaint);
      ((Bitmap)localObject).recycle();
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, int paramInt)
  {
    if (paramBitmap != null) {
      try
      {
        if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right <= paramBitmap.getWidth()))
        {
          if (paramRect.bottom > paramBitmap.getHeight()) {
            return null;
          }
          Paint localPaint = new Paint();
          Rect localRect = new Rect(0, 0, paramRect.width() / paramInt, paramRect.height() / paramInt);
          RectF localRectF = new RectF(localRect);
          Bitmap localBitmap = Bitmap.createBitmap(localRect.width(), localRect.height(), Bitmap.Config.RGB_565);
          Canvas localCanvas = new Canvas(localBitmap);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRect(localRectF, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, paramRect, localRect, localPaint);
          if (!paramBitmap.isRecycled()) {
            paramBitmap.recycle();
          }
          return localBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        if (QLog.isColorLevel())
        {
          paramRect = new StringBuilder();
          paramRect.append("getClipRectBitmap throw error ... ");
          paramRect.append(paramBitmap.getMessage());
          QLog.e("ImageUtil", 2, paramRect.toString());
        }
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        if (((Canvas)localObject).getDensity() != paramBitmap.getDensity()) {
          ((Canvas)localObject).setDensity(paramBitmap.getDensity());
        }
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        localPaint.setColor(Color.parseColor("#80000000"));
        RectF localRectF = new RectF(0.0F, 0.0F, i, j);
        if (paramBoolean)
        {
          ((Canvas)localObject).drawRoundRect(localRectF, i / 2, j / 2, localPaint);
          return localBitmap;
        }
        ((Canvas)localObject).drawRect(localRectF, localPaint);
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("grey bitmap, oom, stack:");
        ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
        QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramBitmap;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Object localObject = null;
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicWidth();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      localObject = localBitmap;
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw((Canvas)localObject);
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return null;
    }
    int k = paramDrawable.getIntrinsicWidth();
    int m = paramDrawable.getIntrinsicHeight();
    int j;
    int i;
    if (k > 0)
    {
      if (m <= 0) {
        return null;
      }
      j = k;
      i = m;
      if (paramInt1 > 0)
      {
        j = k;
        i = m;
        if (paramInt2 > 0)
        {
          float f1 = paramInt1;
          float f3 = k;
          f1 /= f3;
          float f2 = paramInt2;
          float f4 = m;
          f2 /= f4;
          if (f1 >= f2) {
            f1 = f2;
          }
          j = k;
          i = m;
          if (f1 < 1.0F)
          {
            j = (int)(f3 * f1);
            i = (int)(f4 * f1);
          }
        }
      }
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(j, i, (Bitmap.Config)localObject);
      if (localObject != null)
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, j, i);
        paramDrawable.draw(localCanvas);
      }
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
    return null;
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +244 -> 248
    //   7: new 16	android/graphics/BitmapFactory$Options
    //   10: dup
    //   11: invokespecial 17	android/graphics/BitmapFactory$Options:<init>	()V
    //   14: astore 8
    //   16: aload 8
    //   18: iconst_1
    //   19: putfield 21	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: new 218	java/io/BufferedInputStream
    //   25: dup
    //   26: new 515	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 517	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 6
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: aconst_null
    //   46: aload 8
    //   48: invokestatic 27	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: pop
    //   52: aload 6
    //   54: astore 5
    //   56: aload 8
    //   58: getfield 30	android/graphics/BitmapFactory$Options:outWidth	I
    //   61: istore_3
    //   62: aload 6
    //   64: astore 5
    //   66: aload 8
    //   68: getfield 33	android/graphics/BitmapFactory$Options:outHeight	I
    //   71: istore 4
    //   73: aload 6
    //   75: astore 5
    //   77: new 16	android/graphics/BitmapFactory$Options
    //   80: dup
    //   81: invokespecial 17	android/graphics/BitmapFactory$Options:<init>	()V
    //   84: astore 8
    //   86: aload 6
    //   88: astore 5
    //   90: aload 8
    //   92: iload_3
    //   93: iload_1
    //   94: idiv
    //   95: iload 4
    //   97: iload_2
    //   98: idiv
    //   99: invokestatic 383	java/lang/Math:max	(II)I
    //   102: putfield 520	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 6
    //   107: astore 5
    //   109: aload 8
    //   111: iconst_0
    //   112: putfield 21	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   115: aload 6
    //   117: astore 5
    //   119: aload 8
    //   121: iconst_1
    //   122: putfield 523	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: invokevirtual 236	java/io/InputStream:close	()V
    //   134: aload 6
    //   136: astore 5
    //   138: new 218	java/io/BufferedInputStream
    //   141: dup
    //   142: new 515	java/io/FileInputStream
    //   145: dup
    //   146: aload_0
    //   147: invokespecial 517	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   150: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   153: astore_0
    //   154: aload_0
    //   155: aconst_null
    //   156: aload 8
    //   158: invokestatic 27	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   161: astore 6
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: invokevirtual 236	java/io/InputStream:close	()V
    //   171: aload 6
    //   173: areturn
    //   174: astore 6
    //   176: aload_0
    //   177: astore 5
    //   179: aload 6
    //   181: astore_0
    //   182: goto +54 -> 236
    //   185: astore 6
    //   187: goto +26 -> 213
    //   190: astore 5
    //   192: aload 6
    //   194: astore_0
    //   195: aload 5
    //   197: astore 6
    //   199: goto +14 -> 213
    //   202: astore_0
    //   203: aconst_null
    //   204: astore 5
    //   206: goto +30 -> 236
    //   209: astore 6
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: astore 5
    //   216: aload 6
    //   218: invokevirtual 378	java/lang/Throwable:printStackTrace	()V
    //   221: aload_0
    //   222: ifnull +11 -> 233
    //   225: aload 7
    //   227: astore 5
    //   229: aload_0
    //   230: invokevirtual 236	java/io/InputStream:close	()V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_0
    //   236: aload 5
    //   238: ifnull +8 -> 246
    //   241: aload 5
    //   243: invokevirtual 236	java/io/InputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aload 5
    //   253: areturn
    //   254: astore 5
    //   256: goto -10 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramString	String
    //   0	259	1	paramInt1	int
    //   0	259	2	paramInt2	int
    //   61	34	3	i	int
    //   71	28	4	j	int
    //   41	137	5	localObject1	Object
    //   190	6	5	localThrowable1	Throwable
    //   204	48	5	localObject2	Object
    //   254	1	5	localIOException	IOException
    //   37	135	6	localObject3	Object
    //   174	6	6	localObject4	Object
    //   185	8	6	localThrowable2	Throwable
    //   197	1	6	localObject5	Object
    //   209	8	6	localThrowable3	Throwable
    //   1	225	7	localObject6	Object
    //   14	143	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   154	163	174	finally
    //   154	163	185	java/lang/Throwable
    //   43	52	190	java/lang/Throwable
    //   56	62	190	java/lang/Throwable
    //   66	73	190	java/lang/Throwable
    //   77	86	190	java/lang/Throwable
    //   90	105	190	java/lang/Throwable
    //   109	115	190	java/lang/Throwable
    //   119	125	190	java/lang/Throwable
    //   129	134	190	java/lang/Throwable
    //   138	154	190	java/lang/Throwable
    //   7	39	202	finally
    //   7	39	209	java/lang/Throwable
    //   43	52	235	finally
    //   56	62	235	finally
    //   66	73	235	finally
    //   77	86	235	finally
    //   90	105	235	finally
    //   109	115	235	finally
    //   119	125	235	finally
    //   129	134	235	finally
    //   138	154	235	finally
    //   216	221	235	finally
    //   167	171	250	java/io/IOException
    //   229	233	250	java/io/IOException
    //   241	246	254	java/io/IOException
  }
  
  /* Error */
  @java.lang.Deprecated
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +32 -> 37
    //   8: aload_1
    //   9: getfield 21	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   12: ifeq +25 -> 37
    //   15: new 218	java/io/BufferedInputStream
    //   18: dup
    //   19: new 515	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 517	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: sipush 2048
    //   30: invokespecial 528	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_0
    //   34: goto +19 -> 53
    //   37: new 218	java/io/BufferedInputStream
    //   40: dup
    //   41: new 515	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 517	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: aconst_null
    //   57: aload_1
    //   58: invokestatic 529	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 236	java/io/InputStream:close	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: goto +10 -> 79
    //   72: astore_0
    //   73: goto +39 -> 112
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +16 -> 100
    //   87: aload_0
    //   88: astore_2
    //   89: ldc_w 282
    //   92: iconst_2
    //   93: ldc_w 531
    //   96: aload_1
    //   97: invokestatic 533	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: ifnull +8 -> 109
    //   104: aload_3
    //   105: astore_1
    //   106: goto -44 -> 62
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 236	java/io/InputStream:close	()V
    //   120: goto +5 -> 125
    //   123: aload_0
    //   124: athrow
    //   125: goto -2 -> 123
    //   128: astore_0
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: goto -12 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramString	String
    //   0	135	1	paramOptions	BitmapFactory.Options
    //   1	116	2	str	String
    //   3	102	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	68	java/lang/Exception
    //   8	34	72	finally
    //   37	53	72	finally
    //   8	34	76	java/lang/Exception
    //   37	53	76	java/lang/Exception
    //   55	62	111	finally
    //   81	87	111	finally
    //   89	100	111	finally
    //   62	66	128	java/io/IOException
    //   116	120	131	java/io/IOException
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    int m = 1;
    paramOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, paramOptions);
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    while ((j > paramInt) || (k > paramInt)) {
      if (Math.round(Math.max(j, k) / (paramInt * 1.0F)) >= 2)
      {
        k /= 2;
        j /= 2;
        if ((k < paramInt) && (j < paramInt)) {
          paramOptions.inSampleSize = i;
        } else if ((k != paramInt) && (j != paramInt)) {
          i *= 2;
        } else {
          paramOptions.inSampleSize = (i * 2);
        }
      }
      else
      {
        paramOptions.inSampleSize = i;
      }
    }
    paramOptions.inJustDecodeBounds = false;
    paramInt = m;
    if (paramOptions.inSampleSize >= 1) {
      paramInt = paramOptions.inSampleSize;
    }
    paramOptions.inSampleSize = paramInt;
    return paramOptions;
  }
  
  static BitmapFactory.Options a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(File paramFile, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    double d = a(localFileInputStream, paramInt1, paramInt2);
    localFileInputStream.close();
    localOptions.inSampleSize = ((int)d);
    localOptions.inJustDecodeBounds = true;
    localFileInputStream = new FileInputStream(paramFile);
    SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    localFileInputStream.close();
    paramInt2 = 0;
    while (localOptions.outWidth > paramInt1)
    {
      localOptions.inSampleSize += 1;
      localFileInputStream = new FileInputStream(paramFile);
      SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
      localFileInputStream.close();
      if (paramInt2 > 3) {
        break;
      }
      paramInt2 += 1;
    }
    localOptions.inJustDecodeBounds = false;
    return localOptions;
  }
  
  public static BitmapFactory.Options a(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int m = 1;
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    paramString = new StringBuilder();
    paramString.append("compressAIOThumbImg  org width:");
    paramString.append(k);
    paramString.append(",height:");
    paramString.append(j);
    f(paramString.toString());
    int i = 1;
    while ((j > paramInt) && (k > paramInt))
    {
      float f1 = j;
      float f2 = paramInt;
      if (Math.min(Math.round(f1 / f2), Math.round(k / f2)) >= 2)
      {
        k /= 2;
        j /= 2;
        if ((k >= paramInt) && (j >= paramInt))
        {
          if ((k != paramInt) && (j != paramInt)) {
            i *= 2;
          } else {
            localOptions.inSampleSize = (i * 2);
          }
        }
        else {
          localOptions.inSampleSize = i;
        }
      }
      else
      {
        localOptions.inSampleSize = i;
      }
    }
    localOptions.inJustDecodeBounds = false;
    paramInt = m;
    if (localOptions.inSampleSize >= 1) {
      paramInt = localOptions.inSampleSize;
    }
    localOptions.inSampleSize = paramInt;
    return localOptions;
  }
  
  public static Rect a(Rect paramRect, int paramInt, float paramFloat)
  {
    if ((paramRect != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      int k = (int)(paramInt * paramFloat);
      int i = paramRect.width();
      int j = paramRect.width();
      if (i > j) {
        paramInt = i;
      } else {
        paramInt = j;
      }
      if (paramInt < k)
      {
        paramRect = new Rect();
        a(paramRect, i, j, k);
        return paramRect;
      }
    }
    return null;
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt1, int paramInt2, float paramFloat)
  {
    Rect localRect = new Rect();
    if ((paramDrawable != null) && (paramInt2 > 0) && (paramInt1 > 0) && (paramInt2 > paramInt1) && (paramFloat > 0.0F))
    {
      int j = paramDrawable.getIntrinsicWidth();
      int k = paramDrawable.getIntrinsicHeight();
      int i;
      if (j > k) {
        i = j;
      } else {
        i = k;
      }
      if (i < paramInt1)
      {
        a(localRect, j, k, (int)(paramInt1 * paramFloat));
        return localRect;
      }
      if ((i >= paramInt1) && (i < paramInt2))
      {
        localRect.set(0, 0, (int)(j * paramFloat), (int)(k * paramFloat));
        return localRect;
      }
      a(localRect, j, k, (int)(paramInt2 * paramFloat));
    }
    return localRect;
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      paramDrawable = ((SkinnableBitmapDrawable)paramDrawable).mutate2();
    } else {
      paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    }
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  public static Drawable a(boolean paramBoolean)
  {
    return new BitmapDrawable(b(paramBoolean));
  }
  
  public static StateListDrawable a(int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getResources().getDrawable(paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject;
    if (Build.VERSION.SDK_INT <= 19)
    {
      paramInt = paramContext.getIntrinsicWidth();
      int i = paramContext.getIntrinsicHeight();
      localObject = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramContext.setAlpha(102);
      paramContext.setBounds(0, 0, paramInt, i);
      paramContext.draw(localCanvas);
      localObject = new BitmapDrawable((Bitmap)localObject);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    }
    else
    {
      localObject = paramContext.getConstantState().newDrawable();
      ((Drawable)localObject).mutate().setAlpha(102);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    }
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      else
      {
        localFile.delete();
      }
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static String a(double paramDouble)
  {
    int m = (int)paramDouble;
    paramDouble = paramDouble % 1.0D * 60.0D;
    int j = (int)paramDouble;
    int i = j;
    if (j < 0) {
      i = j * -1;
    }
    int k = (int)(paramDouble % 1.0D * 60.0D);
    j = k;
    if (k < 0) {
      j = k * -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(m));
    localStringBuilder.append("/1,");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("/1,");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("/1");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("thumb/");
    localObject = ((StringBuilder)localObject).toString();
    if (paramUri == null) {
      return "";
    }
    paramContext = b(paramContext, paramUri);
    if (paramContext.startsWith((String)localObject)) {
      return paramContext;
    }
    paramUri = paramContext.substring(paramContext.lastIndexOf("/") + 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramContext.hashCode());
    localStringBuilder.append(paramUri);
    paramContext = localStringBuilder.toString();
    paramUri = new File((String)localObject);
    if (!paramUri.exists()) {
      paramUri.mkdirs();
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramContext = new StringBuilder();
    paramContext.append(AppConstants.SDCARD_PATH);
    paramContext.append("thumb/");
    paramContext = paramContext.toString();
    if (paramString.startsWith(paramContext)) {
      return paramString;
    }
    String str = paramString.substring(paramString.lastIndexOf("/") + 1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramString.hashCode());
    localStringBuilder.append(str);
    paramString = localStringBuilder.toString();
    paramContext = new File(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = 600;
    int i = 800;
    try
    {
      a(paramContext, paramString, (String)localObject1, 600, 800);
      int k = 0;
      while ((new File((String)localObject1).length() > paramInt) && (k < 3))
      {
        k += 1;
        j -= 100;
        i -= 100;
        a(paramContext, paramString, (String)localObject1, Math.max(100, j), Math.max(100, i));
      }
      Object localObject2 = a(paramContext, Uri.parse(paramString));
      String str = a(paramContext, Uri.parse((String)localObject1));
      localObject2 = new File((String)localObject2);
      if (((File)localObject2).exists()) {
        ((File)localObject2).renameTo(new File(str));
      } else {
        a(paramContext, (String)localObject1, str, 160, 160);
      }
      return localObject1;
    }
    catch (Exception paramContext)
    {
      a("compressImageForGroup exception", paramContext);
    }
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    long l = 0L;
    if (((File)localObject).exists()) {
      l = ((File)localObject).lastModified();
    }
    int i = paramString.lastIndexOf("/");
    int j = 1;
    localObject = paramString.substring(i + 1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_PATH);
    localStringBuffer.append("photo/");
    if (NetworkUtil.isWifiEnabled(paramContext)) {
      localStringBuffer.append("WIFI");
    }
    i = j;
    if (paramInt1 != 1)
    {
      i = j;
      if (paramInt1 != 1001)
      {
        i = j;
        if (paramInt1 != 10002) {
          if (paramInt1 == 3000) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
    }
    localStringBuffer.append(i);
    localStringBuffer.append("s");
    localStringBuffer.append(paramInt2);
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append(l);
    localStringBuffer.append(paramContext.toString().hashCode());
    localStringBuffer.append((String)localObject);
    return localStringBuffer.toString();
  }
  
  public static String a(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
    }
    catch (IOException paramFileInputStream)
    {
      paramFileInputStream.printStackTrace();
    }
    localObject = HexUtil.bytes2HexStr((byte[])localObject).toUpperCase();
    if (((String)localObject).contains("FFD8FF")) {
      return "jpg";
    }
    if (((String)localObject).contains("89504E470D0A1A0A")) {
      return "png";
    }
    if (((String)localObject).contains("47494638")) {
      return "gif";
    }
    if (((String)localObject).contains("49492A00")) {
      return "tif";
    }
    if (((String)localObject).contains("424D")) {
      return "bmp";
    }
    if (((String)localObject).contains("0A")) {
      return "pcx";
    }
    if ((!((String)localObject).contains("4D4D")) && (!((String)localObject).contains("4949")))
    {
      if (((String)localObject).contains("464F524D")) {
        return "iff";
      }
      if (((String)localObject).contains("52494646")) {
        return "ani";
      }
      if (((String)localObject).contains("0000020000")) {
        return "tga";
      }
      if (((String)localObject).contains("0000100000")) {
        return "rle";
      }
      if (((String)localObject).contains("0000010001002020")) {
        return "ico";
      }
      paramFileInputStream = (FileInputStream)localObject;
      if (((String)localObject).contains("0000020001002020")) {
        return "cur";
      }
    }
    else
    {
      paramFileInputStream = "tiff";
    }
    return paramFileInputStream;
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 145	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   4: putfield 818	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: aconst_null
    //   11: aload_1
    //   12: invokestatic 27	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_2
    //   25: invokestatic 820	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   28: astore 5
    //   30: new 822	java/io/BufferedOutputStream
    //   33: dup
    //   34: new 824	java/io/FileOutputStream
    //   37: dup
    //   38: aload 5
    //   40: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 828	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_0
    //   47: aload 4
    //   49: getstatic 834	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   52: bipush 100
    //   54: aload_0
    //   55: invokevirtual 838	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 841	java/io/OutputStream:close	()V
    //   63: aload 4
    //   65: ifnull +16 -> 81
    //   68: aload 4
    //   70: invokevirtual 394	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +8 -> 81
    //   76: aload 4
    //   78: invokevirtual 401	android/graphics/Bitmap:recycle	()V
    //   81: aload_2
    //   82: ifnonnull +22 -> 104
    //   85: aload 5
    //   87: ifnull +17 -> 104
    //   90: aload 5
    //   92: invokevirtual 621	java/io/File:exists	()Z
    //   95: ifeq +9 -> 104
    //   98: aload 5
    //   100: invokevirtual 639	java/io/File:delete	()Z
    //   103: pop
    //   104: aload_2
    //   105: areturn
    //   106: astore_1
    //   107: goto +12 -> 119
    //   110: goto +65 -> 175
    //   113: goto +114 -> 227
    //   116: astore_1
    //   117: aload_3
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +10 -> 130
    //   123: aload_0
    //   124: invokevirtual 841	java/io/OutputStream:close	()V
    //   127: goto +3 -> 130
    //   130: aload 4
    //   132: ifnull +16 -> 148
    //   135: aload 4
    //   137: invokevirtual 394	android/graphics/Bitmap:isRecycled	()Z
    //   140: ifne +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 401	android/graphics/Bitmap:recycle	()V
    //   148: aload_2
    //   149: ifnonnull +22 -> 171
    //   152: aload 5
    //   154: ifnull +17 -> 171
    //   157: aload 5
    //   159: invokevirtual 621	java/io/File:exists	()Z
    //   162: ifeq +9 -> 171
    //   165: aload 5
    //   167: invokevirtual 639	java/io/File:delete	()Z
    //   170: pop
    //   171: aload_1
    //   172: athrow
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull +10 -> 186
    //   179: aload_0
    //   180: invokevirtual 841	java/io/OutputStream:close	()V
    //   183: goto +3 -> 186
    //   186: aload 4
    //   188: ifnull +16 -> 204
    //   191: aload 4
    //   193: invokevirtual 394	android/graphics/Bitmap:isRecycled	()Z
    //   196: ifne +8 -> 204
    //   199: aload 4
    //   201: invokevirtual 401	android/graphics/Bitmap:recycle	()V
    //   204: aload 5
    //   206: ifnull +66 -> 272
    //   209: aload 5
    //   211: invokevirtual 621	java/io/File:exists	()Z
    //   214: ifeq +58 -> 272
    //   217: aload 5
    //   219: invokevirtual 639	java/io/File:delete	()Z
    //   222: pop
    //   223: aconst_null
    //   224: areturn
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: ifnull +10 -> 238
    //   231: aload_0
    //   232: invokevirtual 841	java/io/OutputStream:close	()V
    //   235: goto +3 -> 238
    //   238: aload 4
    //   240: ifnull +16 -> 256
    //   243: aload 4
    //   245: invokevirtual 394	android/graphics/Bitmap:isRecycled	()Z
    //   248: ifne +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 401	android/graphics/Bitmap:recycle	()V
    //   256: aload 5
    //   258: ifnull +14 -> 272
    //   261: aload 5
    //   263: invokevirtual 621	java/io/File:exists	()Z
    //   266: ifeq +6 -> 272
    //   269: goto -52 -> 217
    //   272: aconst_null
    //   273: areturn
    //   274: astore_0
    //   275: goto -50 -> 225
    //   278: astore_0
    //   279: goto -106 -> 173
    //   282: astore_1
    //   283: goto -170 -> 113
    //   286: astore_1
    //   287: goto -177 -> 110
    //   290: astore_0
    //   291: goto -228 -> 63
    //   294: astore_0
    //   295: goto -165 -> 130
    //   298: astore_0
    //   299: goto -113 -> 186
    //   302: astore_0
    //   303: goto -65 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramInputStream	InputStream
    //   0	306	1	paramOptions	BitmapFactory.Options
    //   0	306	2	paramString	String
    //   8	110	3	localObject	Object
    //   15	237	4	localBitmap	Bitmap
    //   28	234	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	59	106	finally
    //   30	47	116	finally
    //   30	47	274	java/lang/Exception
    //   30	47	278	java/lang/OutOfMemoryError
    //   47	59	282	java/lang/Exception
    //   47	59	286	java/lang/OutOfMemoryError
    //   59	63	290	java/io/IOException
    //   123	127	294	java/io/IOException
    //   179	183	298	java/io/IOException
    //   231	235	302	java/io/IOException
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 27	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +56 -> 72
    //   19: new 48	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc_w 844
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 126	android/graphics/Bitmap:getWidth	()I
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_0
    //   45: ldc_w 846
    //   48: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 135	android/graphics/Bitmap:getHeight	()I
    //   57: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc_w 282
    //   64: iconst_2
    //   65: aload_0
    //   66: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 849	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: invokestatic 820	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   76: astore_0
    //   77: new 824	java/io/FileOutputStream
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_0
    //   86: aload_1
    //   87: getstatic 852	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   90: bipush 100
    //   92: iload_3
    //   93: invokestatic 557	java/lang/Math:min	(II)I
    //   96: aload_0
    //   97: invokevirtual 838	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokevirtual 841	java/io/OutputStream:close	()V
    //   105: aload_2
    //   106: areturn
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: goto +9 -> 121
    //   115: goto +18 -> 133
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 841	java/io/OutputStream:close	()V
    //   129: aload_0
    //   130: athrow
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 841	java/io/OutputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: goto -13 -> 131
    //   147: astore_1
    //   148: goto -33 -> 115
    //   151: astore_0
    //   152: aload_2
    //   153: areturn
    //   154: astore_1
    //   155: goto -26 -> 129
    //   158: astore_0
    //   159: goto -18 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramInputStream	InputStream
    //   0	162	1	paramOptions	BitmapFactory.Options
    //   0	162	2	paramString	String
    //   0	162	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   86	101	107	finally
    //   77	86	118	finally
    //   77	86	143	java/lang/Exception
    //   86	101	147	java/lang/Exception
    //   101	105	151	java/io/IOException
    //   125	129	154	java/io/IOException
    //   137	141	158	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 541	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: iload_2
    //   17: iload_3
    //   18: invokestatic 857	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   21: astore 7
    //   23: new 515	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_0
    //   33: aload 7
    //   35: aload_1
    //   36: bipush 100
    //   38: iload 4
    //   40: invokestatic 557	java/lang/Math:min	(II)I
    //   43: invokestatic 859	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_0
    //   48: invokevirtual 236	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: areturn
    //   53: astore 5
    //   55: aload_0
    //   56: astore_1
    //   57: aload 5
    //   59: astore_0
    //   60: goto +13 -> 73
    //   63: goto +22 -> 85
    //   66: goto +31 -> 97
    //   69: astore_0
    //   70: aload 6
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 236	java/io/InputStream:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +21 -> 107
    //   89: aload 5
    //   91: astore_1
    //   92: goto -45 -> 47
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +9 -> 107
    //   101: aload 5
    //   103: astore_1
    //   104: goto -57 -> 47
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: goto -15 -> 95
    //   113: astore_0
    //   114: goto -31 -> 83
    //   117: astore_1
    //   118: goto -52 -> 66
    //   121: astore_1
    //   122: goto -59 -> 63
    //   125: astore_0
    //   126: aload_1
    //   127: areturn
    //   128: astore_1
    //   129: goto -48 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString1	String
    //   0	132	1	paramString2	String
    //   0	132	2	paramInt1	int
    //   0	132	3	paramInt2	int
    //   0	132	4	paramInt3	int
    //   4	1	5	localObject1	Object
    //   53	49	5	localObject2	Object
    //   1	70	6	localObject3	Object
    //   21	13	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   32	47	53	finally
    //   6	32	69	finally
    //   6	32	109	java/lang/Exception
    //   6	32	113	java/lang/Error
    //   32	47	117	java/lang/Exception
    //   32	47	121	java/lang/Error
    //   47	51	125	java/io/IOException
    //   77	81	128	java/io/IOException
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    localObject = ((BitmapFactory.Options)localObject).outMimeType;
    int i = g(str);
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("title", paramFile.getName());
    localContentValues.put("_display_name", paramFile.getName());
    localContentValues.put("date_modified", Long.valueOf(paramFile.lastModified() / 1000L));
    localContentValues.put("mime_type", (String)localObject);
    localContentValues.put("orientation", Integer.valueOf(i));
    localContentValues.put("_data", str);
    localContentValues.put("_size", Long.valueOf(paramFile.length()));
    try
    {
      if (paramContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues) == null)
      {
        MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), str, paramFile.getName(), null);
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ImageUtil", 1, "savePic2SystemMedia fail.", paramContext);
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore_0
    //   9: new 541	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload 6
    //   20: astore_0
    //   21: aload_1
    //   22: iload_3
    //   23: iload 4
    //   25: invokestatic 857	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   28: astore 7
    //   30: aload 6
    //   32: astore_0
    //   33: new 218	java/io/BufferedInputStream
    //   36: dup
    //   37: new 515	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_1
    //   49: aload_1
    //   50: aload 7
    //   52: aload_2
    //   53: invokestatic 936	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;)Ljava/lang/String;
    //   56: pop
    //   57: aload_1
    //   58: invokevirtual 236	java/io/InputStream:close	()V
    //   61: return
    //   62: astore_0
    //   63: goto +72 -> 135
    //   66: astore_2
    //   67: goto +15 -> 82
    //   70: astore_2
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: astore_0
    //   75: goto +60 -> 135
    //   78: astore_2
    //   79: aload 5
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: new 48	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   91: astore 5
    //   93: aload_1
    //   94: astore_0
    //   95: aload 5
    //   97: ldc_w 938
    //   100: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_1
    //   105: astore_0
    //   106: aload 5
    //   108: aload_2
    //   109: invokevirtual 391	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: astore_0
    //   118: aload 5
    //   120: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 68	com/tencent/mobileqq/utils/BaseImageUtil:f	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 236	java/io/InputStream:close	()V
    //   134: return
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 236	java/io/InputStream:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: return
    //   147: astore_1
    //   148: goto -5 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   0	151	1	paramString1	String
    //   0	151	2	paramString2	String
    //   0	151	3	paramInt1	int
    //   0	151	4	paramInt2	int
    //   1	118	5	localStringBuilder	StringBuilder
    //   4	27	6	localObject	Object
    //   28	23	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   49	57	62	finally
    //   49	57	66	java/lang/Exception
    //   9	18	70	finally
    //   21	30	70	finally
    //   33	49	70	finally
    //   84	93	70	finally
    //   95	104	70	finally
    //   106	116	70	finally
    //   118	126	70	finally
    //   9	18	78	java/lang/Exception
    //   21	30	78	java/lang/Exception
    //   33	49	78	java/lang/Exception
    //   57	61	145	java/io/IOException
    //   130	134	145	java/io/IOException
    //   139	143	147	java/io/IOException
  }
  
  public static void a(Resources paramResources, View paramView, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inInputShareable = true;
      localOptions.inPurgeable = true;
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localOptions.inSampleSize = 2;
      paramView.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeResource(paramResources, paramInt, localOptions)));
      return;
    }
    catch (OutOfMemoryError paramResources) {}
  }
  
  /* Error */
  public static void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 541	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 956	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 621	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 959	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 636	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 621	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 962	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 642	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: new 822	java/io/BufferedOutputStream
    //   57: dup
    //   58: new 824	java/io/FileOutputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 828	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_1
    //   70: aload_0
    //   71: getstatic 834	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   74: bipush 100
    //   76: aload_1
    //   77: invokevirtual 838	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   80: pop
    //   81: aload_1
    //   82: invokevirtual 965	java/io/BufferedOutputStream:flush	()V
    //   85: aload_1
    //   86: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   89: return
    //   90: astore_2
    //   91: aload_1
    //   92: astore_0
    //   93: aload_2
    //   94: astore_1
    //   95: goto +9 -> 104
    //   98: goto +16 -> 114
    //   101: astore_1
    //   102: aload_2
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   122: return
    //   123: astore_0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -12 -> 114
    //   129: astore_0
    //   130: goto -32 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramBitmap	Bitmap
    //   0	133	1	paramFile	File
    //   11	43	2	localFile	File
    //   90	13	2	localObject1	Object
    //   51	74	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	85	90	finally
    //   54	70	101	finally
    //   54	70	123	java/io/IOException
    //   70	85	129	java/io/IOException
  }
  
  private static void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
    {
      paramRect.set(0, 0, paramInt3, (int)(paramInt3 / paramInt1 * paramInt2));
      return;
    }
    paramRect.set(0, 0, (int)(paramInt3 / paramInt2 * paramInt1), paramInt3);
  }
  
  static final void a(FileOutputStream paramFileOutputStream)
  {
    paramFileOutputStream.flush();
    paramFileOutputStream = paramFileOutputStream.getFD();
    if ((paramFileOutputStream != null) && (paramFileOutputStream.valid())) {
      paramFileOutputStream.sync();
    }
  }
  
  static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    paramContext = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramContext != null) {
      ThreadManager.post(new BaseImageUtil.1(paramContext, paramString, paramBoolean), 2, null, false);
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 541	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_1
    //   15: invokestatic 820	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   18: astore 5
    //   20: new 515	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_1
    //   29: new 824	java/io/FileOutputStream
    //   32: dup
    //   33: aload 5
    //   35: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: astore_0
    //   39: sipush 2048
    //   42: newarray byte
    //   44: astore_3
    //   45: aload_1
    //   46: aload_3
    //   47: invokevirtual 1005	java/io/InputStream:read	([B)I
    //   50: istore_2
    //   51: iload_2
    //   52: iflt +13 -> 65
    //   55: aload_0
    //   56: aload_3
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 1009	java/io/OutputStream:write	([BII)V
    //   62: goto -17 -> 45
    //   65: aload_1
    //   66: invokevirtual 236	java/io/InputStream:close	()V
    //   69: aload_0
    //   70: invokevirtual 841	java/io/OutputStream:close	()V
    //   73: return
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: aload 4
    //   80: astore_0
    //   81: goto +19 -> 100
    //   84: goto +42 -> 126
    //   87: astore_0
    //   88: goto +12 -> 100
    //   91: aload 4
    //   93: astore_0
    //   94: goto +32 -> 126
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +10 -> 111
    //   104: aload_1
    //   105: invokevirtual 236	java/io/InputStream:close	()V
    //   108: goto +3 -> 111
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 841	java/io/OutputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: aconst_null
    //   122: astore_1
    //   123: aload 4
    //   125: astore_0
    //   126: aload_1
    //   127: ifnull +10 -> 137
    //   130: aload_1
    //   131: invokevirtual 236	java/io/InputStream:close	()V
    //   134: goto +3 -> 137
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 841	java/io/OutputStream:close	()V
    //   145: return
    //   146: astore_0
    //   147: goto -26 -> 121
    //   150: astore_0
    //   151: goto -60 -> 91
    //   154: astore_3
    //   155: goto -71 -> 84
    //   158: astore_1
    //   159: goto -90 -> 69
    //   162: astore_0
    //   163: return
    //   164: astore_1
    //   165: goto -54 -> 111
    //   168: astore_1
    //   169: goto -50 -> 119
    //   172: astore_1
    //   173: goto -36 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   50	9	2	i	int
    //   4	112	3	localObject1	Object
    //   154	1	3	localException	Exception
    //   1	1	4	localObject2	Object
    //   74	50	4	localObject3	Object
    //   18	16	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	45	74	finally
    //   45	51	74	finally
    //   55	62	74	finally
    //   29	39	87	finally
    //   5	29	97	finally
    //   5	29	146	java/lang/Exception
    //   29	39	150	java/lang/Exception
    //   39	45	154	java/lang/Exception
    //   45	51	154	java/lang/Exception
    //   55	62	154	java/lang/Exception
    //   65	69	158	java/io/IOException
    //   69	73	162	java/io/IOException
    //   141	145	162	java/io/IOException
    //   104	108	164	java/io/IOException
    //   115	119	168	java/io/IOException
    //   130	134	172	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString1, localOptions);
      if ((localOptions.outWidth < paramInt1) && (localOptions.outHeight < paramInt2))
      {
        a(paramString1, paramString2, paramInt1, paramInt2, 100);
        return;
      }
      paramString2 = SafeBitmapFactory.decodeFile(paramString1);
      if (paramString2.getWidth() < paramInt1) {
        paramString2.getWidth();
      } else if (paramString2.getHeight() < paramInt2) {
        paramString2.getHeight();
      }
      b(a(paramString2, paramInt1, paramInt2), new File(paramString1));
      return;
    }
    catch (Error paramString1)
    {
      f(paramString1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      f(paramString1.toString());
    }
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if ((QLog.isColorLevel()) || (UtilApi.b.c())) {
      QLog.e("ImageUtil", 2, paramString, paramThrowable);
    }
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 541	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 956	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 621	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 959	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 636	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 621	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 962	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 642	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore 4
    //   53: aconst_null
    //   54: astore_3
    //   55: new 822	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 824	java/io/FileOutputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 828	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   70: astore_2
    //   71: aload_0
    //   72: getstatic 834	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   75: iload_1
    //   76: aload_2
    //   77: invokevirtual 838	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 965	java/io/BufferedOutputStream:flush	()V
    //   85: aload_2
    //   86: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_0
    //   92: aload_2
    //   93: astore_3
    //   94: goto +19 -> 113
    //   97: astore_0
    //   98: aload_2
    //   99: astore_3
    //   100: goto +11 -> 111
    //   103: astore_0
    //   104: goto +9 -> 113
    //   107: astore_0
    //   108: aload 4
    //   110: astore_3
    //   111: aload_0
    //   112: athrow
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramBitmap	Bitmap
    //   0	123	1	paramInt	int
    //   0	123	2	paramFile	File
    //   11	107	3	localObject1	Object
    //   51	58	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	85	91	finally
    //   71	85	97	java/io/IOException
    //   55	71	103	finally
    //   111	113	103	finally
    //   55	71	107	java/io/IOException
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, boolean paramBoolean)
  {
    if (paramExifInterface1 != null)
    {
      if (paramExifInterface2 == null) {
        return false;
      }
      b(paramExifInterface1, paramExifInterface2, PicUploadExifInfoSwitch.getSwitch());
      Object localObject = paramExifInterface1.getAttribute("ImageLength");
      String str = paramExifInterface1.getAttribute("ImageWidth");
      if (localObject != null) {
        paramExifInterface2.setAttribute("ImageLength", (String)localObject);
      }
      if (str != null) {
        paramExifInterface2.setAttribute("ImageWidth", str);
      }
      if (ZhuoXusManager.a().j()) {
        try
        {
          paramExifInterface1 = new JSONObject();
          if (localObject != null) {
            paramExifInterface1.put("ImageLength", localObject);
          }
          if (str != null) {
            paramExifInterface1.put("ImageWidth", str);
          }
          paramExifInterface2.setAttribute("ImageDescription", paramExifInterface1.toString());
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("s E D = ");
            ((StringBuilder)localObject).append(paramExifInterface1.toString());
            QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
          }
        }
        catch (Throwable paramExifInterface1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("F s d ");
          ((StringBuilder)localObject).append(paramExifInterface1.getMessage());
          f(((StringBuilder)localObject).toString());
        }
      }
      try
      {
        paramExifInterface2.saveAttributes();
        return true;
      }
      catch (Exception paramExifInterface1)
      {
        paramExifInterface2 = new StringBuilder();
        paramExifInterface2.append("Failed to save EXIF. ");
        paramExifInterface2.append(paramExifInterface1.getMessage());
        f(paramExifInterface2.toString());
      }
    }
    return false;
  }
  
  public static boolean a(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((paramString != null) && (!JpegExifReader.isCrashJpeg(paramString))) {}
    try
    {
      localExifInterface = new ExifInterface(paramString);
      localExifInterface.setAttribute("GPSLatitude", a(paramDouble1));
      if (paramDouble1 <= 0.0D) {
        break label185;
      }
      paramString = "N";
    }
    catch (IOException|NullPointerException paramString)
    {
      for (;;)
      {
        ExifInterface localExifInterface;
        continue;
        paramString = "S";
        continue;
        paramString = "W";
      }
    }
    localExifInterface.setAttribute("GPSLatitudeRef", paramString);
    localExifInterface.setAttribute("GPSLongitude", a(paramDouble2));
    if (paramDouble2 > 0.0D)
    {
      paramString = "E";
      localExifInterface.setAttribute("GPSLongitudeRef", paramString);
      localExifInterface.saveAttributes();
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[updateLBSExif]GPSLatitude = ");
        paramString.append(localExifInterface.getAttribute("GPSLatitude"));
        paramString.append(", GPSLongitude = ");
        paramString.append(localExifInterface.getAttribute("GPSLongitude"));
        QLog.d("ImageUtil", 4, paramString.toString());
      }
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("ImageUtil", 4, "[updateLBSExif] failed");
      }
      return false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      if (JpegExifReader.isCrashJpeg(paramString1)) {
        return false;
      }
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString1.setAttribute("Orientation", paramString3);
      paramString1.saveAttributes();
      if (QLog.isDevelopLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("[updateExif]tag=");
        paramString1.append(paramString2);
        paramString1.append(", value=");
        paramString1.append(paramString3);
        QLog.d("ImageUtil", 4, paramString1.toString());
      }
      return true;
    }
    catch (IOException|NullPointerException|UnsupportedOperationException paramString1) {}
    return false;
    return false;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      int i;
      if (k > m) {
        i = m;
      } else {
        i = k;
      }
      int j;
      if (k > m) {
        j = (k - m) / 2;
      } else {
        j = 0;
      }
      if (k > m) {
        k = 0;
      } else {
        k = (m - k) / 2;
      }
      return Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
    }
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    double d2 = Math.toRadians(paramFloat);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    double d1 = Math.abs(Math.cos(d2));
    d2 = Math.abs(Math.sin(d2));
    double d3 = j;
    Double.isNaN(d3);
    double d4 = i;
    Double.isNaN(d4);
    int k = (int)(d3 * d2 + d4 * d1);
    Double.isNaN(d4);
    Double.isNaN(d3);
    int m = (int)(d4 * d2 + d3 * d1);
    float f1 = (k - i) / 2.0F;
    float f2 = (m - j) / 2.0F;
    Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.rotate(paramFloat, k / 2.0F, m / 2.0F);
    localCanvas.drawBitmap(paramBitmap, f1, f2, null);
    return localBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt1 > 0)) {
      if (paramInt2 <= 0) {
        return null;
      }
    }
    for (;;)
    {
      int k;
      try
      {
        m = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = new Paint();
        if (m <= paramInt1) {
          break label275;
        }
        i = (m - paramInt1) / 2;
        if (k <= paramInt2) {
          break label280;
        }
        j = (k - paramInt2) / 2;
      }
      catch (Throwable paramBitmap)
      {
        Rect localRect1;
        Rect localRect2;
        RectF localRectF;
        Bitmap localBitmap;
        Canvas localCanvas;
        if (!QLog.isColorLevel()) {
          break label273;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getClipCenterRectBitmap throw error ... ");
        ((StringBuilder)localObject).append(paramBitmap.getMessage());
        QLog.e("ImageUtil", 2, ((StringBuilder)localObject).toString());
      }
      localRect1 = new Rect(i, j, paramInt1, paramInt2);
      localRect2 = new Rect(0, 0, paramInt1 - i, paramInt2 - j);
      localRectF = new RectF(localRect2);
      localBitmap = Bitmap.createBitmap(localRect2.right, localRect2.bottom, Bitmap.Config.RGB_565);
      localCanvas = new Canvas(localBitmap);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setDither(true);
      ((Paint)localObject).setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      ((Paint)localObject).setColor(-12434878);
      localCanvas.drawRect(localRectF, (Paint)localObject);
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, (Paint)localObject);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
      return localBitmap;
      label273:
      return null;
      label275:
      int i = 0;
      continue;
      label280:
      int j = 0;
      int n = paramInt1 + i;
      paramInt1 = n;
      if (n > m) {
        paramInt1 = m;
      }
      int m = paramInt2 + j;
      paramInt2 = m;
      if (m > k) {
        paramInt2 = k;
      }
    }
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    Object localObject = null;
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      localObject = localBitmap;
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw((Canvas)localObject);
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public static Bitmap b(boolean paramBoolean)
  {
    int i;
    Object localObject;
    if ((!paramBoolean) && (QQTheme.isNowSimpleUI()))
    {
      i = 2130841061;
      localObject = "static://DefaultFace_square";
    }
    else
    {
      localObject = "static://DefaultFace";
      i = 2130841060;
    }
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(localObject);
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), i);
      if ((localBitmap1 != null) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.put(localObject, localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultFaceBitmap, bitmap=");
        ((StringBuilder)localObject).append(localBitmap1);
        QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Drawable b()
  {
    return new BitmapDrawable(a());
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(paramContext, paramUri);
  }
  
  public static void b(Context paramContext, File paramFile)
  {
    try
    {
      Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_data='");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append("'");
      paramFile = localStringBuilder.toString();
      paramContext.getContentResolver().delete(localUri, paramFile, null);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ImageUtil", 1, "deletePic2SystemMedia fail.", paramContext);
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramString);
  }
  
  private static void b(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, boolean paramBoolean)
  {
    String str2 = paramExifInterface1.getAttribute("DateTime");
    String str3 = paramExifInterface1.getAttribute("Flash");
    String str4 = paramExifInterface1.getAttribute("FocalLength");
    String str5 = paramExifInterface1.getAttribute("GPSAltitude");
    String str6 = paramExifInterface1.getAttribute("GPSAltitudeRef");
    String str7 = paramExifInterface1.getAttribute("GPSDateStamp");
    String str8 = paramExifInterface1.getAttribute("GPSLatitude");
    String str9 = paramExifInterface1.getAttribute("GPSLatitudeRef");
    String str10 = paramExifInterface1.getAttribute("GPSLongitude");
    String str11 = paramExifInterface1.getAttribute("GPSLongitudeRef");
    String str12 = paramExifInterface1.getAttribute("GPSProcessingMethod");
    String str13 = paramExifInterface1.getAttribute("GPSTimeStamp");
    String str14 = paramExifInterface1.getAttribute("ISOSpeedRatings");
    String str15 = paramExifInterface1.getAttribute("Make");
    String str1 = paramExifInterface1.getAttribute("Model");
    String str16 = paramExifInterface1.getAttribute("WhiteBalance");
    String str17 = paramExifInterface1.getAttribute("UserComment");
    paramExifInterface1 = paramExifInterface1.getAttribute("ImageDescription");
    if ((paramExifInterface1 != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("E D = ");
      localStringBuilder.append(paramExifInterface1);
      QLog.d("ImageUtil", 2, localStringBuilder.toString());
    }
    if ((str2 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("DateTime", str2);
    } else {
      paramExifInterface2.setAttribute("DateTime", "");
    }
    if (str3 != null) {
      paramExifInterface2.setAttribute("Flash", str3);
    }
    if (str4 != null) {
      paramExifInterface2.setAttribute("FocalLength", str4);
    }
    if ((str5 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSAltitude", str5);
    }
    if ((str6 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSAltitudeRef", str6);
    }
    if ((str7 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSDateStamp", str7);
    }
    if ((str8 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSLatitude", str8);
    }
    if ((str9 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSLatitudeRef", str9);
    }
    if ((str10 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSLongitude", str10);
    }
    if ((str11 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSLongitudeRef", str11);
    }
    if ((str12 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSProcessingMethod", str12);
    }
    if ((str13 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("GPSTimeStamp", str13);
    }
    if (str14 != null) {
      paramExifInterface2.setAttribute("ISOSpeedRatings", str14);
    }
    if ((str15 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("Make", str15);
    }
    if ((str1 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("Model", str1);
    }
    if (str16 != null) {
      paramExifInterface2.setAttribute("WhiteBalance", str16);
    }
    if ((str17 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("UserComment", str17);
    }
  }
  
  /* Error */
  public static boolean b(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 541	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 956	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 618	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 621	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 959	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 636	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 621	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 962	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 642	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore 4
    //   53: aconst_null
    //   54: astore_3
    //   55: new 822	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 824	java/io/FileOutputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 825	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 828	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   70: astore_2
    //   71: aload_0
    //   72: getstatic 852	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   75: iload_1
    //   76: aload_2
    //   77: invokevirtual 838	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 965	java/io/BufferedOutputStream:flush	()V
    //   85: aload_2
    //   86: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_0
    //   92: aload_2
    //   93: astore_3
    //   94: goto +19 -> 113
    //   97: astore_0
    //   98: aload_2
    //   99: astore_3
    //   100: goto +11 -> 111
    //   103: astore_0
    //   104: goto +9 -> 113
    //   107: astore_0
    //   108: aload 4
    //   110: astore_3
    //   111: aload_0
    //   112: athrow
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 966	java/io/BufferedOutputStream:close	()V
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramBitmap	Bitmap
    //   0	123	1	paramInt	int
    //   0	123	2	paramFile	File
    //   11	107	3	localObject1	Object
    //   51	58	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	85	91	finally
    //   71	85	97	java/io/IOException
    //   55	71	103	finally
    //   111	113	103	finally
    //   55	71	107	java/io/IOException
  }
  
  public static boolean b(Bitmap paramBitmap, File paramFile)
  {
    return b(paramBitmap, 100, paramFile);
  }
  
  public static boolean b(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return false;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      if (localOptions.outWidth > 0) {
        return localOptions.outHeight > 0;
      }
      return false;
    }
    catch (Exception|OutOfMemoryError paramString) {}
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals(paramString2)) && (!JpegExifReader.isCrashJpeg(paramString1))) {
      try
      {
        paramString1 = new ExifInterface(paramString1);
        ExifInterface localExifInterface = new ExifInterface(paramString2);
        int i = paramString1.getAttributeInt("Orientation", 0);
        paramString2 = new StringBuilder();
        paramString2.append(i);
        paramString2.append("");
        localExifInterface.setAttribute("Orientation", paramString2.toString());
        paramString2 = paramString1.getAttribute("DateTime");
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        localExifInterface.setAttribute("DateTime", paramString1);
        localExifInterface.saveAttributes();
        return true;
      }
      catch (UnsupportedOperationException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImageUtil", 2, "copyExif ", paramString1);
        }
        return false;
      }
      catch (IOException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImageUtil", 2, "copyExif ", paramString1);
        }
      }
    }
    return false;
  }
  
  public static Bitmap c()
  {
    Bitmap localBitmap;
    if (GlobalImageCache.a != null) {
      localBitmap = (Bitmap)GlobalImageCache.a.get("static://DefaultPhoneContactFace");
    } else {
      localBitmap = null;
    }
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = BitmapManager.b(BaseApplication.getContext().getResources(), 2130841162);
      if ((localBitmap != null) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.put("static://DefaultPhoneContactFace", localBitmap);
      }
      localObject = localBitmap;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultPhoneContactBitmap, bitmap=");
        ((StringBuilder)localObject).append(localBitmap);
        QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
        localObject = localBitmap;
      }
    }
    return localObject;
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return paramBitmap;
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = k;
    float f2 = m;
    float f3 = 1.0F * f1 / f2;
    if (f3 == paramFloat) {
      return paramBitmap;
    }
    int j;
    int i;
    if (f3 > paramFloat)
    {
      j = (int)(f2 * paramFloat);
      i = m;
    }
    else
    {
      i = (int)(f1 / paramFloat);
      j = k;
    }
    return Bitmap.createBitmap(paramBitmap, (k - j) / 2, (m - i) / 2, j, i);
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
      int m = (int)Math.ceil(paramBitmap.getWidth() / f);
      int n = (int)Math.ceil(paramBitmap.getHeight() / f);
      Object localObject;
      if (m == paramInt1)
      {
        localObject = paramBitmap;
        if (n == paramInt2) {}
      }
      else
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
        int j = (m - paramInt1) / 2;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        int k = (n - paramInt2) / 2;
        j = k;
        if (k < 0) {
          j = 0;
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ROUND_CORNER_DECODER scale = ");
          ((StringBuilder)localObject).append(f);
          ((StringBuilder)localObject).append(", scaledWidth = ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(", scaledHeight = ");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(", xTopLeft = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", yTopLeft = ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(", width = ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", height = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
        }
        localObject = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
        paramBitmap.recycle();
      }
      paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(paramBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap((Bitmap)localObject, localRect1, localRect2, localPaint);
      ((Bitmap)localObject).recycle();
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
      }
    }
    return null;
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f2 = f1;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt1;
      f2 = f1;
      if (f3 < f1 * f4) {
        f2 = f3 / f4;
      }
    }
    i = (paramInt1 + paramInt2) / 2;
    if (i < 35) {
      f1 = 2.0F;
    }
    for (;;)
    {
      i = (int)(f1 * f2);
      break;
      if (i < 50) {
        f1 = 3.0F;
      } else if (i < 64) {
        f1 = 5.0F;
      } else {
        f1 = 6.0F;
      }
    }
    paramInt1 = (int)(paramInt1 * f2);
    paramInt2 = (int)(paramInt2 * f2);
    return a(paramBitmap, i, paramInt1, paramInt2);
  }
  
  public static Bitmap c(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicWidth();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      if (paramDrawable.getOpacity() != -1) {
        paramDrawable = Bitmap.Config.ARGB_8888;
      } else {
        paramDrawable = Bitmap.Config.RGB_565;
      }
      paramDrawable = Bitmap.createBitmap(i, j, paramDrawable);
      if (paramDrawable != null)
      {
        Canvas localCanvas = new Canvas(paramDrawable);
        Paint localPaint = new Paint();
        localCanvas.drawBitmap(paramDrawable, new Matrix(), localPaint);
      }
      return paramDrawable;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
    return null;
  }
  
  public static boolean c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isGifFile result:");
        paramString.append(bool);
        QLog.d("_photo", 2, paramString.toString());
      }
      return bool;
    }
    return false;
  }
  
  public static int d(String paramString)
  {
    int k = 0;
    StringBuilder localStringBuilder;
    try
    {
      paramString = Class.forName("android.media.ExifInterface").getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(paramString.toString());
        QLog.e("reflection", 2, localStringBuilder.toString());
      }
      paramString = null;
    }
    int j = k;
    if (paramString != null)
    {
      int i;
      try
      {
        i = ((Integer)paramString.getClass().getMethod("getAttributeInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString, new Object[] { "Orientation", Integer.valueOf(-1) })).intValue();
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("e = ");
          localStringBuilder.append(paramString.toString());
          QLog.e("reflection", 2, localStringBuilder.toString());
        }
        i = 0;
      }
      j = k;
      if (i != -1)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 8) {
              return 0;
            }
            return 270;
          }
          return 90;
        }
        j = 180;
      }
    }
    return j;
  }
  
  public static Bitmap d(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = paramBitmap;
    if (localBitmap == null) {
      return null;
    }
    try
    {
      float f2 = paramBitmap.getWidth() / paramInt1;
      float f3 = paramBitmap.getHeight();
      float f1 = paramInt2;
      f2 = Math.min(f2, f3 / f1);
      int m = (int)Math.ceil(paramBitmap.getWidth() / f2);
      int n = (int)Math.ceil(paramBitmap.getHeight() / f2);
      if (m == paramInt1)
      {
        paramBitmap = localBitmap;
        if (n == paramInt2) {}
      }
      else
      {
        localBitmap = Bitmap.createScaledBitmap(localBitmap, m, n, true);
        int j = (m - paramInt1) / 2;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        int k = (n - paramInt2) / 2;
        j = k;
        if (k < 0) {
          j = 0;
        }
        if (QLog.isColorLevel())
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("HALF_ROUND_CORNER_DECODER scale = ");
          paramBitmap.append(f2);
          paramBitmap.append(", scaledWidth = ");
          paramBitmap.append(m);
          paramBitmap.append(", scaledHeight = ");
          paramBitmap.append(n);
          paramBitmap.append(", xTopLeft = ");
          paramBitmap.append(i);
          paramBitmap.append(", yTopLeft = ");
          paramBitmap.append(j);
          paramBitmap.append(", width = ");
          paramBitmap.append(paramInt1);
          paramBitmap.append(", height = ");
          paramBitmap.append(paramInt2);
          paramBitmap.append(" roundPx: ");
          paramBitmap.append(paramFloat);
          QLog.d("ImageUtil", 2, paramBitmap.toString());
        }
        paramBitmap = Bitmap.createBitmap(localBitmap, i, j, paramInt1, paramInt2);
        localBitmap.recycle();
      }
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Rect localRect3 = new Rect(0, (int)(f1 - paramFloat), paramInt1, (int)(f1 + paramFloat));
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localCanvas.drawRect(localRect3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap d(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int j = paramBitmap.getWidth();
      int i = paramInt2 * 2;
      j += i;
      i = paramBitmap.getHeight() + i;
      Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(paramInt2, paramInt2, paramBitmap.getWidth() + paramInt2, paramBitmap.getHeight() + paramInt2);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      localPaint.setColor(paramInt1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(paramInt2);
      localCanvas.drawCircle(j / 2, i / 2, j / 2 - paramInt2 / 2, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static Drawable d()
  {
    return new BitmapDrawable(e());
  }
  
  public static byte[] d(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static Bitmap e()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultSubAccountFace");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), 2130841183);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("static://DefaultSubAccountFace", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap e(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      paramInt1 = j - paramInt1;
      j = i - paramInt2;
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, paramInt2, paramInt1, i);
      Rect localRect2 = new Rect(0, 0, paramInt1, j);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      paramString = new FileInputStream(paramString);
      bool1 = bool2;
      bool2 = "jpg".equals(a(paramString));
      bool1 = bool2;
      paramString.close();
      return bool2;
    }
    catch (Exception paramString)
    {
      f(paramString.toString());
    }
    return bool1;
  }
  
  public static Drawable f()
  {
    return new BitmapDrawable(g());
  }
  
  static void f(String paramString)
  {
    if ((QLog.isColorLevel()) || (UtilApi.b.c())) {
      QLog.e("ImageUtil", 2, paramString);
    }
  }
  
  public static int g(String paramString)
  {
    int i = JpegExifReader.readOrientation(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  public static Bitmap g()
  {
    int i;
    String str;
    if (QQTheme.isNowSimpleUI())
    {
      i = 2130841061;
      str = "static://DefaultTroopFace_square";
    }
    else
    {
      str = "static://DefaultTroopFace";
      i = 2130841348;
    }
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(str);
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = c(BitmapManager.b(BaseApplication.getContext().getResources(), i), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put(str, localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static int h(String paramString)
  {
    if (PhotoIncompatibleBase.b(paramString))
    {
      int i = Utils.getHeifOrientation(paramString);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    return JpegExifReader.getRotationDegree(paramString);
  }
  
  public static Drawable h()
  {
    return new BitmapDrawable(i());
  }
  
  public static Bitmap i()
  {
    Object localObject1;
    if (GlobalImageCache.a != null) {
      localObject1 = (Bitmap)GlobalImageCache.a.get("static://DefaultDiscusionFace");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130841348);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label45:
      break label45;
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (GlobalImageCache.a != null)
      {
        GlobalImageCache.a.put("static://DefaultDiscusionFace", localObject1);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public static Drawable j()
  {
    return new BitmapDrawable(k());
  }
  
  public static Bitmap k()
  {
    return b(true);
  }
  
  public static Bitmap l()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultSystemIcon");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), 2130852745);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("static://DefaultSystemIcon", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable m()
  {
    return new BitmapDrawable(n());
  }
  
  public static Bitmap n()
  {
    Bitmap localBitmap;
    if (GlobalImageCache.a != null) {
      localBitmap = (Bitmap)GlobalImageCache.a.get("static://DefaultFace140_140");
    } else {
      localBitmap = null;
    }
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = BitmapManager.b(BaseApplication.getContext().getResources(), 2130841062);
      if ((localBitmap != null) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.put("static://DefaultFace140_140", localBitmap);
      }
      localObject = localBitmap;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultFaceBitmap140_140, bitmap=");
        ((StringBuilder)localObject).append(localBitmap);
        QLog.d("ImageUtil", 2, ((StringBuilder)localObject).toString());
        localObject = localBitmap;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseImageUtil
 * JD-Core Version:    0.7.0.1
 */