package com.tencent.mobileqq.danmaku.core;

import artz;
import arua;
import aruc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(artz paramartz, List paramList, arua paramarua) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      aruc localaruc = (aruc)localIterator.next();
      artz.a(artz.a(this.this$0), localaruc);
      if (this.jdField_a_of_type_Arua != null) {
        this.jdField_a_of_type_Arua.a(localaruc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */