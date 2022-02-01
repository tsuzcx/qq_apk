package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.DownloadCallback;
import okhttp3.Response;

class CustomHttpService$2$2
  implements Runnable
{
  CustomHttpService$2$2(CustomHttpService.2 param2, Response paramResponse) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.onFail(this.a.code());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.2.2
 * JD-Core Version:    0.7.0.1
 */