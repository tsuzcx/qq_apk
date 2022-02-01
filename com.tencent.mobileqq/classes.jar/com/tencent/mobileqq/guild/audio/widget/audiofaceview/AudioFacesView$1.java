package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.share.GuildShareActionSheet;
import com.tencent.qphone.base.util.QLog;

class AudioFacesView$1
  implements FaceAdapter.OnItemClickListener
{
  AudioFacesView$1(AudioFacesView paramAudioFacesView) {}
  
  public void a(int paramInt1, View paramView, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onItemClick ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.i("AudioFacesView", 2, ((StringBuilder)localObject).toString());
    if (System.currentTimeMillis() - AudioFacesView.a(this.a) < 500L)
    {
      AudioFacesView.a(this.a, System.currentTimeMillis());
      return;
    }
    AudioFacesView.a(this.a, System.currentTimeMillis());
    if (paramInt2 == FaceAdapter.a)
    {
      if (new GuildShareActionSheet((Activity)this.a.getContext(), AudioFacesView.b(this.a), AudioFacesView.c(this.a)).a(new AudioFacesView.1.1(this))) {
        AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.HIDE);
      }
    }
    else
    {
      AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.HIDE);
      localObject = (UserInfo)paramView.getTag();
      AudioFacesView.a(this.a, paramView, (UserInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView.1
 * JD-Core Version:    0.7.0.1
 */