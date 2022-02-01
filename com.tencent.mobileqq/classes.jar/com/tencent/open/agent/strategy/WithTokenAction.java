package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.settings.OpensdkPreference;

abstract class WithTokenAction
  extends BaseAction
{
  public WithTokenAction(String paramString)
  {
    super(paramString);
  }
  
  protected void a(Intent paramIntent, Activity paramActivity, Bundle paramBundle)
  {
    AuthReporter.a(this.a, 0L);
    String str = paramBundle.getString("hopenid");
    paramBundle.putString("encrytoken", OpensdkPreference.a(paramActivity, "openid_encrytoken").getString(str, ""));
    super.a(paramIntent, paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.WithTokenAction
 * JD-Core Version:    0.7.0.1
 */