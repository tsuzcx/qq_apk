package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class OnMoreBiuClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  Context b;
  
  public OnMoreBiuClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    for (;;)
    {
      Object localObject2;
      String str1;
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID);
        ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        ((JSONObject)localObject1).put("feeds_type", paramInt);
        ((JSONObject)localObject1).put("time", System.currentTimeMillis());
        ((JSONObject)localObject1).put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        boolean bool = NetworkState.isWifiConn();
        int i = 1;
        if (!bool) {
          break label418;
        }
        paramInt = 2;
        ((JSONObject)localObject1).put("network_type", paramInt);
        ((JSONObject)localObject1).put("feeds_source", RIJFeedsType.k(paramAbsBaseArticleInfo));
        ((JSONObject)localObject1).put("imei", RIJDeviceUtil.a());
        ((JSONObject)localObject1).put("imsi", RIJDeviceUtil.b());
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
          ((JSONObject)localObject1).put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        }
        ((JSONObject)localObject1).put("comment", paramAbsBaseArticleInfo.mSocialFeedInfo.j);
        if (ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label423;
        }
        paramInt = i;
        ((JSONObject)localObject1).put("reddot_style", paramInt);
        ((JSONObject)localObject1).put("tab_source", RIJTransMergeKanDianReport.b());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJAppSetting.b());
        ((JSONObject)localObject1).put("kandian_mode", ((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str1 = "";
      }
      if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = "0";
      }
      String str2;
      if (paramAbsBaseArticleInfo.mChannelID == 70L) {
        str2 = "0X8009488";
      } else {
        str2 = "0X8009492";
      }
      String str3 = RIJFeedsType.k(paramAbsBaseArticleInfo);
      long l = paramAbsBaseArticleInfo.mFeedId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, str3, str2, str2, 0, 0, String.valueOf(l), (String)localObject2, localStringBuilder.toString(), str1, false);
      return;
      label418:
      paramInt = 1;
      continue;
      label423:
      paramInt = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJFeedsType.g(this.a);
    ReadInJoyLogicEngine.a().a(this.a.mExtraBiuBriefInfo, this.a);
    a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnMoreBiuClickListener
 * JD-Core Version:    0.7.0.1
 */