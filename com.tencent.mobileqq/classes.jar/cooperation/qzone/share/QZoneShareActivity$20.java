package cooperation.qzone.share;

import bbms;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$20
  implements Runnable
{
  QZoneShareActivity$20(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((QZoneShareActivity.a(this.this$0) != null) && (QZoneShareActivity.a(this.this$0).isShowing())) {}
    try
    {
      QZoneShareActivity.a(this.this$0).dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.20
 * JD-Core Version:    0.7.0.1
 */