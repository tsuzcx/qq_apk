package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.tail.GameTail;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.tail.IMsgTail;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class GuildTailProcessor
  implements IGuildTailProcessor
{
  protected GuildMsgItemLayout a;
  protected RelativeLayout b;
  protected Context c;
  protected AppRuntime d;
  protected ArrayList<IMsgTail> e;
  
  public GuildTailProcessor(AppRuntime paramAppRuntime, GuildMsgItemLayout paramGuildMsgItemLayout, Context paramContext)
  {
    this.a = paramGuildMsgItemLayout;
    this.c = paramContext;
    this.d = paramAppRuntime;
  }
  
  private void b()
  {
    if (this.e == null)
    {
      this.e = new ArrayList();
      this.e.add(new GameTail(this.c));
    }
  }
  
  public RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = this.b;
    if (localRelativeLayout != null) {
      return localRelativeLayout;
    }
    this.b = new RelativeLayout(this.c);
    return this.b;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.b == null) {
      return;
    }
    b();
    Object localObject = null;
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      IMsgTail localIMsgTail = (IMsgTail)localIterator.next();
      if ((localIMsgTail != null) && (localIMsgTail.a(paramChatMessage)) && ((localObject == null) || (localObject.a() < localIMsgTail.a()))) {
        localObject = localIMsgTail;
      }
    }
    if (localObject == null)
    {
      this.b.removeAllViews();
      this.b.setVisibility(8);
      return;
    }
    paramChatMessage = localObject.b(paramChatMessage);
    this.b.removeAllViews();
    if (paramChatMessage == null)
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.addView(paramChatMessage);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildTailProcessor
 * JD-Core Version:    0.7.0.1
 */