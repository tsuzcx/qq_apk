package com.tencent.mobileqq.troop.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopListHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopListRespV2;
import friendlist.stFavoriteGroup;
import friendlist.stGroupRankInfo;
import friendlist.stLevelRankPair;
import friendlist.stTroopInfoV2;
import friendlist.stTroopNum;
import friendlist.stTroopNumSimplify;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class TroopListHandler
  extends TroopBaseHandler
  implements ITroopListHandler
{
  public static String a = "GroupCodeZero";
  public static int b = 9101;
  public static int c = 9102;
  private static boolean d = false;
  private boolean e = false;
  private ArrayList<Long> f = new ArrayList();
  private ArrayList<TroopInfo> g;
  
  public TroopListHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopListHandlerProcessorConfig.a();
  }
  
  private stTroopNumSimplify a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    Object localObject = new stTroopNumSimplify();
    try
    {
      ((stTroopNumSimplify)localObject).GroupCode = Long.parseLong(paramTroopInfo.troopuin);
      ((stTroopNumSimplify)localObject).dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      if (!paramBoolean)
      {
        ((stTroopNumSimplify)localObject).dwGroupInfoSeq = paramTroopInfo.dwGroupInfoSeq;
        ((stTroopNumSimplify)localObject).dwGroupRankSeq = paramTroopInfo.dwGroupLevelSeq;
        long l;
        if (paramTroopInfo.mTroopInfoExtObj != null) {
          l = paramTroopInfo.mTroopInfoExtObj.groupInfoExtSeq;
        } else {
          l = 0L;
        }
        ((stTroopNumSimplify)localObject).dwGroupInfoExtSeq = l;
      }
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("dwGroupInfoSeq = ");
        paramTroopInfo.append(((stTroopNumSimplify)localObject).dwGroupInfoSeq);
        paramTroopInfo.append(",dwGroupRankSeq = ");
        paramTroopInfo.append(((stTroopNumSimplify)localObject).dwGroupRankSeq);
        paramTroopInfo.append(",dwGroupInfoExtSeq = ");
        paramTroopInfo.append(((stTroopNumSimplify)localObject).dwGroupInfoExtSeq);
        paramTroopInfo.append(",loadAll = ");
        paramTroopInfo.append(paramBoolean);
        QLog.d("TroopListHandler", 2, paramTroopInfo.toString());
      }
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label170:
      break label170;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NumberFormatException,info.troopuin=");
      ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
      QLog.d("TroopListHandler", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  @NotNull
  private List<TroopInfo> a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2, ITroopInfoService paramITroopInfoService)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramGetTroopListRespV2.vecTroopRank.iterator();
    while (localIterator.hasNext())
    {
      stGroupRankInfo localstGroupRankInfo = (stGroupRankInfo)localIterator.next();
      TroopInfo localTroopInfo = paramITroopInfoService.findTroopInfo(String.valueOf(localstGroupRankInfo.dwGroupCode));
      paramGetTroopListRespV2 = localTroopInfo;
      if (localTroopInfo == null)
      {
        paramGetTroopListRespV2 = new TroopInfo();
        paramGetTroopListRespV2.troopuin = String.valueOf(localstGroupRankInfo.dwGroupCode);
      }
      paramGetTroopListRespV2.uin = paramToServiceMsg.getUin();
      paramGetTroopListRespV2.cGroupRankSysFlag = localstGroupRankInfo.cGroupRankSysFlag;
      paramGetTroopListRespV2.cGroupRankUserFlag = localstGroupRankInfo.cGroupRankUserFlag;
      paramGetTroopListRespV2.dwGroupLevelSeq = localstGroupRankInfo.dwGroupRankSeq;
      a(paramGetTroopListRespV2, localstGroupRankInfo.vecRankMap);
      b(paramGetTroopListRespV2, localstGroupRankInfo.vecRankMapNew);
      paramGetTroopListRespV2.cNewGroupRankUserFlag = localstGroupRankInfo.cGroupRankUserFlagNew;
      paramGetTroopListRespV2.ownerNameShow = localstGroupRankInfo.strOwnerName;
      paramGetTroopListRespV2.adminNameShow = localstGroupRankInfo.strAdminName;
      paramGetTroopListRespV2.dwOfficeMode = localstGroupRankInfo.dwOfficeMode;
      localArrayList.add(paramGetTroopListRespV2);
      if (QLog.isColorLevel())
      {
        paramGetTroopListRespV2 = new StringBuilder();
        paramGetTroopListRespV2.append("handle getTroopList resp->vecTroopRank,troopUin: ");
        paramGetTroopListRespV2.append(localstGroupRankInfo.dwGroupCode);
        paramGetTroopListRespV2.append(" ,sys flag: ");
        paramGetTroopListRespV2.append(localstGroupRankInfo.cGroupRankSysFlag);
        paramGetTroopListRespV2.append(" ,user flag: ");
        paramGetTroopListRespV2.append(localstGroupRankInfo.cGroupRankUserFlag);
        paramGetTroopListRespV2.append(" ,level seq: ");
        paramGetTroopListRespV2.append(localstGroupRankInfo.dwGroupRankSeq);
        paramGetTroopListRespV2.append(" ,level size: ");
        int i;
        if (localstGroupRankInfo.vecRankMap != null) {
          i = localstGroupRankInfo.vecRankMap.size();
        } else {
          i = -1;
        }
        paramGetTroopListRespV2.append(i);
        QLog.d("TroopListHandler", 2, paramGetTroopListRespV2.toString());
      }
    }
    return localArrayList;
  }
  
  @NotNull
  private List<String> a(GetTroopListRespV2 paramGetTroopListRespV2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramGetTroopListRespV2.vecTroopListExt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("vecTroopListExt==>");
      int i = 0;
      while (i < paramGetTroopListRespV2.vecTroopListExt.size())
      {
        Object localObject = (stTroopNum)paramGetTroopListRespV2.vecTroopListExt.get(i);
        String str = String.valueOf(((stTroopNum)localObject).GroupCode);
        if ((!TextUtils.isEmpty(str)) && (!"0".equals(str)))
        {
          localArrayList.add(str);
          localStringBuilder.append("| troopItem.GroupUin: ");
          localStringBuilder.append(((stTroopNum)localObject).GroupUin);
          localStringBuilder.append(" troopItem.GroupCode: ");
          localStringBuilder.append(((stTroopNum)localObject).GroupCode);
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error troopuin: ");
          ((StringBuilder)localObject).append(str);
          QLog.e("TroopListHandler_ext", 2, ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetTroopListRespV2 = new StringBuilder();
        paramGetTroopListRespV2.append("handleGetTroopList resp, ext troop:");
        paramGetTroopListRespV2.append(localStringBuilder.toString());
        QLog.d("troop_ext", 2, paramGetTroopListRespV2.toString());
      }
    }
    return localArrayList;
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.Administrator != null)
    {
      if (paramTroopInfo.Administrator.startsWith("|")) {
        paramTroopInfo.Administrator = paramTroopInfo.Administrator.substring(1);
      }
      if (paramTroopInfo.Administrator.endsWith("|")) {
        paramTroopInfo.Administrator = paramTroopInfo.Administrator.substring(0, paramTroopInfo.Administrator.length() - 1);
      }
    }
    else
    {
      paramTroopInfo.Administrator = "";
    }
    Object localObject;
    if ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)
    {
      if (!paramTroopInfo.Administrator.contains(this.appRuntime.getAccount()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTroopInfo.Administrator);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.appRuntime.getAccount());
        paramTroopInfo.Administrator = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = paramTroopInfo.Administrator;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.appRuntime.getAccount());
      localStringBuilder.append("|");
      localObject = ((String)localObject).replace(localStringBuilder.toString(), "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|");
      localStringBuilder.append(this.appRuntime.getAccount());
      paramTroopInfo.Administrator = ((String)localObject).replace(localStringBuilder.toString(), "").replace(this.appRuntime.getAccount(), "");
    }
  }
  
  private void a(TroopInfo paramTroopInfo, List<stLevelRankPair> paramList)
  {
    if ((paramTroopInfo != null) && (paramList != null) && (paramList.size() > 0))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.putAll(paramTroopInfo.getTroopLevelMap());
      int i = 0;
      while (i < paramList.size())
      {
        stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
        localConcurrentHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
        i += 1;
      }
      paramTroopInfo.setTroopLevelMap(localConcurrentHashMap);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetMultiTroopInfoResp paramGetMultiTroopInfoResp)
  {
    int k = 0;
    int j = 0;
    if (paramGetMultiTroopInfoResp == null)
    {
      notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, false, null);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, false, null);
      return;
    }
    if (paramGetMultiTroopInfoResp.result != 0)
    {
      notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, false, null);
      return;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    int i = k;
    if (paramGetMultiTroopInfoResp.vecTroopInfo != null)
    {
      i = k;
      if (paramGetMultiTroopInfoResp.vecTroopInfo.size() > 0)
      {
        Iterator localIterator = paramGetMultiTroopInfoResp.vecTroopInfo.iterator();
        i = j;
        while (localIterator.hasNext())
        {
          stTroopInfoV2 localstTroopInfoV2 = (stTroopInfoV2)localIterator.next();
          paramGetMultiTroopInfoResp = localITroopInfoService.findTroopInfo(String.valueOf(localstTroopInfoV2.dwGroupCode));
          paramFromServiceMsg = paramGetMultiTroopInfoResp;
          if (paramGetMultiTroopInfoResp == null)
          {
            paramFromServiceMsg = new TroopInfo();
            paramFromServiceMsg.troopuin = String.valueOf(localstTroopInfoV2.dwGroupCode);
          }
          paramFromServiceMsg.troopcode = String.valueOf(localstTroopInfoV2.dwGroupUin);
          if (paramFromServiceMsg.troopcode != null)
          {
            j = i;
            if (!paramFromServiceMsg.troopcode.equals("0")) {}
          }
          else
          {
            j = 1;
          }
          paramFromServiceMsg.troopname = localstTroopInfoV2.strGroupName;
          paramFromServiceMsg.troopmemo = localstTroopInfoV2.strGroupMemo;
          paramFromServiceMsg.fingertroopmemo = localstTroopInfoV2.strFingerMemo;
          paramFromServiceMsg.troopowneruin = Long.toString(localstTroopInfoV2.dwGroupOwnerUin);
          paramFromServiceMsg.dwGroupClassExt = localstTroopInfoV2.dwGroupClassExt;
          paramFromServiceMsg.troopface = ((short)localstTroopInfoV2.wGroupFace);
          paramFromServiceMsg.cGroupOption = ((short)localstTroopInfoV2.cGroupOption);
          paramFromServiceMsg.wMemberNum = localstTroopInfoV2.memberNum;
          paramFromServiceMsg.timeSec = l;
          paramFromServiceMsg.dwGroupFlagExt = localstTroopInfoV2.dwGroupFlagExt;
          paramFromServiceMsg.dwAuthGroupType = localstTroopInfoV2.dwCertificationType;
          localArrayList.add(paramFromServiceMsg);
          i = j;
          if (QLog.isColorLevel())
          {
            paramGetMultiTroopInfoResp = new StringBuilder();
            paramGetMultiTroopInfoResp.append("handleMultiTroopInfo save troop ");
            paramGetMultiTroopInfoResp.append(paramFromServiceMsg.troopuin);
            paramGetMultiTroopInfoResp.append(" troopcode:");
            paramGetMultiTroopInfoResp.append(paramFromServiceMsg.troopcode);
            QLog.d("refreshTroopList", 2, paramGetMultiTroopInfoResp.toString());
            i = j;
          }
        }
        localITroopInfoService.saveTroops(localArrayList, l);
      }
    }
    if (i != 0) {
      a(c);
    }
    notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, true, localArrayList);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null))
    {
      int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("k_resend_cnt");
        paramFromServiceMsg.append(i);
        QLog.d("TroopListHandler", 2, paramFromServiceMsg.toString());
      }
      if (i < 2)
      {
        paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
        send(paramToServiceMsg);
        return;
      }
    }
    if (paramObject == null)
    {
      notifyUI(TroopObserver.TYPE_GET_TROOP_LIST, false, null);
      return;
    }
    paramFromServiceMsg = (GetTroopListRespV2)paramObject;
    if ((paramFromServiceMsg.result != 1) && ((paramFromServiceMsg.vecTroopList != null) || (paramFromServiceMsg.vecTroopListDel != null)))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    notifyUI(TroopObserver.TYPE_GET_TROOP_LIST, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    boolean bool = false;
    if (paramGetTroopListRespV2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "handle get troop list resp, resp == null");
      }
      notifyUI(TroopObserver.TYPE_GET_TROOP_LIST, false, null);
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle get troop list resp, changeNum: ");
      ArrayList localArrayList = paramGetTroopListRespV2.vecTroopList;
      int j = -1;
      if (localArrayList != null) {
        i = paramGetTroopListRespV2.vecTroopList.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" deleteNum: ");
      if (paramGetTroopListRespV2.vecTroopListDel != null) {
        i = paramGetTroopListRespV2.vecTroopListDel.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" LevelInfoNum: ");
      if (paramGetTroopListRespV2.vecTroopRank != null) {
        i = paramGetTroopListRespV2.vecTroopRank.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" FavGroupNum: ");
      if (paramGetTroopListRespV2.vecFavGroup != null) {
        i = paramGetTroopListRespV2.vecFavGroup.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" extNum: ");
      i = j;
      if (paramGetTroopListRespV2.vecTroopListExt != null) {
        i = paramGetTroopListRespV2.vecTroopListExt.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopListHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramGetTroopListRespV2.vecTroopList == null) && (paramGetTroopListRespV2.vecTroopListDel == null) && (paramGetTroopListRespV2.vecTroopRank == null) && (paramGetTroopListRespV2.vecFavGroup == null))
    {
      i = TroopObserver.TYPE_GET_TROOP_LIST;
      if (paramGetTroopListRespV2.errorCode == 0) {
        bool = true;
      }
      notifyUI(i, bool, null);
      d = true;
      TroopListHandlerProcessorConfig.a(this.appRuntime);
      return;
    }
    if (paramGetTroopListRespV2.errorCode == 2001)
    {
      b(this.g);
      return;
    }
    Object localObject = new ArrayList();
    long l = System.currentTimeMillis();
    try
    {
      a(paramToServiceMsg, paramGetTroopListRespV2, (ArrayList)localObject, l, false);
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("TroopListHandler", 2, QLog.getStackTraceString(paramToServiceMsg));
      }
    }
    if ((paramGetTroopListRespV2.vecCookies != null) && (paramGetTroopListRespV2.vecCookies.length > 0))
    {
      a(paramGetTroopListRespV2.vecCookies);
      return;
    }
    if (this.f.size() > 0)
    {
      ((TroopMemberListHandler)this.appRuntime.getBusinessHandler(TroopMemberListHandler.class.getName())).a(this.f);
      this.f.clear();
    }
    ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).refreshCommonlyUsedTroop();
    paramToServiceMsg = this.appRuntime.getApplicationContext();
    paramGetTroopListRespV2 = new StringBuilder();
    paramGetTroopListRespV2.append(this.appRuntime.getAccount());
    paramGetTroopListRespV2.append("load_trooplist");
    paramToServiceMsg.getSharedPreferences(paramGetTroopListRespV2.toString(), 0).edit().putBoolean("load_all_6", false).commit();
    if (QLog.isColorLevel()) {
      QLog.i("TroopListHandler", 2, "notifyUI(TYPE_GET_TROOP_LIST");
    }
    notifyUI(TroopObserver.TYPE_GET_TROOP_LIST, true, null);
    d = true;
    TroopListHandlerProcessorConfig.a(this.appRuntime);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2, ArrayList<Long> paramArrayList, long paramLong, boolean paramBoolean)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    Object localObject = b(paramGetTroopListRespV2);
    if (!((List)localObject).isEmpty()) {
      localITroopInfoService.deleteTroopList((List)localObject);
    }
    localObject = a(paramGetTroopListRespV2);
    if (!((List)localObject).isEmpty()) {
      localITroopInfoService.setTroopEliminated((List)localObject);
    }
    if (paramGetTroopListRespV2.vecTroopList != null)
    {
      localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, new Object[] { "vecTroopList.size():", Integer.valueOf(paramGetTroopListRespV2.vecTroopList.size()) });
      }
      boolean bool = a(paramToServiceMsg, paramGetTroopListRespV2, paramArrayList, paramLong, paramBoolean, localITroopInfoService, (List)localObject, localHashMap);
      localITroopInfoService.addTroops((List)localObject);
      if (localHashMap.size() > 0) {
        TroopListHandlerProcessorConfig.a(this.appRuntime, localHashMap);
      }
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopListHandler", 2, new Object[] { "handle get troop list hidden:", Integer.valueOf(localHashMap.size()) });
        paramBoolean = bool;
      }
    }
    if (paramGetTroopListRespV2.vecTroopRank != null) {
      localITroopInfoService.addTroops(a(paramToServiceMsg, paramGetTroopListRespV2, localITroopInfoService));
    }
    if (paramGetTroopListRespV2.vecGroupInfoExt != null) {
      ((TroopInfoExtHandler)this.appRuntime.getBusinessHandler(TroopInfoExtHandler.class.getName())).a(paramGetTroopListRespV2.vecGroupInfoExt);
    }
    a(paramGetTroopListRespV2, localITroopInfoService);
    TroopListHandlerProcessorConfig.a(this.appRuntime, paramGetTroopListRespV2);
    if (paramBoolean) {
      a(b);
    }
  }
  
  private void a(GetTroopListRespV2 paramGetTroopListRespV2, ITroopInfoService paramITroopInfoService)
  {
    if ((paramGetTroopListRespV2.vecFavGroup != null) && (this.e))
    {
      HashMap localHashMap = new HashMap();
      paramGetTroopListRespV2 = paramGetTroopListRespV2.vecFavGroup.iterator();
      while (paramGetTroopListRespV2.hasNext())
      {
        stFavoriteGroup localstFavoriteGroup = (stFavoriteGroup)paramGetTroopListRespV2.next();
        if ((localstFavoriteGroup.dwSnsFlag & 1L) == 1L) {
          localHashMap.put(new Long(localstFavoriteGroup.dwGroupCode).toString(), Long.valueOf(localstFavoriteGroup.dwTimestamp));
        }
      }
      paramITroopInfoService.prePareCommonlyUsedTroop(localHashMap);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetTroopListReqV2");
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.extraData.putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    localToServiceMsg.extraData.putByte("bGetLongGroupName", (byte)1);
    this.e = false;
    localToServiceMsg.extraData.putByteArray("vecCookies", paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListHandler", 2, "get troop list, cookie != null");
    }
    send(localToServiceMsg);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2, ArrayList<Long> paramArrayList, long paramLong, boolean paramBoolean, ITroopInfoService paramITroopInfoService, List<TroopInfo> paramList, Map<String, Boolean> paramMap)
  {
    int i = 0;
    while (i < paramGetTroopListRespV2.vecTroopList.size())
    {
      stTroopNum localstTroopNum = (stTroopNum)paramGetTroopListRespV2.vecTroopList.get(i);
      TroopInfo localTroopInfo = paramITroopInfoService.findTroopInfo(String.valueOf(localstTroopNum.GroupCode));
      Object localObject = String.valueOf(localstTroopNum.GroupCode);
      if (localTroopInfo == null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localTroopInfo = new TroopInfo();
        localTroopInfo.troopuin = ((String)localObject);
      }
      localTroopInfo.uin = paramToServiceMsg.getUin();
      localTroopInfo.troopcode = String.valueOf(localstTroopNum.GroupUin);
      localTroopInfo.dwGroupInfoSeq = localstTroopNum.dwGroupInfoSeq;
      localTroopInfo.troopname = localstTroopNum.strGroupName;
      localTroopInfo.oldTroopName = localstTroopNum.strGroupName;
      localTroopInfo.troopmemo = localstTroopNum.strGroupMemo;
      localTroopInfo.dwGroupFlagExt = localstTroopNum.dwGroupFlagExt;
      localTroopInfo.dwAuthGroupType = localstTroopNum.dwCertificationType;
      localTroopInfo.timeSec = paramLong;
      localTroopInfo.dwGroupLevelSeq = localstTroopNum.dwGroupRankSeq;
      localTroopInfo.dwGagTimeStamp = localstTroopNum.dwShutupTimestamp;
      localTroopInfo.dwGagTimeStamp_me = localstTroopNum.dwMyShutupTimestamp;
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, String.format("fightgag.handleTroopList6782:sUin=%s, self Gag,time = %d", new Object[] { localObject, Long.valueOf(localTroopInfo.dwGagTimeStamp_me) }));
      }
      boolean bool1;
      if (localTroopInfo.cmdUinFlagEx2 != localstTroopNum.udwCmdUinFlagEx2)
      {
        if (TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512) != TroopInfo.isCmdUinFlagEx2Open(localstTroopNum.udwCmdUinFlagEx2, 512)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localTroopInfo.cmdUinFlagEx2 = localstTroopNum.udwCmdUinFlagEx2;
        if (bool1) {
          paramMap.put(localTroopInfo.troopuin, Boolean.valueOf(TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512)));
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopListHandler", 2, new Object[] { "change:", Boolean.valueOf(bool1), " troop:", localTroopInfo.troopuin });
        }
      }
      localTroopInfo.udwCmdUinRingtoneID = localstTroopNum.udwCmdUinRingtoneID;
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, new Object[] { "handleTroopList: invoked. friendlist.GetTroopListReqV2::update cmdUinFlagEx2 ", Long.valueOf(localTroopInfo.cmdUinFlagEx2), " info.udwCmdUinRingtoneID: ", Long.valueOf(localTroopInfo.udwCmdUinRingtoneID), " troopUin: ", localObject });
      }
      localTroopInfo.dwCmdUinUinFlag = localstTroopNum.dwCmdUinUinFlag;
      localTroopInfo.dwAdditionalFlag = localstTroopNum.dwAdditionalFlag;
      localTroopInfo.dwGroupFlag = localstTroopNum.dwGroupFlag;
      localTroopInfo.troopTypeExt = ((int)localstTroopNum.dwGroupTypeFlag);
      localTroopInfo.dwGroupClassExt = localstTroopNum.dwGroupClassExt;
      localTroopInfo.dwCmdUinJoinTime = localstTroopNum.dwCmduinJoinTime;
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) && (TextUtils.isEmpty(localTroopInfo.troopowneruin))) {
        localTroopInfo.troopowneruin = this.appRuntime.getAccount();
      }
      if (localstTroopNum.dwGroupOwnerUin != 0L) {
        localTroopInfo.troopowneruin = String.valueOf(localstTroopNum.dwGroupOwnerUin);
      }
      localTroopInfo.dwAppPrivilegeFlag = localstTroopNum.dwAppPrivilegeFlag;
      localTroopInfo.troopPrivilegeFlag = localstTroopNum.dwAppPrivilegeFlag;
      localTroopInfo.associatePubAccount = localstTroopNum.dwSubscriptionUin;
      a(localTroopInfo);
      localTroopInfo.wMemberNum = ((int)localstTroopNum.dwMemberNum);
      localTroopInfo.wMemberNumClient = localTroopInfo.wMemberNum;
      localTroopInfo.mMemberNumSeq = localstTroopNum.dwMemberNumSeq;
      localTroopInfo.mMemberCardSeq = localstTroopNum.dwMemberCardSeq;
      localTroopInfo.troopCreditLevel = localstTroopNum.dwGroupSecType;
      localTroopInfo.troopCreditLevelInfo = localstTroopNum.dwGroupSecTypeInfo;
      if ((localstTroopNum.dwGroupFlag & 0x80) == 128L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localTroopInfo.isTroopBlocked = bool1;
      localTroopInfo.appealDeadline = localstTroopNum.dwAppealDeadline;
      localTroopInfo.dwGroupFlagExt3 = localstTroopNum.dwGroupFlagExt3;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleTroopList troopUin:");
        ((StringBuilder)localObject).append(localTroopInfo.troopuin);
        ((StringBuilder)localObject).append(" dwGroupFlagExt3:");
        ((StringBuilder)localObject).append(localTroopInfo.dwGroupFlagExt3);
        ((StringBuilder)localObject).append(" isListenTogetherOpen: ");
        ((StringBuilder)localObject).append(localTroopInfo.isListenTogetherOpen());
        ((StringBuilder)localObject).append(", isAVGameOpen: ");
        ((StringBuilder)localObject).append(localTroopInfo.isAVGameOpen());
        ((StringBuilder)localObject).append(", isTroopHonorOpen: ");
        ((StringBuilder)localObject).append(localTroopInfo.isTroopHonorOpen());
        QLog.i("TroopListHandler", 2, ((StringBuilder)localObject).toString());
      }
      localTroopInfo.groupFlagExt4 = ((int)localstTroopNum.dwGroupFlagExt4);
      int j = localstTroopNum.cIsConfGroup;
      boolean bool2 = true;
      if (j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localTroopInfo.isNewTroop = bool1;
      if (localstTroopNum.cIsModifyConfGroupFace == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localTroopInfo.hasSetNewTroopHead = bool1;
      if (localstTroopNum.cIsModifyConfGroupName == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localTroopInfo.hasSetNewTroopName = bool1;
      localTroopInfo.wMemberMax = ((int)localstTroopNum.dwMaxGroupMemberNum);
      localTroopInfo.eliminated = 0;
      if ((QLog.isColorLevel()) && (localTroopInfo.isQidianPrivateTroop()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleTroopList, vecTroopList privateTroop troopUin=");
        ((StringBuilder)localObject).append(localTroopInfo.troopuin);
        QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject).toString());
      }
      localTroopInfo.hlGuildAppid = localstTroopNum.udwHLGuildAppid;
      localTroopInfo.hlGuildSubType = localstTroopNum.udwHLGuildSubType;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleTroopList], appID:");
        ((StringBuilder)localObject).append(localTroopInfo.hlGuildAppid);
        ((StringBuilder)localObject).append(",subType:");
        ((StringBuilder)localObject).append(localTroopInfo.hlGuildSubType);
        QLog.d(".troop.kingteam_troop", 2, ((StringBuilder)localObject).toString());
      }
      if (localstTroopNum.vecGroupRemark != null)
      {
        localTroopInfo.troopRemark = new String(localstTroopNum.vecGroupRemark);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[handleTroopList], troopRemark length : ");
          ((StringBuilder)localObject).append(localstTroopNum.vecGroupRemark.length);
          QLog.d(".troop.kingteam_troop", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localTroopInfo.troopRemark = "";
      }
      paramList.add(localTroopInfo);
      if ((localTroopInfo.troopcode != null) && (!localTroopInfo.troopcode.equals("0"))) {
        paramArrayList.add(Long.valueOf(localstTroopNum.GroupCode));
      } else {
        paramBoolean = bool2;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle get troop list resp, save troop, troopUin: ");
        ((StringBuilder)localObject).append(localstTroopNum.GroupUin);
        ((StringBuilder)localObject).append(" troopCode: ");
        ((StringBuilder)localObject).append(localstTroopNum.GroupCode);
        ((StringBuilder)localObject).append(", cLevel:");
        ((StringBuilder)localObject).append(localTroopInfo.troopCreditLevel);
        ((StringBuilder)localObject).append(", cInfo:");
        ((StringBuilder)localObject).append(localTroopInfo.troopCreditLevelInfo);
        ((StringBuilder)localObject).append(", info.wMemberNum:");
        ((StringBuilder)localObject).append(localTroopInfo.wMemberNum);
        ((StringBuilder)localObject).append(", info.mMemberNumSeq");
        ((StringBuilder)localObject).append(localTroopInfo.mMemberNumSeq);
        ((StringBuilder)localObject).append(", info.mMemberCardSeq:");
        ((StringBuilder)localObject).append(localTroopInfo.mMemberCardSeq);
        ((StringBuilder)localObject).append(",strGroupName = ");
        ((StringBuilder)localObject).append(localstTroopNum.strGroupName);
        QLog.d("TroopListHandler", 2, ((StringBuilder)localObject).toString());
      }
      localObject = paramITroopInfoService.getTroopMemberForTroopHead(localTroopInfo.troopuin);
      if ((!localTroopInfo.hasSetTroopHead()) && ((((ArrayList)localObject).size() == 0) || ((((ArrayList)localObject).size() < 4) && (localTroopInfo.mMemberNumSeq != localTroopInfo.mOldMemberNumSeq)))) {
        this.f.add(Long.valueOf(localstTroopNum.GroupCode));
      }
      TroopListHandlerProcessorConfig.a(this.appRuntime, localTroopInfo);
      i += 1;
    }
    return paramBoolean;
  }
  
  @NotNull
  private List<String> b(GetTroopListRespV2 paramGetTroopListRespV2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramGetTroopListRespV2.vecTroopListDel != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("vecTroopListDel==>");
      int i = 0;
      while (i < paramGetTroopListRespV2.vecTroopListDel.size())
      {
        Object localObject = (stTroopNum)paramGetTroopListRespV2.vecTroopListDel.get(i);
        String str = String.valueOf(((stTroopNum)localObject).GroupCode);
        if ((!TextUtils.isEmpty(str)) && (!"0".equals(str)))
        {
          localArrayList.add(str);
          localStringBuilder.append("| troopItem.GroupUin: ");
          localStringBuilder.append(((stTroopNum)localObject).GroupUin);
          localStringBuilder.append(" troopItem.GroupCode: ");
          localStringBuilder.append(((stTroopNum)localObject).GroupCode);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("error troopuin: ");
            ((StringBuilder)localObject).append(str);
            QLog.e("TroopListHandler", 2, ((StringBuilder)localObject).toString());
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettrooplist", 0, 1, 0, "", "", "", "");
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetTroopListRespV2 = new StringBuilder();
        paramGetTroopListRespV2.append("handle get troop list resp, delete troop,");
        paramGetTroopListRespV2.append(localStringBuilder.toString());
        QLog.d("TroopListHandler", 2, paramGetTroopListRespV2.toString());
      }
    }
    return localArrayList;
  }
  
  private void b(TroopInfo paramTroopInfo, List<stLevelRankPair> paramList)
  {
    if ((paramTroopInfo != null) && (paramList != null) && (paramList.size() > 0))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.putAll(paramTroopInfo.getNewTroopLevelMap());
      int i = 0;
      while (i < paramList.size())
      {
        stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
        localConcurrentHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
        i += 1;
      }
      paramTroopInfo.setNewTroopLevelMap(localConcurrentHashMap);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (paramObject != null)
      {
        a(paramFromServiceMsg, (GetMultiTroopInfoResp)paramObject);
        return;
      }
      notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, true, null);
      return;
    }
    notifyUI(TroopObserver.TYPE_GET_MULTI_TROOP_INFO, false, null);
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, a, false, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetMultiTroopInfoReq");
    localToServiceMsg.extraData.putSerializable("vecGroupCode", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void b()
  {
    ArrayList localArrayList1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 != null)
    {
      int i = 0;
      while (i < localArrayList1.size())
      {
        TroopInfo localTroopInfo = (TroopInfo)localArrayList1.get(i);
        if (localTroopInfo != null) {
          if (((IHotChatService)this.appRuntime.getRuntimeService(IHotChatService.class, "")).isHotChat(localTroopInfo.troopuin))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getTroopList.hotchat troopuin=");
              localStringBuilder.append(localTroopInfo.troopuin);
              QLog.d("Q.getTroopList", 2, localStringBuilder.toString());
            }
          }
          else {
            localArrayList2.add(localTroopInfo);
          }
        }
        i += 1;
      }
    }
    b(localArrayList2);
  }
  
  public void b(ArrayList<TroopInfo> paramArrayList)
  {
    this.f.clear();
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetTroopListReqV2");
    localToServiceMsg.setEnableFastResend(true);
    Object localObject1 = localToServiceMsg.extraData;
    int i = 0;
    ((Bundle)localObject1).putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    localToServiceMsg.extraData.putByte("bGetLongGroupName", (byte)1);
    this.e = true;
    localObject1 = new ArrayList();
    Object localObject2;
    if (paramArrayList != null)
    {
      this.g = paramArrayList;
      localObject2 = this.appRuntime.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.appRuntime.getAccount());
      localStringBuilder.append("load_trooplist");
      boolean bool = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("load_all_6", true);
      while (i < paramArrayList.size())
      {
        localObject2 = a((TroopInfo)paramArrayList.get(i), bool);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        i += 1;
      }
      if (!((ArrayList)localObject1).isEmpty()) {
        localToServiceMsg.extraData.putSerializable("vecGroupInfo", (Serializable)localObject1);
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayList.append(((stTroopNumSimplify)((Iterator)localObject2).next()).GroupCode);
        paramArrayList.append(";");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get troop list, cookie == null, request size: ");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      ((StringBuilder)localObject2).append(" request troop uins: ");
      ((StringBuilder)localObject2).append(paramArrayList.toString());
      QLog.d("TroopListHandler", 2, ((StringBuilder)localObject2).toString());
    }
    send(localToServiceMsg);
  }
  
  public boolean c()
  {
    return d;
  }
  
  protected String dv_()
  {
    return "TroopListHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("friendlist.GetTroopListReqV2");
      this.allowCmdSet.add("friendlist.GetMultiTroopInfoReq");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "onReceive,resp == null");
      }
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("TroopListHandler", 2, paramToServiceMsg.toString());
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
        QLog.d("TroopListHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ("friendlist.GetTroopListReqV2".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.GetMultiTroopInfoReq".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopListHandler
 * JD-Core Version:    0.7.0.1
 */