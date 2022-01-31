package dov.com.qq.im.ptv;

import alud;
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
import azdh;
import blqh;
import bmfi;
import bmgy;
import bmhg;
import bmhh;
import bmhi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;

@TargetApi(14)
public class PtvCameraCaptureActivity
  extends FlowActivity
  implements bmhg, bmhh
{
  bmhi a;
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
    bmfi.a(paramLWMotionEvent);
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
    return blqh.a();
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
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_Bmhi.a());
      localObject2 = (ViewGroup)$(2131366584);
      if (this.b)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setImageResource(2130844186);
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
    this.jdField_a_of_type_Bmhi.s();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Bmhi.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_Bmhi.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.b = getIntent().getBooleanExtra("flow_camera_show_panel", false);
    String str = getIntent().getStringExtra("LIGHT_ARG_FRAGMENT_CLASS");
    bmfi.a(this, str, getIntent().getBooleanExtra("flow_camera_download_light", false));
    this.jdField_a_of_type_Bmhi = bmfi.a(str, this, this);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bmhi.a(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, alud.a(2131709121), 0).a();
      finish();
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      long l2 = getIntent().getLongExtra("ACTIVITY_START_TIME", l1);
      QLog.i("PtvCameraCaptureActivity", 2, "start cost:" + (l1 - l2) + " ms");
      azdh.a("sv_light_cost_time_ui", l1 - l2);
    } while (!(this.jdField_a_of_type_Bmhi instanceof bmgy));
    bmfi.b((bmgy)this.jdField_a_of_type_Bmhi);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bmhi.e();
    if ((this.jdField_a_of_type_Bmhi instanceof bmgy)) {
      bmfi.a((bmgy)this.jdField_a_of_type_Bmhi);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_Bmhi.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.jdField_a_of_type_Bmhi.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Bmhi.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bmhi.f();
    if (QLog.isColorLevel()) {
      QLog.i("PtvCameraCaptureActivity", 2, "onResume");
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_Bmhi.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Bmhi.p();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bmhi.t();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_Bmhi.a(paramMotionEvent, b(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.PtvCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */