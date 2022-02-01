package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveEventHelper$7
  implements IFetchLiveRoomInfoCallback
{
  QQGuildLiveEventHelper$7(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void a(int paramInt1, String paramString, List<ILiveRoomInfo> paramList, List<String> paramList1, int paramInt2)
  {
    if (!QQGuildLiveEventHelper.j(this.a))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo, inited = false, ignore result.");
      return;
    }
    if (paramInt1 != 0)
    {
      paramList = new StringBuilder();
      paramList.append("fetchLiveRoomInfo, errMsg=");
      paramList.append(paramString);
      QLog.e("QGL.QQGuildLiveEventHelper", 1, paramList.toString());
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      QQGuildLiveEventHelper.a(this.a, LiveChannelRoomInfo.parseFrom((ILiveRoomInfo)paramList.get(0)));
      return;
    }
    QQGuildLiveEventHelper.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.7
 * JD-Core Version:    0.7.0.1
 */