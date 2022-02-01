package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleExposureInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class RIJArticleInfoRepo$5
  implements Runnable
{
  RIJArticleInfoRepo$5(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt) {}
  
  public void run()
  {
    List localList = RIJArticleInfoRepo.b(this.this$0).query(ArticleExposureInfo.class, true, "channelID = ?", new String[] { String.valueOf(this.a) }, null, null, "exposureTime desc", String.valueOf(100));
    if (localList != null)
    {
      localObject1 = new ConcurrentHashMap();
      Object localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject2).next();
        if ((localArticleExposureInfo != null) && (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))) {
          ((ConcurrentHashMap)localObject1).put(localArticleExposureInfo.rowkey, localArticleExposureInfo);
        }
      }
      localObject2 = (ConcurrentMap)RIJArticleInfoRepo.c(this.this$0).get(Integer.valueOf(this.a));
      if ((localObject2 != null) && (((ConcurrentMap)localObject2).size() > 0)) {
        ((ConcurrentHashMap)localObject1).putAll((Map)localObject2);
      }
      RIJArticleInfoRepo.c(this.this$0).put(Integer.valueOf(this.a), localObject1);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadFeedsExposureInfo from db , channelID : ");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(", result : ");
    ((StringBuilder)localObject1).append(localList);
    QLog.d("RIJArticleInfoRepo", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.5
 * JD-Core Version:    0.7.0.1
 */