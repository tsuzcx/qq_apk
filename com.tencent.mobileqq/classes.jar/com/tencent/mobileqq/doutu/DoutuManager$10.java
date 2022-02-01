package com.tencent.mobileqq.doutu;

import ascj;
import com.tencent.mobileqq.persistence.EntityManager;

public class DoutuManager$10
  implements Runnable
{
  public DoutuManager$10(ascj paramascj) {}
  
  public void run()
  {
    if (ascj.a(this.this$0) != null) {
      ascj.a(this.this$0).drop(DoutuData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.10
 * JD-Core Version:    0.7.0.1
 */