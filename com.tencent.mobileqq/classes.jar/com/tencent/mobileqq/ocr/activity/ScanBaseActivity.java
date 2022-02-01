package com.tencent.mobileqq.ocr.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import apbf;
import apfm;
import apgb;
import apji;
import ayrg;
import bisl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class ScanBaseActivity
  extends FragmentActivity
{
  protected TextView a;
  private bisl a;
  public AppInterface a;
  public QQAppInterface a;
  public OcrConfig a;
  public boolean a;
  protected TextView b;
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig = a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig == null)
    {
      QLog.d("ScanBaseActivity", 1, "checkOcrEnable config is null");
      return false;
    }
    boolean bool1 = ayrg.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (bool1)
    {
      boolean bool2 = apji.a();
      if (!bool2)
      {
        QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
        ThreadManager.post(new ScanBaseActivity.1(this), 5, null, false);
      }
      return bool1 & bool2;
    }
    Object localObject = ((apbf)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER)).a(true);
    if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0))
    {
      new ArrayList();
      new ArrayList();
      ArrayList localArrayList = ((ARCommonConfigInfo)localObject).nativeSoResList;
      localObject = ((ARCommonConfigInfo)localObject).nativeSoResList;
      apgb localapgb = new apgb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!apfm.a()) {
        localapgb.a(localArrayList, (ArrayList)localObject, "arcloud");
      }
    }
    return bool1;
  }
  
  public OcrConfig a()
  {
    OcrConfig localOcrConfig = null;
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      localOcrConfig = (OcrConfig)((Bundle)localObject).get("key_ocr_config");
    }
    localObject = localOcrConfig;
    if (localOcrConfig == null)
    {
      localObject = localOcrConfig;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localObject = ((ayrg)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.OCR_MANAGER)).a(false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "getOcrConfig:" + localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    this.b = ((TextView)findViewById(2131369278));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(this);
      View localView = findViewById(2131379015);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
    }
    if (AppSetting.c) {
      findViewById(2131369231).setContentDescription(anvx.a(2131712966));
    }
  }
  
  public void b() {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "checkOcrEnable:" + bool);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanBaseActivity
 * JD-Core Version:    0.7.0.1
 */