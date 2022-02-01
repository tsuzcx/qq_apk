package com.tencent.mobileqq.guild.channel;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

class QQGuildChannelModidyCategoryFragment$3
  implements IGetChannelCategoryCallback
{
  QQGuildChannelModidyCategoryFragment$3(QQGuildChannelModidyCategoryFragment paramQQGuildChannelModidyCategoryFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890307));
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    else
    {
      if (paramInt == -7)
      {
        QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890272), paramIGProSecurityResult);
        return;
      }
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890335), paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelModidyCategoryFragment.3
 * JD-Core Version:    0.7.0.1
 */