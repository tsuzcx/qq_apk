package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelListWithGuildInitForGuestCallback;

class GPSAsynManagerEngine$36
  implements IFetchChannelListWithGuildInitForGuestCallback
{
  GPSAsynManagerEngine$36(GPSAsynManagerEngine paramGPSAsynManagerEngine, IFetchChannelListForGuestCallback paramIFetchChannelListForGuestCallback) {}
  
  public void a(int paramInt, String paramString, GuildInitInfo paramGuildInitInfo)
  {
    this.a.a(paramInt, paramString, GProConvert.a(GProConvert.a(paramGuildInitInfo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.36
 * JD-Core Version:    0.7.0.1
 */