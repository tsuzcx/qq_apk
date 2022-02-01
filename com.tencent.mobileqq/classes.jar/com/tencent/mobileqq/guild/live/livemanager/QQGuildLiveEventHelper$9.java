package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildLiveEventHelper$9
  implements IFetchLiveChannelAnchorListCallback
{
  QQGuildLiveEventHelper$9(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void a(int paramInt, String paramString, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFetchAnchorList result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      return;
    }
    paramString = this.a;
    QQGuildLiveEventHelper.b(paramString, QQGuildLiveEventHelper.b(paramString, paramList, QQGuildLiveEventHelper.l(paramString)));
    paramString = new StringBuilder();
    paramString.append("mSelfInAnchorList = ");
    paramString.append(QQGuildLiveEventHelper.m(this.a));
    QLog.i("QGL.QQGuildLiveEventHelper", 1, paramString.toString());
    QQGuildLiveEventHelper.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.9
 * JD-Core Version:    0.7.0.1
 */