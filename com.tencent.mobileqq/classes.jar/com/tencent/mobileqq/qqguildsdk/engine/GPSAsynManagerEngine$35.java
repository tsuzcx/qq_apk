package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.manager.GuildGuestMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuildInfoForImplCallback;

class GPSAsynManagerEngine$35
  implements IFetchGuildInfoForImplCallback
{
  GPSAsynManagerEngine$35(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback) {}
  
  public void a(int paramInt, String paramString, GProGuildInfo paramGProGuildInfo)
  {
    if (paramInt == 0) {
      this.c.c().a(this.a, paramGProGuildInfo);
    }
    this.b.a(paramInt, paramString, paramGProGuildInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.35
 * JD-Core Version:    0.7.0.1
 */