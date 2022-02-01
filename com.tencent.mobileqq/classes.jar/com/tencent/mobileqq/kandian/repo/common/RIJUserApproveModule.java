package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveStateReqBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveStateRspBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.NumApproveStateItem;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.ReqBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.RspBody;

public class RIJUserApproveModule
  extends ReadInJoyEngineModule
{
  private RIJUserApproveModule.UserApproveCallback a;
  
  public RIJUserApproveModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong)
  {
    oidb_cmd0xb57.ReqBody localReqBody = new oidb_cmd0xb57.ReqBody();
    localReqBody.uint32_oper.set(2);
    List localList = Arrays.asList(new Long[] { Long.valueOf(paramLong) });
    oidb_cmd0xb57.GetNumApproveStateReqBody localGetNumApproveStateReqBody = new oidb_cmd0xb57.GetNumApproveStateReqBody();
    localGetNumApproveStateReqBody.rpt_uint64_query_num.set(localList);
    localReqBody.msg_get_num_approve_state_req.set(localGetNumApproveStateReqBody);
    return ReadInJoyOidbHelper.a("OidbSvc.0xb57", 2903, 16, localReqBody.toByteArray());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xb57.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("RIJUserApproveModule", 1, new Object[] { "handle0xb57UserInfo result = ", Integer.valueOf(i) });
    if ((i == 0) && (((oidb_cmd0xb57.RspBody)localObject).msg_get_num_approve_state_rsp.has()))
    {
      paramFromServiceMsg = ((oidb_cmd0xb57.RspBody)localObject).msg_get_num_approve_state_rsp.rpt_msg_num_approve_state_items.get();
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (oidb_cmd0xb57.NumApproveStateItem)paramFromServiceMsg.next();
          if ((paramObject != null) && (paramObject.uint64_query_num.has()))
          {
            localObject = (Long)paramToServiceMsg.getAttribute("KEY_USER_APPROVE_UIN");
            long l = paramObject.uint64_query_num.get();
            if ((l == ((Long)localObject).longValue()) && (paramObject.uint32_is_approve.has()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("handle0xb57UserInfo state = ");
              ((StringBuilder)localObject).append(paramObject.uint32_is_approve.get());
              QLog.d("RIJUserApproveModule", 1, ((StringBuilder)localObject).toString());
              localObject = ReadInJoyUserInfoModule.a(l, null);
              if (localObject != null) {
                ((ReadInJoyUserInfo)localObject).isApproved = paramObject.uint32_is_approve.get();
              }
              localObject = this.a;
              if (localObject != null) {
                ((RIJUserApproveModule.UserApproveCallback)localObject).a(paramObject.uint32_is_approve.get());
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong, RIJUserApproveModule.UserApproveCallback paramUserApproveCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestUserApproveInfo uin: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("RIJUserApproveModule", 1, ((StringBuilder)localObject).toString());
    if (paramUserApproveCallback != null) {
      this.a = paramUserApproveCallback;
    }
    localObject = ReadInJoyUserInfoModule.a(paramLong, null);
    if ((localObject != null) && (((ReadInJoyUserInfo)localObject).isApproved != -1))
    {
      if (paramUserApproveCallback != null) {
        paramUserApproveCallback.a(((ReadInJoyUserInfo)localObject).isApproved);
      }
      return;
    }
    paramUserApproveCallback = a(paramLong);
    if (paramUserApproveCallback != null)
    {
      paramUserApproveCallback.addAttribute("KEY_USER_APPROVE_UIN", Long.valueOf(paramLong));
      sendPbReq(paramUserApproveCallback);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb57")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJUserApproveModule
 * JD-Core Version:    0.7.0.1
 */