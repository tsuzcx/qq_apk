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
  private int targetHeight = 0;
  private int targetWidth = 0;
  
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
      }
      else
      {
        localGPUDecoder.surfaceTexture.setOnFrameAvailableListener(localGPUDecoder);
        localGPUDecoder.reflectLooper();
      }
      localGPUDecoder.outputSurface = new Surface(localGPUDecoder.surfaceTexture);
      return localGPUDecoder;
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
  
  private boolean attachToGLContext(int paramInt)
  {
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture == null) {
      return false;
    }
    try
    {
      localSurfaceTexture.detachFromGLContext();
      this.surfaceTexture.attachToGLContext(paramInt);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private boolean awaitNewImage()
  {
    Object localObject1 = this.frameSyncObject;
    int i = 10;
    try
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
      try
      {
        this.surfaceTexture.updateTexImage();
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
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
  
  private boolean onConfigure(MediaFormat paramMediaFormat)
  {
    if (this.outputSurface == null) {
      return false;
    }
    this.targetWidth = paramMediaFormat.getInteger("width");
    this.targetHeight = paramMediaFormat.getInteger("height");
    this.outputFormat = paramMediaFormat;
    try
    {
      this.decoder = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
      this.decoder.configure(paramMediaFormat, this.outputSurface, null, 0);
      this.decoder.start();
      return true;
    }
    catch (Exception paramMediaFormat)
    {
      label70:
      break label70;
    }
    paramMediaFormat = this.decoder;
    if (paramMediaFormat != null)
    {
      paramMediaFormat.release();
      this.decoder = null;
    }
    return false;
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
        } else if (i == -2) {
          this.outputFormat = this.decoder.getOutputFormat();
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
    Object localObject2;
    synchronized (handlerLock)
    {
      HandlerThreadCount -= 1;
      if (HandlerThreadCount == 0)
      {
        handlerThread.quit();
        handlerThread = null;
      }
      ??? = this.decoder;
      if (??? != null)
      {
        try
        {
          ((MediaCodec)???).stop();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        try
        {
          this.decoder.release();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        this.decoder = null;
      }
      localObject2 = this.outputSurface;
      if (localObject2 != null)
      {
        ((Surface)localObject2).release();
        this.outputSurface = null;
      }
      localObject2 = this.surfaceTexture;
      if (localObject2 != null)
      {
        ((SurfaceTexture)localObject2).release();
        this.surfaceTexture = null;
      }
      return;
    }
  }
  
  private GPUDecoder.OutputFrame onRenderFrame()
  {
    int i = this.lastOutputBufferIndex;
    if (i != -1)
    {
      i = releaseOutputBuffer(i, true);
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
  
  private long presentationTime()
  {
    return this.bufferInfo.presentationTimeUs;
  }
  
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      this.decoder.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return 0;
    }
    catch (Error localError) {}catch (Exception localException) {}
    localException.printStackTrace();
    return -2;
  }
  
  private void reflectLooper()
  {
    Object localObject2 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if (localObject1.getName().toLowerCase().contains("handler")) {
        break label51;
      }
      i += 1;
    }
    Object localObject1 = null;
    label51:
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, handlerThread.getLooper() });
      localObject2 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(this.surfaceTexture, localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
  
  private float videoHeight()
  {
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[5]);
    if (f > 0.0F) {
      return this.targetHeight / (f + (arrayOfFloat[13] - f) * 2.0F);
    }
    return this.targetHeight;
  }
  
  private float videoWidth()
  {
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[0]);
    if (f > 0.0F) {
      return this.targetWidth / (f + arrayOfFloat[12] * 2.0F);
    }
    return this.targetWidth;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.GPUDecoder
 * JD-Core Version:    0.7.0.1
 */