package com.tencent.mobileqq.guild.live.widget;

import com.tencent.qphone.base.util.QLog;

class GuildLiveSwipeBackLayout$1
  implements Runnable
{
  GuildLiveSwipeBackLayout$1(GuildLiveSwipeBackLayout paramGuildLiveSwipeBackLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFling:");
      localStringBuilder.append(this.this$0.m);
      QLog.d("GuildLiveSwipeBackLayout", 2, localStringBuilder.toString());
    }
    if (!this.this$0.m) {
      this.this$0.d();
    }
    if (GuildLiveSwipeBackLayout.b(this.this$0) != null) {
      GuildLiveSwipeBackLayout.b(this.this$0).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */