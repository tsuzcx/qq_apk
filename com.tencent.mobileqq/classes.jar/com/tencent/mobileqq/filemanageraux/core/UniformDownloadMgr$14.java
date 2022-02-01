package com.tencent.mobileqq.filemanageraux.core;

import atzj;
import atzo;
import aucp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(atzj paramatzj) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (atzj.a(this.this$0))
    {
      if (atzj.a(this.this$0).size() > 0)
      {
        Iterator localIterator = atzj.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          atzo localatzo = (atzo)((Map.Entry)localIterator.next()).getValue();
          if ((localatzo != null) && (localatzo.a != null) && (localatzo.a.b()) && (2 == localatzo.a.g())) {
            localArrayList.add(localatzo);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((atzo)((Iterator)???).next()).a.e();
    }
    atzj.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */