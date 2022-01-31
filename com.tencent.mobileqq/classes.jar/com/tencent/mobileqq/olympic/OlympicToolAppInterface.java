package com.tencent.mobileqq.olympic;

import ajtb;
import ajte;
import akxj;
import alcn;
import alwr;
import android.content.Intent;
import android.os.Bundle;
import auff;
import aufg;
import aukq;
import axqy;
import aysa;
import aysx;
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
  auff jdField_a_of_type_Auff = null;
  public aufg a;
  private aysx jdField_a_of_type_Aysx;
  public HashMap<Integer, ajtb> a;
  public List<ajte> a;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  
  public OlympicToolAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public ajtb a(int paramInt)
  {
    ajtb localajtb1 = (ajtb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localajtb1 == null) {}
    for (;;)
    {
      ajtb localajtb2;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localajtb2 = (ajtb)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localajtb2 == null) {
          break label106;
        }
        return localajtb2;
        if (localajtb1 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localajtb1);
        }
        return localajtb1;
      }
      Object localObject2 = new alwr(this);
      continue;
      localObject2 = new akxj(this);
      continue;
      return localObject2;
      label106:
      localObject2 = localajtb2;
      switch (paramInt)
      {
      }
      localObject2 = localajtb2;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_Aufg.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addObserver(ajte paramajte)
  {
    addObserver(paramajte, false);
  }
  
  public void addObserver(ajte paramajte, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajte)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajte);
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
  
  public List<ajte> getBusinessObserver(int paramInt)
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
  
  public aukq getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public aysa getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aysx == null) {
      this.jdField_a_of_type_Aysx = new aysx();
    }
    return this.jdField_a_of_type_Aysx.a(this, paramInt);
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
    this.jdField_a_of_type_Aufg = new aufg(this);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
    AudioHelper.a(this.app, getLongAccountUin());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + alcn.b);
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
  
  public void removeObserver(ajte paramajte)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajte);
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    axqy.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_Aufg.a(paramToServiceMsg);
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auff = new auff(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Auff);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolAppInterface
 * JD-Core Version:    0.7.0.1
 */