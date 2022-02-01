package com.tencent.mobileqq.guild.profilecard.manage;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.OperateMemberResult;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

class GuildProfileManageViewModel$4
  implements IResultWithSecurityCallback
{
  GuildProfileManageViewModel$4(GuildProfileManageViewModel paramGuildProfileManageViewModel, String paramString) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = new ShowToastModel();
    paramString.a(paramInt);
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      paramString.a(BaseApplication.getContext().getString(2131890499));
      GuildProfileManageViewModel.b(this.b).setValue(Boolean.valueOf(true));
      paramIGProSecurityResult = new QQGuildMemberFragment.OperateMemberResult(1, this.a);
      GuildProfileManageViewModel.d(this.b).setValue(paramIGProSecurityResult);
    }
    else
    {
      paramString.a(BaseApplication.getContext().getString(2131890498));
      paramString.a(paramIGProSecurityResult);
    }
    GuildProfileManageViewModel.e(this.b).setValue(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageViewModel.4
 * JD-Core Version:    0.7.0.1
 */