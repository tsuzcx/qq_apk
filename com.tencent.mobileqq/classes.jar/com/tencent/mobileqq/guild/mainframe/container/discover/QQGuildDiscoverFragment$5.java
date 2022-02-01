package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class QQGuildDiscoverFragment$5
  implements Handler.Callback
{
  QQGuildDiscoverFragment$5(QQGuildDiscoverFragment paramQQGuildDiscoverFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 3)
    {
      if (i != 4)
      {
        if (i != 5) {
          return false;
        }
        QQGuildDiscoverFragment.i(this.a);
        return false;
      }
      i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        QQGuildDiscoverFragment.j(this.a);
        if (QQGuildDiscoverFragment.k(this.a) != null)
        {
          QQGuildDiscoverFragment.k(this.a).a(0);
          this.a.b.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
      }
      else
      {
        QQGuildDiscoverFragment.i(this.a);
        QQToast.makeText(this.a.getActivity(), 1, 2131916799, 0).show(QQGuildDiscoverFragment.l(this.a));
        return false;
      }
    }
    else
    {
      QQToast.makeText(this.a.getActivity(), 1, 2131916799, 0).show();
      QQGuildDiscoverFragment.i(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment.5
 * JD-Core Version:    0.7.0.1
 */