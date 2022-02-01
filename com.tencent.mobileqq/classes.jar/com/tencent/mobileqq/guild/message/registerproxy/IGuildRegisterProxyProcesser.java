package com.tencent.mobileqq.guild.message.registerproxy;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IGuildRegisterProxyProcesser
{
  public abstract void a();
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public abstract boolean a(Object paramObject);
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyProcesser
 * JD-Core Version:    0.7.0.1
 */