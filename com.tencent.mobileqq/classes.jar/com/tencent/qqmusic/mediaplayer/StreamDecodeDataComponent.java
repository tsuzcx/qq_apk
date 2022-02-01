package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class StreamDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
  private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
  private static final String TAG = "StreamDecodeDataComponent";
  private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 5000;
  private long mCurrentFrameCount = 0L;
  private boolean mNeedFlush = false;
  private final Stack<Integer> mSeekRecord = new Stack();
  private int mTrackBufferSizeInByte;
  
  StreamDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
  }
  
  private void addSeekRecord(int paramInt)
  {
    synchronized (this.mSeekRecord)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add seek: ");
      localStringBuilder.append(paramInt);
      Logger.i("StreamDecodeDataComponent", localStringBuilder.toString());
      this.mSeekRecord.push(Integer.valueOf(paramInt));
      return;
    }
  }
  
  private boolean createAudioTrack()
  {
    Logger.d("StreamDecodeDataComponent", axiliary("createAudioTrack"));
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StreamDecodeDataComponent", "mState is not preparing");
      callExceptionCallback(91, 54);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StreamDecodeDataComponent", "mInformation.getSampleRate() failed");
      callExceptionCallback(91, 64);
      return false;
    }
    int i2 = this.mInformation.getChannels();
    int i;
    if (i2 == 1)
    {
      i = 4;
    }
    else
    {
      if (i2 == 2) {}
      do
      {
        i = 12;
        break;
        if (i2 == 6)
        {
          i = 252;
          break;
        }
      } while (i2 != 8);
      i = 1020;
    }
    Logger.d("StreamDecodeDataComponent", axiliary(this.mInformation.toString()));
    for (this.mTargetPlaySample = this.mInformation.getSampleRate(); this.mTargetPlaySample > getMaxSupportSampleRate(); this.mTargetPlaySample /= 2L) {}
    int k = this.mInformation.getBitDepth();
    if (k == 0) {
      k = 2;
    }
    if ((isSupportHighBitDepth()) && (this.mInformation.getBitDepth() >= 3))
    {
      this.mTargetBitDepth = k;
      this.isUseFloatForHighDepth = true;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("will use float resampled pcm for Hi-Res, bitDept: ");
        localStringBuilder1.append(this.mInformation.getBitDepth());
        localStringBuilder1.append(", origin sample rate: ");
        localStringBuilder1.append(this.mInformation.getSampleRate());
        localStringBuilder1.append(", target sample rate: ");
        localStringBuilder1.append(this.mTargetPlaySample);
        Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("will use float pcm for Hi-Res, bitDept: ");
        localStringBuilder1.append(this.mInformation.getBitDepth());
        localStringBuilder1.append(", sample rate: ");
        localStringBuilder1.append(this.mTargetPlaySample);
        Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
      }
    }
    else if ((!isSupportHighBitDepth()) && (this.mInformation.getBitDepth() >= 3))
    {
      this.mTargetBitDepth = 2;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("will use byte pcm resampled and bitDept converted, origin bitDept: ");
        localStringBuilder1.append(this.mInformation.getBitDepth());
        localStringBuilder1.append(", target bitDept: ");
        localStringBuilder1.append(this.mTargetBitDepth);
        localStringBuilder1.append(", origin sample rate: ");
        localStringBuilder1.append(this.mInformation.getSampleRate());
        localStringBuilder1.append(", target sample rate: ");
        localStringBuilder1.append(this.mTargetPlaySample);
        Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("will use byte pcm with bitDept converted, origin bitDept: ");
        localStringBuilder1.append(this.mInformation.getBitDepth());
        localStringBuilder1.append(", target bitDept: ");
        localStringBuilder1.append(this.mTargetBitDepth);
        Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
      }
    }
    else
    {
      this.mTargetBitDepth = k;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("will use byte pcm resampled, bitDept: ");
      localStringBuilder1.append(this.mInformation.getBitDepth());
      localStringBuilder1.append(", origin sample rate: ");
      localStringBuilder1.append(this.mInformation.getSampleRate());
      localStringBuilder1.append(", target sample rate: ");
      localStringBuilder1.append(this.mTargetPlaySample);
      Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
    }
    int j;
    if (k == 1) {
      j = 3;
    } else if ((k != 2) && (this.isUseFloatForHighDepth)) {
      j = 4;
    } else {
      j = 2;
    }
    int n = (int)this.mHandleDecodeDataCallback.getMinPcmBufferSize();
    long l = this.mTargetPlaySample;
    int m = k;
    int i1 = getMinBufferSize(l, i, j, i2, k);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[createAudioTrack] playback_bufsize:");
    localStringBuilder1.append(i1);
    localStringBuilder1.append(" decoderBufsizeInByte:");
    localStringBuilder1.append(n);
    Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
    k = i1;
    if (this.mLeastCommonMultiple > 1) {
      k = getLcm(this.mLeastCommonMultiple, i1);
    }
    i1 = n;
    if (k > n) {
      i1 = k;
    }
    this.mBuffSize = i1;
    Logger.i("StreamDecodeDataComponent", axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mTargetPlaySample: %d, playChannel: %d, pcmEncoding: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mTargetPlaySample), Integer.valueOf(i2), Integer.valueOf(j) })));
    n = Math.max((int)(Math.floor(this.mTargetPlaySample * 1L * i2 * 2L / k) + 1.0D), 1);
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("times: ");
    localStringBuilder1.append(n);
    localStringBuilder1.append(", MIN_AUDIO_TRACK_BUFFER_TIMES: ");
    localStringBuilder1.append(1);
    Logger.d("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
    while (n >= 1)
    {
      try
      {
        this.mTrackBufferSizeInByte = (k * n);
        setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int)this.mTargetPlaySample, i, j, this.mTrackBufferSizeInByte, 1));
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[createAudioTrack] new AudioTrack, sampleRate: ");
        localStringBuilder1.append(this.mTargetPlaySample);
        localStringBuilder1.append(", channels: ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(", bitDepth: ");
        try
        {
          localStringBuilder1.append(m);
          localStringBuilder1.append(", buffer: ");
          localStringBuilder1.append(this.mTrackBufferSizeInByte);
          Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
          i1 = this.mAudioTrack.getState();
          if (i1 == 1)
          {
            Logger.i("StreamDecodeDataComponent", axiliary("new AudioTrack succeed"));
            break;
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("audioTrack create fail!!! state = ");
          localStringBuilder1.append(i1);
          Logger.e("StreamDecodeDataComponent", axiliary(localStringBuilder1.toString()));
          this.mAudioTrack.release();
        }
        catch (Throwable localThrowable1) {}
        Logger.e("StreamDecodeDataComponent", localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      n -= 2;
    }
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 1))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("create audioTrack success times = ");
      localStringBuilder2.append(n);
      Logger.d("StreamDecodeDataComponent", axiliary(localStringBuilder2.toString()));
      this.mStateRunner.setAudioTrack(this.mAudioTrack);
      return true;
    }
    this.mCreateAudioTrackFail = true;
    Logger.e("StreamDecodeDataComponent", axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
    setAudioTrack(null);
    callExceptionCallback(92, 66);
    return false;
  }
  
  private long getCalcBitMinSize(AudioInformation paramAudioInformation)
  {
    if (paramAudioInformation != null) {
      return ((float)(paramAudioInformation.getSampleRate() * paramAudioInformation.getChannels() * paramAudioInformation.getBitDepth()) * 5.0F / 1000.0F);
    }
    return 0L;
  }
  
  private int getGcd(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 <= 0) {
        break;
      }
      paramInt2 = i % paramInt1;
    }
    return i;
  }
  
  private int getLcm(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 / getGcd(paramInt1, paramInt2);
  }
  
  @NonNull
  private BufferInfo initTempBufferInfoIfNeeded(BufferInfo paramBufferInfo, int paramInt)
  {
    BufferInfo localBufferInfo = paramBufferInfo;
    if (paramBufferInfo == null)
    {
      localBufferInfo = new BufferInfo();
      localBufferInfo.setByteBufferCapacity(paramInt);
    }
    return localBufferInfo;
  }
  
  @NonNull
  private FloatBufferInfo initTempFloatBufferInfoIfNeeded(FloatBufferInfo paramFloatBufferInfo, int paramInt)
  {
    FloatBufferInfo localFloatBufferInfo = paramFloatBufferInfo;
    if (paramFloatBufferInfo == null)
    {
      localFloatBufferInfo = new FloatBufferInfo();
      localFloatBufferInfo.setFloatBufferCapacity(paramInt);
    }
    return localFloatBufferInfo;
  }
  
  void flush()
  {
    this.mNeedFlush = true;
  }
  
  int getAudioStreamType()
  {
    return 3;
  }
  
  long getCurPosition()
  {
    Object localObject = this.mAudioTrack;
    if ((localObject != null) && (((AudioTrack)localObject).getState() != 0))
    {
      AudioInformation localAudioInformation = this.mInformation;
      if (localAudioInformation == null) {
        return this.mCurPosition;
      }
      long l1 = getAudioTrackPosition(this.mCurrentFrameCount, (AudioTrack)localObject);
      localObject = this.audioEffects.iterator();
      while (((Iterator)localObject).hasNext()) {
        l1 = ((IAudioListener)((Iterator)localObject).next()).getActualTime(l1);
      }
      long l2 = localAudioInformation.getChannels() * this.mTargetBitDepth * localAudioInformation.getPlaySample();
      if (l2 > 0L) {
        l2 = 1000L * (this.mTrackBufferSizeInByte / l2);
      } else {
        l2 = 0L;
      }
      l2 = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, l2);
      if (l2 < 0L) {
        this.mCurPosition = l1;
      } else if ((l1 > 0L) && (Math.abs(l1 - l2) < 5000L)) {
        this.mCurPosition = l1;
      } else {
        this.mCurPosition = l2;
      }
      return this.mCurPosition;
    }
    return this.mCurPosition;
  }
  
  void handleDecodeData()
  {
    Object localObject6 = this;
    AudioInformation localAudioInformation = ((StreamDecodeDataComponent)localObject6).mInformation;
    Integer localInteger = Integer.valueOf(9);
    Object localObject1;
    int i3;
    long l3;
    Object localObject5;
    long l1;
    long l2;
    int i;
    int j;
    int m;
    int k;
    int n;
    int i1;
    if ((localAudioInformation != null) && (!((StreamDecodeDataComponent)localObject6).mCorePlayer.mIsExit))
    {
      try
      {
        if (0L == ((StreamDecodeDataComponent)localObject6).mInformation.getSampleRate())
        {
          Logger.e("StreamDecodeDataComponent", "failed to getSampleRate");
          ((StreamDecodeDataComponent)localObject6).mStateRunner.transfer(localInteger);
          ((StreamDecodeDataComponent)localObject6).callExceptionCallback(91, 63);
          return;
        }
        ((StreamDecodeDataComponent)localObject6).mHasInit = true;
        if (!createAudioTrack())
        {
          Logger.e("StreamDecodeDataComponent", "failed to createAudioTrack");
          ((StreamDecodeDataComponent)localObject6).mStateRunner.transfer(localInteger);
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException1)
      {
        Logger.e("StreamDecodeDataComponent", localSoNotFindException1);
        localObject1 = ((StreamDecodeDataComponent)localObject6).mStateRunner;
        i3 = 2;
        ((PlayerStateRunner)localObject1).transfer(Integer.valueOf(2));
        ((StreamDecodeDataComponent)localObject6).initAudioListeners(((StreamDecodeDataComponent)localObject6).mTargetBitDepth, ((StreamDecodeDataComponent)localObject6).mInformation, getCurPosition());
        ((StreamDecodeDataComponent)localObject6).postRunnable(new StreamDecodeDataComponent.1((StreamDecodeDataComponent)localObject6), 20);
        if ((!isPlaying()) && (!((StreamDecodeDataComponent)localObject6).mCorePlayer.mIsExit))
        {
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("prepared. waiting..."));
          ((StreamDecodeDataComponent)localObject6).mSignalControl.doWait();
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("woke after preparing"));
        }
        PlayerConfigManager.getInstance().setCommonPlayerRef(((StreamDecodeDataComponent)localObject6).mCorePlayer);
        ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.setByteBufferCapacity(((StreamDecodeDataComponent)localObject6).mBuffSize);
        l3 = System.currentTimeMillis();
        localObject5 = null;
        localObject1 = localObject5;
        l1 = 0L;
        l2 = l1;
        i = 0;
        j = 0;
        m = 1;
        k = 0;
        n = 0;
        i1 = 0;
      }
      if (!((StreamDecodeDataComponent)localObject6).mCorePlayer.mIsExit) {
        if ((((StreamDecodeDataComponent)localObject6).mSpeedToSet != null) && (((StreamDecodeDataComponent)localObject6).mAudioTrack != null) && (Build.VERSION.SDK_INT >= 23))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("setSpeed:");
          ((StringBuilder)???).append(((StreamDecodeDataComponent)localObject6).mSpeedToSet);
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
          ??? = ((StreamDecodeDataComponent)localObject6).mAudioTrack.getPlaybackParams();
          ((PlaybackParams)???).setSpeed(((StreamDecodeDataComponent)localObject6).mSpeedToSet.floatValue());
          ((StreamDecodeDataComponent)localObject6).mSpeedToSet = null;
          ((StreamDecodeDataComponent)localObject6).mAudioTrack.setPlaybackParams((PlaybackParams)???);
        }
      }
    }
    for (;;)
    {
      synchronized (((StreamDecodeDataComponent)localObject6).mSeekRecord)
      {
        if (((StreamDecodeDataComponent)localObject6).mSeekRecord.empty()) {
          break label3129;
        }
        i2 = ((Integer)((StreamDecodeDataComponent)localObject6).mSeekRecord.pop()).intValue();
        ((StreamDecodeDataComponent)localObject6).mSeekRecord.clear();
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("execute seek: ");
        ((StringBuilder)localObject8).append(i2);
        ((StringBuilder)localObject8).append(", abandon the others");
        Logger.i("StreamDecodeDataComponent", ((StringBuilder)localObject8).toString());
        int i4 = i2;
        if (i2 < 0)
        {
          i4 = i2;
          if (((StreamDecodeDataComponent)localObject6).mNeedFlush)
          {
            i4 = getAudioTrackPosition(((StreamDecodeDataComponent)localObject6).mCurrentFrameCount, ((StreamDecodeDataComponent)localObject6).mAudioTrack);
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[run] flashback to ");
            ((StringBuilder)???).append(i4);
            Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
            ((StreamDecodeDataComponent)localObject6).mNeedFlush = false;
          }
        }
        if (i4 >= 0)
        {
          i2 = ((StreamDecodeDataComponent)localObject6).mHandleDecodeDataCallback.seekTo(i4);
          if (i2 < 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("seekTo failed: ");
            ((StringBuilder)localObject1).append(i2);
            Logger.e("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)localObject1).toString()));
            ((StreamDecodeDataComponent)localObject6).mStateRunner.transfer(localInteger);
            ((StreamDecodeDataComponent)localObject6).callExceptionCallback(95, 74);
            return;
          }
          if (((StreamDecodeDataComponent)localObject6).mAudioTrack != null)
          {
            double d1 = i4;
            Double.isNaN(d1);
            d1 /= 1000.0D;
            double d2 = ((StreamDecodeDataComponent)localObject6).mAudioTrack.getSampleRate();
            Double.isNaN(d2);
            ((StreamDecodeDataComponent)localObject6).mCurrentFrameCount = Math.round(d1 * d2);
            if (((StreamDecodeDataComponent)localObject6).mAudioTrack.getPlayState() == 3)
            {
              ((StreamDecodeDataComponent)localObject6).mAudioTrack.pause();
              ((StreamDecodeDataComponent)localObject6).mAudioTrack.flush();
              ((StreamDecodeDataComponent)localObject6).mAudioTrack.play();
            }
            else
            {
              ((StreamDecodeDataComponent)localObject6).mAudioTrack.flush();
            }
            i = 0;
          }
          l4 = i4;
          ((StreamDecodeDataComponent)localObject6).mCurPosition = l4;
          ((StreamDecodeDataComponent)localObject6).notifySeekCompleteForAudioListeners(l4);
          ((StreamDecodeDataComponent)localObject6).mCallback.playerSeekCompletion(((StreamDecodeDataComponent)localObject6).mCorePlayer, i4);
        }
        if (isPaused())
        {
          if (((StreamDecodeDataComponent)localObject6).mAudioTrack.getPlayState() != i3) {
            ((StreamDecodeDataComponent)localObject6).mAudioTrack.pause();
          }
          ((StreamDecodeDataComponent)localObject6).postRunnable(new StreamDecodeDataComponent.2((StreamDecodeDataComponent)localObject6), 20);
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("paused. waiting..."));
          doWaitForPaused();
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("woke after pausing"));
          break;
        }
        if (isIdle()) {
          return;
        }
        if (isError()) {
          return;
        }
        if (isStopped()) {
          return;
        }
        if (isCompleted())
        {
          k = i / ((StreamDecodeDataComponent)localObject6).mInformation.getChannels() - j;
          if (k <= 0) {
            k = 0;
          }
          n = ((StreamDecodeDataComponent)localObject6).mTrackBufferSizeInByte / ((StreamDecodeDataComponent)localObject6).mTargetBitDepth / ((StreamDecodeDataComponent)localObject6).mInformation.getChannels();
          m = n;
          if (k < n) {
            m = k;
          }
          k = (int)(m * 1000 / ((StreamDecodeDataComponent)localObject6).mInformation.getSampleRate());
          m = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("writeShortCount: ");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(", playFramePosition: ");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(", leftTimeInMs: ");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(", minAudioTrackWaitTimeMs: ");
          ((StringBuilder)localObject1).append(m);
          Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)localObject1).toString()));
          if (k <= 0) {
            break label3083;
          }
          try
          {
            localObject6.wait(Math.max(m, k));
            return;
          }
          finally {}
        }
        if ((isPlaying()) && (((StreamDecodeDataComponent)localObject6).mAudioTrack.getPlayState() != 3)) {
          ((StreamDecodeDataComponent)localObject6).mAudioTrack.play();
        }
        if (m != 0)
        {
          if (k != 0) {}
          try
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("writeFail = true,  mBuffSize = ");
            ((StringBuilder)???).append(((StreamDecodeDataComponent)localObject6).mBuffSize);
            Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
            Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("there is no need to read more pcm data, just use writeFailByteArray"));
            n = 0;
            continue;
            n = ((StreamDecodeDataComponent)localObject6).mHandleDecodeDataCallback.pullDecodeData(((StreamDecodeDataComponent)localObject6).mBuffSize, ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.byteBuffer);
            ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize = n;
            l1 += ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize;
            l2 += ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize;
            ((StreamDecodeDataComponent)localObject6).mHasDecode = true;
            if (i1 == 0)
            {
              long l6 = ((StreamDecodeDataComponent)localObject6).getCalcBitMinSize(((StreamDecodeDataComponent)localObject6).mInformation);
              ??? = new StringBuilder();
              ((StringBuilder)???).append("minSize: ");
              ((StringBuilder)???).append(l6);
              ((StringBuilder)???).append(", mDecodeBufferInfo.bufferSize: ");
              ((StringBuilder)???).append(((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize);
              Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
              i1 = n;
              l5 = l1;
              l4 = l2;
              if (l6 > 0L)
              {
                i2 = 10;
                i1 = n;
                l5 = l1;
                l4 = l2;
                if (((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize < l6)
                {
                  i1 = n;
                  l5 = l1;
                  l4 = l2;
                  if (i2 >= 0)
                  {
                    ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.setTempByteBufferCapacity(((StreamDecodeDataComponent)localObject6).mBuffSize);
                    n = ((StreamDecodeDataComponent)localObject6).mHandleDecodeDataCallback.pullDecodeData(((StreamDecodeDataComponent)localObject6).mBuffSize, ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.tempByteBuffer);
                    l5 = l1;
                    l4 = l2;
                    if (n > 0)
                    {
                      ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.appendByte(((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.tempByteBuffer, 0, n);
                      ??? = ((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo;
                      ((BufferInfo)???).bufferSize += n;
                      l4 = n;
                      l5 = l1 + l4;
                      l4 = l2 + l4;
                    }
                    i2 -= 1;
                    ??? = new StringBuilder();
                    ((StringBuilder)???).append("decode tmpSize: ");
                    ((StringBuilder)???).append(n);
                    ((StringBuilder)???).append(", mDecodeBufferInfo.bufferSize: ");
                    ((StringBuilder)???).append(((StreamDecodeDataComponent)localObject6).mDecodeBufferInfo.bufferSize);
                    Logger.d("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
                    l1 = l5;
                    l2 = l4;
                    continue;
                  }
                }
              }
              if (((StreamDecodeDataComponent)localObject6).mInformation.getBitDepth() == 0)
              {
                ((StreamDecodeDataComponent)localObject6).mTargetBitDepth = AudioRecognition.calcBitDept(l5, ((StreamDecodeDataComponent)localObject6).mHandleDecodeDataCallback.getCurPositionByDecoder(), ((StreamDecodeDataComponent)localObject6).mInformation.getChannels(), ((StreamDecodeDataComponent)localObject6).mInformation.getSampleRate());
                ((StreamDecodeDataComponent)localObject6).mInformation.setBitDept(((StreamDecodeDataComponent)localObject6).mTargetBitDepth);
                ??? = new StringBuilder();
                ((StringBuilder)???).append("create audiotrack with wrong bitDepth, there may cause some problem!! ");
                ((StringBuilder)???).append(((StreamDecodeDataComponent)localObject6).mTargetBitDepth);
                Logger.w("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
              }
              i2 = ((StreamDecodeDataComponent)localObject6).mTargetBitDepth;
              ??? = new StringBuilder();
              ((StringBuilder)???).append("mPlayBitDept: ");
              ((StringBuilder)???).append(i2);
              Logger.d("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary(((StringBuilder)???).toString()));
              n = i1;
              l1 = l5;
              l2 = l4;
            }
            else
            {
              i2 = i1;
            }
            i1 = i2;
          }
          catch (SoNotFindException localSoNotFindException2)
          {
            Logger.e("StreamDecodeDataComponent", localSoNotFindException2);
            ((StreamDecodeDataComponent)localObject6).mStateRunner.transfer(localInteger);
            ((StreamDecodeDataComponent)localObject6).callExceptionCallback(92, 62);
            return;
          }
        }
        if (((StreamDecodeDataComponent)localObject6).mNeedChangePlayThreadPriority)
        {
          ((StreamDecodeDataComponent)localObject6).mNeedChangePlayThreadPriority = false;
          PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        }
        long l4 = System.currentTimeMillis();
        long l5 = l4 - l3;
        if (l5 > 1000L)
        {
          PlayerConfigManager.getInstance().updateDecodeSpeed(((float)l2 * 1.0F / (float)l5));
          l2 = 0L;
          l3 = l4;
        }
        ??? = this;
        if (((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize > 0)
        {
          if (!((StreamDecodeDataComponent)???).mHasDecodeSuccess)
          {
            ((StreamDecodeDataComponent)???).mCallback.playerStarted(((StreamDecodeDataComponent)???).mCorePlayer);
            ((StreamDecodeDataComponent)???).mHasDecodeSuccess = true;
          }
          Object localObject3;
          if (k == 0)
          {
            if ((((StreamDecodeDataComponent)???).mTargetBitDepth != ((StreamDecodeDataComponent)???).mInformation.getBitDepth()) && (!((StreamDecodeDataComponent)???).isUseFloatForHighDepth))
            {
              localObject5 = ((StreamDecodeDataComponent)???).initTempBufferInfoIfNeeded((BufferInfo)localObject5, ((StreamDecodeDataComponent)???).mBuffSize);
              ((StreamDecodeDataComponent)???).handleHighBitDepth(((StreamDecodeDataComponent)???).mDecodeBufferInfo, (BufferInfo)localObject5);
              ((BufferInfo)localObject5).fillInto(((StreamDecodeDataComponent)???).mDecodeBufferInfo);
            }
            localObject6 = localObject5;
            if (((StreamDecodeDataComponent)???).mTargetPlaySample != ((StreamDecodeDataComponent)???).mInformation.getSampleRate())
            {
              localObject6 = ((StreamDecodeDataComponent)???).initTempBufferInfoIfNeeded((BufferInfo)localObject5, ((StreamDecodeDataComponent)???).mBuffSize);
              ((StreamDecodeDataComponent)???).handleHighSample(((StreamDecodeDataComponent)???).mDecodeBufferInfo, (BufferInfo)localObject6);
              ((BufferInfo)localObject6).fillInto(((StreamDecodeDataComponent)???).mDecodeBufferInfo);
            }
            if (((StreamDecodeDataComponent)???).isUseFloatForHighDepth)
            {
              ((StreamDecodeDataComponent)???).convertBytePcmToFloatPcm(((StreamDecodeDataComponent)???).mDecodeBufferInfo, ((StreamDecodeDataComponent)???).mFloatBufferInfo);
              if (!((StreamDecodeDataComponent)???).audioEffects.isEmpty())
              {
                localObject3 = ((StreamDecodeDataComponent)???).initTempFloatBufferInfoIfNeeded(localSoNotFindException2, ((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize);
                ((StreamDecodeDataComponent)???).processAudioListeners(((StreamDecodeDataComponent)???).mFloatBufferInfo, (FloatBufferInfo)localObject3);
                ((StreamDecodeDataComponent)???).mFloatBufferInfo.fillFloat(((FloatBufferInfo)localObject3).floatBuffer, ((FloatBufferInfo)localObject3).bufferSize);
                localObject5 = localObject6;
              }
              else
              {
                localObject5 = localObject6;
              }
            }
            else
            {
              localObject8 = localObject3;
              localObject5 = localObject6;
              localObject3 = localObject8;
              if (!((StreamDecodeDataComponent)???).audioEffects.isEmpty())
              {
                localObject5 = ((StreamDecodeDataComponent)???).initTempBufferInfoIfNeeded((BufferInfo)localObject6, ((StreamDecodeDataComponent)???).mBuffSize);
                ((StreamDecodeDataComponent)???).processAudioListeners(((StreamDecodeDataComponent)???).mDecodeBufferInfo, (BufferInfo)localObject5);
                ((BufferInfo)localObject5).fillInto(((StreamDecodeDataComponent)???).mDecodeBufferInfo);
                localObject3 = localObject8;
              }
            }
          }
          if ((((StreamDecodeDataComponent)???).mAudioTrack != null) && (isPlaying()))
          {
            if (k == 0)
            {
              i2 = ((StreamDecodeDataComponent)???).mTerminalAudioEffectList.size() - 1;
              if (i2 >= 0)
              {
                localObject6 = (IAudioListener)((StreamDecodeDataComponent)???).mTerminalAudioEffectList.get(i2);
                if (((IAudioListener)localObject6).isEnabled())
                {
                  if (((StreamDecodeDataComponent)???).isUseFloatForHighDepth) {
                    ((IAudioListener)localObject6).onPcm(((StreamDecodeDataComponent)???).mFloatBufferInfo, ((StreamDecodeDataComponent)???).mFloatBufferInfo, ((StreamDecodeDataComponent)???).mCorePlayer.getCurPositionByDecoder());
                  } else {
                    ((IAudioListener)localObject6).onPcm(((StreamDecodeDataComponent)???).mDecodeBufferInfo, ((StreamDecodeDataComponent)???).mDecodeBufferInfo, ((StreamDecodeDataComponent)???).mCorePlayer.getCurPositionByDecoder());
                  }
                  i2 = 1;
                  continue;
                }
                i2 -= 1;
                continue;
              }
            }
            i2 = 0;
            if (i2 == 0)
            {
              if ((((StreamDecodeDataComponent)???).isUseFloatForHighDepth) && (Build.VERSION.SDK_INT >= 21))
              {
                m = ((StreamDecodeDataComponent)???).mAudioTrack.write(((StreamDecodeDataComponent)???).mFloatBufferInfo.floatBuffer, 0, ((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize, 0);
                if (m < 0)
                {
                  if (((StreamDecodeDataComponent)???).mAudioTrack.getPlayState() == 3)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("mAudioTrack write float failed: ");
                    ((StringBuilder)localObject3).append(m);
                    ((StringBuilder)localObject3).append(", expect: ");
                    ((StringBuilder)localObject3).append(((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize);
                    Logger.e("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary(((StringBuilder)localObject3).toString()));
                    ((StreamDecodeDataComponent)???).mStateRunner.transfer(localInteger);
                    ((StreamDecodeDataComponent)???).callExceptionCallback(92, 102);
                    return;
                  }
                  Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary("write data to audiotrack failed, but it's OK"));
                }
                else
                {
                  if (m != ((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize)
                  {
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append("mAudioTrack write float not equal: ");
                    ((StringBuilder)localObject6).append(m);
                    ((StringBuilder)localObject6).append(", expect: ");
                    ((StringBuilder)localObject6).append(((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize);
                    Logger.w("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary(((StringBuilder)localObject6).toString()));
                    if (m == 0)
                    {
                      Logger.w("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary("save the pcm data that has not written to audiotrack"));
                      j = 1;
                    }
                    else
                    {
                      ((StreamDecodeDataComponent)???).mAudioTrack.flush();
                    }
                  }
                  else
                  {
                    j = 0;
                  }
                  if (m > 0) {
                    k = ((StreamDecodeDataComponent)???).mFloatBufferInfo.bufferSize * 2;
                  } else {
                    k = 0;
                  }
                  i += k;
                  continue;
                }
              }
              else
              {
                m = ((StreamDecodeDataComponent)???).mAudioTrack.write(((StreamDecodeDataComponent)???).mDecodeBufferInfo.byteBuffer, 0, ((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize);
                if (m >= 0) {
                  continue;
                }
                if (((StreamDecodeDataComponent)???).mAudioTrack.getPlayState() == 3)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("mAudioTrack write bytes failed: ");
                  ((StringBuilder)localObject3).append(m);
                  ((StringBuilder)localObject3).append(", expect: ");
                  ((StringBuilder)localObject3).append(((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize);
                  Logger.e("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary(((StringBuilder)localObject3).toString()));
                  ((StreamDecodeDataComponent)???).mStateRunner.transfer(localInteger);
                  ((StreamDecodeDataComponent)???).callExceptionCallback(92, 102);
                  return;
                }
                Logger.i("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary("write data to audiotrack failed, but it's OK"));
              }
              j = k;
              k = 0;
              continue;
              if (m != ((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize)
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("mAudioTrack write bytes not equal: ");
                ((StringBuilder)localObject6).append(m);
                ((StringBuilder)localObject6).append(", expect: ");
                ((StringBuilder)localObject6).append(((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize);
                Logger.w("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary(((StringBuilder)localObject6).toString()));
                if (m == 0)
                {
                  Logger.w("StreamDecodeDataComponent", ((StreamDecodeDataComponent)???).axiliary("save the pcm data that has not written to audiotrack"));
                  j = 1;
                }
                else
                {
                  ((StreamDecodeDataComponent)???).mAudioTrack.flush();
                }
              }
              else
              {
                j = 0;
              }
              if (m > 0) {
                k = ((StreamDecodeDataComponent)???).mDecodeBufferInfo.bufferSize;
              } else {
                k = 0;
              }
              i += k;
              k = 1;
              i2 = AudioUtil.getPlaybackHeadPositionSafely(((StreamDecodeDataComponent)???).mAudioTrack);
              m = j;
              j = i2;
            }
            else
            {
              i2 = m;
              m = k;
              k = i2;
            }
            i2 = m;
            m = k;
            k = i2;
          }
        }
        else
        {
          ((StreamDecodeDataComponent)???).mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(n, 92);
        }
        i3 = 2;
        localObject6 = ???;
      }
      label3083:
      return;
      if (!((StreamDecodeDataComponent)localObject6).mCorePlayer.mIsExit)
      {
        Logger.e("StreamDecodeDataComponent", ((StreamDecodeDataComponent)localObject6).axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
        ((StreamDecodeDataComponent)localObject6).mStateRunner.transfer(localInteger);
        ((StreamDecodeDataComponent)localObject6).callExceptionCallback(91, 63);
      }
      return;
      label3129:
      int i2 = -1;
    }
  }
  
  void pause(boolean paramBoolean)
  {
    super.pause(paramBoolean);
    AudioTrack localAudioTrack;
    if (paramBoolean)
    {
      localAudioTrack = this.mAudioTrack;
      if (localAudioTrack == null) {}
    }
    try
    {
      if ((localAudioTrack.getState() == 1) && (localAudioTrack.getPlayState() != 2)) {
        localAudioTrack.pause();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  void release()
  {
    super.release();
    this.mCurrentFrameCount = 0L;
  }
  
  void seek(int paramInt)
  {
    addSeekRecord(paramInt);
    refreshTimeAndNotify(paramInt);
  }
  
  void setAudioStreamType(int paramInt)
  {
    if (paramInt == this.mAudioStreamType) {
      return;
    }
    try
    {
      this.mAudioStreamType = paramInt;
      if (this.mAudioTrack == null) {
        return;
      }
      AudioTrack localAudioTrack = instantiateAudioTrackCompat(paramInt, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setAudioStreamType] new AudioTrack, sampleRate: ");
      localStringBuilder.append(this.mAudioTrack.getSampleRate());
      localStringBuilder.append(", channels: ");
      localStringBuilder.append(this.mAudioTrack.getChannelConfiguration());
      localStringBuilder.append(", bitDepth: ");
      localStringBuilder.append(this.mAudioTrack.getAudioFormat());
      localStringBuilder.append(", buffer: ");
      localStringBuilder.append(this.mTrackBufferSizeInByte);
      Logger.i("StreamDecodeDataComponent", axiliary(localStringBuilder.toString()));
      int i = this.mAudioTrack.getPlayState();
      if (i == 3) {
        pause(false);
      }
      this.mAudioTrack.release();
      setAudioTrack(localAudioTrack);
      this.mStateRunner.setAudioTrack(this.mAudioTrack);
      if (i != 3) {
        return;
      }
      play();
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed in setting audio stream type to :");
    localStringBuilder.append(paramInt);
    Logger.e("StreamDecodeDataComponent", localStringBuilder.toString(), localIllegalArgumentException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */