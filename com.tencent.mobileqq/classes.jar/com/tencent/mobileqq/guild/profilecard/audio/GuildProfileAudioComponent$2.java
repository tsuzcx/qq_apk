package com.tencent.mobileqq.guild.profilecard.audio;

import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.utils.ViewUtils;

class GuildProfileAudioComponent$2
  implements Observer<Boolean>
{
  GuildProfileAudioComponent$2(GuildProfileAudioComponent paramGuildProfileAudioComponent) {}
  
  public void a(Boolean paramBoolean)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)GuildProfileAudioComponent.access$200(this.a).getLayoutParams();
    if (paramBoolean.booleanValue()) {
      localMarginLayoutParams.bottomMargin = ViewUtils.dip2px(12.0F);
    } else {
      localMarginLayoutParams.bottomMargin = ViewUtils.dip2px(24.0F);
    }
    GuildProfileAudioComponent.access$300(this.a).setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioComponent.2
 * JD-Core Version:    0.7.0.1
 */