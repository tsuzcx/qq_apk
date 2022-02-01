package com.tencent.mobileqq.lyric.widget;

import android.util.Log;

class LyricViewController$1
  implements LyricViewScroll.LyricViewScrollListener
{
  LyricViewController$1(LyricViewController paramLyricViewController) {}
  
  public void a(int paramInt)
  {
    this.a.a = true;
    this.a.c(paramInt);
  }
  
  public void b(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.a.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.1
 * JD-Core Version:    0.7.0.1
 */