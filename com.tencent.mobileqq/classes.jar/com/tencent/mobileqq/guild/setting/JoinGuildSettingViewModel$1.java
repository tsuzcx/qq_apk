package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.qphone.base.util.QLog;

class JoinGuildSettingViewModel$1
  implements IGetAddGuildOptionCallback
{
  JoinGuildSettingViewModel$1(JoinGuildSettingViewModel paramJoinGuildSettingViewModel) {}
  
  public void a(int paramInt, String paramString, AddGuildOption paramAddGuildOption)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onGetAddGuildOptionResult ");
        paramString.append(paramAddGuildOption.toString());
        QLog.d("JoinGuildSettingViewModel", 4, paramString.toString());
      }
      if ((paramAddGuildOption != null) && (paramAddGuildOption.a != 0))
      {
        JoinGuildSettingViewModel.a(this.a).setValue(paramAddGuildOption);
        JoinGuildSettingViewModel.b(this.a).setValue(Integer.valueOf(paramAddGuildOption.a));
      }
      else
      {
        JoinGuildSettingViewModel.a(this.a).setValue(new AddGuildOption());
      }
      JoinGuildSettingViewModel.c(this.a).setValue(Boolean.valueOf(true));
      JoinGuildSettingViewModel.d(this.a).setValue(Boolean.valueOf(false));
      return;
    }
    paramAddGuildOption = new StringBuilder();
    paramAddGuildOption.append("getAddGuildOption failed ");
    paramAddGuildOption.append(paramInt);
    QLog.w("JoinGuildSettingViewModel", 1, paramAddGuildOption.toString());
    JoinGuildSettingViewModel.e(this.a).setValue(new BaseGuildViewModel.ToastEvent(paramInt, paramString));
    JoinGuildSettingViewModel.a(this.a).setValue(new AddGuildOption());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingViewModel.1
 * JD-Core Version:    0.7.0.1
 */