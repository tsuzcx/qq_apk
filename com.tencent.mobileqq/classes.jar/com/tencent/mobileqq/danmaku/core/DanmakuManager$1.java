package com.tencent.mobileqq.danmaku.core;

import artq;
import arty;
import aruc;
import arvp;
import arvz;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, aruc paramaruc, arvz paramarvz) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Aruc == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Arvz.a(this.jdField_a_of_type_Aruc.h(), this.jdField_a_of_type_Aruc.i());
    arvp localarvp = this.jdField_a_of_type_Aruc.a(this.jdField_a_of_type_Arvz);
    if (DanmakuManager.a(this.this$0, localarvp))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localarvp.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Aruc);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Aruc, this.jdField_a_of_type_Arvz, localarvp);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */