package com.tencent.mobileqq.listentogether.lyrics;

import android.graphics.Paint.Align;
import com.tencent.mobileqq.lyric.data.Lyric;

public abstract interface ILyricView
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract boolean d();
  
  public abstract String getSongId();
  
  public abstract int getState();
  
  public abstract void setAlign(Paint.Align paramAlign);
  
  public abstract void setLineMaxWidth(int paramInt);
  
  public abstract void setLyric(Lyric paramLyric, int paramInt);
  
  public abstract void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener);
  
  public abstract void setSongId(String paramString);
  
  public abstract void setStrokeColor(int paramInt);
  
  public abstract void setStrokeWidth(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.ILyricView
 * JD-Core Version:    0.7.0.1
 */