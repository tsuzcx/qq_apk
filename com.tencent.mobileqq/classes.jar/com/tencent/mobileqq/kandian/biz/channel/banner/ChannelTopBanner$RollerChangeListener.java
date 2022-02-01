package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

public class ChannelTopBanner$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected ChannelTopBanner$RollerChangeListener(ChannelTopBanner paramChannelTopBanner) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
    ChannelTopBanner localChannelTopBanner = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
    int j = 1;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localChannelTopBanner.jdField_a_of_type_Boolean = bool;
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.getCurrentItem();
    localChannelTopBanner = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
    localChannelTopBanner.jdField_a_of_type_Int = i;
    paramInt = localChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.instantiateItem(null, paramInt - 2);
    } else if (i == paramInt - 2) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.instantiateItem(null, 1);
    }
    if (i == 0) {
      paramInt -= 2;
    } else if (i == paramInt - 1) {
      paramInt = j;
    } else {
      paramInt = i;
    }
    if (i != paramInt)
    {
      localChannelTopBanner = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
      localChannelTopBanner.jdField_a_of_type_Int = paramInt;
      localChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setCurrentItem(paramInt, false);
      ChannelTopBanner.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner, paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramInt);
    if ((i >= 0) && (this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView.length > i) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView.length > this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_Int].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.b);
      this.jdField_a_of_type_Int = i;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */