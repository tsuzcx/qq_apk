package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.qphone.base.util.QLog;

class DatalineFileModel$3$1
  implements FMDialogUtil.FMDialogInterface
{
  DatalineFileModel$3$1(DatalineFileModel.3 param3) {}
  
  public void a()
  {
    int i = this.a.a.g();
    if (this.a.a.f() == 6000) {
      if (i == 0) {
        if (this.a.a.h() == 2) {
          DatalineFileModel.c(this.a.a);
        }
      }
    }
    for (;;)
    {
      if (this.a.a.a != null) {
        this.a.a.a.d();
      }
      return;
      DatalineFileModel.a(this.a.a);
      continue;
      DatalineFileModel.c(this.a.a);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("DatalineFileModel<FileAssistant>", 2, "DatalineFileModel doStartDownload : error, this file is not from dataline");
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel.3.1
 * JD-Core Version:    0.7.0.1
 */