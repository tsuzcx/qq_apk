package com.tencent.mobileqq.mini.app;

import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppClientQIPCModule$8
  implements MiniAppCmdInterface
{
  MiniAppClientQIPCModule$8(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniAppClientQIPCModule", 1, "sendArkMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getAppBrandRunTime(MiniAppClientQIPCModule.access$300(this.this$0), MiniAppClientQIPCModule.access$400(this.this$0));
    Object localObject;
    if (MiniAppClientQIPCModule.access$500(this.this$0)) {
      localObject = MiniAppClientQIPCModule.access$100(this.this$0);
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (paramJSONObject != null) {
          break label121;
        }
        ((BaseJsPluginEngine)localObject).callbackJsEventFail(this.val$jsRuntime, this.val$shareEvent, null, this.val$callbackId);
      }
      label121:
      JSONObject localJSONObject;
      label196:
      do
      {
        for (;;)
        {
          return;
          if (localAppBrandRuntime == null) {
            break label691;
          }
          localObject = localAppBrandRuntime.jsPluginEngine;
          break;
          localJSONObject = new JSONObject();
          int i;
          if (paramBoolean) {
            try
            {
              MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = (MiniProgramShare.StSendArkMsgRsp)paramJSONObject.get("response");
              i = paramJSONObject.getInt("retCode");
              paramJSONObject = paramJSONObject.getString("errMsg");
              if (i == 0) {
                if (MiniAppClientQIPCModule.access$500(this.this$0))
                {
                  MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventOK(this.val$jsRuntime, this.val$shareEvent, null, this.val$callbackId);
                  ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.8.1(this, (BaseJsPluginEngine)localObject));
                  if (!this.val$shareEvent.equals("shareMessageToFriend")) {
                    continue;
                  }
                  localJSONObject.put("success", true);
                  localJSONObject.put("errMsg", "");
                  if (!MiniAppClientQIPCModule.access$500(this.this$0)) {
                    break label388;
                  }
                  paramJSONObject = (OpenDataPlugin)MiniAppClientQIPCModule.access$100(this.this$0).getPlugin(OpenDataPlugin.class);
                  if (paramJSONObject == null) {
                    continue;
                  }
                  paramJSONObject.handleShareEvent("onShareMessageToFriend", localJSONObject.toString());
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              ((BaseJsPluginEngine)localObject).callbackJsEventFail(this.val$jsRuntime, this.val$shareEvent, null, this.val$callbackId);
            }
          } else {
            try
            {
              localJSONObject.put("errMsg", "请求失败");
              localJSONObject.put("success", false);
              if (MiniAppClientQIPCModule.access$500(this.this$0))
              {
                paramJSONObject = (OpenDataPlugin)MiniAppClientQIPCModule.access$100(this.this$0).getPlugin(OpenDataPlugin.class);
                if (paramJSONObject == null) {
                  continue;
                }
                paramJSONObject.handleShareEvent("onShareMessageToFriend", localJSONObject.toString());
                return;
                ((BaseJsPluginEngine)localObject).callbackJsEventOK(localAppBrandRuntime.getPageWebView(), this.val$shareEvent, null, this.val$callbackId);
                break label196;
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
                return;
                localJSONObject.put("errMsg", paramJSONObject);
                localJSONObject.put("errCode", i);
                ((BaseJsPluginEngine)localObject).callbackJsEventFail(this.val$jsRuntime, this.val$shareEvent, localJSONObject, this.val$callbackId);
                localJSONObject.put("success", false);
                if (MiniAppClientQIPCModule.access$500(this.this$0))
                {
                  paramJSONObject = (OpenDataPlugin)MiniAppClientQIPCModule.access$100(this.this$0).getPlugin(OpenDataPlugin.class);
                  if (paramJSONObject == null) {
                    continue;
                  }
                  paramJSONObject.handleShareEvent("onShareMessageToFriend", localJSONObject.toString());
                  return;
                }
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
                return;
                ((BaseJsPluginEngine)localObject).callbackJsEventFail(this.val$jsRuntime, this.val$shareEvent, null, this.val$callbackId);
                localJSONObject.put("errMsg", "请求失败");
                localJSONObject.put("success", false);
                if (MiniAppClientQIPCModule.access$500(this.this$0))
                {
                  paramJSONObject = (OpenDataPlugin)MiniAppClientQIPCModule.access$100(this.this$0).getPlugin(OpenDataPlugin.class);
                  if (paramJSONObject == null) {
                    continue;
                  }
                  paramJSONObject.handleShareEvent("onShareMessageToFriend", localJSONObject.toString());
                  return;
                }
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
              }
            }
            catch (JSONException paramJSONObject)
            {
              for (;;)
              {
                paramJSONObject.printStackTrace();
              }
            }
          }
        }
      } while ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null));
      label388:
      ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
      return;
      label691:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.8
 * JD-Core Version:    0.7.0.1
 */