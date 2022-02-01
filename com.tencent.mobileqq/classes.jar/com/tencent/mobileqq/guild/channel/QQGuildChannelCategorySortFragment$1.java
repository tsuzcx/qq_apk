package com.tencent.mobileqq.guild.channel;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelCategorySortFragment$1
  implements IGetChannelCategoryCallback
{
  QQGuildChannelCategorySortFragment$1(QQGuildChannelCategorySortFragment paramQQGuildChannelCategorySortFragment) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      if (this.a.getActivity() == null) {
        return;
      }
      this.a.getActivity().setResult(-1);
      this.a.getActivity().finish();
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890335), paramIGProSecurityResult);
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("setChannelCategoryOrder error ");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append(" msg=");
    paramIGProSecurityResult.append(paramString);
    QLog.w("QQGuildCustomTitleBarFragment", 1, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelCategorySortFragment.1
 * JD-Core Version:    0.7.0.1
 */