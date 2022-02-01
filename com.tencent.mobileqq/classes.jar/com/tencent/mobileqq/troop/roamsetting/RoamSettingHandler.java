package com.tencent.mobileqq.troop.roamsetting;

import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import GeneralSettings.Setting;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.RoamSettingProcessorConfig;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RoamSettingHandler
  extends TroopBaseHandler
{
  public RoamSettingHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private Map<String, Integer> a(ArrayList<Setting> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)paramArrayList.get(i);
        Object localObject = localSetting.Path;
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetGeneralSettingAll cmd=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getMsfCommand());
      ((StringBuilder)localObject).append(" resp.isSucc=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(" resultCode=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("RoamSettingHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (IRoamSettingService)this.appRuntime.getRuntimeService(IRoamSettingService.class, "");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int j = paramToServiceMsg.extraData.getInt("Revision");
      int i = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSettingHandler", 2, "handlerGetGeneralSettingAll, data == null");
        }
        ((RoamSettingServiceImpl)localObject).onGetAllSettingsFinish(false, true);
        notifyUI(1, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      paramFromServiceMsg = paramRespGetSettings.Settings;
      paramToServiceMsg = "null";
      if ((paramFromServiceMsg != null) && (paramRespGetSettings.Settings.size() != 0))
      {
        if ((i != -1) && (i < paramRespGetSettings.Revision))
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("respRevision != data.Revision, load settings again, respRev=");
            paramToServiceMsg.append(i);
            paramToServiceMsg.append(" data.Rev=");
            paramToServiceMsg.append(paramRespGetSettings.Revision);
            QLog.d("RoamSettingHandler", 2, paramToServiceMsg.toString());
          }
          ((RoamSettingServiceImpl)localObject).onGetAllSettingsFinish(false, false);
          ((IRoamSettingService)localObject).loadAllRoamSettings(bool);
          notifyUI(1, true, new Object[] { Boolean.valueOf(false) });
          return;
        }
        if (i == -1) {
          i = paramRespGetSettings.Revision;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("oldRevision=");
          paramFromServiceMsg.append(j);
          paramFromServiceMsg.append(" lastRespRevision=");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(" total=");
          paramFromServiceMsg.append(paramRespGetSettings.Total);
          paramFromServiceMsg.append(" offset=");
          paramFromServiceMsg.append(l);
          paramFromServiceMsg.append(" data.settings.size=");
          if (paramRespGetSettings.Settings != null) {
            paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size());
          }
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("RoamSettingHandler", 2, paramFromServiceMsg.toString());
        }
        ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings(paramRespGetSettings.Settings, this.appRuntime);
        l += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total > l)
        {
          ((RoamSettingServiceImpl)localObject).loadRoamSettingsByPage(j, l, i, bool, null);
          notifyUI(1, true, new Object[] { Boolean.valueOf(false) });
          return;
        }
        ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(paramRespGetSettings.Revision, this.appRuntime);
        ((RoamSettingServiceImpl)localObject).onGetAllSettingsFinish(true, true);
        notifyUI(1, true, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlerGetGeneralSettingAll, data.Settings=");
        if (paramRespGetSettings.Settings != null) {
          paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size());
        }
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("RoamSettingHandler", 2, paramFromServiceMsg.toString());
      }
      ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(paramRespGetSettings.Revision, this.appRuntime);
      ((RoamSettingServiceImpl)localObject).onGetAllSettingsFinish(true, true);
      notifyUI(1, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    ((RoamSettingServiceImpl)localObject).onGetAllSettingsFinish(false, true);
    notifyUI(1, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i = paramToServiceMsg.extraData.getInt("localRevision");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handlerUploadRoamSettingNewValue isSuccess = ");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      localStringBuilder.append(" reqLocalRevision=");
      localStringBuilder.append(i);
      localStringBuilder.append(" data.Revision=");
      if (paramRespSetSettings == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
      }
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("RoamSettingHandler", 2, localStringBuilder.toString());
    }
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (paramRespSetSettings != null) {
        if (i + 1 == paramRespSetSettings.Revision)
        {
          ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings(localArrayList, this.appRuntime);
          ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(paramRespSetSettings.Revision, this.appRuntime);
          ((RoamSettingServiceImpl)this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(true, false);
          bool1 = bool2;
        }
        else
        {
          ((RoamSettingServiceImpl)this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(true, true);
          bool1 = bool2;
        }
      }
    }
    else
    {
      ((RoamSettingServiceImpl)this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(false, false);
      bool1 = false;
    }
    if (localArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RoamSettingHandler", 2, "handlerUploadRoamSettingNewValue  settings is null.");
      }
      return;
    }
    a(localArrayList, bool1);
  }
  
  private void a(ArrayList<Setting> paramArrayList, boolean paramBoolean)
  {
    Map localMap = a(paramArrayList);
    RoamSettingServiceImpl localRoamSettingServiceImpl = (RoamSettingServiceImpl)this.appRuntime.getRuntimeService(IRoamSettingService.class, "");
    paramArrayList = paramArrayList.iterator();
    boolean bool = false;
    while (paramArrayList.hasNext())
    {
      Setting localSetting = (Setting)paramArrayList.next();
      if (localSetting.Path != null) {
        if (localSetting.Path.startsWith("message.group.policy."))
        {
          Object localObject;
          if ((!bool) && ((paramBoolean) || ((!paramBoolean) && (localRoamSettingServiceImpl.enableRetry()))))
          {
            localObject = localMap.keySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              Boolean localBoolean = (Boolean)localRoamSettingServiceImpl.getMapRequest().get(str);
              if ((localBoolean != null) && (localBoolean.booleanValue())) {
                localRoamSettingServiceImpl.getMapRequest().put(str, Boolean.valueOf(false));
              }
            }
            notifyUI(2, paramBoolean, new Object[] { localSetting.Path, localMap });
            bool = true;
          }
          else if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleUploadRoamsSettingNewValue not notifyUI, path=");
            ((StringBuilder)localObject).append(localSetting.Path);
            ((StringBuilder)localObject).append(" value=");
            ((StringBuilder)localObject).append(localSetting.Value);
            ((StringBuilder)localObject).append(" hasNotifyTroop=");
            ((StringBuilder)localObject).append(bool);
            ((StringBuilder)localObject).append("uploadSuccess=");
            ((StringBuilder)localObject).append(paramBoolean);
            ((StringBuilder)localObject).append(" enableRetry=");
            ((StringBuilder)localObject).append(localRoamSettingServiceImpl.enableRetry());
            QLog.d("RoamSettingHandler", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          a(paramBoolean, localSetting.Path, localMap, localRoamSettingServiceImpl, localSetting, 2, "handleUploadRoamsSettingNewValue");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, Map<String, Integer> paramMap, RoamSettingServiceImpl paramRoamSettingServiceImpl, Setting paramSetting, int paramInt, String paramString2)
  {
    if ((!paramBoolean) && ((paramBoolean) || (!paramRoamSettingServiceImpl.enableRetry())))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("-->");
        paramString1.append(paramString2);
        paramString1.append(" not notifyUI, path=");
        paramString1.append(paramSetting.Path);
        paramString1.append(" value=");
        paramString1.append(paramSetting.Value);
        paramString1.append("uploadSuccess=");
        paramString1.append(paramBoolean);
        paramString1.append(" enableRetry=");
        paramString1.append(paramRoamSettingServiceImpl.enableRetry());
        QLog.d("RoamSettingHandler", 2, paramString1.toString());
      }
    }
    else {
      notifyUI(paramInt, paramBoolean, new Object[] { paramString1, paramMap });
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAllGeneralSettings.localRevision=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" offset=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" respRevision=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" isNeedGetTroopMsgFilter=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RoamSettingHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((ArrayList)localObject).add("message.group.policy.*");
    }
    RoamSettingProcessorConfig.a().a((ArrayList)localObject);
    a((ArrayList)localObject, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap != null)
    {
      if (paramConcurrentHashMap.size() == 0) {
        return;
      }
      Object localObject = new ConcurrentHashMap();
      ((Map)localObject).putAll(paramConcurrentHashMap);
      paramConcurrentHashMap = new ArrayList();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramConcurrentHashMap.add(new Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
      }
      localObject = createToServiceMsg("ProfileService.ReqSetSettings");
      ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
      ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
      send((ToServiceMsg)localObject);
    }
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GeneralSettings getGeneralSettings start offset =");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("RoamSettingHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("ProfileService.ReqGetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Paths", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putInt("Revision", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("Offset", paramLong1);
    ((ToServiceMsg)localObject).extraData.putLong("Count", paramLong2);
    ((ToServiceMsg)localObject).extraData.putInt("respRevision", paramInt2);
    ((ToServiceMsg)localObject).extraData.putBoolean("needTroopSettings", paramBoolean);
    send((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("ProfileService.ReqGetSettings");
      this.allowCmdSet.add("ProfileService.ReqSetSettings");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return RoamSettingObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("RoamSettingHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
        return;
      }
      if ("ProfileService.ReqSetSettings".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RoamSettingHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler
 * JD-Core Version:    0.7.0.1
 */