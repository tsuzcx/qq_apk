package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieFoldStatusListener;
import com.tencent.mobileqq.guild.chatpie.GuildHelperProvider;

public class GuildAppAuthorHelper
  implements ILifeCycleHelper
{
  private GuildChatContext a;
  private GuildChatPieFoldStatusListener b = new GuildAppAuthorHelper.1(this);
  
  public GuildAppAuthorHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildAppAuthorHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 4, 7, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      ((GuildHelperProvider)this.a.d()).b(this.b);
      return;
    }
    ((GuildHelperProvider)this.a.d()).a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildAppAuthorHelper
 * JD-Core Version:    0.7.0.1
 */