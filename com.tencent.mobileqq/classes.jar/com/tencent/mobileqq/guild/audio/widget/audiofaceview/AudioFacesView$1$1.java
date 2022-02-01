package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet.ActionSheetListener;

class AudioFacesView$1$1
  implements GuildShareActionSheet.ActionSheetListener
{
  AudioFacesView$1$1(AudioFacesView.1 param1) {}
  
  public void a() {}
  
  public void b()
  {
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.REOPEN);
  }
  
  public void c()
  {
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.REOPEN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView.1.1
 * JD-Core Version:    0.7.0.1
 */