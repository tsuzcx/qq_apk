package com.tencent.mobileqq.mini.entry;

import aukp;
import aukq;
import aukr;
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
    aukp localaukp;
    do
    {
      return;
      QLog.i("MiniAppLocalSearchManager", 1, "removeAllLocalSearchData");
      localaukp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localaukp == null);
    localObject1 = localaukp.a();
    try
    {
      ((aukr)localObject1).a();
      localaukp.b(" DELETE FROM MiniAppLocalSearchEntity ");
      ((aukr)localObject1).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((aukr)localObject1).b();
      }
    }
    finally
    {
      ((aukr)localObject1).b();
    }
    MiniAppLocalSearchManager.access$100(this.this$0, this.val$entities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.1
 * JD-Core Version:    0.7.0.1
 */