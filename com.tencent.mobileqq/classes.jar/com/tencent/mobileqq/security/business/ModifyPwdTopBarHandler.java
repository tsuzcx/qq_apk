package com.tencent.mobileqq.security.business;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.login.ModifyPwdDisplayInfo.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ModifyPwdTopBarHandler
  extends BusinessHandler
{
  public ModifyPwdTopBarHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
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
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
    paramToServiceMsg = "";
    boolean bool2;
    if (bool1)
    {
      ModifyPwdDisplayInfo.RspBody localRspBody = new ModifyPwdDisplayInfo.RspBody();
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (localRspBody.uint32_display_flag.has())
          {
            i = localRspBody.uint32_display_flag.get();
            if (i == 1)
            {
              bool2 = true;
              break label130;
            }
          }
          bool2 = false;
          try
          {
            label130:
            if (localRspBody.str_hori_bar_content.has()) {
              paramFromServiceMsg = localRspBody.str_hori_bar_content.get();
            } else {
              paramFromServiceMsg = "";
            }
            paramObject = paramToServiceMsg;
            Object localObject = paramToServiceMsg;
            try
            {
              if (localRspBody.str_bar_url.has())
              {
                localObject = paramToServiceMsg;
                paramObject = localRspBody.str_bar_url.get();
              }
              localObject = paramObject;
              if (localRspBody.uint32_next_access_time.has())
              {
                localObject = paramObject;
                i = localRspBody.uint32_next_access_time.get();
              }
              else
              {
                i = 0;
              }
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = paramObject;
            }
            catch (Exception paramObject)
            {
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              break label270;
            }
            QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay error: uint32_result != 0");
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = "";
          }
        }
        else
        {
          paramFromServiceMsg = "";
          bool1 = false;
          bool2 = false;
          i = 0;
        }
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = "";
        bool2 = false;
        label270:
        QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay exception: ", paramObject);
        bool1 = false;
        break label291;
      }
    }
    else
    {
      paramFromServiceMsg = "";
      bool2 = false;
    }
    label291:
    int i = 0;
    paramObject = new StringBuilder();
    paramObject.append("handleFetchBarDisplay, isSuccess: ");
    paramObject.append(bool1);
    paramObject.append(" displayFlag: ");
    paramObject.append(bool2);
    paramObject.append(" horiBarContent: ");
    paramObject.append(paramToServiceMsg);
    paramObject.append(" barUrl: ");
    paramObject.append(paramFromServiceMsg);
    paramObject.append(" nextAccessTime: ");
    paramObject.append(i);
    QLog.d("ModifyPwdTopBarHandler", 1, paramObject.toString());
    notifyUI(1, bool1, new Object[] { Long.valueOf(l), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i) });
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchDisplayInfo pbMark: ");
    localStringBuilder.append(paramLong);
    QLog.d("ModifyPwdTopBarHandler", 1, localStringBuilder.toString());
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ModifyPwdTopBarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive: ");
    localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
    QLog.d("ModifyPwdTopBarHandler", 1, localStringBuilder.toString());
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("OidbSvc.0xecc_0".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.security.business.ModifyPwdTopBarHandler
 * JD-Core Version:    0.7.0.1
 */