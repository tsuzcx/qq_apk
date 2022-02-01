package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel;
import java.util.ArrayList;
import java.util.List;

class FileViewerParamParser$1
  implements FileBrowserManager.IModelCreater
{
  FileViewerParamParser$1(FileViewerParamParser paramFileViewerParamParser, BaseActivity paramBaseActivity) {}
  
  public FileBrowserModelBase a()
  {
    int j = this.b.a();
    int i = 0;
    Object localObject3 = null;
    Object localObject1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = new ArrayList(1);
          ((List)localObject1).add(this.b.d());
        }
      }
      else
      {
        localObject1 = this.b.c();
        i = this.b.b();
      }
    }
    else
    {
      localObject1 = this.b.c();
      i = this.b.b();
    }
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if (((List)localObject1).size() > 0)
      {
        localObject2 = (IFileViewerAdapter)((List)localObject1).get(i);
        j = ((IFileViewerAdapter)localObject2).m();
        int k = ((IFileViewerAdapter)localObject2).f();
        if (j == 7) {
          return new MPcFileModel(FileViewerParamParser.a(this.b), this.a, (List)localObject1, i);
        }
        if (j == 9) {
          return new DocsExportFileModel(FileViewerParamParser.a(this.b), this.a, (List)localObject1, i);
        }
        if (k != 6000)
        {
          if (k != 9501) {
            return new C2CFileModel(FileViewerParamParser.a(this.b), this.a, (List)localObject1, i);
          }
          return new DeviceFileModel(FileViewerParamParser.a(this.b), this.a, (List)localObject1, i);
        }
        localObject2 = new DatalineFileModel(FileViewerParamParser.a(this.b), this.a, (List)localObject1, i);
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser.1
 * JD-Core Version:    0.7.0.1
 */