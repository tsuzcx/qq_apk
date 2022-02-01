package com.tencent.mobileqq.kandian.repo.account;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeReqBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.ReqBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.RspBody;

public class RIJUserLevelRequestModule
  extends ReadInJoyEngineModule
{
  public RIJUserLevelRequestModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xef9.RspBody localRspBody = new oidb_cmd0xef9.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleUserLevel, result=");
    paramFromServiceMsg.append(i);
    QLog.d("RIJUserLevelRequestModule", 1, paramFromServiceMsg.toString());
    if ((i == 0) && (localRspBody.privilege_rsp.has()) && (localRspBody.privilege_rsp.get() != null))
    {
      paramObject = (oidb_cmd0xef9.PrivilegeRspBody)localRspBody.privilege_rsp.get();
      paramFromServiceMsg = paramToServiceMsg.getAttribute("ope_user_info_uin", null);
      paramToServiceMsg = paramToServiceMsg.getAttribute("ope_user_info_type", null);
      if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
      {
        a(paramObject, ((Long)paramFromServiceMsg).longValue(), ((Integer)paramToServiceMsg).intValue());
        paramObject = new StringBuilder();
        paramObject.append("handleUserLevel, update data! uin=");
        paramObject.append(paramFromServiceMsg);
        paramObject.append(" operType=");
        paramObject.append(paramToServiceMsg);
        QLog.d("RIJUserLevelRequestModule", 1, paramObject.toString());
      }
    }
  }
  
  private void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt)
  {
    ThreadManager.a().post(new RIJUserLevelRequestModule.1(this, paramPrivilegeRspBody, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestIconRefreshInfo ,uin=");
    ((StringBuilder)localObject).append(RIJLogUtil.a.a(paramLong));
    ((StringBuilder)localObject).append(" operType=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJUserLevelRequestModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xef9.ReqBody();
    oidb_cmd0xef9.PrivilegeReqBody localPrivilegeReqBody = new oidb_cmd0xef9.PrivilegeReqBody();
    localPrivilegeReqBody.uin.set(paramLong);
    localPrivilegeReqBody.oper_type.set(paramInt);
    ((oidb_cmd0xef9.ReqBody)localObject).privilege_req.set(localPrivilegeReqBody);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xef9", 3833, 1, ((oidb_cmd0xef9.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("ope_user_info_uin", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("ope_user_info_type", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xef9")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserLevelRequestModule
 * JD-Core Version:    0.7.0.1
 */