package com.tencent.mobileqq.guild.message.unread;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d.MyChannelInfo;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d.ReqBody;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ChannelMsgReadedReportHandler
  extends BaseGuildMessageHandler
  implements IChannelMsgReadedReportHandler
{
  private final String a = "ChannelMsgReadedReportHandler";
  
  protected ChannelMsgReadedReportHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    recordSendMessageRetryResult(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = getHandlerFromQueue(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() == 2901)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleSendMsgReadedReportError: reqSeq ");
          paramFromServiceMsg.append(l1);
          QLog.d("ChannelMsgReadedReportHandler", 2, paramFromServiceMsg.toString());
        }
        if (retrySendMessage(paramToServiceMsg, "msf")) {
          return;
        }
      }
      if ((480000L == l2) || (paramToServiceMsg.b()))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSendMsgReadedReportError, all retry: reqSeq ");
          paramToServiceMsg.append(l1);
          QLog.d("ChannelMsgReadedReportHandler", 2, paramToServiceMsg.toString());
        }
        removeSendMessageHandler(l1);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j;
    Oidb0xf6d.RspBody localRspBody;
    if ((paramObject != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      j = -1;
      localRspBody = new Oidb0xf6d.RspBody();
    }
    try
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    }
    catch (Exception paramObject)
    {
      int i;
      label41:
      break label41;
    }
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.e("ChannelMsgReadedReportHandler", 2, "handleSendMsgReadedReportError : parseOIDBPkg error");
      i = j;
    }
    if (i != 0)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, localRspBody);
    return;
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Oidb0xf6d.RspBody paramRspBody)
  {
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    if (getHandlerFromQueue(l) == null) {
      return;
    }
    removeSendMessageHandler(l);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelMsgReadedReportHandler", 2, "handleSendMsgReadedReportSuc");
    }
  }
  
  private void a(@NonNull String paramString)
  {
    IGuildMessageBoxDataService localIGuildMessageBoxDataService = (IGuildMessageBoxDataService)this.appRuntime.getRuntimeService(IGuildMessageBoxDataService.class, "");
    if (localIGuildMessageBoxDataService != null) {
      localIGuildMessageBoxDataService.clearChannelMsgBoxReadEventList(paramString, 1L);
    }
  }
  
  private void a(Oidb0xf6d.ReqBody paramReqBody)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realSendMsgReadedReportreq. rpt_msg_my_channel_list size:");
      ((StringBuilder)localObject).append(paramReqBody.rpt_msg_my_channel_list.size());
      QLog.i("ChannelMsgReadedReportHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3949);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramReqBody.toByteArray()));
    processRequest(true, true, false, 0L, new ChannelMsgReadedReportHandler.1(this, (oidb_sso.OIDBSSOPkg)localObject));
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem a(String paramString, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    IGuildMsgSeqTimeService localIGuildMsgSeqTimeService = (IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    String str = ((IGuildFocusChannelService)this.appRuntime.getRuntimeService(IGuildFocusChannelService.class, "")).getCurActiveChannelId();
    Object localObject1 = localObject2;
    if (!paramBoolean)
    {
      localObject1 = localObject2;
      if (paramString.equals(str)) {
        localObject1 = localIGuildMsgSeqTimeService.getLatestHasSeenMsg(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localIGuildMsgSeqTimeService.getLastSvrMsgSeq(paramString);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getLastSeqMsgSeqTimeItem, channel = ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", bGetLastSvr = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", lastSeq = ");
    if (localObject2 == null) {
      paramString = "null";
    } else {
      paramString = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject2).toString();
    }
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("ChannelMsgReadedReportHandler", 2, ((StringBuilder)localObject1).toString());
    return localObject2;
  }
  
  public void a(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (paramMsgSeqTimeItem == null) {
      return;
    }
    Oidb0xf6d.ReqBody localReqBody = new Oidb0xf6d.ReqBody();
    try
    {
      localReqBody.uint64_member_id.set(Long.valueOf(this.appRuntime.getCurrentUin()).longValue());
      localReqBody.uint32_type.set(2);
      Object localObject2 = (IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
      Object localObject1 = ((IGuildMsgSeqTimeService)localObject2).getReadedMsgSeq(paramString2);
      boolean bool = true;
      if (!((IGuildMsgSeqTimeService)localObject2).setReadedMsgSeq(paramString1, paramString2, paramMsgSeqTimeItem, true)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendMsgReadedReport guildid:");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(" channelid:");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(" oldReadedMsgSeq:");
        ((StringBuilder)localObject2).append(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).toString());
        ((StringBuilder)localObject2).append(" newReadedMsgSeq:");
        ((StringBuilder)localObject2).append(paramMsgSeqTimeItem.toString());
        QLog.i("ChannelMsgReadedReportHandler", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        long l1 = Long.valueOf(paramString1).longValue();
        long l2 = Long.valueOf(paramString2).longValue();
        paramString1 = new Oidb0xf6d.MyChannelInfo();
        paramString1.uint64_guild_id.set(l1);
        paramString1.uint64_channel_id.set(l2);
        localObject1 = new common.MsgSeq();
        ((common.MsgSeq)localObject1).uint64_seq.set(paramMsgSeqTimeItem.b);
        ((common.MsgSeq)localObject1).uint64_time.set(paramMsgSeqTimeItem.c);
        paramString1.msg_read_cnt_msg_seq.set((MessageMicro)localObject1);
        localObject1 = new common.MsgSeq();
        ((common.MsgSeq)localObject1).uint64_seq.set(paramMsgSeqTimeItem.a);
        ((common.MsgSeq)localObject1).uint64_time.set(paramMsgSeqTimeItem.c);
        paramString1.msg_read_msg_seq.set((MessageMicro)localObject1);
        if (paramMsgSeqTimeItem.d != null) {
          paramString1.bytes_read_msg_meta.set(ByteStringMicro.copyFrom(paramMsgSeqTimeItem.d));
        }
        if (((IGuildUnreadCntService)this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(paramString2, 4).a <= 0L) {
          bool = false;
        }
        paramString1.bool_has_at_me_msg.set(bool);
        localReqBody.rpt_msg_my_channel_list.add(paramString1);
        a(localReqBody);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ChannelMsgReadedReportHandler", 2, paramString1.toString());
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ChannelMsgReadedReportHandler", 2, paramString1.toString());
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    boolean bool1 = paramBoolean;
    int i = paramInt;
    String str1 = "ChannelMsgReadedReportHandler";
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Oidb0xf6d.ReqBody localReqBody = new Oidb0xf6d.ReqBody();
      try
      {
        localReqBody.uint64_member_id.set(Long.valueOf(this.appRuntime.getCurrentUin()).longValue());
        try
        {
          long l1 = Long.valueOf(paramString).longValue();
          localReqBody.uint32_type.set(2);
          IGuildMsgSeqTimeService localIGuildMsgSeqTimeService = (IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
          IGuildUnreadCntService localIGuildUnreadCntService = (IGuildUnreadCntService)this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "");
          HashSet localHashSet = new HashSet();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (paramArrayList.hasNext())
            {
              String str2 = (String)paramArrayList.next();
              try
              {
                long l2 = Long.valueOf(str2).longValue();
                Object localObject1 = paramArrayList;
                if ((localIGuildUnreadCntService.getChannelUnreadCnt(str2, 1).a > 0L) || (bool1)) {
                  for (;;)
                  {
                    boolean bool2;
                    if ((i != 4) && (i != 9) && (i != 10)) {
                      bool2 = true;
                    } else {
                      bool2 = false;
                    }
                    localObject1 = a(str2, bool2);
                    if (localObject1 != null)
                    {
                      if (((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a())
                      {
                        Object localObject2 = localIGuildMsgSeqTimeService.getReadedMsgSeq(str2);
                        if ((!localIGuildMsgSeqTimeService.setReadedMsgSeq(paramString, str2, (IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1, false)) && (!bool1))
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("sendMsgReadedReport, setReadedMsgSeq return false; from: ");
                          ((StringBuilder)localObject1).append(i);
                          QLog.i(str1, 1, ((StringBuilder)localObject1).toString());
                        }
                        else
                        {
                          Object localObject3 = new StringBuilder();
                          ((StringBuilder)localObject3).append("sendMsgReadedReport force:");
                          ((StringBuilder)localObject3).append(bool1);
                          ((StringBuilder)localObject3).append(" guildid:");
                          ((StringBuilder)localObject3).append(paramString);
                          ((StringBuilder)localObject3).append(" channelid:");
                          ((StringBuilder)localObject3).append(str2);
                          ((StringBuilder)localObject3).append(" oldReadedMsgSeq:");
                          ((StringBuilder)localObject3).append(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject2).toString());
                          ((StringBuilder)localObject3).append(" newReadedMsgSeq:");
                          ((StringBuilder)localObject3).append(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).toString());
                          ((StringBuilder)localObject3).append(", from:");
                          ((StringBuilder)localObject3).append(i);
                          QLog.i(str1, 1, ((StringBuilder)localObject3).toString());
                          localObject2 = new Oidb0xf6d.MyChannelInfo();
                          ((Oidb0xf6d.MyChannelInfo)localObject2).uint64_guild_id.set(l1);
                          ((Oidb0xf6d.MyChannelInfo)localObject2).uint64_channel_id.set(l2);
                          localObject3 = new common.MsgSeq();
                          ((common.MsgSeq)localObject3).uint64_seq.set(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).b);
                          ((common.MsgSeq)localObject3).uint64_time.set(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).c);
                          ((Oidb0xf6d.MyChannelInfo)localObject2).msg_read_cnt_msg_seq.set((MessageMicro)localObject3);
                          localObject3 = new common.MsgSeq();
                          ((common.MsgSeq)localObject3).uint64_seq.set(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a);
                          ((common.MsgSeq)localObject3).uint64_time.set(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).c);
                          ((Oidb0xf6d.MyChannelInfo)localObject2).msg_read_msg_seq.set((MessageMicro)localObject3);
                          if (((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).d != null) {
                            ((Oidb0xf6d.MyChannelInfo)localObject2).bytes_read_msg_meta.set(ByteStringMicro.copyFrom(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).d));
                          }
                          if (localIGuildUnreadCntService.getChannelUnreadCnt(String.valueOf(l2), 4).a > 0L) {
                            bool1 = true;
                          } else {
                            bool1 = false;
                          }
                          ((Oidb0xf6d.MyChannelInfo)localObject2).bool_has_at_me_msg.set(bool1);
                          localReqBody.rpt_msg_my_channel_list.add((MessageMicro)localObject2);
                          localHashSet.add(paramString);
                          a(str2);
                          localIGuildUnreadCntService.refreshAndNotifyChannelUnreadCntInfo(str2);
                          break;
                        }
                      }
                    }
                    else
                    {
                      bool1 = paramBoolean;
                      i = paramInt;
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                QLog.e(str1, 2, localException.toString());
                bool1 = paramBoolean;
                i = paramInt;
              }
            }
          }
          paramString = localHashSet.iterator();
          while (paramString.hasNext()) {
            localIGuildUnreadCntService.refreshAndNotifyGuildUnreadCntInfo((String)paramString.next());
          }
          if (localReqBody.rpt_msg_my_channel_list.get().size() == 0) {
            return;
          }
          a(localReqBody);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("ChannelMsgReadedReportHandler", 2, paramString.toString());
          return;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("ChannelMsgReadedReportHandler", 2, paramString.toString());
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf6d_1");
    }
    return this.allowCmdSet;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.e("ChannelMsgReadedReportHandler", 1, paramToServiceMsg.toString());
        return;
      }
      if ("OidbSvcTrpcTcp.0xf6d_1".equalsIgnoreCase(str)) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.e("ChannelMsgReadedReportHandler", 1, "onReceive,resp == null or req == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.ChannelMsgReadedReportHandler
 * JD-Core Version:    0.7.0.1
 */