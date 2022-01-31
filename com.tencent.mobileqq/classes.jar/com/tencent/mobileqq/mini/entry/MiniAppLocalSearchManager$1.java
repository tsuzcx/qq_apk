package com.tencent.mobileqq.mini.entry;

import aukn;
import auko;
import aukp;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppLocalSearchManager$1
  implements Runnable
{
  MiniAppLocalSearchManager$1(MiniAppLocalSearchManager paramMiniAppLocalSearchManager, List paramList) {}
  
  public void run()
  {
    localObject1 = MiniAppLocalSearchManager.access$000();
    if (localObject1 == null) {
      QLog.e("MiniAppLocalSearchManager", 2, "getLocalSearchData, app is null.");
    }
    aukn localaukn;
    do
    {
      return;
      QLog.i("MiniAppLocalSearchManager", 1, "removeAllLocalSearchData");
      localaukn = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localaukn == null);
    localObject1 = localaukn.a();
    try
    {
      ((aukp)localObject1).a();
      localaukn.b(" DELETE FROM MiniAppLocalSearchEntity ");
      ((aukp)localObject1).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((aukp)localObject1).b();
      }
    }
    finally
    {
      ((aukp)localObject1).b();
    }
    MiniAppLocalSearchManager.access$100(this.this$0, this.val$entities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.1
 * JD-Core Version:    0.7.0.1
 */