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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    QLog.d("MiniSDKClientQIPCModule", 1, (String)localObject1);
    if (paramJSONObject == null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
      localObject1 = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule;
      localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("share_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
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
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
        paramJSONObject = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule;
        localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("share_");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
        MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject2, ((StringBuilder)localObject3).toString(), "success", 3, null);
        MiniSDKClientQIPCModule.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, "share_success");
        if (!this.jdField_a_of_type_JavaLangString.equals("shareMessageToFriend")) {
          break label673;
        }
        MiniSDKClientQIPCModule.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule, (JSONObject)localObject1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "", true, ApiUtil.wrapCallbackOk(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject1));
        return;
      }
      ((JSONObject)localObject1).put("errMsg", paramJSONObject);
      ((JSONObject)localObject1).put("errCode", i);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail((JSONObject)localObject1, paramJSONObject);
      MiniSDKClientQIPCModule.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule, (JSONObject)localObject1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, paramJSONObject, false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject1));
      localObject2 = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule;
      localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("share_");
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
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
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    MiniSDKClientQIPCModule.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule, (JSONObject)localObject1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject1));
    paramJSONObject = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule;
    Object localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("share_");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
    MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject2, ((StringBuilder)localObject3).toString(), "fail", 3, "request fail");
    return;
    label579:
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
    MiniSDKClientQIPCModule.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule, (JSONObject)localObject1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime, this.jdField_a_of_type_Int, "请求失败", false, ApiUtil.wrapCallbackFail(this.jdField_a_of_type_JavaLangString, (JSONObject)localObject1));
    paramJSONObject = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniSDKClientQIPCModule;
    localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("share_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.event);
    MiniSDKClientQIPCModule.a(paramJSONObject, (BaseRuntime)localObject1, ((StringBuilder)localObject2).toString(), "fail", 3, "request exception");
    label673:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */