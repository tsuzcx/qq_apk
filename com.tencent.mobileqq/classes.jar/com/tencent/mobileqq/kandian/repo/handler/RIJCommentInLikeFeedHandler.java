package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;

public abstract class RIJCommentInLikeFeedHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJCommentInLikeFeedHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  protected int a(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramMessageMicro);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("parse0x83eRspResultCode result code :");
    paramFromServiceMsg.append(j);
    QLog.d("RIJCommentInLikeFeedHandler", 1, paramFromServiceMsg.toString());
    int i = j;
    if (j == 84) {
      i = 0;
    }
    return i;
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xb83.RspBody());
    paramFromServiceMsg = Integer.valueOf(0);
    paramObject = paramToServiceMsg.getAttribute("biu_deliver", paramFromServiceMsg);
    boolean bool = true;
    Integer localInteger = Integer.valueOf(1);
    if (paramObject.equals(localInteger)) {}
    int i;
    while (paramToServiceMsg.getAttribute("biu_deliver", paramFromServiceMsg).equals(Integer.valueOf(2)))
    {
      i = 4;
      break;
    }
    if (paramToServiceMsg.getAttribute("ugc_deliver", paramFromServiceMsg).equals(localInteger)) {}
    while (paramToServiceMsg.getAttribute("up_master_deliver", paramFromServiceMsg).equals(localInteger))
    {
      i = 5;
      break;
    }
    if (paramToServiceMsg.getAttribute("submit_comment", paramFromServiceMsg).equals(localInteger)) {
      i = 0;
    } else if (paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type") != null) {
      i = ((Integer)paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type")).intValue();
    } else {
      i = -1;
    }
    if (i == 4) {
      ReadinjoyReportUtils.a(j, paramToServiceMsg, 1, null);
    }
    if (i == 0) {
      ReadinjoyReportUtils.a(j, paramToServiceMsg, 3, null);
    }
    paramFromServiceMsg = RIJQQAppInterfaceUtil.a();
    if (j != 0) {
      bool = false;
    }
    RIJStatisticCollectorReport.a(paramFromServiceMsg, bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedHandler
 * JD-Core Version:    0.7.0.1
 */