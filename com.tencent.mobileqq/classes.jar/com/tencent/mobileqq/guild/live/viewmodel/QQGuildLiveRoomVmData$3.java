package com.tencent.mobileqq.guild.live.viewmodel;

import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

class QQGuildLiveRoomVmData$3
  implements IQueryTinyIdByLiveUIDCallback
{
  QQGuildLiveRoomVmData$3(QQGuildLiveRoomVmData paramQQGuildLiveRoomVmData, BetterLiveData paramBetterLiveData, long paramLong, QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel, IGPSService paramIGPSService) {}
  
  public void a(int paramInt, String paramString, HashMap<Long, Long> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryTinyIdByLiveUID result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveRoomVmData", 1, localStringBuilder.toString());
    paramString = Boolean.valueOf(false);
    if (paramInt != 0)
    {
      this.a.setValue(paramString);
      return;
    }
    if ((paramHashMap != null) && (paramHashMap.containsKey(Long.valueOf(this.b))))
    {
      paramHashMap = (Long)paramHashMap.get(Long.valueOf(this.b));
      if (paramHashMap == null)
      {
        QLog.e("QGL.QQGuildLiveRoomVmData", 1, "queryTinyIdByLiveUID tinyIdLong == null.");
        this.a.setValue(paramString);
        return;
      }
      paramString = String.valueOf(paramHashMap);
      this.c.a(this.d.getGuildUserNick(paramString));
      paramString = ((IQQGuildAvatarApi)QQGuildLiveRoomVmData.b(this.e).getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(QQGuildLiveRoomVmData.b(this.e), paramString);
      this.c.a(paramString);
      this.a.setValue(Boolean.valueOf(true));
      return;
    }
    QLog.e("QGL.QQGuildLiveRoomVmData", 1, "queryTinyIdByLiveUID map not contains.");
    this.a.setValue(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData.3
 * JD-Core Version:    0.7.0.1
 */