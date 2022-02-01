package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class TVKVideoController
  implements MsgRevokeListener
{
  MediaFocusManager.OnMediaFocusChangeListener a = new TVKVideoController.3(this);
  private int b = 0;
  private VideoPlayMedioInfo c;
  private VideoPlayParam d;
  private WeakReference<Context> e;
  private IVideoOuterStatusListener f;
  private BaseVideoView g;
  private int h;
  private int i;
  private URLDrawable j;
  private long k;
  
  public TVKVideoController(Context paramContext)
  {
    this.e = new WeakReference(paramContext);
  }
  
  private VideoPlayParam a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    this.d = new VideoPlayParam();
    VideoPlayParam localVideoPlayParam = this.d;
    localVideoPlayParam.mIsMute = false;
    localVideoPlayParam.mSceneId = 116;
    localVideoPlayParam.mSceneName = SceneID.getSceneStr(116);
    localVideoPlayParam = this.d;
    localVideoPlayParam.mNeedPlayProgress = true;
    if (paramVideoPlayMedioInfo != null)
    {
      localVideoPlayParam.mStartPlayPosMs = paramVideoPlayMedioInfo.q;
      this.d.mIsLocal = (true ^ paramVideoPlayMedioInfo.a);
      if (this.d.mIsLocal)
      {
        this.d.mVideoPath = paramVideoPlayMedioInfo.b;
      }
      else
      {
        this.d.mUrls = paramVideoPlayMedioInfo.c;
        this.d.mSavePath = paramVideoPlayMedioInfo.b;
      }
    }
    a(this.d);
    return this.d;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSeek === progress : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TVKVideoController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((BaseVideoView)localObject).seekTo(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramInt1 = 402;
    } else {
      paramInt1 = 401;
    }
    if (paramInt2 == 14011001) {
      paramInt1 = 403;
    }
    IVideoOuterStatusListener localIVideoOuterStatusListener = this.f;
    if (localIVideoOuterStatusListener != null) {
      localIVideoOuterStatusListener.onVideoError(paramInt1);
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new TVKVideoController.4(this);
  }
  
  private void c()
  {
    if (MediaFocusManager.b().a(1, this.a) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "onPlay ===");
      }
      BaseVideoView localBaseVideoView = this.g;
      if (localBaseVideoView != null) {
        localBaseVideoView.play();
      }
      this.b = 4;
    }
  }
  
  private void d()
  {
    MediaFocusManager.b().a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onPause ===");
    }
    BaseVideoView localBaseVideoView = this.g;
    if (localBaseVideoView != null) {
      localBaseVideoView.pause();
    }
    this.b = 6;
  }
  
  private void e()
  {
    MediaFocusManager.b().a(this.a);
    WeakReference localWeakReference = this.e;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AudioManager)((Context)this.e.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void f()
  {
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "clickPlay curState:", Integer.valueOf(this.b), ",path:", this.c.b });
    }
    c();
  }
  
  private void g()
  {
    if (this.f != null)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        long l = ((BaseVideoView)localObject).getVideoDurationMs();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoView.getVideoDurationMs = ");
          ((StringBuilder)localObject).append(l);
          QLog.d("TVKVideoController", 2, ((StringBuilder)localObject).toString());
        }
        this.f.onVideoStart((int)l);
      }
    }
  }
  
  public void a()
  {
    this.f = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new TVKVideoController.1(this));
  }
  
  public void a(long paramLong)
  {
    if (this.k == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, new Object[] { "onRecokeMsg:", Long.valueOf(paramLong) });
      }
      ThreadManager.getUIHandler().post(new TVKVideoController.2(this));
    }
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with mediaInfo :", paramVideoPlayMedioInfo.b });
    }
    this.k = paramLong1;
    this.c = paramVideoPlayMedioInfo;
    paramVideoPlayMedioInfo = this.c;
    paramVideoPlayMedioInfo.q = paramLong2;
    this.d = a(paramVideoPlayMedioInfo);
    this.g = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView((Context)this.e.get(), 0L, this.d, null));
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = paramString.toString();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
          try
          {
            localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject);
            if (((URLDrawable)localObject).getStatus() != 1) {
              ((URLDrawable)localObject).downloadImediatly();
            }
            if ((localObject instanceof URLDrawable))
            {
              this.j = ((URLDrawable)localObject);
              return;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("initCover():  getDrawable Exception, coverUrl=");
              localStringBuilder.append(paramString);
              QLog.e("TVKVideoController", 2, localStringBuilder.toString(), localException);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    Object localObject = new File(paramString);
    long l;
    if (((File)localObject).exists()) {
      l = ((File)localObject).length();
    } else {
      l = 0L;
    }
    this.k = paramLong1;
    this.c = new VideoPlayMedioInfo();
    localObject = this.c;
    ((VideoPlayMedioInfo)localObject).a = false;
    ((VideoPlayMedioInfo)localObject).b = paramString;
    ((VideoPlayMedioInfo)localObject).n = l;
    ((VideoPlayMedioInfo)localObject).p = l;
    ((VideoPlayMedioInfo)localObject).q = paramLong2;
    this.d = a((VideoPlayMedioInfo)localObject);
    this.g = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView((Context)this.e.get(), 0L, this.d, null));
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1;
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      f1 = paramInt2 / paramInt3;
    }
    else
    {
      f2 = 0.5625F;
      f1 = f2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("videoWidth or videoHeight Wrong. videoWidth = ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" videoHeight = ");
        ((StringBuilder)localObject).append(paramInt3);
        QLog.d("TVKVideoController", 2, ((StringBuilder)localObject).toString());
        f1 = f2;
      }
    }
    float f2 = f1;
    if (f1 > 1.0F) {
      f2 = 1.0F / f1;
    }
    boolean bool;
    if (paramInt2 > paramInt3) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(bool).setRatio(f2).setCanMove(true).setCanZoom(true).build();
    if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplicationImpl.getContext(), this.g, (FloatingScreenParams)localObject, FloatingScreenReporter.a(paramInt1)) == 1)
    {
      ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog((Context)this.e.get());
      return false;
    }
    a();
    f();
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "destory!");
    }
    Object localObject = this.e;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((AudioManager)((Context)this.e.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
    this.c = null;
    this.e = null;
    this.j = null;
    localObject = this.g;
    if (localObject != null) {
      ((BaseVideoView)localObject).releasePlayer(false);
    }
    this.g = null;
    MediaFocusManager.b().a(this.a);
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController
 * JD-Core Version:    0.7.0.1
 */