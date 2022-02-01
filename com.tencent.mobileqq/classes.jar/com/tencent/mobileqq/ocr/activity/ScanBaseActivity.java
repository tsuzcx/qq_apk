package com.tencent.mobileqq.ocr.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArCloudNativeSoLoader;
import com.tencent.mobileqq.ar.ArNativeSoManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class ScanBaseActivity
  extends BaseActivity
{
  protected TextView a;
  protected TextView b;
  public OcrConfig c;
  public AppInterface d;
  public QQAppInterface e;
  public boolean f = false;
  private QQProgressDialog g;
  
  private boolean d()
  {
    if (this.c == null) {
      this.c = a();
    }
    if (this.c == null)
    {
      QLog.d("ScanBaseActivity", 1, "checkOcrEnable config is null");
      return false;
    }
    boolean bool1 = ((IOCRService)this.d.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.d.getCurrentAccountUin(), 0);
    if (bool1)
    {
      boolean bool2 = ARCloudControl.a();
      if (!bool2)
      {
        QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
        ThreadManager.post(new ScanBaseActivity.1(this), 5, null, false);
      }
      return bool1 & bool2;
    }
    Object localObject = ((ARGlobalConfigManager)this.d.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER)).a(true);
    if ((localObject != null) && (((ARCommonConfigInfo)localObject).nativeSoResList != null) && (((ARCommonConfigInfo)localObject).nativeSoResList.size() > 0))
    {
      new ArrayList();
      new ArrayList();
      ArrayList localArrayList = ((ARCommonConfigInfo)localObject).nativeSoResList;
      localObject = ((ARCommonConfigInfo)localObject).nativeSoResList;
      ArNativeSoManager localArNativeSoManager = new ArNativeSoManager(this.e);
      if (!ArCloudNativeSoLoader.b()) {
        localArNativeSoManager.a(localArrayList, (ArrayList)localObject, "arcloud");
      }
    }
    return bool1;
  }
  
  public OcrConfig a()
  {
    Object localObject1 = getIntent().getExtras();
    if (localObject1 != null) {
      localObject1 = (OcrConfig)((Bundle)localObject1).get("key_ocr_config");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      AppInterface localAppInterface = this.d;
      localObject2 = localObject1;
      if ((localAppInterface instanceof QQAppInterface)) {
        localObject2 = ((IOCRService)localAppInterface.getRuntimeService(IOCRService.class, "")).getOCRConfig(false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getOcrConfig:");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("ScanBaseActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public void b()
  {
    this.a = ((TextView)findViewById(2131436180));
    this.b = ((TextView)findViewById(2131436227));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(this);
      View localView = findViewById(2131447479);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
    }
    if (AppSetting.e) {
      findViewById(2131436180).setContentDescription(HardCodeUtil.a(2131910981));
    }
  }
  
  public void c() {}
  
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
    boolean bool = d();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("checkOcrEnable:");
      paramBundle.append(bool);
      QLog.d("ScanBaseActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQProgressDialog localQQProgressDialog = this.g;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void updateAppRuntime()
  {
    this.e = ((QQAppInterface)getAppRuntime());
    this.d = this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanBaseActivity
 * JD-Core Version:    0.7.0.1
 */