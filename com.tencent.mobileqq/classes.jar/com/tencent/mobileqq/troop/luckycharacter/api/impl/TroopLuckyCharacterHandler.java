package com.tencent.mobileqq.troop.luckycharacter.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDBUtilApi;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xef1.oidb_0xef1.QueryGroupLuckyWordStatusRequest;
import tencent.im.oidb.cmd0xef1.oidb_0xef1.QueryGroupLuckyWordStatusResponse;

public class TroopLuckyCharacterHandler
  extends TroopBaseHandler
  implements ITroopLuckyCharacterHandler
{
  public TroopLuckyCharacterHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected String a()
  {
    return "TroopLuckyCharacterHandler";
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
      oidb_0xef1.QueryGroupLuckyWordStatusResponse localQueryGroupLuckyWordStatusResponse = new oidb_0xef1.QueryGroupLuckyWordStatusResponse();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localQueryGroupLuckyWordStatusResponse);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetTroopLuckyCharacterStatus result = ");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(",troopUin = ");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("TroopLuckyCharacterHandler", 2, paramFromServiceMsg.toString());
        }
        notifyUI(TroopLuckyCharacterObserver.a, false, new Object[] { paramToServiceMsg, "" });
        return;
      }
      paramFromServiceMsg = localQueryGroupLuckyWordStatusResponse.wording.get();
      ((IDBUtilApi)QRoute.api(IDBUtilApi.class)).setTroopLuckyCharacterStatus(this.appRuntime.getCurrentAccountUin(), paramToServiceMsg, paramFromServiceMsg);
      notifyUI(TroopLuckyCharacterObserver.a, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterHandler", 2, "handleGetTroopLuckyCharacterStatus resp == null || res == null");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopLuckyCharacterStatus troopUin =");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("TroopLuckyCharacterHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new oidb_0xef1.QueryGroupLuckyWordStatusRequest();
      ((oidb_0xef1.QueryGroupLuckyWordStatusRequest)localObject).group_code.set(l);
      localObject = makeOIDBPkg("OidbSvc.0xef1_2", 3825, 2, ((oidb_0xef1.QueryGroupLuckyWordStatusRequest)localObject).toByteArray(), 30000L);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("sendPbRequest. cmd=");
        paramString.append(((ToServiceMsg)localObject).getServiceCmd());
        QLog.d("TroopLuckyCharacterHandler", 2, paramString.toString());
      }
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xef1_2");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopLuckyCharacterObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopLuckyCharacterHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopLuckyCharacterHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xef1_2".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.api.impl.TroopLuckyCharacterHandler
 * JD-Core Version:    0.7.0.1
 */