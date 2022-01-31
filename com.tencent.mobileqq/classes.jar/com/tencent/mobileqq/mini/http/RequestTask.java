package com.tencent.mobileqq.mini.http;

import com.squareup.okhttp.Call;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class RequestTask
  implements Runnable
{
  public static final String CONTENT_TYPE = "content-type";
  private static final String DEFAULT_DATA_TYPE = "application/json";
  private static final String TAG = "RequestTask";
  private static final ArrayList<String> supportMethod = new ArrayList(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE" }));
  private RequestConfig mConfig;
  public AtomicBoolean mIsAbort = new AtomicBoolean(false);
  private Call mOkHttpCall;
  private RequestTask.Request mRequest;
  
  public RequestTask(RequestTask.Request paramRequest)
  {
    this.mRequest = paramRequest;
    this.mConfig = new RequestConfig();
    this.mConfig.mNetworkTimeOut = this.mRequest.mTimeOut;
  }
  
  public void abort()
  {
    this.mIsAbort.getAndSet(true);
    if (this.mOkHttpCall != null) {
      this.mOkHttpCall.cancel();
    }
    ThreadManagerV2.removeJobFromThreadPool(this, 128);
  }
  
  public void run()
  {
    if (this.mRequest != null)
    {
      if (!this.mIsAbort.get()) {
        break label42;
      }
      WxRequest.removeTaskInMap(this.mRequest.mTaskId);
      this.mRequest.mCallback.httpCallBack(-5, null, null);
    }
    label42:
    while (!this.mRequest.preParse()) {
      return;
    }
    String[] arrayOfString = MiniappHttpUtil.mapToString(this.mRequest.mHeaders);
    RequestTask.1 local1 = new RequestTask.1(this);
    Object localObject = this.mRequest.mMethod.toUpperCase();
    if (!supportMethod.contains(localObject))
    {
      this.mRequest.mCallback.httpCallBack(-3, null, null);
      return;
    }
    if (((String)localObject).equals("GET"))
    {
      this.mOkHttpCall = MiniappHttpUtil.httpGetV2(this.mRequest.mUrl, arrayOfString, local1, this.mConfig);
      return;
    }
    if (((String)localObject).equals("POST"))
    {
      this.mOkHttpCall = MiniappHttpUtil.httpPostV2(this.mRequest.mUrl, this.mRequest.mBody, arrayOfString, local1, this.mConfig);
      return;
    }
    String str1 = this.mRequest.mMethod;
    String str2 = this.mRequest.mUrl;
    if (this.mRequest.mBody == null) {}
    for (localObject = new byte[1];; localObject = this.mRequest.mBody)
    {
      this.mOkHttpCall = MiniappHttpUtil.httpSendV2(str1, str2, (byte[])localObject, arrayOfString, local1, this.mConfig);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.RequestTask
 * JD-Core Version:    0.7.0.1
 */