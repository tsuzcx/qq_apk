package com.tencent.mobileqq.dpc.api.impl;

import android.content.SharedPreferences;
import com.tencent.imcore.message.UinMD5Cache;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.dpc.DeviceProfileManager.DPCConfigInfo;
import com.tencent.mobileqq.dpc.api.IDPCAccountService;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DPCAccountServiceImpl
  implements IDPCAccountService
{
  public static HashSet<String> accountDpcNames = new HashSet();
  private String currentUinMD5;
  public AppRuntime mApp;
  public HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureAccountMapLV2 = new HashMap();
  public HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureDefaultAccountMap = new HashMap();
  
  public static String buildAccountDpcSPName(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    return UinMD5Cache.a(paramAppRuntime.getAccount()) + "_" + paramString;
  }
  
  private void doOnCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    try
    {
      this.currentUinMD5 = UinMD5Cache.a(this.mApp.getAccount());
      if (MobileQQ.sProcessId != 9)
      {
        bool = true;
        init(bool);
        return;
      }
    }
    catch (NoClassDefFoundError paramAppRuntime)
    {
      for (;;)
      {
        paramAppRuntime.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void init(boolean paramBoolean)
  {
    initDefaultValue();
    if (!paramBoolean) {
      return;
    }
    SharedPreferences localSharedPreferences = ReflectedMethods.a(this.mApp.getApplicationContext(), "dpcConfig_account");
    DPCAccountNames[] arrayOfDPCAccountNames = DPCAccountNames.values();
    int j = arrayOfDPCAccountNames.length;
    int i = 0;
    label34:
    String str1;
    String str2;
    DeviceProfileManager.DPCConfigInfo localDPCConfigInfo;
    if (i < j)
    {
      str1 = buildAccountDpcName(arrayOfDPCAccountNames[i].name());
      str2 = localSharedPreferences.getString(str1, "");
      if (!"".equals(str2)) {
        break label159;
      }
      localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultAccountMap.get(str1)).clone();
    }
    for (;;)
    {
      this.mFeatureAccountMapLV2.put(str1, localDPCConfigInfo);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceProfileManager", 2, "init loop mFeatureMapLV2_account MAP: " + str1 + "=" + localDPCConfigInfo.toString());
      }
      i += 1;
      break label34;
      break;
      label159:
      localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
      DeviceProfileManager.buildDPCConfigValue(localDPCConfigInfo, str2);
    }
  }
  
  private void initDefaultValue()
  {
    DPCAccountNames[] arrayOfDPCAccountNames = DPCAccountNames.values();
    int j = arrayOfDPCAccountNames.length;
    int i = 0;
    while (i < j)
    {
      DPCAccountNames localDPCAccountNames = arrayOfDPCAccountNames[i];
      this.mFeatureDefaultAccountMap.put(buildAccountDpcName(localDPCAccountNames.name()), new DeviceProfileManager.DPCConfigInfo());
      accountDpcNames.add(localDPCAccountNames.name());
      i += 1;
    }
  }
  
  public String buildAccountDpcName(String paramString)
  {
    return this.currentUinMD5 + "_" + paramString;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    doOnCreate(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceProfileManager", 2, "AccountDpcManager onDestroy()");
    }
    synchronized (DeviceProfileManager.getInstance())
    {
      DeviceProfileManager.sAccountDpcService = null;
      this.mApp = null;
      DeviceProfileManager.getInstance().nextServerDataState(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.api.impl.DPCAccountServiceImpl
 * JD-Core Version:    0.7.0.1
 */