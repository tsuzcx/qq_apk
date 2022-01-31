package com.tencent.mobileqq.filemanager.settings;

import aptm;
import apts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FMSettings$3
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.a.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l = aptm.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (apts)this.this$0.a.get(localObject);
      localObject = aptm.b(this.this$0, ((apts)localObject).b + ((apts)localObject).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.3
 * JD-Core Version:    0.7.0.1
 */