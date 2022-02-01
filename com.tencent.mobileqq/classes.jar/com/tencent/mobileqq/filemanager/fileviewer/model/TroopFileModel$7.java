package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopFileModel$7
  implements Runnable
{
  TroopFileModel$7(TroopFileModel paramTroopFileModel, TroopFileStatusInfo paramTroopFileStatusInfo) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileModel<FileAssistant>", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(this.a.e), this.a.t, Integer.valueOf(this.a.g) }));
    }
    Object localObject = this.this$0.c.r();
    if (!((FileManagerEntity)localObject).isFromProcessingForward2c2cOrDiscItem())
    {
      if (((FileManagerEntity)localObject).isFromProcessingForward2DatalineItem()) {
        return;
      }
      if (this.this$0.s != null) {
        this.this$0.s.a(this.a.r, this.a.m);
      }
      if (this.this$0.q == null)
      {
        QLog.d("TroopFileModel<FileAssistant>", 1, "updateTroopFileInfo: error, transListener is null!");
        if (QLog.isDevelopLevel()) {
          QQToast.makeText(this.this$0.i, 1, 2131889368, 0);
        }
        return;
      }
      switch (this.a.e)
      {
      case 4: 
      case 5: 
      default: 
        break;
      case 12: 
        localObject = new Intent();
        ((Intent)localObject).putExtra("TroopFile_DeleteFile", true);
        ((Intent)localObject).putExtra("TroopFile_FileName", this.a.t);
        this.this$0.i.setResult(-1, (Intent)localObject);
        this.this$0.i.finish();
        break;
      case 11: 
        TroopFileModel.a(this.this$0, (FileManagerEntity)localObject, this.a);
        break;
      case 9: 
      case 10: 
        this.this$0.q.e();
        break;
      case 8: 
        if (TroopFileModel.b(this.this$0) != 8) {
          this.this$0.q.d();
        }
        this.this$0.q.a((float)this.a.j * 1.0F / ((float)this.a.i * 1.0F));
        break;
      case 6: 
        this.this$0.q.f();
        break;
      case 2: 
      case 3: 
        this.this$0.q.e();
        break;
      case 1: 
        this.this$0.q.d();
        this.this$0.q.a((float)this.a.j * 1.0F / ((float)this.a.i * 1.0F));
      }
      TroopFileModel.a(this.this$0, this.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7
 * JD-Core Version:    0.7.0.1
 */