package com.tencent.mobileqq.troop.honor.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
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
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = TroopListHandler.class.getName();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  protected TroopHonorHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      QLog.d("TroopHonor.handler", 2, "handleGetHostTroopHonorList, data error");
      return;
    }
    oidb_0xdc9.RspBody localRspBody = new oidb_0xdc9.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    label64:
    long l;
    if (j == 0) {
      if (localRspBody.honor_list.has())
      {
        paramFromServiceMsg = localRspBody.honor_list.get();
        if (!localRspBody.cache_ts.has()) {
          break label246;
        }
        l = localRspBody.cache_ts.get();
        label86:
        ((ITroopHonorService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopHonorService.class, "")).updateHostHonorList(paramFromServiceMsg, paramToServiceMsg.extraData.getBoolean("not_update_honors", false));
        paramToServiceMsg = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
        paramToServiceMsg.edit().putLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", l).apply();
        paramToServiceMsg.edit().putLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", NetConnInfoCenter.getServerTime()).apply();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((TroopListHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString)).notifyUI(TroopNotificationConstants.aC, true, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonor.handler", 2, String.format("handleGetHostTroopHonorList, result = %s", new Object[] { Integer.valueOf(j) }));
      return;
      paramFromServiceMsg = null;
      break label64;
      label246:
      l = 0L;
      break label86;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", 0L);
    long l2 = ((SharedPreferences)localObject1).getLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", 0L);
    l2 = NetConnInfoCenter.getServerTime() - l2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.handler", 2, String.format("getHostTroopHonorList, requestInterval: %s, limitInterval: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
    }
    if ((l2 < l1) && (!paramBoolean))
    {
      QLog.d("TroopHonor.handler", 1, "getHostTroopHonorList, requestInterval < limitInterval");
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
          QLog.d("TroopHonor.handler", 1, "getHostTroopHonorList, convert uin exception", localNumberFormatException);
        }
      }
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      QLog.d("TroopHonor.handler", 1, "getHostTroopHonorList, troopUinList is empty!");
      return;
    }
    if (QLog.isColorLevel()) {
      if (localObject1 != null) {
        break label340;
      }
    }
    label340:
    for (int i = 0;; i = ((List)localObject1).size())
    {
      QLog.d("TroopHonor.handler", 2, String.format("getHostTroopHonorList, troopUinList size = %s", new Object[] { Integer.valueOf(i) }));
      localObject2 = new oidb_0xdc9.ReqBody();
      ((oidb_0xdc9.ReqBody)localObject2).group_id.set((List)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xdc9", 3529, 0, ((oidb_0xdc9.ReqBody)localObject2).toByteArray());
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("not_update_honors", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putAll((Bundle)localObject2);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    while (!"OidbSvc.0xdc9".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler
 * JD-Core Version:    0.7.0.1
 */