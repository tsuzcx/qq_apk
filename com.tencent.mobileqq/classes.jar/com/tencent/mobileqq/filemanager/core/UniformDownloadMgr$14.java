package com.tencent.mobileqq.filemanager.core;

import aqwa;
import aqwf;
import arpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(aqwa paramaqwa) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (aqwa.a(this.this$0))
    {
      if (aqwa.a(this.this$0).size() > 0)
      {
        Iterator localIterator = aqwa.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          aqwf localaqwf = (aqwf)((Map.Entry)localIterator.next()).getValue();
          if ((localaqwf != null) && (localaqwf.a != null) && (localaqwf.a.b()) && (2 == localaqwf.a.g())) {
            localArrayList.add(localaqwf);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((aqwf)((Iterator)???).next()).a.e();
    }
    aqwa.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */