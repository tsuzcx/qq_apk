import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
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
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListRsp;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassReq;
import trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassRsp;
import trpc.qq_vgame.game_list.AvGameList.GameListItemInfo;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;
import trpc.qq_vgame.nofity.AvGameNotify.RoomDestoryS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerChangeGameS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserChangeStatusS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserEnterS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomUserExitS2CReq;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.SelectGameRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatReq;
import trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatRsp;

public class mza
  extends mwm
{
  public mza(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          mxp localmxp;
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
              localRoomInfo = mxo.a((AvGameCommon.RoomInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject).room_info.get());
              localmxp = null;
              localList = null;
              localArrayList = null;
              j = 0;
              paramObject = null;
              paramFromServiceMsg = null;
              bool2 = bool1;
              if (bool4)
              {
                localmxp = mxo.a((AvGameCommon.GameStatusInfo)((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_status_info.get());
                if ((localmxp == null) || (!localmxp.a())) {
                  break label644;
                }
                bool2 = true;
                localList = mxo.a(((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_ranking_info);
                localObject = (AvGameList.CmdGameListRsp)((AvGameRoomManager.CmdRoomInfoRsp)localObject).game_cfg_info.get();
                j = ((AvGameList.CmdGameListRsp)localObject).curr_game_index.get();
                paramObject = ((AvGameList.CmdGameListRsp)localObject).resource_url.get();
                paramFromServiceMsg = ((AvGameList.CmdGameListRsp)localObject).resource_md5.get();
                localArrayList = new ArrayList();
                a(((AvGameList.CmdGameListRsp)localObject).game_list.get(), localArrayList);
                QLog.d("avgame_logic.GameRoomHandler", 1, String.format("onGetGameRoomInfo game valid=%b game=%s", new Object[] { Boolean.valueOf(bool2), localmxp }));
                bool2 = bool1 & bool2;
              }
              bool3 = bool2;
              if (bool2) {
                mwu.a().b(mzj.class, 1, true, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, localRoomInfo, localmxp, localList, localArrayList, Integer.valueOf(j), paramObject, paramFromServiceMsg, Integer.valueOf(k) });
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
        mwu.a().b(mzj.class, 1, false, new Object[] { Boolean.valueOf(bool4), Long.valueOf(l), str, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(k) });
      }
      mxt.a(bool3, k);
      return;
      bool1 = false;
      break;
      label644:
      paramToServiceMsg = "";
      i = 0;
    }
  }
  
  private void a(List<AvGameList.GameListItemInfo> paramList, List<myg> paramList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AvGameList.GameListItemInfo localGameListItemInfo = (AvGameList.GameListItemInfo)paramList.next();
        if (localGameListItemInfo != null)
        {
          myg localmyg = new myg();
          localmyg.a(localGameListItemInfo);
          paramList1.add(localmyg);
        }
      }
    }
  }
  
  private void a(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomOwnerChangeGameS2CReq)paramNotifyMsg.change_game_req.get();
    if (paramNotifyMsg.game_type.has()) {}
    for (int i = paramNotifyMsg.game_type.get();; i = 1)
    {
      mxo.a("avgame_logic.GameRoomHandler", "handlerChangeGamePush()", new String[] { "AvGameNotify.RoomOwnerChangeGameS2CReq" }, new MessageMicro[] { paramNotifyMsg });
      mwu.a().b(mzj.class, 24, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i) });
      return;
    }
  }
  
  private void a(AvGameRoomManager.CmdRoomInfoRsp paramCmdRoomInfoRsp) {}
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          mxo.a("avgame_logic.GameRoomHandler", "onGetGameRoomList()", null, new MessageMicro[] { localCmdGameListRsp });
          if (localCmdGameListRsp.game_list.has())
          {
            paramToServiceMsg = localCmdGameListRsp.game_list.get();
            if ((i == 0) || (paramToServiceMsg == null)) {
              break label345;
            }
            if (!localCmdGameListRsp.curr_game_index.has()) {
              break label334;
            }
            i = localCmdGameListRsp.curr_game_index.get();
            paramObject = new ArrayList();
            a(paramToServiceMsg, paramObject);
            if (!localCmdGameListRsp.resource_url.has()) {
              break label340;
            }
            paramToServiceMsg = localCmdGameListRsp.resource_url.get();
            paramFromServiceMsg = localObject;
            if (localCmdGameListRsp.resource_md5.has()) {
              paramFromServiceMsg = localCmdGameListRsp.resource_md5.get();
            }
            mwu.a().b(mzj.class, 2, true, new Object[] { paramObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg, Long.valueOf(l) });
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
            label334:
            i = 0;
            continue;
            label340:
            paramToServiceMsg = null;
          }
        }
      }
    }
    label345:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onGetGameRoomList failed ");
    }
    mwu.a().b(mzj.class, 2, false, new Object[] { Long.valueOf(l) });
  }
  
  private void b(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserChangeStatusS2CReq localRoomUserChangeStatusS2CReq = (AvGameNotify.RoomUserChangeStatusS2CReq)paramNotifyMsg.room_user_change_status_req.get();
    if (localRoomUserChangeStatusS2CReq.uin.has())
    {
      paramNotifyMsg = String.valueOf(localRoomUserChangeStatusS2CReq.uin.get());
      if (!localRoomUserChangeStatusS2CReq.user_status.has()) {
        break label153;
      }
    }
    label153:
    for (int i = localRoomUserChangeStatusS2CReq.user_status.get();; i = 0)
    {
      RoomInfo localRoomInfo = mxo.a((AvGameCommon.RoomInfo)localRoomUserChangeStatusS2CReq.room_info.get());
      mxo.a("avgame_logic.GameRoomHandler", "handlerChangeUserStatusPush()", new String[] { "AvGameNotify.RoomUserChangeStatusS2CReq" }, new MessageMicro[] { localRoomUserChangeStatusS2CReq });
      mwu.a().b(mzj.class, 23, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramNotifyMsg, Integer.valueOf(i), localRoomInfo });
      return;
      paramNotifyMsg = "";
      break;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label514;
      }
      paramToServiceMsg = new AvGameList.CmdGetQuestionClassRsp();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        mxo.a("avgame_logic.GameRoomHandler", "onGetQuestionClass()", null, new MessageMicro[] { paramToServiceMsg });
        paramObject = paramToServiceMsg;
        if ((i != 0) && (paramObject.res.errcode.get() == 0)) {
          if (paramObject.question_class_title_url.has())
          {
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
            myh localmyh = new myh();
            localmyh.a(localQuestionClassInfo);
            localArrayList.add(localmyh);
            i += 1;
            continue;
            i = 0;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        ArrayList localArrayList;
        i = 0;
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass:" + paramFromServiceMsg);
        continue;
        paramToServiceMsg = "";
        continue;
        paramFromServiceMsg = "";
        continue;
        paramObject = null;
        continue;
        mwu.a().b(mzj.class, 9, true, new Object[] { Long.valueOf(l), null, localArrayList, paramToServiceMsg, paramFromServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameRoomHandler", 2, "onGetQuestionClass success! roomId = " + l + " questionClassInfoListSize=" + localArrayList.size() + " titleImageUrl=" + paramToServiceMsg + " buttonImageUrl=" + paramFromServiceMsg);
        }
        return;
      }
      i = paramObject.res.errcode.get();
      if (paramObject.res.errmsg.has()) {}
      for (paramToServiceMsg = paramObject.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "拉取题库类型失败")
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "onGetQuestionClass fail! errorCode = " + i + "retMsg=" + paramToServiceMsg);
        mwu.a().b(mzj.class, 9, false, new Object[] { Long.valueOf(l), paramToServiceMsg, null, null, null });
        return;
      }
      label514:
      paramObject = null;
    }
  }
  
  private void c(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    paramNotifyMsg = (AvGameNotify.RoomDestoryS2CReq)paramNotifyMsg.room_destory_req.get();
    mxo.a("avgame_logic.GameRoomHandler", "handlerDestroyRoomPush()", new String[] { "AvGameNotify.RoomDestoryS2CReq" }, new MessageMicro[] { paramNotifyMsg });
    mwu.a().b(mzj.class, 22, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
                break label233;
              }
              l1 = paramFromServiceMsg.seq.get();
              if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0)) {
                break label239;
              }
              mwu.a().b(mzj.class, 6, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              mxo.a("avgame_logic.GameRoomHandler", "onSelectGame()", new String[] { "AvGameCommon.Result -> seq = " + l1 }, new MessageMicro[] { paramToServiceMsg });
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
            label233:
            long l1 = 0L;
            continue;
            label239:
            mwu.a().b(mzj.class, 6, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          }
        }
      }
    }
    QLog.e("avgame_logic.GameRoomHandler", 1, "onSelectGame()  failed ");
    mwu.a().b(mzj.class, 6, false, new Object[] { Long.valueOf(0L), Long.valueOf(l2) });
  }
  
  private void d(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
  {
    AvGameNotify.RoomUserExitS2CReq localRoomUserExitS2CReq = (AvGameNotify.RoomUserExitS2CReq)paramNotifyMsg.room_user_exit_req.get();
    int i;
    label56:
    String str;
    if (localRoomUserExitS2CReq.exit_reason.has())
    {
      i = localRoomUserExitS2CReq.exit_reason.get();
      if (!localRoomUserExitS2CReq.exit_uin.has()) {
        break label213;
      }
      paramNotifyMsg = String.valueOf(localRoomUserExitS2CReq.exit_uin.get());
      if (!localRoomUserExitS2CReq.new_owner_uin.has()) {
        break label219;
      }
      str = String.valueOf(localRoomUserExitS2CReq.new_owner_uin.get());
      label80:
      if (!localRoomUserExitS2CReq.heartbeat_timeout.has()) {
        break label226;
      }
    }
    label213:
    label219:
    label226:
    for (int j = localRoomUserExitS2CReq.heartbeat_timeout.get();; j = 0)
    {
      RoomInfo localRoomInfo = mxo.a((AvGameCommon.RoomInfo)localRoomUserExitS2CReq.room_info.get());
      mxo.a("avgame_logic.GameRoomHandler", "handlerExitRoomPush()", new String[] { "AvGameNotify.RoomUserExitS2CReq" }, new MessageMicro[] { localRoomUserExitS2CReq });
      mwu.a().b(mzj.class, 21, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str, localRoomInfo, Integer.valueOf(j) });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
      str = "";
      break label80;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label184;
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
        break label302;
      }
      if (localCmdGetShareLinkRsp.share_url.has()) {
        break label228;
      }
      mwu.a().a(mzj.class, 8, false, new Object[] { "", Long.valueOf(l) });
      QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label184:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("avgame_logic.GameRoomHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label228:
    paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
    mwu.a().a(mzj.class, 8, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
    QLog.d("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink.get shareUrl:" + paramToServiceMsg + " mark: " + l);
    return;
    label302:
    mwu.a().a(mzj.class, 8, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("avgame_logic.GameRoomHandler", 1, "onGameGetShareLink fail");
  }
  
  private void e(AvGameNotify.NotifyMsg paramNotifyMsg, long paramLong1, long paramLong2)
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
        break label189;
      }
    }
    label183:
    label189:
    for (String str = String.valueOf(localRoomUserEnterS2CReq.inviter_uin.get());; str = "")
    {
      RoomInfo localRoomInfo = mxo.a((AvGameCommon.RoomInfo)localRoomUserEnterS2CReq.room_info.get());
      mxo.a("avgame_logic.GameRoomHandler", "handlerEnterRoomPush()", new String[] { "AvGameNotify.RoomUserEnterS2CReq" }, new MessageMicro[] { localRoomUserEnterS2CReq });
      mwu.a().b(mzj.class, 20, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i), paramNotifyMsg, str, localRoomInfo });
      return;
      i = 0;
      break;
      paramNotifyMsg = "";
      break label56;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label292;
      }
      AvGameRoomManager.CmdRoomLeaveRsp localCmdRoomLeaveRsp = new AvGameRoomManager.CmdRoomLeaveRsp();
      try
      {
        localCmdRoomLeaveRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label292;
        }
        paramToServiceMsg = (AvGameCommon.Result)localCmdRoomLeaveRsp.res.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0))
        {
          paramToServiceMsg = mxo.a((AvGameCommon.RoomInfo)localCmdRoomLeaveRsp.room_info.get());
          mwu.a().a(mzj.class, 3, true, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
          mxo.a("avgame_logic.GameRoomHandler", "onLeaveGameRoom()", null, new MessageMicro[] { localCmdRoomLeaveRsp });
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
          break label286;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has()) {}
    label286:
    for (paramToServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      mwu.a().a(mzj.class, 3, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
      break;
    }
    label292:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onLeaveGameRoom() failed");
    }
    mwu.a().a(mzj.class, 3, false, new Object[] { Long.valueOf(l), Integer.valueOf(j), paramFromServiceMsg, "" });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("room_id");
    int j = paramToServiceMsg.extraData.getInt("change_status_from");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label320;
      }
      AvGameRoomManager.CmdRoomChangeUserStatusRsp localCmdRoomChangeUserStatusRsp = new AvGameRoomManager.CmdRoomChangeUserStatusRsp();
      try
      {
        localCmdRoomChangeUserStatusRsp.mergeFrom((byte[])paramObject);
        if (i == 0) {
          break label320;
        }
        if (localCmdRoomChangeUserStatusRsp.res.has())
        {
          paramToServiceMsg = (AvGameCommon.Result)localCmdRoomChangeUserStatusRsp.res.get();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.errcode.get() != 0) || (localCmdRoomChangeUserStatusRsp.room_info.get() == null)) {
            break label225;
          }
          paramToServiceMsg = mxo.a((AvGameCommon.RoomInfo)localCmdRoomChangeUserStatusRsp.room_info.get());
          mwu.a().b(mzj.class, 4, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
          mxo.a("avgame_logic.GameRoomHandler", "onChangeUserStatus()", null, new MessageMicro[] { localCmdRoomChangeUserStatusRsp });
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
        label225:
        if (paramToServiceMsg == null) {
          break label308;
        }
      }
    }
    if (paramToServiceMsg.errmsg.has())
    {
      paramFromServiceMsg = paramToServiceMsg.errmsg.get().toStringUtf8();
      label250:
      if (paramToServiceMsg == null) {
        break label314;
      }
    }
    label308:
    label314:
    for (int i = paramToServiceMsg.errcode.get();; i = -1)
    {
      mwu.a().b(mzj.class, 4, false, new Object[] { Long.valueOf(l), paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramFromServiceMsg = "";
      break label250;
    }
    label320:
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomHandler", 2, "onChangeUserStatus() failed");
    }
    mwu.a().b(mzj.class, 4, false, new Object[] { Long.valueOf(l), "", Integer.valueOf(109), Integer.valueOf(j) });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
                break label290;
              }
              l1 = localCmdUserHeartBeatRsp.seq.get();
              if (!localCmdUserHeartBeatRsp.report_interval.has()) {
                break label296;
              }
              i = localCmdUserHeartBeatRsp.report_interval.get();
              if (paramToServiceMsg == null) {
                break label302;
              }
              j = paramToServiceMsg.errcode.get();
              mwu.a().a(mzj.class, 5, true, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), paramFromServiceMsg, Integer.valueOf(j) });
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
            label290:
            long l1 = 0L;
            continue;
            label296:
            i = 0;
            continue;
            label302:
            int j = 0;
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HeartBeatController", 2, "onStartHeartBeat() failed");
    }
    mwu.a().a(mzj.class, 5, false, new Object[] { "", Long.valueOf(l2), paramFromServiceMsg });
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
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    try
    {
      AvGameShare.CmdGetShareLinkReq localCmdGetShareLinkReq = new AvGameShare.CmdGetShareLinkReq();
      localCmdGetShareLinkReq.roomid.set(paramLong1);
      localCmdGetShareLinkReq.share_uin.set(paramLong2);
      localCmdGetShareLinkReq.share_name.set(paramString1);
      localCmdGetShareLinkReq.share_type.set(paramInt1);
      if (paramInt1 == 2)
      {
        localCmdGetShareLinkReq.play_game_id.set(paramString2);
        localCmdGetShareLinkReq.game_type.set(paramInt2);
      }
      paramString1 = createToServiceMsg("qqvgame.Share-GetShareLink");
      paramString1.putWupBuffer(localCmdGetShareLinkReq.toByteArray());
      paramString1.extraData.putLong("mark_extra_tag", paramLong3);
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("avgame_logic.GameRoomHandler", 1, "getShareLink exception: " + paramString1.getMessage());
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    AvGameHeartBeat.CmdUserHeartBeatReq localCmdUserHeartBeatReq = new AvGameHeartBeat.CmdUserHeartBeatReq();
    localCmdUserHeartBeatReq.roomid.set(paramLong);
    localCmdUserHeartBeatReq.uin.set(Long.valueOf(paramString).longValue());
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
    long l1;
    long l2;
    try
    {
      int i = paramNotifyMsg.type.get();
      l1 = paramNotifyMsg.seq.get();
      l2 = paramNotifyMsg.roomid.get();
      String str = paramNotifyMsg.play_game_id.get();
      QLog.d("avgame_logic.GameRoomHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), mxo.a(i), Long.valueOf(l1), Long.valueOf(l2), str }));
      switch (i)
      {
      case 1: 
        e(paramNotifyMsg, l1, l2);
        return;
      }
    }
    catch (Exception paramNotifyMsg)
    {
      QLog.d("avgame_logic.GameRoomHandler", 1, "handleOnlinePush()  e = " + paramNotifyMsg);
      paramNotifyMsg.printStackTrace();
      return;
    }
    d(paramNotifyMsg, l1, l2);
    return;
    c(paramNotifyMsg, l1, l2);
    return;
    b(paramNotifyMsg, l1, l2);
    return;
    a(paramNotifyMsg, l1, l2);
    return;
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    boolean bool2 = false;
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      String[] arrayOfString = nft.a;
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
  
  protected Class<? extends anil> observerClass()
  {
    return mzj.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("qqvgame.GameList-GetGameList".equals(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("qqvgame.RoomManager-RoomInfoGet".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomLeave".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomUserStatusChange".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.UserHeartBeat-UserHeartBeat".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.GameManager-SelectGame".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.Share-GetShareLink".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"qqvgame.GameList-GetQuestionClass".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mza
 * JD-Core Version:    0.7.0.1
 */