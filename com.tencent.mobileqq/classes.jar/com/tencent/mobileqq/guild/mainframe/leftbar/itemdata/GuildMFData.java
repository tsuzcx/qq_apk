package com.tencent.mobileqq.guild.mainframe.leftbar.itemdata;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;

public class GuildMFData
  extends GuildBaseLeftItemData
{
  public long f = 0L;
  public IGuildUnreadCntService.UnreadCntInfo g = new IGuildUnreadCntService.UnreadCntInfo();
  public String h = "";
  
  public GuildMFData(String paramString)
  {
    super(1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildMFData
 * JD-Core Version:    0.7.0.1
 */