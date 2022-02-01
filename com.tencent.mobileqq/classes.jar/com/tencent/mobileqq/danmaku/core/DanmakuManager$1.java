package com.tencent.mobileqq.danmaku.core;

import arqz;
import arrh;
import arrl;
import arsy;
import arti;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, arrl paramarrl, arti paramarti) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Arrl == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Arti.a(this.jdField_a_of_type_Arrl.h(), this.jdField_a_of_type_Arrl.i());
    arsy localarsy = this.jdField_a_of_type_Arrl.a(this.jdField_a_of_type_Arti);
    if (DanmakuManager.a(this.this$0, localarsy))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localarsy.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Arrl);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Arrl, this.jdField_a_of_type_Arti, localarsy);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */