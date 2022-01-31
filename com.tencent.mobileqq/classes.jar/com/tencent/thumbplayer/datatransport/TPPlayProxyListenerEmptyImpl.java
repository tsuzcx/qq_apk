package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

public class TPPlayProxyListenerEmptyImpl
  implements ITPPreloadProxy.IPreloadListener, ITPPlayListener
{
  private String tag;
  
  public TPPlayProxyListenerEmptyImpl(String paramString)
  {
    this.tag = paramString;
  }
  
  public long getAdvRemainTime()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getAdvRemainTime");
    return 0L;
  }
  
  public int getCurrentPlayClipNo()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getCurrentPlayClipNo");
    return 0;
  }
  
  public long getCurrentPosition()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getCurrentPosition");
    return 0L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getPlayInfo with type : " + paramLong);
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getPlayInfo with key : " + paramString);
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , getPlayerBufferLength");
    return 0L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString) {}
  
  public void onDownloadFinish() {}
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , onPlayProgress, current : " + paramLong1 + ", total : " + paramLong2);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt) {}
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , onPlayCallback, messageType : " + paramInt + ",ext1:" + paramObject1 + ",ext2:" + paramObject2 + ",ext3" + paramObject3 + ",ext4" + paramObject4);
    return null;
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void onPrepareError()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , onPrepareError : ");
  }
  
  public void onPrepareSuccess()
  {
    TPLogUtil.i(this.tag, " empty proxy player listener , notify , onPrepareSuccess : ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayProxyListenerEmptyImpl
 * JD-Core Version:    0.7.0.1
 */