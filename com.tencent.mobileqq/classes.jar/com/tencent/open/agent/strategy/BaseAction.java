package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.business.base.Constants;

abstract class BaseAction
  implements IAgentAction
{
  protected String a;
  
  public BaseAction(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(Activity paramActivity)
  {
    Bundle localBundle = AuthParamUtil.a(paramActivity.getIntent(), "key_params");
    if (a(paramActivity, localBundle)) {
      a(paramActivity, localBundle);
    }
  }
  
  protected void a(Activity paramActivity, int paramInt)
  {
    SSOLog.b("BaseAction", new Object[] { "setResult action=", this.a, ", error=", Integer.valueOf(paramInt) });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", Constants.c);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    paramActivity.setResult(-1, localIntent);
    paramActivity.finish();
  }
  
  protected abstract void a(Activity paramActivity, Bundle paramBundle);
  
  protected void a(Intent paramIntent, Activity paramActivity, Bundle paramBundle)
  {
    paramIntent.putExtra("key_action", this.a);
    paramIntent.putExtra("key_params", paramBundle);
    try
    {
      paramActivity.startActivityForResult(paramIntent, 0);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      SSOLog.c("BaseAction", "ActivityNotFoundException", paramIntent);
      a(paramActivity, -6);
    }
  }
  
  protected boolean a(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      a(paramActivity, -5);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.BaseAction
 * JD-Core Version:    0.7.0.1
 */