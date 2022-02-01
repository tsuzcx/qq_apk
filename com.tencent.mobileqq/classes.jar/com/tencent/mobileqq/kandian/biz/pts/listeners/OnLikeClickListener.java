package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
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
    if ((this.a != null) && (paramButtonBase != null) && (!paramButtonBase.isSelected())) {
      RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(this.a, new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0));
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
    paramButtonBase = this.a.mSocialFeedInfo;
    paramButtonBase.h += i;
    if (this.a.mSocialFeedInfo.h < 0) {
      this.a.mSocialFeedInfo.h = 0;
    }
    paramButtonBase = this.a.mSocialFeedInfo;
    int j;
    if (i > 0) {
      j = 1;
    } else {
      j = 0;
    }
    paramButtonBase.i = j;
    this.a.invalidateProteusTemplateBean();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = this.a;
    if ((RIJFeedsType.ab(this.a)) && (!TextUtils.isEmpty(this.a.innerUniqueID)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
    }
    else
    {
      paramButtonBase = ReadInJoyLogicEngine.a();
      long l1 = RIJQQAppInterfaceUtil.c();
      long l2 = this.a.mFeedId;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramButtonBase.a(l1, l2, bool, this.a.clone());
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
  
  protected int a()
  {
    if (this.a.mSocialFeedInfo.i == 1) {
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
    Object localObject3 = paramAbsBaseArticleInfo.mSocialFeedInfo;
    boolean bool = ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID);
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
    long l1;
    long l2;
    if (((SocializeFeedsInfo)localObject3).i == 1)
    {
      Object localObject2;
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.ab(paramAbsBaseArticleInfo))
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
          GalleryReportedUtils.a(this.b, paramAbsBaseArticleInfo, "0X8009A74", (JSONObject)localObject1);
          return;
        }
        localObject2 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = ((SocializeFeedsInfo)localObject3).a;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, (String)localObject2, (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject3).toString(), str2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        l1 = ((SocializeFeedsInfo)localObject3).s.e;
        l2 = ((SocializeFeedsInfo)localObject3).a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, String.valueOf(l1), (String)localObject1, (String)localObject1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject2).toString(), str2, false);
      }
      if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
    else
    {
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.ab(paramAbsBaseArticleInfo))
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
          GalleryReportedUtils.a(this.b, paramAbsBaseArticleInfo, "0X8009A74", (JSONObject)localObject1);
          return;
        }
        localObject1 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = ((SocializeFeedsInfo)localObject3).a;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, (String)localObject1, localJSONException2, localJSONException2, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject3).toString(), str2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        l1 = ((SocializeFeedsInfo)localObject3).s.e;
        l2 = ((SocializeFeedsInfo)localObject3).a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, String.valueOf(l1), localJSONException2, localJSONException2, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject1).toString(), str2, false);
      }
      if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnLikeClickListener
 * JD-Core Version:    0.7.0.1
 */