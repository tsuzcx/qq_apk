package com.tencent.mobileqq.guild.main.data;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

public class QQGuildChannelText
  extends QQChannelItemData
{
  private String b;
  private IGProChannelInfo c;
  private IGuildUnreadCntService.UnreadCntInfo d = new IGuildUnreadCntService.UnreadCntInfo();
  private boolean e = false;
  
  public QQGuildChannelText(String paramString, IGProChannelInfo paramIGProChannelInfo)
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
    IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = this.d;
    localUnreadCntInfo.b = paramInt;
    localUnreadCntInfo.a = paramLong;
  }
  
  public void a(QQChannelItemData paramQQChannelItemData)
  {
    super.a(paramQQChannelItemData);
    if ((paramQQChannelItemData instanceof QQGuildChannelText))
    {
      paramQQChannelItemData = (QQGuildChannelText)paramQQChannelItemData;
      this.c = paramQQChannelItemData.a();
      this.d = paramQQChannelItemData.b();
      this.e = paramQQChannelItemData.e;
    }
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    this.c = paramIGProChannelInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public IGuildUnreadCntService.UnreadCntInfo b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.data.QQGuildChannelText
 * JD-Core Version:    0.7.0.1
 */