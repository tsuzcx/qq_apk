package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.List;

class UsedAppListManager$1
  implements Runnable
{
  UsedAppListManager$1(UsedAppListManager paramUsedAppListManager) {}
  
  public void run()
  {
    if (UsedAppListManager.access$000(this.this$0) == null) {}
    List localList;
    do
    {
      do
      {
        return;
        ??? = UsedAppListManager.access$000(this.this$0).getEntityManagerFactory().createEntityManager();
      } while (??? == null);
      localList = ((EntityManager)???).query(AppInfo.class, AppInfo.class.getSimpleName(), false, null, null, null, null, "timestamp desc", null);
    } while (localList == null);
    synchronized (UsedAppListManager.access$100(this.this$0))
    {
      UsedAppListManager.access$102(this.this$0, localList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.UsedAppListManager.1
 * JD-Core Version:    0.7.0.1
 */