package com.tencent.mtt.abtestsdk.abtest;

import com.tencent.mtt.abtestsdk.listener.GetConfigListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.conn.ConnectTimeoutException;

class RemoteConfigClient$OnConfigResCallBack
  implements Callback
{
  private GetConfigListener mListener;
  
  public RemoteConfigClient$OnConfigResCallBack(RemoteConfigClient paramRemoteConfigClient, GetConfigListener paramGetConfigListener)
  {
    this.mListener = paramGetConfigListener;
  }
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("config onFailure: ");
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
    RemoteConfigClient.access$000(this.this$0, i, paramCall, this.mListener);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = paramResponse.body();
    if (paramCall != null) {
      paramCall = new String(paramCall.bytes(), "UTF-8");
    } else {
      paramCall = "";
    }
    ABTestLog.configUpload(String.format("get config response data: %s", new Object[] { paramCall }), new Object[0]);
    RemoteConfigClient.access$100(this.this$0, paramCall, this.mListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.RemoteConfigClient.OnConfigResCallBack
 * JD-Core Version:    0.7.0.1
 */