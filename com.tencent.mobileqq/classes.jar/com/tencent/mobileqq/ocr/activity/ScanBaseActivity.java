package com.tencent.mobileqq.ocr.activity;

import ajjy;
import akiu;
import akna;
import aknp;
import akrc;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atdp;
import bbms;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class ScanBaseActivity
  extends FragmentActivity
{
  protected TextView a;
  private bbms a;
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
    boolean bool1 = atdp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (bool1)
    {
      boolean bool2 = akrc.a();
      if (!bool2)
      {
        QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
        ThreadManager.post(new ScanBaseActivity.1(this), 5, null, false);
      }
      return bool1 & bool2;
    }
    Object localObject = ((akiu)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(220)).a(true);
    if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0))
    {
      new ArrayList();
      new ArrayList();
      ArrayList localArrayList = ((ARCommonConfigInfo)localObject).nativeSoResList;
      localObject = ((ARCommonConfigInfo)localObject).nativeSoResList;
      aknp localaknp = new aknp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!akna.a()) {
        localaknp.a(localArrayList, (ArrayList)localObject, "arcloud");
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
        localObject = ((atdp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(228)).a(false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "getOcrConfig:" + localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.b = ((TextView)findViewById(2131302847));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(this);
      View localView = findViewById(2131311549);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
    }
    if (AppSetting.c) {
      findViewById(2131302804).setContentDescription(ajjy.a(2131647716));
    }
  }
  
  public void b() {}
  
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
    if (this.jdField_a_of_type_Bbms != null) {
      this.jdField_a_of_type_Bbms.dismiss();
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
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanBaseActivity
 * JD-Core Version:    0.7.0.1
 */