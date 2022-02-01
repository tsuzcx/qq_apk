package com.tencent.mobileqq.qqexpand.network;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ExpandCmdHandler
{
  public static final AtomicInteger a = new AtomicInteger();
  private Map<Integer, ExpandCmdHandler.RequestObject> b = new ConcurrentHashMap();
  private final BaseQQAppInterface c;
  
  public ExpandCmdHandler(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.c = paramBaseQQAppInterface;
    this.b = new ConcurrentHashMap();
  }
  
  public static ExpandCmdHandler a(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (ExpandManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramBaseQQAppInterface == null) {
      return null;
    }
    return paramBaseQQAppInterface.p();
  }
  
  private ExpandResponse a(ExpandCmdHandler.RequestObject paramRequestObject, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (paramRequestObject.a.c())
    {
      paramRequestObject = new ExpandResponse.ExpandOIDBResponse(paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg());
      localObject = paramRequestObject;
      if (paramFromServiceMsg.isSuccess())
      {
        paramRequestObject.a(paramFromServiceMsg.getWupBuffer());
        return paramRequestObject;
      }
    }
    else
    {
      if (paramRequestObject.a.d()) {
        paramRequestObject = new ExpandResponse.ExpandDirectConnectSSOResponse(paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg());
      } else {
        paramRequestObject = new ExpandResponse.ExpandSSOResponse(paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg());
      }
      localObject = paramRequestObject;
      if (paramFromServiceMsg.isSuccess())
      {
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramRequestObject.a((byte[])localObject);
        localObject = paramRequestObject;
      }
    }
    return localObject;
  }
  
  private void a(ExpandCmdHandler.RequestObject paramRequestObject, ExpandResponse paramExpandResponse)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cmd", paramRequestObject.a.e());
    localHashMap.put("msg", paramExpandResponse.c());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramExpandResponse.b());
    localStringBuilder.append("");
    localHashMap.put("result", localStringBuilder.toString());
    if (paramRequestObject.a.c()) {
      paramRequestObject = "0";
    } else {
      paramRequestObject = "1";
    }
    localHashMap.put("req_type", paramRequestObject);
    ExpandReportUtils.a("expand_quality#succ_rate#proto", true, localHashMap);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ExpandResponse paramExpandResponse)
  {
    int i = paramToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
    long l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("REQUEST_TIME");
    if (paramExpandResponse.b() != 0)
    {
      QLog.w("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", new Object[] { paramToServiceMsg.getServiceCmd(), Integer.valueOf(paramToServiceMsg.getAppSeq()), Long.valueOf(l), paramExpandResponse.d(), Integer.valueOf(i) }));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", new Object[] { paramToServiceMsg.getServiceCmd(), Integer.valueOf(paramToServiceMsg.getAppSeq()), Long.valueOf(l), paramExpandResponse.d(), Integer.valueOf(i) }));
    }
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(ExpandReqInfo paramExpandReqInfo, IExpandCmdCallback paramIExpandCmdCallback)
  {
    if (paramExpandReqInfo == null)
    {
      QLog.w("expand.cmd.ExpandCmdHandler", 1, "send request but request == null");
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      paramIExpandCmdCallback.onProtocol(paramExpandReqInfo, new ExpandResponse(900000000, "no network"));
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandCmdHandler.1(this, paramExpandReqInfo, paramIExpandCmdCallback));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      int i = paramToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
      ExpandCmdHandler.RequestObject localRequestObject = (ExpandCmdHandler.RequestObject)this.b.get(Integer.valueOf(i));
      if (localRequestObject == null)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("can't find request cmd:");
        paramFromServiceMsg.append(paramToServiceMsg.getServiceCmd());
        paramFromServiceMsg.append(" request seq:");
        paramFromServiceMsg.append(i);
        QLog.w("expand.cmd.ExpandCmdHandler", 1, paramFromServiceMsg.toString());
        return;
      }
      paramFromServiceMsg = a(localRequestObject, paramFromServiceMsg);
      a(paramToServiceMsg, paramFromServiceMsg);
      if (localRequestObject.b != null) {
        localRequestObject.b.onProtocol(localRequestObject.a, paramFromServiceMsg);
      }
      a(localRequestObject, paramFromServiceMsg);
      return;
    }
    QLog.e("expand.cmd.ExpandCmdHandler", 1, "request == null || response == null");
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, IExpandCmdCallback paramIExpandCmdCallback)
  {
    a(new ExpandReqInfo.Builder().a(false).a(paramString).a(paramArrayOfByte).a(paramInt).a(), paramIExpandCmdCallback);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, IExpandCmdCallback paramIExpandCmdCallback)
  {
    a(new ExpandReqInfo.Builder().a(false).a(paramString).a(paramArrayOfByte).a(), paramIExpandCmdCallback);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, IExpandCmdCallback paramIExpandCmdCallback)
  {
    a(new ExpandReqInfo.Builder().a(false).b(true).a(paramString).a(paramArrayOfByte).a(), paramIExpandCmdCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler
 * JD-Core Version:    0.7.0.1
 */