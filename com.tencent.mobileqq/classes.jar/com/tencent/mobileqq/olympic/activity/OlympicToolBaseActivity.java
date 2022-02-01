package com.tencent.mobileqq.olympic.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends AbsBaseWebViewActivity
{
  public AppInterface a;
  public QQAppInterface a;
  public OlympicToolAppInterface a;
  
  public void a()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      return;
    }
    if ((localAppRuntime instanceof OlympicToolAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface = ((OlympicToolAppInterface)localAppRuntime);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public String getModuleId()
  {
    if ("ScanTorchActivity".equals(getClass().getSimpleName())) {
      return "module_olympic";
    }
    return super.getModuleId();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    a();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */