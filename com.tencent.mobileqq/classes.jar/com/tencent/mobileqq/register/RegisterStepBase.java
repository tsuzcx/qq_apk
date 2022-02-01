package com.tencent.mobileqq.register;

import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import mqq.app.AppRuntime;

public abstract class RegisterStepBase
{
  protected AppRuntime g;
  protected RegisterNewBaseActivity h;
  
  protected RegisterStepBase(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    this.h = paramRegisterNewBaseActivity;
    this.g = this.h.getAppRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.RegisterStepBase
 * JD-Core Version:    0.7.0.1
 */