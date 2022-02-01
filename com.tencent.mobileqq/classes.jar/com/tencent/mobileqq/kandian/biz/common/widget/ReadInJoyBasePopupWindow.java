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
  private int a;
  protected Activity a;
  protected View a;
  protected FrameLayout a;
  protected ImageView a;
  protected boolean a;
  private int b;
  protected ImageView b;
  private int c;
  private int d;
  
  public ReadInJoyBasePopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    setHeight(this.jdField_b_of_type_Int);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "calculatePopupWindow, popupHeight = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  protected void a()
  {
    this.c = ((int)DeviceInfoUtil.i());
    this.d = ((int)DeviceInfoUtil.j());
    Object localObject = (LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater");
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560087, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379125));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379124));
    localObject = a((LayoutInflater)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_Int = ((int)(this.c - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298867) * 2.0F));
    setWidth(this.jdField_a_of_type_Int);
    setTouchable(true);
    setFocusable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  protected final void a(View paramView)
  {
    c();
    a(0.8F);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = this.d;
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    int j = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298867);
    int k = this.jdField_a_of_type_Int - (arrayOfInt[0] - j) - paramView.getWidth() / 2;
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "marginRight = ", Integer.valueOf(k) });
    double d1;
    double d2;
    if (i - (m + n) > this.jdField_b_of_type_Int)
    {
      d1 = k;
      d2 = this.jdField_a_of_type_Int;
      Double.isNaN(d2);
      if (d1 > d2 * 0.1D) {
        setAnimationStyle(2131755041);
      } else {
        setAnimationStyle(2131755040);
      }
      i = arrayOfInt[1] + paramView.getHeight() + ViewUtils.a(4.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
    }
    else
    {
      d1 = k;
      d2 = this.jdField_a_of_type_Int;
      Double.isNaN(d2);
      if (d1 > d2 * 0.1D) {
        setAnimationStyle(2131755044);
      } else {
        setAnimationStyle(2131755043);
      }
      i = arrayOfInt[1] - this.jdField_b_of_type_Int - ViewUtils.a(4.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
    }
    showAtLocation(paramView, 0, j, i);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "x = ", Integer.valueOf(j), ", y = ", Integer.valueOf(i), ", width = ", Integer.valueOf(this.jdField_a_of_type_Int), ", height = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void b()
  {
    setOnDismissListener(new ReadInJoyBasePopupWindow.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow
 * JD-Core Version:    0.7.0.1
 */