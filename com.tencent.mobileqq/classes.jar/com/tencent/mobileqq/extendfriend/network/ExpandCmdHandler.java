package com.tencent.mobileqq.extendfriend.network;

import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ExpandCmdHandler
{
  public static final AtomicInteger a;
  private Map<Integer, ExpandCmdHandler.RequestObject> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public ExpandCmdHandler()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static ExpandCmdHandler a()
  {
    Object localObject = ExtendFriendManager.a();
    if (localObject == null) {
      return null;
    }
    localObject = (ExtendFriendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localObject == null) {
      return null;
    }
    return ((ExtendFriendManager)localObject).a();
  }
  
  private ExpandResponse a(ExpandCmdHandler.RequestObject paramRequestObject, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (paramRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a())
    {
      localObject = new ExpandResponse.ExpandOIDBResponse(paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg());
      paramRequestObject = (ExpandCmdHandler.RequestObject)localObject;
      if (paramFromServiceMsg.isSuccess())
      {
        ((ExpandResponse)localObject).a(paramFromServiceMsg.getWupBuffer());
        paramRequestObject = (ExpandCmdHandler.RequestObject)localObject;
      }
    }
    do
    {
      return paramRequestObject;
      localObject = new ExpandResponse.ExpandSSOResponse(paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg());
      paramRequestObject = (ExpandCmdHandler.RequestObject)localObject;
    } while (!paramFromServiceMsg.isSuccess());
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    paramRequestObject = new byte[i];
    PkgTools.copyData(paramRequestObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    ((ExpandResponse)localObject).a(paramRequestObject);
    return localObject;
  }
  
  private AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a(ExpandCmdHandler.RequestObject paramRequestObject, ExpandResponse paramExpandResponse)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cmd", paramRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a());
    localHashMap.put("msg", paramExpandResponse.a());
    localHashMap.put("result", paramExpandResponse.a() + "");
    if (paramRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo.a()) {}
    for (paramRequestObject = "0";; paramRequestObject = "1")
    {
      localHashMap.put("req_type", paramRequestObject);
      ExpandReportUtils.a("expand_quality#succ_rate#proto", true, localHashMap);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ExpandResponse paramExpandResponse)
  {
    int i = paramToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
    long l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("REQUEST_TIME");
    if (paramExpandResponse.a() != 0) {
      QLog.w("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", new Object[] { paramToServiceMsg.getServiceCmd(), Integer.valueOf(paramToServiceMsg.getAppSeq()), Long.valueOf(l), paramExpandResponse.b(), Integer.valueOf(i) }));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", new Object[] { paramToServiceMsg.getServiceCmd(), Integer.valueOf(paramToServiceMsg.getAppSeq()), Long.valueOf(l), paramExpandResponse.b(), Integer.valueOf(i) }));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(ExpandReqInfo paramExpandReqInfo, ExpandCmdHandler.ICallback paramICallback)
  {
    if (paramExpandReqInfo == null)
    {
      QLog.w("expand.cmd.ExpandCmdHandler", 1, "send request but request == null");
      return;
    }
    if (!NetworkUtils.a(QQStoryContext.a().a()))
    {
      paramICallback.a(paramExpandReqInfo, new ExpandResponse(900000000, "no network"));
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandCmdHandler.1(this, paramExpandReqInfo, paramICallback));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      QLog.e("expand.cmd.ExpandCmdHandler", 1, "request == null || response == null");
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
    ExpandCmdHandler.RequestObject localRequestObject = (ExpandCmdHandler.RequestObject)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localRequestObject == null)
    {
      QLog.w("expand.cmd.ExpandCmdHandler", 1, "can't find request cmd:" + paramToServiceMsg.getServiceCmd() + " request seq:" + i);
      return;
    }
    paramFromServiceMsg = a(localRequestObject, paramFromServiceMsg);
    a(paramToServiceMsg, paramFromServiceMsg);
    if (localRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler$ICallback != null) {
      localRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandCmdHandler$ICallback.a(localRequestObject.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExpandReqInfo, paramFromServiceMsg);
    }
    a(localRequestObject, paramFromServiceMsg);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, ExpandCmdHandler.ICallback paramICallback)
  {
    a(new ExpandReqInfo.Builder().a(false).a(paramString).a(paramArrayOfByte).a(paramInt).a(), paramICallback);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, ExpandCmdHandler.ICallback paramICallback)
  {
    a(new ExpandReqInfo.Builder().a(false).a(paramString).a(paramArrayOfByte).a(), paramICallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler
 * JD-Core Version:    0.7.0.1
 */