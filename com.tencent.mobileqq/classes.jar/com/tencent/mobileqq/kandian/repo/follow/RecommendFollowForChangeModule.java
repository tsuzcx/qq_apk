package com.tencent.mobileqq.kandian.repo.follow;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.GetRecommendAccountRsp;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.RecommendAccountInfo;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.ReqBody;
import tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.RspBody;

public class RecommendFollowForChangeModule
  extends ReadInJoyEngineModule
{
  public static final String a = "RecommendFollowForChangeModule";
  
  public RecommendFollowForChangeModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    this.mMainThreadHandler.post(new RecommendFollowForChangeModule.1(this, paramBoolean, paramLong, paramList));
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    oidb_cmd0xbbe.ReqBody localReqBody = new oidb_cmd0xbbe.ReqBody();
    localReqBody.uint64_article_id.set(paramLong);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localReqBody.bytes_info_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xbbe", 3006, 1, localReqBody.toByteArray()));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive response cmd = ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject).append(", code = ");
      ((StringBuilder)localObject).append(i);
      QLog.d(paramToServiceMsg, 2, ((StringBuilder)localObject).toString());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbe")) {
      if (i != 1000)
      {
        a(false, -1L, null);
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_cmd0xbbe.RspBody();
        if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject) == 0)
        {
          if ((((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.has()) && (((oidb_cmd0xbbe.GetRecommendAccountRsp)((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.get()).rpt_msg_recommend_account_info.has()))
          {
            long l = 0L;
            paramToServiceMsg = new ArrayList();
            if (((oidb_cmd0xbbe.RspBody)localObject).uint64_article_id.has()) {
              l = ((oidb_cmd0xbbe.RspBody)localObject).uint64_article_id.get();
            }
            paramFromServiceMsg = ((oidb_cmd0xbbe.GetRecommendAccountRsp)((oidb_cmd0xbbe.RspBody)localObject).msg_get_recommend_account_rsp.get()).rpt_msg_recommend_account_info.get().iterator();
            bool1 = paramFromServiceMsg.hasNext();
            boolean bool2 = true;
            if (bool1)
            {
              paramObject = (oidb_cmd0xbbe.RecommendAccountInfo)paramFromServiceMsg.next();
              localObject = new RecommendFollowInfo();
              if (paramObject.uint64_uin.has()) {
                ((RecommendFollowInfo)localObject).uin = paramObject.uint64_uin.get();
              }
              if (paramObject.uint32_account_type.has()) {
                ((RecommendFollowInfo)localObject).type = paramObject.uint32_account_type.get();
              }
              if (paramObject.bytes_recommend_reason.has()) {
                ((RecommendFollowInfo)localObject).recommendReason = paramObject.bytes_recommend_reason.get().toStringUtf8();
              }
              if (paramObject.bytes_nick_name.has()) {
                ((RecommendFollowInfo)localObject).nickName = paramObject.bytes_nick_name.get().toStringUtf8();
              }
              if (paramObject.bytes_head_img_url.has()) {
                ((RecommendFollowInfo)localObject).headUrl = paramObject.bytes_head_img_url.get().toStringUtf8();
              }
              if (paramObject.uint32_is_vip.has())
              {
                if (paramObject.uint32_is_vip.get() != 1) {
                  break label566;
                }
                bool1 = true;
                ((RecommendFollowInfo)localObject).isVip = bool1;
              }
              if (paramObject.uint32_is_star.has())
              {
                if (paramObject.uint32_is_star.get() != 1) {
                  break label572;
                }
                bool1 = bool2;
                ((RecommendFollowInfo)localObject).isStar = bool1;
              }
              if (paramObject.uint64_algorithm_id.has()) {
                ((RecommendFollowInfo)localObject).algorithmId = paramObject.uint64_algorithm_id.get();
              }
              if (paramObject.uint32_strategy_id.has()) {
                ((RecommendFollowInfo)localObject).strategyId = paramObject.uint32_strategy_id.get();
              }
              paramToServiceMsg.add(localObject);
              continue;
            }
            if (paramToServiceMsg.size() > 0) {
              a(true, l, paramToServiceMsg);
            }
          }
        }
        else
        {
          a(false, -1L, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder();
          paramObject.append("onReceive e = ");
          paramObject.append(QLog.getStackTraceString(paramToServiceMsg));
          QLog.e(paramFromServiceMsg, 2, paramObject.toString());
        }
        a(false, -1L, null);
      }
      return;
      label566:
      boolean bool1 = false;
      continue;
      label572:
      bool1 = false;
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.RecommendFollowForChangeModule
 * JD-Core Version:    0.7.0.1
 */