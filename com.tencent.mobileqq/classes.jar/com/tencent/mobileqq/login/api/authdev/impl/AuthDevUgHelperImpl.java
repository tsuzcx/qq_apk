package com.tencent.mobileqq.login.api.authdev.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.login.api.authdev.IAuthDevUgHelper;

public class AuthDevUgHelperImpl
  implements IAuthDevUgHelper
{
  public void notifyPhoneChanged(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.broadcast.action.authdev.phonechange");
    localIntent.setPackage(paramActivity.getPackageName());
    localIntent.putExtra("PhoneNum", paramString1);
    localIntent.putExtra("PhoneCountryCode", paramString2);
    paramActivity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.login.api.authdev.impl.AuthDevUgHelperImpl
 * JD-Core Version:    0.7.0.1
 */