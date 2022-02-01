package com.tencent.mobileqq.matchchat;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class MatchChatMsgListFragment$8
  implements Handler.Callback
{
  MatchChatMsgListFragment$8(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      paramMessage = this.a;
      MatchChatMsgListFragment.a(paramMessage, MatchChatMsgListFragment.b(paramMessage));
      return false;
    }
    if ((!this.a.c()) && (this.a.h.getMode() == -1))
    {
      this.a.j.a(this.a.s);
      this.a.j.a(21);
      this.a.b();
      if ((!this.a.t) && (this.a.s.size() != 0)) {
        this.a.f.setVisibility(0);
      } else {
        this.a.f.setVisibility(8);
      }
      if (!this.a.l)
      {
        this.a.l = true;
        if (QLog.isColorLevel())
        {
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.n) }));
          return false;
        }
      }
    }
    else
    {
      this.a.m = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.8
 * JD-Core Version:    0.7.0.1
 */