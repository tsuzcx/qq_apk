package dov.com.qq.im;

import ajjy;
import aluq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import autt;
import awdp;
import awii;
import bbmy;
import bbqo;
import bgww;
import bgxb;
import bhdr;
import bheb;
import bhfc;
import bhfm;
import bhzb;
import bhzc;
import bhzd;
import bjeh;
import bjin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import wed;
import xfz;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements bhzb, bhzc
{
  private static long jdField_a_of_type_Long;
  private static final String jdField_a_of_type_JavaLangString = QIMCameraCaptureActivity.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private bhzd jdField_a_of_type_Bhzd;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", bgww.a.a());
      if ((bgww.k.a(i)) || (bgww.j.a(i))) {
        paramContext.setFlags(268435456);
      }
    }
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (b()) {
      return;
    }
    if (awdp.jdField_a_of_type_Long != 0L)
    {
      awdp.c = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(awdp.c) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", awdp.jdField_a_of_type_Long);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", awdp.b);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", awdp.c);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "startLaunchActivity time=" + System.currentTimeMillis());
    }
    paramActivity.startActivityForResult(a(paramActivity, paramBundle), paramInt);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramContext.startActivity(a(paramContext, paramBundle));
  }
  
  private static boolean b()
  {
    long l = System.currentTimeMillis();
    QLog.d(jdField_a_of_type_JavaLangString, 4, "pre: " + jdField_a_of_type_Long + " cur: " + l);
    if (Math.abs(l - jdField_a_of_type_Long) < 500L)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "isFastClick.");
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
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
    return bhfc.a();
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
    this.jdField_a_of_type_Bhzd.p();
  }
  
  public boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bhzd.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bhzd.a();
    bbqo.a(BaseApplicationImpl.getContext(), true, 51);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (awii.e())
    {
      DisplayMetrics localDisplayMetrics = autt.a(this);
      if ((localDisplayMetrics != null) && ((this.jdField_a_of_type_Int != localDisplayMetrics.widthPixels) || (this.b != localDisplayMetrics.heightPixels)))
      {
        this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
        this.b = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Bhzd.b_(this.jdField_a_of_type_Int, this.b);
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("CameraLaunchPerf", 4, "activityOnCreate time=" + l1);
      l2 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
      if (l2 > 0L) {
        QLog.d("CameraLaunchPerf", 4, "IPC cost=" + (l1 - l2));
      }
    }
    bhgj.c = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (awii.e()) {
      bjeh.c(this);
    }
    bjeh.a(this);
    if (bjeh.c()) {
      bjeh.b(this);
    }
    Object localObject = autt.a(this);
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.b = ((DisplayMetrics)localObject).heightPixels;
    }
    this.ac = true;
    this.ad = false;
    super.onCreate(paramBundle);
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (bgww.d.a(k))
        {
          localObject = bgxb.a().a("app_alg_aio_camera_type_id", "", 4);
          QLog.d(jdField_a_of_type_JavaLangString, 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label658;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", bgww.d.a());
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "buildCaptureUnit start time=" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Bhzd = bheb.a(i, this, this);
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "buildCaptureUnit end time=" + l3);
    }
    this.jdField_a_of_type_Bhzd.a(paramBundle);
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("CameraLaunchPerf", 4, "CaptureUnit onCreateDone time=" + l2);
      QLog.d("CameraLaunchPerf", 4, "unitOnCreate cost=" + (l2 - l3));
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bhzd.a();
    if (QLog.isDevelopLevel())
    {
      l3 = System.currentTimeMillis();
      QLog.d("CameraLaunchPerf", 4, "CaptureUnit onCreateViewDone time=" + l3);
      QLog.d("CameraLaunchPerf", 4, "unitOnCreateView cost=" + (l3 - l2));
    }
    setContentView(this.jdField_a_of_type_AndroidViewView);
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "activitySetContentViewDone time=" + System.currentTimeMillis());
    }
    if (g())
    {
      bbmy.a(this, ajjy.a(2131643976), 0).a();
      finish();
    }
    label658:
    do
    {
      return;
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", bgww.o.a());
      break;
      ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    } while (!QLog.isDevelopLevel());
    l2 = System.currentTimeMillis();
    QLog.d("CameraLaunchPerf", 4, "activityOnCreateDone time=" + l2);
    QLog.d("CameraLaunchPerf", 4, "activityOnCreateDone cost=" + (l2 - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bhzd.e();
    xfz.a().j = 0;
    bjin localbjin = (bjin)bhfm.a(3);
    bjin.jdField_a_of_type_Int = 0;
    ((bhdr)bhfm.a(13)).d(0);
    bbqo.a(BaseApplicationImpl.getContext(), true, 51);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bhzd.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bhzd.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Bhzd.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bhzd.f();
    ((bhdr)bhfm.a(13)).c(0);
    if (Build.VERSION.SDK_INT >= 29) {
      wed.a(getWindow());
    }
    bbqo.a(BaseApplicationImpl.getContext(), false, 51);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
      QLog.d("CameraLaunchPerf", 4, "activityOnResumeDone time=" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bhzd.b(paramBundle);
  }
  
  public void onStart()
  {
    long l = System.currentTimeMillis();
    waitAppRuntime();
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "waitAppRuntime, cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    super.onStart();
    this.jdField_a_of_type_Bhzd.q();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bhzd.r();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bhzd.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */