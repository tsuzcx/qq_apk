package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;

class GPSAsynManagerEngine$15
  implements ISetChannelMsgNotifyTypeCallback
{
  GPSAsynManagerEngine$15(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, int paramInt, String paramString2, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback) {}
  
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    if (paramInt == 0)
    {
      paramIGProChannelInfo = this.e.d().c(this.a, this.b);
      this.e.d().d(this.a, this.b);
      this.e.a(5, "customChannelMsgNotifyType", this.a);
      this.e.a(12, "customChannelMsgNotifyType", this.c, this.a, Integer.valueOf(this.b));
    }
    this.d.a(paramInt, paramIGProChannelInfo, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.15
 * JD-Core Version:    0.7.0.1
 */