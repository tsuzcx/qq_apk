package com.tencent.mobileqq.guild.setting.popup;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

class GuildMainSettingViewModel$4
  implements IResultWithSecurityCallback
{
  GuildMainSettingViewModel$4(GuildMainSettingViewModel paramGuildMainSettingViewModel) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
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
      paramString.a(BaseApplication.getContext().getString(2131889062));
    }
    else
    {
      paramString.a(BaseApplication.getContext().getString(2131889061));
      paramString.a(paramIGProSecurityResult);
    }
    GuildMainSettingViewModel.d(this.a).setValue(paramString);
    if (paramInt != 0) {
      GuildMainSettingViewModel.e(this.a).setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingViewModel.4
 * JD-Core Version:    0.7.0.1
 */