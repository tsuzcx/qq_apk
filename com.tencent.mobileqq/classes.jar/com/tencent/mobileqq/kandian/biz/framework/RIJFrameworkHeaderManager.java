package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout;
import com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.HeaderViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.mobileqq.kandian.biz.tab.ChannelTopPositionView;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.anim.IAnimManager.PullRefreshComplete;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RIJFrameworkHeaderManager
{
  private ChannelCoverView a;
  private ChannelTopBanner b;
  private ChannelTopPositionView c;
  private ChannelTopPositionView d;
  private SlideActiveAnimController e;
  private List<HeaderViewController> f = new ArrayList();
  private IAnimManager.PullRefreshComplete g;
  
  private void a(View paramView, Context paramContext)
  {
    if ((paramContext instanceof ReadInJoyNewFeedsActivity))
    {
      ((ReadInJoyNewFeedsActivity)paramContext).a(paramView);
      return;
    }
    if (RIJShowKanDianTabSp.c()) {
      try
      {
        paramContext = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)paramContext).a(ReadinjoyTabFrame.class);
        if (paramContext != null)
        {
          paramContext.b(paramView);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramContext = new StringBuilder();
        paramContext.append("readinjoy tab add dispatch touch event view fail ! e : ");
        paramContext.append(paramView);
        QLog.d("RIJFrameworkReportManager", 2, paramContext.toString());
      }
    }
  }
  
  public ChannelCoverView a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    ChannelTopPositionView localChannelTopPositionView = this.d;
    if (localChannelTopPositionView != null) {
      localChannelTopPositionView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt1, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!ReadInJoyRefreshManager.j) && ((paramActivity instanceof SplashActivity))) {
      return;
    }
    if (paramReadInJoyXListView.c()) {
      return;
    }
    if (paramInt2 != 0)
    {
      paramReadInJoyXListView.b(0);
      return;
    }
    if (paramInt1 != -1)
    {
      if (paramInt1 == 0)
      {
        paramReadInJoyXListView.b(0);
        return;
      }
      if (!paramReadInJoyXListView.c())
      {
        paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.b(2);
        a(paramReadInJoyXListView);
        paramActivity.a(this.e);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!ReadInJoyRefreshManager.j) && ((paramActivity instanceof SplashActivity))) {
      return;
    }
    if (paramReadInJoyXListView.c()) {
      return;
    }
    if (paramInt2 != 0)
    {
      paramReadInJoyXListView.b(0);
      return;
    }
    if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        if (!paramReadInJoyXListView.c())
        {
          paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.b(2);
          a(paramReadInJoyXListView);
          paramActivity.a(this.e);
        }
      }
      else {
        paramReadInJoyXListView.b(0);
      }
    }
    else if (!paramReadInJoyXListView.c())
    {
      paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.b(2);
      a(paramReadInJoyXListView);
      paramActivity.a(this.e);
    }
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131427599);
    View localView = paramActivity.findViewById(2131447492);
    int j = AIOUtils.b(50.0F, paramActivity.getResources());
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
    }
    paramReadInJoyXListView.setPadding(0, i, 0, 0);
    paramReadInJoyXListView.initPaddingManual();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI 消息看点 mListView.setPadding heightDef=");
      localStringBuilder.append(i);
      QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
    }
    paramView = paramView.findViewById(2131433609);
    paramView.setPadding(0, i, 0, 0);
    this.e = new SlideActiveAnimController(paramInt, paramActivity, localReadInjoySlideAnimLayout, paramReadInJoyXListView, localView, null, new RIJFrameworkHeaderManager.1(this, localView, i, paramView, paramReadInJoyXListView));
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateListViewPadding,update2StudyMode=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" ,isOnCreate=");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("RIJFrameworkReportManager", 1, ((StringBuilder)localObject).toString());
    localObject = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131427598);
    View localView = paramActivity.findViewById(2131446342);
    paramView = paramView.findViewById(2131433609);
    int i;
    if (paramBoolean1) {
      i = 2131299574;
    } else {
      i = 2131299578;
    }
    int j = paramActivity.getResources().getDimensionPixelOffset(i);
    if (paramBoolean1) {
      i = ImmersiveUtils.getStatusBarHeight(paramActivity);
    } else {
      i = AIOUtils.b(50.0F, paramActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(paramActivity);
    }
    i += j;
    j = AIOUtils.b(50.0F, paramActivity.getResources());
    int k = ImmersiveUtils.getStatusBarHeight(paramActivity);
    int m = paramActivity.getResources().getDimensionPixelOffset(2131299578);
    paramView.setPadding(0, i, 0, 0);
    paramReadInJoyXListView.setPadding(0, i, 0, 0);
    paramReadInJoyXListView.initPaddingManual();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI 看点 mListView.setPadding :");
      localStringBuilder.append(i);
      QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
    }
    this.e = new SlideActiveAnimController(paramInt, paramActivity, (ReadInjoySlideAnimLayout)localObject, paramReadInJoyXListView, localView, paramActivity.findViewById(16908307), new RIJFrameworkHeaderManager.2(this, localView, i, j + k + m, paramView, paramReadInJoyXListView));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 41695)
    {
      if (this.d == null) {
        this.d = ((ChannelTopPositionView)paramView.findViewById(2131444339));
      }
      a(0);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null) {
      paramReadInJoyXListView.a(this.g);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext)
  {
    if (this.c == null)
    {
      this.c = new ChannelTopPositionView(paramContext);
      paramReadInJoyXListView.addHeaderView(this.c, 2);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!ReadInJoyHelper.w()) {
        this.f.add(new ReadInJoyFeedsHeaderViewController(paramContext));
      }
    }
    else if (paramInt == 56)
    {
      if (ReadInJoyHelper.O(ReadInJoyUtils.b()) != 2)
      {
        this.a = new ChannelCoverView(paramContext, paramInt, paramReadInJoyXListView);
        a(this.a.b(), paramContext);
      }
    }
    else if (paramInt == 70)
    {
      this.f.add(new ReadInJoyDiandianHeaderController(paramContext));
    }
    else if ((paramInt == 41523) && (ReadInJoyHelper.P(ReadInJoyUtils.b()) != 1))
    {
      this.a = new ChannelCoverView(paramContext, paramInt, paramReadInJoyXListView);
      this.a.b().setBackgroundColor(-1);
      a(this.a.b(), paramContext);
    }
    paramContext = this.f.iterator();
    while (paramContext.hasNext()) {
      ((HeaderViewController)paramContext.next()).a(paramReadInJoyXListView);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (paramTopBannerInfo != null)
    {
      if (paramTopBannerInfo.mChannelId != paramInt) {
        return;
      }
      if (paramInt == 41695) {
        return;
      }
      if (paramTopBannerInfo.isEmpty())
      {
        paramTopBannerInfo = this.b;
        if (paramTopBannerInfo != null) {
          paramReadInJoyXListView.removeHeaderView(paramTopBannerInfo);
        }
        this.b = null;
        return;
      }
      if (this.b == null)
      {
        this.b = new ChannelTopBanner(paramActivity);
        paramReadInJoyXListView.addHeaderView(this.b, 2);
      }
      this.b.a(paramReadInJoyBaseAdapter, paramTopBannerInfo);
    }
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete, ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null)
    {
      paramReadInJoyXListView.a(paramPullRefreshComplete);
      this.g = paramPullRefreshComplete;
    }
  }
  
  public List<HeaderViewController> b()
  {
    return this.f;
  }
  
  public void c()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      HeaderViewController localHeaderViewController = (HeaderViewController)localIterator.next();
      if ((localHeaderViewController instanceof ReadInJoyDiandianHeaderController)) {
        localHeaderViewController.e();
      }
    }
  }
  
  public void d()
  {
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).c();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ChannelTopBanner)localObject).c();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).e();
    }
  }
  
  public void e()
  {
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ChannelTopBanner)localObject).d();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).f();
    }
  }
  
  public void f()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((ChannelCoverView)localObject).a();
      this.a = null;
    }
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).b();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).g();
    }
  }
  
  public void g()
  {
    SlideActiveAnimController localSlideActiveAnimController = this.e;
    if (localSlideActiveAnimController != null) {
      localSlideActiveAnimController.i();
    }
  }
  
  public boolean h()
  {
    SlideActiveAnimController localSlideActiveAnimController = this.e;
    return (localSlideActiveAnimController != null) && (localSlideActiveAnimController.l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager
 * JD-Core Version:    0.7.0.1
 */