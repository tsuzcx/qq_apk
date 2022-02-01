package com.tencent.mobileqq.guild.profilecard.game;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.widget.GloryOfKingRecordView;

class GuildProfileGameComponent$2
  implements Observer<GuildProfileGameGloryKingData>
{
  GuildProfileGameComponent$2(GuildProfileGameComponent paramGuildProfileGameComponent) {}
  
  public void a(GuildProfileGameGloryKingData paramGuildProfileGameGloryKingData)
  {
    if (paramGuildProfileGameGloryKingData == null)
    {
      GuildProfileGameComponent.access$500(this.a).setVisibility(8);
      if (GuildProfileGameComponent.access$600(this.a) != null) {
        GuildProfileGameComponent.access$600(this.a).setVisibility(8);
      }
      return;
    }
    GuildProfileGameComponent.access$700(this.a).setVisibility(0);
    GuildProfileGameComponent.access$800(this.a);
    GuildProfileGameComponent.access$900(this.a).findViewById(2131434743).setVisibility(0);
    GuildProfileGameComponent.access$600(this.a).a(paramGuildProfileGameGloryKingData, GuildProfileGameComponent.access$1000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameComponent.2
 * JD-Core Version:    0.7.0.1
 */