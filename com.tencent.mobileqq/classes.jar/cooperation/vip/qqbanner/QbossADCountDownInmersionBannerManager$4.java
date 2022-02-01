package cooperation.vip.qqbanner;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;

class QbossADCountDownInmersionBannerManager$4
  extends TimerTask
{
  QbossADCountDownInmersionBannerManager$4(QbossADCountDownInmersionBannerManager paramQbossADCountDownInmersionBannerManager) {}
  
  public void run()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QbossADCountDownInmersionBannerManager.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADCountDownInmersionBannerManager.4
 * JD-Core Version:    0.7.0.1
 */