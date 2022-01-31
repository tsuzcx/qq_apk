package dov.com.qq.im;

import alpo;
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
import aobd;
import axld;
import ayyd;
import azcw;
import betl;
import bkiu;
import bkje;
import bkwi;
import bkwm;
import blbo;
import blev;
import blfg;
import bllv;
import blmf;
import bmcu;
import bmcv;
import bmcw;
import bngs;
import bnkz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import yhj;
import zdp;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bmcu, bmcv
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bmcw jdField_a_of_type_Bmcw;
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
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
      if ((bkwm.l.a(i)) || (bkwm.k.a(i))) {
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
    if (ayyd.a != 0L)
    {
      ayyd.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(ayyd.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", ayyd.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", ayyd.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", ayyd.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bllv.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramActivity.startActivityForResult(a(paramActivity, paramBundle), paramInt);
      blbo.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bllv.a();
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
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      SparseIntArray localSparseIntArray = jdField_a_of_type_AndroidUtilSparseIntArray;
      int i = this.jdField_a_of_type_Int;
      j += 1;
      localSparseIntArray.put(i, j);
      blfg.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    blfg.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
    return false;
  }
  
  private void b()
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(this.jdField_a_of_type_Int) >= 0)
    {
      int i = jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Int);
      blfg.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    blfg.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
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
    return bllv.a();
  }
  
  public void a()
  {
    super.onBackPressed();
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Bmcw != null) {
      this.jdField_a_of_type_Bmcw.s();
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
    this.jdField_a_of_type_Bmcw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bmcw.a();
    betl.a(BaseApplicationImpl.getContext(), true, 51);
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (azcw.e())
    {
      DisplayMetrics localDisplayMetrics = axld.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.c != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.c = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bmcw.b_(this.jdField_b_of_type_Int, this.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    blfg.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    blfg.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = bkwm.a(getIntent());
    blbo.a().b();
    blbo.a().a("mainProcessLaunch", l2);
    blbo.a().a("activityOnCreateBegin", l1);
    blbo.a().a(l2);
    blnc.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (azcw.e()) {
      bngs.c(this);
    }
    bngs.a(this);
    if (bngs.c()) {
      bngs.b(this);
    }
    Object localObject = axld.a(this);
    if (localObject != null)
    {
      this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.c = ((DisplayMetrics)localObject).heightPixels;
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if (a())
    {
      blfg.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
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
        if (bkwm.e.a(k))
        {
          localObject = blev.a().a("app_alg_aio_camera_type_id", "", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label504;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", bkwm.e.a());
        }
      }
    }
    for (;;)
    {
      blbo.a().a("buildCaptureUnit-begin");
      this.jdField_a_of_type_Bmcw = bkje.a(i, this, this);
      blbo.a().a("buildCaptureUnit-end");
      this.jdField_a_of_type_Bmcw.a(paramBundle);
      blbo.a().a("unitOnCreateView-begin");
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bmcw.a();
      blbo.a().a("unitOnCreateView-end");
      setContentView(this.jdField_a_of_type_AndroidViewView);
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, alpo.a(2131710144), 0).a();
      finish();
      return;
      label504:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", bkwm.p.a());
    }
    bkwi.a().a(true);
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    blbo.a().a("activityOnCreateEnd");
    blfg.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    blfg.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    b();
    if (this.jdField_a_of_type_Bmcw != null)
    {
      this.jdField_a_of_type_Bmcw.e();
      zdp.a().j = 0;
      bnkz localbnkz = (bnkz)blmf.a(3);
      bnkz.jdField_a_of_type_Int = 0;
      ((bkiu)blmf.a(13)).d(0);
      betl.a(BaseApplicationImpl.getContext(), true, 51);
      aobd.a(BaseApplicationImpl.getContext(), 2, true);
      bkwi.a().a(false);
    }
    blbo.a().a(true);
    blbo.a().c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bmcw.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bmcw.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bmcw != null) {
      this.jdField_a_of_type_Bmcw.d();
    }
  }
  
  public void onResume()
  {
    blfg.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean) {
      blbo.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_Bmcw.f();
    ((bkiu)blmf.a(13)).c(0);
    if ((Build.VERSION.SDK_INT >= 29) && (this.jdField_a_of_type_Int != bkwm.x.a())) {
      yhj.a(getWindow());
    }
    betl.a(BaseApplicationImpl.getContext(), false, 51);
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_a_of_type_Boolean) {
      blbo.a().a("activityOnResumeEnd");
    }
    this.jdField_a_of_type_Boolean = true;
    blfg.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bmcw.b(paramBundle);
  }
  
  public void onStart()
  {
    blfg.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_b_of_type_Boolean) {
      blbo.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    blfg.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_Bmcw.p();
    if (!this.jdField_b_of_type_Boolean) {
      blbo.a().a("activityOnStartEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    blfg.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    blfg.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bmcw != null) {
      this.jdField_a_of_type_Bmcw.t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bmcw.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */