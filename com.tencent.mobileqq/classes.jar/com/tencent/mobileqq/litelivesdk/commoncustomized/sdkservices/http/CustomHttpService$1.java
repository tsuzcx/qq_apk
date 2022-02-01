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
    CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog().i("HttpComponent", "url = " + this.jdField_a_of_type_JavaLangString + ", onFailure e = " + paramIOException, new Object[0]);
    ThreadCenter.postDefaultUITask(new CustomHttpService.1.1(this, paramIOException));
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog().i("HttpComponent", "url = " + this.jdField_a_of_type_JavaLangString + ", onResponse code = " + paramResponse.code(), new Object[0]);
    paramCall = "";
    if (paramResponse.body() != null)
    {
      paramCall = paramResponse.body().string();
      CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog().i("HttpComponent", "onResponse result = " + paramCall, new Object[0]);
    }
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse != null) {}
    try
    {
      paramCall = new JSONObject(paramCall);
      ThreadCenter.postDefaultUITask(new CustomHttpService.1.2(this, paramCall));
      return;
    }
    catch (JSONException paramCall)
    {
      for (;;)
      {
        CustomHttpService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesHttpCustomHttpService).getLog().i("HttpComponent", "onResponse JSONException e = " + paramCall, new Object[0]);
        paramCall = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.1
 * JD-Core Version:    0.7.0.1
 */