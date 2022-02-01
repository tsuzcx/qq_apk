package com.tencent.mobileqq.qqexpand.audio;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/audio/IExpandAudioPlayer;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "audioPreDownLoad", "", "url", "", "result", "Lcom/tencent/mobileqq/qqexpand/audio/IMethodCallback;", "continueAudioPlay", "pauseAudioPlay", "removeAudioPlayerListener", "setAudioPlayerListener", "statusListener", "Lcom/tencent/mobileqq/qqexpand/audio/IAudioPlayerStatusListener;", "startAudioPlay", "stopAudioPlay", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandAudioPlayer
  extends QRouteApi
{
  public abstract void audioPreDownLoad(@Nullable String paramString, @Nullable IMethodCallback paramIMethodCallback);
  
  public abstract void continueAudioPlay(@Nullable IMethodCallback paramIMethodCallback);
  
  public abstract void pauseAudioPlay(@Nullable IMethodCallback paramIMethodCallback);
  
  public abstract void removeAudioPlayerListener();
  
  public abstract void setAudioPlayerListener(@NotNull IAudioPlayerStatusListener paramIAudioPlayerStatusListener);
  
  public abstract void startAudioPlay(@Nullable String paramString, @Nullable IMethodCallback paramIMethodCallback);
  
  public abstract void stopAudioPlay(@Nullable IMethodCallback paramIMethodCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.IExpandAudioPlayer
 * JD-Core Version:    0.7.0.1
 */