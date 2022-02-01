package com.tencent.mobileqq.filemanageraux.core;

import aure;
import aurj;
import auuk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(aure paramaure) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (aure.a(this.this$0))
    {
      if (aure.a(this.this$0).size() > 0)
      {
        Iterator localIterator = aure.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          aurj localaurj = (aurj)((Map.Entry)localIterator.next()).getValue();
          if ((localaurj != null) && (localaurj.a != null) && (localaurj.a.b()) && (2 == localaurj.a.g())) {
            localArrayList.add(localaurj);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((aurj)((Iterator)???).next()).a.e();
    }
    aure.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */