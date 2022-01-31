package com.tencent.mobileqq.danmaku.core;

import apbn;
import apbo;
import apbq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(apbn paramapbn, List paramList, apbo paramapbo) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      apbq localapbq = (apbq)localIterator.next();
      apbn.a(apbn.a(this.this$0), localapbq);
      if (this.jdField_a_of_type_Apbo != null) {
        this.jdField_a_of_type_Apbo.a(localapbq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */