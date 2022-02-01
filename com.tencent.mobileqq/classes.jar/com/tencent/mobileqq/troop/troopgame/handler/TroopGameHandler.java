package com.tencent.mobileqq.troop.troopgame.handler;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcMsg;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcOptions;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.GradeDistributedInfo;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo;
import com.tencent.mobileqq.troop.troopgame.data.ProfileGameInfo.UserHeroInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.GradeDistributed;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.NotifyUpdateReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupInfoReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupInfoRsp;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryUserInfoReq;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryUserInfoRsp;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.UserHeroInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RspBody;
import tencent.im.oidb.cmd0xf3c.oidb_0xf3c.ReqBody;
import tencent.im.oidb.cmd0xf3c.oidb_0xf3c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopGameHandler
  extends TroopBaseHandler
  implements ITroopGameHandler
{
  protected Set<String> a;
  public WadlTrpcListener b = new TroopGameHandler.1(this);
  private AppInterface c;
  
  public TroopGameHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.c = paramAppInterface;
    if (this.b != null) {
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.b);
    }
  }
  
  private void a(long paramLong, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("isChecked");
    paramToServiceMsg = (ITroopInfoService)this.c.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo = paramToServiceMsg.getTroopInfo(String.valueOf(paramLong));
    if (localTroopInfo != null)
    {
      localTroopInfo.setCmduinFlagEx3Grocer4(bool ^ true, 1);
      paramToServiceMsg.saveTroopInfo(localTroopInfo);
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    TroopGameHandler.2 local2 = new TroopGameHandler.2(this, paramLong, paramBoolean);
    this.appRuntime.addDefaultObservers(local2);
  }
  
  private void a(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if ((paramIntent != null) && (paramTrpcInovkeRsp != null) && (paramIntent.getExtras() != null))
    {
      paramIntent = paramIntent.getExtras().getString("troopUin");
      if ((paramLong == 0L) && (paramTrpcInovkeRsp.data.has())) {
        try
        {
          localObject = new sgame_qgroup_datacard.QueryGroupInfoRsp();
          ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
          paramTrpcInovkeRsp = new TroopGameInfo();
          Iterator localIterator = ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).gradeDistributedList.get().iterator();
          while (localIterator.hasNext())
          {
            sgame_qgroup_datacard.GradeDistributed localGradeDistributed = (sgame_qgroup_datacard.GradeDistributed)localIterator.next();
            if (localGradeDistributed != null)
            {
              GradeDistributedInfo localGradeDistributedInfo = new GradeDistributedInfo();
              localGradeDistributedInfo.grade = localGradeDistributed.grade.get();
              localGradeDistributedInfo.userCount = localGradeDistributed.userCount.get();
              paramTrpcInovkeRsp.gradeDistributedList.add(localGradeDistributedInfo);
            }
          }
          paramTrpcInovkeRsp.fightScore = ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).fightScore.get();
          paramTrpcInovkeRsp.fightScoreRank = ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).fightScoreRank.get();
          paramTrpcInovkeRsp.weekGPlayGameCount = ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).weekPlayGameCount.get();
          paramTrpcInovkeRsp.weekPlayUserCount = ((sgame_qgroup_datacard.QueryGroupInfoRsp)localObject).weekPlayUserCount.get();
          notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, true, new Object[] { paramIntent, paramTrpcInovkeRsp });
          return;
        }
        catch (Exception paramTrpcInovkeRsp)
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleGetTroopGameCardResp Exception: ");
            ((StringBuilder)localObject).append(paramTrpcInovkeRsp);
            QLog.d("TroopGameHandler", 1, ((StringBuilder)localObject).toString());
          }
          notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[] { paramIntent, null });
          paramTrpcInovkeRsp.printStackTrace();
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramTrpcInovkeRsp = new StringBuilder();
        paramTrpcInovkeRsp.append("handleGetTroopGameCardResp failed, ret: ");
        paramTrpcInovkeRsp.append(paramLong);
        QLog.d("TroopGameHandler", 1, paramTrpcInovkeRsp.toString());
      }
      if (paramLong == 200018L)
      {
        notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, true, new Object[] { paramIntent, null });
        return;
      }
      notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[] { paramIntent, null });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameHandler", 1, "handleGetTroopGameCardResp request | rsp | extra is null");
    }
    notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, null);
  }
  
  private void a(List<oidb_0x787.MemberLevelInfo> paramList, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle0x787_1 troopUin =  ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" memberInfo size: ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("TroopGameHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (oidb_0x787.MemberLevelInfo)paramList.next();
      if ((((oidb_0x787.MemberLevelInfo)localObject).uint32_cmduin_flagex3_grocery.has()) && (((oidb_0x787.MemberLevelInfo)localObject).uint64_uin.has()))
      {
        long l1 = ((oidb_0x787.MemberLevelInfo)localObject).uint64_uin.get();
        long l2 = ((oidb_0x787.MemberLevelInfo)localObject).uint32_cmduin_flagex3_grocery.get();
        localObject = (ITroopMemberInfoService)this.c.getRuntimeService(ITroopMemberInfoService.class, "");
        if (localObject != null) {
          ((ITroopMemberInfoService)localObject).saveTroopMemberCmduinFlagEx3(String.valueOf(paramLong), String.valueOf(l1), l2);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle0x787_1 troopUin =  ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" ex3Grocery: ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(". member : ");
          ((StringBuilder)localObject).append(l1);
          QLog.d("TroopGameHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void b(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    String str;
    if ((paramIntent != null) && (paramTrpcInovkeRsp != null) && (paramIntent.getExtras() != null))
    {
      str = paramIntent.getExtras().getString("troopUin");
      paramIntent = paramIntent.getExtras().getString("memberUin");
      if ((paramLong != 0L) || (!paramTrpcInovkeRsp.data.has())) {}
    }
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = new sgame_qgroup_datacard.QueryUserInfoRsp();
        ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        paramTrpcInovkeRsp = new ProfileGameInfo();
        paramTrpcInovkeRsp.mGrade = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).grade.get();
        paramTrpcInovkeRsp.seasonWinRate = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).seasonWinRate.get();
        paramTrpcInovkeRsp.gamesTotal = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).gamesTotal.get();
        paramTrpcInovkeRsp.mvpTotal = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).mvpTotal.get();
        paramTrpcInovkeRsp.bestOccupation = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).bestOccupation.get();
        paramTrpcInovkeRsp.encrptOpenId = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).encrptOpenId.get();
        paramTrpcInovkeRsp.partition = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).partition.get();
        paramTrpcInovkeRsp.platid = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).platid.get();
        paramTrpcInovkeRsp.area = ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).area.get();
        i = 0;
        Object localObject2;
        if (i < ((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).bestHeroList.size())
        {
          localObject2 = (sgame_qgroup_datacard.UserHeroInfo)((sgame_qgroup_datacard.QueryUserInfoRsp)localObject1).bestHeroList.get(i);
          if (localObject2 == null) {
            break label648;
          }
          paramTrpcInovkeRsp.getClass();
          localObject2 = new ProfileGameInfo.UserHeroInfo(paramTrpcInovkeRsp, ((sgame_qgroup_datacard.UserHeroInfo)localObject2).heroId.get(), ((sgame_qgroup_datacard.UserHeroInfo)localObject2).icon.get(), ((sgame_qgroup_datacard.UserHeroInfo)localObject2).skill.get());
          paramTrpcInovkeRsp.bestHeroList.add(localObject2);
          break label648;
        }
        localObject1 = (ITroopGameCardService)this.c.getRuntimeService(ITroopGameCardService.class, "");
        if (localObject1 != null)
        {
          localObject2 = new MemberGradeLevelInfo();
          ((MemberGradeLevelInfo)localObject2).memberuin = paramIntent;
          ((MemberGradeLevelInfo)localObject2).gradeLevel = paramTrpcInovkeRsp.mGrade;
          ((ITroopGameCardService)localObject1).saveMemberGradeLevelInfo((MemberGradeLevelInfo)localObject2);
        }
        notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, true, new Object[] { str, paramIntent, paramTrpcInovkeRsp });
        return;
      }
      catch (Exception paramTrpcInovkeRsp)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleGetTroopMemberGameCardResp Exception: ");
          ((StringBuilder)localObject1).append(paramTrpcInovkeRsp);
          QLog.d("TroopGameHandler", 1, ((StringBuilder)localObject1).toString());
        }
        notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[] { str, paramIntent, null });
        paramTrpcInovkeRsp.printStackTrace();
        return;
      }
      if (QLog.isColorLevel())
      {
        paramTrpcInovkeRsp = new StringBuilder();
        paramTrpcInovkeRsp.append("handleGetTroopMemberGameCardResp failed, ret: ");
        paramTrpcInovkeRsp.append(paramLong);
        QLog.d("TroopGameHandler", 1, paramTrpcInovkeRsp.toString());
      }
      if (paramLong == 200004L)
      {
        paramTrpcInovkeRsp = new MemberGradeLevelInfo();
        paramTrpcInovkeRsp.memberuin = paramIntent;
        paramTrpcInovkeRsp.gradeLevel = 0;
        localObject1 = (ITroopGameCardService)this.c.getRuntimeService(ITroopGameCardService.class, "");
        if (localObject1 != null) {
          ((ITroopGameCardService)localObject1).saveMemberGradeLevelInfo(paramTrpcInovkeRsp);
        }
        notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, true, new Object[] { str, paramIntent, null });
        return;
      }
      notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[] { str, paramIntent, null });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameHandler", 1, "handleGetTroopMemberGameCardResp request | rsp | extra is null");
      }
      notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, null);
      return;
      label648:
      i += 1;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("TroopGameHandler", 2, "handle0x787_1 failed. req is NULL!");
      return;
    }
    if (paramToServiceMsg.extraData.getInt("key_subcmd") != 0) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD_SWITCH;
    long l2 = paramToServiceMsg.extraData.getLong("memberUin");
    if (paramFromServiceMsg == null)
    {
      QLog.e("TroopGameHandler", 2, "handle0x787_1 failed. resp is NULL!");
      notifyUI(j, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        QLog.e("TroopGameHandler", 2, "handle0x787_1 failed. ssoPkg is null!");
        notifyUI(j, false, null);
        return;
      }
      paramFromServiceMsg = new oidb_0x787.RspBody();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      long l1;
      int i;
      label334:
      label353:
      break label353;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      l1 = 0L;
      if (paramFromServiceMsg.uint64_group_code.has()) {
        l1 = paramFromServiceMsg.uint64_group_code.get();
      }
      i = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i = paramToServiceMsg.uint32_result.get();
      }
      if (i != 0)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handle0x787_1 failed. resultCode = ");
        paramToServiceMsg.append(i);
        QLog.e("TroopGameHandler", 2, paramToServiceMsg.toString());
        notifyUI(j, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(i) });
        return;
      }
      paramToServiceMsg = paramFromServiceMsg.rpt_msg_member_level_info.get();
      if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
      {
        a(paramToServiceMsg, l1);
        notifyUI(j, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(i) });
        return;
      }
      notifyUI(j, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(i) });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label334;
    }
    QLog.e("TroopGameHandler", 2, "handle0x787_1 failed. InvalidProtocolBufferMicroException!");
    notifyUI(j, false, null);
    return;
    QLog.e("TroopGameHandler", 2, "handle0x787_1 failed. InvalidProtocolBufferMicroException!");
    notifyUI(j, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramToServiceMsg.extraData.getString("troopUin");
      long l = paramToServiceMsg.extraData.getInt("appid");
      paramToServiceMsg = new oidb_0xf3c.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        paramFromServiceMsg = new TroopGameActivityInfo();
        paramFromServiceMsg.activityValue = paramToServiceMsg.active_num.get();
        paramFromServiceMsg.rankNum = paramToServiceMsg.rank_num.get();
        paramFromServiceMsg.rankEntrance = paramToServiceMsg.rank_entrance.get().toStringUtf8();
        paramFromServiceMsg.iconUrl = paramToServiceMsg.icon.get().toStringUtf8();
        paramFromServiceMsg.rankText = paramToServiceMsg.rank_text.get().toStringUtf8();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetTroopGameActivityInfo succ, info = ");
          paramToServiceMsg.append(paramFromServiceMsg.toString());
          QLog.i("TroopGameHandler", 1, paramToServiceMsg.toString());
        }
        notifyUI(TroopGameObserver.TYPE_GET_TROOP_GAME_ACTIVITY_INFO, true, new Object[] { str, Long.valueOf(l), paramFromServiceMsg });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetTroopGameActivityInfo failed, result = ");
        paramToServiceMsg.append(i);
        QLog.i("TroopGameHandler", 1, paramToServiceMsg.toString());
      }
      notifyUI(TroopGameObserver.TYPE_GET_TROOP_GAME_ACTIVITY_INFO, false, new Object[] { str, Long.valueOf(l), null });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. req is NULL!");
      return;
    }
    int j = paramToServiceMsg.extraData.getInt("key_subcmd");
    int i;
    if (j != 15) {
      i = 0;
    } else {
      i = TroopGameObserver.TYPE_NOTIFY_MODIFY_MEMBER_GAME_CARD_SWITCH;
    }
    if (i == 0) {
      return;
    }
    if (paramFromServiceMsg == null)
    {
      QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. resp is NULL!");
      notifyUI(i, false, null);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. ssoPkg is NULL!");
        notifyUI(i, false, null);
        return;
      }
      paramObject = new Oidb_0x8fc.RspBody();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      long l;
      String str;
      label194:
      int k;
      break label361;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramObject.uint64_group_code.has()) {
        l = paramObject.uint64_group_code.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label342;
    }
    try
    {
      str = paramToServiceMsg.extraData.getString("troopUin");
      if (!TextUtils.isEmpty(str)) {
        l = Long.parseLong(str);
      }
    }
    catch (Exception localException)
    {
      break label194;
    }
    l = 0L;
    k = paramFromServiceMsg.uint32_result.get();
    paramFromServiceMsg = "";
    if (k != 0)
    {
      paramToServiceMsg = paramFromServiceMsg;
      if (paramObject.strErrInfo.has()) {
        paramToServiceMsg = paramObject.strErrInfo.get();
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x8fc_20 failed. resultCode = ");
      paramFromServiceMsg.append(k);
      QLog.e("TroopGameHandler", 2, paramFromServiceMsg.toString());
      notifyUI(i, false, new Object[] { Long.valueOf(l), Long.valueOf(k), paramToServiceMsg });
      return;
    }
    a(l, paramToServiceMsg, j);
    notifyUI(i, true, new Object[] { Long.valueOf(l), Long.valueOf(0L), "" });
    return;
    label342:
    QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. InvalidProtocolBufferMicroException!");
    notifyUI(i, false, null);
    return;
    label361:
    QLog.e("TroopGameHandler", 2, "handle0x8fc_20 failed. InvalidProtocolBufferMicroException!");
    notifyUI(i, false, null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameHandler", 1, "getTroopGameCardInfo");
    }
    try
    {
      localObject2 = new sgame_qgroup_datacard.QueryGroupInfoReq();
      ((sgame_qgroup_datacard.QueryGroupInfoReq)localObject2).groupId.set(Long.valueOf(paramString).longValue());
      TrpcProxy.TrpcMsg localTrpcMsg = new TrpcProxy.TrpcMsg();
      localTrpcMsg.clientRPCName.set("/v1/3");
      TrpcProxy.TrpcOptions localTrpcOptions = new TrpcProxy.TrpcOptions();
      localTrpcOptions.currentSerializationType.set(4);
      localTrpcOptions.serializationType.set(0);
      localTrpcOptions.requestType.set(0);
      Object localObject1 = new TrpcProxy.TrpcInovkeReq();
      ((TrpcProxy.TrpcInovkeReq)localObject1).msg.set(localTrpcMsg);
      ((TrpcProxy.TrpcInovkeReq)localObject1).data.set(ByteStringMicro.copyFrom(((sgame_qgroup_datacard.QueryGroupInfoReq)localObject2).toByteArray()));
      ((TrpcProxy.TrpcInovkeReq)localObject1).options.set(localTrpcOptions);
      localObject2 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject2).list.add((MessageMicro)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("troopUin", paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject2, (Bundle)localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTroopGameCardInfo Exception: ");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("TroopGameHandler", 1, ((StringBuilder)localObject2).toString());
      }
      notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_TROOP_GAME_CARD, false, new Object[] { paramString, null });
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new oidb_0xf3c.ReqBody();
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    ((oidb_0xf3c.ReqBody)localObject).group_code.set(l);
    ((oidb_0xf3c.ReqBody)localObject).appid.set(paramInt);
    localObject = makeOIDBPkg("OidbSvcTcp.0xf3c_1", 3900, 1, ((oidb_0xf3c.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appid", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, long paramLong)
  {
    oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
    localFilter.uint32_cmduin_flagex3_grocery.set(0);
    localFilter.uint32_member_level_info_uin.set(0);
    Object localObject = new oidb_0x787.ReqBody();
    ((oidb_0x787.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x787.ReqBody)localObject).uint64_begin_uin.set(0L);
    ((oidb_0x787.ReqBody)localObject).uint64_data_time.set(0L);
    ((oidb_0x787.ReqBody)localObject).rpt_uin_list.add(Long.valueOf(paramLong));
    ((oidb_0x787.ReqBody)localObject).opt_filter.set(localFilter);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1927);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x787_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("key_subcmd", 0);
    ((ToServiceMsg)localObject).extraData.putLong("memberUin", paramLong);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameHandler", 1, "getTroopGameCardInfo");
    }
    try
    {
      localObject2 = new sgame_qgroup_datacard.QueryUserInfoReq();
      ((sgame_qgroup_datacard.QueryUserInfoReq)localObject2).groupId.set(Long.valueOf(paramString1).longValue());
      ((sgame_qgroup_datacard.QueryUserInfoReq)localObject2).showUin.set(Long.valueOf(paramString2).longValue());
      TrpcProxy.TrpcMsg localTrpcMsg = new TrpcProxy.TrpcMsg();
      localTrpcMsg.clientRPCName.set("/v1/4");
      TrpcProxy.TrpcOptions localTrpcOptions = new TrpcProxy.TrpcOptions();
      localTrpcOptions.currentSerializationType.set(4);
      localTrpcOptions.serializationType.set(0);
      localTrpcOptions.requestType.set(0);
      Object localObject1 = new TrpcProxy.TrpcInovkeReq();
      ((TrpcProxy.TrpcInovkeReq)localObject1).msg.set(localTrpcMsg);
      ((TrpcProxy.TrpcInovkeReq)localObject1).data.set(ByteStringMicro.copyFrom(((sgame_qgroup_datacard.QueryUserInfoReq)localObject2).toByteArray()));
      ((TrpcProxy.TrpcInovkeReq)localObject1).options.set(localTrpcOptions);
      localObject2 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject2).list.add((MessageMicro)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("troopUin", paramString1);
      ((Bundle)localObject1).putString("memberUin", paramString2);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject2, (Bundle)localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTroopMemberGameCard Exception: ");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("TroopGameHandler", 1, ((StringBuilder)localObject2).toString());
      }
      notifyUI(TroopGameObserver.TYPE_NOTIFY_GET_MEMBER_GAME_CARD, false, new Object[] { paramString1, paramString2, null });
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("TroopGameHandler", 2, "modifyTroopGameCardSwitchBy0x89a troopUin is empty!");
        return;
      }
      l = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      long l;
      label27:
      int i;
      break label27;
    }
    l = 0L;
    if (l == 0L)
    {
      QLog.e("TroopGameHandler", 2, "modifyTroopGameCardSwitchBy0x89a uin is 0!");
      return;
    }
    a(l, paramBoolean);
    paramString = new oidb_0x89a.groupinfo();
    i = 0;
    if (paramBoolean) {
      i = 4096;
    }
    paramString.uint32_group_flagext4.set(i);
    paramString.uint32_group_flagext4_mask.set(4096);
    ((ITroopModifyHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(l, paramString, "SUBCMD_MODIFY_TROOP_GAME_CARD_SWITCH");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameHandler", 1, "getTroopGameCardInfo");
    }
    try
    {
      Object localObject2 = new sgame_qgroup_datacard.NotifyUpdateReq();
      ((sgame_qgroup_datacard.NotifyUpdateReq)localObject2).groupId.set(Long.valueOf(paramString).longValue());
      TrpcProxy.TrpcMsg localTrpcMsg = new TrpcProxy.TrpcMsg();
      localTrpcMsg.clientRPCName.set("/v1/9");
      TrpcProxy.TrpcOptions localTrpcOptions = new TrpcProxy.TrpcOptions();
      localTrpcOptions.currentSerializationType.set(4);
      localTrpcOptions.serializationType.set(0);
      localTrpcOptions.requestType.set(1);
      localObject1 = new TrpcProxy.TrpcInovkeReq();
      ((TrpcProxy.TrpcInovkeReq)localObject1).msg.set(localTrpcMsg);
      ((TrpcProxy.TrpcInovkeReq)localObject1).data.set(ByteStringMicro.copyFrom(((sgame_qgroup_datacard.NotifyUpdateReq)localObject2).toByteArray()));
      ((TrpcProxy.TrpcInovkeReq)localObject1).options.set(localTrpcOptions);
      localObject2 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject2).list.add((MessageMicro)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("troopUin", paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject2, (Bundle)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyTroopGameCardUpdate Exception: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("TroopGameHandler", 1, ((StringBuilder)localObject1).toString());
      }
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("modifyShowGameCardSwitch troopUin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopGameHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Oidb_0x8fc.ReqBody();
    ((Oidb_0x8fc.ReqBody)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    Object localObject2 = new ArrayList();
    Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
    long l = Long.parseLong(this.c.getCurrentAccountUin());
    localMemberInfo.uint64_uin.set(l);
    localMemberInfo.uint32_cmduin_flag_ex3_mask.set(1);
    int i = 0;
    if (!paramBoolean) {
      i = 1;
    }
    localMemberInfo.uint32_cmduin_flag_ex3_grocery.set(i);
    ((ArrayList)localObject2).add(localMemberInfo);
    ((Oidb_0x8fc.ReqBody)localObject1).rpt_mem_level_info.set((List)localObject2);
    localObject2 = new Oidb_0x8fc.ClientInfo();
    ((Oidb_0x8fc.ClientInfo)localObject2).uint32_implat.set(109);
    ((Oidb_0x8fc.ClientInfo)localObject2).string_clientver.set(DeviceInfoUtil.e());
    ((Oidb_0x8fc.ReqBody)localObject1).msg_client_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2300);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(20);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x8fc.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x8fc_20");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("key_subcmd", 15);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isChecked", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  protected String dv_()
  {
    return "TroopGameHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x787_1");
      this.a.add("OidbSvc.0x8fc_20");
      this.a.add("OidbSvcTcp.0xf3c_1");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopGameObserver.class;
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.b);
    }
    super.onDestroy();
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
          QLog.d("TroopGameHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopGameHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x8fc_20".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvcTcp.0xf3c_1".equals(paramFromServiceMsg.getServiceCmd())) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler
 * JD-Core Version:    0.7.0.1
 */