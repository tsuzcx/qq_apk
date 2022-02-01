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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UinMD5Cache.a(paramAppRuntime.getAccount()));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void doOnCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    try
    {
      this.currentUinMD5 = UinMD5Cache.a(this.mApp.getAccount());
    }
    catch (NoClassDefFoundError paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
    boolean bool;
    if (MobileQQ.sProcessId != 9) {
      bool = true;
    } else {
      bool = false;
    }
    init(bool);
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
    while (i < j)
    {
      String str = buildAccountDpcName(arrayOfDPCAccountNames[i].name());
      Object localObject = localSharedPreferences.getString(str, "");
      DeviceProfileManager.DPCConfigInfo localDPCConfigInfo;
      if ("".equals(localObject))
      {
        localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.mFeatureDefaultAccountMap.get(str)).clone();
      }
      else
      {
        localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
        DeviceProfileManager.buildDPCConfigValue(localDPCConfigInfo, (String)localObject);
      }
      this.mFeatureAccountMapLV2.put(str, localDPCConfigInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init loop mFeatureMapLV2_account MAP: ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("=");
        ((StringBuilder)localObject).append(localDPCConfigInfo.toString());
        QLog.i("DeviceProfileManager", 2, ((StringBuilder)localObject).toString());
      }
      i += 1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.currentUinMD5);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.api.impl.DPCAccountServiceImpl
 * JD-Core Version:    0.7.0.1
 */