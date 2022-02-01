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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/circle/CircleEntryView;", "Lcom/tencent/tkd/topicsdk/entry/circle/ICircleEntryView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Landroid/os/Bundle;Landroid/os/Bundle;)V", "addPublishView", "Landroid/widget/ImageView;", "value", "Landroid/view/View$OnClickListener;", "addPublishViewClickListener", "getAddPublishViewClickListener", "()Landroid/view/View$OnClickListener;", "setAddPublishViewClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnLongClickListener;", "addPublishViewLongClickListener", "getAddPublishViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setAddPublishViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "getBridge", "()Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "cancelPublishView", "cancelPublishViewClickListener", "getCancelPublishViewClickListener", "setCancelPublishViewClickListener", "centerWordingLayout", "Landroid/view/View;", "coverImageView", "createTopicView", "createTopicViewClickListener", "getCreateTopicViewClickListener", "setCreateTopicViewClickListener", "currentStatus", "", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "draftImageView", "draftImageViewClickListener", "getDraftImageViewClickListener", "setDraftImageViewClickListener", "getInnerBundle", "()Landroid/os/Bundle;", "setInnerBundle", "(Landroid/os/Bundle;)V", "isFold", "", "()Z", "setFold", "(Z)V", "getOuterBundle", "setOuterBundle", "progressLayout", "Landroid/widget/FrameLayout;", "progressTextView", "Landroid/widget/TextView;", "progressView", "Lcom/tencent/tkd/topicsdk/widget/RoundProgressView;", "publishArticleView", "publishArticleViewClickListener", "getPublishArticleViewClickListener", "setPublishArticleViewClickListener", "refreshView", "refreshViewClickListener", "getRefreshViewClickListener", "setRefreshViewClickListener", "successView", "uploadUnfoldTitleView", "fold", "", "callback", "Lkotlin/Function0;", "getResColor", "colorId", "hideMainEntryView", "hideSubEntryView", "onCoverImageViewClicked", "reset", "setPublishFail", "showCreateTopicView", "showMainEntryView", "showProgressLayout", "isVisible", "showPublishArticleView", "showPublishProgress", "showSuccessAnimation", "unFold", "updateCoverImage", "coverPath", "", "updateData", "updateNeedNumProgress", "needNumProgress", "updateProgress", "percent", "Companion", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class CircleEntryView
  extends LinearLayout
  implements ICircleEntryView
{
  public static final CircleEntryView.Companion a;
  private int jdField_a_of_type_Int;
  @Nullable
  private Bundle jdField_a_of_type_AndroidOsBundle;
  @Nullable
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  @Nullable
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final IEntryViewBridge jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge;
  private RoundProgressView jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private Bundle jdField_b_of_type_AndroidOsBundle;
  @Nullable
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  @Nullable
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  @Nullable
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  @Nullable
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private ImageView g;
  private ImageView h;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkEntryCircleCircleEntryView$Companion = new CircleEntryView.Companion(null);
  }
  
  public CircleEntryView(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge = paramIEntryViewBridge;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
    this.jdField_a_of_type_Boolean = true;
    LayoutInflater.from(paramContext).inflate(R.layout.jdField_a_of_type_Int, (ViewGroup)this, true);
    paramIEntryViewBridge = findViewById(R.id.e);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.createTopicView)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.C);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.publishArticleView)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.jdField_a_of_type_Int);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.addPublishView)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.draftImageView)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.coverImageView)");
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.z);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressView)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView = ((RoundProgressView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.H);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.uploadUnfoldTitleView)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.y);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressTextView)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.cancelPublishView)");
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.x);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.progressLayout)");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.D);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.refreshView)");
    this.g = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.successView)");
    this.h = ((ImageView)paramIEntryViewBridge);
    paramIEntryViewBridge = findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "findViewById(R.id.centerWordingLayout)");
    this.jdField_a_of_type_AndroidViewView = paramIEntryViewBridge;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new CircleEntryView.1(this));
    paramContext = ContextCompat.getDrawable(paramContext, R.drawable.jdField_a_of_type_Int);
    if (paramContext != null) {
      paramContext = paramContext.mutate();
    } else {
      paramContext = null;
    }
    if (paramContext != null) {
      paramContext.setColorFilter(a(R.color.b), PorterDuff.Mode.SRC_IN);
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    d();
  }
  
  private final int a(int paramInt)
  {
    return ContextCompat.getColor(getContext(), paramInt);
  }
  
  private final void e()
  {
    int i;
    if (a())
    {
      a();
      i = 4;
    }
    else
    {
      ICircleEntryView.DefaultImpls.a(this, null, 1, null);
      i = 3;
    }
    setCurrentStatus(i);
  }
  
  @Nullable
  public final Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  @NotNull
  public IEntryViewBridge a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
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
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CircleEntryView.unFold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueAnimator");
    AnimationExtensionsKt.a((ValueAnimator)localObject1, (Function0)new CircleEntryView.unFold.2(this));
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).start();
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(int paramInt)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append('%');
    localTextView.setText((CharSequence)localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setCurrentProgress(paramInt);
  }
  
  public void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "coverPath");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    }
    IEntryViewBridge localIEntryViewBridge = a();
    ImageView localImageView = this.jdField_e_of_type_AndroidWidgetImageView;
    localIEntryViewBridge.a(localImageView, paramString, localImageView.getWidth() / 2);
  }
  
  public void a(@Nullable Function0<Unit> paramFunction0)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setNeedNumProgress(true);
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject).a(localContext, 177.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ValueAnimator.ofInt(new int[] { i, ((DisplayUtils)localObject).a(localContext, 74.0F) });
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CircleEntryView.fold.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "valueAnimator");
    AnimationExtensionsKt.a((ValueAnimator)localObject, (Function0)new CircleEntryView.fold.2(this, paramFunction0));
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).start();
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localFrameLayout.setVisibility(i);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @Nullable
  public final Bundle b()
  {
    return this.jdField_b_of_type_AndroidOsBundle;
  }
  
  public void b()
  {
    if (a().a())
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(a().d());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a().b());
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(a().c());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(a().a());
    }
    if (!a().a(this.jdField_a_of_type_AndroidOsBundle))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      setCurrentStatus(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    setCurrentStatus(1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    setCurrentStatus(0);
  }
  
  public final void d()
  {
    a(false);
    a(0);
    c();
    b();
    a("");
    this.h.setVisibility(8);
  }
  
  public final void setAddPublishViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public final void setAddPublishViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_c_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public final void setCancelPublishViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_e_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public final void setCreateTopicViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setDraftImageViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_d_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setInnerBundle(@Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public final void setOuterBundle(@Nullable Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidOsBundle = paramBundle;
  }
  
  public final void setPublishArticleViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public final void setPublishFail()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)((Resources)localObject).getString(R.string.b));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(R.color.c));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a(R.color.jdField_a_of_type_Int));
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)((Resources)localObject).getString(R.string.jdField_a_of_type_Int));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetRoundProgressView.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  public final void setRefreshViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_f_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.circle.CircleEntryView
 * JD-Core Version:    0.7.0.1
 */