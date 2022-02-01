package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class RIJCommentInLikeFeedUpvoteActionHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedUpvoteActionHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1 = new oidb_cmd0x83e.ReqBody();
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    if (paramLong1 != -1L) {
      ((oidb_cmd0x83e.ReqBody)localObject1).uint64_uin.set(paramLong1);
    }
    if (paramLong2 != -1L) {
      ((oidb_cmd0x83e.ReqBody)localObject1).uint64_feeds_id.set(paramLong2);
    }
    ((oidb_cmd0x83e.ReqBody)localObject1).uint32_operation.set(i);
    Object localObject2 = new oidb_cmd0x83e.FeedsInfo();
    ((oidb_cmd0x83e.FeedsInfo)localObject2).feeds_type.set(paramAbsBaseArticleInfo.busiType);
    ((oidb_cmd0x83e.FeedsInfo)localObject2).uint32_business_id.set((int)paramAbsBaseArticleInfo.businessId);
    ((oidb_cmd0x83e.ReqBody)localObject1).msg_feeds_info.set((MessageMicro)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(RIJQQAppInterfaceUtil.a()));
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    localObject2 = ((StringBuilder)localObject2).toString();
    ((oidb_cmd0x83e.ReqBody)localObject1).bytes_req_seq.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("0x83e_article", paramAbsBaseArticleInfo);
    ((ToServiceMsg)localObject1).addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReqWithAutoRetry((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    if (a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (localRspBody.uint64_feeds_id.has())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("upvote feeds id:");
          paramFromServiceMsg.append(localRspBody.uint64_feeds_id.get());
          QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 2, paramFromServiceMsg.toString());
        }
        if (localRspBody.uint32_operation.has())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("upvote status:");
          boolean bool;
          if (localRspBody.uint32_operation.get() == 2) {
            bool = true;
          } else {
            bool = false;
          }
          paramFromServiceMsg.append(bool);
          QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 2, paramFromServiceMsg.toString());
        }
      }
      try
      {
        paramToServiceMsg = (AbsBaseArticleInfo)paramToServiceMsg.getAttribute("0x83e_article");
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJCommentInLikeFeedUpvoteActionHandler.1(this, paramToServiceMsg));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("RIJCommentInLikeFeedUpvoteActionHandler", 1, "failed to update article ", paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUpvoteActionHandler
 * JD-Core Version:    0.7.0.1
 */