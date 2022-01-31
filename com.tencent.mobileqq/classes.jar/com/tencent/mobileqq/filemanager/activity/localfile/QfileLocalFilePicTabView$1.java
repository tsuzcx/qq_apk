package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import apti;
import aptw;
import apxv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class QfileLocalFilePicTabView$1
  implements Runnable
{
  QfileLocalFilePicTabView$1(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, Context paramContext) {}
  
  public void run()
  {
    if (this.this$0.f) {}
    for (HashMap localHashMap = (HashMap)aptw.a(this.a);; localHashMap = null)
    {
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        Object localObject1 = this.this$0.d.iterator();
        while (((Iterator)localObject1).hasNext()) {
          aptw.a(true, ((apxv)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
        }
        if (this.this$0.f) {}
        for (localObject1 = apti.a().a();; localObject1 = null)
        {
          if (localObject1 != null) {
            aptw.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
          }
          aptw.a(localHashMap);
          if (localHashMap == null) {
            break;
          }
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            if ("QQfile_recv".equalsIgnoreCase((String)localObject2) != true)
            {
              localObject2 = (List)localHashMap.get(localObject2);
              this.this$0.a.addAll((Collection)localObject2);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1
 * JD-Core Version:    0.7.0.1
 */