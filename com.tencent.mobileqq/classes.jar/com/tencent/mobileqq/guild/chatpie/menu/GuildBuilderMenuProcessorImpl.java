package com.tencent.mobileqq.guild.chatpie.menu;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildBuilderMenuProcessorImpl
  extends BaseBubbleBuilderMenuProcessor
  implements IBaseBubbleBuilderMenuAddProcessor, IBaseBubbleBuilderMenuClickProcessor
{
  private BaseBubbleBuilderMenuProcessor c;
  private List<BaseBubbleBuilderMenuProcessor> d;
  
  public GuildBuilderMenuProcessorImpl(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramSessionInfo);
  }
  
  private void b(int paramInt)
  {
    if (this.d == null)
    {
      this.d = new ArrayList();
      this.d.add(new GuildSelectMoreMenuProcessor(this.a, this.b));
      this.d.add(new GuildReplyMenuProcessor(this.a, this.b));
      this.d.add(new GuildRevokeMenuProcessor(this.a, this.b));
    }
    this.c = null;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = (BaseBubbleBuilderMenuProcessor)localIterator.next();
      if ((localBaseBubbleBuilderMenuProcessor != null) && (localBaseBubbleBuilderMenuProcessor.a(paramInt))) {
        this.c = localBaseBubbleBuilderMenuProcessor;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    b(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.c;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuClickProcessor)) {
      ((IBaseBubbleBuilderMenuClickProcessor)localBaseBubbleBuilderMenuProcessor).a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    b(paramInt);
    BaseBubbleBuilderMenuProcessor localBaseBubbleBuilderMenuProcessor = this.c;
    if ((localBaseBubbleBuilderMenuProcessor instanceof IBaseBubbleBuilderMenuAddProcessor)) {
      ((IBaseBubbleBuilderMenuAddProcessor)localBaseBubbleBuilderMenuProcessor).a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.c != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.menu.GuildBuilderMenuProcessorImpl
 * JD-Core Version:    0.7.0.1
 */