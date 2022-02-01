package com.tencent.mobileqq.lyric.widget;

import android.util.Log;

class LyricViewController$1
  implements LyricViewScroll.LyricViewScrollListener
{
  LyricViewController$1(LyricViewController paramLyricViewController) {}
  
  public void a(int paramInt)
  {
    LyricViewController localLyricViewController = this.a;
    localLyricViewController.e = true;
    localLyricViewController.c(paramInt);
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScrollStop -> top:");
    localStringBuilder.append(paramInt);
    Log.d("ModuleController", localStringBuilder.toString());
    this.a.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.1
 * JD-Core Version:    0.7.0.1
 */