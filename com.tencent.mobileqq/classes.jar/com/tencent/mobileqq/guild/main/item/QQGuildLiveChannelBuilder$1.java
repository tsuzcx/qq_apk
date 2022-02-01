package com.tencent.mobileqq.guild.main.item;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

class QQGuildLiveChannelBuilder$1
  implements Runnable
{
  QQGuildLiveChannelBuilder$1(QQGuildLiveChannelBuilder paramQQGuildLiveChannelBuilder, QQGuildLiveChannelBuilder.ChannelHolder paramChannelHolder) {}
  
  public void run()
  {
    int i = QQGuildLiveChannelBuilder.ChannelHolder.h(this.a).getWidth();
    int j = QQGuildLiveChannelBuilder.ChannelHolder.g(this.a).getWidth();
    int k = ViewUtils.dip2px(37.0F);
    QQGuildLiveChannelBuilder.ChannelHolder.b(this.a).setMaxWidth(i - j - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder.1
 * JD-Core Version:    0.7.0.1
 */