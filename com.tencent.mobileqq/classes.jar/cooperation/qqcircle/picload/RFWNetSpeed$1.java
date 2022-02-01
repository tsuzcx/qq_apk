package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.qphone.base.util.QLog;

class RFWNetSpeed$1
  implements IQQFrontBackListener
{
  RFWNetSpeed$1(RFWNetSpeed paramRFWNetSpeed) {}
  
  public void onQQEnterBackground()
  {
    QLog.d("QCircleNetSpeed", 1, "onQQEnterBackground stop report");
    RFWNetSpeed.access$002(this.this$0, true);
    this.this$0.stop();
  }
  
  public void onQQEnterForeground()
  {
    RFWNetSpeed.access$002(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWNetSpeed.1
 * JD-Core Version:    0.7.0.1
 */