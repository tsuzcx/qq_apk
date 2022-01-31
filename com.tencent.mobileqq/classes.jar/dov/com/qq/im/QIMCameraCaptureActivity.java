package dov.com.qq.im;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.qq.im.setting.IQIMCameraLifeCallback;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPanel;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends FlowActivity
  implements ICameraEntrance, IQIMCameraContainer
{
  IQIMCameraLifeCallback a;
  
  private static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("ARG_FRAGMENT_CLASS", paramString);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivityForResult(a(paramActivity, paramString, paramBundle), paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramContext.startActivity(a(paramContext, paramString, paramBundle));
  }
  
  public int a()
  {
    Object localObject = a().getIntent();
    int j = ((Intent)localObject).getIntExtra("take_video_entrance_type", 99);
    int i = j;
    if (j == 100)
    {
      localObject = (SessionInfo)((Intent)localObject).getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject == null) {
        break label94;
      }
    }
    label94:
    for (i = ((SessionInfo)localObject).a;; i = 0)
    {
      switch (i)
      {
      default: 
        i = 11;
        return i;
      case 0: 
        return 11;
      case 1: 
        return 9;
      }
      return 10;
    }
  }
  
  public Activity a()
  {
    return this;
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  protected FlowPanel a()
  {
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a();
  }
  
  public void a()
  {
    super.onBackPressed();
  }
  
  public void a(int paramInt)
  {
    finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.addView(this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = paramString1;
    localReportInfo.d = paramString2;
    localReportInfo.e = paramString3;
    paramString1 = "";
    if (a() != null) {
      paramString1 = a().getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.i();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.n();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.W = true;
    this.X = false;
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback = QIMEffectCameraCaptureUnitBuilder.a(getIntent().getIntExtra("edit_video_type", 10002), this, this);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramBundle);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.e(false);
    MemoryClearManagerNew.a().h = 1;
    MemoryClearManagerNew.a().j = 1;
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "enter_story_capture_count", true, 0L, 0L, null, "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.m();
    MemoryClearManagerNew.a().j = 0;
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
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.q();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.e(true);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.d();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.k();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.l();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_DovComQqImSettingIQIMCameraLifeCallback.a(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */