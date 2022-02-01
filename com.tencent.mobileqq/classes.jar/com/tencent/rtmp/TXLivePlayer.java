package com.tencent.rtmp;

import android.content.Context;
import android.view.Surface;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class TXLivePlayer
{
  public static final int PLAY_TYPE_LIVE_FLV = 1;
  public static final int PLAY_TYPE_LIVE_RTMP = 0;
  public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
  public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
  public static final int PLAY_TYPE_VOD_FLV = 2;
  public static final int PLAY_TYPE_VOD_HLS = 3;
  public static final int PLAY_TYPE_VOD_MP4 = 4;
  public static final String TAG = "TXLivePlayer";
  private a mTXLivePlayerImpl;
  
  public TXLivePlayer(Context paramContext)
  {
    this.mTXLivePlayerImpl = new a(paramContext);
  }
  
  public boolean addVideoRawData(byte[] paramArrayOfByte)
  {
    return this.mTXLivePlayerImpl.a(paramArrayOfByte);
  }
  
  public void callExperimentalAPI(String paramString)
  {
    this.mTXLivePlayerImpl.b(paramString);
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    this.mTXLivePlayerImpl.e(paramInt);
  }
  
  public boolean enableHardwareDecode(boolean paramBoolean)
  {
    return this.mTXLivePlayerImpl.b(paramBoolean);
  }
  
  public boolean isPlaying()
  {
    return this.mTXLivePlayerImpl.a();
  }
  
  public void pause()
  {
    this.mTXLivePlayerImpl.b();
  }
  
  public int prepareLiveSeek(String paramString, int paramInt)
  {
    return this.mTXLivePlayerImpl.b(paramString, paramInt);
  }
  
  public void resume()
  {
    this.mTXLivePlayerImpl.c();
  }
  
  public int resumeLive()
  {
    return this.mTXLivePlayerImpl.e();
  }
  
  public void seek(int paramInt)
  {
    this.mTXLivePlayerImpl.g(paramInt);
  }
  
  public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    this.mTXLivePlayerImpl.a(paramITXAudioRawDataListener);
  }
  
  public void setAudioRoute(int paramInt)
  {
    this.mTXLivePlayerImpl.d(paramInt);
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mTXLivePlayerImpl.a(paramITXAudioVolumeEvaluationListener);
  }
  
  @Deprecated
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mTXLivePlayerImpl.d(paramBoolean);
  }
  
  public void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    this.mTXLivePlayerImpl.a(paramTXLivePlayConfig);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mTXLivePlayerImpl.c(paramBoolean);
  }
  
  public void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.mTXLivePlayerImpl.a(paramITXLivePlayListener);
  }
  
  public void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    this.mTXLivePlayerImpl.a(paramTXCloudVideoView);
  }
  
  @Deprecated
  public void setRate(float paramFloat)
  {
    this.mTXLivePlayerImpl.a(paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mTXLivePlayerImpl.a(paramInt);
  }
  
  public void setRenderRotation(int paramInt)
  {
    this.mTXLivePlayerImpl.b(paramInt);
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mTXLivePlayerImpl.a(paramSurface);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    this.mTXLivePlayerImpl.a(paramInt1, paramInt2);
  }
  
  public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    this.mTXLivePlayerImpl.a(paramITXVideoRawDataListener);
  }
  
  public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.mTXLivePlayerImpl.a(paramITXVideoRecordListener);
  }
  
  public int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener paramITXLivePlayVideoRenderListener, Object paramObject)
  {
    return this.mTXLivePlayerImpl.a(paramITXLivePlayVideoRenderListener, paramObject);
  }
  
  public void setVolume(int paramInt)
  {
    this.mTXLivePlayerImpl.c(paramInt);
  }
  
  public void snapshot(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mTXLivePlayerImpl.a(paramITXSnapshotListener);
  }
  
  public int startPlay(String paramString, int paramInt)
  {
    return this.mTXLivePlayerImpl.a(paramString, paramInt);
  }
  
  public int startRecord(int paramInt)
  {
    return this.mTXLivePlayerImpl.f(paramInt);
  }
  
  public int stopPlay(boolean paramBoolean)
  {
    return this.mTXLivePlayerImpl.a(paramBoolean);
  }
  
  public int stopRecord()
  {
    return this.mTXLivePlayerImpl.d();
  }
  
  public int switchStream(String paramString)
  {
    return this.mTXLivePlayerImpl.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayer
 * JD-Core Version:    0.7.0.1
 */