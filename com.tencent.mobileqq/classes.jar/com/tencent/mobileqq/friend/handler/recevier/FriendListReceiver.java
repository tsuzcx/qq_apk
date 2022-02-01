package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.friend.api.impl.FriendExtensionServiceImpl;
import com.tencent.mobileqq.friend.config.FriendConfig;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.friend.servlet.FriendService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import friendlist.GetFriendListResp;
import friendlist.GroupInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/recevier/FriendListReceiver;", "Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "handler", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "mRequestFailedCount", "", "mRequestFailedTimestamp", "", "batchUpdateExtensionInfo", "", "friendRespList", "Ljava/util/ArrayList;", "Lfriendlist/FriendInfo;", "Lkotlin/collections/ArrayList;", "extRspData", "Lcom/tencent/mobileqq/friend/data/ExtRspData;", "timestamp", "isComplete", "", "batchUpdateFriendInfo", "Lcom/tencent/mobileqq/data/Friends;", "getCmd", "", "handleRequestFriendListResult", "isSuccess", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "receive", "req", "res", "receiveFriendInfoResponse", "receiveFriendListResponse", "reportRequestFriendListResult", "totalCount", "fromIndex", "errCode", "resendCount", "updateExtensionInfo", "friendResp", "updateFriendInfo", "friendRsp", "updateGroupList", "groupListResp", "Lfriendlist/GroupInfo;", "updateSelfInfo", "selfInfoResp", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendListReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public static final FriendListReceiver.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFriendHandlerRecevierFriendListReceiver$Companion = new FriendListReceiver.Companion(null);
  }
  
  public FriendListReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, (BusinessHandler)paramFriendHandler);
  }
  
  private final ArrayList<Friends> a(ArrayList<FriendInfo> paramArrayList, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "batchUpdateFriendInfo| timestamp: " + paramLong + ", isComplete: " + paramBoolean);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      FriendInfo localFriendInfo = (FriendInfo)paramArrayList.next();
      Friends localFriends1 = new Friends();
      localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
      localFriends1.name = localFriendInfo.nick;
      localFriends1.remark = localFriendInfo.remark;
      localFriends1.groupid = localFriendInfo.groupId;
      localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
      localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
      localFriends1.datetime = paramLong;
      localFriends1.alias = localFriendInfo.sShowName;
      localFriends1.abilityBits = localFriendInfo.uAbiFlag;
      localFriends1.eNetwork = localFriendInfo.eNetworkType;
      localFriends1.netTypeIconId = localFriendInfo.eIconType;
      localFriends1.strTermDesc = localFriendInfo.strTermDesc;
      localFriends1.iTermType = localFriendInfo.iTermType;
      localFriends1.setShieldFlag(false);
      Friends localFriends2 = localFriendDataServiceImpl.getFriend(localFriends1.uin, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendListReceiver", 2, "batchUpdateFriendInfo| uin: " + localFriends1.uin + ", oldFriend: " + localFriends2);
      }
      if (localFriends2 != null)
      {
        if (localFriends2.gathtertype != (byte)1) {
          break label389;
        }
        localFriends1.gathtertype = ((byte)1);
      }
      for (;;)
      {
        localFriends1.age = localFriends2.age;
        localFriends1.smartRemark = localFriends2.smartRemark;
        localFriends1.gender = localFriends2.gender;
        localFriends1.recommReason = localFriends2.recommReason;
        localArrayList2.add(new Pair(localFriends1, localFriendInfo));
        localArrayList1.add(localFriends1);
        break;
        label389:
        if (localFriends2.gathtertype == (byte)2) {
          localFriends1.gathtertype = ((byte)2);
        }
      }
    }
    paramArrayList = ((FriendHandler)a()).a().iterator();
    while (paramArrayList.hasNext()) {
      ((BaseFriendProcessor)paramArrayList.next()).onBatchUpdateFriendInfo((List)localArrayList2, paramLong, paramBoolean);
    }
    localFriendDataServiceImpl.saveFriendList((List)localArrayList1, paramBoolean, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "batchUpdateFriendInfo| friendList size: " + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  private final void a(FriendInfo paramFriendInfo)
  {
    if (paramFriendInfo == null)
    {
      QLog.e("IMCore.friend.FriendListReceiver", 1, "updateSelfInfo| selfInfoResp is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "updateSelfInfo");
    }
    FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
    Friends localFriends = localFriendDataServiceImpl.getFriend(a().getCurrentAccountUin());
    if (localFriends == null) {
      localFriends = new Friends();
    }
    for (;;)
    {
      localFriends.name = paramFriendInfo.nick;
      localFriends.remark = localFriends.remark;
      localFriends.uin = String.valueOf(paramFriendInfo.friendUin);
      localFriends.cSpecialFlag = paramFriendInfo.cSpecialFlag;
      localFriends.detalStatusFlag = paramFriendInfo.detalStatusFlag;
      localFriends.alias = paramFriendInfo.sShowName;
      localFriends.abilityBits = paramFriendInfo.uAbiFlag;
      localFriends.eNetwork = paramFriendInfo.eNetworkType;
      localFriends.groupid = paramFriendInfo.groupId;
      Iterator localIterator = ((FriendHandler)a()).a().iterator();
      while (localIterator.hasNext()) {
        ((BaseFriendProcessor)localIterator.next()).onUpdateSelfInfo(localFriends, paramFriendInfo);
      }
      localFriendDataServiceImpl.saveFriend(localFriends);
      return;
    }
  }
  
  private final void a(FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "updateExtensionInfo");
    }
    Object localObject = String.valueOf(paramFriendInfo.friendUin);
    FriendExtensionServiceImpl localFriendExtensionServiceImpl = FriendExtensionServiceImpl.getService((AppRuntime)a());
    ExtensionInfo localExtensionInfo = localFriendExtensionServiceImpl.getExtensionInfo((String)localObject);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = ((String)localObject);
    }
    for (;;)
    {
      localExtensionInfo.timestamp = System.currentTimeMillis();
      localObject = ((FriendHandler)a()).a().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseFriendProcessor)((Iterator)localObject).next()).onUpdateExtensionInfo(localExtensionInfo, paramFriendInfo, paramExtRspData);
      }
      localFriendExtensionServiceImpl.saveExtensionInfo(localExtensionInfo);
      return;
    }
  }
  
  private final void a(ArrayList<GroupInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      QLog.e("IMCore.friend.FriendListReceiver", 1, "updateGroupList| groupListResp is null");
    }
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendListReceiver", 2, "updateGroupList");
      }
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)paramArrayList.next();
        Groups localGroups = new Groups();
        localGroups.group_id = localGroupInfo.groupId;
        localGroups.group_name = localGroupInfo.groupname;
        localGroups.group_friend_count = localGroupInfo.friend_count;
        localGroups.seqid = localGroupInfo.seqid;
        localArrayList.add(localGroups);
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.friend.FriendListReceiver", 2, "updateGroupList| " + localGroups);
        }
      }
      paramArrayList = FriendDataServiceImpl.getService((AppRuntime)a());
    } while (localArrayList.size() <= 0);
    paramArrayList.saveGroupList((List)localArrayList);
  }
  
  private final void a(ArrayList<FriendInfo> paramArrayList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "batchUpdateExtensionInfo| timestamp: " + paramLong + ", isComplete: " + paramBoolean);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FriendExtensionServiceImpl localFriendExtensionServiceImpl = FriendExtensionServiceImpl.getService((AppRuntime)a());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      FriendInfo localFriendInfo = (FriendInfo)localIterator.next();
      String str = String.valueOf(localFriendInfo.friendUin);
      ExtensionInfo localExtensionInfo = localFriendExtensionServiceImpl.getExtensionInfo(str);
      paramArrayList = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramArrayList = new ExtensionInfo();
        paramArrayList.uin = str;
      }
      paramArrayList.timestamp = paramLong;
      localArrayList2.add(new Pair(paramArrayList, localFriendInfo));
      localArrayList1.add(paramArrayList);
    }
    paramArrayList = ((FriendHandler)a()).a().iterator();
    while (paramArrayList.hasNext()) {
      ((BaseFriendProcessor)paramArrayList.next()).onBatchUpdateExtensionInfo((List)localArrayList2, paramExtRspData, paramLong, paramBoolean);
    }
    localFriendExtensionServiceImpl.saveExtensionInfoList((List)localArrayList1);
  }
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    long l1 = System.currentTimeMillis();
    long l2 = ((FriendHandler)a()).a();
    Map localMap = (Map)localHashMap;
    Object localObject;
    if (paramBoolean)
    {
      localObject = "1";
      localMap.put("reqGetStatus", localObject);
      ((Map)localHashMap).put("friendListCount", String.valueOf(paramInt1));
      ((Map)localHashMap).put("fromIndex", String.valueOf(paramInt2));
      ((Map)localHashMap).put("reqCountEveryPage", String.valueOf(200));
      ((Map)localHashMap).put("retryCount", String.valueOf(paramInt4));
      ((Map)localHashMap).put("totalConsume", String.valueOf(l1 - l2));
      ((Map)localHashMap).put("errorCode", String.valueOf(paramInt3));
      StatisticCollector.getInstance(a().getApplicationContext()).collectPerformance(null, "QQFriendListReqGetEvent", true, 0L, 0L, localHashMap, null);
      if (!paramBoolean) {
        break label319;
      }
      if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Long > 0L))
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        localObject = new HashMap();
        ((Map)localObject).put("mFriendListFailedCount", String.valueOf(this.jdField_a_of_type_Int));
        ((Map)localObject).put("failedTime", String.valueOf(l1 - l2));
        StatisticCollector.getInstance(a().getApplicationContext()).collectPerformance(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, (HashMap)localObject, null);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
      }
    }
    label319:
    do
    {
      return;
      localObject = "0";
      break;
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Long != 0L);
    this.jdField_a_of_type_Long = ((FriendHandler)a()).a();
  }
  
  private final void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
    }
    localObject = (FriendListRequestData)localObject;
    int k = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
    QLog.d("IMCore.friend.FriendListReceiver", 1, "handleRequestFriendListResult| resultCode: " + paramFromServiceMsg.getResultCode() + ',' + " resendCount: " + k + ", isSuccess: " + paramBoolean);
    if ((paramFromServiceMsg.getResultCode() == 2901) && (k < 2))
    {
      paramToServiceMsg.extraData.putInt("k_resend_cnt", k + 1);
      ((FriendHandler)a()).a().a(paramToServiceMsg);
      return;
    }
    ((FriendHandler)a()).a(0L);
    int j = ((FriendListRequestData)localObject).getTotalFriendCount();
    int m = ((FriendListRequestData)localObject).getFriendStartIndex();
    int i = j;
    if (j == 0)
    {
      i = j;
      if ((paramObject instanceof GetFriendListResp)) {
        i = ((GetFriendListResp)paramObject).totoal_friend_count;
      }
    }
    a(paramBoolean, i, m, paramFromServiceMsg.getResultCode(), k);
    if (paramBoolean)
    {
      ((FriendHandler)a()).notifyUI(1, true, Boolean.valueOf(true));
      ((FriendHandler)a()).notifyUI(99, true, new Boolean[] { Boolean.valueOf(true), (Boolean)null });
      return;
    }
    ((FriendHandler)a()).notifyUI(1, false, null);
    ((FriendHandler)a()).notifyUI(99, false, null);
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
    }
    localObject1 = (FriendListRequestData)localObject1;
    if ((!paramFromServiceMsg.isSuccess()) || (!(paramObject instanceof GetFriendListResp)) || (((GetFriendListResp)paramObject).result == 1)) {
      a(false, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      return;
      long l = ((FriendListRequestData)localObject1).getTimeStamp();
      int i = ((GetFriendListResp)paramObject).startIndex;
      int j = ((GetFriendListResp)paramObject).friend_count;
      int k = ((GetFriendListResp)paramObject).totoal_friend_count;
      if (i + j >= k) {}
      ArrayList localArrayList1;
      for (boolean bool = true;; bool = false)
      {
        localArrayList1 = ((FriendListRequestData)localObject1).getUinList();
        if (((GetFriendListResp)paramObject).vecFriendInfo == null) {
          break;
        }
        localObject2 = ((GetFriendListResp)paramObject).vecFriendInfo.iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList1.add(String.valueOf(((FriendInfo)((Iterator)localObject2).next()).friendUin));
        }
      }
      Object localObject2 = new ExtRspData((GetFriendListResp)paramObject);
      ((FriendHandler)a()).a().a(((GetFriendListResp)paramObject).cShowPcIcon);
      if (i == 0)
      {
        l = System.currentTimeMillis();
        a(((GetFriendListResp)paramObject).stSelfInfo);
      }
      a(((GetFriendListResp)paramObject).vecGroupInfo);
      ArrayList localArrayList2 = ((GetFriendListResp)paramObject).vecFriendInfo;
      Intrinsics.checkExpressionValueIsNotNull(localArrayList2, "data.vecFriendInfo");
      a(localArrayList2, l, bool);
      localArrayList2 = ((GetFriendListResp)paramObject).vecFriendInfo;
      Intrinsics.checkExpressionValueIsNotNull(localArrayList2, "data.vecFriendInfo");
      a(localArrayList2, (ExtRspData)localObject2, l, bool);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendListReceiver", 2, "receiveFriendListResponse| timestamp: " + l + ", startIndex: " + i + ", " + "friendCount: " + j + ", totalFriendCount: " + k + ", isComplete: " + bool + ", uinListSize: " + localArrayList1.size());
      }
      if (!bool)
      {
        paramToServiceMsg = new FriendListRequestData(null, false, 0, 0, 0, 0, 0L, 0, 0, false, 1023, null);
        paramToServiceMsg.setUinList(localArrayList1);
        paramToServiceMsg.setFriendStartIndex(i + j);
        paramToServiceMsg.setFriendCount(200);
        paramToServiceMsg.setTimeStamp(l);
        paramToServiceMsg.setTotalFriendCount(k);
        paramToServiceMsg.setPullRefresh(((FriendListRequestData)localObject1).isPullRefresh());
        paramToServiceMsg.setShowTermType(1);
        ((FriendHandler)a()).a(paramToServiceMsg, false);
        return;
      }
      a(true, paramToServiceMsg, paramFromServiceMsg, paramObject);
      paramToServiceMsg = ((FriendHandler)a()).a().iterator();
      while (paramToServiceMsg.hasNext()) {
        ((BaseFriendProcessor)paramToServiceMsg.next()).onGetFriendListFinish(((FriendListRequestData)localObject1).isPullRefresh(), localArrayList1, (ExtRspData)localObject2);
      }
    }
  }
  
  private final void b(FriendInfo paramFriendInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "updateFriendInfo");
    }
    Friends localFriends = new Friends();
    FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
    localFriends.name = paramFriendInfo.nick;
    localFriends.remark = paramFriendInfo.remark;
    localFriends.uin = String.valueOf(paramFriendInfo.friendUin);
    localFriends.groupid = paramFriendInfo.groupId;
    localFriends.cSpecialFlag = paramFriendInfo.cSpecialFlag;
    if (localFriends.cSpecialFlag < 0)
    {
      QLog.d("IMCore.friend.FriendListReceiver", 1, "cSpecialFlag is 0xff");
      localFriends.cSpecialFlag = 0;
    }
    localFriends.detalStatusFlag = paramFriendInfo.detalStatusFlag;
    localFriends.alias = paramFriendInfo.sShowName;
    localFriends.iTermType = paramFriendInfo.iTermType;
    localFriends.abilityBits = paramFriendInfo.uAbiFlag;
    localFriends.netTypeIconId = paramFriendInfo.eIconType;
    localFriends.strTermDesc = paramFriendInfo.strTermDesc;
    localFriends.setShieldFlag(false);
    Object localObject = localFriendDataServiceImpl.getFriend(localFriends.uin);
    if (localObject != null)
    {
      localFriends.datetime = ((Friends)localObject).datetime;
      localFriends.lastLoginType = ((Friends)localObject).lastLoginType;
      if (((Friends)localObject).gathtertype != 1) {
        break label278;
      }
      localFriends.gathtertype = ((byte)1);
    }
    for (;;)
    {
      localFriends.age = ((Friends)localObject).age;
      localFriends.smartRemark = ((Friends)localObject).smartRemark;
      localFriends.gender = ((Friends)localObject).gender;
      localFriends.recommReason = ((Friends)localObject).recommReason;
      localObject = ((FriendHandler)a()).a().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseFriendProcessor)((Iterator)localObject).next()).onUpdateFriendInfo(localFriends, paramFriendInfo);
      }
      label278:
      if (((Friends)localObject).gathtertype == 2) {
        localFriends.gathtertype = ((byte)2);
      }
    }
    localFriendDataServiceImpl.saveFriend(localFriends);
  }
  
  private final void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((!paramFromServiceMsg.isSuccess()) || (!(paramObject instanceof GetFriendListResp)) || (((GetFriendListResp)paramObject).result == 1))
    {
      i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      QLog.e("IMCore.friend.FriendListReceiver", 1, "receiveFriendInfoResponse| failed resultCode: " + paramFromServiceMsg.getResultCode() + ", resendCount: " + i);
      if ((paramFromServiceMsg.getResultCode() == 2901) && (i < 2))
      {
        paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
        ((FriendHandler)a()).a().a(paramToServiceMsg);
      }
    }
    do
    {
      return;
      ((FriendHandler)a()).notifyUI(1, false, null);
      ((FriendHandler)a()).notifyUI(99, false, null);
      return;
      paramToServiceMsg = (FriendInfo)((GetFriendListResp)paramObject).vecFriendInfo.get(0);
      paramObject = new ExtRspData((GetFriendListResp)paramObject);
      paramFromServiceMsg = String.valueOf(paramToServiceMsg.friendUin);
      i = paramToServiceMsg.groupId;
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "friendResp");
      b(paramToServiceMsg);
      a(paramToServiceMsg, paramObject);
      if (!((FriendHandler)a()).a()) {
        ((FriendHandler)a()).notifyUI(1, true, Boolean.valueOf(true));
      }
      paramToServiceMsg = ((FriendHandler)a()).a().iterator();
      while (paramToServiceMsg.hasNext()) {
        ((BaseFriendProcessor)paramToServiceMsg.next()).onGetFriendInfoFinish(paramFromServiceMsg);
      }
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendListReceiver", 2, "receiveFriendInfoResponse| friendUin: " + paramFromServiceMsg + ", groundId: " + i);
  }
  
  @NotNull
  public String a()
  {
    return "friendlist.getFriendGroupList";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    Serializable localSerializable = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if ((localSerializable instanceof FriendListRequestData))
    {
      if (((FriendListRequestData)localSerializable).isRequestSingle())
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    QLog.e("IMCore.friend.FriendListReceiver", 1, "GET_FRIEND_GROUP_LIST| requestData is not FriendListRequestData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.FriendListReceiver
 * JD-Core Version:    0.7.0.1
 */