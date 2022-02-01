package com.tencent.mobileqq.guild.chatpie.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;

public class GuildFocusChannelHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private GuildChatContext b;
  
  public GuildFocusChannelHelper(GuildChatContext paramGuildChatContext)
  {
    this.b = paramGuildChatContext;
    this.a = paramGuildChatContext.a();
  }
  
  private void a()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((GuildChatContext)localObject).O() != null))
    {
      localObject = this.a;
      if (localObject != null) {
        ((IGuildFocusChannelService)((QQAppInterface)localObject).getRuntimeService(IGuildFocusChannelService.class, "")).updateCurChannelId(this.b.O().c, this.b.O().b);
      }
    }
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      ((IGuildFocusChannelService)localQQAppInterface.getRuntimeService(IGuildFocusChannelService.class, "")).updateCurChannelId(null, null);
    }
  }
  
  public String getTag()
  {
    return "GuildFocusChannelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 15) {
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildFocusChannelHelper
 * JD-Core Version:    0.7.0.1
 */