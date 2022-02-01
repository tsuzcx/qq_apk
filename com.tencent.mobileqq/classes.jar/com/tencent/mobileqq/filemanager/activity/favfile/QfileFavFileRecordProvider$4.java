package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.GetFileListResult;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QfileFavFileRecordProvider$4
  extends IQQFavProxy.GetFileListResult
{
  QfileFavFileRecordProvider$4(QfileFavFileRecordProvider paramQfileFavFileRecordProvider, Bundle paramBundle) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!QfileFavFileRecordProvider.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider))
    {
      paramList = QfileFavFileRecordProvider.a;
      paramBundle = new StringBuilder();
      paramBundle.append(QfileFavFileRecordProvider.b);
      paramBundle.append("<<<syncLastFileRecord is not getting");
      QLog.d(paramList, 1, paramBundle.toString());
      return;
    }
    Object localObject1 = QfileFavFileRecordProvider.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.b);
    ((StringBuilder)localObject2).append("<<<syncLastFileRecord result errCode:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (paramBundle == null) {
      localObject1 = new Bundle();
    } else {
      localObject1 = paramBundle;
    }
    localObject2 = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject2 != null) {
      ((Bundle)localObject1).putAll((Bundle)localObject2);
    }
    QfileFavFileRecordProvider.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
    if (paramInt != 0)
    {
      int i = 2131698239;
      if (paramInt == 65535) {
        i = 2131698240;
      }
      paramInt = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168);
      int j = (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
      QQToast.a(BaseApplication.getContext(), 0, i, 0).b(paramInt - j);
      QfileFavFileRecordProvider.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localObject1 } });
      return;
    }
    ((IQQFileEngine)QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider).getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
    QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
    QfileFavFileRecordProvider.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
    if (paramBundle != null)
    {
      QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        QfileFavFileRecordProvider.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider, true);
      }
      paramBundle = QfileFavFileRecordProvider.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.b);
      ((StringBuilder)localObject2).append("syncLastFileRecord result: nextTimestamp:");
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
      ((StringBuilder)localObject2).append(" gettedListEnd:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" localEnd:");
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
      QLog.i(paramBundle, 1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      paramBundle = QfileFavFileRecordProvider.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.b);
      ((StringBuilder)localObject2).append("syncLastFileRecord result: lastTimestamp:");
      ((StringBuilder)localObject2).append(QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
      ((StringBuilder)localObject2).append(" exData=null");
      QLog.i(paramBundle, 1, ((StringBuilder)localObject2).toString());
    }
    paramBundle = new QfileFavFileRecordProvider.FileRecordGroup();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(paramList, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(paramBundle);
    QfileFavFileRecordProvider.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localObject1 } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.4
 * JD-Core Version:    0.7.0.1
 */