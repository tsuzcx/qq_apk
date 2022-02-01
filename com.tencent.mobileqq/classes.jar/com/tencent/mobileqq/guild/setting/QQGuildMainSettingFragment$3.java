package com.tencent.mobileqq.guild.setting;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildMainSettingFragment$3
  implements IResultWithSecurityCallback
{
  QQGuildMainSettingFragment$3(QQGuildMainSettingFragment paramQQGuildMainSettingFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      this.a.getActivity().finish();
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131889061), paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */