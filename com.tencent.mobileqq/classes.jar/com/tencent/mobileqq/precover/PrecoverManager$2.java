package com.tencent.mobileqq.precover;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class PrecoverManager$2
  implements Runnable
{
  PrecoverManager$2(PrecoverManager paramPrecoverManager, String paramString) {}
  
  public void run()
  {
    boolean bool1 = true;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      synchronized (PrecoverManager.a(this.this$0))
      {
        if (TextUtils.isEmpty(this.a))
        {
          Object localObject1 = PrecoverManager.a(this.this$0).keySet();
          localObject4 = new ArrayList();
          localObject1 = ((Set)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject5 = (String)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "startDownload, download business=", localObject5 });
          }
          localObject5 = (List)PrecoverManager.a(this.this$0).get(localObject5);
          if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
            continue;
          }
          ((List)localObject4).addAll((Collection)localObject5);
        }
      }
      localObject3 = new HashSet();
      ((Set)localObject3).add(this.a);
    }
    if ((this.a == null) && (PrecoverUtils.a(PrecoverManager.a(this.this$0).getApp(), "res_cover"))) {}
    for (;;)
    {
      if (bool1)
      {
        PrecoverUtils.a(PrecoverManager.a(this.this$0).getApp(), "res_cover");
        PrecoverManager.a(this.this$0, true);
        PrecoverManager.a(this.this$0, new HashSet());
        PrecoverManager.a(this.this$0).a(this.this$0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "startDownload, needReport=", Boolean.valueOf(bool1), ", resToDownload.size=", Integer.valueOf(((List)localObject4).size()) });
      }
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PrecoverResource)((Iterator)localObject3).next();
        if ((localObject4 != null) && (((PrecoverResource)localObject4).isValid()))
        {
          if ((bool1) && (PrecoverManager.a(this.this$0) != null)) {
            PrecoverManager.a(this.this$0).add(localObject4);
          }
          boolean bool2 = PrecoverManager.a(this.this$0).a((PrecoverResource)localObject4, null, true, false);
          if ((bool1) && (PrecoverManager.a(this.this$0) != null) && (!bool2)) {
            PrecoverManager.a(this.this$0).remove(localObject4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "startDownload, res=" + localObject4 + ", started=" + bool2);
          }
        }
      }
      if ((bool1) && (PrecoverManager.a(this.this$0) != null) && (PrecoverManager.a(this.this$0).size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "startDownload, nothing need download, doing report");
        }
        PrecoverManager.a(this.this$0, false);
        PrecoverManager.a(this.this$0).b(this.this$0);
        PrecoverManager.a(this.this$0).a();
      }
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverManager.2
 * JD-Core Version:    0.7.0.1
 */