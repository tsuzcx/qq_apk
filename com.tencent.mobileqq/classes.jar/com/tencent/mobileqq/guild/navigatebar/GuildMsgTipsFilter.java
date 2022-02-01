package com.tencent.mobileqq.guild.navigatebar;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GuildMsgTipsFilter
  implements IMsgTipsFilter
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.mMessageInfo == null) {
      return true;
    }
    if (a(paramMessageRecord.mMessageInfo.c)) {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private boolean a(MessageNavInfo paramMessageNavInfo)
  {
    return (paramMessageNavInfo.a == 24) || (paramMessageNavInfo.a == 13);
  }
  
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramAIOContext = TroopBusinessUtil.a(paramMessage);
    if (paramAIOContext != null) {
      paramMessage.nickName = paramAIOContext.d;
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramAIOContext = paramAIOContext.a();
    if (paramAIOContext == null) {
      return false;
    }
    long l = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessageRecord);
    return a(((IGPSService)paramAIOContext.getRuntimeService(IGPSService.class, "")).getChannelList(String.valueOf(l)), paramMessageRecord, false);
  }
  
  public boolean a(List<IGProChannelInfo> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str = paramMessageRecord.frienduin;
    if (paramList == null) {
      return paramBoolean;
    }
    int i = 0;
    boolean bool;
    for (;;)
    {
      bool = paramBoolean;
      if (i >= paramList.size()) {
        break;
      }
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)paramList.get(i);
      if (str.equals(localIGProChannelInfo.getChannelUin()))
      {
        if ((localIGProChannelInfo.getFinalMsgNotify() != 2) && (localIGProChannelInfo.getFinalMsgNotify() != 1))
        {
          if (localIGProChannelInfo.getFinalMsgNotify() == 3) {
            paramBoolean = true;
          }
        }
        else {
          paramBoolean = a(paramMessageRecord, paramBoolean);
        }
        bool = paramBoolean;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramList = new StringBuilder();
        paramList.append("[afterOnlinePushProcessed], isNotShow ");
        paramList.append(paramBoolean);
        paramList.append(" igProChannelInfo.getMyMsgNotify() ");
        paramList.append(localIGProChannelInfo.getFinalMsgNotify());
        paramList.append(", channelId: ");
        paramList.append(str);
        QLog.d("GuildMsgTipsFilter", 2, paramList.toString());
        return paramBoolean;
      }
      i += 1;
    }
    return bool;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramAIOContext = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    if (paramAIOContext.hasRobotNewsClassId(paramMessage))
    {
      if (!paramAIOContext.hasProcessedMoreDetail(paramMessage)) {
        paramAIOContext.preProcessMessageMoreDetail(paramMessage);
      }
      paramAIOContext = paramAIOContext.generateMoreDetailMsg(paramMessage);
      if (!TextUtils.isEmpty(paramAIOContext)) {
        return paramAIOContext;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */