package com.tencent.mobileqq.guild.util;

import android.content.res.Resources;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class QQJoinGuildHelper$7
  implements IFetchGuildInfoCallback
{
  QQJoinGuildHelper$7(IGPSService paramIGPSService, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    paramIGProGuildInfo = this.a.getChannelList(this.b);
    if ((paramInt == 0) && (paramIGProGuildInfo != null) && (paramIGProGuildInfo.size() > 0))
    {
      paramString = this.a.getChannelInfo(this.c);
      if ((paramString != null) && (paramString.getType() == 2)) {
        ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), this.a.getGuildInfo(this.b), paramString, true);
      }
    }
    else
    {
      if (paramInt != 0)
      {
        QLog.e("QQJoinGuildHelper", 1, new Object[] { "openGuild fetchGuildInfo error channel info err:", Integer.valueOf(paramInt), ", msg:", paramString });
        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getResources().getString(2131892325), 0).show();
        return;
      }
      QLog.w("QQJoinGuildHelper", 1, "fetchGuildInfo success, but channelInfo is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.7
 * JD-Core Version:    0.7.0.1
 */