package com.tencent.mobileqq.qqexpand.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import java.util.ArrayList;
import java.util.List;

class HeadsPanelAnimationView$1
  implements Handler.Callback
{
  HeadsPanelAnimationView$1(HeadsPanelAnimationView paramHeadsPanelAnimationView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      paramMessage = (ArrayList)paramMessage.obj;
      if (this.a.j)
      {
        paramMessage = Message.obtain(this.a.e, 2, paramMessage);
        this.a.e.sendMessageDelayed(paramMessage, 500L);
        return false;
      }
      HeadsPanelAnimationView.a(this.a, paramMessage);
      return false;
    }
    if (this.a.f.size() == 0)
    {
      QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
      return false;
    }
    this.a.c();
    if (this.a.e.hasMessages(1)) {
      this.a.e.removeMessages(1);
    }
    Util.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (String)this.a.f.get(this.a.f.size() - 1));
    this.a.e.sendEmptyMessageDelayed(1, 3000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HeadsPanelAnimationView.1
 * JD-Core Version:    0.7.0.1
 */