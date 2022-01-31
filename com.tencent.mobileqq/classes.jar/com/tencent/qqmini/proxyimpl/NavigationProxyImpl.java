package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.qqmini.sdk.core.proxy.NavigationProxy;
import org.json.JSONObject;

public class NavigationProxyImpl
  extends NavigationProxy
{
  private void savaShowInfoToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationProxyImpl.1(this, paramMiniAppInfo), 32, null, true);
  }
  
  public boolean launchByAppType(int paramInt1, Activity paramActivity, String paramString, int paramInt2, JSONObject paramJSONObject, ResultReceiver paramResultReceiver)
  {
    return GameProxy.startGameByMiniApp(paramActivity, paramString, paramJSONObject);
  }
  
  public void onAfterLaunchByAppInfo(JSONObject paramJSONObject)
  {
    savaShowInfoToDB(MiniAppInfo.createMiniAppInfo(paramJSONObject));
  }
  
  public void onBeforeNavigateToMiniProgram()
  {
    MiniAppStateManager.getInstance().notifyChange("hideInput");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationProxyImpl
 * JD-Core Version:    0.7.0.1
 */