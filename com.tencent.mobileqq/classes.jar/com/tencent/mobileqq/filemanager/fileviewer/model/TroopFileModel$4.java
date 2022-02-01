package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class TroopFileModel$4
  extends BizTroopObserver
{
  TroopFileModel$4(TroopFileModel paramTroopFileModel) {}
  
  public void onMMApkFileSafeCheckResult(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin != paramTroopFileStatusInfo.b) {}
    while ((paramTroopFileStatusInfo.a == null) || (TroopFileModel.a(this.a) == null) || (!TroopFileModel.a(this.a).equals(paramTroopFileStatusInfo.a.toString())) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnMMApkSafeCheckListener == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnMMApkSafeCheckListener.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    paramObject = (TroopFileStatusInfo)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(TroopFileModel.a(this.a)))
      {
        localObject = this.a.a((FileManagerEntity)localObject);
        if (((TroopFileStatusInfo)localObject).a != null) {
          TroopFileModel.a(this.a, ((TroopFileStatusInfo)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (TroopFileModel.a(this.a) == null) || (!TroopFileModel.a(this.a).equals(paramObject.a.toString())));
    TroopFileModel.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.4
 * JD-Core Version:    0.7.0.1
 */