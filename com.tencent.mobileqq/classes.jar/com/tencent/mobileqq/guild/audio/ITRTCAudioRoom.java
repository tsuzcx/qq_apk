package com.tencent.mobileqq.guild.audio;

import android.content.Context;

public abstract interface ITRTCAudioRoom
{
  public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback);
  
  public abstract void a(Context paramContext, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback);
  
  public abstract void a(ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback);
  
  public abstract void a(ITRTCAudioRoom.ITRTCAudioRoomListener paramITRTCAudioRoomListener);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.ITRTCAudioRoom
 * JD-Core Version:    0.7.0.1
 */