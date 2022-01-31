package com.tencent.mobileqq.startup.step;

import ajya;
import axok;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public class InitMagnifierSDKData$LeakListener$2
  implements Runnable
{
  public InitMagnifierSDKData$LeakListener$2(axok paramaxok, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajya.a(2131705784) + this.b;; str = ajya.a(2131705788))
    {
      bcql.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */