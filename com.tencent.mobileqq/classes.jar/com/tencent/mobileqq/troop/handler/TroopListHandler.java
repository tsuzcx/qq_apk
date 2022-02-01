package com.tencent.mobileqq.troop.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopListHandlerProcessorConfig;
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
  extends BusinessHandler
{
  public static int a;
  public static String a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static int b;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<TroopInfo> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GroupCodeZero";
    jdField_a_of_type_Int = 9101;
    jdField_b_of_type_Int = 9102;
  }
  
  public TroopListHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopListHandlerProcessorConfig.a();
  }
  
  private stTroopNumSimplify a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    stTroopNumSimplify localstTroopNumSimplify = new stTroopNumSimplify();
    for (;;)
    {
      try
      {
        localstTroopNumSimplify.GroupCode = Long.parseLong(paramTroopInfo.troopuin);
        localstTroopNumSimplify.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
        if (!paramBoolean)
        {
          localstTroopNumSimplify.dwGroupInfoSeq = paramTroopInfo.dwGroupInfoSeq;
          localstTroopNumSimplify.dwGroupRankSeq = paramTroopInfo.dwGroupLevelSeq;
          if (paramTroopInfo.mTroopInfoExtObj != null)
          {
            l = paramTroopInfo.mTroopInfoExtObj.groupInfoExtSeq;
            localstTroopNumSimplify.dwGroupInfoExtSeq = l;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopListHandler", 2, "dwGroupInfoSeq = " + localstTroopNumSimplify.dwGroupInfoSeq + ",dwGroupRankSeq = " + localstTroopNumSimplify.dwGroupRankSeq + ",dwGroupInfoExtSeq = " + localstTroopNumSimplify.dwGroupInfoExtSeq + ",loadAll = " + paramBoolean);
          }
          return localstTroopNumSimplify;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopListHandler", 2, "NumberFormatException,info.troopuin=" + paramTroopInfo.troopuin);
        }
        return null;
      }
      long l = 0L;
    }
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
        paramGetTroopListRespV2 = new StringBuilder().append("handle getTroopList resp->vecTroopRank,troopUin: ").append(localstGroupRankInfo.dwGroupCode).append(" ,sys flag: ").append(localstGroupRankInfo.cGroupRankSysFlag).append(" ,user flag: ").append(localstGroupRankInfo.cGroupRankUserFlag).append(" ,level seq: ").append(localstGroupRankInfo.dwGroupRankSeq).append(" ,level size: ");
        if (localstGroupRankInfo.vecRankMap != null) {}
        for (int i = localstGroupRankInfo.vecRankMap.size();; i = -1)
        {
          QLog.d("TroopListHandler", 2, i);
          break;
        }
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
      if (i < paramGetTroopListRespV2.vecTroopListExt.size())
      {
        stTroopNum localstTroopNum = (stTroopNum)paramGetTroopListRespV2.vecTroopListExt.get(i);
        String str = String.valueOf(localstTroopNum.GroupCode);
        if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {
          if (QLog.isColorLevel()) {
            QLog.e("TroopListHandler_ext", 2, "error troopuin: " + str);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(str);
          localStringBuilder.append("| troopItem.GroupUin: ").append(localstTroopNum.GroupUin).append(" troopItem.GroupCode: ").append(localstTroopNum.GroupCode);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("troop_ext", 2, "handleGetTroopList resp, ext troop:" + localStringBuilder.toString());
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
      if (!paramTroopInfo.Administrator.endsWith("|")) {}
    }
    for (paramTroopInfo.Administrator = paramTroopInfo.Administrator.substring(0, paramTroopInfo.Administrator.length() - 1); (paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L; paramTroopInfo.Administrator = "")
    {
      if (!paramTroopInfo.Administrator.contains(this.appRuntime.getAccount())) {
        paramTroopInfo.Administrator = (paramTroopInfo.Administrator + "|" + this.appRuntime.getAccount());
      }
      return;
    }
    paramTroopInfo.Administrator = paramTroopInfo.Administrator.replace(this.appRuntime.getAccount() + "|", "").replace("|" + this.appRuntime.getAccount(), "").replace(this.appRuntime.getAccount(), "");
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
    int j = 0;
    if (paramGetMultiTroopInfoResp == null)
    {
      notifyUI(TroopNotificationConstants.c, false, null);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopNotificationConstants.c, false, null);
      return;
    }
    if (paramGetMultiTroopInfoResp.result != 0)
    {
      notifyUI(TroopNotificationConstants.c, false, null);
      return;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    int i = j;
    if (paramGetMultiTroopInfoResp.vecTroopInfo != null)
    {
      i = j;
      if (paramGetMultiTroopInfoResp.vecTroopInfo.size() > 0)
      {
        Iterator localIterator = paramGetMultiTroopInfoResp.vecTroopInfo.iterator();
        i = 0;
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
            QLog.d("refreshTroopList", 2, "handleMultiTroopInfo save troop " + paramFromServiceMsg.troopuin + " troopcode:" + paramFromServiceMsg.troopcode);
            i = j;
          }
        }
        localITroopInfoService.saveTroops(localArrayList, l);
      }
    }
    if (i != 0) {
      a(jdField_b_of_type_Int);
    }
    notifyUI(TroopNotificationConstants.c, true, localArrayList);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null))
    {
      int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "k_resend_cnt" + i);
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
      notifyUI(TroopNotificationConstants.jdField_b_of_type_Int, false, null);
      return;
    }
    paramFromServiceMsg = (GetTroopListRespV2)paramObject;
    if ((paramFromServiceMsg.result == 1) || ((paramFromServiceMsg.vecTroopList == null) && (paramFromServiceMsg.vecTroopListDel == null)))
    {
      notifyUI(TroopNotificationConstants.jdField_b_of_type_Int, false, null);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    int j = -1;
    if (paramGetTroopListRespV2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "handle get troop list resp, resp == null");
      }
      notifyUI(TroopNotificationConstants.jdField_b_of_type_Int, false, null);
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handle get troop list resp, changeNum: ");
      if (paramGetTroopListRespV2.vecTroopList != null)
      {
        i = paramGetTroopListRespV2.vecTroopList.size();
        localObject = ((StringBuilder)localObject).append(i).append(" deleteNum: ");
        if (paramGetTroopListRespV2.vecTroopListDel == null) {
          break label269;
        }
        i = paramGetTroopListRespV2.vecTroopListDel.size();
        label97:
        localObject = ((StringBuilder)localObject).append(i).append(" LevelInfoNum: ");
        if (paramGetTroopListRespV2.vecTroopRank == null) {
          break label274;
        }
        i = paramGetTroopListRespV2.vecTroopRank.size();
        label126:
        localObject = ((StringBuilder)localObject).append(i).append(" FavGroupNum: ");
        if (paramGetTroopListRespV2.vecFavGroup == null) {
          break label279;
        }
        i = paramGetTroopListRespV2.vecFavGroup.size();
        label155:
        localObject = ((StringBuilder)localObject).append(i).append(" extNum: ");
        i = j;
        if (paramGetTroopListRespV2.vecTroopListExt != null) {
          i = paramGetTroopListRespV2.vecTroopListExt.size();
        }
        QLog.d("TroopListHandler", 2, i);
      }
    }
    else
    {
      if ((paramGetTroopListRespV2.vecTroopList != null) || (paramGetTroopListRespV2.vecTroopListDel != null) || (paramGetTroopListRespV2.vecTroopRank != null) || (paramGetTroopListRespV2.vecFavGroup != null)) {
        break label290;
      }
      i = TroopNotificationConstants.jdField_b_of_type_Int;
      if (paramGetTroopListRespV2.errorCode != 0) {
        break label284;
      }
    }
    label269:
    label274:
    label279:
    label284:
    for (boolean bool = true;; bool = false)
    {
      notifyUI(i, bool, null);
      jdField_a_of_type_Boolean = true;
      TroopListHandlerProcessorConfig.a(this.appRuntime);
      return;
      i = -1;
      break;
      i = -1;
      break label97;
      i = -1;
      break label126;
      i = -1;
      break label155;
    }
    label290:
    if (paramGetTroopListRespV2.errorCode == 2001)
    {
      a(this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
    Object localObject = new ArrayList();
    long l = System.currentTimeMillis();
    try
    {
      a(paramToServiceMsg, paramGetTroopListRespV2, (ArrayList)localObject, l, false);
      if ((paramGetTroopListRespV2.vecCookies != null) && (paramGetTroopListRespV2.vecCookies.length > 0))
      {
        a(paramGetTroopListRespV2.vecCookies);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      do
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("TroopListHandler", 2, QLog.getStackTraceString(paramToServiceMsg));
        }
      } while (0 == 0);
      throw new NullPointerException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ((TroopMemberInfoHandler)this.appRuntime.getBusinessHandler(TroopMemberInfoHandler.class.getName())).a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).refreshCommonlyUsedTroop();
    this.appRuntime.getApplicationContext().getSharedPreferences(this.appRuntime.getAccount() + "load_trooplist", 0).edit().putBoolean("load_all_4", false).commit();
    if (QLog.isColorLevel()) {
      QLog.i("TroopListHandler", 2, "notifyUI(TYPE_GET_TROOP_LIST");
    }
    notifyUI(TroopNotificationConstants.jdField_b_of_type_Int, true, null);
    jdField_a_of_type_Boolean = true;
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
    boolean bool = paramBoolean;
    if (paramGetTroopListRespV2.vecTroopList != null)
    {
      localObject = new ArrayList();
      HashMap localHashMap = new HashMap();
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, new Object[] { "vecTroopList.size():", Integer.valueOf(paramGetTroopListRespV2.vecTroopList.size()) });
      }
      paramBoolean = a(paramToServiceMsg, paramGetTroopListRespV2, paramArrayList, paramLong, paramBoolean, localITroopInfoService, (List)localObject, localHashMap);
      localITroopInfoService.addTroops((List)localObject);
      if (localHashMap.size() > 0) {
        TroopListHandlerProcessorConfig.a(this.appRuntime, localHashMap);
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopListHandler", 2, new Object[] { "handle get troop list hidden:", Integer.valueOf(localHashMap.size()) });
        bool = paramBoolean;
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
    if (bool) {
      a(jdField_a_of_type_Int);
    }
  }
  
  private void a(GetTroopListRespV2 paramGetTroopListRespV2, ITroopInfoService paramITroopInfoService)
  {
    if ((paramGetTroopListRespV2.vecFavGroup != null) && (this.jdField_b_of_type_Boolean))
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
    this.jdField_b_of_type_Boolean = false;
    localToServiceMsg.extraData.putByteArray("vecCookies", paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListHandler", 2, "get troop list, cookie != null");
    }
    send(localToServiceMsg);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2, ArrayList<Long> paramArrayList, long paramLong, boolean paramBoolean, ITroopInfoService paramITroopInfoService, List<TroopInfo> paramList, Map<String, Boolean> paramMap)
  {
    int i = 0;
    if (i < paramGetTroopListRespV2.vecTroopList.size())
    {
      stTroopNum localstTroopNum = (stTroopNum)paramGetTroopListRespV2.vecTroopList.get(i);
      TroopInfo localTroopInfo = paramITroopInfoService.findTroopInfo(String.valueOf(localstTroopNum.GroupCode));
      Object localObject = String.valueOf(localstTroopNum.GroupCode);
      int j;
      label64:
      boolean bool;
      if (localTroopInfo == null)
      {
        j = 1;
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
        if (localTroopInfo.cmdUinFlagEx2 != localstTroopNum.udwCmdUinFlagEx2)
        {
          if (TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512) == TroopInfo.isCmdUinFlagEx2Open(localstTroopNum.udwCmdUinFlagEx2, 512)) {
            break label1322;
          }
          bool = true;
          label284:
          localTroopInfo.cmdUinFlagEx2 = localstTroopNum.udwCmdUinFlagEx2;
          if (bool) {
            paramMap.put(localTroopInfo.troopuin, Boolean.valueOf(TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512)));
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopListHandler", 2, new Object[] { "change:", Boolean.valueOf(bool), " troop:", localTroopInfo.troopuin });
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
        if ((localstTroopNum.dwGroupFlag & 0x80) != 128L) {
          break label1328;
        }
        bool = true;
        label677:
        localTroopInfo.isTroopBlocked = bool;
        localTroopInfo.appealDeadline = localstTroopNum.dwAppealDeadline;
        localTroopInfo.dwGroupFlagExt3 = localstTroopNum.dwGroupFlagExt3;
        if (QLog.isColorLevel()) {
          QLog.i("TroopListHandler", 2, "handleTroopList troopUin:" + localTroopInfo.troopuin + " dwGroupFlagExt3:" + localTroopInfo.dwGroupFlagExt3 + " isListenTogetherOpen: " + localTroopInfo.isListenTogetherOpen() + ", isAVGameOpen: " + localTroopInfo.isAVGameOpen() + ", isTroopHonorOpen: " + localTroopInfo.isTroopHonorOpen());
        }
        localTroopInfo.groupFlagExt4 = ((int)localstTroopNum.dwGroupFlagExt4);
        if (localstTroopNum.cIsConfGroup != 1) {
          break label1334;
        }
        bool = true;
        label819:
        localTroopInfo.isNewTroop = bool;
        if (localstTroopNum.cIsModifyConfGroupFace != 1) {
          break label1340;
        }
        bool = true;
        label838:
        localTroopInfo.hasSetNewTroopHead = bool;
        if (localstTroopNum.cIsModifyConfGroupName != 1) {
          break label1346;
        }
        bool = true;
        label857:
        localTroopInfo.hasSetNewTroopName = bool;
        localTroopInfo.wMemberMax = ((int)localstTroopNum.dwMaxGroupMemberNum);
        localTroopInfo.eliminated = 0;
        if ((QLog.isColorLevel()) && (localTroopInfo.isQidianPrivateTroop())) {
          QLog.d(".troop.qidian_private_troop", 2, "handleTroopList, vecTroopList privateTroop troopUin=" + localTroopInfo.troopuin);
        }
        localTroopInfo.hlGuildAppid = localstTroopNum.udwHLGuildAppid;
        localTroopInfo.hlGuildSubType = localstTroopNum.udwHLGuildSubType;
        if (QLog.isColorLevel()) {
          QLog.d(".troop.kingteam_troop", 2, "[handleTroopList], appID:" + localTroopInfo.hlGuildAppid + ",subType:" + localTroopInfo.hlGuildSubType);
        }
        if (localstTroopNum.vecGroupRemark == null) {
          break label1352;
        }
        localTroopInfo.troopRemark = new String(localstTroopNum.vecGroupRemark);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.kingteam_troop", 2, "[handleTroopList], troopRemark length : " + localstTroopNum.vecGroupRemark.length);
        }
        label1060:
        paramList.add(localTroopInfo);
        if ((localTroopInfo.troopcode != null) && (!localTroopInfo.troopcode.equals("0"))) {
          break label1363;
        }
        paramBoolean = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopListHandler", 2, "handle get troop list resp, save troop, troopUin: " + localstTroopNum.GroupUin + " troopCode: " + localstTroopNum.GroupCode + ", cLevel:" + localTroopInfo.troopCreditLevel + ", cInfo:" + localTroopInfo.troopCreditLevelInfo + ", info.wMemberNum:" + localTroopInfo.wMemberNum + ", info.mMemberNumSeq" + localTroopInfo.mMemberNumSeq + ", info.mMemberCardSeq:" + localTroopInfo.mMemberCardSeq + ",strGroupName = " + localstTroopNum.strGroupName);
        }
        localObject = paramITroopInfoService.getTroopMemberForTroopHead(localTroopInfo.troopuin);
        if ((!localTroopInfo.hasSetTroopHead()) && ((((ArrayList)localObject).size() == 0) || ((((ArrayList)localObject).size() < 4) && (localTroopInfo.mMemberNumSeq != localTroopInfo.mOldMemberNumSeq)))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localstTroopNum.GroupCode));
        }
        TroopListHandlerProcessorConfig.a(this.appRuntime, localTroopInfo);
        i += 1;
        break;
        j = 0;
        break label64;
        label1322:
        bool = false;
        break label284;
        label1328:
        bool = false;
        break label677;
        label1334:
        bool = false;
        break label819;
        label1340:
        bool = false;
        break label838;
        label1346:
        bool = false;
        break label857;
        label1352:
        localTroopInfo.troopRemark = "";
        break label1060;
        label1363:
        paramArrayList.add(Long.valueOf(localstTroopNum.GroupCode));
      }
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
      if (i < paramGetTroopListRespV2.vecTroopListDel.size())
      {
        stTroopNum localstTroopNum = (stTroopNum)paramGetTroopListRespV2.vecTroopListDel.get(i);
        String str = String.valueOf(localstTroopNum.GroupCode);
        if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopListHandler", 2, "error troopuin: " + str);
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettrooplist", 0, 1, 0, "", "", "", "");
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(str);
          localStringBuilder.append("| troopItem.GroupUin: ").append(localstTroopNum.GroupUin).append(" troopItem.GroupCode: ").append(localstTroopNum.GroupCode);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "handle get troop list resp, delete troop," + localStringBuilder.toString());
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
      notifyUI(TroopNotificationConstants.c, true, null);
      return;
    }
    notifyUI(TroopNotificationConstants.c, false, null);
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, jdField_a_of_type_JavaLangString, false, 0L, 0L, localHashMap, "");
  }
  
  public void a(ArrayList<TroopInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetTroopListReqV2");
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.extraData.putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    localToServiceMsg.extraData.putByte("bGetLongGroupName", (byte)1);
    this.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramArrayList != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      boolean bool = this.appRuntime.getApplicationContext().getSharedPreferences(this.appRuntime.getAccount() + "load_trooplist", 0).getBoolean("load_all_4", true);
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = a((TroopInfo)paramArrayList.get(i), bool);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (!localArrayList.isEmpty()) {
        localToServiceMsg.extraData.putSerializable("vecGroupInfo", localArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.append(((stTroopNumSimplify)((Iterator)localObject).next()).GroupCode).append(";");
      }
      QLog.d("TroopListHandler", 2, "get troop list, cookie == null, request size: " + localArrayList.size() + " request troop uins: " + paramArrayList.toString());
    }
    send(localToServiceMsg);
  }
  
  public void b(ArrayList<Long> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetMultiTroopInfoReq");
    localToServiceMsg.extraData.putSerializable("vecGroupCode", paramArrayList);
    send(localToServiceMsg);
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopListHandler", 2, "onReceive,resp == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopListHandler", 2, "cmdfilter error=" + str);
      return;
      if ("friendlist.GetTroopListReqV2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"friendlist.GetMultiTroopInfoReq".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopListHandler
 * JD-Core Version:    0.7.0.1
 */