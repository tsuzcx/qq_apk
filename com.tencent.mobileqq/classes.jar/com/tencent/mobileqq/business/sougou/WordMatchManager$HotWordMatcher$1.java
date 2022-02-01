package com.tencent.mobileqq.business.sougou;

import java.lang.ref.WeakReference;

class WordMatchManager$HotWordMatcher$1
  implements Runnable
{
  WordMatchManager$HotWordMatcher$1(WordMatchManager.HotWordMatcher paramHotWordMatcher, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem) {}
  
  public void run()
  {
    if ((this.b.d != null) && (this.b.d.e != null))
    {
      WordMatchManager.MatchCallback localMatchCallback = (WordMatchManager.MatchCallback)this.b.d.e.get();
      if (localMatchCallback != null) {
        localMatchCallback.a(this.b.d.b, this.a);
      }
    }
    this.b.dispatchNextTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher.1
 * JD-Core Version:    0.7.0.1
 */