package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import aukp;
import aukq;
import aukr;
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
    aukp localaukp;
    do
    {
      return;
      QLog.i("MiniAppEntrySettingFragment", 1, "removeAllLocalSwitchDataList");
      localaukp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while (localaukp == null);
    localObject1 = localaukp.a();
    try
    {
      ((aukr)localObject1).a();
      localaukp.b(" DELETE FROM MiniAppSettingSwitchInfoEntity ");
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
    MiniAppEntrySettingFragment.access$400(this.this$0, this.val$serverSwitchInfoEntities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.3
 * JD-Core Version:    0.7.0.1
 */