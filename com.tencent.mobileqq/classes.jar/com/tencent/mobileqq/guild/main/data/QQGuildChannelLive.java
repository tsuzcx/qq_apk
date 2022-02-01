package com.tencent.mobileqq.guild.main.data;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;

public class QQGuildChannelLive
  extends QQChannelItemData
{
  private String b;
  private IGProChannelInfo c;
  private ILiveRoomInfo d;
  private IGuildUnreadCntService.UnreadCntInfo e = new IGuildUnreadCntService.UnreadCntInfo();
  
  public QQGuildChannelLive(String paramString, IGProChannelInfo paramIGProChannelInfo)
  {
    this.b = paramString;
    this.c = paramIGProChannelInfo;
  }
  
  public IGProChannelInfo a()
  {
    return this.c;
  }
  
  public void a(int paramInt, long paramLong)
  {
    IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = this.e;
    localUnreadCntInfo.b = paramInt;
    localUnreadCntInfo.a = paramLong;
  }
  
  public void a(QQChannelItemData paramQQChannelItemData)
  {
    super.a(paramQQChannelItemData);
    if ((paramQQChannelItemData instanceof QQGuildChannelLive))
    {
      paramQQChannelItemData = (QQGuildChannelLive)paramQQChannelItemData;
      this.c = paramQQChannelItemData.a();
      this.e = paramQQChannelItemData.e();
    }
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    this.c = paramIGProChannelInfo;
  }
  
  public void a(ILiveRoomInfo paramILiveRoomInfo)
  {
    this.d = paramILiveRoomInfo;
  }
  
  public String b()
  {
    return this.c.getChannelUin();
  }
  
  public String c()
  {
    return this.b;
  }
  
  public ILiveRoomInfo d()
  {
    return this.d;
  }
  
  public IGuildUnreadCntService.UnreadCntInfo e()
  {
    return this.e;
  }
  
  public void f()
  {
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.data.QQGuildChannelLive
 * JD-Core Version:    0.7.0.1
 */