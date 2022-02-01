package com.tencent.mobileqq.guild.message.registerproxy;

import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;

public abstract interface IGuildRegisterProxyMsgHandler
{
  public abstract void a(long paramLong);
  
  public abstract void a(ArrayList<synclogic.GuildNode> paramArrayList);
  
  public abstract void b(int paramInt);
  
  public abstract void b(ArrayList<GuildPullMsgParam> paramArrayList);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract boolean e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler
 * JD-Core Version:    0.7.0.1
 */