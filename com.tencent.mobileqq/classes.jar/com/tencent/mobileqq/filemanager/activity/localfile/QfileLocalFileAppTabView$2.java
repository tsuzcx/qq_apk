package com.tencent.mobileqq.filemanager.activity.localfile;

import aumo;
import aunb;
import aupu;
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
      aunb.a(this.this$0.a, this.this$0);
      aunb.a(true, aumo.a().b(), ".apk", "", localHashMap, this.this$0);
      localObject = aumo.a().a();
      if (localObject != null) {
        aunb.a(true, (String)localObject, ".apk", "", localHashMap, null);
      }
    }
    for (;;)
    {
      aunb.a(localHashMap);
      QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.2.1(this));
      return;
      localObject = this.this$0.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        aunb.a(true, ((aupu)((Iterator)localObject).next()).a(), ".apk", "", localHashMap, this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
 * JD-Core Version:    0.7.0.1
 */