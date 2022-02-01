package com.tencent.mobileqq.kandian.repo.reward;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.IPUtils;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.SecurityInfo;

public class RIJCoinInfoModule
  extends ReadInJoyEngineModule
{
  private HashMap<Integer, RIJCoinInfoModule.RequestHandler> a;
  
  public RIJCoinInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    a();
  }
  
  private RIJCoinInfoModule.RequestHandler a(int paramInt)
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null) {
      return (RIJCoinInfoModule.RequestHandler)localHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  private void a()
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    a(new RIJCoinInfoModule.CoinQueryRequestHandler());
    a(new RIJCoinInfoModule.CoinPresentRequestHandler());
    a(new RIJCoinInfoModule.CoinRewardRequestHandler());
    a(new RIJCoinInfoModule.ContentCoinCheckRequestHandler());
    a(new RIJCoinInfoModule.ContentCoinNumQueryRequestHandler());
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.a().post(new RIJCoinInfoModule.1(this, paramInt1, paramString));
  }
  
  private void a(Bundle paramBundle, ToServiceMsg paramToServiceMsg)
  {
    if (paramBundle != null)
    {
      if (paramToServiceMsg == null) {
        return;
      }
      int i = paramBundle.getInt("request_scene_type", -1);
      paramToServiceMsg.getAttributes().put("request_scene_type", Integer.valueOf(i));
    }
  }
  
  private void a(RIJCoinInfoModule.RequestHandler paramRequestHandler)
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null)
    {
      if (paramRequestHandler == null) {
        return;
      }
      localHashMap.put(Integer.valueOf(paramRequestHandler.a()), paramRequestHandler);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xed4.RspBody localRspBody = new oidb_cmd0xed4.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("RequestType");
    paramObject = new StringBuilder();
    paramObject.append("handle0xed4CoinInfoResp, result:");
    paramObject.append(i);
    QLog.d("RIJCoinInfoModule", 1, paramObject.toString());
    int j = localRspBody.retcode.get();
    paramObject = localRspBody.retmsg.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", requestType=");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", retCode=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", retMsg=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("RIJCoinInfoModule", 2, new Object[] { "handle0xed4CoinInfoResp result = ", ((StringBuilder)localObject).toString() });
    }
    Object localObject = a(paramFromServiceMsg.intValue());
    if (localObject == null)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("dispatch0xed4Resp() cant find requestHandler, requestType=");
      paramToServiceMsg.append(paramFromServiceMsg);
      QLog.e("RIJCoinInfoModule", 1, paramToServiceMsg.toString());
      return;
    }
    if (a(paramToServiceMsg))
    {
      a(j, i, paramObject);
      return;
    }
    ((RIJCoinInfoModule.RequestHandler)localObject).a(paramToServiceMsg, localRspBody, i, j, paramObject);
  }
  
  private void a(oidb_cmd0xed4.ReqBody paramReqBody)
  {
    Object localObject = new oidb_cmd0xed4.MetaData();
    ((oidb_cmd0xed4.MetaData)localObject).timestamp.set(NetConnInfoCenter.getServerTimeMillis() / 1000L);
    paramReqBody.meta.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xed4.SecurityInfo();
    ((oidb_cmd0xed4.SecurityInfo)localObject).nickname.set(this.mApp.getCurrentNickname());
    if (!TextUtils.isEmpty(DeviceInfoUtil.b())) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).device_id.set(DeviceInfoUtil.b());
    }
    String str = IPUtils.a(BaseApplicationImpl.getContext());
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).ip.set(str);
    }
    str = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).terminal_id.set(str);
    }
    ((oidb_cmd0xed4.SecurityInfo)localObject).os_type.set(2);
    ((oidb_cmd0xed4.SecurityInfo)localObject).app_version.set("8.7.0");
    paramReqBody.security_info.set((MessageMicro)localObject);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i = ((Integer)paramToServiceMsg.getAttributes().get("request_scene_type")).intValue();
      if (i == 6) {
        return true;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is3Click error! e=");
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("RIJCoinInfoModule", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params)
  {
    a(paramRequest0xed4Params, null);
  }
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params, Bundle paramBundle)
  {
    if (paramRequest0xed4Params == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo params == null");
      }
      return;
    }
    try
    {
      localObject1 = new oidb_cmd0xed4.ReqBody();
      Object localObject2 = a(paramRequest0xed4Params.jdField_a_of_type_Int);
      if (localObject2 == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("request0xed4CoinInfo cant find requestHandler, requestType=");
        paramBundle.append(paramRequest0xed4Params.jdField_a_of_type_Int);
        QLog.e("RIJCoinInfoModule", 1, paramBundle.toString());
        return;
      }
      a((oidb_cmd0xed4.ReqBody)localObject1);
      ((RIJCoinInfoModule.RequestHandler)localObject2).a(paramRequest0xed4Params, (oidb_cmd0xed4.ReqBody)localObject1);
      localObject1 = ((oidb_cmd0xed4.ReqBody)localObject1).toByteArray();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("request0xed4CoinInfo requestType:");
        ((StringBuilder)localObject2).append(paramRequest0xed4Params.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append(", toByteArray size=");
        ((StringBuilder)localObject2).append(localObject1.length);
        QLog.d("RIJCoinInfoModule", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xed4", 3796, 1, (byte[])localObject1);
      ((ToServiceMsg)localObject1).getAttributes().put("RequestType", Integer.valueOf(paramRequest0xed4Params.jdField_a_of_type_Int));
      if (!TextUtils.isEmpty(paramRequest0xed4Params.jdField_a_of_type_JavaLangString)) {
        ((ToServiceMsg)localObject1).getAttributes().put("RequestRowkey", paramRequest0xed4Params.jdField_a_of_type_JavaLangString);
      }
      a(paramBundle, (ToServiceMsg)localObject1);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Throwable paramBundle)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("request0xed4CoinInfo failed. type=");
        ((StringBuilder)localObject1).append(paramRequest0xed4Params.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", rowkey=");
        ((StringBuilder)localObject1).append(paramRequest0xed4Params.jdField_a_of_type_JavaLangString);
        QLog.e("RIJCoinInfoModule", 2, ((StringBuilder)localObject1).toString(), paramBundle);
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xed4")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reward.RIJCoinInfoModule
 * JD-Core Version:    0.7.0.1
 */