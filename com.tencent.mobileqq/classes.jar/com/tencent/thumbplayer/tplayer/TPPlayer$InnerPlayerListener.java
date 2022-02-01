package com.tencent.thumbplayer.tplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.datatransport.resourceloader.ITPAssetResourceLoader;
import com.tencent.thumbplayer.log.TPBaseLogger;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

class TPPlayer$InnerPlayerListener
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener, ITPPlayListener
{
  TPPlayer$InnerPlayerListener(TPPlayer paramTPPlayer) {}
  
  public long getAdvRemainTime()
  {
    ITPPlayerProxyListener localITPPlayerProxyListener = TPPlayer.access$000(this.this$0).getTPPlayerProxyListener();
    if (localITPPlayerProxyListener != null) {
      return localITPPlayerProxyListener.getAdvRemainTimeMs();
    }
    return -1L;
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return "";
    }
    return TPPlayer.access$1600(this.this$0).getContentType(paramInt, paramString);
  }
  
  public int getCurrentPlayClipNo()
  {
    ITPPlayerAdapter localITPPlayerAdapter = TPPlayer.access$100(this.this$0);
    if (localITPPlayerAdapter != null) {
      return localITPPlayerAdapter.getCurrentPlayClipNo();
    }
    return 0;
  }
  
  public long getCurrentPosition()
  {
    return this.this$0.getCurrentPositionMs();
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return "";
    }
    return TPPlayer.access$1600(this.this$0).getDataFilePath(paramInt, paramString);
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return -1L;
    }
    return TPPlayer.access$1600(this.this$0).getDataTotalSize(paramInt, paramString);
  }
  
  public Object getPlayInfo(long paramLong)
  {
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    ITPPlayerAdapter localITPPlayerAdapter = TPPlayer.access$100(this.this$0);
    if (localITPPlayerAdapter != null) {
      return localITPPlayerAdapter.getPlayableDurationMs() - TPPlayer.access$100(this.this$0).getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$1000(this.this$0);
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.onAudioFrameOut(this.this$0, paramTPAudioFrameBuffer);
    }
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$1000(this.this$0);
    if (localTPPlayerListeners != null) {
      return localTPPlayerListeners.onAudioProcessFrameOut(this.this$0, paramTPPostProcessFrameBuffer);
    }
    return null;
  }
  
  public void onCompletion()
  {
    TPPlayer.access$200(this.this$0, 111, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(0)).build());
    TPPlayer.access$300(this.this$0, 260, 0, 0, null);
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    TPPlayer.access$700(this.this$0).info("onDownloadCdnUrlExpired");
    TPPlayer.access$300(this.this$0, 275, 0, 0, paramMap);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TPBaseLogger localTPBaseLogger = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadCdnUrlInfoUpdate, url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", cdnIp:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", uip:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", errorCodeStr:");
    localStringBuilder.append(paramString4);
    localTPBaseLogger.info(localStringBuilder.toString());
    paramString4 = new TPPlayerMsg.TPCDNURLInfo();
    paramString4.url = paramString1;
    paramString4.cdnIp = paramString2;
    paramString4.uIp = paramString3;
    TPPlayer.access$200(this.this$0, 201, 0, 0, null, new TPHashMapBuilder().put("url", paramString1).put("cdnip", paramString2).put("cdnuip", paramString3).build());
    TPPlayer.access$300(this.this$0, 270, 0, 0, paramString4);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    TPBaseLogger localTPBaseLogger = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadCdnUrlUpdate, url:");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    TPPlayer.access$300(this.this$0, 269, 0, 0, paramString);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    TPBaseLogger localTPBaseLogger = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadError, moduleID:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", extInfo:");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    TPPlayer.access$800(this.this$0, paramInt1, paramInt2);
    TPPlayer.access$300(this.this$0, 268, paramInt1, paramInt2, paramString);
  }
  
  public void onDownloadFinish()
  {
    TPPlayer.access$700(this.this$0).info("onDownloadFinish");
    TPPlayer.access$300(this.this$0, 271, 0, 0, Integer.valueOf(0));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    TPPlayer.access$700(this.this$0).info("onDownloadProgressUpdate");
    Object localObject = this.this$0;
    long l = paramInt1;
    TPPlayer.access$1102((TPPlayer)localObject, l);
    TPPlayer.access$1202(this.this$0, paramLong1);
    TPPlayer.access$1302(this.this$0, paramLong2);
    localObject = new TPPlayerMsg.TPDownLoadProgressInfo();
    ((TPPlayerMsg.TPDownLoadProgressInfo)localObject).playableDurationMS = l;
    ((TPPlayerMsg.TPDownLoadProgressInfo)localObject).downloadSpeedKBps = paramInt2;
    ((TPPlayerMsg.TPDownLoadProgressInfo)localObject).currentDownloadSize = paramLong1;
    ((TPPlayerMsg.TPDownLoadProgressInfo)localObject).totalFileSize = paramLong2;
    ((TPPlayerMsg.TPDownLoadProgressInfo)localObject).extraInfo = paramString;
    TPPlayer.access$200(this.this$0, 200, 0, 0, null, new TPHashMapBuilder().put("speed", Integer.valueOf(paramInt2)).put("spanId", paramString).build());
    TPPlayer.access$300(this.this$0, 274, 0, 0, localObject);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    Object localObject = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProtocolUpdate, protocol:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", protocolVer:");
    localStringBuilder.append(paramString2);
    ((TPBaseLogger)localObject).info(localStringBuilder.toString());
    localObject = new TPPlayerMsg.TPProtocolInfo();
    ((TPPlayerMsg.TPProtocolInfo)localObject).protocolVersion = paramString2;
    ((TPPlayerMsg.TPProtocolInfo)localObject).protocolName = paramString1;
    TPPlayer.access$200(this.this$0, 202, 0, 0, null, new TPHashMapBuilder().put("proto", paramString1).put("protover", paramString2).build());
    TPPlayer.access$300(this.this$0, 273, 0, 0, localObject);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    if (paramInt != TPPlayer.access$1400(this.this$0))
    {
      TPBaseLogger localTPBaseLogger = TPPlayer.access$700(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadStatusUpdate, status:");
      localStringBuilder.append(paramInt);
      localTPBaseLogger.info(localStringBuilder.toString());
      TPPlayer.access$1402(this.this$0, paramInt);
    }
    TPPlayer.access$300(this.this$0, 272, paramInt, 0, null);
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    String str = TPPlayer.access$000(this.this$0).getPlayErrorCodeStr();
    Object localObject2 = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError playerErrorCodeStr=");
    localStringBuilder.append(str);
    ((TPBaseLogger)localObject2).info(localStringBuilder.toString());
    int i = paramInt1;
    int j = paramInt2;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        j = Integer.parseInt(str);
        i = 4000;
      }
      catch (Exception localException)
      {
        TPPlayer.access$700(this.this$0).printException(localException);
        j = paramInt2;
        i = paramInt1;
      }
    }
    TPPlayer.access$800(this.this$0, i, j);
    Object localObject1 = TPPlayer.access$700(this.this$0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onError errorTypeReal=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", errorCodeReal=");
    ((StringBuilder)localObject2).append(j);
    ((TPBaseLogger)localObject1).info(((StringBuilder)localObject2).toString());
    localObject1 = new TPThreadSwitchCommons.TPSwitchCommonParams();
    ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject1).arg1 = paramLong1;
    ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject1).arg2 = paramLong2;
    TPPlayer.access$300(this.this$0, 262, i, j, localObject1);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPPlayer.access$400(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
    if (paramInt == 1011)
    {
      TPPlayer.access$500(this.this$0, paramObject);
      return;
    }
    if (paramInt == 1012)
    {
      TPPlayer.access$600(this.this$0, paramObject);
      return;
    }
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    localTPSwitchCommonParams.arg1 = paramLong1;
    localTPSwitchCommonParams.arg2 = paramLong2;
    localTPSwitchCommonParams.extraObject = paramObject;
    TPPlayer.access$300(this.this$0, 261, paramInt, 0, localTPSwitchCommonParams);
  }
  
  public void onPcdnDownloadFailed(String paramString)
  {
    TPBaseLogger localTPBaseLogger = TPPlayer.access$700(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPcdnDownloadFailed: ");
    localStringBuilder.append(paramString);
    localTPBaseLogger.info(localStringBuilder.toString());
    TPPlayer.access$300(this.this$0, 282, 0, 0, paramString);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      if (!(paramObject3 instanceof Integer))
      {
        TPPlayer.access$700(this.this$0).info("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
        return null;
      }
      paramObject1 = (Integer)paramObject3;
      TPPlayer.access$300(this.this$0, 278, paramObject1.intValue(), 0, null);
      return null;
    }
    TPPlayer.access$700(this.this$0).info("onDownloadNoMoreData");
    TPPlayer.access$300(this.this$0, 276, 0, 0, paramObject1);
    return null;
  }
  
  public void onPrepared()
  {
    TPPlayer.access$000(this.this$0).setProxyPlayState(0);
    Object localObject1 = TPPlayer.access$100(this.this$0).getPlaybackInfo();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((TPPlaybackInfo)localObject1).getWidth());
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(((TPPlaybackInfo)localObject1).getHeight());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = TPPlayer.access$100(this.this$0).getTrackInfo();
    if (localObject3 != null)
    {
      int m = localObject3.length;
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (localObject3[j].trackType == 2) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    localObject3 = this.this$0;
    localObject1 = new TPHashMapBuilder().put("playertype", Integer.valueOf(TPPlayer.access$100(this.this$0).getPlayerType())).put("definition", localObject2).put("rate", Long.valueOf(((TPPlaybackInfo)localObject1).getVideoBitRate())).put("duration", Long.valueOf(((TPPlaybackInfo)localObject1).getDurationMs())).put("fmt", ((TPPlaybackInfo)localObject1).getContainerFormat()).put("etime", Long.valueOf(System.currentTimeMillis()));
    boolean bool = true;
    if (k <= 1) {
      bool = false;
    }
    TPPlayer.access$200((TPPlayer)localObject3, 103, 0, 0, null, ((TPHashMapBuilder)localObject1).put("multitrack", Boolean.valueOf(bool)).build());
    TPPlayer.access$300(this.this$0, 257, 0, 0, null);
  }
  
  public void onQuicDownloadStatusUpdate(String paramString)
  {
    String str = TPPlayer.access$1500(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQuicDownloadStatusUpdate, info:");
    localStringBuilder.append(paramString);
    TPLogUtil.i(str, localStringBuilder.toString());
    TPPlayer.access$300(this.this$0, 281, 0, 0, paramString);
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return -1;
    }
    return TPPlayer.access$1600(this.this$0).onReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public void onSeekComplete()
  {
    TPPlayer.access$900(this.this$0);
    TPPlayer.access$200(this.this$0, 110, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("petime", Long.valueOf(this.this$0.getCurrentPositionMs())).build());
    TPPlayer.access$300(this.this$0, 263, 0, 0, null);
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return -1;
    }
    return TPPlayer.access$1600(this.this$0).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    TPPlayer.access$300(this.this$0, 277, paramInt1, paramInt2, null);
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    if (TPPlayer.access$1600(this.this$0) == null)
    {
      TPPlayer.access$700(this.this$0).error("mAssetResourceLoader not set");
      return -1;
    }
    return TPPlayer.access$1600(this.this$0).onStopReadData(paramInt1, paramString, paramInt2);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPPlayer.access$300(this.this$0, 265, 0, 0, paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    TPPlayer.access$300(this.this$0, 279, 0, 0, paramTPSubtitleFrameBuffer);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$1000(this.this$0);
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.onVideoFrameOut(this.this$0, paramTPVideoFrameBuffer);
    }
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$1000(this.this$0);
    if (localTPPlayerListeners != null) {
      return localTPPlayerListeners.onVideoProcessFrameOut(this.this$0, paramTPPostProcessFrameBuffer);
    }
    return null;
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    localTPSwitchCommonParams.arg1 = paramLong1;
    localTPSwitchCommonParams.arg2 = paramLong2;
    TPPlayer.access$300(this.this$0, 264, 0, 0, localTPSwitchCommonParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer.InnerPlayerListener
 * JD-Core Version:    0.7.0.1
 */