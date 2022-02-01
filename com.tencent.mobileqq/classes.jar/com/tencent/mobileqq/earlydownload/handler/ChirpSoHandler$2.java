package com.tencent.mobileqq.earlydownload.handler;

import asdl;
import asdm;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(asdl paramasdl) {}
  
  public void run()
  {
    synchronized (asdl.a(this.this$0))
    {
      Iterator localIterator = asdl.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((asdm)localIterator.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */