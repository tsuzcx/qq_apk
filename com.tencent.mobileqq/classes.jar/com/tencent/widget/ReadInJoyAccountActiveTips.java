package com.tencent.widget;

import alnw;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyAccountActiveTips
  extends PopupWindow
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  
  public ReadInJoyAccountActiveTips(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ((int)DeviceInfoUtil.j());
    this.jdField_b_of_type_Int = ((int)DeviceInfoUtil.k());
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2130969532, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366847));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366846);
    setHeight(-2);
    setWidth(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(true);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new alnw(this));
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.c = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    this.d = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyAccountActiveTips", 2, "DeviceInfoUtil.getWidth() = " + this.jdField_a_of_type_Int + ", DeviceInfoUtil.getHeight() = " + this.jdField_b_of_type_Int);
      QLog.d("ReadInJoyAccountActiveTips", 2, "popupWidth = " + this.c + ", popupHeight = " + this.d);
      QLog.d("ReadInJoyAccountActiveTips", 2, "x = " + arrayOfInt[0] + ", y = " + arrayOfInt[1]);
      QLog.d("ReadInJoyAccountActiveTips", 2, "parent.getWidth() = " + paramView.getWidth() + ", parent.getHeight() = " + paramView.getHeight());
    }
    int i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559669);
    int j;
    int k;
    if (this.jdField_a_of_type_Int - arrayOfInt[0] > i)
    {
      j = arrayOfInt[0] + paramView.getWidth() / 2 - this.c / 2;
      i = arrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 5 + AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      k = this.c / 2 - AIOUtils.a(12.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) / 2;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAccountActiveTips", 2, "marginLeft = " + k);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAccountActiveTips", 2, "show x = " + j + ", show y = " + i);
      }
      showAtLocation(paramView, 0, j, i);
      return;
      j = this.jdField_a_of_type_Int - this.c - (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559685);
      i = arrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 5 + AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      k = arrayOfInt[0] + paramView.getWidth() / 2 - j - AIOUtils.a(12.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) / 2;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAccountActiveTips", 2, "marginLeft = " + k);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.ReadInJoyAccountActiveTips
 * JD-Core Version:    0.7.0.1
 */