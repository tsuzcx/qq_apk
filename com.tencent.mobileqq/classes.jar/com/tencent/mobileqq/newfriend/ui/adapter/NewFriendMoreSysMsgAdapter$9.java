package com.tencent.mobileqq.newfriend.ui.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendMoreSysMsgAdapter$9
  extends NewFriendMessageObserver
{
  NewFriendMoreSysMsgAdapter$9(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionError execute");
    }
    NewFriendMoreSysMsgAdapter.d(this.a);
    paramString = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131719418);
    QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 1, paramString, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeleteAllSysMsg ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.i("NewFriendMoreSysMsgAdapter", 2, localStringBuilder.toString());
    }
    NewFriendMoreSysMsgAdapter.d(this.a);
    if (paramBoolean)
    {
      if (NewFriendMoreSysMsgAdapter.a(this.a) != null) {
        NewFriendMoreSysMsgAdapter.a(this.a).finish();
      }
    }
    else {
      QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 2131699380, 0).a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendSystemMsgActionFin|isSuccess : ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",logStr : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",actionType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", msgDetail : ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",resultCode : ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", respType : ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("msgFail : ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("msgInvalidDecided : ");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(",remarkRet : ");
      ((StringBuilder)localObject).append(paramInt4);
      QLog.i("NewFriendMoreSysMsgAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString3;
    NewFriendMoreSysMsgAdapter.d(this.a);
    this.a.notifyDataSetChanged();
    long l2 = FriendSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        l1 = l2;
      }
    }
    structmsg.StructMsg localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString3)) {
        localObject = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131718739);
      }
      QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 1, (CharSequence)localObject, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).changeStructMsgActionsWhenFail(localStructMsg, paramInt3, paramString2, paramString4);
      return;
    }
    paramString1 = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131692656);
    QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 2, paramString1, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
    l2 = FriendSystemMsgController.a().a();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).changeStructMsgActions(localStructMsg, paramInt1, paramString2, paramInt2);
    if ((l2 != 0L) && (localStructMsg != null)) {
      try
      {
        NewFriendMoreSysMsgAdapter.a(this.a).updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l2, localStructMsg.toByteArray());
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin Exception!");
        }
      }
    }
    if ((paramInt1 == 0) && (localStructMsg != null))
    {
      paramString3 = new Bundle();
      paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
      paramString2 = localStructMsg.msg.req_uin_nick.get();
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = String.valueOf(localStructMsg.req_uin.get());
      }
      paramString3.putString("base_nick", paramString1);
      paramString3.putInt("verfy_type", localStructMsg.msg.sub_type.get());
      paramString3.putString("verfy_msg", localStructMsg.msg.msg_additional.get());
      if (FriendSystemMessage.a(this.a.a, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
      {
        paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
        paramString2 = paramString1;
        if (!TextUtils.isEmpty(paramString4)) {
          paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
        }
        paramString3.putString("base_nick", paramString2);
        paramString3.putBoolean("isFromWzry", true);
      }
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startRemarkAfterAgree(NewFriendMoreSysMsgAdapter.a(this.a), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetDelSystemMsgFin|isSuccess : ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", bTimeOut : ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("NewFriendMoreSysMsgAdapter", 2, ((StringBuilder)localObject).toString());
    }
    NewFriendMoreSysMsgAdapter.d(this.a);
    if (paramBoolean1)
    {
      NewFriendMoreSysMsgAdapter.c(this.a);
      return;
    }
    if ((paramBoolean2) && (NewFriendMoreSysMsgAdapter.a(this.a)))
    {
      localObject = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131719409);
      QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 1, (CharSequence)localObject, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgError");
    }
    NewFriendMoreSysMsgAdapter.d(this.a);
    String str = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131719409);
    QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 1, str, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onGetSystemMsgFin|isSuccess : ");
      paramList.append(paramBoolean1);
      paramList.append(", bTimeOut : ");
      paramList.append(paramBoolean2);
      QLog.i("NewFriendMoreSysMsgAdapter", 2, paramList.toString());
    }
    if (NewFriendMoreSysMsgAdapter.a(this.a).isFinishing()) {
      return;
    }
    if (paramBoolean1)
    {
      NewFriendMoreSysMsgAdapter.c(this.a);
    }
    else if ((paramBoolean2) && (NewFriendMoreSysMsgAdapter.a(this.a)))
    {
      paramList = NewFriendMoreSysMsgAdapter.a(this.a).getResources().getString(2131719416);
      QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 1, paramList, 0).b(NewFriendMoreSysMsgAdapter.b(this.a));
    }
    NewFriendMoreSysMsgAdapter.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.9
 * JD-Core Version:    0.7.0.1
 */