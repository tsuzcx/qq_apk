package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.settings.OpensdkPreference;
import org.json.JSONException;
import org.json.JSONObject;

public class EncryTokenActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    BaseApplicationImpl.getApplication().addOtherTypeActivity(this);
    super.onCreate(paramBundle);
    str1 = "";
    try
    {
      localObject = super.getIntent();
      paramBundle = str1;
      if (localObject != null) {
        paramBundle = ((Intent)localObject).getStringExtra("key_action");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        String str2;
        JSONObject localJSONObject;
        paramBundle = str1;
      }
    }
    if ("action_check_token".equals(paramBundle))
    {
      localObject = OpensdkPreference.a(this, "openid_encrytoken");
      paramBundle = super.getIntent().getStringExtra("openid") + "";
      str1 = super.getIntent().getStringExtra("access_token");
      str2 = ((SharedPreferences)localObject).getString(paramBundle, "");
      localObject = new Intent();
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("openid", paramBundle);
        localJSONObject.put("access_token", str1);
        localJSONObject.put("encry_token", str2);
        ((Intent)localObject).putExtra("key_response", localJSONObject.toString());
        super.setResult(-1, (Intent)localObject);
        super.finish();
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
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