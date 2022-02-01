import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVedioGamePushInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.resultshare.AvGameResultShare.FileUploadReq;
import trpc.qq_vgame.resultshare.AvGameResultShare.FileUploadRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomDestroyReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomDestroyRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq;
import trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkReq;
import trpc.qq_vgame.share.AvGameShare.CmdGetShareLinkRsp;
import trpc.qq_vgame.share.AvGameShare.CmdInviteCheckReq;
import trpc.qq_vgame.share.AvGameShare.CmdInviteCheckRsp;

public class mwn
  extends anii
{
  public mwn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 2) {
      return 2;
    }
    if ((paramInt == 3) || (paramInt == 6)) {
      return 3;
    }
    if ((paramInt == 4) || (paramInt == 500) || (paramInt == 501) || (paramInt == 502)) {
      return 4;
    }
    if (paramInt == 5) {
      return 5;
    }
    if (paramInt == 1) {
      return 1;
    }
    return 1;
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if ((paramInt == 3) || (paramInt == 5)) {
      return 3;
    }
    if (paramInt == 4) {
      return 4;
    }
    return 4;
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramFromServiceMsg = new AvGameRoomManager.CmdRoomLeaveRsp();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (i != 0) {
            if (paramFromServiceMsg.res.has())
            {
              paramToServiceMsg = (AvGameCommon.Result)paramFromServiceMsg.res.get();
              if (paramFromServiceMsg.room_info.has()) {
                paramFromServiceMsg = (AvGameCommon.RoomInfo)paramFromServiceMsg.room_info.get();
              }
              if ((paramToServiceMsg != null) && (paramToServiceMsg.errcode.get() == 0)) {}
              QLog.i("AvGameRoomListHandler", 4, "onLeaveGameRoom success errorCode= " + paramToServiceMsg.errcode.get() + " errorMsg =" + paramToServiceMsg.errmsg.get());
              return;
              i = 0;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          for (;;)
          {
            QLog.e("AvGameRoomListHandler", 1, "onLeaveGameRoom:" + paramToServiceMsg);
            i = 0;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
    }
    QLog.i("AvGameRoomListHandler", 4, "onLeaveGameRoom failed");
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    int k;
    String str;
    mwd localmwd;
    for (int i = 1;; i = 0)
    {
      k = paramToServiceMsg.extraData.getInt("_result_file_type");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("_result_game_id");
      str = paramToServiceMsg.extraData.getString("_result_url");
      localmwd = (mwd)this.app.getManager(373);
      if (i != 0) {
        break;
      }
      localmwd.a().a(paramFromServiceMsg, k);
      return;
    }
    AvGameResultShare.FileUploadRsp localFileUploadRsp = new AvGameResultShare.FileUploadRsp();
    try
    {
      localFileUploadRsp.mergeFrom((byte[])paramObject);
      paramToServiceMsg = "";
      i = j;
      if (localFileUploadRsp.err_code.has()) {
        i = localFileUploadRsp.err_code.get();
      }
      if (localFileUploadRsp.err_msg.has()) {
        paramToServiceMsg = localFileUploadRsp.err_msg.get();
      }
      if (i != 0)
      {
        QLog.e("AvGameRoomListHandler", 1, "handleGameResultShare retCode:" + i + " errMsg:" + paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      QLog.e("AvGameRoomListHandler", 1, "handleGameResultShare:" + paramToServiceMsg);
      localmwd.a().a(paramFromServiceMsg, k);
      return;
    }
    localmwd.a().a(paramFromServiceMsg, k, str);
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "createGameRoom " + paramInt1 + " troopUin: " + paramString);
    }
    String str = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomCreateReq localCmdRoomCreateReq = new AvGameRoomManager.CmdRoomCreateReq();
      localCmdRoomCreateReq.creator_uin.set(nga.a(str));
      localCmdRoomCreateReq.game_type.set(paramInt2);
      paramInt2 = a(paramInt1);
      localCmdRoomCreateReq.from.set(paramInt2);
      if (paramInt2 == 3)
      {
        localCmdRoomCreateReq.group_id.set(nga.a(paramString));
        if (TextUtils.isEmpty(paramString)) {
          QLog.e("AvGameRoomListHandler", 1, "troopUin EMPTY FP =" + paramInt1);
        }
      }
      paramString = createToServiceMsg("qqvgame.RoomManager-RoomCreate");
      paramString.putWupBuffer(localCmdRoomCreateReq.toByteArray());
      paramString.extraData.putLong("mark_extra_tag", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l = this.app.getLongAccountUin();
    AvGameResultShare.FileUploadReq localFileUploadReq = new AvGameResultShare.FileUploadReq();
    localFileUploadReq.file_type.set(paramInt);
    localFileUploadReq.file_url.set(paramString2);
    localFileUploadReq.play_game_id.set(paramString1);
    localFileUploadReq.uin.set(l);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.ResultShare-FileUpload");
    localToServiceMsg.extraData.putString("_result_game_id", paramString1);
    localToServiceMsg.extraData.putInt("_result_file_type", paramInt);
    localToServiceMsg.extraData.putString("_result_url", paramString2);
    localToServiceMsg.putWupBuffer(localFileUploadReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 1, "updateShareUrl request = " + localToServiceMsg);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "joinGameRoom " + paramInt + " roomId: " + paramString1);
    }
    String str = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomEnterReq localCmdRoomEnterReq = new AvGameRoomManager.CmdRoomEnterReq();
      int i = b(paramInt);
      localCmdRoomEnterReq.from.set(i);
      localCmdRoomEnterReq.uin.set(nga.a(str));
      if ((paramInt == 1) || (paramInt == 2))
      {
        localCmdRoomEnterReq.invitor_uin.set(nga.a(paramString2));
        if (TextUtils.isEmpty(paramString2)) {
          QLog.e("AvGameRoomListHandler", 1, "INVITER UIN EMPTY FP=" + paramInt);
        }
      }
      localCmdRoomEnterReq.roomid.set(nga.a(paramString1));
      localCmdRoomEnterReq.invitor_uin.set(nga.a(paramString2));
      localCmdRoomEnterReq.init_status.set(1);
      paramString1 = createToServiceMsg("qqvgame.RoomManager-RoomEnter");
      paramString1.putWupBuffer(localCmdRoomEnterReq.toByteArray());
      paramString1.extraData.putLong("mark_extra_tag", paramLong);
      sendPbReq(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "reportUser exception:", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    long l = nga.a(this.app.c());
    AvGameRoomManager.CmdRoomLeaveReq localCmdRoomLeaveReq = new AvGameRoomManager.CmdRoomLeaveReq();
    localCmdRoomLeaveReq.roomid.set(paramLong);
    localCmdRoomLeaveReq.reason.set(1);
    localCmdRoomLeaveReq.operator_uin.set(l);
    localCmdRoomLeaveReq.target_uin.set(l);
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.RoomManager-RoomLeave");
    localToServiceMsg.putWupBuffer(localCmdRoomLeaveReq.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("AvGameRoomListHandler", 4, "leaveGameRoom request = " + localToServiceMsg);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("AvGameRoomListHandler", 1, "getShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
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
      QLog.e("AvGameRoomListHandler", 1, "getShareLink exception: " + paramString1.getMessage());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    AvGameRoomManager.CmdRoomCreateRsp localCmdRoomCreateRsp;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      localCmdRoomCreateRsp = new AvGameRoomManager.CmdRoomCreateRsp();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. ");
      }
      l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      if (i == 0) {
        break label192;
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
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom.  InvalidProtocolBufferMicroException result：" + paramToServiceMsg.toString());
        j = 0;
        continue;
      }
      paramFromServiceMsg = null;
      if (j == 0) {
        break label645;
      }
      if (localCmdRoomCreateRsp.res.has()) {
        break label236;
      }
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom.  rspBody.res.has nothing");
      return;
      i = 0;
      break;
      label192:
      j = i;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        j = i;
      }
    }
    label236:
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
      QLog.d("AvGameRoomListHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size() + " playerUin" + paramToServiceMsg);
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label622;
      }
      if (!localCmdRoomCreateRsp.auth_info.has()) {
        break label617;
      }
      paramToServiceMsg = localCmdRoomCreateRsp.auth_info.get().toByteArray();
      label421:
      if (paramToServiceMsg == null) {
        break label701;
      }
      i = paramToServiceMsg.length;
    }
    for (;;)
    {
      label429:
      if (localCmdRoomCreateRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomCreateRsp.black_ban_expire_time.get();
      }
      if (localCmdRoomCreateRsp.res.errmsg.has()) {}
      for (paramObject = localCmdRoomCreateRsp.res.errmsg.get().toStringUtf8();; paramObject = "")
      {
        QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleCreateGameRoom. ret = ", j + " errMsg : " + paramObject + " roomId:" + l1 + "sig length" + i + " banExpireTime:" + l2 });
        notifyUI(1, true, new Object[] { Integer.valueOf(j), paramObject, paramFromServiceMsg, paramToServiceMsg, Long.valueOf(l3), Long.valueOf(l2) });
        return;
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom room_info empty");
        break;
        label617:
        paramToServiceMsg = null;
        break label421;
        label622:
        QLog.e("AvGameRoomListHandler", 1, "handleCreateGameRoom auth_info empty");
        i = 0;
        paramToServiceMsg = null;
        break label429;
      }
      label645:
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleCreateGameRoom. failed not suc");
      return;
      label701:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "destroyGameRoom troopUin: " + paramString);
    }
    Object localObject = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomDestroyReq localCmdRoomDestroyReq = new AvGameRoomManager.CmdRoomDestroyReq();
      localCmdRoomDestroyReq.uin.set(nga.a((String)localObject));
      localCmdRoomDestroyReq.type.set(2);
      localCmdRoomDestroyReq.groupid.set(nga.a(paramString));
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomDestroy");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomDestroyReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "destroyGameRoom exception:", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameRoomListHandler", 2, "batchGetGroupGameRoomList  troopUin: " + paramString + " start: " + paramInt1 + " batchCount: " + paramInt2);
    }
    Object localObject = this.mApp.getCurrentAccountUin();
    try
    {
      AvGameRoomManager.CmdRoomBatchForGroupReq localCmdRoomBatchForGroupReq = new AvGameRoomManager.CmdRoomBatchForGroupReq();
      localCmdRoomBatchForGroupReq.groupid.set(nga.a(paramString));
      localCmdRoomBatchForGroupReq.uin.set(nga.a((String)localObject));
      localCmdRoomBatchForGroupReq.start.set(paramInt1);
      localCmdRoomBatchForGroupReq.batch_num.set(paramInt2);
      localObject = createToServiceMsg("qqvgame.RoomManager-RoomBatchForGroup");
      ((ToServiceMsg)localObject).putWupBuffer(localCmdRoomBatchForGroupReq.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troop_uin_extra_tag", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("AvGameRoomListHandler", 1, "batchGetGroupGameRoomList exception:", paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AvGameRoomListHandler", 1, "getInviteBackflowInfo  key: " + paramString + " pbMark" + paramLong);
    try
    {
      AvGameShare.CmdInviteCheckReq localCmdInviteCheckReq = new AvGameShare.CmdInviteCheckReq();
      localCmdInviteCheckReq.key.set(paramString);
      paramString = createToServiceMsg("qqvgame.Share-InviteBackflowCheck");
      paramString.putWupBuffer(localCmdInviteCheckReq.toByteArray());
      paramString.extraData.putLong("mark_extra_tag", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AvGameRoomListHandler", 1, "getInviteBackflowInfo exception: " + paramString.getMessage());
    }
  }
  
  public void a(TroopTips0x857.QQVedioGamePushInfo paramQQVedioGamePushInfo)
  {
    if (paramQQVedioGamePushInfo == null)
    {
      QLog.d("AvGameRoomListHandler", 2, "handleGameRoomPushInfo pushInfo == null");
      return;
    }
    int i;
    String str;
    if (paramQQVedioGamePushInfo.uint32_msg_type.has())
    {
      i = paramQQVedioGamePushInfo.uint32_msg_type.get();
      if (!paramQQVedioGamePushInfo.uint64_group_code.has()) {
        break label180;
      }
      str = String.valueOf(paramQQVedioGamePushInfo.uint64_group_code.get());
      label53:
      if (!paramQQVedioGamePushInfo.uint64_oper_uin.has()) {
        break label186;
      }
    }
    label180:
    label186:
    for (paramQQVedioGamePushInfo = String.valueOf(paramQQVedioGamePushInfo.uint64_oper_uin.get());; paramQQVedioGamePushInfo = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameRoomListHandler", 2, "handleGameRoomPushInfo, msg_type = " + i + " troopUin = " + str + " oper_uin = " + paramQQVedioGamePushInfo);
      }
      if ((i >= 1) && (str.length() != 0)) {
        break label192;
      }
      QLog.d("AvGameRoomListHandler", 2, "handleGameRoomPushInfo wrong info! msg_type = " + i + " troopUin = " + str);
      return;
      i = -1;
      break;
      str = "";
      break label53;
    }
    label192:
    notifyUI(4, true, new Object[] { Integer.valueOf(i), str, paramQQVedioGamePushInfo });
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomEnterRsp localCmdRoomEnterRsp = new AvGameRoomManager.CmdRoomEnterRsp();
    boolean bool1;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l3 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {
        break label210;
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
        QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = null;
      if (!bool2) {
        break label614;
      }
      if (localCmdRoomEnterRsp.res.has()) {
        break label254;
      }
      notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
      QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom.  rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label210:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label254:
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
      QLog.d("AvGameRoomListHandler", 2, "roominfo :  " + paramFromServiceMsg.toString() + " players:" + paramFromServiceMsg.players.size());
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label596;
      }
      if (!localCmdRoomEnterRsp.auth_info.has()) {
        break label591;
      }
      paramToServiceMsg = localCmdRoomEnterRsp.auth_info.get().toByteArray();
      label402:
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.length;
        paramObject = paramToServiceMsg;
      }
      label414:
      if (localCmdRoomEnterRsp.black_ban_expire_time.has()) {
        l2 = localCmdRoomEnterRsp.black_ban_expire_time.get();
      }
      if (!localCmdRoomEnterRsp.res.errmsg.has()) {
        break label608;
      }
    }
    label591:
    label596:
    label608:
    for (paramToServiceMsg = localCmdRoomEnterRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
    {
      QLog.d("AvGameRoomListHandler", 2, new Object[] { "handleJoinGameRoom. ret = ", j + " errMsg : " + paramToServiceMsg + " roomId:" + l1 + "sig length" + i });
      notifyUI(2, true, new Object[] { Integer.valueOf(j), paramToServiceMsg, paramFromServiceMsg, paramObject, Long.valueOf(l3), Long.valueOf(l2) });
      return;
      QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom room_info empty");
      break;
      paramToServiceMsg = null;
      break label402;
      QLog.e("AvGameRoomListHandler", 1, "handleJoinGameRoom auth_info empty");
      break label414;
    }
    label614:
    notifyUI(2, false, new Object[] { Integer.valueOf(-1), "", null, null, Long.valueOf(l3), Long.valueOf(0L) });
    QLog.d("AvGameRoomListHandler", 2, "handleJoinGameRoom. failed not suc");
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomBatchForGroupRsp localCmdRoomBatchForGroupRsp = new AvGameRoomManager.CmdRoomBatchForGroupRsp();
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList. isSuccess = " + bool1);
      }
      if (!bool1) {}
    }
    else
    {
      try
      {
        localCmdRoomBatchForGroupRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          label82:
          bool2 = false;
          QLog.e("AvGameRoomListHandler", 1, "handleGetGroupGameRoomList.  false result：" + paramFromServiceMsg.toString());
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
      paramObject = new ArrayList();
      if (!bool2) {
        break label578;
      }
      if (localCmdRoomBatchForGroupRsp.res.has()) {
        break label266;
      }
      notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramFromServiceMsg, paramObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList. rspBody.res.has nothing");
    }
    label266:
    label440:
    label572:
    label578:
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = bool1;
      if (paramFromServiceMsg == null) {
        break label82;
      }
      QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
      bool2 = bool1;
      break label82;
      int m = localCmdRoomBatchForGroupRsp.res.errcode.get();
      if (localCmdRoomBatchForGroupRsp.res.errmsg.has()) {}
      int i;
      for (paramToServiceMsg = localCmdRoomBatchForGroupRsp.res.errmsg.get().toStringUtf8();; paramToServiceMsg = "")
      {
        List localList = localCmdRoomBatchForGroupRsp.room_infos.get();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        i = 0;
        while (i < localList.size())
        {
          RoomInfo localRoomInfo = new RoomInfo();
          localRoomInfo.parseFrom((AvGameCommon.RoomInfo)localList.get(i));
          paramObject.add(localRoomInfo);
          i += 1;
        }
      }
      int j;
      if (localCmdRoomBatchForGroupRsp.total_room_num.has())
      {
        i = localCmdRoomBatchForGroupRsp.total_room_num.get();
        if (!localCmdRoomBatchForGroupRsp.next.has()) {
          break label566;
        }
        j = localCmdRoomBatchForGroupRsp.next.get();
        if (!localCmdRoomBatchForGroupRsp.is_end.has()) {
          break label572;
        }
      }
      for (int k = localCmdRoomBatchForGroupRsp.is_end.get();; k = 0)
      {
        notifyUI(3, true, new Object[] { Integer.valueOf(m), paramToServiceMsg, paramFromServiceMsg, paramObject, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList.get gameRoomList retcode" + m + " gameRoomList size" + paramObject.size());
        return;
        i = 0;
        break;
        j = 0;
        break label440;
      }
      notifyUI(3, false, new Object[] { Integer.valueOf(-1), "", paramFromServiceMsg, paramObject, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    } while (!QLog.isColorLevel());
    label566:
    QLog.d("AvGameRoomListHandler", 2, "handleGetGroupGameRoomList fail");
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdGetShareLinkRsp localCmdGetShareLinkRsp = new AvGameShare.CmdGetShareLinkRsp();
    boolean bool1;
    long l;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("AvGameRoomListHandler", 1, "handleGameShare. isSuccess = " + bool1);
      if (!bool1) {
        break label180;
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
        QLog.e("AvGameRoomListHandler", 1, "handleGameShare.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      if (!bool2) {
        break label294;
      }
      if (localCmdGetShareLinkRsp.share_url.has()) {
        break label224;
      }
      notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
      QLog.e("AvGameRoomListHandler", 1, "handleGameShare. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label180:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label224:
    paramToServiceMsg = localCmdGetShareLinkRsp.share_url.get();
    notifyUI(6, true, new Object[] { paramToServiceMsg, Long.valueOf(l) });
    QLog.d("AvGameRoomListHandler", 1, "handleGameShare.get shareUrl:" + paramToServiceMsg + " mark: " + l);
    return;
    label294:
    notifyUI(6, false, new Object[] { "", Long.valueOf(l) });
    QLog.e("AvGameRoomListHandler", 1, "handleGameShare fail");
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameShare.CmdInviteCheckRsp localCmdInviteCheckRsp = new AvGameShare.CmdInviteCheckRsp();
    boolean bool1;
    long l1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      l1 = paramToServiceMsg.extraData.getLong("mark_extra_tag");
      QLog.d("AvGameRoomListHandler", 1, "handleShareInviteBackflow. isSuccess = " + bool1);
      if (!bool1) {
        break label200;
      }
    }
    for (;;)
    {
      try
      {
        localCmdInviteCheckRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow.  false result：" + paramToServiceMsg.toString());
        bool2 = false;
        continue;
      }
      if (!bool2) {
        break label349;
      }
      if ((localCmdInviteCheckRsp.roomid.has()) && (localCmdInviteCheckRsp.share_uin.has())) {
        break label244;
      }
      notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l1) });
      QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow. rspBody.res.has nothing");
      return;
      bool1 = false;
      break;
      label200:
      boolean bool2 = bool1;
      if (paramFromServiceMsg != null)
      {
        QLog.e("AvGameRoomListHandler", 1, "ERRCODE:" + paramFromServiceMsg.getResultCode());
        bool2 = bool1;
      }
    }
    label244:
    long l2 = localCmdInviteCheckRsp.roomid.get();
    long l3 = localCmdInviteCheckRsp.share_uin.get();
    notifyUI(7, true, new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
    QLog.d("AvGameRoomListHandler", 1, "handleShareInviteBackflow.get roomId:" + l2 + " shareUin: " + l3 + " mark: " + l1);
    return;
    label349:
    notifyUI(7, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(l1) });
    QLog.e("AvGameRoomListHandler", 1, "handleShareInviteBackflow fail");
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    AvGameRoomManager.CmdRoomDestroyRsp localCmdRoomDestroyRsp = new AvGameRoomManager.CmdRoomDestroyRsp();
    boolean bool1;
    boolean bool2;
    label82:
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AvGameRoomListHandler", 2, "handleDestroyAllGameRoom. isSuccess = " + bool1);
      }
      if (!bool1) {}
    }
    else
    {
      try
      {
        localCmdRoomDestroyRsp.mergeFrom((byte[])paramObject);
        bool2 = bool1;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.e("AvGameRoomListHandler", 2, "handleDestroyAllGameRoom.  false result：" + paramFromServiceMsg.toString());
          bool2 = false;
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("troop_uin_extra_tag");
      paramToServiceMsg = "";
      if ((!bool2) || (!localCmdRoomDestroyRsp.res.has())) {
        break label274;
      }
      i = localCmdRoomDestroyRsp.res.errcode.get();
      if (!localCmdRoomDestroyRsp.res.errmsg.has()) {
        break label268;
      }
      paramToServiceMsg = localCmdRoomDestroyRsp.res.errmsg.get().toStringUtf8();
    }
    for (;;)
    {
      notifyUI(5, bool2, new Object[] { Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
      return;
      bool1 = false;
      break;
      bool2 = bool1;
      if (paramFromServiceMsg == null) {
        break label82;
      }
      QLog.e("AvGameRoomListHandler", 2, "ERRCODE:" + paramFromServiceMsg.getResultCode());
      bool2 = bool1;
      break label82;
      label268:
      paramToServiceMsg = "";
      continue;
      label274:
      i = 0;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("qqvgame.RoomManager-RoomCreate");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomEnter");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomLeave");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomBatchForGroup");
      this.allowCmdSet.add("qqvgame.ResultShare-FileUpload");
      this.allowCmdSet.add("qqvgame.Share-GetShareLink");
      this.allowCmdSet.add("qqvgame.Share-InviteBackflowCheck");
      this.allowCmdSet.add("qqvgame.RoomManager-RoomDestroy");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return mwq.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      if ("qqvgame.RoomManager-RoomCreate".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomEnter".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomLeave".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomBatchForGroup".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.ResultShare-FileUpload".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.RoomManager-RoomDestroy".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qqvgame.Share-GetShareLink".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"qqvgame.Share-InviteBackflowCheck".equals(paramFromServiceMsg.getServiceCmd()));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwn
 * JD-Core Version:    0.7.0.1
 */