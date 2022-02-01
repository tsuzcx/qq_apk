package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ProxyService(proxy=RequestProxy.class)
public class RequestProxyDefault
  extends RequestProxy
{
  public ConcurrentHashMap<String, RequestProxyDefault.RequestTask> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    ((RequestProxyDefault.RequestTask)this.taskMap.get(paramString)).mAbort = true;
    this.taskMap.remove(paramString);
  }
  
  public boolean request(String paramString1, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString2, int paramInt, RequestProxy.RequestListener paramRequestListener)
  {
    paramArrayOfByte = new RequestProxyDefault.RequestTask(this, paramString1, paramArrayOfByte, paramMap, paramString2.toUpperCase(), paramInt, paramRequestListener);
    this.taskMap.put(paramString1, paramArrayOfByte);
    ThreadManager.executeOnNetworkIOThreadPool(paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault
 * JD-Core Version:    0.7.0.1
 */