package com.tencent.mobileqq.mini.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MiniAppEntrySettingFragment$4
  implements Runnable
{
  MiniAppEntrySettingFragment$4(MiniAppEntrySettingFragment paramMiniAppEntrySettingFragment, MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity) {}
  
  public void run()
  {
    Object localObject1;
    if (MiniAppEntrySettingFragment.access$200(this.this$0) != null)
    {
      localObject1 = MiniAppEntrySettingFragment.access$200(this.this$0).app;
      if (localObject1 != null) {
        break label34;
      }
      QLog.e("MiniAppEntrySettingFragment", 2, "updateDataToDB, app is null.");
    }
    for (;;)
    {
      return;
      label34:
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      if (localObject1 != null)
      {
        localObject2 = MiniAppSettingSwitchInfoEntity.class.getSimpleName();
        Object localObject3 = this.val$entity.key;
        String str = this.val$entity.key;
        localObject2 = ((EntityManager)localObject1).query(MiniAppSettingSwitchInfoEntity.class, (String)localObject2, false, "key = ?", new String[] { localObject3 }, null, null, null, str);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MiniAppSettingSwitchInfoEntity)((Iterator)localObject2).next();
          MiniAppEntrySettingFragment.access$500(this.this$0, (EntityManager)localObject1, (Entity)localObject3);
        }
      }
    }
    Object localObject2 = new MiniAppSettingSwitchInfoEntity(this.val$entity.key, this.val$entity.title, this.val$entity.subTitle, this.val$entity.value);
    MiniAppEntrySettingFragment.access$500(this.this$0, (EntityManager)localObject1, (Entity)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.4
 * JD-Core Version:    0.7.0.1
 */