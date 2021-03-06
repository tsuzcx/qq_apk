package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONObject;

public class RefreshQzoneFeedPlugin
  implements NativePlugin
{
  public static final String TAG = "RefreshQzoneFeedPlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext != null)
    {
      paramJSONObject = paramJSContext.getActivity();
      if (paramJSONObject != null)
      {
        Intent localIntent = new Intent("action_personalize_js2qzone");
        Bundle localBundle = new Bundle();
        localBundle.putString("cmd", "refreshFeed");
        localIntent.putExtras(localBundle);
        QZoneHelper.forwardToQzoneTransluentActivity(paramJSONObject, QZoneHelper.UserInfo.getInstance(), localIntent);
        paramJSContext.evaluateCallback(true, null, "");
        if (QLog.isColorLevel()) {
          QLog.i("RefreshQzoneFeedPlugin", 2, "RefreshQzoneFeed");
        }
      }
      else
      {
        QLog.e("RefreshQzoneFeedPlugin", 1, "activity is null");
      }
    }
    else
    {
      QLog.e("RefreshQzoneFeedPlugin", 1, "jsContext is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.RefreshQzoneFeedPlugin
 * JD-Core Version:    0.7.0.1
 */