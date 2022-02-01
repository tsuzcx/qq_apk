package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IChannelPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IJoinCondition;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.List;

public class AppChnnPreInfo
  implements IAppChnnPreInfo
{
  private String a;
  private String b;
  private long c;
  private int d;
  private String e;
  private int f;
  private String g;
  private List<IChannelPreInfo> h;
  private String i;
  private int j;
  private IJoinCondition k;
  private long l;
  
  public AppChnnPreInfo(GProAppChnnPreInfo paramGProAppChnnPreInfo)
  {
    this.a = GProConvert.a(paramGProAppChnnPreInfo.getGuildId());
    this.b = GProConvert.a(paramGProAppChnnPreInfo.getChannelId());
    this.c = paramGProAppChnnPreInfo.getAppid();
    this.d = paramGProAppChnnPreInfo.getResult();
    this.e = paramGProAppChnnPreInfo.getJumpUrl();
    this.f = paramGProAppChnnPreInfo.getJumpType();
    this.g = paramGProAppChnnPreInfo.getText();
    this.h = GProConvert.l(paramGProAppChnnPreInfo.getChnnPreList());
    this.i = paramGProAppChnnPreInfo.getChnnPreSeq();
    this.j = paramGProAppChnnPreInfo.getNextTimeStamp();
    this.k = GProConvert.a(paramGProAppChnnPreInfo.getJoinCondition());
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.l = (paramLong + this.j * 1000);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public long h()
  {
    return this.l;
  }
  
  public void i()
  {
    this.l += 5000L;
  }
  
  public List<IChannelPreInfo> j()
  {
    return this.h;
  }
  
  public IJoinCondition k()
  {
    return this.k;
  }
  
  public AppChnnPreFetchInfo l()
  {
    return new AppChnnPreFetchInfo(a(), b(), g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.AppChnnPreInfo
 * JD-Core Version:    0.7.0.1
 */