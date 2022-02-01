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
  public static final String a = SafeBlowHandler.class.getName();
  
  protected SafeBlowHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("SafeBlowHandler", 2, "onReceiverOxefe called with: resultCode = " + i + ", req = " + paramToServiceMsg + ", res = " + paramFromServiceMsg);
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
        for (;;)
        {
          QLog.d("SafeBlowHandler", 1, "onReceiverOxefe throw e", paramFromServiceMsg);
        }
      }
      if (paramToServiceMsg.uint32_service_type.get() == 4) {
        notifyUI(3838, true, Integer.valueOf(4));
      }
      return;
    }
    notifyUI(3838, false, Integer.valueOf(-1));
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SafeBlowHandler", 2, "sendClickEvtPbReq() called: friendUin = " + paramLong);
    }
    oidb_cmd0xefe.ReqBody localReqBody = new oidb_cmd0xefe.ReqBody();
    localReqBody.friend_uin.set(paramLong);
    sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 4, localReqBody.toByteArray()));
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return SafeBlowObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      QLog.e("SafeBlowHandler", 1, "onReceive params: res = " + paramFromServiceMsg + ", data = " + paramObject);
    }
    while (!TextUtils.equals("OidbSvc.0xefe", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.SafeBlowHandler
 * JD-Core Version:    0.7.0.1
 */