package com.tencent.mobileqq.kandian.biz.xtab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.view.widget.RIJBlackWhiteModeLinearLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay.IDisplayListener;
import com.tencent.mobileqq.kandian.biz.xtab.badge.EmptyBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.IRIJXTabBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.NumBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "Lcom/tencent/mobileqq/kandian/base/view/widget/RIJBlackWhiteModeLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "deliverBtn", "Landroid/widget/ImageView;", "<set-?>", "", "isDynamicIcon", "()Z", "moreChannelBtn", "moreChannelBtnBadge", "getMoreChannelBtnBadge", "()Landroid/widget/ImageView;", "setMoreChannelBtnBadge", "(Landroid/widget/ImageView;)V", "onBtnClickListener", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$OnBtnClickListener;", "onPageChangeListener", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$onPageChangeListener$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$onPageChangeListener$1;", "searchBtn", "selfBtn", "selfBtnNotifyIcon", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "getSelfBtnNotifyIcon", "()Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "setSelfBtnNotifyIcon", "(Lcom/tencent/mobileqq/tianshu/ui/RedTouch;)V", "tabLayout", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout;", "topicBtn", "topicBtnDrawable", "buildRedTouch", "configDtReportParam", "", "createRedPointDisplay", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJXTabBadgeDisplay;", "display", "Ljava/lang/Class;", "redPointContainer", "Landroid/widget/RelativeLayout;", "doOnTabChange", "visible", "getRedPointDisplay", "badgeInfo", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "needShowGuideBadge", "getTabLayout", "handleRedPointDisplay", "titleView", "Landroid/widget/TextView;", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "handleTitleView", "init", "refreshDeliverBtnVisibility", "refreshMoreChannelBtnBadgeVisibility", "refreshTopicBtnVisibility", "setOnBtnClickListener", "listener", "setTopicIcon", "immersive", "setTopicIconHasClicked", "setXTabRedPointHandler", "showRedPoint", "badgeDisplay", "switchImmersiveMode", "selectedIndex", "updateUI", "viewPager", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "itemList", "", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "Companion", "OnBtnClickListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBar
  extends RIJBlackWhiteModeLinearLayout
{
  public static final RIJXTabBar.Companion a;
  private int jdField_a_of_type_Int = 2130849849;
  @NotNull
  public ImageView a;
  private RIJXTabBar.OnBtnClickListener jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$OnBtnClickListener;
  private final RIJXTabBar.onPageChangeListener.1 jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$onPageChangeListener$1 = new RIJXTabBar.onPageChangeListener.1(this);
  private RIJXTabLayout jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
  @NotNull
  public RedTouch a;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$Companion = new RIJXTabBar.Companion(null);
  }
  
  public RIJXTabBar(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RIJXTabBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RIJXTabBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final IRIJXTabBadgeDisplay<?> a(Class<? extends IRIJXTabBadgeDisplay<?>> paramClass, RelativeLayout paramRelativeLayout)
  {
    if (Intrinsics.areEqual(paramClass, AvatarBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new AvatarBadgeDisplay(paramRelativeLayout);
    }
    if (Intrinsics.areEqual(paramClass, NumBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new NumBadgeDisplay(paramRelativeLayout);
    }
    if (Intrinsics.areEqual(paramClass, EmptyBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new EmptyBadgeDisplay(paramRelativeLayout);
    }
    return null;
  }
  
  private final Class<? extends IRIJXTabBadgeDisplay<?>> a(RIJXTabRedDotInfo paramRIJXTabRedDotInfo, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramRIJXTabRedDotInfo == null)
    {
      paramRIJXTabRedDotInfo = localObject;
      if (paramBoolean) {
        paramRIJXTabRedDotInfo = EmptyBadgeDisplay.class;
      }
      return paramRIJXTabRedDotInfo;
    }
    if (!paramRIJXTabRedDotInfo.isBig()) {
      return EmptyBadgeDisplay.class;
    }
    int i = RIJXTabBadgeShowLevel.a();
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return NumBadgeDisplay.class;
    }
    return AvatarBadgeDisplay.class;
  }
  
  private final void a(RelativeLayout paramRelativeLayout, TextView paramTextView, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = RIJXTabBadgeStore.a(paramTabChannelCoverInfo.mChannelCoverId);
    boolean bool;
    if ((paramTabChannelCoverInfo.needBadgeGuide) && (RIJXTabBadgeStore.a.a(paramTabChannelCoverInfo.mChannelCoverId))) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2 = paramRelativeLayout.getTag();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof IRIJXTabBadgeDisplay)) {
      localObject1 = null;
    }
    localObject2 = (IRIJXTabBadgeDisplay)localObject1;
    Class localClass = a(localRIJXTabRedDotInfo, bool);
    if (localClass == null)
    {
      if (localObject2 != null) {
        ((IRIJXTabBadgeDisplay)localObject2).c(true);
      }
      paramRelativeLayout.setTag(null);
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!(true ^ Intrinsics.areEqual(localObject2.getClass(), localClass))) {}
    }
    else
    {
      if (localObject2 != null) {
        ((IRIJXTabBadgeDisplay)localObject2).c(false);
      }
      localObject2 = a(localClass, paramRelativeLayout);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        paramRelativeLayout.setTag(localObject2);
        a((IRIJXTabBadgeDisplay)localObject2, paramTextView);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      a(localObject1, localRIJXTabRedDotInfo);
      if (localRIJXTabRedDotInfo != null)
      {
        RIJXTabBadgeReporter.a(localRIJXTabRedDotInfo);
        return;
      }
      if (bool) {
        RIJXTabBadgeReporter.a(paramTabChannelCoverInfo.mChannelCoverId);
      }
    }
  }
  
  private final void a(IRIJXTabBadgeDisplay<?> paramIRIJXTabBadgeDisplay, TextView paramTextView)
  {
    if ((paramIRIJXTabBadgeDisplay instanceof AvatarBadgeDisplay)) {
      ((AvatarBadgeDisplay)paramIRIJXTabBadgeDisplay).a((AvatarBadgeDisplay.IDisplayListener)new RIJXTabBar.handleTitleView.1(paramTextView));
    }
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementId(localObject, "head_sculpture_button");
    localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").c("click_head_sculpture"), null, 1, null).a());
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementId(localObject, "search_box_button");
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("search_box").c("click_search_box"), null, 1, null).a());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementId(localObject, "more_channel_button");
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("channel_bar").c("click_more_channel"), null, 1, null).a());
  }
  
  private final void c()
  {
    RIJXTabLayout localRIJXTabLayout = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localRIJXTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    localRIJXTabLayout.setRedPointHandler((Function2)new RIJXTabBar.setXTabRedPointHandler.1(this));
  }
  
  private final void c(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130849849;
    } else {
      i = 2130849848;
    }
    this.jdField_a_of_type_Int = i;
    Object localObject1 = Aladdin.getConfig(440);
    if (localObject1 != null) {
      localObject1 = ((AladdinConfig)localObject1).getString("button_image_url", "");
    } else {
      localObject1 = null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[switchImmersiveMode] topicIcon = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("RIJXTabBar", 1, ((StringBuilder)localObject2).toString());
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!ReadInJoyHelper.c()))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
      ImageView localImageView = this.f;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(URLDecoder.decode((String)localObject1, "UTF-8"), (URLDrawable.URLDrawableOptions)localObject2));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    ((ImageView)localObject1).setImageResource(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private final void d()
  {
    Object localObject = Aladdin.getConfig(440);
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("fourTab_button_hashTag", 0);
    } else {
      i = 0;
    }
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[refreshTopicBtnVisibility] showTopic = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("RIJXTabBar", 1, ((StringBuilder)localObject).toString());
    if (bool)
    {
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnBadge");
      }
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setVisibility(0);
  }
  
  @NotNull
  public final RIJXTabLayout a()
  {
    RIJXTabLayout localRIJXTabLayout = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localRIJXTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    return localRIJXTabLayout;
  }
  
  @NotNull
  public final RedTouch a()
  {
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localRedTouch == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    return localRedTouch;
  }
  
  public final void a()
  {
    boolean bool = RIJUgcUtils.m();
    Object localObject;
    if (bool)
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      ((ImageView)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      ((ImageView)localObject).setVisibility(4);
    }
    if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[refreshDeliverButton] needShow = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("RIJXTabBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    LayoutInflater.from(paramContext).inflate(2131562716, (ViewGroup)this, true);
    paramContext = findViewById(2131376115);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_self_btn)");
    this.c = ((ImageView)paramContext);
    paramContext = findViewById(2131376126);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_tab_layout)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout = ((RIJXTabLayout)paramContext);
    paramContext = findViewById(2131376098);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_btn)");
    this.e = ((ImageView)paramContext);
    paramContext = findViewById(2131376047);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_deliver_btn)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(2131376114);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_search_btn)");
    this.b = ((ImageView)paramContext);
    paramContext = findViewById(2131376137);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_topic_btn)");
    this.f = ((ImageView)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = b();
    paramContext = findViewById(2131376099);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_red_dot)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.1(this));
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.2(this));
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.3(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.4(this));
    paramContext = this.f;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.5(this));
    a();
    d();
    b();
    c();
  }
  
  public final void a(@NotNull ReadInJoyChannelViewPager paramReadInJoyChannelViewPager, @NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyChannelViewPager, "viewPager");
    Intrinsics.checkParameterIsNotNull(paramList, "itemList");
    Intrinsics.checkParameterIsNotNull(paramRIJXTabViewPagerController, "viewPagerController");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramReadInJoyChannelViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)localObject);
    removeAllViews();
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    paramReadInJoyChannelViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$onPageChangeListener$1);
    paramReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$onPageChangeListener$1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    paramReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RIJXTabLayout)localObject).a(localContext, paramList, paramRIJXTabViewPagerController);
    paramReadInJoyChannelViewPager.post((Runnable)new RIJXTabBar.updateUI.1(this, paramReadInJoyChannelViewPager));
  }
  
  @VisibleForTesting
  public final void a(@NotNull IRIJXTabBadgeDisplay<?> paramIRIJXTabBadgeDisplay, @Nullable RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIRIJXTabBadgeDisplay, "badgeDisplay");
    if ((paramIRIJXTabBadgeDisplay instanceof AvatarBadgeDisplay))
    {
      paramIRIJXTabBadgeDisplay = (AvatarBadgeDisplay)paramIRIJXTabBadgeDisplay;
      long l;
      if (paramRIJXTabRedDotInfo != null) {
        l = paramRIJXTabRedDotInfo.getUin();
      } else {
        l = 0L;
      }
      paramIRIJXTabBadgeDisplay.a(l, true);
      return;
    }
    if ((paramIRIJXTabBadgeDisplay instanceof NumBadgeDisplay))
    {
      ((NumBadgeDisplay)paramIRIJXTabBadgeDisplay).a(1L, true);
      return;
    }
    if ((paramIRIJXTabBadgeDisplay instanceof EmptyBadgeDisplay)) {
      ((EmptyBadgeDisplay)paramIRIJXTabBadgeDisplay).a(new Object(), false);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    ImageView localImageView = this.e;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    if (localImageView.getVisibility() != 0)
    {
      QLog.i("RIJXTabBar", 1, "[refreshMoreChannelBtnBadgeVisibility] moreChannelBtn is not visible.");
      return;
    }
    localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnBadge");
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  @VisibleForTesting
  public final void a(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 2130849847;
    } else {
      i = 2130849846;
    }
    int j;
    if (paramBoolean) {
      j = 2130849839;
    } else {
      j = 2130849838;
    }
    int k;
    if (paramBoolean) {
      k = 2130849843;
    } else {
      k = 2130849842;
    }
    int m;
    if (paramBoolean) {
      m = 2130849845;
    } else {
      m = 2130849844;
    }
    c(paramBoolean);
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
    }
    ((ImageView)localObject).setImageResource(i);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    ((ImageView)localObject).setImageResource(j);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setImageResource(k);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    ((ImageView)localObject).setImageResource(m);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    ((RIJXTabLayout)localObject).a(paramBoolean, paramInt);
    float f1;
    if (paramBoolean) {
      f1 = 0.8F;
    } else {
      f1 = 1.0F;
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @VisibleForTesting
  @NotNull
  public final RedTouch b()
  {
    RedTouch localRedTouch = new RedTouch(getContext(), findViewById(2131376116)).b(8388661).a();
    Intrinsics.checkExpressionValueIsNotNull(localRedTouch, "RedTouch(this.context, t…               .applyTo()");
    return localRedTouch;
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ImageView localImageView = this.f;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
      }
      if (localImageView.getVisibility() == 0) {
        RIJXTabReport.a(this.jdField_a_of_type_Boolean, "0X800BA07");
      }
    }
  }
  
  public final void setMoreChannelBtnBadge(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public final void setOnBtnClickListener(@NotNull RIJXTabBar.OnBtnClickListener paramOnBtnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnBtnClickListener, "listener");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar$OnBtnClickListener = paramOnBtnClickListener;
  }
  
  public final void setSelfBtnNotifyIcon(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = paramRedTouch;
  }
  
  public final void setTopicIconHasClicked()
  {
    ReadInJoyHelper.a();
    ImageView localImageView = this.f;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("topicBtn");
    }
    localImageView.setImageResource(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = false;
    RIJXTabReport.a(this.jdField_a_of_type_Boolean, "0X800BA07");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar
 * JD-Core Version:    0.7.0.1
 */