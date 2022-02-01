package com.tencent.mobileqq.kandian.biz.pts.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ReadInJoyPTSCostHelper$1
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      Iterator localIterator = new ArrayList(ReadInJoyPTSCostHelper.a()).iterator();
      while (localIterator.hasNext()) {
        ReadInJoyPTSCostHelper.a((String)localIterator.next());
      }
      ReadInJoyPTSCostHelper.a().clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper.1
 * JD-Core Version:    0.7.0.1
 */