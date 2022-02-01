package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class GuildRedPointHelper
  implements ILifeCycleHelper
{
  private GuildChatContext a;
  private View b = null;
  
  public GuildRedPointHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
  }
  
  private void a()
  {
    GuildChatContext localGuildChatContext = this.a;
    if (localGuildChatContext != null)
    {
      if (localGuildChatContext.s() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildRedPointHelper", 2, "onShowFirstBegin guild");
      }
      this.b = this.a.s().findViewById(2131436194);
    }
  }
  
  private void b()
  {
    View localView = this.b;
    if (localView != null) {
      localView.setOnClickListener(null);
    }
  }
  
  @NotNull
  public String getTag()
  {
    return "GuildRedPointHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
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
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildRedPointHelper
 * JD-Core Version:    0.7.0.1
 */