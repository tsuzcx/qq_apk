package cooperation.qqcircle.picload;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;

class QCircleNetSpeed$1
  implements IQQFrontBackListener
{
  QCircleNetSpeed$1(QCircleNetSpeed paramQCircleNetSpeed) {}
  
  public void onQQEnterBackground()
  {
    RFLog.d("QCircleNetSpeed", RFLog.USR, "onQQEnterBackground stop report");
    QCircleNetSpeed.access$002(this.this$0, true);
    this.this$0.stop();
  }
  
  public void onQQEnterForeground()
  {
    QCircleNetSpeed.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleNetSpeed.1
 * JD-Core Version:    0.7.0.1
 */