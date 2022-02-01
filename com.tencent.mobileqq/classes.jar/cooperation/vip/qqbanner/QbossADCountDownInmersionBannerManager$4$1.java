package cooperation.vip.qqbanner;

import android.widget.TextView;
import cooperation.qzone.util.QZLog;

class QbossADCountDownInmersionBannerManager$4$1
  implements Runnable
{
  QbossADCountDownInmersionBannerManager$4$1(QbossADCountDownInmersionBannerManager.4 param4) {}
  
  public void run()
  {
    if (QbossADCountDownInmersionBannerManager.a(this.a.this$0) == null) {
      return;
    }
    long l = (QbossADCountDownInmersionBannerManager.a(this.a.this$0) - System.currentTimeMillis()) / 1000L;
    if (QZLog.isColorLevel()) {
      QZLog.i("QbossADCountDownInmersi", 2, "count down text = " + QbossADCountDownInmersionBannerManager.a(this.a.this$0).getText() + " currentTime = " + l + " mCountDownTime = " + QbossADCountDownInmersionBannerManager.a(this.a.this$0) + " millis = " + (QbossADCountDownInmersionBannerManager.a(this.a.this$0) - System.currentTimeMillis()));
    }
    if (l <= 0L)
    {
      QbossADCountDownInmersionBannerManager.a(this.a.this$0);
      return;
    }
    QbossADCountDownInmersionBannerManager.a(this.a.this$0).setText(QbossADCountDownInmersionBannerManager.a(this.a.this$0, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADCountDownInmersionBannerManager.4.1
 * JD-Core Version:    0.7.0.1
 */