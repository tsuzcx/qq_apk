package dov.com.qq.im;

import Override;
import aana;
import abjg;
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
import anzj;
import aquy;
import bbgg;
import bcwd;
import bdax;
import bjfr;
import bocw;
import bodg;
import born;
import borr;
import bowp;
import bozz;
import bpam;
import bpan;
import bplg;
import bplq;
import bqah;
import bqai;
import bqaj;
import brhn;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import vuc;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bqah, bqai
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bqaj jdField_a_of_type_Bqaj;
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
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", born.a.a());
      if ((born.l.a(i)) || (born.k.a(i))) {
        paramContext.setFlags(268435456);
      }
    }
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (bcwd.a != 0L)
    {
      bcwd.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(bcwd.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", bcwd.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", bcwd.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", bcwd.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bplg.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      localObject = a(paramActivity, paramBundle);
      if (borr.a(paramBundle)) {
        ((Intent)localObject).addFlags(603979776);
      }
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      bowp.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bplg.a();
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
    if (born.j(getIntent())) {
      return false;
    }
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      SparseIntArray localSparseIntArray = jdField_a_of_type_AndroidUtilSparseIntArray;
      int i = this.jdField_a_of_type_Int;
      j += 1;
      localSparseIntArray.put(i, j);
      bpam.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    bpam.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
    return false;
  }
  
  private void b()
  {
    if (!born.j(getIntent())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(a());
    VideoReport.setPageId(this, "small_world_base");
    VideoReport.setPageParams(this, new vuc().a("QIMCameraCaptureActivity").a());
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
      bpam.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    bpam.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
    jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
  }
  
  public Activity a()
  {
    return this;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public AppInterface a()
  {
    return bplg.a();
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Bqaj != null) {
      this.jdField_a_of_type_Bqaj.s();
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
    this.jdField_a_of_type_Bqaj.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bqaj.a();
    bjfr.a(BaseApplicationImpl.getContext(), true, 51);
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (bdax.e())
    {
      DisplayMetrics localDisplayMetrics = bbgg.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.jdField_c_of_type_Int != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bqaj.b_(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
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
    bpam.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bpam.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = born.a(getIntent());
    bowp.a().d();
    bowp.a().a("mainProcessLaunch", l2);
    bowp.a().a("activityOnCreateBegin", l1);
    bowp.a().a(l2);
    bpmn.jdField_c_of_type_Boolean = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (bdax.e()) {
      LiuHaiUtils.c(this);
    }
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c()) {
      LiuHaiUtils.b(this);
    }
    Object localObject = bbgg.a(this);
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
      bpam.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
      finish();
      return;
    }
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (born.e.a(k))
        {
          localObject = bozz.a().a("app_alg_aio_camera_type_id", "NEWCAMERA", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label507;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", born.e.a());
        }
      }
    }
    for (;;)
    {
      bowp.a().a("buildCaptureUnit-begin");
      bpan.a();
      this.jdField_a_of_type_Bqaj = bodg.a(i, this, this);
      bowp.a().a("buildCaptureUnit-end");
      this.jdField_a_of_type_Bqaj.a(paramBundle);
      bowp.a().a("unitOnCreateView-begin");
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bqaj.a();
      bowp.a().a("unitOnCreateView-end");
      setContentView(this.jdField_a_of_type_AndroidViewView);
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, anzj.a(2131708641), 0).a();
      finish();
      return;
      label507:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", born.p.a());
    }
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    b();
    bowp.a().a("activityOnCreateEnd");
    bpam.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bpam.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    c();
    if (this.jdField_a_of_type_Bqaj != null)
    {
      this.jdField_a_of_type_Bqaj.e();
      abjg.a().j = 0;
      brhn localbrhn = (brhn)bplq.a(3);
      brhn.jdField_a_of_type_Int = 0;
      ((bocw)bplq.a(13)).d(0);
      bjfr.a(BaseApplicationImpl.getContext(), true, 51);
      aquy.a(BaseApplicationImpl.getContext(), 2, true);
    }
    bowp.a().a(true);
    bowp.a().e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bqaj.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bqaj.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bqaj != null) {
      this.jdField_a_of_type_Bqaj.d();
    }
    bpam.a("QIMCameraCaptureActivity", "onPause from: " + this.jdField_a_of_type_Int);
    if (a().isFinishing()) {
      c();
    }
  }
  
  public void onResume()
  {
    bpam.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_b_of_type_Boolean) {
      bowp.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_Bqaj.f();
    ((bocw)bplq.a(13)).c(0);
    if ((Build.VERSION.SDK_INT >= 29) && (!born.h(this.jdField_a_of_type_Int))) {
      aana.a(getWindow());
    }
    bjfr.a(BaseApplicationImpl.getContext(), false, 51);
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_b_of_type_Boolean) {
      bowp.a().a("activityOnResumeEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    bpam.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bqaj.b(paramBundle);
  }
  
  public void onStart()
  {
    bpam.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_c_of_type_Boolean) {
      bowp.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    bpam.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_Bqaj.p();
    if (!this.jdField_c_of_type_Boolean) {
      bowp.a().a("activityOnStartEnd");
    }
    this.jdField_c_of_type_Boolean = true;
    bpam.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    bpam.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bqaj != null) {
      this.jdField_a_of_type_Bqaj.t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bqaj.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */