package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$8
  implements BusinessObserver
{
  BridgeModule$8(BridgeModule paramBridgeModule, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject2 = paramBundle.getByteArray("data");
        if (localObject2 != null)
        {
          localObject1 = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("data", ((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
          ((JSONObject)localObject2).put("retcode", ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get());
          ((JSONObject)localObject2).put("cret", 0);
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localObject2);
          if (((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).frequency.has()) {
            BridgeModule.access$102(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, ((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).frequency.get());
          }
          if (((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).packageSize.has()) {
            BridgeModule.access$202(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, ((WebSsoBody.WebSsoControlData)((WebSsoBody.WebSsoResponseBody)localObject1).controlData.get()).packageSize.get());
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          BridgeModuleHelper.a((WebSsoBody.WebSsoResponseBody)localObject1, paramBundle);
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("request web sso success, but byte data is null, cmd: ");
        paramBundle.append(this.b);
        QLog.e("BridgeModule", 1, paramBundle.toString());
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject2;
        Object localObject1;
        JSONObject localJSONObject;
        continue;
      }
      try
      {
        if ((ViolaBaseView.a) && (paramBundle.containsKey("data_error_code")) && (paramBundle.getInt("data_error_code") == 1002))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(BridgeModule.ssoTimeOutRecordStr);
          ((StringBuilder)localObject1).append(paramBundle.getString("cmd"));
          ((StringBuilder)localObject1).append("\n");
          BridgeModule.ssoTimeOutRecordStr = ((StringBuilder)localObject1).toString();
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendRequest failed when time out :");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("BridgeModule", 2, ((StringBuilder)localObject2).toString());
      }
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("cret", 1);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
    BridgeModuleHelper.a(paramBundle);
    return;
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("cret", 2);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.8
 * JD-Core Version:    0.7.0.1
 */