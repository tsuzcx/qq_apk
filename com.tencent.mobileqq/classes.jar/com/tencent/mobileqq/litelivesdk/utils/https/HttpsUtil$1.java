package com.tencent.mobileqq.litelivesdk.utils.https;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

class HttpsUtil$1
  implements Callback
{
  HttpsUtil$1(HttpsUtil paramHttpsUtil, String paramString, HttpsInterface.CallBack paramCallBack) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil).c("HttpsUtil", "url = " + this.jdField_a_of_type_JavaLangString + ", onFailure e = " + paramIOException);
    ThreadCenter.postDefaultUITask(new HttpsUtil.1.1(this, paramIOException));
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil).c("HttpsUtil", "url = " + this.jdField_a_of_type_JavaLangString + ", onResponse code = " + paramResponse.code());
    paramCall = "";
    if (paramResponse.body() != null)
    {
      paramCall = paramResponse.body().string();
      HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil).c("HttpsUtil", "onResponse result = " + paramCall);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsInterface$CallBack != null) {}
    try
    {
      paramCall = new JSONObject(paramCall);
      ThreadCenter.postDefaultUITask(new HttpsUtil.1.2(this, paramCall));
      return;
    }
    catch (JSONException paramCall)
    {
      for (;;)
      {
        HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil).c("HttpsUtil", "onResponse JSONException e = " + paramCall);
        paramCall = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.https.HttpsUtil.1
 * JD-Core Version:    0.7.0.1
 */