package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.ReqBody;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.RspBody;

public class RIJUGCAccountCreateModule
  extends ReadInJoyEngineModule
{
  private RIJUGCAccountCreateModule.UGCAccountCreateCallback a;
  private RIJUGCAccountCreateModule.UGCAccountStatusCallback b;
  
  public RIJUGCAccountCreateModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong, int paramInt)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    localReqBody.uint32_op_type.set(paramInt);
    return ReadInJoyOidbHelper.a("OidbSvc.0xe71", 3697, paramInt, localReqBody.toByteArray());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE");
    if (localInteger.intValue() == 1)
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (localInteger.intValue() == 2) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleUGCAccountCreate result = ");
      paramToServiceMsg.append(i);
      QLog.d("RIJUGCAccountCreateModule", 1, paramToServiceMsg.toString());
      return;
    }
    i = RIJPBFieldUtils.a(paramToServiceMsg.uint32_result, -1);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleUGCAccountCreate pbResult = ");
    paramFromServiceMsg.append(i);
    QLog.d("RIJUGCAccountCreateModule", 1, paramFromServiceMsg.toString());
    if (i >= 0)
    {
      paramFromServiceMsg = this.a;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(paramToServiceMsg.uint32_result.get());
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleUGCAccountStatus result = ");
      paramToServiceMsg.append(i);
      QLog.d("RIJUGCAccountCreateModule", 1, paramToServiceMsg.toString());
      return;
    }
    i = RIJPBFieldUtils.a(paramToServiceMsg.account_status);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleUGCAccountStatus status = ");
    paramToServiceMsg.append(i);
    QLog.d("RIJUGCAccountCreateModule", 1, paramToServiceMsg.toString());
    paramToServiceMsg = this.b;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.a(i);
    }
  }
  
  public void a(long paramLong, RIJUGCAccountCreateModule.UGCAccountCreateCallback paramUGCAccountCreateCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestUgcAccountCreate uin: ");
    localStringBuilder.append(paramLong);
    QLog.d("RIJUGCAccountCreateModule", 1, localStringBuilder.toString());
    if (paramUGCAccountCreateCallback != null) {
      this.a = paramUGCAccountCreateCallback;
    }
    paramUGCAccountCreateCallback = a(paramLong, 1);
    paramUGCAccountCreateCallback.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramUGCAccountCreateCallback.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(1));
    sendPbReq(paramUGCAccountCreateCallback);
  }
  
  public void a(long paramLong, RIJUGCAccountCreateModule.UGCAccountStatusCallback paramUGCAccountStatusCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestUgcAccountStatus uin: ");
    localStringBuilder.append(RIJLogUtil.a.a(paramLong));
    QLog.d("RIJUGCAccountCreateModule", 1, localStringBuilder.toString());
    if (paramUGCAccountStatusCallback != null) {
      this.b = paramUGCAccountStatusCallback;
    }
    paramUGCAccountStatusCallback = a(paramLong, 2);
    paramUGCAccountStatusCallback.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    paramUGCAccountStatusCallback.addAttribute("KEY_UGC_USER_ACCOUNT_OPT_TYPE", Integer.valueOf(2));
    sendPbReq(paramUGCAccountStatusCallback);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule
 * JD-Core Version:    0.7.0.1
 */