package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;

public class PatternLockResult
  extends BaseLoginResult
{
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString)
  {
    PatternLockUtils.setFirstEnterAfterLoginState(paramActivity, paramString, true);
  }
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    PatternLockUtils.setFirstEnterAfterLoginState(paramActivity, paramAppRuntime.getAccount(), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.PatternLockResult
 * JD-Core Version:    0.7.0.1
 */