package com.tencent.mobileqq.filemanager.core;

import aome;
import aomj;
import apen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(aome paramaome) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (aome.a(this.this$0))
    {
      if (aome.a(this.this$0).size() > 0)
      {
        Iterator localIterator = aome.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          aomj localaomj = (aomj)((Map.Entry)localIterator.next()).getValue();
          if ((localaomj != null) && (localaomj.a != null) && (localaomj.a.b()) && (2 == localaomj.a.g())) {
            localArrayList.add(localaomj);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((aomj)((Iterator)???).next()).a.e();
    }
    aome.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */