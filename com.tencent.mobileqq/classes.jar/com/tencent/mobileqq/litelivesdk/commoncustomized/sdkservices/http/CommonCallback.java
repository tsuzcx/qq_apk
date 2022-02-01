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
  private Handler a = new Handler(Looper.getMainLooper());
  private HttpResponse b;
  private LogInterface c;
  
  public CommonCallback(HttpResponse paramHttpResponse, LogInterface paramLogInterface)
  {
    this.b = paramHttpResponse;
    this.c = paramLogInterface;
  }
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    if (this.b != null) {
      this.a.post(new CommonCallback.1(this));
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (!paramResponse.isSuccessful())
    {
      this.a.post(new CommonCallback.2(this, paramResponse));
      return;
    }
    Object localObject;
    if (paramResponse.body() != null)
    {
      paramCall = paramResponse.body().string();
      paramResponse = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse result = ");
      ((StringBuilder)localObject).append(paramCall);
      paramResponse.i("CommonCallback", ((StringBuilder)localObject).toString(), new Object[0]);
    }
    else
    {
      paramCall = "";
    }
    if (this.b != null)
    {
      paramResponse = null;
      try
      {
        paramCall = new JSONObject(paramCall);
      }
      catch (JSONException paramCall)
      {
        localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResponse JSONException e = ");
        localStringBuilder.append(paramCall);
        ((LogInterface)localObject).i("CommonCallback", localStringBuilder.toString(), new Object[0]);
        paramCall = paramResponse;
      }
      this.a.post(new CommonCallback.3(this, paramCall));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CommonCallback
 * JD-Core Version:    0.7.0.1
 */