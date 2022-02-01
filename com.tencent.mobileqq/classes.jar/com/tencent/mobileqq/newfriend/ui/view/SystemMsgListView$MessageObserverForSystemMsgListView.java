package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
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

public class SystemMsgListView$MessageObserverForSystemMsgListView
  extends NewFriendMessageObserver
{
  public SystemMsgListView$MessageObserverForSystemMsgListView(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.a())
    {
      paramString = SystemMsgListView.a(this.a).getResources().getString(2131719418);
      QQToast.a(SystemMsgListView.a(this.a), 1, paramString, 0).b(this.a.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionError");
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
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
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
    structmsg.StructMsg localStructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    if (!this.a.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin");
      }
      return;
    }
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramString3 = SystemMsgListView.a(this.a).getResources().getString(2131718739);
      }
      QQToast.a(SystemMsgListView.a(this.a), 1, paramString3, 0).b(this.a.a());
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).changeStructMsgActionsWhenFail(localStructMsg, paramInt3, paramString2, paramString4);
      return;
    }
    paramString1 = SystemMsgListView.a(this.a).getResources().getString(2131692656);
    QQToast.a(SystemMsgListView.a(this.a), 2, paramString1, 0).b(this.a.a());
    l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrentUniseq();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).changeStructMsgActions(localStructMsg, paramInt1, paramString2, paramInt2);
    if ((l2 != 0L) && (localStructMsg != null)) {
      try
      {
        ((IMessageFacade)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l2, localStructMsg.toByteArray());
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
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
      if (FriendSystemMessage.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
      {
        paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
        paramString2 = paramString1;
        if (!TextUtils.isEmpty(paramString4)) {
          paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
        }
        paramString3.putString("base_nick", paramString2);
        paramString3.putBoolean("isFromWzry", true);
      }
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startRemarkAfterAgree(this.a.jdField_a_of_type_ComTencentMobileqqNewfriendUiViewBaseNewFriendView$INewFriendContext.getActivity(), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.bengin");
    }
    this.a.k();
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgFin.success");
      }
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
    }
    else if (paramBoolean2)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetDelSystemMsgError");
    }
    this.a.k();
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1016);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {
      return;
    }
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
      }
      try
      {
        if (SystemMsgListView.a(this.a) != null) {
          SystemMsgListView.a(this.a).c();
        }
        this.a.i();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.MessageObserverForSystemMsgListView
 * JD-Core Version:    0.7.0.1
 */