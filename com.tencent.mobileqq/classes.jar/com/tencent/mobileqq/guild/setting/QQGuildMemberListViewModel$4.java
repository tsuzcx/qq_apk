package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildMemberListViewModel$4
  implements IResultWithSecurityCallback
{
  QQGuildMemberListViewModel$4(QQGuildMemberListViewModel paramQQGuildMemberListViewModel, boolean paramBoolean, IGProUserInfo paramIGProUserInfo) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (this.c.a) {
      return;
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      if (this.a)
      {
        this.c.m.setValue(this.b);
        QQGuildUtil.c(BaseApplication.getContext().getString(2131890579));
        return;
      }
      this.c.n.setValue(this.b);
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890596));
      return;
    }
    if (this.a)
    {
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890589), paramIGProSecurityResult);
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890595), paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel.4
 * JD-Core Version:    0.7.0.1
 */