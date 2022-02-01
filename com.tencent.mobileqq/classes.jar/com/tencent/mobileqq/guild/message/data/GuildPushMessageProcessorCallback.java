package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.base.AbsGuildPushMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GuildPushMessageProcessorCallback
  extends AbsGuildPushMessageProcessorCallback
{
  final String a = "GuildPushMessageProcessorCallback";
  
  private boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo, boolean paramBoolean)
  {
    Object localObject = paramMessageRecord.mMessageInfo;
    int i = 0;
    boolean bool;
    if (localObject == null)
    {
      paramMessageRecord = paramMessageRecord.frienduin;
      localObject = ((IGPSService)paramQQAppInterface.getRuntimeService(IGPSService.class)).getChannelInfo(paramMessageRecord);
      if ((localObject != null) && (((IGProChannelInfo)localObject).getFinalMsgNotify() == 1))
      {
        paramBoolean = true;
        a(paramQQAppInterface, 1000, true, (int)paramUnreadCntInfo.a, true, true);
      }
      else
      {
        paramBoolean = false;
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("[isOnlyAtMessage], getFinalMsgNotify: ");
        if (localObject != null) {
          paramQQAppInterface = Integer.valueOf(((IGProChannelInfo)localObject).getFinalMsgNotify());
        } else {
          paramQQAppInterface = "null";
        }
        paramMessageRecord.append(paramQQAppInterface);
        paramMessageRecord.append(", needSoundVibrationsTip: ");
        paramMessageRecord.append(paramBoolean);
        QLog.d("GuildPushMessageProcessorCallback", 2, paramMessageRecord.toString());
        return paramBoolean;
      }
    }
    else
    {
      paramMessageRecord = paramMessageRecord.mMessageInfo.c;
      if ((paramMessageRecord.a == 24) || (paramMessageRecord.a == 13)) {
        i = 1;
      }
      if (i != 0)
      {
        paramBoolean = true;
        a(paramQQAppInterface, 1000, true, (int)paramUnreadCntInfo.a, true, true);
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("[isOnlyAtMessage], bizType: ");
        paramQQAppInterface.append(paramMessageRecord.a);
        paramQQAppInterface.append(", needSoundVibrationsTip: ");
        paramQQAppInterface.append(paramBoolean);
        QLog.d("GuildPushMessageProcessorCallback", 2, paramQQAppInterface.toString());
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private void b(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramInt1 == 1000)
    {
      if (!paramBoolean1) {
        return;
      }
      if (paramInt2 > 0)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[afterOnlinePushProcessed], unRead ");
            localStringBuilder.append(paramInt2);
            QLog.d("GuildPushMessageProcessorCallback", 2, localStringBuilder.toString());
          }
          paramQQAppInterface.handleReceivedMessage(paramInt2, paramBoolean2, paramBoolean3);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.w("GuildPushMessageProcessorCallback", 2, "[notifyNotification] notification exception", paramQQAppInterface);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("GuildPushMessageProcessorCallback", 2, "[notifyNotification], no unRead message");
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppInterface).userActiveStatus = paramInt;
    }
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList)
  {
    ((IGuildPicDownLoadConfigApi)QRoute.api(IGuildPicDownLoadConfigApi.class)).preDownLoadMsg(paramArrayList, paramAppInterface);
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (paramArrayList.size() == 0) {
        return;
      }
      if (StudyModeManager.h()) {
        return;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.get(paramArrayList.size() - 1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[afterOnlinePushProcessed], messageRecord ");
        ((StringBuilder)localObject1).append(localMessageRecord.toString());
        QLog.d("GuildPushMessageProcessorCallback", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = localMessageRecord.frienduin;
      Object localObject2 = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
      boolean bool = false;
      long l = ((IGuildMessageUtilsApi)localObject2).getGuildIdFromMR((MessageRecord)paramArrayList.get(0));
      paramArrayList = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getChannelList(String.valueOf(l));
      paramAppInterface = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo((String)localObject1);
      if ((paramAppInterface != null) && (paramAppInterface.getFinalMsgNotify() == 1)) {
        paramAppInterface = ((IGuildUnreadCntService)localQQAppInterface.getRuntimeService(IGuildUnreadCntService.class)).getChannelUnreadCnt((String)localObject1, 1);
      } else {
        paramAppInterface = ((IGuildUnreadCntService)localQQAppInterface.getRuntimeService(IGuildUnreadCntService.class)).getChannelUnreadCnt((String)localObject1, 6);
      }
      if ((paramArrayList != null) && (paramAppInterface != null))
      {
        if (paramAppInterface.b == 2) {
          return;
        }
        int i = 0;
        while (i < paramArrayList.size())
        {
          localObject2 = (IGProChannelInfo)paramArrayList.get(i);
          if (((String)localObject1).equals(((IGProChannelInfo)localObject2).getChannelUin()))
          {
            if ((((IGProChannelInfo)localObject2).getFinalMsgNotify() == 2) || (((IGProChannelInfo)localObject2).getFinalMsgNotify() == 1)) {
              bool = a(localQQAppInterface, localMessageRecord, paramAppInterface, false);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("[afterOnlinePushProcessed], needSoundVibrationsTip ");
            paramAppInterface.append(bool);
            paramAppInterface.append(" igProChannelInfo.getFinalMsgNotify() = ");
            paramAppInterface.append(((IGProChannelInfo)localObject2).getFinalMsgNotify());
            paramAppInterface.append(", channelId: ");
            paramAppInterface.append((String)localObject1);
            QLog.d("GuildPushMessageProcessorCallback", 2, paramAppInterface.toString());
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo == null) {
      return;
    }
    paramArrayList = ((MessageRecord)paramArrayList.get(paramArrayList.size() - 1)).frienduin;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[beforeSaveMsg] messageInfo.getShmsgseq = ");
      ((StringBuilder)localObject).append(paramMessageInfo.b());
      ((StringBuilder)localObject).append("\nmessageInfo.uinType = ");
      ((StringBuilder)localObject).append(paramMessageInfo.b);
      ((StringBuilder)localObject).append("\nmessageInfo.getBizType = ");
      ((StringBuilder)localObject).append(paramMessageInfo.a(false));
      ((StringBuilder)localObject).append("\nchannelId = ");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.d("GuildPushMessageProcessorCallback", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (BaseInfoManager)paramAppInterface.getManager(QQManagerFactory.GUILDINFO_MANAGER);
    paramAppInterface = paramMessageInfo;
    if (!paramMessageInfo.e()) {
      paramAppInterface = new MessageInfo();
    }
    ((BaseInfoManager)localObject).a(paramArrayList, paramAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramQQAppInterface, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3);
  }
  
  public boolean a()
  {
    return StartService.a;
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppInterface).mAutomator.j();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.data.GuildPushMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */