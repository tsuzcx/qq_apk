package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.config.TroopPushHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class TroopPushHandler
  extends TroopBaseHandler
  implements ITroopPushHandler
{
  public TroopPushHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopPushHandlerProcessorConfig.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.dwGroupFlagExt3 = paramInt;
      localITroopInfoService.saveTroopInfo(localTroopInfo);
      notifyUI(TroopPushObserver.d, true, new Object[] { String.valueOf(paramString), Long.valueOf(localTroopInfo.dwGroupFlagExt3) });
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPushHandler", 2, String.format("handlePassiveExitTroop, troopUin: %s, msgType: %s", new Object[] { paramString, Integer.valueOf(paramInt1) }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString, true);
    if (localTroopInfo == null)
    {
      QLog.e("TroopPushHandler", 1, "handlePassiveExitTroop, troopInfo == null");
      return;
    }
    if (localTroopInfo.isExited())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopPushHandler", 2, "handlePassiveExitTroop, exitReason is no default ");
      }
      return;
    }
    long l = localTroopInfo.dwCmdUinJoinTime;
    if (l < paramLong)
    {
      ((ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).deleteTroopMembers(paramString);
      localITroopInfoService.buildTroopUI();
      if (paramInt2 == 2)
      {
        localTroopInfo.exitTroopReason = 2;
        localITroopInfoService.saveTroopInfo(localTroopInfo);
      }
      else if (paramInt2 == 1)
      {
        localTroopInfo.exitTroopReason = 1;
        localITroopInfoService.saveTroopInfo(localTroopInfo);
      }
      TroopPushHandlerProcessorConfig.a(this.appRuntime, paramString, paramLong, paramInt1);
      notifyUI(TroopPushObserver.b, true, new Object[] { paramString, Integer.valueOf(paramInt2) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopPushHandler", 2, String.format("handlePassiveExit push joinTime: %s, msgTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTroopFlagExt4Changed troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", newTroopFlagExt4 = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopPushHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = ((ITroopInfoService)localObject).findTroopInfo(paramString);
    if (localTroopInfo == null) {
      return;
    }
    int i = localTroopInfo.groupFlagExt4;
    localTroopInfo.groupFlagExt4 = paramInt;
    ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
    notifyUI(TroopPushObserver.e, true, new Object[] { paramString, Integer.valueOf(i) });
    TroopPushHandlerProcessorConfig.a(this.appRuntime, paramString, paramInt, i);
  }
  
  public void c(String paramString, int paramInt)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString);
    if (localTroopInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopPushHandler", 1, "HWGroup classInfo changed");
      }
      long l = localTroopInfo.dwGroupClassExt;
      localTroopInfo.dwGroupClassExt = paramInt;
      localITroopInfoService.saveTroopInfo(localTroopInfo);
      notifyUI(TroopPushObserver.c, true, new Object[] { paramString, Long.valueOf(l) });
    }
  }
  
  protected String dv_()
  {
    return "TroopPushHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null) {
      this.allowCmdSet = new HashSet();
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopPushObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopPushHandler
 * JD-Core Version:    0.7.0.1
 */