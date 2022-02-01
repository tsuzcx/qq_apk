package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
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
      QLog.d(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "<<<syncLastFileRecord is not getting");
      return;
    }
    QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "<<<syncLastFileRecord result errCode:" + paramInt);
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      QfileFavFileRecordProvider.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
      if (paramInt != 0)
      {
        int i = 2131698175;
        if (paramInt == 65535) {
          i = 2131698176;
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
        int j = (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(paramInt - j);
        QfileFavFileRecordProvider.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localBundle } });
        return;
      }
      QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider).getFileManagerEngine().a().cancelGetFileList(QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
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
        QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "syncLastFileRecord result: nextTimestamp:" + QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider) + " gettedListEnd:" + bool + " localEnd:" + QfileFavFileRecordProvider.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider));
      }
      for (;;)
      {
        paramBundle = new QfileFavFileRecordProvider.FileRecordGroup(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(paramList, paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.a(paramBundle);
        QfileFavFileRecordProvider.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localBundle } });
        return;
        QLog.i(QfileFavFileRecordProvider.a, 1, QfileFavFileRecordProvider.b + "syncLastFileRecord result: lastTimestamp:" + QfileFavFileRecordProvider.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileRecordProvider) + " exData=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.4
 * JD-Core Version:    0.7.0.1
 */