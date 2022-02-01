package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils;
import msf.msgcomm.msg_comm.Msg;

public class QFileAssistantUtilsImpl
  implements IQFileAssistantUtils
{
  public boolean checkNotifyDeviceOnline(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.c(paramBaseQQAppInterface);
  }
  
  public int decodeMessageDeviceType(msg_comm.Msg paramMsg)
  {
    return QQFileAssistantUtils.a(paramMsg);
  }
  
  public int getCurrentDeviceType()
  {
    return QQFileAssistantUtils.a();
  }
  
  public int getCurrentTargetDeviceType()
  {
    return QQFileAssistantUtils.b();
  }
  
  public int getMachineHeadResId(int paramInt)
  {
    return QQFileAssistantUtils.b(paramInt);
  }
  
  public String getMachineNickName(Context paramContext, int paramInt)
  {
    return QQFileAssistantUtils.a(paramContext, paramInt);
  }
  
  public int getMachineType(int paramInt)
  {
    return QQFileAssistantUtils.a(paramInt);
  }
  
  public String getNewVersionDatalineUin(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.a(paramBaseQQAppInterface);
  }
  
  public long getOfflineDelay(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.b(paramBaseQQAppInterface);
  }
  
  public long getOnlyOfflineLimitSize(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.a(paramBaseQQAppInterface);
  }
  
  public boolean isAutoDownloadOffline(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return QQFileAssistantUtils.a(paramBaseQQAppInterface, paramLong);
  }
  
  public boolean isFileAssistantAio(String paramString)
  {
    return QQFileAssistantUtils.a(paramString);
  }
  
  public boolean isIgonreDataLineLogic(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return QQFileAssistantUtils.a(paramBaseQQAppInterface, paramRecentUser);
  }
  
  public boolean isMessageSender(MessageRecord paramMessageRecord)
  {
    return QQFileAssistantUtils.b(paramMessageRecord);
  }
  
  public boolean isNeedShowPadOpts(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.b(paramBaseQQAppInterface);
  }
  
  public boolean isNewVersionDataline()
  {
    return QQFileAssistantUtils.a();
  }
  
  public boolean isNewVersionDataline(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return QQFileAssistantUtils.a(paramBaseQQAppInterface);
  }
  
  public boolean isOldDatalineMsgRecord(MessageRecord paramMessageRecord)
  {
    return QQFileAssistantUtils.a(paramMessageRecord);
  }
  
  public void notifyUpdateRecentFileAssistant(BaseQQAppInterface paramBaseQQAppInterface)
  {
    QQFileAssistantUtils.c(paramBaseQQAppInterface);
  }
  
  public void openNewDatalineAio(Context paramContext)
  {
    QQFileAssistantUtils.a(paramContext);
  }
  
  public void openNewDatalineAioSingle(Context paramContext, Intent paramIntent)
  {
    QQFileAssistantUtils.b(paramContext, paramIntent);
  }
  
  public void reParseFileAssistantInfo(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, Bundle paramBundle)
  {
    QQFileAssistantUtils.a(paramBaseQQAppInterface, paramIntent, paramBundle);
  }
  
  public void resetFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface)
  {
    QQFileAssistantUtils.b(paramBaseQQAppInterface);
  }
  
  public void saveMessageDeviceType(MessageRecord paramMessageRecord, int paramInt)
  {
    QQFileAssistantUtils.a(paramMessageRecord, paramInt);
  }
  
  public void setFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    QQFileAssistantUtils.a(paramBaseQQAppInterface, paramInt, paramBoolean);
  }
  
  public void setSendTarget(int paramInt)
  {
    QQFileAssistantUtils.a(paramInt);
  }
  
  public boolean userOfflineOnly(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return QQFileAssistantUtils.b(paramBaseQQAppInterface, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileAssistantUtilsImpl
 * JD-Core Version:    0.7.0.1
 */