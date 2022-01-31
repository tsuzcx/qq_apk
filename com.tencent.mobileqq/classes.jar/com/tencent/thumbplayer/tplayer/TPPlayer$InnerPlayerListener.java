package com.tencent.thumbplayer.tplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.utils.TPHashMapBuilder;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Map;

class TPPlayer$InnerPlayerListener
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener, ITPPlayListener
{
  TPPlayer$InnerPlayerListener(TPPlayer paramTPPlayer) {}
  
  public long getAdvRemainTime()
  {
    return TPPlayer.access$900(this.this$0).getAdvRemainTime();
  }
  
  public int getCurrentPlayClipNo()
  {
    return TPPlayer.access$900(this.this$0).getCurrentPlayClipNo();
  }
  
  public long getCurrentPosition()
  {
    return TPPlayer.access$900(this.this$0).getCurrentPosition();
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
    return TPPlayer.access$900(this.this$0).getPlayerBufferLength();
  }
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$800(this.this$0);
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.onAudioFrameOut(this.this$0, paramTPAudioFrameBuffer);
    }
  }
  
  public void onCompletion()
  {
    TPPlayer.access$200(this.this$0, 111, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("reason", Integer.valueOf(0)).build());
    TPPlayer.access$300(this.this$0, 260, 0, 0, null);
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadCdnUrlExpired");
    TPPlayer.access$900(this.this$0).onDownloadCdnUrlExpired(paramMap);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
    TPPlayer.access$900(this.this$0).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadCdnUrlUpdate, url:" + paramString);
    TPPlayer.access$900(this.this$0).onDownloadCdnUrlUpdate(paramString);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    TPPlayer.access$900(this.this$0).onDownloadError(4000, paramInt2, paramString);
  }
  
  public void onDownloadFinish()
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadFinish");
    TPPlayer.access$900(this.this$0).onDownloadFinish();
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPPlayer.access$900(this.this$0).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    TPPlayer.access$900(this.this$0).onDownloadProtocolUpdate(paramString1, paramString2);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    if (paramInt != TPPlayer.access$1000(this.this$0))
    {
      TPLogUtil.i(TPPlayer.access$500(this.this$0), "onDownloadStatusUpdate, status:" + paramInt);
      TPPlayer.access$1002(this.this$0, paramInt);
    }
    TPPlayer.access$900(this.this$0).onDownloadStatusUpdate(paramInt);
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject = TPPlayer.access$000(this.this$0).getPlayErrorCodeStr();
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onError playerErrorCodeStr=" + (String)localObject);
    j = paramInt1;
    i = paramInt2;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      i = Integer.parseInt((String)localObject);
      j = 4000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e(TPPlayer.access$500(this.this$0), "onError e=" + localException.getMessage());
        j = paramInt1;
        i = paramInt2;
      }
    }
    TPPlayer.access$600(this.this$0, j, i);
    TPLogUtil.i(TPPlayer.access$500(this.this$0), "onError errorTypeReal=" + j + ", errorCodeReal=" + i);
    localObject = new TPThreadSwitchCommons.TPSwitchCommonParams();
    ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject).arg1 = paramLong1;
    ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject).arg2 = paramLong2;
    TPPlayer.access$300(this.this$0, 262, j, i, localObject);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPPlayer.access$400(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    localTPSwitchCommonParams.arg1 = paramLong1;
    localTPSwitchCommonParams.arg2 = paramLong2;
    localTPSwitchCommonParams.extraObject = paramObject;
    TPPlayer.access$300(this.this$0, 261, paramInt, 0, localTPSwitchCommonParams);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return TPPlayer.access$900(this.this$0).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public void onPrepared()
  {
    TPPlayer.access$000(this.this$0).setProxyPlayState(0);
    Object localObject1 = TPPlayer.access$100(this.this$0).getPlaybackInfo();
    String str = ((TPPlaybackInfo)localObject1).getWidth() + "*" + ((TPPlaybackInfo)localObject1).getHeight();
    Object localObject2 = TPPlayer.access$100(this.this$0).getTrackInfo();
    int i;
    if (localObject2 != null)
    {
      int m = localObject2.length;
      int j = 0;
      int k;
      for (i = 0; j < m; i = k)
      {
        k = i;
        if (localObject2[j].trackType == 2) {
          k = i + 1;
        }
        j += 1;
      }
    }
    for (;;)
    {
      localObject2 = this.this$0;
      localObject1 = new TPHashMapBuilder().put("playertype", Integer.valueOf(TPPlayer.access$100(this.this$0).getPlayerType())).put("definition", str).put("rate", Long.valueOf(((TPPlaybackInfo)localObject1).getVideoBitRate())).put("duration", Long.valueOf(((TPPlaybackInfo)localObject1).getDurationMs())).put("fmt", ((TPPlaybackInfo)localObject1).getContainerFormat()).put("etime", Long.valueOf(System.currentTimeMillis()));
      if (i > 1) {}
      for (boolean bool = true;; bool = false)
      {
        TPPlayer.access$200((TPPlayer)localObject2, 103, 0, 0, null, ((TPHashMapBuilder)localObject1).put("multitrack", Boolean.valueOf(bool)).build());
        TPPlayer.access$300(this.this$0, 257, 0, 0, null);
        return;
      }
      i = 0;
    }
  }
  
  public void onSeekComplete()
  {
    TPPlayer.access$700(this.this$0);
    TPPlayer.access$200(this.this$0, 110, 0, 0, null, new TPHashMapBuilder().put("etime", Long.valueOf(System.currentTimeMillis())).put("petime", Long.valueOf(this.this$0.handleGetCurrentPositionMs())).build());
    TPPlayer.access$300(this.this$0, 263, 0, 0, null);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPPlayer.access$300(this.this$0, 265, 0, 0, paramTPSubtitleData);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$800(this.this$0);
    if (localTPPlayerListeners != null) {
      localTPPlayerListeners.onVideoFrameOut(this.this$0, paramTPVideoFrameBuffer);
    }
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams = new TPThreadSwitchCommons.TPSwitchCommonParams();
    localTPSwitchCommonParams.arg1 = paramLong1;
    localTPSwitchCommonParams.arg2 = paramLong2;
    TPPlayer.access$300(this.this$0, 264, 0, 0, localTPSwitchCommonParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer.InnerPlayerListener
 * JD-Core Version:    0.7.0.1
 */