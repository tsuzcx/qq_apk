package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;

class MiniAppDesktopLayout$3
  implements Runnable
{
  MiniAppDesktopLayout$3(MiniAppDesktopLayout paramMiniAppDesktopLayout, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject;
    if (MiniAppConfProcessor.h())
    {
      localObject = (AppletsFolderManager)this.val$activity.app.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
      if (localObject != null)
      {
        boolean bool = ((AppletsFolderManager)localObject).a();
        localObject = MiniAppDesktopLayout.access$300(this.this$0);
        if (!bool) {
          break label59;
        }
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      ((MiniAppDesktopAdapter)localObject).setRedDotSwitchState(i);
      MiniAppDesktopLayout.access$400(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout.3
 * JD-Core Version:    0.7.0.1
 */