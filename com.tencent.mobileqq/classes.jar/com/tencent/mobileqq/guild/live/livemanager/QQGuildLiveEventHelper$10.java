package com.tencent.mobileqq.guild.live.livemanager;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveEventHelper$10
  implements IGetUserInfoCallback
{
  QQGuildLiveEventHelper$10(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if ((QQGuildLiveEventHelper.j(this.a)) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramString = QQGuildUtil.a((IGProUserInfo)paramList.get(0));
      paramList = new StringBuilder();
      paramList.append("selfNick=");
      paramList.append(paramString);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, paramList.toString());
      if (!TextUtils.isEmpty(paramString)) {
        QQGuildLiveRoomUiData.a().a(paramString, true);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("mInited=");
    paramString.append(QQGuildLiveEventHelper.j(this.a));
    QLog.i("QGL.QQGuildLiveEventHelper", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.10
 * JD-Core Version:    0.7.0.1
 */