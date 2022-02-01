package com.tencent.mobileqq.winkpublish.player;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public abstract interface FSPlayerCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void a(ISuperPlayer paramISuperPlayer);
  
  public abstract void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  
  public abstract void b();
  
  public abstract void b(ISuperPlayer paramISuperPlayer);
  
  public abstract void c();
  
  public abstract Object getReportData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSPlayerCallback
 * JD-Core Version:    0.7.0.1
 */