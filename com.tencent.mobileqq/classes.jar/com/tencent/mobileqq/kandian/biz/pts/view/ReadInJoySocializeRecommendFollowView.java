package com.tencent.mobileqq.kandian.biz.pts.view;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnViewWindowChangedListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListReq;
import tencent.im.oidb.oidb_0xc2f.ReqBody;

public class ReadInJoySocializeRecommendFollowView
  extends ViewBase
  implements DisableSlideHorizontalListView.OnOverScrollListener, DisableSlideHorizontalListView.OnViewWindowChangedListener
{
  private LinearLayout a;
  private DisableSlideHorizontalListView b;
  private ReadInJoySocializeRecommendFollowView.FollowListAdapter c;
  private ViewBase d;
  private ViewBase e;
  private AbsBaseArticleInfo f;
  private int g;
  private ReadInJoyObserver h = new ReadInJoySocializeRecommendFollowView.10(this);
  
  private ReadInJoySocializeRecommendFollowView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = ((LinearLayout)LayoutInflater.from(paramVafContext.getContext()).inflate(2131626333, null));
    this.b = ((DisableSlideHorizontalListView)this.a.findViewById(2131444459));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)this.a.findViewById(2131429396);
    this.b.setSideBarView(localBezierSideBarView);
    this.c = new ReadInJoySocializeRecommendFollowView.FollowListAdapter(this, null);
    this.b.setDividerWidth(DisplayUtil.a(paramVafContext.getContext(), 5.0F));
    this.b.setAdapter(this.c);
    this.b.setOnViewWindowChangedListener(this);
    this.b.setOnOverScrollListener(this);
    this.g = DisplayUtil.a(paramVafContext.getContext(), 6.0F);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestRecommendList, uin = ");
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0xc2f.ReqBody();
    oidb_0xc2f.GetFollowUserRecommendListReq localGetFollowUserRecommendListReq = new oidb_0xc2f.GetFollowUserRecommendListReq();
    localGetFollowUserRecommendListReq.uint64_followed_uin.set(paramLong);
    ((oidb_0xc2f.ReqBody)localObject).msg_get_follow_user_recommend_list_req.set(localGetFollowUserRecommendListReq);
    ProtoUtils.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReadInJoySocializeRecommendFollowView.9(this), ((oidb_0xc2f.ReqBody)localObject).toByteArray(), "OidbSvc.0xc2f", 3119, 1, null, 0L);
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().f(this.f);
    ThreadManager.post(new ReadInJoySocializeRecommendFollowView.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    ReadInJoySocializeRecommendFollowView.7 local7 = new ReadInJoySocializeRecommendFollowView.7(this);
    ReadInJoySocializeRecommendFollowView.8 local8 = new ReadInJoySocializeRecommendFollowView.8(this, paramBoolean);
    ValueAnimator localValueAnimator;
    if (paramBoolean) {
      localValueAnimator = ValueAnimator.ofInt(new int[] { DisplayUtil.a(this.mContext.getContext(), 6.0F), this.a.getMeasuredHeight() });
    } else {
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.a.getMeasuredHeight(), DisplayUtil.a(this.mContext.getContext(), 6.0F) });
    }
    localValueAnimator.addListener(local8);
    localValueAnimator.addUpdateListener(local7);
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  private void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mContext.getContext()))
    {
      QQToast.makeText(this.mContext.getContext(), 1, 2131915450, 0).show();
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToProfile, info = ");
      ((StringBuilder)localObject).append(paramRecommendFollowInfo);
      QLog.d("ReadInJoySocializeRecommendFollowView", 1, ((StringBuilder)localObject).toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      paramRecommendFollowInfo = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(paramRecommendFollowInfo)) && (ViolaAccessHelper.e(paramRecommendFollowInfo)))
      {
        ViolaAccessHelper.a(this.mContext.getContext(), null, ViolaAccessHelper.f(paramRecommendFollowInfo), null);
        return;
      }
      localObject = new ActivityURIRequest(this.mContext.getContext(), "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putString("url", paramRecommendFollowInfo);
      ((ActivityURIRequest)localObject).extra().putBoolean("hide_operation_bar", true);
      ((ActivityURIRequest)localObject).extra().putBoolean("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      QRoute.startUri((URIRequest)localObject, null);
    }
  }
  
  private void d()
  {
    ViewBean localViewBean = new ViewBean();
    ValueBean localValueBean = localViewBean.valueBean;
    boolean bool = this.f.isShowRecommendList;
    String str2 = "VISIBLE";
    String str1;
    if (bool) {
      str1 = "VISIBLE";
    } else {
      str1 = "GONE";
    }
    localValueBean.putTrueDynamicValue("visibility", str1);
    bindDynamicValue(localViewBean);
    localViewBean = new ViewBean();
    localValueBean = localViewBean.valueBean;
    if (this.f.isShowRecommendList) {
      str1 = "GONE";
    } else {
      str1 = "VISIBLE";
    }
    localValueBean.putTrueDynamicValue("visibility", str1);
    try
    {
      if (Util.a(this.f)) {
        localViewBean.valueBean.putTrueDynamicValue("visibility", "GONE");
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoySocializeRecommendFollowView", 2, localJSONException, new Object[0]);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((ViewBase)localObject).bindDynamicValue(localViewBean);
    }
    localViewBean = new ViewBean();
    localValueBean = localViewBean.valueBean;
    if (this.f.isShowRecommendList) {
      localObject = str2;
    } else {
      localObject = "GONE";
    }
    localValueBean.putTrueDynamicValue("visibility", localObject);
    localObject = this.e;
    if (localObject != null) {
      ((ViewBase)localObject).bindDynamicValue(localViewBean);
    }
  }
  
  public void a()
  {
    Object localObject = this.f.mRecommendFollowInfos.f;
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.mContext.getContext(), "/pubaccount/browser");
    localActivityURIRequest.extra().putString("url", (String)localObject);
    QRoute.startUri(localActivityURIRequest, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.c());
    ((StringBuilder)localObject).append("");
    PublicAccountReportUtils.a(null, ((StringBuilder)localObject).toString(), "0X800984C", "0X800984C", 0, 0, "1", "", "", "", false);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.f = paramIReadInJoyModel.k();
    if (this.d == null) {
      this.d = getParent().findViewBaseByName("id_dislike_button");
    }
    if (this.e == null)
    {
      this.e = getParent().findViewBaseByName("id_social_header_fold_button");
      paramIReadInJoyModel = this.e;
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.setOnClickListener(new ReadInJoySocializeRecommendFollowView.1(this));
      }
    }
    d();
    if ((this.f.isShowRecommendList) && (this.f.mRecommendFollowInfos != null) && (this.f.mRecommendFollowInfos.c != null))
    {
      this.c.a(this.f.mRecommendFollowInfos.c);
      paramIReadInJoyModel = new ReadInJoySocializeRecommendFollowView.2(this);
      if (this.a.getMeasuredHeight() == 0)
      {
        this.a.post(paramIReadInJoyModel);
        return;
      }
      paramIReadInJoyModel.run();
      return;
    }
    this.g = DisplayUtil.a(this.mContext.getContext(), 6.0F);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(this.mContext.getContext()))
    {
      if (paramRecommendFollowInfo.type == 1)
      {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      else if (paramRecommendFollowInfo.type == 2)
      {
        b(paramRecommendFollowInfo, paramBoolean);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("followAccount, error type, info.type = ");
        localStringBuilder.append(paramRecommendFollowInfo.type);
        localStringBuilder.append(", follow = ");
        localStringBuilder.append(paramBoolean);
        QLog.e("ReadInJoySocializeRecommendFollowView", 1, localStringBuilder.toString());
      }
      this.c.notifyDataSetChanged();
      return;
    }
    QQToast.makeText(this.mContext.getContext(), 1, 2131915450, 0).show();
  }
  
  public void b()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.h);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecommendFollowInfo.uin);
    localStringBuilder.append("");
    localUserOperationModule.request0x978((String)localObject, localStringBuilder.toString(), paramBoolean, paramRecommendFollowInfo.headUrl, new ReadInJoySocializeRecommendFollowView.3(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.h);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ReadInJoySocializeRecommendFollowView.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ReadInJoySocializeRecommendFollowView.5(this, paramRecommendFollowInfo), 1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.g;
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView
 * JD-Core Version:    0.7.0.1
 */