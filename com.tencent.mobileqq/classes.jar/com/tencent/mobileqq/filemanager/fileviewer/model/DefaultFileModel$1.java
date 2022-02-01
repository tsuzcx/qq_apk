package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class DefaultFileModel$1
  implements FilePreviewActivity.ControlerCallback
{
  DefaultFileModel$1(DefaultFileModel paramDefaultFileModel, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.e("FileBrowserModelBase", 1, "sending cs to get preview url but failed, retCode[" + paramLong + "], retMeg[" + paramString3 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.c = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.d = paramString5;
    paramString2 = "";
    short s;
    if (paramBundle != null) {
      if (this.jdField_a_of_type_Int == 3000)
      {
        paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc_ZipInner(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString1 = paramBundle.getString("httpsdomain");
        if ((TextUtils.isEmpty(paramString1)) || (!paramBoolean)) {
          break label336;
        }
        paramBoolean = true;
        s = paramBundle.getShort("httpsport");
        label220:
        paramString2 = paramBundle.getString("ipv6domain", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.c, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()), "/", this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), paramBoolean, paramString1, s, paramString2, new DefaultFileModel.1.1(this, paramBoolean, paramString1, s));
      return;
      paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C_ZipInner(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label336:
      paramString1 = null;
      s = 0;
      paramBoolean = false;
      break label220;
      paramString1 = null;
      s = 0;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.1
 * JD-Core Version:    0.7.0.1
 */