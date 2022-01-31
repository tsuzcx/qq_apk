package com.tencent.mobileqq.filemanager.activity.localfile;

import aptm;
import apty;
import apxx;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
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
    if (this.this$0.a.e() != 8) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = this.this$0.d.iterator();
      while (((Iterator)localObject1).hasNext()) {
        apty.a(bool, ((apxx)((Iterator)localObject1).next()).a(), ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
      }
    }
    if (this.this$0.f) {}
    for (Object localObject1 = aptm.a().a();; localObject1 = null)
    {
      if (localObject1 != null) {
        apty.a(bool, (String)localObject1, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
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
    }
    apty.a((Map)localObject1);
    QfileLocalFileDocTabView.a(this.this$0, new QfileLocalFileDocTabView.1.1(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1
 * JD-Core Version:    0.7.0.1
 */