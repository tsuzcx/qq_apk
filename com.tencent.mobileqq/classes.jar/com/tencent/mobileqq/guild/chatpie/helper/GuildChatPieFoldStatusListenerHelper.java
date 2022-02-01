package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieFoldStatusListener;
import org.jetbrains.annotations.NotNull;

public class GuildChatPieFoldStatusListenerHelper
  implements ILifeCycleHelper, GuildChatPieFoldStatusListener
{
  protected GuildChatPie a;
  
  public GuildChatPieFoldStatusListenerHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = ((GuildChatPie)paramBaseChatPie);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    return AIOSelectableDelegateImpl.a().l();
  }
  
  @NonNull
  @NotNull
  public String getTag()
  {
    return "GuildChatPieFoldStatusListenerHelper";
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
      this.a.b(this);
      return;
    }
    this.a.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildChatPieFoldStatusListenerHelper
 * JD-Core Version:    0.7.0.1
 */