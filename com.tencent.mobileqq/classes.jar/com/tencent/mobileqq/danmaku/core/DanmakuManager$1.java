package com.tencent.mobileqq.danmaku.core;

import ampc;
import ampk;
import ampo;
import amrb;
import amrl;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, ampo paramampo, amrl paramamrl) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Ampo == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Amrl.a(this.jdField_a_of_type_Ampo.h(), this.jdField_a_of_type_Ampo.i());
    amrb localamrb = this.jdField_a_of_type_Ampo.a(this.jdField_a_of_type_Amrl);
    if (DanmakuManager.a(this.this$0, localamrb))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localamrb.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Ampo);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Ampo, this.jdField_a_of_type_Amrl, localamrb);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */