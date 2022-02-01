package com.tencent.mobileqq.guild.message.unread.logic;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class ChannelAtAllUnReadCnt
  extends AbsChannelUnreadCnt
{
  public ChannelAtAllUnReadCnt(AppRuntime paramAppRuntime, String paramString)
  {
    super(paramAppRuntime, paramString);
  }
  
  private void e()
  {
    Object localObject2 = (IGuildMsgSeqTimeService)this.a.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    Object localObject1 = ((IGuildMsgSeqTimeService)localObject2).getReadedMsgSeq(this.b);
    IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ((IGuildMsgSeqTimeService)localObject2).getLastSvrMsgSeq(this.b);
    if ((((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a()) && (localMsgSeqTimeItem.a()))
    {
      long l1 = localMsgSeqTimeItem.c();
      long l2 = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).c();
      if ((l2 != -1L) && (l1 != -1L))
      {
        if (l1 <= l2)
        {
          this.c.a = 0L;
          return;
        }
        this.c.a = (l1 - l2);
        localObject2 = ((IGuildMsgSeqTimeService)localObject2).getDecreaseMsgSeqList(this.b).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DecreaseMsgSeqInfo localDecreaseMsgSeqInfo = (DecreaseMsgSeqInfo)((Iterator)localObject2).next();
          if ((localDecreaseMsgSeqInfo.msgSeq > ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a) && (localDecreaseMsgSeqInfo.msgSeq <= localMsgSeqTimeItem.a) && (localDecreaseMsgSeqInfo.msgType == DecreaseMsgSeqInfo.MSGTYPE_ATALL))
          {
            Object localObject3 = this.c;
            ((IGuildUnreadCntService.UnreadCntInfo)localObject3).a -= 1L;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleCommonUnreadCnt  decreaseMsgSeq:");
              ((StringBuilder)localObject3).append(localDecreaseMsgSeqInfo.msgSeq);
              QLog.e("ChannelAtAllUnReadCnt", 1, ((StringBuilder)localObject3).toString());
            }
          }
        }
        if (this.c.a < 0L) {
          this.c.a = 0L;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleUnreadCnt unreadCnt: ");
          ((StringBuilder)localObject2).append(this.c.a);
          ((StringBuilder)localObject2).append(", lastSvrMsgSeq.cntSeq: ");
          ((StringBuilder)localObject2).append(localMsgSeqTimeItem.b);
          ((StringBuilder)localObject2).append(", readedMsgSeq.cntSeq: ");
          ((StringBuilder)localObject2).append(((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).b);
          QLog.i("ChannelAtAllUnReadCnt", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      this.c.a = 0L;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleCommonUnreadCnt error, lastAtAllSeq:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(" readedAtAllSeq:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("channelId:");
        ((StringBuilder)localObject1).append(this.b);
        QLog.i("ChannelAtAllUnReadCnt", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    this.c.a = 0L;
  }
  
  public String c()
  {
    return "ChannelAtAllUnReadCnt";
  }
  
  protected void d()
  {
    this.c.b = 1;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.logic.ChannelAtAllUnReadCnt
 * JD-Core Version:    0.7.0.1
 */