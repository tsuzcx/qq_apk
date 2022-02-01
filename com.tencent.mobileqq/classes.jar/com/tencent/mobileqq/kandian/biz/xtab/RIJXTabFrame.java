package com.tencent.mobileqq.kandian.biz.xtab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyViewLayer;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewBridge;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJFloatViewManager;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.controller.IEntryViewController;
import com.tencent.tkd.topicsdk.entry.controller.IEntryViewController.DefaultImpls;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame;", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase;", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "badgeChangerListener", "Lkotlin/Function0;", "", "channelBarMask", "Landroid/view/View;", "getChannelBarMask", "()Landroid/view/View;", "setChannelBarMask", "(Landroid/view/View;)V", "channelViewPager", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "getChannelViewPager", "()Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "setChannelViewPager", "(Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;)V", "entryViewController", "Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryViewController;", "entryViewId", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "getFrameFragment", "()Lcom/tencent/mobileqq/app/FrameFragment;", "setFrameFragment", "immersiveBar", "Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "getImmersiveBar", "()Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "setImmersiveBar", "(Lcom/tencent/widget/immersive/ImmersiveTitleBar2;)V", "mObserver", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$mObserver$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$mObserver$1;", "nightView", "getNightView", "setNightView", "pagerAdapter", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "getPagerAdapter", "()Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "setPagerAdapter", "(Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;)V", "rootView", "getRootView", "setRootView", "topBarMask", "Lcom/tencent/image/URLImageView;", "getTopBarMask", "()Lcom/tencent/image/URLImageView;", "setTopBarMask", "(Lcom/tencent/image/URLImageView;)V", "viewLayer", "Lcom/tencent/mobileqq/kandian/base/view/widget/ReadinjoyViewLayer;", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "getViewPagerController", "()Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "setViewPagerController", "(Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;)V", "xTabTopBar", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "adjustStatusBarStyle", "userDark", "", "doOnTabChange", "visible", "fillData", "isSwitchAccount", "getCurrentChannelId", "", "getCurrentFragment", "Lcom/tencent/mobileqq/kandian/biz/common/fragment/ReadInJoyBaseFragment;", "getTitleView", "handleChannelBarMask", "isImmersive", "handlePageSelected", "channelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "handleRedPoint", "handleStatusBar", "initBarMarginTop", "initNightView", "initPublisherEntryView", "activity", "Landroidx/fragment/app/FragmentActivity;", "initTopBar", "initUI", "initViewPager", "initViewPagerListener", "needHideRedPoint", "needHideTabBlur", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "onPostThemeChanged", "onRefreshDeliverBtn", "onTabClickSelf", "setTopBitmap", "bitmap", "Landroid/graphics/Bitmap;", "switchToChannel", "channelID", "switchToDefaultChannel", "ignoreChannelID", "switchToMainFragmentForLongTime", "updateNightStatus", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame
  extends RIJTabFrameBase
{
  @NotNull
  public View a;
  @NotNull
  public FragmentManager a;
  @NotNull
  public URLImageView a;
  @Nullable
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
  @NotNull
  public ReadInJoyChannelViewPager.CustomFragmentPagerAdapter a;
  @NotNull
  public ReadInJoyChannelViewPager a;
  private RIJXTabBar jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
  private final RIJXTabFrame.mObserver.1 jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabFrame$mObserver$1;
  @NotNull
  public RIJXTabViewPagerController a;
  private BizEntryViewController jdField_a_of_type_ComTencentTkdTopicsdkAdapterEntryviewBizEntryViewController;
  @NotNull
  public ImmersiveTitleBar2 a;
  private String jdField_a_of_type_JavaLangString;
  private final Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private View jdField_b_of_type_AndroidViewView;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  @Nullable
  private View c;
  
  public RIJXTabFrame(@Nullable FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
    this.jdField_b_of_type_JavaLangString = "RIJXTabFrame";
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabFrame$mObserver$1 = new RIJXTabFrame.mObserver.1(this);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = ((Function0)new RIJXTabFrame.badgeChangerListener.1(this));
  }
  
  private final void a(Bitmap paramBitmap)
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
    }
    if (localURLImageView == null) {
      return;
    }
    if (paramBitmap != null)
    {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localURLImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
      }
      localURLImageView.setVisibility(0);
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localURLImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
      }
      localURLImageView.setImageBitmap(paramBitmap);
      int i = ViewUtils.a(44.0F);
      paramBitmap = a();
      Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "activity");
      i += ImmersiveUtils.getStatusBarHeight(paramBitmap.getBaseContext());
      paramBitmap = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramBitmap == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
      }
      paramBitmap = paramBitmap.getLayoutParams();
      if (paramBitmap.height != i)
      {
        paramBitmap.height = i;
        localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
        if (localURLImageView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
        }
        localURLImageView.setLayoutParams(paramBitmap);
      }
    }
    else
    {
      paramBitmap = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramBitmap == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topBarMask");
      }
      paramBitmap.setVisibility(8);
    }
  }
  
  private final void a(FragmentActivity paramFragmentActivity)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("entryStyle", 0);
    ((Bundle)localObject).putInt("bottomMargin", a().getDimensionPixelOffset(2131298880));
    ((Bundle)localObject).putInt("rightMargin", a().getDimensionPixelOffset(2131298881));
    paramFragmentActivity = (Context)paramFragmentActivity;
    IEntryViewBridge localIEntryViewBridge = (IEntryViewBridge)new RIJEntryViewBridge(paramFragmentActivity);
    ReadinjoyViewLayer localReadinjoyViewLayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (localReadinjoyViewLayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterEntryviewBizEntryViewController = new BizEntryViewController(paramFragmentActivity, localIEntryViewBridge, (IFloatViewManager)new RIJFloatViewManager((ViewGroup)localReadinjoyViewLayer));
    if (RIJEntryViewUtils.a.a())
    {
      paramFragmentActivity = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterEntryviewBizEntryViewController;
      if (paramFragmentActivity == null) {
        Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
      }
      paramFragmentActivity.a((Bundle)localObject, null, (Function1)new RIJXTabFrame.initPublisherEntryView.1(this));
      RIJEntryViewReport.a("0X800BBD1");
      if (RIJEntryViewUtils.a.a() == 1)
      {
        RIJEntryViewReport.a("0X800BBD3", 2);
        return;
      }
      if (RIJEntryViewUtils.a.a() == 2) {
        RIJEntryViewReport.a("0X800BBCF", 2);
      }
    }
    else
    {
      paramFragmentActivity = this.jdField_a_of_type_JavaLangString;
      if (paramFragmentActivity != null)
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterEntryviewBizEntryViewController;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
        }
        IEntryViewController.DefaultImpls.b((IEntryViewController)localObject, paramFragmentActivity, null, 2, null);
      }
    }
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo != null) {
      f(paramTabChannelCoverInfo.isImmersive);
    }
    if (d())
    {
      RIJAppSetting.b((Activity)a(), false);
      return;
    }
    RIJAppSetting.b((Activity)a(), true);
  }
  
  private final boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    int i;
    if (localObject != null) {
      i = ((TabChannelCoverInfo)localObject).mChannelCoverId;
    } else {
      i = 0;
    }
    switch (i)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void f(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channelBarMask");
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localView.setVisibility(i);
    g(paramBoolean ^ true);
  }
  
  private final void g(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      if (!ImmersiveUtils.setStatusTextColor(paramBoolean, ((QBaseActivity)localObject1).getWindow()))
      {
        localObject1 = (Activity)a();
        localObject2 = (Frame)this;
        ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
        if (localImmersiveTitleBar2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
        }
        RIJAppSetting.a((Activity)localObject1, (Frame)localObject2, true, localImmersiveTitleBar2, -1);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adjustStatusBarStyle exception,msg");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private final void m()
  {
    o();
    r();
    Object localObject = a(2131378881);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localObject);
      localObject = a(2131364460);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.channelBarMask)");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localObject = a(2131378988);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
        n();
        localObject = a();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
        a((FragmentActivity)localObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.image.URLImageView");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.widget.immersive.ImmersiveTitleBar2");
  }
  
  private final void n()
  {
    View localView = a(2131376108);
    if (localView != null)
    {
      this.c = ((ViewStub)localView).inflate();
      t();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewStub");
  }
  
  private final void o()
  {
    Object localObject = a(2131364459);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar = ((RIJXTabBar)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
      }
      ((RIJXTabBar)localObject).setOnBtnClickListener((RIJXTabBar.OnBtnClickListener)new RIJXTabFrame.initTopBar.1(this));
      p();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar");
  }
  
  private final void p()
  {
    int i = RIJXTabFrameUtils.INSTANCE.getChannelBarMarginTop();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localObject = ((RIJXTabBar)localObject).getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void r()
  {
    Object localObject1 = a();
    Object localObject2 = a(2131376066);
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)localObject2);
      if ((localObject1 instanceof SplashActivity))
      {
        localObject1 = ((SplashActivity)localObject1).getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.supportFragmentManager");
        this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = ((FragmentManager)localObject1);
      }
      else if ((localObject1 instanceof BaseActivity))
      {
        localObject1 = ((BaseActivity)localObject1).getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.supportFragmentManager");
        this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = ((FragmentManager)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter((FragmentManager)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
      }
      ((ReadInJoyChannelViewPager)localObject1).setAdapter((PagerAdapter)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
      }
      RIJXTabBar localRIJXTabBar = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
      if (localRIJXTabBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController = new RIJXTabViewPagerController((ReadInJoyChannelViewPager)localObject1, (ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)localObject2, localRIJXTabBar);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).b();
      localObject1 = RIJChannelViewpagerEnterPathHelper.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "RIJChannelViewpagerEnter…per.getChannelEntryPath()");
      ((Map)localObject1).put(Integer.valueOf(((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).getDefaultEnterTabId()), Integer.valueOf(0));
      s();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager");
  }
  
  private final void s()
  {
    ReadInJoyChannelViewPager localReadInJoyChannelViewPager = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
    if (localReadInJoyChannelViewPager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channelViewPager");
    }
    localReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)new RIJXTabFrame.initViewPagerListener.1(this));
  }
  
  private final void t()
  {
    View localView = this.c;
    if (localView != null)
    {
      int i;
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  private final void u() {}
  
  private final void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((TabChannelCoverInfo)localObject).isImmersive;
    } else {
      bool1 = false;
    }
    if (!bool1) {
      bool2 = true;
    }
    g(bool2);
  }
  
  private final void w()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localObject != null)
    {
      localObject = (KandianMergeManager)localObject;
      if ((((KandianMergeManager)localObject).e() <= 0) && (!((KandianMergeManager)localObject).b()))
      {
        if (RIJXTabBadgeStore.a())
        {
          int i = RIJXTabBadgeStore.a.a();
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
          }
          ((RIJXTabViewPagerController)localObject).a(i);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
        }
        ((RIJXTabViewPagerController)localObject).d();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if (localObject != null) {
      return ((TabChannelCoverInfo)localObject).mChannelCoverId;
    }
    return -1;
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560228, null);
    paramLayoutInflater = a();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "activity");
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer = new ReadinjoyViewLayer(paramLayoutInflater.getBaseContext());
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    paramLayoutInflater.addView(this.jdField_b_of_type_AndroidViewView);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131365118);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "viewLayer.findViewById(R.id.contactsRoot)");
    paramLayoutInflater = (ViewGroup)paramLayoutInflater;
    ReadinjoyViewLayer localReadinjoyViewLayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (localReadinjoyViewLayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    localReadinjoyViewLayer.a((View)paramLayoutInflater);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    return (View)paramLayoutInflater;
  }
  
  @Nullable
  public ReadInJoyBaseFragment a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).a();
    if ((localObject instanceof ReadInJoyBaseFragment)) {
      return (ReadInJoyBaseFragment)localObject;
    }
    return null;
  }
  
  @NotNull
  public final RIJXTabViewPagerController a()
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    return localRIJXTabViewPagerController;
  }
  
  protected void a()
  {
    super.a();
    m();
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabFrame$mObserver$1);
    RIJXTabBadgeDispatcher.a.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction0);
  }
  
  public void a(int paramInt)
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localRIJXTabViewPagerController.a(paramInt);
  }
  
  public void at_()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    try
    {
      RIJKanDianTabReport.a(a(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(a(), true);
      return;
    }
    catch (Exception localException)
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabClickSelf error,msg=");
      localStringBuilder.append(localException);
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  public void au_()
  {
    Activity localActivity = (Activity)a();
    Frame localFrame = (Frame)this;
    ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
    if (localImmersiveTitleBar2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
    }
    RIJAppSetting.a(localActivity, localFrame, true, localImmersiveTitleBar2, -1);
    t();
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    VideoReport.traversePage(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean)
    {
      v();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
      }
      ((RIJXTabViewPagerController)localObject1).b();
      w();
      u();
      if (d()) {
        RIJAppSetting.b((Activity)a(), false);
      }
    }
    else
    {
      localObject1 = (Activity)a();
      Object localObject2 = (Frame)this;
      ImmersiveTitleBar2 localImmersiveTitleBar2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
      if (localImmersiveTitleBar2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
      }
      RIJAppSetting.a((Activity)localObject1, (Frame)localObject2, false, localImmersiveTitleBar2, -1);
      localObject1 = (Activity)a();
      localObject2 = this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
      }
      RIJAppSetting.a((Activity)localObject1, (ImmersiveTitleBar2)localObject2);
      RIJAppSetting.b((Activity)a(), true);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    ((RIJXTabBar)localObject1).b(paramBoolean);
  }
  
  protected void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    Object localObject2 = a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
    ((RIJXTabViewPagerController)localObject1).a((Context)localObject2);
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabFrame$mObserver$1);
    RIJXTabBadgeDispatcher.a.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction0);
    localObject1 = this.jdField_a_of_type_JavaLangString;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterEntryviewBizEntryViewController;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
      }
      IEntryViewController.DefaultImpls.c((IEntryViewController)localObject2, (String)localObject1, null, 2, null);
    }
  }
  
  public void i()
  {
    RIJXTabBar localRIJXTabBar = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
    if (localRIJXTabBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localRIJXTabBar.a();
  }
  
  public boolean m_()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame
 * JD-Core Version:    0.7.0.1
 */