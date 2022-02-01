package dov.com.tencent.mobileqq.richmedia.capture.activity;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.Window;
import born;
import borr;
import bpam;
import brdv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadActivity
  extends FragmentActivity
  implements brdv
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = CaptureQmcfSoDownloadActivity.class.getSimpleName();
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    if (borr.a(paramBundle)) {
      localIntent.addFlags(603979776);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean1);
    localIntent.putExtra("key_wait_download_result", paramBoolean2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", born.a.a());
    if ((i == born.l.a()) || (i == born.k.a())) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (!getIntent().getBooleanExtra("key_wait_download_result", false))
    {
      QLog.d("qqBaseActivity", 4, "in launch.");
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadActivity.1(this), 5L);
      return;
    }
    bpam.d(jdField_a_of_type_JavaLangString, "[onFinish] getBooleanExtra(KEY_JUST_WAIT_DOWNLOAD_RESULT");
    setResult(-1, null);
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561116);
    this.jdField_a_of_type_AndroidSupportV4AppFragment = new CaptureQmcfSoDownloadFragment();
    this.b = getIntent().getStringExtra("pendingIntentClass");
    if (getIntent().getBooleanExtra("pendingIntentAllWait", false)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new CaptureQmcfSoDownloadFragmentAllWaite();
    }
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362007, this.jdField_a_of_type_AndroidSupportV4AppFragment);
    paramBundle.commit();
    this.jdField_a_of_type_Boolean = getIntent().hasExtra("pendingIntentRequest");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int = getIntent().getIntExtra("pendingIntentRequest", 0);
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    bpam.b(jdField_a_of_type_JavaLangString, "【Activity doOnCreate】");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bpam.b(jdField_a_of_type_JavaLangString, "【Activity doOnDestroy】");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */