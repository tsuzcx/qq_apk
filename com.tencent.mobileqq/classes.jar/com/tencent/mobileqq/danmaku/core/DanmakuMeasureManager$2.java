package com.tencent.mobileqq.danmaku.core;

import arek;
import arel;
import aren;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(arek paramarek, List paramList, arel paramarel) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      aren localaren = (aren)localIterator.next();
      arek.a(arek.a(this.this$0), localaren);
      if (this.jdField_a_of_type_Arel != null) {
        this.jdField_a_of_type_Arel.a(localaren);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */