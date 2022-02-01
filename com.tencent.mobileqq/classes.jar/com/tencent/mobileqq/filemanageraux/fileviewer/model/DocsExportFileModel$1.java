package com.tencent.mobileqq.filemanageraux.fileviewer.model;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkExportObserver;
import com.tencent.mobileqq.teamwork.TeamWorkExportUtil;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import mqq.os.MqqHandler;

class DocsExportFileModel$1
  extends TeamWorkExportObserver
{
  DocsExportFileModel$1(DocsExportFileModel paramDocsExportFileModel) {}
  
  public void a(int paramInt)
  {
    if ((DocsExportFileModel.i(this.a) != null) && (paramInt <= 100)) {
      DocsExportFileModel.f(this.a).post(new DocsExportFileModel.1.2(this, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    DocsExportFileModel.a(this.a, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    DocsExportFileModel.a(this.a, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a.A;
    long l3 = this.a.A;
    long l4 = this.a.z;
    if (paramBoolean)
    {
      if ((DocsExportFileModel.a(this.a) != null) && (DocsExportFileModel.b(this.a).getBoolean("isMiniProgram", false))) {
        TenDocLogReportHelper.a(DocsExportFileModel.c(this.a), "0X800A4B3");
      }
      if (DocsExportFileModel.d(this.a) != null)
      {
        DocsExportFileModel.d(this.a).setFilePath(paramString1);
        DocsExportFileModel.d(this.a).fileSize = FileManagerUtil.h(paramString1);
        paramString1 = TeamWorkExportUtil.a(DocsExportFileModel.d(this.a).nFileType);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((localQQAppInterface != null) && (paramString2 != null))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l3 - l4);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(l1 - l2);
          localStringBuilder.append("");
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009956", "0X8009956", 0, 1, (String)localObject, localStringBuilder.toString(), paramString1, paramString2);
        }
      }
      if (DocsExportFileModel.e(this.a) != null)
      {
        DocsExportFileModel.f(this.a).removeMessages(8001);
        DocsExportFileModel.f(this.a).removeMessages(8002);
        DocsExportFileModel.f(this.a).post(new DocsExportFileModel.1.1(this));
      }
    }
    else
    {
      paramString1 = HardCodeUtil.a(2131901511);
      DocsExportFileModel.a(this.a, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel.1
 * JD-Core Version:    0.7.0.1
 */