package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.os.SystemClock;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildMixedMsgItemBuilder$4
  implements ActionSheet.OnButtonClickListener
{
  GuildMixedMsgItemBuilder$4(GuildMixedMsgItemBuilder paramGuildMixedMsgItemBuilder, MessageForMixedMsg paramMessageForMixedMsg, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      long l = SystemClock.uptimeMillis();
      if (l - this.c.a < 500L) {
        return;
      }
      paramView = this.c;
      paramView.a = l;
      paramView = (MixedMsgManager)paramView.g.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      this.c.g.getMessageFacade().h(this.a.frienduin, this.a.istroop, this.a.uniseq);
      paramView.a(this.c.c, this.a, true);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMixedMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */