package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StaticDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final String TAG = "StaticDecodeDataComponent";
  private int mAllBufferSize;
  private List<BufferInfo> mAllPcmBufferList;
  private boolean mHasTerminal = false;
  private boolean mIsfirstStarted;
  
  StaticDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
    this.mBuffSize = 8192;
  }
  
  private boolean createAudioTrack()
  {
    Logger.d("StaticDecodeDataComponent", axiliary("createAudioTrack"));
    Object localObject = this.mInformation;
    Integer localInteger = Integer.valueOf(9);
    if (localObject == null)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
      this.mStateRunner.transfer(localInteger);
      callExceptionCallback(91, 63);
      return false;
    }
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mState is not preparing"));
      callExceptionCallback(91, 54);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StaticDecodeDataComponent", axiliary("mInformation.getSampleRate() failed"));
      callExceptionCallback(91, 64);
      return false;
    }
    int k = this.mInformation.getChannels();
    int i;
    if (k == 1)
    {
      i = 4;
    }
    else
    {
      if (k == 2) {}
      do
      {
        i = 12;
        break;
        if (k == 6)
        {
          i = 252;
          break;
        }
      } while (k != 8);
      i = 1020;
    }
    this.mTargetPlaySample = this.mInformation.getSampleRate();
    int j = this.mInformation.getBitDepth();
    while (this.mTargetPlaySample > getMaxSupportSampleRate()) {
      this.mTargetPlaySample /= 2L;
    }
    if ((isSupportHighBitDepth()) && (j >= 3))
    {
      this.mTargetBitDepth = j;
      this.isUseFloatForHighDepth = true;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("will use float resampled pcm for Hi-Res, bitDept: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", origin sample rate: ");
        ((StringBuilder)localObject).append(this.mInformation.getSampleRate());
        ((StringBuilder)localObject).append(", target sample rate: ");
        ((StringBuilder)localObject).append(this.mTargetPlaySample);
        Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("will use float pcm for Hi-Res, bitDept: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", sample rate: ");
        ((StringBuilder)localObject).append(this.mTargetPlaySample);
        Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      }
    }
    else if ((!isSupportHighBitDepth()) && (j >= 3))
    {
      this.mTargetBitDepth = 2;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("will use byte pcm resampled and bitDept converted, origin bitDept: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", target bitDept: ");
        ((StringBuilder)localObject).append(this.mTargetBitDepth);
        ((StringBuilder)localObject).append(", origin sample rate: ");
        ((StringBuilder)localObject).append(this.mInformation.getSampleRate());
        ((StringBuilder)localObject).append(", target sample rate: ");
        ((StringBuilder)localObject).append(this.mTargetPlaySample);
        Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("will use byte pcm with bitDept converted, origin bitDept: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", target bitDept: ");
        ((StringBuilder)localObject).append(this.mTargetBitDepth);
        Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
      }
    }
    else
    {
      this.mTargetBitDepth = j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("will use byte pcm resampled, bitDept: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", origin sample rate: ");
      ((StringBuilder)localObject).append(this.mInformation.getSampleRate());
      ((StringBuilder)localObject).append(", target sample rate: ");
      ((StringBuilder)localObject).append(this.mTargetPlaySample);
      Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
    }
    if (j == 1) {
      j = 3;
    } else if ((j != 2) && (this.isUseFloatForHighDepth)) {
      j = 4;
    } else {
      j = 2;
    }
    Logger.d("StaticDecodeDataComponent", axiliary(String.format("mTargetPlaySample: %d, playChannel: %d", new Object[] { Long.valueOf(this.mTargetPlaySample), Integer.valueOf(k) })));
    try
    {
      setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int)this.mTargetPlaySample, i, j, this.mAllBufferSize, 0));
      if ((this.mSpeedToSet != null) && (Build.VERSION.SDK_INT >= 23))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSpeed:");
        ((StringBuilder)localObject).append(this.mSpeedToSet);
        Logger.i("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
        localObject = this.mAudioTrack.getPlaybackParams();
        ((PlaybackParams)localObject).setSpeed(this.mSpeedToSet.floatValue());
        this.mSpeedToSet = null;
        this.mAudioTrack.setPlaybackParams((PlaybackParams)localObject);
      }
      if (this.mAudioTrack.getState() == 2) {
        Logger.d("StaticDecodeDataComponent", axiliary("new AudioTrack succeed"));
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("StaticDecodeDataComponent", localThrowable);
    }
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 2))
    {
      Logger.d("StaticDecodeDataComponent", axiliary("create audioTrack success"));
      return true;
    }
    this.mCreateAudioTrackFail = true;
    Logger.e("StaticDecodeDataComponent", axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
    setAudioTrack(null);
    this.mStateRunner.transfer(localInteger);
    callExceptionCallback(91, 66);
    return false;
  }
  
  private boolean decodeAllData()
  {
    this.mAllPcmBufferList = new ArrayList();
    int i;
    while (!this.mCorePlayer.mIsExit)
    {
      BufferInfo localBufferInfo1 = new BufferInfo();
      localBufferInfo1.setByteBufferCapacity(this.mBuffSize);
      try
      {
        i = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, localBufferInfo1.byteBuffer);
        this.mHasDecode = true;
        if (i > 0)
        {
          localBufferInfo1.bufferSize = i;
          this.mAllPcmBufferList.add(localBufferInfo1);
          if (!this.mHasDecodeSuccess) {
            this.mHasDecodeSuccess = true;
          }
        }
        else if (i == 0)
        {
          localBufferInfo1.bufferSize = this.mBuffSize;
          this.mAllPcmBufferList.add(localBufferInfo1);
          Logger.i("StaticDecodeDataComponent", "static decode end");
        }
        else
        {
          this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i, 91);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.e("StaticDecodeDataComponent", localThrowable);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 67);
        return false;
      }
      catch (SoNotFindException localSoNotFindException)
      {
        Logger.e("StaticDecodeDataComponent", localSoNotFindException);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(91, 62);
        return false;
      }
    }
    if (!this.mAllPcmBufferList.isEmpty())
    {
      Object localObject = this.mAllPcmBufferList.iterator();
      i = 0;
      while (((Iterator)localObject).hasNext()) {
        i += ((BufferInfo)((Iterator)localObject).next()).bufferSize;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("static totalBufferSize = ");
      ((StringBuilder)localObject).append(i);
      Logger.i("StaticDecodeDataComponent", ((StringBuilder)localObject).toString());
      this.mDecodeBufferInfo.setByteBufferCapacity(i);
      localObject = this.mAllPcmBufferList.iterator();
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        BufferInfo localBufferInfo2 = (BufferInfo)((Iterator)localObject).next();
        System.arraycopy(localBufferInfo2.byteBuffer, 0, this.mDecodeBufferInfo.byteBuffer, i, localBufferInfo2.bufferSize);
        i += localBufferInfo2.bufferSize;
        BufferInfo localBufferInfo3 = this.mDecodeBufferInfo;
        localBufferInfo3.bufferSize += localBufferInfo2.bufferSize;
        this.mAllBufferSize += localBufferInfo2.bufferSize;
      }
    }
    return true;
  }
  
  private void playAudioTrack()
  {
    this.mAudioTrack.reloadStaticData();
    while (!this.mCorePlayer.mIsExit) {
      if (isPaused())
      {
        if (this.mAudioTrack.getPlayState() != 2) {
          this.mAudioTrack.pause();
        }
        postRunnable(new StaticDecodeDataComponent.2(this), 20);
        doWaitForPaused();
      }
      else
      {
        if (isIdle()) {
          return;
        }
        if (isError())
        {
          Logger.e("StaticDecodeDataComponent", "static play error");
          return;
        }
        if (isStopped())
        {
          if (this.mAudioTrack.getPlayState() != 1) {
            this.mAudioTrack.stop();
          }
          postRunnable(new StaticDecodeDataComponent.3(this), 20);
          return;
        }
        if (isCompleted())
        {
          this.mCorePlayer.mIsExit = true;
          return;
        }
        if (isPlaying()) {
          if (this.mAudioTrack.getPlayState() == 2)
          {
            this.mAudioTrack.play();
          }
          else if (this.mAudioTrack.getPlayState() == 1)
          {
            if (!this.mIsfirstStarted)
            {
              this.mIsfirstStarted = true;
              this.mAudioTrack.play();
              this.mCallback.playerStarted(this.mCorePlayer);
            }
          }
          else if (AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack) * this.mInformation.getChannels() * this.mTargetBitDepth >= this.mAllBufferSize)
          {
            this.mStateRunner.transfer(Integer.valueOf(7));
            Logger.i("StaticDecodeDataComponent", "static play completed");
            postRunnable(new StaticDecodeDataComponent.4(this), 20);
          }
        }
      }
    }
  }
  
  private boolean writeAudioTrack()
  {
    Object localObject = new BufferInfo();
    if ((this.mDecodeBufferInfo.byteBuffer != null) && (this.mAudioTrack != null))
    {
      if (this.mTargetBitDepth != this.mInformation.getBitDepth())
      {
        handleHighBitDepth(this.mDecodeBufferInfo, (BufferInfo)localObject);
        this.mDecodeBufferInfo.fillInto((BufferInfo)localObject);
      }
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        handleHighSample(this.mDecodeBufferInfo, (BufferInfo)localObject);
        this.mDecodeBufferInfo.fillInto((BufferInfo)localObject);
      }
      if (this.isUseFloatForHighDepth)
      {
        convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
        processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
      }
      else
      {
        processAudioListeners(this.mDecodeBufferInfo, (BufferInfo)localObject);
        this.mDecodeBufferInfo.fillInto((BufferInfo)localObject);
      }
      this.mHasTerminal = false;
      int i = this.mTerminalAudioEffectList.size() - 1;
      while (i >= 0)
      {
        localObject = (IAudioListener)this.mTerminalAudioEffectList.get(i);
        if (((IAudioListener)localObject).isEnabled())
        {
          if (this.isUseFloatForHighDepth) {
            ((IAudioListener)localObject).onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
          } else {
            ((IAudioListener)localObject).onPcm(this.mDecodeBufferInfo, this.mDecodeBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
          }
          this.mHasTerminal = true;
          break;
        }
        i -= 1;
      }
      if (!this.mHasTerminal)
      {
        if ((this.isUseFloatForHighDepth) && (Build.VERSION.SDK_INT >= 21))
        {
          i = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
          if (i < 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mAudioTrack write float failed: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", expect: ");
            ((StringBuilder)localObject).append(this.mFloatBufferInfo.bufferSize);
            Logger.e("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(91, 102);
            return false;
          }
          if (i != this.mFloatBufferInfo.bufferSize)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mAudioTrack write float not equal: ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(", expect: ");
            ((StringBuilder)localObject).append(this.mFloatBufferInfo.bufferSize);
            Logger.w("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
          }
          i = this.mFloatBufferInfo.bufferSize;
          return true;
        }
        i = this.mAudioTrack.write(this.mDecodeBufferInfo.byteBuffer, 0, this.mDecodeBufferInfo.bufferSize);
        if (i < 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mAudioTrack write bytes failed: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", expect: ");
          ((StringBuilder)localObject).append(this.mDecodeBufferInfo.bufferSize);
          Logger.e("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 102);
          return false;
        }
        if (i != this.mDecodeBufferInfo.bufferSize)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mAudioTrack write bytes not equal: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", expect: ");
          ((StringBuilder)localObject).append(this.mDecodeBufferInfo.bufferSize);
          Logger.w("StaticDecodeDataComponent", axiliary(((StringBuilder)localObject).toString()));
        }
        i = this.mDecodeBufferInfo.bufferSize;
        return true;
      }
      Logger.i("StaticDecodeDataComponent", "mTerminalAudioEffectList has blocked");
    }
    return false;
  }
  
  int getAudioStreamType()
  {
    return 3;
  }
  
  long getCurPosition()
  {
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack != null) && (localAudioTrack.getState() != 0))
    {
      this.mCurPosition = getAudioTrackPosition(0L, localAudioTrack);
      return this.mCurPosition;
    }
    return this.mCurPosition;
  }
  
  void handleDecodeData()
  {
    AudioInformation localAudioInformation = this.mInformation;
    Integer localInteger = Integer.valueOf(9);
    if (localAudioInformation != null)
    {
      try
      {
        if (0L == this.mInformation.getSampleRate())
        {
          Logger.e("StaticDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(localInteger);
          callExceptionCallback(91, 63);
          return;
        }
        this.mHasInit = true;
        if (!decodeAllData())
        {
          Logger.e("StaticDecodeDataComponent", "failed to decodeAllData");
          this.mStateRunner.transfer(localInteger);
          return;
        }
        if (!createAudioTrack())
        {
          Logger.e("StaticDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(localInteger);
          return;
        }
        if ((!writeAudioTrack()) && (!this.mHasTerminal))
        {
          Logger.e("StaticDecodeDataComponent", "failed to writeAudioTrack");
          this.mStateRunner.transfer(localInteger);
          return;
        }
        if (this.mHasTerminal)
        {
          this.mStateRunner.transfer(Integer.valueOf(7));
          return;
        }
        this.mStateRunner.transfer(Integer.valueOf(2));
        this.mIsfirstStarted = false;
        initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
        postRunnable(new StaticDecodeDataComponent.1(this), 20);
      }
      catch (SoNotFindException localSoNotFindException)
      {
        Logger.e("StaticDecodeDataComponent", localSoNotFindException);
      }
      Logger.i("StaticDecodeDataComponent", axiliary("prepared. waiting..."));
      this.mSignalControl.doWait();
      Logger.i("StaticDecodeDataComponent", axiliary("woke after preparing"));
      playAudioTrack();
      return;
    }
    Logger.e("StaticDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
    this.mStateRunner.transfer(localInteger);
    callExceptionCallback(91, 63);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */