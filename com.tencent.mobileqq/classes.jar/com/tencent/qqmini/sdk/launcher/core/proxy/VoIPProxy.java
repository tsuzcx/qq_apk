package com.tencent.qqmini.sdk.launcher.core.proxy;

public abstract class VoIPProxy
{
  public abstract int enableLocalAudio(boolean paramBoolean);
  
  public abstract int enableRemoteAudio(boolean paramBoolean);
  
  public abstract void exitRoom();
  
  public abstract void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener);
  
  public abstract int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract void setAudioRoute(int paramInt);
  
  public abstract void unInit();
  
  public abstract void updateRoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
 * JD-Core Version:    0.7.0.1
 */