package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class GPUDecoder
{
  private static final int DECODER_THREAD_MAX_COUNT = 10;
  private static final int END_OF_STREAM = -3;
  private static final int ERROR = -2;
  private static final int INIT_DECODER_TIMEOUT_MS = 2000;
  private static final int SUCCESS = 0;
  private static final int TIMEOUT_US = 1000;
  private static final int TRY_AGAIN_LATER = -1;
  private static final AtomicInteger decoderThreadCount = new AtomicInteger();
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec decoder;
  private boolean disableFlush = true;
  private int lastOutputBufferIndex = -1;
  private Surface outputSurface = null;
  private boolean released = false;
  
  private static GPUDecoder Create(Surface paramSurface)
  {
    if (forceSoftwareDecoder()) {
      return null;
    }
    GPUDecoder localGPUDecoder = new GPUDecoder();
    localGPUDecoder.outputSurface = paramSurface;
    return localGPUDecoder;
  }
  
  private int dequeueInputBuffer()
  {
    try
    {
      int i = this.decoder.dequeueInputBuffer(1000L);
      return i;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    return -1;
  }
  
  private int dequeueOutputBuffer()
  {
    try
    {
      int i = this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  private static boolean forceSoftwareDecoder()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return this.decoder.getInputBuffer(paramInt);
      }
      ByteBuffer localByteBuffer = this.decoder.getInputBuffers()[paramInt];
      return localByteBuffer;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    return null;
  }
  
  private boolean initDecoder(MediaFormat paramMediaFormat)
  {
    int i = decoderThreadCount.get();
    boolean bool2 = false;
    if (i >= 10) {
      return false;
    }
    decoderThreadCount.getAndIncrement();
    HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder_init_decoder");
    localHandlerThread.start();
    SynchronizeHandler localSynchronizeHandler = new SynchronizeHandler(localHandlerThread.getLooper());
    MediaCodec[] arrayOfMediaCodec = new MediaCodec[1];
    arrayOfMediaCodec[0] = null;
    boolean bool3 = localSynchronizeHandler.runSync(new GPUDecoder.1(this, paramMediaFormat, arrayOfMediaCodec), 2000L);
    localHandlerThread.quitSafely();
    boolean bool1 = bool2;
    if (bool3)
    {
      this.decoder = arrayOfMediaCodec[0];
      bool1 = bool2;
      if (this.decoder != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean onConfigure(MediaFormat paramMediaFormat)
  {
    if (this.outputSurface == null) {
      return false;
    }
    return initDecoder(paramMediaFormat);
  }
  
  private int onDecodeFrame()
  {
    releaseOutputBuffer();
    try
    {
      int i = dequeueOutputBuffer();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if (i >= 0) {
          this.lastOutputBufferIndex = i;
        }
      }
      else
      {
        if (i >= 0) {
          this.lastOutputBufferIndex = i;
        }
        int j = this.lastOutputBufferIndex;
        i = -1;
        if (j != -1) {
          i = 0;
        }
        return i;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -2;
    }
    return -3;
  }
  
  private int onEndOfStream()
  {
    int i = dequeueInputBuffer();
    if (i >= 0) {
      return queueInputBuffer(i, 0, 0, 0L, 4);
    }
    return -1;
  }
  
  private void onFlush()
  {
    if (this.disableFlush) {
      return;
    }
    try
    {
      this.decoder.flush();
      this.bufferInfo = new MediaCodec.BufferInfo();
      this.lastOutputBufferIndex = -1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void onRelease()
  {
    if (this.released) {
      return;
    }
    this.released = true;
    releaseOutputBuffer();
    releaseDecoder();
  }
  
  private boolean onRenderFrame()
  {
    int i = this.lastOutputBufferIndex;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i != -1)
    {
      i = releaseOutputBuffer(i, true);
      this.lastOutputBufferIndex = -1;
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int onSendBytes(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = dequeueInputBuffer();
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = getInputBuffer(i);
      if (localByteBuffer == null) {
        return -2;
      }
      localByteBuffer.clear();
      paramByteBuffer.position(0);
      localByteBuffer.put(paramByteBuffer);
      return queueInputBuffer(i, 0, paramByteBuffer.limit(), paramLong, 0);
    }
    return -1;
  }
  
  private long presentationTime()
  {
    return this.bufferInfo.presentationTimeUs;
  }
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      this.disableFlush = false;
      return 0;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    return -2;
  }
  
  private void releaseAsync(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    decoderThreadCount.getAndIncrement();
    HandlerThread localHandlerThread = new HandlerThread("libpag_GPUDecoder_release_decoder");
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new GPUDecoder.3(this, paramRunnable, localHandlerThread));
  }
  
  private void releaseDecoder()
  {
    if (this.decoder == null) {
      return;
    }
    releaseAsync(new GPUDecoder.2(this));
  }
  
  private int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    try
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      return 0;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    return -2;
  }
  
  private void releaseOutputBuffer()
  {
    int i = this.lastOutputBufferIndex;
    if (i != -1)
    {
      releaseOutputBuffer(i, false);
      this.lastOutputBufferIndex = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */