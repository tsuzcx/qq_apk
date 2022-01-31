package com.tencent.mobileqq.danmaku.core;

import aowv;
import aoxd;
import aoxh;
import aoyu;
import aoze;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, aoxh paramaoxh, aoze paramaoze) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Aoxh == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Aoze.a(this.jdField_a_of_type_Aoxh.h(), this.jdField_a_of_type_Aoxh.i());
    aoyu localaoyu = this.jdField_a_of_type_Aoxh.a(this.jdField_a_of_type_Aoze);
    if (DanmakuManager.a(this.this$0, localaoyu))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localaoyu.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Aoxh);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Aoxh, this.jdField_a_of_type_Aoze, localaoyu);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */