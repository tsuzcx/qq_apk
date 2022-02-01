package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
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
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

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
    double d3 = 1.0D;
    if ((i <= paramInt1) && (j <= paramInt2)) {
      return d3;
    }
    double d1;
    if (i > j) {
      d1 = i / paramInt1;
    }
    for (double d2 = j / paramInt2;; d2 = i / paramInt2)
    {
      d3 = d1;
      if (d1 > d2) {
        break;
      }
      return d2;
      d1 = j / paramInt1;
    }
  }
  
  public static int a(int paramInt)
  {
    int i = 10;
    if (paramInt < 100) {
      i = 3;
    }
    while (paramInt >= 140) {
      return i;
    }
    return 7;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 1;
    int i = j;
    if (paramInt1 != 0)
    {
      i = j;
      if (paramInt2 != 0)
      {
        i = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i = j;
        }
      }
    }
    return i;
    label43:
    float f = paramOptions.outWidth * paramOptions.outHeight / (paramInt1 * paramInt2);
    paramInt1 = k;
    for (;;)
    {
      i = paramInt1;
      if (f <= 1.0F) {
        break;
      }
      paramInt1 *= 2;
      f /= 4.0F;
    }
  }
  
  public static int a(ExifInterface paramExifInterface)
  {
    int j = 0;
    int i = j;
    if (paramExifInterface != null)
    {
      int k = paramExifInterface.getAttributeInt("Orientation", -1);
      a("getExifOrientation  orientation  =====" + k + "=====");
      i = j;
      if (k != -1)
      {
        i = j;
        switch (k)
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      a("getExifOrientation degree =======" + i + "==========");
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = Class.forName("android.media.ExifInterface").getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        i = ((Integer)paramString.getClass().getMethod("getAttributeInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString, new Object[] { "Orientation", Integer.valueOf(-1) })).intValue();
        if (i != -1) {}
        switch (i)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          paramString = null;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          int i = 0;
        }
        return 90;
      }
    }
    return 180;
    return 270;
  }
  
  public static Bitmap a()
  {
    String str = "static://DefaultTroopFace";
    int i = 2130840707;
    if (((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI())
    {
      str = "static://DefaultTroopFace_square";
      i = 2130840453;
    }
    if (GlobalImageCache.a != null) {}
    for (Bitmap localBitmap1 = (Bitmap)GlobalImageCache.a.get(str);; localBitmap1 = null)
    {
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
  
  /* Error */
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 276	android/util/TypedValue
    //   5: dup
    //   6: invokespecial 277	android/util/TypedValue:<init>	()V
    //   9: astore 4
    //   11: new 279	java/io/BufferedInputStream
    //   14: dup
    //   15: aload_0
    //   16: iload_1
    //   17: aload 4
    //   19: invokevirtual 285	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   22: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_0
    //   27: aload 4
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokestatic 294	android/graphics/BitmapFactory:decodeResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_3
    //   39: astore_0
    //   40: aload_2
    //   41: ifnull +9 -> 50
    //   44: aload_2
    //   45: invokevirtual 299	java/io/InputStream:close	()V
    //   48: aload_3
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_3
    //   56: astore_0
    //   57: aload_2
    //   58: ifnull -8 -> 50
    //   61: aload_2
    //   62: invokevirtual 299	java/io/InputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_3
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull -26 -> 50
    //   79: aload_2
    //   80: invokevirtual 299	java/io/InputStream:close	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 299	java/io/InputStream:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_3
    //   103: areturn
    //   104: astore_2
    //   105: goto -6 -> 99
    //   108: astore_0
    //   109: goto -18 -> 91
    //   112: astore_0
    //   113: goto -40 -> 73
    //   116: astore_0
    //   117: goto -62 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramResources	Resources
    //   0	120	1	paramInt	int
    //   25	71	2	localBufferedInputStream	java.io.BufferedInputStream
    //   104	1	2	localIOException	IOException
    //   1	102	3	localResources	Resources
    //   9	19	4	localTypedValue	android.util.TypedValue
    // Exception table:
    //   from	to	target	type
    //   2	26	52	java/lang/OutOfMemoryError
    //   61	65	67	java/io/IOException
    //   2	26	70	java/lang/Throwable
    //   79	83	85	java/io/IOException
    //   2	26	88	finally
    //   44	48	101	java/io/IOException
    //   95	99	104	java/io/IOException
    //   26	36	108	finally
    //   26	36	112	java/lang/Throwable
    //   26	36	116	java/lang/OutOfMemoryError
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
      localObject = paramBitmap;
      if (localBitmap != null)
      {
        localObject = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        ColorMatrix localColorMatrix = new ColorMatrix();
        localColorMatrix.setSaturation(0.0F);
        localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
        ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        Object localObject = paramBitmap;
      } while (!QLog.isColorLevel());
      QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
    }
    return localObject;
    return paramBitmap;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {}
    do
    {
      return localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          a("OOM occurred in ImageUtil.round" + localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    localObject2 = new Canvas(localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        a("cutOurImg() img:[" + f1 + ", " + f2 + "], default: [" + paramFloat1 + ", " + paramFloat2 + "]");
        float f3 = paramFloat1 / f1;
        float f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          j = (int)paramFloat1;
          i = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(j / f1, i / f2);
          localMatrix.postTranslate((paramFloat1 - j) / 2.0F, (paramFloat2 - i) / 2.0F);
          Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.RGB_565);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          paramBitmap = localBitmap;
          return paramBitmap;
        }
        int j = (int)(f1 * f4);
        int i = (int)paramFloat2;
        continue;
        paramBitmap = null;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        return null;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
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
      try
      {
        int j = paramBitmap.getWidth();
        int i = paramBitmap.getHeight();
        if (j > i)
        {
          m = (j - i) / 2;
          k = 0;
          paramInt1 = paramInt2;
          j = i;
          break label257;
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(m, k, j + m, i + k);
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
        else if (i > j)
        {
          k = (i - j) / 2;
          int n = 0;
          paramInt2 = paramInt1;
          m = j;
          i = j;
          j = m;
          m = n;
        }
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
      int k = 0;
      int m = 0;
      label257:
      if (!paramBoolean) {
        paramFloat = paramInt1;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {
      return localObject2;
    }
    localObject2 = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = paramInt / (Math.max(i, j) * 1.0F);
    if ((f != 1.0F) && (f > 0.0F)) {}
    for (;;)
    {
      try
      {
        ((Matrix)localObject2).postScale(f, f);
        localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject2, true);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        a("compress :" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a("compress :  scaleBitmap OOM");
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramBitmap == null) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.isRecycled()) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.equals(localObject1)) {
          break;
        }
        paramBitmap.recycle();
        return localObject1;
      }
      return paramBitmap;
      localObject1 = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
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
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
        int m = (int)Math.ceil(paramBitmap.getWidth() / f);
        int n = (int)Math.ceil(paramBitmap.getHeight() / f);
        Bitmap localBitmap1;
        if (m == paramInt1)
        {
          localBitmap1 = paramBitmap;
          if (n == paramInt2) {}
        }
        else
        {
          paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
          int i = (m - paramInt1) / 2;
          if (i >= 0) {
            break label461;
          }
          i = 0;
          int k = (n - paramInt2) / 2;
          int j = k;
          if (k < 0) {
            j = 0;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2);
          }
          localBitmap1 = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
          paramBitmap.recycle();
        }
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
        Canvas localCanvas = new Canvas(localBitmap2);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
        Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
        RectF localRectF = new RectF(localRect2);
        switch (paramInt4)
        {
        case 1: 
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          localCanvas.drawRoundRect(localRectF, paramInt3, paramInt3, localPaint);
          if (paramBitmap != null) {
            localCanvas.drawRect(paramBitmap, localPaint);
          }
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(localBitmap1, localRect1, localRect2, localPaint);
          localBitmap1.recycle();
          return localBitmap2;
        }
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
        }
        return null;
      }
      label461:
      continue;
      paramBitmap = new Rect(0, paramInt3, paramInt1, paramInt2 + paramInt3);
      continue;
      paramBitmap = new Rect(0, -paramInt3, paramInt1, paramInt2 - paramInt3);
      continue;
      paramBitmap = new Rect(paramInt3, 0, paramInt1 + paramInt3, paramInt2);
      continue;
      paramBitmap = new Rect(-paramInt3, 0, paramInt1 - paramInt3, paramInt2);
      continue;
      paramBitmap = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramBitmap == null) || (paramInt1 == 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = BaseApplication.getContext().getResources();
        Drawable localDrawable = ((Resources)localObject).getDrawable(paramInt1);
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
        localBitmap.setDensity(((Resources)localObject).getDisplayMetrics().densityDpi);
        localObject = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        ((Canvas)localObject).drawARGB(0, 0, 0, 0);
        Rect localRect2 = new Rect(0, 0, paramInt2, paramInt3);
        localDrawable.setBounds(localRect2);
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        ((Canvas)localObject).drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
        paramInt1 = DisplayUtil.a(BaseApplication.getContext(), 55.0F);
        if ((paramBoolean) && (paramInt3 > paramInt1))
        {
          localPaint.setShader(new LinearGradient(0.0F, paramInt3 - paramInt1, 0.0F, paramInt3, 0, -1728053248, Shader.TileMode.CLAMP));
          ((Canvas)localObject).drawRect(localRect2, localPaint);
        }
        if ((localDrawable instanceof SkinnableNinePatchDrawable))
        {
          ((SkinnableNinePatchDrawable)localDrawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          localDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        if ((localDrawable instanceof NinePatchDrawable)) {
          ((NinePatchDrawable)localDrawable).getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        } else {
          QLog.e("ImageUtil", 1, "invalid drawable resource :" + localDrawable.getClass().getName());
        }
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("ImageUtil", 1, "clip bitmap error:" + paramBitmap.getMessage());
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, int paramInt)
  {
    if (paramBitmap != null) {
      try
      {
        if ((paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right <= paramBitmap.getWidth()) && (paramRect.bottom <= paramBitmap.getHeight()))
        {
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
          paramRect = localBitmap;
          if (paramBitmap.isRecycled()) {
            return paramRect;
          }
          paramBitmap.recycle();
          return localBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImageUtil", 2, "getClipRectBitmap throw error ... " + paramBitmap.getMessage());
        }
        return null;
      }
    } else {
      paramRect = null;
    }
    return paramRect;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = paramBitmap;
      if (localBitmap == null) {
        break label195;
      }
      localObject = new Canvas(localBitmap);
      if (((Canvas)localObject).getDensity() != paramBitmap.getDensity()) {
        ((Canvas)localObject).setDensity(paramBitmap.getDensity());
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setColor(Color.parseColor("#80000000"));
      RectF localRectF = new RectF(0.0F, 0.0F, i, j);
      if (paramBoolean) {
        ((Canvas)localObject).drawRoundRect(localRectF, i / 2, j / 2, localPaint);
      } else {
        ((Canvas)localObject).drawRect(localRectF, localPaint);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject = paramBitmap;
      if (!QLog.isColorLevel()) {
        break label195;
      }
    }
    QLog.d("ImageUtil", 2, "grey bitmap, oom, stack:" + MsfSdkUtils.getStackTraceString(localOutOfMemoryError));
    return paramBitmap;
    Object localObject = localOutOfMemoryError;
    label195:
    return localObject;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return localObject;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicWidth();
      localObject = localBitmap;
      if (i <= 0) {
        continue;
      }
      localObject = localBitmap;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          localObject = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject = new Canvas(localBitmap);
          paramDrawable.setBounds(0, 0, i, j);
          paramDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return null;
    }
    int m = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    if ((m <= 0) || (k <= 0)) {
      return null;
    }
    int j = k;
    int i = m;
    float f1;
    float f2;
    if (paramInt1 > 0)
    {
      j = k;
      i = m;
      if (paramInt2 > 0)
      {
        f1 = paramInt1 / m;
        f2 = paramInt2 / k;
        if (f1 >= f2) {
          break label165;
        }
      }
    }
    for (;;)
    {
      j = k;
      i = m;
      if (f1 < 1.0F)
      {
        i = (int)(m * f1);
        j = (int)(k * f1);
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          if (localObject != null)
          {
            Canvas localCanvas = new Canvas((Bitmap)localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
          }
          return localObject;
          label165:
          f1 = f2;
          break;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: aload_0
    //   8: ifnull +143 -> 151
    //   11: new 17	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 7
    //   20: aload 7
    //   22: iconst_1
    //   23: putfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   26: new 279	java/io/BufferedInputStream
    //   29: dup
    //   30: new 630	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore 5
    //   43: aload 5
    //   45: aconst_null
    //   46: aload 7
    //   48: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: pop
    //   52: aload 7
    //   54: getfield 31	android/graphics/BitmapFactory$Options:outWidth	I
    //   57: istore_3
    //   58: aload 7
    //   60: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   63: istore 4
    //   65: new 17	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 7
    //   74: aload 7
    //   76: iload_3
    //   77: iload_1
    //   78: idiv
    //   79: iload 4
    //   81: iload_2
    //   82: idiv
    //   83: invokestatic 438	java/lang/Math:max	(II)I
    //   86: putfield 635	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload 7
    //   91: iconst_0
    //   92: putfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   95: aload 7
    //   97: iconst_1
    //   98: putfield 638	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   101: aload 5
    //   103: invokevirtual 299	java/io/InputStream:close	()V
    //   106: new 279	java/io/BufferedInputStream
    //   109: dup
    //   110: new 630	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   118: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore_0
    //   122: aload_0
    //   123: aconst_null
    //   124: aload 7
    //   126: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: astore 5
    //   131: aload 5
    //   133: astore 6
    //   135: aload 6
    //   137: astore 5
    //   139: aload_0
    //   140: ifnull +11 -> 151
    //   143: aload_0
    //   144: invokevirtual 299	java/io/InputStream:close	()V
    //   147: aload 6
    //   149: astore 5
    //   151: aload 5
    //   153: areturn
    //   154: astore 5
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 5
    //   160: invokevirtual 433	java/lang/Throwable:printStackTrace	()V
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: ifnull -17 -> 151
    //   171: aload_0
    //   172: invokevirtual 299	java/io/InputStream:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore 5
    //   184: aload 5
    //   186: ifnull +8 -> 194
    //   189: aload 5
    //   191: invokevirtual 299	java/io/InputStream:close	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: aload 6
    //   199: areturn
    //   200: astore 5
    //   202: goto -8 -> 194
    //   205: astore_0
    //   206: goto -22 -> 184
    //   209: astore 6
    //   211: aload_0
    //   212: astore 5
    //   214: aload 6
    //   216: astore_0
    //   217: goto -33 -> 184
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: goto -44 -> 184
    //   231: astore 7
    //   233: aload 5
    //   235: astore_0
    //   236: aload 7
    //   238: astore 5
    //   240: goto -82 -> 158
    //   243: astore 5
    //   245: goto -87 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString	String
    //   0	248	1	paramInt1	int
    //   0	248	2	paramInt2	int
    //   57	22	3	i	int
    //   63	20	4	j	int
    //   5	147	5	localObject1	Object
    //   154	5	5	localThrowable1	Throwable
    //   165	25	5	localObject2	Object
    //   200	1	5	localIOException	IOException
    //   212	27	5	localObject3	Object
    //   243	1	5	localThrowable2	Throwable
    //   1	197	6	localObject4	Object
    //   209	6	6	localObject5	Object
    //   220	6	6	localObject6	Object
    //   18	107	7	localOptions	BitmapFactory.Options
    //   231	6	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	43	154	java/lang/Throwable
    //   171	175	177	java/io/IOException
    //   11	43	180	finally
    //   143	147	196	java/io/IOException
    //   189	194	200	java/io/IOException
    //   43	122	205	finally
    //   122	131	209	finally
    //   158	163	220	finally
    //   43	122	231	java/lang/Throwable
    //   122	131	243	java/lang/Throwable
  }
  
  /* Error */
  @java.lang.Deprecated
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +52 -> 55
    //   6: aload_1
    //   7: getfield 22	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   10: ifeq +45 -> 55
    //   13: new 279	java/io/BufferedInputStream
    //   16: dup
    //   17: new 630	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: sipush 2048
    //   28: invokespecial 643	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   31: astore_0
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: aconst_null
    //   36: aload_1
    //   37: invokestatic 644	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 299	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: astore_2
    //   53: aload_2
    //   54: areturn
    //   55: new 279	java/io/BufferedInputStream
    //   58: dup
    //   59: new 630	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: goto -39 -> 32
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: astore_2
    //   79: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +16 -> 98
    //   85: aload_0
    //   86: astore_2
    //   87: ldc_w 331
    //   90: iconst_2
    //   91: ldc_w 646
    //   94: aload_1
    //   95: invokestatic 648	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: ifnull -48 -> 53
    //   104: aload_0
    //   105: invokevirtual 299	java/io/InputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 299	java/io/InputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_0
    //   127: aload_1
    //   128: areturn
    //   129: astore_1
    //   130: goto -6 -> 124
    //   133: astore_0
    //   134: goto -18 -> 116
    //   137: astore_1
    //   138: goto -61 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramOptions	BitmapFactory.Options
    //   33	88	2	localObject1	Object
    //   1	98	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	32	74	java/lang/Exception
    //   55	71	74	java/lang/Exception
    //   104	108	110	java/io/IOException
    //   6	32	113	finally
    //   55	71	113	finally
    //   47	51	126	java/io/IOException
    //   120	124	129	java/io/IOException
    //   34	41	133	finally
    //   79	85	133	finally
    //   87	98	133	finally
    //   34	41	137	java/lang/Exception
  }
  
  public static Bitmap a(boolean paramBoolean)
  {
    Object localObject1 = "static://DefaultFace";
    int j = 2130840452;
    int i = j;
    Object localObject2 = localObject1;
    if (!paramBoolean)
    {
      i = j;
      localObject2 = localObject1;
      if (((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI())
      {
        localObject2 = "static://DefaultFace_square";
        i = 2130840453;
      }
    }
    if (GlobalImageCache.a != null) {}
    for (localObject1 = (Bitmap)GlobalImageCache.a.get(localObject2);; localObject1 = null)
    {
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = BitmapManager.b(BaseApplication.getContext().getResources(), i);
        if ((localObject1 != null) && (GlobalImageCache.a != null)) {
          GlobalImageCache.a.put(localObject2, localObject1);
        }
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("ImageUtil", 2, "getDefaultFaceBitmap, bitmap=" + localObject1);
          localObject3 = localObject1;
        }
      }
      return localObject3;
    }
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    int m = 1;
    paramOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int j = 1;
    if ((i > paramInt) || (k > paramInt))
    {
      if (Math.round(Math.max(i, k) / (paramInt * 1.0F)) < 2) {
        break label144;
      }
      k /= 2;
      i /= 2;
      if ((k >= paramInt) || (i >= paramInt)) {
        break label113;
      }
      paramOptions.inSampleSize = j;
    }
    label144:
    for (;;)
    {
      paramOptions.inJustDecodeBounds = false;
      paramInt = m;
      if (paramOptions.inSampleSize >= 1) {
        paramInt = paramOptions.inSampleSize;
      }
      paramOptions.inSampleSize = paramInt;
      return paramOptions;
      label113:
      if ((k == paramInt) || (i == paramInt))
      {
        paramOptions.inSampleSize = (j * 2);
      }
      else
      {
        j *= 2;
        break;
        paramOptions.inSampleSize = j;
      }
    }
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
    for (;;)
    {
      if (localOptions.outWidth > paramInt1)
      {
        localOptions.inSampleSize += 1;
        localFileInputStream = new FileInputStream(paramFile);
        SafeBitmapFactory.decodeStream(localFileInputStream, null, localOptions);
        localFileInputStream.close();
        if (paramInt2 <= 3) {}
      }
      else
      {
        localOptions.inJustDecodeBounds = false;
        return localOptions;
      }
      paramInt2 += 1;
    }
  }
  
  public static BitmapFactory.Options a(String paramString, int paramInt)
  {
    int m = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int k = localOptions.outWidth;
    a("compressAIOThumbImg  org width:" + k + ",height:" + i);
    int j = 1;
    if ((i > paramInt) && (k > paramInt))
    {
      if (Math.min(Math.round(i / paramInt), Math.round(k / paramInt)) < 2) {
        break label198;
      }
      k /= 2;
      i /= 2;
      if ((k >= paramInt) && (i >= paramInt)) {
        break label169;
      }
      localOptions.inSampleSize = j;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      paramInt = m;
      if (localOptions.inSampleSize >= 1) {
        paramInt = localOptions.inSampleSize;
      }
      localOptions.inSampleSize = paramInt;
      return localOptions;
      label169:
      if ((k == paramInt) || (i == paramInt))
      {
        localOptions.inSampleSize = (j * 2);
      }
      else
      {
        j *= 2;
        break;
        label198:
        localOptions.inSampleSize = j;
      }
    }
  }
  
  public static Rect a(Rect paramRect, int paramInt, float paramFloat)
  {
    if ((paramRect != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      int k = (int)(paramInt * paramFloat);
      int i = paramRect.width();
      int j = paramRect.width();
      if (i > j) {}
      for (paramInt = i; paramInt < k; paramInt = j)
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
    int j;
    int k;
    if ((paramDrawable != null) && (paramInt2 > 0) && (paramInt1 > 0) && (paramInt2 > paramInt1) && (paramFloat > 0.0F))
    {
      j = paramDrawable.getIntrinsicWidth();
      k = paramDrawable.getIntrinsicHeight();
      if (j <= k) {
        break label78;
      }
    }
    label78:
    for (int i = j; i < paramInt1; i = k)
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
    return localRect;
  }
  
  public static Drawable a()
  {
    return new BitmapDrawable(a());
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {}
    for (paramDrawable = ((SkinnableBitmapDrawable)paramDrawable).mutate2();; paramDrawable = paramDrawable.getConstantState().newDrawable().mutate())
    {
      paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
      return paramDrawable;
    }
  }
  
  public static Drawable a(boolean paramBoolean)
  {
    return new BitmapDrawable(a(paramBoolean));
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
    for (;;)
    {
      localStateListDrawable.addState(new int[0], paramContext);
      return localStateListDrawable;
      localObject = paramContext.getConstantState().newDrawable();
      ((Drawable)localObject).mutate().setAlpha(102);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject);
    }
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
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
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
    return String.valueOf(m) + "/1," + String.valueOf(i) + "/1," + String.valueOf(j) + "/1";
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = AppConstants.SDCARD_PATH + "thumb/";
    if (paramUri == null) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        paramUri = b(paramContext, paramUri);
        paramContext = paramUri;
      } while (paramUri.startsWith((String)localObject));
      paramContext = paramUri.substring(paramUri.lastIndexOf("/") + 1);
      paramUri = (String)localObject + paramUri.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramUri;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramUri;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramContext = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        localObject = AppConstants.SDCARD_PATH + "thumb/";
        paramContext = paramString;
      } while (paramString.startsWith((String)localObject));
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramString = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramString;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    String str = AppConstants.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    int j = 600;
    int i = 800;
    try
    {
      a(paramContext, paramString, str, 600, 800);
      int k = 0;
      for (;;)
      {
        localObject1 = new File(str);
        if ((localObject1 == null) || (((File)localObject1).length() <= paramInt) || (k >= 3)) {
          break;
        }
        k += 1;
        j -= 100;
        i -= 100;
        a(paramContext, paramString, str, Math.max(100, j), Math.max(100, i));
      }
      localObject2 = a(paramContext, Uri.parse(paramString));
    }
    catch (Exception paramContext)
    {
      a("compressImageForGroup exception", paramContext);
      return paramString;
    }
    Object localObject1 = a(paramContext, Uri.parse(str));
    Object localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      ((File)localObject2).renameTo(new File((String)localObject1));
    } else {
      a(paramContext, str, (String)localObject1, 160, 160);
    }
    return str;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    long l = 0L;
    if (((File)localObject).exists()) {
      l = ((File)localObject).lastModified();
    }
    localObject = paramString.substring(paramString.lastIndexOf("/") + 1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_PATH).append("photo/");
    if (NetworkUtil.a(paramContext)) {
      localStringBuffer.append("WIFI");
    }
    if ((paramInt1 == 1) || (paramInt1 == 1001) || (paramInt1 == 10002) || (paramInt1 == 3000))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label193;
      }
    }
    label193:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localStringBuffer.append(paramInt1);
      localStringBuffer.append("s").append(paramInt2);
      localStringBuffer.append((paramString + l).hashCode()).append((String)localObject);
      return localStringBuffer.toString();
      paramInt1 = 0;
      break;
    }
  }
  
  public static String a(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
      localObject = HexUtil.bytes2HexStr((byte[])localObject).toUpperCase();
      if (((String)localObject).contains("FFD8FF"))
      {
        paramFileInputStream = "jpg";
        return paramFileInputStream;
      }
    }
    catch (IOException paramFileInputStream)
    {
      do
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
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
        if ((((String)localObject).contains("4D4D")) || (((String)localObject).contains("4949"))) {
          return "tiff";
        }
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
      } while (!((String)localObject).contains("0000020001002020"));
    }
    return "cur";
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 225	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   4: putfield 940	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   7: aload_0
    //   8: aconst_null
    //   9: aload_1
    //   10: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokestatic 942	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: new 944	java/io/BufferedOutputStream
    //   30: dup
    //   31: new 946	java/io/FileOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 950	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore_0
    //   43: aload 4
    //   45: getstatic 956	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   48: bipush 100
    //   50: aload_0
    //   51: invokevirtual 960	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: pop
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 963	java/io/OutputStream:close	()V
    //   63: aload 4
    //   65: ifnull +16 -> 81
    //   68: aload 4
    //   70: invokevirtual 444	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +8 -> 81
    //   76: aload 4
    //   78: invokevirtual 451	android/graphics/Bitmap:recycle	()V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_2
    //   84: ifnonnull +25 -> 109
    //   87: aload_2
    //   88: astore_0
    //   89: aload_3
    //   90: ifnull +19 -> 109
    //   93: aload_2
    //   94: astore_0
    //   95: aload_3
    //   96: invokevirtual 747	java/io/File:exists	()Z
    //   99: ifeq +10 -> 109
    //   102: aload_3
    //   103: invokevirtual 766	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: astore_0
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 963	java/io/OutputStream:close	()V
    //   122: aload 4
    //   124: ifnull +16 -> 140
    //   127: aload 4
    //   129: invokevirtual 444	android/graphics/Bitmap:isRecycled	()Z
    //   132: ifne +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 451	android/graphics/Bitmap:recycle	()V
    //   140: iconst_0
    //   141: ifne +157 -> 298
    //   144: aload_3
    //   145: ifnull +153 -> 298
    //   148: aload_3
    //   149: invokevirtual 747	java/io/File:exists	()Z
    //   152: ifeq +146 -> 298
    //   155: aload_3
    //   156: invokevirtual 766	java/io/File:delete	()Z
    //   159: pop
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -53 -> 109
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 963	java/io/OutputStream:close	()V
    //   176: aload 4
    //   178: ifnull +16 -> 194
    //   181: aload 4
    //   183: invokevirtual 444	android/graphics/Bitmap:isRecycled	()Z
    //   186: ifne +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 451	android/graphics/Bitmap:recycle	()V
    //   194: iconst_0
    //   195: ifne +103 -> 298
    //   198: aload_3
    //   199: ifnull +99 -> 298
    //   202: aload_3
    //   203: invokevirtual 747	java/io/File:exists	()Z
    //   206: ifeq +92 -> 298
    //   209: aload_3
    //   210: invokevirtual 766	java/io/File:delete	()Z
    //   213: pop
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -107 -> 109
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 963	java/io/OutputStream:close	()V
    //   230: aload 4
    //   232: ifnull +16 -> 248
    //   235: aload 4
    //   237: invokevirtual 444	android/graphics/Bitmap:isRecycled	()Z
    //   240: ifne +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 451	android/graphics/Bitmap:recycle	()V
    //   248: aload_2
    //   249: ifnonnull +19 -> 268
    //   252: aload_3
    //   253: ifnull +15 -> 268
    //   256: aload_3
    //   257: invokevirtual 747	java/io/File:exists	()Z
    //   260: ifeq +8 -> 268
    //   263: aload_3
    //   264: invokevirtual 766	java/io/File:delete	()Z
    //   267: pop
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: goto -208 -> 63
    //   274: astore_0
    //   275: goto -153 -> 122
    //   278: astore_0
    //   279: goto -103 -> 176
    //   282: astore_0
    //   283: goto -53 -> 230
    //   286: astore_1
    //   287: goto -65 -> 222
    //   290: astore_1
    //   291: goto -123 -> 168
    //   294: astore_1
    //   295: goto -181 -> 114
    //   298: aconst_null
    //   299: astore_0
    //   300: goto -191 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramInputStream	InputStream
    //   0	303	1	paramOptions	BitmapFactory.Options
    //   0	303	2	paramString	String
    //   26	238	3	localFile	File
    //   13	231	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   27	43	111	java/lang/Exception
    //   27	43	165	java/lang/OutOfMemoryError
    //   27	43	219	finally
    //   59	63	270	java/io/IOException
    //   118	122	274	java/io/IOException
    //   172	176	278	java/io/IOException
    //   226	230	282	java/io/IOException
    //   43	55	286	finally
    //   43	55	290	java/lang/OutOfMemoryError
    //   43	55	294	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 28	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +46 -> 62
    //   19: ldc_w 331
    //   22: iconst_2
    //   23: new 49	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 966
    //   33: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 206	android/graphics/Bitmap:getWidth	()I
    //   40: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc_w 968
    //   46: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: invokevirtual 215	android/graphics/Bitmap:getHeight	()I
    //   53: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 971	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_2
    //   63: invokestatic 942	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   66: astore_1
    //   67: new 946	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_1
    //   76: aload_0
    //   77: getstatic 974	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   80: bipush 100
    //   82: iload_3
    //   83: invokestatic 683	java/lang/Math:min	(II)I
    //   86: aload_1
    //   87: invokevirtual 960	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: pop
    //   91: aload_2
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +9 -> 103
    //   97: aload_1
    //   98: invokevirtual 963	java/io/OutputStream:close	()V
    //   101: aload_2
    //   102: astore_0
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +49 -> 158
    //   112: aload_1
    //   113: invokevirtual 963	java/io/OutputStream:close	()V
    //   116: aconst_null
    //   117: astore_0
    //   118: goto -15 -> 103
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_0
    //   124: goto -21 -> 103
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 963	java/io/OutputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: aload_2
    //   142: astore_0
    //   143: goto -40 -> 103
    //   146: astore_1
    //   147: goto -9 -> 138
    //   150: astore_0
    //   151: goto -21 -> 130
    //   154: astore_0
    //   155: goto -47 -> 108
    //   158: aconst_null
    //   159: astore_0
    //   160: goto -57 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramInputStream	InputStream
    //   0	163	1	paramOptions	BitmapFactory.Options
    //   0	163	2	paramString	String
    //   0	163	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   67	76	105	java/lang/Exception
    //   112	116	121	java/io/IOException
    //   67	76	127	finally
    //   97	101	140	java/io/IOException
    //   134	138	146	java/io/IOException
    //   76	91	150	finally
    //   76	91	154	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 667	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_2
    //   14: iload_3
    //   15: invokestatic 979	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   18: astore 6
    //   20: new 630	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload 6
    //   32: aload_1
    //   33: bipush 100
    //   35: iload 4
    //   37: invokestatic 683	java/lang/Math:min	(II)I
    //   40: invokestatic 981	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload 5
    //   49: astore_1
    //   50: aload_0
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: invokevirtual 299	java/io/InputStream:close	()V
    //   58: aload 5
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull -9 -> 61
    //   73: aload_0
    //   74: invokevirtual 299	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload 5
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -28 -> 61
    //   92: aload_0
    //   93: invokevirtual 299	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 299	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: goto -7 -> 112
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: astore_1
    //   131: goto -65 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   0	134	2	paramInt1	int
    //   0	134	3	paramInt2	int
    //   0	134	4	paramInt3	int
    //   1	115	5	str	String
    //   18	13	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   3	29	63	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   3	29	82	java/lang/Error
    //   92	96	98	java/io/IOException
    //   3	29	101	finally
    //   54	58	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   29	44	122	finally
    //   29	44	126	java/lang/Error
    //   29	44	130	java/lang/Exception
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
    localObject = ((BitmapFactory.Options)localObject).outMimeType;
    int i = b(str);
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
      if (paramContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues) == null) {
        MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), str, paramFile.getName(), null);
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ImageUtil", 1, "savePic2SystemMedia fail.", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramString);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 667	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iload_3
    //   11: iload 4
    //   13: invokestatic 979	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   16: astore 5
    //   18: new 279	java/io/BufferedInputStream
    //   21: dup
    //   22: new 630	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 288	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: aload 5
    //   39: aload_2
    //   40: invokestatic 1057	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;)Ljava/lang/String;
    //   43: pop
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 299	java/io/InputStream:close	()V
    //   52: return
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: new 49	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 1059
    //   68: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 454	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 68	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ifnull -33 -> 52
    //   88: aload_1
    //   89: invokevirtual 299	java/io/InputStream:close	()V
    //   92: return
    //   93: astore_0
    //   94: return
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 299	java/io/InputStream:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: return
    //   110: astore_0
    //   111: goto -5 -> 106
    //   114: astore_1
    //   115: goto -17 -> 98
    //   118: astore_2
    //   119: goto -63 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramString1	String
    //   0	122	2	paramString2	String
    //   0	122	3	paramInt1	int
    //   0	122	4	paramInt2	int
    //   16	22	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   0	34	53	java/lang/Exception
    //   88	92	93	java/io/IOException
    //   0	34	95	finally
    //   48	52	108	java/io/IOException
    //   102	106	110	java/io/IOException
    //   36	44	114	finally
    //   58	84	114	finally
    //   36	44	118	java/lang/Exception
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
    //   0: new 667	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 1077	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 747	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 1080	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 760	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 747	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 1083	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 763	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_2
    //   52: new 944	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 946	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 950	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_1
    //   68: aload_0
    //   69: getstatic 956	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: bipush 100
    //   74: aload_1
    //   75: invokevirtual 960	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   78: pop
    //   79: aload_1
    //   80: invokevirtual 1086	java/io/BufferedOutputStream:flush	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   91: return
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -5 -> 91
    //   99: aload_1
    //   100: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   103: return
    //   104: astore_0
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: goto -11 -> 107
    //   121: astore_0
    //   122: goto -27 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramBitmap	Bitmap
    //   0	125	1	paramFile	File
    //   11	95	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	68	92	java/io/IOException
    //   52	68	104	finally
    //   68	83	117	finally
    //   68	83	121	java/io/IOException
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
  
  static void a(String paramString)
  {
    if ((QLog.isColorLevel()) || (((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isActiveReporting())) {
      QLog.e("ImageUtil", 2, paramString);
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
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 667	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_1
    //   16: invokestatic 942	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore_1
    //   20: new 630	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: new 946	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore 5
    //   39: sipush 2048
    //   42: newarray byte
    //   44: astore_1
    //   45: lconst_0
    //   46: lstore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 1129	java/io/InputStream:read	([B)I
    //   52: istore_2
    //   53: iload_2
    //   54: iflt +42 -> 96
    //   57: lload_3
    //   58: iload_2
    //   59: i2l
    //   60: ladd
    //   61: lstore_3
    //   62: aload 5
    //   64: aload_1
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 1133	java/io/OutputStream:write	([BII)V
    //   70: goto -23 -> 47
    //   73: astore_1
    //   74: aload_0
    //   75: astore_1
    //   76: aload 5
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 299	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 963	java/io/OutputStream:close	()V
    //   95: return
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 299	java/io/InputStream:close	()V
    //   104: aload 5
    //   106: ifnull -11 -> 95
    //   109: aload 5
    //   111: invokevirtual 963	java/io/OutputStream:close	()V
    //   114: return
    //   115: astore_0
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload 6
    //   122: astore 5
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 299	java/io/InputStream:close	()V
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 963	java/io/OutputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -62 -> 87
    //   152: astore_0
    //   153: return
    //   154: astore_0
    //   155: goto -23 -> 132
    //   158: astore_0
    //   159: goto -17 -> 142
    //   162: astore_1
    //   163: aload 6
    //   165: astore 5
    //   167: goto -43 -> 124
    //   170: astore_1
    //   171: goto -47 -> 124
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: goto -101 -> 79
    //   183: astore_1
    //   184: aconst_null
    //   185: astore 5
    //   187: aload_0
    //   188: astore_1
    //   189: aload 5
    //   191: astore_0
    //   192: goto -113 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString1	String
    //   0	195	1	paramString2	String
    //   52	15	2	i	int
    //   46	16	3	l	long
    //   4	186	5	localObject1	Object
    //   1	163	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	73	java/lang/Exception
    //   47	53	73	java/lang/Exception
    //   62	70	73	java/lang/Exception
    //   109	114	115	java/io/IOException
    //   6	29	117	finally
    //   100	104	144	java/io/IOException
    //   83	87	148	java/io/IOException
    //   91	95	152	java/io/IOException
    //   128	132	154	java/io/IOException
    //   137	142	158	java/io/IOException
    //   29	39	162	finally
    //   39	45	170	finally
    //   47	53	170	finally
    //   62	70	170	finally
    //   6	29	174	java/lang/Exception
    //   29	39	183	java/lang/Exception
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
      if (paramString2.getWidth() >= paramInt1) {
        break label99;
      }
      paramString2.getWidth();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a(paramString1.toString());
        return;
        if (paramString2.getHeight() < paramInt2) {
          paramString2.getHeight();
        }
      }
    }
    catch (Error paramString1)
    {
      label99:
      a(paramString1.toString());
    }
    a(a(paramString2, paramInt1, paramInt2), new File(paramString1));
    return;
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if ((QLog.isColorLevel()) || (((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isActiveReporting())) {
      QLog.e("ImageUtil", 2, paramString, paramThrowable);
    }
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 667	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 1077	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 747	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 1080	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 760	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 747	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 1083	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 763	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 944	java/io/BufferedOutputStream
    //   53: dup
    //   54: new 946	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 950	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: getstatic 956	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: iload_1
    //   73: aload_3
    //   74: invokevirtual 960	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 1086	java/io/BufferedOutputStream:flush	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -13 -> 100
    //   116: astore_0
    //   117: aload_3
    //   118: astore_2
    //   119: goto -22 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramBitmap	Bitmap
    //   0	122	1	paramInt	int
    //   0	122	2	paramFile	File
    //   11	107	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	94	java/io/IOException
    //   68	78	99	finally
    //   80	84	99	finally
    //   97	99	99	finally
    //   50	66	110	finally
    //   68	78	116	java/io/IOException
    //   80	84	116	java/io/IOException
  }
  
  public static boolean a(Bitmap paramBitmap, File paramFile)
  {
    return b(paramBitmap, 100, paramFile);
  }
  
  public static boolean a(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, double paramDouble1, double paramDouble2)
  {
    if ((paramString != null) && (!JpegExifReader.isCrashJpeg(paramString))) {}
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        localExifInterface.setAttribute("GPSLatitude", a(paramDouble1));
        if (paramDouble1 > 0.0D)
        {
          paramString = "N";
          localExifInterface.setAttribute("GPSLatitudeRef", paramString);
          localExifInterface.setAttribute("GPSLongitude", a(paramDouble2));
          if (paramDouble2 > 0.0D)
          {
            paramString = "E";
            localExifInterface.setAttribute("GPSLongitudeRef", paramString);
            localExifInterface.saveAttributes();
            if (QLog.isDevelopLevel()) {
              QLog.d("ImageUtil", 4, "[updateLBSExif]GPSLatitude = " + localExifInterface.getAttribute("GPSLatitude") + ", GPSLongitude = " + localExifInterface.getAttribute("GPSLongitude"));
            }
          }
          else
          {
            paramString = "W";
            continue;
          }
          return true;
        }
      }
      catch (NullPointerException paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ImageUtil", 4, "[updateLBSExif] failed");
        }
        return false;
      }
      catch (IOException paramString)
      {
        continue;
      }
      paramString = "S";
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2))
      {
        bool1 = bool2;
        if (JpegExifReader.isCrashJpeg(paramString1)) {}
      }
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      ExifInterface localExifInterface = new ExifInterface(paramString2);
      int i = paramString1.getAttributeInt("Orientation", 0);
      localExifInterface.setAttribute("Orientation", i + "");
      paramString2 = paramString1.getAttribute("DateTime");
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localExifInterface.setAttribute("DateTime", paramString1);
      localExifInterface.saveAttributes();
      bool1 = true;
    }
    catch (IOException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("ImageUtil", 2, "copyExif ", paramString1);
      return false;
    }
    catch (UnsupportedOperationException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e("ImageUtil", 2, "copyExif ", paramString1);
    }
    return bool1;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (JpegExifReader.isCrashJpeg(paramString1))) {
      return false;
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString1.setAttribute("Orientation", paramString3);
      paramString1.saveAttributes();
      if (QLog.isDevelopLevel()) {
        QLog.d("ImageUtil", 4, "[updateExif]tag=" + paramString2 + ", value=" + paramString3);
      }
      return true;
    }
    catch (UnsupportedOperationException paramString1)
    {
      return false;
    }
    catch (NullPointerException paramString1)
    {
      return false;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static int b(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static Bitmap b()
  {
    String str = "static://DefaultDiscusionFace";
    int i = 2130840707;
    if (((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).isNowSimpleUI())
    {
      str = "static://DefaultDiscusionFace_square";
      i = 2130840453;
    }
    if (GlobalImageCache.a != null) {}
    for (Object localObject1 = (Bitmap)GlobalImageCache.a.get(str);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), i);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label66:
        break label66;
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put(str, localObject1);
          localObject2 = localObject1;
        }
      }
      return localObject2;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int m;
    int i;
    int j;
    if (paramBitmap != null)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if (k <= m) {
        break label63;
      }
      i = m;
      if (k <= m) {
        break label68;
      }
      j = (k - m) / 2;
      label40:
      if (k <= m) {
        break label73;
      }
    }
    label63:
    label68:
    label73:
    for (int k = 0;; k = (m - k) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
      return localBitmap;
      i = k;
      break;
      j = 0;
      break label40;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    double d2 = Math.toRadians(paramFloat);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    double d1 = Math.abs(Math.cos(d2));
    d2 = Math.abs(Math.sin(d2));
    int k = (int)(j * d2 + i * d1);
    int m = (int)(d2 * i + d1 * j);
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
    int j = 0;
    Object localObject;
    if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int m;
      int k;
      try
      {
        m = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = new Paint();
        if (m <= paramInt1) {
          break label273;
        }
        i = (m - paramInt1) / 2;
        if (k <= paramInt2) {
          break label293;
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
          continue;
        }
        QLog.e("ImageUtil", 2, "getClipCenterRectBitmap throw error ... " + paramBitmap.getMessage());
        return null;
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
      localObject = localBitmap;
      if (paramBitmap.isRecycled()) {
        break;
      }
      paramBitmap.recycle();
      return localBitmap;
      label273:
      int i = 0;
      continue;
      label278:
      for (paramInt1 = i + paramInt1; j + paramInt2 <= k; paramInt1 = m)
      {
        paramInt2 = j + paramInt2;
        break;
        label293:
        if (i + paramInt1 <= m) {
          break label278;
        }
      }
      paramInt2 = k;
    }
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localBitmap;
    }
    for (;;)
    {
      return localObject;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      localObject = localBitmap;
      if (i <= 0) {
        continue;
      }
      localObject = localBitmap;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
        {
          localBitmap = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
          localObject = localBitmap;
          if (localBitmap == null) {
            break;
          }
          localObject = new Canvas(localBitmap);
          paramDrawable.setBounds(0, 0, i, j);
          paramDrawable.draw((Canvas)localObject);
          return localBitmap;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Drawable b()
  {
    return new BitmapDrawable(b());
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
      paramFile = "_data='" + paramFile.getAbsolutePath() + "'";
      paramContext.getContentResolver().delete(localUri, paramFile, null);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ImageUtil", 1, "deletePic2SystemMedia fail.", paramContext);
    }
  }
  
  /* Error */
  public static boolean b(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 667	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokevirtual 1077	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 744	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 747	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 1080	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_3
    //   27: invokevirtual 760	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 747	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_2
    //   39: invokevirtual 1083	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 763	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 944	java/io/BufferedOutputStream
    //   53: dup
    //   54: new 946	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 947	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 950	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: getstatic 974	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: iload_1
    //   73: aload_3
    //   74: invokevirtual 960	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   77: pop
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 1086	java/io/BufferedOutputStream:flush	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 1087	java/io/BufferedOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_2
    //   113: goto -13 -> 100
    //   116: astore_0
    //   117: aload_3
    //   118: astore_2
    //   119: goto -22 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramBitmap	Bitmap
    //   0	122	1	paramInt	int
    //   0	122	2	paramFile	File
    //   11	107	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	94	java/io/IOException
    //   68	78	99	finally
    //   80	84	99	finally
    //   97	99	99	finally
    //   50	66	110	finally
    //   68	78	116	java/io/IOException
    //   80	84	116	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new FileInputStream(paramString);
        boolean bool = "jpg".equals(a(paramString));
        if (bool) {
          bool = true;
        }
        bool = false;
      }
      catch (Exception paramString)
      {
        try
        {
          paramString.close();
          return bool;
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = paramString;
        bool = false;
        a(paramString.toString());
        return bool;
      }
    }
  }
  
  public static Bitmap c()
  {
    return a(false);
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return paramBitmap;
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramBitmap == null) {}
    for (;;)
    {
      return null;
      try
      {
        float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
        int m = (int)Math.ceil(paramBitmap.getWidth() / f);
        int n = (int)Math.ceil(paramBitmap.getHeight() / f);
        Bitmap localBitmap;
        int i;
        int k;
        if (m == paramInt1)
        {
          localBitmap = paramBitmap;
          if (n == paramInt2) {}
        }
        else
        {
          paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
          i = (m - paramInt1) / 2;
          if (i >= 0) {
            break label383;
          }
          i = 0;
          k = (n - paramInt2) / 2;
          if (k >= 0) {
            break label386;
          }
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ImageUtil", 2, "ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2);
          }
          localBitmap = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
          paramBitmap.recycle();
          paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(paramBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          localBitmap.recycle();
          return paramBitmap;
          label383:
          break;
          label386:
          j = k;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    QLog.w("ImageUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
    return null;
  }
  
  public static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    i = (paramInt1 + paramInt2) / 2;
    if (i < 35) {
      i = (int)(2.0F * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i, paramInt1, paramInt2);
      if (i < 50) {
        i = (int)(3.0F * f1);
      } else if (i < 64) {
        i = (int)(5.0F * f1);
      } else {
        i = (int)(6.0F * f1);
      }
    }
  }
  
  public static Bitmap c(Drawable paramDrawable)
  {
    Paint localPaint = null;
    Object localObject;
    if (paramDrawable == null) {
      localObject = localPaint;
    }
    for (;;)
    {
      return localObject;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicWidth();
      localObject = localPaint;
      if (i <= 0) {
        continue;
      }
      localObject = localPaint;
      if (j <= 0) {
        continue;
      }
      try
      {
        if (paramDrawable.getOpacity() != -1) {}
        for (paramDrawable = Bitmap.Config.ARGB_8888;; paramDrawable = Bitmap.Config.RGB_565)
        {
          paramDrawable = Bitmap.createBitmap(i, j, paramDrawable);
          localObject = paramDrawable;
          if (paramDrawable == null) {
            break;
          }
          localObject = new Canvas(paramDrawable);
          localPaint = new Paint();
          ((Canvas)localObject).drawBitmap(paramDrawable, new Matrix(), localPaint);
          return paramDrawable;
        }
        return null;
      }
      catch (OutOfMemoryError paramDrawable) {}
    }
  }
  
  public static Drawable c()
  {
    return new BitmapDrawable(c());
  }
  
  public static Bitmap d()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultSystemIcon");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), 2130850953);
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
  
  public static Bitmap d(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      float f = Math.min(paramBitmap.getWidth() / paramInt1, paramBitmap.getHeight() / paramInt2);
      int m = (int)Math.ceil(paramBitmap.getWidth() / f);
      int n = (int)Math.ceil(paramBitmap.getHeight() / f);
      Bitmap localBitmap;
      int i;
      int k;
      if (m == paramInt1)
      {
        localBitmap = paramBitmap;
        if (n == paramInt2) {}
      }
      else
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, m, n, true);
        i = (m - paramInt1) / 2;
        if (i >= 0) {
          break label418;
        }
        i = 0;
        k = (n - paramInt2) / 2;
        if (k >= 0) {
          break label421;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageUtil", 2, "HALF_ROUND_CORNER_DECODER scale = " + f + ", scaledWidth = " + m + ", scaledHeight = " + n + ", xTopLeft = " + i + ", yTopLeft = " + j + ", width = " + paramInt1 + ", height = " + paramInt2 + " roundPx: " + paramFloat);
        }
        localBitmap = Bitmap.createBitmap(paramBitmap, i, j, paramInt1, paramInt2);
        paramBitmap.recycle();
        paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(paramBitmap);
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
        Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
        Rect localRect3 = new Rect(0, (int)(paramInt2 - paramFloat), paramInt1, (int)(paramInt2 + paramFloat));
        RectF localRectF = new RectF(localRect2);
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
        localCanvas.drawRect(localRect3, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
        return paramBitmap;
        label418:
        break;
        label421:
        j = k;
      }
      return null;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static Bitmap d(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramInt2 * 2 + paramBitmap.getWidth();
      int j = paramInt2 * 2 + paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
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
      localCanvas.drawCircle(i / 2, j / 2, i / 2 - paramInt2 / 2, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static Bitmap e(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i - paramInt1, j - paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, paramInt2, i - paramInt1, j);
      Rect localRect2 = new Rect(0, 0, i - paramInt1, j - paramInt2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseImageUtil
 * JD-Core Version:    0.7.0.1
 */