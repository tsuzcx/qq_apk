package com.tencent.mobileqq.guild.chatpie;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class GuildFragmentUnreadTask
{
  protected final AIOContext a;
  boolean b = false;
  
  public GuildFragmentUnreadTask(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendReadReport. channelId:");
    ((StringBuilder)localObject).append(this.a.O().b);
    ((StringBuilder)localObject).append(", forceSendReport: ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("GuildFragmentUnreadTask", 1, ((StringBuilder)localObject).toString());
    localObject = (IGuildMsgReadedService)this.a.a().getRuntimeService(IGuildMsgReadedService.class, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a.O().b);
    if (this.b)
    {
      ((IGuildMsgReadedService)localObject).setMsgReadedAndReportForce(this.a.O().c, localArrayList, paramInt);
      this.b = false;
      return;
    }
    ((IGuildMsgReadedService)localObject).setMsgReadedAndReport(this.a.O().c, localArrayList, paramInt);
  }
  
  private boolean f()
  {
    Object localObject1 = (IGuildMsgReadedService)this.a.a().getRuntimeService(IGuildMsgReadedService.class, "");
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(this.a.O().b);
    ((IGuildMsgReadedService)localObject1).setMessageRecordReaded(this.a.O().c, (List)localObject2);
    localObject1 = (IGuildMsgSeqTimeService)this.a.a().getRuntimeService(IGuildMsgSeqTimeService.class, "");
    localObject2 = ((IGuildMsgSeqTimeService)localObject1).getReportSeqTimeItem(this.a.O().b, false);
    if (localObject2 != null)
    {
      if (!((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject2).a()) {
        return false;
      }
      boolean bool = ((IGuildMsgSeqTimeService)localObject1).setReadedMsgSeq(this.a.O().c, this.a.O().b, (IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject2, true);
      if (this.a.O().h == -1L) {
        this.a.O().h = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject2).a;
      }
      return bool;
    }
    return false;
  }
  
  private int g()
  {
    if (this.a.a() == null) {
      return 0;
    }
    return (int)((IGuildUnreadCntService)this.a.a().getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(this.a.O().b, 1).a;
  }
  
  public void a()
  {
    ThreadManager.post(new GuildFragmentUnreadTask.1(this), 8, null, false);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((((GuildChatContext)this.a).Z()) && (this.a.j()))
    {
      if (this.a.a() == null) {
        return;
      }
      Object localObject1 = this.a.e().a().e();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((IMsgUpdateCallback)((Iterator)localObject2).next()).b(this.a, paramChatMessage);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setReadedOnNewMsg. setReadedLocal channelId:");
      ((StringBuilder)localObject2).append(this.a.O().b);
      QLog.i("GuildFragmentUnreadTask", 1, ((StringBuilder)localObject2).toString());
      f();
      this.b = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IMsgUpdateCallback)((Iterator)localObject1).next()).c(this.a, paramChatMessage);
      }
      return;
    }
    paramChatMessage = new StringBuilder();
    paramChatMessage.append("setReadedOnNewMsg. checkAioPos= false. channelId:");
    paramChatMessage.append(this.a.O().b);
    QLog.i("GuildFragmentUnreadTask", 1, paramChatMessage.toString());
  }
  
  public void b()
  {
    if (!((GuildChatContext)this.a).Z())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReadedOnOpenWithPosChecking. checkAioPos= false. channelId:");
      localStringBuilder.append(this.a.O().b);
      QLog.i("GuildFragmentUnreadTask", 1, localStringBuilder.toString());
      return;
    }
    a();
  }
  
  public void c()
  {
    if (this.a.a() == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setReadedOnPause. sendReadReport channelId:");
    localStringBuilder.append(this.a.O().b);
    QLog.i("GuildFragmentUnreadTask", 1, localStringBuilder.toString());
    a(9);
    this.a.g().removeMessages(16711698);
  }
  
  public void d()
  {
    if (!((GuildChatContext)this.a).Z())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setReadedOnPauseWithPosChecking. checkAioPos= false. channelId:");
      localStringBuilder.append(this.a.O().b);
      QLog.i("GuildFragmentUnreadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setReadedOnPauseWithPosChecking. sendReadReport channelId:");
    localStringBuilder.append(this.a.O().b);
    QLog.i("GuildFragmentUnreadTask", 1, localStringBuilder.toString());
    c();
  }
  
  public void e()
  {
    this.a.g().sendEmptyMessageDelayed(16711698, 300000L);
    ThreadManager.post(new GuildFragmentUnreadTask.2(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildFragmentUnreadTask
 * JD-Core Version:    0.7.0.1
 */