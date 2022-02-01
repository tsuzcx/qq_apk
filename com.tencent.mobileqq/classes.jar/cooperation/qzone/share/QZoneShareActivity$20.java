package cooperation.qzone.share;

import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$20
  implements Runnable
{
  QZoneShareActivity$20(QZoneShareActivity paramQZoneShareActivity, int paramInt) {}
  
  public void run()
  {
    if (QZoneShareActivity.access$1800(this.this$0) == null)
    {
      QZoneShareActivity localQZoneShareActivity = this.this$0;
      QZoneShareActivity.access$1802(localQZoneShareActivity, new QQProgressDialog(localQZoneShareActivity, localQZoneShareActivity.getResources().getDimensionPixelSize(2131299168)));
    }
    QZoneShareActivity.access$1800(this.this$0).c(this.val$resId);
    try
    {
      QZoneShareActivity.access$1800(this.this$0).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.20
 * JD-Core Version:    0.7.0.1
 */