package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayout;

public class GuildLiveMsgMenuHelper
  extends GuildMsgMenuHelper
{
  public GuildLiveMsgMenuHelper(GuildChatContext paramGuildChatContext)
  {
    super(paramGuildChatContext);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    ChatXListView localChatXListView = this.a.n().U;
    if (localChatXListView == null) {
      return;
    }
    int j = localChatXListView.getChildCount();
    int i = 0;
    View localView = null;
    while (i < j)
    {
      localView = localChatXListView.getChildAt(i);
      if (localView.getBottom() > paramMotionEvent.getY()) {
        break;
      }
      i += 1;
    }
    i = GuildLiveChannelMsgItemLayout.b;
    j = GuildLiveChannelMsgItemLayout.a;
    if ((localView != null) && (paramMotionEvent.getY() <= localView.getBottom() - j) && (paramMotionEvent.getY() >= localView.getTop() + j) && (paramMotionEvent.getX() <= localView.getRight() - i))
    {
      if (paramMotionEvent.getX() < localView.getLeft() + i) {
        return;
      }
      this.a.n().V.f.onLongClick(localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildLiveMsgMenuHelper
 * JD-Core Version:    0.7.0.1
 */