package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class FeedsManager$1
  implements Runnable
{
  FeedsManager$1(FeedsManager paramFeedsManager) {}
  
  public void run()
  {
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      int i = FeedsManager.access$000(this.this$0).delete(new FeedInfo().getTableName(), "feedTime<?", new String[] { String.valueOf(l - 604800L) });
      if (QLog.isColorLevel()) {
        QLog.i("FeedsManager", 2, String.format("删除 %d 条 7天前的feeds记录", new Object[] { Integer.valueOf(i) }));
      }
      Object localObject = (ArrayList)FeedsManager.access$000(this.this$0).query(FeedInfo.class);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedInfo localFeedInfo = (FeedInfo)((Iterator)localObject).next();
          this.this$0.feedInfoCache.put(String.valueOf(localFeedInfo.ownerUin), localFeedInfo);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FeedsManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.1
 * JD-Core Version:    0.7.0.1
 */