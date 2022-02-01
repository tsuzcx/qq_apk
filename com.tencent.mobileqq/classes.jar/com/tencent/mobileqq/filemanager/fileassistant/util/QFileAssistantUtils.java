package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils;
import com.tencent.mobileqq.qroute.QRoute;
import msf.msgcomm.msg_comm.Msg;

public class QFileAssistantUtils
{
  public static int a()
  {
    return a().getCurrentDeviceType();
  }
  
  public static int a(int paramInt)
  {
    return a().getMachineHeadResId(paramInt);
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    return a().decodeMessageDeviceType(paramMsg);
  }
  
  public static long a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getOnlyOfflineLimitSize(paramBaseQQAppInterface);
  }
  
  public static IQFileAssistantUtils a()
  {
    return (IQFileAssistantUtils)QRoute.api(IQFileAssistantUtils.class);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a().getMachineNickName(paramContext, paramInt);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getNewVersionDatalineUin(paramBaseQQAppInterface);
  }
  
  public static void a(int paramInt)
  {
    a().setSendTarget(paramInt);
  }
  
  public static void a(Context paramContext)
  {
    a().openNewDatalineAio(paramContext);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    a().openNewDatalineAioSingle(paramContext, paramIntent);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    a().resetFileAssistantOnlineMark(paramBaseQQAppInterface);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    a().setFileAssistantOnlineMark(paramBaseQQAppInterface, paramInt, paramBoolean);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, Bundle paramBundle)
  {
    a().reParseFileAssistantInfo(paramBaseQQAppInterface, paramIntent, paramBundle);
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt)
  {
    a().saveMessageDeviceType(paramMessageRecord, paramInt);
  }
  
  public static boolean a()
  {
    return a().isNewVersionDataline();
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().isNewVersionDataline(paramBaseQQAppInterface);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return a().isAutoDownloadOffline(paramBaseQQAppInterface, paramLong);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    return a().isIgonreDataLineLogic(paramBaseQQAppInterface, paramRecentUser);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return a().isOldDatalineMsgRecord(paramMessageRecord);
  }
  
  public static boolean a(String paramString)
  {
    return a().isFileAssistantAio(paramString);
  }
  
  public static int b()
  {
    return a().getCurrentTargetDeviceType();
  }
  
  public static int b(int paramInt)
  {
    return a().getMachineType(paramInt);
  }
  
  public static long b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getOfflineDelay(paramBaseQQAppInterface);
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    a().notifyUpdateRecentFileAssistant(paramBaseQQAppInterface);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().isNeedShowPadOpts(paramBaseQQAppInterface);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return a().userOfflineOnly(paramBaseQQAppInterface, paramLong);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return a().isMessageSender(paramMessageRecord);
  }
  
  public static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().checkNotifyDeviceOnline(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils
 * JD-Core Version:    0.7.0.1
 */