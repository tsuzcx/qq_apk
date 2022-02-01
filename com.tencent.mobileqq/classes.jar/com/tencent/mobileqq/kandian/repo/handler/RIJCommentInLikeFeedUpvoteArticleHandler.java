package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class RIJCommentInLikeFeedUpvoteArticleHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedUpvoteArticleHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    int i;
    if (paramBoolean) {
      i = 12;
    } else {
      i = 13;
    }
    localReqBody.uint64_uin.set(paramLong);
    Object localObject = localReqBody.uint32_operation;
    int j;
    if (paramBoolean) {
      j = 2;
    } else {
      j = 3;
    }
    ((PBUInt32Field)localObject).set(j);
    localObject = localReqBody.bytes_inner_uniq_id;
    if (paramFastWebArticleInfo != null) {
      paramFastWebArticleInfo = paramFastWebArticleInfo.j;
    } else {
      paramFastWebArticleInfo = "";
    }
    ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramFastWebArticleInfo));
    paramFastWebArticleInfo = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
    paramFastWebArticleInfo.addAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(1));
    paramFastWebArticleInfo.addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
    paramFastWebArticleInfo.addAttribute("request_like_scene", Integer.valueOf(paramInt));
    this.a.sendPbReq(paramFastWebArticleInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    int i = 0;
    boolean bool = true;
    if (j == 0)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, "handle0x83eUpvoteFastWebArticleAction result OK");
      if (localRspBody.uint32_operation.has())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handle0x83eUpvoteFastWebArticleAction | upvote status :");
        if (localRspBody.uint32_operation.get() != 2) {
          bool = false;
        }
        paramFromServiceMsg.append(bool);
        QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 2, paramFromServiceMsg.toString());
      }
    }
    else
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x83eUpvoteFastWebArticleAction failed result ");
      paramFromServiceMsg.append(j);
      QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, paramFromServiceMsg.toString());
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("request_like_scene");
    if (paramToServiceMsg != null) {
      i = ((Integer)paramToServiceMsg).intValue();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(new RIJCommentInLikeFeedUpvoteArticleHandler.1(this, i, j, localRspBody));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUpvoteArticleHandler
 * JD-Core Version:    0.7.0.1
 */