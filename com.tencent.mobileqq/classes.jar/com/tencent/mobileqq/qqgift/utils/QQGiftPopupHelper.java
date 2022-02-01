package com.tencent.mobileqq.qqgift.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class QQGiftPopupHelper
{
  private View a;
  private PopupWindow b;
  private Context c;
  private PopupWindow.OnDismissListener d;
  private boolean e = true;
  private boolean f = true;
  private int g = -1;
  private int h = -2;
  private PopupWindow.OnDismissListener i = new QQGiftPopupHelper.1(this);
  
  public QQGiftPopupHelper(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramView;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setOutsideTouchable(true);
      this.b.setFocusable(true);
      return;
    }
    this.b.setOutsideTouchable(false);
    this.b.setFocusable(false);
  }
  
  public void a()
  {
    this.b = new PopupWindow(this.a, this.g, this.h);
    this.b.setOnDismissListener(this.i);
    this.b.setBackgroundDrawable(new ColorDrawable(0));
    b(this.f);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.c).getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    ((Activity)this.c).getWindow().setAttributes(localLayoutParams);
    if (paramBoolean)
    {
      ((Activity)this.c).getWindow().addFlags(2);
      return;
    }
    ((Activity)this.c).getWindow().clearFlags(2);
  }
  
  public void a(View paramView)
  {
    a();
    if (this.e) {
      a(0.7F, true);
    }
    this.b.setAnimationStyle(2131951647);
    this.b.showAtLocation(paramView, 83, 0, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftPopupHelper
 * JD-Core Version:    0.7.0.1
 */