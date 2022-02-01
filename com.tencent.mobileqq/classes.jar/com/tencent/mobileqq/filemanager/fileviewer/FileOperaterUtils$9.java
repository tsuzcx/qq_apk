package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$9
  implements View.OnClickListener
{
  FileOperaterUtils$9(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        String str = localTroopFileStatusInfo.e;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        TroopFileStatusInfo localTroopFileStatusInfo;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()) == 0)
      {
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131697610));
      }
      else
      {
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131692733), 0);
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localTroopFileStatusInfo.e, localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, localTroopFileStatusInfo.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.9
 * JD-Core Version:    0.7.0.1
 */