package com.tencent.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import bjum;
import com.tencent.qphone.base.util.QLog;

public class TipsPopupWindow
  extends PopupWindow
  implements bjum
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TipsLinearLayout jdField_a_of_type_ComTencentWidgetTipsLinearLayout;
  private TipsPopupWindow.DismissRunnable jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private void c()
  {
    if (this.c) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable, 1000L);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.d)) {
      return;
    }
    this.d = true;
    e();
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.a();
      this.c = true;
      this.d = false;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable);
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b) {
      ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    }
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.b();
  }
  
  public void a()
  {
    if (this.b) {
      ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
    this.c = false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.post(new TipsPopupWindow.2(this));
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsPopupWindow", 2, "dismiss");
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(this.jdField_a_of_type_ComTencentWidgetTipsPopupWindow$DismissRunnable, 300L);
  }
  
  public void showAsDropDown(View paramView)
  {
    super.showAsDropDown(paramView);
    d();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    d();
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.TipsPopupWindow
 * JD-Core Version:    0.7.0.1
 */