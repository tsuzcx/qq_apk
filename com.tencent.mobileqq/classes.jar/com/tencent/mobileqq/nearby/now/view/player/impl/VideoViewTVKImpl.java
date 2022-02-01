package com.tencent.mobileqq.nearby.now.view.player.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnCompletionListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnDownloadListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnErrorListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnPreparedListener;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.HashMap;

public class VideoViewTVKImpl
  implements IVideoView
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  final Context jdField_a_of_type_AndroidContentContext;
  IVideoView.OnCompletionListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnCompletionListener;
  IVideoView.OnDownloadListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnDownloadListener;
  IVideoView.OnErrorListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnErrorListener;
  IVideoView.OnInfoListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnInfoListener;
  IVideoView.OnPreparedListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnPreparedListener;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  final IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  String c;
  
  public VideoViewTVKImpl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static TVK_PlayerVideoInfo a(String paramString1, String paramString2, long paramLong)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20171106));
    if (paramLong > 0L) {
      localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramLong / 1000L));
    }
    localTVK_PlayerVideoInfo.setConfigMap("downloadflag", "0");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_qqstory");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    if (!TextUtils.isEmpty(paramString2))
    {
      localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString2);
      paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new File(paramString2);
        if (!paramString2.exists()) {
          paramString2.mkdirs();
        }
      }
    }
    localTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    localTVK_PlayerVideoInfo.setVid(paramString1);
    return localTVK_PlayerVideoInfo;
  }
  
  public int a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer == null) {
      return 0;
    }
    double d1 = localTVK_IMediaPlayer.getCurrentPostion();
    double d2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d1 / (d2 + 0.1D) * 100.0D);
  }
  
  public long a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return (int)localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  }
  
  public void a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.removeAllListener();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void a(long paramLong)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo((int)paramLong);
    }
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnCompletionListener = paramOnCompletionListener;
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnDownloadListener = paramOnDownloadListener;
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnErrorListener = paramOnErrorListener;
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnInfoListener = paramOnInfoListener;
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView$OnPreparedListener = paramOnPreparedListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    String str = DownloadTask.a(paramString1, 0);
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(0);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new VideoViewTVKImpl.1(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new VideoViewTVKImpl.2(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new VideoViewTVKImpl.3(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new VideoViewTVKImpl.4(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new VideoViewTVKImpl.5(this, paramString2, paramString1, paramString3));
    }
    paramString1 = a(str, paramString2, paramLong);
    paramString1.setConfigMap("keep_last_frame", "true");
    if ((!TextUtils.isEmpty(paramString2)) && (FileCacheUtils.a(new File(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoViewTVKImpl", 2, "  use local path");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString2, 0L, 0L, null, paramString1);
      this.jdField_a_of_type_Int = 0;
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    if (!paramString3.contains("authkey"))
    {
      Bosses.get().postJob(new VideoViewTVKImpl.6(this, "VideoViewTVKImpl", paramString3, paramString1));
      return;
    }
    this.c = InnerDns.replaceDomainWithIp(this.c.replace("https://", "http://"), 1012);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.c, 0L, 0L, null, paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public long b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      if (localTVK_IMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl
 * JD-Core Version:    0.7.0.1
 */