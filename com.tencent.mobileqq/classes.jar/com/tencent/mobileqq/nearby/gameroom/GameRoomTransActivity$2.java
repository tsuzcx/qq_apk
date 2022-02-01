package com.tencent.mobileqq.nearby.gameroom;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class GameRoomTransActivity$2
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomTransActivity$2(GameRoomTransActivity paramGameRoomTransActivity, int paramInt) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("quickStartGame onCallback errorCode = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("qqBaseActivity", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = paramRspBody.string_err_title.has();
    Object localObject3 = null;
    if (bool)
    {
      localObject2 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject3;
    if (paramRspBody.string_err_msg.has())
    {
      localObject2 = paramRspBody.string_err_msg.get().toStringUtf8();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = localObject3;
      }
    }
    if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007))
    {
      if ((paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010) && (paramInt != 1013))
      {
        if ((paramInt != 0) && (paramInt != 1009))
        {
          if (paramInt == 1008)
          {
            localObject1 = paramRspBody.string_invite_id.get().toStringUtf8();
            GameRoomConstants.a = (String)localObject1;
            paramInt = this.a;
            if (paramRspBody.uint32_max_member_num.has()) {
              paramInt = paramRspBody.uint32_max_member_num.get();
            }
            this.b.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showMyInviteDialog(this.b, (String)localObject1, paramInt);
          }
          else if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.b.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this.b, (String)localObject1, (String)localObject2);
          }
          else
          {
            QQToast.makeText(this.b, 1, HardCodeUtil.a(2131903103), 1).show();
            if (QLog.isColorLevel())
            {
              paramRspBody = new StringBuilder();
              paramRspBody.append("start game failed! code = ");
              paramRspBody.append(paramInt);
              QLog.d("qqBaseActivity", 2, paramRspBody.toString());
            }
            GameRoomTransActivity.access$001(this.b);
          }
        }
        else
        {
          paramRspBody = paramRspBody.poi_info;
          localObject1 = paramRspBody.bytes_uid.get().toStringUtf8();
          ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).gotoGameChatPie(this.b, HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject1, paramRspBody.bytes_name.get().toStringUtf8());
          this.b.finish();
        }
      }
      else {
        this.b.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this.b, (String)localObject1, (String)localObject2);
      }
    }
    else {
      this.b.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this.b, (String)localObject1, (String)localObject2);
    }
    if (this.b.dialog != null) {
      this.b.dialog.setOnDismissListener(this.b.disMissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity.2
 * JD-Core Version:    0.7.0.1
 */