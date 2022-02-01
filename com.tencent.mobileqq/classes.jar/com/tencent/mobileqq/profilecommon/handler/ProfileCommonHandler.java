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
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = null;
    if (bool)
    {
      i = j;
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = j;
        j = paramObject.uint32_result.get();
        if (j == 0)
        {
          bool = true;
          if (!bool) {
            break label238;
          }
          i = j;
          if (!paramObject.bytes_bodybuffer.has()) {
            break label238;
          }
          i = j;
          oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
          i = j;
          localRspBody.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          i = j;
          if (localRspBody.rpt_msg_uin_data.size() <= 0) {
            break label238;
          }
          i = j;
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get(0);
          paramFromServiceMsg = paramObject;
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.e("ProfileCommonHandler", 1, "handleGetProfileInfo fail.", paramObject);
          bool = false;
          continue;
          label238:
          paramFromServiceMsg = null;
        }
      }
    }
    for (int i = j;; i = j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCommonHandler", 2, String.format("handleGetProfileInfo success=%s resultCode=%s udcUinData=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramFromServiceMsg }));
      }
      paramToServiceMsg = paramToServiceMsg.extraData;
      ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseGetProfileDetail(paramToServiceMsg, bool, paramFromServiceMsg);
      return;
      bool = false;
      break;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = paramFromServiceMsg.getResultCode();
    if (bool) {}
    for (;;)
    {
      try
      {
        int j = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        if (j != 0) {
          continue;
        }
        bool = true;
        i = j;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("ProfileCommonHandler", 1, "handleSetProfileInfo fail.", paramFromServiceMsg);
        bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCommonHandler", 2, String.format("handleSetProfileInfo success=%s resultCode=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      paramToServiceMsg = paramToServiceMsg.extraData;
      ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseSetProfileDetail(paramToServiceMsg, bool);
      return;
      bool = false;
    }
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ProfileCommonObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {}
    do
    {
      return;
      if ("OidbSvc.0x5eb_common".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x587_common".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler
 * JD-Core Version:    0.7.0.1
 */