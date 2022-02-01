package com.tencent.mobileqq.kandian.base.automator;

import java.util.ArrayList;
import java.util.Collections;

class Automator$1
  implements Runnable
{
  Automator$1(Automator paramAutomator, BaseStep[] paramArrayOfBaseStep, boolean paramBoolean) {}
  
  public void run()
  {
    Automator.a(this.this$0).clear();
    Collections.addAll(Automator.a(this.this$0), this.a);
    Collections.addAll(Automator.b(this.this$0), this.a);
    if (this.b) {
      Automator.c(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.Automator.1
 * JD-Core Version:    0.7.0.1
 */