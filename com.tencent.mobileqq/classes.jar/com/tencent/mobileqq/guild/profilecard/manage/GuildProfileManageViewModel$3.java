package com.tencent.mobileqq.guild.profilecard.manage;

import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.OperateMemberResult;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class GuildProfileManageViewModel$3
  implements IResultWithSecurityCallback
{
  GuildProfileManageViewModel$3(GuildProfileManageViewModel paramGuildProfileManageViewModel, boolean paramBoolean, String paramString) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetGuildUserTypeResult result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      QLog.i("GuildManageProfileViewModel", 1, localStringBuilder.toString());
    }
    paramString = new ShowToastModel();
    paramString.a(paramInt);
    if ((paramInt == 0) && (((IGuildInfoUtilsApi)QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(paramIGProSecurityResult)))
    {
      if (this.a)
      {
        paramString.a(BaseApplication.getContext().getString(2131890558));
        paramIGProSecurityResult = new QQGuildMemberFragment.OperateMemberResult(2, this.b);
        GuildProfileManageViewModel.d(this.c).setValue(paramIGProSecurityResult);
      }
      else
      {
        paramString.a(BaseApplication.getContext().getString(2131890560));
        paramIGProSecurityResult = new QQGuildMemberFragment.OperateMemberResult(3, this.b);
        GuildProfileManageViewModel.d(this.c).setValue(paramIGProSecurityResult);
      }
      GuildProfileManageViewModel.e(this.c).setValue(paramString);
      return;
    }
    paramIGProSecurityResult = BaseApplication.getContext();
    if (this.a) {
      paramInt = 2131890557;
    } else {
      paramInt = 2131890559;
    }
    paramString.a(paramIGProSecurityResult.getString(paramInt));
    GuildProfileManageViewModel.c(this.c).setValue(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileManageViewModel.3
 * JD-Core Version:    0.7.0.1
 */