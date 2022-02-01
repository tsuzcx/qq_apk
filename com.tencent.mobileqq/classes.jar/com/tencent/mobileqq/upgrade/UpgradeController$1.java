package com.tencent.mobileqq.upgrade;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

class UpgradeController$1
  implements Runnable
{
  UpgradeController$1(UpgradeController paramUpgradeController, boolean paramBoolean) {}
  
  public void run()
  {
    if ((UpgradeController.a(this.this$0) != null) && (UpgradeController.a(this.this$0).f != null))
    {
      if (UpgradeController.a(this.this$0).f.dialog == null) {
        return;
      }
      if (UpgradeController.a(this.this$0).f.dialog.h.equals("1"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "showUpgradeTip config do not allow to tip");
        }
        return;
      }
      if (MessageCache.c() < UpgradeController.a(this.this$0).f.dialog.d / 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "showUpgradeTip want to tip but is not time to show");
        }
        return;
      }
      Object localObject = (QQAppInterface)UpgradeController.b(this.this$0).getRuntime();
      if (localObject == null) {
        return;
      }
      if ((this.this$0.b() == 4) && (this.this$0.j()))
      {
        if ((UpgradeController.c(this.this$0) != null) && (!TextUtils.isEmpty(UpgradeController.c(this.this$0).q)))
        {
          UpgradeController.a(this.this$0, true);
          localObject = new File(UpgradeController.c(this.this$0).q);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("UpgradeController", 2, "showUpgradeTip the jacked apk has been removed.");
            }
          }
        }
        return;
      }
      UpgradeManager.a((QQAppInterface)localObject);
      boolean bool;
      if (!ConfigHandler.d((QQAppInterface)localObject))
      {
        bool = UpgradeController.a(this.this$0, (QQAppInterface)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, String.format("showUpgradeTip not wifi download needDialog=%s showDialog=%s", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(bool) }));
        }
        if ((this.a) && (bool))
        {
          this.this$0.a((QQAppInterface)localObject, false);
          return;
        }
        this.this$0.a((QQAppInterface)localObject);
        return;
      }
      if ((UpgradeController.a(this.this$0).b != null) && (UpgradeController.a(this.this$0).b.iUpgradeType == 1))
      {
        bool = UpgradeController.a(this.this$0, (QQAppInterface)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, String.format("showUpgradeTip wifi download showDialog=%s", new Object[] { Boolean.valueOf(bool) }));
        }
        if (bool)
        {
          this.this$0.a((QQAppInterface)localObject, true);
          return;
        }
        this.this$0.a((QQAppInterface)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.1
 * JD-Core Version:    0.7.0.1
 */