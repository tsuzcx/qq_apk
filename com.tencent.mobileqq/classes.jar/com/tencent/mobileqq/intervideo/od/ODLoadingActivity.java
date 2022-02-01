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
import anvx;
import avue;
import avwn;
import avwo;
import bisl;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
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
  private final avwo jdField_a_of_type_Avwo = new avwo(this);
  private bisl jdField_a_of_type_Bisl;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void c()
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, 40);
      this.jdField_a_of_type_Bisl.a(anvx.a(2131707280));
    }
    this.jdField_a_of_type_Bisl.show();
  }
  
  private void d()
  {
    this.b = true;
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void a()
  {
    d();
    finish();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("onCloseLoadingView").report();
    avue.b("33669909");
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    runOnUiThread(new ODLoadingActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("onShowLoadingView").report();
    avue.b("33669908");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("onEnterComplete").report();
    avue.b("33669911");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
      avue.b("33669910");
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
        paramBundle.putString("qqVersion", "8.4.10");
        paramBundle.putBoolean("isGooglePlayVersion", false);
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(str).d1(String.valueOf(l));
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("enterLoading").report();
        avue.b("33669907");
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        findViewById(16908290).setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ODLoadingActivity.1(this), 1000L);
        ExecutorService localExecutorService = ThreadManagerExecutor.getExecutorService(192);
        localExecutorService.submit(new ODLoadingActivity.3(this, localExecutorService.submit(new avwn(this, str)), l, paramBundle));
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
      d();
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