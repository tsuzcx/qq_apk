package com.tencent.mobileqq.guild.channel;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildChannelCreateCategoryFragment$1
  implements IGetChannelCategoryCallback
{
  QQGuildChannelCreateCategoryFragment$1(QQGuildChannelCreateCategoryFragment paramQQGuildChannelCreateCategoryFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890281));
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    else
    {
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890335), paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelCreateCategoryFragment.1
 * JD-Core Version:    0.7.0.1
 */