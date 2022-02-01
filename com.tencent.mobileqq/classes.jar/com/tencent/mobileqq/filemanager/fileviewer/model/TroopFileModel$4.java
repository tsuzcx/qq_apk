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
  
  protected void a(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.c.r().TroopUin != paramTroopFileStatusInfo.d) {
      return;
    }
    if ((paramTroopFileStatusInfo.a != null) && (TroopFileModel.a(this.a) != null) && (TroopFileModel.a(this.a).equals(paramTroopFileStatusInfo.a.toString())) && (this.a.y != null) && (paramInt1 == 0)) {
      this.a.y.a(paramInt2, paramString1, paramString2, paramBundle);
    }
  }
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.c.r();
    paramObject = (TroopFileStatusInfo)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.d)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
      return;
    }
    if (TextUtils.isEmpty(TroopFileModel.a(this.a)))
    {
      localObject = this.a.e((FileManagerEntity)localObject);
      if (((TroopFileStatusInfo)localObject).a != null) {
        TroopFileModel.a(this.a, ((TroopFileStatusInfo)localObject).a.toString());
      }
    }
    if ((paramObject.a != null) && (TroopFileModel.a(this.a) != null) && (TroopFileModel.a(this.a).equals(paramObject.a.toString()))) {
      TroopFileModel.a(this.a, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.4
 * JD-Core Version:    0.7.0.1
 */