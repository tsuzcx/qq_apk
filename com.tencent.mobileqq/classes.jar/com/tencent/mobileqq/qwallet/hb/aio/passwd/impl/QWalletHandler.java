package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.ReqBody;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.ReqInfo;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QWalletHandler
  extends BusinessHandler
{
  protected QWalletHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return null;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
    }
    if (paramToServiceMsg.uint32_result.get() == 0)
    {
      if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
        return null;
      }
      return paramToServiceMsg;
    }
    return null;
  }
  
  public void a(int paramInt, List<oidb_0x438.ReqInfo> paramList)
  {
    Object localObject = new oidb_0x438.ReqBody();
    ((oidb_0x438.ReqBody)localObject).stReqInfo.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1080);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(paramInt);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x438.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x438");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QWalletObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletHandler", 4, "onReceive");
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd=");
      localStringBuilder.append(str);
      QLog.i("QWalletHandler", 4, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data length =");
      localStringBuilder.append(((byte[])paramObject).length);
      QLog.i("QWalletHandler", 4, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (str.compareTo("OidbSvc.0x438") == 0)
    {
      paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramToServiceMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWalletHandler", 2, "onReceive: ssoPkg parse failed");
        }
        return;
      }
      paramFromServiceMsg = new oidb_0x438.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = paramFromServiceMsg.PasswdRedBag.get();
        if (paramFromServiceMsg != null)
        {
          notifyUI(paramToServiceMsg.uint32_service_type.get(), true, paramFromServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        notifyUI(paramToServiceMsg.uint32_service_type.get(), false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.QWalletHandler
 * JD-Core Version:    0.7.0.1
 */