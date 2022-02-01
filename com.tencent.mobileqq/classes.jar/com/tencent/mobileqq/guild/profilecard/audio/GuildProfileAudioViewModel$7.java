package com.tencent.mobileqq.guild.profilecard.audio;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.BaseApplication;

class GuildProfileAudioViewModel$7
  implements IResultCallback
{
  GuildProfileAudioViewModel$7(GuildProfileAudioViewModel paramGuildProfileAudioViewModel) {}
  
  public void onResult(int paramInt, String paramString)
  {
    paramString = new ShowToastModel();
    paramString.a(paramInt);
    if (paramInt != 0)
    {
      paramString.a(BaseApplication.getContext().getString(2131890262));
      GuildProfileAudioViewModel.f(this.a).setValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel.7
 * JD-Core Version:    0.7.0.1
 */