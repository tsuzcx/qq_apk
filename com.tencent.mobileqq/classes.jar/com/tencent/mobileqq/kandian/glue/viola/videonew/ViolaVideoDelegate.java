package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.ComponentConstant.Event;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaVideoDelegate
  implements IVideoVolumeController.EventListener, IVideoView.VideoViewEventListener, VVideoView.OnVideoViewControlListener, VideoPlayManager.VideoStatusListener, ComponentConstant.Event
{
  private int a;
  protected Activity a;
  protected IVideoView a;
  protected VVideoView a;
  protected VideoPlayManager a;
  private int b = 1;
  private int c = -1;
  
  public ViolaVideoDelegate(Activity paramActivity, IVideoView paramIVideoView, VVideoView paramVVideoView, ViolaInstance paramViolaInstance)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager = new VideoPlayManager(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a(paramIVideoView);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView = paramIVideoView;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.setEventListener(this);
    VideoVolumeController.getInstance().inKandianModule(paramActivity);
    VideoVolumeController.getInstance().addEventListener(this);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    }
  }
  
  public static final int a(long paramLong)
  {
    if (paramLong >= 500L)
    {
      double d = paramLong / 1000L;
      Double.isNaN(d);
      return (int)(d + 0.5D);
    }
    return 0;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    for (;;)
    {
      try
      {
        this.b = paramInt;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", paramInt);
        if (paramObject != null) {
          ((JSONObject)localObject).put("message", paramObject);
        }
        paramObject = new JSONObject();
        com.tencent.mobileqq.kandian.base.video.player.api.IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a;
        int i = 0;
        if (localIVideoView != null)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a.a().getWidth();
          paramObject.put("width", paramInt);
          paramInt = i;
          if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a != null) {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a.a().getHeight();
          }
          paramObject.put("height", paramInt);
          ((JSONObject)localObject).put("videoSize", paramObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("stateChange", localObject);
          return;
        }
      }
      catch (Exception paramObject)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callJsStateChange,error = ");
          ((StringBuilder)localObject).append(paramObject.getMessage());
          QLog.e("ViolaVideoDelegate", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      paramInt = 0;
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramInt));
      localJSONObject.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c() / 1000L);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView;
    boolean bool = false;
    paramVVideoView.a(0, paramBoolean);
    try
    {
      paramVVideoView = new JSONObject();
      paramBoolean = bool;
      if (this.jdField_a_of_type_Int == 2) {
        paramBoolean = true;
      }
      paramVVideoView.put("hasUI", paramBoolean);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      paramString = new StringBuilder();
      paramString.append("enterFullScreen error = : ");
      paramString.append(paramVVideoView.getMessage());
      QLog.e("ViolaVideoDelegate", 2, paramString.toString());
    }
  }
  
  public void a(VVideoView paramVVideoView) {}
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b(paramInt);
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
    if (paramVVideoView != null)
    {
      paramVVideoView.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.e(paramVVideoView.f);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", this.b);
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.d()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a.a().getWidth());
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a().a.a().getHeight());
      paramVVideoView.put("videoSize", localJSONObject);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      paramVVideoView = new StringBuilder();
      paramVVideoView.append("open: ");
      paramVVideoView.append(paramJSONObject);
      QLog.d("ViolaVideoDelegate", 2, paramVVideoView.toString());
    }
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.a();
    paramVVideoView = null;
    try
    {
      paramJSONObject = new VideoPlayManager.VideoPlayParam(localViewGroup, paramJSONObject);
      paramVVideoView = paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    if (paramVVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c();
      if (paramVVideoView.b) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b(paramVVideoView);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a(paramVVideoView);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.a(paramVVideoView);
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(paramBoolean);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    a(4, null);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    paramVideoPlayParam = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramVideoPlayParam.put("code", 101);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localJSONObject.put("code", localStringBuilder.toString());
      localJSONObject.put("msg", paramString);
      paramVideoPlayParam.put("extra", localJSONObject);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    a(6, paramVideoPlayParam);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    try
    {
      paramVideoPlayParam = new JSONObject();
      paramVideoPlayParam.put("currentTime", a(paramLong));
      paramVideoPlayParam.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c() / 1000L);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("playTimeChange", paramVideoPlayParam);
      return;
    }
    catch (Exception paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener) {}
  
  public void a(boolean paramBoolean)
  {
    VVideoView localVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView;
    String str;
    if (paramBoolean) {
      str = "stateVisible";
    } else {
      str = "stateHidden";
    }
    localVVideoView.a(str, null);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.a();
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a() != null)
    {
      paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager;
      paramVVideoView.b(paramVVideoView.a());
    }
  }
  
  public void b(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.setControlType(this.jdField_a_of_type_Int);
  }
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView;
    boolean bool = true;
    paramVVideoView.a(1);
    for (;;)
    {
      try
      {
        paramVVideoView = new JSONObject();
        if (this.jdField_a_of_type_Int == 2)
        {
          paramVVideoView.put("hasUI", bool);
          paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
          return;
        }
      }
      catch (Exception paramVVideoView)
      {
        paramString = new StringBuilder();
        paramString.append("exitFullScreen error = : ");
        paramString.append(paramVVideoView.getMessage());
        QLog.e("ViolaVideoDelegate", 2, paramString.toString());
        return;
      }
      bool = false;
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetSrc: ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("ViolaVideoDelegate", 2, localStringBuilder.toString());
    }
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    a(2, null);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_Int != 2) {
          break label100;
        }
        paramBoolean = true;
        localJSONObject.put("hasUI", paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label99;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initChangeFullScreenAnim onAnimationEnd error = : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ViolaVideoDelegate", 2, localStringBuilder.toString());
      return;
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("didExitFullScreen", null);
      label99:
      return;
      label100:
      paramBoolean = false;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.e();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.f(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener) {}
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.setFullScreenDisable(paramBoolean);
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(1, null);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.d();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c();
  }
  
  public void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(2, null);
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c();
    if (paramVVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b(paramVVideoView);
    }
  }
  
  public void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(7, null);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.f();
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView;
    if (localIVideoView != null) {
      localIVideoView.c();
    }
    VideoVolumeController.getInstance().outKandianModule(this.jdField_a_of_type_AndroidAppActivity);
    VideoVolumeController.getInstance().removeEventListener(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.a();
  }
  
  public void f(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.b >= 2) {
      a(3, null);
    }
  }
  
  public void f_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.b(paramBoolean);
  }
  
  public void g() {}
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.b();
  }
  
  public void g(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a())
    {
      a(2, null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.d()) {
      a(4, null);
    }
  }
  
  public void g_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewIVideoView.setEndWithLastFrame(paramBoolean);
  }
  
  public void h() {}
  
  public void h(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(5, null);
  }
  
  public void i() {}
  
  public void j() {}
  
  public void l_(int paramInt) {}
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(true);
  }
  
  public void onPhoneCome()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.a();
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(true);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager.c(false);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.c == -1) {
        this.c = VideoVolumeController.getInstance().getStreamMaxVolume(3);
      }
      localJSONObject.put("value", paramInt / this.c);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("volumeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoDelegate
 * JD-Core Version:    0.7.0.1
 */