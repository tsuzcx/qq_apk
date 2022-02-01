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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString3);
    TPLogUtil.d(paramString2, localStringBuilder.toString());
    return 0;
  }
  
  public int e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString3);
    TPLogUtil.e(paramString2, localStringBuilder.toString());
    return 0;
  }
  
  public int i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString3);
    TPLogUtil.i(paramString2, localStringBuilder.toString());
    return 0;
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    TPPreloadProxyImpl.access$100(this.this$0).onInfo(2101, 0L, 0L, paramString);
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    TPPreloadProxyImpl.access$100(this.this$0).onPrepareDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString3);
    TPLogUtil.w(paramString2, localStringBuilder.toString());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl.InnerProxyListener
 * JD-Core Version:    0.7.0.1
 */