package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.os.ResultReceiver;
import org.json.JSONObject;

public abstract class NavigationProxy
{
  public abstract boolean launchByAppType(int paramInt1, Activity paramActivity, String paramString, int paramInt2, JSONObject paramJSONObject, ResultReceiver paramResultReceiver);
  
  public abstract void onAfterLaunchByAppInfo(JSONObject paramJSONObject);
  
  public abstract void onBeforeNavigateToMiniProgram();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy
 * JD-Core Version:    0.7.0.1
 */