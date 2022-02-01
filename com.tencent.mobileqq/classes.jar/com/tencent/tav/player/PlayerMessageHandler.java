package com.tencent.tav.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.Utils;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.SeekTimeStore;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.PreviewReportSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

class PlayerMessageHandler
  implements Handler.Callback
{
  private static final String TAG = "PlayerMessageHandler";
  private IDecoderTrack aDecoderTrack;
  private long decoderConsumerTimeUs = 0L;
  CMTime frameDuration = new CMTime(1L, 30);
  private volatile long lastSyncMessageId = 0L;
  private boolean loop;
  private PlayerThreadAudio mAudioThread;
  @NonNull
  private final Handler mMainHandler;
  private boolean mPause;
  @NonNull
  private final Player mPlayer;
  private PlayerItem mPlayerItem;
  CMTime mPosition = CMTime.CMTimeZero;
  private long mStartTime;
  private int mStatus = 1;
  private OnGetTavExtraListener onGetTavExtraListener;
  private final PlayerRenderer playerRenderer = new PlayerRenderer();
  private final PlayerThread playerThread;
  private float rate = 1.0F;
  private final PreviewReportSession reportSession = new PreviewReportSession();
  private long startTimeUsMark = Utils.getCurrentUsTime();
  private IDecoderTrack vDecoderTrack;
  
  PlayerMessageHandler(PlayerThread paramPlayerThread, IDecoderTrack paramIDecoderTrack1, IDecoderTrack paramIDecoderTrack2, Player paramPlayer)
  {
    this.playerThread = paramPlayerThread;
    this.vDecoderTrack = paramIDecoderTrack1;
    this.aDecoderTrack = paramIDecoderTrack2;
    this.mPlayer = paramPlayer;
    this.mPlayerItem = paramPlayer.getCurrentItem();
    this.mMainHandler = paramPlayer.mMainHandler;
    if (paramIDecoderTrack1 != null) {
      this.frameDuration = paramIDecoderTrack1.getFrameDuration();
    }
  }
  
  private void checkNotifyProgressChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if (this.playerThread.mPlayHandler.hasMessages(5)) {
        return;
      }
      if ((this.mPlayer.isIgnorePreparePosition()) && (paramBoolean2)) {
        return;
      }
      notifyProgressChange();
    }
  }
  
  private boolean dispatchMessage(Message paramMessage, Object paramObject1, Object paramObject2)
  {
    int j = paramMessage.what;
    if (j != 9)
    {
      if (j != 101)
      {
        if (j != 231)
        {
          if (j != 850)
          {
            if (j != 11)
            {
              int i = 0;
              boolean bool = false;
              if (j != 12)
              {
                if (j != 21)
                {
                  if (j != 22)
                  {
                    if (j != 24)
                    {
                      if (j != 25)
                      {
                        switch (j)
                        {
                        default: 
                          return true;
                        case 6: 
                          release(paramMessage);
                          return true;
                        case 5: 
                          if ((paramObject2 instanceof Callback))
                          {
                            seek((CMTime)paramObject1, (Callback)paramObject2);
                            return true;
                          }
                          seek((CMTime)paramObject1);
                          return true;
                        case 4: 
                          if (paramObject1 != null) {
                            bool = ((Boolean)paramObject1).booleanValue();
                          }
                          stop(bool);
                          return true;
                        case 3: 
                          pause();
                          return true;
                        case 2: 
                          play();
                          return true;
                        }
                        prepare(paramObject1);
                        return true;
                      }
                      if ((paramObject1 instanceof OnGetTavExtraListener))
                      {
                        this.onGetTavExtraListener = ((OnGetTavExtraListener)paramObject1);
                        return true;
                      }
                    }
                    else if ((paramObject1 instanceof OnReadSnapShootListener))
                    {
                      this.playerRenderer.setOnReadSnapShootListener((OnReadSnapShootListener)paramObject1);
                      return true;
                    }
                  }
                  else
                  {
                    updateAudioClipsProperties();
                    return true;
                  }
                }
                else if ((paramObject1 instanceof CGSize))
                {
                  this.playerRenderer.setSurfaceSize((CGSize)paramObject1);
                  this.playerRenderer.initViewport(this.mMainHandler);
                  return true;
                }
              }
              else
              {
                if (paramObject1 != null) {
                  i = ((Integer)paramObject1).intValue();
                }
                readSample(i);
                return true;
              }
            }
            else
            {
              paramMessage = (UpdateCompositionMessage)paramObject1;
              stop(true, true);
              releaseComposition();
              if (paramMessage != null)
              {
                updateComposition(paramMessage.playerItem);
                prepare(paramMessage.updateListener);
                return true;
              }
            }
          }
          else
          {
            quit();
            return true;
          }
        }
        else
        {
          readCurrentSample();
          return true;
        }
      }
      else if ((paramObject1 instanceof Runnable))
      {
        ((Runnable)paramObject1).run();
        return true;
      }
    }
    else {
      seekPreSample();
    }
    return true;
  }
  
  @NotNull
  private CMSampleState doReadSample(int paramInt, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    this.playerRenderer.makeCurrent();
    long l1 = System.nanoTime();
    paramCMTime2 = readSampleBuffer(paramInt, paramCMTime1, paramCMTime2);
    long l2 = System.nanoTime();
    paramCMTime1 = paramCMTime2.getState();
    long l3 = System.nanoTime();
    this.playerRenderer.renderSampleBuffer(paramCMTime2, this.mPlayer.getBgColor(), this.onGetTavExtraListener);
    this.reportSession.tickPreview(l2 - l1, System.nanoTime() - l3);
    paramCMTime2 = new CMTime(1L, paramCMTime1.getTime().timeScale);
    paramCMTime2 = paramCMTime1.getTime().add(paramCMTime2);
    if (paramInt != 5) {
      this.vDecoderTrack.asyncReadNextSample(paramCMTime2);
    }
    this.decoderConsumerTimeUs = (Utils.getCurrentUsTime() - this.startTimeUsMark);
    return paramCMTime1;
  }
  
  private void fixFrameDuration()
  {
    long l1 = Utils.getCurrentUsTime();
    long l2 = this.startTimeUsMark;
    try
    {
      l1 = this.frameDuration.divide(this.rate).getTimeUs() - (l1 - l2);
      if (l1 > 0L)
      {
        Thread.sleep(l1 / 1000L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("PlayerMessageHandler", "readSample: ", localThrowable);
    }
  }
  
  @NotNull
  private CMSampleState fixSampleState(CMTime paramCMTime, CMSampleState paramCMSampleState, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCMSampleState.getStateCode() >= 0L)
    {
      this.mPosition = paramCMSampleState.getTime();
      checkNotifyProgressChange(paramBoolean1, paramBoolean2);
      return paramCMSampleState;
    }
    if (paramCMSampleState.stateMatchingTo(new long[] { -100L })) {
      this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    }
    return new CMSampleState(paramCMTime);
  }
  
  private CMTime getLastSeekPosAndRemoveOther()
  {
    Object localObject = Utils.getContinuesMessage(5, PlayerMessage.class, this.playerThread.mPlayHandler);
    CMTime localCMTime = CMTime.CMTimeInvalid;
    if (((ArrayList)localObject).isEmpty()) {
      return localCMTime;
    }
    Message localMessage = (Message)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    if (!(localMessage.obj instanceof PlayerMessage)) {
      return localCMTime;
    }
    localCMTime = (CMTime)((PlayerMessage)localMessage.obj).bizMsg1;
    if (localCMTime == CMTime.CMTimeInvalid) {
      return localCMTime;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localMessage = (Message)((Iterator)localObject).next();
      this.playerThread.mPlayHandler.removeMessages(localMessage.what, localMessage.obj);
    }
    return localCMTime;
  }
  
  private long getWaitTime(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = this.frameDuration.getTimeUs();
    long l2 = paramCMTime.getTimeUs();
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l3 = ((float)l1 / Math.abs(this.rate));
      long l4 = l3 - this.decoderConsumerTimeUs;
      paramCMTime = new StringBuilder();
      paramCMTime.append("getWaitTime--position-->");
      paramCMTime.append(l2);
      paramCMTime.append(" rate = ");
      paramCMTime.append(this.rate);
      paramCMTime.append("--decoderConsumerTimeUs-->");
      paramCMTime.append(this.decoderConsumerTimeUs);
      paramCMTime.append("--frameDurationMs-->");
      paramCMTime.append(l1);
      paramCMTime.append("--realTime-->");
      paramCMTime.append(l3);
      paramCMTime.append("--nextFrameTime-->");
      paramCMTime.append(l2 + l3);
      paramCMTime.append("--sleepTime-->");
      paramCMTime.append(l4);
      paramCMTime.append("  mStartTime = ");
      paramCMTime.append(this.mStartTime);
      Logger.v("PlayerMessageHandler", paramCMTime.toString());
      return l4;
    }
    paramCMTime = new StringBuilder();
    paramCMTime.append("getWaitTime - 0 ");
    paramCMTime.append(paramBoolean1);
    paramCMTime.append("  |  ");
    paramCMTime.append(paramBoolean2);
    Logger.d("PlayerMessageHandler", paramCMTime.toString());
    return 0L;
  }
  
  private void initDecoderTrack(Object paramObject)
  {
    this.playerRenderer.initRenderContext();
    VideoComposition localVideoComposition = this.mPlayerItem.getVideoComposition();
    this.playerRenderer.initRenderSize(localVideoComposition);
    this.playerRenderer.initViewport(this.mMainHandler);
    updateProgressPreNextAction(this.mPosition);
    if (this.vDecoderTrack != null) {
      tryInitVideoDecoder(paramObject);
    } else {
      onCompositionUpdate(paramObject, false);
    }
    paramObject = this.aDecoderTrack;
    if (paramObject != null)
    {
      paramObject.start();
      this.aDecoderTrack.seekTo(this.mPosition, false, false);
    }
    updateStatus(2);
    synAudioComposition();
  }
  
  private void initVideoDecoder(Object paramObject)
  {
    this.vDecoderTrack.setFrameRate((int)(this.frameDuration.timeScale / this.frameDuration.getValue()));
    this.vDecoderTrack.start(this.playerRenderer.getRenderContext());
    if (!this.loop)
    {
      if (this.mPosition == CMTime.CMTimeInvalid) {
        this.mPosition = this.vDecoderTrack.getDuration();
      }
      this.vDecoderTrack.seekTo(this.mPosition, false, true);
      readSample(1);
    }
    onCompositionUpdate(paramObject, true);
    paramObject = new StringBuilder();
    paramObject.append("prepare: init codec-->");
    paramObject.append(Thread.currentThread().getName());
    paramObject.append("--vDecoderTrack-->");
    paramObject.append(this.vDecoderTrack);
    Logger.v("PlayerMessageHandler", paramObject.toString());
  }
  
  private void notifyProgressChange()
  {
    if (!this.playerThread.mPlayHandler.hasMessages(5)) {
      this.mMainHandler.obtainMessage(2, this.mPosition).sendToTarget();
    }
  }
  
  private void notifyStatus(IPlayer.PlayerStatus paramPlayerStatus, String paramString)
  {
    this.mMainHandler.obtainMessage(1, new PlayerStatusMsg(paramPlayerStatus, paramString)).sendToTarget();
  }
  
  private void onCompositionUpdate(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof OnCompositionUpdateListener)) {
      ((OnCompositionUpdateListener)paramObject).onUpdated(this.mPlayer, paramBoolean);
    }
  }
  
  private void onPlayFinish()
  {
    IDecoderTrack localIDecoderTrack = this.vDecoderTrack;
    if (localIDecoderTrack != null) {
      if (this.mPosition.smallThan(localIDecoderTrack.getDuration())) {
        this.vDecoderTrack.seekTo(this.mPosition, false, true);
      } else {
        this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
      }
    }
    updateStatus(2);
    SeekTimeStore.clean();
  }
  
  private void pause()
  {
    this.loop = false;
    Logger.v("PlayerMessageHandler", "pause: mLooper set to false");
    this.mPause = true;
    removePendingMessage(new int[] { 12 });
    notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
    SeekTimeStore.clean();
  }
  
  private void play()
  {
    int i = this.mStatus;
    if (i == 1)
    {
      if ((this.vDecoderTrack != null) || (this.aDecoderTrack != null))
      {
        this.playerThread.sendMessage(1, "not can play");
        this.playerThread.sendMessage(2, "not can play");
      }
      return;
    }
    if (i == 3) {
      onPlayFinish();
    }
    removePendingMessage(new int[] { 12 });
    this.loop = true;
    Logger.v("PlayerMessageHandler", "play: mLooper set to true");
    this.playerThread.sendMessage(12, Integer.valueOf(2), "play");
    notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playm() called start play-->");
    localStringBuilder.append(this.mStatus);
    Logger.v("PlayerMessageHandler", localStringBuilder.toString());
    SeekTimeStore.clean();
  }
  
  private void playerFinish()
  {
    Logger.d("PlayerMessageHandler", "playFinish");
    Object localObject = this.vDecoderTrack;
    if (localObject != null) {
      localObject = ((IDecoderTrack)localObject).getDuration();
    } else {
      localObject = this.mPlayer.duration();
    }
    updateProgressPreNextAction((CMTime)localObject);
    notifyProgressChange();
    updateStatus(3);
    syncAudioOtherMsg(-1, null);
    localObject = this.vDecoderTrack;
    if (localObject != null) {
      ((IDecoderTrack)localObject).seekTo(CMTime.CMTimeZero, false, true);
    }
    this.mStartTime = 0L;
    this.loop = false;
    notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
  }
  
  private void prepare(Object paramObject)
  {
    if (this.mStatus == 1)
    {
      initDecoderTrack(paramObject);
      return;
    }
    this.playerThread.sendMessage(4, Boolean.valueOf(false), "prepare");
    this.playerThread.sendMessage(1, paramObject, "prepare");
  }
  
  private void quit()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("quit: PlayerThreadMain ");
    localStringBuilder.append(this);
    Logger.i("PlayerMessageHandler", localStringBuilder.toString());
    removePendingMessage(new int[0]);
    if (this.playerThread.mThread != null)
    {
      this.playerThread.mThread.quit();
      this.playerThread.mThread = null;
    }
    this.vDecoderTrack.release();
    this.aDecoderTrack.release();
    this.playerRenderer.releaseRenderContext();
    this.vDecoderTrack = null;
    this.aDecoderTrack = null;
    this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
  }
  
  private void readCurrentSample()
  {
    CMSampleBuffer localCMSampleBuffer = this.vDecoderTrack.readCurrentSample();
    if (localCMSampleBuffer != null) {
      this.playerRenderer.renderSampleBuffer(localCMSampleBuffer, this.mPlayer.getBgColor(), this.onGetTavExtraListener);
    }
  }
  
  private void readSample(int paramInt)
  {
    int i;
    if (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId) {
      i = 1;
    } else {
      i = 0;
    }
    CMTime localCMTime;
    if (i != 0) {
      localCMTime = this.mAudioThread.getCurrentPlayingState();
    } else {
      localCMTime = CMTime.CMTimeInvalid;
    }
    readSample(paramInt, localCMTime);
  }
  
  private void readSample(int paramInt, CMTime paramCMTime)
  {
    if (this.vDecoderTrack == null)
    {
      syncAudioProgress();
      return;
    }
    if (paramInt == 2) {
      this.loop = true;
    }
    fixFrameDuration();
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    syncAudioPosition(paramInt, paramCMTime, localCMTime);
    this.startTimeUsMark = Utils.getCurrentUsTime();
    CMSampleState localCMSampleState = new CMSampleState();
    try
    {
      paramCMTime = doReadSample(paramInt, paramCMTime, localCMTime);
    }
    catch (Exception localException)
    {
      Logger.e("PlayerMessageHandler", "readSample: ", localException);
      paramCMTime = localCMSampleState;
      if ((localException instanceof IllegalStateException))
      {
        notifyStatus(IPlayer.PlayerStatus.ERROR, "解码异常");
        return;
      }
    }
    if (paramCMTime.stateMatchingTo(new long[] { -1L, -3L }))
    {
      Logger.v("PlayerMessageHandler", "readSample() called with: finish");
      playerFinish();
      return;
    }
    boolean bool2 = false;
    boolean bool1;
    if (5 == paramInt) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (1 == paramInt) {
      bool2 = true;
    }
    scheduleNextWork(fixSampleState(localCMTime, paramCMTime, bool1, bool2), bool1);
    paramCMTime = new StringBuilder();
    paramCMTime.append("readSample end [");
    paramCMTime.append(paramInt);
    paramCMTime.append("]--looper-->");
    paramCMTime.append(this.loop);
    paramCMTime.append(" consumer = ");
    paramCMTime.append(Utils.getCurrentUsTime() - this.startTimeUsMark);
    Logger.v("PlayerMessageHandler", paramCMTime.toString());
  }
  
  @NonNull
  private CMSampleBuffer readSampleBuffer(int paramInt, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (paramInt == 5) {
      return this.vDecoderTrack.seekTo(paramCMTime1, true, true);
    }
    CMTime localCMTime = this.frameDuration.multi(this.rate);
    if (paramCMTime2.smallThan(paramCMTime1.sub(localCMTime.multi(3.0F))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readSampleBuffer: sampleTime = // ");
      localStringBuilder.append(paramCMTime2.add(this.frameDuration));
      Logger.v("PlayerMessageHandler", localStringBuilder.toString());
      return this.vDecoderTrack.readSample(paramCMTime1.divide(localCMTime).multi(localCMTime));
    }
    if ((paramCMTime2.bigThan(paramCMTime1.add(localCMTime))) && (paramCMTime1.bigThan(CMTime.CMTimeZero)) && (this.mAudioThread.isFinished()))
    {
      syncAudioOtherMsg(2, paramCMTime2);
      paramCMTime1 = new StringBuilder();
      paramCMTime1.append("readSampleBuffer: sampleTime = /// ");
      paramCMTime1.append(paramCMTime2.add(localCMTime));
      Logger.v("PlayerMessageHandler", paramCMTime1.toString());
      return this.vDecoderTrack.readSample(localCMTime);
    }
    paramCMTime1 = new StringBuilder();
    paramCMTime1.append("readSampleBuffer: sampleTime = ");
    paramCMTime1.append(paramCMTime2.add(localCMTime));
    Logger.v("PlayerMessageHandler", paramCMTime1.toString());
    return this.vDecoderTrack.readSample(paramCMTime2.add(localCMTime));
  }
  
  private void release(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release player - ");
    ((StringBuilder)localObject).append(this);
    Logger.d("PlayerMessageHandler", ((StringBuilder)localObject).toString());
    this.playerRenderer.makeCurrent();
    if ((paramMessage.obj instanceof PlayerMessage))
    {
      localObject = ((PlayerMessage)paramMessage.obj).bizMsg1;
      if ((localObject instanceof Runnable)) {
        ((Runnable)localObject).run();
      }
    }
    removePendingMessage(new int[0]);
    releaseAudioThread(paramMessage.what, paramMessage.obj);
    updateStatus(1);
    this.reportSession.flush();
  }
  
  private void releaseAudioThread(int paramInt, Object paramObject)
  {
    if (paramInt == 6)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseAudioThread SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      localStringBuilder.append("  action = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  obj =  ");
      localStringBuilder.append(paramObject);
      Logger.d("PlayerMessageHandler", localStringBuilder.toString());
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
  }
  
  private void releaseComposition()
  {
    if (this.vDecoderTrack == null) {
      return;
    }
    if (this.mPlayerItem.getCustomVideoCompositor() != null) {
      this.mPlayerItem.getCustomVideoCompositor().release();
    }
    this.vDecoderTrack.release();
    this.aDecoderTrack.release();
  }
  
  private void removePendingMessage(int... arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage() called with: removeInt = [");
    int j = ???.length;
    int i = 0;
    Object localObject1;
    if (j == 0) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(???[0]);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    Logger.v("PlayerMessageHandler", localStringBuilder.toString());
    if (???.length != 0)
    {
      j = ???.length;
      while (i < j)
      {
        int k = ???[i];
        this.playerThread.mPlayHandler.removeMessages(k);
        i += 1;
      }
      return;
    }
    synchronized (this.playerThread.mPlayHandler)
    {
      if (!this.playerThread.mPlayHandler.hasMessages(850))
      {
        this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
      }
      else
      {
        this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
        this.playerThread.mPlayHandler.sendEmptyMessage(850);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void removePendingMessageUnless(int... paramVarArgs)
  {
    try
    {
      Iterator localIterator = PlayerThread.msgMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (Arrays.binarySearch(paramVarArgs, localInteger.intValue()) < 0) {
          this.playerThread.mPlayHandler.removeMessages(localInteger.intValue());
        }
      }
      return;
    }
    catch (Exception paramVarArgs)
    {
      Logger.e("PlayerMessageHandler", "removePendingMessageUnless: ", paramVarArgs);
    }
  }
  
  private void scheduleNextWork(long paramLong)
  {
    paramLong /= 1000L;
    if (paramLong > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("waitTime");
      localStringBuilder.append(paramLong);
      Logger.v("scheduleNextWork", localStringBuilder.toString());
      this.playerThread.sendMessageDelay(12, paramLong, "schedule next");
      return;
    }
    this.playerThread.sendMessage(12, "schedule next");
  }
  
  private void scheduleNextWork(CMSampleState paramCMSampleState, boolean paramBoolean)
  {
    if (this.loop)
    {
      boolean bool = this.mPause;
      this.decoderConsumerTimeUs = (Utils.getCurrentUsTime() - this.startTimeUsMark + 5000L);
      scheduleNextWork(getWaitTime(paramCMSampleState.getTime(), paramBoolean, bool));
      this.mPause = false;
    }
  }
  
  private void seek(CMTime paramCMTime)
  {
    seek(paramCMTime, null);
  }
  
  private void seek(CMTime paramCMTime, @Nullable Callback paramCallback)
  {
    if (this.mStatus == 1) {
      return;
    }
    Object localObject = CMTime.CMTimeInvalid;
    try
    {
      CMTime localCMTime = getLastSeekPosAndRemoveOther();
      localObject = localCMTime;
    }
    catch (Exception localException)
    {
      Logger.e("PlayerMessageHandler", "seek: ", localException);
    }
    if (((CMTime)localObject).getValue() > -1L) {
      paramCMTime = (CMTime)localObject;
    }
    if (this.vDecoderTrack != null)
    {
      removePendingMessage(new int[] { 12 });
      this.mPosition = paramCMTime;
      notifyProgressChange();
      syncAudioOtherMsg(3, paramCMTime);
      syncAudioOtherMsg(5, paramCMTime);
      readSample(5, paramCMTime);
      this.playerThread.mPlayHandler.postDelayed(new PlayerMessageHandler.1(this), 10L);
    }
    else
    {
      syncAudioOtherMsg(5, paramCMTime);
    }
    if (paramCallback != null) {
      paramCallback.call();
    }
  }
  
  private void seekPreSample()
  {
    CMTime localCMTime = this.vDecoderTrack.getCurrentSampleTime();
    if (localCMTime != CMTime.CMTimeInvalid) {
      seek(localCMTime);
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    stop(paramBoolean, false);
  }
  
  private void stop(boolean paramBoolean1, boolean paramBoolean2)
  {
    releaseComposition();
    this.playerRenderer.releaseFilter();
    this.mStartTime = 0L;
    updateStatus(1);
    if (paramBoolean1)
    {
      notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
      if (paramBoolean2) {
        removePendingMessageUnless(new int[] { 101, 850 });
      } else {
        removePendingMessage(new int[0]);
      }
      this.loop = false;
      Logger.v("PlayerMessageHandler", "stop: mLooper set to false");
    }
  }
  
  private void synAudioComposition()
  {
    if (this.aDecoderTrack != null)
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("synAudioComposition SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      Logger.d("PlayerMessageHandler", localStringBuilder.toString());
      this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioOtherMsg(int paramInt, Object paramObject)
  {
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 7) || (paramInt == -1) || (paramInt == 5))
    {
      this.lastSyncMessageId = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncAudioOtherMsg SyncMessageId = ");
      localStringBuilder.append(this.lastSyncMessageId);
      localStringBuilder.append("  action = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  obj = ");
      localStringBuilder.append(paramObject);
      Logger.d("PlayerMessageHandler", localStringBuilder.toString());
      this.mAudioThread.sendMessage(paramInt, paramObject, "syncAudioStatus", this.lastSyncMessageId);
    }
  }
  
  private void syncAudioPosition(int paramInt, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readSample[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] lastPosition = ");
    localStringBuilder.append(paramCMTime2);
    localStringBuilder.append(" syncPlayingTime = ");
    localStringBuilder.append(paramCMTime1);
    Logger.v("PlayerMessageHandler", localStringBuilder.toString());
    if (paramInt == 2) {
      syncAudioOtherMsg(2, paramCMTime2);
    }
  }
  
  private void syncAudioProgress()
  {
    IDecoderTrack localIDecoderTrack = this.aDecoderTrack;
    if (localIDecoderTrack == null) {
      return;
    }
    if (!this.mPosition.equalsTo(localIDecoderTrack.getCurrentSampleTime()))
    {
      this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
      notifyProgressChange();
    }
    if (this.mAudioThread.isFinished())
    {
      Logger.v("PlayerMessageHandler", "processFrame() called with: finish");
      playerFinish();
      return;
    }
    if (this.loop)
    {
      scheduleNextWork(30L);
      this.mPause = false;
    }
  }
  
  private void tryInitVideoDecoder(Object paramObject)
  {
    try
    {
      initVideoDecoder(paramObject);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("PlayerMessageHandler", "init composition cause exception: ", localException);
      this.vDecoderTrack.release();
      this.vDecoderTrack = null;
      onCompositionUpdate(paramObject, false);
    }
  }
  
  private void updateAudioClipsProperties()
  {
    IDecoderTrack localIDecoderTrack = this.aDecoderTrack;
    if (localIDecoderTrack != null) {
      localIDecoderTrack.release();
    }
    this.aDecoderTrack = this.mPlayerItem.initAudioCompositionDecoderTrack();
    this.aDecoderTrack.start();
    this.mAudioThread.update(this.aDecoderTrack);
    if (this.loop) {
      syncAudioOtherMsg(2, this.mPosition);
    }
  }
  
  private void updateComposition(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateComposition() called with: obj = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    Logger.i("PlayerMessageHandler", localStringBuilder.toString());
    if ((paramObject instanceof PlayerItem))
    {
      paramObject = (PlayerItem)paramObject;
      this.vDecoderTrack = paramObject.getRealDecoderTrack();
      this.aDecoderTrack = paramObject.getAudioCompositionDecoderTrack();
      this.mPlayerItem = paramObject;
    }
    paramObject = this.vDecoderTrack;
    if (paramObject != null) {
      this.frameDuration = paramObject.getFrameDuration();
    }
    this.mAudioThread.update(this.aDecoderTrack);
  }
  
  private void updateProgressPreNextAction(CMTime paramCMTime)
  {
    this.mPosition = paramCMTime;
  }
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  void bindSurface(IDecoderTrack paramIDecoderTrack, PlayerLayer paramPlayerLayer)
  {
    this.playerRenderer.bindSurface(paramPlayerLayer);
    this.vDecoderTrack = paramIDecoderTrack;
  }
  
  @Nullable
  CGRect getGlViewportRect()
  {
    return this.playerRenderer.getGlViewportRect();
  }
  
  RenderContextParams getRenderContextParams()
  {
    return this.playerRenderer.getRenderContextParams();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = paramMessage.obj;
    Object localObject4 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (PlayerMessage)paramMessage.obj;
    }
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((PlayerMessage)localObject1).bizMsg1;
      localObject3 = ((PlayerMessage)localObject1).bizMsg2;
    }
    else
    {
      localObject2 = null;
      localObject3 = localObject2;
    }
    if (paramMessage.what != 2) {
      syncAudioOtherMsg(paramMessage.what, paramMessage.obj);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage() called with: msg = [");
    localStringBuilder.append(PlayerThread.catLog(paramMessage.what));
    localStringBuilder.append("]--obj-->");
    localStringBuilder.append(localObject2);
    localStringBuilder.append("--from-->");
    if (localObject1 == null) {
      localObject1 = localObject4;
    } else {
      localObject1 = ((PlayerMessage)localObject1).form;
    }
    localStringBuilder.append((String)localObject1);
    Logger.v("PlayerMessageHandler", localStringBuilder.toString());
    if (this.playerThread.mThread == null) {
      return false;
    }
    try
    {
      boolean bool = dispatchMessage(paramMessage, localObject2, localObject3);
      return bool;
    }
    catch (Exception paramMessage)
    {
      Logger.e("PlayerMessageHandler", "player error:", paramMessage);
    }
    return false;
  }
  
  void setAudioThread(PlayerThreadAudio paramPlayerThreadAudio)
  {
    this.mAudioThread = paramPlayerThreadAudio;
  }
  
  void setRate(float paramFloat)
  {
    this.rate = paramFloat;
    this.mAudioThread.setRate(paramFloat);
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.playerRenderer.setRenderContextParams(paramRenderContextParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerMessageHandler
 * JD-Core Version:    0.7.0.1
 */