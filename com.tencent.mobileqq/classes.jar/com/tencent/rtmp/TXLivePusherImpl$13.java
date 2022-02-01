package com.tencent.rtmp;

import com.tencent.liteav.audio.h;

class TXLivePusherImpl$13
  implements h
{
  TXLivePusherImpl$13(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void onPlayEnd(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.onBGMComplete(paramInt);
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (this.a.a != null) {
      this.a.a.onBGMProgress(paramLong1, paramLong2);
    }
  }
  
  public void onPlayStart()
  {
    if (this.a.a != null) {
      this.a.a.onBGMStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.13
 * JD-Core Version:    0.7.0.1
 */