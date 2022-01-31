package com.tencent.mobileqq.filemanager.activity.localfile;

import armo;
import arna;
import arqz;
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
      arna.a(this.this$0.a, this.this$0);
      arna.a(true, armo.a().b(), ".apk", "", localHashMap, this.this$0);
      localObject = armo.a().a();
      if (localObject != null) {
        arna.a(true, (String)localObject, ".apk", "", localHashMap, null);
      }
    }
    for (;;)
    {
      arna.a(localHashMap);
      QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.2.1(this));
      return;
      localObject = this.this$0.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        arna.a(true, ((arqz)((Iterator)localObject).next()).a(), ".apk", "", localHashMap, this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
 * JD-Core Version:    0.7.0.1
 */