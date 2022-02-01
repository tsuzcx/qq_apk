package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.widget.XListView;
import java.util.List;

class TroopFileZipPreviewActivity$2
  implements TroopFileProtocol.OnGetZipFileList
{
  TroopFileZipPreviewActivity$2(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(List<ZipFilePresenter.FileData> paramList)
  {
    this.b.stopTitleProgress();
    if (paramList != null)
    {
      Object localObject = this.b;
      ((TroopFileZipPreviewActivity)localObject).m = paramList;
      ((TroopFileZipPreviewActivity)localObject).k = new ZipFilesListAdapter(paramList, (Activity)localObject);
      paramList = this.b.k;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.i);
      ((StringBuilder)localObject).append("/");
      paramList.g = ((StringBuilder)localObject).toString();
      this.b.k.i = this.b.n;
      this.b.k.h = this.a.TroopUin;
      this.b.k.d = this.b.f;
      this.b.k.e = this.b.g;
      this.b.k.f = this.b.h;
      this.b.k.c = this.b.e;
      this.b.k.a(this.b.o, this.b.p, this.b.q);
      this.b.j.setAdapter(this.b.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */