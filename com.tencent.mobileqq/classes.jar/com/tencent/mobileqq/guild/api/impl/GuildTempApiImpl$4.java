package com.tencent.mobileqq.guild.api.impl;

import android.view.ViewTreeObserver;
import android.widget.TabWidget;

class GuildTempApiImpl$4
  implements Runnable
{
  GuildTempApiImpl$4(GuildTempApiImpl paramGuildTempApiImpl, TabWidget paramTabWidget) {}
  
  private void a()
  {
    try
    {
      if (GuildTempApiImpl.access$300(this.this$0) != null)
      {
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(GuildTempApiImpl.access$300(this.this$0));
        GuildTempApiImpl.access$302(this.this$0, null);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTempApiImpl.4
 * JD-Core Version:    0.7.0.1
 */