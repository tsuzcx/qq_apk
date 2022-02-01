package com.tencent.mobileqq.guild.profilecard.audio;

import android.widget.TextView;
import androidx.lifecycle.Observer;

class GuildProfileAudioComponent$1
  implements Observer<GuildAudioProfileDisplayData>
{
  GuildProfileAudioComponent$1(GuildProfileAudioComponent paramGuildProfileAudioComponent) {}
  
  public void a(GuildAudioProfileDisplayData paramGuildAudioProfileDisplayData)
  {
    GuildProfileAudioComponent.access$000(this.a).setText(paramGuildAudioProfileDisplayData.a());
    GuildProfileAudioComponent.access$100(this.a).setText(paramGuildAudioProfileDisplayData.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent.1
 * JD-Core Version:    0.7.0.1
 */