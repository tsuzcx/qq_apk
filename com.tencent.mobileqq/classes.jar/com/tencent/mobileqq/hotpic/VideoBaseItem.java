package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VideoBaseItem
{
  public static SparseArray<WeakReference<VideoBaseItem>> a = new SparseArray();
  public static int b = -1;
  public int c;
  Context d;
  public TVK_IMediaPlayer e;
  TVK_IProxyFactory f;
  int g = 0;
  String h;
  boolean i = false;
  long j = -1L;
  private View k;
  private Handler l = new Handler();
  private VideoBaseItem.OnInnerStateChangeListener m;
  private boolean n = false;
  private boolean o = false;
  
  private VideoBaseItem(Context paramContext, int paramInt)
  {
    this.d = paramContext;
    this.c = paramInt;
  }
  
  public static View a(Context paramContext)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        return (View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      }
      return (View)localTVK_IProxyFactory.createVideoView(paramContext);
    }
    return null;
  }
  
  public static VideoBaseItem a(Context paramContext, int paramInt)
  {
    paramContext = new VideoBaseItem(paramContext, paramInt);
    a.put(paramInt, new WeakReference(paramContext));
    return paramContext;
  }
  
  private void i()
  {
    ((IVideoViewBase)this.k).addViewCallBack(new VideoBaseItem.1(this));
  }
  
  private void j()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.e.release();
      this.e = null;
      this.f = null;
      this.k = null;
      this.o = false;
    }
  }
  
  public void a()
  {
    j();
    this.g = 5;
    this.m = null;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.g == 4)
    {
      String str = this.h;
      a(str, str, 0L, paramLong, paramBoolean);
    }
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
    i();
    this.g = 1;
  }
  
  public void a(VideoBaseItem.OnInnerStateChangeListener paramOnInnerStateChangeListener)
  {
    this.m = paramOnInnerStateChangeListener;
  }
  
  public void a(VideoBaseItem.VideoStatusRecord paramVideoStatusRecord)
  {
    if (this.g != 3)
    {
      QLog.d("VideoBaseItem", 2, "you should check thi status.Have you stopped Mediaplayer");
      return;
    }
    paramVideoStatusRecord = this.e;
    if ((paramVideoStatusRecord != null) && (!paramVideoStatusRecord.isPlaying()))
    {
      this.e.start();
      if (this.i) {
        this.e.seekTo((int)this.j);
      }
      this.g = 2;
      QLog.d("VideoBaseItem", 2, "you restart mediaplayer");
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.g < 1)
    {
      QLog.d("VideoBaseItem", 2, "you should check video staus! this function only call be calld after VideoStatusRecord.ITEM_BIND_VIEW");
      return;
    }
    if (this.k == null)
    {
      Toast.makeText(this.d, "video view is empty,please check,you shold bind TencentSdkView", 0).show();
      return;
    }
    if (this.f == null) {
      this.f = TVK_SDKMgr.getProxyFactory();
    }
    if ((this.e == null) && (this.k != null))
    {
      this.e = this.f.createMediaPlayer(BaseApplicationImpl.getApplication(), (IVideoViewBase)this.k);
      this.e.setOnCompletionListener(new VideoBaseItem.2(this));
      this.e.setOnErrorListener(new VideoBaseItem.3(this));
      this.e.setOnVideoPreparedListener(new VideoBaseItem.4(this));
      this.e.setOnSeekCompleteListener(new VideoBaseItem.5(this));
      this.e.setOnInfoListener(new VideoBaseItem.6(this));
      this.e.setOnNetVideoInfoListener(new VideoBaseItem.7(this));
      this.e.setOnVideoPreparingListener(new VideoBaseItem.8(this));
      this.e.setOnDownloadCallback(new VideoBaseItem.9(this));
    }
    this.e.setOutputMute(paramBoolean);
    this.h = paramString2;
    String str = HotVideoUtils.a(paramString2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "shouq_hotpic_online_video");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    File localFile = new File(str);
    if (HotVideoUtils.a(paramString2, paramLong2))
    {
      this.n = true;
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      localTVK_PlayerVideoInfo.setPlayType(4);
      this.e.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), localFile.getAbsolutePath(), paramLong1, 0L, localTVK_PlayerVideoInfo);
      QLog.d("VideoBaseItem", 2, "huanxxiao test file have been cached");
      return;
    }
    this.n = false;
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.setVid(MD5Utils.toMD5(paramString1));
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    this.e.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString1, paramLong1, 0L, localTVK_PlayerVideoInfo);
    QLog.d("VideoBaseItem", 2, "huanxxiao test open with url ok");
  }
  
  public void a(boolean paramBoolean)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getOutputMute();
    }
    return true;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public long d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getCurrentPostion();
    }
    return -1L;
  }
  
  public long e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer == null) {
      return -1L;
    }
    return localTVK_IMediaPlayer.getDuration();
  }
  
  public int f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if (localTVK_IMediaPlayer == null) {
      return -1;
    }
    return localTVK_IMediaPlayer.getBufferPercent();
  }
  
  public VideoBaseItem.VideoStatusRecord g()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      this.j = this.e.getCurrentPostion();
      this.g = 3;
      this.e.pause();
      QLog.d("VideoBaseItem", 2, " you have paused Mediaplayer");
    }
    return new VideoBaseItem.VideoStatusRecord(this, this.g, this.j);
  }
  
  public boolean h()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.e;
    return (localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem
 * JD-Core Version:    0.7.0.1
 */