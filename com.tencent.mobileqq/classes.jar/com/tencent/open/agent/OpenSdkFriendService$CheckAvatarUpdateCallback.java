package com.tencent.open.agent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.settings.OpensdkPreference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$CheckAvatarUpdateCallback
  implements HttpCgiAsyncTask.Callback
{
  protected OpenSdkFriendService$CheckAvatarUpdateCallback(OpenSdkFriendService paramOpenSdkFriendService) {}
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckAvatarUpdate Exception. ");
    localStringBuilder.append(paramException.getMessage());
    LogUtility.c("OpenSdkFriendService", localStringBuilder.toString(), paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("ret");
      localObject = paramJSONObject.getString("msg");
      if (i == 0)
      {
        localObject = paramJSONObject.getJSONArray("update_list");
        i = ((JSONArray)localObject).length();
        if (i > 0) {
          ThreadManager.executeOnSubThread(new OpenSdkFriendService.CheckAvatarUpdateCallback.1(this, i, (JSONArray)localObject));
        }
        localObject = OpensdkPreference.a(CommonDataAdapter.a().a(), "prefer_last_avatar_update_time").edit();
        ((SharedPreferences.Editor)localObject).putString(this.a.b, paramJSONObject.getString("time"));
        ((SharedPreferences.Editor)localObject).commit();
        if (this.a.a != null) {
          this.a.a.a();
        }
      }
      else
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("CheckAvatarUpdateCallback error. ret=");
        paramJSONObject.append(i);
        paramJSONObject.append(", msg=");
        paramJSONObject.append((String)localObject);
        LogUtility.e("OpenSdkFriendService", paramJSONObject.toString());
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CheckAvatarUpdate Exception. ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      LogUtility.c("OpenSdkFriendService", ((StringBuilder)localObject).toString(), paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback
 * JD-Core Version:    0.7.0.1
 */