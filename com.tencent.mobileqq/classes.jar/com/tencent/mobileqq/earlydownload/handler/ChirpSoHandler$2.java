package com.tencent.mobileqq.earlydownload.handler;

import asbt;
import asbu;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(asbt paramasbt) {}
  
  public void run()
  {
    synchronized (asbt.a(this.this$0))
    {
      Iterator localIterator = asbt.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((asbu)localIterator.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */