package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DownloaderProxyImpl
  extends DownloaderProxy
{
  private static final String TAG = "DownloaderProxyImpl";
  public ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Call localCall = (Call)this.taskMap.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    this.taskMap.remove(paramString);
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    paramMap = MiniOkHttpClientFactory.getDownloadClient(true).newCall(HttpUtil.buildRequest(paramString1, paramMap, "GET", null, null));
    paramMap.enqueue(new DownloaderProxyImpl.1(this, paramString1, paramDownloadListener, paramString2));
    this.taskMap.put(paramString1, paramMap);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.DownloaderProxyImpl
 * JD-Core Version:    0.7.0.1
 */