package com.tencent.mobileqq.business.sougou;

import anuh;
import java.util.ArrayList;

class WordMatchManager$1
  implements Runnable
{
  WordMatchManager$1(WordMatchManager paramWordMatchManager, anuh paramanuh) {}
  
  public void run()
  {
    if (this.a == null) {}
    do
    {
      return;
      if ((this.a != null) && (!this.this$0.a.contains(this.a))) {
        this.this$0.a.add(this.a);
      }
    } while (this.this$0.d);
    this.this$0.d = true;
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.1
 * JD-Core Version:    0.7.0.1
 */