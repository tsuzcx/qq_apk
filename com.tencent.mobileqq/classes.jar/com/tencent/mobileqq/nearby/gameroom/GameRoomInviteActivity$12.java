package com.tencent.mobileqq.nearby.gameroom;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.PlayerState;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class GameRoomInviteActivity$12
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$12(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1008) && (paramInt != 1009) && (paramInt != 1010))
    {
      if (this.a.isHandleReqListError) {
        this.a.handle8e4Error(paramInt, paramRspBody, (String)GameRoomInviteActivity.errorCodeMsgs.get(paramInt));
      }
    }
    else
    {
      boolean bool2 = false;
      if ((paramInt == 1009) && (this.a.mInviteId != null) && (this.a.mInviteId.equals(GameRoomConstants.jdField_a_of_type_JavaLangString)))
      {
        paramRspBody = paramRspBody.poi_info;
        localObject = paramRspBody.bytes_uid.get().toStringUtf8();
        this.a.gotoGameChatPie(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject, paramRspBody.bytes_name.get().toStringUtf8());
        return;
      }
      Object localObject = this.a;
      if (paramRspBody.uint32_refresh_interval.has()) {
        paramInt = paramRspBody.uint32_refresh_interval.get() * 1000;
      } else {
        paramInt = 1000;
      }
      ((GameRoomInviteActivity)localObject).mRefreshDelay = paramInt;
      localObject = this.a;
      ((GameRoomInviteActivity)localObject).mRefreshDelay = Math.max(1000, ((GameRoomInviteActivity)localObject).mRefreshDelay);
      this.a.mUsers = new ArrayList();
      paramInt = 0;
      boolean bool1;
      for (;;)
      {
        int i = paramRspBody.rpt_msg_player_state.size();
        bool1 = true;
        if (paramInt >= i) {
          break;
        }
        localObject = new GameRoomInviteActivity.GameRoomUser(this.a);
        oidb_0x8e4.PlayerState localPlayerState = (oidb_0x8e4.PlayerState)paramRspBody.rpt_msg_player_state.get(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localPlayerState.uint64_uin.get());
        localStringBuilder.append("");
        ((GameRoomInviteActivity.GameRoomUser)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        if (localPlayerState.uint32_state.get() != 1) {
          bool1 = false;
        }
        ((GameRoomInviteActivity.GameRoomUser)localObject).jdField_a_of_type_Boolean = bool1;
        this.a.mUsers.add(localObject);
        paramInt += 1;
      }
      if (paramRspBody.uint32_max_member_num.has()) {
        this.a.mRoomNum = paramRspBody.uint32_max_member_num.get();
      }
      if (paramRspBody.uint32_zone_id.has()) {
        this.a.mZoneId = paramRspBody.uint32_zone_id.get();
      }
      this.a.mOwnerUin = paramRspBody.uint64_leader_uin.get();
      localObject = this.a;
      if ((paramRspBody.uint64_leader_uin.has()) && (this.a.mOwnerUin != this.a.app.getLongAccountUin()))
      {
        bool1 = bool2;
        if (!this.a.mUsers.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      ((GameRoomInviteActivity)localObject).mIsOwner = bool1;
      this.a.mAdapter.notifyDataSetChanged();
      this.a.refreshUI();
      this.a.refreshRepeat();
      this.a.getRecommendData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.12
 * JD-Core Version:    0.7.0.1
 */