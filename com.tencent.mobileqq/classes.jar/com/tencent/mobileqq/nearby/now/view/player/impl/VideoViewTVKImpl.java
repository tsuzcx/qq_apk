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
  final IVideoViewBase a;
  TVK_IMediaPlayer b;
  final Context c;
  String d;
  String e;
  String f;
  long g;
  int h = 0;
  boolean i = false;
  IVideoView.OnCompletionListener j;
  IVideoView.OnErrorListener k;
  IVideoView.OnInfoListener l;
  IVideoView.OnPreparedListener m;
  IVideoView.OnDownloadListener n;
  
  public VideoViewTVKImpl(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = TVK_SDKMgr.getProxyFactory().createVideoView_Scroll(this.c);
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
  
  public View a()
  {
    return (View)this.a;
  }
  
  public void a(long paramLong)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo((int)paramLong);
    }
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.j = paramOnCompletionListener;
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.n = paramOnDownloadListener;
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    this.k = paramOnErrorListener;
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    this.l = paramOnInfoListener;
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    this.m = paramOnPreparedListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.d = paramString1;
    String str = DownloadTask.b(paramString1, 0);
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramLong;
    if (this.b == null)
    {
      this.b = TVK_SDKMgr.getProxyFactory().createMediaPlayer(this.c, this.a);
      this.b.setXYaxis(0);
      this.b.setOnCompletionListener(new VideoViewTVKImpl.1(this));
      this.b.setOnErrorListener(new VideoViewTVKImpl.2(this));
      this.b.setOnInfoListener(new VideoViewTVKImpl.3(this));
      this.b.setOnVideoPreparedListener(new VideoViewTVKImpl.4(this));
      this.b.setOnDownloadCallback(new VideoViewTVKImpl.5(this, paramString2, paramString1, paramString3));
    }
    paramString1 = a(str, paramString2, paramLong);
    paramString1.setConfigMap("keep_last_frame", "true");
    if ((!TextUtils.isEmpty(paramString2)) && (FileCacheUtils.a(new File(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoViewTVKImpl", 2, "  use local path");
      }
      this.b.openMediaPlayerByUrl(this.c, paramString2, 0L, 0L, null, paramString1);
      this.h = 0;
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
    this.f = InnerDns.replaceDomainWithIp(this.f.replace("https://", "http://"), 1012);
    this.b.openMediaPlayerByUrl(this.c, this.f, 0L, 0L, null, paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.b.removeAllListener();
      this.b.release();
      this.b = null;
    }
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public long d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      return (int)localTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null)
    {
      if (localTVK_IMediaPlayer.isPlaying()) {
        this.b.stop();
      }
      a(this.d, this.e, this.f, this.g);
      this.b.start();
    }
  }
  
  public long g()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public int h()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer == null) {
      return 0;
    }
    double d1 = localTVK_IMediaPlayer.getCurrentPostion();
    double d2 = this.b.getDuration();
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d1 / (d2 + 0.1D) * 100.0D);
  }
  
  public boolean i()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl
 * JD-Core Version:    0.7.0.1
 */