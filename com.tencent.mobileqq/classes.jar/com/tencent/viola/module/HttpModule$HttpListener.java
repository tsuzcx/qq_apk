package com.tencent.viola.module;

import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HttpModule$HttpListener
  implements IHttpAdapter.OnHttpListener
{
  private long mHttpStartTime;
  private Map<String, String> mRespHeaders;
  private Map<String, Object> mResponse = new HashMap();
  private HttpModule.ResponseCallback mResponseCallback;
  
  public HttpModule$HttpListener(HttpModule paramHttpModule, HttpModule.ResponseCallback paramResponseCallback)
  {
    this.mResponseCallback = paramResponseCallback;
  }
  
  public void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    this.mResponse.put("readyState", Integer.valueOf(2));
    this.mResponse.put("status", Integer.valueOf(paramInt));
    HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((List)localEntry.getValue()).size() > 0)
        {
          if (localEntry.getKey() == null) {
            paramMap = "_";
          } else {
            paramMap = (String)localEntry.getKey();
          }
          localHashMap.put(paramMap, ((List)localEntry.getValue()).get(0));
        }
      }
    }
    this.mResponse.put("headers", localHashMap);
    this.mRespHeaders = localHashMap;
  }
  
  public void onHttpFinish(HttpResponse paramHttpResponse)
  {
    Object localObject = this.mResponseCallback;
    if (localObject != null) {
      ((HttpModule.ResponseCallback)localObject).onResponse(paramHttpResponse, this.mRespHeaders);
    }
    if ((this.this$0.getViolaInstance() != null) && (this.mHttpStartTime != 0L))
    {
      localObject = this.this$0.getViolaInstance();
      long l1 = System.currentTimeMillis();
      long l2 = this.mHttpStartTime;
      int i;
      if (paramHttpResponse.originalData != null) {
        i = paramHttpResponse.originalData.length;
      } else {
        i = 0;
      }
      ((ViolaInstance)localObject).setHttpReportData(l1 - l2, i);
      this.mHttpStartTime = 0L;
    }
  }
  
  public void onHttpStart()
  {
    this.mHttpStartTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule.HttpListener
 * JD-Core Version:    0.7.0.1
 */