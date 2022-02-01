package cooperation.qzone.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.lang.reflect.Field;

public class QZoneExceptionReport
{
  public static final String STACK_TAG = "QzoneCatchedException:";
  private static final String TAG = "QZoneExceptionReport";
  private static Field detailMessageField;
  
  private static void addStackTag(Throwable paramThrowable)
  {
    try
    {
      if (detailMessageField == null) {
        detailMessageField = Throwable.class.getDeclaredField("detailMessage");
      }
      detailMessageField.setAccessible(true);
      Field localField = detailMessageField;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QzoneCatchedException:");
      localStringBuilder.append(paramThrowable.getMessage());
      localField.set(paramThrowable, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneExceptionReport", 2, "addStackTag failed", paramThrowable);
      }
    }
  }
  
  public static final void doReport(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = Log.getStackTraceString(paramThrowable);
    }
    addStackTag(paramThrowable);
    QLog.d("QZoneExceptionReport", 2, "", paramThrowable);
    CaughtExceptionReport.a(paramThrowable, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneExceptionReport
 * JD-Core Version:    0.7.0.1
 */