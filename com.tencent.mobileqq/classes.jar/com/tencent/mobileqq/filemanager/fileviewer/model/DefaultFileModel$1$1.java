package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

class DefaultFileModel$1$1
  implements TroopFileProtocol.OnGetZipFileList
{
  DefaultFileModel$1$1(DefaultFileModel.1 param1, boolean paramBoolean, String paramString, short paramShort) {}
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    if (this.d.b.n != null) {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.d.b.n.a(paramList, this.d.b.d, this.d.b.e, this.d.b.f, this.d.b.g, this.a, this.b, this.c);
      } else {
        this.d.b.n.a(-1000L);
      }
    }
    if (paramList != null)
    {
      paramList = this.d.b.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.d.b.c.r().TroopUin);
      ReportController.b(paramList, "dc00899", "Grp_files", null, "oper", "pre_arc_suc", 0, 0, localStringBuilder.toString(), "", FileManagerUtil.t(this.d.b.v()), "1");
      return;
    }
    paramList = this.d.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.d.b.c.r().TroopUin);
    ReportController.b(paramList, "dc00899", "Grp_files", null, "oper", "pre_arc_fail", 0, 0, localStringBuilder.toString(), "-1", FileManagerUtil.t(this.d.b.v()), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.1.1
 * JD-Core Version:    0.7.0.1
 */