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
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  private VideoPlayManager.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$MediaPlayListenerAdapterImpl = new VideoPlayManager.MediaPlayListenerAdapterImpl(this, null);
  private VideoPlayManager.UiHandler jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$UiHandler = new VideoPlayManager.UiHandler(this);
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
  private List<VideoPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilList;
  private Set<VideoPlayerWrapper> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return null;
    }
    localObject = new VideoPlayerWrapper(((Context)localObject).getApplicationContext());
    ((VideoPlayerWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$MediaPlayListenerAdapterImpl);
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_f_of_type_Boolean)) {
      ((VideoPlayerWrapper)localObject).e(true);
    }
    return localObject;
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.a(null);
    paramVideoPlayerWrapper.n();
    if (paramVideoPlayerWrapper.j()) {
      return;
    }
    paramVideoPlayerWrapper.j();
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
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo);
    e(paramVideoPlayParam);
  }
  
  private void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null)
    {
      if (VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam) == null) {
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView == null)
      {
        VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup);
        Object localObject = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a();
        if ((localObject != null) && (((IVideoView)localObject).a() != null))
        {
          paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = ((IVideoView)localObject);
          ((IVideoView)localObject).a().setId(2131376064);
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(paramVideoPlayParam);
          continue;
          localObject = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramVideoPlayParam, 123, 99, null);
          }
          VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam, null);
          return;
        }
      }
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).b(paramVideoPlayParam.jdField_f_of_type_Int);
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).d(this.e);
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).c(paramVideoPlayParam.jdField_a_of_type_Boolean);
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a().setVisibility(0);
      ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam), 64, null, true);
    }
  }
  
  public int a()
  {
    if (b()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).b();
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  @Nullable
  public Activity a()
  {
    return null;
  }
  
  @Nullable
  public IVideoUIManager a()
  {
    return null;
  }
  
  @Nullable
  public VideoPlayParam a()
  {
    return null;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
  }
  
  public void a()
  {
    c(2);
  }
  
  public void a(int paramInt) {}
  
  public void a(@Nullable OnPlayStateListener paramOnPlayStateListener) {}
  
  public void a(@Nullable BaseVideoPlayParam paramBaseVideoPlayParam) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    paramVideoPlayParam = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVideoPlayParam.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramVideoPlayParam.next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, false);
    }
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramVideoStatusListener);
  }
  
  public void a(@Nullable Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
      if (localObject != null) {
        d((VideoPlayManager.VideoPlayParam)localObject);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, 123, 99, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = null;
    }
  }
  
  public boolean a()
  {
    return (b()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).f());
  }
  
  public long b()
  {
    return 0L;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).d();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).d(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (b()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).a(paramInt);
    }
  }
  
  public void b(@Nullable OnPlayStateListener paramOnPlayStateListener) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo() vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.a);
        QLog.d("Viola.VideoPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo: playerParam=");
        ((StringBuilder)localObject).append(paramVideoPlayParam);
        QLog.d("Viola.VideoPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, true);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
      if ((localObject != null) && (!((VideoPluginInstall)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
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
    if (b()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).d(paramBoolean);
    }
  }
  
  public boolean b()
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
    return (localVideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(localVideoPlayParam) != null);
  }
  
  public long c()
  {
    if (b()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).b();
    }
    return 0L;
  }
  
  public void c()
  {
    if (b())
    {
      a(VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).e(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$UiHandler.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null) && (a()))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).f();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, paramInt);
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
    if (b()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).c(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (b()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).d());
  }
  
  public long d()
  {
    if (b()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).a();
    }
    return 0L;
  }
  
  public void d()
  {
    this.c = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(a());
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    if (a())
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      a();
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
    if ((localObject != null) && (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null) && ((d()) || (c())))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).e();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, paramInt);
      }
    }
  }
  
  public boolean d()
  {
    return (b()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).e());
  }
  
  public void e()
  {
    this.c = true;
    if ((this.d) && (c()))
    {
      b();
    }
    else if (this.jdField_f_of_type_Boolean)
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      boolean bool;
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        bool = ((QQAppInterface)localAppRuntime).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.jdField_a_of_type_Boolean = true;
        d(2);
      }
    }
    this.jdField_f_of_type_Boolean = false;
    this.d = false;
  }
  
  public void e(int paramInt)
  {
    if (b()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).b(paramInt);
    }
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
    if (localObject != null)
    {
      if (VideoPlayManager.VideoPlayParam.a((VideoPlayManager.VideoPlayParam)localObject) != null)
      {
        VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam).l();
        VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
    if (localObject != null)
    {
      ((VideoPluginInstall)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */