package com.tencent.mobileqq.troop.trooptodo.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.trooptodo.TroopToDoObserver;
import com.tencent.mobileqq.troop.trooptodo.api.ITroopToDoRequestHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xf90.oidb_0xf90.ReqBody;
import tencent.im.oidb.cmd0xf90.oidb_0xf90.RspBody;
import tencent.im.oidb.cmd0xf90.oidb_0xf90.TodoInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopToDoHandler
  extends TroopBaseHandler
  implements ITroopToDoRequestHandler
{
  public TroopToDoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendToDoStatusRequest —— serviceType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", requestCmd:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", groupCode:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", seq:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(", random:");
    ((StringBuilder)localObject).append(paramLong3);
    QLog.i("TroopToDoHandler", 4, ((StringBuilder)localObject).toString());
    oidb_0xf90.ReqBody localReqBody = new oidb_0xf90.ReqBody();
    localReqBody.group_code.set(paramLong1);
    localReqBody.seq.set(paramLong2);
    localReqBody.random.set(paramLong3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3984);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString = createToServiceMsg(paramString);
    paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramString.setTimeout(30000L);
    sendPbReq(paramString);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, int paramInt)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramObject.printStackTrace();
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handle 0xf90 Response | oidb_sso parseFrom byte ");
          paramToServiceMsg.append(paramObject.toString());
          QLog.i("TroopToDoHandler", 2, paramToServiceMsg.toString());
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (i == 0)
      {
        if (paramInt == 1)
        {
          if (!a(paramInt, paramToServiceMsg)) {}
        }
        else {
          notifyUI(paramInt, true, Integer.valueOf(i));
        }
      }
      else
      {
        notifyUI(paramInt, true, Integer.valueOf(i));
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("serviceType: ");
        paramToServiceMsg.append(paramInt);
        paramToServiceMsg.append(", oidb result: ");
        paramToServiceMsg.append(i);
        QLog.i("TroopToDoHandler", 4, paramToServiceMsg.toString());
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("serviceType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", FromServiceMsg: ");
      if (paramFromServiceMsg != null) {
        paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
      } else {
        paramToServiceMsg = null;
      }
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(", data:");
      localStringBuilder.append(paramObject);
      QLog.i("TroopToDoHandler", 4, localStringBuilder.toString());
    }
    notifyUI(paramInt, false, null);
  }
  
  private boolean a(int paramInt, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if ((paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      Object localObject = new oidb_0xf90.RspBody();
      try
      {
        ((oidb_0xf90.RspBody)localObject).mergeFrom(paramOIDBSSOPkg);
        notifyUI(paramInt, true, (oidb_0xf90.TodoInfo)((oidb_0xf90.RspBody)localObject).info.get());
        return true;
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseData : InvalidProtocolBufferMicroException :");
        ((StringBuilder)localObject).append(paramOIDBSSOPkg.toString());
        QLog.i("TroopToDoHandler", 4, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramLong1, paramLong2, paramLong3, 2, "OidbSvcTrpcTcp.0xf90_2");
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramLong1, paramLong2, paramLong3, 3, "OidbSvcTrpcTcp.0xf90_3");
  }
  
  public void c(long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramLong1, paramLong2, paramLong3, 1, "OidbSvcTrpcTcp.0xf90_1");
  }
  
  public void d(long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramLong1, paramLong2, paramLong3, 4, "OidbSvcTrpcTcp.0xf90_4");
  }
  
  protected String dv_()
  {
    return "TroopToDoHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_1");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_2");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_4");
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf90_3");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopToDoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvcTrpcTcp.0xf90_1".equals(paramToServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, 1);
      return;
    }
    if ("OidbSvcTrpcTcp.0xf90_2".equals(paramToServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, 2);
      return;
    }
    if ("OidbSvcTrpcTcp.0xf90_3".equals(paramToServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, 3);
      return;
    }
    if ("OidbSvcTrpcTcp.0xf90_4".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler
 * JD-Core Version:    0.7.0.1
 */