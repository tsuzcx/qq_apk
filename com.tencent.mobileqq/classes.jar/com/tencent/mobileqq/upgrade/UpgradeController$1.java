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
    if ((UpgradeController.a(this.this$0) == null) || (UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeController", 2, "showUpgradeTip config do not allow to tip");
                return;
                if (MessageCache.a() >= UpgradeController.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.b / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeController", 2, "showUpgradeTip want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)UpgradeController.a(this.this$0).getRuntime();
            } while (localObject == null);
            if ((this.this$0.a() != 4) || (!this.this$0.b())) {
              break;
            }
          } while ((UpgradeController.a(this.this$0) == null) || (TextUtils.isEmpty(UpgradeController.a(this.this$0).l)));
          UpgradeController.a(this.this$0, true);
          localObject = new File(UpgradeController.a(this.this$0).l);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeController", 2, "showUpgradeTip the jacked apk has been removed.");
      return;
      UpgradeManager.a((QQAppInterface)localObject);
      if (!ConfigHandler.b((QQAppInterface)localObject))
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
    } while ((UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (UpgradeController.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1));
    boolean bool = UpgradeController.a(this.this$0, (QQAppInterface)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.1
 * JD-Core Version:    0.7.0.1
 */