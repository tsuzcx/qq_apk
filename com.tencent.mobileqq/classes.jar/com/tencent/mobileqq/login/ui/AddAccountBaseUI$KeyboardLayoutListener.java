package com.tencent.mobileqq.login.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class AddAccountBaseUI$KeyboardLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  RelativeLayout a;
  RelativeLayout b;
  int c;
  int d;
  int e;
  int f;
  int g;
  float h;
  float i;
  float j;
  View k;
  View l;
  View m;
  
  public AddAccountBaseUI$KeyboardLayoutListener(AddAccountBaseUI paramAddAccountBaseUI)
  {
    this.b = ((RelativeLayout)paramAddAccountBaseUI.b(2131436934));
    this.a = ((RelativeLayout)paramAddAccountBaseUI.b(2131439602));
    this.k = paramAddAccountBaseUI.b(2131427779);
    this.l = paramAddAccountBaseUI.b(2131427417);
    this.m = paramAddAccountBaseUI.b(2131439600);
    this.c = ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).bottomMargin;
    this.d = (this.b.getHeight() - paramAddAccountBaseUI.i.getHeight());
    this.e = AddAccountBaseUI.b(paramAddAccountBaseUI).getDimensionPixelOffset(2131299067);
    this.f = AddAccountBaseUI.b(paramAddAccountBaseUI).getDimensionPixelOffset(2131299066);
    this.g = AddAccountBaseUI.b(paramAddAccountBaseUI).getDimensionPixelOffset(2131299062);
    int i1 = this.e;
    int i2 = this.f;
    int i3 = this.g;
    float f1 = i1 + i2 + i3;
    this.h = (i1 / f1);
    this.i = (i2 / f1);
    this.j = (i3 / f1);
  }
  
  void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
      if (localMarginLayoutParams.topMargin != paramInt)
      {
        localMarginLayoutParams.topMargin = paramInt;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.getWindowVisibleDisplayFrame((Rect)localObject);
    int i1 = ((Rect)localObject).height();
    int i2 = this.a.getHeight();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGlobalLayout: rootHeight=");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(", visibleHeight=");
    ((StringBuilder)localObject).append(i1);
    QLog.d("AddAccountBaseUI", 1, ((StringBuilder)localObject).toString());
    if ((i1 == AddAccountBaseUI.c(this.n)) && (i2 == AddAccountBaseUI.d(this.n)))
    {
      QLog.d("AddAccountBaseUI", 1, "onGlobalLayout: doesn't changed, return.");
      return;
    }
    if (i2 != AddAccountBaseUI.d(this.n)) {
      this.d = (this.b.getHeight() - this.n.i.getHeight());
    }
    int i3 = i2 - i1;
    AddAccountBaseUI.a(this.n, i1);
    AddAccountBaseUI.b(this.n, i2);
    if (i3 > ViewUtils.dip2px(100.0F))
    {
      i1 = i3 - this.c + ViewUtils.dip2px(20.0F);
      i2 = Math.min(Math.max(i1, 0), this.d);
      i3 = i1 - this.d - ViewUtils.dip2px(4.0F);
      i1 = i2;
      if (i3 > 0)
      {
        float f1 = i3;
        i1 = (int)Math.min(this.i * f1, this.f);
        int i4 = (int)Math.min(f1 * this.j, this.g);
        i3 = Math.min(i3 - i1 - i4, this.e);
        a(this.k, this.e - i3);
        a(this.l, this.f - i1);
        a(this.m, this.g - i4);
        i1 = i2 + (i1 + i4 + i3);
      }
      this.n.c(i1);
      return;
    }
    this.n.c(0);
    a(this.k, this.e);
    a(this.l, this.f);
    a(this.m, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.KeyboardLayoutListener
 * JD-Core Version:    0.7.0.1
 */