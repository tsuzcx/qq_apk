package com.tencent.tkd.topicsdk.entry.circle;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.tkd.topicsdk.common.AnimationExtensionsKt;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.R.color;
import com.tencent.tkd.topicsdk.entry.R.drawable;
import com.tencent.tkd.topicsdk.entry.R.id;
import com.tencent.tkd.topicsdk.entry.R.layout;
import com.tencent.tkd.topicsdk.entry.R.string;
import com.tencent.tkd.topicsdk.widget.RoundProgressView;
import com.tencent.tkd.topicsdk.widget.ShadowDrawable;
import com.tencent.tkd.topicsdk.widget.ShadowDrawable.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/circle/CircleEntryView;", "Lcom/tencent/tkd/topicsdk/entry/circle/ICircleEntryView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Landroid/os/Bundle;Landroid/os/Bundle;)V", "addPublishView", "Landroid/widget/ImageView;", "value", "Landroid/view/View$OnClickListener;", "addPublishViewClickListener", "getAddPublishViewClickListener", "()Landroid/view/View$OnClickListener;", "setAddPublishViewClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnLongClickListener;", "addPublishViewLongClickListener", "getAddPublishViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setAddPublishViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "getBridge", "()Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "cancelPublishView", "cancelPublishViewClickListener", "getCancelPublishViewClickListener", "setCancelPublishViewClickListener", "centerWordingLayout", "Landroid/view/View;", "coverImageView", "currentStatus", "", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "draftImageView", "draftImageViewClickListener", "getDraftImageViewClickListener", "setDraftImageViewClickListener", "getInnerBundle", "()Landroid/os/Bundle;", "setInnerBundle", "(Landroid/os/Bundle;)V", "isFold", "", "()Z", "setFold", "(Z)V", "getOuterBundle", "setOuterBundle", "progressLayout", "Landroid/widget/FrameLayout;", "progressTextView", "Landroid/widget/TextView;", "progressView", "Lcom/tencent/tkd/topicsdk/widget/RoundProgressView;", "refreshView", "refreshViewClickListener", "getRefreshViewClickListener", "setRefreshViewClickListener", "successView", "uploadUnfoldTitleView", "fold", "", "callback", "Lkotlin/Function0;", "getResColor", "colorId", "hideMainEntryView", "onCoverImageViewClicked", "reset", "setPublishFail", "showMainEntryView", "showProgressLayout", "isVisible", "showPublishProgress", "showSuccessStatus", "animationCallback", "unFold", "updateData", "updateNeedNumProgress", "needNumProgress", "updateProgress", "percent", "updatePublishCover", "coverPath", "", "Companion", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class CircleEntryView
  extends LinearLayout
  implements ICircleEntryView
{
  public static final CircleEntryView.Companion a = new CircleEntryView.Companion(null);
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private RoundProgressView e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private FrameLayout i;
  private ImageView j;
  private ImageView k;
  private View l;
  private int m;
  private boolean n;
  @Nullable
  private View.OnClickListener o;
  @Nullable
  private View.OnLongClickListener p;
  @Nullable
  private View.OnClickListener q;
  @Nullable
  private View.OnClickListener r;
  @Nullable
  private View.OnClickListener s;
  @NotNull
  private final IEntryViewBridge t;
  @Nullable
  private Bundle u;
  @Nullable
  private Bundle v;
  
  public CircleEntryView(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    super(paramContext);
    this.t = paramIEntryViewBridge;
    this.u = paramBundle1;
    this.v = paramBundle2;
    this.n = true;
    LayoutInflater.from(paramContext).inflate(R.layout.a, (ViewGroup)this, true);
    paramIEntryViewBridge = findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.addPublishView)");
    this.b = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.draftImageView)");
    this.c = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.coverImageView)");
    this.d = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.B);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressView)");
    this.e = ((RoundProgressView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.L);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.uploadUnfoldTitleView)");
    this.f = ((TextView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.A);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressTextView)");
    this.g = ((TextView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.cancelPublishView)");
    this.h = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.z);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressLayout)");
    this.i = ((FrameLayout)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.refreshView)");
    this.j = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.F);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.successView)");
    this.k = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.centerWordingLayout)");
    this.l = paramIEntryViewBridge;
    this.i.setBackgroundColor(0);
    this.d.setOnClickListener((View.OnClickListener)new CircleEntryView.1(this));
    paramContext = ContextCompat.getDrawable(paramContext, R.drawable.a);
    if (paramContext != null) {
      paramContext = paramContext.mutate();
    } else {
      paramContext = null;
    }
    if (paramContext != null) {
      paramContext.setColorFilter(b(R.color.b), PorterDuff.Mode.SRC_IN);
    }
    this.h.setImageDrawable(paramContext);
    d();
  }
  
  private final int b(int paramInt)
  {
    return ContextCompat.getColor(getContext(), paramInt);
  }
  
  private final void e()
  {
    int i1;
    if (a())
    {
      b();
      i1 = 4;
    }
    else
    {
      ICircleEntryView.DefaultImpls.a(this, null, 1, null);
      i1 = 3;
    }
    setCurrentStatus(i1);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(int paramInt)
  {
    TextView localTextView = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append('%');
    localTextView.setText((CharSequence)localStringBuilder.toString());
    this.e.setCurrentProgress(paramInt);
  }
  
  public void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    this.u = paramBundle1;
    this.v = paramBundle2;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "coverPath");
    int i1;
    if (((CharSequence)paramString).length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.d.setImageDrawable(null);
      return;
    }
    IEntryViewBridge localIEntryViewBridge = getBridge();
    ImageView localImageView = this.d;
    localIEntryViewBridge.a(localImageView, paramString, localImageView.getWidth() / 2);
  }
  
  public void a(@Nullable Function0<Unit> paramFunction0)
  {
    if (a())
    {
      if (paramFunction0 != null) {
        paramFunction0 = (Unit)paramFunction0.invoke();
      }
      return;
    }
    this.e.setNeedNumProgress(true);
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = ((DisplayUtils)localObject).a(localContext, 177.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ValueAnimator.ofInt(new int[] { i1, ((DisplayUtils)localObject).a(localContext, 74.0F) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CircleEntryView.fold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "valueAnimator");
    AnimationExtensionsKt.a((ValueAnimator)localObject, (Function0)new CircleEntryView.fold.2(this, paramFunction0));
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).start();
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.i;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localFrameLayout.setVisibility(i1);
  }
  
  public boolean a()
  {
    return this.n;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    Object localObject1 = ShadowDrawable.a;
    Object localObject2 = (View)this.i;
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = localDisplayUtils.a(localContext, 74.0F);
    int i2 = Color.parseColor("#26000000");
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i3 = localDisplayUtils.a(localContext, 8.0F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i4 = -localDisplayUtils.a(localContext, 0.5F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((ShadowDrawable.Companion)localObject1).a((View)localObject2, -1, i1, i2, i3, i4, localDisplayUtils.a(localContext, 3.0F));
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    i1 = ((DisplayUtils)localObject1).a((Context)localObject2, 74.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = ValueAnimator.ofInt(new int[] { i1, ((DisplayUtils)localObject1).a((Context)localObject2, 177.0F) });
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CircleEntryView.unFold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueAnimator");
    AnimationExtensionsKt.a((ValueAnimator)localObject1, (Function0)new CircleEntryView.unFold.2(this));
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).start();
  }
  
  public void c()
  {
    if (getBridge().e())
    {
      this.b.setImageDrawable(getBridge().d());
      this.c.setImageDrawable(getBridge().b());
    }
    else
    {
      this.b.setImageDrawable(getBridge().c());
      this.c.setImageDrawable(getBridge().a());
    }
    if (!getBridge().a(this.u))
    {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      setCurrentStatus(0);
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    setCurrentStatus(1);
  }
  
  public final void d()
  {
    a(false);
    a(0);
    c();
    a("");
    this.k.setVisibility(8);
  }
  
  @Nullable
  public final View.OnClickListener getAddPublishViewClickListener()
  {
    return this.o;
  }
  
  @Nullable
  public final View.OnLongClickListener getAddPublishViewLongClickListener()
  {
    return this.p;
  }
  
  @NotNull
  public IEntryViewBridge getBridge()
  {
    return this.t;
  }
  
  @Nullable
  public final View.OnClickListener getCancelPublishViewClickListener()
  {
    return this.r;
  }
  
  public int getCurrentStatus()
  {
    return this.m;
  }
  
  @Nullable
  public final View.OnClickListener getDraftImageViewClickListener()
  {
    return this.q;
  }
  
  @Nullable
  public final Bundle getInnerBundle()
  {
    return this.u;
  }
  
  @Nullable
  public final Bundle getOuterBundle()
  {
    return this.v;
  }
  
  @Nullable
  public final View.OnClickListener getRefreshViewClickListener()
  {
    return this.s;
  }
  
  public final void setAddPublishViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.o = paramOnClickListener;
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public final void setAddPublishViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.p = paramOnLongClickListener;
    this.b.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public final void setCancelPublishViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.r = paramOnClickListener;
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.m = paramInt;
  }
  
  public final void setDraftImageViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.q = paramOnClickListener;
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public final void setInnerBundle(@Nullable Bundle paramBundle)
  {
    this.u = paramBundle;
  }
  
  public final void setOuterBundle(@Nullable Bundle paramBundle)
  {
    this.v = paramBundle;
  }
  
  public final void setPublishFail()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.f.setText((CharSequence)((Resources)localObject).getString(R.string.b));
    this.f.setTextColor(b(R.color.c));
    this.f.setTextSize(12.0F);
    this.g.setTextColor(b(R.color.a));
    this.g.setText((CharSequence)((Resources)localObject).getString(R.string.a));
    this.g.setTextSize(10.0F);
    this.e.setVisibility(8);
    this.j.setVisibility(0);
  }
  
  public final void setRefreshViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.s = paramOnClickListener;
    this.j.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.circle.CircleEntryView
 * JD-Core Version:    0.7.0.1
 */