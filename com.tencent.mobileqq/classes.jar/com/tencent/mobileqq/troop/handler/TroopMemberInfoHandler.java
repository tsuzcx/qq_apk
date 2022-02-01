package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.troop.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard.StoryInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.config.TroopMemberInfoHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopMemberListResp;
import friendlist.ModifyGroupCardResp;
import friendlist.QzoneUserInfo;
import friendlist.stTroopMemberInfo;
import friendlist.stUinInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group.group_member_info.CustomEntry;
import tencent.im.group.group_member_info.GBarInfo;
import tencent.im.group.group_member_info.InfoCardVideoInfo;
import tencent.im.group.group_member_info.MemberGameInfo;
import tencent.im.group.group_member_info.MemberInfo;
import tencent.im.group.group_member_info.ReqBody;
import tencent.im.group.group_member_info.RspBody;
import tencent.im.group.group_member_info.RspGroupCardGetStory;
import tencent.im.group.group_member_info.TeamEntry;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.GroupMember;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.ReqBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopMemberInfoHandler
  extends BusinessHandler
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected Set<String> a;
  private HashMap<String, ArrayList<stTroopMemberInfo>> b = null;
  
  public TroopMemberInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopMemberInfoHandlerProcessorConfig.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return 1;
      int i = 1;
      while (i < 32)
      {
        if (paramInt >> i == 0) {
          return 1 + i;
        }
        i += 1;
      }
    }
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, "data error");
      }
    }
    for (;;)
    {
      return 0;
      try
      {
        troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
        localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
        if (localGroupUserCardHonor.level.has())
        {
          int i = localGroupUserCardHonor.level.get();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberInfoHandler", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
    return 0;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  private List<TroopMemberInfo> a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return null;
    }
    long l3 = System.currentTimeMillis();
    Object localObject1 = paramString + "_" + paramLong;
    try
    {
      if ((this.b == null) || (!this.b.containsKey(localObject1))) {
        return null;
      }
    }
    finally {}
    Object localObject3 = (ArrayList)this.b.remove(localObject1);
    if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ArrayList)localObject3).iterator();
        if (!localIterator.hasNext()) {
          break label490;
        }
        stTroopMemberInfo localstTroopMemberInfo = (stTroopMemberInfo)localIterator.next();
        long l2 = localstTroopMemberInfo.MemberUin;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = localstTroopMemberInfo.MemberUin + 4294967296L;
        }
        String str = String.valueOf(l1);
        localObject1 = localEntityManager.query(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label753;
        }
        localObject1 = (TroopMemberInfo)((List)localObject1).get(0);
        if (localObject1 == null)
        {
          localObject1 = a(paramString, paramLong, localEntityManager, localstTroopMemberInfo, str);
          localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, str);
          if (localObject2 != null) {
            break label750;
          }
          localObject2 = new TroopMemberCardInfo();
          ((TroopMemberCardInfo)localObject2).troopuin = paramString;
          ((TroopMemberCardInfo)localObject2).memberuin = str;
          ((TroopMemberCardInfo)localObject2).nick = localstTroopMemberInfo.Nick;
          ((TroopMemberCardInfo)localObject2).name = TroopMemberInfoHandlerProcessorConfig.a(localstTroopMemberInfo.vecName);
          ((TroopMemberCardInfo)localObject2).sex = localstTroopMemberInfo.cGender;
          ((TroopMemberCardInfo)localObject2).tel = localstTroopMemberInfo.sPhone;
          ((TroopMemberCardInfo)localObject2).email = localstTroopMemberInfo.sEmail;
          ((TroopMemberCardInfo)localObject2).memo = localstTroopMemberInfo.sMemo;
          ((TroopMemberCardInfo)localObject2).job = localstTroopMemberInfo.bytes_job;
          ((TroopMemberCardInfo)localObject2).mVipType = ((int)localstTroopMemberInfo.dwVipType);
          ((TroopMemberCardInfo)localObject2).mVipLevel = a((int)localstTroopMemberInfo.dwVipLevel);
          ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).saveTroopMemberCardInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (TroopMemberCardInfo)localObject2);
          localArrayList.add(localObject1);
          continue;
        }
        a(paramLong, localEntityManager, localstTroopMemberInfo, (TroopMemberInfo)localObject1);
      }
      finally
      {
        localEntityManager.close();
        localEntityTransaction.end();
      }
      continue;
      label490:
      localEntityTransaction.commit();
      localEntityManager.close();
      localEntityTransaction.end();
      TroopMemberInfoHandlerProcessorConfig.a(this.appRuntime, (ArrayList)localObject3);
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "processDataInRsp2TroopMemberList, Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", cost:" + (paramLong - l3));
      }
      localObject1 = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      paramString = ((ITroopInfoService)localObject1).findTroopInfo(paramString);
      Object localObject2 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (stTroopMemberInfo)((Iterator)localObject2).next();
        paramLong = ((stTroopMemberInfo)localObject3).MemberUin;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount().equals(String.valueOf(paramLong)))) {
          if ((((stTroopMemberInfo)localObject3).vecGroupHonor != null) && (paramString != null))
          {
            TroopMemberInfoHandlerProcessorConfig.a(paramString, (stTroopMemberInfo)localObject3);
            ((ITroopInfoService)localObject1).saveTroopInfo(paramString);
            if ((QLog.isColorLevel()) && (((stTroopMemberInfo)localObject3).cRichFlag != 0)) {
              QLog.d("TroopHonor", 2, "honor_rich_friend_me," + ((stTroopMemberInfo)localObject3).cRichFlag);
            }
          }
        }
      }
      return localArrayList;
      label750:
      continue;
      label753:
      localObject1 = null;
    }
  }
  
  private void a(long paramLong, TroopMemberCard paramTroopMemberCard)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    String str;
    Object localObject;
    boolean bool1;
    boolean bool2;
    if ((localITroopInfoService != null) && (localITroopMemberInfoService != null))
    {
      i = -100;
      if (paramTroopMemberCard.titleId > 0) {
        i = paramTroopMemberCard.titleId;
      }
      if (paramTroopMemberCard.mUniqueTitle == null) {
        paramTroopMemberCard.mUniqueTitle = "";
      }
      str = String.valueOf(paramTroopMemberCard.memberUin);
      localObject = localITroopInfoService.getTroopInfo(String.valueOf(paramLong));
      if ((paramTroopMemberCard.memberRole == 3) && (localObject != null) && (paramTroopMemberCard.memberUin != 0L) && (!str.equals(((TroopInfo)localObject).troopowneruin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_troop_member", 2, "handleGetTroopMemberCard change troopOwner:" + paramLong + ", oldOwner=" + ((TroopInfo)localObject).troopowneruin + ", newOwner=" + str);
        }
        ((TroopInfo)localObject).troopowneruin = str;
        localITroopInfoService.saveTroopInfo((TroopInfo)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "handleGetTroopMemberCard memberRole:" + paramTroopMemberCard.memberRole + ",memberUin: " + str);
      }
      if (paramTroopMemberCard.memberRole != 0)
      {
        TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(String.valueOf(paramLong), str);
        bool1 = false;
        localObject = localTroopMemberInfo;
        if (localTroopMemberInfo == null)
        {
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).troopuin = String.valueOf(paramLong);
          ((TroopMemberInfo)localObject).memberuin = str;
          ((TroopMemberInfo)localObject).isTroopFollowed = false;
          bool1 = true;
        }
        bool2 = a(paramTroopMemberCard, (TroopMemberInfo)localObject, bool1);
        bool1 = a(paramTroopMemberCard, i, (TroopMemberInfo)localObject, bool2);
        if ((paramTroopMemberCard.honorList == null) || ((paramTroopMemberCard.honorList.equals(((TroopMemberInfo)localObject).honorList)) && (paramTroopMemberCard.honorRichTag == ((TroopMemberInfo)localObject).mHonorRichFlag))) {
          break label525;
        }
        ((TroopMemberInfo)localObject).honorList = paramTroopMemberCard.honorList;
        ((TroopMemberInfo)localObject).mHonorRichFlag = paramTroopMemberCard.honorRichTag;
        bool1 = true;
      }
    }
    label525:
    for (int i = 1;; i = 0)
    {
      if (bool1) {
        localITroopMemberInfoService.saveTroopMember((TroopMemberInfo)localObject, bool2);
      }
      if ((i != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount().equals(str)))
      {
        paramTroopMemberCard = localITroopInfoService.getTroopInfo(((TroopMemberInfo)localObject).troopuin);
        if ((paramTroopMemberCard != null) && ((!((TroopMemberInfo)localObject).honorList.equals(paramTroopMemberCard.myHonorList)) || (((TroopMemberInfo)localObject).mHonorRichFlag != paramTroopMemberCard.myHonorRichFlag)))
        {
          paramTroopMemberCard.myHonorList = ((TroopMemberInfo)localObject).honorList;
          paramTroopMemberCard.myHonorRichFlag = ((TroopMemberInfo)localObject).mHonorRichFlag;
          localITroopInfoService.saveTroopInfo(paramTroopMemberCard);
        }
      }
      return;
    }
  }
  
  private void a(long paramLong, TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.msg_team_entry.has())
    {
      paramTroopMemberCard.mOrgIds.clear();
      Object localObject = ((group_member_info.TeamEntry)paramMemberInfo.msg_team_entry.get()).rpt_uint64_depid.get().iterator();
      long l;
      while (((Iterator)localObject).hasNext())
      {
        l = ((Long)((Iterator)localObject).next()).longValue();
        String str = "" + paramLong + l;
        if (!paramTroopMemberCard.mOrgIds.contains(str)) {
          paramTroopMemberCard.mOrgIds.add(str);
        }
      }
      paramTroopMemberCard.mCurrAccountOrgIds.clear();
      paramMemberInfo = ((group_member_info.TeamEntry)paramMemberInfo.msg_team_entry.get()).rpt_uint64_self_depid.get().iterator();
      while (paramMemberInfo.hasNext())
      {
        l = ((Long)paramMemberInfo.next()).longValue();
        localObject = "" + paramLong + l;
        if (!paramTroopMemberCard.mCurrAccountOrgIds.contains(localObject)) {
          paramTroopMemberCard.mCurrAccountOrgIds.add(localObject);
        }
      }
    }
  }
  
  private void a(long paramLong, EntityManager paramEntityManager, stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = true;
    a(paramstTroopMemberInfo, paramTroopMemberInfo);
    b(paramstTroopMemberInfo, paramTroopMemberInfo);
    paramTroopMemberInfo.autoremark = paramstTroopMemberInfo.strAutoRemark;
    paramTroopMemberInfo.faceid = paramstTroopMemberInfo.FaceId;
    paramTroopMemberInfo.sex = paramstTroopMemberInfo.Gender;
    paramTroopMemberInfo.status = paramstTroopMemberInfo.Status;
    paramTroopMemberInfo.age = paramstTroopMemberInfo.Age;
    paramTroopMemberInfo.alias = paramstTroopMemberInfo.sShowName;
    paramTroopMemberInfo.datetime = paramLong;
    paramTroopMemberInfo.mVipType = ((int)paramstTroopMemberInfo.dwVipType);
    paramTroopMemberInfo.mVipLevel = a((int)paramstTroopMemberInfo.dwVipLevel);
    paramTroopMemberInfo.mBigClubVipType = ((int)paramstTroopMemberInfo.dwBigClubFlag);
    paramTroopMemberInfo.mBigClubVipLevel = ((int)paramstTroopMemberInfo.dwBigClubLevel);
    paramTroopMemberInfo.mBigClubTemplateId = ((int)paramstTroopMemberInfo.dwNameplate);
    paramTroopMemberInfo.realLevel = ((int)paramstTroopMemberInfo.dwMemberLevel);
    paramTroopMemberInfo.newRealLevel = a(paramstTroopMemberInfo.vecGroupHonor);
    if (paramstTroopMemberInfo.dwTitleId > 0L) {
      paramTroopMemberInfo.level = ((int)paramstTroopMemberInfo.dwTitleId);
    }
    paramTroopMemberInfo.join_time = paramstTroopMemberInfo.dwJoinTime;
    paramTroopMemberInfo.last_active_time = paramstTroopMemberInfo.dwLastSpeakTime;
    paramTroopMemberInfo.active_point = paramstTroopMemberInfo.dwPoint;
    paramTroopMemberInfo.credit_level = paramstTroopMemberInfo.dwCreditLevel;
    if (paramstTroopMemberInfo.cConcerned == 1)
    {
      bool1 = true;
      paramTroopMemberInfo.isTroopFollowed = bool1;
      if (paramstTroopMemberInfo.cShielded != 1) {
        break label431;
      }
    }
    label431:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramTroopMemberInfo.mIsShielded = bool1;
      if ((paramstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (paramstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
      {
        paramTroopMemberInfo.mUniqueTitle = paramstTroopMemberInfo.sSpecialTitle;
        paramTroopMemberInfo.mUniqueTitleExpire = ((int)paramstTroopMemberInfo.dwSpecialTitleExpireTime);
      }
      paramTroopMemberInfo.globalTroopLevel = ((int)paramstTroopMemberInfo.dwGlobalGroupLevel);
      if (paramstTroopMemberInfo.qzusrinfo != null) {
        paramTroopMemberInfo.isShowQZone = paramstTroopMemberInfo.qzusrinfo.eStarState;
      }
      if (paramstTroopMemberInfo.vecGroupHonor != null) {
        TroopMemberInfoHandlerProcessorConfig.a(paramTroopMemberInfo, paramstTroopMemberInfo);
      }
      paramTroopMemberInfo.mHonorRichFlag = paramstTroopMemberInfo.cRichFlag;
      if ((QLog.isColorLevel()) && (paramstTroopMemberInfo.cRichFlag != 0)) {
        QLog.d("TroopHonor", 2, "honor_rich_friend," + paramstTroopMemberInfo.cRichFlag);
      }
      paramEntityManager.update(paramTroopMemberInfo);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.uint32_concern_type.has())
    {
      int i = paramMemberInfo.uint32_concern_type.get();
      if (i == 0)
      {
        paramTroopMemberCard.isConcerned = false;
        paramTroopMemberCard.mIsShield = false;
      }
      do
      {
        return;
        if (i == 1)
        {
          paramTroopMemberCard.isConcerned = true;
          paramTroopMemberCard.mIsShield = false;
          return;
        }
      } while (i != 2);
      paramTroopMemberCard.isConcerned = false;
      paramTroopMemberCard.mIsShield = true;
      return;
    }
    paramTroopMemberCard.isConcerned = paramMemberInfo.bool_is_concerned.get();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetTroopAppointRemarkResp paramGetTroopAppointRemarkResp)
  {
    if (paramFromServiceMsg == null) {
      notifyUI(TroopNotificationConstants.k, false, null);
    }
    do
    {
      do
      {
        return;
      } while (paramGetTroopAppointRemarkResp == null);
      try
      {
        if (paramGetTroopAppointRemarkResp.result != 0)
        {
          notifyUI(TroopNotificationConstants.k, false, null);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        notifyUI(TroopNotificationConstants.k, false, null);
        return;
      }
      paramFromServiceMsg = paramGetTroopAppointRemarkResp.vecTroopRemark;
    } while (paramFromServiceMsg == null);
    paramGetTroopAppointRemarkResp = TroopMemberInfoHandlerProcessorConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramGetTroopAppointRemarkResp.GroupCode), paramFromServiceMsg);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("bRet = ");
      if ((paramGetTroopAppointRemarkResp == null) || (paramGetTroopAppointRemarkResp.length <= 1)) {
        break label134;
      }
    }
    label134:
    for (paramFromServiceMsg = paramGetTroopAppointRemarkResp[1];; paramFromServiceMsg = "null")
    {
      QLog.d("handlerGetTroopMemberCardInfoList", 2, paramFromServiceMsg);
      notifyUI(TroopNotificationConstants.k, true, paramGetTroopAppointRemarkResp);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopMemberListResp paramGetTroopMemberListResp)
  {
    String str1 = a(paramToServiceMsg.extraData.getLong("troop_uin"));
    long l1 = paramToServiceMsg.extraData.getLong("troop_time");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needCallBackCache");
    int i = paramToServiceMsg.extraData.getInt("reqType", 0);
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    int j = paramToServiceMsg.extraData.getInt("type", 0);
    String str2 = str1 + "_" + i;
    long l3;
    Object localObject2;
    Object localObject1;
    if (paramGetTroopMemberListResp != null)
    {
      if (paramGetTroopMemberListResp.NextGetTime != 0L) {
        this.jdField_a_of_type_JavaUtilHashMap.put(str2, Long.valueOf(paramGetTroopMemberListResp.NextGetTime));
      }
      l3 = paramGetTroopMemberListResp.GroupUin;
      paramGetTroopMemberListResp.GroupUin = paramGetTroopMemberListResp.GroupCode;
      paramGetTroopMemberListResp.GroupCode = l3;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, "req troopUin:" + str1 + "| resp.GroupUin:" + paramGetTroopMemberListResp.GroupUin + "|resp.GroupCode:" + paramGetTroopMemberListResp.GroupCode);
      }
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      localObject2 = localITroopInfoService.findTroopInfo(str1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = str1;
      }
      ((TroopInfo)localObject1).dwOfficeMode = paramGetTroopMemberListResp.office_mode;
      localITroopInfoService.saveTroopInfo((TroopInfo)localObject1);
      if (paramGetTroopMemberListResp.result != 0) {
        break label972;
      }
    }
    for (;;)
    {
      try
      {
        if (this.b == null) {
          this.b = new HashMap();
        }
        localObject2 = str1 + "_" + l1;
        if (this.b.containsKey(localObject2))
        {
          ((ArrayList)this.b.get(localObject2)).addAll(paramGetTroopMemberListResp.vecTroopMember);
          paramGetTroopMemberListResp.vecTroopMember.size();
          if (paramGetTroopMemberListResp.NextUin == 0L) {
            break label783;
          }
          paramToServiceMsg.extraData.putBoolean("force_refresh", true);
          paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopMemberListResp.NextUin);
          paramToServiceMsg.extraData.putLong("troop_time", l1);
          paramToServiceMsg.extraData.putInt("reqType", i);
          paramToServiceMsg.extraData.putLong("timestamp", l2);
          paramToServiceMsg.extraData.putInt("type", j);
          localObject1 = new UniPacket(true);
          ((UniPacket)localObject1).setEncodeName("utf-8");
          if (a(paramToServiceMsg, (UniPacket)localObject1))
          {
            paramToServiceMsg.setServiceName("mobileqq.service");
            paramToServiceMsg.setRequestSsoSeq(((UniPacket)localObject1).getRequestId());
            paramToServiceMsg.putWupBuffer(((UniPacket)localObject1).encode());
            send(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("get_troop_member", 2, "FriendListHandler.handleGetTroopMemberList, request the next page data");
            }
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder().append("FriendListHandler.handleGetTroopMemberList, resp.result: ").append(paramGetTroopMemberListResp.result).append(" member count: ").append(paramGetTroopMemberListResp.vecTroopMember.size()).append("|reqType:").append(i).append("|memberListNextReqTime:");
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
                break label1041;
              }
              l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).longValue();
              QLog.d("get_troop_member.troop.req_troop_mem_list_optimize", 2, l1 + "|troopUin:" + str1);
            }
          }
        }
        else
        {
          this.b.put(localObject2, paramGetTroopMemberListResp.vecTroopMember);
          continue;
        }
        if (!bool) {
          break label734;
        }
      }
      finally {}
      paramToServiceMsg = new Object[5];
      paramToServiceMsg[0] = str1;
      paramToServiceMsg[1] = a(str1, l1);
      paramToServiceMsg[2] = Integer.valueOf(i);
      paramToServiceMsg[3] = Long.valueOf(l2);
      paramToServiceMsg[4] = Integer.valueOf(j);
      for (;;)
      {
        notifyUI(TroopNotificationConstants.e, false, paramToServiceMsg);
        break;
        label734:
        a(str1, l1);
        paramToServiceMsg = new Object[5];
        paramToServiceMsg[0] = str1;
        paramToServiceMsg[1] = null;
        paramToServiceMsg[2] = Integer.valueOf(i);
        paramToServiceMsg[3] = Long.valueOf(l2);
        paramToServiceMsg[4] = Integer.valueOf(j);
      }
      label783:
      l3 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "netWorkCost:" + (l3 - l1));
      }
      if (bool)
      {
        paramToServiceMsg = a(str1, l1);
        notifyUI(TroopNotificationConstants.e, true, new Object[] { str1, paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) });
        ThreadManager.post(new TroopMemberInfoHandler.1(this, str1, l1, (TroopInfo)localObject1), 5, null, false);
      }
      else
      {
        a(str1, l1);
        a(str1, l1, (TroopInfo)localObject1);
        notifyUI(TroopNotificationConstants.e, true, new Object[] { str1, null, Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) });
        continue;
        label972:
        int k = TroopNotificationConstants.e;
        if (paramGetTroopMemberListResp.result == 2) {}
        for (bool = true;; bool = false)
        {
          notifyUI(k, bool, new Object[] { str1, null, Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) });
          break;
        }
        label1041:
        l1 = 0L;
      }
    }
  }
  
  private void a(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    if (TextUtils.isEmpty(paramstTroopMemberInfo.Nick))
    {
      paramTroopMemberInfo.pyFirst_friendnick = "";
      paramTroopMemberInfo.pyAll_friendnick = "";
    }
    for (;;)
    {
      paramTroopMemberInfo.friendnick = paramstTroopMemberInfo.Nick;
      TroopMemberInfoHandlerProcessorConfig.a(paramstTroopMemberInfo, paramTroopMemberInfo);
      TroopMemberInfoHandlerProcessorConfig.b(paramstTroopMemberInfo, paramTroopMemberInfo);
      return;
      if (!paramstTroopMemberInfo.Nick.equals(paramTroopMemberInfo.friendnick))
      {
        paramTroopMemberInfo.pyFirst_friendnick = ChnToSpell.a(paramstTroopMemberInfo.Nick, 2);
        paramTroopMemberInfo.pyAll_friendnick = ChnToSpell.a(paramstTroopMemberInfo.Nick, 1);
      }
      else
      {
        if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_friendnick)) {
          paramTroopMemberInfo.pyFirst_friendnick = ChnToSpell.a(paramstTroopMemberInfo.Nick, 2);
        }
        if (TextUtils.isEmpty(paramTroopMemberInfo.pyAll_friendnick)) {
          paramTroopMemberInfo.pyAll_friendnick = ChnToSpell.a(paramstTroopMemberInfo.Nick, 1);
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    TroopMemberInfoHandlerProcessorConfig.a(this.appRuntime, paramString, paramLong);
    if (paramTroopInfo == null) {}
    ITroopNameHelperService localITroopNameHelperService;
    do
    {
      return;
      if ((paramTroopInfo.mOldMemberNumSeq != paramTroopInfo.mMemberNumSeq) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq))
      {
        paramTroopInfo.mOldMemberNumSeq = paramTroopInfo.mMemberNumSeq;
        paramTroopInfo.mOldMemberCardSeq = paramTroopInfo.mMemberCardSeq;
        ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
      }
      ((ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).updateTroopMemberCache(paramString);
      localITroopNameHelperService = (ITroopNameHelperService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNameHelperService.class, "");
    } while ((localITroopNameHelperService.isInReturnTaskList(paramString)) || (paramTroopInfo.hasSetTroopName()));
    localITroopNameHelperService.updateTroopName(paramString);
  }
  
  private void a(group_member_info.RspBody paramRspBody, long paramLong, TroopMemberCard paramTroopMemberCard)
  {
    paramRspBody = (group_member_info.MemberInfo)paramRspBody.msg_meminfo.get();
    paramTroopMemberCard.result = paramRspBody.uint32_result.get();
    paramTroopMemberCard.isAllowModCard = paramRspBody.bool_is_allow_mod_card.get();
    paramTroopMemberCard.memberUin = paramRspBody.uint64_uin.get();
    paramTroopMemberCard.isFriend = paramRspBody.bool_is_friend.get();
    paramTroopMemberCard.credit = paramRspBody.uint32_credit.get();
    a(paramTroopMemberCard, paramRspBody);
    paramTroopMemberCard.sex = -1;
    if (paramRspBody.uint32_sex.has()) {
      paramTroopMemberCard.sex = paramRspBody.uint32_sex.get();
    }
    paramTroopMemberCard.location = "";
    if (paramRspBody.str_location.has()) {
      paramTroopMemberCard.location = paramRspBody.str_location.get().toStringUtf8();
    }
    paramTroopMemberCard.age = paramRspBody.uint32_age.get();
    paramTroopMemberCard.nick = "";
    paramTroopMemberCard.remark = "";
    paramTroopMemberCard.card = "";
    if (paramRspBody.str_nick.has()) {
      paramTroopMemberCard.nick = paramRspBody.str_nick.get().toStringUtf8();
    }
    if (paramRspBody.str_remark.has()) {
      paramTroopMemberCard.remark = paramRspBody.str_remark.get().toStringUtf8();
    }
    if (paramRspBody.str_card.has())
    {
      paramTroopMemberCard.colorCard = TroopMemberInfoHandlerProcessorConfig.a(paramRspBody.str_card.get());
      paramTroopMemberCard.colorCardId = TroopMemberInfoHandlerProcessorConfig.a(paramRspBody.str_card.get().toByteArray());
      paramTroopMemberCard.card = TroopMemberInfoHandlerProcessorConfig.a(paramTroopMemberCard.colorCard);
    }
    paramTroopMemberCard.levelName = paramRspBody.str_lev.get().toStringUtf8();
    if ((paramRspBody.medal_id.has()) && (paramRspBody.medal_id.get() > 0)) {
      paramTroopMemberCard.titleId = paramRspBody.medal_id.get();
    }
    if (paramRspBody.uint32_level.has()) {
      paramTroopMemberCard.realLevel = paramRspBody.uint32_level.get();
    }
    if (paramRspBody.bytes_group_honor.has()) {
      paramTroopMemberCard.newRealLevel = a(paramRspBody.bytes_group_honor.get().toByteArray());
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "handleGetTroopMemberCard, troopUin=" + paramLong + ", memberUin=" + paramTroopMemberCard.memberUin + ", titleId=" + paramTroopMemberCard.titleId);
    }
    paramTroopMemberCard.memberRole = -1;
    if (paramRspBody.uint32_role.has()) {
      paramTroopMemberCard.memberRole = paramRspBody.uint32_role.get();
    }
    paramTroopMemberCard.joinTime = paramRspBody.uint64_join.get();
    paramTroopMemberCard.lastSpeak = paramRspBody.uint64_last_speak.get();
    paramTroopMemberCard.isVip = paramRspBody.bool_is_vip.get();
    paramTroopMemberCard.isYearVip = paramRspBody.bool_is_year_vip.get();
    paramTroopMemberCard.isSuperVip = paramRspBody.bool_is_super_vip.get();
    paramTroopMemberCard.isSuperQQ = paramRspBody.bool_is_super_qq.get();
    paramTroopMemberCard.vipLevel = paramRspBody.uint32_vip_lev.get();
    paramTroopMemberCard.gbarTitle = paramRspBody.str_gbar_title.get().toStringUtf8();
    paramTroopMemberCard.gbarLinkUrl = paramRspBody.str_gbar_url.get().toStringUtf8();
    paramTroopMemberCard.gbarCount = paramRspBody.uint32_gbar_cnt.get();
    paramTroopMemberCard.gbarList = new ArrayList();
    if ((paramRspBody.uint32_special_title_expire_time.has()) && ((paramRspBody.uint32_special_title_expire_time.get() == -1) || (paramRspBody.uint32_special_title_expire_time.get() - NetConnInfoCenter.getServerTime() > 0L)))
    {
      if (paramRspBody.bytes_special_title.has()) {
        paramTroopMemberCard.mUniqueTitle = paramRspBody.bytes_special_title.get().toStringUtf8();
      }
      paramTroopMemberCard.mUniqueTitleExpire = paramRspBody.uint32_special_title_expire_time.get();
    }
    List localList = paramRspBody.rpt_msg_gbar_concerned.get();
    if (localList != null) {}
    int j;
    Object localObject1;
    Object localObject2;
    for (int i = localList.size();; i = 0)
    {
      j = 0;
      while (j < i)
      {
        localObject1 = (group_member_info.GBarInfo)localList.get(j);
        localObject2 = new TroopMemberCard.GBarInfo();
        ((TroopMemberCard.GBarInfo)localObject2).gbarId = ((group_member_info.GBarInfo)localObject1).uint32_gbar_id.get();
        ((TroopMemberCard.GBarInfo)localObject2).level = ((group_member_info.GBarInfo)localObject1).uint32_uin_lev.get();
        ((TroopMemberCard.GBarInfo)localObject2).headUrl = ((group_member_info.GBarInfo)localObject1).str_head_portrait.get().toStringUtf8();
        ((TroopMemberCard.GBarInfo)localObject2).name = ((group_member_info.GBarInfo)localObject1).bytes_gbar_name.get().toStringUtf8();
        paramTroopMemberCard.gbarList.add(localObject2);
        j += 1;
      }
    }
    paramTroopMemberCard.customEntryList = new ArrayList();
    localList = paramRspBody.rpt_msg_custom_enties.get();
    if (localList != null) {}
    for (i = localList.size();; i = 0)
    {
      j = 0;
      while (j < i)
      {
        localObject1 = (group_member_info.CustomEntry)localList.get(j);
        localObject2 = new TroopMemberCard.CustomEntry();
        ((TroopMemberCard.CustomEntry)localObject2).label = ((group_member_info.CustomEntry)localObject1).str_name.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).info = ((group_member_info.CustomEntry)localObject1).str_value.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).linkUrl = ((group_member_info.CustomEntry)localObject1).str_url.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject2).isClickable = ((group_member_info.CustomEntry)localObject1).bool_clicked.get();
        ((TroopMemberCard.CustomEntry)localObject2).reportId = ((group_member_info.CustomEntry)localObject1).uint64_report_id.get();
        paramTroopMemberCard.customEntryList.add(localObject2);
        j += 1;
      }
    }
    b(paramTroopMemberCard, paramRspBody);
    if (paramRspBody.bytes_phone_num.has()) {
      paramTroopMemberCard.phoneNumber = paramRspBody.bytes_phone_num.get().toStringUtf8();
    }
    a(paramLong, paramTroopMemberCard, paramRspBody);
    if (paramRspBody.bytes_job.has()) {
      paramTroopMemberCard.mPosition = paramRspBody.bytes_job.get().toStringUtf8();
    }
    c(paramTroopMemberCard, paramRspBody);
    d(paramTroopMemberCard, paramRspBody);
    if (paramRspBody.bytes_group_honor.has())
    {
      TroopMemberInfoHandlerProcessorConfig.a(paramTroopMemberCard, paramRspBody);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, String.format("handleGetTroopMemberCard troopUin: %s, memberUin: %s, honorList: %s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramTroopMemberCard.memberUin), paramTroopMemberCard.honorList }));
      }
    }
    for (;;)
    {
      if (paramRspBody.uint32_group_honor_bit.has())
      {
        paramTroopMemberCard.honorRichTag = ((byte)paramRspBody.uint32_group_honor_bit.get());
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor", 2, "honor_rich_card," + paramRspBody.uint32_group_honor_bit.get());
        }
      }
      a(paramLong, paramTroopMemberCard);
      return;
      paramTroopMemberCard.honorList = "";
    }
  }
  
  private boolean a(TroopMemberCard paramTroopMemberCard, int paramInt, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt > 0)
    {
      bool = paramBoolean;
      if (paramInt != paramTroopMemberInfo.level)
      {
        paramTroopMemberInfo.level = paramInt;
        bool = true;
      }
    }
    paramBoolean = bool;
    if (paramTroopMemberCard.nick != null)
    {
      paramBoolean = bool;
      if (!paramTroopMemberCard.nick.equals(paramTroopMemberInfo.friendnick))
      {
        paramTroopMemberInfo.friendnick = paramTroopMemberCard.nick;
        paramBoolean = true;
      }
    }
    bool = paramBoolean;
    if (paramTroopMemberCard.mUniqueTitle != null)
    {
      bool = paramBoolean;
      if (!paramTroopMemberCard.mUniqueTitle.equals(paramTroopMemberInfo.mUniqueTitle))
      {
        paramTroopMemberInfo.mUniqueTitle = paramTroopMemberCard.mUniqueTitle;
        bool = true;
      }
    }
    if (paramTroopMemberCard.realLevel != paramTroopMemberInfo.realLevel)
    {
      paramTroopMemberInfo.realLevel = paramTroopMemberCard.realLevel;
      bool = true;
    }
    if (paramTroopMemberCard.newRealLevel != paramTroopMemberInfo.newRealLevel)
    {
      paramTroopMemberInfo.newRealLevel = paramTroopMemberCard.newRealLevel;
      bool = true;
    }
    if (paramTroopMemberCard.joinTime != paramTroopMemberInfo.join_time)
    {
      paramTroopMemberInfo.join_time = paramTroopMemberCard.joinTime;
      bool = true;
    }
    if (paramTroopMemberCard.lastSpeak != paramTroopMemberInfo.last_active_time)
    {
      paramTroopMemberInfo.last_active_time = paramTroopMemberCard.lastSpeak;
      bool = true;
    }
    if (paramTroopMemberCard.colorCardId != paramTroopMemberInfo.troopColorNickId)
    {
      paramTroopMemberInfo.troopColorNickId = paramTroopMemberCard.colorCardId;
      return true;
    }
    return bool;
  }
  
  private boolean a(TroopMemberCard paramTroopMemberCard, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    String str = paramTroopMemberCard.colorCard;
    if (str == null) {}
    for (paramTroopMemberCard = null;; paramTroopMemberCard = TroopMemberInfoHandlerProcessorConfig.a(str))
    {
      if ((str != null) && (!str.equals(paramTroopMemberInfo.troopColorNick))) {
        paramTroopMemberInfo.troopColorNick = str;
      }
      boolean bool = paramBoolean;
      if (paramTroopMemberCard != null)
      {
        bool = paramBoolean;
        if (!paramTroopMemberCard.equals(paramTroopMemberInfo.troopnick))
        {
          paramTroopMemberInfo.troopnick = paramTroopMemberCard;
          bool = true;
        }
      }
      return bool;
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = 0L;
    long l2 = a(paramToServiceMsg.getUin());
    if (l2 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopMemberListReq localGetTroopMemberListReq = new GetTroopMemberListReq();
    localGetTroopMemberListReq.uin = l2;
    localGetTroopMemberListReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopMemberListReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    localGetTroopMemberListReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopMemberListReq.ReqType = paramToServiceMsg.getInt("reqType");
    String str = localGetTroopMemberListReq.GroupCode + "_" + localGetTroopMemberListReq.ReqType;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(str)).longValue();
    }
    localGetTroopMemberListReq.GetListAppointTime = l1;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    return true;
  }
  
  private void b(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if ((paramMemberInfo.bool_location_shared.has()) && (paramMemberInfo.bool_location_shared.get() == true) && (paramMemberInfo.uint64_distance.has()))
    {
      paramTroopMemberCard.distance = paramMemberInfo.uint64_distance.get();
      return;
    }
    if ((paramMemberInfo.bool_location_shared.has()) && (!paramMemberInfo.bool_location_shared.get()))
    {
      paramTroopMemberCard.distance = -1001L;
      return;
    }
    paramTroopMemberCard.distance = -100L;
  }
  
  private void b(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    if (TextUtils.isEmpty(paramstTroopMemberInfo.strAutoRemark))
    {
      paramTroopMemberInfo.pyFirst_autoremark = "";
      paramTroopMemberInfo.pyAll_autoremark = "";
    }
    do
    {
      return;
      if (!paramstTroopMemberInfo.strAutoRemark.equals(paramTroopMemberInfo.autoremark))
      {
        paramTroopMemberInfo.pyFirst_autoremark = ChnToSpell.a(paramstTroopMemberInfo.strAutoRemark, 2);
        paramTroopMemberInfo.pyAll_autoremark = ChnToSpell.a(paramstTroopMemberInfo.strAutoRemark, 1);
        return;
      }
      if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_autoremark)) {
        paramTroopMemberInfo.pyFirst_autoremark = ChnToSpell.a(paramstTroopMemberInfo.strAutoRemark, 2);
      }
    } while (!TextUtils.isEmpty(paramTroopMemberInfo.pyAll_autoremark));
    paramTroopMemberInfo.pyAll_autoremark = ChnToSpell.a(paramstTroopMemberInfo.strAutoRemark, 1);
  }
  
  private void c(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    boolean bool = true;
    int i = 0;
    if (paramMemberInfo.qqstory_infocard.has())
    {
      paramMemberInfo = (group_member_info.RspGroupCardGetStory)paramMemberInfo.qqstory_infocard.get();
      if (paramMemberInfo.flag.has()) {
        if (paramMemberInfo.flag.get() != 1) {
          break label166;
        }
      }
      for (;;)
      {
        paramTroopMemberCard.mHasStory = bool;
        if (!paramMemberInfo.video_info.has()) {
          break;
        }
        paramMemberInfo = paramMemberInfo.video_info.get();
        if (paramMemberInfo.size() <= 0) {
          break;
        }
        paramTroopMemberCard.mStoryInfoList = new ArrayList();
        while (i < paramMemberInfo.size())
        {
          group_member_info.InfoCardVideoInfo localInfoCardVideoInfo = (group_member_info.InfoCardVideoInfo)paramMemberInfo.get(i);
          if (localInfoCardVideoInfo.cover.has())
          {
            TroopMemberCard.StoryInfo localStoryInfo = new TroopMemberCard.StoryInfo();
            localStoryInfo.mCoverUrl = localInfoCardVideoInfo.cover.get().toStringUtf8();
            paramTroopMemberCard.mStoryInfoList.add(localStoryInfo);
          }
          i += 1;
        }
        label166:
        bool = false;
      }
    }
  }
  
  private void d(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.msg_game_info.has())
    {
      localObject = (group_member_info.MemberGameInfo)paramMemberInfo.msg_game_info.get();
      paramMemberInfo = new TroopMemberCard.MemberGameInfo();
      paramMemberInfo.gameName = ((group_member_info.MemberGameInfo)localObject).str_game_name.get();
      paramMemberInfo.levelName = ((group_member_info.MemberGameInfo)localObject).str_level_name.get();
      paramMemberInfo.levelIcon = ((group_member_info.MemberGameInfo)localObject).str_level_icon.get();
      paramMemberInfo.gameFontColor = ((group_member_info.MemberGameInfo)localObject).str_game_font_color.get();
      paramMemberInfo.gameBackGroundColor = ((group_member_info.MemberGameInfo)localObject).str_game_background_color.get();
      paramMemberInfo.gameUrl = ((group_member_info.MemberGameInfo)localObject).str_game_url.get();
      localObject = ((group_member_info.MemberGameInfo)localObject).str_desc_info.get();
      paramMemberInfo.descInfo = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMemberInfo.descInfo.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("get_troop_member", 2, new Object[] { "desc=", ((List)localObject).get(0) });
        }
      }
      paramTroopMemberCard.mMemberGameInfo = paramMemberInfo;
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, new Object[] { "gameInfo, gameName=", paramMemberInfo.gameName, ", levelName=", paramMemberInfo.levelName, ", gameUrl=", paramMemberInfo.gameUrl, ", levelIcon=", paramMemberInfo.levelIcon, ", gameFontColor=", paramMemberInfo.gameFontColor, ", gameBackGroundColor=", paramMemberInfo.gameBackGroundColor });
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("get_troop_member", 2, "has no game info");
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new cmd0xaf6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i == 0)
    {
      paramToServiceMsg = new StringBuffer("groupUins:");
      if (((cmd0xaf6.RspBody)localObject1).group_member.has())
      {
        paramFromServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramObject = ((cmd0xaf6.RspBody)localObject1).group_member.get().iterator();
        while (paramObject.hasNext())
        {
          Object localObject2 = (cmd0xaf6.GroupMember)paramObject.next();
          localObject1 = paramFromServiceMsg.getTroopInfo(String.valueOf(((cmd0xaf6.GroupMember)localObject2).group_id.get()));
          ArrayList localArrayList = new ArrayList();
          localObject2 = ((cmd0xaf6.GroupMember)localObject2).uins.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l = ((Long)((Iterator)localObject2).next()).longValue();
            localArrayList.add(String.valueOf(l));
            paramToServiceMsg.append(l).append("|");
          }
          TroopMemberInfoHandlerProcessorConfig.a(this.appRuntime, (TroopInfo)localObject1, localArrayList);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, "handleGetTroopMemberListForHeadBatch:" + paramToServiceMsg.toString());
      }
      return;
    }
    QLog.e("TroopMemberInfoHandler", 1, "getTroopMemberListBatch failed! retCode = " + i);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopNotificationConstants.j, false, null);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(TroopNotificationConstants.j, false, null);
      return;
    }
    if (paramToServiceMsg == null)
    {
      notifyUI(TroopNotificationConstants.j, false, null);
      return;
    }
    paramFromServiceMsg = (ModifyGroupCardResp)paramObject;
    if (paramFromServiceMsg.result != 0)
    {
      paramToServiceMsg = paramFromServiceMsg.ErrorString;
      notifyUI(TroopNotificationConstants.j, false, new Object[] { null, paramToServiceMsg });
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l = paramToServiceMsg.extraData.getLong("dwGroupCode");
    paramToServiceMsg.extraData.getLong("dwZero");
    paramToServiceMsg.extraData.getLong("dwNewSeq");
    paramToServiceMsg = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).modifyTroopMemberCardInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(l), paramFromServiceMsg);
    notifyUI(TroopNotificationConstants.j, true, new Object[] { paramToServiceMsg, "" });
  }
  
  public TroopMemberInfo a(String paramString1, long paramLong, EntityManager paramEntityManager, stTroopMemberInfo paramstTroopMemberInfo, String paramString2)
  {
    boolean bool2 = true;
    TroopMemberInfo localTroopMemberInfo = new TroopMemberInfo();
    localTroopMemberInfo.troopuin = paramString1;
    localTroopMemberInfo.memberuin = paramString2;
    localTroopMemberInfo.friendnick = paramstTroopMemberInfo.Nick;
    localTroopMemberInfo.pyFirst_friendnick = ChnToSpell.a(localTroopMemberInfo.friendnick, 2);
    localTroopMemberInfo.pyAll_friendnick = ChnToSpell.a(localTroopMemberInfo.friendnick, 1);
    TroopMemberInfoHandlerProcessorConfig.b(paramstTroopMemberInfo, localTroopMemberInfo);
    localTroopMemberInfo.pyFirst_troopnick = ChnToSpell.a(localTroopMemberInfo.troopnick, 2);
    localTroopMemberInfo.pyAll_troopnick = ChnToSpell.a(localTroopMemberInfo.troopnick, 1);
    localTroopMemberInfo.autoremark = paramstTroopMemberInfo.strAutoRemark;
    localTroopMemberInfo.faceid = paramstTroopMemberInfo.FaceId;
    localTroopMemberInfo.sex = paramstTroopMemberInfo.Gender;
    localTroopMemberInfo.status = paramstTroopMemberInfo.Status;
    localTroopMemberInfo.age = paramstTroopMemberInfo.Age;
    localTroopMemberInfo.alias = paramstTroopMemberInfo.sShowName;
    localTroopMemberInfo.datetime = paramLong;
    TroopMemberInfoHandlerProcessorConfig.c(localTroopMemberInfo, paramstTroopMemberInfo);
    TroopMemberInfoHandlerProcessorConfig.b(localTroopMemberInfo, paramstTroopMemberInfo);
    localTroopMemberInfo.join_time = paramstTroopMemberInfo.dwJoinTime;
    localTroopMemberInfo.last_active_time = paramstTroopMemberInfo.dwLastSpeakTime;
    localTroopMemberInfo.active_point = paramstTroopMemberInfo.dwPoint;
    localTroopMemberInfo.credit_level = paramstTroopMemberInfo.dwCreditLevel;
    if (paramstTroopMemberInfo.cConcerned == 1)
    {
      bool1 = true;
      localTroopMemberInfo.isTroopFollowed = bool1;
      if (paramstTroopMemberInfo.cShielded != 1) {
        break label421;
      }
    }
    label421:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localTroopMemberInfo.mIsShielded = bool1;
      localTroopMemberInfo.globalTroopLevel = ((int)paramstTroopMemberInfo.dwGlobalGroupLevel);
      if ((paramstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (paramstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
      {
        localTroopMemberInfo.mUniqueTitle = paramstTroopMemberInfo.sSpecialTitle;
        localTroopMemberInfo.mUniqueTitleExpire = ((int)paramstTroopMemberInfo.dwSpecialTitleExpireTime);
      }
      if (paramstTroopMemberInfo.qzusrinfo != null) {
        localTroopMemberInfo.isShowQZone = paramstTroopMemberInfo.qzusrinfo.eStarState;
      }
      if (paramstTroopMemberInfo.vecGroupHonor != null) {
        TroopMemberInfoHandlerProcessorConfig.a(localTroopMemberInfo, paramstTroopMemberInfo);
      }
      localTroopMemberInfo.mHonorRichFlag = paramstTroopMemberInfo.cRichFlag;
      if ((QLog.isColorLevel()) && (paramstTroopMemberInfo.cRichFlag != 0)) {
        QLog.d("TroopMemberInfoHandler", 2, "honor_rich_friend_add," + paramstTroopMemberInfo.cRichFlag);
      }
      paramEntityManager.persist(localTroopMemberInfo);
      return localTroopMemberInfo;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, false);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "group_member_card.get_group_member_card_info");
    group_member_info.ReqBody localReqBody = new group_member_info.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    localReqBody.uint64_uin.set(paramLong2);
    localReqBody.bool_new_client.set(true);
    localReqBody.uint32_client_type.set(1);
    localReqBody.uint32_rich_card_name_ver.set(1);
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putBoolean("once", paramBoolean);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberCard, memberUin: " + paramLong2 + " troopCode: " + paramLong1);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramFromServiceMsg, (GetTroopAppointRemarkResp)paramObject);
      return;
    }
    notifyUI(TroopNotificationConstants.k, false, null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberInfoHandler", 2, "getTroopMemberListBy0x787 uin=" + paramString);
    }
    try
    {
      long l = Long.parseLong(paramString);
      Object localObject = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject).uint64_group_code.set(l);
      ((oidb_0x787.ReqBody)localObject).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject).uint64_data_time.set(0L);
      oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
      localFilter.uint32_member_level_info_uin.set(1);
      localFilter.uint32_member_level_info_name.set(1);
      localFilter.uint32_nick_name.set(1);
      ((oidb_0x787.ReqBody)localObject).opt_filter.set(localFilter);
      localObject = makeOIDBPkg("OidbSvc.0x787_11", 1927, 11, ((oidb_0x787.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetTroopAppointRemarkReq");
    localToServiceMsg.extraData.putString("GroupUin", paramString1);
    localToServiceMsg.extraData.putString("GroupCode", paramString2);
    localToServiceMsg.extraData.putByte("cRichInfo", (byte)2);
    localToServiceMsg.extraData.putSerializable("vecUinList", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList<TroopMemberCardInfo> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if ((paramString == null) || (paramArrayList == null) || (paramArrayList1 == null)) {}
    while (paramArrayList.size() != paramArrayList1.size()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      int j = ((Integer)paramArrayList1.get(i)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.cGender = localTroopMemberCardInfo.sex;
      localstUinInfo.dwuin = Long.parseLong(localTroopMemberCardInfo.memberuin);
      localstUinInfo.sEmail = localTroopMemberCardInfo.email;
      localstUinInfo.sName = localTroopMemberCardInfo.name;
      localstUinInfo.sPhone = localTroopMemberCardInfo.tel;
      localstUinInfo.sRemark = localTroopMemberCardInfo.memo;
      localstUinInfo.dwFlag = j;
      localArrayList.add(localstUinInfo);
      i += 1;
    }
    paramArrayList = createToServiceMsg("friendlist.ModifyGroupCardReq");
    paramArrayList.extraData.putLong("dwZero", 0L);
    paramArrayList.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList.extraData.putLong("dwNewSeq", 0L);
    send(paramArrayList);
  }
  
  public void a(List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberInfoHandler", 2, "getTroopMemberListForHeadBatch, size = " + paramList.size());
    }
    int k = (int)Math.ceil(paramList.size() / 50.0D);
    int i = 0;
    if (i < k)
    {
      if (paramList.size() < (i + 1) * 50) {}
      for (int j = paramList.size();; j = (i + 1) * 50)
      {
        Object localObject2 = paramList.subList(i * 50, j);
        Object localObject1 = new cmd0xaf6.ReqBody();
        ((cmd0xaf6.ReqBody)localObject1).group_id.set((List)localObject2);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2806);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xaf6.ReqBody)localObject1).toByteArray()));
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        localObject1 = createToServiceMsg("OidbSvc.0xaf6_0");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(30000L);
        sendPbReq((ToServiceMsg)localObject1);
        i += 1;
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || ("0".equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("get_troop_member", 2, "error troopuin: " + paramString1);
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettroopmemberlist", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "friendlist.getTroopMemberList");
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean1);
      localToServiceMsg.extraData.putBoolean("needCallBackCache", paramBoolean2);
      localToServiceMsg.extraData.putInt("reqType", paramInt1);
      localToServiceMsg.extraData.putLong("timestamp", paramLong);
      localToServiceMsg.extraData.putInt("type", paramInt2);
      String str = paramString1 + "_" + paramInt1;
      Bundle localBundle = localToServiceMsg.extraData;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        paramLong = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(str)).longValue();
        localBundle.putLong("get_list_appoint_time", paramLong);
      }
      try
      {
        localToServiceMsg.extraData.putLong("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin());
        localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
        localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
        paramLong = System.currentTimeMillis();
        localToServiceMsg.extraData.putLong("troop_time", paramLong);
        localToServiceMsg.extraData.putLong("version", 3L);
        send(localToServiceMsg);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("get_troop_member", 2, "TroopHandler.getTroopMemberList,Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", troopUin: " + paramString1 + " troopCode: " + paramString2);
        return;
        paramLong = 0L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberList error, NumberFormatException, troopUin: " + paramString1 + " troopCode: " + paramString2);
          }
        }
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramToServiceMsg, (GetTroopMemberListResp)paramObject);
      return;
    }
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int i = paramToServiceMsg.extraData.getInt("type", 0);
    paramFromServiceMsg = a(l);
    notifyUI(TroopNotificationConstants.e, false, new Object[] { paramFromServiceMsg, null, Integer.valueOf(paramToServiceMsg.extraData.getInt("reqType", 0)), Long.valueOf(paramToServiceMsg.extraData.getLong("timestamp")), Integer.valueOf(i) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : data==null");
      }
      notifyUI(TroopNotificationConstants.Y, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(TroopNotificationConstants.Y, false, null);
      return;
    }
    paramFromServiceMsg = new group_member_info.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l = paramFromServiceMsg.uint64_group_code.get();
      int i = paramFromServiceMsg.uint32_self_role.get();
      paramObject = new TroopMemberCard();
      paramObject.result = -1;
      if (paramFromServiceMsg.uint32_group_type.has()) {
        paramObject.mGroupType = paramFromServiceMsg.uint32_group_type.get();
      }
      if (paramFromServiceMsg.msg_meminfo.has()) {
        a(paramFromServiceMsg, l, paramObject);
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("once", false);
      notifyUI(TroopNotificationConstants.Y, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramObject, Boolean.valueOf(bool) });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "onReceive: handleGetTroopMemberCard mergeFrom:" + paramToServiceMsg.toString());
      }
      notifyUI(TroopNotificationConstants.Y, false, null);
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    }
    while (bool)
    {
      long l;
      int i;
      StringBuffer localStringBuffer;
      ArrayList localArrayList;
      try
      {
        ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
        l = Long.valueOf(paramToServiceMsg.extraData.getString("troopUin")).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberInfoHandler", 2, "handleGetTroopCardDefaultNickBatch success=" + bool + " troopUin=" + l);
        }
        paramToServiceMsg = new oidb_0x787.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i != 0) {
          break label513;
        }
        if (l == paramToServiceMsg.uint64_group_code.get())
        {
          localStringBuffer = new StringBuffer();
          paramToServiceMsg = paramToServiceMsg.rpt_msg_member_level_info.get();
          localArrayList = new ArrayList();
          Iterator localIterator = paramToServiceMsg.iterator();
          while (localIterator.hasNext())
          {
            paramObject = (oidb_0x787.MemberLevelInfo)localIterator.next();
            paramFromServiceMsg = "";
            paramToServiceMsg = "";
            String str = String.valueOf(paramObject.uint64_uin.get());
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(" uin=");
              localStringBuffer.append(str.substring(0, 4));
            }
            if (paramObject.str_name.has()) {
              paramFromServiceMsg = TroopMemberInfoHandlerProcessorConfig.a(paramObject.str_name.get());
            }
            if (paramObject.bytes_nick_name.has())
            {
              paramObject = paramObject.bytes_nick_name.get().toStringUtf8();
              paramToServiceMsg = paramObject;
              if (QLog.isColorLevel())
              {
                localStringBuffer.append(" nick=");
                localStringBuffer.append(MessageRecordUtil.a(paramObject));
                paramToServiceMsg = paramObject;
              }
            }
            if (localITroopMemberInfoService != null)
            {
              paramObject = paramFromServiceMsg;
              if (TextUtils.isEmpty(paramFromServiceMsg)) {
                paramObject = null;
              }
              paramFromServiceMsg = paramToServiceMsg;
              if (TextUtils.isEmpty(paramToServiceMsg)) {
                paramFromServiceMsg = null;
              }
              localITroopMemberInfoService.saveTroopMemberEx(String.valueOf(l), str, paramObject, -100, paramFromServiceMsg, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
            }
            localArrayList.add(new Pair(str, ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(String.valueOf(l), str)));
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopMemberInfoHandler", 2, "handleGetTroopCardDefaultNickBatch ex", paramToServiceMsg);
        }
      }
      bool = false;
      continue;
      notifyUI(TroopNotificationConstants.bn, true, new Object[] { String.valueOf(l), localArrayList });
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, localStringBuffer.toString());
      }
      ((ITroopNameHelperService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNameHelperService.class, "")).reExecuteReturnTask(String.valueOf(l), true);
      return;
      label513:
      QLog.d("TroopMemberInfoHandler", 2, "handleGetTroopMemberListBy0x787 result code = " + i);
      return;
    }
    QLog.d("TroopMemberInfoHandler", 2, "handleGetTroopMemberListBy0x787 not success.");
  }
  
  public Set<String> getCommandList()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xaf6_0");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupCardReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopAppointRemarkReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getTroopMemberList");
      this.jdField_a_of_type_JavaUtilSet.add("group_member_card.get_group_member_card_info");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_11");
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberInfoHandler", 2, "onReceive,resp == null");
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
      QLog.d("TroopMemberInfoHandler", 2, "cmdfilter error=" + str);
      return;
      if ("OidbSvc.0xaf6_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.ModifyGroupCardReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.GetTroopAppointRemarkReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.getTroopMemberList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("group_member_card.get_group_member_card_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x787_11".equals(paramFromServiceMsg.getServiceCmd()));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler
 * JD-Core Version:    0.7.0.1
 */