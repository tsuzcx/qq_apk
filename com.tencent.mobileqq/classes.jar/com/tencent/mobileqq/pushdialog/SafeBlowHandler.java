package com.tencent.mobileqq.pushdialog;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SafeBlowHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.pushdialog.SafeBlowHandler";
  
  protected SafeBlowHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiverOxefe called with: resultCode = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", req = ");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(", res = ");
      localStringBuilder.append(paramFromServiceMsg);
      QLog.d("SafeBlowHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("SafeBlowHandler", 1, "onReceiverOxefe throw e", paramFromServiceMsg);
      }
      if (paramToServiceMsg.uint32_service_type.get() == 4) {
        notifyUI(3838, true, Integer.valueOf(4));
      }
    }
    else
    {
      notifyUI(3838, false, Integer.valueOf(-1));
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendClickEvtPbReq() called: friendUin = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("SafeBlowHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xefe.ReqBody();
    ((oidb_cmd0xefe.ReqBody)localObject).friend_uin.set(paramLong);
    sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 4, ((oidb_cmd0xefe.ReqBody)localObject).toByteArray()));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SafeBlowObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (TextUtils.equals("OidbSvc.0xefe", paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceive params: res = ");
    paramToServiceMsg.append(paramFromServiceMsg);
    paramToServiceMsg.append(", data = ");
    paramToServiceMsg.append(paramObject);
    QLog.e("SafeBlowHandler", 1, paramToServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.SafeBlowHandler
 * JD-Core Version:    0.7.0.1
 */