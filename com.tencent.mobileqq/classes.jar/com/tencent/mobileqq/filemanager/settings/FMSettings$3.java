package com.tencent.mobileqq.filemanager.settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FMSettings$3
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.a.keySet().iterator();
    Object localObject;
    for (long l = 0L; localIterator.hasNext(); l = FMSettings.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (FMSettings.StorageInfo)this.this$0.a.get(localObject);
      localObject = FMSettings.b(this.this$0, ((FMSettings.StorageInfo)localObject).b + ((FMSettings.StorageInfo)localObject).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.3
 * JD-Core Version:    0.7.0.1
 */