package dov.com.qq.im;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleDTParamBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.util.LiuHaiUtils;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.qq.im.setting.IQIMCameraLifeCallback;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements ICameraEntrance, IQIMCameraContainer
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private IQIMCameraLifeCallback jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if ((AECameraEntry.l.a(i)) || (AECameraEntry.k.a(i)))
    {
      AEQLog.a("QIMCameraCaptureActivity", "set special launch flags case1");
      paramContext.setFlags(402653184);
    }
    for (;;)
    {
      paramContext.putExtras(paramBundle);
      paramContext.putExtra("need_show_banner", false);
      return paramContext;
      if (AECameraEntry.H.a(i))
      {
        AEQLog.a("QIMCameraCaptureActivity", "set special launch flags case2");
        paramContext.setFlags(402653184);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (AIOShortVideoUtil.a != 0L)
    {
      AIOShortVideoUtil.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(AIOShortVideoUtil.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", AIOShortVideoUtil.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", AIOShortVideoUtil.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", AIOShortVideoUtil.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = CaptureContext.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      localObject = a(paramActivity, paramBundle);
      if (AECameraLauncher.a(paramBundle)) {
        ((Intent)localObject).addFlags(603979776);
      }
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      AELaunchRecorder.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = CaptureContext.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramContext.startActivity(a(paramContext, paramBundle));
      return;
    }
  }
  
  private boolean a()
  {
    if (AECameraEntry.k(getIntent())) {
      return false;
    }
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      SparseIntArray localSparseIntArray = jdField_a_of_type_AndroidUtilSparseIntArray;
      int i = this.jdField_a_of_type_Int;
      j += 1;
      localSparseIntArray.put(i, j);
      AEQLog.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    AEQLog.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
    return false;
  }
  
  private void b()
  {
    if (!AECameraEntry.k(getIntent())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new QCircleDTParamBuilder().setPageSubclass("QIMCameraCaptureActivity").buildPageParams());
    QLog.i("QIMCameraCaptureActivity", 1, "reportDaTongRegister  subPage: QIMCameraCaptureActivity");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int i = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      AEQLog.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    AEQLog.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
    jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
  }
  
  public Activity a()
  {
    return this;
  }
  
  public void a()
  {
    super.onBackPressed();
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.i();
    }
  }
  
  public void initNavigationBarColor() {}
  
  public boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.b();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (CameraCompatibleList.e())
    {
      DisplayMetrics localDisplayMetrics = CaptureUtil.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.jdField_c_of_type_Int != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    AEQLog.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = AECameraEntry.a(getIntent());
    AELaunchRecorder.a().d();
    AELaunchRecorder.a().a("mainProcessLaunch", l2);
    AELaunchRecorder.a().a("activityOnCreateBegin", l1);
    AELaunchRecorder.a().a(l2);
    dov.com.qq.im.capture.control.CaptureAsyncControl.jdField_c_of_type_Boolean = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (CameraCompatibleList.e()) {
      LiuHaiUtils.c(this);
    }
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    DisplayMetrics localDisplayMetrics = CaptureUtil.a(this);
    if (localDisplayMetrics != null)
    {
      this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if (a())
    {
      AEQLog.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
      finish();
      return;
    }
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.OPEN_CAMERA"), "com.tencent.msg.permission.pushnotify");
    AEQLog.b("QIMCameraCaptureActivity", "onCreate: 参数接收：" + getIntent().getExtras());
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (AECameraEntry.e.a(k)) {
          i = 10024;
        }
      }
    }
    AELaunchRecorder.a().a("buildCaptureUnit-begin");
    AEThemeUtil.a();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback = QIMEffectCameraCaptureUnitBuilder.a(i, this, this);
    AELaunchRecorder.a().a("buildCaptureUnit-end");
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramBundle);
    AELaunchRecorder.a().a("unitOnCreateView-begin");
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a();
    AELaunchRecorder.a().a("unitOnCreateView-end");
    setContentView(this.jdField_a_of_type_AndroidViewView);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131709736), 0).a();
      finish();
      return;
    }
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    b();
    AELaunchRecorder.a().a("activityOnCreateEnd");
    AEQLog.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AEQLog.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    c();
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback != null)
    {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.c();
      MemoryClearManager.a().j = 0;
      QIMPtvTemplateManager localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
      QIMPtvTemplateManager.jdField_a_of_type_Int = 0;
      ((QIMCaptureVarManager)QIMManager.a(13)).d(0);
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 51);
      ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
    }
    AELaunchRecorder.a().a(true);
    AELaunchRecorder.a().e();
    a().sendBroadcast(new Intent("com.tencent.mobileqq.action.ae.CLOSE_CAMERA"), "com.tencent.msg.permission.pushnotify");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.b();
    }
    AEQLog.a("QIMCameraCaptureActivity", "onPause from: " + this.jdField_a_of_type_Int);
    if (a().isFinishing()) {
      c();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_b_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.d();
    ((QIMCaptureVarManager)QIMManager.a(13)).c(0);
    if ((Build.VERSION.SDK_INT >= 29) && (!AECameraEntry.h(this.jdField_a_of_type_Int))) {
      NavigationBarUtil.a(getWindow());
    }
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 51);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_b_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnResumeEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    AEQLog.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.b(paramBundle);
  }
  
  public void onStart()
  {
    AEQLog.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_c_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    AEQLog.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.j();
    if (!this.jdField_c_of_type_Boolean) {
      AELaunchRecorder.a().a("activityOnStartEnd");
    }
    this.jdField_c_of_type_Boolean = true;
    AEQLog.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    AEQLog.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.k();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */