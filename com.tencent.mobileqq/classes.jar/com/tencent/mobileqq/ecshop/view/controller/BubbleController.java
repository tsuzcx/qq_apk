package com.tencent.mobileqq.ecshop.view.controller;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/BubbleController;", "", "view", "Landroid/view/View;", "onClickListener", "Landroid/view/View$OnClickListener;", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "bubbleWindow", "Landroid/widget/PopupWindow;", "getBubbleWindow", "()Landroid/widget/PopupWindow;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "onDestroy", "", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class BubbleController
{
  @NotNull
  private final Handler a = new Handler(Looper.getMainLooper());
  @NotNull
  private final PopupWindow b;
  
  public BubbleController(@NotNull View paramView, @NotNull View.OnClickListener paramOnClickListener)
  {
    View localView = LayoutInflater.from(paramView.getContext()).inflate(2131628306, null);
    TextView localTextView = new TextView(paramView.getContext());
    localTextView.setText((CharSequence)"新的物流通知");
    localTextView.setTextColor(-16777216);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout)localView.findViewById(2131437520)).addView((View)localTextView, (ViewGroup.LayoutParams)localLayoutParams);
    this.b = new PopupWindow(localView, ViewUtils.dip2px(109.0F), ViewUtils.dip2px(47.0F));
    this.b.setOutsideTouchable(false);
    this.b.showAsDropDown(paramView, paramView.getWidth() / 2 - ViewUtils.dip2px(156.0F) / 2, ViewUtils.dip2px(10.0F));
    localView.setOnClickListener((View.OnClickListener)new BubbleController.1(paramOnClickListener, localView));
    this.a.postDelayed((Runnable)new BubbleController.2(this), 5000L);
  }
  
  @NotNull
  public final PopupWindow a()
  {
    return this.b;
  }
  
  public final void b()
  {
    this.b.dismiss();
    this.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.BubbleController
 * JD-Core Version:    0.7.0.1
 */