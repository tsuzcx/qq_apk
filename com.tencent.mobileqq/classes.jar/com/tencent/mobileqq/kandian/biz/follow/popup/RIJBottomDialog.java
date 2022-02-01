package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJBottomDialog;", "Landroid/app/Dialog;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowRecommendPopupCommand;", "context", "Landroid/content/Context;", "source", "", "(Landroid/content/Context;I)V", "clickCloseBtn", "", "getClickCloseBtn", "()Z", "setClickCloseBtn", "(Z)V", "followPackData", "Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils$RIJFollowPackData;", "getFollowPackData", "()Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils$RIJFollowPackData;", "setFollowPackData", "(Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils$RIJFollowPackData;)V", "isAnimating", "<set-?>", "Landroid/view/View;", "rootContentView", "getRootContentView", "()Landroid/view/View;", "showed", "getSource", "()I", "animateDown", "", "animateUp", "dismiss", "forceHeightWrapContent", "view", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onStart", "refreshFollowUI", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "show", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBottomDialog
  extends Dialog
  implements SimpleEventReceiver<RIJFollowRecommendPopupCommand>
{
  public static final RIJBottomDialog.Companion a = new RIJBottomDialog.Companion(null);
  private boolean b;
  @Nullable
  private View c;
  private boolean d;
  private boolean e;
  @Nullable
  private RIJFollowPackUtils.RIJFollowPackData f;
  private final int g;
  
  public RIJBottomDialog(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131952290);
    this.g = paramInt;
  }
  
  private final void a(View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      QLog.i("RIJBottomDialog", 1, "[forceHeightWrapContent] view is null.");
      return;
    }
    do
    {
      paramView = localView.getLayoutParams();
      if (paramView != null) {
        paramView.height = -2;
      }
      Object localObject = localView.getParent();
      paramView = localView;
      if (localObject != null) {
        try
        {
          paramView = (View)localObject;
        }
        catch (Exception paramView)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[forceHeightWrapContent] e = ");
          ((StringBuilder)localObject).append(paramView);
          QLog.e("RIJBottomDialog", 1, ((StringBuilder)localObject).toString());
          paramView = localView;
        }
      }
      localView = paramView;
    } while (paramView.getParent() != null);
    paramView.requestLayout();
  }
  
  private final void b()
  {
    View localView = this.c;
    if (localView != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, localView.getHeight(), 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
      localView.startAnimation((Animation)localTranslateAnimation);
    }
  }
  
  private final void c()
  {
    View localView = this.c;
    if (localView != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localView.getHeight());
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
      localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new RIJBottomDialog.animateDown..inlined.let.lambda.1(this));
      localView.startAnimation((Animation)localTranslateAnimation);
    }
  }
  
  private final void d()
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject1 = ((RIJFollowPackUtils.RIJFollowPackData)localObject1).c();
      if (localObject1 != null)
      {
        localObject1 = ((AbsBaseArticleInfo)localObject1).mRecommendFollowInfos;
        if (localObject1 != null)
        {
          Object localObject2 = ((RecommendFollowInfos)localObject1).c;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.recommendFollowInfoList");
          if ((((Collection)localObject2).isEmpty() ^ true))
          {
            localObject2 = RIJFollowPackUtils.a;
            localObject1 = ((RecommendFollowInfos)localObject1).c;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.recommendFollowInfoList");
            ((RIJFollowPackUtils)localObject2).a((List)localObject1);
            localObject1 = RIJFollowPackUtils.a;
            localObject2 = this.f;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((RIJFollowPackUtils)localObject1).a((RIJFollowPackUtils.RIJFollowPackData)localObject2);
          }
        }
      }
    }
  }
  
  @Nullable
  public final View a()
  {
    return this.c;
  }
  
  public final void a(@Nullable RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    this.f = paramRIJFollowPackData;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void dismiss()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dismiss: showed=");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("， isAnimating=");
      ((StringBuilder)localObject1).append(this.d);
      QLog.d("RIJBottomDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.d)
    {
      if (!this.e) {
        return;
      }
      this.e = false;
      c();
      RIJFollowPackUtils.a.b();
      Object localObject2 = RIJFollowRecommendReport.a.a(Integer.valueOf(this.g));
      if (this.b) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addStringNotThrow("close_way", (String)localObject1);
      localObject1 = RIJFollowRecommendReport.a;
      localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "r5Builder.toString()");
      ((RIJFollowRecommendReport.Companion)localObject1).a("0X800B997", (String)localObject2);
      SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
    }
  }
  
  @NotNull
  public ArrayList<Class<RIJFollowRecommendPopupCommand>> getEventClass()
  {
    return CollectionsKt.arrayListOf(new Class[] { RIJFollowRecommendPopupCommand.class });
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setGravity(80);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -2);
    }
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof RIJFollowRecommendPopupCommand))
    {
      int i = ((RIJFollowRecommendPopupCommand)paramSimpleBaseEvent).getCommand();
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        d();
        return;
      }
      dismiss();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    a(this.c);
  }
  
  public void setContentView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.c = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(@NotNull View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.c = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    if (QLog.isColorLevel()) {
      QLog.d("RIJBottomDialog", 2, "show: ");
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.c;
    if (localObject != null) {
      ((View)localObject).post((Runnable)new RIJBottomDialog.show.1(this));
    }
    localObject = RIJFollowRecommendReport.a;
    String str = RIJFollowRecommendReport.a.a(Integer.valueOf(this.g)).toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJFollowRecommendReport…uilder(source).toString()");
    ((RIJFollowRecommendReport.Companion)localObject).a("0X800B96A", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJBottomDialog
 * JD-Core Version:    0.7.0.1
 */