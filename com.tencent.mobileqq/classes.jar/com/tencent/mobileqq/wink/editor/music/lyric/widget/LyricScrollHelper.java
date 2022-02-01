package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LyricScrollHelper
{
  private List<LyricScrollHelper.LyricScrollListener> a = Collections.synchronizedList(new ArrayList());
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LyricScrollHelper.LyricScrollListener)localIterator.next()).a(paramLong);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LyricScrollHelper.LyricScrollListener)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    if (paramLyricScrollListener == null)
    {
      AEQLog.c("LyricScrollHelper", "registerListener() lyricScrollListener == null.");
      return;
    }
    List localList = this.a;
    if (localList == null)
    {
      AEQLog.c("LyricScrollHelper", "registerListener() mScrollListener == null.");
      return;
    }
    localList.add(paramLyricScrollListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricScrollHelper
 * JD-Core Version:    0.7.0.1
 */