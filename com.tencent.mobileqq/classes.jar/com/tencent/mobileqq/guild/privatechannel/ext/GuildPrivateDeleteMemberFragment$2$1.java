package com.tencent.mobileqq.guild.privatechannel.ext;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GuildPrivateDeleteMemberFragment$2$1
  implements IResultWithSecurityCallback
{
  GuildPrivateDeleteMemberFragment$2$1(GuildPrivateDeleteMemberFragment.2 param2) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt != 0) || (!QQGuildUtil.a(paramIGProSecurityResult))) {
      QQGuildUtil.a(this.a.a.getActivity(), paramInt, paramString, paramIGProSecurityResult);
    }
    if ((paramInt == 10006) || (paramInt == 10000)) {
      GuildPrivateDeleteMemberFragment.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateDeleteMemberFragment.2.1
 * JD-Core Version:    0.7.0.1
 */