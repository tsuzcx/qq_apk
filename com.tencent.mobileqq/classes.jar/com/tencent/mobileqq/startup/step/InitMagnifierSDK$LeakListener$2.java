package com.tencent.mobileqq.startup.step;

import ajjy;
import awok;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

public class InitMagnifierSDK$LeakListener$2
  implements Runnable
{
  public InitMagnifierSDK$LeakListener$2(awok paramawok, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = ajjy.a(2131639993) + this.b;; str = ajjy.a(2131639996))
    {
      bbmy.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK.LeakListener.2
 * JD-Core Version:    0.7.0.1
 */