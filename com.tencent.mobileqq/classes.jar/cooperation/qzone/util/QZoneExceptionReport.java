package cooperation.qzone.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class QZoneExceptionReport
{
  private static Field a;
  
  private static void a(Throwable paramThrowable)
  {
    try
    {
      if (a == null) {
        a = Throwable.class.getDeclaredField("detailMessage");
      }
      a.setAccessible(true);
      a.set(paramThrowable, "QzoneCatchedException:" + paramThrowable.getMessage());
      return;
    }
    catch (Throwable paramThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZoneExceptionReport", 2, "addStackTag failed", paramThrowable);
    }
  }
  
  public static final void a(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = Log.getStackTraceString(paramThrowable);
    }
    a(paramThrowable);
    QLog.d("QZoneExceptionReport", 2, "", paramThrowable);
    CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.QZoneExceptionReport
 * JD-Core Version:    0.7.0.1
 */