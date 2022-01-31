package cooperation.vip.qqbanner;

import android.os.Handler;
import bgqp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;

public class QbossADBannerCountDownManager$2
  extends TimerTask
{
  public QbossADBannerCountDownManager$2(bgqp parambgqp) {}
  
  public void run()
  {
    ThreadManagerV2.getUIHandlerV2().post(new QbossADBannerCountDownManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.2
 * JD-Core Version:    0.7.0.1
 */