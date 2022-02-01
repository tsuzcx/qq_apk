package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class QQGuildMemberListViewModel$3
  implements IResultWithSecurityCallback
{
  QQGuildMemberListViewModel$3(QQGuildMemberListViewModel paramQQGuildMemberListViewModel, List paramList, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (this.c.a) {
      return;
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      this.c.o.setValue(this.a);
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890499));
    }
    else
    {
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890498), paramIGProSecurityResult);
    }
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.b;
    if (localIResultWithSecurityCallback != null) {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel.3
 * JD-Core Version:    0.7.0.1
 */