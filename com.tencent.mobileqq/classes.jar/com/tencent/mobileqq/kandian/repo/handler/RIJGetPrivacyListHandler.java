package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListRspBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.ReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.RspBody;

public class RIJGetPrivacyListHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJGetPrivacyListHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" request0xc32GetPrivacyList | feedsid ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" | startIndex ");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("RIJGetPrivacyListHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xc32.ReqBody();
    ((oidb_cmd0xc32.ReqBody)localObject).enum_op.set(2);
    oidb_cmd0xc32.GetVisibleListReqBody localGetVisibleListReqBody = new oidb_cmd0xc32.GetVisibleListReqBody();
    localGetVisibleListReqBody.uint64_feeds_id.set(paramLong);
    localGetVisibleListReqBody.uint32_start_ix.set(paramInt1);
    localGetVisibleListReqBody.uint32_want_num.set(paramInt2);
    ((oidb_cmd0xc32.ReqBody)localObject).msg_get_req_body.set(localGetVisibleListReqBody);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xc32", 3122, 2, ((oidb_cmd0xc32.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc32.RspBody localRspBody = new oidb_cmd0xc32.RspBody();
    int m = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handle0x32GetPrivacyList | retCode ");
    paramToServiceMsg.append(m);
    QLog.d("RIJGetPrivacyListHandler", 1, paramToServiceMsg.toString());
    int i = -1;
    paramToServiceMsg = null;
    long l = 0L;
    int k = 0;
    int j;
    boolean bool;
    if ((m == 0) && (localRspBody.msg_get_rsp_body.has()))
    {
      paramFromServiceMsg = (oidb_cmd0xc32.GetVisibleListRspBody)localRspBody.msg_get_rsp_body.get();
      if (paramFromServiceMsg.rpt_uint64_visible_uins.has()) {
        paramToServiceMsg = paramFromServiceMsg.rpt_uint64_visible_uins.get();
      }
      if (paramFromServiceMsg.uint64_feeds_id.has()) {
        l = paramFromServiceMsg.uint64_feeds_id.get();
      }
      if (paramFromServiceMsg.uint32_next_ix.has()) {
        i = paramFromServiceMsg.uint32_next_ix.get();
      }
      if (paramFromServiceMsg.uint32_total_count.has()) {
        j = paramFromServiceMsg.uint32_total_count.get();
      } else {
        j = 0;
      }
      if ((paramFromServiceMsg.uint32_is_end.has()) && (paramFromServiceMsg.uint32_is_end.get() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x32GetPrivacyList | feedsId ");
      paramFromServiceMsg.append(l);
      paramFromServiceMsg.append("| totalCnt ");
      paramFromServiceMsg.append(j);
      paramFromServiceMsg.append(" | nextPageStartIndex ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(" | hasNextPage ");
      paramFromServiceMsg.append(bool);
      paramFromServiceMsg.append("| uinList size ");
      if (paramToServiceMsg != null) {
        k = paramToServiceMsg.size();
      }
      paramFromServiceMsg.append(k);
      QLog.d("RIJGetPrivacyListHandler", 1, paramFromServiceMsg.toString());
    }
    else
    {
      paramToServiceMsg = null;
      i = -1;
      j = 0;
      bool = false;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJGetPrivacyListHandler.1(this, m, l, paramToServiceMsg, i, j, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetPrivacyListHandler
 * JD-Core Version:    0.7.0.1
 */