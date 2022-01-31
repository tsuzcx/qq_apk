package cooperation.qzone.share;

import bcpq;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$21
  implements Runnable
{
  QZoneShareActivity$21(QZoneShareActivity paramQZoneShareActivity) {}
  
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
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.21
 * JD-Core Version:    0.7.0.1
 */