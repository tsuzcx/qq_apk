package com.tencent.mobileqq.danmaku.core;

import aqnx;
import aqny;
import aqoa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(aqnx paramaqnx, List paramList, aqny paramaqny) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      aqoa localaqoa = (aqoa)localIterator.next();
      aqnx.a(aqnx.a(this.this$0), localaqoa);
      if (this.jdField_a_of_type_Aqny != null) {
        this.jdField_a_of_type_Aqny.a(localaqoa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */