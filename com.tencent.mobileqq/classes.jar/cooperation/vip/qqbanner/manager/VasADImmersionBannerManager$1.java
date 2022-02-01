package cooperation.vip.qqbanner.manager;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.startup.step.SetSplash;

class VasADImmersionBannerManager$1
  implements View.OnLayoutChangeListener
{
  VasADImmersionBannerManager$1(VasADImmersionBannerManager paramVasADImmersionBannerManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView.getHeight() > 0)
    {
      this.a.b.removeOnLayoutChangeListener(this);
      SetSplash.a(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */