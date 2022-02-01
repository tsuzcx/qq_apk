package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
public class HWVideoDecoder
{
  private static final int ACTION_PAUSE = 1;
  private static final int ACTION_PLAY = 0;
  private static final int ACTION_SEEK = 2;
  private static final int ACTION_SEEK_NEXT = 3;
  public static final int MAX_FRAME_SEEK_INTERVAL = 100000;
  private static final int MAX_SEEK_WAIT_TIME = 1000;
  private static final int MSG_PLAY = 1;
  private static final int MSG_SOME_THING = 2;
  public static final int SPEED_TYPE_FAST = 1;
  public static final int SPEED_TYPE_LITTLE_FAST = 3;
  public static final int SPEED_TYPE_REAL_TIME = 0;
  public static final int SPEED_TYPE_REVERSE = 5;
  public static final int SPEED_TYPE_SLOW = 2;
  public static final int SPEED_TYPE_VERY_SLOW = 4;
  private static final String TAG = "HWVideoDecoder";
  public static String debugDecodeFilePath;
  private HWVideoDecoder.DecodeRunnable currentDecodeRunnable;
  private Thread currentDecodeThread;
  private DecodeOutputSurface decodeOutputSurface;
  private Logger logger = SdkContext.getInstance().getLogger();
  private PKManager mPKManager;
  private HWVideoDecoder.PlayHandler mPlayHandler;
  private HandlerThread mPlayThread;
  private Object mSeekingFlag = new Object();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    debugDecodeFilePath = localStringBuilder.toString();
  }
  
  private void assureThread()
  {
    Object localObject = this.mPlayThread;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive()) && (this.mPlayHandler != null))
    {
      this.logger.d("HWVideoDecoder", "playThread: already start");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HWVideoDecoder_");
    ((StringBuilder)localObject).append(hashCode());
    this.mPlayThread = new HandlerThread(((StringBuilder)localObject).toString());
    this.mPlayThread.start();
    while (!this.mPlayThread.isAlive()) {}
    this.mPlayHandler = new HWVideoDecoder.PlayHandler(this, this.mPlayThread.getLooper());
  }
  
  public static final float getSpeedRate(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return 1.0F;
            }
            return -1.0F;
          }
          return 0.25F;
        }
        return 1.5F;
      }
      return 0.5F;
    }
    return 2.0F;
  }
  
  private void sendMessage(int paramInt1, int paramInt2, Object paramObject)
  {
    HWVideoDecoder.PlayHandler localPlayHandler = this.mPlayHandler;
    if (localPlayHandler != null)
    {
      int i;
      if (paramInt1 == 0) {
        i = 1;
      } else {
        i = 2;
      }
      localPlayHandler.obtainMessage(i, paramInt1, paramInt2, paramObject).sendToTarget();
    }
  }
  
  private void startDecode(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig != null) && (paramSurface != null))
    {
      Object localObject = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDecode config = ");
      localStringBuilder.append(paramDecodeConfig);
      ((Logger)localObject).i("HWVideoDecoder", localStringBuilder.toString());
      localObject = this.currentDecodeThread;
      if (localObject != null)
      {
        stopDecode();
        try
        {
          ((Thread)localObject).join();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.currentDecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.inputFilePath, paramSurface, paramHWDecodeListener, this.mSeekingFlag);
      this.currentDecodeRunnable.setDecodeConfig(paramDecodeConfig);
      this.currentDecodeRunnable.setPKManager(this.mPKManager);
      this.currentDecodeThread = new Thread(this.currentDecodeRunnable, "HWVideoDecoder-Thread");
      this.currentDecodeThread.start();
      assureThread();
      return;
    }
    throw new IllegalArgumentException("both decodeConfig and surface should not be null");
  }
  
  public void decodeFrame()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if ((localDecodeRunnable != null) && (HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get()))
    {
      sendMessage(0, 0, null);
      Logger localLogger = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFrame, ");
      localStringBuilder.append(HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
      localLogger.d("HWVideoDecoder", localStringBuilder.toString());
      return;
    }
    this.logger.w("HWVideoDecoder", "decodeFrame failed, can not find DecodeRunnable");
  }
  
  public int getLastFrameSampleTimeMs()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      return (int)localDecodeRunnable.getLastFrameSampleTimeMs();
    }
    return 0;
  }
  
  public long getProgress()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable == null) {
      return 0L;
    }
    return localDecodeRunnable.getProgress();
  }
  
  public void handlePlay()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      synchronized (HWVideoDecoder.DecodeRunnable.access$100(localDecodeRunnable))
      {
        HWVideoDecoder.DecodeRunnable.access$100(localDecodeRunnable).notifyAll();
        this.logger.d("HWVideoDecoder", "handlePlay");
        return;
      }
    }
  }
  
  public void handleSeek(long paramLong)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      try
      {
        if (localDecodeRunnable.isSeeking()) {
          synchronized (this.mSeekingFlag)
          {
            this.mSeekingFlag.wait(1000L);
          }
        }
        localObject2.seekTo(paramLong);
        ??? = this.logger;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleSeek ");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(" ms");
        ((Logger)???).d("HWVideoDecoder", ((StringBuilder)localObject3).toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject3 = this.logger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSeek ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" ms");
        ((Logger)localObject3).e("HWVideoDecoder", localStringBuilder.toString(), localException);
      }
    }
  }
  
  public void handleSeekNext(long paramLong)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      try
      {
        if (localDecodeRunnable.isSeeking()) {
          synchronized (this.mSeekingFlag)
          {
            this.mSeekingFlag.wait(1000L);
          }
        }
        localObject2.nextTo(paramLong);
        ??? = this.logger;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleSeekNext ");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(" ms");
        ((Logger)???).d("HWVideoDecoder", ((StringBuilder)localObject3).toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject3 = this.logger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSeekNext ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" ms");
        ((Logger)localObject3).e("HWVideoDecoder", localStringBuilder.toString(), localException);
      }
    }
  }
  
  public void nextTo(long paramLong)
  {
    if (this.currentDecodeRunnable != null)
    {
      localObject = this.mPlayHandler;
      if (localObject != null)
      {
        ((HWVideoDecoder.PlayHandler)localObject).removeMessages(2);
        sendMessage(3, (int)paramLong, null);
        localObject = this.logger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("nextTo ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" ms");
        ((Logger)localObject).d("HWVideoDecoder", localStringBuilder.toString());
        return;
      }
    }
    Object localObject = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nextTo ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ms failed, can not find DecodeRunnable");
    ((Logger)localObject).w("HWVideoDecoder", localStringBuilder.toString());
  }
  
  public void pauseDecode()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).compareAndSet(false, true);
      sendMessage(1, 0, null);
      Logger localLogger = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseDecode ");
      localStringBuilder.append(HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
      localLogger.d("HWVideoDecoder", localStringBuilder.toString());
      return;
    }
    this.logger.w("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void resumeDecode()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.clearTimeStamp();
      HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).compareAndSet(true, false);
      sendMessage(0, 0, null);
      Logger localLogger = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeDecode ");
      localStringBuilder.append(HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
      localLogger.d("HWVideoDecoder", localStringBuilder.toString());
      return;
    }
    this.logger.w("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void seekTo(int paramInt)
  {
    if (this.currentDecodeRunnable != null)
    {
      localObject = this.mPlayHandler;
      if (localObject != null)
      {
        ((HWVideoDecoder.PlayHandler)localObject).removeMessages(2);
        sendMessage(2, paramInt, null);
        localObject = this.logger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("seekTo ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" ms");
        ((Logger)localObject).d("HWVideoDecoder", localStringBuilder.toString());
        return;
      }
    }
    Object localObject = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekTo ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ms failed, can not find DecodeRunnable");
    ((Logger)localObject).w("HWVideoDecoder", localStringBuilder.toString());
  }
  
  public void setPKManager(PKManager paramPKManager)
  {
    this.mPKManager = paramPKManager;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      Logger localLogger = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayRange [");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" ms, ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" ms]");
      localLogger.d("HWVideoDecoder", localStringBuilder.toString());
      localDecodeRunnable.setPlayRange(paramLong1, paramLong2);
      return;
    }
    this.logger.w("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void setProlongToTime(long paramLong)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      localDecodeRunnable.setProlongToTime(paramLong);
    }
  }
  
  public void setSpeedType(int paramInt)
  {
    Object localObject = this.currentDecodeRunnable;
    if (localObject != null)
    {
      ((HWVideoDecoder.DecodeRunnable)localObject).setSpeedType(paramInt);
      localObject = this.logger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSpeedType");
      localStringBuilder.append(paramInt);
      ((Logger)localObject).d("HWVideoDecoder", localStringBuilder.toString());
      return;
    }
    localObject = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeedType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" failed, can not find DecodeRunnable");
    ((Logger)localObject).w("HWVideoDecoder", localStringBuilder.toString());
  }
  
  public void startDecode(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.decodeOutputSurface = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    startDecode(paramDecodeConfig, this.decodeOutputSurface.surface, paramHWDecodeListener);
  }
  
  public void stopDecode()
  {
    Object localObject = this.mPlayThread;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive()))
    {
      localObject = this.mPlayHandler;
      if (localObject != null)
      {
        ((HWVideoDecoder.PlayHandler)localObject).removeMessages(1);
        this.mPlayHandler.removeMessages(2);
        this.mPlayThread.quit();
      }
    }
    localObject = this.currentDecodeThread;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    this.currentDecodeThread = null;
    this.currentDecodeRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */