package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildFragmentUnreadTask;
import com.tencent.mobileqq.guild.chatpie.GuildHelperProvider;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData;

public class GuildGestureListenerHelper
  implements ILifeCycleHelper
{
  protected GuildChatPie a;
  private AbsGestureListener b = new GuildGestureListenerHelper.1(this);
  
  public GuildGestureListenerHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = ((GuildChatPie)paramBaseChatPie);
  }
  
  private void a(NotifyData paramNotifyData)
  {
    if (paramNotifyData.a() == 3)
    {
      if (paramNotifyData.b() == 0)
      {
        ((GuildHelperProvider)this.a.bv().d()).a(true, paramNotifyData.d(), paramNotifyData.e());
        return;
      }
      if (paramNotifyData.b() == 1000) {
        ((GuildHelperProvider)this.a.bv().d()).a(false, paramNotifyData.d(), paramNotifyData.e());
      }
    }
  }
  
  private void b(NotifyData paramNotifyData)
  {
    if ((paramNotifyData.c() == 1) && (paramNotifyData.a() == 1)) {
      this.a.as();
    }
  }
  
  private void c(NotifyData paramNotifyData)
  {
    if (paramNotifyData.a() == 3)
    {
      if (paramNotifyData.b() == 1000)
      {
        this.a.bI();
        return;
      }
      if (paramNotifyData.d() == 4)
      {
        this.a.bG();
        return;
      }
      if ((paramNotifyData.b() == 0) && (paramNotifyData.e() == 2))
      {
        this.a.bH();
        this.a.bG();
      }
    }
    else if ((paramNotifyData.a() == 1) && (paramNotifyData.c() == 2))
    {
      this.a.bH();
    }
  }
  
  private void d(NotifyData paramNotifyData)
  {
    if (paramNotifyData.a() == 3)
    {
      GuildFragmentUnreadTask localGuildFragmentUnreadTask = ((GuildChatContext)this.a.bv()).P();
      if (paramNotifyData.b() == 0)
      {
        this.a.bE();
        localGuildFragmentUnreadTask.a();
        return;
      }
      if (paramNotifyData.b() == 1000)
      {
        this.a.bF();
        if ((paramNotifyData.d() == 2) && ((paramNotifyData.e() == 1) || (paramNotifyData.e() == 3))) {
          localGuildFragmentUnreadTask.c();
        }
      }
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildGestureListenerHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.a.b(this.b);
      return;
    }
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildGestureListenerHelper
 * JD-Core Version:    0.7.0.1
 */