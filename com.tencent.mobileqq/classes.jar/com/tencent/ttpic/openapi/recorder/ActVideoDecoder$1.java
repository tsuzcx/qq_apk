package com.tencent.ttpic.openapi.recorder;

import android.graphics.SurfaceTexture;

class ActVideoDecoder$1
  implements Runnable
{
  ActVideoDecoder$1(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    ??? = this.this$0;
    ActVideoDecoder.access$002((ActVideoDecoder)???, new SurfaceTexture(ActVideoDecoder.access$100((ActVideoDecoder)???)));
    ActVideoDecoder.access$000(this.this$0).setOnFrameAvailableListener(new ActVideoDecoder.1.1(this));
    synchronized (ActVideoDecoder.access$400(this.this$0))
    {
      ActVideoDecoder.access$400(this.this$0).notifyAll();
      ActVideoDecoder.access$502(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */