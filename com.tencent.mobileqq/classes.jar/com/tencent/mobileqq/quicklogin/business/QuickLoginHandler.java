package com.tencent.mobileqq.quicklogin.business;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QuickLoginHandler
  extends BusinessHandler
{
  public QuickLoginHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  @NotNull
  private ToServiceMsg a(byte paramByte, long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1156);
    localOIDBSSOPkg.uint32_service_type.set(15);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).put(paramByte);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x484_15");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("mark_extra_tag", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    return localObject;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("QuickLoginHandler", 1, "handleSetPCVerify");
    boolean bool2;
    long l;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      bool1 = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.uint32_result.get();
        if (i != 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("QuickLoginHandler", 1, "handleSetPCVerify exception: " + paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
      }
      notifyUI(1, bool1, new Object[] { Long.valueOf(l) });
      return;
      bool2 = false;
      break;
      bool1 = false;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      QLog.d("QuickLoginHandler", 1, "setPCVerify switchOn: " + paramInt + " pbMark: " + paramLong);
      sendPbReq(a((byte)paramInt, paramLong));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QuickLoginHandler", 1, "setPCVerify exception: " + localException.getMessage());
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x484_15");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return QuickLoginObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("QuickLoginHandler", 1, "onReceive");
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    while (!"OidbSvc.0x484_15".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.business.QuickLoginHandler
 * JD-Core Version:    0.7.0.1
 */