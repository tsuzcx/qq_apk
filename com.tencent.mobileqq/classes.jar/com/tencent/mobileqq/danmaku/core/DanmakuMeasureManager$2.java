package com.tencent.mobileqq.danmaku.core;

import anfs;
import anft;
import anfv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(anfs paramanfs, List paramList, anft paramanft) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      anfv localanfv = (anfv)localIterator.next();
      anfs.a(anfs.a(this.this$0), localanfv);
      if (this.jdField_a_of_type_Anft != null) {
        this.jdField_a_of_type_Anft.a(localanfv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */