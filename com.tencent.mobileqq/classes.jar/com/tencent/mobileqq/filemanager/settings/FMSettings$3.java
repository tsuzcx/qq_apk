package com.tencent.mobileqq.filemanager.settings;

import audf;
import audl;
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
    for (long l = 0L; localIterator.hasNext(); l = audf.a(this.this$0, (String)localObject, localArrayList) + l)
    {
      localObject = (String)localIterator.next();
      localObject = (audl)this.this$0.a.get(localObject);
      localObject = audf.b(this.this$0, ((audl)localObject).b + ((audl)localObject).c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.3
 * JD-Core Version:    0.7.0.1
 */