package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.manager.GuildGuestMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuestGuildForImplCallback;

class GPSAsynManagerEngine$34
  implements IFetchGuestGuildForImplCallback
{
  GPSAsynManagerEngine$34(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IFetchGuestGuildCallback paramIFetchGuestGuildCallback) {}
  
  public void a(int paramInt, String paramString, GProGuildInfo paramGProGuildInfo, GuildInitInfo paramGuildInitInfo)
  {
    if (paramInt == 0) {
      this.c.c().a(this.a, paramGProGuildInfo, paramGuildInitInfo);
    }
    this.b.a(paramInt, paramString, paramGProGuildInfo, GProConvert.a(GProConvert.a(paramGuildInitInfo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.34
 * JD-Core Version:    0.7.0.1
 */