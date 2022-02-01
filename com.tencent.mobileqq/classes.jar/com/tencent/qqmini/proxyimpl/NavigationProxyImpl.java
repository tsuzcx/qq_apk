package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.ext.GameProxy;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import org.json.JSONObject;

@ProxyService(proxy=NavigationProxy.class)
public class NavigationProxyImpl
  extends NavigationProxy
{
  private void a(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManagerV2.excute(new NavigationProxyImpl.1(this, paramMiniAppInfo), 32, null, true);
  }
  
  public boolean launchByAppType(int paramInt1, Activity paramActivity, String paramString, int paramInt2, JSONObject paramJSONObject, ResultReceiver paramResultReceiver)
  {
    return GameProxy.startGameByMiniApp(paramActivity, paramString, paramJSONObject);
  }
  
  public void onAfterLaunchByAppInfo(JSONObject paramJSONObject)
  {
    a(MiniAppInfo.createMiniAppInfo(paramJSONObject));
  }
  
  public void onBeforeNavigateToMiniProgram() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.NavigationProxyImpl
 * JD-Core Version:    0.7.0.1
 */