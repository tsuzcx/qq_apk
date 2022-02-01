package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TimTeamPlugin
  implements NativePlugin
{
  public static final String ACTION_SHOW_PROFILE = "showCoopSpaceProfile";
  public static final String PLUGIN_NAME = "tim_space";
  public static final String TAG = "TimTeamPlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext != null) {}
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.getString("data")).getString("action");
      if (QLog.isColorLevel()) {
        QLog.d("TimTeamPlugin", 2, "onInvoke|" + paramJSONObject);
      }
      if (TextUtils.equals(paramJSONObject, "showCoopSpaceProfile"))
      {
        paramJSONObject = new ActivityURIRequest(paramJSContext.getActivity(), "/pubaccount/detail");
        paramJSONObject.extra().putString("uin", AppConstants.TIM_TEAM_UIN);
        QRoute.startUri(paramJSONObject, null);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TimTeamPlugin", 2, "decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin
 * JD-Core Version:    0.7.0.1
 */