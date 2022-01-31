package dov.com.qq.im.ptv;

import alpo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ayyy;
import bllv;
import bmaw;
import bmcm;
import bmcu;
import bmcv;
import bmcw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;

@TargetApi(14)
public class PtvCameraCaptureActivity
  extends FlowActivity
  implements bmcu, bmcv
{
  bmcw a;
  private boolean b;
  
  public static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, PtvCameraCaptureActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("LIGHT_ARG_FRAGMENT_CLASS", paramString);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivity(a(paramActivity, paramString, paramBundle));
    paramActivity.overridePendingTransition(2130771987, 0);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivityForResult(a(paramActivity, paramString, paramBundle), paramInt);
    paramActivity.overridePendingTransition(2130771987, 0);
  }
  
  public static void a(LWMotionEvent paramLWMotionEvent)
  {
    bmaw.a(paramLWMotionEvent);
  }
  
  public static void b() {}
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return a(paramMotionEvent);
    }
    View localView = a();
    if (localView == null) {
      return a(paramMotionEvent);
    }
    int i = localView.getTop();
    if (paramMotionEvent.getY() > i) {}
    return a(paramMotionEvent);
  }
  
  public Activity a()
  {
    return this;
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
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.b) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = i;
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, paramViewGroup.getId());
      localObject1 = new RelativeLayout(this);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_Bmcw.a());
      localObject2 = (ViewGroup)$(2131366578);
      if (this.b)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setImageResource(2130844114);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(2, paramViewGroup.getId());
        localImageView.setLayoutParams(localLayoutParams);
        ((ViewGroup)localObject2).addView(localImageView, 0);
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_Bmcw.s();
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.b = getIntent().getBooleanExtra("flow_camera_show_panel", false);
    String str = getIntent().getStringExtra("LIGHT_ARG_FRAGMENT_CLASS");
    bmaw.a(this, str, getIntent().getBooleanExtra("flow_camera_download_light", false));
    this.jdField_a_of_type_Bmcw = bmaw.a(str, this, this);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bmcw.a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, alpo.a(2131709109), 0).a();
      finish();
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      long l2 = getIntent().getLongExtra("ACTIVITY_START_TIME", l1);
      QLog.i("PtvCameraCaptureActivity", 2, "start cost:" + (l1 - l2) + " ms");
      ayyy.a("sv_light_cost_time_ui", l1 - l2);
    } while (!(this.jdField_a_of_type_Bmcw instanceof bmcm));
    bmaw.b((bmcm)this.jdField_a_of_type_Bmcw);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bmcw.e();
    if ((this.jdField_a_of_type_Bmcw instanceof bmcm)) {
      bmaw.a((bmcm)this.jdField_a_of_type_Bmcw);
    }
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
    this.jdField_a_of_type_Bmcw.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bmcw.f();
    if (QLog.isColorLevel()) {
      QLog.i("PtvCameraCaptureActivity", 2, "onResume");
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bmcw.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Bmcw.p();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bmcw.t();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bmcw.a(paramMotionEvent, b(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.PtvCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */