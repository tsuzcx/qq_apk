package com.tencent.mobileqq.intervideo.now.dynamic.channelImpl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NowChannerHandlerV2
  extends BusinessHandler
{
  private Map<Integer, CommonCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public NowChannerHandlerV2(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      CommonCallback localCommonCallback = (CommonCallback)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("BUFFER", (byte[])paramObject);
      int i = 0;
      localBundle.putInt("BIZCODE", 0);
      localBundle.putString("ERRMSG", paramFromServiceMsg.getBusinessFailMsg());
      if (paramFromServiceMsg.getResultCode() != 1000) {
        i = -1;
      }
      localBundle.putInt("CHANNELCODE", i);
      localBundle.putString("serviceCmd", (String)paramToServiceMsg.getAttribute("serviceCmd"));
      if (localCommonCallback != null) {
        localCommonCallback.onResult(localBundle);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NowChannerHandler", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, CommonCallback<Bundle> paramCommonCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send serviceName = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" to SSO Service");
      QLog.w("NowChannerHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("serviceCmd", paramString2);
    Cmd2HandlerMapHelper.a(paramString2, new String[] { BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2 });
    paramString1 = new ToServiceMsg(paramString1, getCurrentAccountUin(), paramString2);
    paramString1.putWupBuffer(paramArrayOfByte);
    paramString1.setAttributes((HashMap)localObject);
    paramString1.setTimeout(15000L);
    sendPbReq(paramString1);
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramString1.setRequestSsoSeq(i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCommonCallback);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NowChannelObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive-----serviceName = ");
      localStringBuilder.append(paramToServiceMsg.getServiceName());
      localStringBuilder.append(", serviceCmd = ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.e("NowChannerHandler", 2, localStringBuilder.toString());
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2
 * JD-Core Version:    0.7.0.1
 */