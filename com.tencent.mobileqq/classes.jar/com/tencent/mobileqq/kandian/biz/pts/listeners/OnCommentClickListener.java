package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OnCommentClickListener
  extends OnSocialOperationListener
{
  private VafContext c;
  
  public OnCommentClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext)
  {
    super(paramAbsBaseArticleInfo, paramVafContext.getContext());
    this.c = paramVafContext;
  }
  
  public static JSONObject b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniqueKey", paramAbsBaseArticleInfo.innerUniqueID);
      localJSONObject.put("source", 3);
      localJSONObject.put("feedsID", "");
      localJSONObject.put("adTag", 1);
      localJSONObject.put("title", Base64Util.encode(paramAbsBaseArticleInfo.mTitle.getBytes(), 0));
      localJSONObject.put("sourceName", paramAbsBaseArticleInfo.getSubscribeName());
      localJSONObject.put("picUrl", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("duration", paramAbsBaseArticleInfo.mVideoDuration);
      localJSONObject.put("articleID", paramAbsBaseArticleInfo.mArticleID);
      localJSONObject.put("isAwesome", paramAbsBaseArticleInfo.hasAwesome);
      localJSONObject.put("jumpType", paramAbsBaseArticleInfo.mJumpType);
      localJSONObject.put("recommendSeq", paramAbsBaseArticleInfo.mRecommendSeq);
      return localJSONObject;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      label141:
      break label141;
    }
    QLog.d("OnCommentClickListener", 1, "buildNativeCommentJson fail");
    return localJSONObject;
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((!RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) && (!RIJBaseItemViewType.a(paramAbsBaseArticleInfo)))
    {
      RIJJumpUtils.a(this.b, paramAbsBaseArticleInfo, true);
      return;
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.commentJumpUrl))
    {
      RIJJumpUtils.c(this.b, paramAbsBaseArticleInfo.commentJumpUrl);
      return;
    }
    if ((paramAbsBaseArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getCardJumpUrl()))) {
      RIJJumpUtils.c(this.b, paramAbsBaseArticleInfo.getCardJumpUrl());
    }
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (RIJItemViewTypeUtils.E(this.a))
    {
      ViolaBizUtils.a(b(this.a), 0);
      return;
    }
    if (this.a.mFeedType == 36)
    {
      if ((this.b instanceof Activity)) {
        RIJJumpUtils.b(this.b, this.a, 8);
      }
    }
    else
    {
      if ((this.a.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.j > 0) && (!((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.a)))
      {
        QLog.d("OnCommentClickListener", 1, "jumpUrl");
        c(this.a);
        return;
      }
      QLog.d("OnCommentClickListener", 1, "openCommentComponent");
      ReadInJoyCommentUtils.a(this.c.getCurActivity(), this.a, null, 9, HardCodeUtil.a(2131905653), null, false, null, false, null, 1);
    }
  }
  
  protected void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str1;
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009360";
    } else {
      str1 = "0X8007B67";
    }
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    long l1;
    long l2;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      String str3 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = ((SocializeFeedsInfo)localObject).a;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, str3, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str2, false);
      return;
    }
    if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
    {
      l1 = ((SocializeFeedsInfo)localObject).s.e;
      l2 = ((SocializeFeedsInfo)localObject).a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject).toString(), str2, false);
    }
    if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnCommentClickListener
 * JD-Core Version:    0.7.0.1
 */