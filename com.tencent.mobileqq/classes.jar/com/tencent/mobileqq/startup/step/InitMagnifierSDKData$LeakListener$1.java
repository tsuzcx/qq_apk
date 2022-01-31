package com.tencent.mobileqq.startup.step;

import alud;
import azoe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class InitMagnifierSDKData$LeakListener$1
  implements Runnable
{
  public InitMagnifierSDKData$LeakListener$1(azoe paramazoe, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.sApplication, this.a + alud.a(2131706177), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.1
 * JD-Core Version:    0.7.0.1
 */