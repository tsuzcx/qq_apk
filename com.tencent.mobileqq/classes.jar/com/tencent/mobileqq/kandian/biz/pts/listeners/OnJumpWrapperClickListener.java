package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class OnJumpWrapperClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnJumpWrapperClickListener(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = (String)RIJSPUtils.a("kd_topic_recommend_card_jump_url", "0");
    if (QLog.isColorLevel()) {
      QLog.d("OnJumpWrapperClickListener", 2, new Object[] { "jumpUrl = ", paramViewBase });
    }
    if (!TextUtils.isEmpty(paramViewBase))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localAbsBaseArticleInfo != null) {
        RIJFrameworkReportManager.b(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
      }
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnJumpWrapperClickListener
 * JD-Core Version:    0.7.0.1
 */