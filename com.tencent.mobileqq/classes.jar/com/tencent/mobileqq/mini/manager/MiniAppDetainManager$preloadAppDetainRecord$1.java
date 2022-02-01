package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniAppDetainManager$preloadAppDetainRecord$1
  implements Runnable
{
  MiniAppDetainManager$preloadAppDetainRecord$1(String paramString) {}
  
  public final void run()
  {
    Object localObject = MiniAppDetainManager.access$getOrCreateEntityManager(MiniAppDetainManager.INSTANCE);
    if (localObject != null) {
      localObject = ((MiniAppEntityManager)localObject).find(AppDetainRecordEntity.class, "appId=?", new String[] { this.$appId });
    } else {
      localObject = null;
    }
    if ((localObject instanceof AppDetainRecordEntity)) {
      ((Map)MiniAppDetainManager.access$getMRecordCached$p(MiniAppDetainManager.INSTANCE)).put(this.$appId, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniAppDetainManager.preloadAppDetainRecord.1
 * JD-Core Version:    0.7.0.1
 */