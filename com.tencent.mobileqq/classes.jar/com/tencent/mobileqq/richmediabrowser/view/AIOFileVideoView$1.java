package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRMenuItemController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.List;

class AIOFileVideoView$1
  implements IQRMenuItemController
{
  public void a(String paramString, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_JavaUtilArrayList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.1
 * JD-Core Version:    0.7.0.1
 */