package com.tencent.mobileqq.guild.profilecard.game;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;

class GuildProfileGameComponent$1
  implements Observer<GuildProfileGameingData>
{
  GuildProfileGameComponent$1(GuildProfileGameComponent paramGuildProfileGameComponent) {}
  
  public void a(GuildProfileGameingData paramGuildProfileGameingData)
  {
    if (paramGuildProfileGameingData == null)
    {
      GuildProfileGameComponent.access$000(this.a).setVisibility(8);
      GuildProfileGameComponent.access$100(this.a).setVisibility(8);
      GuildProfileGameComponent.access$200(this.a).setVisibility(8);
      return;
    }
    GuildProfileGameComponent.access$300(this.a).setVisibility(0);
    GuildProfileGameComponent.access$400(this.a, paramGuildProfileGameingData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameComponent.1
 * JD-Core Version:    0.7.0.1
 */