package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class SsoJavascriptInterface$1
  implements BusinessObserver
{
  SsoJavascriptInterface$1(SsoJavascriptInterface paramSsoJavascriptInterface, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("cret", 1);
      SsoJavascriptInterface.access$000(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface, this.jdField_a_of_type_JavaLangString, paramBundle.toString());
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject;
        continue;
        paramBoolean = false;
      }
    }
    localObject = paramBundle.getByteArray("data");
    if (localObject == null)
    {
      QLog.i("SsoJavascriptInterface", 2, "onReceive data is null.");
      return;
    }
    if (QLog.isColorLevel())
    {
      if (localObject != null)
      {
        paramBoolean = true;
        QLog.i("SsoJavascriptInterface", 2, String.format("onReceive data!=null[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
    }
    else
    {
      paramBundle = new WebSsoBody.WebSsoResponseBody();
      paramBundle.mergeFrom((byte[])localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", paramBundle.data.get());
      ((JSONObject)localObject).put("retcode", paramBundle.ret.get());
      ((JSONObject)localObject).put("cret", 0);
      SsoJavascriptInterface.access$000(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface, this.jdField_a_of_type_JavaLangString, ((JSONObject)localObject).toString());
      if (((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).frequency.has()) {
        SsoJavascriptInterface.access$102(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface, ((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).frequency.get());
      }
      if (((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).packageSize.has()) {
        SsoJavascriptInterface.access$202(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface, ((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).packageSize.get());
      }
      if (QLog.isDevelopLevel())
      {
        QLog.i("SsoJavascriptInterface", 2, String.format("onReceive cmd=%s %b frequency=%d result=%s", new Object[] { this.b, Boolean.valueOf(((WebSsoBody.WebSsoControlData)paramBundle.controlData.get()).frequency.has()), Integer.valueOf(SsoJavascriptInterface.access$100(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface)), localObject }));
        return;
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("cret", 2);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("SsoJavascriptInterface", 4, localJSONException.getMessage());
        }
        SsoJavascriptInterface.access$000(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizJsSsoJavascriptInterface, this.jdField_a_of_type_JavaLangString, paramBundle.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */