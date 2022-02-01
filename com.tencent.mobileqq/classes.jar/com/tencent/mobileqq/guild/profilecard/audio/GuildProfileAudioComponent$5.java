package com.tencent.mobileqq.guild.profilecard.audio;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class GuildProfileAudioComponent$5
  implements Observer<ShowToastModel>
{
  GuildProfileAudioComponent$5(GuildProfileAudioComponent paramGuildProfileAudioComponent) {}
  
  public void a(ShowToastModel paramShowToastModel)
  {
    if (TextUtils.isEmpty(paramShowToastModel.a())) {
      return;
    }
    if (paramShowToastModel.b())
    {
      QQGuildUtil.c(paramShowToastModel.a());
      return;
    }
    QQGuildUtil.a(GuildProfileAudioComponent.access$900(this.a).getContext(), paramShowToastModel.c(), paramShowToastModel.a(), paramShowToastModel.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent.5
 * JD-Core Version:    0.7.0.1
 */