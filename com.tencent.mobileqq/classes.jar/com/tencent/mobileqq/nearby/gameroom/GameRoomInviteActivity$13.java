package com.tencent.mobileqq.nearby.gameroom;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.PlayerState;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

class GameRoomInviteActivity$13
  extends WerewolvesObserver
{
  GameRoomInviteActivity$13(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.mLoadingView != null)
    {
      if (this.a.isFinishing()) {
        return;
      }
      GameRoomInviteActivity localGameRoomInviteActivity;
      if (paramInt == 0)
      {
        localGameRoomInviteActivity = this.a;
        localGameRoomInviteActivity.isLoading = false;
        localGameRoomInviteActivity.mLoadingView.c();
        this.a.mLoadingView.setComplete(new GameRoomInviteActivity.13.1(this));
        this.a.report("load_page", "suc_cnt");
        return;
      }
      if (paramInt != 4)
      {
        if (this.a.retryTimes > 3)
        {
          this.a.mLoadingView.c.setText(HardCodeUtil.a(2131903085));
          this.a.mLoadingView.c();
          this.a.mLoadingView.setProgress(0);
          this.a.isLoading = false;
          return;
        }
        localGameRoomInviteActivity = this.a;
        localGameRoomInviteActivity.isLoading = true;
        localGameRoomInviteActivity.mWwPluginManager.a();
        localGameRoomInviteActivity = this.a;
        localGameRoomInviteActivity.retryTimes += 1;
      }
    }
  }
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_msg_type.get();
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("the 0xdd push type is wrong:");
              ((StringBuilder)localObject).append(paramMsgBody.uint32_msg_type.get());
              QLog.d("GameRoomInviteActivity", 2, ((StringBuilder)localObject).toString());
            }
          }
          else {
            this.a.showCreateNewTeamDialog(null, HardCodeUtil.a(2131903087), true);
          }
        }
        else
        {
          QQToast.makeText(this.a, HardCodeUtil.a(2131903109), 0).show();
          this.a.finish();
          paramMsgBody = this.a;
          paramMsgBody.mUsers = null;
          SharedPreUtils.a(paramMsgBody, paramMsgBody.app.getCurrentAccountUin(), false, System.currentTimeMillis());
        }
      }
      else
      {
        paramMsgBody = (submsgtype0xdd.MsgBody.WifiPOIInfo)paramMsgBody.msg_poi_info.get();
        localObject = paramMsgBody.bytes_uid.get().toStringUtf8();
        this.a.gotoGameChatPie(HotChatInfo.createHotChat(paramMsgBody, false, 0), paramMsgBody.uint32_group_code.get(), (String)localObject, paramMsgBody.bytes_name.get().toStringUtf8());
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.c()));
      }
    }
    else
    {
      localObject = this.a;
      boolean bool;
      if ((paramMsgBody.uint64_invite_leader.has()) && (paramMsgBody.uint64_invite_leader.get() != this.a.app.getLongAccountUin())) {
        bool = false;
      } else {
        bool = true;
      }
      ((GameRoomInviteActivity)localObject).mIsOwner = bool;
      this.a.mUsers = new ArrayList();
      i = 0;
      while (i < paramMsgBody.rpt_msg_player_state.size())
      {
        localObject = new GameRoomInviteActivity.GameRoomUser(this.a);
        submsgtype0xdd.MsgBody.PlayerState localPlayerState = (submsgtype0xdd.MsgBody.PlayerState)paramMsgBody.rpt_msg_player_state.get(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localPlayerState.uint64_uin.get());
        localStringBuilder.append("");
        ((GameRoomInviteActivity.GameRoomUser)localObject).a = localStringBuilder.toString();
        if (localPlayerState.uint32_state.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((GameRoomInviteActivity.GameRoomUser)localObject).b = bool;
        this.a.mUsers.add(localObject);
        i += 1;
      }
      if (!this.a.isLoading)
      {
        this.a.mAdapter.notifyDataSetChanged();
        this.a.refreshUI();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.13
 * JD-Core Version:    0.7.0.1
 */