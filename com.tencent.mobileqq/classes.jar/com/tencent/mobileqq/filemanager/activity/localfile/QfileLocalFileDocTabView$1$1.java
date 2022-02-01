package com.tencent.mobileqq.filemanager.activity.localfile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileDocTabView$1$1
  implements Runnable
{
  QfileLocalFileDocTabView$1$1(QfileLocalFileDocTabView.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    this.b.this$0.l.clear();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.a.get(str);
      if (localList.size() != 0) {
        this.b.this$0.l.put(str, localList);
      }
    }
    this.b.this$0.i();
    this.b.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1.1
 * JD-Core Version:    0.7.0.1
 */