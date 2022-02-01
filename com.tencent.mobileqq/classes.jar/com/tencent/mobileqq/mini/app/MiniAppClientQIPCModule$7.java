package com.tencent.mobileqq.mini.app;

import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppClientQIPCModule$7
  implements MiniAppCmdInterface
{
  MiniAppClientQIPCModule$7(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniAppClientQIPCModule", 1, "sendArkMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getAppBrandRunTime(MiniAppClientQIPCModule.access$200(this.this$0), MiniAppClientQIPCModule.access$300(this.this$0));
    Object localObject;
    if (MiniAppClientQIPCModule.access$400(this.this$0)) {
      localObject = MiniAppClientQIPCModule.access$100(this.this$0);
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (paramJSONObject != null) {
          break label148;
        }
        if (!MiniAppClientQIPCModule.access$400(this.this$0)) {
          break label139;
        }
        paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getServiceRuntime();
        label108:
        ((BaseJsPluginEngine)localObject).callbackJsEventFail(paramJSONObject, this.val$shareEvent, null, this.val$callbackId);
      }
      label139:
      label148:
      JSONObject localJSONObject;
      label230:
      do
      {
        for (;;)
        {
          return;
          if (localAppBrandRuntime == null) {
            break label820;
          }
          localObject = localAppBrandRuntime.jsPluginEngine;
          break;
          paramJSONObject = localAppBrandRuntime.getPageWebView();
          break label108;
          localJSONObject = new JSONObject();
          int i;
          if (paramBoolean)
          {
            try
            {
              MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = (MiniProgramShare.StSendArkMsgRsp)paramJSONObject.get("response");
              i = paramJSONObject.getInt("retCode");
              paramJSONObject = paramJSONObject.getString("errMsg");
              if (i != 0) {
                break label484;
              }
              if (!MiniAppClientQIPCModule.access$400(this.this$0)) {
                break label430;
              }
              MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventOK(MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(2), this.val$shareEvent, null, this.val$callbackId);
              ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.7.1(this, (BaseJsPluginEngine)localObject));
              if (!this.val$shareEvent.equals("shareMessageToFriend")) {
                continue;
              }
              localJSONObject.put("success", true);
              localJSONObject.put("errMsg", "");
              if ((!MiniAppClientQIPCModule.access$400(this.this$0)) || (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null)) {
                break label452;
              }
              paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
              if (paramJSONObject == null) {
                continue;
              }
              paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
              return;
            }
            catch (Exception paramJSONObject)
            {
              if (!MiniAppClientQIPCModule.access$400(this.this$0)) {
                break label771;
              }
            }
            paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getServiceRuntime();
            ((BaseJsPluginEngine)localObject).callbackJsEventFail(paramJSONObject, this.val$shareEvent, null, this.val$callbackId);
          }
          else
          {
            try
            {
              localJSONObject.put("errMsg", "请求失败");
              localJSONObject.put("success", false);
              if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) != null)
              {
                paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
                if (paramJSONObject == null) {
                  continue;
                }
                paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
                return;
                ((BaseJsPluginEngine)localObject).callbackJsEventOK(localAppBrandRuntime.getPageWebView(), this.val$shareEvent, null, this.val$callbackId);
                break label230;
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
                return;
                localJSONObject.put("errMsg", paramJSONObject);
                localJSONObject.put("errCode", i);
                if (MiniAppClientQIPCModule.access$400(this.this$0)) {}
                for (paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getServiceRuntime();; paramJSONObject = localAppBrandRuntime.getPageWebView())
                {
                  ((BaseJsPluginEngine)localObject).callbackJsEventFail(paramJSONObject, this.val$shareEvent, localJSONObject, this.val$callbackId);
                  localJSONObject.put("success", false);
                  if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null) {
                    break label600;
                  }
                  paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
                  if (paramJSONObject == null) {
                    break;
                  }
                  paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
                  return;
                }
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
                return;
                if (MiniAppClientQIPCModule.access$400(this.this$0)) {}
                for (paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getServiceRuntime();; paramJSONObject = localAppBrandRuntime.getPageWebView())
                {
                  ((BaseJsPluginEngine)localObject).callbackJsEventFail(paramJSONObject, this.val$shareEvent, null, this.val$callbackId);
                  localJSONObject.put("errMsg", "请求失败");
                  localJSONObject.put("success", false);
                  if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null) {
                    break label739;
                  }
                  paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
                  if (paramJSONObject == null) {
                    break;
                  }
                  paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
                  return;
                }
                if ((!(localObject instanceof JsPluginEngine)) || (((BaseJsPluginEngine)localObject).appBrandRuntime == null)) {
                  continue;
                }
                ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
                return;
                paramJSONObject = localAppBrandRuntime.getPageWebView();
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
      label430:
      label452:
      label484:
      ((BaseJsPluginEngine)localObject).appBrandRuntime.evaluateServiceSubcribeJS("onShareMessageToFriend", localJSONObject.toString());
      label600:
      label739:
      return;
      label771:
      label820:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.7
 * JD-Core Version:    0.7.0.1
 */