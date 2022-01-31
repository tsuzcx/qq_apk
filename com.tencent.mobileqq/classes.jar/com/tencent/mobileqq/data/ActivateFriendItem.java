package com.tencent.mobileqq.data;

public class ActivateFriendItem
{
  public long birthSendTime;
  public String birthdayDesc;
  public String nickName;
  public int type;
  public long uin;
  
  public ActivateFriendItem(int paramInt, long paramLong)
  {
    this.type = paramInt;
    this.uin = paramLong;
  }
  
  public ActivateFriendItem(int paramInt, long paramLong, String paramString)
  {
    this.type = paramInt;
    this.uin = paramLong;
    this.nickName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ActivateFriendItem
 * JD-Core Version:    0.7.0.1
 */