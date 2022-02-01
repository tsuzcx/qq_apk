package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
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
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.AccountInfo;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.ClientInfo;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.LiveStatus;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.ReqBody;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.RspBody;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoItem;
import tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.UserInfoOption;

public class RIJLiveStatusModule
  extends ReadInJoyEngineModule
{
  private List<RIJLiveStatusModule.LiveStatusCallback> a;
  
  public RIJLiveStatusModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ToServiceMsg a(List<Long> paramList)
  {
    oidb_cmd0xee9.ReqBody localReqBody = new oidb_cmd0xee9.ReqBody();
    Object localObject = new oidb_cmd0xee9.ClientInfo();
    ((oidb_cmd0xee9.ClientInfo)localObject).uint32_req_client_type.set(1);
    ((oidb_cmd0xee9.ClientInfo)localObject).str_version.set(AppSetting.f());
    localReqBody.client_info.set((MessageMicro)localObject);
    localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      oidb_cmd0xee9.AccountInfo localAccountInfo = new oidb_cmd0xee9.AccountInfo();
      localAccountInfo.uint64_uin.set(localLong.longValue());
      ((List)localObject).add(localAccountInfo);
    }
    localReqBody.rpt_acount_info.set((List)localObject);
    paramList = new oidb_cmd0xee9.UserInfoOption();
    paramList.uint32_live_status.set(1);
    localReqBody.msg_user_option.set(paramList);
    return ReadInJoyOidbHelper.a("OidbSvc.0xee9", 3817, 2, localReqBody.toByteArray());
  }
  
  private void a(int paramInt, List<RIJLiveStatusModule.UserInfoItem> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RIJLiveStatusModule.LiveStatusCallback)((Iterator)localObject).next()).a(paramInt, paramList);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xee9.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      a(i, null);
      return;
    }
    paramFromServiceMsg = RIJPBFieldUtils.a(paramToServiceMsg.rpt_msg_user_info);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
    {
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        Object localObject = (oidb_cmd0xee9.UserInfoItem)paramFromServiceMsg.next();
        oidb_cmd0xee9.LiveStatus localLiveStatus = (oidb_cmd0xee9.LiveStatus)PBFieldUtils.a(((oidb_cmd0xee9.UserInfoItem)localObject).msg_live_status, null);
        paramObject = new RIJLiveStatusModule.UserInfoItem();
        paramObject.jdField_a_of_type_Long = RIJPBFieldUtils.a(((oidb_cmd0xee9.UserInfoItem)localObject).uint64_uin, 0L);
        paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus = new LiveStatus();
        if (localLiveStatus != null)
        {
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_a_of_type_Int = RIJPBFieldUtils.a(localLiveStatus.uint32_liveing);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_a_of_type_Long = RIJPBFieldUtils.a(localLiveStatus.uint64_live_time, 0L);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_b_of_type_Int = RIJPBFieldUtils.a(localLiveStatus.uint32_source, 0);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(localLiveStatus.str_account, null);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(localLiveStatus.str_roomid, null);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.c = RIJPBFieldUtils.a(localLiveStatus.rowkey, null);
          paramObject.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.d = RIJPBFieldUtils.a(localLiveStatus.str_url, null);
        }
        paramToServiceMsg.add(paramObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleUGCAccountCreateResponsePkg: userInfoItem=");
          ((StringBuilder)localObject).append(paramObject);
          QLog.d("RIJLiveStatusModule", 2, ((StringBuilder)localObject).toString());
        }
      }
      a(i, paramToServiceMsg);
      return;
    }
    a(i, null);
  }
  
  public void a(RIJLiveStatusModule.LiveStatusCallback paramLiveStatusCallback)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramLiveStatusCallback);
  }
  
  public void a(List<Long> paramList)
  {
    sendPbReq(a(paramList));
  }
  
  public void b(RIJLiveStatusModule.LiveStatusCallback paramLiveStatusCallback)
  {
    List localList = this.a;
    if (localList != null) {
      localList.remove(paramLiveStatusCallback);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xee9")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule
 * JD-Core Version:    0.7.0.1
 */