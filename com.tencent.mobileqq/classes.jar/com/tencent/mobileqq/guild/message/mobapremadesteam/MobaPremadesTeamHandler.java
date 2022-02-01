package com.tencent.mobileqq.guild.message.mobapremadesteam;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.ArkMessage;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.GuildInfo;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.MobaPremadesTeamMessage;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MobaPremadesTeamHandler
  extends BusinessHandler
  implements IMobaPremadesTeamHandler
{
  private AppInterface a;
  
  public MobaPremadesTeamHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    boolean bool = false;
    if ((i == 1000) && (paramObject != null))
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
          paramObject.append("handleMobaPremadesTeamMsg|oidb_sso parseFrom byte ");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.d("MobaPremadesTeamHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg.printStackTrace();
      }
      int j = paramToServiceMsg.uint32_result.get();
      i = j;
      if (j == 0)
      {
        bool = true;
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleMobaPremadesTeamMsg result:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(" isSuccess:");
      paramToServiceMsg.append(bool);
      QLog.i("MobaPremadesTeamHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(MobaPremadesTeamObserver.a, bool, null);
  }
  
  public void a(ArrayList<Pair<Long, Long>> paramArrayList, long paramLong, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendMobaPremadesTeamMsg guildInfos:");
        ((StringBuilder)localObject1).append(paramArrayList.toString());
        ((StringBuilder)localObject1).append(" teamId:");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(" textMsg:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("MobaPremadesTeamHandler", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new oidb0xffa.ReqBody();
      Object localObject2 = new oidb0xffa.ArkMessage();
      ((oidb0xffa.ArkMessage)localObject2).ark_message_type.set(1);
      Object localObject3 = new oidb0xffa.MobaPremadesTeamMessage();
      ((oidb0xffa.MobaPremadesTeamMessage)localObject3).team_id.set(paramLong);
      ((oidb0xffa.ArkMessage)localObject2).moba_premades_team_message.set((MessageMicro)localObject3);
      ((oidb0xffa.ReqBody)localObject1).ark_message.set((MessageMicro)localObject2);
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject3 = (Pair)paramArrayList.next();
        oidb0xffa.GuildInfo localGuildInfo = new oidb0xffa.GuildInfo();
        localGuildInfo.guild_id.set(((Long)((Pair)localObject3).first).longValue());
        localGuildInfo.channel_id.set(((Long)((Pair)localObject3).second).longValue());
        ((ArrayList)localObject2).add(localGuildInfo);
      }
      ((oidb0xffa.ReqBody)localObject1).guild_info.set((List)localObject2);
      if (!TextUtils.isEmpty(paramString)) {
        ((oidb0xffa.ReqBody)localObject1).leave_message.set(paramString);
      }
      paramArrayList = new oidb_sso.OIDBSSOPkg();
      paramArrayList.uint32_command.set(4090);
      paramArrayList.uint32_service_type.set(2);
      paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb0xffa.ReqBody)localObject1).toByteArray()));
      paramString = createToServiceMsg("OidbSvcTrpcTcp.0xffa_2");
      paramString.putWupBuffer(paramArrayList.toByteArray());
      paramString.setTimeout(30000L);
      sendPbReq(paramString);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xffa_2");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return MobaPremadesTeamObserver.class;
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
          QLog.d("MobaPremadesTeamHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvcTrpcTcp.0xffa_2".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MobaPremadesTeamHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.mobapremadesteam.MobaPremadesTeamHandler
 * JD-Core Version:    0.7.0.1
 */