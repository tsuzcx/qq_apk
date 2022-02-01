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
    if (FileModelAdapter.a(this.a) != null) {
      FileModelAdapter.a(this.a).a(paramLong);
    }
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (FileModelAdapter.a(this.a) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ZipFilePresenter.FileData localFileData = (ZipFilePresenter.FileData)((Iterator)localObject).next();
      IFileBrowserModel.ZipFileData localZipFileData = new IFileBrowserModel.ZipFileData();
      localZipFileData.jdField_a_of_type_Boolean = localFileData.jdField_a_of_type_Boolean;
      localZipFileData.jdField_a_of_type_JavaLangString = localFileData.jdField_a_of_type_JavaLangString;
      localZipFileData.jdField_b_of_type_Long = localFileData.jdField_b_of_type_Long;
      localZipFileData.jdField_a_of_type_Long = localFileData.jdField_a_of_type_Long;
      localArrayList.add(localZipFileData);
    }
    localObject = this.a;
    FileModelAdapter.a((FileModelAdapter)localObject, new ZipFilesListAdapter(paramList, ((FileModelAdapter)localObject).a));
    FileModelAdapter.a(this.a).e = "/";
    FileModelAdapter.a(this.a).jdField_b_of_type_Long = FileModelAdapter.a(this.a).d();
    FileModelAdapter.a(this.a).jdField_a_of_type_Long = FileModelAdapter.a(this.a).b();
    FileModelAdapter.a(this.a).jdField_b_of_type_JavaLangString = paramString2;
    FileModelAdapter.a(this.a).c = paramString3;
    FileModelAdapter.a(this.a).d = paramString4;
    FileModelAdapter.a(this.a).jdField_a_of_type_JavaLangString = paramString1;
    FileModelAdapter.a(this.a).a(paramBoolean, paramString5, paramShort);
    FileModelAdapter.a(this.a).a(localArrayList, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramShort);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (FileModelAdapter.a(this.a) != null) {
      FileModelAdapter.a(this.a).b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter.5
 * JD-Core Version:    0.7.0.1
 */