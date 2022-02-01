package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.persistence.EntityManager;

class DoutuManager$10
  implements Runnable
{
  DoutuManager$10(DoutuManager paramDoutuManager) {}
  
  public void run()
  {
    if (DoutuManager.a(this.this$0) != null) {
      DoutuManager.a(this.this$0).drop(DoutuData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.10
 * JD-Core Version:    0.7.0.1
 */