package com.tencent.mobileqq.qqfeatureswitch.fragment;

import java.util.List;

public class SwitchManageController
{
  private SwitchManageController.ISwitchManageView jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController$ISwitchManageView;
  private SwitchManageModel jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageModel;
  
  public SwitchManageController(SwitchManageController.ISwitchManageView paramISwitchManageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController$ISwitchManageView = paramISwitchManageView;
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageModel = new SwitchManageModel(this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController$ISwitchManageView.a());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageModel.a();
    b();
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageModel.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController$ISwitchManageView.a(paramString);
  }
  
  public void b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageModel.a();
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController$ISwitchManageView.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageController
 * JD-Core Version:    0.7.0.1
 */