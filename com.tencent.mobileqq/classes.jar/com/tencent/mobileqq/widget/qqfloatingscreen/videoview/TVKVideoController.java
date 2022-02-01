package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenReporter;
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
  implements AIOGalleryMsgRevokeMgr.MsgRevokeListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private VideoPlayMedioInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
  MediaFocusManager.OnMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new TVKVideoController.3(this);
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
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
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = new VideoPlayParam();
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute = false;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mSceneId = 116;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mSceneName = SceneID.a(116);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mNeedPlayProgress = true;
    if (paramVideoPlayMedioInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mStartPlayPosMs = paramVideoPlayMedioInfo.e;
      VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
      if (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
        break label116;
      }
      localVideoPlayParam.mIsLocal = bool;
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsLocal) {
        break label121;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mVideoPath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      return this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
      label116:
      bool = false;
      break;
      label121:
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mUrls = paramVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mSavePath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onSeek === progress : " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.seekTo(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 401;
    if (paramInt1 == 1) {
      i = 402;
    }
    if (paramInt2 == 14011001) {
      i = 403;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoError(i);
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
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
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
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
    this.jdField_a_of_type_Int = 6;
  }
  
  private void e()
  {
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "clickPlay curState:", Integer.valueOf(this.jdField_a_of_type_Int), ",path:", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString });
    }
    c();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "mVideoView.getVideoDurationMs = " + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoStart((int)l);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = paramVideoPlayMedioInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.e = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0L, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam, null));
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    Object localObject;
    if (FileUtils.b(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = paramString.toString();
        if (!TextUtils.isEmpty(paramString)) {
          localObject = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
        }
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).downloadImediatly();
      }
      if ((localObject instanceof URLDrawable)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TVKVideoController", 2, "initCover():  getDrawable Exception, coverUrl=" + paramString, localException);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    File localFile = new File(paramString);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = new VideoPlayMedioInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.b = l;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.d = l;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.e = paramLong2;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0L, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam, null));
      AIOGalleryMsgRevokeMgr.a().a(this);
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1;
    if ((paramInt2 > 0) && (paramInt3 > 0))
    {
      f1 = paramInt2 / paramInt3;
      if (f1 <= 1.0F) {
        break label185;
      }
      f1 = 1.0F / f1;
    }
    label175:
    label185:
    for (;;)
    {
      if (paramInt2 > paramInt3) {}
      for (boolean bool = true;; bool = false)
      {
        FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(bool).setRatio(f1).setCanMove(true).setCanZoom(true).build();
        if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, localFloatingScreenParams, FloatingScreenReporter.a(paramInt1)) != 1) {
          break label175;
        }
        FloatingScreenPermission.enterPermissionRequestDialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        return false;
        float f2 = 0.5625F;
        f1 = f2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TVKVideoController", 2, "videoWidth or videoHeight Wrong. videoWidth = " + paramInt2 + " videoHeight = " + paramInt3);
        f1 = f2;
        break;
      }
      a();
      f();
      return true;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "destory!");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((AudioManager)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("audio")).abandonAudioFocus(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController
 * JD-Core Version:    0.7.0.1
 */