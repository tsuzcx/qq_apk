package com.tencent.mobileqq.kandian.repo.share;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.ReqBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.RspBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoReqInfo;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoRspInfo;

public class KingShareReadInjoyModule
  extends ReadInJoyEngineModule
{
  public KingShareReadInjoyModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "construct!");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "handle 0xa70 get king moment info");
    }
    paramToServiceMsg = new oidb_cmd0xa70.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new KingMomentInfo();
    paramFromServiceMsg.a = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_business_id.get();
    paramFromServiceMsg.b = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name.get().toStringUtf8();
    paramFromServiceMsg.c = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_url.get().toStringUtf8();
    paramFromServiceMsg.d = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name_prefix.get().toStringUtf8();
    paramFromServiceMsg.e = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_title.get().toStringUtf8();
    paramFromServiceMsg.f = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_desc.get().toStringUtf8();
    paramFromServiceMsg.g = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_uuid.get().toStringUtf8();
    paramFromServiceMsg.h = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_video_url.get().toStringUtf8();
    paramFromServiceMsg.i = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_pic_url.get().toStringUtf8();
    paramFromServiceMsg.k = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_width.get();
    paramFromServiceMsg.j = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_height.get();
    paramFromServiceMsg.n = paramFromServiceMsg.k;
    paramFromServiceMsg.m = paramFromServiceMsg.j;
    paramFromServiceMsg.l = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint64_duration.get();
    this.mMainThreadHandler.post(new KingShareReadInjoyModule.1(this, i, paramFromServiceMsg));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get king moment ,url =");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("KingShareReadInjoyModule", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString2);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      label52:
      break label52;
    }
    paramString2 = new oidb_cmd0xa70.ReqBody();
    paramString2.uint64_uin.set(l1);
    Object localObject = new oidb_cmd0xa70.VideoReqInfo();
    ((oidb_cmd0xa70.VideoReqInfo)localObject).bytes_wangzhe_share_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString2.msg_video_req_info.set((MessageMicro)localObject);
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xa70", 2672, 0, paramString2.toByteArray()));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa70")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.share.KingShareReadInjoyModule
 * JD-Core Version:    0.7.0.1
 */