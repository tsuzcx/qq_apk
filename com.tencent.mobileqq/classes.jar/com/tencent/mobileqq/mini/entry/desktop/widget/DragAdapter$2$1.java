package com.tencent.mobileqq.mini.entry.desktop.widget;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.qphone.base.util.QLog;

class DragAdapter$2$1
  implements Runnable
{
  DragAdapter$2$1(DragAdapter.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isSuc)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDelUserAppRequest, success. delete appInfo: ");
      localStringBuilder.append(this.this$1.val$miniAppInfo);
      QLog.i("DragAdapter", 1, localStringBuilder.toString());
      try
      {
        if (this.this$1.val$desktopAppInfo.mModuleType != 1) {
          return;
        }
        ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).loadMoreRecentIfNeed();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DragAdapter", 1, localThrowable, new Object[0]);
        return;
      }
    }
    else
    {
      QLog.e("DragAdapter", 1, "sendDelUserAppRequest, failed to delete miniapp!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */