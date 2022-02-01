package com.tencent.tkd.topicsdk.entry;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.common.AnimationExtensionsKt;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.NetworkUtil;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import com.tencent.tkd.topicsdk.publisharticle.PublishManager;
import com.tencent.tkd.topicsdk.publisharticle.PublishManager.IPublishArticleListener;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion;
import com.tencent.tkd.topicsdk.widget.RoundProgressView;
import com.tencent.tkd.topicsdk.widget.ShadowDrawable;
import com.tencent.tkd.topicsdk.widget.ShadowDrawable.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/EntryView;", "Landroid/view/View$OnClickListener;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "(Landroid/content/Context;Landroid/os/Bundle;Landroid/os/Bundle;)V", "addPublishView", "Landroid/widget/ImageView;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "getBridge", "()Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "cancelPublishView", "centerWordingLayout", "Landroid/view/View;", "coverImageView", "createTopicView", "currentPublishId", "", "draftImageView", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "getGlobalPublisherConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "setGlobalPublisherConfig", "(Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "isDraftExist", "", "()Z", "isFold", "needShowCreateTopicEntry", "getNeedShowCreateTopicEntry", "setNeedShowCreateTopicEntry", "(Z)V", "needShowPublishArticleEntry", "getNeedShowPublishArticleEntry", "setNeedShowPublishArticleEntry", "progressLayout", "Landroid/widget/FrameLayout;", "progressTextView", "Landroid/widget/TextView;", "progressView", "Lcom/tencent/tkd/topicsdk/widget/RoundProgressView;", "publishArticleView", "publishListener", "com/tencent/tkd/topicsdk/entry/EntryView$publishListener$1", "Lcom/tencent/tkd/topicsdk/entry/EntryView$publishListener$1;", "refreshView", "successView", "uploadUnfoldTitleView", "fold", "", "callback", "Lkotlin/Function0;", "handleRefresh", "bundle", "hideMainEntryView", "hideProgressLayout", "hideSubEntryView", "initData", "invalidate", "loadCoverImage", "coverPath", "onAddPublishViewClicked", "onAttachedToWindow", "onCancelPublishViewClicked", "onClick", "v", "onDetachedFromWindow", "openCreateTopicPage", "openPublishArticlePage", "reportCancelViewClicked", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "reportEntryViewClick", "reset", "setPublishFail", "showCreateTopicView", "showMainEntryView", "showProgressLayout", "showPublishArticleView", "showPublishProgress", "showSuccessAnimation", "unFold", "updateData", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class EntryView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final EntryView.Companion a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  private final EntryView.publishListener.1 jdField_a_of_type_ComTencentTkdTopicsdkEntryEntryView$publishListener$1;
  private RoundProgressView jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Bundle jdField_b_of_type_AndroidOsBundle;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkEntryEntryView$Companion = new EntryView.Companion(null);
  }
  
  private final IEntryViewBridge a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  private final void a(Bundle paramBundle)
  {
    if (!NetworkUtil.b(getContext()))
    {
      paramBundle = getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "context");
      paramBundle = paramBundle.getResources().getString(R.string.N);
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "context.resources.getString(R.string.net_failed)");
      TopicSDKHelperKt.a(paramBundle, false, null, 6, null);
      return;
    }
    PublishManager.a.a(paramBundle, this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setNeedNumProgress(false);
    l();
    n();
  }
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_ENTRY_VIEW, ReportEventElement.BUTTON_CANCEL, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, paramPublishArticleInfo));
  }
  
  private final void a(String paramString)
  {
    com.tencent.tkd.topicsdk.framework.bridge.ImageLoader localImageLoader = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localImageLoader.a(localContext).a(this.e).a().a(paramString);
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setAnimationListener((Animation.AnimationListener)new EntryView.showSuccessAnimation.1(paramFunction0));
    this.h.setVisibility(0);
    this.h.startAnimation((Animation)localScaleAnimation);
  }
  
  private final void b()
  {
    IEntryViewBridge localIEntryViewBridge = a();
    if (localIEntryViewBridge != null) {
      localIEntryViewBridge.a(this, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  private final void b(Function0<Unit> paramFunction0)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setNeedNumProgress(true);
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject).a(localContext, 177.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ValueAnimator.ofInt(new int[] { i, ((DisplayUtils)localObject).a(localContext, 74.0F) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new EntryView.fold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "valueAnimator");
    AnimationExtensionsKt.a((ValueAnimator)localObject, (Function0)new EntryView.fold.2(this, paramFunction0));
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).start();
  }
  
  private final void c()
  {
    IEntryViewBridge localIEntryViewBridge = a();
    if (localIEntryViewBridge != null) {
      localIEntryViewBridge.b(this, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  private final boolean c()
  {
    String str = DraftManager.a.a().a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig);
    return DraftManager.a.a().a(str);
  }
  
  private final void d()
  {
    IEntryViewBridge localIEntryViewBridge = a();
    if (localIEntryViewBridge != null) {
      localIEntryViewBridge.c(this, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  private final void e()
  {
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_ENTRY_VIEW, ReportEventElement.BUTTON_CONFIRM, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, null, 16, null));
  }
  
  private final void f()
  {
    PublishManager.a.a((Function1)new EntryView.onCancelPublishViewClicked.1(this));
  }
  
  private final void g()
  {
    PublishManager.a.a((Function1)new EntryView.initData.1(this));
    TLog.a("EntryView", "initData");
  }
  
  private final void h()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = ShadowDrawable.a;
    Object localObject2 = (View)this.jdField_a_of_type_AndroidWidgetFrameLayout;
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = localDisplayUtils.a(localContext, 74.0F);
    int j = Color.parseColor("#26000000");
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int k = localDisplayUtils.a(localContext, 8.0F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int m = -localDisplayUtils.a(localContext, 0.5F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((ShadowDrawable.Companion)localObject1).a((View)localObject2, -1, i, j, k, m, localDisplayUtils.a(localContext, 3.0F));
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i = ((DisplayUtils)localObject1).a((Context)localObject2, 74.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = ValueAnimator.ofInt(new int[] { i, ((DisplayUtils)localObject1).a((Context)localObject2, 177.0F) });
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new EntryView.unFold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueAnimator");
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).start();
  }
  
  private final void i()
  {
    if (TopicSDK.a.a().a().a().a())
    {
      localObject = a();
      if (localObject != null)
      {
        localObject = ((IEntryViewBridge)localObject).d();
        if (localObject != null)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          localObject = a();
          if (localObject == null) {
            break label120;
          }
          localObject = ((IEntryViewBridge)localObject).b();
          if (localObject == null) {
            break label120;
          }
        }
      }
      for (;;)
      {
        this.d.setImageDrawable((Drawable)localObject);
        if (c()) {
          break label236;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.d.setVisibility(8);
        return;
        localObject = AppContext.a.a().getResources().getDrawable(R.drawable.f);
        break;
        label120:
        localObject = AppContext.a.a().getResources().getDrawable(R.drawable.e);
      }
    }
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((IEntryViewBridge)localObject).c();
      if (localObject != null)
      {
        label159:
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        localObject = a();
        if (localObject == null) {
          break label217;
        }
        localObject = ((IEntryViewBridge)localObject).a();
        if (localObject == null) {
          break label217;
        }
      }
    }
    for (;;)
    {
      this.d.setImageDrawable((Drawable)localObject);
      break;
      localObject = AppContext.a.a().getResources().getDrawable(R.drawable.c);
      break label159;
      label217:
      localObject = AppContext.a.a().getResources().getDrawable(R.drawable.d);
    }
    label236:
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  private final void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private final void k()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private final void l()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  private final void m()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)((Resources)localObject).getString(R.string.U));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColor(R.color.i));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColor(R.color.e));
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)((Resources)localObject).getString(R.string.k));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private final void n()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(R.string.Z);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColor(R.color.e));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(11.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColor(R.color.c));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  private final void o()
  {
    k();
    j();
    i();
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setCurrentProgress(0);
    this.e.setImageDrawable(null);
    this.h.setVisibility(8);
  }
  
  public final void a()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public final void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
    if (paramBundle1 != null) {}
    for (paramBundle1 = paramBundle1.getSerializable("global_publisher_config");; paramBundle1 = null)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = ((GlobalPublisherConfig)paramBundle1);
      return;
    }
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void invalidate()
  {
    i();
    super.invalidate();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
    PublishManager.a.a((PublishManager.IPublishArticleListener)this.jdField_a_of_type_ComTencentTkdTopicsdkEntryEntryView$publishListener$1);
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == R.id.a)
      {
        b();
        e();
        return;
      }
      if (i == R.id.F)
      {
        c();
        e();
        return;
      }
      if (i == R.id.aU)
      {
        d();
        e();
        return;
      }
      if (i == R.id.H)
      {
        d();
        e();
        return;
      }
      if (i == R.id.E)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          h();
          return;
        }
        a(this, null, 1, null);
        return;
      }
      if (i == R.id.t)
      {
        f();
        return;
      }
    } while (i != R.id.aZ);
    a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void onDetachedFromWindow()
  {
    PublishManager.a.b((PublishManager.IPublishArticleListener)this.jdField_a_of_type_ComTencentTkdTopicsdkEntryEntryView$publishListener$1);
    super.onDetachedFromWindow();
  }
  
  public final void setGlobalPublisherConfig(@Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = paramGlobalPublisherConfig;
  }
  
  public final void setNeedShowCreateTopicEntry(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void setNeedShowPublishArticleEntry(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView
 * JD-Core Version:    0.7.0.1
 */