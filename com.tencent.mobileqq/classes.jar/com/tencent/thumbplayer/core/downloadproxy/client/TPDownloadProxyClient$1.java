package com.tencent.thumbplayer.core.downloadproxy.client;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.List;
import java.util.Map;

class TPDownloadProxyClient$1
  extends ITPPlayListenerAidl.Stub
{
  TPDownloadProxyClient$1(TPDownloadProxyClient paramTPDownloadProxyClient, ITPPlayListener paramITPPlayListener) {}
  
  public long getAdvRemainTime()
  {
    return this.val$playListener.getAdvRemainTime();
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    return this.val$playListener.getContentType(paramInt, paramString);
  }
  
  public int getCurrentPlayClipNo()
  {
    return this.val$playListener.getCurrentPlayClipNo();
  }
  
  public long getCurrentPosition()
  {
    return this.val$playListener.getCurrentPosition();
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    return this.val$playListener.getDataFilePath(paramInt, paramString);
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    return this.val$playListener.getDataTotalSize(paramInt, paramString);
  }
  
  public String getPlayInfo(String paramString)
  {
    paramString = this.val$playListener.getPlayInfo(paramString);
    if ((paramString != null) && (paramString.getClass() == String.class))
    {
      if (paramString.getClass() == String.class) {
        return (String)paramString;
      }
      if (paramString.getClass() == Integer.class) {
        return Integer.toString(((Integer)paramString).intValue());
      }
    }
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    return this.val$playListener.getPlayerBufferLength();
  }
  
  public void onDownloadCdnUrlExpired(Map paramMap)
  {
    this.val$playListener.onDownloadCdnUrlExpired(paramMap);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.val$playListener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    this.val$playListener.onDownloadCdnUrlUpdate(paramString);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    this.val$playListener.onDownloadError(paramInt1, paramInt2, paramString);
  }
  
  public void onDownloadFinish()
  {
    this.val$playListener.onDownloadFinish();
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    this.val$playListener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    this.val$playListener.onDownloadProtocolUpdate(paramString1, paramString2);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    this.val$playListener.onDownloadStatusUpdate(paramInt);
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    this.val$playListener.onPcdnDownloadFailed(paramString);
  }
  
  public int onPlayCallback(int paramInt, List paramList)
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = localInteger;
    if (paramList != null)
    {
      localObject = localInteger;
      if (!paramList.isEmpty()) {
        if (paramList.size() == 1)
        {
          localObject = this.val$playListener.onPlayCallback(paramInt, paramList.get(0), null, null, null);
        }
        else if (paramList.size() == 2)
        {
          localObject = this.val$playListener.onPlayCallback(paramInt, paramList.get(0), paramList.get(1), null, null);
        }
        else
        {
          localObject = localInteger;
          if (paramList.size() == 3) {
            localObject = this.val$playListener.onPlayCallback(paramInt, paramList.get(0), paramList.get(1), paramList.get(2), null);
          }
        }
      }
    }
    if (localObject.getClass() != Integer.class) {
      return -1;
    }
    return ((Integer)localObject).intValue();
  }
  
  public void onQuicDownloadStatusUpdate(String paramString)
  {
    this.val$playListener.onQuicDownloadStatusUpdate(paramString);
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return this.val$playListener.onReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return this.val$playListener.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    return this.val$playListener.onStopReadData(paramInt1, paramString, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.1
 * JD-Core Version:    0.7.0.1
 */