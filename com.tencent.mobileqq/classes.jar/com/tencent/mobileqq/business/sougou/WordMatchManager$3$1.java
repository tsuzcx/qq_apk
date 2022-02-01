package com.tencent.mobileqq.business.sougou;

import java.util.ArrayList;
import java.util.Iterator;

class WordMatchManager$3$1
  implements Runnable
{
  WordMatchManager$3$1(WordMatchManager.3 param3) {}
  
  public void run()
  {
    this.a.this$0.d = this.a.a;
    this.a.this$0.e = this.a.a;
    this.a.this$0.f = false;
    this.a.this$0.m = false;
    Iterator localIterator = this.a.this$0.h.iterator();
    while (localIterator.hasNext())
    {
      WordMatchManager.MatcherCallback localMatcherCallback = (WordMatchManager.MatcherCallback)localIterator.next();
      if (localMatcherCallback != null) {
        localMatcherCallback.a(this.a.this$0.g);
      }
    }
    this.a.this$0.h.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.3.1
 * JD-Core Version:    0.7.0.1
 */