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
    ViolaLogUtils.d("ViolaReportManager", "postDataToBeacon finish,resCode=" + i + ",eventName=" + this.val$eventName + ",data=" + this.val$hashMap.toString() + ",size=" + this.val$hashMap.size());
  }
  
  public void onHttpStart()
  {
    ViolaLogUtils.d("ViolaReportManager", "postDataToBeacon start,eventName=" + this.val$eventName + ",data=" + this.val$hashMap.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager.2
 * JD-Core Version:    0.7.0.1
 */