package com.tencent.timi.game.liveroom.impl.notice;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class TimiNoticeDialog$1
  implements DialogInterface.OnDismissListener
{
  TimiNoticeDialog$1(TimiNoticeDialog paramTimiNoticeDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.notice.TimiNoticeDialog.1
 * JD-Core Version:    0.7.0.1
 */