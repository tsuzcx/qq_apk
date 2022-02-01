package com.tencent.mobileqq.guild.mainframe.api.impl;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class GuildInboxRedServiceImpl$4
  implements IResultCallback
{
  GuildInboxRedServiceImpl$4(GuildInboxRedServiceImpl paramGuildInboxRedServiceImpl, int paramInt) {}
  
  public void onResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.b.setNoticeRedPoint(this.a, 0, 0L);
      paramString = new StringBuilder();
      paramString.append("clearNoticeRedPoint succ. type=");
      paramString.append(this.a);
      QLog.i("GuildInboxRedServiceImpl", 1, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.api.impl.GuildInboxRedServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */