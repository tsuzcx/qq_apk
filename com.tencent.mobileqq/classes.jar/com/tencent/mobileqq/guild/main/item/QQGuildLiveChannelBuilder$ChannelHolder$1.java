package com.tencent.mobileqq.guild.main.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

class QQGuildLiveChannelBuilder$ChannelHolder$1
  implements IGetUserInfoCallback
{
  QQGuildLiveChannelBuilder$ChannelHolder$1(QQGuildLiveChannelBuilder.ChannelHolder paramChannelHolder, AppInterface paramAppInterface) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    QQGuildLiveChannelBuilder.ChannelHolder.a(this.b, this.a, paramInt, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder.ChannelHolder.1
 * JD-Core Version:    0.7.0.1
 */