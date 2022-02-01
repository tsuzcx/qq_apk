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
  public static String debugDecodeFilePath = Environment.getExternalStorageDirectory() + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo";
  private HWVideoDecoder.DecodeRunnable currentDecodeRunnable;
  private Thread currentDecodeThread;
  private DecodeOutputSurface decodeOutputSurface;
  private Logger logger = SdkContext.getInstance().getLogger();
  private PKManager mPKManager;
  private HWVideoDecoder.PlayHandler mPlayHandler;
  private HandlerThread mPlayThread;
  private Object mSeekingFlag = new Object();
  
  private void assureThread()
  {
    if ((this.mPlayThread != null) && (this.mPlayThread.isAlive()) && (this.mPlayHandler != null))
    {
      this.logger.d("HWVideoDecoder", "playThread: already start");
      return;
    }
    this.mPlayThread = new HandlerThread("HWVideoDecoder_" + hashCode());
    this.mPlayThread.start();
    while (!this.mPlayThread.isAlive()) {}
    this.mPlayHandler = new HWVideoDecoder.PlayHandler(this, this.mPlayThread.getLooper());
  }
  
  public static final float getSpeedRate(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1.0F;
    case 1: 
      return 2.0F;
    case 2: 
      return 0.5F;
    case 3: 
      return 1.5F;
    case 4: 
      return 0.25F;
    }
    return -1.0F;
  }
  
  private void sendMessage(int paramInt1, int paramInt2, Object paramObject)
  {
    HWVideoDecoder.PlayHandler localPlayHandler;
    if (this.mPlayHandler != null)
    {
      localPlayHandler = this.mPlayHandler;
      if (paramInt1 != 0) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 2)
    {
      localPlayHandler.obtainMessage(i, paramInt1, paramInt2, paramObject).sendToTarget();
      return;
    }
  }
  
  private void startDecode(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    this.logger.i("HWVideoDecoder", "startDecode config = " + paramDecodeConfig);
    Thread localThread;
    if (this.currentDecodeThread != null)
    {
      localThread = this.currentDecodeThread;
      stopDecode();
    }
    try
    {
      localThread.join();
      this.currentDecodeRunnable = new HWVideoDecoder.DecodeRunnable(paramDecodeConfig.inputFilePath, paramSurface, paramHWDecodeListener, this.mSeekingFlag);
      this.currentDecodeRunnable.setDecodeConfig(paramDecodeConfig);
      this.currentDecodeRunnable.setPKManager(this.mPKManager);
      this.currentDecodeThread = new Thread(this.currentDecodeRunnable, "HWVideoDecoder-Thread");
      this.currentDecodeThread.start();
      assureThread();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void decodeFrame()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if ((localDecodeRunnable != null) && (HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get()))
    {
      sendMessage(0, 0, null);
      this.logger.d("HWVideoDecoder", "decodeFrame, " + HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
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
    if (this.currentDecodeRunnable == null) {
      return 0L;
    }
    return this.currentDecodeRunnable.getProgress();
  }
  
  public void handlePlay()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    synchronized (HWVideoDecoder.DecodeRunnable.access$100(localDecodeRunnable))
    {
      HWVideoDecoder.DecodeRunnable.access$100(localDecodeRunnable).notifyAll();
      this.logger.d("HWVideoDecoder", "handlePlay");
      return;
    }
  }
  
  public void handleSeek(long paramLong)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    try
    {
      if (localDecodeRunnable.isSeeking()) {}
      synchronized (this.mSeekingFlag)
      {
        this.mSeekingFlag.wait(1000L);
        localDecodeRunnable.seekTo(paramLong);
        this.logger.d("HWVideoDecoder", "handleSeek " + paramLong + " ms");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.logger.e("HWVideoDecoder", "handleSeek " + paramLong + " ms", localException);
    }
  }
  
  public void handleSeekNext(long paramLong)
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    try
    {
      if (localDecodeRunnable.isSeeking()) {}
      synchronized (this.mSeekingFlag)
      {
        this.mSeekingFlag.wait(1000L);
        localDecodeRunnable.nextTo(paramLong);
        this.logger.d("HWVideoDecoder", "handleSeekNext " + paramLong + " ms");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.logger.e("HWVideoDecoder", "handleSeekNext " + paramLong + " ms", localException);
    }
  }
  
  public void nextTo(long paramLong)
  {
    if ((this.currentDecodeRunnable != null) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(2);
      sendMessage(3, (int)paramLong, null);
      this.logger.d("HWVideoDecoder", "nextTo " + paramLong + " ms");
      return;
    }
    this.logger.w("HWVideoDecoder", "nextTo " + paramLong + " ms failed, can not find DecodeRunnable");
  }
  
  public void pauseDecode()
  {
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).compareAndSet(false, true);
      sendMessage(1, 0, null);
      this.logger.d("HWVideoDecoder", "pauseDecode " + HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
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
      this.logger.d("HWVideoDecoder", "resumeDecode " + HWVideoDecoder.DecodeRunnable.access$000(localDecodeRunnable).get());
      return;
    }
    this.logger.w("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void seekTo(int paramInt)
  {
    if ((this.currentDecodeRunnable != null) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(2);
      sendMessage(2, paramInt, null);
      this.logger.d("HWVideoDecoder", "seekTo " + paramInt + " ms");
      return;
    }
    this.logger.w("HWVideoDecoder", "seekTo " + paramInt + " ms failed, can not find DecodeRunnable");
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
      this.logger.d("HWVideoDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
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
    HWVideoDecoder.DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.setSpeedType(paramInt);
      this.logger.d("HWVideoDecoder", "setSpeedType" + paramInt);
      return;
    }
    this.logger.w("HWVideoDecoder", "setSpeedType " + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void startDecode(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.decodeOutputSurface = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    startDecode(paramDecodeConfig, this.decodeOutputSurface.surface, paramHWDecodeListener);
  }
  
  public void stopDecode()
  {
    if ((this.mPlayThread != null) && (this.mPlayThread.isAlive()) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(1);
      this.mPlayHandler.removeMessages(2);
      this.mPlayThread.quit();
    }
    if (this.currentDecodeThread != null) {
      this.currentDecodeThread.interrupt();
    }
    this.currentDecodeThread = null;
    this.currentDecodeRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */