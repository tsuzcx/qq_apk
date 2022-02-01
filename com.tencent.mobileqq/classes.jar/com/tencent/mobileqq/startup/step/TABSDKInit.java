package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.app.automator.AsyncStep;
import mqq.app.AppRuntime;

public class TABSDKInit
  extends AsyncStep
{
  public int a()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ABTestController.a(BaseApplicationImpl.sApplication, str);
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.TABSDKInit
 * JD-Core Version:    0.7.0.1
 */