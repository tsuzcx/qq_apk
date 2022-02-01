package dov.com.qq.im.ptv;

import Override;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anni;
import bojl;
import bows;
import boxy;
import boyb;
import boym;
import boyn;
import boyo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;

@TargetApi(14)
public class PtvSoDownloadActivity
  extends FlowActivity
  implements boyb, boym, boyn
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  boyo jdField_a_of_type_Boyo;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, PtvSoDownloadActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("PTV_SO_ARG_FRAGMENT_CLASS", paramString);
    return paramContext;
  }
  
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
    if (paramMotionEvent.getY() > i) {
      a();
    }
    return a(paramMotionEvent);
  }
  
  public Activity a()
  {
    return this;
  }
  
  public AppInterface a()
  {
    return bojl.a();
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
    if (this.c) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = i;
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, paramViewGroup.getId());
      localObject1 = new RelativeLayout(this);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_Boyo.a());
      localObject2 = (ViewGroup)$(2131366849);
      if (this.c)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setImageResource(2130844582);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(2, paramViewGroup.getId());
        localImageView.setLayoutParams(localLayoutParams);
        ((ViewGroup)localObject2).addView(localImageView, 0);
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      return;
    }
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = bows.class.getName();
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("flow_camera_download_light", true);
        PtvCameraCaptureActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_Int);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      PtvCameraCaptureActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
      finish();
      return;
    }
    QLog.i("PtvSoDownloadActivity", 2, "fragmentName:" + this.jdField_a_of_type_JavaLangString + " hasRequest:" + this.jdField_b_of_type_Boolean + "pendingIntentRequest" + this.jdField_b_of_type_Int + " mIsMultiWindowMode: " + this.d + " args=null error.");
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
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.s();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.a(paramInt1, paramInt2, paramIntent);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.a();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.c = getIntent().getBooleanExtra("flow_camera_show_panel", false);
    if (!this.c) {
      getWindow().setBackgroundDrawableResource(2130844582);
    }
    this.d = isInMultiWindow();
    this.jdField_a_of_type_Boyo = new boxy(this, this);
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boyo.a(paramBundle);
    if (this.d)
    {
      QQToast.a(this, anni.a(2131707499), 0).a();
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("PTV_SO_ARG_FRAGMENT_CLASS");
      this.jdField_b_of_type_Boolean = getIntent().hasExtra("PTV_pendingIntentRequest");
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Int = getIntent().getIntExtra("PTV_pendingIntentRequest", 0);
      }
      this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    } while (!QLog.isColorLevel());
    QLog.i("PtvSoDownloadActivity", 2, "fragmentName:" + this.jdField_a_of_type_JavaLangString + " hasRequest:" + this.jdField_b_of_type_Boolean + "pendingIntentRequest" + this.jdField_b_of_type_Int);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.e();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Boyo != null) {
      return this.jdField_a_of_type_Boyo.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.a(paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.d();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.f();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.b(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.p();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Boyo != null) {
      this.jdField_a_of_type_Boyo.t();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boyo != null) {
      return this.jdField_a_of_type_Boyo.a(paramMotionEvent, b(paramMotionEvent));
    }
    return b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.PtvSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */