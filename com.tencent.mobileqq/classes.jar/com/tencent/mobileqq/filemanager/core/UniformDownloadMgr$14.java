package com.tencent.mobileqq.filemanager.core;

import araj;
import arao;
import artu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(araj paramaraj) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (araj.a(this.this$0))
    {
      if (araj.a(this.this$0).size() > 0)
      {
        Iterator localIterator = araj.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          arao localarao = (arao)((Map.Entry)localIterator.next()).getValue();
          if ((localarao != null) && (localarao.a != null) && (localarao.a.b()) && (2 == localarao.a.g())) {
            localArrayList.add(localarao);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((arao)((Iterator)???).next()).a.e();
    }
    araj.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */