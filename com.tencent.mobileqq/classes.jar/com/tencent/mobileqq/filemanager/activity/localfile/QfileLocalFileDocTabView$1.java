package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileDocTabView$1
  implements Runnable
{
  QfileLocalFileDocTabView$1(QfileLocalFileDocTabView paramQfileLocalFileDocTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    boolean bool;
    if (this.this$0.C.E() != 8) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = this.this$0.m.iterator();
    while (((Iterator)localObject1).hasNext()) {
      FileCategoryUtil.a(bool, ((QfileTabBarView.ScanParams)((Iterator)localObject1).next()).a(), ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
    }
    localObject1 = new HashMap();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      String str = QfileLocalFileDocTabView.a(this.this$0, (String)localObject2);
      localObject2 = (List)localHashMap.get(localObject2);
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(str)).addAll((Collection)localObject2);
    }
    FileCategoryUtil.a((Map)localObject1);
    QfileLocalFileDocTabView.a(this.this$0, new QfileLocalFileDocTabView.1.1(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1
 * JD-Core Version:    0.7.0.1
 */