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
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a())
    {
    default: 
      localObject1 = null;
    }
    int j;
    int k;
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (IFileViewerAdapter)((List)localObject1).get(i);
          j = ((IFileViewerAdapter)localObject2).c();
          k = ((IFileViewerAdapter)localObject2).b();
          if (j != 7) {
            break;
          }
          localObject2 = new MPcFileModel(FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a();
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.b();
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a();
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.b();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser.a());
    }
    if (j == 9) {
      return new DocsExportFileModel(FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new C2CFileModel(FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    case 6000: 
      return new DatalineFileModel(FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
    }
    return new DeviceFileModel(FileViewerParamParser.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewerParamParser), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser.1
 * JD-Core Version:    0.7.0.1
 */