package com.tencent.mobileqq.guild.chatpie.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.widget.DrawerFrame;

public class GuildDrawerFrameHelper
  implements ILifeCycleHelper
{
  protected BaseChatPie a;
  
  public GuildDrawerFrameHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (ChatDrawerHelper)((BaseChatPie)localObject).q(124);
      if ((localObject != null) && (((ChatDrawerHelper)localObject).a != null)) {
        ((ChatDrawerHelper)localObject).a.setDrawerEnabled(false);
      }
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildDrawerFrameHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildDrawerFrameHelper
 * JD-Core Version:    0.7.0.1
 */