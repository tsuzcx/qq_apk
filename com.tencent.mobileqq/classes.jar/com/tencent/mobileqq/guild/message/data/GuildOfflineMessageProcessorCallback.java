package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.AbsGuildOfflineMessageProcessorCallback;
import com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GuildOfflineMessageProcessorCallback
  extends AbsGuildOfflineMessageProcessorCallback
{
  final String a = "GuildOfflineMessageProcessorCallback";
  
  public void a(AppInterface paramAppInterface, String paramString, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("messageInfo.getShmsgseq = ");
      paramArrayList.append(paramMessageInfo.b());
      paramArrayList.append("\nmessageInfo.uinType = ");
      paramArrayList.append(paramMessageInfo.b);
      paramArrayList.append("\nmessageInfo.getBizType = ");
      paramArrayList.append(paramMessageInfo.a(false));
      paramArrayList.append("\nchannelId = ");
      paramArrayList.append(paramString);
      QLog.d("GuildOfflineMessageProcessorCallback", 2, paramArrayList.toString());
    }
    ((BaseInfoManager)paramAppInterface.getManager(QQManagerFactory.GUILDINFO_MANAGER)).a(paramString, paramMessageInfo);
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList)
  {
    ((IGuildPicDownLoadConfigApi)QRoute.api(IGuildPicDownLoadConfigApi.class)).preDownLoadMsg(paramArrayList, paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.data.GuildOfflineMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */