package com.tencent.mobileqq.litelivesdk.utils;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import org.json.JSONObject;

final class AegisHelper$1
  implements HttpResponse
{
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      LogFactory.a().c("AegisHelper", "errCode = " + paramInt + "result = " + paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.AegisHelper.1
 * JD-Core Version:    0.7.0.1
 */