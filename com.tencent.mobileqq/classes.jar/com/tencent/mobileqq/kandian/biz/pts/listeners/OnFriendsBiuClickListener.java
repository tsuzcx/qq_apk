package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import org.json.JSONObject;

public class OnFriendsBiuClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnFriendsBiuClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private long a()
  {
    if (!RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 77) && (i != 78))
      {
        if (!RIJItemViewTypeUtils.m(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
        {
          i = this.jdField_a_of_type_Int;
          if ((i != 72) && (i != 74))
          {
            if (i == 76)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser == null)) {
                break label237;
              }
              return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
            }
            if (!RIJItemViewTypeUtils.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
            {
              i = this.jdField_a_of_type_Int;
              if ((i != 73) && (i != 75)) {
                break label237;
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser == null)) {
              break label237;
            }
            return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo == null)) {
          break label237;
        }
        return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID)) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    label237:
    return 0L;
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
        localStringBuilder.append("");
        localJSONObject.put("algorithm_id", localStringBuilder.toString());
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("feeds_type", RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
        localJSONObject.put("channel_id", localStringBuilder.toString());
        boolean bool = NetworkState.isWifiConn();
        int j = 1;
        if (bool)
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("feeds_source", RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
          localJSONObject.put("imei", ReadInJoyUtils.b());
          localJSONObject.put("imsi", ReadInJoyUtils.c());
          localJSONObject.put("idfa", "");
          localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
          localJSONObject.put("comment", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString);
          if (ReadInJoyHelper.x(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label461;
          }
          i = j;
          localJSONObject.put("reddot_style", i);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(RIJTransMergeKanDianReport.a());
          localJSONObject.put("tab_source", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(RIJAppSetting.a());
          localJSONObject.put("kandian_mode", localStringBuilder.toString());
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(a()), "0X800953E", "0X800953E", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), localJSONObject.toString(), false);
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("report error:");
          localStringBuilder.append(localException.toString());
          QLog.d("OnFriendsBiuClickListener", 2, localStringBuilder.toString());
        }
        return;
      }
      int i = 2;
      continue;
      label461:
      i = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.multiBiuSameContentList;
    Object localObject;
    if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
    {
      localObject = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("articleID", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID));
      localBundle.putString("stategyID", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
      localStringBuilder.append("");
      localBundle.putString("algorithm_id", localStringBuilder.toString());
      localBundle.putString("feeds_source", RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      localStringBuilder.append("");
      localBundle.putString("rowkey", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
      localBundle.putString("channel_id", localStringBuilder.toString());
      ((Intent)localObject).putParcelableArrayListExtra("friends_biu_list", paramViewBase);
      ((Intent)localObject).putExtras(localBundle);
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicTransFragmentActivity.class, ReadInjoyFriendsBiuComponentFragment.class);
    }
    a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick:");
      ((StringBuilder)localObject).append(paramViewBase);
      QLog.d("OnFriendsBiuClickListener", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnFriendsBiuClickListener
 * JD-Core Version:    0.7.0.1
 */