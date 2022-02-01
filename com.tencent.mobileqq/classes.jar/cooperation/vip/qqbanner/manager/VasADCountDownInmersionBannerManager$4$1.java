package cooperation.vip.qqbanner.manager;

import android.widget.TextView;
import cooperation.qzone.util.QZLog;

class VasADCountDownInmersionBannerManager$4$1
  implements Runnable
{
  VasADCountDownInmersionBannerManager$4$1(VasADCountDownInmersionBannerManager.4 param4) {}
  
  public void run()
  {
    if (VasADCountDownInmersionBannerManager.a(this.a.this$0) == null) {
      return;
    }
    long l = (VasADCountDownInmersionBannerManager.a(this.a.this$0) - System.currentTimeMillis()) / 1000L;
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("count down text = ");
      localStringBuilder.append(VasADCountDownInmersionBannerManager.a(this.a.this$0).getText());
      localStringBuilder.append(" currentTime = ");
      localStringBuilder.append(l);
      localStringBuilder.append(" mCountDownTime = ");
      localStringBuilder.append(VasADCountDownInmersionBannerManager.a(this.a.this$0));
      localStringBuilder.append(" millis = ");
      localStringBuilder.append(VasADCountDownInmersionBannerManager.a(this.a.this$0) - System.currentTimeMillis());
      QZLog.i("QbossADCountDownInmersi", 2, localStringBuilder.toString());
    }
    if (l <= 0L)
    {
      VasADCountDownInmersionBannerManager.a(this.a.this$0);
      return;
    }
    VasADCountDownInmersionBannerManager.a(this.a.this$0).setText(VasADCountDownInmersionBannerManager.a(this.a.this$0, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.4.1
 * JD-Core Version:    0.7.0.1
 */