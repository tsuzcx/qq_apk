package com.tencent.mobileqq.guild.message.eventflow;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

class PullChannelEventFlowLogic$1
  implements Runnable
{
  PullChannelEventFlowLogic$1(PullChannelEventFlowLogic paramPullChannelEventFlowLogic, long paramLong1, long paramLong2, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPullRoamMsgEventFlowRsp: guildId:");
      ((StringBuilder)localObject).append(PullChannelEventFlowLogic.a(this.this$0));
      ((StringBuilder)localObject).append(" channelId:");
      ((StringBuilder)localObject).append(PullChannelEventFlowLogic.b(this.this$0));
      ((StringBuilder)localObject).append(" beginSeq:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" endSeq:");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("PullChannelEventFlowLogic", 2, ((StringBuilder)localObject).toString());
    }
    PullChannelEventFlowLogic.a(this.this$0, this.a, this.b);
    if (this.c.getUin() == null) {
      localObject = PullChannelEventFlowLogic.c(this.this$0).getCurrentAccountUin();
    } else {
      localObject = this.c.getUin();
    }
    ((IGuildMsgFactory)PullChannelEventFlowLogic.c(this.this$0).getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5).a(new Object[] { this.c, this.d, this.e, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.PullChannelEventFlowLogic.1
 * JD-Core Version:    0.7.0.1
 */