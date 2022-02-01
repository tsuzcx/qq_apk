package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.EntityManager;

class HotPicManager$1
  implements Runnable
{
  HotPicManager$1(HotPicManager paramHotPicManager, HotPicSendData paramHotPicSendData1, HotPicSendData paramHotPicSendData2) {}
  
  public void run()
  {
    HotPicManager.a(this.this$0).persistOrReplace(this.a);
    if (this.b != null) {
      HotPicManager.a(this.this$0).remove(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.1
 * JD-Core Version:    0.7.0.1
 */