package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class CleanRedPointUIComponent
{
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnHandleClickEvent jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent;
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public CleanRedPointUIComponent(RedPointUIData paramRedPointUIData)
  {
    if (paramRedPointUIData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramRedPointUIData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new CleanRedPointUIComponent.1(this));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent
 * JD-Core Version:    0.7.0.1
 */