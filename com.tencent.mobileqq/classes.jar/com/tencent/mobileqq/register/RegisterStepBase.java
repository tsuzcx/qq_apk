package com.tencent.mobileqq.register;

import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import mqq.app.AppRuntime;

public abstract class RegisterStepBase
{
  protected RegisterNewBaseActivity a;
  protected AppRuntime a;
  
  protected RegisterStepBase(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterStepBase
 * JD-Core Version:    0.7.0.1
 */