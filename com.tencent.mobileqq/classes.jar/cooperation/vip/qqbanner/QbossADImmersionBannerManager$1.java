package cooperation.vip.qqbanner;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.startup.step.SetSplash;

class QbossADImmersionBannerManager$1
  implements View.OnLayoutChangeListener
{
  QbossADImmersionBannerManager$1(QbossADImmersionBannerManager paramQbossADImmersionBannerManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView.getHeight() > 0)
    {
      QbossADImmersionBannerManager.a(this.a).removeOnLayoutChangeListener(this);
      SetSplash.a(QbossADImmersionBannerManager.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */