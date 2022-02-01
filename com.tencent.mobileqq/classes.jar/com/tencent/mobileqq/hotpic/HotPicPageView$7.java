package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToastNotifier;

class HotPicPageView$7
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotPicPageView$7(HotPicPageView paramHotPicPageView, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.originalUrl = paramHotVideoGetUrlResult.a();
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a == 1) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a != 1)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new HotPicPageView.7.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-11);
    new QQToastNotifier(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.a, 100, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.7
 * JD-Core Version:    0.7.0.1
 */