package cooperation.qzone.share;

import bhht;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$21
  implements Runnable
{
  QZoneShareActivity$21(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((QZoneShareActivity.access$1800(this.this$0) != null) && (QZoneShareActivity.access$1800(this.this$0).isShowing())) {}
    try
    {
      QZoneShareActivity.access$1800(this.this$0).dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.21
 * JD-Core Version:    0.7.0.1
 */