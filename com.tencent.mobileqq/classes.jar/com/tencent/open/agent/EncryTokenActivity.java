package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bcjl;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONObject;

public class EncryTokenActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    BaseApplicationImpl.getApplication().addOtherTypeActivity(this);
    super.onCreate(paramBundle);
    str = "";
    try
    {
      localObject = super.getIntent();
      paramBundle = str;
      if (localObject != null) {
        paramBundle = ((Intent)localObject).getStringExtra("key_action");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        paramBundle = str;
      }
    }
    if ("action_check_token".equals(paramBundle))
    {
      localObject = bcjl.a(this, "openid_encrytoken");
      try
      {
        paramBundle = super.getIntent().getStringExtra("openid") + "";
        str = super.getIntent().getStringExtra("access_token");
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
    BaseApplicationImpl.getApplication().removeOtherTypeActivity(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.EncryTokenActivity
 * JD-Core Version:    0.7.0.1
 */