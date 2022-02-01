package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class OnTopicDeliverClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public OnTopicDeliverClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    JumpAction localJumpAction = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (localJumpAction != null) {
      localJumpAction.a();
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
      localStringBuilder.append("");
      ((JSONObject)localObject).put("algorithm_id", localStringBuilder.toString());
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("feeds_type", RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
      ((JSONObject)localObject).put("channel_id", localStringBuilder.toString());
      ((JSONObject)localObject).put("feeds_source", RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      ((JSONObject)localObject).put("imei", ReadInJoyUtils.b());
      ((JSONObject)localObject).put("imsi", ReadInJoyUtils.c());
      ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("comment", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.businessId);
      ((JSONObject)localObject).put("topic_id", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJAppSetting.a());
      ((JSONObject)localObject).put("kandian_mode", localStringBuilder.toString());
      ((JSONObject)localObject).put("mark_type", paramString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int)), "0X80097CB", "0X80097CB", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report error:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("OnTopicDeliverClickListener", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (paramViewBase == null) {
      return;
    }
    if ((paramViewBase.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null))
    {
      int i = this.jdField_a_of_type_Int;
      if ((i == 72) || (i == 73))
      {
        a("4");
        return;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a();
      String str1 = "1";
      paramViewBase = str1;
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData))
        {
          String str2 = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData).optString("biz_type", "");
          boolean bool = TextUtils.isEmpty(str2);
          paramViewBase = str1;
          if (!bool) {
            paramViewBase = str2;
          }
        }
      }
      catch (Exception paramViewBase)
      {
        QLog.d("OnTopicDeliverClickListener", 2, "OnTopicDeliverClickListener", paramViewBase);
        paramViewBase = str1;
      }
      a(paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicDeliverClickListener
 * JD-Core Version:    0.7.0.1
 */