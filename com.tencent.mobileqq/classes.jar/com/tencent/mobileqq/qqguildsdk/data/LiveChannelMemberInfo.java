package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProMember;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

public class LiveChannelMemberInfo
  implements ILiveChannelMemberInfo
{
  private GProMember a;
  
  public LiveChannelMemberInfo(GProMember paramGProMember)
  {
    this.a = paramGProMember;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getTinyId());
  }
  
  public String b()
  {
    return this.a.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.LiveChannelMemberInfo
 * JD-Core Version:    0.7.0.1
 */