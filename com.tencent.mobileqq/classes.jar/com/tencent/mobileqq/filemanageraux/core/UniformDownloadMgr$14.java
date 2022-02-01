package com.tencent.mobileqq.filemanageraux.core;

import auht;
import auhy;
import aukz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(auht paramauht) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (auht.a(this.this$0))
    {
      if (auht.a(this.this$0).size() > 0)
      {
        Iterator localIterator = auht.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          auhy localauhy = (auhy)((Map.Entry)localIterator.next()).getValue();
          if ((localauhy != null) && (localauhy.a != null) && (localauhy.a.b()) && (2 == localauhy.a.g())) {
            localArrayList.add(localauhy);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((auhy)((Iterator)???).next()).a.e();
    }
    auht.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */