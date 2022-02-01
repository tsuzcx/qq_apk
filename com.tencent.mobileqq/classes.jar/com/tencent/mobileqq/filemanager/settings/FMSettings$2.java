package com.tencent.mobileqq.filemanager.settings;

import aumo;
import aumu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FMSettings$2
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.a.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l = aumo.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (aumu)this.this$0.a.get(localObject);
      localObject = aumo.c(this.this$0, ((aumu)localObject).b + ((aumu)localObject).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.2
 * JD-Core Version:    0.7.0.1
 */