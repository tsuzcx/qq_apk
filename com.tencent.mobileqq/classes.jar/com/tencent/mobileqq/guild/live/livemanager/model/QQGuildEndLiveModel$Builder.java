package com.tencent.mobileqq.guild.live.livemanager.model;

public class QQGuildEndLiveModel$Builder
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public Builder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public QQGuildEndLiveModel a()
  {
    QQGuildEndLiveModel localQQGuildEndLiveModel = new QQGuildEndLiveModel(null);
    QQGuildEndLiveModel.a(localQQGuildEndLiveModel, this.a);
    QQGuildEndLiveModel.b(localQQGuildEndLiveModel, this.b);
    QQGuildEndLiveModel.c(localQQGuildEndLiveModel, this.c);
    QQGuildEndLiveModel.d(localQQGuildEndLiveModel, this.d);
    QQGuildEndLiveModel.e(localQQGuildEndLiveModel, this.e);
    QQGuildEndLiveModel.f(localQQGuildEndLiveModel, this.f);
    return localQQGuildEndLiveModel;
  }
  
  public Builder b(long paramLong)
  {
    this.d = paramLong;
    return this;
  }
  
  public Builder c(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  public Builder d(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
  
  public Builder e(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public Builder f(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel.Builder
 * JD-Core Version:    0.7.0.1
 */