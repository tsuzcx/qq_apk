package com.tencent.mobileqq.mini.app;

import NS_MINI_SHARE.MiniProgramShare.StSendArkMsgRsp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppClientQIPCModule$6
  implements MiniAppCmdInterface
{
  MiniAppClientQIPCModule$6(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniAppClientQIPCModule", 1, "sendArkMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (MiniAppClientQIPCModule.access$100(this.this$0) != null)
    {
      if (paramJSONObject != null) {
        break label81;
      }
      MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventFail(MiniAppClientQIPCModule.access$100(this.this$0).getServiceRuntime(), this.val$shareEvent, null, this.val$callbackId);
    }
    for (;;)
    {
      return;
      label81:
      JSONObject localJSONObject = new JSONObject();
      int i;
      if (paramBoolean)
      {
        try
        {
          MiniProgramShare.StSendArkMsgRsp localStSendArkMsgRsp = (MiniProgramShare.StSendArkMsgRsp)paramJSONObject.get("response");
          i = paramJSONObject.getInt("retCode");
          paramJSONObject = paramJSONObject.getString("errMsg");
          if (i != 0) {
            break label335;
          }
          MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventOK(MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(2), this.val$shareEvent, null, this.val$callbackId);
          ThreadManager.getSubThreadHandler().post(new MiniAppClientQIPCModule.6.1(this));
          if ((!this.val$shareEvent.equals("shareMessageToFriend")) || (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null)) {
            continue;
          }
          paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
          if (paramJSONObject == null) {
            continue;
          }
          localJSONObject.put("success", true);
          localJSONObject.put("errMsg", "");
          paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
          return;
        }
        catch (Exception paramJSONObject)
        {
          MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventFail(MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(2), this.val$shareEvent, null, this.val$callbackId);
        }
        if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null) {
          continue;
        }
        paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
        if (paramJSONObject == null) {
          continue;
        }
      }
      try
      {
        localJSONObject.put("errMsg", "请求失败");
        localJSONObject.put("success", false);
        paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
        return;
        label335:
        localJSONObject.put("errMsg", paramJSONObject);
        localJSONObject.put("errCode", i);
        MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventFail(MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(2), this.val$shareEvent, localJSONObject, this.val$callbackId);
        if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null) {
          continue;
        }
        paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
        if (paramJSONObject == null) {
          continue;
        }
        localJSONObject.put("success", false);
        paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
        return;
        MiniAppClientQIPCModule.access$100(this.this$0).callbackJsEventFail(MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(2), this.val$shareEvent, null, this.val$callbackId);
        if (MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1) == null) {
          continue;
        }
        paramJSONObject = MiniAppClientQIPCModule.access$100(this.this$0).getGameJsRuntime(1);
        if (paramJSONObject == null) {
          continue;
        }
        localJSONObject.put("errMsg", "请求失败");
        localJSONObject.put("success", false);
        paramJSONObject.evaluateSubcribeJS("onShareMessageToFriend", localJSONObject.toString(), -1);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.6
 * JD-Core Version:    0.7.0.1
 */