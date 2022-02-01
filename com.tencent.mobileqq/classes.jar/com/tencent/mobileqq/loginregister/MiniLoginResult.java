package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import mqq.app.AppRuntime;

public class MiniLoginResult
  extends BaseLoginResult
{
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    MiniAppSecurityUtil.doClearAfterLoginSuccess(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.MiniLoginResult
 * JD-Core Version:    0.7.0.1
 */