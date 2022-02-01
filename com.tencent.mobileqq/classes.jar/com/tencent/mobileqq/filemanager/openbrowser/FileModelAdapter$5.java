package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnZipEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.ZipFileData;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FileModelAdapter$5
  implements FileBrowserModelBase.OnZipEventListener
{
  FileModelAdapter$5(FileModelAdapter paramFileModelAdapter) {}
  
  public void a(long paramLong)
  {
    if (FileModelAdapter.f(this.a) != null) {
      FileModelAdapter.f(this.a).a(paramLong);
    }
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (FileModelAdapter.f(this.a) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)((Iterator)localObject).next();
      IFileBrowserModel.ZipFileData localZipFileData = new IFileBrowserModel.ZipFileData();
      localZipFileData.a = localFileData.a;
      localZipFileData.c = localFileData.c;
      localZipFileData.d = localFileData.d;
      localZipFileData.b = localFileData.b;
      localArrayList.add(localZipFileData);
    }
    localObject = this.a;
    FileModelAdapter.a((FileModelAdapter)localObject, new ZipFilesListAdapter(paramList, ((FileModelAdapter)localObject).b));
    FileModelAdapter.g(this.a).g = "/";
    FileModelAdapter.g(this.a).i = FileModelAdapter.h(this.a).C();
    FileModelAdapter.g(this.a).h = FileModelAdapter.h(this.a).r();
    FileModelAdapter.g(this.a).d = paramString2;
    FileModelAdapter.g(this.a).e = paramString3;
    FileModelAdapter.g(this.a).f = paramString4;
    FileModelAdapter.g(this.a).c = paramString1;
    FileModelAdapter.g(this.a).a(paramBoolean, paramString5, paramShort);
    FileModelAdapter.f(this.a).a(localArrayList, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramShort);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (FileModelAdapter.f(this.a) != null) {
      FileModelAdapter.f(this.a).b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter.5
 * JD-Core Version:    0.7.0.1
 */