package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class GuildFileBaseBubblePauseHandler$1
  implements View.OnClickListener
{
  GuildFileBaseBubblePauseHandler$1(GuildFileBaseBubblePauseHandler paramGuildFileBaseBubblePauseHandler) {}
  
  public void onClick(View paramView)
  {
    ChatItemBuilder.BaseHolder localBaseHolder = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    if (localBaseHolder != null)
    {
      int i = -1;
      ChatMessage localChatMessage = FileManagerUtil.b(localBaseHolder.q);
      if (this.a.a(localChatMessage)) {
        i = 0;
      } else if (this.a.b(localChatMessage)) {
        i = 1;
      }
      this.a.a(paramView, localBaseHolder, localChatMessage, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileBaseBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */