package com.tencent.mobileqq.richmedia.capture.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragment.CaptureSoDownloadListener;
import com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragmentAllWaite;
import com.tencent.mobileqq.richmedia.capture.fragment.WebEffectsCameraCaptureFragment;

public class CaptureSoDownloadActivity
  extends FragmentActivity
  implements CaptureSoDownloadFragment.CaptureSoDownloadListener
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, CaptureSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, CaptureSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentRequest", paramInt);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, CaptureSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CaptureSoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pendingIntentClass", paramString);
    localIntent.putExtra("pendingIntentAllWait", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      CameraCaptureActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
      return;
    }
    CameraCaptureActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130970282);
    paramBundle = new CaptureSoDownloadFragment();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("pendingIntentClass");
    if ((this.jdField_a_of_type_JavaLangString.equals(WebEffectsCameraCaptureFragment.class.getName())) || (getIntent().getBooleanExtra("pendingIntentAllWait", false))) {
      paramBundle = new CaptureSoDownloadFragmentAllWaite();
    }
    FragmentTransaction localFragmentTransaction = super.getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131366941, paramBundle);
    localFragmentTransaction.commit();
    this.jdField_a_of_type_Boolean = getIntent().hasExtra("pendingIntentRequest");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int = getIntent().getIntExtra("pendingIntentRequest", 0);
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */