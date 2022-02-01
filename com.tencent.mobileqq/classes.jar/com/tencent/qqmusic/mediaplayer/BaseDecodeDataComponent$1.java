package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;

class BaseDecodeDataComponent$1
  implements WaitNotify.WaitListener
{
  BaseDecodeDataComponent$1(BaseDecodeDataComponent paramBaseDecodeDataComponent) {}
  
  public boolean keepWaiting()
  {
    return this.this$0.isPaused();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.1
 * JD-Core Version:    0.7.0.1
 */