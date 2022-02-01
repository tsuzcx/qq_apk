package com.tencent.mobileqq.guild.setting.popup;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.BaseApplication;

class GuildMainSettingViewModel$3
  implements IResultCallback
{
  GuildMainSettingViewModel$3(GuildMainSettingViewModel paramGuildMainSettingViewModel) {}
  
  public void onResult(int paramInt, String paramString)
  {
    paramString = new ShowToastModel();
    paramString.a(paramInt);
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramString.a(BaseApplication.getContext().getString(2131888467));
    } else {
      paramString.a(BaseApplication.getContext().getString(2131888466));
    }
    GuildMainSettingViewModel.d(this.a).setValue(paramString);
    if (paramInt != 0) {
      GuildMainSettingViewModel.e(this.a).setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMainSettingViewModel.3
 * JD-Core Version:    0.7.0.1
 */