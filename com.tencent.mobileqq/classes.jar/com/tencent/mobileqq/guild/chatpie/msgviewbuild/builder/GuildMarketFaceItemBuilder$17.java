package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import mqq.os.MqqHandler;

class GuildMarketFaceItemBuilder$17
  implements Runnable
{
  GuildMarketFaceItemBuilder$17(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, GuildMarketFaceItemBuilder.Holder paramHolder, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.r.downloadAIOEmoticon(this.a.a.getEmoticon(), 8);
    ThreadManager.getUIHandler().post(new GuildMarketFaceItemBuilder.17.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.17
 * JD-Core Version:    0.7.0.1
 */