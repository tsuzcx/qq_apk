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
  private ChannelTopBanner jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
  private ChannelCoverView jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView;
  private SlideActiveAnimController jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentMobileqqKandianBizTabChannelTopPositionView;
  private IAnimManager.PullRefreshComplete jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$PullRefreshComplete;
  private List<HeaderViewController> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ChannelTopPositionView b;
  
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
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView;
  }
  
  public List<HeaderViewController> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      HeaderViewController localHeaderViewController = (HeaderViewController)localIterator.next();
      if ((localHeaderViewController instanceof ReadInJoyDiandianHeaderController)) {
        localHeaderViewController.e();
      }
    }
  }
  
  public void a(int paramInt)
  {
    ChannelTopPositionView localChannelTopPositionView = this.b;
    if (localChannelTopPositionView != null) {
      localChannelTopPositionView.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt1, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!ReadInJoyRefreshManager.b) && ((paramActivity instanceof SplashActivity))) {
      return;
    }
    if (paramReadInJoyXListView.a()) {
      return;
    }
    if (paramInt2 != 0)
    {
      paramReadInJoyXListView.a(0);
      return;
    }
    if (paramInt1 != -1)
    {
      if (paramInt1 == 0)
      {
        paramReadInJoyXListView.a(0);
        return;
      }
      if (!paramReadInJoyXListView.a())
      {
        paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.a(2);
        a(paramReadInJoyXListView);
        paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!ReadInJoyRefreshManager.b) && ((paramActivity instanceof SplashActivity))) {
      return;
    }
    if (paramReadInJoyXListView.a()) {
      return;
    }
    if (paramInt2 != 0)
    {
      paramReadInJoyXListView.a(0);
      return;
    }
    if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        if (!paramReadInJoyXListView.a())
        {
          paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.a(2);
          a(paramReadInJoyXListView);
          paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController);
        }
      }
      else {
        paramReadInJoyXListView.a(0);
      }
    }
    else if (!paramReadInJoyXListView.a())
    {
      paramActivity = (ReadInJoyAnimBaseManager)paramReadInJoyXListView.a(2);
      a(paramReadInJoyXListView);
      paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController);
    }
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131362021);
    View localView = paramActivity.findViewById(2131378810);
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
    paramView = paramView.findViewById(2131367155);
    paramView.setPadding(0, i, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController = new SlideActiveAnimController(paramInt, paramActivity, localReadInjoySlideAnimLayout, paramReadInJoyXListView, localView, null, new RIJFrameworkHeaderManager.1(this, localView, i, paramView, paramReadInJoyXListView));
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateListViewPadding,update2StudyMode=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" ,isOnCreate=");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.d("RIJFrameworkReportManager", 1, ((StringBuilder)localObject).toString());
    localObject = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131362020);
    View localView = paramActivity.findViewById(2131377865);
    paramView = paramView.findViewById(2131367155);
    int i;
    if (paramBoolean1) {
      i = 2131298857;
    } else {
      i = 2131298861;
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
    int m = paramActivity.getResources().getDimensionPixelOffset(2131298861);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController = new SlideActiveAnimController(paramInt, paramActivity, (ReadInjoySlideAnimLayout)localObject, paramReadInJoyXListView, localView, paramActivity.findViewById(16908307), new RIJFrameworkHeaderManager.2(this, localView, i, j + k + m, paramView, paramReadInJoyXListView));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 41695)
    {
      if (this.b == null) {
        this.b = ((ChannelTopPositionView)paramView.findViewById(2131376136));
      }
      a(0);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null) {
      paramReadInJoyXListView.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$PullRefreshComplete);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabChannelTopPositionView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabChannelTopPositionView = new ChannelTopPositionView(paramContext);
      paramReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabChannelTopPositionView, 2);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!ReadInJoyHelper.m()) {
        this.jdField_a_of_type_JavaUtilList.add(new ReadInJoyFeedsHeaderViewController(paramContext));
      }
    }
    else if (paramInt == 56)
    {
      if (ReadInJoyHelper.q(ReadInJoyUtils.a()) != 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView = new ChannelCoverView(paramContext, paramInt, paramReadInJoyXListView);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView.a(), paramContext);
      }
    }
    else if (paramInt == 70)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(paramContext));
    }
    else if ((paramInt == 41523) && (ReadInJoyHelper.r(ReadInJoyUtils.a()) != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView = new ChannelCoverView(paramContext, paramInt, paramReadInJoyXListView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView.a().setBackgroundColor(-1);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView.a(), paramContext);
    }
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
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
        paramTopBannerInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
        if (paramTopBannerInfo != null) {
          paramReadInJoyXListView.removeHeaderView(paramTopBannerInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner = new ChannelTopBanner(paramActivity);
        paramReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner, 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner.a(paramReadInJoyBaseAdapter, paramTopBannerInfo);
    }
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete, ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null)
    {
      paramReadInJoyXListView.a(paramPullRefreshComplete);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$PullRefreshComplete = paramPullRefreshComplete;
    }
  }
  
  public boolean a()
  {
    SlideActiveAnimController localSlideActiveAnimController = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
    return (localSlideActiveAnimController != null) && (localSlideActiveAnimController.c());
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
    if (localObject != null) {
      ((ChannelTopBanner)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).d();
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner;
    if (localObject != null) {
      ((ChannelTopBanner)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).e();
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView;
    if (localObject != null)
    {
      ((ChannelCoverView)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverView = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HeaderViewController)((Iterator)localObject).next()).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
    if (localObject != null) {
      ((SlideActiveAnimController)localObject).f();
    }
  }
  
  public void e()
  {
    SlideActiveAnimController localSlideActiveAnimController = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
    if (localSlideActiveAnimController != null) {
      localSlideActiveAnimController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager
 * JD-Core Version:    0.7.0.1
 */