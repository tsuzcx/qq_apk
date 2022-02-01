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
    paramCall = HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onFailure e = ");
    localStringBuilder.append(paramIOException);
    paramCall.c("HttpsUtil", localStringBuilder.toString());
    ThreadCenter.postDefaultUITask(new HttpsUtil.1.1(this, paramIOException));
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", onResponse code = ");
    ((StringBuilder)localObject).append(paramResponse.code());
    paramCall.c("HttpsUtil", ((StringBuilder)localObject).toString());
    if (paramResponse.body() != null)
    {
      paramCall = paramResponse.body().string();
      paramResponse = HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse result = ");
      ((StringBuilder)localObject).append(paramCall);
      paramResponse.c("HttpsUtil", ((StringBuilder)localObject).toString());
    }
    else
    {
      paramCall = "";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsInterface$CallBack != null)
    {
      paramResponse = null;
      try
      {
        paramCall = new JSONObject(paramCall);
      }
      catch (JSONException paramCall)
      {
        localObject = HttpsUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsHttpsHttpsUtil);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResponse JSONException e = ");
        localStringBuilder.append(paramCall);
        ((LogInterface)localObject).c("HttpsUtil", localStringBuilder.toString());
        paramCall = paramResponse;
      }
      ThreadCenter.postDefaultUITask(new HttpsUtil.1.2(this, paramCall));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.https.HttpsUtil.1
 * JD-Core Version:    0.7.0.1
 */