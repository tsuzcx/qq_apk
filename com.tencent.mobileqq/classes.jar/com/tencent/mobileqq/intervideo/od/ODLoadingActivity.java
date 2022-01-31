package com.tencent.mobileqq.intervideo.od;

import ajyc;
import akhl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import argi;
import argq;
import arjs;
import bcpq;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

public class ODLoadingActivity
  extends Activity
{
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private argq jdField_a_of_type_Argq;
  private bcpq jdField_a_of_type_Bcpq;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this, 40);
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131707825));
    }
    this.jdField_a_of_type_Bcpq.show();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bcpq != null) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("onBackPressed").report();
      argi.b("33669910");
      IVCommonInterfaceImpl.getInstance().onHostActivityBackPress();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getBooleanExtra("show_status_bar", false)) {
      setTheme(16973840);
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("is_start_huiyin", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Argq = new argq(this);
      this.jdField_a_of_type_Argq.a(paramBundle);
      return;
    }
    paramBundle = new Bundle(getIntent().getExtras());
    String str = paramBundle.getString("fromId");
    long l = 0L;
    if (str != null) {}
    try
    {
      l = Long.parseLong(str);
      for (;;)
      {
        str = paramBundle.getString("bizType");
        paramBundle.putString("qqVersion", "8.2.8");
        paramBundle.putBoolean("isGooglePlayVersion", false);
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(str).d1(String.valueOf(l));
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("enterLoading").report();
        argi.b("33669907");
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        findViewById(16908290).setVisibility(8);
        a();
        ExecutorService localExecutorService = akhl.a(192);
        localExecutorService.submit(new ODLoadingActivity.2(this, localExecutorService.submit(new arjs(this, str)), l, paramBundle));
        return;
        QLog.e("ODLoadingActivity", 2, "not have fromId");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ODLoadingActivity", 2, "fromId not long");
        l = 0L;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Argq.b();
    }
    for (;;)
    {
      IVCommonInterfaceImpl.getInstance().onHostActivityDestroy();
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {}
      try
      {
        Field localField = View.class.getDeclaredField("mParent");
        localField.setAccessible(true);
        localField.set(this.jdField_a_of_type_AndroidViewView, null);
        label55:
        b();
      }
      catch (Throwable localThrowable)
      {
        break label55;
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    IVCommonInterfaceImpl.getInstance().onHostActivityPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    IVCommonInterfaceImpl.getInstance().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    IVCommonInterfaceImpl.getInstance().onHostActivityResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    IVCommonInterfaceImpl.getInstance().onHostActivityStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity
 * JD-Core Version:    0.7.0.1
 */