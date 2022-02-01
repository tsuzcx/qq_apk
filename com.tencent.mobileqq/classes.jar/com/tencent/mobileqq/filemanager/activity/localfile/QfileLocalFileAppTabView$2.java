package com.tencent.mobileqq.filemanager.activity.localfile;

import audf;
import auds;
import augj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QfileLocalFileAppTabView$2
  implements Runnable
{
  QfileLocalFileAppTabView$2(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (this.this$0.f)
    {
      auds.a(this.this$0.a, this.this$0);
      auds.a(true, audf.a().b(), ".apk", "", localHashMap, this.this$0);
      localObject = audf.a().a();
      if (localObject != null) {
        auds.a(true, (String)localObject, ".apk", "", localHashMap, null);
      }
    }
    for (;;)
    {
      auds.a(localHashMap);
      QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.2.1(this));
      return;
      localObject = this.this$0.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        auds.a(true, ((augj)((Iterator)localObject).next()).a(), ".apk", "", localHashMap, this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
 * JD-Core Version:    0.7.0.1
 */