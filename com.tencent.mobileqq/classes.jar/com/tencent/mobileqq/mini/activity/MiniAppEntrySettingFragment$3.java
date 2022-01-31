package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import atmp;
import atmq;
import atmr;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppEntrySettingFragment$3
  implements Runnable
{
  MiniAppEntrySettingFragment$3(MiniAppEntrySettingFragment paramMiniAppEntrySettingFragment, List paramList) {}
  
  public void run()
  {
    if (MiniAppEntrySettingFragment.access$200(this.this$0) != null)
    {
      localObject1 = MiniAppEntrySettingFragment.access$200(this.this$0).app;
      if (localObject1 != null) {
        break label34;
      }
      QLog.e("MiniAppEntrySettingFragment", 2, "updateLocalSwitchDataList, app is null.");
    }
    label34:
    atmp localatmp;
    do
    {
      return;
      QLog.i("MiniAppEntrySettingFragment", 1, "removeAllLocalSwitchDataList");
      localatmp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localatmp == null);
    localObject1 = localatmp.a();
    try
    {
      ((atmr)localObject1).a();
      localatmp.b(" DELETE FROM MiniAppSettingSwitchInfoEntity ");
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
    MiniAppEntrySettingFragment.access$400(this.this$0, this.val$serverSwitchInfoEntities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.3
 * JD-Core Version:    0.7.0.1
 */