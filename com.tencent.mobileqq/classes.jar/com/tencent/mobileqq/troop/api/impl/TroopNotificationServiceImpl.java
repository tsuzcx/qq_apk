package com.tencent.mobileqq.troop.api.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.ITroopNotificationLoadDBListener;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationApplicantInfoController;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationController;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationGeneralGroupNotifyParserController;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationRecordMessageController;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationShowNewEntryConfigController;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopNotificationServiceImpl
  implements ITroopNotificationService
{
  private static final String TAG = "TroopNotificationServiceImpl";
  private AppRuntime app;
  private Object lock = new Object();
  private Map<Class, TroopNotificationController> mControllerCache = new ConcurrentHashMap();
  
  private void dispatchControllerClearAllMsgCache()
  {
    Iterator localIterator = this.mControllerCache.values().iterator();
    while (localIterator.hasNext())
    {
      TroopNotificationController localTroopNotificationController = (TroopNotificationController)localIterator.next();
      if (localTroopNotificationController != null) {
        localTroopNotificationController.b();
      }
    }
  }
  
  private void dispatchControllerDestroy()
  {
    Iterator localIterator = this.mControllerCache.values().iterator();
    while (localIterator.hasNext())
    {
      TroopNotificationController localTroopNotificationController = (TroopNotificationController)localIterator.next();
      if (localTroopNotificationController != null) {
        localTroopNotificationController.c();
      }
    }
  }
  
  private TroopNotificationController genController(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[] { AppRuntime.class });
      paramClass.setAccessible(true);
      paramClass = (TroopNotificationController)paramClass.newInstance(new Object[] { this.app });
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
      handleGenControllerException(paramClass);
    }
    return null;
  }
  
  private <T extends TroopNotificationController> T getController(Class<T> paramClass)
  {
    Object localObject1 = (TroopNotificationController)this.mControllerCache.get(paramClass);
    if (localObject1 == null) {
      synchronized (this.lock)
      {
        Object localObject2 = (TroopNotificationController)this.mControllerCache.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = genController(paramClass);
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Controller name:");
            ((StringBuilder)localObject2).append(paramClass.getSimpleName());
            ((StringBuilder)localObject2).append(" is not null");
            QLog.i("TroopNotificationServiceImpl", 1, ((StringBuilder)localObject2).toString());
            this.mControllerCache.put(paramClass, localObject1);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Controller name:");
            ((StringBuilder)localObject2).append(paramClass.getSimpleName());
            ((StringBuilder)localObject2).append(" is null");
            QLog.i("TroopNotificationServiceImpl", 1, ((StringBuilder)localObject2).toString());
          }
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private void handleGenControllerException(Exception paramException)
  {
    if ((paramException instanceof NoSuchMethodException))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("genController getDeclaredConstructor throw NoSuchMethodException e:");
      localStringBuilder.append(paramException.getMessage());
      QLog.e("TroopNotificationServiceImpl", 1, localStringBuilder.toString());
      return;
    }
    if ((paramException instanceof SecurityException))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("genController getDeclaredConstructor or setAccessible throw SecurityException e:");
      localStringBuilder.append(paramException.getMessage());
      QLog.e("TroopNotificationServiceImpl", 1, localStringBuilder.toString());
      return;
    }
    if ((!(paramException instanceof IllegalAccessException)) && (!(paramException instanceof IllegalArgumentException)) && (!(paramException instanceof InstantiationException)) && (!(paramException instanceof InvocationTargetException)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("genController throw other Exception e:");
      localStringBuilder.append(paramException.getMessage());
      localStringBuilder.append("Exception name:");
      localStringBuilder.append(paramException.getClass().getSimpleName());
      QLog.e("TroopNotificationServiceImpl", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("genController newInstance throw Exception e:");
    localStringBuilder.append(paramException.getMessage());
    localStringBuilder.append("Exception name:");
    localStringBuilder.append(paramException.getClass().getSimpleName());
    QLog.e("TroopNotificationServiceImpl", 1, localStringBuilder.toString());
  }
  
  public void addLackApplicantInfoUinToCacheBy0x5eb(Long paramLong)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramLong, 0, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void addLackApplicantInfoUinToCacheBy0x668(Long paramLong)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramLong, 0, "OidbSvc.0x668");
  }
  
  public void addMessageRecord(@Nullable List<MessageRecord> paramList, int paramInt)
  {
    ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a(paramList, paramInt);
  }
  
  public void addUnreadCountOrConfigChangedListener(@Nullable ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    ((TroopNotificationShowNewEntryConfigController)getController(TroopNotificationShowNewEntryConfigController.class)).a(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  }
  
  public void clearAllLackApplicantInfoUinsFromCache()
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a();
  }
  
  public void clearAllMsgCache()
  {
    dispatchControllerClearAllMsgCache();
  }
  
  @Nullable
  public TroopNotifyApplicantInfo getApplicantInfo(Long paramLong)
  {
    return ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramLong);
  }
  
  @NonNull
  public List<MessageRecord> getDataListFromClassificationCache(int paramInt)
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a(paramInt);
  }
  
  public IGeneralGroupNotifyParser getGeneralGroupNotifyParser(int paramInt)
  {
    return ((TroopNotificationGeneralGroupNotifyParserController)getController(TroopNotificationGeneralGroupNotifyParserController.class)).a(paramInt);
  }
  
  @NonNull
  public List<Long> getLackApplicantInfoWaitingListFromCache(@Nullable String paramString)
  {
    return ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramString);
  }
  
  @NonNull
  public List<MessageRecord> getMessageRecordListFromCache()
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a();
  }
  
  @Nullable
  public List<MessageRecord> getMessageRecordMayBeLoadDB(@Nullable ITroopNotificationService.ITroopNotificationLoadDBListener paramITroopNotificationLoadDBListener)
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a(paramITroopNotificationLoadDBListener);
  }
  
  public void getNotifyCationApplicantInfoBy0x5eb(@Nullable List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramList, "OidbSvc.0x5eb_troopnotifycation");
  }
  
  public void getNotifyCationApplicantQQLevelBy0x668(@Nullable List<Long> paramList)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramList, "OidbSvc.0x668");
  }
  
  public boolean hasUnreadUndealMsg()
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a();
  }
  
  public boolean isTroopNotificaitonGetAll()
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).b();
  }
  
  public boolean isTroopSuspiciousNotificaitonGetAll()
  {
    return ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).c();
  }
  
  public void notifyNotificationShowNewEntryConfigUpdate(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    ((TroopNotificationShowNewEntryConfigController)getController(TroopNotificationShowNewEntryConfigController.class)).a(paramTroopNotificationEntryConfig);
  }
  
  public void notifyUnreadCountChanged(int paramInt)
  {
    ((TroopNotificationShowNewEntryConfigController)getController(TroopNotificationShowNewEntryConfigController.class)).a(paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    dispatchControllerDestroy();
    this.mControllerCache.clear();
  }
  
  public void removeMessage(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a(paramLong, paramString, paramInt, paramBoolean);
  }
  
  public void removeUnreadCountOrConfigChangedListener(@Nullable ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    ((TroopNotificationShowNewEntryConfigController)getController(TroopNotificationShowNewEntryConfigController.class)).b(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  }
  
  public void saveApplicantInfoListToCacheFrom0x5eb(@Nullable List<TroopNotifyApplicantInfo> paramList)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramList);
  }
  
  public void saveApplicantInfoToCacheFrom0x668(Map<Long, Integer> paramMap)
  {
    ((TroopNotificationApplicantInfoController)getController(TroopNotificationApplicantInfoController.class)).a(paramMap);
  }
  
  public void setTroopNotificaitonGetAll(boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).b(paramBoolean);
  }
  
  public void setTroopSuspiciousNotificaitonGetAll(boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).c(paramBoolean);
  }
  
  public void setUnreadUndealMsg(boolean paramBoolean)
  {
    ((TroopNotificationRecordMessageController)getController(TroopNotificationRecordMessageController.class)).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopNotificationServiceImpl
 * JD-Core Version:    0.7.0.1
 */