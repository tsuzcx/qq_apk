package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.content.Context;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.troop.homework.ErrorInfo;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

class BulkSendMessageFragment$2
  extends HomeworkObserver
{
  BulkSendMessageFragment$2(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg)
  {
    if (QLog.isColorLevel())
    {
      if (paramRspSend1V1Msg == null) {
        localObject = "null";
      } else {
        localObject = PBUtils.b(paramRspSend1V1Msg);
      }
      QLog.d(".troop.troop_app.BulkSendMessageFragment", 2, new Object[] { "Receive response succ=", Boolean.valueOf(paramBoolean), "resp: ", localObject });
    }
    if (this.a.m != null)
    {
      this.a.m.a();
      this.a.m = null;
    }
    Object localObject = this.a.getBaseActivity();
    if (localObject == null)
    {
      QLog.e(".troop.troop_app.BulkSendMessageFragment", 2, "onBulkSendMessage() Error: getActivity == null");
      return;
    }
    if (paramRspSend1V1Msg == null)
    {
      QQToast.makeText((Context)localObject, 1, HardCodeUtil.a(2131899473), 1).show();
      return;
    }
    if (paramRspSend1V1Msg.result.error_code.get() != 0)
    {
      QQToast.makeText((Context)localObject, 1, paramRspSend1V1Msg.result.error_desc.get().toStringUtf8(), 1).show();
      return;
    }
    QQToast.makeText((Context)localObject, 2, HardCodeUtil.a(2131899469), 1).show();
    ((BaseActivity)localObject).finish();
    ((BaseActivity)localObject).overridePendingTransition(0, 2130772018);
    paramRspSend1V1Msg = this.a.d.getHandler(Conversation.class);
    if (paramRspSend1V1Msg != null) {
      paramRspSend1V1Msg.sendEmptyMessage(1009);
    }
    paramRspSend1V1Msg = TroopReportor.a(this.a.d, this.a.c);
    TroopReportor.a("Grp_edu", "MassMessage", "CreateMessage_Send", 0, 0, new String[] { this.a.c, paramRspSend1V1Msg, paramReqSend1V1Msg.text.get().toStringUtf8(), String.valueOf(paramReqSend1V1Msg.to_uins.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.2
 * JD-Core Version:    0.7.0.1
 */