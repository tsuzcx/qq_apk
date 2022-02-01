package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import java.util.List;
import mqq.app.AppRuntime;

public class CleanRedPointUIComponent
{
  private View jdField_a_of_type_AndroidViewView;
  private OnHandleClickEvent jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent;
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private String b;
  
  public CleanRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime = paramRedPointUIData.jdField_a_of_type_MqqAppAppRuntime;
      this.jdField_a_of_type_JavaLangString = paramRedPointUIData.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramRedPointUIData.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent = paramRedPointUIData.jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent;
      this.jdField_a_of_type_AndroidViewView = paramRedPointUIData.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_JavaUtilList = paramRedPointUIData.jdField_b_of_type_JavaUtilList;
    }
    b();
  }
  
  private void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(new CleanRedPointUIComponent.1(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */