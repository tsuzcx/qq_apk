package com.tencent.mobileqq.together.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQPlayerServiceApi
  extends QRouteApi
{
  public abstract String getQQPlayerServiceToken();
  
  public abstract boolean isListeningTogether();
  
  public abstract boolean isPlayStateCompletion(int paramInt);
  
  public abstract boolean isPlayStateError(int paramInt);
  
  public abstract boolean isPlayStatePause(int paramInt);
  
  public abstract boolean isPlayStatePlaying(int paramInt);
  
  public abstract boolean isPlayStateStop(int paramInt);
  
  public abstract boolean isQQPlayServicePlaying();
  
  public abstract boolean isStateCompletion(int paramInt);
  
  public abstract boolean isStateError(int paramInt);
  
  public abstract boolean isStatePause(int paramInt);
  
  public abstract boolean isStatePlaying(int paramInt);
  
  public abstract boolean isStateStop(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.api.IQQPlayerServiceApi
 * JD-Core Version:    0.7.0.1
 */