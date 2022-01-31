import com.tencent.av.VideoRecoveryReporter.1;
import com.tencent.av.VideoRecoveryReporter.2;
import com.tencent.av.VideoRecoveryReporter.3;
import com.tencent.av.VideoRecoveryReporter.4;
import com.tencent.av.VideoRecoveryReporter.5;
import com.tencent.av.VideoRecoveryReporter.6;
import com.tencent.av.VideoRecoveryReporter.7;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class kto
{
  private static boolean a;
  
  public static void a()
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationRequest");
      a = true;
      ThreadManager.post(new VideoRecoveryReporter.4(), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", localThrowable);
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryClose reason=%s duration=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      ThreadManager.post(new VideoRecoveryReporter.3(paramInt, paramLong), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryClose fail.", localThrowable);
    }
  }
  
  public static void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryRequest source=%s interval=%s result=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
      ThreadManager.post(new VideoRecoveryReporter.1(paramInt, paramBoolean, paramLong), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", localThrowable);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportNodeReportRetry success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      ThreadManager.post(new VideoRecoveryReporter.7(paramBoolean), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", localThrowable);
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryResult result=%s timeCost=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
      ThreadManager.post(new VideoRecoveryReporter.2(paramBoolean, paramLong), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", localException);
    }
  }
  
  public static void b()
  {
    try
    {
      if (a) {
        a = false;
      }
      QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationResult");
      ThreadManager.post(new VideoRecoveryReporter.5(), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", localException);
    }
  }
  
  public static void c()
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, "reportNodeReportFail");
      ThreadManager.post(new VideoRecoveryReporter.6(), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kto
 * JD-Core Version:    0.7.0.1
 */