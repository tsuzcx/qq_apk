package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x6e4.oidb_cmd0x6e4.RspBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.ReqBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.RspBody;

public class InterestLabelInfoModule
  extends ReadInJoyEngineModule
{
  private HashMap<Integer, InterestLabelInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<InterestLabelInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public InterestLabelInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x6e5.RspBody localRspBody = new oidb_cmd0x6e5.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramObject = null;
    boolean bool1;
    if (i == 0)
    {
      boolean bool2 = true;
      if (localRspBody.uint64_uin.has()) {
        localRspBody.uint64_uin.get();
      }
      if ((localRspBody.rpt_uint32_default_interest_label_id_list.has()) && (localRspBody.rpt_uint32_default_interest_label_id_list.get() != null)) {
        paramFromServiceMsg = localRspBody.rpt_uint32_default_interest_label_id_list.get();
      } else {
        paramFromServiceMsg = null;
      }
      bool1 = bool2;
      paramToServiceMsg = paramObject;
      if (localRspBody.rpt_interest_label_list.has())
      {
        bool1 = bool2;
        paramToServiceMsg = paramObject;
        if (localRspBody.rpt_interest_label_list.get() != null)
        {
          paramToServiceMsg = ReadInJoyMSFHandlerUtils.a(localRspBody.rpt_interest_label_list.get(), paramFromServiceMsg);
          bool1 = bool2;
        }
      }
    }
    else
    {
      paramToServiceMsg = ReadInJoyMSFHandlerUtils.a(null, null);
      bool1 = false;
    }
    a(bool1, paramToServiceMsg);
  }
  
  public void a()
  {
    this.mExecutorService.execute(new InterestLabelInfoModule.1(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    oidb_cmd0x6e5.ReqBody localReqBody = new oidb_cmd0x6e5.ReqBody();
    long l = Long.parseLong(RIJQQAppInterfaceUtil.a());
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_req_all_interest_label_list.set(paramInt1);
    localReqBody.uint32_req_default_interest_label_id_list.set(paramInt2);
    localReqBody.uint32_req_last_interest_label_id_list.set(paramInt3);
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0x6e5", 1765, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x6e4.RspBody());
  }
  
  public void a(List<InterestLabelInfo> paramList)
  {
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new InterestLabelInfoModule.4(this, paramList));
    }
  }
  
  public void a(boolean paramBoolean, List<InterestLabelInfo> paramList)
  {
    if (paramList != null) {
      this.mMainThreadHandler.post(new InterestLabelInfoModule.3(this, paramList));
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e5"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e4")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.InterestLabelInfoModule
 * JD-Core Version:    0.7.0.1
 */