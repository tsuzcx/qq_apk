package com.tencent.mobileqq.friends.intimate;

import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Req;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopList;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsHelper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.multicard.MultiCardManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e.GroupList;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e.ReqBody;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e.RspBody;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3.ReqBody;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3.RspBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScore;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.ReqBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody;
import tencent.im.oidb.oidb_0xd45.oidb_0xd45.ReqBody;
import tencent.im.oidb.oidb_0xd45.oidb_0xd45.RspBody;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.FriendData;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.NotFriendData;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.ReqBody;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.RspBody;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c.ReqBody;
import tencent.im.oidb.oidb_0xd6f.oidb_0xd6f.ReqBody;
import tencent.im.oidb.oidb_0xd84.ReqBody;

public class IntimateInfoHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public IntimateInfoHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private oidb_0xcf4.RspBody a(oidb_0xd4a.FriendData paramFriendData)
  {
    oidb_0xcf4.RspBody localRspBody = new oidb_0xcf4.RspBody();
    localRspBody.uint64_from_uin.set(paramFriendData.uint64_from_uin.get());
    localRspBody.uint64_to_uin.set(paramFriendData.uint64_to_uin.get());
    if (paramFriendData.msg_cur_mutual_mark_info.has()) {
      localRspBody.msg_cur_mutual_mark_info.set(paramFriendData.msg_cur_mutual_mark_info.get());
    }
    if (paramFriendData.msg_friend_info.has()) {
      localRspBody.msg_friend_info.set(paramFriendData.msg_friend_info.get());
    }
    if (paramFriendData.msg_common_group_chat_info.has()) {
      localRspBody.msg_common_group_chat_info.set(paramFriendData.msg_common_group_chat_info.get());
    }
    if (paramFriendData.rpt_msg_mutual_mark_info.has()) {
      localRspBody.rpt_msg_mutual_mark_info.set(paramFriendData.rpt_msg_mutual_mark_info.get());
    }
    if (paramFriendData.rpt_msg_dna_info.has()) {
      localRspBody.rpt_msg_dna_info.set(paramFriendData.rpt_msg_dna_info.get());
    }
    if (paramFriendData.rpt_msg_prefetch_mutual_mark_info.has()) {
      localRspBody.rpt_msg_prefetch_mutual_mark_info.set(paramFriendData.rpt_msg_prefetch_mutual_mark_info.get());
    }
    if (paramFriendData.rpt_msg_data_tips.has()) {
      localRspBody.rpt_msg_data_tips.set(paramFriendData.rpt_msg_data_tips.get());
    }
    if (paramFriendData.string_reddot_data.has())
    {
      oidb_0xcf4.CommonBody localCommonBody = new oidb_0xcf4.CommonBody();
      localCommonBody.uint32_oidb_cmd.set(3399);
      localCommonBody.string_oidb_body.set(paramFriendData.string_reddot_data.get());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localCommonBody);
      localRspBody.rpt_msg_common_rspbody.set(localArrayList);
    }
    if (paramFriendData.rpt_msg_mutual_score.has()) {
      localRspBody.rpt_msg_mutual_score.set(paramFriendData.rpt_msg_mutual_score.get());
    }
    return localRspBody;
  }
  
  private oidb_0xcf4.RspBody a(oidb_0xd4a.NotFriendData paramNotFriendData)
  {
    oidb_0xcf4.RspBody localRspBody = new oidb_0xcf4.RspBody();
    localRspBody.uint64_from_uin.set(paramNotFriendData.uint64_from_uin.get());
    localRspBody.uint64_to_uin.set(paramNotFriendData.uint64_to_uin.get());
    if (paramNotFriendData.msg_common_group_chat_info.has()) {
      localRspBody.msg_common_group_chat_info.set(paramNotFriendData.msg_common_group_chat_info.get());
    }
    if (paramNotFriendData.rpt_msg_dna_info.has()) {
      localRspBody.rpt_msg_dna_info.set(paramNotFriendData.rpt_msg_dna_info.get());
    }
    return localRspBody;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xcf3.RspBody());
    paramToServiceMsg = paramToServiceMsg.extraData.getString("friendUin");
    boolean bool;
    if (i == 0)
    {
      ((IntimateInfoManager)this.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).b(paramToServiceMsg);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("handleDisbandIntimateRelationship, friendUin: %s, isSuccess: %s, result: %s", new Object[] { paramToServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    notifyUI(1, bool, new Object[] { paramToServiceMsg, Boolean.valueOf(false) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xcf4.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("friendUin");
    boolean bool;
    if (i == 0)
    {
      paramToServiceMsg = IntimateInfo.copyFrom(this.a, (oidb_0xcf4.RspBody)localObject);
      bool = true;
    }
    else
    {
      paramToServiceMsg = null;
      bool = false;
    }
    if (paramToServiceMsg != null)
    {
      paramObject = (IntimateInfoManager)this.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
      localObject = paramObject.a(paramFromServiceMsg);
      if (localObject != null)
      {
        paramToServiceMsg.lastAnimAfterScore = ((IntimateInfo)localObject).lastAnimAfterScore;
        paramToServiceMsg.lastAnimAfterFriendDays = ((IntimateInfo)localObject).lastAnimAfterFriendDays;
        if (com.tencent.qphone.base.util.QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetIntimateInfo old: ");
          localStringBuilder.append(localObject);
          com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, localStringBuilder.toString());
        }
      }
      paramObject.a(paramFromServiceMsg, paramToServiceMsg);
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("handleGetIntimateInfo, isSuccess: %s, result: %s, intimateInfo: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg }));
    }
    notifyUI(0, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Long localLong = Long.valueOf(0L);
    long l1 = ((Long)paramToServiceMsg.getAttribute("groupUin", localLong)).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("fromUin", localLong)).longValue();
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetIntimateGroupRecommendUinList ");
      paramToServiceMsg.append(l1);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l2);
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = new oidb_0xd45.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      l1 = paramToServiceMsg.uint64_from_uin.get();
      l2 = paramToServiceMsg.uint64_group_code.get();
      paramFromServiceMsg = new ArrayList();
      if (paramToServiceMsg.rpt_uint64_uin_list.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_uint64_uin_list.get().iterator();
        while (paramToServiceMsg.hasNext()) {
          paramFromServiceMsg.add((Long)paramToServiceMsg.next());
        }
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetIntimateGroupRecommendUinList succ: ");
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append(" ");
        paramToServiceMsg.append(l2);
        paramToServiceMsg.append(" ");
        paramToServiceMsg.append(paramFromServiceMsg.toString());
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramToServiceMsg.toString());
      }
      notifyUI(5, true, new Object[] { Long.valueOf(l2), paramFromServiceMsg });
      if (!paramFromServiceMsg.isEmpty()) {
        ((MultiCardManager)this.a.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER)).a(l2, paramFromServiceMsg);
      }
    }
    else
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetIntimateGroupRecommendUinList failed result:");
        paramToServiceMsg.append(i);
        com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, paramToServiceMsg.toString());
      }
      notifyUI(5, false, new Object[] { Long.valueOf(l1), null });
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Long localLong = Long.valueOf(0L);
    long l1 = ((Long)paramToServiceMsg.getAttribute("toUin", localLong)).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("fromUin", localLong)).longValue();
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSendDateTypeEventToServer ");
      paramToServiceMsg.append(l1);
      paramToServiceMsg.append(" ");
      paramToServiceMsg.append(l2);
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = new oidb_0xcf4.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      l1 = paramToServiceMsg.uint64_from_uin.get();
      l2 = paramToServiceMsg.uint64_to_uin.get();
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSendDateTypeEventToServer succ: ");
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append(" ");
        paramToServiceMsg.append(l2);
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramToServiceMsg.toString());
      }
      notifyUI(6, true, new Object[] { Long.valueOf(l2) });
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSendDateTypeEventToServer failed result:");
      paramToServiceMsg.append(i);
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, paramToServiceMsg.toString());
    }
    notifyUI(6, false, new Object[] { Long.valueOf(l1) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleGetGroupIntimateInfos ");
    }
    Object localObject1 = paramToServiceMsg.getAttribute("exactData1");
    Object localObject3 = new oidb_0xd4a.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    paramToServiceMsg = " ";
    if (i == 0)
    {
      paramFromServiceMsg = new HashMap(50);
      paramObject = (MultiCardManager)this.a.getManager(QQManagerFactory.TROOP_AIO_MULTI_CARD_MANAGER);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((oidb_0xd4a.RspBody)localObject3).uint64_group_code.get());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject4;
      Object localObject5;
      if (((oidb_0xd4a.RspBody)localObject3).rpt_msg_friend_data.has())
      {
        localObject4 = ((oidb_0xd4a.RspBody)localObject3).rpt_msg_friend_data.get().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (oidb_0xd4a.FriendData)((Iterator)localObject4).next();
          Object localObject6 = a((oidb_0xd4a.FriendData)localObject5);
          localObject6 = IntimateInfo.copyFrom(this.a, (oidb_0xcf4.RspBody)localObject6);
          paramFromServiceMsg.put(Long.valueOf(((oidb_0xd4a.FriendData)localObject5).uint64_to_uin.get()), localObject6);
          paramObject.a((String)localObject2, (IntimateInfo)localObject6);
        }
      }
      if (((oidb_0xd4a.RspBody)localObject3).rpt_msg_not_friend_data.has())
      {
        localObject3 = ((oidb_0xd4a.RspBody)localObject3).rpt_msg_not_friend_data.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (oidb_0xd4a.NotFriendData)((Iterator)localObject3).next();
          localObject5 = a((oidb_0xd4a.NotFriendData)localObject4);
          localObject5 = IntimateInfo.copyFrom(this.a, (oidb_0xcf4.RspBody)localObject5);
          paramFromServiceMsg.put(Long.valueOf(((oidb_0xd4a.NotFriendData)localObject4).uint64_to_uin.get()), localObject5);
          paramObject.a((String)localObject2, (IntimateInfo)localObject5);
        }
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetGroupIntimateInfos succ: ");
        paramObject.append((String)localObject2);
        paramObject.append(" ");
        paramObject.append(paramFromServiceMsg.toString());
        paramObject.append(" ");
        if (localObject1 != null) {
          paramToServiceMsg = localObject1.toString();
        }
        paramObject.append(paramToServiceMsg);
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramObject.toString());
      }
      notifyUI(7, true, new Object[] { paramFromServiceMsg, localObject1 });
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetGroupIntimateInfos failed result:");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(" ");
      if (localObject1 != null) {
        paramToServiceMsg = localObject1.toString();
      }
      paramFromServiceMsg.append(paramToServiceMsg);
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, paramFromServiceMsg.toString());
    }
    notifyUI(7, false, new Object[] { null, localObject1 });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      Object localObject = new oidb_0xe3e.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramFromServiceMsg = new ArrayList();
      if (i == 0)
      {
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, "HandleGetTroopWithCommonFriendsList is Success");
        }
        int j;
        long l;
        if (((oidb_0xe3e.RspBody)localObject).uint32_cache_time_seconds.has())
        {
          j = ((oidb_0xe3e.RspBody)localObject).uint32_cache_time_seconds.get();
          if (j != 0)
          {
            i = j;
            if (j <= 3600) {}
          }
          else
          {
            i = 200;
          }
          l = System.currentTimeMillis();
          TroopWithCommonFriendsHelper.a(String.valueOf(((Long)paramToServiceMsg.getAttribute("frienduin", Long.valueOf(0L))).longValue()), l);
        }
        else
        {
          i = 0;
        }
        if (((oidb_0xe3e.RspBody)localObject).rpt_group_list.has())
        {
          paramToServiceMsg = ((oidb_0xe3e.RspBody)localObject).rpt_group_list.get();
          j = 0;
          while (j < paramToServiceMsg.size())
          {
            paramObject = new TroopList();
            localObject = (oidb_0xe3e.GroupList)paramToServiceMsg.get(j);
            if (((oidb_0xe3e.GroupList)localObject).uint64_group_code.has()) {
              l = ((oidb_0xe3e.GroupList)localObject).uint64_group_code.get();
            } else {
              l = 0L;
            }
            int k;
            if (((oidb_0xe3e.GroupList)localObject).uint32_common_friend_count.has()) {
              k = ((oidb_0xe3e.GroupList)localObject).uint32_common_friend_count.get();
            } else {
              k = 0;
            }
            paramObject.a = l;
            paramObject.b = k;
            paramFromServiceMsg.add(paramObject);
            j += 1;
          }
        }
        notifyUI(8, true, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
        return;
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, "HandleGetTroopWithCommonFriendsList is failed");
      }
      notifyUI(8, false, new Object[] { Integer.valueOf(0), paramFromServiceMsg });
    }
  }
  
  public void a(int paramInt, List<TroopList> paramList)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, "TroopWithCommonFriendsNotify");
    }
    notifyUI(8, true, new Object[] { Integer.valueOf(paramInt), paramList });
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendDateTypeEventToServer ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0xcf4.ReqBody();
    long l = this.a.getLongAccountUin();
    ((oidb_0xcf4.ReqBody)localObject).uint64_from_uin.set(l);
    ((oidb_0xcf4.ReqBody)localObject).uint64_to_uin.set(paramLong);
    ((oidb_0xcf4.ReqBody)localObject).eDateType.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0xcf4_1", 3316, 1, ((oidb_0xcf4.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("toUin", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("fromUin", Long.valueOf(l));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getIntimateGroupRecommendUinList ");
      ((StringBuilder)localObject).append(paramLong1);
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0xd45.ReqBody();
    long l = this.a.getLongAccountUin();
    ((oidb_0xd45.ReqBody)localObject).uint64_from_uin.set(l);
    ((oidb_0xd45.ReqBody)localObject).uint64_group_code.set(paramLong1);
    localObject = makeOIDBPkg("OidbSvc.0xd45", 3397, 0, ((oidb_0xd45.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("groupUin", Long.valueOf(paramLong1));
    ((ToServiceMsg)localObject).addAttribute("fromUin", Long.valueOf(l));
    ((ToServiceMsg)localObject).setTimeout(paramLong2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList, Object paramObject)
  {
    if (paramArrayList == null) {
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGroupIntimateInfos ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramArrayList.toString());
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0xd4a.ReqBody();
    long l = this.a.getLongAccountUin();
    ((oidb_0xd4a.ReqBody)localObject).uint64_from_uin.set(l);
    ((oidb_0xd4a.ReqBody)localObject).rpt_uint64_uin_list.set(paramArrayList);
    ((oidb_0xd4a.ReqBody)localObject).uint64_group_code.set(paramLong);
    paramArrayList = makeOIDBPkg("OidbSvc.0xd4a", 3402, 0, ((oidb_0xd4a.ReqBody)localObject).toByteArray());
    if (paramObject != null) {
      paramArrayList.addAttribute("exactData1", paramObject);
    }
    sendPbReq(paramArrayList);
  }
  
  public void a(String paramString)
  {
    try
    {
      oidb_0xd6f.ReqBody localReqBody = new oidb_0xd6f.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(this.a.getCurrentAccountUin()).longValue());
      localReqBody.uint64_frd_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.uint32_source.set(1);
      ProtoUtils.a(this.a, new IntimateInfoHandler.1(this), localReqBody.toByteArray(), "OidbSvc.0xd6f_0", 3439, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(0, false, new Object[] { paramString, null });
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "disbandIntimateRelationship friendUin is empty!");
      notifyUI(1, false, null);
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, relationshipType: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      Object localObject = new oidb_0xcf3.ReqBody();
      ((oidb_0xcf3.ReqBody)localObject).sub_cmd.set(2);
      ((oidb_0xcf3.ReqBody)localObject).target_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0xcf3.ReqBody)localObject).intimate_type.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xcf3", 3315, 0, ((oidb_0xcf3.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("friendUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "disbandIntimateRelationship", localException);
      notifyUI(1, false, new Object[] { paramString, Boolean.valueOf(false) });
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "getIntimateInfo friendUin is empty!");
      notifyUI(0, false, null);
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("getIntimateInfo, friendUin: %s", new Object[] { paramString }));
    }
    try
    {
      Object localObject1 = new oidb_0xcf4.ReqBody();
      oidb_0xcf4.CommonBody localCommonBody = new oidb_0xcf4.CommonBody();
      Object localObject2 = new ArrayList();
      Object localObject3 = new oidb_0xd6c.ReqBody();
      ((oidb_0xd6c.ReqBody)localObject3).uint64_host_uin.set(Long.valueOf(this.a.getCurrentAccountUin()).longValue());
      ((oidb_0xd6c.ReqBody)localObject3).uint64_friend_uin.set(Long.valueOf(paramString).longValue());
      localCommonBody.uint32_oidb_cmd.set(3436);
      localCommonBody.string_oidb_body.set(ByteStringMicro.copyFrom(((oidb_0xd6c.ReqBody)localObject3).toByteArray()));
      ((ArrayList)localObject2).add(localCommonBody);
      ((oidb_0xcf4.ReqBody)localObject1).rpt_msg_common_reqbody.set((List)localObject2);
      ((oidb_0xcf4.ReqBody)localObject1).uint64_from_uin.set(Long.valueOf(this.a.getCurrentAccountUin()).longValue());
      ((oidb_0xcf4.ReqBody)localObject1).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0xcf4.ReqBody)localObject1).bool_qzone_dna.set(true);
      ((oidb_0xcf4.ReqBody)localObject1).bool_new_dna.set(paramBoolean);
      localCommonBody = new oidb_0xcf4.CommonBody();
      localCommonBody.uint32_oidb_cmd.set(3460);
      localObject2 = new MISC.StGetFriendPlayListV2Req();
      ((MISC.StGetFriendPlayListV2Req)localObject2).friendUin.set(paramString);
      ((MISC.StGetFriendPlayListV2Req)localObject2).pageSize.set(1);
      localObject3 = new oidb_0xd84.ReqBody();
      ((oidb_0xd84.ReqBody)localObject3).bytes_xmitinfo.set(ByteStringMicro.copyFrom(((MISC.StGetFriendPlayListV2Req)localObject2).toByteArray()));
      localCommonBody.string_oidb_body.set(ByteStringMicro.copyFrom(((oidb_0xd84.ReqBody)localObject3).toByteArray()));
      ((oidb_0xcf4.ReqBody)localObject1).rpt_msg_common_reqbody.add(localCommonBody);
      localObject1 = makeOIDBPkg("OidbSvc.0xcf4", 3316, 0, ((oidb_0xcf4.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("friendUin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(0, false, new Object[] { paramString, null });
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("intimate_relationship", 0, String.format("receive disband intimateLover: retcode %s, errmsg %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
    notifyUI(1, paramBoolean, new Object[] { paramString2, Boolean.valueOf(false) });
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    notifyUI(4, paramBoolean, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopWithCommonFriendsList troopuin:");
      ((StringBuilder)localObject).append(paramLong);
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0xe3e.ReqBody();
    ((oidb_0xe3e.ReqBody)localObject).uint64_friend_uin.set(paramLong);
    localObject = makeOIDBPkg("OidbSvc.0xe3e", 3646, paramInt, ((oidb_0xe3e.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("frienduin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public List<BusinessObserver> getObservers(int paramInt)
  {
    return this.a.getBusinessObserver(paramInt);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IntimateInfoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("OidbSvc.0xcf3".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xcf4".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xd45".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xcf4_1".equals(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xd4a".equals(paramFromServiceMsg.getServiceCmd()))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe3e".equals(paramFromServiceMsg.getServiceCmd())) {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoHandler
 * JD-Core Version:    0.7.0.1
 */