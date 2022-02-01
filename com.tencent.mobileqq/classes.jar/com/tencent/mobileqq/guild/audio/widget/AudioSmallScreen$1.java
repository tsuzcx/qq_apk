package com.tencent.mobileqq.guild.audio.widget;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AudioSmallScreen$1
  implements View.OnClickListener
{
  AudioSmallScreen$1(AudioSmallScreen paramAudioSmallScreen) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    DIALOG_STATUS localDIALOG_STATUS = (DIALOG_STATUS)AudioRoomLiveData.a.a().getValue();
    if ((localDIALOG_STATUS != DIALOG_STATUS.DISMISS) && (localDIALOG_STATUS != DIALOG_STATUS.UNKNOWN)) {
      AudioRoomLiveData.a.a().setValue(DIALOG_STATUS.DISMISS);
    }
    ThreadManagerV2.getUIHandlerV2().post(new AudioSmallScreen.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen.1
 * JD-Core Version:    0.7.0.1
 */