package com.tencent.mobileqq.troop.utils.api.impl;

import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.troop.api.config.RoamSettingProcessorConfig;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BizTroopDBUtilsApiImpl
  implements IBizTroopDBUtilsApi
{
  public static final String TAG = "BizTroopDBUtilsApiImpl";
  BizTroopDBUtilsApiImpl.LimitQueuedRunnablePool mLimitQueuedRunnablePool = new BizTroopDBUtilsApiImpl.LimitQueuedRunnablePool(10, 32);
  
  public Map<String, Integer> getTroopMsgFilter(List<String> paramList, int paramInt, AppInterface paramAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localHashMap;
      }
      if (paramAppInterface == null) {
        return localHashMap;
      }
      RoamSettingDataServiceImpl localRoamSettingDataServiceImpl = (RoamSettingDataServiceImpl)paramAppInterface.getRuntimeService(IRoamSettingDataService.class, "");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        String str1 = (String)paramList.get(i);
        if ((str1 != null) && (str1.length() != 0))
        {
          paramAppInterface = new StringBuilder(40);
          paramAppInterface.append("message.group.policy.");
          paramAppInterface.append(str1);
          String str2 = paramAppInterface.toString();
          RoamSetting localRoamSetting = localRoamSettingDataServiceImpl.findRoamSetting(str2);
          paramAppInterface = localRoamSetting;
          if (localRoamSetting == null)
          {
            paramAppInterface = localRoamSetting;
            if (!TextUtils.isEmpty(str2))
            {
              paramAppInterface = new RoamSetting(str2, Integer.toString(paramInt));
              localArrayList.add(paramAppInterface);
            }
          }
          localHashMap.put(str1, Integer.valueOf(RoamSetting.getIntValue(paramAppInterface, paramInt)));
        }
        i += 1;
      }
      if (localArrayList.size() > 0) {
        this.mLimitQueuedRunnablePool.a(new BizTroopDBUtilsApiImpl.2(this, localArrayList, localRoamSettingDataServiceImpl));
      }
    }
    return localHashMap;
  }
  
  public void removeToopMsgFilter(AppInterface paramAppInterface, String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return;
      }
      if (paramString2 == null) {
        return;
      }
      paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
      paramContext = new StringBuilder();
      paramContext.append("message.group.policy.");
      paramContext.append(paramString1);
      paramString1 = paramContext.toString();
      paramString2.remove(paramString1);
      paramString2.commit();
      ((RoamSettingDataServiceImpl)paramAppInterface.getRuntimeService(IRoamSettingDataService.class, "")).deleteRoamSetting(paramString1);
    }
  }
  
  public void saveGeneralSettings(ArrayList<Setting> paramArrayList, AppInterface paramAppInterface)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      long l = 0L;
      Object localObject1;
      if (QLog.isColorLevel())
      {
        l = System.currentTimeMillis();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("saveGeneralSettings setting start size = ");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        QLog.d("BizTroopDBUtilsApiImpl", 2, ((StringBuilder)localObject1).toString());
      }
      RoamSettingDataServiceImpl localRoamSettingDataServiceImpl = (RoamSettingDataServiceImpl)paramAppInterface.getRuntimeService(IRoamSettingDataService.class, "");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject1 = (Setting)paramArrayList.get(i);
        String str = ((Setting)localObject1).Path;
        Object localObject2 = ((Setting)localObject1).Value;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("saveGeneralSettings path =");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("; value = ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("BizTroopDBUtilsApiImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if (str != null)
        {
          if ((localObject2 != null) && (((String)localObject2).length() != 0))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equalsIgnoreCase("")) {}
          }
          else
          {
            int j = ((RoamSettingServiceImpl)paramAppInterface.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(str);
            localObject1 = RoamSettingProcessorConfig.a().b(j);
          }
          localObject2 = localRoamSettingDataServiceImpl.saveRoamSetting(str, (String)localObject1);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
          RoamSettingProcessorConfig.a().a(str, (String)localObject1);
        }
        i += 1;
      }
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        ThreadManager.post(new BizTroopDBUtilsApiImpl.1(this, localRoamSettingDataServiceImpl, localArrayList), 5, null, false);
      } else {
        localRoamSettingDataServiceImpl.saveRoamSettingToDB(localArrayList);
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("GeneralSettings zsw saveGeneralSettings setting end, consume time =");
        paramArrayList.append(System.currentTimeMillis() - l);
        QLog.d("DBUtils", 2, paramArrayList.toString());
      }
    }
  }
  
  public void saveGeneralSettingsRevision(int paramInt, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveGeneralSettingRevision=");
      localStringBuilder.append(paramInt);
      QLog.d("BizTroopDBUtilsApiImpl", 2, localStringBuilder.toString());
    }
    ((RoamSettingDataServiceImpl)paramAppInterface.getRuntimeService(IRoamSettingDataService.class, "")).setRevision(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.BizTroopDBUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */