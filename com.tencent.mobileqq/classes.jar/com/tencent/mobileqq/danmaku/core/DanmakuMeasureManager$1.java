package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;

class DanmakuMeasureManager$1
  implements Runnable
{
  DanmakuMeasureManager$1(DanmakuMeasureManager paramDanmakuMeasureManager, BaseDanmaku paramBaseDanmaku, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback) {}
  
  public void run()
  {
    DanmakuMeasureManager.a(DanmakuMeasureManager.a(this.this$0), this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku);
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager$IMeasureCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager$IMeasureCallback.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuDataBaseDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1
 * JD-Core Version:    0.7.0.1
 */