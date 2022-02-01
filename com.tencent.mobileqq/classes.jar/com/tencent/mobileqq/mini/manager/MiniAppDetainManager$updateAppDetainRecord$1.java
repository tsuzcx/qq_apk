package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import com.tencent.mobileqq.persistence.Entity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniAppDetainManager$updateAppDetainRecord$1
  implements Runnable
{
  MiniAppDetainManager$updateAppDetainRecord$1(AppDetainRecordEntity paramAppDetainRecordEntity) {}
  
  public final void run()
  {
    MiniAppEntityManager localMiniAppEntityManager = MiniAppDetainManager.access$getOrCreateEntityManager(MiniAppDetainManager.INSTANCE);
    if (localMiniAppEntityManager != null) {
      localMiniAppEntityManager.insertOrReplaceEntity((Entity)this.$record);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniAppDetainManager.updateAppDetainRecord.1
 * JD-Core Version:    0.7.0.1
 */