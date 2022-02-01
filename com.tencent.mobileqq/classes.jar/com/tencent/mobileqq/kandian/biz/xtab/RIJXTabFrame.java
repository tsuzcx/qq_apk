package com.tencent.mobileqq.kandian.biz.xtab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.ktx.ViewModelLazy;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyViewLayer;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ktx.ViewModelDelegateKt.viewModels.1;
import com.tencent.mobileqq.kandian.biz.common.ktx.ViewModelDelegateKt.viewModels.factoryPromise.1;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewBridge;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJFloatViewManager;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame;", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase;", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "badgeChangerListener", "Lkotlin/Function0;", "", "channelBarMask", "Landroid/view/View;", "channelViewModel", "Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabChannelViewModel;", "getChannelViewModel", "()Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabChannelViewModel;", "channelViewModel$delegate", "Lkotlin/Lazy;", "entryViewController", "Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryViewController;", "entryViewId", "", "homepageModeGuide", "Lcom/tencent/mobileqq/kandian/biz/xtab/IKDXTabHomepageModeGuide;", "getHomepageModeGuide", "()Lcom/tencent/mobileqq/kandian/biz/xtab/IKDXTabHomepageModeGuide;", "homepageModeGuide$delegate", "homepageModeGuideViewModel", "Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuideViewModel;", "immersiveBar", "Lcom/tencent/widget/immersive/ImmersiveTitleBar2;", "isEnterFeedsStyleModePageFromGuide", "", "mObserver", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$mObserver$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$mObserver$1;", "nightView", "rootView", "ugcPublishUserGuideController", "Lcom/tencent/mobileqq/kandian/biz/xtab/UgcPublishUserGuideController;", "userHasSetFeedsStyle", "viewLayer", "Lcom/tencent/mobileqq/kandian/base/view/widget/ReadinjoyViewLayer;", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "violaEventReceiver", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$violaEventReceiver$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$violaEventReceiver$1;", "xTabTopBar", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "adjustStatusBarStyle", "userDark", "doOnTabChange", "visible", "fillData", "isSwitchAccount", "getCurrentChannelId", "", "getCurrentFragment", "Lcom/tencent/mobileqq/kandian/biz/common/fragment/ReadInJoyBaseFragment;", "getTabWidgetHeight", "getTitleView", "handleChannelBarMask", "isImmersive", "handleStatusBar", "handleUgcPublisherEntryView", "channelID", "initAndShowPublisherEntryView", "initBarMarginTop", "initNightView", "initTopBar", "initUI", "initViewPager", "needHideBadge", "onAccountChanged", "onChannelSwitched", "channelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "onEnterKDTab", "onExitKDTab", "onPostThemeChanged", "onRefreshDeliverBtn", "onResume", "tabChanged", "onTabClickSelf", "reportShowPublishEntryView", "switchToChannel", "switchToChannelByBadge", "switchToDefaultChannel", "ignoreChannelID", "updateNightStatus", "updatePublisherEntryViewState", "updateTabBlur", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame
  extends RIJTabFrameBase
{
  public static final RIJXTabFrame.Companion e = new RIJXTabFrame.Companion(null);
  private View f;
  private RIJXTabViewPagerController g;
  private ImmersiveTitleBar2 h;
  private View i;
  private View j;
  private ReadinjoyViewLayer k;
  private BizEntryViewController l;
  private String m;
  private RIJXTabBar n;
  private UgcPublishUserGuideController o;
  private final Lazy p = LazyKt.lazy((Function0)RIJXTabFrame.homepageModeGuide.2.INSTANCE);
  private final Lazy q;
  private KDXTabHomepageModeGuideViewModel r;
  private final RIJXTabFrame.mObserver.1 s;
  private final Function0<Unit> t;
  private boolean u;
  private boolean v;
  private final RIJXTabFrame.violaEventReceiver.1 w;
  
  public RIJXTabFrame(@NotNull FrameFragment paramFrameFragment)
  {
    super(paramFrameFragment);
    Function0 localFunction0 = (Function0)null;
    localFunction0 = (Function0)new ViewModelDelegateKt.viewModels.factoryPromise.1(this);
    this.q = ((Lazy)new ViewModelLazy(Reflection.getOrCreateKotlinClass(KDXTabChannelViewModel.class), (Function0)new ViewModelDelegateKt.viewModels.1(this), localFunction0));
    this.s = new RIJXTabFrame.mObserver.1(this, paramFrameFragment);
    this.t = ((Function0)new RIJXTabFrame.badgeChangerListener.1(this));
    this.w = new RIJXTabFrame.violaEventReceiver.1(this);
  }
  
  private final void A()
  {
    int i1 = B();
    Bundle localBundle = new Bundle();
    localBundle.putInt("entryStyle", 0);
    localBundle.putInt("bottomMargin", Q().getDimensionPixelOffset(2131299597) + i1);
    localBundle.putInt("rightMargin", Q().getDimensionPixelOffset(2131299599));
    localBundle.putInt("width", Q().getDimensionPixelOffset(2131299600));
    localBundle.putInt("height", Q().getDimensionPixelOffset(2131299598));
    BizEntryViewController localBizEntryViewController = this.l;
    if (localBizEntryViewController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
    }
    localBizEntryViewController.a(localBundle, null, (Function1)new RIJXTabFrame.initAndShowPublisherEntryView.1(this, i1));
  }
  
  private final int B()
  {
    View localView = P().findViewById(16908307);
    Intrinsics.checkExpressionValueIsNotNull(localView, "activity.findViewById<View>(android.R.id.tabs)");
    return localView.getHeight();
  }
  
  private final void C()
  {
    RIJEntryViewReport.a("0X800BBD1", 8);
    if (RIJEntryViewUtils.b() == 1)
    {
      RIJEntryViewReport.b("0X800BBD3", 2);
      return;
    }
    if (RIJEntryViewUtils.b() == 2) {
      RIJEntryViewReport.b("0X800BBCF", 2);
    }
  }
  
  private final void D()
  {
    View localView = d(2131444311);
    if (localView != null)
    {
      this.j = ((ViewStub)localView).inflate();
      I();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewStub");
  }
  
  private final void E()
  {
    Object localObject = d(2131447582);
    if (localObject != null)
    {
      this.h = ((ImmersiveTitleBar2)localObject);
      localObject = d(2131430497);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.channelBarMask)");
      this.i = ((View)localObject);
      localObject = d(2131430496);
      if (localObject != null)
      {
        this.n = ((RIJXTabBar)localObject);
        localObject = this.n;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
        }
        ((RIJXTabBar)localObject).setOnBtnClickListener((RIJXTabBar.OnBtnClickListener)new RIJXTabFrame.initTopBar.1(this));
        F();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.widget.immersive.ImmersiveTitleBar2");
  }
  
  private final void F()
  {
    int i1 = RIJXTabFrameUtils.INSTANCE.getChannelBarMarginTop();
    Object localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localObject = ((RIJXTabBar)localObject).getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void G()
  {
    Object localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    this.g = new RIJXTabViewPagerController(this, (RIJXTabBar)localObject);
    localObject = RIJChannelViewpagerEnterPathHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJChannelViewpagerEnter…per.getChannelEntryPath()");
    ((Map)localObject).put(Integer.valueOf(RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId()), Integer.valueOf(0));
    x().a().observe((LifecycleOwner)n(), (Observer)new RIJXTabFrame.initViewPager.1(this));
    x().b();
    localObject = this.r;
    if (localObject != null)
    {
      localObject = ((KDXTabHomepageModeGuideViewModel)localObject).a();
      if (localObject != null) {
        ((LiveData)localObject).observe((LifecycleOwner)n(), (Observer)new RIJXTabFrame.initViewPager.2(this));
      }
    }
    localObject = this.r;
    if (localObject != null)
    {
      localObject = ((KDXTabHomepageModeGuideViewModel)localObject).b();
      if (localObject != null) {
        ((LiveData)localObject).observe((LifecycleOwner)n(), (Observer)new RIJXTabFrame.initViewPager.3(this));
      }
    }
  }
  
  private final void H()
  {
    boolean bool;
    switch (g())
    {
    default: 
      bool = true;
      break;
    case 41725: 
    case 41726: 
      bool = false;
    }
    RIJAppSetting.b((Activity)P(), bool);
  }
  
  private final void I()
  {
    View localView = this.j;
    if (localView != null)
    {
      int i1;
      if (ThemeUtil.isInNightMode(this.aF)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
    }
  }
  
  private final void J()
  {
    L();
    H();
    x().c();
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    ((RIJXTabViewPagerController)localObject).b();
    localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    ((RIJXTabBar)localObject).d();
    M();
  }
  
  private final void K()
  {
    Object localObject1 = (Activity)P();
    Object localObject2 = (Frame)this;
    ImmersiveTitleBar2 localImmersiveTitleBar2 = this.h;
    if (localImmersiveTitleBar2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
    }
    RIJAppSetting.a((Activity)localObject1, (Frame)localObject2, false, localImmersiveTitleBar2, -1);
    localObject1 = (Activity)P();
    localObject2 = this.h;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
    }
    RIJAppSetting.a((Activity)localObject1, (ImmersiveTitleBar2)localObject2);
    RIJAppSetting.b((Activity)P(), true);
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    ((RIJXTabViewPagerController)localObject1).c();
    localObject1 = this.r;
    if (localObject1 != null) {
      ((KDXTabHomepageModeGuideViewModel)localObject1).e();
    }
  }
  
  private final void L()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).g();
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
  
  private final void M()
  {
    Object localObject = this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localObject != null)
    {
      localObject = (KandianMergeManager)localObject;
      if ((((KandianMergeManager)localObject).R() <= 0) && (!((KandianMergeManager)localObject).d()))
      {
        if (RIJXTabBadgeStore.a())
        {
          int i1 = RIJXTabBadgeStore.a.c();
          localObject = this.g;
          if (localObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
          }
          ((RIJXTabViewPagerController)localObject).a(i1);
        }
      }
      else
      {
        localObject = this.g;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
        }
        ((RIJXTabViewPagerController)localObject).d();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  private final void c(int paramInt)
  {
    Object localObject;
    BizEntryViewController localBizEntryViewController;
    if ((paramInt == 0) && (RIJEntryViewUtils.a()))
    {
      localObject = this.m;
      if (localObject != null)
      {
        localBizEntryViewController = this.l;
        if (localBizEntryViewController == null) {
          Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
        }
        IEntryViewController.DefaultImpls.a(localBizEntryViewController, (String)localObject, null, 2, null);
      }
      localObject = this.o;
      if (localObject != null) {
        UgcPublishUserGuideController.a((UgcPublishUserGuideController)localObject, null, 1, null);
      }
    }
    else
    {
      localObject = this.m;
      if (localObject != null)
      {
        localBizEntryViewController = this.l;
        if (localBizEntryViewController == null) {
          Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
        }
        IEntryViewController.DefaultImpls.b(localBizEntryViewController, (String)localObject, null, 2, null);
      }
      localObject = this.o;
      if (localObject != null) {
        ((UgcPublishUserGuideController)localObject).b();
      }
    }
  }
  
  private final void f(boolean paramBoolean)
  {
    View localView = this.i;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("channelBarMask");
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localView.setVisibility(i1);
    g(paramBoolean ^ true);
  }
  
  private final void g(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = P();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      if (!ImmersiveUtils.setStatusTextColor(paramBoolean, ((QBaseActivity)localObject1).getWindow()))
      {
        localObject1 = (Activity)P();
        localObject2 = (Frame)this;
        ImmersiveTitleBar2 localImmersiveTitleBar2 = this.h;
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
  
  private final IKDXTabHomepageModeGuide w()
  {
    return (IKDXTabHomepageModeGuide)this.p.getValue();
  }
  
  private final KDXTabChannelViewModel x()
  {
    return (KDXTabChannelViewModel)this.q.getValue();
  }
  
  private final void y()
  {
    E();
    G();
    D();
    Object localObject1 = P();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    Object localObject2 = new RIJEntryViewBridge((Context)localObject1, 8);
    ((RIJEntryViewBridge)localObject2).a((Function0)new RIJXTabFrame.initUI..inlined.apply.lambda.1(this));
    localObject1 = P();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    localObject1 = (Context)localObject1;
    localObject2 = (IEntryViewBridge)localObject2;
    ReadinjoyViewLayer localReadinjoyViewLayer = this.k;
    if (localReadinjoyViewLayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    this.l = new BizEntryViewController((Context)localObject1, (IEntryViewBridge)localObject2, (IFloatViewManager)new RIJFloatViewManager((ViewGroup)localReadinjoyViewLayer));
  }
  
  private final void z()
  {
    if (RIJEntryViewUtils.a())
    {
      A();
      return;
    }
    String str = this.m;
    if (str != null)
    {
      BizEntryViewController localBizEntryViewController = this.l;
      if (localBizEntryViewController == null) {
        Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
      }
      localBizEntryViewController.c(str, null);
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131626275, null);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…njoy_kandian_x_tab, null)");
    this.f = paramLayoutInflater;
    paramLayoutInflater = P();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "activity");
    this.k = new ReadinjoyViewLayer(paramLayoutInflater.getBaseContext());
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater.addView((View)localObject);
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131431265);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "viewLayer.findViewById(R.id.contactsRoot)");
    paramLayoutInflater = (ViewGroup)paramLayoutInflater;
    localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    ((ReadinjoyViewLayer)localObject).a((View)paramLayoutInflater);
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewLayer");
    }
    return (View)paramLayoutInflater;
  }
  
  protected void a()
  {
    super.a();
    this.r = new KDXTabHomepageModeGuideViewModel();
    y();
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.s);
    RIJXTabBadgeDispatcher.a.a(this.t);
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this.w);
  }
  
  public void a(int paramInt)
  {
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.g;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localRIJXTabViewPagerController.a(paramInt);
  }
  
  public final void a(@NotNull TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "channelCoverInfo");
    RIJKanDianTabReport.a(paramTabChannelCoverInfo);
    c(paramTabChannelCoverInfo.mChannelCoverId);
    f(paramTabChannelCoverInfo.isImmersive);
    H();
    KDXTabHomepageModeGuideViewModel localKDXTabHomepageModeGuideViewModel = this.r;
    if (localKDXTabHomepageModeGuideViewModel != null) {
      localKDXTabHomepageModeGuideViewModel.a(paramTabChannelCoverInfo.mChannelCoverId);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.u)
    {
      QLog.i("RIJXTabFrame", 1, "[onResume], userHasSetFeedsType, refresh feeds.");
      ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
      if (localReadInJoyBaseFragment != null) {
        localReadInJoyBaseFragment.a(2);
      }
      this.u = false;
      if (this.v)
      {
        QQToast.makeText((Context)P(), 2, (CharSequence)P().getString(2131915415), 0).show();
        this.v = false;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post((Runnable)RIJXTabFrame.fillData.1.a);
    RIJXTabViewPagerController localRIJXTabViewPagerController = this.g;
    if (localRIJXTabViewPagerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localRIJXTabViewPagerController.a();
  }
  
  public void c(boolean paramBoolean)
  {
    View localView = this.f;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    VideoReport.traversePage(localView);
    if (paramBoolean) {
      J();
    } else {
      K();
    }
    z();
  }
  
  public void cP_()
  {
    Activity localActivity = (Activity)P();
    Frame localFrame = (Frame)this;
    ImmersiveTitleBar2 localImmersiveTitleBar2 = this.h;
    if (localImmersiveTitleBar2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("immersiveBar");
    }
    RIJAppSetting.a(localActivity, localFrame, true, localImmersiveTitleBar2, -1);
    I();
  }
  
  protected void d()
  {
    super.d();
    Object localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    Object localObject2 = P();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
    ((RIJXTabViewPagerController)localObject1).a((Context)localObject2);
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.s);
    RIJXTabBadgeDispatcher.a.b(this.t);
    localObject1 = this.m;
    if (localObject1 != null)
    {
      localObject2 = this.l;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("entryViewController");
      }
      IEntryViewController.DefaultImpls.c((IEntryViewController)localObject2, (String)localObject1, null, 2, null);
    }
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this.w);
  }
  
  public void e()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.l();
    }
    try
    {
      RIJKanDianTabReport.a(t(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(t(), true);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabClickSelf error,msg=");
      localStringBuilder.append(localException);
      QLog.e("RIJXTabFrame", 1, localStringBuilder.toString());
    }
  }
  
  protected void f()
  {
    super.f();
    KDXTabHomepageModeGuideViewModel localKDXTabHomepageModeGuideViewModel = this.r;
    if (localKDXTabHomepageModeGuideViewModel != null) {
      localKDXTabHomepageModeGuideViewModel.c();
    }
  }
  
  public int g()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).g();
    if (localObject != null) {
      return ((TabChannelCoverInfo)localObject).mChannelCoverId;
    }
    return -1;
  }
  
  public boolean l()
  {
    return true;
  }
  
  public void m()
  {
    RIJXTabBar localRIJXTabBar = this.n;
    if (localRIJXTabBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("xTabTopBar");
    }
    localRIJXTabBar.c();
  }
  
  @Nullable
  public ReadInJoyBaseFragment p()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerController");
    }
    localObject = ((RIJXTabViewPagerController)localObject).e();
    if ((localObject instanceof ReadInJoyBaseFragment)) {
      return (ReadInJoyBaseFragment)localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame
 * JD-Core Version:    0.7.0.1
 */