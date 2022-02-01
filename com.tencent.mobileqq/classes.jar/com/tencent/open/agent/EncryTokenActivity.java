package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class EncryTokenActivity
  extends Activity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    MobileQQ.sMobileQQ.addOtherTypeActivity(this);
    super.onCreate(paramBundle);
    try
    {
      paramBundle = super.getIntent();
      if (paramBundle != null) {
        paramBundle = paramBundle.getStringExtra("key_action");
      }
    }
    catch (Exception paramBundle)
    {
      label31:
      Object localObject;
      break label31;
    }
    paramBundle = "";
    AuthReporter.a(paramBundle, 0L);
    if ("action_check_token".equals(paramBundle))
    {
      localObject = OpensdkPreference.a(this, "openid_encrytoken");
      try
      {
        paramBundle = new StringBuilder();
        paramBundle.append(super.getIntent().getStringExtra("openid"));
        paramBundle.append("");
        paramBundle = paramBundle.toString();
        String str = super.getIntent().getStringExtra("access_token");
        localObject = ((SharedPreferences)localObject).getString(paramBundle, "");
        Intent localIntent = new Intent();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("openid", paramBundle);
        localJSONObject.put("access_token", str);
        localJSONObject.put("encry_token", localObject);
        localIntent.putExtra("key_response", localJSONObject.toString());
        super.setResult(-1, localIntent);
        super.finish();
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_response", "");
    super.setResult(-1, paramBundle);
    super.finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    MobileQQ.sMobileQQ.removeOtherTypeActivity(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.EncryTokenActivity
 * JD-Core Version:    0.7.0.1
 */