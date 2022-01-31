package dov.com.tencent.mobileqq.richmedia.capture.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import awgh;
import bgww;
import bhcs;
import bjec;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite;

public class CaptureQmcfSoDownloadActivity
  extends FragmentActivity
  implements bjec
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
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", bgww.a.a());
    if ((i == bgww.k.a()) || (i == bgww.j.a())) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (!getIntent().getBooleanExtra("key_wait_download_result", false))
    {
      QLog.d("qqBaseActivity", 4, "in launch.");
      if ((BaseActivity.sTopActivity instanceof CaptureQmcfSoDownloadActivity))
      {
        QLog.d("qqBaseActivity", 4, "is top activity, hasRequest: " + this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsBundle.putString("KEY_ISENTER_SO_DOWNLOAD", "true");
        if (this.jdField_a_of_type_Boolean)
        {
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CaptureQmcfSoDownloadFragment)) {
            ((CaptureQmcfSoDownloadFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
          }
          QIMCameraCaptureActivity.a(this, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
        }
      }
      else
      {
        return;
      }
      QIMCameraCaptureActivity.a(this, this.jdField_a_of_type_AndroidOsBundle);
      finish();
      return;
    }
    setResult(-1, null);
    finish();
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
    super.setContentView(2131495107);
    this.jdField_a_of_type_AndroidSupportV4AppFragment = new CaptureQmcfSoDownloadFragment();
    this.b = getIntent().getStringExtra("pendingIntentClass");
    if (getIntent().getBooleanExtra("pendingIntentAllWait", false)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new CaptureQmcfSoDownloadFragmentAllWaite();
    }
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131296413, this.jdField_a_of_type_AndroidSupportV4AppFragment);
    paramBundle.commit();
    this.jdField_a_of_type_Boolean = getIntent().hasExtra("pendingIntentRequest");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int = getIntent().getIntExtra("pendingIntentRequest", 0);
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    awgh.a().a(true);
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Activity doOnCreate】");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    awgh.a().a(false);
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Activity doOnDestroy】");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */