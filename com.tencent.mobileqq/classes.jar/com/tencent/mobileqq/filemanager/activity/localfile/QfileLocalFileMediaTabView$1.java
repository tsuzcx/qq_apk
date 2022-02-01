package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.HardCodeUtil;
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
    this.this$0.v.addAll(localArrayList);
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
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      if (localFileInfo == null)
      {
        localIterator.remove();
      }
      else
      {
        String str = localFileInfo.a();
        if ((str != null) && (str.length() != 0))
        {
          if (("camera".equalsIgnoreCase(str) != true) && ("Video".equalsIgnoreCase(str) != true))
          {
            localObject = str;
            if ("QQ".equalsIgnoreCase(str)) {
              localObject = HardCodeUtil.a(2131896092);
            }
          }
          else
          {
            localObject = "Camera";
          }
          if (!localLinkedHashMap.containsKey(localObject)) {
            localLinkedHashMap.put(localObject, new ArrayList());
          }
          if (!((List)localLinkedHashMap.get(localObject)).contains(localFileInfo)) {
            ((List)localLinkedHashMap.get(localObject)).add(localFileInfo);
          }
        }
      }
    }
    QfileLocalFileMediaTabView.a(this.this$0, new QfileLocalFileMediaTabView.1.1(this, localArrayList, localHashMap2, localHashMap1, localLinkedHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */