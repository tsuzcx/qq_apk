package com.tencent.mobileqq.screendetect;

import alud;
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
import ayfw;
import ayfx;
import aygf;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import zhv;

public class ScreenShotDetector
  extends zhv
{
  private static Point jdField_a_of_type_AndroidGraphicsPoint;
  private static ScreenShotDetector jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector = new ScreenShotDetector();
  private static String jdField_a_of_type_JavaLangString;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "datetaken" };
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "_data", "datetaken", "width", "height" };
  private static final String[] c = { "screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap" };
  private static final String[] d = { "三星F9000", "三星A8S", "三星S8+", "华为MHA-AL00", "华为P30", "vivoX27", "小米9", "OPPOA59S", "魅族Pro7-H", alud.a(2131713978), alud.a(2131713979) };
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ayfw jdField_a_of_type_Ayfw;
  private ayfx jdField_a_of_type_Ayfx;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private ayfw jdField_b_of_type_Ayfw;
  
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
        aygf.a("0X8009FED", 0);
        if (this.jdField_a_of_type_Ayfx != null) {
          this.jdField_a_of_type_Ayfx.a();
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
      jdField_a_of_type_AndroidGraphicsPoint = aygf.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (jdField_a_of_type_AndroidGraphicsPoint == null) {
        break label190;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotDetector", 2, "Screen Real Size: " + jdField_a_of_type_AndroidGraphicsPoint.x + " * " + jdField_a_of_type_AndroidGraphicsPoint.y);
      }
    }
    while ((jdField_a_of_type_AndroidGraphicsPoint != null) && ((paramInt1 > jdField_a_of_type_AndroidGraphicsPoint.x) || (paramInt2 > jdField_a_of_type_AndroidGraphicsPoint.y)) && ((paramInt2 > jdField_a_of_type_AndroidGraphicsPoint.x) || (paramInt1 > jdField_a_of_type_AndroidGraphicsPoint.y)))
    {
      return false;
      label190:
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
  
  private void b()
  {
    Context localContext;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext == null) {}
    }
    else
    {
      try
      {
        localContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.jdField_a_of_type_Ayfw);
        localContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.jdField_b_of_type_Ayfw);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error", localException);
        return;
      }
    }
    QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error context is null");
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 141	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: ifnull +106 -> 110
    //   7: aload_0
    //   8: getfield 141	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   11: invokevirtual 150	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   14: checkcast 152	android/content/Context
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +82 -> 101
    //   22: aload_0
    //   23: getfield 358	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_Ayfw	Layfw;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +19 -> 47
    //   31: aload_1
    //   32: invokevirtual 166	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_0
    //   36: getfield 358	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_Ayfw	Layfw;
    //   39: invokevirtual 380	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 358	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_a_of_type_Ayfw	Layfw;
    //   47: aload_0
    //   48: getfield 367	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_b_of_type_Ayfw	Layfw;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +57 -> 110
    //   56: aload_1
    //   57: invokevirtual 166	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload_0
    //   61: getfield 367	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_b_of_type_Ayfw	Layfw;
    //   64: invokevirtual 380	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 367	com/tencent/mobileqq/screendetect/ScreenShotDetector:jdField_b_of_type_Ayfw	Layfw;
    //   72: return
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   78: goto -36 -> 42
    //   81: astore_1
    //   82: ldc 154
    //   84: iconst_1
    //   85: ldc_w 382
    //   88: aload_1
    //   89: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: return
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   98: goto -31 -> 67
    //   101: ldc 154
    //   103: iconst_1
    //   104: ldc_w 384
    //   107: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ScreenShotDetector
    //   17	40	1	localContext	Context
    //   81	8	1	localException1	Exception
    //   93	2	1	localException2	Exception
    //   26	27	2	localayfw	ayfw
    //   73	2	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   31	42	73	java/lang/Exception
    //   22	27	81	java/lang/Exception
    //   42	47	81	java/lang/Exception
    //   47	52	81	java/lang/Exception
    //   67	72	81	java/lang/Exception
    //   74	78	81	java/lang/Exception
    //   94	98	81	java/lang/Exception
    //   56	67	93	java/lang/Exception
  }
  
  public static ScreenShotDetector getInstance()
  {
    return jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotDetector;
  }
  
  public void a(ayfx paramayfx)
  {
    this.jdField_a_of_type_Ayfx = paramayfx;
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
    this.jdField_a_of_type_Ayfw = new ayfw(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_Ayfw = new ayfw(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.jdField_a_of_type_AndroidOsHandler);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.2(this), false);
  }
  
  public void d(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ThreadManager.executeOnSubThread(new ScreenShotDetector.3(this), false);
  }
  
  public void disaptchTouchEventCallback(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    aygf.a(paramActivity, paramMotionEvent);
  }
  
  public void onWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotHelper-ScreenShotDetector", 2, "ScreenShot: onWindowFocusChanged " + paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (paramBoolean) {
      aygf.a(paramActivity, this.jdField_a_of_type_AndroidOsHandler);
    }
    while (!"XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
      return;
    }
    aygf.b(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotDetector
 * JD-Core Version:    0.7.0.1
 */