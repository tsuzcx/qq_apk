package com.tencent.mobileqq.troop.onlinemember.handler;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.GPS;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.LBSInfo;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.RspBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import tencent.im.oidb.cmd0xd71.oidb_0xd71.ReqBody;
import tencent.im.oidb.cmd0xd71.oidb_0xd71.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopOnlineMemberHandler
  extends TroopBaseHandler
  implements ITroopOnlineMemberHandler
{
  protected Set<String> a;
  
  public TroopOnlineMemberHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(String paramString, SosoLbsInfo paramSosoLbsInfo)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    oidb_0xa2a.ReqBody localReqBody = new oidb_0xa2a.ReqBody();
    localReqBody.group_id.set(Long.valueOf(paramString).longValue());
    localReqBody.is_private.set(localITroopInfoService.isQidianPrivateTroop(paramString));
    if (paramSosoLbsInfo != null)
    {
      oidb_0xa2a.LBSInfo localLBSInfo = new oidb_0xa2a.LBSInfo();
      oidb_0xa2a.GPS localGPS = new oidb_0xa2a.GPS();
      if (paramSosoLbsInfo.mLocation != null)
      {
        localGPS.int64_longitude.set((paramSosoLbsInfo.mLocation.mLon84 * 1000000.0D));
        localGPS.int64_latitude.set((paramSosoLbsInfo.mLocation.mLat84 * 1000000.0D));
        localGPS.uint32_gps_type.set(1);
      }
      localLBSInfo.msg_gpsdw.set(localGPS);
      localReqBody.lbs_info.set(localLBSInfo);
    }
    paramSosoLbsInfo = localITroopInfoService.getTroopInfo(String.valueOf(paramString));
    if (paramSosoLbsInfo != null)
    {
      localReqBody.hok_appid.set((int)paramSosoLbsInfo.hlGuildAppid);
      localReqBody.hok_type.set((int)paramSosoLbsInfo.hlGuildSubType);
    }
    int j = ((ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "")).getRequestListServiceType(paramString);
    int i = j;
    if (j != 3)
    {
      i = j;
      if (j != 5) {
        i = 0;
      }
    }
    paramSosoLbsInfo = makeOIDBPkg("OidbSvc.0xa2a_0", 2602, i, localReqBody.toByteArray());
    paramSosoLbsInfo.extraData.putString("troopUin", paramString);
    sendPbReq(paramSosoLbsInfo);
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("sendGetDetailOnlineMemberListReq, troopUin=");
      paramSosoLbsInfo.append(paramString);
      paramSosoLbsInfo.append(" serviceType = ");
      paramSosoLbsInfo.append(i);
      QLog.i("TroopOnlineMemberHandler", 2, paramSosoLbsInfo.toString());
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = this.appRuntime;
    boolean bool = false;
    if (localObject == null)
    {
      QLog.i("TroopOnlineMemberHandler", 1, "setGameSwitchStatus, app is null");
      return false;
    }
    paramString = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(String.valueOf(paramString));
    if (paramString == null)
    {
      QLog.i("TroopOnlineMemberHandler", 1, "setGameSwitchStatus, troopInfo is null");
      return false;
    }
    if (paramInt1 != paramString.showGameSwitchStatus)
    {
      paramString.showGameSwitchStatus = paramInt1;
      bool = true;
    }
    if (paramInt2 != paramString.gameSwitchStatus)
    {
      paramString.gameSwitchStatus = paramInt2;
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGameSwitchStatus, showStatus=");
      ((StringBuilder)localObject).append(paramString.showGameSwitchStatus);
      ((StringBuilder)localObject).append(",status=");
      ((StringBuilder)localObject).append(paramString.gameSwitchStatus);
      QLog.i("TroopOnlineMemberHandler", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localOIDBSSOPkg, localRspBody);
    int j = localOIDBSSOPkg.uint32_service_type.get();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetAllOnlineMemberList, retCode=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" serviceType = ");
      paramFromServiceMsg.append(j);
      QLog.i("TroopOnlineMemberHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      paramObject = localRspBody.infos.get();
      if (j == 4)
      {
        notifyUI(TroopOnlineMemberObserver.h, true, new Object[] { paramToServiceMsg, paramObject });
        return;
      }
      paramFromServiceMsg = new ArrayList();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext()) {
        paramFromServiceMsg.add(String.valueOf(((oidb_0xa2a.UserInfo)paramObject.next()).uin.get()));
      }
      i = localRspBody.cache_time.get();
      if (this.appRuntime != null) {
        ((ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "")).updateAllOnlineList(paramToServiceMsg, paramFromServiceMsg, i);
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetAllOnlineMemberList, size=");
        paramObject.append(paramFromServiceMsg.size());
        paramObject.append(" cacheTime = ");
        paramObject.append(i);
        QLog.i("TroopOnlineMemberHandler", 2, paramObject.toString());
      }
      notifyUI(TroopOnlineMemberObserver.e, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetAllOnlineMemberList, retCode=");
    paramFromServiceMsg.append(i);
    QLog.i("TroopOnlineMemberHandler", 1, paramFromServiceMsg.toString());
    if (j == 4)
    {
      notifyUI(TroopOnlineMemberObserver.h, false, new Object[] { paramToServiceMsg, null });
      return;
    }
    notifyUI(TroopOnlineMemberObserver.e, false, new Object[] { paramToServiceMsg, null });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localOIDBSSOPkg, localRspBody);
    int j = localOIDBSSOPkg.uint32_service_type.get();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetAllGameOnlineMemberList, retCode=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" serviceType = ");
      paramFromServiceMsg.append(j);
      QLog.i("TroopOnlineMemberHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      paramObject = localRspBody.infos.get();
      paramFromServiceMsg = new ArrayList();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext()) {
        paramFromServiceMsg.add(String.valueOf(((oidb_0xa2a.UserInfo)paramObject.next()).uin.get()));
      }
      i = localRspBody.cache_time.get();
      if (this.appRuntime != null) {
        ((ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "")).updateAllGameOnlineList(paramToServiceMsg, paramFromServiceMsg, i);
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetAllGameOnlineMemberList, size=");
        paramObject.append(paramFromServiceMsg.size());
        paramObject.append(" cacheTime = ");
        paramObject.append(i);
        QLog.i("TroopOnlineMemberHandler", 2, paramObject.toString());
      }
      notifyUI(TroopOnlineMemberObserver.f, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetAllGameOnlineMemberList, retCode=");
    paramFromServiceMsg.append(i);
    QLog.i("TroopOnlineMemberHandler", 1, paramFromServiceMsg.toString());
    notifyUI(TroopOnlineMemberObserver.f, false, new Object[] { paramToServiceMsg, null });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_0xa2a.RspBody();
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (oidb_sso.OIDBSSOPkg)localObject2, (MessageMicro)localObject1);
    int j = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.get();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetDetailOnlineMemberList, retCode=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" serviceType = ");
      paramFromServiceMsg.append(j);
      QLog.i("TroopOnlineMemberHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      paramFromServiceMsg = ((oidb_0xa2a.RspBody)localObject1).online_info.get();
      if (((oidb_0xa2a.RspBody)localObject1).online_num.has()) {
        i = ((oidb_0xa2a.RspBody)localObject1).online_num.get();
      } else {
        i = 0;
      }
      localObject2 = ((oidb_0xa2a.RspBody)localObject1).infos.get();
      paramObject = new ArrayList();
      Object localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        oidb_0xa2a.UserInfo localUserInfo = (oidb_0xa2a.UserInfo)((Iterator)localObject3).next();
        TroopOnlineMemberItem localTroopOnlineMemberItem = new TroopOnlineMemberItem();
        localTroopOnlineMemberItem.b = String.valueOf(localUserInfo.uin.get());
        localTroopOnlineMemberItem.e = localUserInfo.nick.get();
        localTroopOnlineMemberItem.c = localUserInfo.tag.get();
        localTroopOnlineMemberItem.d = localUserInfo.tag_color.get();
        if (j == 3) {
          localTroopOnlineMemberItem.a = 2;
        } else {
          localTroopOnlineMemberItem.a = 1;
        }
        if (localUserInfo.score.has()) {
          localTroopOnlineMemberItem.f = localUserInfo.score.get();
        }
        paramObject.add(localTroopOnlineMemberItem);
      }
      j = ((oidb_0xa2a.RspBody)localObject1).cache_time.get();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleGetDetailOnlineMemberList, onlineTip=");
        ((StringBuilder)localObject3).append(paramFromServiceMsg);
        ((StringBuilder)localObject3).append(",size=");
        ((StringBuilder)localObject3).append(((List)localObject2).size());
        ((StringBuilder)localObject3).append(",cacheTime=");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(",onlineCount=");
        ((StringBuilder)localObject3).append(i);
        QLog.i("TroopOnlineMemberHandler", 2, ((StringBuilder)localObject3).toString());
      }
      if (this.appRuntime != null)
      {
        ((ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "")).updateDetailOnlineListCache(paramToServiceMsg, paramObject, j, paramFromServiceMsg, i);
        if ((((oidb_0xa2a.RspBody)localObject1).show_game_switch_status.has()) && (((oidb_0xa2a.RspBody)localObject1).game_switch_status.has())) {
          a(((oidb_0xa2a.RspBody)localObject1).show_game_switch_status.get(), ((oidb_0xa2a.RspBody)localObject1).game_switch_status.get(), paramToServiceMsg);
        }
        if (QLog.isColorLevel())
        {
          i = 0;
          while ((i < 3) && (i < paramObject.size()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleGetDetailOnlineMemberList, uin=");
            ((StringBuilder)localObject1).append(((TroopOnlineMemberItem)paramObject.get(i)).b);
            ((StringBuilder)localObject1).append(",name=");
            ((StringBuilder)localObject1).append(((TroopOnlineMemberItem)paramObject.get(i)).e);
            ((StringBuilder)localObject1).append(",tag=");
            ((StringBuilder)localObject1).append(((TroopOnlineMemberItem)paramObject.get(i)).c);
            QLog.i("TroopOnlineMemberHandler", 2, ((StringBuilder)localObject1).toString());
            i += 1;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, app == null");
      }
      notifyUI(TroopOnlineMemberObserver.b, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetDetailOnlineMemberList error, retCode=");
    paramFromServiceMsg.append(i);
    QLog.i("TroopOnlineMemberHandler", 1, paramFromServiceMsg.toString());
    notifyUI(TroopOnlineMemberObserver.b, false, new Object[] { paramToServiceMsg, "" });
  }
  
  public void a(String paramString)
  {
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, app == null");
      }
      return;
    }
    Object localObject = (ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "");
    if ((((ITroopOnlineMemberService)localObject).getRequestListServiceType(paramString) != 3) && (NetConnInfoCenter.getServerTime() < ((ITroopOnlineMemberService)localObject).getDetailNextReqTime(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getDetailOnlineMemberList, too frequency");
      }
      notifyUI(TroopOnlineMemberObserver.b, true, new Object[] { paramString, ((ITroopOnlineMemberService)localObject).getOnlineTip(paramString) });
      return;
    }
    try
    {
      SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("troop_handler");
      if (localSosoLbsInfo != null)
      {
        a(paramString, localSosoLbsInfo);
        return;
      }
      if (NetConnInfoCenter.getServerTimeMillis() - ((ITroopOnlineMemberService)localObject).getLastReqLocationTime() > 300000L)
      {
        ((ITroopOnlineMemberService)localObject).setLastReqLocationTime(NetConnInfoCenter.getServerTimeMillis());
        long l = SystemClock.uptimeMillis();
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new TroopOnlineMemberHandler.1(this, "troop_handler", l, paramString));
        return;
      }
      a(paramString, null);
      if (QLog.isColorLevel())
      {
        QLog.i("TroopOnlineMemberHandler", 2, "location too frequency");
        return;
      }
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDetailOnlineMemberList, e=");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.i("TroopOnlineMemberHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      localObject = new oidb_0xd71.ReqBody();
      ((oidb_0xd71.ReqBody)localObject).group_id.set(Long.valueOf(paramString).longValue());
      if (paramInt1 == 1) {
        ((oidb_0xd71.ReqBody)localObject).game_switch_status.set(paramInt2);
      }
      localObject = makeOIDBPkg("OidbSvc.0xd71", 3441, paramInt1, ((oidb_0xd71.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateGameOnlineSwitchStatus, troopUin=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" , serviceType = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" , status = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.i("TroopOnlineMemberHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateGameOnlineSwitchStatus, e=");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.i("TroopOnlineMemberHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetOnlineMemberTips, retCode=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("TroopOnlineMemberHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      int k = localRspBody.cache_time.get();
      paramFromServiceMsg = localRspBody.online_info.get();
      if (localRspBody.online_num.has()) {
        i = localRspBody.online_num.get();
      } else {
        i = 0;
      }
      int j;
      if (localRspBody.list_type.has()) {
        j = localRspBody.list_type.get();
      } else {
        j = -1;
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetOnlineMemberTips, cacheTime=");
        paramObject.append(k);
        paramObject.append(", onlineTip:");
        paramObject.append(paramFromServiceMsg);
        paramObject.append(" ,onlineCount:");
        paramObject.append(i);
        paramObject.append(" , listType:");
        paramObject.append(j);
        QLog.i("TroopOnlineMemberHandler", 2, paramObject.toString());
      }
      if (this.appRuntime != null)
      {
        paramObject = (ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "");
        if ((j == 5) && (i != paramObject.getOnlineCount(paramToServiceMsg)))
        {
          notifyUI(TroopOnlineMemberObserver.c, true, new Object[] { paramToServiceMsg, Boolean.valueOf(true) });
          paramObject.removeDetailOnlineList(paramToServiceMsg);
        }
        paramObject.updateAIOTipsCache(paramToServiceMsg, k, paramFromServiceMsg, j, i);
        if ((localRspBody.show_game_switch_status.has()) && (localRspBody.game_switch_status.has())) {
          a(localRspBody.show_game_switch_status.get(), localRspBody.game_switch_status.get(), paramToServiceMsg);
        }
      }
      notifyUI(TroopOnlineMemberObserver.g, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleGetOnlineMemberTips, retCode=");
    paramFromServiceMsg.append(i);
    QLog.i("TroopOnlineMemberHandler", 1, paramFromServiceMsg.toString());
    notifyUI(TroopOnlineMemberObserver.g, false, new Object[] { paramToServiceMsg, null });
  }
  
  public void b(String paramString)
  {
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getAllOnlineMemberList, app == null");
      }
      return;
    }
    ThreadManager.post(new TroopOnlineMemberHandler.2(this, paramString), 8, null, true);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xd71.RspBody localRspBody = new oidb_0xd71.RspBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localOIDBSSOPkg, localRspBody);
    int j = localOIDBSSOPkg.uint32_service_type.get();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGameOnlineSwitchStatus, retCode=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" serviceType = ");
      paramFromServiceMsg.append(j);
      QLog.i("TroopOnlineMemberHandler", 2, paramFromServiceMsg.toString());
    }
    if (i != 0)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGameOnlineSwitchStatus error, retCode:");
      paramFromServiceMsg.append(i);
      QLog.i("TroopOnlineMemberHandler", 1, paramFromServiceMsg.toString());
      notifyUI(TroopOnlineMemberObserver.d, false, new Object[] { paramToServiceMsg, Boolean.valueOf(false) });
      return;
    }
    boolean bool;
    if ((localRspBody.show_game_switch_status.has()) && (localRspBody.game_switch_status.has())) {
      bool = a(localRspBody.show_game_switch_status.get(), localRspBody.game_switch_status.get(), paramToServiceMsg);
    } else {
      bool = false;
    }
    notifyUI(TroopOnlineMemberObserver.d, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
  }
  
  public void c(String paramString)
  {
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getOnlineMemTips, app == null");
      }
      return;
    }
    Object localObject1 = (ITroopOnlineMemberService)this.appRuntime.getRuntimeService(ITroopOnlineMemberService.class, "");
    if (NetConnInfoCenter.getServerTime() < ((ITroopOnlineMemberService)localObject1).getAIOTipsNextReqTime(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getOnlineMemTips, too frequency");
      }
      notifyUI(TroopOnlineMemberObserver.g, true, new Object[] { paramString, ((ITroopOnlineMemberService)localObject1).getOnlineTip(paramString) });
      return;
    }
    try
    {
      Object localObject2 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      localObject1 = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject1).group_id.set(Long.valueOf(paramString).longValue());
      ((oidb_0xa2a.ReqBody)localObject1).is_private.set(((ITroopInfoService)localObject2).isQidianPrivateTroop(paramString));
      localObject2 = ((ITroopInfoService)localObject2).getTroopInfo(String.valueOf(paramString));
      if (localObject2 != null)
      {
        ((oidb_0xa2a.ReqBody)localObject1).hok_appid.set((int)((TroopInfo)localObject2).hlGuildAppid);
        ((oidb_0xa2a.ReqBody)localObject1).hok_type.set((int)((TroopInfo)localObject2).hlGuildSubType);
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xa2a_2", 2602, 2, ((oidb_0xa2a.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getOnlineMemTips, e=");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.i("TroopOnlineMemberHandler", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void d(String paramString)
  {
    if (this.appRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getAllGameOnlineMemberList, app == null");
      }
      return;
    }
    ThreadManager.post(new TroopOnlineMemberHandler.3(this, paramString), 8, null, true);
  }
  
  protected String dv_()
  {
    return "TroopOnlineMemberHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xa2a_0");
      this.a.add("OidbSvc.0xa2a_1");
      this.a.add("OidbSvc.0xa2a_2");
      this.a.add("OidbSvc.0xa2a_6");
      this.a.add("OidbSvc.0xd71");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopOnlineMemberObserver.class;
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
          QLog.d("TroopOnlineMemberHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopOnlineMemberHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xa2a_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd71".equals(paramFromServiceMsg.getServiceCmd())) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopOnlineMemberHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler
 * JD-Core Version:    0.7.0.1
 */