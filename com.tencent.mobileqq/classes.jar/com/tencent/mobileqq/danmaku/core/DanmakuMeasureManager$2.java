package com.tencent.mobileqq.danmaku.core;

import arri;
import arrj;
import arrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(arri paramarri, List paramList, arrj paramarrj) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      arrl localarrl = (arrl)localIterator.next();
      arri.a(arri.a(this.this$0), localarrl);
      if (this.jdField_a_of_type_Arrj != null) {
        this.jdField_a_of_type_Arrj.a(localarrl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */