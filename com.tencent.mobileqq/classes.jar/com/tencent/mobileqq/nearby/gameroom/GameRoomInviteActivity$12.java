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
    boolean bool2 = false;
    if (this.a.isFinishing()) {}
    label192:
    do
    {
      return;
      if ((paramInt == 0) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010))
      {
        if ((paramInt == 1009) && (this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_b_of_type_JavaLangString.equals(GameRoomInviteActivity.jdField_a_of_type_JavaLangString)))
        {
          paramRspBody = paramRspBody.poi_info;
          localObject = paramRspBody.bytes_uid.get().toStringUtf8();
          this.a.a(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject, paramRspBody.bytes_name.get().toStringUtf8());
          return;
        }
        Object localObject = this.a;
        if (paramRspBody.uint32_refresh_interval.has())
        {
          paramInt = paramRspBody.uint32_refresh_interval.get() * 1000;
          ((GameRoomInviteActivity)localObject).c = paramInt;
          this.a.c = Math.max(1000, this.a.c);
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramInt = 0;
          if (paramInt >= paramRspBody.rpt_msg_player_state.size()) {
            break label314;
          }
          localObject = new GameRoomInviteActivity.GameRoomUser(this.a);
          oidb_0x8e4.PlayerState localPlayerState = (oidb_0x8e4.PlayerState)paramRspBody.rpt_msg_player_state.get(paramInt);
          ((GameRoomInviteActivity.GameRoomUser)localObject).jdField_a_of_type_JavaLangString = (localPlayerState.uint64_uin.get() + "");
          if (localPlayerState.uint32_state.get() != 1) {
            break label309;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          ((GameRoomInviteActivity.GameRoomUser)localObject).jdField_a_of_type_Boolean = bool1;
          this.a.jdField_a_of_type_JavaUtilList.add(localObject);
          paramInt += 1;
          break label192;
          paramInt = 1000;
          break;
        }
        if (paramRspBody.uint32_max_member_num.has()) {
          this.a.jdField_a_of_type_Int = paramRspBody.uint32_max_member_num.get();
        }
        if (paramRspBody.uint32_zone_id.has()) {
          this.a.jdField_b_of_type_Int = paramRspBody.uint32_zone_id.get();
        }
        this.a.jdField_b_of_type_Long = paramRspBody.uint64_leader_uin.get();
        localObject = this.a;
        if ((paramRspBody.uint64_leader_uin.has()) && (this.a.jdField_b_of_type_Long != this.a.app.getLongAccountUin()))
        {
          bool1 = bool2;
          if (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) {}
        }
        else
        {
          bool1 = true;
        }
        ((GameRoomInviteActivity)localObject).jdField_a_of_type_Boolean = bool1;
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter.notifyDataSetChanged();
        this.a.a();
        this.a.g();
        this.a.j();
        return;
      }
    } while (!this.a.e);
    label309:
    label314:
    this.a.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.12
 * JD-Core Version:    0.7.0.1
 */