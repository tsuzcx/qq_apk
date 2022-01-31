package org.libpag;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class GPUDecoder
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final int END_OF_STREAM = -3;
  private static final int ERROR = -2;
  private static int HandlerThreadCount = 0;
  private static final int SUCCESS = 0;
  private static final int TIMEOUT_US = 1000;
  private static final int TRY_AGAIN_LATER = -1;
  private static final Object handlerLock = new Object();
  private static HandlerThread handlerThread;
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec decoder;
  private boolean frameAvailable = false;
  private final Object frameSyncObject = new Object();
  private int lastOutputBufferIndex = -1;
  private MediaFormat outputFormat = null;
  private Surface outputSurface;
  private boolean released = false;
  private GPUDecoder.OutputFrame successFrame = new GPUDecoder.OutputFrame(null);
  private SurfaceTexture surfaceTexture;
  
  private static GPUDecoder Create(int paramInt)
  {
    if (forceSoftwareDecoder()) {
      return null;
    }
    GPUDecoder localGPUDecoder = new GPUDecoder();
    synchronized (handlerLock)
    {
      StartHandlerThread();
      localGPUDecoder.surfaceTexture = new SurfaceTexture(paramInt);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localGPUDecoder.surfaceTexture.setOnFrameAvailableListener(localGPUDecoder, new Handler(handlerThread.getLooper()));
        localGPUDecoder.outputSurface = new Surface(localGPUDecoder.surfaceTexture);
        return localGPUDecoder;
      }
      localGPUDecoder.surfaceTexture.setOnFrameAvailableListener(localGPUDecoder);
      localGPUDecoder.reflectLooper();
    }
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      HandlerThreadCount += 1;
      if (handlerThread == null)
      {
        handlerThread = new HandlerThread("libpag_GPUDecoder");
        handlerThread.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean awaitNewImage()
  {
    int i = 10;
    synchronized (this.frameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.frameAvailable;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.frameAvailable = false;
      if (i == 0) {
        return false;
      }
    }
    try
    {
      this.surfaceTexture.updateTexImage();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localObject2 = finally;
    throw localObject2;
    return false;
  }
  
  private int dequeueInputBuffer()
  {
    try
    {
      int i = this.decoder.dequeueInputBuffer(1000L);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -1;
    }
    catch (Error localError)
    {
      label14:
      break label14;
    }
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
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (Error localError)
    {
      label30:
      break label30;
    }
  }
  
  private boolean onConfigure(MediaFormat paramMediaFormat)
  {
    if (this.outputSurface == null) {}
    do
    {
      return false;
      this.outputFormat = paramMediaFormat;
      try
      {
        this.decoder = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
        this.decoder.configure(paramMediaFormat, this.outputSurface, null, 0);
        this.decoder.start();
        return true;
      }
      catch (Exception paramMediaFormat) {}
    } while (this.decoder == null);
    this.decoder.release();
    this.decoder = null;
    return false;
  }
  
  private int onDecodeFrame()
  {
    int i = -1;
    releaseOutputBuffer();
    try
    {
      int j = dequeueOutputBuffer();
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        if (j >= 0) {
          this.lastOutputBufferIndex = j;
        }
      }
      else
      {
        if (j >= 0) {
          this.lastOutputBufferIndex = j;
        }
        while (this.lastOutputBufferIndex != -1)
        {
          return 0;
          if (j == -2) {
            this.outputFormat = this.decoder.getOutputFormat();
          }
        }
      }
      i = -3;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -2;
    }
    return i;
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
    try
    {
      this.decoder.flush();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void onRelease()
  {
    if (this.released) {}
    for (;;)
    {
      return;
      this.released = true;
      releaseOutputBuffer();
      if (this.outputSurface != null)
      {
        this.outputSurface.release();
        this.outputSurface = null;
      }
      if (this.surfaceTexture != null)
      {
        this.surfaceTexture.release();
        this.surfaceTexture = null;
      }
      synchronized (handlerLock)
      {
        HandlerThreadCount -= 1;
        if (HandlerThreadCount == 0)
        {
          handlerThread.quit();
          handlerThread = null;
        }
        if (this.decoder == null) {}
      }
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
          this.decoder = null;
          return;
          localObject2 = finally;
          throw localObject2;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  private GPUDecoder.OutputFrame onRenderFrame()
  {
    if (this.lastOutputBufferIndex != -1)
    {
      int i = releaseOutputBuffer(this.lastOutputBufferIndex, true);
      this.lastOutputBufferIndex = -1;
      if ((i == 0) && (awaitNewImage())) {
        return this.successFrame;
      }
    }
    return null;
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
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -2;
    }
    catch (Error localError)
    {
      label18:
      break label18;
    }
  }
  
  private void reflectLooper()
  {
    Object localObject3 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject3[i];
      if (!localObject1.getName().toLowerCase().contains("handler")) {}
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        return;
        i += 1;
        break;
      }
      try
      {
        localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, handlerThread.getLooper() });
        localObject3 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(this.surfaceTexture, localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    try
    {
      this.decoder.releaseOutputBuffer(paramInt, paramBoolean);
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return -2;
    }
    catch (Error localError)
    {
      label12:
      break label12;
    }
  }
  
  private void releaseOutputBuffer()
  {
    if (this.lastOutputBufferIndex != -1)
    {
      releaseOutputBuffer(this.lastOutputBufferIndex, false);
      this.lastOutputBufferIndex = -1;
    }
  }
  
  private int videoHeight()
  {
    if (this.outputFormat.containsKey("height")) {}
    for (int i = this.outputFormat.getInteger("height");; i = 0)
    {
      float[] arrayOfFloat = new float[16];
      this.surfaceTexture.getTransformMatrix(arrayOfFloat);
      if ((Math.abs(arrayOfFloat[0]) != 1.0F) || (Math.abs(arrayOfFloat[5]) != 1.0F)) {}
      while ((!this.outputFormat.containsKey("crop-top")) || (!this.outputFormat.containsKey("crop-bottom"))) {
        return i;
      }
      i = this.outputFormat.getInteger("crop-top");
      return this.outputFormat.getInteger("crop-bottom") - i + 1;
    }
  }
  
  private int videoWidth()
  {
    if (this.outputFormat.containsKey("width")) {}
    for (int i = this.outputFormat.getInteger("width");; i = 0)
    {
      float[] arrayOfFloat = new float[16];
      this.surfaceTexture.getTransformMatrix(arrayOfFloat);
      if ((Math.abs(arrayOfFloat[0]) != 1.0F) || (Math.abs(arrayOfFloat[5]) != 1.0F)) {}
      while ((!this.outputFormat.containsKey("crop-left")) || (!this.outputFormat.containsKey("crop-right"))) {
        return i;
      }
      i = this.outputFormat.getInteger("crop-left");
      return this.outputFormat.getInteger("crop-right") - i + 1;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */