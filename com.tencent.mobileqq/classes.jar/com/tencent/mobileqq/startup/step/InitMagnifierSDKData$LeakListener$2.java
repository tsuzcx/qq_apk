package com.tencent.mobileqq.startup.step;

import ajjy;
import awol;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

public class InitMagnifierSDKData$LeakListener$2
  implements Runnable
{
  public InitMagnifierSDKData$LeakListener$2(awol paramawol, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajjy.a(2131639988) + this.b;; str = ajjy.a(2131639992))
    {
      bbmy.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */