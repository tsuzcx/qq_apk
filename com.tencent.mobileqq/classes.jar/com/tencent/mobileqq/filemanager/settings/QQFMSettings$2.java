package com.tencent.mobileqq.filemanager.settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class QQFMSettings$2
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.this$0.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QQFMSettings.StorageInfo)this.this$0.a.get(localObject);
      QQFMSettings localQQFMSettings = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQFMSettings.StorageInfo)localObject).b);
      localStringBuilder.append(((QQFMSettings.StorageInfo)localObject).c);
      localObject = QQFMSettings.c(localQQFMSettings, localStringBuilder.toString());
      QQFMSettings.a(this.this$0, (String)localObject, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.2
 * JD-Core Version:    0.7.0.1
 */