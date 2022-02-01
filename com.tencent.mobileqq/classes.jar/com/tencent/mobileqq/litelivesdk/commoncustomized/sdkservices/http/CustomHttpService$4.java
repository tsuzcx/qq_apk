package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.HttpInterface.HttpComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class CustomHttpService$4
  implements Callback
{
  CustomHttpService$4(CustomHttpService paramCustomHttpService, String paramString, Callback paramCallback) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    LogInterface localLogInterface = CustomHttpService.a(this.c).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onFailure e = ");
    localStringBuilder.append(paramIOException);
    localLogInterface.i("HttpComponent", localStringBuilder.toString(), new Object[0]);
    this.b.onFailure(paramCall, paramIOException);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    LogInterface localLogInterface = CustomHttpService.a(this.c).getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", onResponse code = ");
    localStringBuilder.append(paramResponse.code());
    localLogInterface.i("HttpComponent", localStringBuilder.toString(), new Object[0]);
    this.b.onResponse(paramCall, paramResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.4
 * JD-Core Version:    0.7.0.1
 */