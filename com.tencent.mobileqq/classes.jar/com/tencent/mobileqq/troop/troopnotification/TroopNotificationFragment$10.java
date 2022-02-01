package com.tencent.mobileqq.troop.troopnotification;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopNotificationFragment$10
  implements Runnable
{
  TroopNotificationFragment$10(TroopNotificationFragment paramTroopNotificationFragment, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    Object localObject2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    } else {
      localObject2 = GroupSystemMsgController.a().b();
    }
    Object localObject1;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (TroopNotificationFragment.a(this.this$0) != null) {
        TroopNotificationFragment.a(this.this$0).dismiss();
      }
      localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718739);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localObject1 = this.jdField_b_of_type_JavaLangString;
      }
      QQToast.a(this.this$0.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)localObject1, 0).b(this.this$0.a());
      TroopSystemMsgUtils.a(GroupSystemMsgController.a().a((String)localObject2), this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.d);
      localObject1 = GroupSystemMsgController.a().a((String)localObject2);
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg_type.get() == 2))
      {
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
        TroopNotificationFragment.g(this.this$0);
      }
    }
    else
    {
      if (TroopNotificationFragment.a(this.this$0) != null) {
        TroopNotificationFragment.a(this.this$0).dismiss();
      }
      String str = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692662);
      int i = this.jdField_b_of_type_Int;
      if (i == 1)
      {
        localObject1 = GroupSystemMsgController.a().a((String)localObject2);
        if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg.group_msg_type.get() == 82)) {
          localObject1 = this.jdField_c_of_type_JavaLangString;
        } else {
          localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692656);
        }
      }
      else if (i == 2)
      {
        localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692661);
      }
      else if (i == 0)
      {
        structmsg.StructMsg localStructMsg = GroupSystemMsgController.a().a((String)localObject2);
        localObject1 = str;
        if (localStructMsg != null)
        {
          localObject1 = str;
          if (localStructMsg.msg.group_msg_type.get() == 82) {
            localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692661);
          }
        }
      }
      else
      {
        localObject1 = str;
        if (i == 3)
        {
          l = GroupSystemMsgController.a().a();
          localObject1 = GroupSystemMsgController.a().a();
          QQToast.a(this.this$0.jdField_a_of_type_AndroidContentContext, 2, this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692658), 0).b(this.this$0.a());
          if (((String)localObject1).equals(AppConstants.TROOP_SYSTEM_MSG_UIN))
          {
            localObject2 = (ITroopNotificationService)TroopNotificationFragment.a(this.this$0).getRuntimeService(ITroopNotificationService.class, "");
            if (localObject2 != null) {
              ((ITroopNotificationService)localObject2).removeMessage(l, (String)localObject1, 0, false);
            }
            TroopNotificationFragment.h(this.this$0);
            return;
          }
          localObject2 = (IMessageFacade)TroopNotificationFragment.a(this.this$0).getRuntimeService(IMessageFacade.class, "");
          if (localObject2 != null) {
            ((IMessageFacade)localObject2).removeMsgByUniseq((String)localObject1, 0, l, false);
          }
          TroopNotificationFragment.i(this.this$0);
          return;
        }
      }
      QQToast.a(this.this$0.jdField_a_of_type_AndroidContentContext, 2, (CharSequence)localObject1, 0).b(this.this$0.a());
      long l = GroupSystemMsgController.a().a();
      TroopSystemMsgUtils.a(GroupSystemMsgController.a().a((String)localObject2), this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      ThreadManager.postImmediately(new TroopNotificationFragment.10.1(this, GroupSystemMsgController.a().a((String)localObject2), l), null, false);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
      TroopNotificationFragment.g(this.this$0);
      TroopNotificationFragment.j(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.10
 * JD-Core Version:    0.7.0.1
 */