package com.tencent.mobileqq.guild.message.registerproxy;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;

public class GuildChannelMsgProcesser
{
  private static String a = "GuildChannelMsgProcesser";
  private static AtomicLong c = new AtomicLong(1L);
  private ArrayList<IGuildProcesserCallBack> b = new ArrayList();
  private ThreadPoolExecutor d;
  private AppInterface e;
  
  public GuildChannelMsgProcesser(AppInterface paramAppInterface)
  {
    this.e = paramAppInterface;
    this.d = new ThreadPoolExecutor(3, 5, 1000L, TimeUnit.SECONDS, new ArrayBlockingQueue(128));
  }
  
  public long a(synclogic.ChannelMsg paramChannelMsg, Bundle paramBundle)
  {
    paramChannelMsg = new GuildChannelMsgProcesser.MsgTask(this, paramChannelMsg, paramBundle);
    this.d.execute(paramChannelMsg);
    return paramChannelMsg.a;
  }
  
  public void a(IGuildProcesserCallBack paramIGuildProcesserCallBack)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(paramIGuildProcesserCallBack)) {
        this.b.add(paramIGuildProcesserCallBack);
      }
      return;
    }
  }
  
  public void b(IGuildProcesserCallBack paramIGuildProcesserCallBack)
  {
    synchronized (this.b)
    {
      if (this.b.contains(paramIGuildProcesserCallBack)) {
        this.b.remove(paramIGuildProcesserCallBack);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildChannelMsgProcesser
 * JD-Core Version:    0.7.0.1
 */