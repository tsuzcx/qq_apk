package com.tencent.mobileqq.hotpic;

import avtm;
import com.tencent.mobileqq.persistence.EntityManager;

public class HotPicManager$1
  implements Runnable
{
  public HotPicManager$1(avtm paramavtm, HotPicSendData paramHotPicSendData1, HotPicSendData paramHotPicSendData2) {}
  
  public void run()
  {
    avtm.a(this.this$0).persistOrReplace(this.a);
    if (this.b != null) {
      avtm.a(this.this$0).remove(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.1
 * JD-Core Version:    0.7.0.1
 */