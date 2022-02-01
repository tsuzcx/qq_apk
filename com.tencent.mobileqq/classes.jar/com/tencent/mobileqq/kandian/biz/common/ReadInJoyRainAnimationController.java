package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.kandian.base.view.widget.RainView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyRainAnimationController
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RainView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView;
  private ReadInJoyRainAnimationController.AnimatorHandler jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController$AnimatorHandler;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ReadInJoyRainAnimationController(ViewGroup paramViewGroup, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyRainAnimationController$AnimatorHandler = new ReadInJoyRainAnimationController.AnimatorHandler(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRainAnimationController", 2, "rain animation show");
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("ReadInJoyRainAnimationController") == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView = new RainView(this.jdField_a_of_type_AndroidContentContext);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView.setTag("ReadInJoyRainAnimationController");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView.setAnimationEndListener(new ReadInJoyRainAnimationController.AnimationEndListenerImp(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView.a(this.jdField_a_of_type_AndroidViewViewGroup.getWidth(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getBottom(), paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("ReadInJoyRainAnimationController") != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRainAnimationController", 2, "rain animation hide");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView.n();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyRainAnimationController
 * JD-Core Version:    0.7.0.1
 */