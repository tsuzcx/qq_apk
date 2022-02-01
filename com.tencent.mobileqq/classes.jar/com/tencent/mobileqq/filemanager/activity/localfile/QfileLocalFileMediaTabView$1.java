package com.tencent.mobileqq.filemanager.activity.localfile;

import anni;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    QfileLocalFileMediaTabView.a(this.this$0, localArrayList);
    QfileLocalFileMediaTabView.b(this.this$0, localArrayList);
    this.this$0.a.addAll(localArrayList);
    HashMap localHashMap1 = QfileLocalFileMediaTabView.a(this.this$0);
    HashMap localHashMap2 = QfileLocalFileMediaTabView.b(this.this$0);
    Object localObject = localHashMap1.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.addAll((Collection)localHashMap1.get((String)((Iterator)localObject).next()));
    }
    localObject = localHashMap2.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.addAll((Collection)localHashMap2.get((String)((Iterator)localObject).next()));
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = localArrayList.iterator();
    FileInfo localFileInfo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localFileInfo = (FileInfo)localIterator.next();
        if (localFileInfo == null)
        {
          localIterator.remove();
        }
        else
        {
          localObject = localFileInfo.a();
          if ((localObject != null) && (((String)localObject).length() != 0)) {
            if (("camera".equalsIgnoreCase((String)localObject) == true) || ("Video".equalsIgnoreCase((String)localObject) == true)) {
              localObject = "Camera";
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, new ArrayList());
      }
      if (((List)localLinkedHashMap.get(localObject)).contains(localFileInfo)) {
        break;
      }
      ((List)localLinkedHashMap.get(localObject)).add(localFileInfo);
      break;
      if ("QQ".equalsIgnoreCase((String)localObject))
      {
        localObject = anni.a(2131708440);
        continue;
        QfileLocalFileMediaTabView.a(this.this$0, new QfileLocalFileMediaTabView.1.1(this, localArrayList, localHashMap2, localHashMap1, localLinkedHashMap));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */