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
  public static int a(int paramInt)
  {
    return a().getMachineHeadResId(paramInt);
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    return a().decodeMessageDeviceType(paramMsg);
  }
  
  public static IQFileAssistantUtils a()
  {
    return (IQFileAssistantUtils)QRoute.api(IQFileAssistantUtils.class);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a().getMachineNickName(paramContext, paramInt);
  }
  
  public static void a(Context paramContext)
  {
    a().openNewDatalineAio(paramContext);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    a().openNewDatalineAioSingle(paramContext, paramIntent);
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
  
  public static String b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getNewVersionDatalineUin(paramBaseQQAppInterface);
  }
  
  public static void b(int paramInt)
  {
    a().setSendTarget(paramInt);
  }
  
  public static boolean b()
  {
    return a().isNewVersionDataline();
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return a().userOfflineOnly(paramBaseQQAppInterface, paramLong);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return a().isMessageSender(paramMessageRecord);
  }
  
  public static int c()
  {
    return a().getCurrentDeviceType();
  }
  
  public static int c(int paramInt)
  {
    return a().getMachineType(paramInt);
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    a().resetFileAssistantOnlineMark(paramBaseQQAppInterface);
  }
  
  public static int d()
  {
    return a().getCurrentTargetDeviceType();
  }
  
  public static long d(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getOnlyOfflineLimitSize(paramBaseQQAppInterface);
  }
  
  public static boolean e(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().isNeedShowPadOpts(paramBaseQQAppInterface);
  }
  
  public static long f(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().getOfflineDelay(paramBaseQQAppInterface);
  }
  
  public static boolean g(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a().checkNotifyDeviceOnline(paramBaseQQAppInterface);
  }
  
  public static void h(BaseQQAppInterface paramBaseQQAppInterface)
  {
    a().notifyUpdateRecentFileAssistant(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils
 * JD-Core Version:    0.7.0.1
 */