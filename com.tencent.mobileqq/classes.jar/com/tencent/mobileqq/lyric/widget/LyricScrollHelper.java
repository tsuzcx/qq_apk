package com.tencent.mobileqq.lyric.widget;

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
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LyricScrollHelper.LyricScrollListener)localIterator.next()).b(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricScrollHelper
 * JD-Core Version:    0.7.0.1
 */