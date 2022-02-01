package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class CustomHttpService$1$1
  implements Runnable
{
  CustomHttpService$1$1(CustomHttpService.1 param1, IOException paramIOException) {}
  
  public void run()
  {
    if (this.b.b != null)
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("errCode", Integer.valueOf(-1));
      ((Map)localObject).put("errMsg", this.a.getMessage());
      localObject = new JSONObject((Map)localObject);
      this.b.b.onResponse(-1, (JSONObject)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService.1.1
 * JD-Core Version:    0.7.0.1
 */