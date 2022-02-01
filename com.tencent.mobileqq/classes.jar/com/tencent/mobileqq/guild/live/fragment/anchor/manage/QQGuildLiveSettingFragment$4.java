package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQGuildLiveSettingFragment$4
  implements IGetVisibleMemberListCallback
{
  QQGuildLiveSettingFragment$4(QQGuildLiveSettingFragment paramQQGuildLiveSettingFragment, boolean paramBoolean) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    QQGuildLiveSettingFragment.a(this.b, false);
    if (QQGuildLiveSettingFragment.a(this.b))
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, "fetchVisibleMembers: illegalStatus");
      return;
    }
    if (paramInt1 != 0)
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchVisibleMembers failed: result=", Integer.valueOf(paramInt1), ", errMsg=", paramString });
      return;
    }
    if (paramList == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramList.size();
    }
    QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchVisibleMembers: ", Integer.valueOf(paramInt1), " members returned, hasMore=", Boolean.valueOf(paramBoolean) });
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (IGProUserInfo)paramString.next();
      QQGuildLiveSettingFragment.f(this.b).add(paramList.a());
    }
    if (paramBoolean)
    {
      QQGuildLiveSettingFragment.a(this.b, false, this.a);
      return;
    }
    if (this.a)
    {
      QQGuildLiveSettingFragment.c(this.b);
      return;
    }
    QQGuildLiveSettingFragment.d(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.QQGuildLiveSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */