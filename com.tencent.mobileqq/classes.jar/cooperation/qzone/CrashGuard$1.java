package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashGuard$1
  implements Runnable
{
  CrashGuard$1(CrashGuard paramCrashGuard, long paramLong) {}
  
  public void run()
  {
    this.this$0.isTimeOvered.set(true);
    QLog.i("QZLog", 1, "clear crash count with no crash");
    LocalMultiProcConfig.putInt4Uin("key_crash_count", 0, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.CrashGuard.1
 * JD-Core Version:    0.7.0.1
 */