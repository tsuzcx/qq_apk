package cooperation.qzone.share;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QZoneShareData;
import mqq.os.MqqHandler;

class QZoneShareActivity$7
  implements Runnable
{
  QZoneShareActivity$7(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if ((this.this$0.app != null) && (QZoneShareActivity.a(this.this$0).a > 0L) && (!TextUtils.isEmpty(QZoneShareActivity.a(this.this$0).i)) && (!this.this$0.a(this.this$0.app, QZoneShareActivity.a(this.this$0).a, QZoneShareActivity.a(this.this$0).i))) {
      return;
    }
    int i = this.this$0.b();
    int j = this.this$0.a();
    ThreadManager.getUIHandler().post(new QZoneShareActivity.7.1(this, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.7
 * JD-Core Version:    0.7.0.1
 */