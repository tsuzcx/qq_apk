package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.TPFutureResult;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

class TPPlayManagerImpl$InnerProxyListener
  implements ITPPlayListener
{
  private TPPlayManagerImpl$InnerProxyListener(TPPlayManagerImpl paramTPPlayManagerImpl) {}
  
  public long getAdvRemainTime()
  {
    return TPPlayManagerImpl.access$400(this.this$0).getAdvRemainTime();
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    return TPPlayManagerImpl.access$400(this.this$0).getContentType(paramInt, paramString);
  }
  
  public int getCurrentPlayClipNo()
  {
    return TPPlayManagerImpl.access$400(this.this$0).getCurrentPlayClipNo();
  }
  
  public long getCurrentPosition()
  {
    return TPPlayManagerImpl.access$400(this.this$0).getCurrentPosition();
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    return TPPlayManagerImpl.access$400(this.this$0).getDataFilePath(paramInt, paramString);
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    return TPPlayManagerImpl.access$400(this.this$0).getDataTotalSize(paramInt, paramString);
  }
  
  public Object getPlayInfo(long paramLong)
  {
    TPFutureResult localTPFutureResult = new TPFutureResult();
    TPPlayManagerImpl.TPMessageParams localTPMessageParams = new TPPlayManagerImpl.TPMessageParams(null);
    localTPMessageParams.params = Long.valueOf(paramLong);
    localTPMessageParams.result = localTPFutureResult;
    TPPlayManagerImpl.access$100(this.this$0, 4105, localTPMessageParams);
    return TPPlayManagerImpl.access$700(this.this$0, localTPFutureResult);
  }
  
  public Object getPlayInfo(String paramString)
  {
    TPFutureResult localTPFutureResult = new TPFutureResult();
    TPPlayManagerImpl.TPMessageParams localTPMessageParams = new TPPlayManagerImpl.TPMessageParams(null);
    localTPMessageParams.params = paramString;
    localTPMessageParams.result = localTPFutureResult;
    TPPlayManagerImpl.access$100(this.this$0, 4107, localTPMessageParams);
    return TPPlayManagerImpl.access$700(this.this$0, localTPFutureResult);
  }
  
  public long getPlayerBufferLength()
  {
    return TPPlayManagerImpl.access$400(this.this$0).getPlayerBufferLength();
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    TPPlayManagerImpl.access$100(this.this$0, 4103, paramMap);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    localTPCDNURLInfo.errorStr = paramString4;
    TPPlayManagerImpl.access$100(this.this$0, 4100, localTPCDNURLInfo);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    TPPlayManagerImpl.access$100(this.this$0, 4099, paramString);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    if (TPPlayManagerImpl.access$200(this.this$0, paramString))
    {
      TPPlayManagerImpl.access$300(this.this$0, 4098, paramInt1, 14011001, paramString, false, false, 0L);
      return;
    }
    TPPlayManagerImpl.access$300(this.this$0, 4098, paramInt1, paramInt2, paramString, false, false, 0L);
  }
  
  public void onDownloadFinish()
  {
    TPPlayManagerImpl.access$100(this.this$0, 4097, null);
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    TPPlayManagerImpl.access$100(this.this$0, 4106, localTPDownLoadProgressInfo);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    TPPlayManagerImpl.access$100(this.this$0, 4102, localTPProtocolInfo);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    TPPlayManagerImpl.access$300(this.this$0, 4101, paramInt, 0, null, false, false, 0L);
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPcdnDownloadFailed: ");
    localStringBuilder.append(paramString);
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
    TPPlayManagerImpl.access$400(this.this$0).onPcdnDownloadFailed(paramString);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    TPPlayManagerImpl.TPOnPlayCallBackParams localTPOnPlayCallBackParams = new TPPlayManagerImpl.TPOnPlayCallBackParams(null);
    localTPOnPlayCallBackParams.messageType = paramInt;
    localTPOnPlayCallBackParams.ext1 = paramObject1;
    localTPOnPlayCallBackParams.ext2 = paramObject2;
    localTPOnPlayCallBackParams.ext3 = paramObject3;
    localTPOnPlayCallBackParams.ext4 = paramObject4;
    paramObject1 = new TPFutureResult();
    paramObject2 = new TPPlayManagerImpl.TPMessageParams(null);
    paramObject2.params = localTPOnPlayCallBackParams;
    paramObject2.result = paramObject1;
    TPPlayManagerImpl.access$100(this.this$0, 4104, paramObject2);
    return TPPlayManagerImpl.access$700(this.this$0, paramObject1);
  }
  
  public void onQuicDownloadStatusUpdate(String paramString)
  {
    TPPlayManagerImpl.access$400(this.this$0).onQuicDownloadStatusUpdate(paramString);
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return TPPlayManagerImpl.access$400(this.this$0).onReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return TPPlayManagerImpl.access$400(this.this$0).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    return TPPlayManagerImpl.access$400(this.this$0).onStopReadData(paramInt1, paramString, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl.InnerProxyListener
 * JD-Core Version:    0.7.0.1
 */