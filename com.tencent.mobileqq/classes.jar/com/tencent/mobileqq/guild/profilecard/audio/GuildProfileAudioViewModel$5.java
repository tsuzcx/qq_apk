package com.tencent.mobileqq.guild.profilecard.audio;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class GuildProfileAudioViewModel$5
  implements IKickChannelMemberCallback
{
  GuildProfileAudioViewModel$5(GuildProfileAudioViewModel paramGuildProfileAudioViewModel) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, List<IGProResultInfo> paramList)
  {
    paramString = new ShowToastModel();
    paramString.a(paramInt);
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramString.a(BaseApplication.getContext().getString(2131890499));
    }
    else
    {
      paramString.a(BaseApplication.getContext().getString(2131890498));
      paramString.a(paramIGProSecurityResult);
    }
    GuildProfileAudioViewModel.f(this.a).setValue(paramString);
    if (paramInt != 0) {
      GuildProfileAudioViewModel.c(this.a).setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel.5
 * JD-Core Version:    0.7.0.1
 */