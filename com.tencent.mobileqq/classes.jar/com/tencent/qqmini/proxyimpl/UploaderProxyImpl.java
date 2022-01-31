package com.tencent.qqmini.proxyimpl;

import com.squareup.okhttp.Call;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UploaderProxyImpl
  extends UploaderProxy
{
  private static final String TAG = "UploaderProxyImpl";
  public ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap();
  
  public void abort(String paramString)
  {
    Call localCall = (Call)this.taskMap.get(paramString);
    if (localCall != null) {
      localCall.cancel();
    }
    this.taskMap.remove(paramString);
  }
  
  public boolean upload(String paramString1, Map<String, String> paramMap1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap2, int paramInt, UploaderProxy.UploadListener paramUploadListener)
  {
    TTHandleThread.a().b(new UploaderProxyImpl.1(this, paramString1, paramMap1, paramString2, paramMap2, paramString3, paramString4, paramUploadListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl
 * JD-Core Version:    0.7.0.1
 */