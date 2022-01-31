package com.tencent.mobileqq.ocr.activity;

import aggl;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArCloudNativeSoLoader;
import com.tencent.mobileqq.ar.ArNativeSoManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class ScanBaseActivity
  extends FragmentActivity
{
  protected TextView a;
  public AppInterface a;
  public QQAppInterface a;
  public OcrConfig a;
  private QQProgressDialog a;
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
    boolean bool1 = OCRManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (bool1)
    {
      boolean bool2 = ARCloudControl.a();
      if (!bool2)
      {
        QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
        ThreadManager.post(new aggl(this), 5, null, false);
      }
      return bool1 & bool2;
    }
    Object localObject = ((ARGlobalConfigManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(219)).a(true);
    if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0))
    {
      new ArrayList();
      new ArrayList();
      ArrayList localArrayList = ((ARCommonConfigInfo)localObject).nativeSoResList;
      localObject = ((ARCommonConfigInfo)localObject).nativeSoResList;
      ArNativeSoManager localArNativeSoManager = new ArNativeSoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!ArCloudNativeSoLoader.a()) {
        localArNativeSoManager.a(localArrayList, (ArrayList)localObject, "arcloud");
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
        localObject = ((OCRManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(227)).a(false);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "getOcrConfig:" + localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363262));
    this.b = ((TextView)findViewById(2131363400));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.a(this);
      View localView = findViewById(2131370895);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
    }
    if (AppSetting.b) {
      findViewById(2131363262).setContentDescription("返回 按钮");
    }
  }
  
  public void b() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("ScanBaseActivity", 2, "checkOcrEnable:" + bool);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected String getModuleId()
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