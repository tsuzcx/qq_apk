package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import java.util.List;

public class ChannelBottomBanner
  extends ChannelTopBanner
{
  public ChannelBottomBanner(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839601);
      this.b = getResources().getDrawable(2130839600);
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  protected void a(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131559964, this, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager = ((RollViewPager)findViewById(2131380851));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370213));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnTouchStateChangeListener(new ChannelBottomBanner.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter = new BannerAdapter(paramActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager, BannerAdapter.b);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter);
    paramActivity = new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    paramActivity.a(400);
    paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager);
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, TopBannerInfo paramTopBannerInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter != null)
    {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramTopBannerInfo);
        a();
        a(true);
        return;
      }
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelBottomBanner
 * JD-Core Version:    0.7.0.1
 */