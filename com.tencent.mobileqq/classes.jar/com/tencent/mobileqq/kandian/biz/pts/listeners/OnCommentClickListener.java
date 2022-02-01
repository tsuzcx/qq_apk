package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  private VafContext a;
  
  public OnCommentClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext)
  {
    super(paramAbsBaseArticleInfo, paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  public static JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((!RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo)) && (!RIJBaseItemViewType.a(paramAbsBaseArticleInfo)))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo, true);
      return;
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.commentJumpUrl))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo.commentJumpUrl);
      return;
    }
    if ((paramAbsBaseArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.getCardJumpUrl()))) {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo.getCardJumpUrl());
    }
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (RIJItemViewTypeUtils.B(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      ViolaBizUtils.a(a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 36)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        RIJJumpUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 8);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.d > 0) && (!((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        QLog.d("OnCommentClickListener", 1, "jumpUrl");
        b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        return;
      }
      QLog.d("OnCommentClickListener", 1, "openCommentComponent");
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null, 9, HardCodeUtil.a(2131707839), null, false, null, false, null, 1);
    }
  }
  
  protected void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str1;
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009360";
    } else {
      str1 = "0X8007B67";
    }
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    long l1;
    long l2;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str3 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str2, false);
      return;
    }
    if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      l1 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      l2 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject).toString(), str2, false);
    }
    if ((!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnCommentClickListener
 * JD-Core Version:    0.7.0.1
 */