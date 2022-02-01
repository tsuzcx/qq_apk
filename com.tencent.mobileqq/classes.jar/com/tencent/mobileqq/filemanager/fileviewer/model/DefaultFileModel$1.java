package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class DefaultFileModel$1
  implements ControlerCallback
{
  DefaultFileModel$1(DefaultFileModel paramDefaultFileModel, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("sending cs to get preview url but failed, retCode[");
      paramString1.append(paramLong);
      paramString1.append("], retMeg[");
      paramString1.append(paramString3);
      paramString1.append("]");
      QLog.e("FileBrowserModelBase", 1, paramString1.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      return;
    }
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel;
    paramString3.jdField_a_of_type_JavaLangString = paramString1;
    paramString3.b = paramString2;
    paramString3.c = paramString4;
    paramString3.d = paramString5;
    paramString1 = null;
    short s = 0;
    boolean bool = false;
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_Int == 3000) {
        paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc_ZipInner(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } else {
        paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C_ZipInner(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramString2 = paramBundle.getString("httpsdomain");
      if ((!TextUtils.isEmpty(paramString2)) && (paramBoolean))
      {
        s = paramBundle.getShort("httpsport");
        paramString1 = paramString2;
        paramBoolean = true;
      }
      else
      {
        s = 0;
        paramBoolean = bool;
      }
      paramString2 = paramBundle.getString("ipv6domain", "");
    }
    else
    {
      paramString1 = null;
      paramString2 = "";
      paramBoolean = false;
    }
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel;
    paramString3.a(paramString3.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.b, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.c, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()), "/", this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelDefaultFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), paramBoolean, paramString1, s, paramString2, new DefaultFileModel.1.1(this, paramBoolean, paramString1, s));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.1
 * JD-Core Version:    0.7.0.1
 */