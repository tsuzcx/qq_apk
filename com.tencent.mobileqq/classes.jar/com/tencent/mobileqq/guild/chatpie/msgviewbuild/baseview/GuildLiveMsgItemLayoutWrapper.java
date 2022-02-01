package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildLiveMsgItemLayoutWrapper
  extends MsgItemLayoutWrapper
{
  private boolean b()
  {
    boolean bool = BaseChatItemLayout.ad;
    if ((this.a instanceof GuildLiveChannelMsgItemLayout)) {
      bool = ((GuildLiveChannelMsgItemLayout)this.a).d();
    }
    return bool;
  }
  
  protected void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      MsgItemLayoutWrapper.HighlightItem localHighlightItem = (MsgItemLayoutWrapper.HighlightItem)localIterator.next();
      if (localHighlightItem.b)
      {
        a(localHighlightItem.a);
        return;
      }
    }
    if (this.a != null)
    {
      int i;
      if (b()) {
        i = 2130840910;
      } else {
        i = 2130840907;
      }
      this.a.setBackgroundResource(i);
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    int i;
    if (b()) {
      i = 2130840911;
    } else {
      i = 2130840908;
    }
    if (paramInt == 1)
    {
      this.a.setBackgroundResource(i);
      return;
    }
    if (paramInt == 2) {
      this.a.setBackgroundResource(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveMsgItemLayoutWrapper
 * JD-Core Version:    0.7.0.1
 */