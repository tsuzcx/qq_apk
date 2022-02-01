package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DanmakuMeasureManager$2
  implements Runnable
{
  DanmakuMeasureManager$2(DanmakuMeasureManager paramDanmakuMeasureManager, List paramList, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      DanmakuMeasureManager.a(DanmakuMeasureManager.a(this.this$0), localBaseDanmaku);
      DanmakuMeasureManager.IMeasureCallback localIMeasureCallback = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager$IMeasureCallback;
      if (localIMeasureCallback != null) {
        localIMeasureCallback.a(localBaseDanmaku);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */