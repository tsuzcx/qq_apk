package com.tencent.mobileqq.kandian.biz.dislike;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;

class RIJDislikeAnimation$1$1
  implements Runnable
{
  RIJDislikeAnimation$1$1(RIJDislikeAnimation.1 param1) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a(), -1, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a().getString(2131699885), 0).b(((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a()).getTitleBarHeight());
    } else if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a() instanceof PluginBaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a(), -1, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a().getString(2131699885), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a()).g());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeAnimation.a.a().a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */