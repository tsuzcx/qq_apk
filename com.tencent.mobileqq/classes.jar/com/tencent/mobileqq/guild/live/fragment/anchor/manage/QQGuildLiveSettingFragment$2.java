package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQGuildLiveSettingFragment$2
  implements IGetUserListCallback
{
  QQGuildLiveSettingFragment$2(QQGuildLiveSettingFragment paramQQGuildLiveSettingFragment, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean) {}
  
  public void onGetUserList(String paramString1, int paramInt, String paramString2, Object paramObject, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2, List<IGProUserInfo> paramList3)
  {
    paramString1 = this.c;
    int i = 0;
    QQGuildLiveSettingFragment.a(paramString1, false);
    if (QQGuildLiveSettingFragment.a(this.c))
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, "fetchAdminList: onGetUserList  illegalStatus");
      return;
    }
    if (paramInt != 0)
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchAdminList: get admin list failed result=", Integer.valueOf(paramInt), ", errMsg=", paramString2 });
      return;
    }
    if (paramList1 == null) {
      paramInt = i;
    } else {
      paramInt = paramList1.size();
    }
    QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchAdminList: ", Integer.valueOf(paramInt), " administrators returned" });
    QQGuildLiveSettingFragment.b(this.c).clear();
    paramString1 = paramList1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (IGProUserInfo)paramString1.next();
      QQGuildLiveSettingFragment.b(this.c).add(paramString2.a());
    }
    if (this.a.getVisibleType() == 2)
    {
      QQGuildLiveSettingFragment.a(this.c, true, this.b);
      return;
    }
    if (this.b)
    {
      QQGuildLiveSettingFragment.c(this.c);
      return;
    }
    QQGuildLiveSettingFragment.d(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.QQGuildLiveSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */