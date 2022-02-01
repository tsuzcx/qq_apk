package com.tencent.rtmp;

import android.os.Bundle;

class TXLivePusherImpl$8
  implements Runnable
{
  TXLivePusherImpl$8(TXLivePusherImpl paramTXLivePusherImpl, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (TXLivePusherImpl.a(this.c) != null) {
      TXLivePusherImpl.a(this.c).onPushEvent(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.8
 * JD-Core Version:    0.7.0.1
 */