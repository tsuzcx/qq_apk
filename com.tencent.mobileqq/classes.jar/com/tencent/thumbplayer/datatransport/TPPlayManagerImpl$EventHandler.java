package com.tencent.thumbplayer.datatransport;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.TPFutureResult;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

@SuppressLint({"HandlerLeak"})
class TPPlayManagerImpl$EventHandler
  extends Handler
{
  public TPPlayManagerImpl$EventHandler(TPPlayManagerImpl paramTPPlayManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (TPPlayManagerImpl.access$400(this.this$0) == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "handleMessage failed, mPlayListener is null and return");
      return;
    }
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4107: 
      paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
      localObject = TPPlayManagerImpl.access$400(this.this$0).getPlayInfo((String)paramMessage.params);
      paramMessage.result.setResult(localObject);
      return;
    case 4106: 
      paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
      TPPlayManagerImpl.access$400(this.this$0).onDownloadProgressUpdate((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize, paramMessage.extraInfo);
      return;
    case 4105: 
      paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
      localObject = TPPlayManagerImpl.access$400(this.this$0).getPlayInfo(((Long)paramMessage.params).longValue());
      paramMessage.result.setResult(localObject);
      return;
    case 4104: 
      paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
      localObject = (TPPlayManagerImpl.TPOnPlayCallBackParams)paramMessage.params;
      localObject = TPPlayManagerImpl.access$400(this.this$0).onPlayCallback(((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).messageType, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext1, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext2, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext3, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext4);
      paramMessage.result.setResult(localObject);
      return;
    case 4103: 
      TPPlayManagerImpl.access$400(this.this$0).onDownloadCdnUrlExpired((Map)paramMessage.obj);
      return;
    case 4102: 
      paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
      TPPlayManagerImpl.access$400(this.this$0).onDownloadProtocolUpdate(paramMessage.protocolName, paramMessage.protocolVersion);
      return;
    case 4101: 
      TPPlayManagerImpl.access$400(this.this$0).onDownloadStatusUpdate(paramMessage.arg1);
      return;
    case 4100: 
      paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
      TPPlayManagerImpl.access$400(this.this$0).onDownloadCdnUrlInfoUpdate(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp, paramMessage.errorStr);
      return;
    case 4099: 
      TPPlayManagerImpl.access$400(this.this$0).onDownloadCdnUrlUpdate((String)paramMessage.obj);
      return;
    case 4098: 
      TPPlayManagerImpl.access$400(this.this$0).onDownloadError(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
    }
    TPPlayManagerImpl.access$400(this.this$0).onDownloadFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl.EventHandler
 * JD-Core Version:    0.7.0.1
 */