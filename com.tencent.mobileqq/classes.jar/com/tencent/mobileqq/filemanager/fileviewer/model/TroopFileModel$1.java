package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

class TroopFileModel$1
  extends TroopFileGetFilePreviewObserver
{
  TroopFileModel$1(TroopFileModel paramTroopFileModel) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    this.a.e = FileManagerUtil.a(paramByteStringMicro1);
    boolean bool = true;
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.e)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("downURL:");
      paramString1.append(this.a.e);
      QLog.d("TroopFileModel<FileAssistant>", 2, paramString1.toString());
      paramString1 = this.a;
      paramString1.jdField_a_of_type_JavaLangString = paramString3;
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(paramInt3);
      paramString1.b = paramString2.toString();
      this.a.c = FileManagerUtil.a(paramByteStringMicro1);
      paramString1 = this.a;
      paramString1.d = paramString4;
      paramString1.c = FileManagerUtil.a(paramByteStringMicro1);
      paramBoolean = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      short s1 = 0;
      if ((paramBoolean) && (TroopFileUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
      {
        paramString2 = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramString2))
        {
          short s2 = (short)paramBundle.getInt("httpsPort", 0);
          paramBoolean = bool;
          paramString1 = paramString2;
          s1 = s2;
          if (s2 != 0) {
            break label243;
          }
          s1 = 443;
          paramBoolean = bool;
          paramString1 = paramString2;
          break label243;
        }
      }
      paramString1 = null;
      paramBoolean = false;
      label243:
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramByteStringMicro1 = new StringBuilder();
      paramByteStringMicro1.append("");
      paramByteStringMicro1.append(paramInt3);
      TroopFileProtocol.a(paramString2, paramString3, paramByteStringMicro1.toString(), this.a.c, FileManagerUtil.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()), "/", paramString4, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), new TroopFileModel.1.1(this, paramBoolean, paramString1, s1));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("get preview url failed for troop, retCode[");
    paramString2.append(paramInt1);
    paramString2.append("], retMeg[");
    paramString2.append(paramString1);
    paramString2.append("]");
    QLog.e("TroopFileModel<FileAssistant>", 1, paramString2.toString());
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin);
    ReportController.b(paramString1, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, paramString2.toString(), "-1", FileManagerUtil.f(this.a.c()), "1");
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.1
 * JD-Core Version:    0.7.0.1
 */