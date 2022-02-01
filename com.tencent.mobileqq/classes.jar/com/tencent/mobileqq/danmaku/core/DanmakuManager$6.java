package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;

class DanmakuManager$6
  implements DanmakuMeasureManager.IMeasureCallback
{
  DanmakuManager$6(DanmakuManager paramDanmakuManager) {}
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    DanmakuManager.a(this.a).b(paramBaseDanmaku);
    if (this.a.a != null) {
      this.a.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.6
 * JD-Core Version:    0.7.0.1
 */