package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.config.TroopAddFriendHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.config.TroopMemberListHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.TroopMemberUtil;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopMemberListResp;
import friendlist.QzoneUserInfo;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.GroupMember;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.ReqBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopMemberListHandler
  extends TroopBaseHandler
  implements ITroopMemberListHandler
{
  protected Set<String> a;
  private AppInterface b;
  private HashMap<String, Long> c = new HashMap();
  private HashMap<String, ArrayList<stTroopMemberInfo>> d = null;
  
  public TroopMemberListHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = paramAppInterface;
    TroopMemberListHandlerProcessorConfig.a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    int i = 1;
    while (i < 32)
    {
      if (paramInt >> i == 0) {
        return i + 1;
      }
      i += 1;
    }
    return 1;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return 0;
      }
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
          QLog.d("TroopMemberListHandler", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
    return 0;
  }
  
  private List<TroopMemberInfo> a(String paramString, long paramLong)
  {
    long l3;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong == 0L) {
        return null;
      }
      l3 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramLong);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    for (;;)
    {
      try
      {
        if ((this.d != null) && (this.d.containsKey(localObject1)))
        {
          ArrayList localArrayList = (ArrayList)this.d.remove(localObject1);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = new ArrayList();
            EntityManager localEntityManager = this.b.getEntityManagerFactory().createEntityManager();
            EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
            localEntityTransaction.begin();
            try
            {
              Iterator localIterator = localArrayList.iterator();
              if (localIterator.hasNext())
              {
                stTroopMemberInfo localstTroopMemberInfo = (stTroopMemberInfo)localIterator.next();
                long l2 = localstTroopMemberInfo.MemberUin;
                long l1 = l2;
                if (l2 < 0L) {
                  l1 = localstTroopMemberInfo.MemberUin + 4294967296L;
                }
                Object localObject3 = String.valueOf(l1);
                localObject2 = localEntityManager.query(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, localObject3 }, null, null, null, null);
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  break label635;
                }
                localObject2 = (TroopMemberInfo)((List)localObject2).get(0);
                if (localObject2 == null) {
                  localObject2 = a(paramString, paramLong, localEntityManager, localstTroopMemberInfo, (String)localObject3);
                } else {
                  a(paramLong, localEntityManager, localstTroopMemberInfo, (TroopMemberInfo)localObject2);
                }
                Object localObject4 = localObject3;
                TroopMemberCardInfo localTroopMemberCardInfo = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.b, paramString, localObject4);
                localObject3 = localTroopMemberCardInfo;
                if (localTroopMemberCardInfo == null)
                {
                  localObject3 = new TroopMemberCardInfo();
                  ((TroopMemberCardInfo)localObject3).troopuin = paramString;
                  ((TroopMemberCardInfo)localObject3).memberuin = localObject4;
                }
                ((TroopMemberCardInfo)localObject3).nick = localstTroopMemberInfo.Nick;
                ((TroopMemberCardInfo)localObject3).sex = localstTroopMemberInfo.cGender;
                ((TroopMemberCardInfo)localObject3).tel = localstTroopMemberInfo.sPhone;
                ((TroopMemberCardInfo)localObject3).email = localstTroopMemberInfo.sEmail;
                ((TroopMemberCardInfo)localObject3).memo = localstTroopMemberInfo.sMemo;
                ((TroopMemberCardInfo)localObject3).job = localstTroopMemberInfo.bytes_job;
                ((TroopMemberCardInfo)localObject3).mVipType = ((int)localstTroopMemberInfo.dwVipType);
                ((TroopMemberCardInfo)localObject3).mVipLevel = a((int)localstTroopMemberInfo.dwVipLevel);
                TroopMemberListHandlerProcessorConfig.a((TroopMemberCardInfo)localObject3, localstTroopMemberInfo);
                ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).saveTroopMemberCardInfo(this.b, (TroopMemberCardInfo)localObject3);
                ((List)localObject1).add(localObject2);
                continue;
              }
              localEntityTransaction.commit();
              localEntityManager.close();
              localEntityTransaction.end();
              paramLong = System.currentTimeMillis();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("processDataInRsp2TroopMemberList, Thread id:");
                ((StringBuilder)localObject2).append(Thread.currentThread().getId());
                ((StringBuilder)localObject2).append(",threadName:");
                ((StringBuilder)localObject2).append(Thread.currentThread().getName());
                ((StringBuilder)localObject2).append(", cost:");
                ((StringBuilder)localObject2).append(paramLong - l3);
                QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject2).toString());
              }
              TroopMemberListHandlerProcessorConfig.a(this.b, paramString, localArrayList);
              return localObject1;
            }
            finally
            {
              localEntityManager.close();
              localEntityTransaction.end();
            }
          }
          return null;
        }
        return null;
      }
      finally {}
      return null;
      label635:
      Object localObject2 = null;
    }
  }
  
  private void a(int paramInt, long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo;
    if (localITroopInfoService != null) {
      localTroopInfo = localITroopInfoService.findTroopInfo(String.valueOf(paramLong));
    } else {
      localTroopInfo = null;
    }
    Object localObject;
    if (paramInt == 9)
    {
      localObject = localTroopInfo;
      if (localTroopInfo != null)
      {
        int i = 0;
        if (paramList != null) {
          paramInt = paramList.size();
        } else {
          paramInt = 0;
        }
        localObject = new ArrayList();
        while (i < paramInt)
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
          if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localmemberlist.uint64_member_uin.get());
            ((ArrayList)localObject).add(localStringBuilder.toString());
          }
          i += 1;
        }
        TroopMemberListHandlerProcessorConfig.a(this.appRuntime, localTroopInfo, (ArrayList)localObject);
        localObject = localTroopInfo;
      }
    }
    else
    {
      localObject = localTroopInfo;
      if (localTroopInfo == null)
      {
        localObject = new TroopInfo();
        ((TroopInfo)localObject).troopuin = String.valueOf(paramLong);
      }
      ((TroopInfo)localObject).updateSomeMemberUins(paramList);
    }
    if (localITroopInfoService != null) {
      localITroopInfoService.saveTroopInfo((TroopInfo)localObject);
    }
    TroopMemberListHandlerProcessorConfig.a(paramLong, paramList);
  }
  
  private void a(long paramLong, EntityManager paramEntityManager, stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
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
    int i = paramstTroopMemberInfo.cConcerned;
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramTroopMemberInfo.isTroopFollowed = bool1;
    boolean bool1 = bool2;
    if (paramstTroopMemberInfo.cShielded == 1) {
      bool1 = true;
    }
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
    TroopMemberListHandlerProcessorConfig.b(paramTroopMemberInfo, paramstTroopMemberInfo);
    paramTroopMemberInfo.mHonorRichFlag = paramstTroopMemberInfo.cRichFlag;
    if ((QLog.isColorLevel()) && (paramstTroopMemberInfo.cRichFlag != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("honor_rich_friend,");
      localStringBuilder.append(paramstTroopMemberInfo.cRichFlag);
      QLog.d("TroopMemberListHandler", 2, localStringBuilder.toString());
    }
    paramEntityManager.update(paramTroopMemberInfo);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopMemberListResp paramGetTroopMemberListResp)
  {
    String str1 = b(paramToServiceMsg.extraData.getLong("troop_uin"));
    long l1 = paramToServiceMsg.extraData.getLong("troop_time");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needCallBackCache");
    int i = paramToServiceMsg.extraData.getInt("reqType", 0);
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    int k = paramToServiceMsg.extraData.getInt("type", 0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(i);
    String str2 = ((StringBuilder)localObject1).toString();
    if (paramGetTroopMemberListResp != null)
    {
      if (paramGetTroopMemberListResp.NextGetTime != 0L) {
        this.c.put(str2, Long.valueOf(paramGetTroopMemberListResp.NextGetTime));
      }
      long l3 = paramGetTroopMemberListResp.GroupUin;
      paramGetTroopMemberListResp.GroupUin = paramGetTroopMemberListResp.GroupCode;
      paramGetTroopMemberListResp.GroupCode = l3;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("req troopUin:");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append("| resp.GroupUin:");
        ((StringBuilder)localObject1).append(paramGetTroopMemberListResp.GroupUin);
        ((StringBuilder)localObject1).append("|resp.GroupCode:");
        ((StringBuilder)localObject1).append(paramGetTroopMemberListResp.GroupCode);
        QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject1).toString());
      }
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
      Object localObject2 = localITroopInfoService.findTroopInfo(str1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = str1;
      }
      ((TroopInfo)localObject1).dwOfficeMode = paramGetTroopMemberListResp.office_mode;
      localITroopInfoService.saveTroopInfo((TroopInfo)localObject1);
      if (paramGetTroopMemberListResp.result == 0)
      {
        try
        {
          if (this.d == null) {
            this.d = new HashMap();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(l1);
          localObject2 = ((StringBuilder)localObject2).toString();
          if (this.d.containsKey(localObject2)) {
            ((ArrayList)this.d.get(localObject2)).addAll(paramGetTroopMemberListResp.vecTroopMember);
          } else {
            this.d.put(localObject2, paramGetTroopMemberListResp.vecTroopMember);
          }
          paramGetTroopMemberListResp.vecTroopMember.size();
          if (paramGetTroopMemberListResp.NextUin != 0L)
          {
            paramToServiceMsg.extraData.putBoolean("force_refresh", true);
            paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopMemberListResp.NextUin);
            paramToServiceMsg.extraData.putLong("troop_time", l1);
            paramToServiceMsg.extraData.putInt("reqType", i);
            paramToServiceMsg.extraData.putLong("timestamp", l2);
            paramToServiceMsg.extraData.putInt("type", k);
            localObject1 = new UniPacket(true);
            ((UniPacket)localObject1).setEncodeName("utf-8");
            if (a(paramToServiceMsg, (UniPacket)localObject1))
            {
              paramToServiceMsg.setServiceName("mobileqq.service");
              paramToServiceMsg.setRequestSsoSeq(((UniPacket)localObject1).getRequestId());
              paramToServiceMsg.putWupBuffer(((UniPacket)localObject1).encode());
              send(paramToServiceMsg);
            }
            else
            {
              if (bool)
              {
                paramToServiceMsg = new Object[5];
                paramToServiceMsg[0] = str1;
                paramToServiceMsg[1] = a(str1, l1);
                paramToServiceMsg[2] = Integer.valueOf(i);
                paramToServiceMsg[3] = Long.valueOf(l2);
                paramToServiceMsg[4] = Integer.valueOf(k);
              }
              else
              {
                a(str1, l1);
                paramToServiceMsg = new Object[5];
                paramToServiceMsg[0] = str1;
                paramToServiceMsg[1] = null;
                paramToServiceMsg[2] = Integer.valueOf(i);
                paramToServiceMsg[3] = Long.valueOf(l2);
                paramToServiceMsg[4] = Integer.valueOf(k);
              }
              a(false, paramToServiceMsg);
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListHandler", 2, "FriendListHandler.handleGetTroopMemberList, request the next page data");
            }
          }
          else
          {
            int j = i;
            l3 = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("netWorkCost:");
              paramToServiceMsg.append(l3 - l1);
              QLog.d("TroopMemberListHandler", 2, paramToServiceMsg.toString());
            }
            if (bool)
            {
              a(true, new Object[] { str1, a(str1, l1), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k) });
              ThreadManager.post(new TroopMemberListHandler.1(this, str1, l1, (TroopInfo)localObject1), 5, null, false);
            }
            else
            {
              a(str1, l1);
              a(str1, l1, (TroopInfo)localObject1);
              a(true, new Object[] { str1, null, Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k) });
            }
          }
        }
        finally {}
      }
      else
      {
        bool = false;
        if (paramGetTroopMemberListResp.result == 2) {
          bool = true;
        }
        a(bool, new Object[] { str1, null, Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(k) });
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("FriendListHandler.handleGetTroopMemberList, resp.result: ");
        paramToServiceMsg.append(paramGetTroopMemberListResp.result);
        paramToServiceMsg.append(" member count: ");
        paramToServiceMsg.append(paramGetTroopMemberListResp.vecTroopMember.size());
        paramToServiceMsg.append("|reqType:");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append("|memberListNextReqTime:");
        if (this.c.containsKey(str2)) {
          l1 = ((Long)this.c.get(str2)).longValue();
        } else {
          l1 = 0L;
        }
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append("|troopUin:");
        paramToServiceMsg.append(str1);
        QLog.d("TroopMemberListHandler.troop.req_troop_mem_list_optimize", 2, paramToServiceMsg.toString());
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
    else if (!paramstTroopMemberInfo.Nick.equals(paramTroopMemberInfo.friendnick))
    {
      paramTroopMemberInfo.pyFirst_friendnick = ChnToSpell.b(paramstTroopMemberInfo.Nick, 2);
      paramTroopMemberInfo.pyAll_friendnick = ChnToSpell.b(paramstTroopMemberInfo.Nick, 1);
    }
    else
    {
      if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_friendnick)) {
        paramTroopMemberInfo.pyFirst_friendnick = ChnToSpell.b(paramstTroopMemberInfo.Nick, 2);
      }
      if (TextUtils.isEmpty(paramTroopMemberInfo.pyAll_friendnick)) {
        paramTroopMemberInfo.pyAll_friendnick = ChnToSpell.b(paramstTroopMemberInfo.Nick, 1);
      }
    }
    paramTroopMemberInfo.friendnick = paramstTroopMemberInfo.Nick;
  }
  
  private void a(String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    TroopMemberListHandlerProcessorConfig.a(this.appRuntime, paramString, paramLong);
    if (paramTroopInfo == null) {
      return;
    }
    if ((paramTroopInfo.mOldMemberNumSeq != paramTroopInfo.mMemberNumSeq) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq))
    {
      paramTroopInfo.mOldMemberNumSeq = paramTroopInfo.mMemberNumSeq;
      paramTroopInfo.mOldMemberCardSeq = paramTroopInfo.mMemberCardSeq;
      ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
    }
    ((ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).updateTroopMemberCache(paramString);
    ITroopNameHelperService localITroopNameHelperService = (ITroopNameHelperService)this.b.getRuntimeService(ITroopNameHelperService.class, "");
    if ((!localITroopNameHelperService.isInReturnTaskList(paramString)) && (!paramTroopInfo.hasSetTroopName())) {
      localITroopNameHelperService.updateTroopName(paramString);
    }
  }
  
  private void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    TroopAddFriendHandlerProcessorConfig.a().a(this.appRuntime);
    notifyUI(TroopObserver.TYPR_GET_TROOP_GETMEMBERLIST, paramBoolean, paramArrayOfObject);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l2 = b(paramToServiceMsg.getUin());
    long l1 = 0L;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localGetTroopMemberListReq.GroupCode);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(localGetTroopMemberListReq.ReqType);
    localObject = ((StringBuilder)localObject).toString();
    if (this.c.containsKey(localObject)) {
      l1 = ((Long)this.c.get(localObject)).longValue();
    }
    localGetTroopMemberListReq.GetListAppointTime = l1;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    return true;
  }
  
  private Object[] a(int paramInt, ToServiceMsg paramToServiceMsg, long paramLong, Object paramObject)
  {
    i = paramToServiceMsg.extraData.getInt("nFlag");
    l1 = paramToServiceMsg.extraData.getLong("nStartUin");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (Exception paramObject) {}
      if (!QLog.isColorLevel()) {
        break label110;
      }
    }
    catch (Exception paramObject)
    {
      paramToServiceMsg = null;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle_oidb_0x899_0| oidb_sso parseFrom byte ");
    ((StringBuilder)localObject1).append(paramObject.toString());
    QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject1).toString());
    label110:
    paramObject.printStackTrace();
    paramObject = "";
    int m;
    if (paramToServiceMsg != null)
    {
      m = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handle_oidb_0x899_0|oidb_sso.OIDBSSOPkg.result = ");
        ((StringBuilder)localObject1).append(m);
        QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = paramObject;
      if (paramToServiceMsg.bytes_bodybuffer.has())
      {
        localObject1 = paramObject;
        if (paramToServiceMsg.bytes_bodybuffer.get() != null)
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          localObject1 = paramObject;
        }
      }
    }
    label527:
    label691:
    try
    {
      localObject2 = new oidb_0x899.RspBody();
      localObject1 = paramObject;
      ((oidb_0x899.RspBody)localObject2).mergeFrom(paramToServiceMsg);
      paramToServiceMsg = paramObject;
      if (m != 0) {
        paramToServiceMsg = paramObject;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      Object localObject2;
      label323:
      boolean bool;
      label335:
      label982:
      label993:
      label999:
      label1013:
      label1019:
      break label999;
    }
    try
    {
      if (((oidb_0x899.RspBody)localObject2).str_errorinfo.has()) {
        paramToServiceMsg = String.valueOf(((oidb_0x899.RspBody)localObject2).str_errorinfo.get().toByteArray());
      }
    }
    catch (Exception paramToServiceMsg)
    {
      label780:
      label808:
      break label335;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handle_oidb_0x899_0|strErrorMsg = ");
        paramObject.append(paramToServiceMsg);
        QLog.i("Q.troopdisband.", 2, paramObject.toString());
      }
    }
    catch (Exception paramObject)
    {
      break label323;
    }
    bool = false;
    paramObject = null;
    paramInt = m;
    break label1019;
    localObject1 = null;
    bool = false;
    paramToServiceMsg = paramObject;
    paramObject = localObject1;
    for (;;)
    {
      paramInt = m;
      break label1019;
      localObject1 = paramToServiceMsg;
      if (m != 0) {
        break label999;
      }
      localObject1 = paramToServiceMsg;
      l2 = ((oidb_0x899.RspBody)localObject2).uint64_group_code.get();
      localObject1 = paramToServiceMsg;
      if (l2 != paramLong) {
        break label999;
      }
      try
      {
        localObject1 = ((oidb_0x899.RspBody)localObject2).rpt_memberlist.get();
        l3 = l1;
      }
      catch (Exception paramObject)
      {
        long l3;
        int k;
        break label993;
      }
      try
      {
        bool = ((oidb_0x899.RspBody)localObject2).uint64_start_uin.has();
        l2 = l1;
        if (bool) {
          k = i;
        }
      }
      catch (Exception paramObject)
      {
        break label982;
      }
      try
      {
        l3 = ((oidb_0x899.RspBody)localObject2).uint64_start_uin.get();
        l2 = l3;
        k = i;
        l1 = l3;
        if (!QLog.isColorLevel()) {
          break;
        }
        k = i;
        l1 = l3;
        paramObject = new StringBuilder();
        k = i;
        l1 = l3;
        paramObject.append("handle_oidb_0x899_0|lGetStartUin = ");
        k = i;
        l1 = l3;
        paramObject.append(l3);
        k = i;
        l1 = l3;
        QLog.i("Q.troopdisband.", 2, paramObject.toString());
        l2 = l3;
      }
      catch (Exception paramObject)
      {
        break label527;
        break label691;
        paramInt = 0;
        break label780;
        i += 1;
        break label808;
      }
      bool = true;
      paramObject = localObject1;
      i = k;
    }
    l3 = l2;
    bool = ((oidb_0x899.RspBody)localObject2).uint32_identify_flag.has();
    j = i;
    if (bool)
    {
      k = i;
      l1 = l2;
      i = ((oidb_0x899.RspBody)localObject2).uint32_identify_flag.get();
      j = i;
      k = i;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        k = i;
        l1 = l2;
        paramObject = new StringBuilder();
        k = i;
        l1 = l2;
        paramObject.append("handle_oidb_0x899_0|nGetIdentifyFlag = ");
        k = i;
        l1 = l2;
        paramObject.append(i);
        k = i;
        l1 = l2;
        QLog.i("Q.troopdisband.", 2, paramObject.toString());
        j = i;
      }
    }
    if (j == 5)
    {
      for (;;)
      {
        try
        {
          a(paramInt, paramLong, (List)localObject1);
          paramObject = localObject1;
          i = j;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder(200);
            paramObject.append("handle_oidb_0x899_0");
            paramObject.append("|lGetStartUin= ");
            paramObject.append(l2);
            paramObject.append("|nGetIdentifyFlag= ");
            paramObject.append(j);
            if (localObject1 == null) {
              break label1113;
            }
            paramInt = ((List)localObject1).size();
            paramObject.append("|size = ");
            paramObject.append(paramInt);
            paramObject.append("{");
            i = 0;
            if (i < paramInt)
            {
              localObject2 = (oidb_0x899.memberlist)((List)localObject1).get(i);
              if (localObject2 != null)
              {
                paramObject.append("[");
                paramObject.append(i);
                paramObject.append(",");
                paramObject.append(((oidb_0x899.memberlist)localObject2).uint64_member_uin);
                paramObject.append(",");
                paramObject.append(((oidb_0x899.memberlist)localObject2).uint32_uin_flag);
                paramObject.append("]");
                break label1118;
              }
              paramObject.append("[");
              paramObject.append(i);
              paramObject.append(", null");
              paramObject.append("]");
              break label1118;
            }
            paramObject.append("}");
            QLog.i("Q.troopdisband.", 2, paramObject.toString());
            l1 = l2;
            i = j;
            paramObject = localObject1;
          }
        }
        catch (Exception paramObject)
        {
          paramObject = localObject1;
          i = j;
          l1 = l2;
          continue;
        }
        bool = true;
        paramInt = m;
        continue;
        paramObject = localObject1;
        l1 = l3;
        continue;
        paramObject = null;
      }
      paramToServiceMsg = (ToServiceMsg)localObject1;
      paramInt = m;
      break label1013;
      paramInt = -1;
      paramToServiceMsg = paramObject;
      paramObject = null;
      bool = false;
      return new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramToServiceMsg, paramObject };
    }
  }
  
  private long b(String paramString)
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
  
  private String b(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  private void b(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    if (TextUtils.isEmpty(paramstTroopMemberInfo.strAutoRemark))
    {
      paramTroopMemberInfo.pyFirst_autoremark = "";
      paramTroopMemberInfo.pyAll_autoremark = "";
      return;
    }
    if (!paramstTroopMemberInfo.strAutoRemark.equals(paramTroopMemberInfo.autoremark))
    {
      paramTroopMemberInfo.pyFirst_autoremark = ChnToSpell.b(paramstTroopMemberInfo.strAutoRemark, 2);
      paramTroopMemberInfo.pyAll_autoremark = ChnToSpell.b(paramstTroopMemberInfo.strAutoRemark, 1);
      return;
    }
    if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_autoremark)) {
      paramTroopMemberInfo.pyFirst_autoremark = ChnToSpell.b(paramstTroopMemberInfo.strAutoRemark, 2);
    }
    if (TextUtils.isEmpty(paramTroopMemberInfo.pyAll_autoremark)) {
      paramTroopMemberInfo.pyAll_autoremark = ChnToSpell.b(paramstTroopMemberInfo.strAutoRemark, 1);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
            paramToServiceMsg.append(l);
            paramToServiceMsg.append("|");
          }
          TroopMemberListHandlerProcessorConfig.a(this.appRuntime, (TroopInfo)localObject1, localArrayList);
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetTroopMemberListForHeadBatch:");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.d("TroopMemberListHandler", 2, paramFromServiceMsg.toString());
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("getTroopMemberListBatch failed! retCode = ");
      paramToServiceMsg.append(i);
      QLog.e("TroopMemberListHandler", 1, paramToServiceMsg.toString());
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = paramToServiceMsg.extraData.getInt("serviceType");
    long l2 = paramToServiceMsg.extraData.getLong("troop_uin");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("updateAdmin");
    int i = paramToServiceMsg.extraData.getInt("nFlag");
    long l1 = paramToServiceMsg.extraData.getLong("nStartUin");
    int j = paramFromServiceMsg.getResultCode();
    Object localObject2 = null;
    boolean bool1;
    Object localObject1;
    if (j == 1000)
    {
      paramObject = a(k, paramToServiceMsg, l2, paramObject);
      i = ((Integer)paramObject[0]).intValue();
      l1 = ((Long)paramObject[1]).longValue();
      bool1 = ((Boolean)paramObject[2]).booleanValue();
      j = ((Integer)paramObject[3]).intValue();
      localObject1 = (String)paramObject[4];
      paramToServiceMsg = localObject2;
      if (paramObject[5] != null) {
        paramToServiceMsg = (List)paramObject[5];
      }
      paramObject = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)localObject1;
    }
    else
    {
      j = -1;
      paramToServiceMsg = "";
      paramObject = null;
      bool1 = false;
    }
    if (k == 0)
    {
      notifyUI(TroopObserver.TYPE_OIDB_0X899_0, bool1, new Object[] { Long.valueOf(l2), Integer.valueOf(i), paramObject, Long.valueOf(l1), Integer.valueOf(j), paramToServiceMsg });
    }
    else if (k == 1)
    {
      if (bool2)
      {
        localObject1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(l2));
        if (localObject1 != null) {
          TroopMemberUtil.a(this.b, (TroopInfo)localObject1, paramObject, true);
        }
      }
      notifyUI(TroopObserver.TYPE_OIDB_0X899_1, bool1, new Object[] { Long.valueOf(l2), Integer.valueOf(i), paramObject, Long.valueOf(l1), Integer.valueOf(j), paramToServiceMsg });
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handle_oidb_0x899_0");
      paramObject.append("|isSuccess = ");
      paramObject.append(bool1);
      paramObject.append("|resultcode = ");
      paramObject.append(paramFromServiceMsg.getResultCode());
      paramObject.append("|troopuin = ");
      paramObject.append(l2);
      paramObject.append("|flag = ");
      paramObject.append(i);
      paramObject.append("|lStartUin = ");
      paramObject.append(l1);
      paramObject.append("|result = ");
      paramObject.append(j);
      paramObject.append("|strErrorMsg = ");
      paramObject.append(paramToServiceMsg);
      QLog.i("Q.troopdisband.", 2, paramObject.toString());
    }
  }
  
  public TroopMemberInfo a(String paramString1, long paramLong, EntityManager paramEntityManager, stTroopMemberInfo paramstTroopMemberInfo, String paramString2)
  {
    TroopMemberInfo localTroopMemberInfo = new TroopMemberInfo();
    localTroopMemberInfo.troopuin = paramString1;
    localTroopMemberInfo.memberuin = paramString2;
    localTroopMemberInfo.friendnick = paramstTroopMemberInfo.Nick;
    localTroopMemberInfo.pyFirst_friendnick = ChnToSpell.b(localTroopMemberInfo.friendnick, 2);
    localTroopMemberInfo.pyAll_friendnick = ChnToSpell.b(localTroopMemberInfo.friendnick, 1);
    localTroopMemberInfo.pyFirst_troopnick = ChnToSpell.b(localTroopMemberInfo.troopnick, 2);
    localTroopMemberInfo.pyAll_troopnick = ChnToSpell.b(localTroopMemberInfo.troopnick, 1);
    localTroopMemberInfo.autoremark = paramstTroopMemberInfo.strAutoRemark;
    localTroopMemberInfo.faceid = paramstTroopMemberInfo.FaceId;
    localTroopMemberInfo.sex = paramstTroopMemberInfo.Gender;
    localTroopMemberInfo.status = paramstTroopMemberInfo.Status;
    localTroopMemberInfo.age = paramstTroopMemberInfo.Age;
    localTroopMemberInfo.alias = paramstTroopMemberInfo.sShowName;
    localTroopMemberInfo.datetime = paramLong;
    TroopMemberListHandlerProcessorConfig.a(localTroopMemberInfo, paramstTroopMemberInfo);
    localTroopMemberInfo.join_time = paramstTroopMemberInfo.dwJoinTime;
    localTroopMemberInfo.last_active_time = paramstTroopMemberInfo.dwLastSpeakTime;
    localTroopMemberInfo.active_point = paramstTroopMemberInfo.dwPoint;
    localTroopMemberInfo.credit_level = paramstTroopMemberInfo.dwCreditLevel;
    int i = paramstTroopMemberInfo.cConcerned;
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localTroopMemberInfo.isTroopFollowed = bool1;
    boolean bool1 = bool2;
    if (paramstTroopMemberInfo.cShielded == 1) {
      bool1 = true;
    }
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
    localTroopMemberInfo.mHonorRichFlag = paramstTroopMemberInfo.cRichFlag;
    if ((QLog.isColorLevel()) && (paramstTroopMemberInfo.cRichFlag != 0))
    {
      paramString1 = new StringBuilder();
      paramString1.append("honor_rich_friend_add,");
      paramString1.append(paramstTroopMemberInfo.cRichFlag);
      QLog.d("TroopMemberListHandler", 2, paramString1.toString());
    }
    paramEntityManager.persist(localTroopMemberInfo);
    return localTroopMemberInfo;
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x899_0");
      ((StringBuilder)localObject1).append("|troopuin = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("|flag = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("|nStartUin = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("|memberNum = ");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append("|filterMethod = ");
      ((StringBuilder)localObject1).append(paramInt4);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x899.memberlist();
    ((oidb_0x899.memberlist)localObject2).uint64_member_uin.set(0L);
    Object localObject1 = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject1).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject1).uint64_start_uin.set(paramLong2);
    if (paramInt2 == 4)
    {
      ((oidb_0x899.memberlist)localObject2).uint32_uin_flag.set(0);
    }
    else if (paramInt2 == 5)
    {
      ((oidb_0x899.ReqBody)localObject1).uint32_member_num.set(paramInt3);
      ((oidb_0x899.ReqBody)localObject1).uint32_filter_method.set(paramInt4);
    }
    else if (paramInt2 == 2)
    {
      ((oidb_0x899.memberlist)localObject2).uint32_privilege.set(1);
    }
    ((oidb_0x899.ReqBody)localObject1).uint32_identify_flag.set(paramInt2);
    ((oidb_0x899.ReqBody)localObject1).memberlist_opt.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2201);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt1);
    localObject1 = "OidbSvc.0x899_0";
    if ((paramInt1 != 0) && (paramInt1 == 1)) {
      localObject1 = "OidbSvc.0x899_9";
    }
    localObject1 = createToServiceMsg((String)localObject1);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject1).extraData.putInt("nFlag", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putLong("nStartUin", paramLong2);
    ((ToServiceMsg)localObject1).extraData.putInt("serviceType", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putBoolean("updateAdmin", paramBoolean);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0x899ForHead uin:");
      localStringBuilder.append(paramLong);
      QLog.i("TroopMemberListHandler", 2, localStringBuilder.toString());
    }
    a(9, paramLong, 0L, 5, 6, 2, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    a(0, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, List<Long> paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("send_oidb_0x899_0");
      ((StringBuilder)localObject).append("|troopuin = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("|flag = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("|nStartUin = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("|memberNum = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("|filterMethod = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
    }
    oidb_0x899.memberlist localmemberlist = new oidb_0x899.memberlist();
    localmemberlist.uint64_member_uin.set(0L);
    localmemberlist.uint32_shutup_timestap.set(0);
    Object localObject = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject).uint64_start_uin.set(paramLong2);
    if (paramInt1 == 3)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        ((oidb_0x899.ReqBody)localObject).rpt_uint64_uin_list.add(localLong);
      }
    }
    ((oidb_0x899.ReqBody)localObject).uint32_identify_flag.set(paramInt1);
    ((oidb_0x899.ReqBody)localObject).memberlist_opt.set(localmemberlist);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2201);
    paramList.uint32_result.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x899_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("nStartUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramToServiceMsg, (GetTroopMemberListResp)paramObject);
      return;
    }
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int i = paramToServiceMsg.extraData.getInt("type", 0);
    a(false, new Object[] { b(l), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("reqType", 0)), Long.valueOf(paramToServiceMsg.extraData.getLong("timestamp")), Integer.valueOf(i) });
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberListBy0x787 uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = Long.parseLong(paramString);
      localObject = new oidb_0x787.ReqBody();
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
  
  public void a(List<Long> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTroopMemberListForHeadBatch, size = ");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    double d1 = paramList.size();
    Double.isNaN(d1);
    int n = (int)Math.ceil(d1 / 50.0D);
    int k;
    for (int i = 0; i < n; i = k)
    {
      int i1 = paramList.size();
      k = i + 1;
      int m = k * 50;
      int j = m;
      if (i1 < m) {
        j = paramList.size();
      }
      Object localObject2 = paramList.subList(i * 50, j);
      localObject1 = new cmd0xaf6.ReqBody();
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
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    a(paramBoolean, paramString1, paramString2, false, paramInt, System.currentTimeMillis(), 0);
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramString1)) && (!"0".equals(paramString1)))
    {
      localObject1 = new ToServiceMsg("mobileqq.service", this.b.getAccount(), "friendlist.getTroopMemberList");
      ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
      ((ToServiceMsg)localObject1).extraData.putBoolean("force_refresh", paramBoolean1);
      ((ToServiceMsg)localObject1).extraData.putBoolean("needCallBackCache", paramBoolean2);
      ((ToServiceMsg)localObject1).extraData.putInt("reqType", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putLong("timestamp", paramLong);
      ((ToServiceMsg)localObject1).extraData.putInt("type", paramInt2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt1);
      localObject2 = ((StringBuilder)localObject2).toString();
      Bundle localBundle = ((ToServiceMsg)localObject1).extraData;
      if (this.c.containsKey(localObject2)) {
        paramLong = ((Long)this.c.get(localObject2)).longValue();
      } else {
        paramLong = 0L;
      }
      localBundle.putLong("get_list_appoint_time", paramLong);
    }
    try
    {
      ((ToServiceMsg)localObject1).extraData.putLong("uin", this.b.getLongAccountUin());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString1));
      ((ToServiceMsg)localObject1).extraData.putLong("troop_code", Long.parseLong(paramString2));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label262:
      break label262;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("FriendListHandler.getTroopMemberList error, NumberFormatException, troopUin: ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" troopCode: ");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject2).toString());
    }
    paramLong = System.currentTimeMillis();
    ((ToServiceMsg)localObject1).extraData.putLong("troop_time", paramLong);
    ((ToServiceMsg)localObject1).extraData.putLong("version", 3L);
    send((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopHandler.getTroopMemberList,Thread id:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      ((StringBuilder)localObject1).append(",threadName:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getName());
      ((StringBuilder)localObject1).append(", troopUin: ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" troopCode: ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("TroopMemberListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    return;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("error troopuin: ");
      paramString2.append(paramString1);
      QLog.e("TroopMemberListHandler", 2, paramString2.toString());
    }
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettroopmemberlist", 0, 1, 0, "", "", "", "");
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {}
    for (;;)
    {
      try
      {
        ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
        long l = Long.valueOf(paramToServiceMsg.extraData.getString("troopUin")).longValue();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetTroopCardDefaultNickBatch success=");
          paramToServiceMsg.append(bool);
          paramToServiceMsg.append(" troopUin=");
          paramToServiceMsg.append(l);
          QLog.d("TroopMemberListHandler", 2, paramToServiceMsg.toString());
        }
        paramToServiceMsg = new oidb_0x787.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          if (l != paramToServiceMsg.uint64_group_code.get()) {
            continue;
          }
          StringBuffer localStringBuffer = new StringBuffer();
          paramFromServiceMsg = paramToServiceMsg.rpt_msg_member_level_info.get();
          paramToServiceMsg = new ArrayList();
          Iterator localIterator = paramFromServiceMsg.iterator();
          if (localIterator.hasNext())
          {
            oidb_0x787.MemberLevelInfo localMemberLevelInfo = (oidb_0x787.MemberLevelInfo)localIterator.next();
            String str = String.valueOf(localMemberLevelInfo.uint64_uin.get());
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(" uin=");
              localStringBuffer.append(str.substring(0, 4));
            }
            if (!localMemberLevelInfo.bytes_nick_name.has()) {
              continue;
            }
            paramObject = localMemberLevelInfo.bytes_nick_name.get().toStringUtf8();
            paramFromServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(" nick=");
              localStringBuffer.append(MessageRecordUtil.a(paramObject));
              paramFromServiceMsg = paramObject;
            }
            paramObject = new TroopMemberCard();
            TroopMemberListHandlerProcessorConfig.a(paramObject, localMemberLevelInfo);
            paramObject = paramObject.colorCard;
            if (localITroopMemberInfoService == null) {
              continue;
            }
            if (!TextUtils.isEmpty(paramObject)) {
              continue;
            }
            paramObject = null;
            if (!TextUtils.isEmpty(paramFromServiceMsg)) {
              continue;
            }
            paramFromServiceMsg = null;
            localITroopMemberInfoService.saveTroopMemberEx(String.valueOf(l), str, paramObject, -100, paramFromServiceMsg, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
            paramToServiceMsg.add(new Pair(str, ((ITroopMemberNameService)this.b.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(String.valueOf(l), str)));
            continue;
          }
          notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_LIST_BY_787, true, new Object[] { String.valueOf(l), paramToServiceMsg });
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListHandler", 2, localStringBuffer.toString());
          }
          ((ITroopNameHelperService)this.b.getRuntimeService(ITroopNameHelperService.class, "")).reExecuteReturnTask(String.valueOf(l), true);
          return;
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetTroopMemberListBy0x787 result code = ");
        paramToServiceMsg.append(i);
        QLog.d("TroopMemberListHandler", 2, paramToServiceMsg.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        continue;
      }
      QLog.d("TroopMemberListHandler", 2, "handleGetTroopMemberListBy0x787 not success.");
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopMemberListHandler", 2, "handleGetTroopCardDefaultNickBatch ex", paramToServiceMsg);
      }
      return;
      paramFromServiceMsg = "";
      continue;
      continue;
    }
  }
  
  protected String dv_()
  {
    return "TroopMemberListHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("friendlist.getTroopMemberList");
      this.a.add("OidbSvc.0xaf6_0");
      this.a.add("OidbSvc.0x787_11");
      this.a.add("OidbSvc.0x899_0");
      this.a.add("OidbSvc.0x899_9");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
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
          QLog.d("TroopMemberListHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopMemberListHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("friendlist.getTroopMemberList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xaf6_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_11".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x899_0".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x899_9".equals(paramFromServiceMsg.getServiceCmd()))) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMemberListHandler
 * JD-Core Version:    0.7.0.1
 */