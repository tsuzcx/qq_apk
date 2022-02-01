package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

final class QQGuildUtil$2
  implements IFetchGuildInfoCallback
{
  QQGuildUtil$2(IGPSService paramIGPSService, String paramString1, String paramString2, AppRuntime paramAppRuntime, Context paramContext, Bundle paramBundle, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    List localList = this.a.getChannelList(this.b);
    if ((paramInt == 0) && (localList != null) && (localList.size() > 0))
    {
      if (this.a.getChannelInfo(this.c) != null) {
        paramString = this.c;
      } else {
        paramString = null;
      }
      QLog.i("QQGuildUtil", 1, "fetchGuildInfo success");
      QQGuildUtil.a(this.d, this.e, localList, paramString, paramIGProGuildInfo, this.f, this.g);
      return;
    }
    if (paramInt != 0)
    {
      QLog.e("QQGuildUtil", 1, new Object[] { "openGuild fetchGuildInfo error channel info err:", Integer.valueOf(paramInt), ", msg:", paramString });
      paramString = BaseApplication.getContext();
      paramIGProGuildInfo = BaseApplication.getContext().getResources();
      if (this.g) {
        paramInt = 2131888255;
      } else {
        paramInt = 2131892325;
      }
      QQToast.makeText(paramString, 1, paramIGProGuildInfo.getString(paramInt), 0).show();
      return;
    }
    QLog.w("QQGuildUtil", 1, "fetchGuildInfo success, but channelInfo is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUtil.2
 * JD-Core Version:    0.7.0.1
 */