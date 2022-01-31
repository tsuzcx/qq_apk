package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.proxy.NavigationProxy;
import org.json.JSONObject;

public class NavigationProxyDefault
  extends NavigationProxy
{
  public boolean launchByAppType(int paramInt1, Activity paramActivity, String paramString, int paramInt2, JSONObject paramJSONObject, ResultReceiver paramResultReceiver)
  {
    if (paramInt1 == 1)
    {
      MiniSDK.startMiniApp(paramActivity, paramString, paramInt2, paramResultReceiver);
      return true;
    }
    return false;
  }
  
  public void onAfterLaunchByAppInfo(JSONObject paramJSONObject) {}
  
  public void onBeforeNavigateToMiniProgram() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.NavigationProxyDefault
 * JD-Core Version:    0.7.0.1
 */