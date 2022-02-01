package com.tencent.mobileqq.upgrade;

import android.text.TextUtils;
import anvl;
import bcrg;
import bhdl;
import bhdu;
import bhea;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$1
  implements Runnable
{
  public UpgradeController$1(bhdu parambhdu, boolean paramBoolean) {}
  
  public void run()
  {
    if ((bhdu.a(this.this$0) == null) || (bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {}
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
                  if (!bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.e.equals("1")) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("UpgradeController", 2, "showUpgradeTip config do not allow to tip");
                return;
                if (bcrg.a() >= bhdu.a(this.this$0).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.b / 1000L) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("UpgradeController", 2, "showUpgradeTip want to tip but is not time to show");
              return;
              localObject = (QQAppInterface)bhdu.a(this.this$0).getRuntime();
            } while (localObject == null);
            if ((this.this$0.a() != 4) || (!this.this$0.b())) {
              break;
            }
          } while ((bhdu.a(this.this$0) == null) || (TextUtils.isEmpty(bhdu.a(this.this$0).l)));
          bhdu.a(this.this$0, true);
          localObject = new File(bhdu.a(this.this$0).l);
        } while (!((File)localObject).exists());
        ((File)localObject).delete();
      } while (!QLog.isColorLevel());
      QLog.d("UpgradeController", 2, "showUpgradeTip the jacked apk has been removed.");
      return;
      bhea.a((QQAppInterface)localObject);
      if (!anvl.b((QQAppInterface)localObject))
      {
        bool = bhdu.a(this.this$0, (QQAppInterface)localObject);
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
    } while ((bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (bhdu.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1));
    boolean bool = bhdu.a(this.this$0, (QQAppInterface)localObject);
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