package cooperation.qzone.share;

import android.content.res.Resources;
import bbms;
import com.tencent.qphone.base.util.QLog;

class QZoneShareActivity$19
  implements Runnable
{
  QZoneShareActivity$19(QZoneShareActivity paramQZoneShareActivity, int paramInt) {}
  
  public void run()
  {
    if (QZoneShareActivity.a(this.this$0) == null) {
      QZoneShareActivity.a(this.this$0, new bbms(this.this$0, this.this$0.getResources().getDimensionPixelSize(2131167766)));
    }
    QZoneShareActivity.a(this.this$0).c(this.a);
    try
    {
      QZoneShareActivity.a(this.this$0).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneShare", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.19
 * JD-Core Version:    0.7.0.1
 */