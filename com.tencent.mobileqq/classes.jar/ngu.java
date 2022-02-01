import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.PKDrawRes;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import trpc.qq_vgame.activity_center.ActivityCenter.GetActivitysReq;
import trpc.qq_vgame.activity_center.ActivityCenter.GetActivitysRsp;
import trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameReq;
import trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameRsp;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.PKUserRankInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListRsp;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassRsp;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKPoolUserChange;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserCreateRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserDraw;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFail;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserFinalSucc;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserPass;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserSucc;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyRoomMatchStatus;
import trpc.qq_vgame.nofity.AvGameNotify.PKDrawRes;
import trpc.qq_vgame.nofity.AvGameNotify.RoomDestoryS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerChangeGameS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserChangeStatusS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserEnterS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserExitS2CReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoRsp;
import trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationReq;
import trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationRsp;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomRsp;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchRoomReq;
import trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchRoomRsp;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatReq;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatRsp;

public class ngu
  extends ndi
{
  public ngu(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private SurvivalPkResultInfo.PKDrawRes a(AvGameNotify.PKDrawRes paramPKDrawRes)
  {
    SurvivalPkResultInfo.PKDrawRes localPKDrawRes = null;
    if (paramPKDrawRes != null) {
      localPKDrawRes = new SurvivalPkResultInfo.PKDrawRes(paramPKDrawRes.is_draw.get(), paramPKDrawRes.self_cost.get(), paramPKDrawRes.peer_cost.get());
    }
    return localPKDrawRes;
  }
  
  private List<SurvivalPkResultInfo.Pair<Integer, Long>> a(List<AvGameCommon.PKUserRankInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AvGameCommon.PKUserRankInfo localPKUserRankInfo = (AvGameCommon.PKUserRankInfo)paramList.next();
      localArrayList.add(new SurvivalPkResultInfo.Pair(Integer.valueOf(localPKUserRankInfo.rank.get()), Long.valueOf(localPKUserRankInfo.uin.get())));
    }
    return localArrayList;
  }
  
  private void a(List<AvGameList.GameListItemInfo> paramList, List<nga> paramList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AvGameList.GameListItemInfo localGameListItemInfo = (AvGameList.GameListItemInfo)paramList.next();
        if (localGameListItemInfo != null)
        {
          nga localnga = new nga();
          localnga.a(localGameListItemInfo);
          paramList1.add(localnga);
        }
      }
    }
  }
  
  private void a(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    int i = paramNotifyMsg.poolID.get();
    int j = paramNotifyMsg.pkID.get();
    if ((nfc.a().a().b != i) || (nfc.a().a().c != j))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkUserMatchTimeout() poolId or pkId wrong " + i + " " + j);
      return;
    }
    ndq.a().b(nhd.class, 28, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private void a(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2, String paramString)
  {
    paramNotifyMsg = (AvGameNotify.NotifyRoomMatchStatus)paramNotifyMsg.room_match_status.get();
    nff.a("avgame_logic.GameRoomHandler", "NT_ROOM_MATCH_STATUS", null, new MessageMicro[] { paramNotifyMsg });
    if (paramNotifyMsg != null) {
      ndq.a().b(nhd.class, 25, true, new Object[] { Long.valueOf(paramNotifyMsg.roomid.get()), Integer.valueOf(paramNotifyMsg.status.get()) });
    }
  }
  
  private void a(AvGameRoomManager.CmdRoomInfoRsp paramCmdRoomInfoRsp) {}
  
  private void a(boolean paramBoolean, AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong)
  {
    int i = paramNotifyMsg.poolID.get();
    int j = paramNotifyMsg.pkID.get();
    if ((nfc.a().a().b != i) || (nfc.a().a().c != j))
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkRoomCreateOrEnterPush() poolId or pkId wrong " + i + " " + j);
      return;
    }
    long l;
    if (paramBoolean)
    {
      paramNotifyMsg = (AvGameNotify.NotifyPKUserCreateRoom)paramNotifyMsg.pk_user_create_room.get();
      l = 0L;
    }
    for (;;)
    {
      ndq.a().b(nhd.class, 26, true, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Long.valueOf(l) });
      return;
      paramNotifyMsg = (AvGameNotify.NotifyPKUserEnterRoom)paramNotifyMsg.pk_user_enter_room.get();
      l = paramNotifyMsg.roomid.get();
      nff.a("avgame_logic.GameRoomHandler", "handlePkRoomCreateOrEnterPush", null, new MessageMicro[] { paramNotifyMsg });
    }
  }
  
  private List<Long> b(List<AvGameCommon.UinWrap> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((AvGameCommon.UinWrap)paramList.next()).uin.get()));
    }
    return localArrayList;
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    paramNotifyMsg = (AvGameNotify.NotifyPKPoolUserChange)paramNotifyMsg.pk_pool_user_change.get();
    int i = paramNotifyMsg.opt.get();
    int j = paramNotifyMsg.total.get();
    if (paramNotifyMsg.uins.has()) {}
    for (paramNotifyMsg = paramNotifyMsg.uins.get();; paramNotifyMsg = new ArrayList(0))
    {
      paramNotifyMsg = b(paramNotifyMsg);
      ndq.a().b(nhd.class, 29, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramNotifyMsg });
      return;
    }
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    nff.a("avgame_logic.GameRoomHandler", "handlePkEndUserResult", null, new MessageMicro[] { paramNotifyMsg });
    int i = paramNotifyMsg.poolID.get();
    int j = paramNotifyMsg.pkID.get();
    if ((nfc.a().a().b != i) || (nfc.a().a().c != j)) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "handlePkEndUserResult() poolId or pkId wrong " + i + " " + j);
    }
    label517:
    label522:
    label669:
    label711:
    label844:
    do
    {
      return;
      i = paramNotifyMsg.type.get();
      if (i == 503)
      {
        paramNotifyMsg = (AvGameNotify.NotifyPKUserSucc)paramNotifyMsg.pk_user_succ.get();
        localObject1 = new SurvivalPkResultInfo();
        ((SurvivalPkResultInfo)localObject1).winReason = paramNotifyMsg.reason.get();
        ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
        if (paramNotifyMsg.draw_res.has()) {
          ((SurvivalPkResultInfo)localObject1).pkDrawRes = a((AvGameNotify.PKDrawRes)paramNotifyMsg.draw_res.get());
        }
        ndq.a().b(nhd.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(1), Boolean.valueOf(false), localObject1 });
        return;
      }
      Object localObject2;
      if (i == 505)
      {
        localObject1 = (AvGameNotify.NotifyPKUserFail)paramNotifyMsg.pk_user_fail.get();
        localObject2 = new SurvivalPkResultInfo();
        if (localObject1 != null)
        {
          ((SurvivalPkResultInfo)localObject2).gameSur = false;
          ((SurvivalPkResultInfo)localObject2).rank = ((AvGameNotify.NotifyPKUserFail)localObject1).rank.get();
          ((SurvivalPkResultInfo)localObject2).total = ((AvGameNotify.NotifyPKUserFail)localObject1).total.get();
          ((SurvivalPkResultInfo)localObject2).hasAward = ((AvGameNotify.NotifyPKUserFail)localObject1).has_consolation_award.get();
          ((SurvivalPkResultInfo)localObject2).awardText = ((AvGameNotify.NotifyPKUserFail)localObject1).award_str.get().toStringUtf8();
          ((SurvivalPkResultInfo)localObject2).awardUrl = ((AvGameNotify.NotifyPKUserFail)localObject1).award_url.get().toStringUtf8();
          if (!((AvGameNotify.NotifyPKUserFail)localObject1).award_url_str.has()) {
            break label517;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFail)localObject1).award_url_str.get().toStringUtf8();
          ((SurvivalPkResultInfo)localObject2).awardUrlStr = paramNotifyMsg;
          ((SurvivalPkResultInfo)localObject2).delayAward = ((AvGameNotify.NotifyPKUserFail)localObject1).delay_award.get();
          if (!((AvGameNotify.NotifyPKUserFail)localObject1).delay_award_tip.has()) {
            break label522;
          }
        }
        for (paramNotifyMsg = ((AvGameNotify.NotifyPKUserFail)localObject1).delay_award_tip.get().toStringUtf8();; paramNotifyMsg = null)
        {
          ((SurvivalPkResultInfo)localObject2).delayAwardTip = paramNotifyMsg;
          if (((AvGameNotify.NotifyPKUserFail)localObject1).draw_res.has()) {
            ((SurvivalPkResultInfo)localObject2).pkDrawRes = a((AvGameNotify.PKDrawRes)((AvGameNotify.NotifyPKUserFail)localObject1).draw_res.get());
          }
          ((SurvivalPkResultInfo)localObject2).isBothClose = ((AvGameNotify.NotifyPKUserFail)localObject1).both_lose.get();
          ndq.a().b(nhd.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(2), Boolean.valueOf(true), localObject2 });
          return;
          paramNotifyMsg = null;
          break;
        }
      }
      boolean bool;
      if (i == 504)
      {
        localObject2 = (AvGameNotify.NotifyPKUserFinalSucc)paramNotifyMsg.pk_user_final_succ.get();
        localObject1 = new SurvivalPkResultInfo();
        if (localObject2 != null)
        {
          ((SurvivalPkResultInfo)localObject1).gameSur = true;
          ((SurvivalPkResultInfo)localObject1).winReason = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).reason.get();
          ((SurvivalPkResultInfo)localObject1).awardText = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).award_str.get().toStringUtf8();
          ((SurvivalPkResultInfo)localObject1).awardUrl = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).award_url.get().toStringUtf8();
          if (TextUtils.isEmpty(((SurvivalPkResultInfo)localObject1).awardUrl)) {
            break label828;
          }
          bool = true;
          ((SurvivalPkResultInfo)localObject1).hasAward = bool;
          ((SurvivalPkResultInfo)localObject1).total = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).total.get();
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject2).award_url_str.has()) {
            break label834;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).award_url_str.get().toStringUtf8();
          ((SurvivalPkResultInfo)localObject1).awardUrlStr = paramNotifyMsg;
          ((SurvivalPkResultInfo)localObject1).delayAward = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).delay_award.get();
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject2).delay_award_tip.has()) {
            break label839;
          }
          paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).delay_award_tip.get().toStringUtf8();
          ((SurvivalPkResultInfo)localObject1).delayAwardTip = paramNotifyMsg;
          if (((AvGameNotify.NotifyPKUserFinalSucc)localObject2).draw_res.has()) {
            ((SurvivalPkResultInfo)localObject1).pkDrawRes = a((AvGameNotify.PKDrawRes)((AvGameNotify.NotifyPKUserFinalSucc)localObject2).draw_res.get());
          }
          if (!((AvGameNotify.NotifyPKUserFinalSucc)localObject2).ranking.has()) {
            break label844;
          }
        }
        for (paramNotifyMsg = ((AvGameNotify.NotifyPKUserFinalSucc)localObject2).ranking.get();; paramNotifyMsg = new ArrayList(0))
        {
          ((SurvivalPkResultInfo)localObject1).rankingUins = a(paramNotifyMsg);
          ndq.a().b(nhd.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(3), Boolean.valueOf(true), localObject1 });
          return;
          bool = false;
          break;
          paramNotifyMsg = null;
          break label669;
          paramNotifyMsg = null;
          break label711;
        }
      }
      if (i == 508)
      {
        paramNotifyMsg = (AvGameNotify.NotifyPKUserDraw)paramNotifyMsg.pk_user_draw.get();
        localObject1 = new SurvivalPkResultInfo();
        ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
        bool = paramNotifyMsg.exit_room.get();
        ndq.a().b(nhd.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(4), Boolean.valueOf(bool), localObject1 });
        return;
      }
    } while (i != 506);
    label828:
    label834:
    label839:
    paramNotifyMsg = (AvGameNotify.NotifyPKUserPass)paramNotifyMsg.pk_user_pass.get();
    Object localObject1 = new SurvivalPkResultInfo();
    ((SurvivalPkResultInfo)localObject1).winRound = paramNotifyMsg.cur_round.get();
    ndq.a().b(nhd.class, 27, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(5), Boolean.valueOf(false), localObject1 });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label318;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.AddMatchRoomRsp();
      int k = -1;
      j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStartStrangerMatch:" + paramToServiceMsg);
          paramToServiceMsg = null;
        }
        ndq.a().b(nhd.class, 12, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(j), paramToServiceMsg });
        return;
      }
      nff.a("avgame_logic.GameRoomHandler", "onStartStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((i == 0) || (j != 0)) {
        break;
      }
      i = paramFromServiceMsg.shard_id.get();
      ndq.a().b(nhd.class, 12, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
      return;
    }
    label318:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStartStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ndq.a().b(nhd.class, 12, false, new Object[] { Long.valueOf(l), Integer.valueOf(-1), Integer.valueOf(0), null });
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomOwnerChangeGameS2CReq)paramNotifyMsg.change_game_req.get();
    if (paramNotifyMsg.game_type.has()) {}
    for (int i = paramNotifyMsg.game_type.get();; i = 1)
    {
      nff.a("avgame_logic.GameRoomHandler", "handlerChangeGamePush()", new String[] { "AvGameNotify.RoomOwnerChangeGameS2CReq" }, new MessageMicro[] { paramNotifyMsg });
      ndq.a().b(nhd.class, 24, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i) });
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label258;
      }
      paramFromServiceMsg = new AvGameStrangerMatch.DelMatchRoomRsp();
      int k = -1;
      int j = k;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = k;
        k = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
        j = k;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = 0;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onStopStrangerMatch:" + paramToServiceMsg);
          paramToServiceMsg = null;
        }
      }
      nff.a("avgame_logic.GameRoomHandler", "onStopStrangerMatch()", null, new MessageMicro[] { paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() roomId=%d errCode=%d errMsg=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg }));
      }
      if ((i != 0) && (j == 0)) {
        ndq.a().b(nhd.class, 13, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramToServiceMsg });
      }
      return;
    }
    label258:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onStopStrangerMatch() fail roomId=%d", new Object[] { Long.valueOf(l) }));
    }
    ndq.a().b(nhd.class, 13, false, new Object[] { Long.valueOf(l), Integer.valueOf(0), null });
  }
  
  private void d(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserChangeStatusS2CReq localRoomUserChangeStatusS2CReq = (AvGameNotify.RoomUserChangeStatusS2CReq)paramNotifyMsg.room_user_change_status_req.get();
    if (localRoomUserChangeStatusS2CReq.uin.has())
    {
      paramNotifyMsg = String.valueOf(localRoomUserChangeStatusS2CReq.uin.get());
      if (!localRoomUserChangeStatusS2CReq.user_status.has()) {
        break label154;
      }
    }
    label154:
    for (int i = localRoomUserChangeStatusS2CReq.user_status.get();; i = 0)
    {
      RoomInfo localRoomInfo = nff.a((AvGameCommon.RoomInfo)localRoomUserChangeStatusS2CReq.room_info.get());
      nff.a("avgame_logic.GameRoomHandler", "handlerChangeUserStatusPush()", new String[] { "AvGameNotify.RoomUserChangeStatusS2CReq" }, new MessageMicro[] { localRoomUserChangeStatusS2CReq });
      ndq.a().b(nhd.class, 23, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramNotifyMsg, Integer.valueOf(i), localRoomInfo });
      return;
      paramNotifyMsg = "";
      break;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    boolean bool;
    label46:
    AvGamePkManager.PKOperationRsp localPKOperationRsp;
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      j = 1;
      i1 = ((Integer)paramToServiceMsg.getAttribute("opeType", Integer.valueOf(0))).intValue();
      if (i1 != 2) {
        break label299;
      }
      bool = true;
      if (j == 0) {
        break label410;
      }
      localPKOperationRsp = new AvGamePkManager.PKOperationRsp();
      i = -1;
      m = 0;
      k = i;
    }
    for (;;)
    {
      try
      {
        localPKOperationRsp.mergeFrom((byte[])paramObject);
        k = i;
        i = ((AvGameCommon.Result)localPKOperationRsp.res.get()).errcode.get();
        k = i;
        paramToServiceMsg = ((AvGameCommon.Result)localPKOperationRsp.res.get()).errmsg.get().toStringUtf8();
        k = m;
      }
      catch (Exception paramFromServiceMsg)
      {
        label299:
        paramToServiceMsg = null;
        i = k;
        j = 0;
      }
      try
      {
        m = localPKOperationRsp.pool_id.get();
        k = m;
        n = localPKOperationRsp.start_user_num.get();
        k = n;
        nff.a("avgame_logic.GameRoomHandler", "onSendSurvivalOperation()", null, new MessageMicro[] { localPKOperationRsp });
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendSurvivalOperation() opeType=%d poolId=%d errCode=%d errMsg=%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(i), paramToServiceMsg }));
        }
        if ((j == 0) || (i != 0)) {
          break label358;
        }
        ndq.a().b(nhd.class, 14, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          j = k;
        }
      }
      j = 0;
      break;
      bool = false;
      break label46;
      int n = 0;
      QLog.e("avgame_logic.GameRoomHandler", 1, "onSendSurvivalOperation:" + paramFromServiceMsg);
      k = 0;
      m = j;
      j = n;
    }
    label358:
    ndq.a().b(nhd.class, 14, false, new Object[] { Boolean.valueOf(bool), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg });
    return;
    label410:
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendSurvivalOperation() fail opeType=%d code:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i) }));
      }
      ndq.a().b(nhd.class, 14, false, new Object[] { Boolean.valueOf(bool), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null });
      return;
    }
  }
  
  private void e(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomDestoryS2CReq)paramNotifyMsg.room_destory_req.get();
    nff.a("avgame_logic.GameRoomHandler", "handlerDestroyRoomPush()", new String[] { "AvGameNotify.RoomDestoryS2CReq" }, new MessageMicro[] { paramNotifyMsg });
    ndq.a().b(nhd.class, 22, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1;
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0)
      {
        paramFromServiceMsg = new AvGamePkManager.GetPKInfoRsp();
        j = -1;
        m = 0;
        i1 = 0;
        k = j;
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          k = j;
          j = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errcode.get();
          k = j;
          paramToServiceMsg = ((AvGameCommon.Result)paramFromServiceMsg.res.get()).errmsg.get().toStringUtf8();
          k = i1;
        }
        catch (Exception paramFromServiceMsg)
        {
          int n;
          m = 0;
          j = 0;
          paramToServiceMsg = null;
          i = k;
          k = m;
        }
        try
        {
          n = paramFromServiceMsg.interval.get();
          k = i1;
          m = n;
          i1 = paramFromServiceMsg.user_total_num.get();
          k = i1;
          m = n;
          paramFromServiceMsg = b(paramFromServiceMsg.user_in_pk.get());
          k = i1;
          m = i;
          i = j;
          j = n;
          if (QLog.isColorLevel()) {
            QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendGetPKInfo() interval=%d userTotalNum=%d errCode=%d errMsg=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramToServiceMsg }));
          }
          if ((m != 0) && (i == 0)) {
            ndq.a().b(nhd.class, 17, true, new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramFromServiceMsg, Integer.valueOf(i), paramToServiceMsg });
          }
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            i = j;
            j = m;
          }
        }
        i = 0;
        break;
        m = 0;
        QLog.e("avgame_logic.GameRoomHandler", 1, "onSendGetPKInfo:" + paramFromServiceMsg);
        paramFromServiceMsg = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onSendGetPKInfo() fail code:%d", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
    }
    ndq.a().b(nhd.class, 17, false, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null });
  }
  
  private void f(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserExitS2CReq localRoomUserExitS2CReq = (AvGameNotify.RoomUserExitS2CReq)paramNotifyMsg.room_user_exit_req.get();
    int i;
    label56:
    String str1;
    label80:
    int j;
    label101:
    int k;
    label122:
    String str2;
    if (localRoomUserExitS2CReq.exit_reason.has())
    {
      i = localRoomUserExitS2CReq.exit_reason.get();
      if (!localRoomUserExitS2CReq.exit_uin.has()) {
        break label303;
      }
      paramNotifyMsg = String.valueOf(localRoomUserExitS2CReq.exit_uin.get());
      if (!localRoomUserExitS2CReq.new_owner_uin.has()) {
        break label310;
      }
      str1 = String.valueOf(localRoomUserExitS2CReq.new_owner_uin.get());
      if (!localRoomUserExitS2CReq.heartbeat_timeout.has()) {
        break label318;
      }
      j = localRoomUserExitS2CReq.heartbeat_timeout.get();
      if (!localRoomUserExitS2CReq.sub_reason.has()) {
        break label324;
      }
      k = localRoomUserExitS2CReq.sub_reason.get();
      if (!localRoomUserExitS2CReq.onwer_tip.has()) {
        break label330;
      }
      str2 = String.valueOf(localRoomUserExitS2CReq.onwer_tip.get());
      label146:
      if (!localRoomUserExitS2CReq.exiter_tip.has()) {
        break label338;
      }
    }
    label303:
    label310:
    label318:
    label324:
    label330:
    label338:
    for (String str3 = String.valueOf(localRoomUserExitS2CReq.exiter_tip.get());; str3 = "")
    {
      RoomInfo localRoomInfo = nff.a((AvGameCommon.RoomInfo)localRoomUserExitS2CReq.room_info.get());
      nff.a("avgame_logic.GameRoomHandler", "handlerExitRoomPush()", new String[] { "AvGameNotify.RoomUserExitS2CReq" }, new MessageMicro[] { localRoomUserExitS2CReq });
      ndq.a().b(nhd.class, 21, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str1, localRoomInfo, Integer.valueOf(j), Integer.valueOf(k), str2, str3 });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
      str1 = "";
      break label80;
      j = 0;
      break label101;
      k = 0;
      break label122;
      str2 = "";
      break label146;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    int k;
    long l;
    String str;
    int j;
    Object localObject;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool4 = paramToServiceMsg.extraData.getBoolean("is_from_sync");
      k = paramToServiceMsg.extraData.getInt("snapshot_from");
      l = paramToServiceMsg.extraData.getLong("room_id");
      str = paramToServiceMsg.extraData.getString("user_uin");
      j = 0;
      if (bool1)
      {
        localObject = new AvGameRoomManager.CmdRoomInfoRsp();
        i = j;
      }
    }
    else
    {
      try
      {
        ((AvGameRoomManager.CmdRoomInfoRsp)localObject).mergeFrom((byte[])paramObject);
        i = j;
        j = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject).res.get()).errcode.get();
        i = j;
        paramToServiceMsg = ((AvGameCommon.Result)((AvGameRoomManager.CmdRoomInfoRsp)localObject).res.get()).errmsg.get().toStringUtf8();
        i = j;
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          RoomInfo localRoomInfo;
          nfg localnfg;
          List localList;
          ArrayList localArrayList;
          QLog.e("avgame_logic.GameRoomHandler", 1, "onGetGameRoomInfo:" + paramToServiceMsg);
          bool1 = false;
          paramToServiceMsg = "";
          continue;
          boolean bool2 = false;
        }
      }
      a((AvGameRoomManager.CmdRoomInfoRsp)localObject);
      bool3 = bool1;
      if (bool1)
      {
        bool3 = bool1;
        if (i == 0)
        {
          bool3 = bool1;
          if (((AvGameRoomManager.CmdRoomInfoRsp)localObject).room_info.has())
          {
            bool3 = bool1;
            if (((AvGameRoomManager.CmdRoomInfoRsp)localObject).room_info.get() != null)
            {
              localRoomInfo = nff.a((AvGameCommon.RoomInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject).room_info.get());
              localnfg = null;
              localList = null;
              localArrayList = null;
              j = 0;
              paramObject = null;
              paramFromServiceMsg = null;
              bool2 = bool1;
              if (bool4)
              {
                localnfg = nff.a((AvGameCommon.GameStatusInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_status_info.get());
                if ((localnfg == null) || (!localnfg.a())) {
                  break label653;
                }
                bool2 = true;
                localList = nff.a(((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_ranking_info);
                localObject = (AvGameList.CmdGameListRsp)((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_cfg_info.get();
                j = ((AvGameList.CmdGameListRsp)localObject).curr_game_index.get();
                paramObject = ((AvGameList.CmdGameListRsp)localObject).resource_url.get();
                paramFromServiceMsg = ((AvGameList.CmdGameListRsp)localObject).resource_md5.get();
                localArrayList = new ArrayList();
                a(((AvGameList.CmdGameListRsp)localObject).game_list.get(), localArrayList);
                QLog.d("avgame_logic.GameRoomHandler", 1, String.format("onGetGameRoomInfo game valid=%b game=%s", new Object[] { Boolean.valueOf(bool2), localnfg }));
                bool2 = bool1 & bool2;
              }
              bool3 = bool2;
              if (bool2) {
                ndq.a().b(nhd.class, 1, true, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, localRoomInfo, localnfg, localList, localArrayList, Integer.valueOf(j), paramObject, paramFromServiceMsg, Integer.valueOf(k) });
              }
            }
          }
        }
      }
    }
    for (boolean bool3 = bool2;; bool3 = bool1)
    {
      if (!bool3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, String.format("onGetGameRoomInfo failed suc=%b errCode=%d errMsg=%s", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(i), paramToServiceMsg }));
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (paramToServiceMsg == null) {
          paramFromServiceMsg = "";
        }
        ndq.a().b(nhd.class, 1, false, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(k) });
      }
      nfk.a(bool3, k);
      return;
      bool1 = false;
      break;
      label653:
      paramToServiceMsg = "";
      i = 0;
    }
  }
  
  private void g(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserEnterS2CReq localRoomUserEnterS2CReq = (AvGameNotify.RoomUserEnterS2CReq)paramNotifyMsg.room_user_enter_req.get();
    int i;
    if (localRoomUserEnterS2CReq.type.has())
    {
      i = localRoomUserEnterS2CReq.type.get();
      if (!localRoomUserEnterS2CReq.enter_uin.has()) {
        break label183;
      }
      paramNotifyMsg = String.valueOf(localRoomUserEnterS2CReq.enter_uin.get());
      label56:
      if (!localRoomUserEnterS2CReq.inviter_uin.has()) {
        break label190;
      }
    }
    label183:
    label190:
    for (String str = String.valueOf(localRoomUserEnterS2CReq.inviter_uin.get());; str = "")
    {
      RoomInfo localRoomInfo = nff.a((AvGameCommon.RoomInfo)localRoomUserEnterS2CReq.room_info.get());
      nff.a("avgame_logic.GameRoomHandler", "handlerEnterRoomPush()", new String[] { "AvGameNotify.RoomUserEnterS2CReq" }, new MessageMicro[] { localRoomUserEnterS2CReq });
      ndq.a().b(nhd.class, 20, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str, localRoomInfo });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        AvGameList.CmdGameListRsp localCmdGameListRsp = new AvGameList.CmdGameListRsp();
        try
        {
          localCmdGameListRsp.mergeFrom((byte[])paramObject);
          nff.a("avgame_logic.GameRoomHandler", "onGetGameRoomList()", null, new MessageMicro[] { localCmdGameListRsp });
          if (localCmdGameListRsp.game_list.has())
          {
            paramToServiceMsg = localCmdGameListRsp.game_list.get();
            if ((i == 0) || (paramToServiceMsg == null)) {
              break label346;
            }
            if (!localCmdGameListRsp.curr_game_index.has()) {
              break label335;
            }
            i = localCmdGameListRsp.curr_game_index.get();
            paramObject = new ArrayList();
            a(paramToServiceMsg, paramObject);
            if (!localCmdGameListRsp.resource_url.has()) {
              break label341;
            }
            paramToServiceMsg = localCmdGameListRsp.resource_url.get();
            paramFromServiceMsg = localObject;
            if (localCmdGameListRsp.resource_md5.has()) {
              paramFromServiceMsg = localCmdGameListRsp.resource_md5.get();
            }
            ndq.a().b(nhd.class, 2, true, new Object[] { paramObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg, Long.valueOf(l) });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList success gameList = " + paramObject + " curGameIndex=" + i + " resUrl = " + paramToServiceMsg + " resMd5 =" + paramFromServiceMsg);
            }
            return;
            i = 0;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("avgame_logic.GameRoomHandler", 1, "onGetGameRoomList:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label335:
            i = 0;
            continue;
            label341:
            paramToServiceMsg = null;
          }
        }
      }
    }
    label346:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList failed ");
    }
    ndq.a().b(nhd.class, 2, false, new Object[] { Long.valueOf(l) });
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label565;
      }
      paramToServiceMsg = new AvGameList.CmdGetQuestionClassRsp();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        nff.a("avgame_logic.GameRoomHandler", "onGetQuestionClass()", null, new MessageMicro[] { paramToServiceMsg });
        paramObject = paramToServiceMsg;
        j = i;
        if ((paramObject != null) && (paramObject.res.has()))
        {
          i = 1;
          if ((j == 0) || (i == 0) || (paramObject.res.errcode.get() != 0)) {
            break label426;
          }
          if (!paramObject.question_class_title_url.has()) {
            continue;
          }
          paramToServiceMsg = paramObject.question_class_title_url.get();
          if (!paramObject.question_class_button_url.has()) {
            continue;
          }
          paramFromServiceMsg = paramObject.question_class_button_url.get();
          localArrayList = new ArrayList();
          if (!paramObject.question_class_list.has()) {
            continue;
          }
          paramObject = paramObject.question_class_list.get();
          if ((paramObject == null) || (paramObject.size() <= 0)) {
            continue;
          }
          i = 0;
          if (i >= paramObject.size()) {
            continue;
          }
          AvGameList.QuestionClassInfo localQuestionClassInfo = (AvGameList.QuestionClassInfo)paramObject.get(i);
          ngb localngb = new ngb();
          localngb.a(localQuestionClassInfo);
          localArrayList.add(localngb);
          i += 1;
          continue;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        ArrayList localArrayList;
        i = 0;
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass:" + paramFromServiceMsg);
        continue;
        i = 0;
        continue;
        paramToServiceMsg = "";
        continue;
        paramFromServiceMsg = "";
        continue;
        paramObject = null;
        continue;
        ndq.a().b(nhd.class, 9, true, new Object[] { Long.valueOf(l), null, localArrayList, paramToServiceMsg, paramFromServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, "onGetQuestionClass success! roomId = " + l + " questionClassInfoListSize=" + localArrayList.size() + " titleImageUrl=" + paramToServiceMsg + " buttonImageUrl=" + paramFromServiceMsg);
        }
        return;
      }
      label426:
      if (i != 0)
      {
        j = paramObject.res.errcode.get();
        if ((i == 0) || (!paramObject.res.errmsg.has())) {
          break label558;
        }
      }
      label558:
      for (paramToServiceMsg = paramObject.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "拉取题库类型失败")
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass fail! errorCode = " + j + "retMsg=" + paramToServiceMsg);
        ndq.a().b(nhd.class, 9, false, new Object[] { Long.valueOf(l), paramToServiceMsg, null, null, null });
        return;
        j = -1;
        break;
      }
      label565:
      paramObject = null;
      int j = i;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    long l2;
    for (;;)
    {
      l2 = paramToServiceMsg.extraData.getLong("room_id");
      if (i != 0)
      {
        paramFromServiceMsg = new AvGamePlay.SelectGameRsp();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (paramFromServiceMsg.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
              if (!paramFromServiceMsg.seq.has()) {
                break label234;
              }
              l1 = paramFromServiceMsg.seq.get();
              if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0)) {
                break label240;
              }
              ndq.a().b(nhd.class, 6, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              nff.a("avgame_logic.GameRoomHandler", "onSelectGame()", new String[] { "AvGameCommon.Result -> seq = " + l1 }, new MessageMicro[] { paramToServiceMsg });
              return;
              i = 0;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label234:
            long l1 = 0L;
            continue;
            label240:
            ndq.a().b(nhd.class, 6, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          }
        }
      }
    }
    QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame()  failed ");
    ndq.a().b(nhd.class, 6, false, new Object[] { Long.valueOf(0L), Long.valueOf(l2) });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdGetShareLinkRsp localCmdGetShareLinkRsp = new AvGameShare.CmdGetShareLinkRsp();
    boolean bool1;
    long l;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. isSuccess = " + bool1);
      if (!bool1) {
        break label185;
      }
    }
    for (;;)
    {
      try
      {
        localCmdGetShareLinkRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      if (!bool2) {
        break label303;
      }
      if (localCmdGetShareLinkRsp.share_url.has()) {
        break label229;
      }
      ndq.a().a(nhd.class, 8, false, new Object[] { "", Long.valueOf(l) });
      QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label185:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label229:
    paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
    ndq.a().a(nhd.class, 8, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
    QLog.d("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink.get shareUrl:" + paramToServiceMsg + " mark: " + l);
    return;
    label303:
    ndq.a().a(nhd.class, 8, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink fail");
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    int j;
    long l;
    for (;;)
    {
      j = paramToServiceMsg.extraData.getInt("leave_game_room_type");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("user_uin");
      l = paramToServiceMsg.extraData.getLong("room_id");
      if (i == 0) {
        break label295;
      }
      AvGameRoomManager.CmdRoomLeaveRsp localCmdRoomLeaveRsp = new AvGameRoomManager.CmdRoomLeaveRsp();
      try
      {
        localCmdRoomLeaveRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label295;
        }
        paramToServiceMsg = (AvGameCommon.Result)localCmdRoomLeaveRsp.res.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0))
        {
          paramToServiceMsg = nff.a((AvGameCommon.RoomInfo)localCmdRoomLeaveRsp.room_info.get());
          ndq.a().a(nhd.class, 3, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
          nff.a("avgame_logic.GameRoomHandler", "onLeaveGameRoom()", null, new MessageMicro[] { localCmdRoomLeaveRsp });
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GameRoomHandler", 1, "onLeaveGameRoom():" + paramToServiceMsg);
          i = 0;
        }
        if (paramToServiceMsg == null) {
          break label288;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has()) {}
    label288:
    for (paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      ndq.a().a(nhd.class, 3, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
      break;
    }
    label295:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onLeaveGameRoom() failed");
    }
    ndq.a().a(nhd.class, 3, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, "" });
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int j = paramToServiceMsg.extraData.getInt("change_status_from");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label322;
      }
      AvGameRoomManager.CmdRoomChangeUserStatusRsp localCmdRoomChangeUserStatusRsp = new AvGameRoomManager.CmdRoomChangeUserStatusRsp();
      try
      {
        localCmdRoomChangeUserStatusRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label322;
        }
        if (localCmdRoomChangeUserStatusRsp.res.has())
        {
          paramToServiceMsg = (AvGameCommon.Result)localCmdRoomChangeUserStatusRsp.res.get();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0) || (localCmdRoomChangeUserStatusRsp.room_info.get() == null)) {
            break label226;
          }
          paramToServiceMsg = nff.a((AvGameCommon.RoomInfo)localCmdRoomChangeUserStatusRsp.room_info.get());
          ndq.a().b(nhd.class, 4, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
          nff.a("avgame_logic.GameRoomHandler", "onChangeUserStatus()", null, new MessageMicro[] { localCmdRoomChangeUserStatusRsp });
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GameRoomHandler", 1, "onChangeUserStatus():" + paramToServiceMsg);
          i = 0;
          continue;
          paramToServiceMsg = null;
        }
        label226:
        if (paramToServiceMsg == null) {
          break label309;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has())
    {
      paramFromServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
      label251:
      if (paramToServiceMsg == null) {
        break label316;
      }
    }
    label309:
    label316:
    for (int i = paramToServiceMsg.errcode.get();; i = -1)
    {
      ndq.a().b(nhd.class, 4, false, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramFromServiceMsg = "";
      break label251;
    }
    label322:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onChangeUserStatus() failed");
    }
    ndq.a().b(nhd.class, 4, false, new Object[] { Long.valueOf(l), "", Integer.valueOf(109), Integer.valueOf(j) });
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramToServiceMsg = null;
    boolean bool;
    ActivityCenter.GetActivitysRsp localGetActivitysRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label300;
      }
      localGetActivitysRsp = new ActivityCenter.GetActivitysRsp();
    }
    for (;;)
    {
      try
      {
        localGetActivitysRsp.mergeFrom((byte[])paramObject);
        if (bool) {
          if (localGetActivitysRsp.res.has())
          {
            paramFromServiceMsg = (AvGameCommon.Result)localGetActivitysRsp.res.get();
            if (paramFromServiceMsg != null)
            {
              i = paramFromServiceMsg.errcode.get();
              paramToServiceMsg = paramFromServiceMsg.errmsg.get().toStringUtf8();
            }
            if (i != 0) {
              continue;
            }
            paramFromServiceMsg = new nfy();
            paramFromServiceMsg.jdField_a_of_type_JavaLangString = localGetActivitysRsp.icon_url.get();
            paramFromServiceMsg.b = localGetActivitysRsp.jump_url.get();
            paramFromServiceMsg.jdField_a_of_type_Int = localGetActivitysRsp.red_point.get();
            ndq.a().a(nhd.class, 10, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onGetActivityEntry, [" + bool + "," + i + "," + paramToServiceMsg + "," + paramFromServiceMsg + "]");
            }
            return;
            bool = false;
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        bool = false;
        QLog.i("avgame_logic.GameRoomHandler", 1, "onGetActivityEntry, parse error.", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = null;
        continue;
        bool = false;
        paramFromServiceMsg = null;
        continue;
        paramToServiceMsg = null;
        i = 0;
        paramFromServiceMsg = null;
        continue;
      }
      label300:
      paramToServiceMsg = null;
      i = 0;
      paramFromServiceMsg = null;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("playGameId");
    int i = 0;
    paramToServiceMsg = null;
    boolean bool;
    ActivityCenter.SyncShareGameRsp localSyncShareGameRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label293;
      }
      localSyncShareGameRsp = new ActivityCenter.SyncShareGameRsp();
    }
    for (;;)
    {
      try
      {
        localSyncShareGameRsp.mergeFrom((byte[])paramObject);
        if (bool) {
          if (localSyncShareGameRsp.res.has())
          {
            paramFromServiceMsg = (AvGameCommon.Result)localSyncShareGameRsp.res.get();
            if (paramFromServiceMsg != null)
            {
              i = paramFromServiceMsg.errcode.get();
              paramToServiceMsg = paramFromServiceMsg.errmsg.get().toStringUtf8();
            }
            if (i != 0) {
              continue;
            }
            paramFromServiceMsg = localSyncShareGameRsp.jump_url.get();
            ndq.a().a(nhd.class, 11, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, str, paramFromServiceMsg });
            if (QLog.isColorLevel()) {
              QLog.i("avgame_logic.GameRoomHandler", 2, "onSyncShareGame, [" + bool + "," + i + "," + paramToServiceMsg + "," + str + "," + paramFromServiceMsg + "]");
            }
            return;
            bool = false;
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        bool = false;
        QLog.i("avgame_logic.GameRoomHandler", 1, "onSyncShareGame, parse error.", paramFromServiceMsg);
        continue;
        paramFromServiceMsg = null;
        continue;
        bool = false;
        paramFromServiceMsg = null;
        continue;
        paramToServiceMsg = null;
        i = 0;
        paramFromServiceMsg = null;
        continue;
      }
      label293:
      paramToServiceMsg = null;
      i = 0;
      paramFromServiceMsg = null;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    long l2;
    for (;;)
    {
      l2 = paramToServiceMsg.extraData.getLong("room_id");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("user_uin");
      if (i != 0)
      {
        AvGameHeartBeat.CmdUserHeartBeatRsp localCmdUserHeartBeatRsp = new AvGameHeartBeat.CmdUserHeartBeatRsp();
        try
        {
          localCmdUserHeartBeatRsp.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (localCmdUserHeartBeatRsp.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)localCmdUserHeartBeatRsp.res.get();
              if (!localCmdUserHeartBeatRsp.seq.has()) {
                break label292;
              }
              l1 = localCmdUserHeartBeatRsp.seq.get();
              if (!localCmdUserHeartBeatRsp.report_interval.has()) {
                break label298;
              }
              i = localCmdUserHeartBeatRsp.report_interval.get();
              if (paramToServiceMsg == null) {
                break label304;
              }
              j = paramToServiceMsg.errcode.get();
              ndq.a().a(nhd.class, 5, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), paramFromServiceMsg, Integer.valueOf(j) });
              if (QLog.isDevelopLevel()) {
                QLog.i("HeartBeatController", 2, "onStartHeartBeat() success result = " + j + " seq=" + l1);
              }
              return;
              i = 0;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("HeartBeatController", 1, "onStartHeartBeat():" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
            continue;
            label292:
            long l1 = 0L;
            continue;
            label298:
            i = 0;
            continue;
            label304:
            int j = 0;
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HeartBeatController", 2, "onStartHeartBeat() failed");
    }
    ndq.a().a(nhd.class, 5, false, new Object[] { "", Long.valueOf(l2), paramFromServiceMsg });
  }
  
  public void a()
  {
    ActivityCenter.GetActivitysReq localGetActivitysReq = new ActivityCenter.GetActivitysReq();
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ActivityCenter-GetActivitys");
    localToServiceMsg.putWupBuffer(localGetActivitysReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 4, "sendGetActivityEntryReq");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "exitSurvivalPool  " + paramInt);
    }
    a(2, 0, paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getPKInfo " + paramInt1 + " poolId:" + paramInt2);
    }
    b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AvGamePkManager.PKOperationReq localPKOperationReq = new AvGamePkManager.PKOperationReq();
    localPKOperationReq.pk_id.set(paramInt2);
    localPKOperationReq.opt.set(paramInt1);
    localPKOperationReq.pool_id.set(paramInt3);
    localPKOperationReq.cur_round.set(paramInt4);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.PKManager-PKOperation");
    localToServiceMsg.putWupBuffer(localPKOperationReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.addAttribute("opeType", Integer.valueOf(paramInt1));
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "createGameRoom " + paramInt1 + " troopUin: " + paramString);
    }
    String str = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomCreateReq localCmdRoomCreateReq = new AvGameRoomManager.CmdRoomCreateReq();
      localCmdRoomCreateReq.creator_uin.set(nqi.a(str));
      localCmdRoomCreateReq.game_type.set(paramInt2);
      paramInt2 = ndj.a(paramInt1);
      localCmdRoomCreateReq.from.set(paramInt2);
      if (paramInt2 == 3)
      {
        localCmdRoomCreateReq.group_id.set(nqi.a(paramString));
        if (TextUtils.isEmpty(paramString)) {
          QLog.e("avgame_logic.GameRoomHandler", 1, "troopUin EMPTY FP =" + paramInt1);
        }
      }
      paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
      paramString.putWupBuffer(localCmdRoomCreateReq.toByteArray());
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("avgame_logic.GameRoomHandler", 2, "joinGameRoom " + paramInt + " roomId: " + paramString1);
    }
    String str = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomEnterReq localCmdRoomEnterReq = new AvGameRoomManager.CmdRoomEnterReq();
      int i = ndj.b(paramInt);
      localCmdRoomEnterReq.from.set(i);
      localCmdRoomEnterReq.uin.set(nqi.a(str));
      if ((paramInt == 1) || (paramInt == 2))
      {
        localCmdRoomEnterReq.invitor_uin.set(nqi.a(paramString2));
        if (TextUtils.isEmpty(paramString2)) {
          QLog.e("avgame_logic.GameRoomHandler", 1, "INVITER UIN EMPTY FP=" + paramInt);
        }
      }
      localCmdRoomEnterReq.roomid.set(nqi.a(paramString1));
      localCmdRoomEnterReq.invitor_uin.set(nqi.a(paramString2));
      localCmdRoomEnterReq.init_status.set(0);
      paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
      paramString1.putWupBuffer(localCmdRoomEnterReq.toByteArray());
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("avgame_logic.GameRoomHandler", 1, "reportUser exception:", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    AvGameList.CmdGameListReq localCmdGameListReq = new AvGameList.CmdGameListReq();
    localCmdGameListReq.roomid.set(paramLong);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameList-GetGameList");
    localToServiceMsg.putWupBuffer(localCmdGameListReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getGameRoomList() roomId = " + paramLong);
    }
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("stopStrangerMatch() roomId=%d shareId=%d ownerUin=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2) }));
    }
    AvGameStrangerMatch.DelMatchRoomReq localDelMatchRoomReq = new AvGameStrangerMatch.DelMatchRoomReq();
    localDelMatchRoomReq.roomid.set(paramLong1);
    localDelMatchRoomReq.type.set(0);
    localDelMatchRoomReq.shard_id.set(paramInt);
    localDelMatchRoomReq.owner_uin.set(paramLong2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-DelMatchRoom");
    localToServiceMsg.putWupBuffer(localDelMatchRoomReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong1);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AvGameRoomManager.CmdRoomLeaveReq localCmdRoomLeaveReq = new AvGameRoomManager.CmdRoomLeaveReq();
    localCmdRoomLeaveReq.roomid.set(paramLong);
    localCmdRoomLeaveReq.reason.set(paramInt);
    localCmdRoomLeaveReq.operator_uin.set(Long.valueOf(paramString1).longValue());
    localCmdRoomLeaveReq.target_uin.set(Long.valueOf(paramString2).longValue());
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(localCmdRoomLeaveReq.toByteArray());
    localToServiceMsg.extraData.putInt("leave_game_room_type", paramInt);
    localToServiceMsg.extraData.putString("user_uin", paramString2);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("leaveGameRoom() leaveType=%d rId=%d [opUin,dstUin]=[%s,%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2 }));
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("startStrangerMatch() roomId=%d ownerUin=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    AvGameStrangerMatch.AddMatchRoomReq localAddMatchRoomReq = new AvGameStrangerMatch.AddMatchRoomReq();
    localAddMatchRoomReq.roomid.set(paramLong1);
    localAddMatchRoomReq.type.set(0);
    localAddMatchRoomReq.owner_uin.set(paramLong2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.StrangerMatch-AddMatchRoom");
    localToServiceMsg.putWupBuffer(localAddMatchRoomReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong1);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    try
    {
      AvGameShare.CmdGetShareLinkReq localCmdGetShareLinkReq = new AvGameShare.CmdGetShareLinkReq();
      if (paramInt1 == 4)
      {
        localCmdGetShareLinkReq.share_uin.set(paramLong2);
        localCmdGetShareLinkReq.share_type.set(paramInt1);
      }
      for (;;)
      {
        paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
        paramString1.putWupBuffer(localCmdGetShareLinkReq.toByteArray());
        paramString1.extraData.putLong("mark_extra_tag", paramLong3);
        sendPbReq(paramString1);
        return;
        localCmdGetShareLinkReq.roomid.set(paramLong1);
        localCmdGetShareLinkReq.share_uin.set(paramLong2);
        localCmdGetShareLinkReq.share_name.set(paramString1);
        localCmdGetShareLinkReq.share_type.set(paramInt1);
        if (paramInt1 == 2)
        {
          localCmdGetShareLinkReq.play_game_id.set(paramString2);
          localCmdGetShareLinkReq.game_type.set(paramInt2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("avgame_logic.GameRoomHandler", 1, "getShareLink exception: " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    AvGameHeartBeat.CmdUserHeartBeatReq localCmdUserHeartBeatReq = new AvGameHeartBeat.CmdUserHeartBeatReq();
    localCmdUserHeartBeatReq.roomid.set(paramLong);
    localCmdUserHeartBeatReq.uin.set(Long.valueOf(paramString).longValue());
    localCmdUserHeartBeatReq.room_state.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.UserHeartBeat-UserHeartBeat");
    localToServiceMsg.putWupBuffer(localCmdUserHeartBeatReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putString("user_uin", paramString);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("HeartBeatController", 2, "startHeartBeat() roomId = " + paramLong + " userUin=" + paramString);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AvGameRoomManager.CmdRoomChangeUserStatusReq localCmdRoomChangeUserStatusReq = new AvGameRoomManager.CmdRoomChangeUserStatusReq();
    localCmdRoomChangeUserStatusReq.roomid.set(paramLong);
    localCmdRoomChangeUserStatusReq.uin.set(Long.valueOf(paramString).longValue());
    localCmdRoomChangeUserStatusReq.user_status.set(paramInt1);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomUserStatusChange");
    localToServiceMsg.putWupBuffer(localCmdRoomChangeUserStatusReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    localToServiceMsg.extraData.putInt("change_status_from", paramInt2);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("changUserStatus() rId=%d uin=%s uStatus=%d", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) }));
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    AvGameRoomManager.CmdRoomInfoReq localCmdRoomInfoReq = new AvGameRoomManager.CmdRoomInfoReq();
    localCmdRoomInfoReq.roomids.set(paramLong);
    localCmdRoomInfoReq.uin.set(Long.valueOf(paramString).longValue());
    Object localObject = localCmdRoomInfoReq.opt;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomInfoGet");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomInfoReq.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("is_from_sync", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("snapshot_from", paramInt);
      ((ToServiceMsg)localObject).extraData.putString("user_uin", paramString);
      ((ToServiceMsg)localObject).extraData.putLong("room_id", paramLong);
      sendPbReq((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomHandler", 2, String.format("getGameRoomInfo() roomId=%d uin=%s fromSync=%b from=%d", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
      }
      return;
    }
  }
  
  public void a(long paramLong, ArrayList<Integer> paramArrayList)
  {
    AvGameList.CmdGetQuestionClassReq localCmdGetQuestionClassReq = new AvGameList.CmdGetQuestionClassReq();
    localCmdGetQuestionClassReq.roomid.set(paramLong);
    localCmdGetQuestionClassReq.game_type_list.set(paramArrayList);
    paramArrayList = createToServiceMsg("qqvgame.GameList-GetQuestionClass");
    paramArrayList.putWupBuffer(localCmdGetQuestionClassReq.toByteArray());
    paramArrayList.setTimeout(30000L);
    paramArrayList.extraData.putLong("room_id", paramLong);
    sendPbReq(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "getQuestionClass() roomId = " + paramLong);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    AvGameRoomManager.CmdRoomCreateRsp localCmdRoomCreateRsp;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      localCmdRoomCreateRsp = new AvGameRoomManager.CmdRoomCreateRsp();
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. ");
      }
      if (i == 0) {
        break label177;
      }
    }
    for (;;)
    {
      try
      {
        localCmdRoomCreateRsp.mergeFrom((byte[])paramObject);
        j = i;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom.  InvalidProtocolBufferMicroException result：" + paramToServiceMsg.toString());
        j = 0;
        continue;
      }
      paramFromServiceMsg = null;
      if (j == 0) {
        break label628;
      }
      if (localCmdRoomCreateRsp.res.has()) {
        break label221;
      }
      ndq.a().b(nhd.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
      return;
      i = 0;
      break;
      label177:
      j = i;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        j = i;
      }
    }
    label221:
    int j = localCmdRoomCreateRsp.res.errcode.get();
    long l1 = -1L;
    long l2 = 0L;
    if (localCmdRoomCreateRsp.room_info.has())
    {
      l1 = localCmdRoomCreateRsp.room_info.roomid.get();
      paramFromServiceMsg = new RoomInfo();
      paramFromServiceMsg.parseFrom(localCmdRoomCreateRsp.room_info);
      paramToServiceMsg = "";
      if (paramFromServiceMsg.players.size() > 0) {
        paramToServiceMsg = ((Player)paramFromServiceMsg.players.get(0)).uin;
      }
      QLog.d("avgame_logic.GameRoomHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size() + " playerUin" + paramToServiceMsg);
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label604;
      }
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label599;
      }
      paramToServiceMsg = localCmdRoomCreateRsp.auth_info.get().toByteArray();
      label407:
      if (paramToServiceMsg == null) {
        break label681;
      }
      i = paramToServiceMsg.length;
    }
    for (;;)
    {
      label415:
      if (localCmdRoomCreateRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomCreateRsp.black_ban_expire_time.get();
      }
      if (localCmdRoomCreateRsp.res.errmsg.has()) {}
      for (paramObject = localCmdRoomCreateRsp.res.errmsg.get().toStringUtf8();; paramObject = "")
      {
        QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", j + " errMsg : " + paramObject + " roomId:" + l1 + "sig length" + i + " banExpireTime:" + l2 });
        ndq.a().b(nhd.class, 15, true, new Object[] { Integer.valueOf(j), paramObject, paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l2) });
        return;
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom room_info empty");
        break;
        label599:
        paramToServiceMsg = null;
        break label407;
        label604:
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleCreateGameRoom auth_info empty");
        i = 0;
        paramToServiceMsg = null;
        break label415;
      }
      label628:
      ndq.a().b(nhd.class, 15, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleCreateGameRoom. failed not suc");
      return;
      label681:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    ActivityCenter.SyncShareGameReq localSyncShareGameReq = new ActivityCenter.SyncShareGameReq();
    localSyncShareGameReq.play_game_id.set(paramString);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ActivityCenter-SyncShareGame");
    localToServiceMsg.putWupBuffer(localSyncShareGameReq.toByteArray());
    localToServiceMsg.extraData.putString("playGameId", paramString);
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 4, "syncShareGame, playGameId[" + paramString + "]");
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    AvGamePlay.SelectGameReq localSelectGameReq = new AvGamePlay.SelectGameReq();
    localSelectGameReq.uin.set(Long.valueOf(paramString).longValue());
    localSelectGameReq.roomid.set(paramLong);
    localSelectGameReq.type.set(paramInt);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-SelectGame");
    localToServiceMsg.putWupBuffer(localSelectGameReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putLong("room_id", paramLong);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, String.format("selectGame() %s rId=%d gType=%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    boolean bool = false;
    int i;
    long l1;
    long l2;
    String str;
    try
    {
      i = paramNotifyMsg.type.get();
      l1 = paramNotifyMsg.seq.get();
      l2 = paramNotifyMsg.roomid.get();
      str = paramNotifyMsg.play_game_id.get();
      QLog.d("avgame_logic.GameRoomHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), nff.a(i), Long.valueOf(l1), Long.valueOf(l2), str }));
      switch (i)
      {
      case 1: 
        g(paramNotifyMsg, l1, l2);
        return;
      }
    }
    catch (Exception paramNotifyMsg)
    {
      QLog.d("avgame_logic.GameRoomHandler", 1, "handleOnlinePush()  e = " + paramNotifyMsg);
      paramNotifyMsg.printStackTrace();
      return;
    }
    f(paramNotifyMsg, l1, l2);
    return;
    e(paramNotifyMsg, l1, l2);
    return;
    d(paramNotifyMsg, l1, l2);
    return;
    c(paramNotifyMsg, l1, l2);
    return;
    a(paramNotifyMsg, l1, l2, str);
    return;
    for (;;)
    {
      a(bool, paramNotifyMsg, l1);
      return;
      b(paramNotifyMsg, l1, l2);
      return;
      a(paramNotifyMsg, l1, l2);
      return;
      b(paramNotifyMsg);
      return;
      return;
      if (i == 501) {
        bool = true;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "enterSurvivalPool " + paramBoolean + " " + paramInt1 + " " + paramInt2 + " " + paramInt3);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      a(i, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AvGamePkManager.GetPKInfoReq localGetPKInfoReq = new AvGamePkManager.GetPKInfoReq();
    localGetPKInfoReq.pk_id.set(paramInt1);
    localGetPKInfoReq.pool_id.set(paramInt2);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.PKManager-GetPKInfo");
    localToServiceMsg.putWupBuffer(localGetPKInfoReq.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomEnterRsp localCmdRoomEnterRsp = new AvGameRoomManager.CmdRoomEnterRsp();
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {
        break label195;
      }
    }
    for (;;)
    {
      try
      {
        localCmdRoomEnterRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = null;
      if (!bool2) {
        break label596;
      }
      if (localCmdRoomEnterRsp.res.has()) {
        break label239;
      }
      ndq.a().b(nhd.class, 16, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
      QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label195:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label239:
    int j = localCmdRoomEnterRsp.res.errcode.get();
    long l1 = -1L;
    paramObject = null;
    int i = 0;
    long l2 = 0L;
    if (localCmdRoomEnterRsp.room_info.has())
    {
      l1 = localCmdRoomEnterRsp.room_info.roomid.get();
      paramFromServiceMsg = new RoomInfo();
      paramFromServiceMsg.parseFrom(localCmdRoomEnterRsp.room_info);
      QLog.d("avgame_logic.GameRoomHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size());
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label577;
      }
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label572;
      }
      paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
      label387:
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.length;
        paramObject = paramToServiceMsg;
      }
      label399:
      if (localCmdRoomEnterRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomEnterRsp.black_ban_expire_time.get();
      }
      if (!localCmdRoomEnterRsp.res.errmsg.has()) {
        break label589;
      }
    }
    label572:
    label577:
    label589:
    for (paramToServiceMsg = localCmdRoomEnterRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      QLog.d("avgame_logic.GameRoomHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", j + " errMsg : " + paramToServiceMsg + " roomId:" + l1 + "sig length" + i });
      ndq.a().b(nhd.class, 16, true, new Object[] { Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg, paramObject, Long.valueOf(l2) });
      return;
      QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom room_info empty");
      break;
      paramToServiceMsg = null;
      break label387;
      QLog.e("avgame_logic.GameRoomHandler", 1, "handleJoinGameRoom auth_info empty");
      break label399;
    }
    label596:
    ndq.a().b(nhd.class, 16, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(0L) });
    QLog.d("avgame_logic.GameRoomHandler", 2, "handleJoinGameRoom. failed not suc");
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    boolean bool2 = false;
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      String[] arrayOfString = nqb.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.allowCmdSet.add(str);
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (this.allowCmdSet != null)
    {
      bool1 = bool2;
      if (!this.allowCmdSet.contains(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return nhd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("qqvgame.GameList-GetGameList".equals(str)) {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("qqvgame.RoomManager-RoomInfoGet".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomLeave".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomUserStatusChange".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.UserHeartBeat-UserHeartBeat".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.GameManager-SelectGame".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.Share-GetShareLink".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.GameList-GetQuestionClass".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.ActivityCenter-GetActivitys".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.ActivityCenter-SyncShareGame".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.StrangerMatch-AddMatchRoom".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.StrangerMatch-DelMatchRoom".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.PKManager-PKOperation".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomCreate".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomEnter".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"qqvgame.PKManager-GetPKInfo".equals(str));
    f(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngu
 * JD-Core Version:    0.7.0.1
 */