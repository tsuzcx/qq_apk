package com.tencent.mobileqq.danmaku.core;

import anfj;
import anfr;
import anfv;
import anhi;
import anhs;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, anfv paramanfv, anhs paramanhs) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Anfv == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Anhs.a(this.jdField_a_of_type_Anfv.h(), this.jdField_a_of_type_Anfv.i());
    anhi localanhi = this.jdField_a_of_type_Anfv.a(this.jdField_a_of_type_Anhs);
    if (DanmakuManager.a(this.this$0, localanhi))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localanhi.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Anfv);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Anfv, this.jdField_a_of_type_Anhs, localanhi);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */