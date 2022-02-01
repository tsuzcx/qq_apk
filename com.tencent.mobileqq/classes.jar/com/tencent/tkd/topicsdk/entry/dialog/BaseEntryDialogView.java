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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/dialog/BaseEntryDialogView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelClickListener", "Lkotlin/Function0;", "", "getCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "leftClickListener", "getLeftClickListener", "setLeftClickListener", "leftImageView", "Landroid/widget/ImageView;", "leftLayout", "leftLongClickListener", "", "getLeftLongClickListener", "setLeftLongClickListener", "leftTextView", "Landroid/widget/TextView;", "rightClickListener", "getRightClickListener", "setRightClickListener", "rightImageView", "rightLayout", "rightLongClickListener", "getRightLongClickListener", "setRightLongClickListener", "rightTextView", "doOnCreate", "getLayoutId", "", "initLeftLayout", "initRightLayout", "setLeftComponent", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "leftWording", "", "setRightComponent", "rightDrawable", "rightWording", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class BaseEntryDialogView
  extends LinearLayout
{
  @NotNull
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private Function0<Boolean> jdField_b_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function0<Unit> c;
  @Nullable
  private Function0<Boolean> d;
  @Nullable
  private Function0<Unit> e;
  
  public BaseEntryDialogView(@NotNull Context paramContext)
  {
    super(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(a(), (ViewGroup)this, true);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…etLayoutId(), this, true)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    b();
    c();
    a();
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.v);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.ll_left)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.iv_left)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.F);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.tv_left)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new BaseEntryDialogView.initLeftLayout.1(this));
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftLayout");
    }
    ((LinearLayout)localObject).setOnLongClickListener((View.OnLongClickListener)new BaseEntryDialogView.initLeftLayout.2(this));
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.w);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.ll_right)");
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.m);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.iv_right)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.G);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.findViewById(R.id.tv_right)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
    }
    ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new BaseEntryDialogView.initRightLayout.1(this));
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightLayout");
    }
    ((LinearLayout)localObject).setOnLongClickListener((View.OnLongClickListener)new BaseEntryDialogView.initRightLayout.2(this));
  }
  
  public int a()
  {
    return -1;
  }
  
  @NotNull
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  public void a() {}
  
  @Nullable
  public final Function0<Boolean> b()
  {
    return this.jdField_b_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function0<Unit> c()
  {
    return this.c;
  }
  
  @Nullable
  public final Function0<Boolean> d()
  {
    return this.d;
  }
  
  @Nullable
  public final Function0<Unit> e()
  {
    return this.e;
  }
  
  public final void setCancelClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.e = paramFunction0;
  }
  
  public final void setContainerView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<set-?>");
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public final void setLeftClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setLeftComponent(@NotNull Drawable paramDrawable, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "leftDrawable");
    Intrinsics.checkParameterIsNotNull(paramString, "leftWording");
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftImageView");
    }
    localImageView.setImageDrawable(paramDrawable);
    paramDrawable = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramDrawable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftTextView");
    }
    paramDrawable.setText((CharSequence)paramString);
  }
  
  public final void setLeftLongClickListener(@Nullable Function0<Boolean> paramFunction0)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setRightClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.c = paramFunction0;
  }
  
  public final void setRightComponent(@NotNull Drawable paramDrawable, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "rightDrawable");
    Intrinsics.checkParameterIsNotNull(paramString, "rightWording");
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
    }
    localImageView.setImageDrawable(paramDrawable);
    paramDrawable = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramDrawable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
    }
    paramDrawable.setText((CharSequence)paramString);
  }
  
  public final void setRightLongClickListener(@Nullable Function0<Boolean> paramFunction0)
  {
    this.d = paramFunction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView
 * JD-Core Version:    0.7.0.1
 */