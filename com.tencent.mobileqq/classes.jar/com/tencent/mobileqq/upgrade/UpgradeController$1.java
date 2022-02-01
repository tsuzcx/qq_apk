package com.tencent.mobileqq.upgrade;

import ampt;
import android.text.TextUtils;
import bbko;
import bfmx;
import bfng;
import bfnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$1
  implements Runnable
{
  public UpgradeController$1(bfng parambfng, boolean paramBoolean) {}
  
  public void run()
  {
    if ((bfng.a(this.this$0) == null) || (bfng.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (bfng.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
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
                  if (!bfng.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeController", 2, "showUpgradeTip config do not allow to tip");
                return;
                if (bbko.a() >= bfng.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.b / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeController", 2, "showUpgradeTip want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)bfng.a(this.this$0).getRuntime();
            } while (localObject == null);
            if ((this.this$0.a() != 4) || (!this.this$0.b())) {
              break;
            }
          } while ((bfng.a(this.this$0) == null) || (TextUtils.isEmpty(bfng.a(this.this$0).l)));
          bfng.a(this.this$0, true);
          localObject = new File(bfng.a(this.this$0).l);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeController", 2, "showUpgradeTip the jacked apk has been removed.");
      return;
      bfnm.a((QQAppInterface)localObject);
      if (!ampt.b((QQAppInterface)localObject))
      {
        bool = bfng.a(this.this$0, (QQAppInterface)localObject);
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
    } while ((bfng.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (bfng.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1));
    boolean bool = bfng.a(this.this$0, (QQAppInterface)localObject);
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