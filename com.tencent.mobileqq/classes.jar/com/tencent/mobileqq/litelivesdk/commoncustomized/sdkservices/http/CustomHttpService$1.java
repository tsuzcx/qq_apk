package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.HttpInterface.HttpComponentAdapter;
import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

class CustomHttpService$1
  implements Callback
{
  CustomHttpService$1(CustomHttpService paramCustomHttpService, String paramString, HttpResponse paramHttpResponse) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", onFailure e = ");
    localStringBuilder.append(paramIOException);
    paramCall.i("HttpComponent", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postDefaultUITask(new CustomHttpService.1.1(this, paramIOException));
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", onResponse code = ");
    ((StringBuilder)localObject).append(paramResponse.code());
    paramCall.i("HttpComponent", ((StringBuilder)localObject).toString(), new Object[0]);
    if (paramResponse.body() != null)
    {
      paramCall = paramResponse.body().string();
      paramResponse = CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse result = ");
      ((StringBuilder)localObject).append(paramCall);
      paramResponse.i("HttpComponent", ((StringBuilder)localObject).toString(), new Object[0]);
    }
    else
    {
      paramCall = "";
    }
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse != null)
    {
      paramResponse = null;
      try
      {
        paramCall = new JSONObject(paramCall);
      }
      catch (JSONException paramCall)
      {
        localObject = CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResponse JSONException e = ");
        localStringBuilder.append(paramCall);
        ((LogInterface)localObject).i("HttpComponent", localStringBuilder.toString(), new Object[0]);
        paramCall = paramResponse;
      }
      ThreadCenter.postDefaultUITask(new CustomHttpService.1.2(this, paramCall));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.1
 * JD-Core Version:    0.7.0.1
 */