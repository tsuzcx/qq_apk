package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class ReadInJoyBasePopupWindow
  extends PopupWindow
{
  protected Activity a;
  protected View b;
  protected FrameLayout c;
  protected ImageView d;
  protected ImageView e;
  protected boolean f = false;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public ReadInJoyBasePopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
  }
  
  private void c()
  {
    this.b.measure(0, 0);
    this.h = this.b.getMeasuredHeight();
    setHeight(this.h);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "calculatePopupWindow, popupHeight = ", Integer.valueOf(this.h) });
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  protected void a()
  {
    this.i = ((int)DeviceInfoUtil.D());
    this.j = ((int)DeviceInfoUtil.E());
    Object localObject = (LayoutInflater)this.a.getSystemService("layout_inflater");
    this.b = ((LayoutInflater)localObject).inflate(2131626134, null);
    this.c = ((FrameLayout)this.b.findViewById(2131431322));
    this.d = ((ImageView)this.b.findViewById(2131447861));
    this.e = ((ImageView)this.b.findViewById(2131447860));
    localObject = a((LayoutInflater)localObject);
    if (localObject != null) {
      this.c.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    this.g = ((int)(this.i - this.a.getResources().getDimension(2131299584) * 2.0F));
    setWidth(this.g);
    setTouchable(true);
    setFocusable(true);
    setContentView(this.b);
    b();
    this.f = true;
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.a.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.a.getWindow().setAttributes(localLayoutParams);
  }
  
  protected final void a(View paramView)
  {
    c();
    a(0.8F);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int k = this.j;
    int i1 = arrayOfInt[1];
    int i2 = paramView.getHeight();
    int m = (int)this.a.getResources().getDimension(2131299584);
    int n = this.g - (arrayOfInt[0] - m) - paramView.getWidth() / 2;
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "marginRight = ", Integer.valueOf(n) });
    double d1;
    double d2;
    if (k - (i1 + i2) > this.h)
    {
      d1 = n;
      d2 = this.g;
      Double.isNaN(d2);
      if (d1 > d2 * 0.1D) {
        setAnimationStyle(2131951657);
      } else {
        setAnimationStyle(2131951656);
      }
      k = arrayOfInt[1] + paramView.getHeight() + ViewUtils.dip2px(4.0F);
      this.d.setVisibility(0);
      this.e.setVisibility(4);
      this.d.setPadding(0, 0, n, 0);
    }
    else
    {
      d1 = n;
      d2 = this.g;
      Double.isNaN(d2);
      if (d1 > d2 * 0.1D) {
        setAnimationStyle(2131951660);
      } else {
        setAnimationStyle(2131951659);
      }
      k = arrayOfInt[1] - this.h - ViewUtils.dip2px(4.0F);
      this.d.setVisibility(4);
      this.e.setVisibility(0);
      this.e.setPadding(0, 0, n, 0);
    }
    showAtLocation(paramView, 0, m, k);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "x = ", Integer.valueOf(m), ", y = ", Integer.valueOf(k), ", width = ", Integer.valueOf(this.g), ", height = ", Integer.valueOf(this.h) });
  }
  
  public void b()
  {
    setOnDismissListener(new ReadInJoyBasePopupWindow.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow
 * JD-Core Version:    0.7.0.1
 */