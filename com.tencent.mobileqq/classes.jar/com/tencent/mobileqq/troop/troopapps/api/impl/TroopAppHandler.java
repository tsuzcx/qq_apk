package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.utils.AssertUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab.ReqBody;
import tencent.im.oidb.cmd0xb70.oidb_0xb70.ReqBody;
import tencent.im.oidb.cmd0xb70.oidb_0xb70.RspBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.ClientInfo;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.ReqBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e.RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ClientInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ReqBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.cmd0xece.oidb_0xece.ClientInfo;
import tencent.im.oidb.cmd0xece.oidb_0xece.ReqBody;
import tencent.im.oidb.cmd0xece.oidb_0xece.RspBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.AppInfo;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.ReqBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.Result;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.RspBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.AppInfo;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.ReqBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.AppInfo;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.ReqBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopAppHandler
  extends TroopBaseHandler
  implements ITroopAppHandler
{
  public TroopAppHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private TroopAIOAppInfo a(int paramInt, List<Integer> paramList1, List<Integer> paramList2, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    paramList2.add(Integer.valueOf(paramTroopAIOAppInfo.appid));
    paramList2 = paramTroopAIOAppInfo;
    if (!paramList1.contains(Integer.valueOf(paramTroopAIOAppInfo.appid)))
    {
      paramList2 = (ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
      if (paramList2.needRequestDetail(paramTroopAIOAppInfo))
      {
        paramList2.ensureAppInfoExist(paramTroopAIOAppInfo);
        paramList1.add(Integer.valueOf(paramTroopAIOAppInfo.appid));
        paramList2 = paramTroopAIOAppInfo;
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("troopAppInfo need detail:");
          paramList1.append(paramTroopAIOAppInfo.toString());
          QLog.d(".troop.troop_app", 2, paramList1.toString());
          return paramTroopAIOAppInfo;
        }
      }
      else
      {
        paramList1 = paramList2.getAppInfo(paramTroopAIOAppInfo.appid, paramInt);
        AssertUtils.a(paramList1);
        paramList2 = paramList1;
        if (QLog.isColorLevel())
        {
          paramList2 = new StringBuilder();
          paramList2.append("troopAppInfo not need detail:");
          paramList2.append(paramList1.toString());
          QLog.d(".troop.troop_app", 2, paramList2.toString());
          paramList2 = paramList1;
        }
      }
    }
    return paramList2;
  }
  
  private void a(int paramInt1, int paramInt2, cmd0xca02.RspBody paramRspBody, ArrayList<TroopAIOAppInfo> paramArrayList, List<Integer> paramList1, List<Integer> paramList2)
  {
    ITroopAppService localITroopAppService = (ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
    if (paramInt1 == 1) {
      localITroopAppService.update0xca02Info(paramRspBody.all_app_wording.get());
    }
    localITroopAppService.updateAppInfoCalendarDay(paramInt2);
    if (paramInt1 == 1)
    {
      if ((localITroopAppService.makeAppidsInOrder(paramList2, paramInt2)) && (paramList1.isEmpty())) {
        notifyUI(TroopAppObserver.a, true, new Object[] { null });
      }
      if (!paramList1.isEmpty()) {
        a(2, paramInt2, paramList1, false);
      }
    }
    else
    {
      localITroopAppService.addTroopAppInfos(paramArrayList, paramInt2);
      notifyUI(TroopAppObserver.a, true, new Object[] { null });
    }
  }
  
  private void a(TroopAIOAppInfo paramTroopAIOAppInfo, cmd0xca02.Result paramResult)
  {
    paramTroopAIOAppInfo.appid = paramResult.uint32_id.get();
    paramTroopAIOAppInfo.name = paramResult.string_name.get().toStringUtf8();
    paramTroopAIOAppInfo.canRemove = paramResult.bool_can_remove.get();
    paramTroopAIOAppInfo.hashVal = paramResult.string_hash_val.get().toStringUtf8();
    paramTroopAIOAppInfo.redPoint = paramResult.bool_red_point.get();
    paramTroopAIOAppInfo.iconUrl = paramResult.string_icon.get().toStringUtf8();
    paramTroopAIOAppInfo.url = paramResult.string_url.get().toStringUtf8();
    if (((cmd0xca02.AppInfo)paramResult.msg_app_info.get()).plat_type.get() == 2) {
      paramTroopAIOAppInfo.minVersion = ((cmd0xca02.AppInfo)paramResult.msg_app_info.get()).str_app_version.get();
    }
    if (!TroopAIOAppInfo.checkVersion(paramTroopAIOAppInfo.minVersion)) {
      paramTroopAIOAppInfo.minVersion = "0";
    }
    paramTroopAIOAppInfo.identifyMask = paramResult.uint32_identify_visibilty.get();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    int j;
    boolean bool;
    cmd0xca02.RspBody localRspBody;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      i = paramToServiceMsg.extraData.getInt("readType");
      j = paramToServiceMsg.extraData.getInt("groupType");
      bool = paramToServiceMsg.extraData.getBoolean("appListChangedFromWebOperate");
      if ((i != 2) && (i != 1)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppHandler.troop.troop_app", 2, new Object[] { "handleGetTroopAppList(), readType: ", Integer.valueOf(i), " ,groupType: ", Integer.valueOf(j) });
      }
      localRspBody = new cmd0xca02.RspBody();
    }
    label601:
    label602:
    label607:
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        if (localRspBody.uint32_res.get() == 0)
        {
          ITroopAppService localITroopAppService = (ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
          if (localITroopAppService == null)
          {
            notifyUI(TroopAppObserver.a, false, new Object[] { null });
            if (!QLog.isColorLevel()) {
              break label601;
            }
            QLog.d("TroopAppHandler.troop.troop_app", 2, "handleGetTroopAppList==>troopAppMgr == null");
            return;
          }
          if (bool) {
            localITroopAppService.setAppListChangedFromWebOperate(false);
          }
          localITroopAppService.saveAppListTimestamp(localRspBody.uint32_timestamp.get(), j);
          localITroopAppService.setCheckedUpdateAfterLogined(true, j);
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetTroopAppList==>appListTimestamp:");
            paramToServiceMsg.append(localRspBody.uint32_timestamp.get());
            QLog.d("TroopAppHandler.troop.troop_app", 2, paramToServiceMsg.toString());
          }
          paramFromServiceMsg = localRspBody.rpt_result.get();
          ArrayList localArrayList1 = new ArrayList();
          if (i != 1) {
            break label602;
          }
          paramToServiceMsg = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator = paramFromServiceMsg.iterator();
          if (localIterator.hasNext())
          {
            paramFromServiceMsg = (cmd0xca02.Result)localIterator.next();
            if (paramFromServiceMsg.uint32_id.get() <= 0) {
              continue;
            }
            if (paramFromServiceMsg.uint32_res.get() == 2)
            {
              if (QLog.isColorLevel())
              {
                paramObject = new StringBuilder();
                paramObject.append("result.uint32_res.get() == 2|appid:");
                paramObject.append(paramFromServiceMsg.uint32_id.get());
                paramObject.append("|appName:");
                paramObject.append(paramFromServiceMsg.string_name.get().toStringUtf8());
                QLog.d("TroopAppHandler.troop.troop_app", 2, paramObject.toString());
              }
              localITroopAppService.removeTroopAppByAppid(paramFromServiceMsg.uint32_id.get(), j);
              break label607;
            }
            paramObject = new TroopAIOAppInfo();
            a(paramObject, paramFromServiceMsg);
            paramObject.groupType = j;
            paramFromServiceMsg = paramObject;
            if (i == 1) {
              paramFromServiceMsg = a(j, paramToServiceMsg, localArrayList2, paramObject);
            }
            localArrayList1.add(paramFromServiceMsg);
            break label607;
          }
          a(i, j, localRspBody, localArrayList1, paramToServiceMsg, localArrayList2);
          return;
        }
        notifyUI(TroopAppObserver.a, false, new Object[] { null });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        continue;
      }
      notifyUI(TroopAppObserver.a, false, new Object[] { null });
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleGetTroopAppList");
      }
      return;
      notifyUI(TroopAppObserver.a, false, new Object[] { null });
      return;
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xca04.RspBody localRspBody;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("appidList2sort");
      localRspBody = new cmd0xca04.RspBody();
    }
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      int i = localRspBody.uint32_res.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onrecive, cmd_troop_sort_app_list, re:");
        paramObject.append(i);
        QLog.d("TroopAppHandler.troop.troop_app", 2, paramObject.toString());
      }
      if (i == 0)
      {
        paramObject = (ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
        if (paramObject == null)
        {
          notifyUI(TroopAppObserver.b, false, null);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("TroopAppHandler.troop.troop_app", 2, "troopAppMgr == null");
          return;
        }
        paramObject.saveAppListTimestamp(localRspBody.uint32_timestamp.get(), 0);
        paramObject.makeAppidsInOrder(paramFromServiceMsg, 0);
        notifyUI(TroopAppObserver.b, true, null);
        paramToServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("appidToAdd");
        ((TroopAppHandler)this.appRuntime.getBusinessHandler(TroopAppHandler.class.getName())).a(2, 0, paramToServiceMsg, false);
        return;
      }
      notifyUI(TroopAppObserver.b, false, null);
      if (!QLog.isColorLevel()) {
        break label289;
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("sort troop apps falied, rspBody.uint32_res:");
      paramToServiceMsg.append(i);
      QLog.d("TroopAppHandler.troop.troop_app", 2, paramToServiceMsg.toString());
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label264:
      break label264;
    }
    notifyUI(TroopAppObserver.b, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleSortTroopAppList");
    }
    label289:
    return;
    notifyUI(TroopAppObserver.b, false, null);
    return;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getIntegerArrayList("appids");
    int i = paramToServiceMsg.extraData.getInt("groupType");
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      paramToServiceMsg = new cmd0xca05.RspBody();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      int j = paramToServiceMsg.uint32_res.get();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleClearTroopAppRedPoint, retCode:");
        paramFromServiceMsg.append(j);
        QLog.d("TroopAppHandler.troop.troop_app", 2, paramFromServiceMsg.toString());
      }
      if (j == 0)
      {
        paramFromServiceMsg = paramToServiceMsg.rpt_result.get();
        paramObject = (ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
        ITroopAioAppService localITroopAioAppService = (ITroopAioAppService)this.appRuntime.getRuntimeService(ITroopAioAppService.class, "");
        if (paramObject == null) {
          break label302;
        }
        paramObject.saveAppListTimestamp(paramToServiceMsg.uint32_timestamp.get(), i);
        i = 0;
        while (i < localArrayList.size())
        {
          paramObject.clearLocalTroopAppRedPoint(((Integer)localArrayList.get(i)).intValue());
          localITroopAioAppService.clearRedDotInCacheAndDb(((Integer)localArrayList.get(i)).intValue());
          i += 1;
        }
        notifyUI(TroopAppObserver.c, true, new Object[] { localArrayList, paramFromServiceMsg });
        return;
      }
      notifyUI(TroopAppObserver.c, false, null);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label265:
      break label265;
    }
    notifyUI(TroopAppObserver.c, false, new Object[] { localArrayList, null });
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleClearTroopAppRedPoint");
    }
    label302:
    return;
    notifyUI(TroopAppObserver.c, false, new Object[] { localArrayList, null });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.extraData.get("troopUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isProfileAppListChangedFromWebOperate");
    if (!paramFromServiceMsg.isSuccess())
    {
      ReportController.b(this.appRuntime, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -1, str, "", "", "");
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      int i = paramToServiceMsg.uint32_result.get();
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("mGetTroopAppListObserver: result = ");
          paramToServiceMsg.append(i);
          QLog.w("TroopAppHandler.troop.troop_app", 2, paramToServiceMsg.toString());
        }
      }
      else
      {
        paramFromServiceMsg = new oidb_0xe83.RspBody();
        paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        i = paramToServiceMsg.uint32_service_type.get();
        ((ITroopManagerService)this.appRuntime.getRuntimeService(ITroopManagerService.class, "")).setTroopAppListData(str, paramObject);
        if (bool) {
          ((ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(false, str);
        }
        paramFromServiceMsg.mergeFrom(paramObject);
        notifyUI(TroopAppObserver.d, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("mGetTroopAppListObserver: ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.w("TroopAppHandler.troop.troop_app", 2, paramFromServiceMsg.toString());
      }
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xb70.RspBody());
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
        long l = paramToServiceMsg.extraData.getLong("appId");
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleTroopAppFeedsReaded retCode = ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append("troopUin = ");
        paramToServiceMsg.append(paramFromServiceMsg);
        paramToServiceMsg.append(" appId = ");
        paramToServiceMsg.append(l);
        QLog.d("TroopAppHandler", 2, paramToServiceMsg.toString());
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TroopAppHandler", 1, "handleTroopAppFeedsReaded failed!", paramToServiceMsg);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      oidb_0xe2e.RspBody localRspBody = new oidb_0xe2e.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        notifyUI(TroopAppObserver.e, true, new Object[] { paramToServiceMsg.extraData, localRspBody, Integer.valueOf(i) });
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetShortcutTroopApps failed result:");
      paramFromServiceMsg.append(i);
      QLog.i("TroopAppHandler", 2, paramFromServiceMsg.toString());
      notifyUI(TroopAppObserver.e, false, new Object[] { paramToServiceMsg.extraData, localRspBody, Integer.valueOf(i) });
      return;
    }
    notifyUI(TroopAppObserver.e, false, new Object[] { Integer.valueOf(0), null, Integer.valueOf(-1) });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      long l = 0L;
      if (paramToServiceMsg.extraData != null) {
        l = paramToServiceMsg.extraData.getLong("troopUin");
      }
      paramToServiceMsg = new oidb_0xece.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        notifyUI(TroopAppObserver.f, true, new Object[] { Long.valueOf(l), paramToServiceMsg, Integer.valueOf(i) });
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetAddTroopAppRemindInfo failed result:");
      paramFromServiceMsg.append(i);
      QLog.i("TroopAppHandler", 2, paramFromServiceMsg.toString());
      notifyUI(TroopAppObserver.f, false, new Object[] { Long.valueOf(l), paramToServiceMsg, Integer.valueOf(i) });
      return;
    }
    notifyUI(TroopAppObserver.f, false, new Object[] { Integer.valueOf(0), null, Integer.valueOf(-1) });
  }
  
  protected String a()
  {
    return "TroopAppHandler";
  }
  
  public void a(int paramInt1, int paramInt2, List<Integer> paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppHandler.troop.troop_app", 2, new Object[] { "getTroopAppList: start", "readType: ", Integer.valueOf(paramInt1), " ,groupType: ", Integer.valueOf(paramInt2) });
    }
    cmd0xca02.ReqBody localReqBody = new cmd0xca02.ReqBody();
    localReqBody.uint32_type.set(paramInt1);
    Object localObject = new cmd0xca02.AppInfo();
    ((cmd0xca02.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca02.AppInfo)localObject).str_app_version.set("8.7.0");
    localReqBody.msg_app_info.set((MessageMicro)localObject);
    if (paramInt2 != 0) {
      localReqBody.uint32_group_type.set(paramInt2);
    }
    if (paramInt1 == 2)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramList = paramList.iterator();
      }
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        localReqBody.rpt_app_ids.add(localObject);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TroopAppHandler.troop.troop_app", 2, "invaliedAppids.isEmpty");
        }
        return;
      }
    }
    paramList = createToServiceMsg("GroupOpen.ReadAppList");
    paramList.putWupBuffer(localReqBody.toByteArray());
    paramList.extraData.putInt("readType", paramInt1);
    paramList.extraData.putBoolean("appListChangedFromWebOperate", paramBoolean);
    paramList.extraData.putInt("groupType", paramInt2);
    sendPbReq(paramList);
  }
  
  public void a(int paramInt, ArrayList<Integer> paramArrayList)
  {
    a(paramInt, paramArrayList, null);
  }
  
  public void a(int paramInt, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("modifyTroopAppList, start==>appListTimestamp:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("TroopAppHandler.troop.troop_app", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList1 != null)
    {
      if (paramArrayList1.isEmpty()) {
        return;
      }
      localObject1 = new cmd0xca04.ReqBody();
      ((cmd0xca04.ReqBody)localObject1).uint32_timestamp.set(paramInt);
      Object localObject2 = new cmd0xca04.AppInfo();
      ((cmd0xca04.AppInfo)localObject2).plat_type.set(2);
      ((cmd0xca04.AppInfo)localObject2).str_app_version.set("8.7.0");
      ((cmd0xca04.ReqBody)localObject1).msg_app_info.set((MessageMicro)localObject2);
      localObject2 = paramArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        if (localInteger.intValue() > 0) {
          ((cmd0xca04.ReqBody)localObject1).rpt_uint32_appids.add(localInteger);
        }
      }
      localObject2 = createToServiceMsg("GroupOpen.SortAppList");
      ((ToServiceMsg)localObject2).putWupBuffer(((cmd0xca04.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putIntegerArrayList("appidList2sort", paramArrayList1);
      if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
        ((ToServiceMsg)localObject2).extraData.putIntegerArrayList("appidToAdd", paramArrayList2);
      }
      sendPbReq((ToServiceMsg)localObject2);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new oidb_0xece.ReqBody();
    Object localObject2 = new oidb_0xece.ClientInfo();
    ((oidb_0xece.ClientInfo)localObject2).platform.set(2);
    ((oidb_0xece.ClientInfo)localObject2).version.set("8.7.0.5295");
    ((oidb_0xece.ReqBody)localObject1).client_info.set((MessageMicro)localObject2);
    ((oidb_0xece.ReqBody)localObject1).from.set(2);
    ((oidb_0xece.ReqBody)localObject1).group_id.set(paramLong);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3790);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xece.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvcTcp.0xece_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(5000L);
    ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = new oidb_0xe2e.ReqBody();
    Object localObject2 = new oidb_0xe2e.ClientInfo();
    ((oidb_0xe2e.ClientInfo)localObject2).platform.set(2);
    ((oidb_0xe2e.ClientInfo)localObject2).version.set("8.7.0.5295");
    ((oidb_0xe2e.ReqBody)localObject1).client.set((MessageMicro)localObject2);
    ((oidb_0xe2e.ReqBody)localObject1).group_id.set(paramLong);
    ((oidb_0xe2e.ReqBody)localObject1).group_type.set(paramInt1);
    ((oidb_0xe2e.ReqBody)localObject1).redpoint.set(1);
    ((oidb_0xe2e.ReqBody)localObject1).page.set(paramInt2);
    ((oidb_0xe2e.ReqBody)localObject1).num.set(paramInt3);
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      ((oidb_0xe2e.ReqBody)localObject1).mode.set(1);
    }
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3630);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xe2e.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xe2e_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(5000L);
    ((ToServiceMsg)localObject1).extraData.putLong("troopuin", paramLong);
    ((ToServiceMsg)localObject1).extraData.putInt("page", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putInt("num", paramInt3);
    ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt4);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 761	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +262 -> 269
    //   10: new 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 466	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 298	[B
    //   21: checkcast 298	[B
    //   24: invokevirtual 467	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +52 -> 84
    //   35: aload_1
    //   36: getfield 470	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 4
    //   44: invokestatic 764	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +37 -> 84
    //   50: new 79	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc_w 766
    //   62: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: iload 4
    //   69: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc_w 768
    //   76: iconst_4
    //   77: aload_2
    //   78: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 550	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_1
    //   85: ifnull +184 -> 269
    //   88: aload_1
    //   89: getfield 481	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   92: invokevirtual 771	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   95: ifeq +174 -> 269
    //   98: aload_1
    //   99: getfield 481	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   102: invokevirtual 177	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   105: ifnull +164 -> 269
    //   108: aload_1
    //   109: getfield 481	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   112: invokevirtual 177	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   115: invokevirtual 485	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   118: astore_1
    //   119: new 773	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody
    //   122: dup
    //   123: invokespecial 774	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:<init>	()V
    //   126: astore_2
    //   127: aload_2
    //   128: aload_1
    //   129: invokevirtual 775	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   132: pop
    //   133: aload_2
    //   134: getfield 779	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:list	Ltencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList;
    //   137: invokevirtual 782	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   140: checkcast 781	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList
    //   143: astore_1
    //   144: aload_1
    //   145: getfield 785	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:rpt_tab_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   148: invokevirtual 336	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   151: astore_2
    //   152: aload_1
    //   153: getfield 788	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:uint32_curr_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: i2l
    //   160: lstore 5
    //   162: lload 5
    //   164: ldc2_w 789
    //   167: lcmp
    //   168: ifne +101 -> 269
    //   171: new 17	java/lang/String
    //   174: dup
    //   175: aload_2
    //   176: lload 5
    //   178: l2i
    //   179: invokeinterface 791 2 0
    //   184: checkcast 793	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem
    //   187: getfield 796	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem:byt_tab_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   190: invokevirtual 177	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   193: invokevirtual 485	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   196: invokespecial 798	java/lang/String:<init>	([B)V
    //   199: pop
    //   200: aload_0
    //   201: getfield 54	com/tencent/mobileqq/troop/troopapps/api/impl/TroopAppHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   204: ldc 56
    //   206: ldc 58
    //   208: invokevirtual 64	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   211: checkcast 56	com/tencent/mobileqq/troop/troopapps/api/ITroopAppService
    //   214: iconst_1
    //   215: iconst_0
    //   216: invokeinterface 802 3 0
    //   221: pop
    //   222: return
    //   223: astore_1
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: invokestatic 764	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   230: ifeq +39 -> 269
    //   233: new 79	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   240: astore_2
    //   241: aload_2
    //   242: ldc_w 804
    //   245: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_2
    //   250: aload_1
    //   251: invokevirtual 805	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   254: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc_w 768
    //   261: iconst_4
    //   262: aload_2
    //   263: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: return
    //   270: astore_1
    //   271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	TroopAppHandler
    //   0	272	1	paramToServiceMsg	ToServiceMsg
    //   0	272	2	paramFromServiceMsg	FromServiceMsg
    //   0	272	3	paramObject	Object
    //   42	26	4	i	int
    //   160	17	5	l	long
    // Exception table:
    //   from	to	target	type
    //   119	162	223	finally
    //   171	222	223	finally
    //   10	31	226	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   119	162	270	java/lang/Exception
    //   171	222	270	java/lang/Exception
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = new oidb_0xb70.ReqBody();
    ((oidb_0xb70.ReqBody)localObject).group_id.set(Long.parseLong(paramString));
    ((oidb_0xb70.ReqBody)localObject).appid.set(paramLong);
    localObject = makeOIDBPkg("OidbSvc.0xb70_1", 2928, 1, ((oidb_0xb70.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject).extraData.putLong("appId", paramLong);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setTroopAppFeedsReaded. cmd=");
      paramString.append(((ToServiceMsg)localObject).getServiceCmd());
      QLog.d("TroopAppHandler", 2, paramString.toString());
    }
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = a(paramString);
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppHandler.troop.troop_app", 2, new Object[] { "getNewTroopAppList troopUin invalid. str=", paramString });
      }
      return;
    }
    Object localObject1 = new oidb_0xe83.ClientInfo();
    ((oidb_0xe83.ClientInfo)localObject1).platform.set(2);
    ((oidb_0xe83.ClientInfo)localObject1).version.set("8.7.0");
    Object localObject2 = new oidb_0xe83.ReqBody();
    ((oidb_0xe83.ReqBody)localObject2).group_id.set(l);
    ((oidb_0xe83.ReqBody)localObject2).client_info.set((MessageMicro)localObject1);
    ((oidb_0xe83.ReqBody)localObject2).last_game_dynamic_ts.set(paramInt1);
    if (paramInt3 > 0) {
      ((oidb_0xe83.ReqBody)localObject2).mode.set(paramInt3);
    }
    localObject1 = makeOIDBPkg("OidbSvc.0xe83", 3715, paramInt2, ((oidb_0xe83.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isProfileAppListChangedFromWebOperate", paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getNewTroopAppList. troopUin = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", isProfileAppListChangedFromWebOperate = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", time=");
      ((StringBuilder)localObject2).append(paramInt1);
      QLog.i("TroopAppHandler", 1, ((StringBuilder)localObject2).toString());
    }
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppHandler.troop.troop_app", 2, "getTroopAppList: start");
      }
      cmd0xca05.ReqBody localReqBody = new cmd0xca05.ReqBody();
      Object localObject = localReqBody.uint32_type;
      int i = 0;
      ((PBUInt32Field)localObject).set(0);
      localObject = new cmd0xca05.AppInfo();
      ((cmd0xca05.AppInfo)localObject).plat_type.set(2);
      ((cmd0xca05.AppInfo)localObject).str_app_version.set("8.7.0");
      while (i < paramArrayList.size())
      {
        localObject = (Integer)paramArrayList.get(i);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("redPoint appid:");
          localStringBuilder.append(localObject);
          QLog.d("TroopAppHandler.troop.troop_app", 2, localStringBuilder.toString());
        }
        localReqBody.rpt_app_ids.add(Long.valueOf(((Integer)localObject).intValue() + 0L));
        i += 1;
      }
      localObject = createToServiceMsg("GroupOpen.ClearRedPoint");
      ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appids", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("groupType", paramInt);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xf110_1 troopCode = ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("Q.troopgetnews.", 2, ((StringBuilder)localObject1).toString());
    }
    if (((ITroopAppService)this.appRuntime.getRuntimeService(ITroopAppService.class, "all")).getAppInfo(1104445552, 0) != null) {
      return;
    }
    Object localObject2 = new oidb_0x9ab.ReqBody();
    ((oidb_0x9ab.ReqBody)localObject2).uint64_group_code.set(paramLong);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2475);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9ab.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x9ab_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("GroupOpen.ReadAppList");
      this.allowCmdSet.add("GroupOpen.SortAppList");
      this.allowCmdSet.add("GroupOpen.ClearRedPoint");
      this.allowCmdSet.add("OidbSvc.0xe83");
      this.allowCmdSet.add("OidbSvc.0xb70_1");
      this.allowCmdSet.add("OidbSvc.0xe2e_1");
      this.allowCmdSet.add("OidbSvcTcp.0xece_1");
      this.allowCmdSet.add("OidbSvc.0x9ab_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAppObserver.class;
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
          QLog.d("TroopAppHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopAppHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("GroupOpen.ReadAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.SortAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.ClearRedPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe83".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb70_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe2e_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvcTcp.0xece_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ab_1".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppHandler
 * JD-Core Version:    0.7.0.1
 */