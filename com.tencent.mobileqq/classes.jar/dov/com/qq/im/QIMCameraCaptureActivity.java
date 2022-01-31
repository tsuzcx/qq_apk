package dov.com.qq.im;

import ajya;
import amkf;
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
import avte;
import axcz;
import axhq;
import bcql;
import bcuc;
import bigy;
import bihi;
import birq;
import birt;
import biwu;
import bjaa;
import bjah;
import bjal;
import bjav;
import bjrk;
import bjrl;
import bjrm;
import bkvi;
import bkzp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import wsr;
import xow;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bjrk, bjrl
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bjrm jdField_a_of_type_Bjrm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", birt.a.a());
      if ((birt.l.a(i)) || (birt.k.a(i))) {
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
    if (axcz.a != 0L)
    {
      axcz.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(axcz.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", axcz.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", axcz.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", axcz.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bjal.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramActivity.startActivityForResult(a(paramActivity, paramBundle), paramInt);
      biwu.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bjal.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramContext.startActivity(a(paramContext, paramBundle));
      return;
    }
  }
  
  private void b()
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int i = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      bjah.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    bjah.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
    jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
  }
  
  private boolean b()
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      SparseIntArray localSparseIntArray = jdField_a_of_type_AndroidUtilSparseIntArray;
      int i = this.jdField_a_of_type_Int;
      j += 1;
      localSparseIntArray.put(i, j);
      bjah.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    bjah.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
    return false;
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
    return bjal.a();
  }
  
  public void a()
  {
    super.onBackPressed();
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Bjrm != null) {
      this.jdField_a_of_type_Bjrm.s();
    }
  }
  
  public boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bjrm.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bjrm.a();
    bcuc.a(BaseApplicationImpl.getContext(), true, 51);
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (axhq.e())
    {
      DisplayMetrics localDisplayMetrics = avte.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.c != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.c = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bjrm.b_(this.jdField_b_of_type_Int, this.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bjah.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bjah.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = birt.a(getIntent());
    biwu.a().b();
    biwu.a().a("mainProcessLaunch", l2);
    biwu.a().a("activityOnCreateBegin", l1);
    biwu.a().a(l2);
    bjbs.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (axhq.e()) {
      bkvi.c(this);
    }
    bkvi.a(this);
    if (bkvi.c()) {
      bkvi.b(this);
    }
    Object localObject = avte.a(this);
    if (localObject != null)
    {
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.c = ((DisplayMetrics)localObject).heightPixels;
    }
    this.ac = true;
    this.ad = false;
    super.onCreate(paramBundle);
    if (b())
    {
      bjah.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
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
        if (birt.e.a(k))
        {
          localObject = bjaa.a().a("app_alg_aio_camera_type_id", "", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label504;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", birt.e.a());
        }
      }
    }
    for (;;)
    {
      biwu.a().a("buildCaptureUnit-begin");
      this.jdField_a_of_type_Bjrm = bihi.a(i, this, this);
      biwu.a().a("buildCaptureUnit-end");
      this.jdField_a_of_type_Bjrm.a(paramBundle);
      biwu.a().a("unitOnCreateView-begin");
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bjrm.a();
      biwu.a().a("unitOnCreateView-end");
      setContentView(this.jdField_a_of_type_AndroidViewView);
      if (!g()) {
        break;
      }
      bcql.a(this, ajya.a(2131709772), 0).a();
      finish();
      return;
      label504:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", birt.p.a());
    }
    birq.a().a(true);
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    biwu.a().a("activityOnCreateEnd");
    bjah.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bjah.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    b();
    if (this.jdField_a_of_type_Bjrm != null)
    {
      this.jdField_a_of_type_Bjrm.e();
      xow.a().j = 0;
      bkzp localbkzp = (bkzp)bjav.a(3);
      bkzp.jdField_a_of_type_Int = 0;
      ((bigy)bjav.a(13)).d(0);
      bcuc.a(BaseApplicationImpl.getContext(), true, 51);
      amkf.a(BaseApplicationImpl.getContext(), 2, true);
      birq.a().a(false);
    }
    biwu.a().a(true);
    biwu.a().c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bjrm.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bjrm.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bjrm != null) {
      this.jdField_a_of_type_Bjrm.d();
    }
  }
  
  public void onResume()
  {
    bjah.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean) {
      biwu.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_Bjrm.f();
    ((bigy)bjav.a(13)).c(0);
    if (Build.VERSION.SDK_INT >= 29) {
      wsr.a(getWindow());
    }
    bcuc.a(BaseApplicationImpl.getContext(), false, 51);
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_a_of_type_Boolean) {
      biwu.a().a("activityOnResumeEnd");
    }
    this.jdField_a_of_type_Boolean = true;
    bjah.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bjrm.b(paramBundle);
  }
  
  public void onStart()
  {
    bjah.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_b_of_type_Boolean) {
      biwu.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    bjah.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_Bjrm.p();
    if (!this.jdField_b_of_type_Boolean) {
      biwu.a().a("activityOnStartEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    bjah.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    bjah.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bjrm != null) {
      this.jdField_a_of_type_Bjrm.t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bjrm.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */