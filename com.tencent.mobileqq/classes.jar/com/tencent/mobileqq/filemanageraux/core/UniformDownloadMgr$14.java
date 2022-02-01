package com.tencent.mobileqq.filemanageraux.core;

import atdm;
import atdr;
import atgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(atdm paramatdm) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (atdm.a(this.this$0))
    {
      if (atdm.a(this.this$0).size() > 0)
      {
        Iterator localIterator = atdm.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          atdr localatdr = (atdr)((Map.Entry)localIterator.next()).getValue();
          if ((localatdr != null) && (localatdr.a != null) && (localatdr.a.b()) && (2 == localatdr.a.g())) {
            localArrayList.add(localatdr);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((atdr)((Iterator)???).next()).a.e();
    }
    atdm.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */