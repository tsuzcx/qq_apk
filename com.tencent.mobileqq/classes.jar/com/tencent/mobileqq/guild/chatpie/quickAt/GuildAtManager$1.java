package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;

class GuildAtManager$1
  implements View.OnTouchListener
{
  GuildAtManager$1(GuildAtManager paramGuildAtManager, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() == 4) && (AtPanelTouchController.a(this.a, paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtManager.1
 * JD-Core Version:    0.7.0.1
 */