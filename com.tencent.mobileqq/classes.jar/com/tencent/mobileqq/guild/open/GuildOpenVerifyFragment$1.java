package com.tencent.mobileqq.guild.open;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.forward.AppInfo;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.qphone.base.util.QLog;

class GuildOpenVerifyFragment$1
  extends ProtoUtils.TroopProtocolObserver
{
  GuildOpenVerifyFragment$1(GuildOpenVerifyFragment paramGuildOpenVerifyFragment) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a.a();
    if (this.a.getQBaseActivity() == null)
    {
      QLog.e("QQGuildOpenVerifyFragment", 1, "activity is destroy");
      return;
    }
    paramBundle = new AppInfo();
    paramArrayOfByte = ForwardUtils.c(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      AppInfo.a(paramArrayOfByte, GuildOpenVerifyFragment.a(this.a).packageId, paramBundle);
    }
    if (paramInt == 0)
    {
      GuildOpenVerifyFragment.a(this.a, paramBundle, true);
      return;
    }
    if (paramInt == 25501)
    {
      GuildOpenVerifyFragment.a(this.a, paramBundle, false);
      return;
    }
    paramArrayOfByte = paramBundle.h();
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramArrayOfByte = "操作失败，请稍后再试";
    }
    this.a.b(paramArrayOfByte);
    QLog.e("QQGuildOpenVerifyFragment", 1, new Object[] { "checkOpenIdAndScheme error:", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */