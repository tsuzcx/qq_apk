package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.profilecard.baseprofile.card.GuildProfileCard.CardShowListener;

class AudioFacesView$2
  implements GuildProfileCard.CardShowListener
{
  AudioFacesView$2(AudioFacesView paramAudioFacesView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.REOPEN);
      return;
    }
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.UNKNOWN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView.2
 * JD-Core Version:    0.7.0.1
 */