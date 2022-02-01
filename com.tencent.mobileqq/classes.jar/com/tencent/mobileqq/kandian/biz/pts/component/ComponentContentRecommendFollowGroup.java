package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements DisableSlideHorizontalListView.OnOverScrollListener, ComponentInheritView
{
  private static int i = -1;
  protected ReadInJoyObserver a = new ComponentContentRecommendFollowGroup.4(this);
  private DisableSlideHorizontalListView b;
  private ComponentContentRecommendFollowGroup.FollowListAdapter c;
  private TextView d;
  private AbsBaseArticleInfo e;
  private View f;
  private View g;
  private IReadInJoyModel h;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos.h != null))
    {
      if (paramAbsBaseArticleInfo.mRecommendFollowInfos.h.size() <= 0) {
        return;
      }
      Iterator localIterator = paramAbsBaseArticleInfo.mRecommendFollowInfos.h.values().iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, 3, 0, i, null);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        PublicAccountReportUtils.a(null, (String)localObject1, "0X80094DB", "0X80094DB", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        PublicAccountReportUtils.a(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
      }
      paramAbsBaseArticleInfo.mRecommendFollowInfos.h.clear();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626178, this, true);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(View paramView)
  {
    this.b = ((DisableSlideHorizontalListView)paramView.findViewById(2131444459));
    this.d = ((TextView)paramView.findViewById(2131444467));
    this.f = paramView.findViewById(2131436957);
    this.g = paramView.findViewById(2131444462);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131429396);
    this.b.setSideBarView(localBezierSideBarView);
    this.c = new ComponentContentRecommendFollowGroup.FollowListAdapter(this, null);
    this.b.setDividerWidth(DisplayUtil.a(paramView.getContext(), 5.0F));
    this.b.setAdapter(this.c);
    this.b.setOnOverScrollListener(this);
    this.g.setOnClickListener(new ComponentContentRecommendFollowGroup.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.makeText(getContext(), 1, 2131915450, 0).show();
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToProfile, info = ");
      ((StringBuilder)localObject).append(paramRecommendFollowInfo);
      QLog.d("ComponentContentRecommendFollowGroup", 1, ((StringBuilder)localObject).toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (ViolaAccessHelper.e((String)localObject)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.f((String)localObject), null);
        return;
      }
      paramRecommendFollowInfo = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      paramRecommendFollowInfo.putExtra("url", (String)localObject);
      paramRecommendFollowInfo.putExtra("hide_operation_bar", true);
      paramRecommendFollowInfo.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      ((Activity)getContext()).startActivityForResult(paramRecommendFollowInfo, 1);
    }
  }
  
  public void a(Object paramObject)
  {
    i = RIJTransMergeKanDianReport.b();
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.h = ((IReadInJoyModel)paramObject);
      this.e = this.h.k();
      paramObject = this.e;
      if (paramObject == null) {
        return;
      }
      paramObject = paramObject.mRecommendFollowInfos;
      this.d.setText(paramObject.e);
      this.c.a(paramObject.g);
      if (this.e.mRecommendFollowInfos.a)
      {
        this.f.setVisibility(0);
        return;
      }
      this.f.setVisibility(8);
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<RecommendFollowInfo> paramList)
  {
    Object localObject1 = this.h;
    int j;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).u() != null)) {
      j = this.h.u().c();
    } else {
      j = 0;
    }
    paramList = ComponentContentRecommend.a(j, paramLong1, this.e, paramLong2, 3, paramInt2, i, paramList);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.e.mRecommendFollowId);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.e.mArticleID);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), paramList, false);
  }
  
  protected void a(List<RecommendFollowInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    RecommendFollowInfo localRecommendFollowInfo;
    while (j < paramList.size())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)paramList.get(j);
      if (paramBoolean != localRecommendFollowInfo.isFollowed)
      {
        localArrayList1.add(new BatchFollowModel(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
        localArrayList2.add(localRecommendFollowInfo);
      }
      j += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)localArrayList2.get(0);
      if (paramBoolean) {
        a("0X80094DC", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
      } else {
        a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
      }
    }
    paramList = new ComponentContentRecommendFollowGroup.2(this, paramList, paramBoolean);
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().c().batchFollow(localArrayList1, paramList, 2);
      return;
    }
    ReadInJoyLogicEngine.a().c().batchUnFollow(localArrayList1, paramList, 2);
  }
  
  protected void b()
  {
    Object localObject = this.e.mRecommendFollowInfos.f;
    Intent localIntent = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.e.mRecommendFollowInfos.c.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0, null);
  }
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().f(this.e);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */