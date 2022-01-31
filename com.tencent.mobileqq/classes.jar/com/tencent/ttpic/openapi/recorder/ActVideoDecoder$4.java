package com.tencent.ttpic.openapi.recorder;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;

class ActVideoDecoder$4
  implements Runnable
{
  ActVideoDecoder$4(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    if (ActVideoDecoder.access$000(this.this$0) != null) {
      ActVideoDecoder.access$000(this.this$0).release();
    }
    ActVideoDecoder.access$1400(this.this$0).getLooper().quit();
    ActVideoDecoder.access$1402(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.4
 * JD-Core Version:    0.7.0.1
 */