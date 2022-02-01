package com.tencent.mobileqq.guild.message.unread.api;

public class IGuildUnreadCntService$NotifyObj
{
  public int a = 0;
  public String b;
  public IGuildUnreadCntService.UnreadCntInfo c = null;
  
  public IGuildUnreadCntService$NotifyObj(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public IGuildUnreadCntService$NotifyObj(int paramInt, String paramString, IGuildUnreadCntService.UnreadCntInfo paramUnreadCntInfo)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramUnreadCntInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj
 * JD-Core Version:    0.7.0.1
 */