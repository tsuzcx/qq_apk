package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.base.video.player.pool.PlayerPool;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.video.constants.ViolaVideoConstants.ResizeType;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VVideoDelegate
  implements PlayerStatusListener, IVideoVolumeController.EventListener, ViolaVideoConstants.ResizeType, VVideoView.OnVideoViewControlListener
{
  protected Activity a;
  protected VVideoView b;
  ReadInJoyPlayer c;
  @Nullable
  private VideoInfo d;
  private long e;
  private int f = -1;
  private boolean g = false;
  private boolean h = false;
  private int i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private int n = 0;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  
  public VVideoDelegate(Activity paramActivity, VVideoView paramVVideoView, int paramInt, ViolaInstance paramViolaInstance, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.l = paramBoolean1;
    this.r = paramBoolean2;
    if (paramBoolean2) {
      this.c = ((ReadInJoyPlayer)PlayerPool.a.a(paramActivity, new VVideoDelegate.1(this, paramInt, paramString, paramBoolean1)));
    } else {
      this.c = ((ReadInJoyPlayer)ReadInJoyPlayerFactory.get().createPlayer(paramInt, paramString, paramBoolean1));
    }
    this.m = paramBoolean1;
    this.b = paramVVideoView;
    this.a = paramActivity;
    VideoVolumeController.getInstance().inKandianModule(paramVVideoView);
    VideoVolumeController.getInstance().addEventListener(this);
    this.c.a(this);
    this.c.a(paramVVideoView);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    }
    this.k = (true ^ TextUtils.isEmpty(paramString));
    if (paramViolaInstance != null) {
      try
      {
        if (((paramViolaInstance.getFragment() instanceof ReadInJoyViolaChannelFragment)) && (((ReadInJoyViolaChannelFragment)paramViolaInstance.getFragment()).n))
        {
          c();
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
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
  
  private void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramInt);
      if (paramString != null) {
        localJSONObject.put("message", paramString);
      }
      paramString = new JSONObject();
      paramString.put("width", this.c.w());
      paramString.put("height", this.c.x());
      localJSONObject.put("videoSize", paramString);
      localJSONObject.put("errorData", paramJSONObject);
      this.b.a("stateChange", localJSONObject);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callJsStateChange,error = ");
        paramJSONObject.append(paramString.getMessage());
        QLog.e("VVideoControlListenerImpl", 2, paramJSONObject.toString());
      }
    }
    if (paramInt == 2) {
      this.b.a();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
    boolean bool = this.c.r();
    if ((!bool) && (!this.c.v()) && (!this.c.q()))
    {
      if (this.c.u())
      {
        a(2, null);
        return;
      }
      if (this.c.t())
      {
        a(4, null);
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("seamlessPlay error state: ");
      paramString1.append(this.c.l());
      QLog.e("VVideoControlListenerImpl", 2, paramString1.toString());
      this.l = true;
      this.m = true;
      this.c.h();
      paramString1 = this.d;
      if (paramString1 != null) {
        this.c.a(paramString1.a, this.d.b, this.d.i, this.e, this.d.e);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("VVideoControlListenerImpl", 2, "seamlessPlay VIDEO_STATE_BUFFERING");
      }
      a(3, null);
      if (bool) {
        this.c.A();
      }
    }
  }
  
  private int l()
  {
    int i1 = this.c.l();
    if (i1 != 0) {
      if ((i1 != 1) && (i1 != 2))
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5)
            {
              if (i1 != 7) {
                return 6;
              }
            }
            else {
              return 4;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    return 5;
  }
  
  private void m()
  {
    if (this.h)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.b.a("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initChangeFullScreenAnim onAnimationEnd error = : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    else
    {
      this.b.a("didExitFullScreen", null);
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    this.c.a(paramFloat);
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.h = true;
    if (!paramBoolean) {
      if (paramInt == 0) {
        this.a.setRequestedOrientation(0);
      } else {
        this.a.setRequestedOrientation(8);
      }
    }
    paramVVideoView = this.b;
    Activity localActivity = this.a;
    Window localWindow = localActivity.getWindow();
    this.i = localWindow.getDecorView().getSystemUiVisibility();
    if (paramBoolean)
    {
      localWindow.setFlags(1024, 1024);
      if (CommonSuspensionGestureLayout.h()) {
        VideoFeedsHelper.i(this.a);
      } else {
        VideoFeedsHelper.h(localActivity);
      }
    }
    else
    {
      VideoFeedsHelper.h(localActivity);
    }
    if ((paramVVideoView.getComponent() != null) && (paramVVideoView.getComponent().getInstance() != null) && ((paramVVideoView.getComponent().getInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      paramVVideoView = (ViolaLazyFragment)paramVVideoView.getComponent().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.hideTitleBar();
        paramVVideoView.hideStatusBar();
      }
    }
    m();
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("hasUI", false);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      paramString = new StringBuilder();
      paramString.append("enterFullScreen error = : ");
      paramString.append(paramVVideoView.getMessage());
      QLog.e("VVideoControlListenerImpl", 2, paramString.toString());
    }
  }
  
  public void a(IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.c.a(paramIVideoPreDownloadMgr);
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.d != null) && (!this.c.b()) && (!this.s))
    {
      this.c.b(this.g);
      this.c.a(this.d.a, this.d.b, this.d.i, this.e, this.d.e);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    if (!this.j) {
      this.c.b(paramInt);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.n = 0;
    } else if (paramString.equals("cover")) {
      this.n = 2;
    }
    if (this.m) {
      this.c.a(this.n);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", l());
      paramVVideoView.put("currentTime", a(this.c.k()));
      paramVVideoView.put("totalTime", this.c.j() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.c.w());
      localJSONObject.put("height", this.c.x());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open: ");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append(", isDestroyed=");
      localStringBuilder.append(this.s);
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    if (this.s) {
      return;
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      boolean bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      l_(paramJSONObject.optBoolean("endWithLastFrame"));
      this.g = paramJSONObject.optBoolean("cover_frame", false);
      this.e = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.d = new VideoInfo(paramJSONObject.getJSONObject("video_info"));
      if ((!VideoVolumeController.getInstance().isBizFocusing()) && (!VideoVolumeController.getInstance().isHadChangeVolumeAfterLossFocus())) {
        this.c.e(true);
      } else {
        this.c.e(paramJSONObject.optBoolean("muted", false));
      }
      this.c.a(Float.valueOf(paramJSONObject.optString("rate", "1.0")).floatValue());
      if (paramJSONObject.optBoolean("debugInfoEnable", ReadInJoyHelper.o(ReadInJoyUtils.b())))
      {
        paramVVideoView = paramJSONObject.optString("debugInfo");
        ReadInJoyHelper.i(ReadInJoyUtils.b(), true);
        this.c.b(paramVVideoView);
      }
      if (this.d.j == 1)
      {
        this.n = VideoFeedsHelper.c(this.a, this.d.c, this.d.d);
        this.c.a(this.n);
      }
      if (this.k)
      {
        a(this.d.b, this.d.i);
        return;
      }
      if (bool1)
      {
        this.c.a(this.d.a, this.d.b, this.d.i, this.e, this.d.e);
        return;
      }
      if (bool2)
      {
        a(null);
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("VVideoControlListenerImpl", 2, "open: ", paramVVideoView);
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    if ((VideoVolumeController.getInstance().isBizFocusing()) || (VideoVolumeController.getInstance().isHadChangeVolumeAfterLossFocus())) {
      this.c.e(paramBoolean);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    Map localMap = this.c.B();
    PlayFeedbackHelper.a(localMap);
    paramOnVideoViewMethodListener.OnMethodSuccess(paramString, new JSONObject(localMap));
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel())
    {
      paramVVideoView = new StringBuilder();
      paramVVideoView.append("play: status=");
      paramVVideoView.append(this.c.l());
      paramVVideoView.append(", isPreload=");
      paramVVideoView.append(this.c.b());
      paramVVideoView.append(", videoinfo=");
      paramVVideoView.append(this.d);
      paramVVideoView.append(", mStartPosition:");
      paramVVideoView.append(this.e);
      paramVVideoView.append(", isDestroyed=");
      paramVVideoView.append(this.s);
      QLog.d("VVideoControlListenerImpl", 2, paramVVideoView.toString());
    }
    if (this.s) {
      return;
    }
    if ((this.d != null) && (this.c.b()))
    {
      this.c.a(this.d.a, this.d.b, this.d.i, this.e, this.d.e);
      return;
    }
    if (this.c.o())
    {
      this.c.e();
      return;
    }
    paramVVideoView = this.d;
    if (paramVVideoView != null) {
      this.c.a(paramVVideoView.a, this.d.b, this.d.i, this.e, this.d.e);
    }
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.h = false;
    this.a.setRequestedOrientation(1);
    this.a.setRequestedOrientation(1);
    paramVVideoView = this.b;
    Window localWindow = this.a.getWindow();
    localWindow.getDecorView().setSystemUiVisibility(this.i);
    localWindow.clearFlags(1024);
    if ((paramVVideoView.getComponent() != null) && (paramVVideoView.getComponent().getInstance() != null) && ((paramVVideoView.getComponent().getInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      paramVVideoView = (ViolaFragment)paramVVideoView.getComponent().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.showTitleBar();
        paramVVideoView.recoverStatusBar();
      }
    }
    m();
    if ((TextUtils.isEmpty(paramString)) && (paramOnVideoViewMethodListener != null)) {
      try
      {
        paramVVideoView = new JSONObject();
        paramVVideoView.put("hasUI", false);
        paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
        return;
      }
      catch (Exception paramVVideoView)
      {
        paramString = new StringBuilder();
        paramString.append("exitFullScreen error = : ");
        paramString.append(paramVVideoView.getMessage());
        QLog.e("VVideoControlListenerImpl", 2, paramString.toString());
      }
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetSrc: ");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append(", isDestroyed=");
      localStringBuilder.append(this.s);
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    if (this.s) {
      return;
    }
    this.k = false;
    this.c.h();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void beforeVideoStart()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      this.c.a(((VideoInfo)localObject).k);
      boolean bool2 = this.d.m;
      boolean bool1 = true;
      int i1;
      if (bool2) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      localObject = new VideoEntity.Builder().setContentId(this.d.k).setPage(this.a);
      if (i1 != 1) {
        bool1 = false;
      }
      localObject = ((VideoEntity.Builder)localObject).ignoreReport(bool1).setContentType(i1).setVideoDuration(this.d.e).addCustomParams(this.d.n).setIdentifier(this.d.k).build();
      VideoReport.bindVideoPlayerInfo(this.c, (VideoEntity)localObject);
    }
  }
  
  public void c()
  {
    this.c.D();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    if (this.h) {
      VideoFeedsHelper.h(this.a);
    }
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.c.f();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.c.c(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("videoToken", this.c.y());
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void d()
  {
    this.c.C();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.c.h();
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    this.c.a();
  }
  
  public void f()
  {
    if (this.r)
    {
      this.c.E();
      if ((this.a != null) && (!PlayerPool.a.a(this.a, this.c))) {
        this.c.F();
      }
    }
    else
    {
      this.c.F();
    }
    VideoVolumeController.getInstance().outKandianModule(this.b);
    VideoVolumeController.getInstance().removeEventListener(this);
    this.a = null;
    this.s = true;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.c.m();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.c.n();
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public void h()
  {
    this.c.z();
  }
  
  public void i()
  {
    if (!this.l)
    {
      this.c.c();
      this.c.a(this.n);
      this.m = true;
    }
  }
  
  public void j()
  {
    if (!this.l)
    {
      this.c.c();
      this.c.a(this.n);
      this.m = true;
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.2(this), 0L);
      h();
    }
  }
  
  public void k()
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.3(this), 0L);
  }
  
  public void k_(boolean paramBoolean)
  {
    this.c.d(paramBoolean);
  }
  
  public void l_(boolean paramBoolean)
  {
    this.c.c(paramBoolean);
  }
  
  public void onBufferEnd()
  {
    if (this.c.u())
    {
      a(2, null);
      return;
    }
    if (this.c.t()) {
      a(4, null);
    }
  }
  
  public void onBufferStart()
  {
    a(3, null);
  }
  
  public void onCompletion()
  {
    a(5, null);
  }
  
  public void onFirstFrameRendered()
  {
    this.b.a("firstFrameReady", null);
    if (this.p) {
      a(2, null);
    }
    this.o = true;
  }
  
  public void onFocusGain()
  {
    ReadInJoyPlayer localReadInJoyPlayer = this.c;
    if ((localReadInJoyPlayer != null) && (this.q))
    {
      localReadInJoyPlayer.e(false);
      this.q = false;
    }
  }
  
  public void onFocusLoss()
  {
    ReadInJoyPlayer localReadInJoyPlayer = this.c;
    if ((localReadInJoyPlayer != null) && (!localReadInJoyPlayer.i()))
    {
      this.c.e(true);
      this.q = true;
    }
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    this.c.e(paramBoolean ^ true);
  }
  
  public void onPhoneCome()
  {
    this.c.f();
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramLong));
      localJSONObject.put("totalTime", this.c.j() / 1000L);
      this.b.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    Object localObject = this.c;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ReadInJoyPlayer)localObject).e(bool);
    try
    {
      localObject = new JSONObject();
      if (this.f == -1) {
        this.f = VideoVolumeController.getInstance().getStreamMaxVolume(3);
      }
      ((JSONObject)localObject).put("value", paramInt / this.f);
      this.b.a("volumeChange", localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onVideoEnd(int paramInt)
  {
    a(5, null);
  }
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramInt1 == 202) && (paramInt2 == 108)) {}
    try
    {
      localJSONObject.put("code", "2");
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder;
      localJSONException.printStackTrace();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localJSONObject.put("code", localStringBuilder.toString());
    a(6, paramString, localJSONObject);
  }
  
  public void onVideoOpen()
  {
    this.o = false;
    this.p = false;
  }
  
  public void onVideoPause()
  {
    a(4, null);
  }
  
  public void onVideoPrepared()
  {
    a(1, null);
  }
  
  public void onVideoRestart()
  {
    a(2, null);
  }
  
  public void onVideoStart()
  {
    if (this.o) {
      a(2, null);
    }
    this.p = true;
  }
  
  public void onVideoStop()
  {
    a(7, null);
    this.p = false;
    this.o = false;
    VideoReport.unbindVideoPlayerInfo(this.c);
  }
  
  public void r_(int paramInt)
  {
    this.e = (paramInt * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoDelegate
 * JD-Core Version:    0.7.0.1
 */