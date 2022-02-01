package com.tencent.mobileqq.olympic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class OlympicToolAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  OlympicToolAppInterface.MyNetInfoHandler jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$MyNetInfoHandler = null;
  public OlympicToolService a;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolService;
  }
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onBeforeExitProc");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolService = new OlympicToolService(this);
    AudioHelper.a((BaseApplicationImpl)this.app, getLongAccountUin());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + FaceScanModelsLoader.b);
    }
    super.onDestroy();
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveAccountAction");
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveLegalExitProcAction");
    }
    return false;
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$MyNetInfoHandler = new OlympicToolAppInterface.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface$MyNetInfoHandler);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */