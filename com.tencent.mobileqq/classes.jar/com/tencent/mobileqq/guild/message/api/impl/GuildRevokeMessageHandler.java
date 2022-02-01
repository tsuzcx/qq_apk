package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildRevokeMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.msgupdate.oidb_0xf5e.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GuildRevokeMessageHandler
  extends BusinessHandler
  implements IGuildRevokeMessageHandler
{
  public GuildRevokeMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("channelId");
    Long localLong = Long.valueOf(paramToServiceMsg.extraData.getLong("shmsgseq"));
    int i;
    if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleRecallMsgRsp|oidb_sso parseFrom byte ");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.d("GuildRevokeMessageHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg.printStackTrace();
      }
      int j = paramToServiceMsg.uint32_result.get();
      paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
      paramToServiceMsg = paramFromServiceMsg;
      i = j;
      if (j == 0)
      {
        paramToServiceMsg = paramFromServiceMsg;
        bool = true;
        i = j;
        break label161;
      }
    }
    else
    {
      i = -1;
      paramToServiceMsg = "";
    }
    boolean bool = false;
    label161:
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleRecallMsgRsp. result: ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(", isSuccess: ");
      paramFromServiceMsg.append(bool);
      paramFromServiceMsg.append(", errMsg: ");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(", channelId: ");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(", shmsgseq: ");
      paramFromServiceMsg.append(localLong);
      QLog.d("GuildRevokeMessageHandler", 2, paramFromServiceMsg.toString());
    }
    notifyUI(GuildMessageObserver.e, bool, new Object[] { str, localLong });
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = new oidb_0xf5e.ReqBody();
    try
    {
      ((oidb_0xf5e.ReqBody)localObject1).channel_id.set(Long.parseLong(paramMessageRecord.frienduin));
      ((oidb_0xf5e.ReqBody)localObject1).guild_id.set(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessageRecord));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recallMsg. channelId: ");
        ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject2).append(", shmsgseq: ");
        ((StringBuilder)localObject2).append(paramMessageRecord.shmsgseq);
        QLog.d("GuildRevokeMessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Long.valueOf(paramMessageRecord.shmsgseq));
      ((oidb_0xf5e.ReqBody)localObject1).msg_seqs.set((List)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3934);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xf5e.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xf5e_1");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("guildId", String.valueOf(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(paramMessageRecord)));
      ((ToServiceMsg)localObject1).extraData.putString("channelId", paramMessageRecord.frienduin);
      ((ToServiceMsg)localObject1).extraData.putLong("shmsgseq", paramMessageRecord.shmsgseq);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf5e_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildMessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("GuildRevokeMessageHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvcTrpcTcp.0xf5e_1".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildRevokeMessageHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildRevokeMessageHandler
 * JD-Core Version:    0.7.0.1
 */