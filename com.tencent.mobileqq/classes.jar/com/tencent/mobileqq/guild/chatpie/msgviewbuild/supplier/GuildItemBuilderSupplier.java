package com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;

public abstract class GuildItemBuilderSupplier<T extends ChatItemBuilder>
{
  protected Context a;
  protected QQAppInterface b;
  protected SessionInfo c;
  protected BaseChatPie d;
  protected AIOAnimationConatiner e;
  private T f;
  
  private void c()
  {
    ChatItemBuilder localChatItemBuilder = this.f;
    if ((localChatItemBuilder instanceof BaseGuildMsgViewBuild)) {
      ((BaseGuildMsgViewBuild)localChatItemBuilder).a(b());
    }
  }
  
  protected abstract T a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter);
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.c = paramSessionInfo;
    this.d = paramBaseChatPie;
    this.e = paramAIOAnimationConatiner;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public T b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (this.f == null)
    {
      this.f = a(paramChatMessage, paramBaseAdapter);
      c();
    }
    return this.f;
  }
  
  protected boolean b()
  {
    return this.d instanceof GuildLiveChannelChatPie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildItemBuilderSupplier
 * JD-Core Version:    0.7.0.1
 */