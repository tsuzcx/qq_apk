package com.tencent.mobileqq.business.sougou;

import java.util.ArrayList;

class WordMatchManager$1
  implements Runnable
{
  WordMatchManager$1(WordMatchManager paramWordMatchManager, WordMatchManager.MatcherCallback paramMatcherCallback) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if ((localObject != null) && (!this.this$0.a.contains(this.a))) {
      this.this$0.a.add(this.a);
    }
    if (!this.this$0.d)
    {
      localObject = this.this$0;
      ((WordMatchManager)localObject).d = true;
      ((WordMatchManager)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.1
 * JD-Core Version:    0.7.0.1
 */