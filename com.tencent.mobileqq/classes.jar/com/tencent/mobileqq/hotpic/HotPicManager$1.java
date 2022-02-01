package com.tencent.mobileqq.hotpic;

import augn;
import com.tencent.mobileqq.persistence.EntityManager;

public class HotPicManager$1
  implements Runnable
{
  public HotPicManager$1(augn paramaugn, HotPicSendData paramHotPicSendData1, HotPicSendData paramHotPicSendData2) {}
  
  public void run()
  {
    augn.a(this.this$0).persistOrReplace(this.a);
    if (this.b != null) {
      augn.a(this.this$0).remove(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.1
 * JD-Core Version:    0.7.0.1
 */