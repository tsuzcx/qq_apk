package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class MiniSDKClientQIPCModule$3
  implements MiniAppCmdInterface
{
  MiniSDKClientQIPCModule$3(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, RequestEvent paramRequestEvent, BaseRuntime paramBaseRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendArkMsg receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(paramJSONObject);
    if (((StringBuilder)localObject1).toString() != null)
    {
      localObject1 = paramJSONObject.toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(null);
      ((StringBuilder)localObject1).append("; event :");
      ((StringBuilder)localObject1).append(this.a.event);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    QLog.d("MiniSDKClientQIPCModule", 1, (String)localObject1);
    if (paramJSONObject == null)
    {
      this.a.fail();
      localObject1 = this.e;
      localObject2 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("share_");
      ((StringBuilder)localObject3).append(this.a.event);
      MiniSDKClientQIPCModule.a((MiniSDKClientQIPCModule)localObject1, (BaseRuntime)localObject2, ((StringBuilder)localObject3).toString(), "fail", 3, "request fail");
    }
    localObject1 = new JSONObject();
    if (paramBoolean) {}
    try
    {
      int i = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      if (i == 0)
      {
        this.a.ok();
        paramJSONObject = this.e;
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("share_");
        ((StringBuilder)localObject3).append(this.a.event);
        MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject2, ((StringBuilder)localObject3).toString(), "success", 3, null);
        MiniSDKClientQIPCModule.a(this.e, this.b, "share_success");
        if (!this.c.equals("shareMessageToFriend")) {
          break label673;
        }
        MiniSDKClientQIPCModule.a(this.e, (JSONObject)localObject1, this.b, this.d, "", true, ApiUtil.wrapCallbackOk(this.c, (JSONObject)localObject1));
        return;
      }
      ((JSONObject)localObject1).put("errMsg", paramJSONObject);
      ((JSONObject)localObject1).put("errCode", i);
      this.a.fail((JSONObject)localObject1, paramJSONObject);
      MiniSDKClientQIPCModule.a(this.e, (JSONObject)localObject1, this.b, this.d, paramJSONObject, false, ApiUtil.wrapCallbackFail(this.c, (JSONObject)localObject1));
      localObject2 = this.e;
      localObject3 = this.b;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("share_");
      ((StringBuilder)localObject4).append(this.a.event);
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append(",");
      localStringBuilder.append(paramJSONObject);
      MiniSDKClientQIPCModule.a((MiniSDKClientQIPCModule)localObject2, (BaseRuntime)localObject3, (String)localObject4, "fail", 3, localStringBuilder.toString());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      break label579;
    }
    this.a.fail();
    MiniSDKClientQIPCModule.a(this.e, (JSONObject)localObject1, this.b, this.d, "请求失败", false, ApiUtil.wrapCallbackFail(this.c, (JSONObject)localObject1));
    paramJSONObject = this.e;
    Object localObject2 = this.b;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("share_");
    ((StringBuilder)localObject3).append(this.a.event);
    MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject2, ((StringBuilder)localObject3).toString(), "fail", 3, "request fail");
    return;
    label579:
    this.a.fail();
    MiniSDKClientQIPCModule.a(this.e, (JSONObject)localObject1, this.b, this.d, "请求失败", false, ApiUtil.wrapCallbackFail(this.c, (JSONObject)localObject1));
    paramJSONObject = this.e;
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("share_");
    ((StringBuilder)localObject2).append(this.a.event);
    MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject1, ((StringBuilder)localObject2).toString(), "fail", 3, "request exception");
    label673:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */