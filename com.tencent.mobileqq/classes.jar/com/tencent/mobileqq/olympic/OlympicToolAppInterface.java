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
import com.tencent.mobileqq.utils.QQAudioHelper;
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
  public OlympicToolService a;
  Map<Integer, Manager> b = new HashMap(20);
  OlympicToolAppInterface.MyNetInfoHandler c = null;
  private NetEngineFactory d = null;
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.b.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.b.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.d();
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
    return this.a;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    this.a = new OlympicToolService(this);
    QQAudioHelper.a((BaseApplicationImpl)this.app, getLongAccountUin());
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy ,FaceScanModelsLoader.hasFaceModelInit = ");
      localStringBuilder.append(FaceScanModelsLoader.b);
      QLog.i("olympic.OlympicToolAppInterface", 2, localStringBuilder.toString());
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
    this.c = new OlympicToolAppInterface.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.c);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */