package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfoForUpdate;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class GuildEventFlowHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private final GuildChatContext a;
  private final QQAppInterface b;
  private boolean c = false;
  private int d = -1;
  private int e = -1;
  
  public GuildEventFlowHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
    this.b = paramGuildChatContext.a();
  }
  
  private void a() {}
  
  private void a(int paramInt1, int paramInt2)
  {
    List localList = this.a.n().V.a();
    int j = localList.size();
    if ((localList != null) && (j > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramInt1;
      while (i < paramInt1 + paramInt2)
      {
        if (i < j)
        {
          ChatMessage localChatMessage = (ChatMessage)localList.get(i);
          if ((localChatMessage != null) && (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(localChatMessage)))
          {
            GuildMsgEventInfoForUpdate localGuildMsgEventInfoForUpdate = new GuildMsgEventInfoForUpdate();
            localGuildMsgEventInfoForUpdate.a = localChatMessage.shmsgseq;
            localGuildMsgEventInfoForUpdate.b = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getEventFlow(localChatMessage);
            if (!localArrayList.contains(localGuildMsgEventInfoForUpdate)) {
              localArrayList.add(localGuildMsgEventInfoForUpdate);
            }
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0) {
        ((IGuildEventFlowService)this.a.a().getRuntimeService(IGuildEventFlowService.class)).onChatMessageExposure(this.a.S(), this.a.T(), localArrayList);
      }
    }
  }
  
  private void b() {}
  
  private void c()
  {
    this.c = true;
    ChatXListView localChatXListView = this.a.n().U;
    int i = localChatXListView.getFirstVisiblePosition();
    int j = localChatXListView.getChildCount();
    this.d = i;
    this.e = j;
    a(i, j);
  }
  
  private void d()
  {
    this.c = false;
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildEventFlowHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          d();
          return;
        }
        c();
        return;
      }
      b();
      return;
    }
    a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.c) {
      return;
    }
    if ((paramInt1 == this.d) && (this.e == paramInt2)) {
      return;
    }
    this.d = paramInt1;
    this.e = paramInt2;
    a(paramInt1, paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildEventFlowHelper
 * JD-Core Version:    0.7.0.1
 */