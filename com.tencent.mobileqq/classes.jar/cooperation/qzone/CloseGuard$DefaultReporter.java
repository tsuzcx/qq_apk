package cooperation.qzone;

import cooperation.qzone.util.QZLog;

final class CloseGuard$DefaultReporter
  implements CloseGuard.Reporter
{
  public void report(String paramString, Throwable paramThrowable)
  {
    QZLog.e("QZLog", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.CloseGuard.DefaultReporter
 * JD-Core Version:    0.7.0.1
 */