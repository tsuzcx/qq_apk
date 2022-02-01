package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLikeButton;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OnLikeClickListener
  extends OnSocialOperationListener
{
  public OnLikeClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    super(paramAbsBaseArticleInfo, paramContext);
  }
  
  private void a(ButtonBase paramButtonBase)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramButtonBase != null) && (!paramButtonBase.isSelected())) {
      RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0));
    }
  }
  
  private void b(ViewBase paramViewBase)
  {
    if ((paramViewBase instanceof ButtonBase))
    {
      paramViewBase = (ButtonBase)paramViewBase;
      b(paramViewBase);
      a(paramViewBase);
      return;
    }
    paramViewBase = paramViewBase.findViewBaseByName("id_like_button");
    if ((paramViewBase instanceof ReadInJoyLikeButton))
    {
      paramViewBase = (ReadInJoyLikeButton)paramViewBase;
      paramViewBase.onClick();
      a(paramViewBase);
    }
  }
  
  private void b(ButtonBase paramButtonBase)
  {
    int i;
    if (paramButtonBase.isSelected()) {
      i = -1;
    } else {
      i = 1;
    }
    paramButtonBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo;
    paramButtonBase.b += i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.b < 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.b = 0;
    }
    paramButtonBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo;
    int j;
    if (i > 0) {
      j = 1;
    } else {
      j = 0;
    }
    paramButtonBase.c = j;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.invalidateProteusTemplateBean();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((RIJFeedsType.T(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
    }
    else
    {
      paramButtonBase = ReadInJoyLogicEngine.a();
      long l1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramButtonBase.a(l1, l2, bool, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.clone());
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.c == 1) {
      return 2;
    }
    return 13;
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnLikeClickListener", 1, "cick like");
    b(paramViewBase);
  }
  
  protected void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo;
    boolean bool = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID);
    Object localObject1;
    if (bool) {
      localObject1 = "0X800935E";
    } else {
      localObject1 = "0X8007B65";
    }
    String str1;
    if (bool) {
      str1 = "0X800935F";
    } else {
      str1 = "0X8007B66";
    }
    String str3;
    long l1;
    long l2;
    if (((SocializeFeedsInfo)localObject2).c == 1)
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.T(paramAbsBaseArticleInfo))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("like", 0);
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
          }
          GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo, "0X8009A74", (JSONObject)localObject1);
          return;
        }
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str3 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Long;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject2).toString(), str2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
        l2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Long;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject2).toString(), str2, false);
      }
      if ((!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
    else
    {
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.T(paramAbsBaseArticleInfo))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("like", 1);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
          GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo, "0X8009A74", (JSONObject)localObject1);
          return;
        }
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str3 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Long;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mStrategyId);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, str3, localJSONException2, localJSONException2, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject2).toString(), str2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
        l2 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_Long;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mStrategyId);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, String.valueOf(l1), localJSONException2, localJSONException2, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject2).toString(), str2, false);
      }
      if ((!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnLikeClickListener
 * JD-Core Version:    0.7.0.1
 */