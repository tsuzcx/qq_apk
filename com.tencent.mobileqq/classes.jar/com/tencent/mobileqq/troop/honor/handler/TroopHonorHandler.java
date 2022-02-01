package com.tencent.mobileqq.troop.honor.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.ReqBody;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.RspBody;

public class TroopHonorHandler
  extends TroopBaseHandler
{
  private static final String jdField_a_of_type_JavaLangString = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopListHandlerName();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  protected TroopHonorHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      oidb_0xdc9.RspBody localRspBody = new oidb_0xdc9.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      int i;
      if (j == 0)
      {
        if (localRspBody.honor_list.has()) {
          paramFromServiceMsg = localRspBody.honor_list.get();
        } else {
          paramFromServiceMsg = null;
        }
        long l;
        if (localRspBody.cache_ts.has()) {
          l = localRspBody.cache_ts.get();
        } else {
          l = 0L;
        }
        ((ITroopHonorService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopHonorService.class, "")).updateHostHonorList(paramFromServiceMsg, paramToServiceMsg.extraData.getBoolean("not_update_honors", false));
        paramToServiceMsg = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
        paramToServiceMsg.edit().putLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", l).apply();
        paramToServiceMsg.edit().putLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", NetConnInfoCenter.getServerTime()).apply();
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (i != 0) {
        ((ITroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorHandler", 2, String.format("handleGetHostTroopHonorList, result = %s", new Object[] { Integer.valueOf(j) }));
      }
      return;
    }
    QLog.d("TroopHonorHandler", 2, "handleGetHostTroopHonorList, data error");
  }
  
  protected String a()
  {
    return "TroopHonorHandler";
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", 0L);
    long l2 = ((SharedPreferences)localObject1).getLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", 0L);
    l2 = NetConnInfoCenter.getServerTime() - l2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonorHandler", 2, String.format("getHostTroopHonorList, requestInterval: %s, limitInterval: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
    }
    if ((l2 < l1) && (!paramBoolean))
    {
      QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, requestInterval < limitInterval");
      return;
    }
    localObject1 = new ArrayList();
    Object localObject2 = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
        try
        {
          ((List)localObject1).add(Long.valueOf(localTroopInfo.troopuin));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, convert uin exception", localNumberFormatException);
        }
      }
    }
    if (((List)localObject1).isEmpty())
    {
      QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, troopUinList is empty!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonorHandler", 2, String.format("getHostTroopHonorList, troopUinList size = %s", new Object[] { Integer.valueOf(((List)localObject1).size()) }));
    }
    localObject2 = new oidb_0xdc9.ReqBody();
    ((oidb_0xdc9.ReqBody)localObject2).group_id.set((List)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0xdc9", 3529, 0, ((oidb_0xdc9.ReqBody)localObject2).toByteArray());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("not_update_honors", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putAll((Bundle)localObject2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorHandler", 2, "REQ_TAG doesn't match.");
      }
      return;
    }
    if ("OidbSvc.0xdc9".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler
 * JD-Core Version:    0.7.0.1
 */