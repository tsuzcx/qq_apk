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
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku;
    if (localObject == null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint.a(((BaseDanmaku)localObject).j(), this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku.k());
    localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint);
    if (this.this$0.a((ClickResult)localObject))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener.a(true);
      if (((ClickResult)localObject).a) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolTouchPoint, (ClickResult)localObject);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.1
 * JD-Core Version:    0.7.0.1
 */