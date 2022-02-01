package org.libpag;

import android.media.MediaCodec;

class GPUDecoder$2
  implements Runnable
{
  GPUDecoder$2(GPUDecoder paramGPUDecoder) {}
  
  public void run()
  {
    try
    {
      GPUDecoder.access$200(this.this$0).stop();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      GPUDecoder.access$200(this.this$0).release();
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    GPUDecoder.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.GPUDecoder.2
 * JD-Core Version:    0.7.0.1
 */