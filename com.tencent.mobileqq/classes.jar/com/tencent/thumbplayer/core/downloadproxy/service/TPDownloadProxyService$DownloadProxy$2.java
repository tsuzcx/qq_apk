package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TPDownloadProxyService$DownloadProxy$2
  implements ITPPlayListener
{
  TPDownloadProxyService$DownloadProxy$2(TPDownloadProxyService.DownloadProxy paramDownloadProxy, ITPPlayListenerAidl paramITPPlayListenerAidl) {}
  
  public long getAdvRemainTime()
  {
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getAdvRemainTime();
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAdvRemainTime failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1L;
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getContentType(paramInt, paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getContentType key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return "";
  }
  
  public int getCurrentPlayClipNo()
  {
    try
    {
      if (this.val$playListener != null)
      {
        int i = this.val$playListener.getCurrentPlayClipNo();
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPlayClipNo failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
  
  public long getCurrentPosition()
  {
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getCurrentPosition();
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPosition failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1L;
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getDataFilePath(paramInt, paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDataFilePath key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return "";
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getDataTotalSize(paramInt, paramString);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDataTotalSize key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    try
    {
      if (this.val$playListener != null)
      {
        String str = this.val$playListener.getPlayInfo(Long.toString(paramLong));
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayInfo type failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramString = this.val$playListener.getPlayInfo(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayInfo key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    try
    {
      if (this.val$playListener != null)
      {
        long l = this.val$playListener.getPlayerBufferLength();
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayerBufferLength failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadCdnUrlExpired(paramMap);
        return;
      }
    }
    catch (Throwable paramMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadCdnUrlExpired failed, error:");
      localStringBuilder.append(paramMap.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onDownloadCdnUrlInfoUpdate failed, error:");
      paramString2.append(paramString1.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramString2.toString());
    }
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadCdnUrlUpdate(paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadCdnUrlUpdate failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadError(paramInt1, paramInt2, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadError failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onDownloadFinish()
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadFinish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadProgressUpdate failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadProtocolUpdate(paramString1, paramString2);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onDownloadProtocolUpdate failed, error:");
      paramString2.append(paramString1.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramString2.toString());
    }
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onDownloadStatusUpdate(paramInt);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadStatusUpdate failed, error:");
      localStringBuilder.append(localThrowable.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onPcdnDownloadFailed(paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPcdnDownloadFailed failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    try
    {
      paramObject4 = new ArrayList();
      if (paramObject1 != null) {
        paramObject4.add(paramObject1);
      }
      if (paramObject1 != null) {
        paramObject4.add(paramObject2);
      }
      if (paramObject1 != null) {
        paramObject4.add(paramObject3);
      }
      if (this.val$playListener != null) {
        this.val$playListener.onPlayCallback(paramInt, paramObject4);
      }
    }
    catch (Throwable paramObject1)
    {
      paramObject2 = new StringBuilder();
      paramObject2.append("onPlayCallback failed, error:");
      paramObject2.append(paramObject1.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramObject2.toString());
    }
    return null;
  }
  
  public void onQuicDownloadStatusUpdate(String paramString)
  {
    try
    {
      if (this.val$playListener != null)
      {
        this.val$playListener.onQuicDownloadStatusUpdate(paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQuicDownloadStatusUpdate failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramInt = this.val$playListener.onReadData(paramInt, paramString, paramLong1, paramLong2);
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReadData key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramInt = this.val$playListener.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartReadData key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      if (this.val$playListener != null)
      {
        paramInt1 = this.val$playListener.onStopReadData(paramInt1, paramString, paramInt2);
        return paramInt1;
      }
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStopReadData key failed, error:");
      localStringBuilder.append(paramString.toString());
      TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", localStringBuilder.toString());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */