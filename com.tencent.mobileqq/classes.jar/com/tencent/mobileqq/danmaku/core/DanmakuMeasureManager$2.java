package com.tencent.mobileqq.danmaku.core;

import anfx;
import anfy;
import anga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(anfx paramanfx, List paramList, anfy paramanfy) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      anga localanga = (anga)localIterator.next();
      anfx.a(anfx.a(this.this$0), localanga);
      if (this.jdField_a_of_type_Anfy != null) {
        this.jdField_a_of_type_Anfy.a(localanga);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */