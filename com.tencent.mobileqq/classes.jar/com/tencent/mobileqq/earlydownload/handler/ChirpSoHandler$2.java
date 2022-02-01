package com.tencent.mobileqq.earlydownload.handler;

import arnx;
import arny;
import java.util.Iterator;
import java.util.LinkedList;

public class ChirpSoHandler$2
  implements Runnable
{
  public ChirpSoHandler$2(arnx paramarnx) {}
  
  public void run()
  {
    synchronized (arnx.a(this.this$0))
    {
      Iterator localIterator = arnx.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((arny)localIterator.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.2
 * JD-Core Version:    0.7.0.1
 */