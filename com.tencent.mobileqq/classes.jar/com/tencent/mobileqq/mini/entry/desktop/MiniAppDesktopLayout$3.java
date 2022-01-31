package com.tencent.mobileqq.mini.entry.desktop;

import ahjx;
import amtb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class MiniAppDesktopLayout$3
  implements Runnable
{
  MiniAppDesktopLayout$3(MiniAppDesktopLayout paramMiniAppDesktopLayout) {}
  
  public void run()
  {
    MiniAppDesktopAdapter localMiniAppDesktopAdapter;
    if (amtb.l())
    {
      boolean bool = ((ahjx)MiniAppDesktopLayout.access$300(this.this$0).app.getManager(315)).a();
      localMiniAppDesktopAdapter = MiniAppDesktopLayout.access$400(this.this$0);
      if (!bool) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      localMiniAppDesktopAdapter.setRedDotSwitchState(i);
      MiniAppDesktopLayout.access$500(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.3
 * JD-Core Version:    0.7.0.1
 */