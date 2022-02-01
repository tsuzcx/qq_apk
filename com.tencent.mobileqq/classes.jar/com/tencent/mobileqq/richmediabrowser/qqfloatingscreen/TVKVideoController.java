package com.tencent.mobileqq.richmediabrowser.qqfloatingscreen;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.VideoPlayMedioInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class TVKVideoController
  implements MsgRevokeListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  MediaFocusManager.OnMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new TVKVideoController.3(this);
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
  private VideoPlayMedioInfo jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  private int c;
  
  public TVKVideoController(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  private VideoPlayParam a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = new VideoPlayParam();
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
    localVideoPlayParam.mIsMute = false;
    localVideoPlayParam.mSceneId = 116;
    localVideoPlayParam.mSceneName = SceneID.a(116);
    localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
    localVideoPlayParam.mNeedPlayProgress = true;
    if (paramVideoPlayMedioInfo != null)
    {
      localVideoPlayParam.mStartPlayPosMs = paramVideoPlayMedioInfo.e;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsLocal = (true ^ paramVideoPlayMedioInfo.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsLocal)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mVideoPath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mUrls = paramVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mSavePath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
    return this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
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
    IVideoOuterStatusListener localIVideoOuterStatusListener = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
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
    if (MediaFocusManager.a().a(1, this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "onPlay ===");
      }
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (localBaseVideoView != null) {
        localBaseVideoView.play();
      }
      this.jdField_a_of_type_Int = 4;
    }
  }
  
  private void d()
  {
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onPause ===");
    }
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.pause();
    }
    this.jdField_a_of_type_Int = 6;
  }
  
  private void e()
  {
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "clickPlay curState:", Integer.valueOf(this.jdField_a_of_type_Int), ",path:", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo.jdField_a_of_type_JavaLangString });
    }
    c();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
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
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoStart((int)l);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new TVKVideoController.1(this));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == paramLong)
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
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with mediaInfo :", paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo = paramVideoPlayMedioInfo;
    paramVideoPlayMedioInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo;
    paramVideoPlayMedioInfo.e = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a(paramVideoPlayMedioInfo);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0L, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam, null));
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getThumbUrl(paramString);
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
              this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
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
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo;
    ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean = false;
    ((VideoPlayMedioInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((VideoPlayMedioInfo)localObject).b = l;
    ((VideoPlayMedioInfo)localObject).d = l;
    ((VideoPlayMedioInfo)localObject).e = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a((VideoPlayMedioInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0L, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam, null));
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
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
    if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, (FloatingScreenParams)localObject, FloatingScreenReporter.a(paramInt1)) == 1)
    {
      ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelVideoPlayMedioInfo = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localObject != null) {
      ((BaseVideoView)localObject).releasePlayer(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).removeMsgRevokerListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController
 * JD-Core Version:    0.7.0.1
 */