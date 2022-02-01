package dov.com.qq.im.aeeditor.lyric.widget;

import android.util.Log;

class LyricViewController$1
  implements LyricViewScroll.LyricViewScrollListener
{
  LyricViewController$1(LyricViewController paramLyricViewController) {}
  
  public void a(int paramInt)
  {
    Log.d("ModuleController", "onScrolling() top => " + paramInt);
    this.a.d(paramInt);
  }
  
  public void b(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.a.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.1
 * JD-Core Version:    0.7.0.1
 */