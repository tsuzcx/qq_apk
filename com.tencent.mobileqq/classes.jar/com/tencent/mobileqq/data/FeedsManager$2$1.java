package com.tencent.mobileqq.data;

import adtk;
import apdy;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class FeedsManager$2$1
  implements Runnable
{
  public FeedsManager$2$1(apdy paramapdy) {}
  
  public void run()
  {
    if (!this.a.a.feedInfoCache.isEmpty()) {
      FeedsManager.access$200(this.a.a).notifyObservers(adtk.class, 10000, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.2.1
 * JD-Core Version:    0.7.0.1
 */