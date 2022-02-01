package com.tencent.mobileqq.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ScreenShotUtil
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QLog.e("ScreenShotUtil", 1, "createBitmap failed", localOutOfMemoryError1);
      System.gc();
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return localBitmap2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.e("ScreenShotUtil", 1, "createBitmap failed again", localOutOfMemoryError2);
      }
    }
    return null;
  }
  
  public static Bitmap a(WebView paramWebView, int paramInt1, int paramInt2)
  {
    if ((paramWebView != null) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return null;
      }
      Bitmap localBitmap = a(paramInt1, paramInt2);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (paramWebView.getX5WebViewExtension() != null)
      {
        PaintFlagsDrawFilter localPaintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
        paramInt2 = QbSdk.getTbsVersion(paramWebView.getContext());
        if ((paramInt2 >= 43000) && (paramInt2 < 43105))
        {
          f = paramInt1 / paramWebView.getMeasuredWidth();
          localCanvas.scale(f, f);
          localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
          paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
          }
        }
        else
        {
          f = paramInt1 / paramWebView.getContentWidth();
          localCanvas.scale(f, f);
          localCanvas.setDrawFilter(localPaintFlagsDrawFilter);
          paramWebView.getX5WebViewExtension().snapshotWholePage(localCanvas, false, false);
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotUtil", 2, "snapshot with snapshotWholePage()");
          }
        }
        localCanvas.setDrawFilter(null);
        return localBitmap;
      }
      float f = paramInt1 / paramWebView.getMeasuredWidth();
      localCanvas.scale(f, f);
      paramWebView = paramWebView.capturePicture();
      if (paramWebView != null) {
        paramWebView.draw(localCanvas);
      }
      return localBitmap;
    }
    return null;
  }
  
  public static String a()
  {
    if (CheckPermission.isHasStoragePermission(BaseApplicationImpl.getContext()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory());
      localStringBuilder.append("/Tencent/MobileQQ/web_long_shot/");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir());
    localStringBuilder.append("/Tencent/MobileQQ/web_long_shot/");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +178 -> 184
    //   9: aload_1
    //   10: ifnull +174 -> 184
    //   13: aload_2
    //   14: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_1
    //   23: invokevirtual 178	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 181	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 175	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: aload_2
    //   40: invokespecial 184	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 4
    //   47: astore_1
    //   48: new 186	java/io/BufferedOutputStream
    //   51: dup
    //   52: new 188	java/io/FileOutputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 194	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore_2
    //   65: aload_0
    //   66: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 100
    //   71: aload_2
    //   72: invokevirtual 204	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual 209	java/io/OutputStream:flush	()V
    //   80: aload_2
    //   81: invokevirtual 212	java/io/OutputStream:close	()V
    //   84: goto +13 -> 97
    //   87: astore_0
    //   88: ldc 31
    //   90: iconst_1
    //   91: ldc 214
    //   93: aload_0
    //   94: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload 5
    //   99: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: areturn
    //   103: astore_0
    //   104: aload_2
    //   105: astore_1
    //   106: goto +55 -> 161
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: aload_1
    //   113: astore_2
    //   114: goto +10 -> 124
    //   117: astore_0
    //   118: goto +43 -> 161
    //   121: astore_2
    //   122: aload_3
    //   123: astore_0
    //   124: aload_0
    //   125: astore_1
    //   126: ldc 31
    //   128: iconst_1
    //   129: aload_2
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   137: aload_0
    //   138: ifnull +20 -> 158
    //   141: aload_0
    //   142: invokevirtual 212	java/io/OutputStream:close	()V
    //   145: ldc 222
    //   147: areturn
    //   148: astore_0
    //   149: ldc 31
    //   151: iconst_1
    //   152: ldc 214
    //   154: aload_0
    //   155: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: ldc 222
    //   160: areturn
    //   161: aload_1
    //   162: ifnull +20 -> 182
    //   165: aload_1
    //   166: invokevirtual 212	java/io/OutputStream:close	()V
    //   169: goto +13 -> 182
    //   172: astore_1
    //   173: ldc 31
    //   175: iconst_1
    //   176: ldc 214
    //   178: aload_1
    //   179: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_0
    //   183: athrow
    //   184: aconst_null
    //   185: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramBitmap	Bitmap
    //   0	186	1	paramFile	java.io.File
    //   0	186	2	paramString	String
    //   1	122	3	localObject1	Object
    //   3	43	4	localObject2	Object
    //   43	55	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   80	84	87	java/io/IOException
    //   65	80	103	finally
    //   65	80	109	java/lang/Throwable
    //   48	65	117	finally
    //   126	137	117	finally
    //   48	65	121	java/lang/Throwable
    //   141	145	148	java/io/IOException
    //   165	169	172	java/io/IOException
  }
  
  public static <T> void a(WebView paramWebView, ScreenShotUtil.ScreenLongShotCallback<T> paramScreenLongShotCallback)
  {
    QLog.d("ScreenShotUtil", 1, "webViewFragmentScreenLongShot start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, mWebView is null");
      paramScreenLongShotCallback.a(new NullPointerException("mWebView is null"));
      return;
    }
    Object localObject1 = paramWebView.getContext();
    if (localObject1 == null)
    {
      QLog.e("ScreenShotUtil", 1, "webviewFragmentScreenLongShot error, context is null");
      paramScreenLongShotCallback.a(new NullPointerException("context is null"));
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localObject1 = new TDProgressDialog((Context)localObject1);
    ((TDProgressDialog)localObject1).a(HardCodeUtil.a(2131699205));
    ((TDProgressDialog)localObject1).a(true);
    ((TDProgressDialog)localObject1).a(new ScreenShotUtil.3(localAtomicBoolean, (TDProgressDialog)localObject1));
    ((TDProgressDialog)localObject1).show();
    ValueAnimator localValueAnimator1 = ObjectAnimator.ofInt(new int[] { 0, 90 });
    localValueAnimator1.setDuration(2000L);
    ValueAnimator localValueAnimator2 = ObjectAnimator.ofInt(new int[] { 90, 99 });
    localValueAnimator2.setDuration(10000L);
    Object localObject2 = new ScreenShotUtil.4((TDProgressDialog)localObject1);
    localValueAnimator1.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localValueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    ((AnimatorSet)localObject2).start();
    ((TDProgressDialog)localObject1).setOnDismissListener(new ScreenShotUtil.5((AnimatorSet)localObject2));
    a(paramWebView, new ScreenShotUtil.6(localAtomicBoolean, (TDProgressDialog)localObject1, paramScreenLongShotCallback, paramWebView, (AnimatorSet)localObject2));
  }
  
  public static void a(WebView paramWebView, ScreenShotUtil.ScreenshotCallback paramScreenshotCallback)
  {
    int j;
    Bitmap localBitmap;
    Canvas localCanvas;
    if (paramWebView != null)
    {
      if (paramScreenshotCallback == null) {
        return;
      }
      i = paramWebView.getMeasuredWidth();
      j = paramWebView.getMeasuredHeight();
      if (i > 0)
      {
        if (j <= 0) {
          return;
        }
        localBitmap = a(i, j);
        if (localBitmap == null) {
          return;
        }
        localCanvas = new Canvas(localBitmap);
        if (paramWebView.getX5WebViewExtension() != null)
        {
          boolean bool = jdField_a_of_type_Boolean;
          j = 1;
          if ((!bool) && (jdField_a_of_type_JavaLangReflectMethod == null))
          {
            Class[] arrayOfClass = paramWebView.getX5WebViewExtension().getClass().getInterfaces();
            int k = arrayOfClass.length;
            i = 0;
            while (i < k)
            {
              Object localObject = arrayOfClass[i];
              if ("com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(((Class)localObject).getName())) {
                try
                {
                  jdField_a_of_type_JavaLangReflectMethod = ((Class)localObject).getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("ScreenShotUtil", 2, "call snapshotVisibleWithBitmap");
                }
                catch (Exception localException1)
                {
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("call snapshotVisibleWithBitmap failed: ");
                    ((StringBuilder)localObject).append(localException1.getMessage());
                    QLog.i("ScreenShotUtil", 2, ((StringBuilder)localObject).toString());
                  }
                  jdField_a_of_type_JavaLangReflectMethod = null;
                }
              }
              i += 1;
            }
            jdField_a_of_type_Boolean = true;
          }
          i = j;
        }
      }
    }
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        break label364;
      }
      jdField_a_of_type_JavaLangReflectMethod.invoke(paramWebView.getX5WebViewExtension(), new Object[] { localBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ScreenShotUtil.1(paramScreenshotCallback, localBitmap) });
      i = j;
    }
    catch (Exception localException2)
    {
      label362:
      break label362;
    }
    int i = 0;
    label364:
    if (i == 0)
    {
      localCanvas.setDrawFilter(new PaintFlagsDrawFilter(134, 64));
      paramWebView.getX5WebViewExtension().snapshotVisible(localCanvas, false, false, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotUtil", 2, "snapshot with snapshotVisible()");
      }
      localCanvas.setDrawFilter(null);
      paramScreenshotCallback.a(localBitmap);
      return;
      paramWebView.draw(localCanvas);
      paramScreenshotCallback.a(localBitmap);
    }
  }
  
  public static <T> boolean a(WebView paramWebView, ScreenShotUtil.ScreenLongShotCallback<T> paramScreenLongShotCallback)
  {
    QLog.d("ScreenShotUtil", 1, "snapshotWholePage start");
    if (paramWebView == null)
    {
      QLog.e("ScreenShotUtil", 1, "snapshotWholePage error, mWebView is null");
      paramScreenLongShotCallback.a(new NullPointerException("mWebView is null"));
      return false;
    }
    int i = paramWebView.getMeasuredWidth();
    int j = paramWebView.getContentWidth();
    int k = paramWebView.getContentHeight();
    float f;
    if ((i > 0) && (j > 0) && (k > 0))
    {
      f = i / j;
      j = (int)(k * f);
      if (j > 20000)
      {
        QLog.e("ScreenShotUtil", 1, "height > 20000, out of height limit");
        paramScreenLongShotCallback.a(new IllegalStateException(HardCodeUtil.a(2131718549)));
        return false;
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
      if (localBitmap == null) {
        return false;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.scale(f, f);
      ThreadManagerV2.executeOnNetWorkThread(new ScreenShotUtil.2(paramWebView, localCanvas, paramScreenLongShotCallback, localBitmap));
      return true;
    }
    catch (OutOfMemoryError paramWebView)
    {
      label180:
      break label180;
    }
    QLog.e("ScreenShotUtil", 1, "createBitmap out of memory");
    paramScreenLongShotCallback.a(new IllegalStateException(HardCodeUtil.a(2131718549)));
    return false;
    QLog.e("ScreenShotUtil", 1, "measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0");
    paramScreenLongShotCallback.a(new IllegalStateException("measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil
 * JD-Core Version:    0.7.0.1
 */