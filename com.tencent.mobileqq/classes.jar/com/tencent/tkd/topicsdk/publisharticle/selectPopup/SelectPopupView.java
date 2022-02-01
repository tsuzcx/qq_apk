package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupView;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeView", "Landroid/widget/ImageView;", "containerView", "Landroid/view/View;", "value", "", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countLimitView", "Landroid/widget/TextView;", "Lkotlin/Function0;", "", "onCloseClickListener", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onLayoutClickListener", "getOnLayoutClickListener", "setOnLayoutClickListener", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleView", "wording", "getWording", "setWording", "wordingView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupView
  extends PopupWindow
{
  private int jdField_a_of_type_Int = 12;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_b_of_type_JavaLangString = "";
  @Nullable
  private Function0<Unit> jdField_b_of_type_KotlinJvmFunctionsFunction0;
  private TextView c;
  
  public SelectPopupView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.layout.F, null, false);
    View localView = paramAttributeSet.findViewById(R.id.bi);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(R.id.bm);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_wording)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramAttributeSet.findViewById(R.id.V);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.iv_cancel)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(R.id.aW);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_count_limit)");
    this.c = ((TextView)localView);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(cont…_limit)\n                }");
    this.jdField_a_of_type_AndroidViewView = paramAttributeSet;
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setWidth(DisplayUtils.a.a(paramContext, 254.0F));
    setHeight(-2);
    if (Build.VERSION.SDK_INT >= 21) {
      setElevation(10.0F);
    }
    setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetTextView.addTextChangedListener((TextWatcher)new SelectPopupView.2(this));
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramString);
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)new SelectPopupView.onCloseClickListener.1(paramFunction0));
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramString);
  }
  
  public final void b(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new SelectPopupView.onLayoutClickListener.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupView
 * JD-Core Version:    0.7.0.1
 */