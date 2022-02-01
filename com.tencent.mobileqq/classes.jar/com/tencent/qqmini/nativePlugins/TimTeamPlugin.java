package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TimTeamPlugin
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QMLog.e("TimTeamPlugin", ((StringBuilder)localObject).toString());
    return null;
  }
  
  @JsEvent({"tim_space"})
  public void timSpace(RequestEvent paramRequestEvent)
  {
    try
    {
      paramRequestEvent = new JSONObject(a(paramRequestEvent).getString("data")).getString("action");
      if (QMLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onInvoke|");
        localStringBuilder.append(paramRequestEvent);
        QMLog.d("TimTeamPlugin", localStringBuilder.toString());
      }
      if (!TextUtils.equals(paramRequestEvent, "showCoopSpaceProfile")) {
        break label118;
      }
      paramRequestEvent = new ActivityURIRequest(this.mMiniAppContext.getAttachedActivity(), "/pubaccount/detail");
      paramRequestEvent.extra().putString("uin", AppConstants.TIM_TEAM_UIN);
      QRoute.startUri(paramRequestEvent, null);
      return;
    }
    catch (Exception paramRequestEvent)
    {
      label105:
      label118:
      break label105;
    }
    if (QMLog.isColorLevel()) {
      QMLog.w("TimTeamPlugin", "decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TimTeamPlugin
 * JD-Core Version:    0.7.0.1
 */