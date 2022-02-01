package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONObject;

class MiniSDKClientQIPCModule$6
  implements MiniAppCmdInterface
{
  MiniSDKClientQIPCModule$6(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, String paramString, IJsService paramIJsService, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createUpdatableMsg receive isSuc= ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ret=");
    ((StringBuilder)localObject).append(String.valueOf(paramJSONObject));
    QLog.i("MiniSDKClientQIPCModule", 2, ((StringBuilder)localObject).toString());
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("retCode");
      localObject = paramJSONObject.optString("errMsg");
      paramJSONObject = new JSONObject();
      if (i == 0) {}
      try
      {
        paramJSONObject.put("retCode", i);
        paramJSONObject.put("errMsg", localObject);
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        localThrowable.printStackTrace();
      }
      paramJSONObject.put("retCode", 2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(":fail ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("(");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      paramJSONObject.put("errMsg", localStringBuilder.toString());
      IJsService localIJsService = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIJsService;
      if (localIJsService != null)
      {
        localIJsService.evaluateCallbackJs(this.jdField_a_of_type_Int, paramJSONObject.toString());
        return;
      }
      QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null jsService");
      return;
    }
    QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null ret");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.6
 * JD-Core Version:    0.7.0.1
 */