package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

class GuildFacadeTopFrameController$1
  implements Runnable
{
  GuildFacadeTopFrameController$1(GuildFacadeTopFrameController paramGuildFacadeTopFrameController) {}
  
  public void run()
  {
    Context localContext = GuildFacadeTopFrameController.a(this.this$0).getContentView().getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      GuildFacadeTopFrameController.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeTopFrameController.1
 * JD-Core Version:    0.7.0.1
 */