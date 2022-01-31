package com.tencent.mobileqq.danmaku.core;

import aoxe;
import aoxf;
import aoxh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(aoxe paramaoxe, List paramList, aoxf paramaoxf) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      aoxh localaoxh = (aoxh)localIterator.next();
      aoxe.a(aoxe.a(this.this$0), localaoxh);
      if (this.jdField_a_of_type_Aoxf != null) {
        this.jdField_a_of_type_Aoxf.a(localaoxh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */