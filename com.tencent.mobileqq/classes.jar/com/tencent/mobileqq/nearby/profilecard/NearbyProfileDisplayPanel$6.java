package com.tencent.mobileqq.nearby.profilecard;

import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileDisplayPanel$6
  implements ViewPager.OnPageChangeListener
{
  NearbyProfileDisplayPanel$6(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.a.a(paramInt, true);
    Object localObject1 = this.a.O;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("android:switcher:2131450002:");
    ((StringBuilder)localObject2).append(paramInt);
    localObject1 = (NearbyBaseFragment)((FragmentManager)localObject1).findFragmentByTag(((StringBuilder)localObject2).toString());
    if (localObject1 != null) {
      ((NearbyBaseFragment)localObject1).dw_();
    }
    if (this.a.e.mMode == 2) {
      if (paramInt == this.a.x())
      {
        this.a.P.setVisibility(8);
      }
      else
      {
        this.a.P.setVisibility(0);
        localObject2 = new ReportTask(this.a.e.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(String.valueOf(this.a.f.tinyId));
        if (this.a.e.mMode == 2) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      }
    }
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.6
 * JD-Core Version:    0.7.0.1
 */