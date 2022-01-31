package com.tencent.mobileqq.mini.entry;

import atmp;
import atmq;
import atmr;
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
    atmp localatmp;
    do
    {
      return;
      QLog.i("MiniAppLocalSearchManager", 1, "removeAllLocalSearchData");
      localatmp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localatmp == null);
    localObject1 = localatmp.a();
    try
    {
      ((atmr)localObject1).a();
      localatmp.b(" DELETE FROM MiniAppLocalSearchEntity ");
      ((atmr)localObject1).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((atmr)localObject1).b();
      }
    }
    finally
    {
      ((atmr)localObject1).b();
    }
    MiniAppLocalSearchManager.access$100(this.this$0, this.val$entities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.1
 * JD-Core Version:    0.7.0.1
 */