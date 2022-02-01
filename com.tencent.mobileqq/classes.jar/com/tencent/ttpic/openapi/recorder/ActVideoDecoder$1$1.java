package com.tencent.ttpic.openapi.recorder;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class ActVideoDecoder$1$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  ActVideoDecoder$1$1(ActVideoDecoder.1 param1) {}
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (ActVideoDecoder.access$200(this.this$1.this$0))
    {
      if (!ActVideoDecoder.access$300(this.this$1.this$0))
      {
        ActVideoDecoder.access$302(this.this$1.this$0, true);
        ActVideoDecoder.access$200(this.this$1.this$0).notifyAll();
        return;
      }
      throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.1.1
 * JD-Core Version:    0.7.0.1
 */