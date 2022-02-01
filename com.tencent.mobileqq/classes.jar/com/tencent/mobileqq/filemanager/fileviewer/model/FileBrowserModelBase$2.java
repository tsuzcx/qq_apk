package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.List;

class FileBrowserModelBase$2
  implements IQRMenuItemController
{
  public void a(String paramString, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = this.a;
      paramList.f = paramString;
      if (paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.2
 * JD-Core Version:    0.7.0.1
 */