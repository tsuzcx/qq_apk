package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.DownloadCallback;
import java.io.File;

class CustomHttpService$2$4
  implements Runnable
{
  CustomHttpService$2$4(CustomHttpService.2 param2, File paramFile) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.onSuccess(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.2.4
 * JD-Core Version:    0.7.0.1
 */