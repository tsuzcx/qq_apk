package com.tencent.mobileqq.leba;

import adza;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.concurrent.atomic.AtomicInteger;

public class LebaFeedsVideoPlayer
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoSizeChangedListener
{
  private adza jdField_a_of_type_Adza;
  private Context jdField_a_of_type_AndroidContentContext;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  
  public LebaFeedsVideoPlayer(Context paramContext, adza paramadza)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Adza = paramadza;
    e();
  }
  
  private void e()
  {
    QLog.i("LebaFeedsVideoPlayer", 1, "initMediaPlayer has init=" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      QLog.i("LebaFeedsVideoPlayer", 1, "initMediaPlayer failed, getProxyFactory return null");
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase == null)
    {
      QLog.i("LebaFeedsVideoPlayer", 1, "initMediaPlayer failed, createVideoView_Scroll return null");
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      QLog.i("LebaFeedsVideoPlayer", 1, "createMediaPlayer failed, createVideoView_Scroll return null");
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoSizeChangedListener(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "OnDownloadCallback " + paramString);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public View a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "start");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      a(3);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void a(adza paramadza)
  {
    this.jdField_a_of_type_Adza = paramadza;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "openWithVid " + this.jdField_a_of_type_Adza);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
      QLog.e("LebaFeedsVideoPlayer", 1, "openWithVid state not IDLE");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      a(1);
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if (paramLong2 > 0L) {
        localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(paramLong2));
      }
      if (paramLong3 > 0L) {
        localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramLong3));
      }
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      localTVK_PlayerVideoInfo.setVid(paramString);
      localTVK_PlayerVideoInfo.setPlayType(2);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20180425");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null, localTVK_PlayerVideoInfo, null, paramLong1, 0L);
    } while (!QLog.isColorLevel());
    QLog.i("LebaFeedsVideoPlayer", 2, "openWithVid vid = " + paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "setOutputMute " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsVideoPlayer", 2, "isPlaying " + bool);
      }
      return bool;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "pause ");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      a(4);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "openWithUrl " + this.jdField_a_of_type_Adza);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
      QLog.e("LebaFeedsVideoPlayer", 1, "openWithUrl state not IDLE");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
      a(1);
      TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if (paramLong2 > 0L) {
        localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(paramLong2));
      }
      if (paramLong3 > 0L) {
        localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramLong3));
      }
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString, paramLong1, 0L, null, localTVK_PlayerVideoInfo);
    } while (!QLog.isColorLevel());
    QLog.i("LebaFeedsVideoPlayer", 2, "openWithUrl openMediaPlayerByUrl " + paramString);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsVideoPlayer", 2, "isPausing " + bool);
      }
      return bool;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "resume ");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      a(3);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      a(5);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "onCompletion " + paramTVK_IMediaPlayer);
    }
    a(0);
    if (this.jdField_a_of_type_Adza != null) {
      this.jdField_a_of_type_Adza.b(this);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Adza != null) {
      this.jdField_a_of_type_Adza.a(this, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "onInfo i=" + paramInt + ", obj=" + paramObject);
    }
    return false;
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayer", 2, "onVideoPrepared");
    }
    a(2);
    if (this.jdField_a_of_type_Adza != null) {
      this.jdField_a_of_type_Adza.a(this);
    }
  }
  
  public void onVideoSizeChanged(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Adza != null) {
      this.jdField_a_of_type_Adza.a(this, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsVideoPlayer
 * JD-Core Version:    0.7.0.1
 */