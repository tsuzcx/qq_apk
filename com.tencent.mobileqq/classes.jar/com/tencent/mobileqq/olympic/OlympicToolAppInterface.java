package com.tencent.mobileqq.olympic;

import alpd;
import alpg;
import amso;
import amxs;
import android.content.Intent;
import android.os.Bundle;
import ansb;
import awas;
import awat;
import awgg;
import azqs;
import baue;
import bavd;
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
  awas jdField_a_of_type_Awas = null;
  public awat a;
  private bavd jdField_a_of_type_Bavd;
  public HashMap<Integer, alpd> a;
  public List<alpg> a;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public alpd a(int paramInt)
  {
    alpd localalpd1 = (alpd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localalpd1 == null) {}
    for (;;)
    {
      alpd localalpd2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localalpd2 = (alpd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localalpd2 == null) {
          break label106;
        }
        return localalpd2;
        if (localalpd1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localalpd1);
        }
        return localalpd1;
      }
      Object localObject2 = new ansb(this);
      continue;
      localObject2 = new amso(this);
      continue;
      return localObject2;
      label106:
      localObject2 = localalpd2;
      switch (paramInt)
      {
      }
      localObject2 = localalpd2;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Awat.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(alpg paramalpg)
  {
    addObserver(paramalpg, false);
  }
  
  public void addObserver(alpg paramalpg, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramalpg)) {
      this.jdField_a_of_type_JavaUtilList.add(paramalpg);
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
  
  public List<alpg> getBusinessObserver(int paramInt)
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
  
  public awgg getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public baue getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bavd == null) {
      this.jdField_a_of_type_Bavd = new bavd();
    }
    return this.jdField_a_of_type_Bavd.a(this, paramInt);
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
    this.jdField_a_of_type_Awat = new awat(this);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    AudioHelper.a(this.app, getLongAccountUin());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + amxs.b);
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
  
  public void removeObserver(alpg paramalpg)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramalpg);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    azqs.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Awat.a(paramToServiceMsg);
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_Awas = new awas(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Awas);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */