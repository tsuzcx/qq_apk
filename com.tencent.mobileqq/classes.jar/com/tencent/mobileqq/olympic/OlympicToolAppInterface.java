package com.tencent.mobileqq.olympic;

import ajfb;
import ajfe;
import akiy;
import akoc;
import alie;
import android.content.Intent;
import android.os.Bundle;
import athe;
import athf;
import atmq;
import awqx;
import axrr;
import axso;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class OlympicToolAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  athe jdField_a_of_type_Athe = null;
  public athf a;
  private axso jdField_a_of_type_Axso;
  public HashMap<Integer, ajfb> a;
  public List<ajfe> a;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public ajfb a(int paramInt)
  {
    ajfb localajfb1 = (ajfb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localajfb1 == null) {}
    for (;;)
    {
      ajfb localajfb2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localajfb2 = (ajfb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localajfb2 == null) {
          break label106;
        }
        return localajfb2;
        if (localajfb1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localajfb1);
        }
        return localajfb1;
      }
      Object localObject2 = new alie(this);
      continue;
      localObject2 = new akiy(this);
      continue;
      return localObject2;
      label106:
      localObject2 = localajfb2;
      switch (paramInt)
      {
      }
      localObject2 = localajfb2;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Athf.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(ajfe paramajfe)
  {
    addObserver(paramajfe, false);
  }
  
  public void addObserver(ajfe paramajfe, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajfe)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajfe);
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<ajfe> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public atmq getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public axrr getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Axso == null) {
      this.jdField_a_of_type_Axso = new axso();
    }
    return this.jdField_a_of_type_Axso.a(this, paramInt);
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
    this.jdField_a_of_type_Athf = new athf(this);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    AudioHelper.a(this.app, getLongAccountUin());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + akoc.b);
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
  
  public void removeObserver(ajfe paramajfe)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajfe);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    awqx.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Athf.a(paramToServiceMsg);
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_Athe = new athe(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Athe);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */