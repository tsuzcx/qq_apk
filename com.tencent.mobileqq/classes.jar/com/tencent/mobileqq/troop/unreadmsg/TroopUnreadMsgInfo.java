package com.tencent.mobileqq.troop.unreadmsg;

public class TroopUnreadMsgInfo
{
  public long a;
  public String b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo
 * JD-Core Version:    0.7.0.1
 */