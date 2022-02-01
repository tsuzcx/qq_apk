package com.tencent.ttpic.openapi.recorder;

import android.media.MediaCodec;
import android.media.MediaExtractor;

class ActVideoDecoder$3
  implements Runnable
{
  ActVideoDecoder$3(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    if (ActVideoDecoder.access$900(this.this$0) != null) {
      ActVideoDecoder.access$900(this.this$0).seekTo(0L, 0);
    }
    if (ActVideoDecoder.access$1000(this.this$0) != null) {
      ActVideoDecoder.access$1000(this.this$0).flush();
    }
    ActVideoDecoder.access$1102(this.this$0, false);
    ActVideoDecoder.access$1202(this.this$0, -1L);
    ActVideoDecoder.access$1302(this.this$0, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.3
 * JD-Core Version:    0.7.0.1
 */