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
  protected VideoPlayManager a;
  protected IVideoView b;
  protected VVideoView c;
  protected Activity d;
  private int e;
  private int f = 1;
  private int g = -1;
  
  public ViolaVideoDelegate(Activity paramActivity, IVideoView paramIVideoView, VVideoView paramVVideoView, ViolaInstance paramViolaInstance)
  {
    this.d = paramActivity;
    this.a = new VideoPlayManager(paramActivity);
    this.a.a(paramIVideoView);
    this.a.a(this);
    this.b = paramIVideoView;
    this.c = paramVVideoView;
    this.b.a(this.a);
    this.b.setEventListener(this);
    VideoVolumeController.getInstance().inKandianModule(paramVVideoView);
    VideoVolumeController.getInstance().addEventListener(this);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    }
  }
  
  public static final int a(long paramLong)
  {
    if (paramLong >= 500L)
    {
      double d1 = paramLong / 1000L;
      Double.isNaN(d1);
      return (int)(d1 + 0.5D);
    }
    return 0;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    for (;;)
    {
      try
      {
        this.f = paramInt;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", paramInt);
        if (paramObject != null) {
          ((JSONObject)localObject).put("message", paramObject);
        }
        paramObject = new JSONObject();
        com.tencent.mobileqq.kandian.base.video.player.api.IVideoView localIVideoView = this.a.m().b;
        int i = 0;
        if (localIVideoView != null)
        {
          paramInt = this.a.m().b.a().getWidth();
          paramObject.put("width", paramInt);
          paramInt = i;
          if (this.a.m().b != null) {
            paramInt = this.a.m().b.a().getHeight();
          }
          paramObject.put("height", paramInt);
          ((JSONObject)localObject).put("videoSize", paramObject);
          this.c.a("stateChange", localObject);
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
      localJSONObject.put("totalTime", this.a.j() / 1000L);
      this.c.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramVVideoView = this.b;
    boolean bool = false;
    paramVVideoView.a(0, paramBoolean);
    try
    {
      paramVVideoView = new JSONObject();
      paramBoolean = bool;
      if (this.e == 2) {
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
    this.a.b(paramInt);
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    paramVVideoView = this.a.m();
    if (paramVVideoView != null)
    {
      paramVVideoView.a(paramString);
      this.a.e(paramVVideoView.n);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", this.f);
      paramVVideoView.put("currentTime", a(this.a.k()));
      paramVVideoView.put("totalTime", this.a.j() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.a.m().b.a().getWidth());
      localJSONObject.put("height", this.a.m().b.a().getHeight());
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
    ViewGroup localViewGroup = this.b.getVideoContainer();
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
      this.a.i();
      if (paramVVideoView.f) {
        this.a.b(paramVVideoView);
      } else {
        this.a.a(paramVVideoView);
      }
      this.b.a(paramVVideoView);
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.a.c(paramBoolean);
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
      paramVideoPlayParam.put("totalTime", this.a.j() / 1000L);
      this.c.a("playTimeChange", paramVideoPlayParam);
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
    VVideoView localVVideoView = this.c;
    String str;
    if (paramBoolean) {
      str = "stateVisible";
    } else {
      str = "stateHidden";
    }
    localVVideoView.a(str, null);
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (this.a.n())
    {
      this.a.h();
      return;
    }
    if (this.a.m() != null)
    {
      paramVVideoView = this.a;
      paramVVideoView.b(paramVVideoView.m());
    }
  }
  
  public void b(VVideoView paramVVideoView, int paramInt)
  {
    this.e = paramInt;
    this.b.setControlType(this.e);
  }
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramVVideoView = this.b;
    boolean bool = true;
    paramVVideoView.a(1);
    for (;;)
    {
      try
      {
        paramVVideoView = new JSONObject();
        if (this.e == 2)
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
        if (this.e != 2) {
          break label100;
        }
        paramBoolean = true;
        localJSONObject.put("hasUI", paramBoolean);
        this.c.a("didEnterFullScreen", localJSONObject);
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
      this.c.a("didExitFullScreen", null);
      label99:
      return;
      label100:
      paramBoolean = false;
    }
  }
  
  public void c()
  {
    this.a.r();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.a.c();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.a.f(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener) {}
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.b.setFullScreenDisable(paramBoolean);
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(1, null);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    this.a.q();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.a.i();
  }
  
  public void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(2, null);
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    paramVVideoView = this.a.m();
    this.a.i();
    if (paramVVideoView != null) {
      this.a.b(paramVVideoView);
    }
  }
  
  public void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(7, null);
  }
  
  public void f()
  {
    this.a.s();
    IVideoView localIVideoView = this.b;
    if (localIVideoView != null) {
      localIVideoView.c();
    }
    VideoVolumeController.getInstance().outKandianModule(this.c);
    VideoVolumeController.getInstance().removeEventListener(this);
    this.d = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.b.a();
  }
  
  public void f(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.f >= 2) {
      a(3, null);
    }
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.b.b();
  }
  
  public void g(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.a.g())
    {
      a(2, null);
      return;
    }
    if (this.a.p()) {
      a(4, null);
    }
  }
  
  public boolean g()
  {
    return this.b.d();
  }
  
  public void h() {}
  
  public void h(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(5, null);
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void k_(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void l_(boolean paramBoolean)
  {
    this.b.setEndWithLastFrame(paramBoolean);
  }
  
  public void onFocusGain() {}
  
  public void onFocusLoss() {}
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.c(false);
      return;
    }
    this.a.c(true);
  }
  
  public void onPhoneCome()
  {
    this.a.c();
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.a.c(true);
    } else {
      this.a.c(false);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.g == -1) {
        this.g = VideoVolumeController.getInstance().getStreamMaxVolume(3);
      }
      localJSONObject.put("value", paramInt / this.g);
      this.c.a("volumeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void r_(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoDelegate
 * JD-Core Version:    0.7.0.1
 */