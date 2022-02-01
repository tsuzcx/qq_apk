package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.controller.LebaController;
import java.util.List;

class Leba$9
  implements Runnable
{
  Leba$9(Leba paramLeba, List paramList) {}
  
  public void run()
  {
    if (this.this$0.c != null)
    {
      this.this$0.c.clear();
      this.this$0.c.addAll(this.a);
      if (this.this$0.e != null) {
        this.this$0.e.c();
      }
      Leba.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.9
 * JD-Core Version:    0.7.0.1
 */