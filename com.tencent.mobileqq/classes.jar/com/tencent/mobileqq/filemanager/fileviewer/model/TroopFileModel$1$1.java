package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import java.util.List;

class TroopFileModel$1$1
  implements TroopFileProtocol.OnGetZipFileList
{
  TroopFileModel$1$1(TroopFileModel.1 param1, boolean paramBoolean, String paramString, short paramShort) {}
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    if (this.d.a.n != null) {
      this.d.a.n.a(paramList, this.d.a.d, this.d.a.e, this.d.a.f, this.d.a.g, this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.1.1
 * JD-Core Version:    0.7.0.1
 */