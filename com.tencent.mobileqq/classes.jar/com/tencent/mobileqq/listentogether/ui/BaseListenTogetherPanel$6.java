package com.tencent.mobileqq.listentogether.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import avca;
import avce;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class BaseListenTogetherPanel$6
  implements Runnable
{
  public BaseListenTogetherPanel$6(avca paramavca) {}
  
  public void run()
  {
    try
    {
      View localView = ((LayoutInflater)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("layout_inflater")).inflate(2131560924, this.this$0.jdField_a_of_type_AndroidViewViewGroup, false);
      localView.measure(0, 0);
      this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView);
      this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      localView.setOnClickListener(new avce(this));
      if (this.this$0.jdField_a_of_type_AndroidViewViewGroup != null) {}
      for (int i = this.this$0.jdField_a_of_type_AndroidViewViewGroup.getWidth();; i = ViewUtils.getScreenWidth())
      {
        int j = localView.getMeasuredWidth();
        int k = ViewUtils.dip2px(52.0F);
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout, i - j - k, 0);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BaseListenTogetherPanel", 1, "showGuide exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6
 * JD-Core Version:    0.7.0.1
 */