package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric;

public abstract interface LyricBaseInternalViewInterface
{
  public abstract int a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract int b(int paramInt);
  
  public abstract int getEndScrollY();
  
  public abstract Lyric getMeasuredLyric();
  
  public abstract int getTopScroll();
  
  public abstract void setEffectEnable(boolean paramBoolean);
  
  public abstract void setLyric(Lyric paramLyric1, Lyric paramLyric2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricBaseInternalViewInterface
 * JD-Core Version:    0.7.0.1
 */