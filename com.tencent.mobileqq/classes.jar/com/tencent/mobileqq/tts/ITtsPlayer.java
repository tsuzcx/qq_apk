package com.tencent.mobileqq.tts;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tts.silk.IPlayerCallback;
import java.io.InputStream;

@QAPI(process={"all"})
public abstract interface ITtsPlayer
  extends QRouteApi
{
  public abstract boolean isPlaying();
  
  public abstract void release();
  
  public abstract void setDataStream(InputStream paramInputStream);
  
  public abstract void setPlayerCallback(IPlayerCallback paramIPlayerCallback);
  
  public abstract void start();
  
  public abstract void start(int paramInt);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.ITtsPlayer
 * JD-Core Version:    0.7.0.1
 */