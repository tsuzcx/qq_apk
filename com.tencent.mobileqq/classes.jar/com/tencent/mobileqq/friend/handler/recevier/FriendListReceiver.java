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
import java.util.ArrayList<Lfriendlist.FriendInfo;>;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("batchUpdateFriendInfo| timestamp: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", isComplete: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IMCore.friend.FriendListReceiver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("batchUpdateFriendInfo| uin: ");
        localStringBuilder.append(localFriends1.uin);
        localStringBuilder.append(", oldFriend: ");
        localStringBuilder.append(localFriends2);
        QLog.d("IMCore.friend.FriendListReceiver", 2, localStringBuilder.toString());
      }
      if (localFriends2 != null)
      {
        int i = localFriends2.gathtertype;
        byte b = (byte)1;
        if (i == b)
        {
          localFriends1.gathtertype = b;
        }
        else
        {
          i = localFriends2.gathtertype;
          b = (byte)2;
          if (i == b) {
            localFriends1.gathtertype = b;
          }
        }
        localFriends1.age = localFriends2.age;
        localFriends1.smartRemark = localFriends2.smartRemark;
        localFriends1.gender = localFriends2.gender;
        localFriends1.recommReason = localFriends2.recommReason;
      }
      localArrayList.add(new Pair(localFriends1, localFriendInfo));
      ((ArrayList)localObject).add(localFriends1);
    }
    paramArrayList = ((FriendHandler)a()).a().iterator();
    while (paramArrayList.hasNext()) {
      ((BaseFriendProcessor)paramArrayList.next()).onBatchUpdateFriendInfo((List)localArrayList, paramLong, paramBoolean);
    }
    localFriendDataServiceImpl.saveFriendList((List)localObject, paramBoolean, paramLong);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("batchUpdateFriendInfo| friendList size: ");
      paramArrayList.append(((ArrayList)localObject).size());
      QLog.d("IMCore.friend.FriendListReceiver", 2, paramArrayList.toString());
    }
    return localObject;
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
    Object localObject2 = localFriendDataServiceImpl.getFriend(a().getCurrentAccountUin());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Friends();
    }
    ((Friends)localObject1).name = paramFriendInfo.nick;
    ((Friends)localObject1).remark = ((Friends)localObject1).remark;
    ((Friends)localObject1).uin = String.valueOf(paramFriendInfo.friendUin);
    ((Friends)localObject1).cSpecialFlag = paramFriendInfo.cSpecialFlag;
    ((Friends)localObject1).detalStatusFlag = paramFriendInfo.detalStatusFlag;
    ((Friends)localObject1).alias = paramFriendInfo.sShowName;
    ((Friends)localObject1).abilityBits = paramFriendInfo.uAbiFlag;
    ((Friends)localObject1).eNetwork = paramFriendInfo.eNetworkType;
    ((Friends)localObject1).groupid = paramFriendInfo.groupId;
    localObject2 = ((FriendHandler)a()).a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((BaseFriendProcessor)((Iterator)localObject2).next()).onUpdateSelfInfo((Friends)localObject1, paramFriendInfo);
    }
    localFriendDataServiceImpl.saveFriend((Friends)localObject1);
  }
  
  private final void a(FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "updateExtensionInfo");
    }
    String str = String.valueOf(paramFriendInfo.friendUin);
    FriendExtensionServiceImpl localFriendExtensionServiceImpl = FriendExtensionServiceImpl.getService((AppRuntime)a());
    Object localObject2 = localFriendExtensionServiceImpl.getExtensionInfo(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = str;
    }
    ((ExtensionInfo)localObject1).timestamp = System.currentTimeMillis();
    localObject2 = ((FriendHandler)a()).a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((BaseFriendProcessor)((Iterator)localObject2).next()).onUpdateExtensionInfo((ExtensionInfo)localObject1, paramFriendInfo, paramExtRspData);
    }
    localFriendExtensionServiceImpl.saveExtensionInfo((ExtensionInfo)localObject1);
  }
  
  private final void a(ArrayList<GroupInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      QLog.e("IMCore.friend.FriendListReceiver", 1, "updateGroupList| groupListResp is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListReceiver", 2, "updateGroupList");
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (GroupInfo)paramArrayList.next();
      Groups localGroups = new Groups();
      localGroups.group_id = ((GroupInfo)localObject).groupId;
      localGroups.group_name = ((GroupInfo)localObject).groupname;
      localGroups.group_friend_count = ((GroupInfo)localObject).friend_count;
      localGroups.seqid = ((GroupInfo)localObject).seqid;
      localArrayList.add(localGroups);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateGroupList| ");
        ((StringBuilder)localObject).append(localGroups);
        QLog.d("IMCore.friend.FriendListReceiver", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramArrayList = FriendDataServiceImpl.getService((AppRuntime)a());
    if (localArrayList.size() > 0) {
      paramArrayList.saveGroupList((List)localArrayList);
    }
  }
  
  private final void a(ArrayList<FriendInfo> paramArrayList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("batchUpdateExtensionInfo| timestamp: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", isComplete: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IMCore.friend.FriendListReceiver", 2, ((StringBuilder)localObject).toString());
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FriendExtensionServiceImpl localFriendExtensionServiceImpl = FriendExtensionServiceImpl.getService((AppRuntime)a());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      FriendInfo localFriendInfo = (FriendInfo)localIterator.next();
      String str = String.valueOf(localFriendInfo.friendUin);
      localObject = localFriendExtensionServiceImpl.getExtensionInfo(str);
      paramArrayList = (ArrayList<FriendInfo>)localObject;
      if (localObject == null)
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
    Object localObject2 = new HashMap();
    long l1 = System.currentTimeMillis();
    long l2 = ((FriendHandler)a()).a();
    Map localMap = (Map)localObject2;
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localMap.put("reqGetStatus", localObject1);
    localMap.put("friendListCount", String.valueOf(paramInt1));
    localMap.put("fromIndex", String.valueOf(paramInt2));
    localMap.put("reqCountEveryPage", String.valueOf(200));
    localMap.put("retryCount", String.valueOf(paramInt4));
    localMap.put("totalConsume", String.valueOf(l1 - l2));
    localMap.put("errorCode", String.valueOf(paramInt3));
    StatisticCollector.getInstance(a().getApplicationContext()).collectPerformance(null, "QQFriendListReqGetEvent", true, 0L, 0L, (HashMap)localObject2, null);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Long > 0L))
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        localObject1 = new HashMap();
        localObject2 = (Map)localObject1;
        ((Map)localObject2).put("mFriendListFailedCount", String.valueOf(this.jdField_a_of_type_Int));
        ((Map)localObject2).put("failedTime", String.valueOf(l1 - l2));
        StatisticCollector.getInstance(a().getApplicationContext()).collectPerformance(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, (HashMap)localObject1, null);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
      }
    }
    else
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = ((FriendHandler)a()).a();
      }
    }
  }
  
  private final void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if (localObject != null)
    {
      localObject = (FriendListRequestData)localObject;
      int k = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRequestFriendListResult| resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(',');
      localStringBuilder.append(" resendCount: ");
      localStringBuilder.append(k);
      localStringBuilder.append(", isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("IMCore.friend.FriendListReceiver", 1, localStringBuilder.toString());
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
        ((FriendHandler)a()).notifyUI(97, true, new Boolean[] { Boolean.valueOf(true), (Boolean)null });
        return;
      }
      ((FriendHandler)a()).notifyUI(1, false, null);
      ((FriendHandler)a()).notifyUI(97, false, null);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if (localObject1 != null)
    {
      localObject1 = (FriendListRequestData)localObject1;
      if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof GetFriendListResp)))
      {
        Object localObject3 = (GetFriendListResp)paramObject;
        if (((GetFriendListResp)localObject3).result != 1)
        {
          long l2 = ((FriendListRequestData)localObject1).getTimeStamp();
          int i = ((GetFriendListResp)localObject3).startIndex;
          int j = ((GetFriendListResp)localObject3).friend_count;
          int k = ((GetFriendListResp)localObject3).totoal_friend_count;
          int m = i + j;
          boolean bool;
          if (m >= k) {
            bool = true;
          } else {
            bool = false;
          }
          ArrayList localArrayList1 = ((FriendListRequestData)localObject1).getUinList();
          long l1 = l2;
          if (((GetFriendListResp)localObject3).vecFriendInfo != null)
          {
            localObject2 = ((GetFriendListResp)localObject3).vecFriendInfo.iterator();
            for (;;)
            {
              l1 = l2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localArrayList1.add(String.valueOf(((FriendInfo)((Iterator)localObject2).next()).friendUin));
            }
          }
          Object localObject2 = new ExtRspData((GetFriendListResp)localObject3);
          ((FriendHandler)a()).a().a(((GetFriendListResp)localObject3).cShowPcIcon);
          if (i == 0)
          {
            l1 = System.currentTimeMillis();
            a(((GetFriendListResp)localObject3).stSelfInfo);
          }
          a(((GetFriendListResp)localObject3).vecGroupInfo);
          ArrayList localArrayList2 = ((GetFriendListResp)localObject3).vecFriendInfo;
          Intrinsics.checkExpressionValueIsNotNull(localArrayList2, "data.vecFriendInfo");
          a(localArrayList2, l1, bool);
          localObject3 = ((GetFriendListResp)localObject3).vecFriendInfo;
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "data.vecFriendInfo");
          a((ArrayList)localObject3, (ExtRspData)localObject2, l1, bool);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("receiveFriendListResponse| timestamp: ");
            ((StringBuilder)localObject3).append(l1);
            ((StringBuilder)localObject3).append(", startIndex: ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(", ");
            ((StringBuilder)localObject3).append("friendCount: ");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append(", totalFriendCount: ");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(", isComplete: ");
            ((StringBuilder)localObject3).append(bool);
            ((StringBuilder)localObject3).append(", uinListSize: ");
            ((StringBuilder)localObject3).append(localArrayList1.size());
            QLog.d("IMCore.friend.FriendListReceiver", 2, ((StringBuilder)localObject3).toString());
          }
          if (!bool)
          {
            paramToServiceMsg = new FriendListRequestData(null, false, 0, 0, 0, 0, 0L, 0, 0, false, 1023, null);
            paramToServiceMsg.setUinList(localArrayList1);
            paramToServiceMsg.setFriendStartIndex(m);
            paramToServiceMsg.setFriendCount(200);
            paramToServiceMsg.setTimeStamp(l1);
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
          return;
        }
      }
      a(false, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    paramToServiceMsg = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
    for (;;)
    {
      throw paramToServiceMsg;
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
      if (((Friends)localObject).gathtertype == 1) {
        localFriends.gathtertype = ((byte)1);
      } else if (((Friends)localObject).gathtertype == 2) {
        localFriends.gathtertype = ((byte)2);
      }
      localFriends.age = ((Friends)localObject).age;
      localFriends.smartRemark = ((Friends)localObject).smartRemark;
      localFriends.gender = ((Friends)localObject).gender;
      localFriends.recommReason = ((Friends)localObject).recommReason;
    }
    localObject = ((FriendHandler)a()).a().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseFriendProcessor)((Iterator)localObject).next()).onUpdateFriendInfo(localFriends, paramFriendInfo);
    }
    localFriendDataServiceImpl.saveFriend(localFriends);
  }
  
  private final void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof GetFriendListResp)))
    {
      paramObject = (GetFriendListResp)paramObject;
      if (paramObject.result != 1)
      {
        paramFromServiceMsg = (FriendInfo)paramObject.vecFriendInfo.get(0);
        paramObject = new ExtRspData(paramObject);
        paramToServiceMsg = String.valueOf(paramFromServiceMsg.friendUin);
        i = paramFromServiceMsg.groupId;
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "friendResp");
        b(paramFromServiceMsg);
        a(paramFromServiceMsg, paramObject);
        if (!((FriendHandler)a()).a()) {
          ((FriendHandler)a()).notifyUI(1, true, Boolean.valueOf(true));
        }
        paramFromServiceMsg = ((FriendHandler)a()).a().iterator();
        while (paramFromServiceMsg.hasNext()) {
          ((BaseFriendProcessor)paramFromServiceMsg.next()).onGetFriendInfoFinish(paramToServiceMsg);
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("receiveFriendInfoResponse| friendUin: ");
          paramFromServiceMsg.append(paramToServiceMsg);
          paramFromServiceMsg.append(", groundId: ");
          paramFromServiceMsg.append(i);
          QLog.d("IMCore.friend.FriendListReceiver", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
    int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
    paramObject = new StringBuilder();
    paramObject.append("receiveFriendInfoResponse| failed resultCode: ");
    paramObject.append(paramFromServiceMsg.getResultCode());
    paramObject.append(", resendCount: ");
    paramObject.append(i);
    QLog.e("IMCore.friend.FriendListReceiver", 1, paramObject.toString());
    if ((paramFromServiceMsg.getResultCode() == 2901) && (i < 2))
    {
      paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
      ((FriendHandler)a()).a().a(paramToServiceMsg);
      return;
    }
    ((FriendHandler)a()).notifyUI(1, false, null);
    ((FriendHandler)a()).notifyUI(97, false, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.FriendListReceiver
 * JD-Core Version:    0.7.0.1
 */