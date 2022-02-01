package com.tencent.mobileqq.danmaku.core;

import aqno;
import aqnw;
import aqoa;
import aqpn;
import aqpx;

public class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, aqoa paramaqoa, aqpx paramaqpx) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_Aqoa == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_Aqpx.a(this.jdField_a_of_type_Aqoa.h(), this.jdField_a_of_type_Aqoa.i());
    aqpn localaqpn = this.jdField_a_of_type_Aqoa.a(this.jdField_a_of_type_Aqpx);
    if (DanmakuManager.a(this.this$0, localaqpn))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localaqpn.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_Aqoa);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_Aqoa, this.jdField_a_of_type_Aqpx, localaqpn);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */