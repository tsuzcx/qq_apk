package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProEnterChannelPermission;

public class EnterChannelPermission
  implements IEnterChannelPermission
{
  private GProEnterChannelPermission a;
  
  public EnterChannelPermission(GProEnterChannelPermission paramGProEnterChannelPermission)
  {
    this.a = paramGProEnterChannelPermission;
  }
  
  public boolean a()
  {
    return this.a.getAllowEnter();
  }
  
  public String b()
  {
    return this.a.getDisallowReason();
  }
  
  public boolean c()
  {
    return this.a.getAllowLive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.EnterChannelPermission
 * JD-Core Version:    0.7.0.1
 */