package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;

class GuildMarketFaceItemBuilder$13
  implements QueryCallback<EmoticonPackage>
{
  GuildMarketFaceItemBuilder$13(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, GuildMarketFaceItemBuilder.Holder paramHolder, QQProgressDialog paramQQProgressDialog) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ReportController.b(this.c.g, "CliOper", "", this.c.g.getCurrentAccountUin(), "ep_mall", "Clk_button_follow", 0, 0, "", "", this.a.a.getEmoticon().eId, "");
    if (paramEmoticonPackage == null)
    {
      this.c.z.a(107, this.c.g, this.c.o, this.a.a, this.c.c, GuildMarketFaceItemBuilder.a(this.c));
      this.c.r.getEmojiListenerManager().addEmotionJsonDownloadListener(this.c.z);
      this.c.r.startDownloadEmosmJson(this.a.a.getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    GuildMarketFaceItemBuilder.a(107, this.c.o, this.c.g, paramEmoticonPackage, this.a.a, this.c.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.13
 * JD-Core Version:    0.7.0.1
 */