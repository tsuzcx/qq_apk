package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.IMagicCallback;
import com.tencent.qphone.base.util.QLog;

class GuildMarketFaceItemBuilder$3
  implements GuildPngFrameManager.IMagicCallback
{
  GuildMarketFaceItemBuilder$3(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, ChatMessage paramChatMessage, GuildMarketFaceItemBuilder.Holder paramHolder) {}
  
  public void a(GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "func downloadVideoDetails, 【callback】 try to download video details.");
    }
    GuildMarketFaceItemBuilder.a(this.c, paramHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      GuildMarketFaceItemBuilder.a(this.c, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */