package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.DownloadCallback;

class CustomHttpService$2$3
  implements Runnable
{
  CustomHttpService$2$3(CustomHttpService.2 param2, long paramLong1, long paramLong2, int paramInt) {}
  
  public void run()
  {
    if (this.d.a != null) {
      this.d.a.onProgress(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.2.3
 * JD-Core Version:    0.7.0.1
 */