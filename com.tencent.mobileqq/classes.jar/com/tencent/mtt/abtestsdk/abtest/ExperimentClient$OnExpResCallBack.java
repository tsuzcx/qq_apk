package com.tencent.mtt.abtestsdk.abtest;

import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.conn.ConnectTimeoutException;

class ExperimentClient$OnExpResCallBack
  implements Callback
{
  private String mExpName;
  private OnUpdateExperimentsListener mListener;
  
  public ExperimentClient$OnExpResCallBack(ExperimentClient paramExperimentClient, String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener)
  {
    this.mExpName = paramString;
    this.mListener = paramOnUpdateExperimentsListener;
  }
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("experiment onFailure: ");
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
    ExperimentClient.access$000(this.this$0, i, paramCall, this.mListener);
    if ((TextUtils.isEmpty(this.mExpName)) && (!ExperimentClient.access$100()))
    {
      paramCall = ExperimentClient.access$200(this.this$0).iterator();
      while (paramCall.hasNext()) {
        ((ExpInitListener)paramCall.next()).expInitFailed();
      }
      ExperimentClient.access$102(true);
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = paramResponse.body();
    if (paramCall != null) {
      paramCall = new String(paramCall.bytes(), "UTF-8");
    } else {
      paramCall = "";
    }
    ABTestLog.expUpload(String.format("get exp response data: %s", new Object[] { paramCall }), new Object[0]);
    ExperimentClient.access$300(this.this$0, paramCall, this.mExpName, this.mListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.ExperimentClient.OnExpResCallBack
 * JD-Core Version:    0.7.0.1
 */