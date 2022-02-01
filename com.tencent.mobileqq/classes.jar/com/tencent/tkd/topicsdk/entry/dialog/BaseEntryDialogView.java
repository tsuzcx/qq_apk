package com.tencent.tkd.topicsdk.entry.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.entry.R.id;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/dialog/BaseEntryDialogView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "layoutId", "", "(Landroid/content/Context;I)V", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "leftClickListener", "getLeftClickListener", "setLeftClickListener", "leftImageView", "Landroid/widget/ImageView;", "leftLayout", "leftLongClickListener", "", "getLeftLongClickListener", "setLeftLongClickListener", "leftTextView", "Landroid/widget/TextView;", "rightClickListener", "getRightClickListener", "setRightClickListener", "rightImageView", "rightLayout", "rightLongClickListener", "getRightLongClickListener", "setRightLongClickListener", "rightTextView", "initLeftLayout", "initRightLayout", "setLeftComponent", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "leftWording", "", "setRightComponent", "rightDrawable", "rightWording", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class BaseEntryDialogView
  extends LinearLayout
{
  @NotNull
  private View a;
  private LinearLayout b;
  private ImageView c;
  private TextView d;
  private LinearLayout e;
  private ImageView f;
  private TextView g;
  @Nullable
  private Function0<Unit> h;
  @Nullable
  private Function0<Boolean> i;
  @Nullable
  private Function0<Unit> j;
  @Nullable
  private Function0<Boolean> k;
  @Nullable
  private Function0<Unit> l;
  
  public BaseEntryDialogView(@NotNull Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt, (ViewGroup)this, true);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…ate(layoutId, this, true)");
    this.a = paramContext;
    a();
    b();
  }
  
  private final void a()
  {
    Object localObject = this.a.findViewById(R.id.x);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.ll_left)");
    this.b = ((LinearLayout)localObject);
    localObject = this.a.findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.iv_left)");
    this.c = ((ImageView)localObject);
    localObject = this.a.findViewById(R.id.H);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.tv_left)");
    this.d = ((TextView)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new BaseEntryDialogView.initLeftLayout.1(this));
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
    }
    ((LinearLayout)localObject).setOnLongClickListener((View.OnLongClickListener)new BaseEntryDialogView.initLeftLayout.2(this));
  }
  
  private final void b()
  {
    Object localObject = this.a.findViewById(R.id.y);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.ll_right)");
    this.e = ((LinearLayout)localObject);
    localObject = this.a.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.iv_right)");
    this.f = ((ImageView)localObject);
    localObject = this.a.findViewById(R.id.K);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.tv_right)");
    this.g = ((TextView)localObject);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new BaseEntryDialogView.initRightLayout.1(this));
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
    }
    ((LinearLayout)localObject).setOnLongClickListener((View.OnLongClickListener)new BaseEntryDialogView.initRightLayout.2(this));
  }
  
  @Nullable
  public final Function0<Unit> getCancelClickListener()
  {
    return this.l;
  }
  
  @NotNull
  public final View getContainerView()
  {
    return this.a;
  }
  
  @Nullable
  public final Function0<Unit> getLeftClickListener()
  {
    return this.h;
  }
  
  @Nullable
  public final Function0<Boolean> getLeftLongClickListener()
  {
    return this.i;
  }
  
  @Nullable
  public final Function0<Unit> getRightClickListener()
  {
    return this.j;
  }
  
  @Nullable
  public final Function0<Boolean> getRightLongClickListener()
  {
    return this.k;
  }
  
  public final void setCancelClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.l = paramFunction0;
  }
  
  public final void setContainerView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.a = paramView;
  }
  
  public final void setLeftClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.h = paramFunction0;
  }
  
  public final void setLeftComponent(@NotNull Drawable paramDrawable, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "leftDrawable");
    Intrinsics.checkParameterIsNotNull(paramString, "leftWording");
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
    }
    localImageView.setImageDrawable(paramDrawable);
    paramDrawable = this.d;
    if (paramDrawable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftTextView");
    }
    paramDrawable.setText((CharSequence)paramString);
  }
  
  public final void setLeftLongClickListener(@Nullable Function0<Boolean> paramFunction0)
  {
    this.i = paramFunction0;
  }
  
  public final void setRightClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.j = paramFunction0;
  }
  
  public final void setRightComponent(@NotNull Drawable paramDrawable, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "rightDrawable");
    Intrinsics.checkParameterIsNotNull(paramString, "rightWording");
    ImageView localImageView = this.f;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
    }
    localImageView.setImageDrawable(paramDrawable);
    paramDrawable = this.g;
    if (paramDrawable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
    }
    paramDrawable.setText((CharSequence)paramString);
  }
  
  public final void setRightLongClickListener(@Nullable Function0<Boolean> paramFunction0)
  {
    this.k = paramFunction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView
 * JD-Core Version:    0.7.0.1
 */