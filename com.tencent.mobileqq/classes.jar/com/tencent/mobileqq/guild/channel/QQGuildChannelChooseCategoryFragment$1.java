package com.tencent.mobileqq.guild.channel;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelChooseCategoryFragment$1
  implements IGetChannelCategoryCallback
{
  QQGuildChannelChooseCategoryFragment$1(QQGuildChannelChooseCategoryFragment paramQQGuildChannelChooseCategoryFragment, String paramString) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      QQGuildChannelChooseCategoryFragment.a(this.b).a(this.a);
      QQGuildChannelChooseCategoryFragment.a(this.b, this.a);
      return;
    }
    QQGuildUtil.a(BaseApplication.getContext(), paramInt, BaseApplication.getContext().getString(2131890335), paramIGProSecurityResult);
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("setChannelCategory result=");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append(" errMsg=");
    paramIGProSecurityResult.append(paramString);
    QLog.w("QQGuildChannelListSettingFragment", 1, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelChooseCategoryFragment.1
 * JD-Core Version:    0.7.0.1
 */