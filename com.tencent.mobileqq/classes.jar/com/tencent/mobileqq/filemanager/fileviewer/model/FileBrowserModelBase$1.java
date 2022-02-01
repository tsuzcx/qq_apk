package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FileBrowserModelBase$1
  implements IQRMenuItemController
{
  FileBrowserModelBase$1(FileBrowserModelBase paramFileBrowserModelBase, String paramString) {}
  
  public void a(String paramString, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    paramString = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString.addAll(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.1
 * JD-Core Version:    0.7.0.1
 */