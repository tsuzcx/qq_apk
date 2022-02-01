package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import com.tencent.trtc.TRTCCloudListener;

public abstract interface TRTCInterface
  extends TRTCAudioInterface, TRTCVideoInterface
{
  public abstract void a(String paramString, TRTCCloudListener paramTRTCCloudListener);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, TRTCCustomCmdHandlerListener paramTRTCCustomCmdHandlerListener);
  
  public abstract void b(String paramString, TRTCCloudListener paramTRTCCloudListener);
  
  public abstract void j(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCInterface
 * JD-Core Version:    0.7.0.1
 */