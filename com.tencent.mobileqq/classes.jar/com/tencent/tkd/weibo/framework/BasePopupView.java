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
  public static final BasePopupView.Companion b = new BasePopupView.Companion(null);
  @Nullable
  private Function2<? super BEAN, ? super Bundle, Unit> a;
  private Bundle c;
  private final ViewGroup d;
  private HashMap e;
  
  public BasePopupView(@NotNull ViewGroup paramViewGroup, @Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramViewGroup;
    setOnClickListener((View.OnClickListener)BasePopupView.1.a);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }
  
  public View a(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@Nullable Bundle paramBundle)
  {
    this.c = paramBundle;
    paramBundle = (Animation)new TranslateAnimation(0.0F, 0.0F, this.d.getHeight(), 0.0F);
    paramBundle.setDuration(200L);
    paramBundle.setFillEnabled(true);
    paramBundle.setFillAfter(true);
    setAnimation(paramBundle);
    paramBundle.startNow();
    this.d.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public final void a(@Nullable BEAN paramBEAN)
  {
    Object localObject = (Animation)new TranslateAnimation(0.0F, 0.0F, 0.0F, this.d.getHeight());
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillAfter(true);
    setAnimation((Animation)localObject);
    ((Animation)localObject).startNow();
    localObject = this.a;
    if (localObject != null) {
      paramBEAN = (Unit)((Function2)localObject).invoke(paramBEAN, this.c);
    }
    this.d.removeView((View)this);
  }
  
  public final int b(int paramInt)
  {
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localContext.getResources().getColor(paramInt);
  }
  
  @Nullable
  public final Function2<BEAN, Bundle, Unit> getDismissListener()
  {
    return this.a;
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
    this.a = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.BasePopupView
 * JD-Core Version:    0.7.0.1
 */