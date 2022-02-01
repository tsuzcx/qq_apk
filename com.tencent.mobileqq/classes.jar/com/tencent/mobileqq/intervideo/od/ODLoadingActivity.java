package com.tencent.mobileqq.intervideo.od;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anni;
import anvy;
import avjb;
import avlh;
import biau;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

public class ODLoadingActivity
  extends Activity
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private biau jdField_a_of_type_Biau;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a()
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(this, 40);
      this.jdField_a_of_type_Biau.a(anni.a(2131706597));
    }
    this.jdField_a_of_type_Biau.show();
  }
  
  private void b()
  {
    this.b = true;
    if (this.jdField_a_of_type_Biau != null) {
      this.jdField_a_of_type_Biau.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
      avjb.b("33669910");
      IVCommonInterfaceImpl.getInstance().onHostActivityBackPress();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getBooleanExtra("show_status_bar", false)) {
      setTheme(16973840);
    }
    super.onCreate(paramBundle);
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
        paramBundle.putString("qqVersion", "8.4.1");
        paramBundle.putBoolean("isGooglePlayVersion", false);
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(str).d1(String.valueOf(l));
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("enterLoading").report();
        avjb.b("33669907");
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        findViewById(16908290).setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ODLoadingActivity.1(this), 1000L);
        ExecutorService localExecutorService = anvy.a(192);
        localExecutorService.submit(new ODLoadingActivity.3(this, localExecutorService.submit(new avlh(this, str)), l, paramBundle));
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
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      Field localField = View.class.getDeclaredField("mParent");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_AndroidViewView, null);
      label34:
      b();
      IVCommonInterfaceImpl.getInstance().onHostActivityDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label34;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity
 * JD-Core Version:    0.7.0.1
 */