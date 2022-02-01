package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildMarketFaceItemBuilder$16
  implements ActionSheet.OnButtonClickListener
{
  GuildMarketFaceItemBuilder$16(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, IPicEmoticonInfo paramIPicEmoticonInfo, ActionSheet paramActionSheet, MessageForMarketFace paramMessageForMarketFace) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ChatActivityFacade.a(this.d.g, this.d.o, this.d.c, this.a.getEmoticon(), this.c.uniseq);
      this.b.cancel();
      return;
    }
    boolean bool1;
    if (this.a.getEmoticon().jobType == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.a.getEmoticon().jobType == 3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.d.o, this.d.g.getAccount(), 8, this.a.getEmoticon().epId, bool1, bool2);
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.16
 * JD-Core Version:    0.7.0.1
 */