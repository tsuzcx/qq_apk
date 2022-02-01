package com.tencent.mobileqq.confess;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class BaseMsgListFragment$4
  implements Handler.Callback
{
  BaseMsgListFragment$4(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return false;
    }
    if ((!this.a.e()) && (this.a.i.getMode() == -1))
    {
      this.a.k.a(this.a.t);
      this.a.k.a(17);
      this.a.d();
      if ((!this.a.u) && (this.a.t.size() != 0)) {
        this.a.g.setVisibility(0);
      } else {
        this.a.g.setVisibility(8);
      }
      if (!this.a.m)
      {
        this.a.m = true;
        if (QLog.isColorLevel())
        {
          QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.o) }));
          return false;
        }
      }
    }
    else
    {
      this.a.n = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment.4
 * JD-Core Version:    0.7.0.1
 */