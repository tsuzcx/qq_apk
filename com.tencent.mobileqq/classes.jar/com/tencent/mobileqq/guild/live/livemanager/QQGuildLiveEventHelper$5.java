package com.tencent.mobileqq.guild.live.livemanager;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveEventHelper$5
  implements IFetchLiveRoomInfoCallback
{
  QQGuildLiveEventHelper$5(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void a(int paramInt1, String paramString, List<ILiveRoomInfo> paramList, List<String> paramList1, int paramInt2)
  {
    paramList1 = new StringBuilder();
    paramList1.append("checkLiveStateWhenNetRestore. result:");
    paramList1.append(paramInt1);
    paramList1.append(" errMsg:");
    paramList1.append(paramString);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, paramList1.toString());
    if (QQGuildLiveEventHelper.j(this.a))
    {
      if (paramInt1 != 0) {
        return;
      }
      paramString = this.a;
      boolean bool1;
      if (QQGuildLiveEventHelper.a(paramString, paramList, QQGuildLiveEventHelper.h(paramString)))
      {
        paramString = ((ILiveRoomInfo)paramList.get(0)).getRoomId();
        bool1 = true;
      }
      else
      {
        paramString = null;
        bool1 = false;
      }
      boolean bool2 = ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().c(), Boolean.valueOf(false))).booleanValue();
      paramList = new StringBuilder();
      paramList.append("checkLiveStateWhenNetRestore. haveLiveRoomInfo:");
      paramList.append(bool1);
      paramList.append(" isEnterRoom:");
      paramList.append(bool2);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, paramList.toString());
      if (bool2)
      {
        if (!bool1) {
          QQGuildLiveEventHelper.k(this.a);
        }
      }
      else if ((bool1) && (!TextUtils.isEmpty(paramString))) {
        QQGuildLiveEventHelper.d(this.a, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.5
 * JD-Core Version:    0.7.0.1
 */