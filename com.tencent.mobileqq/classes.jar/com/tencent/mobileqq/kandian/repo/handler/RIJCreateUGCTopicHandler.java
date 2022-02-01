package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.RspBody;

public class RIJCreateUGCTopicHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJCreateUGCTopicHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xc16.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    long l;
    if (paramToServiceMsg.uint64_topic_id.has()) {
      l = paramToServiceMsg.uint64_topic_id.get();
    } else {
      l = 0L;
    }
    if (paramToServiceMsg.bytes_topic_url.has()) {
      paramToServiceMsg = paramToServiceMsg.bytes_topic_url.get().toStringUtf8();
    } else {
      paramToServiceMsg = "";
    }
    this.b.post(new RIJCreateUGCTopicHandler.1(this, i, l, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCreateUGCTopicHandler
 * JD-Core Version:    0.7.0.1
 */