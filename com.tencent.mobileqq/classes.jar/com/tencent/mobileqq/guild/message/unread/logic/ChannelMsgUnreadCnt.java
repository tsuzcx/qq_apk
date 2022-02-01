package com.tencent.mobileqq.guild.message.unread.logic;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ChannelMsgUnreadCnt
  extends AbsChannelUnreadCnt
{
  public ChannelMsgUnreadCnt(AppRuntime paramAppRuntime, String paramString)
  {
    super(paramAppRuntime, paramString);
  }
  
  private void e()
  {
    IGProChannelInfo localIGProChannelInfo = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.b);
    if (localIGProChannelInfo == null) {
      return;
    }
    if (localIGProChannelInfo.getFinalMsgNotify() == 1)
    {
      this.c.b = 1;
      return;
    }
    this.c.b = 2;
  }
  
  private void f()
  {
    Object localObject1 = (IGuildMsgSeqTimeService)this.a.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem1 = ((IGuildMsgSeqTimeService)localObject1).getReadedMsgSeq(this.b);
    IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem2 = ((IGuildMsgSeqTimeService)localObject1).getLastSvrMsgSeq(this.b);
    if ((localMsgSeqTimeItem1.a()) && (localMsgSeqTimeItem2.a()))
    {
      if (localMsgSeqTimeItem2.b <= localMsgSeqTimeItem1.b)
      {
        this.c.a = 0L;
        return;
      }
      this.c.a = (localMsgSeqTimeItem2.b - localMsgSeqTimeItem1.b);
      localObject1 = ((IGuildMsgSeqTimeService)localObject1).getDecreaseMsgSeqList(this.b).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DecreaseMsgSeqInfo localDecreaseMsgSeqInfo = (DecreaseMsgSeqInfo)((Iterator)localObject1).next();
        if ((localDecreaseMsgSeqInfo.msgSeq > localMsgSeqTimeItem1.a) && (localDecreaseMsgSeqInfo.msgSeq <= localMsgSeqTimeItem2.a))
        {
          Object localObject2 = this.c;
          ((IGuildUnreadCntService.UnreadCntInfo)localObject2).a -= 1L;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleCommonUnreadCnt  decreaseMsgSeq:");
            ((StringBuilder)localObject2).append(localDecreaseMsgSeqInfo.msgSeq);
            QLog.e("ChannelCommonUnreadCnt", 1, ((StringBuilder)localObject2).toString());
          }
        }
      }
      if (this.c.a < 0L) {
        this.c.a = 0L;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleUnreadCnt unreadCnt: ");
        ((StringBuilder)localObject1).append(this.c.a);
        ((StringBuilder)localObject1).append(", lastSvrMsgSeq.cntSeq: ");
        ((StringBuilder)localObject1).append(localMsgSeqTimeItem2.b);
        ((StringBuilder)localObject1).append(", readedMsgSeq.cntSeq: ");
        ((StringBuilder)localObject1).append(localMsgSeqTimeItem1.b);
        QLog.i("ChannelCommonUnreadCnt", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    this.c.a = 0L;
  }
  
  public String c()
  {
    return "ChannelCommonUnreadCnt";
  }
  
  protected void d()
  {
    f();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.ChannelMsgUnreadCnt
 * JD-Core Version:    0.7.0.1
 */