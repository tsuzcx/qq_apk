package dov.com.qq.im.ae;

import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.MainThread;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture.FocusGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraProviderViewGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture.CameraSwitchGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraTriggerGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture.ZoomGestureListener;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.QIMCaptureVarManager;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.ShortVideoProcessUtil;
import dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEEffectListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.ABTestInfo;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.BinaryInfo;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.IDebugInfoCallback;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel.AEWaterMarkPanelListener;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import dov.com.qq.im.ae.camera.ui.tips.AETipsViewController;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.font.AEFontManager;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.qipc.AECameraGetInfoClient;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AECaptureAudioUtil;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.util.PicChooseJumpUtil;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout.PituCaptureButtonListener;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.control.CaptureAsyncControl;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import dov.com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.light.bean.WMElement;
import org.light.listener.IOnClickWatermarkListener;

@TargetApi(9)
public class AEPituCameraUnit
  extends AEBaseCameraUnit
  implements View.OnClickListener, View.OnTouchListener, AEFilterManager.MaterialInnerEffectListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener, AECameraGLSurfaceView.AEEffectListener, AEVideoStoryDashboardPart.IDebugInfoCallback, AEPituCameraCaptureButtonLayout.PituCaptureButtonListener, VideoFilterTools.OnResourceDownloadListener
{
  public static boolean f;
  public static boolean g = false;
  private long jdField_a_of_type_Long = 0L;
  protected GestureDetector a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected AEFilterManager a;
  protected CameraFocusGesture.FocusGestureListener a;
  protected CameraFocusGesture a;
  protected CameraProviderViewGesture a;
  protected CameraSwitchGesture.CameraSwitchGestureListener a;
  protected CameraSwitchGesture a;
  protected CameraTriggerGesture a;
  protected CameraViewPagerGesture a;
  protected CameraZoomGesture.ZoomGestureListener a;
  protected CameraZoomGesture a;
  private AEPituCameraUnit.ViewStubHoldersViewModel jdField_a_of_type_DovComQqImAeAEPituCameraUnit$ViewStubHoldersViewModel;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  protected final AECameraGLSurfaceView.AEGLSurfaceListener a;
  protected final AECameraManager.CameraManagerListener a;
  protected AECaptureController a;
  protected FilterPagerViewStubHolder a;
  protected AEMaterialPanel.AEMaterialPanelListener a;
  protected AEMaterialPanel a;
  protected AEWaterMarkPanel.AEWaterMarkPanelListener a;
  protected AEWaterMarkPanel a;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private AETipsViewController jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  protected VideoStoryCapturePartManager a;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private IOnClickWatermarkListener jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  protected View b;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  protected int e;
  protected boolean e;
  protected int f;
  private boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = AEThemeUtil.a();
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  
  static
  {
    jdField_f_of_type_Boolean = false;
  }
  
  public AEPituCameraUnit()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new AEPituCameraUnit.1(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = new AEPituCameraUnit.2(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = new AEPituCameraUnit.3(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener = new AEPituCameraUnit.4(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener = new AEPituCameraUnit.5(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener = new AEPituCameraUnit.6(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new AEPituCameraUnit.7(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "unitConstructor--fake");
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEPituCameraUnit] + END");
  }
  
  public AEPituCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new AEPituCameraUnit.1(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = new AEPituCameraUnit.2(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = new AEPituCameraUnit.3(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener = new AEPituCameraUnit.4(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener = new AEPituCameraUnit.5(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener = new AEPituCameraUnit.6(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new AEPituCameraUnit.7(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    long l1 = System.currentTimeMillis();
    AELaunchRecorder.a().a("unitConstructor-begin");
    Log.d(this.jdField_b_of_type_JavaLangString, "AEPituCameraUnit: cameraConfig.getFrom() =" + this.jdField_a_of_type_DovComQqImAeAECameraConfig.i());
    this.jdField_d_of_type_Int = 11;
    if (l())
    {
      this.jdField_d_of_type_Int = 13;
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10023, this.jdField_a_of_type_DovComQqImAeAECameraConfig.d(), this.jdField_a_of_type_DovComQqImAeAECameraConfig.a());
    }
    for (;;)
    {
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEPituCameraUnit] submit unit init");
      H();
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
      if (!AECameraEntry.e.a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i()))
      {
        this.jdField_d_of_type_Int = this.jdField_a_of_type_DovComQqImAeAECameraConfig.b().intValue();
        this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("edit_video_type", 10002), this.jdField_a_of_type_DovComQqImAeAECameraConfig.d(), this.jdField_a_of_type_DovComQqImAeAECameraConfig.a());
      }
      else
      {
        this.jdField_d_of_type_Int = 1;
      }
    }
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_DovComQqImAeAECameraConfig.i() != AECameraEntry.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (AECameraEntry.a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i()).a()) {
        AEBaseReportParam.a().a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i(), str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      AEBaseReportParam.a().a(str);
      AEBaseReportParam.a().a(true);
      AEBaseReportParam.a().b();
      AEBaseReportParam.a().a();
      AEBaseReportParam.a().b(CameraOperationHelper.a(a()));
    }
    AEBaseDataReporter.a().aa();
    if (AECameraEntry.e.a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i())) {
      StoryReportor.a("check_Android", AECameraEntry.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      if ((this.l) || (this.m) || (this.n))
      {
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "checkSetOnClickWatermarkListener--FAIL, some panel is showing");
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnClickWatermarkListener(null);
      }
    }
    else {
      return;
    }
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "checkSetOnClickWatermarkListener--PASS, no panel is showing");
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnClickWatermarkListener(this.jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener);
  }
  
  private void C()
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
  }
  
  private Intent a(Activity paramActivity, Class<?> paramClass, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("arg_video_source", 2);
    if (paramActivity.getIntent().getExtras() != null) {
      paramClass.putExtras(paramActivity.getIntent().getExtras());
    }
    if (paramIntent != null)
    {
      paramActivity = paramIntent.getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
      if (paramActivity != null) {
        paramClass.putParcelableArrayListExtra("key_read_in_joy_video_upload_report", paramActivity);
      }
    }
    if (paramPublishParam != null)
    {
      paramClass.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramPublishParam);
      paramClass.putExtra("arg_video_duration", paramPublishParam.jdField_a_of_type_Long);
      paramClass.putExtra("arg_video_path", paramPublishParam.j);
      paramClass.putExtra("arg_video_cover", paramPublishParam.c);
      paramClass.putExtra("arg_video_width", paramPublishParam.jdField_a_of_type_Int);
      paramClass.putExtra("arg_video_height", paramPublishParam.b);
    }
    return paramClass;
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      AECaptureMode localAECaptureMode2 = AECaptureMode.fromName(str);
      int i1;
      if (localAECaptureMode2 != null)
      {
        i1 = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < i1) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          AEQLog.d(this.jdField_b_of_type_JavaLangString, "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        i1 = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (AECameraEntry.c.a() == i1)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!AECameraEntry.d(i1))) {
          break label218;
        }
        str = AECameraPrefsUtil.a().a("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label218:
      str = null;
    }
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    T();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.25(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.26(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    int i1 = this.jdField_a_of_type_DovComQqImAeAECameraConfig.f();
    switch (i1)
    {
    case -1: 
    default: 
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "sendPhotoEndByConfig---unknown type: " + i1);
      return;
    case 0: 
    case 3: 
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    case 2: 
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_DovComQqImAeAECameraConfig.b(), Integer.valueOf(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()) });
      return;
    case 1: 
      CapturePicParams localCapturePicParams = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()).a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()).a(1).a();
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a(localCapturePicParams);
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_DovComQqImAeAECameraConfig.b() });
      return;
    }
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    boolean bool2 = true;
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {}
    label233:
    label238:
    do
    {
      return;
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onCaptureModeChanged---from " + paramAECaptureMode1 + " to " + paramAECaptureMode2);
      b(paramAECaptureMode1, paramAECaptureMode2);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture.a();
      }
      if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
      {
        bool1 = true;
        AEBaseReportParam.a().b(bool1);
        if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
        }
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.24(this));
        paramAECaptureMode1 = this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder;
        if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
          break label233;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAECaptureMode1.c(bool1);
        if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) {
          break label238;
        }
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController != null) {
          this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController.b();
        }
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
        return;
        bool1 = false;
        break;
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
  }
  
  private boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    return (paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.c) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements().size() > 0);
  }
  
  private long b()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = Utils.b();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    l1 >>>= 20;
    QLog.d(this.jdField_b_of_type_JavaLangString, 4, "available size = " + l1 + "M");
    return l1 / 30L;
  }
  
  private void b(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    Object localObject = a().getIntent();
    if (AECameraEntry.k((Intent)localObject))
    {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    }
    if (AECameraEntry.g((Intent)localObject))
    {
      localObject = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()).a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()).a(1).a();
      this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a((CapturePicParams)localObject);
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    if (AECameraEntry.m((Intent)localObject))
    {
      b(true);
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_DovComQqImAeAECameraConfig.b(), Integer.valueOf(14) });
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      s();
    }
    if (!paramAECaptureMode2.shouldStartCamera()) {
      d(false);
    }
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeAECameraConfig.g() == 0) {}
      for (i1 = CameraHelper.a();; i1 = this.jdField_a_of_type_DovComQqImAeAECameraConfig.g())
      {
        if (paramAECaptureMode2 == AECaptureMode.GIF) {
          i1 = 1;
        }
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(i1);
        return;
      }
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.changeCamera(i1, new AEPituCameraUnit.39(this));
  }
  
  private int c()
  {
    int i1 = AEPreviewSizeUtil.a();
    int i2 = ImmersiveUtils.getStatusBarHeight(a());
    int i3 = a().getResources().getDimensionPixelSize(2131296290);
    if (i1 == 1)
    {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "[getSurfaceTopMargin] long screen:" + (i2 + i3));
      return i2 + i3;
    }
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "[getSurfaceTopMargin]:0");
    return 0;
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.o)
      {
        if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
        {
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(true);
        }
        e(true);
        this.o = false;
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
    }
    e(false);
    this.o = false;
  }
  
  private boolean n()
  {
    return (!this.m) && (!this.l) && (!this.n);
  }
  
  protected void H()
  {
    ThreadManager.excute(new AEPituCameraUnit.8(this), 16, null, true);
  }
  
  @NotNull
  protected void I()
  {
    if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      Y();
      if (l())
      {
        ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378585);
        if (localViewStub != null)
        {
          localViewStub.inflate();
          AEQLog.b(this.jdField_b_of_type_JavaLangString, "AEPartAction--inflate bottom");
        }
      }
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a();
    }
  }
  
  public void J()
  {
    h();
  }
  
  public void K()
  {
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(786435, new Object[0]);
  }
  
  public void L()
  {
    O();
  }
  
  public void M()
  {
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    if (AECameraEntry.e.a(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i()))
    {
      localQIMCaptureVarManager.b(14);
      return;
    }
    localQIMCaptureVarManager.b(this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.c);
  }
  
  protected void N()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      PressScaleAnimDelegate.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718563));
      }
    }
    else {
      if (!g()) {
        break label106;
      }
    }
    for (;;)
    {
      p();
      if (l()) {
        AEReportUtils.b(13, null);
      }
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718564));
      break;
      label106:
      AEBaseDataReporter.a().H();
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera());
    }
  }
  
  protected void O()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  protected void P()
  {
    if (j()) {
      R();
    }
    while (!k()) {
      return;
    }
    Q();
  }
  
  protected void Q()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(131076, new Object[0]);
  }
  
  protected void R()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(131077, new Object[0]);
  }
  
  protected void S()
  {
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit$ViewStubHoldersViewModel = ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this).get(AEPituCameraUnit.ViewStubHoldersViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this, new AEPituCameraUnit.19(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().observe(this, new AEPituCameraUnit.20(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.d().observe(this, new AEPituCameraUnit.21(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().observe(this, new AEPituCameraUnit.22(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().observe(this, new AEPituCameraUnit.23(this));
  }
  
  protected void T()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.27(this));
    }
  }
  
  public void U()
  {
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().onBackPressed();
  }
  
  public void V()
  {
    a().getIntent().removeExtra("widgetinfo");
    PicChooseJumpUtil.a(a());
  }
  
  protected void W()
  {
    AECircleMultiUnit.a(false, a());
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(false));
  }
  
  protected void X()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture = new CameraProviderViewGesture();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture.a(new AEPituCameraUnit.40(this));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener);
    AECameraGLSurfaceView localAECameraGLSurfaceView = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
    if (l()) {}
    for (int i1 = c();; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture = new CameraTriggerGesture(localAECameraGLSurfaceView, i1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture = new CameraSwitchGesture(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener);
      return;
    }
  }
  
  @MainThread
  protected void Y()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "setCaptureModeViewModel---");
    AEVideoStoryCaptureModeViewModel localAEVideoStoryCaptureModeViewModel = (AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class);
    localAEVideoStoryCaptureModeViewModel.a.setValue(new AECaptureModeChangingEvent(null, this.jdField_a_of_type_DovComQqImAeAECameraConfig.a(), 1));
    localAEVideoStoryCaptureModeViewModel.b.setValue(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a());
  }
  
  public void Z()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a();
  }
  
  protected int a()
  {
    if (l()) {
      return 2131558538;
    }
    return 2131558537;
  }
  
  protected long a()
  {
    return 5L;
  }
  
  protected BroadcastReceiver a()
  {
    return this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController = a();
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager = new VideoStoryCapturePartManager(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), this.jdField_a_of_type_AndroidViewView, this);
    ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    aa();
    I();
    S();
    X();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setMaterialPanelListener(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new AEPituCameraUnit.AEGestureListener(this), null, true);
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController = new AETipsViewController(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder = new FilterPagerViewStubHolder((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378591));
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit$ViewStubHoldersViewModel.b.postValue(this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder);
    Object localObject = this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder;
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      bool = true;
      ((FilterPagerViewStubHolder)localObject).a(bool);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder = new BeautyAndFilterPanelViewStubHolder((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378583));
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit$ViewStubHoldersViewModel.a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder);
      CosFunHelper.setCountDownListener(new AEPituCameraUnit.11(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture = this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder.a();
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = Base64.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363759);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          AEQLog.b(this.jdField_b_of_type_JavaLangString, "[UnitAsyncInit] after await");
          return localView;
          bool = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            AEQLog.d(this.jdField_b_of_type_JavaLangString, "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected DarkModeChecker.DarkModeListener a()
  {
    return this;
  }
  
  protected AECaptureParam a()
  {
    int i2 = 1;
    Intent localIntent = a().getIntent();
    if (AECameraEntry.j(localIntent)) {
      if ((localIntent.getBooleanExtra("key_camera_prefer_id", false)) || (!CameraUtils.d())) {
        i2 = 2;
      }
    }
    label103:
    while (MediaCodecDPC.l())
    {
      return DovSVParamManager.a().a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), i2);
      if (this.jdField_a_of_type_DovComQqImAeAECameraConfig.g() == 0) {}
      for (int i1 = CameraHelper.a();; i1 = this.jdField_a_of_type_DovComQqImAeAECameraConfig.g())
      {
        if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) && (CameraUtils.d())) {
          break label103;
        }
        i2 = i1;
        break;
      }
    }
    return DovSVParamManager.a().a(this.jdField_a_of_type_DovComQqImAeAECameraConfig);
  }
  
  protected AECameraManager.CameraManagerListener a()
  {
    return this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener;
  }
  
  public AECaptureController a()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController == null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController = new AECaptureController(this.jdField_a_of_type_AndroidViewView, this);
    }
    return this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController;
  }
  
  public AECaptureMode a(int paramInt)
  {
    AECaptureMode localAECaptureMode = AECaptureMode.NORMAL;
    switch (paramInt)
    {
    default: 
      localAECaptureMode = AECaptureMode.NORMAL;
    }
    for (;;)
    {
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + localAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
      return localAECaptureMode;
      localAECaptureMode = AECaptureMode.PLAY;
      continue;
      localAECaptureMode = AECaptureMode.PLAY;
      continue;
      localAECaptureMode = AECaptureMode.NORMAL;
      continue;
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, paramInt);
      continue;
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, paramInt);
      continue;
      localAECaptureMode = AECaptureMode.GIF;
    }
  }
  
  public HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public List<WMElement> a()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return Collections.emptyList();
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements();
  }
  
  protected void a()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "actionAfterFirstFrame");
    int i1 = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(CaptureAsyncControl.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(i1) });
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.e();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(this.jdField_b_of_type_JavaLangString, "notifyPreviewSizeChanged: ");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + jdField_f_of_type_Boolean);
    }
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    ReportUtil.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        paramIntent = this.jdField_b_of_type_JavaLangString;
        bool1 = bool2;
        if (localActivity == null) {
          bool1 = true;
        }
        QLog.d(paramIntent, 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool1) });
      }
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        if (paramInt1 != 1024) {
          break;
        }
      } while (paramInt2 != -1);
      localActivity.setResult(-1, paramIntent);
      localActivity.finish();
      return;
      if (paramInt1 == 1026)
      {
        this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("file_send_path");
        long l1 = paramIntent.getLongExtra("file_send_duration", -1L);
        localObject2 = paramIntent.getStringExtra("widgetinfo");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 > 0L))
        {
          paramIntent = new Intent(localActivity, SendVideoActivity.class);
          paramIntent.putExtra("file_send_path", (String)localObject1);
          paramIntent.putExtra("file_send_size", new File((String)localObject1).length());
          paramIntent.putExtra("file_send_duration", l1);
          paramIntent.putExtra("uin", this.jdField_a_of_type_DovComQqImAeAECameraConfig.a().jdField_a_of_type_JavaLangString);
          paramIntent.putExtra("uintype", this.jdField_a_of_type_DovComQqImAeAECameraConfig.a().jdField_a_of_type_Int);
          paramIntent.putExtra("file_source", "album");
          paramIntent.putExtra("start_init_activity_after_sended", false);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramIntent.putExtra("widgetinfo", (String)localObject2);
          }
          localActivity.startActivity(paramIntent);
          localActivity.finish();
          return;
        }
      }
      if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        localObject2 = (QimMusicPlayer)QIMManager.a().c(8);
        if (localObject2 != null) {
          ((QimMusicPlayer)localObject2).c();
        }
        localActivity.startActivityForResult(a(localActivity, ReadInJoyDeliverVideoActivity.class, (PublishParam)localObject1, paramIntent), 111);
        localActivity.setResult(paramInt2, paramIntent);
        localActivity.finish();
        return;
      }
      if (paramInt1 == 111)
      {
        localActivity.setResult(paramInt2, paramIntent);
        localActivity.finish();
        return;
      }
      AEQLog.a(this.jdField_b_of_type_JavaLangString, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
      if (paramInt1 != 10020) {
        break;
      }
    } while (paramInt2 != -1);
    localActivity.setResult(paramInt2, paramIntent);
    localActivity.finish();
    return;
    if ((paramIntent == null) && (paramInt2 == 0) && (jdField_f_of_type_Boolean))
    {
      jdField_f_of_type_Boolean = false;
      return;
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.i();
    }
    if (paramInt2 == 0) {
      QQFilterRenderManagerHolder.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.a() != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeAECameraConfig.a().a());
    }
    if ((paramInt1 == 1012) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if ((paramIntent == null) || (!paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
          break label735;
        }
        label690:
        if (paramIntent == null) {
          break label741;
        }
        paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
        paramIntent.putExtra("input_full_screen_mode", bool1);
        localActivity.setResult(-1, paramIntent);
      }
      for (;;)
      {
        localActivity.finish();
        return;
        localObject1 = "";
        break;
        label735:
        bool1 = false;
        break label690;
        label741:
        paramIntent = new Intent();
        paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
        paramIntent.putExtra("input_full_screen_mode", bool1);
        localActivity.setResult(-1, paramIntent);
      }
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      localObject1 = a().getIntent();
      if (localObject1 == null) {
        break label935;
      }
    }
    label935:
    for (Object localObject1 = ((Intent)localObject1).getStringExtra("KEY_SEND_ARK_MSG_ID");; localObject1 = null)
    {
      localObject2 = this.jdField_a_of_type_DovComQqImAeAECameraConfig.a();
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onActivityResult: edit video finish, arkId=").append((String)localObject1).append(", session is null=");
      if (localObject2 == null) {}
      for (bool1 = bool3;; bool1 = false)
      {
        AEQLog.b(str, bool1);
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (localObject2 == null)) {
          break;
        }
        localActivity.finish();
        return;
      }
      ShortVideoProcessUtil.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), paramIntent, this.jdField_a_of_type_DovComQqImSettingICameraEntrance, null);
      return;
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(paramInt1, paramInt2, paramIntent);
      return;
    }
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196617, new Object[] { Integer.valueOf(paramInt), paramAEFilterManager });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)QIMManager.a().c(18);
    if ((localAEMaterialManager == null) || (paramInt < 0))
    {
      QQToast.a(a(), 2131689691, 1).a();
      return;
    }
    localAEMaterialManager.a(false);
    paramString = localAEMaterialManager.a(paramInt, paramString, l());
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "entry dynamics: aeMaterialMetaData" + paramString);
    if (paramString == null)
    {
      QQToast.a(a(), 2131689691, 1).a();
      return;
    }
    if (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString)) {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "entry dynamics: category is exit but id is null");
    }
    AECircleMultiUnit.a(false, a());
    a().a(true, 150);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196612, new Object[0]);
  }
  
  protected void a(long paramLong)
  {
    boolean bool2 = false;
    Intent localIntent = new Intent(a(), AEStoryGIFPreviewActivity.class);
    localIntent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
    localIntent.putExtra("KEY_AVAILABLE_EMO_COUNT", paramLong);
    Object localObject = (AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this).get(AEVideoStoryGIFTplViewModel.class);
    AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)((AEVideoStoryGIFTplViewModel)localObject).b().getValue();
    if (localAEMaterialWrapper != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localIntent.putExtra("KEY_MATERIAL_APPLIED", bool1);
      if (localAEMaterialWrapper != null) {
        localIntent.putExtra("ARG_GIF_MATERIAL_ID", localAEMaterialWrapper.jdField_a_of_type_JavaLangString);
      }
      localIntent.putExtra("KEY_AVAILABLE_SAVENAME", (String)((AEVideoStoryGIFTplViewModel)localObject).c().getValue());
      localIntent.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeAECameraConfig.a());
      localObject = a().getIntent();
      if (!AECameraEntry.g((Intent)localObject))
      {
        bool1 = bool2;
        if (!AECameraEntry.h((Intent)localObject)) {}
      }
      else
      {
        bool1 = true;
      }
      localIntent.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
      localObject = a();
      if (localObject != null)
      {
        localIntent.putExtra("AECAMERA_MODE", this.jdField_a_of_type_DovComQqImAeAECameraConfig.j());
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", this.jdField_a_of_type_DovComQqImAeAECameraConfig.i());
        ((Activity)localObject).startActivityForResult(localIntent, 101);
      }
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "[AE Profiler] AEPituCameraUnit onCreate");
    long l1 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    AEBaseReportParam.a().c(l1);
    super.a(paramBundle);
    com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = true;
    jdField_f_of_type_Boolean = false;
    VideoFilterTools.a().b(false);
    this.jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener = new AEPituCameraUnit.9(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) && ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton instanceof AEPituCameraCaptureButtonLayout))) {
      ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton).a(paramMotionEvent);
    }
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < a())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + a());
        }
        O();
        return;
      }
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      AEBaseReportParam.a().b(5L);
      AEBaseDataReporter.a().af();
      long l1 = b();
      if (l1 > 0L)
      {
        a(l1);
        return;
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.41(this, paramAEVideoCaptureResult));
  }
  
  public void a(@NonNull List<AEDashboardUtil.BinaryInfo> paramList, @NonNull List<AEDashboardUtil.ABTestInfo> paramList1)
  {
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected boolean a()
  {
    return l();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      b();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public AECaptureMode[] a(int paramInt)
  {
    AECaptureMode[] arrayOfAECaptureMode;
    switch (paramInt)
    {
    default: 
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
    }
    for (;;)
    {
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + this.jdField_a_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(arrayOfAECaptureMode));
      return arrayOfAECaptureMode;
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.PLAY;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.PLAY;
      arrayOfAECaptureMode[1] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.PLAY;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[3];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.PLAY;
      arrayOfAECaptureMode[2] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.GIF;
    }
  }
  
  protected void aa()
  {
    LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, ViewUtils.a(1.0F));
    ab();
  }
  
  protected void ab()
  {
    Object localObject = a();
    if (ScreenUtil.getRealHeight((Context)localObject) / ScreenUtil.getRealWidth((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!AECameraEntry.h(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i())) {
        a((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_b_of_type_AndroidViewView.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AEPituCameraUnit.45(this));
      }
    }
  }
  
  protected int b()
  {
    int i1;
    if (l())
    {
      i1 = AEPreviewSizeUtil.a();
      if (i1 == 1)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio.code;
      if (i1 == 2)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        break;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
      break;
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
    }
  }
  
  public void b()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "onActivityPause");
    super.b();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder.b();
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.l();
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.g();
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.c();
    AEMaterialManager.jdField_b_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "onActivityPause, ID=" + this.c);
    }
  }
  
  public void b(String paramString)
  {
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)QIMManager.a().c(18);
    if ((localAEMaterialManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      localAEMaterialManager.a(false);
      paramString = localAEMaterialManager.a(paramString, l());
      if (paramString == null) {
        Toast.makeText(a(), 2131689691, 1).show();
      }
    }
    else
    {
      return;
    }
    AECircleMultiUnit.a(false, a());
    a().a(true, 150);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196612, new Object[0]);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBundlePath(paramString1, paramString2);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController == null) {
      return false;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589824)) && (((Boolean)this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589826, new Object[0])).booleanValue()))
    {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "WaterMark editor need hide");
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.g();
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.i();
    Intent localIntent;
    String str1;
    String str2;
    if (l())
    {
      localIntent = a().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 != null)
      {
        localIntent.setClassName(str2, str1);
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
        localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localIntent.addFlags(603979776);
        if (localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
          break label207;
        }
        a().startActivity(localIntent);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
      AEBaseDataReporter.a().E();
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Click】onBackPressed");
      return true;
      label207:
      localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = localIntent.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(localIntent, str1);
        QZoneHelper.launchQZone(a(), str3, localIntent, 2);
      }
    }
  }
  
  public void c()
  {
    super.c();
    C();
    if (AEDashboardUtil.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = null;
    }
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.f();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder.c();
    }
    GestureRecognitionUtils.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_DovComQqImAeUtilAECaptureAudioUtil.b();
    AEBaseReportParam.a().l();
    AEBaseReportParam.a().a(false);
    AECameraGetInfoClient.b();
    if ((a() != null) && (AECameraEntry.j(a().getIntent()))) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(CameraHelper.a());
    }
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)QIMManager.a(18);
    localAEMaterialManager.a();
    localAEMaterialManager.g();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.d();
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnClickWatermarkListener(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnlineUsrCountDelegate("watermark.qq.online", null);
    }
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367180);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    while (AECameraEntry.j(a().getIntent())) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "onActivityResume");
    this.jdField_b_of_type_Boolean = true;
    if (jdField_f_of_type_Boolean) {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
    }
    do
    {
      return;
      super.d();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.refreshDarkModeTimer();
      B();
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraTriggerGesture);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.h();
      if (this.i)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.k();
        }
        e();
        a(false);
      }
      if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
        this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.b();
      }
      M();
      f(false);
      AEMaterialManager.jdField_b_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        AEQLog.a(this.jdField_b_of_type_JavaLangString, "onActivityResume, ID=" + this.c);
      }
    } while (!l());
    HashMap localHashMap = null;
    if (AEMaterialManager.a() != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("ext2", AEMaterialManager.a().jdField_a_of_type_JavaLangString);
    }
    AEReportUtils.a(1, localHashMap);
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int i3 = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    int i1;
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label193;
      }
      i2 = 1;
      label48:
      if (PermissionUtils.isStorePermissionEnable((Context)localObject)) {
        break label198;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (i1 != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Camera Permission】denied");
      }
      if (i2 != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Audio Permission】denied");
      }
      if (i3 != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        AEQLog.b(this.jdField_b_of_type_JavaLangString, "【External Storage Permission】denied");
      }
      localObject = DialogUtil.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.34(this, (String)localObject));
      return;
      i1 = 0;
      break;
      label193:
      i2 = 0;
      break label48;
      label198:
      i3 = 0;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (CameraUtils.d()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.b()) {
        break label125;
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    for (;;)
    {
      f(true);
      AEBaseReportParam.a().i();
      AEBaseDataReporter.a().Z();
      if ((!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(0);
      }
      if (n()) {
        AECircleMultiUnit.a(true, a());
      }
      this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
      break;
      label125:
      if ((this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) && (this.o))
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
      }
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.jdField_f_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(true));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.resetMaterialWhenRecord();
    if ((this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.startCaptureVideo();
    if (!this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusModeRecording();
    }
    ((CaptureComboManager)QIMManager.a(5)).a(true);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(327687, new Object[0]);
      return;
    }
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(327688, new Object[0]);
  }
  
  protected boolean f()
  {
    return AECameraEntry.k(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i());
  }
  
  public void g()
  {
    Log.d(this.jdField_b_of_type_JavaLangString, "onCaptureButtonVideoStop: thread = " + Thread.currentThread().getName());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.stopCaptureVideo();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopRecordVideo();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    ((CaptureComboManager)QIMManager.a(5)).a(false);
    c(0);
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!g)
    {
      g = true;
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new AEPituCameraUnit.31(this));
      return;
    }
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new AEPituCameraUnit.32(this));
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Camera / Audio / Storage Permission】grant");
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      u();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController.c();
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
    AECircleMultiUnit.a(false, a());
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(false));
  }
  
  public boolean h()
  {
    return true;
  }
  
  public void i()
  {
    super.i();
  }
  
  protected boolean i()
  {
    return (this.jdField_a_of_type_DovComQqImAeAECameraConfig != null) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.f() != -1);
  }
  
  public void j()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "onActivityStart");
    super.j();
    if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    AEBaseDataReporter.a().D();
    if (QLog.isDevelopLevel()) {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "onActivityStart, ID=" + this.c);
    }
  }
  
  protected boolean j()
  {
    return (this.jdField_a_of_type_DovComQqImAeAECameraConfig.c() == 101) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.c()) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.a()) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.f());
  }
  
  public void k()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "onActivityStop");
    super.k();
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.e();
    AEBaseDataReporter.a().c(this.jdField_b_of_type_Long);
    if (QLog.isDevelopLevel()) {
      AEQLog.a(this.jdField_b_of_type_JavaLangString, "onActivityStop, ID=" + this.c);
    }
  }
  
  protected boolean k()
  {
    return (this.jdField_a_of_type_DovComQqImAeAECameraConfig.c() == 101) && (this.jdField_a_of_type_DovComQqImAeAECameraConfig.e());
  }
  
  public boolean l()
  {
    return AECameraEntry.k(a().getIntent());
  }
  
  protected void m()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeGLSurfaceListener(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new AEPituCameraUnit.42(this));
    if (MediaCodecDPC.l())
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      if (AEDashboardUtil.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = this;
      }
      if (l()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeEditMaterialSelectedListener(new AEPituCameraUnit.43(this));
      }
      return;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(false);
    }
  }
  
  /* Error */
  public boolean m()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 133	dov/com/qq/im/ae/AEPituCameraUnit:jdField_e_of_type_Int	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	AEPituCameraUnit
    //   8	4	1	i1	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  protected void n()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.33(this));
  }
  
  public void notifyEnableLutType(int paramInt)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramInt == 1000)
    {
      d(1);
      if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
        this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
      }
      localObject = AEFilterManagerHolder.getAEFilterManager();
      if (localObject != null)
      {
        if (paramInt == 1000) {
          break label109;
        }
        bool1 = true;
        label54:
        ((AEFilterProcessTex)localObject).jdField_a_of_type_Boolean = bool1;
        if (paramInt == 1000) {
          ((AEFilterProcessTex)localObject).f();
        }
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController != null)
      {
        localObject = this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController;
        if (paramInt == 1000) {
          break label114;
        }
      }
    }
    label109:
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AECaptureController)localObject).jdField_a_of_type_Boolean = bool1;
      return;
      d(0);
      break;
      bool1 = false;
      break label54;
    }
  }
  
  public void notifyEnableMeshType(int paramInt)
  {
    if (paramInt == 2001) {}
    for (paramInt = 4;; paramInt = 3)
    {
      e(paramInt);
      return;
    }
  }
  
  public void o()
  {
    W();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(8);
    }
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262147, new Object[0]);
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    int i1 = AEBeautyProviderView.a();
    int i2 = AEBeautyProviderView.b();
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a(i1);
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.b(i2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.10(this));
    AEFontManager.a().a();
  }
  
  public void onAssetProcessingData(HashMap<String, String> paramHashMap)
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onAssetProcessingData: " + paramHashMap);
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void onCaptureError(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onCaptureError. errorCode = " + paramInt, new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.44(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
      {
        PressScaleAnimDelegate.a(this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.isSelected())
        {
          bool = true;
          label105:
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(bool);
          e(bool);
          if (bool) {
            break label147;
          }
          this.o = true;
          label127:
          ReportUtil.a(bool);
          if (!bool) {
            break label155;
          }
        }
        for (;;)
        {
          CaptureReportUtil.a(i1);
          break;
          bool = false;
          break label105;
          label147:
          this.o = false;
          break label127;
          label155:
          i1 = 2;
        }
        N();
        continue;
        PressScaleAnimDelegate.a(paramView, 200L, null);
        U();
        continue;
        a().getIntent().removeExtra("widgetinfo");
      }
    }
  }
  
  public void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onDeviceNotSupportMaterial()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.46(this));
  }
  
  public void onHideNormalTip()
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onHideNormalTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.36(this));
  }
  
  public void onHidePagTip()
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onHidePagTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.38(this));
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    AEBaseReportParam.a().b(2L);
    AEBaseDataReporter.a().d(paramLocalMediaInfo.mDuration);
    b(false);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196610, new Object[0]) });
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEPhotoCaptureResult = paramAEPhotoCaptureResult;
    AEBaseReportParam.a().b(1L);
    AEBaseDataReporter.a().d(-1L);
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "【Type】Photo");
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WMElement localWMElement = (WMElement)((Iterator)localObject).next();
          if ("CHECK_IN".equals(localWMElement.type)) {
            localWMElement.doCheckIn();
          }
        }
      }
    }
    if (i()) {
      a(paramAEPhotoCaptureResult);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
      return;
      b(paramAEPhotoCaptureResult);
    }
  }
  
  public void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    T();
    C();
    if (!g())
    {
      if (paramVideoMaterial == null) {
        AEBaseReportParam.a().c("none");
      }
    }
    else
    {
      if ((paramVideoMaterial != null) && (paramVideoMaterial.isWatermarkMaterial()) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
      {
        AEQLog.a(this.jdField_b_of_type_JavaLangString, "onSelectFaceEffect: wmSetOnlineUsrCountDelegate");
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnlineUsrCountDelegate("watermark.qq.online", new AEPituCameraUnit.28(this));
      }
      if ((paramVideoMaterial == null) || (!paramVideoMaterial.isEditableWatermark()) || (g())) {
        break label137;
      }
      a().runOnUiThread(new AEPituCameraUnit.29(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController != null) {
        this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController.a(paramVideoMaterial);
      }
      return;
      AEBaseReportParam.a().c(paramVideoMaterial.getId());
      break;
      label137:
      a().runOnUiThread(new AEPituCameraUnit.30(this, paramVideoMaterial));
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    if ((paramAEFilterProcessTex != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController != null)) {
      paramAEFilterProcessTex.a(this.jdField_a_of_type_DovComQqImAeCameraUiTipsAETipsViewController.a());
    }
    if (paramAEFilterProcessTex != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterProcessTex.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onShowNormalTip: tip=" + paramString1 + ", icon=" + paramString2 + ", duration=" + paramInt);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.35(this, paramString1, paramString2, paramInt));
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "onShowPagTip: pagPath=" + paramString + ", duration=" + paramInt);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.37(this, paramString, paramInt));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(), this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  public void onVideoCaptureStart()
  {
    h();
    c(8);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(262145, new Object[0]);
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (g()) {
      a(paramAEVideoCaptureResult);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
      return;
      int i1 = 500;
      if (this.jdField_d_of_type_Int == 13) {
        i1 = 2000;
      }
      if (MediaUtil.a(paramAEVideoCaptureResult.videoMp4FilePath) < i1)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
        O();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  protected void q()
  {
    super.q();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367256);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373621));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373622));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit
 * JD-Core Version:    0.7.0.1
 */