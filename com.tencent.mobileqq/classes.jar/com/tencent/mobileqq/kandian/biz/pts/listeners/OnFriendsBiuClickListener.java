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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import org.json.JSONObject;

public class OnFriendsBiuClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  Context b;
  private int c;
  
  public OnFriendsBiuClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramInt;
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.mAlgorithmID);
        localStringBuilder.append("");
        localJSONObject.put("algorithm_id", localStringBuilder.toString());
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("feeds_type", RIJFeedsType.g(this.a));
        localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.mChannelID);
        localJSONObject.put("channel_id", localStringBuilder.toString());
        boolean bool = NetworkState.isWifiConn();
        int j = 1;
        if (bool)
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("feeds_source", RIJFeedsType.k(this.a));
          localJSONObject.put("imei", ReadInJoyUtils.c());
          localJSONObject.put("imsi", ReadInJoyUtils.d());
          localJSONObject.put("idfa", "");
          localJSONObject.put("rowkey", this.a.innerUniqueID);
          localJSONObject.put("comment", this.a.mSocialFeedInfo.e);
          if (ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label451;
          }
          i = j;
          localJSONObject.put("reddot_style", i);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(RIJTransMergeKanDianReport.b());
          localJSONObject.put("tab_source", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(RIJAppSetting.b());
          localJSONObject.put("kandian_mode", localStringBuilder.toString());
          PublicAccountReportUtils.a(null, String.valueOf(b()), "0X800953E", "0X800953E", 0, 0, String.valueOf(this.a.mSocialFeedInfo.a), String.valueOf(this.a.mArticleID), String.valueOf(this.a.mStrategyId), localJSONObject.toString(), false);
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
      label451:
      i = 0;
    }
  }
  
  private long b()
  {
    if (!RIJItemViewTypeUtils.a(this.a))
    {
      int i = this.c;
      if ((i != 77) && (i != 78))
      {
        if (!RIJItemViewTypeUtils.m(this.a))
        {
          i = this.c;
          if ((i != 72) && (i != 74))
          {
            if (i == 76)
            {
              if ((this.a.mSocialFeedInfo == null) || (this.a.mSocialFeedInfo.c == null)) {
                break label237;
              }
              return this.a.mSocialFeedInfo.c.a;
            }
            if (!RIJItemViewTypeUtils.e(this.a))
            {
              i = this.c;
              if ((i != 73) && (i != 75)) {
                break label237;
              }
            }
            if ((this.a.mSocialFeedInfo == null) || (this.a.mSocialFeedInfo.c == null)) {
              break label237;
            }
            return this.a.mSocialFeedInfo.c.a;
          }
        }
        if ((this.a.mSocialFeedInfo == null) || (this.a.mSocialFeedInfo.s == null)) {
          break label237;
        }
        return this.a.mSocialFeedInfo.s.e;
      }
    }
    if (!TextUtils.isEmpty(this.a.mSubscribeID)) {
      try
      {
        long l = Long.parseLong(this.a.mSubscribeID);
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
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.multiBiuSameContentList;
    Object localObject;
    if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
    {
      localObject = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("articleID", String.valueOf(this.a.mArticleID));
      localBundle.putString("stategyID", String.valueOf(this.a.mStrategyId));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.mAlgorithmID);
      localStringBuilder.append("");
      localBundle.putString("algorithm_id", localStringBuilder.toString());
      localBundle.putString("feeds_source", RIJFeedsType.k(this.a));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.innerUniqueID);
      localStringBuilder.append("");
      localBundle.putString("rowkey", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.mChannelID);
      localBundle.putString("channel_id", localStringBuilder.toString());
      ((Intent)localObject).putParcelableArrayListExtra("friends_biu_list", paramViewBase);
      ((Intent)localObject).putExtras(localBundle);
      PublicFragmentActivity.Launcher.a(this.b, (Intent)localObject, PublicTransFragmentActivity.class, ReadInjoyFriendsBiuComponentFragment.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnFriendsBiuClickListener
 * JD-Core Version:    0.7.0.1
 */