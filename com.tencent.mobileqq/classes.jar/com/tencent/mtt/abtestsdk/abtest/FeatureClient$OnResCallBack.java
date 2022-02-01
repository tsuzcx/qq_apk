package com.tencent.mtt.abtestsdk.abtest;

import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.conn.ConnectTimeoutException;

class FeatureClient$OnResCallBack
  implements Callback
{
  private String featureKey;
  private GetFeatureListener featureListener;
  
  public FeatureClient$OnResCallBack(FeatureClient paramFeatureClient, GetFeatureListener paramGetFeatureListener, String paramString)
  {
    this.featureListener = paramGetFeatureListener;
    this.featureKey = paramString;
  }
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("feature onFailure ");
    paramCall.append(paramIOException.getMessage());
    ABTestLog.error(paramCall.toString(), new Object[0]);
    int i;
    if ((paramIOException instanceof SocketTimeoutException))
    {
      i = 1003;
      paramCall = "socket_timeout_error";
    }
    else if ((paramIOException instanceof ConnectTimeoutException))
    {
      i = 1004;
      paramCall = "connectTimeout error";
    }
    else
    {
      i = 1002;
      paramCall = "unknown error";
    }
    FeatureClient.access$000(this.this$0, i, paramCall, this.featureListener);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = paramResponse.body();
    if (paramCall != null) {
      paramCall = new String(paramCall.bytes(), "UTF-8");
    } else {
      paramCall = "";
    }
    ABTestLog.featureUpload(String.format("get feature response data: %s", new Object[] { paramCall }), new Object[0]);
    FeatureClient.access$100(this.this$0, paramCall, this.featureListener, this.featureKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.FeatureClient.OnResCallBack
 * JD-Core Version:    0.7.0.1
 */