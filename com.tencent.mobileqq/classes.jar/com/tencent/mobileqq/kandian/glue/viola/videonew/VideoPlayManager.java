package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class VideoPlayManager
  implements OnVideoPluginInstallListener, IVideoPlayManager
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private int g = 1000;
  private Context h;
  private VideoPlayManager.VideoPlayParam i;
  private Set<VideoPlayerWrapper> j = new ArraySet();
  private List<VideoPlayManager.VideoStatusListener> k;
  private VideoPluginInstall l;
  private VideoPlayManager.MediaPlayListenerAdapterImpl m = new VideoPlayManager.MediaPlayListenerAdapterImpl(this, null);
  private VideoPlayManager.UiHandler n = new VideoPlayManager.UiHandler(this);
  
  public VideoPlayManager(Context paramContext)
  {
    this.h = paramContext;
    this.l = new VideoPluginInstall();
    this.l.a(this);
    this.k = new ArrayList();
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.a(null);
    paramVideoPlayerWrapper.T();
    if (paramVideoPlayerWrapper.r()) {
      return;
    }
    ThreadManager.excute(new VideoPlayManager.2(this, paramVideoPlayerWrapper), 64, null, false);
  }
  
  private void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramVideoPlayParam), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.c);
    e(paramVideoPlayParam);
  }
  
  private void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null)
    {
      if (VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam) == null) {
        return;
      }
      paramVideoPlayParam.a.setKeepScreenOn(true);
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      if (paramVideoPlayParam.b == null)
      {
        VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.a);
        Object localObject = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).c();
        if ((localObject != null) && (((IVideoView)localObject).a() != null))
        {
          paramVideoPlayParam.b = ((IVideoView)localObject);
          ((IVideoView)localObject).a().setId(2131444264);
          localObject = this.k.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(paramVideoPlayParam);
          continue;
          localObject = this.k.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramVideoPlayParam, 123, 99, null);
          }
          VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam, null);
          return;
        }
      }
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).b(paramVideoPlayParam.n);
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).h(this.e);
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).g(paramVideoPlayParam.e);
      paramVideoPlayParam.b.a().setVisibility(0);
      ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam), 64, null, true);
    }
  }
  
  private VideoPlayerWrapper f(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject = this.h;
    if (localObject == null) {
      return null;
    }
    localObject = new VideoPlayerWrapper(((Context)localObject).getApplicationContext());
    ((VideoPlayerWrapper)localObject).a(this.m);
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.o)) {
      ((VideoPlayerWrapper)localObject).i(true);
    }
    return localObject;
  }
  
  @Nullable
  public VideoPlayParam a()
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(@Nullable OnPlayStateListener paramOnPlayStateListener) {}
  
  public void a(@Nullable BaseVideoPlayParam paramBaseVideoPlayParam) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.i = paramVideoPlayParam;
    paramVideoPlayParam = this.k.iterator();
    while (paramVideoPlayParam.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramVideoPlayParam.next()).a(this.i, false);
    }
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.k.add(paramVideoStatusListener);
  }
  
  public void a(@Nullable Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.i;
      if (localObject != null) {
        d((VideoPlayManager.VideoPlayParam)localObject);
      }
    }
    else
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.i, 123, 99, null);
      }
      this.i = null;
    }
  }
  
  @Nullable
  public Activity b()
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    if (n()) {
      VideoPlayManager.VideoPlayParam.a(this.i).a(paramInt);
    }
  }
  
  public void b(@Nullable OnPlayStateListener paramOnPlayStateListener) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo() vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.c.b);
        QLog.d("Viola.VideoPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo: playerParam=");
        ((StringBuilder)localObject).append(paramVideoPlayParam);
        QLog.d("Viola.VideoPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      this.i = paramVideoPlayParam;
      Object localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.i, true);
      }
      localObject = this.l;
      if ((localObject != null) && (!((VideoPluginInstall)localObject).b()))
      {
        this.l.a();
        return;
      }
      d(paramVideoPlayParam);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (n()) {
      VideoPlayManager.VideoPlayParam.a(this.i).h(paramBoolean);
    }
  }
  
  public void c()
  {
    c(2);
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.i;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null) && (g()))
    {
      VideoPlayManager.VideoPlayParam.a(this.i).w();
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.i, paramInt);
      }
    }
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      a(VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (n()) {
      VideoPlayManager.VideoPlayParam.a(this.i).g(paramBoolean);
    }
  }
  
  @Nullable
  public IVideoUIManager d()
  {
    return null;
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.i;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null) && ((p()) || (o())))
    {
      VideoPlayManager.VideoPlayParam.a(this.i).v();
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(this.i, paramInt);
      }
    }
  }
  
  public long e()
  {
    return 0L;
  }
  
  public void e(int paramInt)
  {
    if (n()) {
      VideoPlayManager.VideoPlayParam.a(this.i).b(paramInt);
    }
  }
  
  public long f()
  {
    return 0L;
  }
  
  public void f(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean g()
  {
    return (n()) && (VideoPlayManager.VideoPlayParam.a(this.i).n());
  }
  
  public void h()
  {
    Object localObject = this.i;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null))
    {
      VideoPlayManager.VideoPlayParam.a(this.i).u();
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).d(this.i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void i()
  {
    if (n())
    {
      a(VideoPlayManager.VideoPlayParam.a(this.i));
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).e(this.i);
      }
      this.i.a.setKeepScreenOn(false);
      this.i = null;
    }
    this.n.removeMessages(0);
  }
  
  public long j()
  {
    if (n()) {
      return VideoPlayManager.VideoPlayParam.a(this.i).I();
    }
    return 0L;
  }
  
  public long k()
  {
    if (n()) {
      return VideoPlayManager.VideoPlayParam.a(this.i).C();
    }
    return 0L;
  }
  
  public int l()
  {
    if (n()) {
      return VideoPlayManager.VideoPlayParam.a(this.i).h();
    }
    return -1;
  }
  
  public VideoPlayManager.VideoPlayParam m()
  {
    return this.i;
  }
  
  public boolean n()
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = this.i;
    return (localVideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(localVideoPlayParam) != null);
  }
  
  public boolean o()
  {
    return (n()) && (VideoPlayManager.VideoPlayParam.a(this.i).l());
  }
  
  public boolean p()
  {
    return (n()) && (VideoPlayManager.VideoPlayParam.a(this.i).m());
  }
  
  public void q()
  {
    this.c = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(g());
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    if (g())
    {
      this.f = true;
      this.a = false;
      c();
    }
  }
  
  public void r()
  {
    this.c = true;
    if ((this.d) && (o()))
    {
      h();
    }
    else if (this.f)
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.b();
      boolean bool;
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        bool = ((QQAppInterface)localAppRuntime).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.a = true;
        d(2);
      }
    }
    this.f = false;
    this.d = false;
  }
  
  public void s()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    i();
    Object localObject = this.i;
    if (localObject != null)
    {
      if (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null)
      {
        VideoPlayManager.VideoPlayParam.a(this.i).D();
        VideoPlayManager.VideoPlayParam.a(this.i, null);
      }
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.q())) {
          localVideoPlayerWrapper.D();
        }
      }
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((VideoPluginInstall)localObject).c();
      this.l = null;
    }
    this.n.removeCallbacksAndMessages(null);
    this.k.clear();
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */