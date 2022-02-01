package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class StreamDecodeDataComponent$1
  implements Runnable
{
  StreamDecodeDataComponent$1(StreamDecodeDataComponent paramStreamDecodeDataComponent) {}
  
  public void run()
  {
    if (this.this$0.getPlayerState() == 8)
    {
      Logger.w("StreamDecodeDataComponent", "[run] state changed to END during postRunnable!");
      return;
    }
    this.this$0.mCallback.playerPrepared(this.this$0.mCorePlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.1
 * JD-Core Version:    0.7.0.1
 */