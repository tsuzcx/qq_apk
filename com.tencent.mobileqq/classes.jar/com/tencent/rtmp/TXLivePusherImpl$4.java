package com.tencent.rtmp;

import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

class TXLivePusherImpl$4
  implements Runnable
{
  TXLivePusherImpl$4(TXLivePusherImpl paramTXLivePusherImpl, long paramLong) {}
  
  public void run()
  {
    if (TXLivePusherImpl.j(this.b) != null) {
      TXLivePusherImpl.j(this.b).onRecordProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.4
 * JD-Core Version:    0.7.0.1
 */