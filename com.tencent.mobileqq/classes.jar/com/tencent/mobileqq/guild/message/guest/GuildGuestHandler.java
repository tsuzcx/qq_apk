package com.tencent.mobileqq.guild.message.guest;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.GuildGuestObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ChannelMsg;
import tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ChannelParam;
import tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ReqBody;
import tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.RspBody;
import tencent.im.group_pro_proto.oidb0xfa8.oidb0xfa8.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GuildGuestHandler
  extends BusinessHandler
  implements IGuildGuestHandler
{
  private AppInterface a;
  
  public GuildGuestHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("guildId");
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
          paramObject.append("handleReportGuestEnteringGuild|oidb_sso parseFrom byte ");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.d("GuildGuestHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg.printStackTrace();
      }
      int j = paramToServiceMsg.uint32_result.get();
      i = j;
      if (j == 0)
      {
        bool = true;
        i = j;
        break label132;
      }
    }
    else
    {
      i = -1;
    }
    boolean bool = false;
    label132:
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleReportGuestEnteringGuild, guildId: ");
    paramToServiceMsg.append(str);
    paramToServiceMsg.append(", result = ");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(", isSuccess = ");
    paramToServiceMsg.append(bool);
    QLog.i("GuildGuestHandler", 2, paramToServiceMsg.toString());
    notifyUI(GuildGuestObserver.b, bool, new Object[] { str });
  }
  
  public void a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      Object localObject2 = new oidb0xfa8.ReqBody();
      ((oidb0xfa8.ReqBody)localObject2).uint64_guild_id.set(l);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(4008);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb0xfa8.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg("OidbSvcTrpcTcp.0xfa8_1");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putString("guildId", paramString);
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportGuestEnteringGuild exception: ");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.d("GuildGuestHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      Object localObject2 = new Oidb0xfa2.ChannelParam();
      ((Oidb0xfa2.ChannelParam)localObject2).guild_id.set(l1);
      ((Oidb0xfa2.ChannelParam)localObject2).channel_id.set(l2);
      Object localObject1 = new Oidb0xfa2.ReqBody();
      ((Oidb0xfa2.ReqBody)localObject1).channel_param.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(4002);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb0xfa2.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xfa2_2");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("guildId", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("channelId", paramString2);
      ((ToServiceMsg)localObject1).extraData.putInt("fromSource", 1);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportGuestEnteringGuild exception: ");
      paramString2.append(paramString1.toString());
      QLog.d("GuildGuestHandler", 2, paramString2.toString());
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      Object localObject2 = new Oidb0xfa2.ChannelParam();
      ((Oidb0xfa2.ChannelParam)localObject2).guild_id.set(l1);
      ((Oidb0xfa2.ChannelParam)localObject2).channel_id.set(l2);
      ((Oidb0xfa2.ChannelParam)localObject2).begin_seq.set(paramLong1);
      ((Oidb0xfa2.ChannelParam)localObject2).end_seq.set(paramLong2);
      Object localObject1 = new Oidb0xfa2.ReqBody();
      ((Oidb0xfa2.ReqBody)localObject1).channel_param.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(4002);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb0xfa2.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvcTrpcTcp.0xfa2_2");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("guildId", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("channelId", paramString2);
      ((ToServiceMsg)localObject1).extraData.putLong("lBeginSeq", paramLong1);
      ((ToServiceMsg)localObject1).extraData.putLong("lEndSeq", paramLong2);
      ((ToServiceMsg)localObject1).extraData.putInt("fromSource", 2);
      if (paramBundle != null) {
        ((ToServiceMsg)localObject1).extraData.putBundle("context", paramBundle);
      }
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportGuestEnteringGuild exception: ");
      paramString2.append(paramString1.toString());
      QLog.d("GuildGuestHandler", 2, paramString2.toString());
    }
    return false;
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2 = paramToServiceMsg.extraData.getString("guildId");
    String str1 = paramToServiceMsg.extraData.getString("channelId");
    int k = paramToServiceMsg.extraData.getInt("fromSource");
    Bundle localBundle = paramToServiceMsg.extraData.getBundle("context");
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
          paramObject.append("handlePullMsg. guildId: ");
          paramObject.append(str2);
          paramObject.append(", channelId: ");
          paramObject.append(str1);
          paramObject.append(", oidb_sso parseFrom byte ");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.d("GuildGuestHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg.printStackTrace();
      }
      int j = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlePullMsg, ssoPkg result = ");
        paramFromServiceMsg.append(j);
        paramFromServiceMsg.append(", guildId: ");
        paramFromServiceMsg.append(str2);
        paramFromServiceMsg.append(", channelId: ");
        paramFromServiceMsg.append(str1);
        QLog.d("GuildGuestHandler", 2, paramFromServiceMsg.toString());
      }
      if ((j == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        try
        {
          paramToServiceMsg = new Oidb0xfa2.RspBody();
          paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          i = paramToServiceMsg.result.get();
          if ((i != 0) && (i != 200006))
          {
            bool1 = false;
          }
          else
          {
            if (localBundle != null) {
              try
              {
                localBundle.putBoolean("success", true);
                localBundle.putInt("resCode", j);
              }
              catch (Exception paramToServiceMsg)
              {
                bool1 = true;
                break label486;
              }
            }
            bool1 = true;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handlePullMsg, channelMsg has = ");
              paramFromServiceMsg.append(paramToServiceMsg.channel_msg.has());
              paramFromServiceMsg.append(", resultCode = ");
              paramFromServiceMsg.append(i);
              paramFromServiceMsg.append(", guildId: ");
              paramFromServiceMsg.append(str2);
              paramFromServiceMsg.append(", channelId: ");
              paramFromServiceMsg.append(str1);
              QLog.d("GuildGuestHandler", 2, paramFromServiceMsg.toString());
            }
            j = i;
            bool2 = bool1;
            if (!paramToServiceMsg.channel_msg.has()) {
              break label518;
            }
            paramToServiceMsg = (Oidb0xfa2.ChannelMsg)paramToServiceMsg.channel_msg.get();
          }
          catch (Exception paramToServiceMsg) {}
          j = i;
        }
        catch (Exception paramToServiceMsg)
        {
          i = 0;
          bool1 = false;
        }
        label486:
        boolean bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("GuildGuestHandler", 2, paramToServiceMsg.toString());
          bool2 = bool1;
          j = i;
        }
        label518:
        paramToServiceMsg = null;
        i = j;
        bool1 = bool2;
        break label539;
      }
    }
    paramToServiceMsg = null;
    int i = 0;
    boolean bool1 = false;
    label539:
    ((IGuildMsgFactory)this.a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(4).a(new Object[] { paramToServiceMsg, localBundle, Integer.valueOf(k) });
    notifyUI(GuildGuestObserver.c, bool1, new Object[] { str1, Integer.valueOf(k), Integer.valueOf(i) });
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xfa8_1");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xfa2_2");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildGuestObserver.class;
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
          QLog.d("GuildGuestHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvcTrpcTcp.0xfa8_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvcTrpcTcp.0xfa2_2".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildGuestHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.guest.GuildGuestHandler
 * JD-Core Version:    0.7.0.1
 */