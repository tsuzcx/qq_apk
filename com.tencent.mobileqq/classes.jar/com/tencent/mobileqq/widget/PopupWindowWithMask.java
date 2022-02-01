package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

public class PopupWindowWithMask
  extends PopupWindow
{
  protected Context a;
  private WindowManager b;
  private View c;
  
  public PopupWindowWithMask(Context paramContext)
  {
    super(paramContext, null, 2131953435);
    this.a = paramContext;
    this.b = ((WindowManager)paramContext.getSystemService("window"));
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  private void a()
  {
    if (this.c != null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new PopupWindowWithMask.3(this));
      localValueAnimator.addListener(new PopupWindowWithMask.4(this));
      localValueAnimator.start();
    }
  }
  
  private void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    this.c = new View(this.a);
    this.c.setBackgroundColor(855638016);
    this.c.setFitsSystemWindows(false);
    this.c.setOnKeyListener(new PopupWindowWithMask.1(this));
    this.b.addView(this.c, localLayoutParams);
    paramIBinder = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramIBinder.setDuration(400L);
    paramIBinder.addUpdateListener(new PopupWindowWithMask.2(this));
    paramIBinder.start();
  }
  
  public void dismiss()
  {
    a();
    super.dismiss();
  }
  
  public void showAsDropDown(View paramView)
  {
    a(paramView.getWindowToken());
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView.getWindowToken());
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView.getWindowToken());
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PopupWindowWithMask
 * JD-Core Version:    0.7.0.1
 */