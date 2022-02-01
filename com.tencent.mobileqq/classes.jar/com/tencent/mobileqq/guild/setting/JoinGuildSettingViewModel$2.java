package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import mqq.app.MobileQQ;

class JoinGuildSettingViewModel$2
  implements IResultWithSecurityCallback
{
  JoinGuildSettingViewModel$2(JoinGuildSettingViewModel paramJoinGuildSettingViewModel) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0)
    {
      JoinGuildSettingViewModel.d(this.a).setValue(Boolean.valueOf(true));
      paramString = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(2131890400);
      JoinGuildSettingViewModel.e(this.a).setValue(new BaseGuildViewModel.ToastEvent(paramInt, paramString, paramIGProSecurityResult));
      return;
    }
    JoinGuildSettingViewModel.e(this.a).setValue(new BaseGuildViewModel.ToastEvent(paramInt, paramString, paramIGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingViewModel.2
 * JD-Core Version:    0.7.0.1
 */