package com.tencent.mobileqq.filemanager.core;

import apdc;
import apdh;
import apwj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(apdc paramapdc) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (apdc.a(this.this$0))
    {
      if (apdc.a(this.this$0).size() > 0)
      {
        Iterator localIterator = apdc.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          apdh localapdh = (apdh)((Map.Entry)localIterator.next()).getValue();
          if ((localapdh != null) && (localapdh.a != null) && (localapdh.a.b()) && (2 == localapdh.a.g())) {
            localArrayList.add(localapdh);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((apdh)((Iterator)???).next()).a.e();
    }
    apdc.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */