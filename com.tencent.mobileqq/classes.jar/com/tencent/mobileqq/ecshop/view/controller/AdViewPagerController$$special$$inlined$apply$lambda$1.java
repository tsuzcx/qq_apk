package com.tencent.mobileqq.ecshop.view.controller;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/view/controller/AdViewPagerController$1$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdViewPagerController$$special$$inlined$apply$lambda$1
  implements ViewPager.OnPageChangeListener
{
  AdViewPagerController$$special$$inlined$apply$lambda$1(ViewPager paramViewPager, AdViewPagerController paramAdViewPagerController) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == AdViewPagerController.b(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController).size() - 1)
    {
      JumpUtil.b(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getContext());
      AdViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController).setCurrentItem(AdViewPagerController.b(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController).size() - 2, true);
    }
    else if (paramInt != AdViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController))
    {
      AdViewPagerController.b(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController, paramInt);
      AdViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected position = ");
    localStringBuilder.append(paramInt);
    QLog.d("AdViewPagerController", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdViewPagerController..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */