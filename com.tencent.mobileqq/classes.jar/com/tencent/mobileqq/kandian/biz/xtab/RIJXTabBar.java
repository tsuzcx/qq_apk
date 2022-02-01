package com.tencent.mobileqq.kandian.biz.xtab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.view.widget.RIJBlackWhiteModeLinearLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardConfigUtil;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "Lcom/tencent/mobileqq/kandian/base/view/widget/RIJBlackWhiteModeLinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "deliverBtn", "Landroid/widget/ImageView;", "hashBtn", "hashBtnBadge", "hashBtnContainer", "Landroid/widget/FrameLayout;", "hashBtnDrawable", "<set-?>", "", "isDynamicIcon", "()Z", "moreChannelBtn", "moreChannelBtnBadge", "getMoreChannelBtnBadge", "()Landroid/widget/ImageView;", "setMoreChannelBtnBadge", "(Landroid/widget/ImageView;)V", "onBtnClickListener", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$OnBtnClickListener;", "searchBtn", "selfBtn", "selfBtnNotifyIcon", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "getSelfBtnNotifyIcon", "()Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "setSelfBtnNotifyIcon", "(Lcom/tencent/mobileqq/tianshu/ui/RedTouch;)V", "tabLayout", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout;", "xTabBarRightPadding", "Landroid/widget/Space;", "adjustHashBtnPosition", "", "buildSelfBtnRedTouch", "configDtReportParam", "getHashBtnDrawableResId", "immersive", "getTabLayout", "init", "onEnterKDTab", "refreshDeliverBtnVisibility", "refreshHashBtnBadgeVisibility", "visible", "refreshHashBtnVisibility", "refreshMoreChannelBtnBadgeVisibility", "reportHashBtnExposure", "setHashBtnIcon", "setOnBtnClickListener", "listener", "setTopicIconHasClicked", "switchImmersiveMode", "selectedIndex", "updateUI", "itemList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "viewPagerController", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "Companion", "OnBtnClickListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBar
  extends RIJBlackWhiteModeLinearLayout
{
  public static final RIJXTabBar.Companion c = new RIJXTabBar.Companion(null);
  @NotNull
  public RedTouch a;
  @NotNull
  public ImageView b;
  private ImageView d;
  private ImageView e;
  private RIJXTabLayout f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private FrameLayout k;
  private Space l;
  private int m = 2130851556;
  private boolean n;
  private RIJXTabBar.OnBtnClickListener o;
  
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
  
  private final int c(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2130851556;
    } else {
      i1 = 2130851555;
    }
    if (RIJXTabMessageBoardConfigUtil.a.b())
    {
      if (paramBoolean) {
        return 2130851548;
      }
      i1 = 2130851547;
    }
    return i1;
  }
  
  private final void e()
  {
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementId(localObject, "head_sculpture_button");
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").c("click_head_sculpture"), null, 1, null).c());
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementId(localObject, "search_box_button");
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("search_box").c("click_search_box"), null, 1, null).c());
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementId(localObject, "more_channel_button");
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementReportPolicy(localObject, ReportPolicy.REPORT_POLICY_CLICK);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    VideoReport.setElementParams(localObject, RIJDtParamBuilder.a(new RIJDtParamBuilder().a("14").b("channel_bar").c("click_more_channel"), null, 1, null).c());
  }
  
  private final void f()
  {
    Object localObject = findViewById(2131444278);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.findViewById(R.id.r…oy_id_hash_btn_container)");
    this.k = ((FrameLayout)localObject);
    localObject = findViewById(2131444282);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.findViewById(R.id.r…d_xtab_bar_right_padding)");
    this.l = ((Space)localObject);
    localObject = Aladdin.getConfig(440);
    int i1 = 0;
    if (localObject != null) {
      i1 = ((AladdinConfig)localObject).getIntegerFromString("hash_button_position", 0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[adjustHashBtnPosition] position = ");
    ((StringBuilder)localObject).append(i1);
    QLog.i("RIJXTabBar", 1, ((StringBuilder)localObject).toString());
    if (i1 == 1)
    {
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hashBtnContainer");
      }
      removeView((View)localObject);
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabBarRightPadding");
      }
      removeView((View)localObject);
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hashBtnContainer");
      }
      addView((View)localObject);
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("xTabBarRightPadding");
      }
      addView((View)localObject);
    }
  }
  
  private final void g()
  {
    boolean bool = RIJXTabMessageBoardConfigUtil.a.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[refreshHashBtnVisibility] isShowHashBtn = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("RIJXTabBar", 1, ((StringBuilder)localObject).toString());
    if (bool)
    {
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnBadge");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
      }
      ((ImageView)localObject).setImageResource(c(false));
      return;
    }
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtnBadge");
    }
    ((ImageView)localObject).setVisibility(8);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setVisibility(0);
  }
  
  private final void h()
  {
    if (RIJXTabMessageBoardConfigUtil.a.b())
    {
      if (RIJXTabMessageBoardRedUtil.a.a()) {
        RIJXTabMessageBoardRedUtil.a.a("0X800BCB4", RIJXTabMessageBoardRedUtil.a.d());
      }
    }
    else {
      RIJXTabReport.a(this.n, "0X800BA07");
    }
  }
  
  private final void setHashBtnIcon(boolean paramBoolean)
  {
    this.m = c(paramBoolean);
    Object localObject1 = Aladdin.getConfig(440);
    if (localObject1 != null) {
      localObject1 = ((AladdinConfig)localObject1).getString("button_image_url", "");
    } else {
      localObject1 = null;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[switchImmersiveMode] topicIcon = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.i("RIJXTabBar", 1, ((StringBuilder)localObject3).toString());
    localObject3 = (CharSequence)localObject1;
    int i1;
    if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 == 0) && (!ReadInJoyHelper.c()))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      try
      {
        localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "URLDecoder.decode(topicIcon, \"UTF-8\")");
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        QLog.e("RIJXTabBar", 1, (Throwable)localIllegalArgumentException, new Object[] { "The icon URL is not standard" });
        localObject2 = "";
      }
      ImageView localImageView = this.i;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
      }
      localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3));
      this.n = true;
      return;
    }
    Object localObject2 = this.i;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    ((ImageView)localObject2).setImageResource(this.m);
    this.n = false;
  }
  
  @VisibleForTesting
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    LayoutInflater.from(paramContext).inflate(2131629149, (ViewGroup)this, true);
    f();
    paramContext = findViewById(2131444318);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_self_btn)");
    this.e = ((ImageView)paramContext);
    paramContext = findViewById(2131444329);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_tab_layout)");
    this.f = ((RIJXTabLayout)paramContext);
    paramContext = findViewById(2131444301);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_btn)");
    this.h = ((ImageView)paramContext);
    paramContext = findViewById(2131444247);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_deliver_btn)");
    this.g = ((ImageView)paramContext);
    paramContext = findViewById(2131444317);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_search_btn)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(2131444274);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_hash_btn)");
    this.i = ((ImageView)paramContext);
    paramContext = findViewById(2131444275);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_hash_btn_red_dot)");
    this.j = ((ImageView)paramContext);
    this.a = b();
    paramContext = findViewById(2131444302);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.findViewById(R.id.readinjoy_more_tab_red_dot)");
    this.b = ((ImageView)paramContext);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.1(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.2(this));
    paramContext = this.h;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.3(this));
    paramContext = this.g;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.4(this));
    paramContext = this.i;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new RIJXTabBar.init.5(this));
    c();
    g();
    b(RIJXTabMessageBoardRedUtil.a.a());
    e();
  }
  
  public final void a(@NotNull List<? extends TabChannelCoverInfo> paramList, @NotNull RIJXTabViewPagerController paramRIJXTabViewPagerController)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "itemList");
    Intrinsics.checkParameterIsNotNull(paramRIJXTabViewPagerController, "viewPagerController");
    removeAllViews();
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RIJXTabLayout)localObject).a(localContext, paramList, paramRIJXTabViewPagerController);
  }
  
  public final void a(boolean paramBoolean)
  {
    ImageView localImageView = this.h;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    if (localImageView.getVisibility() != 0)
    {
      QLog.i("RIJXTabBar", 1, "[refreshMoreChannelBtnBadgeVisibility] moreChannelBtn is not visible.");
      return;
    }
    localImageView = this.b;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnBadge");
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    int i1;
    if (paramBoolean) {
      i1 = 2130851554;
    } else {
      i1 = 2130851553;
    }
    int i2;
    if (paramBoolean) {
      i2 = 2130851544;
    } else {
      i2 = 2130851543;
    }
    int i3;
    if (paramBoolean) {
      i3 = 2130851550;
    } else {
      i3 = 2130851549;
    }
    int i4;
    if (paramBoolean) {
      i4 = 2130851552;
    } else {
      i4 = 2130851551;
    }
    setHashBtnIcon(paramBoolean);
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
    }
    ((ImageView)localObject).setImageResource(i1);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    ((ImageView)localObject).setImageResource(i2);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setImageResource(i3);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    ((ImageView)localObject).setImageResource(i4);
    localObject = this.f;
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
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    ((ImageView)localObject).setAlpha(f1);
  }
  
  public final boolean a()
  {
    return this.n;
  }
  
  @VisibleForTesting
  @NotNull
  public final RedTouch b()
  {
    RedTouch localRedTouch = new RedTouch(getContext(), findViewById(2131444319)).c(8388661).a();
    Intrinsics.checkExpressionValueIsNotNull(localRedTouch, "RedTouch(this.context, t…               .applyTo()");
    return localRedTouch;
  }
  
  public final void b(boolean paramBoolean)
  {
    ImageView localImageView = this.i;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    if (localImageView.getVisibility() != 0)
    {
      QLog.i("RIJXTabBar", 1, "[refreshHashBtnBadgeVisibility] hashTopicBtn is not visible.");
      return;
    }
    localImageView = this.j;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtnBadge");
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public final void c()
  {
    boolean bool = RIJUgcUtils.l();
    Object localObject;
    if (bool)
    {
      localObject = this.g;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverBtn");
      }
      ((ImageView)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.g;
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
  
  public final void d()
  {
    ImageView localImageView = this.i;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    if (localImageView.getVisibility() == 0) {
      h();
    }
  }
  
  @NotNull
  public final ImageView getMoreChannelBtnBadge()
  {
    ImageView localImageView = this.b;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("moreChannelBtnBadge");
    }
    return localImageView;
  }
  
  @NotNull
  public final RedTouch getSelfBtnNotifyIcon()
  {
    RedTouch localRedTouch = this.a;
    if (localRedTouch == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfBtnNotifyIcon");
    }
    return localRedTouch;
  }
  
  @NotNull
  public final RIJXTabLayout getTabLayout()
  {
    RIJXTabLayout localRIJXTabLayout = this.f;
    if (localRIJXTabLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    }
    return localRIJXTabLayout;
  }
  
  public final void setMoreChannelBtnBadge(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "<set-?>");
    this.b = paramImageView;
  }
  
  public final void setOnBtnClickListener(@NotNull RIJXTabBar.OnBtnClickListener paramOnBtnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnBtnClickListener, "listener");
    this.o = paramOnBtnClickListener;
  }
  
  public final void setSelfBtnNotifyIcon(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "<set-?>");
    this.a = paramRedTouch;
  }
  
  public final void setTopicIconHasClicked()
  {
    ReadInJoyHelper.d();
    ImageView localImageView = this.i;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("hashBtn");
    }
    localImageView.setImageResource(this.m);
    this.n = false;
    RIJXTabReport.a(this.n, "0X800BA07");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar
 * JD-Core Version:    0.7.0.1
 */