package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.data.ChannelMsgEventCollection;
import com.tencent.mobileqq.guild.message.GuildMessageBoxObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxHandler;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.msg_box.MsgBox.ChannelEvent;
import tencent.im.group_pro_proto.msg_box.MsgBox.Event;
import tencent.im.group_pro_proto.msg_box.MsgBox.GetReq;
import tencent.im.group_pro_proto.msg_box.MsgBox.GetRsp;

public class GuildMessageBoxHandler
  extends BaseGuildMessageHandler
  implements IGuildMessageBoxHandler
{
  private AppInterface a;
  
  public GuildMessageBoxHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      paramFromServiceMsg = new MsgBox.GetRsp();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.err_code.get() != 0L)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("onFetchMsgEventListResp rsp failed, errCode: ");
            paramToServiceMsg.append(paramFromServiceMsg.err_code.get());
            paramToServiceMsg.append(" errMsg: ");
            paramToServiceMsg.append(paramFromServiceMsg.err_msg.get());
            QLog.e("GuildMessageBoxHandler", 1, paramToServiceMsg.toString());
          }
          notifyUI(GuildMessageBoxObserver.a, false, null);
          return;
        }
        paramToServiceMsg = localObject;
        if (paramFromServiceMsg.channel_events.has())
        {
          paramToServiceMsg = localObject;
          if (paramFromServiceMsg.channel_events.size() > 0)
          {
            paramToServiceMsg = new ArrayList();
            a(paramFromServiceMsg, paramToServiceMsg);
          }
        }
        a(paramToServiceMsg);
        a(paramFromServiceMsg);
        notifyUI(GuildMessageBoxObserver.a, true, new Object[] { paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onFetchMsgEventListResp decode error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("GuildMessageBoxHandler", 1, paramFromServiceMsg.toString());
        paramToServiceMsg.printStackTrace();
        notifyUI(GuildMessageBoxObserver.a, false, null);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessageBoxHandler", 2, "onFetchMsgEventListResp resp == null || res == null");
    }
    notifyUI(GuildMessageBoxObserver.a, false, null);
  }
  
  private void a(List<ChannelMsgEventCollection> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveChannelMsgEventList] channelMsgEventList size : ");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("GuildMessageBoxHandler", 2, ((StringBuilder)localObject).toString());
    }
    IGuildMessageBoxDataService localIGuildMessageBoxDataService = (IGuildMessageBoxDataService)this.a.getRuntimeService(IGuildMessageBoxDataService.class, "");
    HashSet localHashSet = new HashSet();
    if (localIGuildMessageBoxDataService != null)
    {
      localObject = (IGuildUnreadCntService)this.appRuntime.getRuntimeService(IGuildUnreadCntService.class, "");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelMsgEventCollection localChannelMsgEventCollection = (ChannelMsgEventCollection)paramList.next();
        if (localChannelMsgEventCollection != null)
        {
          localHashSet.add(localChannelMsgEventCollection.guildId);
          localIGuildMessageBoxDataService.addChannelMsgBoxEventList(localChannelMsgEventCollection.channelId, localChannelMsgEventCollection.msgEventList);
          ((IGuildUnreadCntService)localObject).refreshAndNotifyChannelUnreadCntInfo(localChannelMsgEventCollection.channelId);
        }
      }
      paramList = localHashSet.iterator();
      while (paramList.hasNext()) {
        ((IGuildUnreadCntService)localObject).refreshAndNotifyGuildUnreadCntInfo((String)paramList.next());
      }
    }
  }
  
  private void a(MsgBox.GetRsp paramGetRsp)
  {
    Object localObject;
    try
    {
      paramGetRsp = new String(paramGetRsp.cookie.get().toByteArray(), "ISO_8859_1");
    }
    catch (UnsupportedEncodingException paramGetRsp)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveMessageBoxCookie] exception : ");
      ((StringBuilder)localObject).append(paramGetRsp);
      QLog.d("GuildMessageBoxHandler", 2, ((StringBuilder)localObject).toString());
      paramGetRsp = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveMessageBoxCookie] cookie : ");
      ((StringBuilder)localObject).append(paramGetRsp);
      QLog.d("GuildMessageBoxHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramGetRsp))
    {
      localObject = (IGuildMessageBoxDataService)this.a.getRuntimeService(IGuildMessageBoxDataService.class, "");
      if (localObject != null) {
        ((IGuildMessageBoxDataService)localObject).setMessageBoxCookie(paramGetRsp);
      }
    }
  }
  
  private void a(@NonNull MsgBox.GetRsp paramGetRsp, @NonNull List<ChannelMsgEventCollection> paramList)
  {
    paramGetRsp = paramGetRsp.channel_events.get().iterator();
    while (paramGetRsp.hasNext())
    {
      Object localObject = (MsgBox.ChannelEvent)paramGetRsp.next();
      ChannelMsgEventCollection localChannelMsgEventCollection = new ChannelMsgEventCollection();
      localChannelMsgEventCollection.guildId = String.valueOf(((MsgBox.ChannelEvent)localObject).guild_id.get());
      localChannelMsgEventCollection.channelId = String.valueOf(((MsgBox.ChannelEvent)localObject).channel_id.get());
      if ((((MsgBox.ChannelEvent)localObject).events.has()) && (((MsgBox.ChannelEvent)localObject).events.size() > 0))
      {
        localChannelMsgEventCollection.msgEventList = new ArrayList();
        localObject = ((MsgBox.ChannelEvent)localObject).events.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          MsgBox.Event localEvent = (MsgBox.Event)((Iterator)localObject).next();
          ChannelMsgEvent localChannelMsgEvent = new ChannelMsgEvent();
          localChannelMsgEvent.channelId = localChannelMsgEventCollection.channelId;
          localChannelMsgEvent.eventType = localEvent.event_type.get();
          localChannelMsgEvent.msgSeq = localEvent.msg_seq.get();
          localChannelMsgEvent.tinyId = String.valueOf(localEvent.from_tinyid.get());
          localChannelMsgEvent.eventRandom = localEvent.event_random.get();
          localChannelMsgEventCollection.msgEventList.add(localChannelMsgEvent);
        }
      }
      paramList.add(localChannelMsgEventCollection);
    }
  }
  
  public void a()
  {
    Object localObject = (IGuildMessageBoxDataService)this.a.getRuntimeService(IGuildMessageBoxDataService.class, "");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildMessageBoxHandler", 2, "fetchMsgEventList msgBoxMgr == null");
      }
      notifyUI(GuildMessageBoxObserver.a, false, null);
      return;
    }
    String str = ((IGuildMessageBoxDataService)localObject).getMessageBoxCookie();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchMsgEventList cookie=");
      ((StringBuilder)localObject).append(str);
      QLog.d("GuildMessageBoxHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new MsgBox.GetReq();
    if (str != null) {
      try
      {
        ((MsgBox.GetReq)localObject).cookie.set(ByteStringMicro.copyFrom(str.getBytes("ISO_8859_1")));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[fetchMsgEventList] exception : ");
        localStringBuilder.append(localUnsupportedEncodingException);
        QLog.d("GuildMessageBoxHandler", 2, localStringBuilder.toString());
      }
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("trpc.group_pro.msg_box.MsgBox.Get");
    localToServiceMsg.putWupBuffer(((MsgBox.GetReq)localObject).toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.group_pro.msg_box.MsgBox.Get");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildMessageBoxObserver.class;
  }
  
  public void onDestroy() {}
  
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
          QLog.d("GuildMessageBoxHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("trpc.group_pro.msg_box.MsgBox.Get".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMessageBoxHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxHandler
 * JD-Core Version:    0.7.0.1
 */