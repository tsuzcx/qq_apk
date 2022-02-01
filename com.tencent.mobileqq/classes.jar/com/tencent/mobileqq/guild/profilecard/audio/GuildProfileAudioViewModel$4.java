package com.tencent.mobileqq.guild.profilecard.audio;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

class GuildProfileAudioViewModel$4
  implements Observer<Integer>
{
  GuildProfileAudioViewModel$4(GuildProfileAudioViewModel paramGuildProfileAudioViewModel) {}
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 2)
    {
      paramInteger = new GuildAudioProfileDisplayData();
      int i;
      if (((GuildAudioChannelData)GuildProfileAudioViewModel.d(this.a).getValue()).f()) {
        i = 2131890243;
      } else {
        i = 2131890264;
      }
      paramInteger.a(i);
      if (((GuildAudioChannelData)GuildProfileAudioViewModel.d(this.a).getValue()).g()) {
        i = 2131890268;
      } else {
        i = 2131890256;
      }
      paramInteger.b(i);
      GuildProfileAudioViewModel.e(this.a).setValue(paramInteger);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel.4
 * JD-Core Version:    0.7.0.1
 */