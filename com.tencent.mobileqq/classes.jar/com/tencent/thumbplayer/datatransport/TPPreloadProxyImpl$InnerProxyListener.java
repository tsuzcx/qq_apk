package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPreloadProxyImpl$InnerProxyListener
  implements ITPDLProxyLogListener, ITPPreLoadListener
{
  private TPPreloadProxyImpl$InnerProxyListener(TPPreloadProxyImpl paramTPPreloadProxyImpl) {}
  
  public int d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.d(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public int e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.e(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public int i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.i(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    TPPreloadProxyImpl.access$100(this.this$0).onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onPrepareError(int paramInt1, int paramInt2, String paramString)
  {
    TPPreloadProxyImpl.access$100(this.this$0).onPrepareError();
  }
  
  public void onPrepareOK()
  {
    TPPreloadProxyImpl.access$100(this.this$0).onPrepareSuccess();
  }
  
  public int w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.w(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl.InnerProxyListener
 * JD-Core Version:    0.7.0.1
 */