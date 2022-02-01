package com.tencent.mobileqq.guild.message.unread.api;

public class IGuildUnreadCntService$UnreadCntInfo
{
  public long a = 0L;
  public int b = 1;
  
  public IGuildUnreadCntService$UnreadCntInfo() {}
  
  public IGuildUnreadCntService$UnreadCntInfo(long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > 0L)
    {
      this.a = paramLong1;
      this.b = 1;
      return;
    }
    if (paramLong2 > 0L)
    {
      this.a = paramLong2;
      this.b = 2;
      return;
    }
    this.a = 0L;
    this.b = 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof UnreadCntInfo))
    {
      long l = this.a;
      paramObject = (UnreadCntInfo)paramObject;
      return (l == paramObject.a) && (this.b == paramObject.b);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unreadCnt:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append("showType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo
 * JD-Core Version:    0.7.0.1
 */