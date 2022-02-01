package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.music.QQPlayerCallback;

public abstract interface IOnlineMusicStatusManager
  extends IStatusManager
{
  public abstract int a();
  
  public abstract Lyric a(String paramString);
  
  public abstract void a(int paramInt);
  
  public abstract QQPlayerCallback b();
  
  public abstract void b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager
 * JD-Core Version:    0.7.0.1
 */