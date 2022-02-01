package com.tencent.mobileqq.troop.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopNotificationService
  extends IRuntimeService
{
  public abstract void addLackApplicantInfoUinToCacheBy0x5eb(Long paramLong);
  
  public abstract void addLackApplicantInfoUinToCacheBy0x668(Long paramLong);
  
  public abstract void addMessageRecord(@Nullable List<MessageRecord> paramList, int paramInt);
  
  public abstract void addUnreadCountOrConfigChangedListener(@Nullable ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  
  public abstract void clearAllLackApplicantInfoUinsFromCache();
  
  public abstract void clearAllMsgCache();
  
  @Nullable
  public abstract TroopNotifyApplicantInfo getApplicantInfo(Long paramLong);
  
  @NonNull
  public abstract List<MessageRecord> getDataListFromClassificationCache(int paramInt);
  
  public abstract IGeneralGroupNotifyParser getGeneralGroupNotifyParser(int paramInt);
  
  @NonNull
  public abstract List<Long> getLackApplicantInfoWaitingListFromCache(@Nullable String paramString);
  
  @NonNull
  public abstract List<MessageRecord> getMessageRecordListFromCache();
  
  @Nullable
  public abstract List<MessageRecord> getMessageRecordMayBeLoadDB(@Nullable ITroopNotificationService.ITroopNotificationLoadDBListener paramITroopNotificationLoadDBListener);
  
  public abstract void getNotifyCationApplicantInfoBy0x5eb(@Nullable List<Long> paramList);
  
  public abstract void getNotifyCationApplicantQQLevelBy0x668(@Nullable List<Long> paramList);
  
  public abstract boolean hasUnreadUndealMsg();
  
  public abstract boolean isTroopNotificaitonGetAll();
  
  public abstract boolean isTroopSuspiciousNotificaitonGetAll();
  
  public abstract void notifyNotificationShowNewEntryConfigUpdate(TroopNotificationEntryConfig paramTroopNotificationEntryConfig);
  
  public abstract void notifyUnreadCountChanged(int paramInt);
  
  public abstract void removeMessage(long paramLong, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void removeUnreadCountOrConfigChangedListener(@Nullable ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener);
  
  public abstract void saveApplicantInfoListToCacheFrom0x5eb(@Nullable List<TroopNotifyApplicantInfo> paramList);
  
  public abstract void saveApplicantInfoToCacheFrom0x668(Map<Long, Integer> paramMap);
  
  public abstract void setTroopNotificaitonGetAll(boolean paramBoolean);
  
  public abstract void setTroopSuspiciousNotificaitonGetAll(boolean paramBoolean);
  
  public abstract void setUnreadUndealMsg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopNotificationService
 * JD-Core Version:    0.7.0.1
 */