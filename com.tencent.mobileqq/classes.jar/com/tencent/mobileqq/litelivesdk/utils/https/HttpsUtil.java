package com.tencent.mobileqq.litelivesdk.utils.https;

import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.now.netchannel.okhttp.OkHttpClientFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class HttpsUtil
  implements HttpsInterface
{
  private LogInterface a = LogFactory.a();
  
  public void a(String paramString1, Map<String, String> paramMap, JSONObject paramJSONObject, HttpsInterface.CallBack paramCallBack, String paramString2)
  {
    Request.Builder localBuilder = new Request.Builder().url(paramString1);
    if (paramString2 != null) {
      localBuilder.header("Cookie", paramString2);
    }
    if (paramMap != null)
    {
      paramString2 = paramMap.keySet().iterator();
      while (paramString2.hasNext())
      {
        String str1 = (String)paramString2.next();
        String str2 = (String)paramMap.get(str1);
        if (str2 != null) {
          localBuilder.addHeader(str1, str2);
        }
      }
    }
    paramMap = localBuilder.post(RequestBody.create(MediaType.parse("application/json"), paramJSONObject.toString())).build();
    OkHttpClientFactory.a().newCall(paramMap).enqueue(new HttpsUtil.1(this, paramString1, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.https.HttpsUtil
 * JD-Core Version:    0.7.0.1
 */