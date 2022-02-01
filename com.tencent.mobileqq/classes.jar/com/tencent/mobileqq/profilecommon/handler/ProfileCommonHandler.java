package com.tencent.mobileqq.profilecommon.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.api.impl.ProfileCommonServiceImpl;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ProfileCommonHandler
  extends BusinessHandler
{
  protected ProfileCommonHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int k = paramFromServiceMsg.getResultCode();
    Object localObject = null;
    boolean bool1 = bool2;
    paramFromServiceMsg = localObject;
    int j = k;
    int i;
    if (bool2) {
      i = k;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = k;
        k = paramObject.uint32_result.get();
        if (k != 0) {
          break label289;
        }
        bool2 = true;
        bool1 = bool2;
        paramFromServiceMsg = localObject;
        j = k;
        if (bool2)
        {
          i = k;
          bool1 = bool2;
          paramFromServiceMsg = localObject;
          j = k;
          if (paramObject.bytes_bodybuffer.has())
          {
            i = k;
            oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
            i = k;
            localRspBody.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
            i = k;
            bool1 = bool2;
            paramFromServiceMsg = localObject;
            j = k;
            if (localRspBody.rpt_msg_uin_data.size() > 0)
            {
              i = k;
              paramFromServiceMsg = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get(0);
              bool1 = bool2;
              j = k;
            }
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("ProfileCommonHandler", 1, "handleGetProfileInfo fail.", paramFromServiceMsg);
        bool1 = false;
        j = i;
        paramFromServiceMsg = localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCommonHandler", 2, String.format("handleGetProfileInfo success=%s resultCode=%s udcUinData=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j), paramFromServiceMsg }));
      }
      paramToServiceMsg = paramToServiceMsg.extraData;
      ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseGetProfileDetail(paramToServiceMsg, bool1, paramFromServiceMsg);
      return;
      label289:
      bool2 = false;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int j = paramFromServiceMsg.getResultCode();
    boolean bool1 = bool2;
    int i = j;
    if (bool2) {
      try
      {
        int k = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        i = k;
        if (k == 0)
        {
          bool1 = true;
          i = k;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("ProfileCommonHandler", 1, "handleSetProfileInfo fail.", paramFromServiceMsg);
        i = j;
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonHandler", 2, String.format("handleSetProfileInfo success=%s resultCode=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) }));
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseSetProfileDetail(paramToServiceMsg, bool1);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x5eb_common");
      this.allowCmdSet.add("OidbSvc.0x587_common");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ProfileCommonObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      return;
    }
    if ("OidbSvc.0x5eb_common".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x587_common".equals(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler
 * JD-Core Version:    0.7.0.1
 */