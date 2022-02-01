package cooperation.vip.qqbanner;

import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;

class QbossADBannerCountDownManager$1
  implements Runnable
{
  QbossADBannerCountDownManager$1(QbossADBannerCountDownManager paramQbossADBannerCountDownManager, QbossADBannerConfigInfo paramQbossADBannerConfigInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    do
    {
      do
      {
        return;
      } while (!(this.a instanceof QbossADBannerCountDownInfo));
      QbossADBannerCountDownManager.a(this.this$0, (QbossADBannerCountDownInfo)this.a);
      QbossADBannerCountDownManager.a(this.this$0).setText(QbossADBannerCountDownManager.a(this.this$0, QbossADBannerCountDownManager.a(this.this$0).f));
      QbossADBannerCountDownManager.b(this.this$0).setText(QbossADBannerCountDownManager.b(this.this$0, QbossADBannerCountDownManager.a(this.this$0).g));
      QbossADBannerCountDownManager.a(this.this$0).setTextColor(QbossADBannerCountDownManager.a(this.this$0, QbossADBannerCountDownManager.a(this.this$0).h));
      QbossADBannerCountDownManager.b(this.this$0).setTextColor(QbossADBannerCountDownManager.b(this.this$0, QbossADBannerCountDownManager.a(this.this$0).h));
      QbossADBannerCountDownManager.a(this.this$0, QbossADBannerCountDownManager.a(this.this$0));
      QbossADBannerCountDownManager.c(this.this$0).setBackgroundDrawable(QbossADBannerCountDownManager.a(this.this$0, QbossADBannerCountDownManager.a(this.this$0).i));
      QbossADBannerCountDownManager.c(this.this$0).setTextColor(QbossADBannerCountDownManager.c(this.this$0, QbossADBannerCountDownManager.a(this.this$0).j));
    } while (QbossADBannerCountDownManager.a(this.this$0).d != 1);
    QbossADBannerCountDownManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.1
 * JD-Core Version:    0.7.0.1
 */