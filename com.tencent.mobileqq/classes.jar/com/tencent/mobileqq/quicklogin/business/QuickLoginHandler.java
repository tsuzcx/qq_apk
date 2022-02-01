package com.tencent.mobileqq.quicklogin.business;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QuickLoginHandler
  extends BusinessHandler
{
  public QuickLoginHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
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
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    long l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
    if (bool) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.uint32_result.get();
        if (i == 0) {
          bool = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSetPCVerify exception: ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("QuickLoginHandler", 1, paramFromServiceMsg.toString());
        bool = false;
      }
    }
    notifyUI(1, bool, new Object[] { Long.valueOf(l) });
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("setPCVerify switchOn: ");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(" pbMark: ");
      localStringBuilder1.append(paramLong);
      QLog.d("QuickLoginHandler", 1, localStringBuilder1.toString());
      sendPbReq(a((byte)paramInt, paramLong));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("setPCVerify exception: ");
      localStringBuilder2.append(localException.getMessage());
      QLog.e("QuickLoginHandler", 1, localStringBuilder2.toString());
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QuickLoginObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("QuickLoginHandler", 1, "onReceive");
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("OidbSvc.0x484_15".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.quicklogin.business.QuickLoginHandler
 * JD-Core Version:    0.7.0.1
 */