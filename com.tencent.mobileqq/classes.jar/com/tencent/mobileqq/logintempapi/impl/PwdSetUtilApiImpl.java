package com.tencent.mobileqq.logintempapi.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PwdSetUtilApiImpl
  implements IPwdSetUtilApi
{
  public boolean checkHasNotSetPwd(Activity paramActivity)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return PwdSetUtil.a((AppInterface)localAppRuntime, paramActivity);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.logintempapi.impl.PwdSetUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */