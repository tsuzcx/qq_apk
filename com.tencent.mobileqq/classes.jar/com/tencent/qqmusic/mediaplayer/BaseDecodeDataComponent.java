package com.tencent.qqmusic.mediaplayer;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.media.AudioTrack.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class BaseDecodeDataComponent
{
  static final int CALL_PREPARED_DELAY_TIME = 20;
  private static int MAX_PLAY_SAMPLE_RATE = 0;
  private static final String TAG = "BaseDecodeDataComponent";
  final List<IAudioListener> audioEffects = new ArrayList(3);
  boolean isUseFloatForHighDepth = false;
  int mAudioStreamType = getAudioStreamType();
  AudioTrack mAudioTrack;
  int mBuffSize;
  final PlayerCallback mCallback;
  final CorePlayer mCorePlayer;
  boolean mCreateAudioTrackFail = false;
  long mCurPosition = 0L;
  final BufferInfo mDecodeBufferInfo = new BufferInfo();
  private final Handler mEventHandler;
  final FloatBufferInfo mFloatBufferInfo = new FloatBufferInfo();
  @NonNull
  final BaseDecodeDataComponent.HandleDecodeDataCallback mHandleDecodeDataCallback;
  boolean mHasDecode = false;
  boolean mHasDecodeSuccess = false;
  boolean mHasInit = false;
  final AudioInformation mInformation;
  int mLeastCommonMultiple = 1;
  volatile boolean mNeedChangePlayThreadPriority = false;
  private final int mPlayerID;
  @NonNull
  final WaitNotify mSignalControl = new WaitNotify();
  @Nullable
  Float mSpeedToSet = null;
  final PlayerStateRunner mStateRunner;
  int mTargetBitDepth = 2;
  long mTargetPlaySample;
  final List<IAudioListener> mTerminalAudioEffectList = new ArrayList();
  @Nullable
  PerformanceTracer performanceTracer = null;
  
  BaseDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, @NonNull BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    this.mCorePlayer = paramCorePlayer;
    this.mStateRunner = paramPlayerStateRunner;
    this.mInformation = paramAudioInformation;
    this.mCallback = paramPlayerCallback;
    this.mHandleDecodeDataCallback = paramHandleDecodeDataCallback;
    this.mEventHandler = paramHandler;
    this.mPlayerID = paramInt;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCallback.playerException(this.mCorePlayer, paramInt1, paramInt2, paramInt3);
  }
  
  private void destroyAudioListeners()
  {
    synchronized (this.audioEffects)
    {
      Iterator localIterator = this.audioEffects.iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerStopped();
      }
      synchronized (this.mTerminalAudioEffectList)
      {
        localIterator = this.mTerminalAudioEffectList.iterator();
        while (localIterator.hasNext()) {
          ((IAudioListener)localIterator.next()).onPlayerStopped();
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  static int getAudioTrackPosition(long paramLong, AudioTrack paramAudioTrack)
  {
    if (paramAudioTrack != null) {
      try
      {
        double d1 = paramLong + paramAudioTrack.getPlaybackHeadPosition();
        int i = paramAudioTrack.getSampleRate();
        double d2 = i;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        paramLong = Math.round(d1 * 1000.0D);
      }
      catch (Exception paramAudioTrack)
      {
        Logger.e("BaseDecodeDataComponent", "getAudioTrackPosition", paramAudioTrack);
      }
    } else {
      paramLong = 0L;
    }
    return (int)paramLong;
  }
  
  @NonNull
  static AudioTrack instantiateAudioTrackCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
      localBuilder.setLegacyStreamType(paramInt1);
      AudioFormat.Builder localBuilder1 = new AudioFormat.Builder();
      localBuilder1.setSampleRate(paramInt2);
      localBuilder1.setEncoding(paramInt4);
      localBuilder1.setChannelMask(paramInt3);
      if (Build.VERSION.SDK_INT >= 23) {
        return new AudioTrack.Builder().setAudioAttributes(localBuilder.build()).setAudioFormat(localBuilder1.build()).setBufferSizeInBytes(paramInt5).setTransferMode(paramInt6).build();
      }
      return new ReportAudioTrack(localBuilder.build(), localBuilder1.build(), paramInt5, paramInt6, 0);
    }
    return new ReportAudioTrack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private static boolean processAudioListener(@NonNull IAudioListener paramIAudioListener, BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong)
  {
    try
    {
      paramBufferInfo2.setByteBufferCapacity(paramBufferInfo1.bufferSize);
      boolean bool = paramIAudioListener.onPcm(paramBufferInfo1, paramBufferInfo2, paramLong);
      return bool;
    }
    catch (Throwable paramBufferInfo1)
    {
      paramBufferInfo2 = new StringBuilder();
      paramBufferInfo2.append("[processAudioListener] failed. audio: ");
      paramBufferInfo2.append(paramIAudioListener);
      Logger.e("BaseDecodeDataComponent", paramBufferInfo2.toString(), paramBufferInfo1);
    }
    return false;
  }
  
  private static boolean processAudioListener(@NonNull IAudioListener paramIAudioListener, FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong)
  {
    try
    {
      paramFloatBufferInfo2.setFloatBufferCapacity(paramFloatBufferInfo1.bufferSize);
      boolean bool = paramIAudioListener.onPcm(paramFloatBufferInfo1, paramFloatBufferInfo2, paramLong);
      return bool;
    }
    catch (Throwable paramFloatBufferInfo1)
    {
      paramFloatBufferInfo2 = new StringBuilder();
      paramFloatBufferInfo2.append("[processAudioListener] failed. audio: ");
      paramFloatBufferInfo2.append(paramIAudioListener);
      Logger.e("BaseDecodeDataComponent", paramFloatBufferInfo2.toString(), paramFloatBufferInfo1);
    }
    return false;
  }
  
  void addAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    StringBuilder localStringBuilder;
    if (paramIAudioListener.isTerminal()) {
      synchronized (this.mTerminalAudioEffectList)
      {
        if (!this.mTerminalAudioEffectList.contains(paramIAudioListener))
        {
          this.mTerminalAudioEffectList.add(paramIAudioListener);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[addAudioListener] terminal audio added: ");
          localStringBuilder.append(paramIAudioListener);
          Logger.i("BaseDecodeDataComponent", localStringBuilder.toString());
        }
      }
    }
    synchronized (this.audioEffects)
    {
      if (!this.audioEffects.contains(paramIAudioListener))
      {
        this.audioEffects.add(paramIAudioListener);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[addAudioListener] audio added: ");
        localStringBuilder.append(paramIAudioListener);
        Logger.i("BaseDecodeDataComponent", localStringBuilder.toString());
      }
      ??? = this.mInformation;
      if ((??? != null) && (((AudioInformation)???).getPlaySample() > 0L) && (this.mInformation.getChannels() > 0))
      {
        long l;
        try
        {
          l = paramIAudioListener.onPlayerReady(this.mTargetBitDepth, this.mInformation, getCurPosition());
        }
        catch (Throwable localThrowable)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[addAudioListener] failed to init audio: ");
          localStringBuilder.append(paramIAudioListener);
          Logger.e("BaseDecodeDataComponent", localStringBuilder.toString(), localThrowable);
          l = 0L;
        }
        if (l != 0L) {
          Logger.e("BaseDecodeDataComponent", "[addAudioListener] failed to init audio %s, ret: %d", new Object[] { paramIAudioListener, Long.valueOf(l) });
        }
      }
      else
      {
        Logger.i("BaseDecodeDataComponent", "[addAudioListener] audio information not ready. init will be delayed.");
      }
      return;
    }
  }
  
  String axiliary(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ID: ");
    localStringBuilder.append(this.mPlayerID);
    localStringBuilder.append(". ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  void callExceptionCallback(int paramInt1, int paramInt2)
  {
    callExceptionCallback(paramInt1, paramInt2, 0);
  }
  
  void changePlayThreadPriorityImmediately()
  {
    Logger.d("BaseDecodeDataComponent", axiliary("changePlayThreadPriorityImmediately"));
    this.mNeedChangePlayThreadPriority = true;
  }
  
  void convertBytePcmToFloatPcm(BufferInfo paramBufferInfo, FloatBufferInfo paramFloatBufferInfo)
  {
    try
    {
      PcmConvertionUtil.convertByteBufferToFloatBuffer(paramBufferInfo, paramFloatBufferInfo, this.mInformation.getBitDepth());
      return;
    }
    catch (Throwable paramBufferInfo)
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo);
    }
  }
  
  void doWaitForPaused()
  {
    this.mSignalControl.doWait(2000L, 5, new BaseDecodeDataComponent.1(this));
  }
  
  void flush() {}
  
  abstract int getAudioStreamType();
  
  abstract long getCurPosition();
  
  int getMaxSupportSampleRate()
  {
    int i = MAX_PLAY_SAMPLE_RATE;
    if (i > 0) {
      return i;
    }
    label141:
    try
    {
      localObject = AudioFormat.class.getDeclaredField("SAMPLE_RATE_HZ_MAX");
      ((Field)localObject).setAccessible(true);
      MAX_PLAY_SAMPLE_RATE = ((Field)localObject).getInt(null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get the max sample rate support by system from AudioFormat = ");
      ((StringBuilder)localObject).append(MAX_PLAY_SAMPLE_RATE);
      Logger.i("BaseDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      i = MAX_PLAY_SAMPLE_RATE;
      return i;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      label76:
      break label76;
    }
    try
    {
      localObject = AudioTrack.class.getDeclaredField("SAMPLE_RATE_HZ_MAX");
      ((Field)localObject).setAccessible(true);
      MAX_PLAY_SAMPLE_RATE = ((Field)localObject).getInt(null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get the max sample rate support by system from AudioTrack = ");
      ((StringBuilder)localObject).append(MAX_PLAY_SAMPLE_RATE);
      Logger.i("BaseDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      i = MAX_PLAY_SAMPLE_RATE;
      return i;
    }
    catch (Throwable localThrowable2)
    {
      break label141;
    }
    Logger.i("BaseDecodeDataComponent", axiliary("can't reflect max sample rate, use default sample rate"));
    if (Build.VERSION.SDK_INT < 21) {
      return 48000;
    }
    if (Build.VERSION.SDK_INT < 22) {
      return 96000;
    }
    return 192000;
  }
  
  int getMinBufferSize(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = AudioTrack.getMinBufferSize((int)paramLong, paramInt1, paramInt2);
    int i = j;
    if (j < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("minBufferSize = ");
      localStringBuilder.append(j);
      localStringBuilder.append(" mTargetPlaySample = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("  channelConfiguration = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("   pcmEncoding = ");
      localStringBuilder.append(paramInt2);
      Logger.i("BaseDecodeDataComponent", axiliary(localStringBuilder.toString()));
      i = paramInt3 * 3536 * paramInt4;
    }
    return i;
  }
  
  int getPlayerState()
  {
    return this.mStateRunner.get().intValue();
  }
  
  int getSessionId()
  {
    AudioTrack localAudioTrack = this.mAudioTrack;
    if (localAudioTrack != null) {
      return localAudioTrack.getAudioSessionId();
    }
    return 0;
  }
  
  abstract void handleDecodeData();
  
  void handleHighBitDepth(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2)
  {
    if (this.isUseFloatForHighDepth)
    {
      paramBufferInfo1.fillInto(paramBufferInfo2);
      return;
    }
    try
    {
      PcmConvertionUtil.convertBitDepthTo16(paramBufferInfo1, paramBufferInfo2, this.mInformation.getBitDepth());
      return;
    }
    catch (Throwable paramBufferInfo1)
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo1);
    }
  }
  
  void handleHighSample(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2)
  {
    try
    {
      PcmConvertionUtil.reSample(paramBufferInfo1, paramBufferInfo2, this.mInformation.getSampleRate(), this.mTargetPlaySample, this.mTargetBitDepth);
      return;
    }
    catch (Throwable paramBufferInfo1)
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo1);
    }
  }
  
  boolean hasDecodeData()
  {
    try
    {
      boolean bool = this.mHasDecode;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean hasDecodeDataSuccess()
  {
    try
    {
      boolean bool = this.mHasDecodeSuccess;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void initAudioListeners(int paramInt, AudioInformation paramAudioInformation, long paramLong)
  {
    synchronized (this.audioEffects)
    {
      Iterator localIterator = this.audioEffects.iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerReady(paramInt, paramAudioInformation, paramLong);
      }
      synchronized (this.mTerminalAudioEffectList)
      {
        localIterator = this.mTerminalAudioEffectList.iterator();
        while (localIterator.hasNext()) {
          ((IAudioListener)localIterator.next()).onPlayerReady(paramInt, paramAudioInformation, paramLong);
        }
        return;
      }
    }
    for (;;)
    {
      throw paramAudioInformation;
    }
  }
  
  boolean isCompleted()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(7) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isError()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(9) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isIdle()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(0) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isInit()
  {
    return this.mHasInit;
  }
  
  protected boolean isPaused()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(5) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isPlaying()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(4) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isStopped()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(6) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isSupportHighBitDepth()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  void notifySeekCompleteForAudioListeners(long paramLong)
  {
    synchronized (this.audioEffects)
    {
      Iterator localIterator = this.audioEffects.iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerSeekComplete(paramLong);
      }
      synchronized (this.mTerminalAudioEffectList)
      {
        localIterator = this.mTerminalAudioEffectList.iterator();
        while (localIterator.hasNext()) {
          ((IAudioListener)localIterator.next()).onPlayerSeekComplete(paramLong);
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void pause(boolean paramBoolean)
  {
    Logger.i("BaseDecodeDataComponent", axiliary("pause"));
    this.mStateRunner.transfer(Integer.valueOf(5), new Integer[] { Integer.valueOf(4), Integer.valueOf(2) });
  }
  
  void play()
  {
    Logger.i("BaseDecodeDataComponent", axiliary("play"));
    PlayerStateRunner localPlayerStateRunner = this.mStateRunner;
    Integer localInteger = Integer.valueOf(4);
    localPlayerStateRunner.transfer(localInteger, new Integer[] { Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(6), localInteger });
    if (this.mSignalControl.isWaiting())
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: play, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  void postRunnable(Runnable paramRunnable, int paramInt)
  {
    this.mEventHandler.postDelayed(paramRunnable, paramInt);
  }
  
  void processAudioListeners(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2)
  {
    synchronized (this.audioEffects)
    {
      if (this.audioEffects.size() == 0)
      {
        paramBufferInfo1.fillInto(paramBufferInfo2);
      }
      else
      {
        Iterator localIterator = this.audioEffects.iterator();
        Object localObject2 = paramBufferInfo1;
        Object localObject1 = paramBufferInfo2;
        while (localIterator.hasNext())
        {
          Object localObject3 = (IAudioListener)localIterator.next();
          if (((IAudioListener)localObject3).isEnabled())
          {
            if (processAudioListener((IAudioListener)localObject3, (BufferInfo)localObject2, (BufferInfo)localObject1, this.mCorePlayer.getCurPositionByDecoder()))
            {
              localObject3 = localObject1;
              localObject1 = localObject2;
            }
            else
            {
              ((BufferInfo)localObject2).fillInto((BufferInfo)localObject1);
              localObject3 = localObject2;
            }
          }
          else
          {
            ((BufferInfo)localObject2).fillInto((BufferInfo)localObject1);
            localObject3 = localObject2;
          }
          int i = ((BufferInfo)localObject1).bufferSize;
          localObject2 = localObject3;
        }
        if (localObject2 == paramBufferInfo1) {
          paramBufferInfo1.fillInto(paramBufferInfo2);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramBufferInfo1;
    }
  }
  
  void processAudioListeners(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2)
  {
    synchronized (this.audioEffects)
    {
      if (this.audioEffects.size() == 0)
      {
        paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
      }
      else
      {
        Iterator localIterator = this.audioEffects.iterator();
        Object localObject2 = paramFloatBufferInfo1;
        Object localObject1 = paramFloatBufferInfo2;
        while (localIterator.hasNext())
        {
          Object localObject3 = (IAudioListener)localIterator.next();
          if (((IAudioListener)localObject3).isEnabled())
          {
            if (processAudioListener((IAudioListener)localObject3, (FloatBufferInfo)localObject2, (FloatBufferInfo)localObject1, this.mCorePlayer.getCurPositionByDecoder()))
            {
              localObject3 = localObject1;
              localObject1 = localObject2;
            }
            else
            {
              ((FloatBufferInfo)localObject2).copy((FloatBufferInfo)localObject1);
              localObject3 = localObject2;
            }
          }
          else
          {
            ((FloatBufferInfo)localObject2).copy((FloatBufferInfo)localObject1);
            localObject3 = localObject2;
          }
          int i = ((FloatBufferInfo)localObject1).bufferSize;
          localObject2 = localObject3;
        }
        if (localObject2 == paramFloatBufferInfo1) {
          paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramFloatBufferInfo1;
    }
  }
  
  void refreshTimeAndNotify(int paramInt)
  {
    if (this.mSignalControl.isWaiting())
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: seek, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  void release()
  {
    AudioTrack localAudioTrack = this.mAudioTrack;
    if (localAudioTrack != null)
    {
      try
      {
        localAudioTrack.stop();
      }
      catch (Throwable localThrowable1)
      {
        Logger.e("BaseDecodeDataComponent", localThrowable1);
      }
      try
      {
        this.mAudioTrack.flush();
      }
      catch (Throwable localThrowable2)
      {
        Logger.e("BaseDecodeDataComponent", localThrowable2);
      }
      try
      {
        this.mAudioTrack.release();
      }
      catch (Throwable localThrowable3)
      {
        Logger.e("BaseDecodeDataComponent", localThrowable3);
      }
      try
      {
        destroyAudioListeners();
      }
      catch (Throwable localThrowable4)
      {
        Logger.i("BaseDecodeDataComponent", "[run] failed to destroyAudioListeners!", localThrowable4);
      }
      setAudioTrack(null);
      Logger.d("BaseDecodeDataComponent", axiliary("finally release audioTrack"));
    }
    if (!this.mCorePlayer.mIsExit)
    {
      if (this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(7) }))
      {
        this.mCallback.playerEnded(this.mCorePlayer);
        return;
      }
      this.mCallback.playerStopped(this.mCorePlayer);
    }
  }
  
  void releaseNotify()
  {
    if (this.mSignalControl.isWaiting())
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: release, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  void removeAudioListener(@NonNull IAudioListener paramIAudioListener)
  {
    synchronized (this.audioEffects)
    {
      StringBuilder localStringBuilder;
      if (this.audioEffects.remove(paramIAudioListener))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[removeAudioListener] audio removed: ");
        localStringBuilder.append(paramIAudioListener);
        Logger.i("BaseDecodeDataComponent", localStringBuilder.toString());
      }
      synchronized (this.mTerminalAudioEffectList)
      {
        if (this.mTerminalAudioEffectList.remove(paramIAudioListener))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[removeAudioListener] terminal audio removed: ");
          localStringBuilder.append(paramIAudioListener);
          Logger.i("BaseDecodeDataComponent", localStringBuilder.toString());
        }
        return;
      }
    }
  }
  
  void seek(int paramInt) {}
  
  void setAudioStreamType(int paramInt)
  {
    if (paramInt == this.mAudioStreamType) {
      return;
    }
    this.mAudioStreamType = paramInt;
  }
  
  void setAudioTrack(AudioTrack paramAudioTrack)
  {
    this.mAudioTrack = paramAudioTrack;
    this.mHandleDecodeDataCallback.onAudioTrackChanged(paramAudioTrack);
  }
  
  void setLeastCommonMultiple(int paramInt)
  {
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wrong least common multiple: ");
      localStringBuilder.append(paramInt);
      Logger.e("BaseDecodeDataComponent", localStringBuilder.toString());
      return;
    }
    this.mLeastCommonMultiple = paramInt;
  }
  
  void setPerformanceTracer(PerformanceTracer paramPerformanceTracer)
  {
    this.performanceTracer = paramPerformanceTracer;
  }
  
  void setSpeed(float paramFloat)
  {
    this.mSpeedToSet = Float.valueOf(paramFloat);
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    AudioTrack localAudioTrack = this.mAudioTrack;
    if (localAudioTrack != null) {
      try
      {
        localAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logger.e("BaseDecodeDataComponent", "setVolume", localIllegalStateException);
      }
    }
  }
  
  void stop()
  {
    Logger.i("BaseDecodeDataComponent", axiliary("stop"));
    if ((this.mStateRunner.transfer(Integer.valueOf(6), new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(2) })) && (this.mSignalControl.isWaiting()))
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: stop, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */