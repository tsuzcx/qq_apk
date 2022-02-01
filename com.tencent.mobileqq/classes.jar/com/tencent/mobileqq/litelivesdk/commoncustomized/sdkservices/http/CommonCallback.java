package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import android.os.Handler;
import android.os.Looper;
import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

class CommonCallback
  implements Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HttpResponse jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  
  public CommonCallback(HttpResponse paramHttpResponse, LogInterface paramLogInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse = paramHttpResponse;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramLogInterface;
  }
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonCallback.1(this));
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (!paramResponse.isSuccessful()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonCallback.2(this, paramResponse));
    }
    do
    {
      return;
      paramCall = "";
      if (paramResponse.body() != null)
      {
        paramCall = paramResponse.body().string();
        this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("CommonCallback", "onResponse result = " + paramCall, new Object[0]);
      }
    } while (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpResponse == null);
    try
    {
      paramCall = new JSONObject(paramCall);
      this.jdField_a_of_type_AndroidOsHandler.post(new CommonCallback.3(this, paramCall));
      return;
    }
    catch (JSONException paramCall)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("CommonCallback", "onResponse JSONException e = " + paramCall, new Object[0]);
        paramCall = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CommonCallback
 * JD-Core Version:    0.7.0.1
 */