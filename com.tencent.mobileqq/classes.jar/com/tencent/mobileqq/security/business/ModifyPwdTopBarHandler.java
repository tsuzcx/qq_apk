package com.tencent.mobileqq.security.business;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tencent.im.login.ModifyPwdDisplayInfo.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ModifyPwdTopBarHandler
  extends BusinessHandler
{
  public ModifyPwdTopBarHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  @NotNull
  private ToServiceMsg a(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3788);
    localOIDBSSOPkg.uint32_service_type.set(0);
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0xecc_0");
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putLong("mark_extra_tag", paramLong);
    localToServiceMsg.setTimeout(30000L);
    return localToServiceMsg;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    long l;
    String str;
    int i;
    ModifyPwdDisplayInfo.RspBody localRspBody;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      paramFromServiceMsg = "";
      str = "";
      i = 0;
      if (bool1) {
        localRspBody = new ModifyPwdDisplayInfo.RspBody();
      }
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label379;
        }
        localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!localRspBody.uint32_display_flag.has()) {
          break label466;
        }
        j = localRspBody.uint32_display_flag.get();
        if (j != 1) {
          break label373;
        }
        bool2 = true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          int j;
          label125:
          Object localObject;
          label247:
          bool2 = false;
          paramToServiceMsg = "";
          bool1 = false;
          QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay exception: ", paramObject);
          continue;
          bool2 = false;
        }
      }
      paramToServiceMsg = paramFromServiceMsg;
      localObject = str;
      paramObject = paramFromServiceMsg;
      try
      {
        if (localRspBody.str_hori_bar_content.has())
        {
          localObject = str;
          paramObject = paramFromServiceMsg;
          paramToServiceMsg = localRspBody.str_hori_bar_content.get();
        }
        paramFromServiceMsg = str;
        localObject = str;
        paramObject = paramToServiceMsg;
        if (localRspBody.str_bar_url.has())
        {
          localObject = str;
          paramObject = paramToServiceMsg;
          paramFromServiceMsg = localRspBody.str_bar_url.get();
        }
        localObject = paramFromServiceMsg;
        paramObject = paramToServiceMsg;
        if (!localRspBody.uint32_next_access_time.has()) {
          break label442;
        }
        localObject = paramFromServiceMsg;
        paramObject = paramToServiceMsg;
        j = localRspBody.uint32_next_access_time.get();
        i = j;
        paramObject = paramFromServiceMsg;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg = (ToServiceMsg)localObject;
          localObject = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          paramObject = localObject;
          continue;
          boolean bool3 = bool1;
          i = 0;
          paramObject = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          bool1 = bool2;
          bool2 = bool3;
        }
      }
      bool3 = bool2;
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      QLog.d("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay, isSuccess: " + bool1 + " displayFlag: " + bool2 + " horiBarContent: " + paramFromServiceMsg + " barUrl: " + paramToServiceMsg + " nextAccessTime: " + i);
      notifyUI(1, bool1, new Object[] { Long.valueOf(l), Boolean.valueOf(bool2), paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i) });
      return;
      bool1 = false;
      break;
      label373:
      bool2 = false;
      break label125;
      label379:
      QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay error: uint32_result != 0");
      paramFromServiceMsg = "";
      bool2 = false;
      i = 0;
      paramToServiceMsg = "";
      bool1 = false;
      break label247;
      label442:
      label466:
      bool2 = false;
      paramToServiceMsg = "";
    }
  }
  
  public void a(long paramLong)
  {
    QLog.d("ModifyPwdTopBarHandler", 1, "fetchDisplayInfo pbMark: " + paramLong);
    sendPbReq(a(paramLong));
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xecc_0");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ModifyPwdTopBarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("ModifyPwdTopBarHandler", 1, "onReceive: " + paramFromServiceMsg.getServiceCmd());
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    while (!"OidbSvc.0xecc_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.security.business.ModifyPwdTopBarHandler
 * JD-Core Version:    0.7.0.1
 */