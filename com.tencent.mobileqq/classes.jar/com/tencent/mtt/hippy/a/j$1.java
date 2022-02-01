package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class j$1
  implements HippyHttpAdapter.HttpTaskCallback
{
  j$1(j paramj, a parama, String paramString) {}
  
  public void onTaskFailed(HippyHttpRequest paramHippyHttpRequest, Throwable paramThrowable)
  {
    paramHippyHttpRequest = this.a;
    if (paramHippyHttpRequest != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not connect to development server.URL: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append("  try to :adb reverse tcp:38989 tcp:38989 , message : ");
      localStringBuilder.append(paramThrowable.getMessage());
      paramHippyHttpRequest.a(new i(localStringBuilder.toString()));
    }
  }
  
  public void onTaskSuccess(HippyHttpRequest paramHippyHttpRequest, HippyHttpResponse paramHippyHttpResponse)
  {
    if (this.a == null) {
      return;
    }
    if ((paramHippyHttpResponse.getStatusCode().intValue() == 200) && (paramHippyHttpResponse.getInputStream() != null))
    {
      this.a.a(paramHippyHttpResponse.getInputStream());
      return;
    }
    Object localObject;
    if (paramHippyHttpResponse.getErrorStream() != null)
    {
      paramHippyHttpRequest = new StringBuffer();
      paramHippyHttpResponse = new BufferedReader(new InputStreamReader(paramHippyHttpResponse.getErrorStream(), "UTF-8"));
      for (;;)
      {
        localObject = paramHippyHttpResponse.readLine();
        if (localObject == null) {
          break;
        }
        paramHippyHttpRequest.append((String)localObject);
        paramHippyHttpRequest.append("\r\n");
      }
      paramHippyHttpRequest = paramHippyHttpRequest.toString();
    }
    else
    {
      paramHippyHttpRequest = "unknown";
    }
    paramHippyHttpResponse = this.a;
    if (paramHippyHttpResponse != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not connect to development server.URL: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("  try to :adb reverse tcp:38989 tcp:38989 , message : ");
      ((StringBuilder)localObject).append(paramHippyHttpRequest);
      paramHippyHttpResponse.a(new i(((StringBuilder)localObject).toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.j.1
 * JD-Core Version:    0.7.0.1
 */