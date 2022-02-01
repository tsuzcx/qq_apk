package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.RspBody;

public class RIJRefreshTopicInfoHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJRefreshTopicInfoHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(int paramInt)
  {
    ConcurrentMap localConcurrentMap1 = this.a.i().d(paramInt);
    ConcurrentMap localConcurrentMap2 = this.a.i().a(paramInt);
    if ((localConcurrentMap1 != null) && (localConcurrentMap2 != null) && (!this.f.isTerminated()))
    {
      if (this.f.isShutdown()) {
        return;
      }
      this.f.execute(new RIJRefreshTopicInfoHandler.1(this, localConcurrentMap2, localConcurrentMap1, paramInt));
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xa6e.RspBody localRspBody = new oidb_cmd0xa6e.RspBody();
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      paramFromServiceMsg = localRspBody.rpt_topicinfo.get();
      int i = ((Integer)paramToServiceMsg.getAttribute("channelId")).intValue();
      paramToServiceMsg = (Set)paramToServiceMsg.getAttribute("0xa6e_articleSeqSet");
      this.f.execute(new RIJRefreshTopicInfoHandler.2(this, i, paramToServiceMsg, paramFromServiceMsg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJRefreshTopicInfoHandler
 * JD-Core Version:    0.7.0.1
 */