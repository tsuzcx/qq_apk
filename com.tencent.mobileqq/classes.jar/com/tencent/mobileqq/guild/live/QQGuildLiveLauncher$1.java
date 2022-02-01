package com.tencent.mobileqq.guild.live;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission;
import com.tencent.qphone.base.util.QLog;

final class QQGuildLiveLauncher$1
  implements IFetchEnterChannelPermissionCallback
{
  QQGuildLiveLauncher$1(QQGuildLiveLauncher.CloseLoadingDialog paramCloseLoadingDialog, QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, IEnterChannelPermission paramIEnterChannelPermission)
  {
    QLog.d("QGL.QQGuildLiveLauncher", 1, new Object[] { "onFetchEnterChannelPermission: ", Integer.valueOf(paramInt), " errMsg: ", paramString });
    QQGuildLiveLauncher.a(this.a);
    if (paramInt == 0)
    {
      if (paramIEnterChannelPermission.a())
      {
        this.b.setAllowStartLive(paramIEnterChannelPermission.c());
        QQGuildLiveLauncher.a(this.b, this.c, false);
        return;
      }
      GuildLiveToast.b(paramIEnterChannelPermission.b());
      return;
    }
    if (paramInt == -93)
    {
      GuildLiveToast.b(2131890472);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      GuildLiveToast.b(paramString);
      return;
    }
    GuildLiveToast.b(2131890434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveLauncher.1
 * JD-Core Version:    0.7.0.1
 */