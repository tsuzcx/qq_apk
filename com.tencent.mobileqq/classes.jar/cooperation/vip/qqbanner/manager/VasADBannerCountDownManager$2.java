package cooperation.vip.qqbanner.manager;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;

class VasADBannerCountDownManager$2
  extends TimerTask
{
  VasADBannerCountDownManager$2(VasADBannerCountDownManager paramVasADBannerCountDownManager) {}
  
  public void run()
  {
    ThreadManagerV2.getUIHandlerV2().post(new VasADBannerCountDownManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.2
 * JD-Core Version:    0.7.0.1
 */