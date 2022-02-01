package com.tencent.mobileqq.screendetect;

import aaff;
import amtj;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.MotionEvent;
import baqs;
import baqt;
import barb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ScreenShotDetector
  extends aaff
{
  private static Point jdField_a_of_type_AndroidGraphicsPoint;
  private static ScreenShotDetector jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector = new ScreenShotDetector();
  private static String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "datetaken" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "_data", "datetaken", "width", "height" };
  private static final String[] c = { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
  private static final String[] d = { "三星F9000", "三星A8S", "三星S8+", "华为MHA-AL00", "华为P30", "vivoX27", "小米9", "OPPOA59S", "魅族Pro7-H", amtj.a(2131712698), amtj.a(2131712699) };
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private baqs jdField_a_of_type_Baqs;
  private baqt jdField_a_of_type_Baqt;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private baqs jdField_b_of_type_Baqs;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private Point a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  private static void a(Context paramContext, baqs parambaqs)
  {
    if (parambaqs == null) {
      return;
    }
    try
    {
      paramContext.getContentResolver().unregisterContentObserver(parambaqs);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "unregisterContentObserver", paramContext);
    }
  }
  
  private void a(Uri paramUri)
  {
    int j = -1;
    Point localPoint = null;
    Object localObject2 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      QLog.e("ScreenShotDetector", 2, "context null.");
    }
    for (;;)
    {
      return;
      Object localObject1 = localPoint;
      try
      {
        ContentResolver localContentResolver = ((Context)localObject2).getContentResolver();
        localObject1 = localPoint;
        if (Build.VERSION.SDK_INT < 16) {
          localObject1 = localPoint;
        }
        for (localObject2 = jdField_a_of_type_ArrayOfJavaLangString;; localObject2 = jdField_b_of_type_ArrayOfJavaLangString)
        {
          for (;;)
          {
            localObject1 = localPoint;
            paramUri = localContentResolver.query(paramUri, (String[])localObject2, null, null, "date_added desc limit 1");
            if (paramUri != null) {
              break label127;
            }
            localObject1 = paramUri;
            try
            {
              QLog.e("ScreenShotDetector", 2, "Deviant logic.");
              if ((paramUri == null) || (paramUri.isClosed())) {
                break;
              }
              paramUri.close();
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                int k;
                int m;
                long l;
                Uri localUri;
                continue;
                int i = -1;
              }
            }
          }
          localObject1 = localPoint;
        }
        label127:
        localObject1 = paramUri;
        if (!paramUri.moveToFirst())
        {
          localObject1 = paramUri;
          if (QLog.isColorLevel())
          {
            localObject1 = paramUri;
            QLog.d("ScreenShotDetector", 2, "Cursor no data.");
          }
          if ((paramUri == null) || (paramUri.isClosed())) {
            continue;
          }
          paramUri.close();
          return;
        }
        localObject1 = paramUri;
        k = paramUri.getColumnIndex("_data");
        localObject1 = paramUri;
        m = paramUri.getColumnIndex("datetaken");
        localObject1 = paramUri;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = paramUri;
          j = paramUri.getColumnIndex("width");
          localObject1 = paramUri;
          i = paramUri.getColumnIndex("height");
          localObject1 = paramUri;
          localObject2 = paramUri.getString(k);
          localObject1 = paramUri;
          l = paramUri.getLong(m);
          if ((j >= 0) && (i >= 0))
          {
            localObject1 = paramUri;
            k = paramUri.getInt(j);
            localObject1 = paramUri;
            j = paramUri.getInt(i);
            i = k;
          }
          for (;;)
          {
            localObject1 = paramUri;
            a((String)localObject2, l, i, j);
            if ((paramUri == null) || (paramUri.isClosed())) {
              break;
            }
            paramUri.close();
            return;
            localObject1 = paramUri;
            localPoint = a((String)localObject2);
            localObject1 = paramUri;
            i = localPoint.x;
            localObject1 = paramUri;
            j = localPoint.y;
          }
        }
      }
      catch (Exception localException1)
      {
        paramUri = null;
      }
      finally
      {
        try
        {
          localException1.printStackTrace();
          if ((paramUri == null) || (paramUri.isClosed())) {
            continue;
          }
          paramUri.close();
          return;
        }
        finally
        {
          localUri = paramUri;
          paramUri = localObject3;
        }
        paramUri = finally;
        if ((localException1 != null) && (!localException1.isClosed())) {
          localException1.close();
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (a(paramString, paramLong, paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong + "; diffTime = " + (System.currentTimeMillis() - paramLong));
      }
      if (!a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShotDetector", 2, "ScreenShot 机型：" + Build.MANUFACTURER + Build.MODEL);
        }
        barb.a("0X8009FED", 0);
        if (this.jdField_a_of_type_Baqt != null) {
          this.jdField_a_of_type_Baqt.a();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.post(new ScreenShotDetector.1(this, paramString));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScreenShotDetector", 2, "Media content changed, but not screenshot: path = " + paramString + "; size = " + paramInt1 + " * " + paramInt2 + "; date = " + paramLong);
  }
  
  private boolean a(String paramString)
  {
    if ((jdField_a_of_type_JavaLangString.length() > 0) && (TextUtils.equals(jdField_a_of_type_JavaLangString, paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: imgPath has done; imagePath = " + paramString);
      }
      return true;
    }
    jdField_a_of_type_JavaLangString = paramString;
    return false;
  }
  
  private boolean a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, "ScreenShotDetector called with checkScreenShot  当前时间与图片获取时间差 : " + (System.currentTimeMillis() - paramLong));
    }
    if ((paramLong < this.jdField_a_of_type_Long) || (System.currentTimeMillis() - paramLong > 4000L)) {
      return false;
    }
    if (jdField_a_of_type_AndroidGraphicsPoint == null)
    {
      jdField_a_of_type_AndroidGraphicsPoint = barb.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (jdField_a_of_type_AndroidGraphicsPoint == null) {
        break label191;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "Screen Real Size: " + jdField_a_of_type_AndroidGraphicsPoint.x + " * " + jdField_a_of_type_AndroidGraphicsPoint.y);
      }
    }
    while ((jdField_a_of_type_AndroidGraphicsPoint != null) && ((paramInt1 > jdField_a_of_type_AndroidGraphicsPoint.x) || (paramInt2 > jdField_a_of_type_AndroidGraphicsPoint.y)) && ((paramInt2 > jdField_a_of_type_AndroidGraphicsPoint.x) || (paramInt1 > jdField_a_of_type_AndroidGraphicsPoint.y)))
    {
      return false;
      label191:
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "Get screen real size failed.");
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    String[] arrayOfString = c;
    paramInt2 = arrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramString.contains(arrayOfString[paramInt1])) {
        return true;
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  private static void c(Context paramContext, baqs parambaqs1, baqs parambaqs2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, "doOnRegisterObservers() called with: context = [" + paramContext + "], internalObserver = [" + parambaqs1 + "], externalObserver = [" + parambaqs2 + "]");
    }
    try
    {
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, parambaqs1);
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, parambaqs2);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error", paramContext);
    }
  }
  
  private static void d(Context paramContext, baqs parambaqs1, baqs parambaqs2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotDetector", 2, "doOnUnRegisterObservers() called with: context = [" + paramContext + "], internalObserver = [" + parambaqs1 + "], externalObserver = [" + parambaqs2 + "]");
    }
    try
    {
      a(paramContext, parambaqs1);
      a(paramContext, parambaqs2);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnUnRegisterObservers error", paramContext);
    }
  }
  
  public static ScreenShotDetector getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector;
  }
  
  public void a(baqt parambaqt)
  {
    this.jdField_a_of_type_Baqt = parambaqt;
  }
  
  public boolean a()
  {
    if (!barb.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "ScreenShot: onChange screen switch is closed!");
      }
      return true;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).mAutomator.b())) {
      return true;
    }
    return (localAppRuntime == null) || (localAppRuntime.isBackgroundPause) || (localAppRuntime.isBackgroundStop);
  }
  
  public void c(Context paramContext)
  {
    if ((paramContext instanceof QQLSActivity))
    {
      QLog.e("ScreenShotDetector", 1, "ScreenShot: startListen error, context is QQLSActivity!");
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Baqs == null) {
      this.jdField_a_of_type_Baqs = new baqs(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.jdField_a_of_type_AndroidOsHandler);
    }
    if (this.jdField_b_of_type_Baqs == null) {
      this.jdField_b_of_type_Baqs = new baqs(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.jdField_a_of_type_AndroidOsHandler);
    }
    ThreadManager.executeOnSubThread(new ScreenShotDetector.2(this, paramContext.getApplicationContext()), false);
  }
  
  public void d(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.3(this, paramContext.getApplicationContext()), false);
  }
  
  public void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    barb.a(paramActivity, paramMotionEvent);
  }
  
  public void onWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper-ScreenShotDetector", 2, "ScreenShot: onWindowFocusChanged " + paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (paramBoolean) {
      barb.a(paramActivity, this.jdField_a_of_type_AndroidOsHandler);
    }
    while (!"XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
      return;
    }
    barb.b(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector
 * JD-Core Version:    0.7.0.1
 */