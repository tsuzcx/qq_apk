package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;

class DanmakuManager$1
  implements Runnable
{
  DanmakuManager$1(DanmakuManager paramDanmakuManager, BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint) {}
  
  public void run()
  {
    if (DanmakuManager.a(this.this$0) == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku == null)
    {
      DanmakuManager.a(this.this$0).a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku.h(), this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku.i());
    ClickResult localClickResult = this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint);
    if (DanmakuManager.a(this.this$0, localClickResult))
    {
      DanmakuManager.a(this.this$0).a(true);
      if (localClickResult.a) {
        DanmakuManager.a(this.this$0).b(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku);
      }
      DanmakuManager.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint, localClickResult);
      return;
    }
    DanmakuManager.a(this.this$0).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */