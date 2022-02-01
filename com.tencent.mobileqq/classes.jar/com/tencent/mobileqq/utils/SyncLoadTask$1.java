package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

final class SyncLoadTask$1
  implements Runnable
{
  SyncLoadTask$1(ArrayList paramArrayList1, Resources paramResources, SyncLoadTask.OnSyncTaskListener paramOnSyncTaskListener, ArrayList paramArrayList2) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SyncLoadTask localSyncLoadTask = (SyncLoadTask)localIterator.next();
      if (localSyncLoadTask.runOnSubThread(this.b))
      {
        localArrayList1.add(localSyncLoadTask);
      }
      else
      {
        localSyncLoadTask.clean();
        localArrayList2.add(localSyncLoadTask);
      }
    }
    ThreadManager.getUIHandler().post(new SyncLoadTask.1.1(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SyncLoadTask.1
 * JD-Core Version:    0.7.0.1
 */