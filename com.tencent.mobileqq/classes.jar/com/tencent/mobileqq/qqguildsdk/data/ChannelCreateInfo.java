package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import java.util.List;

public class ChannelCreateInfo
{
  private int a;
  private String b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private String g;
  private String h;
  private long i;
  private int j;
  @Nullable
  private List<String> k;
  
  private ChannelCreateInfo(ChannelCreateInfo.Builder paramBuilder)
  {
    this.a = ChannelCreateInfo.Builder.a(paramBuilder);
    this.b = ChannelCreateInfo.Builder.b(paramBuilder);
    this.c = ChannelCreateInfo.Builder.c(paramBuilder);
    this.e = ChannelCreateInfo.Builder.d(paramBuilder);
    this.d = ChannelCreateInfo.Builder.e(paramBuilder);
    this.f = ChannelCreateInfo.Builder.f(paramBuilder);
    this.g = ChannelCreateInfo.Builder.g(paramBuilder);
    this.h = ChannelCreateInfo.Builder.h(paramBuilder);
    this.i = ChannelCreateInfo.Builder.i(paramBuilder);
    this.j = ChannelCreateInfo.Builder.j(paramBuilder);
    this.k = ChannelCreateInfo.Builder.k(paramBuilder);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public long i()
  {
    return this.i;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public List<String> k()
  {
    return this.k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelCreateInfo{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",name=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",talkPermission=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",msgNotifyType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",myMsgNotifyType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",finalMsgNotifyType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",appId=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",visibleType=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",visibleMemberList=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo
 * JD-Core Version:    0.7.0.1
 */