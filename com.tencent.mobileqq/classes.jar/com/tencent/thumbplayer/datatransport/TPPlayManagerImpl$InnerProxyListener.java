package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.Map;

class TPPlayManagerImpl$InnerProxyListener
  implements ITPPlayListener
{
  private TPPlayManagerImpl$InnerProxyListener(TPPlayManagerImpl paramTPPlayManagerImpl) {}
  
  public long getAdvRemainTime()
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return 0L;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getAdvRemainTime();
  }
  
  public int getCurrentPlayClipNo()
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return 0;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getCurrentPlayClipNo();
  }
  
  public long getCurrentPosition()
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return 0L;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getCurrentPosition();
  }
  
  public Object getPlayInfo(long paramLong)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return null;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getPlayInfo(paramLong);
  }
  
  public Object getPlayInfo(String paramString)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return null;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getPlayInfo(paramString);
  }
  
  public long getPlayerBufferLength()
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return 0L;
    }
    return TPPlayManagerImpl.access$100(this.this$0).getPlayerBufferLength();
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadCdnUrlExpired(paramMap);
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadCdnUrlUpdate(paramString);
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null)
    {
      if (TPPlayManagerImpl.access$200(this.this$0, paramString)) {
        TPPlayManagerImpl.access$100(this.this$0).onDownloadError(paramInt1, 14011001, paramString);
      }
    }
    else {
      return;
    }
    TPPlayManagerImpl.access$100(this.this$0).onDownloadError(paramInt1, paramInt2, paramString);
  }
  
  public void onDownloadFinish()
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadFinish();
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadProtocolUpdate(paramString1, paramString2);
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) != null) {
      TPPlayManagerImpl.access$100(this.this$0).onDownloadStatusUpdate(paramInt);
    }
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (TPPlayManagerImpl.access$100(this.this$0) == null) {
      return null;
    }
    return TPPlayManagerImpl.access$100(this.this$0).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl.InnerProxyListener
 * JD-Core Version:    0.7.0.1
 */