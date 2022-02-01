package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TXLivePusherImpl$17
  implements Runnable
{
  TXLivePusherImpl$17(TXLivePusherImpl paramTXLivePusherImpl, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    if (TXLivePusherImpl.i(this.c) != null) {
      TXLivePusherImpl.i(this.c).setLogText(null, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.17
 * JD-Core Version:    0.7.0.1
 */