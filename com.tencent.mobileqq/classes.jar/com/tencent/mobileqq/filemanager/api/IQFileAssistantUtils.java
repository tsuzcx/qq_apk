package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import msf.msgcomm.msg_comm.Msg;

@QAPI(process={"all"})
public abstract interface IQFileAssistantUtils
  extends QRouteApi
{
  public abstract boolean checkNotifyDeviceOnline(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract int decodeMessageDeviceType(msg_comm.Msg paramMsg);
  
  public abstract int getCurrentDeviceType();
  
  public abstract int getCurrentTargetDeviceType();
  
  public abstract int getMachineHeadResId(int paramInt);
  
  public abstract String getMachineNickName(Context paramContext, int paramInt);
  
  public abstract int getMachineType(int paramInt);
  
  public abstract String getNewVersionDatalineUin(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract long getOfflineDelay(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract long getOnlyOfflineLimitSize(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isAutoDownloadOffline(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
  
  public abstract boolean isFileAssistantAio(String paramString);
  
  public abstract boolean isIgonreDataLineLogic(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser);
  
  public abstract boolean isMessageSender(MessageRecord paramMessageRecord);
  
  public abstract boolean isNeedShowPadOpts(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isNewVersionDataline();
  
  public abstract boolean isNewVersionDataline(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean isOldDatalineMsgRecord(MessageRecord paramMessageRecord);
  
  public abstract void notifyUpdateRecentFileAssistant(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void openNewDatalineAio(Context paramContext);
  
  public abstract void openNewDatalineAioSingle(Context paramContext, Intent paramIntent);
  
  public abstract void reParseFileAssistantInfo(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, Bundle paramBundle);
  
  public abstract void resetFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void saveMessageDeviceType(MessageRecord paramMessageRecord, int paramInt);
  
  public abstract void setFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean);
  
  public abstract void setSendTarget(int paramInt);
  
  public abstract boolean userOfflineOnly(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
 * JD-Core Version:    0.7.0.1
 */