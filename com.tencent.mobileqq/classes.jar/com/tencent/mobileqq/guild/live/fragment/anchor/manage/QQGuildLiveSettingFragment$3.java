package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveSettingFragment$3
  implements IFetchLiveChannelAnchorListCallback
{
  QQGuildLiveSettingFragment$3(QQGuildLiveSettingFragment paramQQGuildLiveSettingFragment) {}
  
  public void a(int paramInt, String paramString, List<String> paramList)
  {
    QQGuildLiveSettingFragment localQQGuildLiveSettingFragment = this.a;
    int i = 0;
    QQGuildLiveSettingFragment.a(localQQGuildLiveSettingFragment, false);
    if (QQGuildLiveSettingFragment.a(this.a))
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, "fetchLiveChannelAnchorList: illegalStatus");
      return;
    }
    if (paramInt != 0)
    {
      QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchLiveChannelAnchorList failed, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
      return;
    }
    if (paramList == null) {
      paramInt = i;
    } else {
      paramInt = paramList.size();
    }
    QLog.e("QGL.QQGuildLiveSettingFragment", 1, new Object[] { "fetchLiveChannelAnchorList: ", Integer.valueOf(paramInt), " anchors returned" });
    QQGuildLiveSettingFragment.e(this.a).clear();
    if (paramList != null) {
      QQGuildLiveSettingFragment.e(this.a).addAll(paramList);
    }
    QQGuildLiveSettingFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.QQGuildLiveSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */