package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.video.constants.ViolaVideoConstants.ResizeType;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.qroute.QRoute;
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
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected Activity a;
  IReadInJoyPlayer jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer;
  @Nullable
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo;
  protected VVideoView a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public VVideoDelegate(Activity paramActivity, VVideoView paramVVideoView, int paramInt, ViolaInstance paramViolaInstance, String paramString, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer = ((IReadInJoyPlayerFactory)QRoute.api(IReadInJoyPlayerFactory.class)).createPlayer(paramInt, paramString, paramBoolean);
    this.f = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    VideoVolumeController.getInstance().inKandianModule(paramActivity);
    VideoVolumeController.getInstance().addEventListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramVVideoView);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    }
    this.d = (true ^ TextUtils.isEmpty(paramString));
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a();
    if (i != 0) {
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 7) {
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
      paramString.put("width", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b());
      paramString.put("height", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c());
      localJSONObject.put("videoSize", paramString);
      localJSONObject.put("errorData", paramJSONObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("stateChange", localJSONObject);
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
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramString1, paramString2);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e();
    if ((!bool) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.i()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.h())
      {
        a(2, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.g())
      {
        a(4, null);
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("seamlessPlay error state: ");
      paramString1.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a());
      QLog.e("VVideoControlListenerImpl", 2, paramString1.toString());
      this.e = true;
      this.f = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.f();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo;
      if (paramString1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramString1.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("VVideoControlListenerImpl", 2, "seamlessPlay VIDEO_STATE_BUFFERING");
      }
      a(3, null);
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.j();
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
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
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("didExitFullScreen", null);
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramFloat);
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = true;
    if (!paramBoolean) {
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      }
    }
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Window localWindow = localActivity.getWindow();
    this.jdField_b_of_type_Int = localWindow.getDecorView().getSystemUiVisibility();
    if (paramBoolean)
    {
      localWindow.setFlags(1024, 1024);
      if (CommonSuspensionGestureLayout.c()) {
        VideoFeedsHelper.c(this.jdField_a_of_type_AndroidAppActivity);
      } else {
        VideoFeedsHelper.b(localActivity);
      }
    }
    else
    {
      VideoFeedsHelper.b(localActivity);
    }
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && ((paramVVideoView.a().getInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.hideTitleBar();
        paramVVideoView.hideStatusBar();
      }
    }
    k();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramIVideoPreDownloadMgr);
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b(paramInt);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.jdField_c_of_type_Int = 0;
    } else if (paramString.equals("cover")) {
      this.jdField_c_of_type_Int = 2;
    }
    if (this.f) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_c_of_type_Int);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", a());
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b());
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c());
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
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      boolean bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      g_(paramJSONObject.optBoolean("endWithLastFrame"));
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("cover_frame", false);
      this.jdField_a_of_type_Long = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo = new VideoInfo(paramJSONObject.getJSONObject("video_info"));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(paramJSONObject.optBoolean("muted", false));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(Float.valueOf(paramJSONObject.optString("rate", "1.0")).floatValue());
      if (paramJSONObject.optBoolean("debugInfoEnable", ReadInJoyHelper.j(ReadInJoyUtils.a())))
      {
        paramVVideoView = paramJSONObject.optString("debugInfo");
        ReadInJoyHelper.i(ReadInJoyUtils.a(), true);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b(paramVVideoView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_e_of_type_Int == 1)
      {
        this.jdField_c_of_type_Int = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_c_of_type_Int);
      }
      if (this.d)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString);
        return;
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(paramBoolean);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a();
    PlayFeedbackHelper.a(localMap);
    paramOnVideoViewMethodListener.OnMethodSuccess(paramString, new JSONObject(localMap));
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel())
    {
      paramVVideoView = new StringBuilder();
      paramVVideoView.append("play: status=");
      paramVVideoView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a());
      paramVVideoView.append(", isPreload=");
      paramVVideoView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a());
      paramVVideoView.append(", videoinfo=");
      paramVVideoView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo);
      paramVVideoView.append(", mStartPosition:");
      paramVVideoView.append(this.jdField_a_of_type_Long);
      QLog.d("VVideoControlListenerImpl", 2, paramVVideoView.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c();
      return;
    }
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo;
    if (paramVVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(paramVVideoView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    paramVVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView;
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    localWindow.getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    localWindow.clearFlags(1024);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && ((paramVVideoView.a().getInstance().getFragment() instanceof ViolaLazyFragment)))
    {
      paramVVideoView = (ViolaFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.showTitleBar();
        paramVVideoView.recoverStatusBar();
      }
    }
    k();
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
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.f();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void beforeVideoStart()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(((VideoInfo)localObject).jdField_e_of_type_JavaLangString);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Boolean;
      boolean bool1 = true;
      int i;
      if (bool2) {
        i = 1;
      } else {
        i = 2;
      }
      localObject = new VideoEntity.Builder().setContentId(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_e_of_type_JavaLangString).setPage(this.jdField_a_of_type_AndroidAppActivity);
      if (i != 1) {
        bool1 = false;
      }
      localObject = ((VideoEntity.Builder)localObject).ignoreReport(bool1).setContentType(i).setVideoDuration(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int).addCustomParams(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaUtilMap).setIdentifier(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_e_of_type_JavaLangString).build();
      VideoReport.bindVideoPlayerInfo(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer, (VideoEntity)localObject);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.l();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "viola video");
    if (this.jdField_b_of_type_Boolean) {
      VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("videoToken", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a());
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
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.k();
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.f();
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.m();
    VideoVolumeController.getInstance().outKandianModule(this.jdField_a_of_type_AndroidAppActivity);
    VideoVolumeController.getInstance().removeEventListener(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.g();
  }
  
  public void f_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d(paramBoolean);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.i();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.h();
  }
  
  public void g_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.c(paramBoolean);
  }
  
  public void h()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_c_of_type_Int);
      this.f = true;
    }
  }
  
  public void i()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a(this.jdField_c_of_type_Int);
      this.f = true;
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.1(this), 0L);
      g();
    }
  }
  
  public void j()
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.2(this), 0L);
  }
  
  public void l_(int paramInt)
  {
    this.jdField_a_of_type_Long = (paramInt * 1000);
  }
  
  public void onBufferEnd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.h())
    {
      a(2, null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.g()) {
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
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("firstFrameReady", null);
    if (this.h) {
      a(2, null);
    }
    this.g = true;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(true);
  }
  
  public void onPhoneCome()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.d();
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramLong));
      localJSONObject.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.a() / 1000L);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(true);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer.e(false);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_Int = VideoVolumeController.getInstance().getStreamMaxVolume(3);
      }
      localJSONObject.put("value", paramInt / this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.a("volumeChange", localJSONObject);
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
    this.g = false;
    this.h = false;
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
    if (this.g) {
      a(2, null);
    }
    this.h = true;
  }
  
  public void onVideoStop()
  {
    a(7, null);
    this.h = false;
    this.g = false;
    VideoReport.unbindVideoPlayerInfo(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIReadInJoyPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoDelegate
 * JD-Core Version:    0.7.0.1
 */