package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class OnTopicDeliverClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  private int c;
  private String d;
  
  public OnTopicDeliverClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt, String paramString)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramInt;
    this.d = paramString;
  }
  
  private void a()
  {
    JumpAction localJumpAction = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b, this.d);
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
      localStringBuilder.append(this.a.mAlgorithmID);
      localStringBuilder.append("");
      ((JSONObject)localObject).put("algorithm_id", localStringBuilder.toString());
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("feeds_type", RIJFeedsType.g(this.a));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.mChannelID);
      ((JSONObject)localObject).put("channel_id", localStringBuilder.toString());
      ((JSONObject)localObject).put("feeds_source", RIJFeedsType.k(this.a));
      ((JSONObject)localObject).put("imei", ReadInJoyUtils.c());
      ((JSONObject)localObject).put("imsi", ReadInJoyUtils.d());
      ((JSONObject)localObject).put("rowkey", this.a.innerUniqueID);
      ((JSONObject)localObject).put("comment", this.a.mSocialFeedInfo.e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.businessId);
      ((JSONObject)localObject).put("topic_id", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(RIJAppSetting.b());
      ((JSONObject)localObject).put("kandian_mode", localStringBuilder.toString());
      ((JSONObject)localObject).put("mark_type", paramString);
      PublicAccountReportUtils.a(null, String.valueOf(RIJItemViewTypeUtils.a(this.a, this.c)), "0X80097CB", "0X80097CB", 0, 0, String.valueOf(this.a.mSocialFeedInfo.a), String.valueOf(this.a.mArticleID), String.valueOf(this.a.mStrategyId), ((JSONObject)localObject).toString(), false);
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
    paramViewBase = this.a;
    if (paramViewBase == null) {
      return;
    }
    if ((paramViewBase.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.x != null))
    {
      int i = this.c;
      if ((i == 72) || (i == 73))
      {
        a("4");
        return;
      }
    }
    if (!TextUtils.isEmpty(this.d))
    {
      a();
      String str1 = "1";
      paramViewBase = str1;
      try
      {
        if (!TextUtils.isEmpty(this.a.proteusItemsData))
        {
          String str2 = new JSONObject(this.a.proteusItemsData).optString("biz_type", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicDeliverClickListener
 * JD-Core Version:    0.7.0.1
 */