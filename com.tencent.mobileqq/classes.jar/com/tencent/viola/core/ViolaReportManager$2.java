package com.tencent.viola.core;

import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ViolaReportManager$2
  implements IHttpAdapter.OnHttpListener
{
  ViolaReportManager$2(ViolaReportManager paramViolaReportManager, String paramString, HashMap paramHashMap) {}
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    int i = Integer.parseInt(paramHttpResponse.statusCode);
    paramHttpResponse = new StringBuilder();
    paramHttpResponse.append("postDataToBeacon finish,resCode=");
    paramHttpResponse.append(i);
    paramHttpResponse.append(",eventName=");
    paramHttpResponse.append(this.val$eventName);
    paramHttpResponse.append(",data=");
    paramHttpResponse.append(this.val$hashMap.toString());
    paramHttpResponse.append(",size=");
    paramHttpResponse.append(this.val$hashMap.size());
    ViolaLogUtils.d("ViolaReportManager", paramHttpResponse.toString());
  }
  
  public void onHttpStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("postDataToBeacon start,eventName=");
    localStringBuilder.append(this.val$eventName);
    localStringBuilder.append(",data=");
    localStringBuilder.append(this.val$hashMap.toString());
    ViolaLogUtils.d("ViolaReportManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager.2
 * JD-Core Version:    0.7.0.1
 */