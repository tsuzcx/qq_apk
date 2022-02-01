package com.tencent.mobileqq.vip;

public class IGameCardManager$GameCardInfo
{
  public String a;
  public String b;
  public long c;
  public int d;
  public boolean e;
  public int f;
  
  public IGameCardManager$GameCardInfo(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this("", paramLong, paramInt1, paramBoolean, paramInt2);
  }
  
  public IGameCardManager$GameCardInfo(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramInt1;
    this.e = paramBoolean;
    this.f = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameCardInfo{uin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameAppId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", dan=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", danSwitch=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", gameCardId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo
 * JD-Core Version:    0.7.0.1
 */