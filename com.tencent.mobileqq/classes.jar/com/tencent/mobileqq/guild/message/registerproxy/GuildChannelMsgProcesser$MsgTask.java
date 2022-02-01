package com.tencent.mobileqq.guild.message.registerproxy;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.GuildMessageCache;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;

public class GuildChannelMsgProcesser$MsgTask
  implements Runnable
{
  public long a;
  private synclogic.ChannelMsg b;
  private Bundle c;
  
  public GuildChannelMsgProcesser$MsgTask(GuildChannelMsgProcesser paramGuildChannelMsgProcesser, synclogic.ChannelMsg paramChannelMsg, Bundle paramBundle)
  {
    this.b = paramChannelMsg;
    this.c = paramBundle;
    this.a = GuildChannelMsgProcesser.a().incrementAndGet();
  }
  
  private void a()
  {
    if (this.b == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = GuildChannelMsgProcesser.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGuildMsg channelid:");
      localStringBuilder.append(this.b.channel_id.get());
      localStringBuilder.append(" result :");
      localStringBuilder.append(this.b.result.get());
      localStringBuilder.append(" rsp_begin_seq:");
      localStringBuilder.append(this.b.rsp_begin_seq.get());
      localStringBuilder.append(" rsp_end_seq:");
      localStringBuilder.append(this.b.rsp_end_seq.get());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    ((IGuildMsgFactory)GuildChannelMsgProcesser.a(this.this$0).getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(1).a(new Object[] { this.c, this.b });
  }
  
  private void b()
  {
    synchronized (GuildChannelMsgProcesser.b(this.this$0))
    {
      Iterator localIterator = GuildChannelMsgProcesser.b(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((IGuildProcesserCallBack)localIterator.next()).a(-1, Long.valueOf(this.a));
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void run()
  {
    synchronized (((IGuildMsgFactory)GuildChannelMsgProcesser.a(this.this$0).getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().a(String.valueOf(this.b.channel_id.get())))
    {
      a();
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildChannelMsgProcesser.MsgTask
 * JD-Core Version:    0.7.0.1
 */