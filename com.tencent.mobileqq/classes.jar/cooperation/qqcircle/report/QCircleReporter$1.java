package cooperation.qqcircle.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QCircleReporter$1
  extends Handler
{
  QCircleReporter$1(QCircleReporter paramQCircleReporter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 4097)
    {
      if (i != 4098) {
        return;
      }
      QCircleReporter.access$100(this.this$0);
      return;
    }
    QCircleReporter.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.1
 * JD-Core Version:    0.7.0.1
 */