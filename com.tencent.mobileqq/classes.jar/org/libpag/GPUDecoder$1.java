package org.libpag;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

class GPUDecoder$1
  implements SynchronizeHandler.TimeoutRunnable
{
  private MediaCodec decoder;
  private long startTime;
  
  GPUDecoder$1(GPUDecoder paramGPUDecoder, MediaFormat paramMediaFormat, MediaCodec[] paramArrayOfMediaCodec) {}
  
  public void afterRun(boolean paramBoolean)
  {
    long l1;
    long l2;
    if ((paramBoolean) && (this.decoder != null))
    {
      l1 = SystemClock.uptimeMillis();
      l2 = this.startTime;
    }
    try
    {
      this.decoder.stop();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.decoder.release();
          label35:
          this.decoder = null;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("init decoder timeout. cost: ");
          localStringBuilder.append(l1 - l2);
          localStringBuilder.append("ms");
          new RuntimeException(localStringBuilder.toString()).printStackTrace();
          if (!paramBoolean) {
            this.val$initDecoder[0] = this.decoder;
          }
          GPUDecoder.access$100().getAndDecrement();
          return;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label35;
      }
    }
  }
  
  public void run()
  {
    this.startTime = SystemClock.uptimeMillis();
    try
    {
      this.decoder = MediaCodec.createDecoderByType(this.val$mediaFormat.getString("mime"));
      this.decoder.configure(this.val$mediaFormat, GPUDecoder.access$000(this.this$0), null, 0);
      this.decoder.start();
      return;
    }
    catch (Exception localException)
    {
      label51:
      MediaCodec localMediaCodec;
      break label51;
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null)
    {
      localMediaCodec.release();
      this.decoder = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.GPUDecoder.1
 * JD-Core Version:    0.7.0.1
 */