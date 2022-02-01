package com.tencent.mobileqq.guild.joinguild;

import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class JoinGuildCheckOptionLogic$2
  implements IGetAddGuildOptionCallback
{
  JoinGuildCheckOptionLogic$2(JoinGuildCheckOptionLogic paramJoinGuildCheckOptionLogic, IResultWithSecurityCallback paramIResultWithSecurityCallback, JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction) {}
  
  public void a(int paramInt, String paramString, AddGuildOption paramAddGuildOption)
  {
    if (paramInt != 0)
    {
      paramAddGuildOption = new StringBuilder();
      paramAddGuildOption.append("getAddGuildOption getAddGuildOption=");
      paramAddGuildOption.append(JoinGuildCheckOptionLogic.b(this.c).a);
      paramAddGuildOption.append(" result=");
      paramAddGuildOption.append(paramInt);
      paramAddGuildOption.append(" errMsg=");
      paramAddGuildOption.append(paramString);
      QLog.w("JoinGuildLogic", 1, paramAddGuildOption.toString());
      JoinGuildCheckOptionLogic.a(this.c, this.a, paramInt, BaseApplication.getContext().getString(2131890217), null);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getAddGuildOption result=");
      paramString.append(paramAddGuildOption);
      QLog.i("JoinGuildLogic", 1, paramString.toString());
    }
    if (paramAddGuildOption == null)
    {
      paramString = this.c;
      JoinGuildCheckOptionLogic.a(paramString, this.b, JoinGuildCheckOptionLogic.b(paramString), JoinGuildCheckOptionLogic.c(this.c), JoinGuildCheckOptionLogic.d(this.c), this.a);
      return;
    }
    JoinGuildCheckOptionLogic.a(this.c, paramAddGuildOption);
    JoinGuildCheckOptionLogic.a(this.c, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.2
 * JD-Core Version:    0.7.0.1
 */