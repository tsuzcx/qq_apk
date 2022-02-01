package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

final class GuildMarketFaceItemBuilder$9
  implements DialogInterface.OnClickListener
{
  GuildMarketFaceItemBuilder$9(Emoticon paramEmoticon, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool;
    if (this.a.jobType == 4) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.b, this.c.getAccount(), 8, this.a.epId, false, bool);
    if (GuildMarketFaceItemBuilder.l != null) {
      paramInt = this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */