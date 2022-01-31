package com.tencent.mobileqq.filemanager.core;

import apcy;
import apdd;
import apwh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(apcy paramapcy) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (apcy.a(this.this$0))
    {
      if (apcy.a(this.this$0).size() > 0)
      {
        Iterator localIterator = apcy.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          apdd localapdd = (apdd)((Map.Entry)localIterator.next()).getValue();
          if ((localapdd != null) && (localapdd.a != null) && (localapdd.a.b()) && (2 == localapdd.a.g())) {
            localArrayList.add(localapdd);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((apdd)((Iterator)???).next()).a.e();
    }
    apcy.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */