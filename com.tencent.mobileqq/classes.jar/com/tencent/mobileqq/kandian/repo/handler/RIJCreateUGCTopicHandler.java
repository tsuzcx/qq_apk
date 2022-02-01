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
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.ReqBody;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.RspBody;

public class RIJCreateUGCTopicHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJCreateUGCTopicHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    oidb_cmd0xc16.ReqBody localReqBody = new oidb_cmd0xc16.ReqBody();
    Object localObject1 = "";
    if (paramTopicInfo != null)
    {
      long l = paramTopicInfo.b();
      localReqBody.uint64_uin.set(l);
      Object localObject2 = paramTopicInfo.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramTopicInfo.b();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      Object localObject4 = paramTopicInfo.d();
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      localObject4 = paramTopicInfo.c();
      paramTopicInfo = (TopicInfo)localObject4;
      if (localObject4 == null) {
        paramTopicInfo = "";
      }
      localReqBody.bytes_topic_title.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localReqBody.bytes_topic_desc.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqBody.bytes_topic_pic_url.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      localReqBody.bytes_topic_cover_pic_url.set(ByteStringMicro.copyFromUtf8(paramTopicInfo));
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("uin:");
      ((StringBuilder)localObject4).append(l);
      ((StringBuilder)localObject4).append("  title:");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append("  des:");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(" headUrl:");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(" coerUrl:");
      ((StringBuilder)localObject4).append(paramTopicInfo);
      localObject1 = ((StringBuilder)localObject4).toString();
    }
    paramTopicInfo = new StringBuilder();
    paramTopicInfo.append(" request0xc16CreateTopic, ");
    paramTopicInfo.append((String)localObject1);
    QLog.d("RIJCreateUGCTopicHandler", 1, paramTopicInfo.toString());
    paramTopicInfo = ReadInJoyOidbHelper.a("OidbSvc.0xc16", 3094, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReq(paramTopicInfo);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCreateUGCTopicHandler.1(this, i, l, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCreateUGCTopicHandler
 * JD-Core Version:    0.7.0.1
 */