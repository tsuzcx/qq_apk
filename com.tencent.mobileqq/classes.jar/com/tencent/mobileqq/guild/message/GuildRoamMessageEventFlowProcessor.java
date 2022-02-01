package com.tencent.mobileqq.guild.message;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.base.AbsGuildRoamMessageEventFlowProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

public class GuildRoamMessageEventFlowProcessor
  extends BaseGuildMessageProcessor
{
  private static AbsGuildRoamMessageEventFlowProcessorCallback a;
  
  public GuildRoamMessageEventFlowProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildRoamMessageEventFlowProcessorCallback)) {
      a = (AbsGuildRoamMessageEventFlowProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processRoamEventFlow: size:");
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramChannelMsgRsp == null)
    {
      QLog.d("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "channelMsgRsp为null");
      return;
    }
    Object localObject = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
    IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
    long l2 = paramToServiceMsg.extraData.getLong("lEndSeq");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("channelId");
    while (l1 <= l2)
    {
      MessageRecord localMessageRecord = ((BaseMsgProxy)localObject).d(paramToServiceMsg, 10014, l1);
      if (localMessageRecord != null)
      {
        localIGuildMessageUtilsApi.saveSyncTimeToMsg(localMessageRecord, paramChannelMsgRsp.get_msg_time.get());
        c(localMessageRecord);
      }
      l1 += 1L;
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramToServiceMsg = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        paramToServiceMsg.addAll(a((common.Msg)paramArrayList.next(), paramString, new MessageInfo(), paramChannelMsgRsp.get_msg_time.get()));
      }
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramToServiceMsg.next();
        paramChannelMsgRsp = ((BaseMsgProxy)localObject).d(paramArrayList.frienduin, 10014, paramArrayList.shmsgseq);
        if (paramChannelMsgRsp != null)
        {
          MessageRecord.copyMessageRecordBaseField(paramChannelMsgRsp, paramArrayList);
          d(paramChannelMsgRsp);
          paramArrayList = a;
          if (paramArrayList != null) {
            paramArrayList.a(this.d, paramChannelMsgRsp);
          }
        }
      }
      return;
    }
    QLog.i("BaseGuildMessageProcessor.GuildRoamMessageEventFlowProcessor", 1, "msgs is empty!");
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    BaseMsgProxy localBaseMsgProxy = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extStr", paramMessageRecord.extStr);
    localBaseMsgProxy.a(paramMessageRecord.frienduin, 10014, paramMessageRecord.uniseq, localContentValues);
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    BaseMsgProxy localBaseMsgProxy = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extStr", paramMessageRecord.extStr);
    localContentValues.put("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
    localContentValues.put("msgData", paramMessageRecord.msgData);
    localBaseMsgProxy.a(paramMessageRecord.frienduin, 10014, paramMessageRecord.uniseq, localContentValues);
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      ArrayList localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (synclogic.ChannelMsgRsp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildRoamMessageEventFlowProcessor
 * JD-Core Version:    0.7.0.1
 */