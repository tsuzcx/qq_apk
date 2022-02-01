package com.tencent.mobileqq.nearby.profilecard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

class ProfileQiqiLiveController$1
  extends AsyncTask<Integer, Void, Bundle>
{
  ProfileQiqiLiveController$1(ProfileQiqiLiveController paramProfileQiqiLiveController) {}
  
  protected Bundle a(Integer... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("downloadcode", paramVarArgs[0].intValue());
    try
    {
      paramVarArgs = (HttpURLConnection)new URL("https://tiantian.qq.com/qiqimanage/qunpack/android/58.json").openConnection();
      paramVarArgs.setConnectTimeout(5000);
      paramVarArgs.setReadTimeout(30000);
      paramVarArgs.setRequestMethod("GET");
      paramVarArgs.setRequestProperty("Connection", "Keep-Alive");
      paramVarArgs.connect();
      paramVarArgs = new BufferedReader(new InputStreamReader(paramVarArgs.getInputStream()));
      Object localObject = new StringBuffer();
      for (;;)
      {
        String str = paramVarArgs.readLine();
        if (str == null) {
          break;
        }
        ((StringBuffer)localObject).append(str).append("\n");
      }
      localObject = ((StringBuffer)localObject).toString();
      paramVarArgs.close();
      paramVarArgs = new JSONObject((String)localObject);
      if (paramVarArgs.optInt("errCode", -1) == 0)
      {
        paramVarArgs = paramVarArgs.optJSONObject("data");
        if (paramVarArgs != null)
        {
          paramVarArgs = paramVarArgs.optJSONObject("package");
          if (paramVarArgs != null)
          {
            localBundle.putString("DownPackage", paramVarArgs.optString("package"));
            localBundle.putString("DownUrl", paramVarArgs.optString("url"));
            localBundle.putString("DownAppId", paramVarArgs.optString("appid"));
          }
        }
      }
      return localBundle;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.a.b = paramBundle.getString("DownPackage");
      this.a.d = paramBundle.getString("DownUrl");
      this.a.c = paramBundle.getString("DownAppId");
      if ((!TextUtils.isEmpty(this.a.b)) && (!TextUtils.isEmpty(this.a.c)) && (!TextUtils.isEmpty(this.a.d))) {
        this.a.a(paramBundle.getInt("downloadcode"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController.1
 * JD-Core Version:    0.7.0.1
 */