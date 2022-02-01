package com.tencent.mobileqq.mini.entry.desktop;

import aljo;
import arfd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class MiniAppDesktopLayout$3
  implements Runnable
{
  MiniAppDesktopLayout$3(MiniAppDesktopLayout paramMiniAppDesktopLayout, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    MiniAppDesktopAdapter localMiniAppDesktopAdapter;
    if (arfd.h())
    {
      boolean bool = ((aljo)this.val$activity.app.getManager(315)).a();
      localMiniAppDesktopAdapter = MiniAppDesktopLayout.access$300(this.this$0);
      if (!bool) {
        break label53;
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      localMiniAppDesktopAdapter.setRedDotSwitchState(i);
      MiniAppDesktopLayout.access$400(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.3
 * JD-Core Version:    0.7.0.1
 */