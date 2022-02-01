package com.tencent.mobileqq.newfriend.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.widget.QQToast;

class SystemMsgListView$1
  extends Handler
{
  SystemMsgListView$1(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1012)
    {
      if (i != 1016) {
        return;
      }
      paramMessage = SystemMsgListView.a(this.a).getResources().getString(2131719409);
      QQToast.a(SystemMsgListView.a(this.a), 1, paramMessage, 0).b(this.a.a());
      return;
    }
    if (SystemMsgListView.a(this.a) != null)
    {
      this.a.i();
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.1
 * JD-Core Version:    0.7.0.1
 */