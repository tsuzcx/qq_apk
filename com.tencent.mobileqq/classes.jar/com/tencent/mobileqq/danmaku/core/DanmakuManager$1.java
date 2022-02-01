package com.tencent.mobileqq.danmaku.core;

import areb;
import arej;
import aren;
import arga;
import argk;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, aren paramaren, argk paramargk) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Aren == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Argk.a(this.jdField_a_of_type_Aren.h(), this.jdField_a_of_type_Aren.i());
    arga localarga = this.jdField_a_of_type_Aren.a(this.jdField_a_of_type_Argk);
    if (DanmakuManager.a(this.this$0, localarga))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localarga.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Aren);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Aren, this.jdField_a_of_type_Argk, localarga);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */