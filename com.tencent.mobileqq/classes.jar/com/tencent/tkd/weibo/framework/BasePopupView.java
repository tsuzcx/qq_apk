package com.tencent.tkd.weibo.framework;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/BasePopupView;", "BEAN", "Landroid/widget/LinearLayout;", "parentView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/ViewGroup;Landroid/content/Context;Landroid/util/AttributeSet;)V", "bundle", "Landroid/os/Bundle;", "dismissListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bean", "", "getDismissListener", "()Lkotlin/jvm/functions/Function2;", "setDismissListener", "(Lkotlin/jvm/functions/Function2;)V", "dismissWithAnimation", "(Ljava/lang/Object;)V", "getColor", "", "colorId", "getColor$tkd_weibo_component_release", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "showWithAnimation", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public abstract class BasePopupView<BEAN>
  extends LinearLayout
{
  public static final BasePopupView.Companion a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  @Nullable
  private Function2<? super BEAN, ? super Bundle, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboFrameworkBasePopupView$Companion = new BasePopupView.Companion(null);
  }
  
  public BasePopupView(@NotNull ViewGroup paramViewGroup, @Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    setOnClickListener((View.OnClickListener)BasePopupView.1.a);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }
  
  public final int a(int paramInt)
  {
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getColor(paramInt);
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramBundle = (Animation)new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewViewGroup.getHeight(), 0.0F);
    paramBundle.setDuration(200L);
    paramBundle.setFillEnabled(true);
    paramBundle.setFillAfter(true);
    setAnimation(paramBundle);
    paramBundle.startNow();
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public final void a(@Nullable BEAN paramBEAN)
  {
    Object localObject = (Animation)new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillAfter(true);
    setAnimation((Animation)localObject);
    ((Animation)localObject).startNow();
    localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localObject != null) {
      paramBEAN = (Unit)((Function2)localObject).invoke(paramBEAN, this.jdField_a_of_type_AndroidOsBundle);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)this);
  }
  
  public boolean onKeyDown(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    if ((paramInt != 4) && (paramInt != 111)) {
      return false;
    }
    a(null);
    return true;
  }
  
  public final void setDismissListener(@Nullable Function2<? super BEAN, ? super Bundle, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.BasePopupView
 * JD-Core Version:    0.7.0.1
 */