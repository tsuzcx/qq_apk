package com.tencent.viola.core;

import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.List;
import java.util.Map;

class ViolaReportManager$3
  implements IHttpAdapter.OnHttpListener
{
  ViolaReportManager$3(ViolaReportManager paramViolaReportManager) {}
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    int i = Integer.parseInt(paramHttpResponse.statusCode);
    ViolaLogUtils.d("ViolaReportManager", "postToBeaconTest finish,resCode=" + i + ",eventName=default");
  }
  
  public void onHttpStart()
  {
    ViolaLogUtils.d("ViolaReportManager", "postToBeaconTest start,eventName=default");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager.3
 * JD-Core Version:    0.7.0.1
 */