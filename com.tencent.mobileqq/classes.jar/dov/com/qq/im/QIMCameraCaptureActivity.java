package dov.com.qq.im;

import Override;
import aafp;
import amtj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import apoh;
import babd;
import bbpn;
import bbub;
import bhlx;
import blie;
import blif;
import blvr;
import blvv;
import bmau;
import bmbk;
import bmbx;
import bmby;
import bmqh;
import bmql;
import bnbo;
import bnbp;
import bnbq;
import boba;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import zjv;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bnbo, bnbp
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bnbq jdField_a_of_type_Bnbq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", blvr.a.a());
    if ((blvr.l.a(i)) || (blvr.k.a(i))) {
      paramContext.setFlags(268435456);
    }
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (bbpn.a != 0L)
    {
      bbpn.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(bbpn.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", bbpn.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", bbpn.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", bbpn.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bmqh.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      localObject = a(paramActivity, paramBundle);
      if (blvv.a(paramBundle)) {
        ((Intent)localObject).addFlags(603979776);
      }
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      bmau.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bmqh.a();
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
    if (blvr.j(getIntent())) {
      return false;
    }
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      SparseIntArray localSparseIntArray = jdField_a_of_type_AndroidUtilSparseIntArray;
      int i = this.jdField_a_of_type_Int;
      j += 1;
      localSparseIntArray.put(i, j);
      bmbx.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    bmbx.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
    return false;
  }
  
  private void b()
  {
    if (!blvr.j(getIntent())) {
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
      bmbx.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    bmbx.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
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
    if (this.jdField_a_of_type_Bnbq != null) {
      this.jdField_a_of_type_Bnbq.n();
    }
  }
  
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
    this.jdField_a_of_type_Bnbq.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bnbq.a();
    bhlx.a(BaseApplicationImpl.getContext(), true, 51);
    apoh.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (bbub.e())
    {
      DisplayMetrics localDisplayMetrics = babd.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.jdField_c_of_type_Int != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bnbq.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
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
    bmbx.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bmbx.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = blvr.a(getIntent());
    bmau.a().d();
    bmau.a().a("mainProcessLaunch", l2);
    bmau.a().a("activityOnCreateBegin", l1);
    bmau.a().a(l2);
    bmri.jdField_c_of_type_Boolean = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (bbub.e()) {
      LiuHaiUtils.c(this);
    }
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    Object localObject = babd.a(this);
    if (localObject != null)
    {
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_c_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if (a())
    {
      bmbx.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
      finish();
      return;
    }
    Log.d("lingeng_camera", "onCreate: 参数接收：" + getIntent().getExtras());
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (blvr.e.a(k))
        {
          localObject = bmbk.a().a("app_alg_aio_camera_type_id", "NEWCAMERA", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label540;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", blvr.e.a());
        }
      }
    }
    for (;;)
    {
      bmau.a().a("buildCaptureUnit-begin");
      bmby.a();
      this.jdField_a_of_type_Bnbq = blif.a(i, this, this);
      bmau.a().a("buildCaptureUnit-end");
      this.jdField_a_of_type_Bnbq.a(paramBundle);
      bmau.a().a("unitOnCreateView-begin");
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bnbq.a();
      bmau.a().a("unitOnCreateView-end");
      setContentView(this.jdField_a_of_type_AndroidViewView);
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, amtj.a(2131708873), 0).a();
      finish();
      return;
      label540:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", blvr.p.a());
    }
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    b();
    bmau.a().a("activityOnCreateEnd");
    bmbx.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bmbx.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    c();
    if (this.jdField_a_of_type_Bnbq != null)
    {
      this.jdField_a_of_type_Bnbq.e();
      aafp.a().j = 0;
      boba localboba = (boba)bmql.a(3);
      boba.jdField_a_of_type_Int = 0;
      ((blie)bmql.a(13)).d(0);
      bhlx.a(BaseApplicationImpl.getContext(), true, 51);
      apoh.a(BaseApplicationImpl.getContext(), 2, true);
    }
    bmau.a().a(true);
    bmau.a().e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bnbq.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bnbq.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bnbq != null) {
      this.jdField_a_of_type_Bnbq.d();
    }
    bmbx.a("QIMCameraCaptureActivity", "onPause from: " + this.jdField_a_of_type_Int);
    if (a().isFinishing()) {
      c();
    }
  }
  
  public void onResume()
  {
    bmbx.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_b_of_type_Boolean) {
      bmau.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_Bnbq.f();
    ((blie)bmql.a(13)).c(0);
    if ((Build.VERSION.SDK_INT >= 29) && (!blvr.h(this.jdField_a_of_type_Int))) {
      zjv.a(getWindow());
    }
    bhlx.a(BaseApplicationImpl.getContext(), false, 51);
    apoh.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_b_of_type_Boolean) {
      bmau.a().a("activityOnResumeEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    bmbx.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bnbq.b(paramBundle);
  }
  
  public void onStart()
  {
    bmbx.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_c_of_type_Boolean) {
      bmau.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    bmbx.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_Bnbq.o();
    if (!this.jdField_c_of_type_Boolean) {
      bmau.a().a("activityOnStartEnd");
    }
    this.jdField_c_of_type_Boolean = true;
    bmbx.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    bmbx.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bnbq != null) {
      this.jdField_a_of_type_Bnbq.p();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bnbq.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */