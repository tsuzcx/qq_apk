package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;

class CsTaskImpl$2
  implements Runnable
{
  CsTaskImpl$2(CsTaskImpl paramCsTaskImpl) {}
  
  public void run()
  {
    if (CsTaskImpl.a(this.this$0) != null) {
      CsTaskImpl.a(this.this$0).onError(true, -1, "Time out");
    }
    CsTaskImpl.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.CsTaskImpl.2
 * JD-Core Version:    0.7.0.1
 */