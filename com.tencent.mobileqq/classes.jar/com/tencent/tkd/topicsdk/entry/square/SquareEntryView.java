package com.tencent.tkd.topicsdk.entry.square;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.R.id;
import com.tencent.tkd.topicsdk.entry.R.layout;
import com.tencent.tkd.topicsdk.widget.RoundBackgroundTextView;
import com.tencent.tkd.topicsdk.widget.SquareProgressView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/square/SquareEntryView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/entry/square/ISquareEntryView;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Landroid/os/Bundle;Landroid/os/Bundle;)V", "getBridge", "()Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "setBridge", "(Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;)V", "cancelView", "Landroid/view/View;", "value", "Landroid/view/View$OnClickListener;", "cancelViewClickListener", "getCancelViewClickListener", "()Landroid/view/View$OnClickListener;", "setCancelViewClickListener", "(Landroid/view/View$OnClickListener;)V", "coverImageView", "Landroid/widget/ImageView;", "currentStatus", "", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "entryLayout", "firstSubDraftView", "firstSubEntryLayout", "firstSubEntryTextView", "Lcom/tencent/tkd/topicsdk/widget/RoundBackgroundTextView;", "firstSubEntryView", "firstSubViewClickListener", "getFirstSubViewClickListener", "setFirstSubViewClickListener", "getInnerBundle", "()Landroid/os/Bundle;", "setInnerBundle", "(Landroid/os/Bundle;)V", "isFirstSubViewShowing", "", "isSecondSubViewShowing", "mainEntryDraftView", "mainEntryView", "mainViewClickListener", "getMainViewClickListener", "setMainViewClickListener", "Landroid/view/View$OnLongClickListener;", "mainViewLongClickListener", "getMainViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMainViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "operationContentView", "Landroid/widget/TextView;", "operationLayout", "operationStatusView", "operationView", "getOuterBundle", "setOuterBundle", "progressLayout", "progressView", "Lcom/tencent/tkd/topicsdk/widget/SquareProgressView;", "progressViewClickListener", "getProgressViewClickListener", "setProgressViewClickListener", "retryLayout", "retryView", "secondSubEntryLayout", "secondSubViewClickListener", "getSecondSubViewClickListener", "setSecondSubViewClickListener", "secondSubViewLongClickListener", "getSecondSubViewLongClickListener", "setSecondSubViewLongClickListener", "successLayout", "successView", "uploadLayout", "getCancelViewAnimation", "Landroid/view/animation/AnimationSet;", "getMainViewAnimation", "Landroid/view/animation/RotateAnimation;", "isReverse", "postDelayMs", "", "getProgressLayoutAnimation", "Landroid/view/animation/ScaleAnimation;", "animationCallback", "Lkotlin/Function0;", "", "getSubViewAnimationSet", "view", "translateStartY", "", "translateEndY", "durationMs", "hideMainEntryView", "hidePublishLayout", "needAnimation", "hideSubEntryView", "reset", "resetProgressContentView", "resetProgressView", "showMainEntryView", "showOperationStatus", "statusText", "", "icon", "Landroid/graphics/drawable/Drawable;", "showPublishLayout", "showRetryStatus", "showSubEntryView", "showFirstSubView", "showSecondSubView", "showSuccessStatus", "updateData", "updateFirstSubViewStatus", "isForbidden", "updateProgress", "progress", "updatePublishCover", "coverPath", "Companion", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class SquareEntryView
  extends RelativeLayout
  implements ISquareEntryView
{
  public static final SquareEntryView.Companion a = new SquareEntryView.Companion(null);
  @Nullable
  private View.OnClickListener A;
  @Nullable
  private View.OnLongClickListener B;
  @Nullable
  private View.OnClickListener C;
  @Nullable
  private View.OnClickListener D;
  @NotNull
  private IEntryViewBridge E;
  @Nullable
  private Bundle F;
  @Nullable
  private Bundle G;
  private int b;
  private RelativeLayout c;
  private ImageView d;
  private ImageView e;
  private RelativeLayout f;
  private ImageView g;
  private RoundBackgroundTextView h;
  private ImageView i;
  private RelativeLayout j;
  private RelativeLayout k;
  private RelativeLayout l;
  private ImageView m;
  private SquareProgressView n;
  private RelativeLayout o;
  private View p;
  private TextView q;
  private TextView r;
  private RelativeLayout s;
  private ImageView t;
  private RelativeLayout u;
  private ImageView v;
  private View w;
  @Nullable
  private View.OnClickListener x;
  @Nullable
  private View.OnLongClickListener y;
  @Nullable
  private View.OnClickListener z;
  
  public SquareEntryView(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    super(paramContext);
    this.E = paramIEntryViewBridge;
    this.F = paramBundle1;
    this.G = paramBundle2;
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    paramContext = findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_entry)");
    this.c = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_main_entry)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_main_entry_draft)");
    this.e = ((ImageView)paramContext);
    paramContext = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_first_sub_entry)");
    this.f = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.g);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_first_sub_entry)");
    this.g = ((ImageView)paramContext);
    paramContext = findViewById(R.id.G);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_first_sub_entry)");
    this.h = ((RoundBackgroundTextView)paramContext);
    paramContext = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_first_sub_entry_draft)");
    this.i = ((ImageView)paramContext);
    paramContext = findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_second_sub_entry)");
    this.j = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.w);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_upload)");
    this.k = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.C);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_layout)");
    this.l = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_upload)");
    this.m = ((ImageView)paramContext);
    paramContext = findViewById(R.id.D);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_view)");
    this.n = ((SquareProgressView)paramContext);
    paramContext = findViewById(R.id.s);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_operation)");
    this.o = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_operation)");
    this.p = paramContext;
    paramContext = findViewById(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_operation_content)");
    this.q = ((TextView)paramContext);
    paramContext = findViewById(R.id.J);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_operation_status)");
    this.r = ((TextView)paramContext);
    paramContext = findViewById(R.id.v);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_success)");
    this.s = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.o);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_success)");
    this.t = ((ImageView)paramContext);
    paramContext = findViewById(R.id.t);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_retry)");
    this.u = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_retry)");
    this.v = ((ImageView)paramContext);
    paramContext = findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_cancel)");
    this.w = paramContext;
  }
  
  private final AnimationSet getCancelViewAnimation()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, -45.0F, this.w.getPivotX(), this.w.getPivotY());
    Object localObject1 = DisplayUtils.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    float f1 = ((DisplayUtils)localObject1).a((Context)localObject2, 13.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new TranslateAnimation(0.0F, f1, 0.0F, -((DisplayUtils)localObject1).a((Context)localObject2, 48.0F));
    localObject2 = DisplayUtils.a;
    Object localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    f1 = ((DisplayUtils)localObject2).a((Context)localObject3, 28.0F);
    localObject2 = DisplayUtils.a;
    localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    f1 /= ((DisplayUtils)localObject2).a((Context)localObject3, 18.0F);
    localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1, this.w.getPivotX(), this.w.getPivotY());
    localObject3 = new AnimationSet(true);
    ((AnimationSet)localObject3).addAnimation((Animation)localRotateAnimation);
    ((AnimationSet)localObject3).addAnimation((Animation)localObject1);
    ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject3).setInterpolator((Interpolator)new DecelerateInterpolator());
    ((AnimationSet)localObject3).setDuration(300L);
    return localObject3;
  }
  
  public void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    this.F = paramBundle1;
    this.G = paramBundle2;
  }
  
  @NotNull
  public IEntryViewBridge getBridge()
  {
    return this.E;
  }
  
  @Nullable
  public final View.OnClickListener getCancelViewClickListener()
  {
    return this.D;
  }
  
  public int getCurrentStatus()
  {
    return this.b;
  }
  
  @Nullable
  public final View.OnClickListener getFirstSubViewClickListener()
  {
    return this.z;
  }
  
  @Nullable
  public final Bundle getInnerBundle()
  {
    return this.F;
  }
  
  @Nullable
  public final View.OnClickListener getMainViewClickListener()
  {
    return this.x;
  }
  
  @Nullable
  public final View.OnLongClickListener getMainViewLongClickListener()
  {
    return this.y;
  }
  
  @Nullable
  public final Bundle getOuterBundle()
  {
    return this.G;
  }
  
  @Nullable
  public final View.OnClickListener getProgressViewClickListener()
  {
    return this.C;
  }
  
  @Nullable
  public final View.OnClickListener getSecondSubViewClickListener()
  {
    return this.A;
  }
  
  @Nullable
  public final View.OnLongClickListener getSecondSubViewLongClickListener()
  {
    return this.B;
  }
  
  public void setBridge(@NotNull IEntryViewBridge paramIEntryViewBridge)
  {
    Intrinsics.checkParameterIsNotNull(paramIEntryViewBridge, "<set-?>");
    this.E = paramIEntryViewBridge;
  }
  
  public final void setCancelViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.D = paramOnClickListener;
    this.w.setOnClickListener(paramOnClickListener);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setFirstSubViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.z = paramOnClickListener;
    this.f.setOnClickListener(paramOnClickListener);
  }
  
  public final void setInnerBundle(@Nullable Bundle paramBundle)
  {
    this.F = paramBundle;
  }
  
  public final void setMainViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public final void setMainViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.y = paramOnLongClickListener;
    this.d.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public final void setOuterBundle(@Nullable Bundle paramBundle)
  {
    this.G = paramBundle;
  }
  
  public final void setProgressViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.C = paramOnClickListener;
    this.l.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSecondSubViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.A = paramOnClickListener;
    this.j.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSecondSubViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.B = paramOnLongClickListener;
    this.j.setOnLongClickListener(paramOnLongClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.square.SquareEntryView
 * JD-Core Version:    0.7.0.1
 */