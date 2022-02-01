package dov.com.qq.im.ae;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.QIMCameraLifeCycleBaseUnit;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEKitInitListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.CaptureListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap;
import dov.com.qq.im.ae.qipc.AECameraGetInfoClient;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECaptureAudioUtil;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECameraErrorDialog;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public abstract class AEBaseCameraUnit
  extends QIMCameraLifeCycleBaseUnit
  implements IBaseCameraUnit, AECameraGLSurfaceView.AEKitInitListener, AECameraGLSurfaceView.CaptureListener
{
  protected static final LinkedList<Integer> a;
  protected volatile SurfaceTexture a;
  protected Handler a;
  protected View a;
  protected ViewStub a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected CameraFocusView a;
  protected LocalMediaInfo a;
  protected AECameraConfig a;
  protected AEPhotoCaptureResult a;
  protected AEVideoCaptureResult a;
  protected AECameraGLSurfaceView a;
  protected AECameraManager a;
  protected AEVideoStoryTopBarViewModel.Ratio a;
  protected AECaptureMode a;
  protected AECaptureAudioUtil a;
  protected AECameraErrorDialog a;
  protected CaptureEntranceParams a;
  protected ICameraEntrance a;
  public IQIMCameraContainer a;
  protected AbsAECaptureButton a;
  protected AECaptureMode[] a;
  protected AECaptureMode b;
  protected final String b;
  protected boolean b;
  protected int c;
  protected volatile boolean c;
  protected int d;
  protected volatile boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public AEBaseCameraUnit()
  {
    this.jdField_b_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_DovComQqImAeUtilAECaptureAudioUtil = new AECaptureAudioUtil();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = null;
    this.jdField_d_of_type_Int = 11;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    AEQLog.a(this.jdField_b_of_type_JavaLangString, "unitConstructor--fake");
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEBaseCameraUnit] + END");
  }
  
  public AEBaseCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_b_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_DovComQqImAeUtilAECaptureAudioUtil = new AECaptureAudioUtil();
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = null;
    this.jdField_d_of_type_Int = 11;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_DovComQqImSettingICameraEntrance = paramICameraEntrance;
    this.jdField_a_of_type_DovComQqImAeAECameraConfig = a();
  }
  
  private AudioCapture a(AECaptureParam paramAECaptureParam)
  {
    return new AudioCapture(paramAECaptureParam.a, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getCameraHandler());
  }
  
  private void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(a());
    AECaptureParam localAECaptureParam = a();
    if (this.jdField_a_of_type_DovComQqImAeAECameraConfig.d()) {}
    for (AudioCapture localAudioCapture = a(localAECaptureParam);; localAudioCapture = null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.init(localAECaptureParam, localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyEnable(this.jdField_a_of_type_DovComQqImAeAECameraConfig.c());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectEnable(this.jdField_a_of_type_DovComQqImAeAECameraConfig.e());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFilterEnable(this.jdField_a_of_type_DovComQqImAeAECameraConfig.f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceEnable(this.jdField_a_of_type_DovComQqImAeAECameraConfig.a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setUseVideoOrientation(this.jdField_a_of_type_DovComQqImAeAECameraConfig.h());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.init(localAECaptureParam);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setAudioCapture(localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeEnable(this.jdField_a_of_type_DovComQqImAeAECameraConfig.i());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeListener(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeChecker(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
      return;
    }
  }
  
  protected static void a(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(2048);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().addFlags(256);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x4);
    }
  }
  
  protected int a()
  {
    return 2131558538;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
  }
  
  protected abstract BroadcastReceiver a();
  
  protected IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.c.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.k.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.j.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.f.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.g.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.e.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.d.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.h.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.i.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.l.jdField_b_of_type_JavaLangString);
    return localIntentFilter;
  }
  
  public View a()
  {
    a("unitInflateView-begin");
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    a("unitInflateView-end");
    q();
    r();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract DarkModeChecker.DarkModeListener a();
  
  @NotNull
  protected DarkModeChecker a()
  {
    return new DarkModeChecker();
  }
  
  protected AECameraConfig a()
  {
    return c();
  }
  
  protected AECaptureParam a()
  {
    return DovSVParamManager.a().a(this.jdField_a_of_type_DovComQqImAeAECameraConfig);
  }
  
  protected abstract AECameraManager.CameraManagerListener a();
  
  public AECaptureMode a(int paramInt)
  {
    return AECaptureMode.NORMAL;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    c(false);
    this.jdField_d_of_type_Boolean = d();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.jdField_c_of_type_Int = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onCreate, restore from background, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeUtilAECaptureAudioUtil.a();
      AECameraGetInfoClient.a();
      if (!jdField_a_of_type_JavaUtilLinkedList.contains(Integer.valueOf(this.jdField_c_of_type_Int))) {
        jdField_a_of_type_JavaUtilLinkedList.push(Integer.valueOf(this.jdField_c_of_type_Int));
      }
      a().registerReceiver(a(), a());
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onCreate, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      this.jdField_c_of_type_Int = (jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onCreate, new created, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    AELaunchRecorder.a().a(paramString);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        Activity localActivity = a();
        bool1 = bool2;
        if (!Settings.System.canWrite(localActivity))
        {
          DialogUtil.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.switchFlash(paramBoolean);
    }
    return bool1;
  }
  
  public AECaptureMode[] a(int paramInt)
  {
    return new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  }
  
  protected int b()
  {
    return AEVideoStoryTopBarViewModel.Ratio.FULL.code;
  }
  
  public AECameraConfig b()
  {
    if (this.jdField_a_of_type_DovComQqImAeAECameraConfig == null) {
      this.jdField_a_of_type_DovComQqImAeAECameraConfig = a();
    }
    return this.jdField_a_of_type_DovComQqImAeAECameraConfig;
  }
  
  public void b()
  {
    super.b();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    s();
    d(false);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.jdField_c_of_type_Int);
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "onSaveInstanceState---destroyed in background, ID=" + this.jdField_c_of_type_Int);
  }
  
  protected AECameraConfig c()
  {
    AECameraConfig.Builder localBuilder = new AECameraConfig.Builder();
    Intent localIntent = a().getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      boolean bool1 = localIntent.getExtras().getBoolean("PeakConstants.ARG_AUDIO", true);
      int i = localIntent.getExtras().getInt("ARG_CAPTURE_MAX_DURATION", -1);
      boolean bool2 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
      boolean bool3 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
      boolean bool4 = localIntent.getExtras().getBoolean("PeakConstants.ARG_BEAUTY", true);
      boolean bool5 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SHARP_FACE", true);
      boolean bool6 = localIntent.getExtras().getBoolean("PeakConstants.ARG_ALBUM", true);
      int j = localIntent.getExtras().getInt("ARG_DEFAULT_OPEN_PANEL", -1);
      int k = localIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      int m = localIntent.getExtras().getInt("edit_video_way", 0);
      int n = localIntent.getExtras().getInt("entrance_type", 120);
      int i1 = localIntent.getExtras().getInt("extra.busi_type", 14);
      SessionWrap localSessionWrap = (SessionWrap)localIntent.getParcelableExtra("ARG_SESSION_INFO");
      String str = localIntent.getStringExtra("ARG_AIO_CLASS");
      int i2 = localIntent.getExtras().getInt("key_camera_photo_edit_type", -1);
      int i3 = localIntent.getExtras().getInt("key_camera_video_edit_type", -1);
      int i4 = localIntent.getExtras().getInt("ability_flag", -1);
      int i5 = localIntent.getIntExtra("AECAMERA_MODE", 200);
      boolean bool7 = localIntent.getBooleanExtra("key_camera_use_video_orientation", true);
      boolean bool8 = localIntent.getBooleanExtra("key_camera_auto_rotate", true);
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = a(i5);
      this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = a(i5);
      boolean bool9 = a().getIntent().getBooleanExtra("key_has_countdown", false);
      int i6 = b();
      int i7 = localIntent.getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0);
      int i8 = localIntent.getIntExtra("key_camera_result_code", -1);
      localBuilder.f(k).a(i8).a(bool1).c(bool4).c(j).e(bool2).b(i).d(bool5).f(bool3).b(bool6).m(i4).l(n).d(i1).e(m).g(i2).h(i3).h(bool8).g(bool7).i(bool9).k(i5).a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode).a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode).a(localSessionWrap).a(str).j(i6).i(i7);
    }
    return localBuilder.a();
  }
  
  public void c()
  {
    super.c();
    a().unregisterReceiver(a());
    d(true);
    GLGestureProxy.getInstance().removeAllListener();
    PlayDownloadManagerWrap.getInstance().clearObserver();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onDestroy();
    WatermarkDataManager.a().a();
    CosFunHelper.setCountDownListener(null);
    c(true);
    if (e())
    {
      jdField_a_of_type_JavaUtilLinkedList.pop();
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onDestroy, is on top, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onDestroy, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "onDestroy, is NOT on top, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), paramBoolean, 5);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  protected abstract boolean c();
  
  public void d()
  {
    super.d();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    s();
    d(false);
    this.jdField_d_of_type_Boolean = d();
    v();
  }
  
  public void d(boolean paramBoolean)
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "closeCamera");
    if (!e())
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopCamera(paramBoolean);
  }
  
  protected boolean d()
  {
    if (Build.VERSION.SDK_INT < 23) {
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "checkPermission---below android6.0, no need check");
    }
    int i;
    int j;
    boolean bool;
    do
    {
      return true;
      Activity localActivity = a();
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      bool = PermissionUtils.isStorePermissionEnable(localActivity);
      AEQLog.b(this.jdField_b_of_type_JavaLangString, "checkPermission, camera: " + i + " audio: " + j + ", storage=" + bool);
    } while ((i == 0) && (j == 0) && (bool));
    return false;
  }
  
  protected void e(boolean paramBoolean)
  {
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected boolean e()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilLinkedList.peek();
    return (localInteger != null) && (localInteger.intValue() == this.jdField_c_of_type_Int);
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 4, "capturePhotoByCameraProxy");
      AEDashboardUtil.a.jdField_b_of_type_Boolean = false;
      y();
    }
    for (;;)
    {
      o();
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 4, "capturePhotoByAEKit");
      AEDashboardUtil.a.jdField_b_of_type_Boolean = true;
      x();
    }
  }
  
  protected abstract void m();
  
  protected abstract void n();
  
  public abstract void o();
  
  public void onAEKitInited()
  {
    Log.d(this.jdField_b_of_type_JavaLangString, "onAEKitInited: thread = " + Thread.currentThread().getName());
  }
  
  public void p()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.toggleCamera(new AEBaseCameraUnit.2(this));
  }
  
  protected void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363738));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363736));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364338));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378586));
  }
  
  protected void r()
  {
    AECaptureMode.NORMAL.setHasCountDown(this.jdField_a_of_type_DovComQqImAeAECameraConfig.j());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.jdField_a_of_type_DovComQqImAeAECameraConfig.h());
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = this.jdField_a_of_type_DovComQqImAeAECameraConfig.a();
    a();
    m();
  }
  
  public void reportFirstFrameShown()
  {
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isSupportCamera2()) {}
    for (int i = 2;; i = 1)
    {
      localAEBaseDataReporter.c(i);
      return;
    }
  }
  
  public void s()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "stopPreview");
    if (!e())
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.cameraStopPreview();
  }
  
  public void t()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "tryStartPreview---ENTER");
    if (!e())
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localObject == null) || (!((AECaptureMode)localObject).shouldStartCamera()))
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, not right mode: " + localObject);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, mPreviewTexture is NULL");
      return;
    }
    if (AEPreviewSizeUtil.a() == null)
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
      return;
    }
    localObject = AEPreviewSizeUtil.a((AECaptureMode)localObject, AEPreviewSizeUtil.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.startCameraPreview(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, (Size)localObject);
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "tryStartPreview---EXIT, normal");
  }
  
  public void u()
  {
    AEQLog.b(this.jdField_b_of_type_JavaLangString, "tryOpenCamera---ENTER");
    if (!e())
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localAECaptureMode == null) || (!localAECaptureMode.shouldStartCamera()))
    {
      AEQLog.d(this.jdField_b_of_type_JavaLangString, "tryOpenCamera---EXIT, not right mode: " + localAECaptureMode);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.openCamera(new AEBaseCameraUnit.3(this));
  }
  
  protected void v()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      u();
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      w();
      return;
    }
    z();
  }
  
  protected void w()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a() instanceof BaseActivity)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    int i;
    label51:
    int j;
    if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label176;
      }
      j = 1;
      label64:
      if (PermissionUtils.isStorePermissionEnable(localBaseActivity)) {
        break label181;
      }
    }
    label176:
    label181:
    for (int k = 1;; k = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (k != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localBaseActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label51;
      j = 0;
      break label64;
    }
  }
  
  protected void x()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled())
    {
      i = 1500;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.capturePhotoByAEKit(i);
  }
  
  protected void y()
  {
    Size localSize;
    Object localObject;
    boolean bool;
    if ((this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != null) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) && (AEPreviewSizeUtil.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
      }
      localSize = AEPreviewSizeUtil.a(this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, AEPreviewSizeUtil.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      localObject = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getCaptureDir() + "/" + System.currentTimeMillis() + ".jpg";
      FileUtils.c((String)localObject);
      localObject = new File((String)localObject);
      bool = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera();
      if (!this.jdField_a_of_type_DovComQqImAeAECameraConfig.g()) {
        break label166;
      }
    }
    label166:
    for (int i = CaptureUtil.c(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getActivityOrientation());; i = 0)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.capturePhoto((File)localObject, i, bool, new AEBaseCameraUnit.4(this), localSize);
      return;
    }
  }
  
  protected void z()
  {
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECameraErrorDialog == null) {
      this.jdField_a_of_type_DovComQqImAeViewAECameraErrorDialog = new AECameraErrorDialog(localActivity);
    }
    this.jdField_a_of_type_DovComQqImAeViewAECameraErrorDialog.a(new AEBaseCameraUnit.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEBaseCameraUnit
 * JD-Core Version:    0.7.0.1
 */