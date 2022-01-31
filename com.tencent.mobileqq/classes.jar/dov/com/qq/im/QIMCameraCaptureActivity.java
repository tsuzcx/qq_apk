package dov.com.qq.im;

import ajyc;
import amkg;
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
import avtc;
import axcx;
import axho;
import bcpw;
import bctn;
import bigh;
import bigr;
import biqz;
import birc;
import biwd;
import bizj;
import bizq;
import bizu;
import bjae;
import bjqt;
import bjqu;
import bjqv;
import bkur;
import bkyy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import wsu;
import xoz;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bjqt, bjqu
{
  private static SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bjqv jdField_a_of_type_Bjqv;
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
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", birc.a.a());
      if ((birc.l.a(i)) || (birc.k.a(i))) {
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
    if (axcx.a != 0L)
    {
      axcx.c = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(axcx.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", axcx.a);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", axcx.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", axcx.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bizu.a();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramActivity.startActivityForResult(a(paramActivity, paramBundle), paramInt);
      biwd.a().a("startActivityForResult");
      return;
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = bizu.a();
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
      bizq.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.jdField_a_of_type_Int + " value: " + i);
      if (i <= 1)
      {
        jdField_a_of_type_AndroidUtilSparseIntArray.delete(this.jdField_a_of_type_Int);
        return;
      }
      jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, i - 1);
      return;
    }
    bizq.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.jdField_a_of_type_Int);
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
      bizq.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.jdField_a_of_type_Int + " value: " + j);
      return true;
    }
    jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_Int, 1);
    bizq.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.jdField_a_of_type_Int + " value: " + 1);
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
    return bizu.a();
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
    if (this.jdField_a_of_type_Bjqv != null) {
      this.jdField_a_of_type_Bjqv.s();
    }
  }
  
  public boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bjqv.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bjqv.a();
    bctn.a(BaseApplicationImpl.getContext(), true, 51);
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (axho.e())
    {
      DisplayMetrics localDisplayMetrics = avtc.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_b_of_type_Int != localDisplayMetrics.widthPixels) || (this.c != localDisplayMetrics.heightPixels)))
      {
        this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
        this.c = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bjqv.b_(this.jdField_b_of_type_Int, this.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bizq.b("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bizq.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.jdField_a_of_type_Int = birc.a(getIntent());
    biwd.a().b();
    biwd.a().a("mainProcessLaunch", l2);
    biwd.a().a("activityOnCreateBegin", l1);
    biwd.a().a(l2);
    bjbb.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (axho.e()) {
      bkur.c(this);
    }
    bkur.a(this);
    if (bkur.c()) {
      bkur.b(this);
    }
    Object localObject = avtc.a(this);
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
      bizq.d("QIMCameraCaptureActivity", "repeat launch from: " + this.jdField_a_of_type_Int);
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
        if (birc.e.a(k))
        {
          localObject = bizj.a().a("app_alg_aio_camera_type_id", "", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label504;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", birc.e.a());
        }
      }
    }
    for (;;)
    {
      biwd.a().a("buildCaptureUnit-begin");
      this.jdField_a_of_type_Bjqv = bigr.a(i, this, this);
      biwd.a().a("buildCaptureUnit-end");
      this.jdField_a_of_type_Bjqv.a(paramBundle);
      biwd.a().a("unitOnCreateView-begin");
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bjqv.a();
      biwd.a().a("unitOnCreateView-end");
      setContentView(this.jdField_a_of_type_AndroidViewView);
      if (!g()) {
        break;
      }
      bcpw.a(this, ajyc.a(2131709761), 0).a();
      finish();
      return;
      label504:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", birc.p.a());
    }
    biqz.a().a(true);
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    biwd.a().a("activityOnCreateEnd");
    bizq.b("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bizq.a("QIMCameraCaptureActivity", "onDestroy from: " + this.jdField_a_of_type_Int);
    b();
    if (this.jdField_a_of_type_Bjqv != null)
    {
      this.jdField_a_of_type_Bjqv.e();
      xoz.a().j = 0;
      bkyy localbkyy = (bkyy)bjae.a(3);
      bkyy.jdField_a_of_type_Int = 0;
      ((bigh)bjae.a(13)).d(0);
      bctn.a(BaseApplicationImpl.getContext(), true, 51);
      amkg.a(BaseApplicationImpl.getContext(), 2, true);
      biqz.a().a(false);
    }
    biwd.a().a(true);
    biwd.a().c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bjqv.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bjqv.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bjqv != null) {
      this.jdField_a_of_type_Bjqv.d();
    }
  }
  
  public void onResume()
  {
    bizq.b("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean) {
      biwd.a().a("activityOnResumeBegin");
    }
    super.onResume();
    this.jdField_a_of_type_Bjqv.f();
    ((bigh)bjae.a(13)).c(0);
    if (Build.VERSION.SDK_INT >= 29) {
      wsu.a(getWindow());
    }
    bctn.a(BaseApplicationImpl.getContext(), false, 51);
    amkg.a(BaseApplicationImpl.getContext(), 2, false);
    if (!this.jdField_a_of_type_Boolean) {
      biwd.a().a("activityOnResumeEnd");
    }
    this.jdField_a_of_type_Boolean = true;
    bizq.b("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bjqv.b(paramBundle);
  }
  
  public void onStart()
  {
    bizq.b("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.jdField_b_of_type_Boolean) {
      biwd.a().a("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    bizq.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.jdField_a_of_type_Bjqv.p();
    if (!this.jdField_b_of_type_Boolean) {
      biwd.a().a("activityOnStartEnd");
    }
    this.jdField_b_of_type_Boolean = true;
    bizq.b("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    bizq.a("QIMCameraCaptureActivity", "onStop from: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bjqv != null) {
      this.jdField_a_of_type_Bjqv.t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bjqv.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */