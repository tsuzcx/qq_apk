package com.tencent.mobileqq.guild.chatpie.clickprocessor;

import android.view.View;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.live.IQQGuildLiveAIOListener;
import mqq.util.WeakReference;

public class LiveChannelInputBarBtnClickCallback
  extends InputBarBtnClickCallback
{
  private WeakReference<IQQGuildLiveAIOListener> a;
  
  public void a(WeakReference<IQQGuildLiveAIOListener> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  protected void b(View paramView, GuildChatContext paramGuildChatContext)
  {
    paramGuildChatContext.L();
    paramView = this.a;
    if ((paramView != null) && (paramView.get() != null)) {
      ((IQQGuildLiveAIOListener)this.a.get()).ct_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.clickprocessor.LiveChannelInputBarBtnClickCallback
 * JD-Core Version:    0.7.0.1
 */