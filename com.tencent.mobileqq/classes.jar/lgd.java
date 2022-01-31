import com.tencent.av.VideoSocketReconnectReporter.1;
import com.tencent.av.VideoSocketReconnectReporter.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class lgd
{
  public static void a()
  {
    int i = mqg.a().o;
    int j = ndk.a(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconRequest policyType=%s netType=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    ThreadManager.post(new VideoSocketReconnectReporter.1(i, j), 5, null, false);
  }
  
  public static void a(long paramLong)
  {
    int i = mqg.a().o;
    int j = ndk.a(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconResult policyType=%s netType=%s timeCost=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(paramLong) }));
    }
    ThreadManager.post(new VideoSocketReconnectReporter.2(i, j, paramLong), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lgd
 * JD-Core Version:    0.7.0.1
 */