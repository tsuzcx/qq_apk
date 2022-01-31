package com.tencent.mobileqq.danmaku.core;

import apbe;
import apbm;
import apbq;
import apdd;
import apdn;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, apbq paramapbq, apdn paramapdn) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Apbq == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Apdn.a(this.jdField_a_of_type_Apbq.h(), this.jdField_a_of_type_Apbq.i());
    apdd localapdd = this.jdField_a_of_type_Apbq.a(this.jdField_a_of_type_Apdn);
    if (DanmakuManager.a(this.this$0, localapdd))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localapdd.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Apbq);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Apbq, this.jdField_a_of_type_Apdn, localapdd);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */