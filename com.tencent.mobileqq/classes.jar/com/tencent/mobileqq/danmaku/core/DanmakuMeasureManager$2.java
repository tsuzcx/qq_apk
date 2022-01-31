package com.tencent.mobileqq.danmaku.core;

import ampl;
import ampm;
import ampo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(ampl paramampl, List paramList, ampm paramampm) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      ampo localampo = (ampo)localIterator.next();
      ampl.a(ampl.a(this.this$0), localampo);
      if (this.jdField_a_of_type_Ampm != null) {
        this.jdField_a_of_type_Ampm.a(localampo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */