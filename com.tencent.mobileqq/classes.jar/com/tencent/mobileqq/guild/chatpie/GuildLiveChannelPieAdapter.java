package com.tencent.mobileqq.guild.chatpie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar;
import java.util.Iterator;
import java.util.List;

public class GuildLiveChannelPieAdapter
  extends GuildPieAdapter
{
  private ChatMessage s;
  
  public GuildLiveChannelPieAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.f = new GuildLiveChannelPieAdapter.GuildLiveBubbleOnLongClickListener(this);
  }
  
  private void d(List<ChatMessage> paramList)
  {
    i();
    int i = e(paramList);
    if (this.s.shmsgseq == 0L) {
      if (paramList.size() == 0) {
        this.s.shmsgseq = BaseAioMsgNavigateBar.b;
      } else {
        this.s.shmsgseq = (((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq + 1L);
      }
    }
    paramList.add(i, this.s);
  }
  
  private int e(@NonNull List<ChatMessage> paramList)
  {
    int j = paramList.size();
    int k;
    for (int i = paramList.size() - 1; i >= 0; i = k)
    {
      if (((ChatMessage)paramList.get(i)).time <= this.s.time) {
        return j;
      }
      k = i - 1;
      j = i;
    }
    return j;
  }
  
  private void i()
  {
    if (this.s == null) {
      this.s = ((IGuildLiveChannelApi)QRoute.api(IGuildLiveChannelApi.class)).createSecurityMsg(this.q);
    }
  }
  
  protected void a(int paramInt, ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage.setIsNeedCombine(false);
  }
  
  protected void b(List<ChatMessage> paramList)
  {
    d(paramList);
  }
  
  public void c(List<ChatMessage> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((ChatMessage)localIterator.next() instanceof IMessageRecordForGuildWelcome))
      {
        i = 1;
        break label38;
      }
    }
    int i = 0;
    label38:
    if (i == 0) {
      d(paramList);
    }
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    boolean bool = super.c(paramChatMessage);
    int i = GuildMsgItemBuildFactory.a(this.b, paramChatMessage);
    return (bool) || (i == GuildMsgItemBuildFactory.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChannelPieAdapter
 * JD-Core Version:    0.7.0.1
 */