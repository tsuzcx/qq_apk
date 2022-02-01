package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.now.msfilivehead.ForwardRsp;

class MsfChannelService$1$1
  implements Runnable
{
  MsfChannelService$1$1(MsfChannelService.1 param1, ForwardRsp paramForwardRsp) {}
  
  public void run()
  {
    if (this.a.f != 0)
    {
      this.b.a.onError(false, this.a.f, "");
      return;
    }
    this.b.a.onRecv(this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService.1.1
 * JD-Core Version:    0.7.0.1
 */