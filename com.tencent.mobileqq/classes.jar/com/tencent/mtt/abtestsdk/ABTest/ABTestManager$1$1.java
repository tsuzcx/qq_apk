package com.tencent.mtt.abtestsdk.ABTest;

import android.os.Message;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

class ABTestManager$1$1
  implements Callback
{
  ABTestManager$1$1(ABTestManager.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    ABTestLog.error(paramIOException.getMessage(), new Object[0]);
    int i = 1002;
    paramCall = "unknown error";
    if ((paramIOException instanceof SocketTimeoutException))
    {
      i = 1003;
      paramCall = "socket_timeout_error";
    }
    for (;;)
    {
      this.this$1.msg.arg1 = i;
      this.this$1.msg.obj = paramCall;
      this.this$1.msg.what = 1;
      this.this$1.msg.sendToTarget();
      return;
      if ((paramIOException instanceof ConnectTimeoutException))
      {
        i = 1004;
        paramCall = "connectTimeout error";
      }
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = paramResponse.body();
    if (paramCall != null) {}
    for (paramCall = new String(paramCall.bytes(), "utf-8");; paramCall = "")
    {
      ABTestLog.stepUpload("get res from network:" + paramCall, new Object[0]);
      if (!paramCall.contains("<html>")) {
        break;
      }
      this.this$1.msg.arg1 = 1002;
      this.this$1.msg.obj = "unknown error";
      this.this$1.msg.what = 1;
      this.this$1.msg.sendToTarget();
      return;
    }
    try
    {
      if (new JSONObject(paramCall).optInt("code") != 0)
      {
        this.this$1.msg.arg1 = 1006;
        this.this$1.msg.obj = "server error";
        this.this$1.msg.what = 1;
        this.this$1.msg.sendToTarget();
        return;
      }
    }
    catch (JSONException paramResponse)
    {
      paramResponse.printStackTrace();
      ABTestManager.access$200(this.this$1.this$0, paramCall, this.this$1.val$expName);
      ABTestManager.access$300(this.this$1.this$0, paramCall, this.this$1.val$expName);
      this.this$1.this$0.saveConfigInfo();
      ABTestManager.access$400(this.this$1.this$0, paramCall);
      this.this$1.msg.obj = paramCall;
      this.this$1.msg.what = 0;
      this.this$1.msg.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager.1.1
 * JD-Core Version:    0.7.0.1
 */