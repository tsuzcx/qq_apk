package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.HttpResponse;
import okhttp3.Response;

class CommonCallback$2
  implements Runnable
{
  CommonCallback$2(CommonCallback paramCommonCallback, Response paramResponse) {}
  
  public void run()
  {
    if (CommonCallback.a(this.this$0) != null) {
      CommonCallback.a(this.this$0).onResponse(this.a.code(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CommonCallback.2
 * JD-Core Version:    0.7.0.1
 */