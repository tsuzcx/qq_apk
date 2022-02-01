package com.tencent.mobileqq.troop.troopnotification.ui;

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
    if (!TextUtils.isEmpty(this.a)) {
      localObject2 = this.a;
    } else {
      localObject2 = GroupSystemMsgController.a().f();
    }
    Object localObject1;
    if (!this.b)
    {
      if (TroopNotificationFragment.j(this.this$0) != null) {
        TroopNotificationFragment.j(this.this$0).dismiss();
      }
      localObject1 = this.this$0.g.getResources().getString(2131916242);
      if (!TextUtils.isEmpty(this.c)) {
        localObject1 = this.c;
      }
      QQToast.makeText(this.this$0.g, 1, (CharSequence)localObject1, 0).show(this.this$0.b());
      TroopSystemMsgUtils.a(GroupSystemMsgController.a().b((String)localObject2), this.d, this.e, this.f);
      localObject1 = GroupSystemMsgController.a().b((String)localObject2);
      if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg_type.get() == 2))
      {
        this.this$0.w.sendEmptyMessage(1012);
        TroopNotificationFragment.m(this.this$0);
      }
    }
    else
    {
      if (TroopNotificationFragment.j(this.this$0) != null) {
        TroopNotificationFragment.j(this.this$0).dismiss();
      }
      String str = this.this$0.g.getResources().getString(2131889687);
      int i = this.g;
      if (i == 1)
      {
        localObject1 = GroupSystemMsgController.a().b((String)localObject2);
        if ((localObject1 != null) && (((structmsg.StructMsg)localObject1).msg.group_msg_type.get() == 82)) {
          localObject1 = this.e;
        } else {
          localObject1 = this.this$0.g.getResources().getString(2131889681);
        }
      }
      else if (i == 2)
      {
        localObject1 = this.this$0.g.getResources().getString(2131889686);
      }
      else if (i == 0)
      {
        structmsg.StructMsg localStructMsg = GroupSystemMsgController.a().b((String)localObject2);
        localObject1 = str;
        if (localStructMsg != null)
        {
          localObject1 = str;
          if (localStructMsg.msg.group_msg_type.get() == 82) {
            localObject1 = this.this$0.g.getResources().getString(2131889686);
          }
        }
      }
      else
      {
        localObject1 = str;
        if (i == 3)
        {
          l = GroupSystemMsgController.a().c();
          localObject1 = GroupSystemMsgController.a().d();
          QQToast.makeText(this.this$0.g, 2, this.this$0.g.getResources().getString(2131889683), 0).show(this.this$0.b());
          if (((String)localObject1).equals(AppConstants.TROOP_SYSTEM_MSG_UIN))
          {
            localObject2 = (ITroopNotificationService)TroopNotificationFragment.f(this.this$0).getRuntimeService(ITroopNotificationService.class, "");
            if (localObject2 != null) {
              ((ITroopNotificationService)localObject2).removeMessage(l, (String)localObject1, 0, false);
            }
            TroopNotificationFragment.n(this.this$0);
            return;
          }
          localObject2 = (IMessageFacade)TroopNotificationFragment.f(this.this$0).getRuntimeService(IMessageFacade.class, "");
          if (localObject2 != null) {
            ((IMessageFacade)localObject2).removeMsgByUniseq((String)localObject1, 0, l, false);
          }
          TroopNotificationFragment.o(this.this$0);
          return;
        }
      }
      QQToast.makeText(this.this$0.g, 2, (CharSequence)localObject1, 0).show(this.this$0.b());
      long l = GroupSystemMsgController.a().c();
      TroopSystemMsgUtils.a(GroupSystemMsgController.a().b((String)localObject2), this.g, this.e, this.h);
      ThreadManager.postImmediately(new TroopNotificationFragment.10.1(this, GroupSystemMsgController.a().b((String)localObject2), l), null, false);
      this.this$0.w.sendEmptyMessage(1012);
      TroopNotificationFragment.m(this.this$0);
      TroopNotificationFragment.p(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.10
 * JD-Core Version:    0.7.0.1
 */