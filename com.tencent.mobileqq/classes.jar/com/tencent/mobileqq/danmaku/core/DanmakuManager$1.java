package com.tencent.mobileqq.danmaku.core;

import anfo;
import anfw;
import anga;
import anhn;
import anhx;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, anga paramanga, anhx paramanhx) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Anga == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Anhx.a(this.jdField_a_of_type_Anga.h(), this.jdField_a_of_type_Anga.i());
    anhn localanhn = this.jdField_a_of_type_Anga.a(this.jdField_a_of_type_Anhx);
    if (DanmakuManager.a(this.this$0, localanhn))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localanhn.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Anga);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Anga, this.jdField_a_of_type_Anhx, localanhn);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */