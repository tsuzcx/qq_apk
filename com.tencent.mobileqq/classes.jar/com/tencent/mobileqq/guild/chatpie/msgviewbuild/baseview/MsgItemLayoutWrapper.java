package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class MsgItemLayoutWrapper
{
  protected View a;
  protected ArrayList<MsgItemLayoutWrapper.HighlightItem> b = new ArrayList();
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.b.remove(new MsgItemLayoutWrapper.HighlightItem(this, paramInt, paramBoolean));
    this.b.add(new MsgItemLayoutWrapper.HighlightItem(this, paramInt, paramBoolean));
  }
  
  private void b(Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramContext != null)
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment();
      if (paramContext != null)
      {
        paramContext = paramContext.k();
        if (paramContext != null)
        {
          paramContext = ((GuildMsgMenuHelper)paramContext.q(156)).a();
          if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq))
          {
            a(1, true);
            return;
          }
        }
      }
    }
    a(1, false);
  }
  
  protected void a()
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgItemLayoutWrapper.HighlightItem localHighlightItem = (MsgItemLayoutWrapper.HighlightItem)((Iterator)localObject).next();
      if (localHighlightItem.b)
      {
        a(localHighlightItem.a);
        return;
      }
    }
    localObject = this.a;
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(0);
    }
  }
  
  protected void a(int paramInt)
  {
    View localView = this.a;
    if (localView == null) {
      return;
    }
    if (paramInt == 1)
    {
      localView.setBackgroundColor(-986378);
      return;
    }
    if (paramInt == 2) {
      localView.setBackgroundColor(-921103);
    }
  }
  
  public void a(Context paramContext, ChatMessage paramChatMessage)
  {
    b(paramContext, paramChatMessage);
    a();
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.MsgItemLayoutWrapper
 * JD-Core Version:    0.7.0.1
 */