package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class PublicCommentWindow$JsEventReceiver
  extends BroadcastReceiver
{
  PublicCommentWindow$JsEventReceiver(PublicCommentWindow paramPublicCommentWindow) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("CommentSendSuccess".equals(paramIntent.getStringExtra("event"))))
    {
      paramContext = this.a;
      paramContext.l = true;
      paramContext.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("PublicCommentPopupWindow", 2, "web call finish----------------");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow.JsEventReceiver
 * JD-Core Version:    0.7.0.1
 */