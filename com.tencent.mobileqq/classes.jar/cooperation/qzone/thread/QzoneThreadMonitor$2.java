package cooperation.qzone.thread;

import android.util.Printer;
import com.tencent.qphone.base.util.QLog;

class QzoneThreadMonitor$2
  implements Printer
{
  QzoneThreadMonitor$2(QzoneThreadMonitor paramQzoneThreadMonitor) {}
  
  public void println(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneThreadMonitor", 4, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor.2
 * JD-Core Version:    0.7.0.1
 */